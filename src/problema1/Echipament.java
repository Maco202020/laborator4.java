package problema1;
import java.io.Serializable;

public abstract class Echipament implements Serializable {
    protected String denumire;
    protected int nrInv;
    protected double pret;
    protected String zonaMag;
    protected StareEchipament stare;

    public Echipament(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare) {
        this.denumire = denumire;
        this.nrInv = nrInv;
        this.pret = pret;
        this.zonaMag = zonaMag;
        this.stare = stare;
    }

    public abstract void afiseazaDetalii();

    public void setStare(StareEchipament stare) {
        this.stare = stare;
    }

    public StareEchipament getStare() {
        return stare;
    }
}
