import java.time.LocalDate;

public class PajamuIrasas {
    private double suma;
    private LocalDate data;
    private String kategorija;
    private boolean pozymisArIBanka;
    private String papildomaInfo;

    public PajamuIrasas(double suma, LocalDate data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
        this.suma = suma;
        this.data = data;
        this.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
    }

    public double getSuma() {
        return suma;
    }
}
