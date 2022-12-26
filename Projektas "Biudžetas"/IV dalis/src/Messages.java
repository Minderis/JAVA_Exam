public enum Messages {
    BAD_INPUT("Blogai įvedėte duomenis. Bandykite dar kartą..."),
    INPUT_SUCCESS("Įrašas sėkmingai atliktas."),
    ENTER_AMOUNT("Iveskite sumą:"),
    ENTER_CATEGORY("Įveskite kategoriją:"),
    ENTER_COMMENT("Įveskite papildomą informaciją (komentaras):"),
    BANK_PAYMENT("Įveskite atsiskaitymo būdą. Jei bankas - TAIP / Jei gryni - NE:"),
    TITLE_FORMAT("| %-5s | %-10s | %-15s | %-20s | %-20s | %-20s | %-20s | %-20s |"),
    MESSAGE_FOR_RECORD_DELETE("Įveskite įrašo id, kurį norite pašalinti:"),
    MESSAGE_FOR_RECORD_EDIT("Įveskite įrašo id, kurį norite redaguoti:"),
    DELETE_SUCCESS("Įrašas sėkmingai pašalintas."),
    EDIT_SUCCESS("Įrašas sėkmingai atnaujintas."),
    NOTHING_CHANGED("Jūs nepakeitėte nei vieno lauko. Įrašas liko nepakeistas."),
    RECORD_NOT_FOUND("Nerastas įrašas su id %d!"),
    EXPENSE_TYPE("Įveskite išlaidų tipą:"),
    INCOME_TYPE("Įveskite pajamų tipą:"),
    RECORD_TYPE("Pasirinkite įrašo tipą:"),
    RECORD_INCOME_TO_STRING_FORMAT("| %-5d | %-10.2f | %-15s | %-20s | %-20s "),
    RECORD_OUTCOME_TO_STRING_FORMAT("| %-5d | %10.2f | %-15s | %-20s | %-20s "),
    SUCCESS_IMPORT("Duomenų failas sėkmingai importuotas."),
    NOT_EXIST_OR_INVALID_FORMAT("Irašų failas neegzistuoja arba failas netinkamo formato!"),
    RECORD_TO_STRING_FORMAT("| %-20s | %-20s | %-20s |"),
    MAIN_MENU("""
                        
                        [1] - sukurti įrašą
                        [2] - redaguoti įrašą
                        [3] - informacija apie pajamas
                        [4] - informacija apie išlaidas
                        [5] - balansas
                        [6] - atspausdinti pajamu įrašus
                        [7] - atspausdinti išlaidų įrašus
                        [8] - atspausdinti visą sąrašą
                        [9] - išsaugoti duomenis
                        [0] - užkrauti duomenis
                        [*] - baigti darbą su programa
                        """),
    FILE_REQUIREMENTS("""
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


    public final String message;

    Messages(String message) {
        this.message = message;
    }
}
