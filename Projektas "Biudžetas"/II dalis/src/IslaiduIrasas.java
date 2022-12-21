import java.time.LocalDateTime;

public class IslaiduIrasas {
    private final int id;
    private double suma;
    private LocalDateTime dataSuLaiku;
    private String kategorija;
    private boolean atsiskaitymoBudasBankas;
    private String papildomaInfo;

    public IslaiduIrasas(int id, double suma, LocalDateTime dataSuLaiku, String kategorija, boolean atsiskaitymoBudasBankas, String papildomaInfo) {
        this.id = id;
        this.suma = suma;
        this.dataSuLaiku = dataSuLaiku;
        this.kategorija = kategorija;
        this.atsiskaitymoBudasBankas = atsiskaitymoBudasBankas;
        this.papildomaInfo = papildomaInfo;
    }

    public double getSuma() {
        return suma;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataSuLaiku() {
        return dataSuLaiku;
    }

    public String getKategorija() {
        return kategorija;
    }

    public boolean isAtsiskaitymoBudasBankas() {
        return atsiskaitymoBudasBankas;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }
}
