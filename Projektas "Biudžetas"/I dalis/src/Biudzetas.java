import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Biudzetas {
    private final PajamuIrasas[] pajamos = new PajamuIrasas[100];
    private final IslaiduIrasas[] islaidos = new IslaiduIrasas[100];

    public void pridetiPajamuIrasa(Scanner sc) {
        if (!Arrays.asList(pajamos).contains(null)) {
            System.out.println(Messages.ARRAY_FILLED.message);
            return;
        }
        makeRecord(pajamos, sc);
    }

    public void pridetiIslaiduIrasa(Scanner sc) {
        if (!Arrays.asList(islaidos).contains(null)) {
            System.out.println(Messages.ARRAY_FILLED.message);
            return;
        }
        makeRecord(islaidos, sc);
    }

    public double gautiPajamas() {
        double suma = 0;
        for (PajamuIrasas pi : pajamos) {
            if (pi != null) {
                suma += pi.getSuma();
            }
        }
        return suma;
    }

    public double gautiIslaidas() {
        double suma = 0;
        for (IslaiduIrasas ii : islaidos) {
            if (ii != null) {
                suma += ii.getSuma();
            }
        }
        return suma;
    }

    private double validateAndGetDouble(Scanner sc) {
        double suma = 0;
        boolean isNotDouble = true;
        while (isNotDouble) {
            try {
                suma = Double.parseDouble(sc.nextLine());
                isNotDouble = false;
            } catch (NumberFormatException e) {
                System.out.println(Messages.BAD_INPUT.message);
            }
        }
        return suma;
    }

    private String validateAndGetString(Scanner sc) {
        boolean isString = false;
        String input = "";
        while (!isString) {
            input = sc.nextLine();
            if (input.length() > 0) {
                isString = true;
            } else {
                System.out.println(Messages.BAD_INPUT.message);
            }
        }
        return input;
    }

    private boolean taipNe(Scanner sc) {
        boolean isBank = false;
        boolean isTrue = true;
        while (isTrue) {
            String arIBanka = sc.nextLine().toUpperCase();
            switch (arIBanka) {
                case "TAIP" -> {
                    isBank = true;
                    isTrue = false;
                }
                case "NE" -> isTrue = false;

                default -> System.out.println(Messages.BAD_INPUT.message);
            }
        }
        return isBank;
    }

    private void addToArray(PajamuIrasas[] arrayIn, PajamuIrasas pi) {
        for (int i = 0; i < arrayIn.length; i++) {
            if (arrayIn[i] == null) {
                arrayIn[i] = pi;
                break;
            }
        }
        System.out.println(Messages.INPUT_SUCCESS.message);
    }

    private void addToArray(IslaiduIrasas[] arrayOut, IslaiduIrasas ii) {
        for (int i = 0; i < arrayOut.length; i++) {
            if (arrayOut[i] == null) {
                arrayOut[i] = ii;
                break;
            }
        }
        System.out.println(Messages.INPUT_SUCCESS.message);
    }

    private void makeRecord(IslaiduIrasas[] islaidos, Scanner sc) {
        System.out.println(Messages.ENTER_AMOUNT.message);
        double suma = validateAndGetDouble(sc);
        System.out.println(Messages.ENTER_CATEGORY.message);
        String kategorija = validateAndGetString(sc);
        System.out.println(Messages.BANK_PAYMENT.message);
        boolean atsiskaitymoBudasBankas = taipNe(sc);
        System.out.println(Messages.ENTER_COMMENT.message);
        String papildomaInfo = validateAndGetString(sc);
        IslaiduIrasas ii = new IslaiduIrasas(suma, LocalDateTime.now(), kategorija, atsiskaitymoBudasBankas, papildomaInfo);
        addToArray(islaidos, ii);

    }

    private void makeRecord(PajamuIrasas[] pajamos, Scanner sc) {
        System.out.println(Messages.ENTER_AMOUNT.message);
        double suma = validateAndGetDouble(sc);
        System.out.println(Messages.ENTER_CATEGORY.message);
        String kategorija = validateAndGetString(sc);
        System.out.println(Messages.BANK_PAYMENT.message);
        boolean atsiskaitymoBudasBankas = taipNe(sc);
        System.out.println(Messages.ENTER_COMMENT.message);
        String papildomaInfo = validateAndGetString(sc);
        PajamuIrasas pi = new PajamuIrasas(suma, LocalDate.now(), kategorija, atsiskaitymoBudasBankas, papildomaInfo);
        addToArray(pajamos, pi);
    }

}
