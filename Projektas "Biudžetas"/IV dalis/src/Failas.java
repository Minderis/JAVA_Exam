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
        if (name.length() > 0) {
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
        } else {
            System.out.println("Jūs nenurodėte failo pavadinimo!");
        }
    }

    public ArrayList<Irasas> gautiDuomenis(Scanner sc) {
        System.out.println(Messages.FILE_REQUIREMENTS.message);
        System.out.println("Nurodykite pilną kelią iki failo arba \"src/...\", jei failas guli po src direktorija (failas testavimui: src/test.csv):");
        String path = sc.nextLine();
        ArrayList<Irasas> irasai = checkFile(path, false);
        if (irasai != null && irasai.size() > 0) {
            Biudzetas.id = 1;
            return checkFile(path, true);
        } else {
            return null;
        }
    }

    public ArrayList<Irasas> checkFile(String path, boolean showMessage) {
        File file = new File(path);
        ArrayList<Irasas> irasai = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int currentLine = 1;
            String line = br.readLine();
            while (line != null) {
                int indexOffset = 0;
                String[] splittedValues = line.split(";");
                if (splittedValues.length == 7) {
                    indexOffset = -1;
                } else if (splittedValues.length < 7) {
                    if (showMessage) {
                        System.out.println("Failo eilutėje Nr. " + currentLine + " trūksta stulpelių! Ji bus ignoruota.");
                    }
                    line = br.readLine();
                    currentLine++;
                    Biudzetas.id++;
                    continue;
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
                    if (showMessage) {
                        System.out.println("Failo eilutėje Nr. " + currentLine + " aptiktas netinkamo formato įrašas! Ši eilutė bus ignoruojama.");
                    }
                    line = br.readLine();
                    currentLine++;
                }

            }
            br.close();
        } catch (Exception e) {
            if (showMessage) {
                System.out.println("KLAIDA!");
            }
        }
        return irasai;
    }
}
