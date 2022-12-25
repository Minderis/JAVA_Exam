import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
                System.out.println("""
                        
                        [1] - sukurti įrašą
                        [2] - redaguoti įrašą
                        [3] - informacija apie pajamas
                        [4] - informacija apie išlaidas
                        [5] - balansas
                        [6] - atspausdinti pajamu įrašus
                        [7] - atspausdinti išlaidų įrašus
                        [8] - atspausdinti visą sąrašą
                        [0] - baigti darbą su programa
                        """);
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
                    case "0" -> {
                        System.out.println("Programa baigė darbą.");
                        isTrue = false;
                    }
                    default -> System.out.println(Messages.BAD_INPUT.message);
                }
        }
        sc.close();
    }
}