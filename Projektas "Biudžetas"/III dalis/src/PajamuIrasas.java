import java.time.LocalDate;

public class PajamuIrasas extends Irasas{
    private String pajamuKategorija;

    private String pajamuTipas;

    private LocalDate data;

    public PajamuIrasas(int id, double suma, LocalDate data, String pajamuKategorija, boolean atsiskaitymoBudasBankas, String papildomaInfo, String pajamuTipas) {
        super(id, suma, atsiskaitymoBudasBankas, papildomaInfo);
        this.data = data;
        this.pajamuKategorija = pajamuKategorija;
        this.pajamuTipas = pajamuTipas;
    }

    public LocalDate getData() {
        return data;
    }

    public String getPajamuKategorija() {
        return pajamuKategorija;
    }

    public String getPajamuTipas() {
        return pajamuTipas;
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
