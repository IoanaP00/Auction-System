import java.util.ArrayList;

public class Licitatie {
    int id;
    int idProdus;
    int nrPasiMaxim;
    ArrayList<Client> participanti;
    private final int nrParticipanti;

    //Constructors
    public Licitatie(int id, int idProdus, int nrParticipanti, int nrPasiMaxim, ArrayList<Client> participanti) {
        this.id = id;
        this.idProdus = idProdus;
        this.nrParticipanti = nrParticipanti;
        this.nrPasiMaxim = nrPasiMaxim;
        this.participanti = participanti;
    }

    //Getter
    public int getNrParticipanti() {
        return nrParticipanti;
    }

    /**
     * Returneaza stringul cu informatiile asociate licitatiei
     *
     * @return String-ul rezultat
     */
    @Override
    public String toString() {
        return "Licitatie{" +
                "id=" + id +
                ", idProdus=" + idProdus +
                ", NrCurentParticipanti=" + participanti.size() +
                '}';
    }
}
