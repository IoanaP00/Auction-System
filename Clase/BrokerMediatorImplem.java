import java.util.ArrayList;

/**
 * Implementare a interfetei BrokerMediator
 */
public class BrokerMediatorImplem implements BrokerMediator {
    private final int id;
    private ArrayList<Client> clienti;
    private ArrayList<Client> clientiLicitatieActiva = new ArrayList<>();
    private CasaDeLicitatii casaDeLicitatii;
    private double castiguri;
    private Client castigator;

    //Constructor
    public BrokerMediatorImplem(int id) {
        this.clienti = new ArrayList<Client>();
        this.id = id;
    }

    //Getters
    public ArrayList<Client> getClientiLicitatieActiva() {
        return clientiLicitatieActiva;
    }
    public int getId() {
        return id;
    }

    /**
     * Adauga clientul c in lista de clienti a brokerului
     * @param c Clientul ce trebuie adaugat
     */
    public void addClient(Client c) {
        clienti.add(c);
    }

    /**
     * Asociaza casa de licitatie unui Broker
     *
     * @param c casa de licitatie care ii este asociata unui broker
     */
    public void addCasaLicitatii(CasaDeLicitatii c) {
        this.casaDeLicitatii = c;
    }

    /**
     * Incepe procesul de licitatie
     * Pargurge lista de participanti a licitatiei si ii cauta pe cei
     * prezenti in lista de clienti ai brokerului curent
     *
     * @param licitatie Licitatia care incepe
     */
    public void startLicitatie(Licitatie licitatie) {
        for (Client participant : licitatie.participanti) {
            for (Client clientBroker : this.clienti) {
                if (clientBroker.getId() == participant.getId()) {
                    this.clientiLicitatieActiva.add(participant);
                }
            }
        }
        //Apeleaza cererea preturilor initiale oferite
        getPretInitial(licitatie);
    }


    /**
     * Parcurge clientii inscrisi la licitatia curenta si le solicita un pret initial
     *
     * @param licitatie Licitatia activa
     */
    public void getPretInitial(Licitatie licitatie) {
        if (clientiLicitatieActiva.size() > 0) {
            for (Client c : clientiLicitatieActiva) {
                c.getPretInit(licitatie);
            }
        }

    }

    /**
     * Dupa terminarea licitatiei se cauta produsul licitat si se elimina
     *
     * @param licitatie Licitatia tocmai incheiata
     */
    public void removeProduct(Licitatie licitatie) {
        for (int i = 0; i < casaDeLicitatii.getProduse().size(); i++) {
            Prod produsElim = casaDeLicitatii.getProduse().get(i);
            if (licitatie.idProdus == produsElim.id)
                casaDeLicitatii.getProduse().remove(produsElim);
        }
    }

    /**
     * Se reseteaza parametrii unui broker asociati licitatiei active
     *
     * @param licitatie Licitatia tocmai incheiata
     */
    public void reset(Licitatie licitatie, Client winner) {
        removeProduct(licitatie);
        castigator = null;
        for (Client c : clientiLicitatieActiva) {
            c.pretCurent = 0.0;
        }
        clientiLicitatieActiva.clear();
    }

    public void reset(Licitatie licitatie) {
        castigator = null;
        for (Client c : clientiLicitatieActiva) {
            c.pretCurent = 0.0;
        }
        clientiLicitatieActiva.clear();
    }

    /**
     * Parcurge clientii inscrisi la licitatia curenta si le solicita un pret nou,
     * in functie de pretul max
     *
     * @param max Suma maxima anterioara
     */
    public void askNewPrice(double max) {
        if (clientiLicitatieActiva.size() > 0) {
            for (Client c : clientiLicitatieActiva) {
                double newPrice = c.comunicaNewPrice(max);
                c.setPretCurent(newPrice);
            }
        }
    }

    /**
     * Intoarce clientul din lista de participanti a brokerului
     * care a licitat la ultimul pas suma maxima finala si
     * face alegerea in functie de nr licitatii castigate
     *
     * @param max Suma maxima finala
     * @return Clientul care a licitat suma maxima, daca exista in brokerul respectiv
     */
    public Client verifClient(double max) {
        if (clientiLicitatieActiva.size() > 0) {
            for (Client c : clientiLicitatieActiva) {
                if (c.pretCurent == max) {
                    if (castigator == null || castigator.getNume() == null) {
                        castigator = c;
                    } else {
                        if (c.getNrLicitatiiCastigate() > castigator.getNrLicitatiiCastigate()) castigator = c;
                    }
                }
            }
            return castigator;
        }
        return null;
    }

    /**
     * Calculeaza comisionul in functie de tipul de client
     * si adauga rezultatul in campul personal de castiguri
     *
     * @param c Clientul in functie de care se calculeaza comisionul
     */
    public void getComision(Client c) {
        if (c instanceof PersoanaFizica) {
            if (c.getNrParticipari() < 5) castiguri += c.pretCurent / 5;
            else castiguri += (c.pretCurent * 15) / 100;
        } else {
            if (c.getNrParticipari() < 25) castiguri += c.pretCurent / 2;
            else castiguri += c.pretCurent / 10;
        }
    }

    /**
     * Returneaza stringul cu informatiile asociate brokerului
     *
     * @return String-ul afisat
     */
    @Override
    public String toString() {
        return "BrokerMediatorImplem{" +
                "id=" + id +
                ", clienti=" + clienti +
                ", clientiLicitatieActiva=" + clientiLicitatieActiva +
                ", casaDeLicitatii=" + casaDeLicitatii +
                ", castiguri=" + castiguri +
                '}';
    }
}
