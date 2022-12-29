
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();
        Failas failas = new Failas();
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
                System.out.println(Messages.MAIN_MENU.message);
                String input = sc.nextLine();
                switch (input) {
                    case "1" -> biudzetas.sukurtiIrPridetiIrasa(sc);
                    case "2" -> biudzetas.redaguotiIrasa(sc);
                    case "3" -> System.out.println("Viso gauta: " + biudzetas.gautiVisasPajamas());
                    case "4" -> System.out.println("Viso išleista: " + biudzetas.gautiVisasIslaidas());
                    case "5" -> System.out.println("Sąskaitos balansas: " + biudzetas.balansas());
                    case "6" -> biudzetas.atspausdintiPajamuIrasus();
                    case "7" -> biudzetas.atspausdintiIslaiduIrasus();
                    case "8" -> biudzetas.atspausdintiVisaSarasa();
                    case "9" -> failas.issaugotiDuomenis(sc, biudzetas.getIrasai());
                    case "0" -> biudzetas.pakeistiIrasuSarasa(failas.gautiDuomenis(sc));
                    case "*" -> {
                        System.out.println("Programa baigė darbą.");
                        isTrue = false;
                    }
                    default -> System.out.println(Messages.BAD_INPUT.message);
                }
        }
        sc.close();
    }
}