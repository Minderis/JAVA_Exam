import java.time.LocalDate;

public class PajamuIrasas extends Irasas{
    private String pajamuKategorija;

    private String pajamuTipas;

    private LocalDate data;

    public PajamuIrasas(int id, double suma, LocalDate data, String pajamuKategorija, boolean atsiskaitymoBudasBankas, String papildomaInfo, String pajamuTipas, String recordType) {
        super(id, suma, atsiskaitymoBudasBankas, papildomaInfo, recordType);
        this.data = data;
        this.pajamuKategorija = pajamuKategorija;
        this.pajamuTipas = pajamuTipas;
    }

    public PajamuIrasas(int id) {
        super(id);
    }

    public String getCsvValue(){
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s\n", this.getId(), this.getSuma(), this.isAtsiskaitymoBudasBankas(),
                this.getPapildomaInfo(), this.getRecordType(), this.getData(),
                this.getPajamuKategorija(), this.getPajamuTipas());
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

    @Override
    public String getRecordType() {
        return super.getRecordType();
    }

    public void setPajamuKategorija(String pajamuKategorija) {
        this.pajamuKategorija = pajamuKategorija;
    }

    public void setPajamuTipas(String pajamuTipas) {
        this.pajamuTipas = pajamuTipas;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public void setSuma(double suma) {
        super.setSuma(suma);
    }

    @Override
    public void setAtsiskaitymoBudasBankas(boolean atsiskaitymoBudasBankas) {
        super.setAtsiskaitymoBudasBankas(atsiskaitymoBudasBankas);
    }

    @Override
    public void setPapildomaInfo(String papildomaInfo) {
        super.setPapildomaInfo(papildomaInfo);
    }

    @Override
    public void setRecordType(String recordType) {
        super.setRecordType(recordType);
    }

    @Override
    public String toString() {
        return super.toString().concat(String.format(Messages.RECORD_TO_STRING_FORMAT.message, data, pajamuKategorija, pajamuTipas));
    }
}
