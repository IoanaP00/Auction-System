/**
 * Tip de Produs - Tablou
 */
public class Tablou extends Prod {
    private String numePictor;
    private Culori culori;


    //Constructor
    public Tablou(int id, String nume, double pretMinim, int an) {
        super(id, nume, pretMinim, an);
    }

    @Override
    public void construct() {
        System.out.println("A fost adaugata un tablou in lista de produse");
    }

    //Getters
    public String getNumePictor() {
        return numePictor;
    }
    public Culori getCulori() {
        return culori;
    }

//    Setters
    public void setNumePictor(String numePictor) {
        this.numePictor = numePictor;
    }
    public void setCulori(Culori culori) {
        this.culori = culori;
    }

    /**
     * Returneaza stringul cu informatiile asociate tabloului
     * @return String-ul rezultat
     */
    @Override
    public String toString() {
        return "Tablou{" +
                "numePictor='" + numePictor + '\'' +
                ", culori=" + culori +
                ", id=" + id +
                ", nume='" + nume + '\'' +
                ", pretVanzare=" + pretVanzare +
                ", pretMinim=" + pretMinim +
                ", an=" + an +
                '}';
    }
}

