package problema1;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class GestionareEchipamente {
    private List<Echipament> echipamente;

    public GestionareEchipamente(List<Echipament> echipamente) {
        this.echipamente = echipamente;
    }

    // Metodă pentru a obține lista de echipamente
    public List<Echipament> getEchipamente() {
        return echipamente;
    }

    // Citire din fisierul echipamente.txt
    public void citesteDinFisier(String fisier) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] campuri = linie.split(";");
                String denumire = campuri[0];
                int nrInv = Integer.parseInt(campuri[1]);
                double pret = Double.parseDouble(campuri[2]);
                String zonaMag = campuri[3];
                StareEchipament stare = StareEchipament.valueOf(campuri[4].toUpperCase());
                String tipEchipament = campuri[5].toLowerCase();

                switch (tipEchipament) {
                    case "imprimanta":
                        int ppm = Integer.parseInt(campuri[6]);
                        String rezolutie = campuri[7]; // Acum citim ca String
                        int pCar = Integer.parseInt(campuri[8]);
                        ModTiparire modTiparire = ModTiparire.valueOf(campuri[9].toUpperCase());
                        echipamente.add(new Imprimanta(denumire, nrInv, pret, zonaMag, stare, ppm, rezolutie, pCar, modTiparire));
                        break;

                    case "copiator":
                        int pTon = Integer.parseInt(campuri[6]);
                        FormatCopiere formatCopiere = FormatCopiere.valueOf(campuri[7].toUpperCase());
                        echipamente.add(new Copiator(denumire, nrInv, pret, zonaMag, stare, pTon, formatCopiere));
                        break;

                    case "sistem de calcul":
                        String tipMon = campuri[6];
                        double vitProc = Double.parseDouble(campuri[7]);
                        int cHdd = Integer.parseInt(campuri[8]);
                        SistemOperare sistemOperare = SistemOperare.valueOf(campuri[9].toUpperCase());
                        echipamente.add(new SistemCalcul(denumire, nrInv, pret, zonaMag, stare, tipMon, vitProc, cHdd, sistemOperare));
                        break;

                    default:
                        System.out.println("Tip de echipament necunoscut: " + tipEchipament);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("Eroare la parsarea datelor din fișier.");
        }
    }

    public void serializeazaEchipamente(String fisier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fisier))) {
            out.writeObject(echipamente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeazaEchipamente(String fisier) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fisier))) {
            echipamente = (List<Echipament>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
