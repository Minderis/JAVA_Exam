import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Biudzetas {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
    private static final DateTimeFormatter MY_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static int id = 0;
    private final ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
    private final ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();

    public void pridetiPajamuIrasa(Scanner sc) {
        makeRecord(null, pajamos, sc);
    }

    public void pridetiIslaiduIrasa(Scanner sc) {
        makeRecord(islaidos, null, sc);
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

    public void atspausdintiPajamas() {
        printTableTitle();
        for (PajamuIrasas pi : pajamos) {
            System.out.printf((Messages.STRING_FORMAT_FOR_INPUT.message) + "%n",
                    pi.getId(), pi.getSuma(), pi.getData(),
                    pi.getKategorija(), pi.isPozymisArIBanka(), pi.getPapildomaInfo());
        }
    }

    public void atspausdintiIslaidas() {
        printTableTitle();
        for (IslaiduIrasas ii : islaidos) {
            System.out.printf((Messages.STRING_FORMAT_FOR_OUTPUT.message) + "%n",
                    ii.getId(), ii.getSuma() * -1, ii.getDataSuLaiku().format(MY_DATE_FORMAT),
                    ii.getKategorija(), ii.isAtsiskaitymoBudasBankas(), ii.getPapildomaInfo());
        }
    }

    public double balansas() {
        return Double.parseDouble(DECIMAL_FORMAT.format(gautiPajamas() - gautiIslaidas()));
    }

    public void pasalintiPajamuIrasa(Scanner sc) {
        System.out.println(Messages.MESSAGE_FOR_INPUT_RECORD_DELETE.message);
        int id = validateAndGetInt(sc);
        if (pajamos.stream().anyMatch(o -> id == o.getId())) {
            for (PajamuIrasas pi : pajamos) {
                if (pi.getId() == id) {
                    pajamos.remove(pi);
                    System.out.println(Messages.DELETE_SUCCESS.message);
                    break;
                }
            }
        } else {
            System.out.printf((Messages.RECORD_NOT_FOUND.message) + "%n", id);
        }
        atspausdintiPajamas();

    }

    public void pasalintiIslaiduIrasa(Scanner sc) {
        System.out.println(Messages.MESSAGE_FOR_OUTPUT_RECORD_DELETE.message);
        int id = validateAndGetInt(sc);
        if (islaidos.stream().anyMatch(o -> id == o.getId())) {
            for (IslaiduIrasas ii : islaidos) {
                if (ii.getId() == id) {
                    islaidos.remove(ii);
                    System.out.println(Messages.DELETE_SUCCESS.message);
                    break;
                }
            }
        } else {
            System.out.printf((Messages.RECORD_NOT_FOUND.message) + "%n", id);
        }
        atspausdintiIslaidas();

    }

    private void printTableTitle() {
        System.out.printf((Messages.TITLE_FORMAT.message) + "%n",
                "Id", "Suma", "Data", "Kategorija", "Ar bankas?", "Komentaras");
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

    private int validateAndGetInt(Scanner sc) {
        int id = 0;
        boolean isNotInt = true;
        while (isNotInt) {
            try {
                id = Integer.parseInt(sc.nextLine());
                isNotInt = false;
            } catch (NumberFormatException e) {
                System.out.println(Messages.BAD_INPUT.message);
            }
        }
        return id;
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

    private void addToArray(ArrayList<PajamuIrasas> arrayIn, PajamuIrasas pi) {
        arrayIn.add(pi);
        System.out.println(Messages.INPUT_SUCCESS.message);
    }

    private void addToArray(ArrayList<IslaiduIrasas> arrayOut, IslaiduIrasas ii) {
        arrayOut.add(ii);
        System.out.println(Messages.INPUT_SUCCESS.message);
    }


    private void makeRecord(ArrayList<IslaiduIrasas> islaidos, ArrayList<PajamuIrasas> pajamos, Scanner sc) {
        System.out.println(Messages.ENTER_AMOUNT.message);
        double suma = validateAndGetDouble(sc);
        System.out.println(Messages.ENTER_CATEGORY.message);
        String kategorija = validateAndGetString(sc);
        System.out.println(Messages.BANK_PAYMENT.message);
        boolean atsiskaitymoBudasBankas = taipNe(sc);
        System.out.println(Messages.ENTER_COMMENT.message);
        String papildomaInfo = validateAndGetString(sc);
        if (pajamos != null) {
            PajamuIrasas pi = new PajamuIrasas(++id, suma, LocalDate.now(), kategorija, atsiskaitymoBudasBankas, papildomaInfo);
            addToArray(pajamos, pi);
        }
        if (islaidos != null) {
            IslaiduIrasas ii = new IslaiduIrasas(++id, suma, LocalDateTime.now(), kategorija, atsiskaitymoBudasBankas, papildomaInfo);
            addToArray(islaidos, ii);
        }
    }
}
