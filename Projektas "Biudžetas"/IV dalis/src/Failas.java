import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Failas {

    private static final DateTimeFormatter MY_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public void issaugotiDuomenis(Scanner sc, ArrayList<Irasas> irasai) {
        System.out.println("Nurodykite failo pavadinimą, kuris bus sukurtas src direktorijoje ir į kurį bus išsaugoti duomenys:");
        String name = sc.nextLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/" + name))) {
            for (Irasas irasas : irasai) {
                if (irasas instanceof PajamuIrasas) {
                    bw.write(((PajamuIrasas) irasas).getCsvValue());
                }
                if (irasas instanceof IslaiduIrasas) {
                    bw.write(((IslaiduIrasas) irasas).getCsvValue());
                }
            }
            System.out.println("Duomenys sėkmingai išsaugoti faile src/" + name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Irasas> gautiDuomennis(Scanner sc) {
        System.out.println("""
                Reikalavimai failo stulpelių formatui:
                1 stulpelis: int Id - laukas neprivalomas (gali nebūti netgi stulpelio);
                2 stulpelis: double Suma - laukas privalomas (bet kokia double reikšmė);
                3 stulpelis: boolean Ar bankas? - laukas privalomas (TRUE arba FALSE reikšmė, esant netinkamam formatui reikšmė bus nustatyta į FALSE);
                4 stulpelis: String Komentaras - laukas privalomas (bet kokia String reikšmė);
                5 stulpelis: String Įrašo tipas - laukas privalomas ("Pajamos" arba "Išlaidos" reikšmė);
                6 stulpelis: LocalDate arba LocalDateTime  Data - laukas privalomas (Pajamų įrašui formatas: yyyy-MM-dd; Išlaidų įrašui formatas: yyyy-MM-dd HH:mm);
                7 stulpelis: String Kategorija - laukas privalomas (bet kokia String reikšmė);
                8 stulpelis: String Tipas - laukas privalomas (bet kokia String reikšmė, p.s. redaguojant tokį įrašą išlieka ribotas tipų pasirinkimas);
                STULPELIAI TURI BŪTI ATSKIRTI SKIRTUKU ";".
                """);
        System.out.println("Nurodykite pilną kelią iki failo arba \"src/...\", jei failas guli po src direktorija:");
        String path = sc.nextLine();
        File file = new File(path);
        ArrayList<Irasas> irasai = new ArrayList<>();
        int indexOffset = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int currentLine = 1;
            String line = br.readLine();
            while (line != null) {
                String[] splittedValues = line.split(";");
                if (splittedValues.length == 7) {
                    indexOffset = -1;
                } else if (splittedValues.length < 7 || splittedValues.length > 8) {
                    return null;
                }
                try {
                    if (line.contains("Pajamos")) {
                        PajamuIrasas irasas = new PajamuIrasas(Biudzetas.id++);
                        irasas.setSuma(Double.parseDouble(splittedValues[1 + indexOffset]));
                        irasas.setAtsiskaitymoBudasBankas(Boolean.parseBoolean(splittedValues[2 + indexOffset]));
                        irasas.setPapildomaInfo(splittedValues[3 + indexOffset]);
                        irasas.setRecordType(splittedValues[4 + indexOffset]);
                        irasas.setData(LocalDate.parse(splittedValues[5 + indexOffset]));
                        irasas.setPajamuKategorija(splittedValues[6 + indexOffset]);
                        irasas.setPajamuTipas(splittedValues[7 + indexOffset]);
                        irasai.add(irasas);
                    }
                    if (line.contains("Išlaidos")) {
                        IslaiduIrasas irasas = new IslaiduIrasas(Biudzetas.id++);
                        irasas.setSuma(Double.parseDouble(splittedValues[1]));
                        irasas.setAtsiskaitymoBudasBankas(Boolean.parseBoolean(splittedValues[2]));
                        irasas.setPapildomaInfo(splittedValues[3]);
                        irasas.setRecordType(splittedValues[4]);
                        irasas.setDataSuLaiku(LocalDateTime.parse(splittedValues[5], MY_DATE_FORMAT));
                        irasas.setIslaiduKategorija(splittedValues[6]);
                        irasas.setIslaiduTipas(splittedValues[7]);
                        irasai.add(irasas);
                    }
                    line = br.readLine();
                    currentLine++;
                } catch (Exception e) {
                    System.out.println("Failo eilutėje Nr. " + currentLine + " aptiktas netinkamo formato įrašas! Ši eilutė bus ignoruojama.");
                    line = br.readLine();
                    currentLine++;
                }

            }
            br.close();
        } catch (Exception e) {
            System.out.println("KLAIDA!");
        }
        return irasai;
    }
}
