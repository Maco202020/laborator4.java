package problema1;
public class Imprimanta extends Echipament {
    private int ppm;
    private String dpi; // Schimbăm tipul de la int la String
    private int pCar;
    private ModTiparire modTiparire;

    public Imprimanta(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare,
                      int ppm, String dpi, int pCar, ModTiparire modTiparire) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.ppm = ppm;
        this.dpi = dpi; // Acum este String
        this.pCar = pCar;
        this.modTiparire = modTiparire;
    }

    // Metodele getter și setter pentru dpi sunt ajustate
    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Imprimanta: " + denumire + ", Nr. Inventar: " + nrInv + ", Preț: " + pret +
                ", Zona magazie: " + zonaMag + ", Stare: " + stare + ", PPM: " + ppm +
                ", DPI: " + dpi + ", Pagini per cartuș: " + pCar + ", Mod tipărire: " + modTiparire);
    }
}
