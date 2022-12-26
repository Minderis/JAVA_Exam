import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Biudzetas {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static int id = 1;

    private ArrayList<Irasas> irasai = new ArrayList<>();

    public void pakeistiIrasuSarasa(ArrayList<Irasas> irasai) {
        if (irasai != null && irasai.size() > 0) {
            setIrasai(irasai);
            System.out.println(Messages.SUCCESS_IMPORT.message);
        } else {
            System.out.println(Messages.NOT_EXIST_OR_INVALID_FORMAT.message);
        }
    }

    public void sukurtiIrPridetiIrasa(Scanner sc) {
        Irasas irasas = sukurtiIrasa(sc);
        pridetiIrasa(irasas);
    }

    public void redaguotiIrasa(Scanner sc) {
        System.out.println("Pasirinkite veiksmą:");
        String action = showSubmenuItems(sc, "[1] - Pakeisti įrašą",
                "[2] - Ištrinti įrašą");
        if (action.equals("1")) {
            pakeistiIrasa(sc);
        }
        if (action.equals("2")) {
            pasalintiIrasa(sc);
        }
    }

    public double gautiVisasPajamas() {
        double suma = 0;
        for (Irasas irasas : irasai) {
            if (irasas instanceof PajamuIrasas) {
                suma += irasas.getSuma();
            }
        }
        return Double.parseDouble(DECIMAL_FORMAT.format(suma));
    }

    public double gautiVisasIslaidas() {
        double suma = 0;
        for (Irasas irasas : irasai) {
            if (irasas instanceof IslaiduIrasas) {
                suma += irasas.getSuma();
            }
        }
        return Double.parseDouble(DECIMAL_FORMAT.format(suma));
    }

    public double balansas() {
        return Double.parseDouble(DECIMAL_FORMAT.format(gautiVisasPajamas() - gautiVisasIslaidas()));
    }

    public void atspausdintiPajamuIrasus() {
        printTableTitle();
        for (PajamuIrasas irasas : gautiPajamuIrasus()) {
            System.out.println(irasas);
        }
    }

    public void atspausdintiIslaiduIrasus() {
        printTableTitle();
        for (IslaiduIrasas irasas : gautiIslaiduIrasus()) {
            System.out.println(irasas);
        }
    }

    public void atspausdintiVisaSarasa() {
        printTableTitle();
        for (Irasas irasas : getIrasai()) {
            System.out.println(irasas);
        }
    }

    private void pridetiIrasa(Irasas irasas) {
        irasai.add(irasas);
        System.out.println(Messages.INPUT_SUCCESS.message);
        atspausdintiVisaSarasa();
    }

    private Irasas gautiIrasa(int id) {
            for (Irasas irasas : irasai) {
                if (irasas.getId() == id) {
                    return irasas;
                }
            }
        return null;
    }

    private Irasas sukurtiIrasa(Scanner sc) {
        int myId = id++;
        return gautiSukurtaIrasa(sc, myId);
    }

    private Irasas sukurtiIrasa(Scanner sc, Integer integer) {
        int myId = integer;
        return gautiSukurtaIrasa(sc, myId);
    }

    private Irasas gautiSukurtaIrasa(Scanner sc, int id) {
        System.out.println(Messages.RECORD_TYPE.message);
        String type = showSubmenuItems(sc, "[1] - Pajamų įrašas",
                "[2] - Išlaidų įrašas");
        System.out.println(Messages.ENTER_AMOUNT.message);
        double suma = validateAndGetDouble(sc);
        System.out.println(Messages.ENTER_CATEGORY.message);
        String kategorija = validateAndGetString(sc);
        System.out.println(Messages.BANK_PAYMENT.message);
        boolean atsiskaitymoBudasBankas = taipNe(sc);
        System.out.println(Messages.ENTER_COMMENT.message);
        String papildomaInfo = validateAndGetString(sc);
        if (type.equals("1")) {
            String irasoTipas = "Pajamos";
            System.out.println(Messages.INCOME_TYPE.message);
            String pajamuTipas = validateAndGetType(sc, type);
            return new PajamuIrasas(id, suma, LocalDate.now(), kategorija, atsiskaitymoBudasBankas, papildomaInfo, pajamuTipas, irasoTipas);
        } else if (type.equals("2")) {
            String irasoTipas = "Išlaidos";
            System.out.println(Messages.EXPENSE_TYPE.message);
            String islaiduTipas = validateAndGetType(sc, type);
            return new IslaiduIrasas(id, suma, LocalDateTime.now(), kategorija, atsiskaitymoBudasBankas, papildomaInfo, islaiduTipas, irasoTipas);
        } else {
            return null;
        }
    }

    private ArrayList<PajamuIrasas> gautiPajamuIrasus() {
        ArrayList<PajamuIrasas> pajamuIrasai = new ArrayList<>();
        for (Irasas irasas : irasai){
            if(irasas instanceof PajamuIrasas) {
                pajamuIrasai.add((PajamuIrasas) irasas);
            }
        }
        return pajamuIrasai;
    }

    private ArrayList<IslaiduIrasas> gautiIslaiduIrasus() {
        ArrayList<IslaiduIrasas> islaiduIrasai = new ArrayList<>();
        for (Irasas irasas : irasai){
            if(irasas instanceof IslaiduIrasas) {
                islaiduIrasai.add((IslaiduIrasas) irasas);
            }
        }
        return islaiduIrasai;
    }

    private void pasalintiIrasa(Scanner sc) {
        atspausdintiVisaSarasa();
        System.out.println(Messages.MESSAGE_FOR_RECORD_DELETE.message);
        int id = validateAndGetInt(sc);
        if (irasai.stream().anyMatch(o -> id == o.getId())) {
            for (Irasas irasas : irasai) {
                if (irasas.getId() == id) {
                    irasai.remove(irasas);
                    System.out.println(Messages.DELETE_SUCCESS.message);
                    break;
                }
            }
        } else {
            System.out.printf((Messages.RECORD_NOT_FOUND.message) + "%n", id);
        }
        atspausdintiVisaSarasa();
    }

    private boolean changeStepByStep(Scanner sc, Irasas irasas, String field) {
        switch (field) {
            case "Suma" -> {
                System.out.println("Suma: " + irasas.getSuma());
                String answer = showSubmenuItems(sc, "[1] - Redaguoti", "[2] - Toliau", "[3] - Baigti redagavimą");
                if (answer.equals("1")) {
                    System.out.println(Messages.ENTER_AMOUNT.message);
                    irasas.setSuma(validateAndGetDouble(sc));
                }
                if (answer.equals("3")) {
                    return true;
                }
            }
            case "Ar bankas?" -> {
                System.out.println("Ar bankas?: " + irasas.isAtsiskaitymoBudasBankas());
                String answer = showSubmenuItems(sc, "[1] - Redaguoti", "[2] - Toliau", "[3] - Baigti redagavimą");
                if (answer.equals("1")) {
                    System.out.println(Messages.BANK_PAYMENT.message);
                    irasas.setAtsiskaitymoBudasBankas(taipNe(sc));
                }
                if (answer.equals("3")) {
                    return true;
                }
            }
            case "Komentaras" -> {
                System.out.println("Komentaras: " + irasas.getPapildomaInfo());
                String answer = showSubmenuItems(sc, "[1] - Redaguoti", "[2] - Toliau", "[3] - Baigti redagavimą");
                if (answer.equals("1")) {
                    System.out.println(Messages.ENTER_COMMENT.message);
                    irasas.setPapildomaInfo(validateAndGetString(sc));
                }
                if (answer.equals("3")) {
                    return true;
                }
            }
            case "Kategorija" -> {
                if (irasas instanceof IslaiduIrasas) {
                    System.out.println("Kategorija: " + ((IslaiduIrasas) irasas).getIslaiduKategorija());
                    String answer = showSubmenuItems(sc, "[1] - Redaguoti", "[2] - Toliau", "[3] - Baigti redagavimą");
                    if (answer.equals("1")) {
                        System.out.println(Messages.ENTER_CATEGORY.message);
                        ((IslaiduIrasas) irasas).setIslaiduKategorija(validateAndGetString(sc));
                    }
                    if (answer.equals("3")) {
                        return true;
                    }
                }
                if (irasas instanceof PajamuIrasas) {
                    System.out.println("Kategorija: " + ((PajamuIrasas) irasas).getPajamuKategorija());
                    String answer = showSubmenuItems(sc, "[1] - Redaguoti", "[2] - Toliau", "[3] - Baigti redagavimą");
                    if (answer.equals("1")) {
                        System.out.println(Messages.ENTER_CATEGORY.message);
                        ((PajamuIrasas) irasas).setPajamuKategorija(validateAndGetString(sc));
                    }
                    if (answer.equals("3")) {
                        return true;
                    }
                }
            }
            case "Tipas" -> {
                if (irasas instanceof IslaiduIrasas) {
                    System.out.println("Tipas: " + ((IslaiduIrasas) irasas).getIslaiduTipas());
                    String answer = showSubmenuItems(sc, "[1] - Redaguoti", "[2] - Toliau", "[3] - Baigti redagavimą");
                    if (answer.equals("1")) {
                        System.out.println(Messages.INCOME_TYPE.message);
                        ((IslaiduIrasas) irasas).setIslaiduTipas(validateAndGetType(sc, "2"));
                    }
                    if (answer.equals("3")) {
                        return true;
                    }
                }
                if (irasas instanceof PajamuIrasas) {
                    System.out.println("Tipas: " + ((PajamuIrasas) irasas).getPajamuTipas());
                    String answer = showSubmenuItems(sc, "[1] - Redaguoti", "[2] - Toliau", "[3] - Baigti redagavimą");
                    if (answer.equals("1")) {
                        System.out.println(Messages.EXPENSE_TYPE.message);
                        ((PajamuIrasas) irasas).setPajamuTipas(validateAndGetType(sc, "1"));
                    }
                    if (answer.equals("3")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void pakeistiIrasa(Scanner sc) {
        String modificationLevel = showSubmenuItems(sc, "[1] - Dalinis įrašo keitimas",
                                                                "[2] - Pilnas įrašo keitimas");
        atspausdintiVisaSarasa();
        System.out.println(Messages.MESSAGE_FOR_RECORD_EDIT.message);
        int id = validateAndGetInt(sc);
        if (irasai.stream().anyMatch(o -> id == o.getId())) {
            if (modificationLevel.equals("1")) {
                Irasas irasas = gautiIrasa(id);
                assert irasas != null;
                double suma = irasas.getSuma();
                boolean arBankas = irasas.isAtsiskaitymoBudasBankas();
                String komentaras = irasas.getPapildomaInfo();
                String kategorija = "";
                String tipas = "";
                if (irasas instanceof IslaiduIrasas) {
                    kategorija = ((IslaiduIrasas) irasas).getIslaiduKategorija();
                    tipas = ((IslaiduIrasas) irasas).getIslaiduTipas();
                }
                if(irasas instanceof PajamuIrasas) {
                    kategorija = ((PajamuIrasas) irasas).getPajamuKategorija();
                    tipas = ((PajamuIrasas) irasas).getPajamuTipas();
                }
                boolean isOver = changeStepByStep(sc, irasas, "Suma");
                if (!isOver) {
                    isOver = changeStepByStep(sc, irasas, "Ar bankas?");
                }
                if (!isOver) {
                    isOver = changeStepByStep(sc, irasas, "Komentaras");
                }
                if (!isOver) {
                    isOver = changeStepByStep(sc, irasas, "Kategorija");
                }
                if (!isOver) {
                    changeStepByStep(sc, irasas, "Tipas");
                }
                String kategorijaPoPakeitimo = "";
                String tipasPoPakeitimo = "";
                if (irasas instanceof IslaiduIrasas) {
                    kategorijaPoPakeitimo = ((IslaiduIrasas) irasas).getIslaiduKategorija();
                    tipasPoPakeitimo = ((IslaiduIrasas) irasas).getIslaiduTipas();
                }
                if(irasas instanceof PajamuIrasas) {
                    kategorijaPoPakeitimo = ((PajamuIrasas) irasas).getPajamuKategorija();
                    tipasPoPakeitimo = ((PajamuIrasas) irasas).getPajamuTipas();
                }
                if (suma != irasas.getSuma()
                        || arBankas != irasas.isAtsiskaitymoBudasBankas()
                        || !komentaras.equals(irasas.getPapildomaInfo())
                        || !kategorija.equals(kategorijaPoPakeitimo)
                        || !tipas.equals(tipasPoPakeitimo)) {
                    if (irasas instanceof IslaiduIrasas) {
                        ((IslaiduIrasas) irasas).setDataSuLaiku(LocalDateTime.now());
                    }
                    if (irasas instanceof PajamuIrasas) {
                        ((PajamuIrasas) irasas).setData(LocalDate.now());
                    }
                    System.out.println(Messages.EDIT_SUCCESS.message);
                } else {
                    System.out.println(Messages.NOTHING_CHANGED.message);
                }
                atspausdintiVisaSarasa();
            }
            if (modificationLevel.equals("2")) {
                atnaujintiIrasa(sukurtiIrasa(sc, id));
                System.out.println(Messages.EDIT_SUCCESS.message);
                atspausdintiVisaSarasa();
            }
        } else {
            System.out.printf((Messages.RECORD_NOT_FOUND.message) + "%n", id);
        }
    }

    private void atnaujintiIrasa(Irasas irasas) {
        for (Irasas i : irasai) {
            if(i.equals(irasas)) {
                int index = irasai.indexOf(i);
                irasai.set(index, irasas);
            }
        }
    }

    private void printTableTitle() {
        System.out.printf((Messages.TITLE_FORMAT.message) + "%n",
                "Id", "Suma", "Ar bankas?", "Komentaras", "Įrašo tipas", "Data", "Kategorija",  "Tipas");
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

    private String validateAndGetType(Scanner sc, String type) {
        String result = "";
        String pajamuMeniu1 = "[1] - Darbo pajamos";
        String pajamuMeniu2 = "[2] - Dividendų pajamos";
        String pajamuMeniu3 = "[3] - Pardavimų pajamos";
        String islaiduMeniu1 = "[1] - Asmeninės išlaidos";
        String islaiduMeniu2 = "[2] - Veiklos išlaidos";
        String islaiduMeniu3 = "[3] - Mokesčiai";
            if (type.equals("1")) {
                String answer = showSubmenuItems(sc, pajamuMeniu1, pajamuMeniu2, pajamuMeniu3);
                switch (answer) {
                    case "1" -> result = pajamuMeniu1.substring(6);
                    case "2" -> result = pajamuMeniu2.substring(6);
                    case "3" -> result = pajamuMeniu3.substring(6);
                }
            }
            if (type.equals("2")) {
                String answer = showSubmenuItems(sc, islaiduMeniu1, islaiduMeniu2, islaiduMeniu3);
                switch (answer) {
                    case "1" -> result = islaiduMeniu1.substring(6);
                    case "2" -> result = islaiduMeniu2.substring(6);
                    case "3" -> result = islaiduMeniu3.substring(6);
                }
            }
        return result;
    }

    private String showSubmenuItems(Scanner sc, String...choices) {
        String result = "";
        boolean isTrue = true;
        while (isTrue) {
            for (String choice : choices) {
                System.out.println(choice);
            }
            String input = sc.nextLine();
            try {
                if (Integer.parseInt(input) > 0 &&  Integer.parseInt(input) <= choices.length) {
                    result = input;
                    isTrue = false;
                } else {
                    System.out.println(Messages.BAD_INPUT.message);
                }
            } catch (NumberFormatException e) {
                System.out.println(Messages.BAD_INPUT.message);
            }
        }
        return result;
    }

    public ArrayList<Irasas> getIrasai() {
        return irasai;
    }

    public void setIrasai(ArrayList<Irasas> irasai) {
        this.irasai = irasai;
    }
}
