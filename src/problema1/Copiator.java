package problema1;
public class Copiator extends Echipament {
    private int pTon;
    private FormatCopiere formatCopiere;

    public Copiator(String denumire, int nrInv, double pret, String zonaMag, StareEchipament stare, int pTon, FormatCopiere formatCopiere) {
        super(denumire, nrInv, pret, zonaMag, stare);
        this.pTon = pTon;
        this.formatCopiere = formatCopiere;
    }

    public void setFormatCopiere(FormatCopiere formatCopiere) {
        this.formatCopiere = formatCopiere;
    }

    @Override
    public void afiseazaDetalii() {
        System.out.println("Copiator: " + denumire + ", Nr. Inventar: " + nrInv + ", Preț: " + pret +
                ", Zona magazie: " + zonaMag + ", Stare: " + stare + ", Pagini per toner: " + pTon +
                ", Format copiere: " + formatCopiere);
    }
}
