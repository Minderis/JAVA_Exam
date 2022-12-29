import java.time.LocalDate;

public class PajamuIrasas {
    private final int id;
    private double suma;
    private LocalDate data;
    private String kategorija;
    private boolean pozymisArIBanka;
    private String papildomaInfo;

    public PajamuIrasas(int id, double suma, LocalDate data, String kategorija, boolean pozymisArIBanka, String papildomaInfo) {
        this.id = id;
        this.suma = suma;
        this.data = data;
        this.kategorija = kategorija;
        this.pozymisArIBanka = pozymisArIBanka;
        this.papildomaInfo = papildomaInfo;
    }

    public double getSuma() {
        return suma;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public String getKategorija() {
        return kategorija;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }
}
