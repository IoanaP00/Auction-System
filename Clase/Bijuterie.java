/**
 * Tip de Produs - Bijuterie
 */
public class Bijuterie extends Prod {
    private String material;
    private boolean piatraPretioasa;

    //Constructor
    public Bijuterie(int id, String nume, double pretMinim, int an) {
        super(id, nume, pretMinim, an);
    }

    @Override
    public void construct() {
        System.out.println("A fost adaugata o bijuterie in lista de produse");
    }

    //Setters
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setPiatraPretioasa(boolean piatraPretioasa) {
        this.piatraPretioasa = piatraPretioasa;
    }
}
