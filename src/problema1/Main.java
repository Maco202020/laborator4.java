package problema1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static GestionareEchipamente gestionareEchipamente;

    public static void main(String[] args) {
        List<Echipament> echipamente = new ArrayList<>();
        gestionareEchipamente = new GestionareEchipamente(echipamente);

        // Citire inițială din fișierul echipamente.txt
        gestionareEchipamente.citesteDinFisier("C:\\Users\\macov\\Desktop\\java_laboratoare\\laborator4\\echipamente.txt");

        Scanner scanner = new Scanner(System.in);
        int optiune;

        // Meniu principal
        do {
            System.out.println("\n--- Meniu Echipamente ---");
            System.out.println("1. Afișarea tuturor echipamentelor");
            System.out.println("2. Afișarea imprimantelor");
            System.out.println("3. Afișarea copiatoarelor");
            System.out.println("4. Afișarea sistemelor de calcul");
            System.out.println("5. Modificarea stării unui echipament");
            System.out.println("6. Setarea unui mod de scriere pentru o imprimantă");
            System.out.println("7. Setarea unui format de copiere pentru un copiator");
            System.out.println("8. Instalarea unui sistem de operare pe un sistem de calcul");
            System.out.println("9. Afișarea echipamentelor vândute");
            System.out.println("10. Salvare și ieșire");
            System.out.print("Selectează o opțiune: ");

            optiune = scanner.nextInt();
            scanner.nextLine(); // Consumăm newline-ul după număr

            switch (optiune) {
                case 1:
                    afiseazaToateEchipamentele();
                    break;
                case 2:
                    afiseazaImprimante();
                    break;
                case 3:
                    afiseazaCopiatoare();
                    break;
                case 4:
                    afiseazaSistemeCalcul();
                    break;
                case 5:
                    modificaStareEchipament(scanner);
                    break;
                case 6:
                    setareModScriereImprimanta(scanner);
                    break;
                case 7:
                    setareFormatCopiereCopiator(scanner);
                    break;
                case 8:
                    instalareSistemOperare(scanner);
                    break;
                case 9:
                    afiseazaEchipamenteVandute();
                    break;
                case 10:
                    gestionareEchipamente.serializeazaEchipamente("echip.bin");
                    System.out.println("Colecția a fost salvată. Ieșire...");
                    break;
                default:
                    System.out.println("Opțiune invalidă. Încearcă din nou.");
            }
        } while (optiune != 10);

        scanner.close();
    }

    // Metode pentru fiecare opțiune din meniu

    private static void afiseazaToateEchipamentele() {
        System.out.println("\nToate echipamentele:");
        for (Echipament e : gestionareEchipamente.getEchipamente()) {
            e.afiseazaDetalii();
        }
    }

    private static void afiseazaImprimante() {
        System.out.println("\nImprimante:");
        for (Echipament e : gestionareEchipamente.getEchipamente()) {
            if (e instanceof Imprimanta) {
                e.afiseazaDetalii();
            }
        }
    }

    private static void afiseazaCopiatoare() {
        System.out.println("\nCopiatoare:");
        for (Echipament e : gestionareEchipamente.getEchipamente()) {
            if (e instanceof Copiator) {
                e.afiseazaDetalii();
            }
        }
    }

    private static void afiseazaSistemeCalcul() {
        System.out.println("\nSisteme de calcul:");
        for (Echipament e : gestionareEchipamente.getEchipamente()) {
            if (e instanceof SistemCalcul) {
                e.afiseazaDetalii();
            }
        }
    }

    private static void modificaStareEchipament(Scanner scanner) {
        System.out.print("\nIntrodu numărul de inventar al echipamentului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        Echipament echipament = cautaEchipamentDupaNrInv(nrInv);
        if (echipament != null) {
            System.out.println("Stare actuală: " + echipament.getStare());
            System.out.print("Introdu noua stare (ACHIZITIONAT, EXPUS, VANDUT): ");
            String stareNoua = scanner.nextLine().toUpperCase();

            try {
                StareEchipament stare = StareEchipament.valueOf(stareNoua);
                echipament.setStare(stare);
                System.out.println("Stare modificată cu succes!");
            } catch (IllegalArgumentException e) {
                System.out.println("Stare invalidă!");
            }
        } else {
            System.out.println("Echipamentul nu a fost găsit.");
        }
    }

    private static void setareModScriereImprimanta(Scanner scanner) {
        System.out.print("\nIntrodu numărul de inventar al imprimantei: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        Echipament echipament = cautaEchipamentDupaNrInv(nrInv);
        if (echipament instanceof Imprimanta) {
            System.out.print("Introdu noul mod de tipărire (COLOR, ALB_NEGRU): ");
            String modNou = scanner.nextLine().toUpperCase();

            try {
                ModTiparire modTiparire = ModTiparire.valueOf(modNou);
                ((Imprimanta) echipament).setModTiparire(modTiparire);
                System.out.println("Mod de tipărire modificat cu succes!");
            } catch (IllegalArgumentException e) {
                System.out.println("Mod de tipărire invalid!");
            }
        } else {
            System.out.println("Echipamentul nu este o imprimantă.");
        }
    }

    private static void setareFormatCopiereCopiator(Scanner scanner) {
        System.out.print("\nIntrodu numărul de inventar al copiatorului: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        Echipament echipament = cautaEchipamentDupaNrInv(nrInv);
        if (echipament instanceof Copiator) {
            System.out.print("Introdu noul format de copiere (A3, A4): ");
            String formatNou = scanner.nextLine().toUpperCase();

            try {
                FormatCopiere format = FormatCopiere.valueOf(formatNou);
                ((Copiator) echipament).setFormatCopiere(format);
                System.out.println("Formatul de copiere a fost modificat cu succes!");
            } catch (IllegalArgumentException e) {
                System.out.println("Format invalid!");
            }
        } else {
            System.out.println("Echipamentul nu este un copiator.");
        }
    }

    private static void instalareSistemOperare(Scanner scanner) {
        System.out.print("\nIntrodu numărul de inventar al sistemului de calcul: ");
        int nrInv = scanner.nextInt();
        scanner.nextLine();

        Echipament echipament = cautaEchipamentDupaNrInv(nrInv);
        if (echipament instanceof SistemCalcul) {
            System.out.print("Introdu noul sistem de operare (WINDOWS, LINUX): ");
            String sistemNou = scanner.nextLine().toUpperCase();

            try {
                SistemOperare sistem = SistemOperare.valueOf(sistemNou);
                ((SistemCalcul) echipament).instaleazaSistemOperare(sistem);
                System.out.println("Sistemul de operare a fost instalat cu succes!");
            } catch (IllegalArgumentException e) {
                System.out.println("Sistem de operare invalid!");
            }
        } else {
            System.out.println("Echipamentul nu este un sistem de calcul.");
        }
    }

    private static void afiseazaEchipamenteVandute() {
        System.out.println("\nEchipamente vândute:");
        for (Echipament e : gestionareEchipamente.getEchipamente()) {
            if (e.getStare() == StareEchipament.VANDUT) {
                e.afiseazaDetalii();
            }
        }
    }

    private static Echipament cautaEchipamentDupaNrInv(int nrInv) {
        for (Echipament e : gestionareEchipamente.getEchipamente()) {
            if (e.nrInv == nrInv) {
                return e;
            }
        }
        return null;
    }
}
