package problema1;
public class SistemCalcul extends Echipament {
    private String tipMon;
    private double vitProc;
    private int cHdd;
    private SistemOperare sistemOperare;

    public SistemCalcul(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, String tipMon, double vitProc, int cHdd, SistemOperare sistemOperare) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.tipMon = tipMon;
        this.vitProc = vitProc;
        this.cHdd = cHdd;
        this.sistemOperare = sistemOperare;
    }

    public void instaleazaSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Sistem de calcul: " + denumire + ", Nr. Inventar: " + nrInv + ", Preț: " + pret +
                ", Zona magazie: " + zonaMag + ", Stare: " + stare + ", Tip Monitor: " + tipMon +
                ", Viteză procesor: " + vitProc + "GHz, Capacitate HDD: " + cHdd + "GB, Sistem Operare: " + sistemOperare);
    }
}
