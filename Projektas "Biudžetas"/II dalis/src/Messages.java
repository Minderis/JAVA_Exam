public enum Messages {
    BAD_INPUT("Blogai įvedėte duomenis. Bandykite dar kartą..."),
    INPUT_SUCCESS("Įrašas sėkmingai atliktas."),
    ENTER_AMOUNT("Iveskite sumą:"),
    ENTER_CATEGORY("Įveskite kategoriją:"),
    ENTER_COMMENT("Įveskite papildomą informaciją (komentaras):"),
    BANK_PAYMENT("Įveskite atsiskaitymo būdą. Jei bankas - TAIP / Jei gryni - NE:"),
    STRING_FORMAT_FOR_INPUT("| %-5d | %-10.2f | %-20s | %-20s | %-15s | %-20s |"),
    STRING_FORMAT_FOR_OUTPUT("| %-5d | %10.2f | %-20s | %-20s | %-15s | %-20s |"),
    TITLE_FORMAT("| %-5s | %-10s | %-20s | %-20s | %-15s | %-20s |"),
    MESSAGE_FOR_INPUT_RECORD_DELETE("Įveskite pajamų įrašo id, kurį norite pašalinti:"),
    MESSAGE_FOR_OUTPUT_RECORD_DELETE("Įveskite išlaidų įrašo id, kurį norite pašalinti:"),
    DELETE_SUCCESS("Įrašas sėkmingai pašalintas."),
    RECORD_NOT_FOUND("Nerastas įrašas su id %d!");


    public final String message;

    Messages(String message) {
        this.message = message;
    }
}
