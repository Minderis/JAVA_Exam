import java.util.Objects;

public class Irasas {
    private final int id;
    private double suma;

    private boolean atsiskaitymoBudasBankas;
    private String papildomaInfo;

    private String recordType;

    public Irasas(int id, double suma, boolean atsiskaitymoBudasBankas, String papildomaInfo, String recordType) {
        this.id = id;
        this.suma = suma;
        this.atsiskaitymoBudasBankas = atsiskaitymoBudasBankas;
        this.papildomaInfo = papildomaInfo;
        this.recordType = recordType;
    }

    public int getId() {
        return id;
    }

    public double getSuma() {
        return suma;
    }

    public boolean isAtsiskaitymoBudasBankas() {
        return atsiskaitymoBudasBankas;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public void setAtsiskaitymoBudasBankas(boolean atsiskaitymoBudasBankas) {
        this.atsiskaitymoBudasBankas = atsiskaitymoBudasBankas;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @Override
    public String toString() {
        if (this.recordType.equals("Pajamos")) {
            return String.format(Messages.RECORD_INCOME_TO_STRING_FORMAT.message, id, suma, atsiskaitymoBudasBankas, papildomaInfo, recordType);
        } else {
            return String.format(Messages.RECORD_OUTCOME_TO_STRING_FORMAT.message, id, suma * -1, atsiskaitymoBudasBankas, papildomaInfo, recordType);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Irasas irasas)) return false;
        return id == irasas.id;
    }

}
