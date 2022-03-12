public abstract class Prod {
    int id;
    String nume;
    double pretVanzare;
    double pretMinim;
    int an;

    //Constructors
    public Prod() {
    }

    public Prod(int id, String nume, double pretMinim, int an) {
        this.id = id;
        this.nume = nume;
        this.pretMinim = pretMinim;
        this.an = an;
    }

    public abstract void construct();

}
