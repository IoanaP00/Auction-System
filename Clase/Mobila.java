/**
 * Tip de Produs - Mobila
 */
public class Mobila extends Prod {
    private String tip;
    private String material;

    //Constructor
    public Mobila(int id, String nume, double pretMinim, int an) {
        super(id, nume, pretMinim, an);
    }

    @Override
    public void construct() {
        System.out.println("A fost adaugata moblia in lista de produse");

    }

    //Getters
    public String getTip() {
        return tip;
    }
    public String getMaterial() {
        return material;
    }

    //Setters
    public void setTip(String tip) {
        this.tip = tip;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Returneaza stringul cu informatiile asociate mobilei
     * @return
     */
    @Override
    public String toString() {
        return "Mobila{" +
                "tip='" + tip + '\'' +
                ", material='" + material + '\'' +
                ", id=" + id +
                ", nume='" + nume + '\'' +
                ", pretVanzare=" + pretVanzare +
                ", pretMinim=" + pretMinim +
                ", an=" + an +
                '}';
    }
}
