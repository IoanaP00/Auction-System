import java.util.ArrayList;

/**
 * Builder Design Pattern pentru Licitatie
 */
public class LicitatieBuilder {
    int id;
    int idProdus;
    int nrParticipanti;
    int nrPasiMaxim;
    ArrayList<Client> participanti = new ArrayList();

    public LicitatieBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public LicitatieBuilder setIdProdus(int idProdus) {
        this.idProdus = idProdus;
        return this;
    }

    public LicitatieBuilder setNrParticipanti(int nrParticipanti) {
        this.nrParticipanti = nrParticipanti;
        return this;
    }

    public LicitatieBuilder setNrPasiMaxim(int nrPasiMaxim) {
        this.nrPasiMaxim = nrPasiMaxim;
        return this;
    }

    public LicitatieBuilder setParticipanti(ArrayList<Client> participanti) {
        this.participanti = participanti;
        return this;
    }
    public Licitatie getLicitatie(){
        return new Licitatie(id, idProdus, nrParticipanti, nrPasiMaxim, participanti);
    };
}
