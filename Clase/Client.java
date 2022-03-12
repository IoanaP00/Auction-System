public abstract class Client {
    protected BrokerMediator brokerMediator;
    private int id;
    private String nume;
    private String adresa;
    private int nrParticipari;
    private int nrLicitatiiCastigate;
    double pretMaxim;
    double pretCurent;

    public abstract void getPretInit(Licitatie licitatie);
    public abstract double comunicaNewPrice(double max);
    public abstract void solicitaLicitatie(CasaDeLicitatii c, int idProdus, double pretMax);

    //Constructors
    public Client() {
    }
    public Client(int id, String nume, String adresa) {
        this.id = id;
        this.nume = nume;
        this.adresa = adresa;
        this.nrParticipari = 0;
        this.nrLicitatiiCastigate = 0;
    }

    //Setter
    public void setPretCurent(double pretCurent) {
        this.pretCurent = pretCurent;
    }
    public void setNrLicitatiiCastigate(int nrLicitatiiCastigate) {
        this.nrLicitatiiCastigate = nrLicitatiiCastigate;
    }
    public void setNrParticipari(int nrParticipari) {
        this.nrParticipari = nrParticipari;
    }

    //Getters
    public int getNrLicitatiiCastigate() {
        return nrLicitatiiCastigate;
    }
    public int getNrParticipari() {
        return nrParticipari;
    }
    public int getId() {
        return id;
    }
    public String getNume() {
        return nume;
    }

    /**
     * Returneaza stringul cu informatiile asociate clientului
     * @return String-ul rezultat
     */
    @Override

    public String toString() {
        return "Client{" +
                "idBroker=" + ((BrokerMediatorImplem) brokerMediator).getId() +
                ", id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", nrParticipari=" + nrParticipari +
                ", nrLicitatiiCastigate=" + nrLicitatiiCastigate +
                ", pretMaxim=" + pretMaxim +
                ", pretCurr=" + pretCurent +
                '}';
    }
}
