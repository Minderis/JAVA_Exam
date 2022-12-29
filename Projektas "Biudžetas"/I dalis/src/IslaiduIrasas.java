import java.time.LocalDateTime;

public class IslaiduIrasas {
    private double suma;
    private LocalDateTime dataSuLaiku;
    private String kategorija;
    private boolean atsiskaitymoBudasBankas;
    private String papildomaInfo;

    public IslaiduIrasas(double suma, LocalDateTime dataSuLaiku, String kategorija, boolean atsiskaitymoBudasBankas, String papildomaInfo) {
        this.suma = suma;
        this.dataSuLaiku = dataSuLaiku;
        this.kategorija = kategorija;
        this.atsiskaitymoBudasBankas = atsiskaitymoBudasBankas;
        this.papildomaInfo = papildomaInfo;
    }

    public double getSuma() {
        return suma;
    }
}
