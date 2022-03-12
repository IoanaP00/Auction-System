/**
 * Factory Design Pattern pentru un Produs
 */
public class ProdusFactory {
    public Prod getProdus(TipProdus p, int id, String nume, double pretMinim, int an){

        switch (p) {
            case Bijuterie:
                return new Bijuterie(id, nume, pretMinim, an);
            case Mobila:
                return new Mobila(id, nume, pretMinim, an);
            case Tablou:
                return new Tablou(id, nume, pretMinim, an);
            default:
                throw new IllegalArgumentException("Tipul de produs " + p + "nu este cunoscut.");
        }
    }

    /**
     * Tipurile de produse ce pot aparea in catalogul casei de licitatii
     */
    public static enum TipProdus{
        Bijuterie, Mobila, Tablou
    }
}
