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
    RECORD_TO_STRING_FORMAT("| %-20s | %-20s | %-20s |");


    public final String message;

    Messages(String message) {
        this.message = message;
    }
}
