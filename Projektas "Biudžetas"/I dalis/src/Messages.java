public enum Messages {
    BAD_INPUT("Blogai įvedėte duomenis. Bandykite dar kartą...\n"),
    INPUT_SUCCESS("Įrašas sėkmingai atliktas.\n"),
    ARRAY_FILLED("Jūs pasiekėte maksimalų įrašų skaičiu. Išvalykite duomenis!\n"),
    ENTER_AMOUNT("Iveskite sumą:"),
    ENTER_CATEGORY("Įveskite kategoriją:"),
    ENTER_COMMENT("Įveskite papildomą informaciją (komentaras):"),
    BANK_PAYMENT("Įveskite atsiskaitymo būdą. Jei bankas - TAIP / Jei gryni - NE:");


    public final String message;

    Messages(String message) {
        this.message = message;
    }
}
