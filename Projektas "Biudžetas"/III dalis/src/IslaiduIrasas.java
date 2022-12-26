import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IslaiduIrasas extends Irasas{
    private static final DateTimeFormatter MY_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String islaiduKategorija;

    private String islaiduTipas;

    private LocalDateTime dataSuLaiku;

    public IslaiduIrasas(int id, double suma, LocalDateTime dataSuLaiku, String islaiduKategorija, boolean atsiskaitymoBudasBankas, String papildomaInfo, String islaiduTipas, String recordType) {
        super(id, suma, atsiskaitymoBudasBankas, papildomaInfo, recordType);
        this.dataSuLaiku = dataSuLaiku;
        this.islaiduKategorija = islaiduKategorija;
        this.islaiduTipas = islaiduTipas;
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

    @Override
    public String getRecordType() {
        return super.getRecordType();
    }

    public void setIslaiduKategorija(String islaiduKategorija) {
        this.islaiduKategorija = islaiduKategorija;
    }

    public void setIslaiduTipas(String islaiduTipas) {
        this.islaiduTipas = islaiduTipas;
    }

    public void setDataSuLaiku(LocalDateTime dataSuLaiku) {
        this.dataSuLaiku = dataSuLaiku;
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
        return super.toString().concat(String.format(Messages.RECORD_TO_STRING_FORMAT.message, dataSuLaiku.format(MY_DATE_FORMAT), islaiduKategorija, islaiduTipas));
    }
}
