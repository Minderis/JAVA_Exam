import java.time.LocalDateTime;

public class IslaiduIrasas extends Irasas{
    private String islaiduKategorija;

    private String islaiduTipas;

    private LocalDateTime dataSuLaiku;

    public IslaiduIrasas(int id, double suma, LocalDateTime dataSuLaiku, String islaiduKategorija, boolean atsiskaitymoBudasBankas, String papildomaInfo, String islaiduTipas) {
        super(id, suma, atsiskaitymoBudasBankas, papildomaInfo);
        this.dataSuLaiku = dataSuLaiku;
        this.islaiduKategorija = islaiduKategorija;
        this.islaiduTipas = islaiduTipas;
    }

    public LocalDateTime getDataSuLaiku() {
        return dataSuLaiku;
    }

    public String getIslaiduKategorija() {
        return islaiduKategorija;
    }

    public String getIslaiduTipas() {
        return islaiduTipas;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public double getSuma() {
        return super.getSuma();
    }

    @Override
    public boolean isAtsiskaitymoBudasBankas() {
        return super.isAtsiskaitymoBudasBankas();
    }

    @Override
    public String getPapildomaInfo() {
        return super.getPapildomaInfo();
    }
}
