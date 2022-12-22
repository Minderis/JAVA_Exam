import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Biudzetas biudzetas = new Biudzetas();
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
                System.out.println("""
                        
                        [1] - įvesti pajamas
                        [2] - įvesti išlaidas
                        [3] - informacija apie pajamas
                        [4] - informacija apie išlaidas
                        [5] - balansas
                        [6] - atspausdinti pajamas
                        [7] - atspausdinti islaidas
                        [8] - pašalinti pajamų įrašą
                        [9] - pašalinti išlaidų įrašą
                        [0] - baigti darbą su programa
                        """);
                String input = sc.nextLine();
                switch (input) {
                    case "1" -> biudzetas.pridetiPajamuIrasa(sc);
                    case "2" -> biudzetas.pridetiIslaiduIrasa(sc);
                    case "3" -> System.out.println("Viso gauta: " + biudzetas.gautiPajamas());
                    case "4" -> System.out.println("Viso išleista: " + biudzetas.gautiIslaidas());
                    case "5" -> System.out.println("Sąskaitos balansas: " + biudzetas.balansas());
                    case "6" -> biudzetas.atspausdintiPajamas();
                    case "7" -> biudzetas.atspausdintiIslaidas();
                    case "8" -> biudzetas.pasalintiPajamuIrasa(sc);
                    case "9" -> biudzetas.pasalintiIslaiduIrasa(sc);
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