

public class Irasas {
    private final int id;
    private double suma;

    private boolean atsiskaitymoBudasBankas;
    private String papildomaInfo;

    public Irasas(int id, double suma, boolean atsiskaitymoBudasBankas, String papildomaInfo) {
        this.id = id;
        this.suma = suma;
        this.atsiskaitymoBudasBankas = atsiskaitymoBudasBankas;
        this.papildomaInfo = papildomaInfo;
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
}
