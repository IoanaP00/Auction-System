import java.util.ArrayList;

public abstract class CasaDeLicitatii {
    protected ArrayList<BrokerMediator> brokers;
    private ArrayList<Prod> produse;
    private ArrayList<Client> clienti;
    private ArrayList<Licitatie> licitatii;
    private double pretmax = 0.0;

    //Constructor
    public CasaDeLicitatii() {
        this.produse = new ArrayList<>();
        this.clienti = new ArrayList<>();
        this.licitatii = new ArrayList<>();
        this.brokers = new ArrayList<>();
    }

    //Getters
    public ArrayList<Licitatie> getLicitatii() {
        return licitatii;
    }
    public ArrayList<Prod> getProduse() {
        return produse;
    }


    /**
     * Asigneza in mod aleator un broker din lista clientului c
     *
     * @param c Clientul caruia ii asignam brokerul
     */
    public void assignBroker(Client c) {
        int max = brokers.size();
        int index = ((int) (Math.random() * max));

        brokers.get(index).addClient(c);
        c.brokerMediator = brokers.get(index);
    }

    /**
     * Verifica daca s-a atins numarul de participanti necesari pentru a incepe licitatia
     * Daca sunt suficienti participanti, se vor anunta toti brokerii din casa de licitatii
     *
     * @param licitatie Licitatia pe care trebuie sa o verifice
     */
    public void verificaLicitatie(Licitatie licitatie) {
        if (licitatie.getNrParticipanti() == licitatie.participanti.size()) {
            System.out.println("A inceput licitatia nr." + licitatie.id + ", pentru produsul: " + licitatie.idProdus);
            for (BrokerMediator b : brokers) {
                b.startLicitatie(licitatie);
            }
            this.procesLicitatie(licitatie);
        }
    }

    /**
     * Se parcurg toti pasii licitatiei; pentru fiecare pas brokerii cer clientilor noua suma de licitatie
     * si o transmit casei de licitatie care calculeaza maximul pasului curent
     *
     * @param licitatie Licitatia activa
     */
    public void procesLicitatie(Licitatie licitatie) {
        double max = pretMaxPas();

        //Cererea preturilor si calcularea maximului pentru fiecare pas
        for (int i = 1; i < licitatie.nrPasiMaxim; i++) {
            for (BrokerMediator b : brokers) {
                ((BrokerMediatorImplem) b).askNewPrice(max);
                max = pretMaxPas();
            }
        }
        //Gasire castigator dupa ce se termina pasii
        findWinner(max, licitatie);
    }

    /**
     * Parcurge toti brokerii si verifica daca exista mai multi brokeri care au un
     * client ce a licitat pretul maxim. Alege castigatorul licitatiei in functie de
     * numarul de licitatii castigate. Apeleaza apoi calularea comisionului de catre
     * brokerul corespunzator si reseteaza licitatia activa.
     *
     * @param max Pretul maxim final cautat
     * @param licitatie Licitatia tocmai incheiata
     */
    public void findWinner(double max, Licitatie licitatie) {
        Client winner = new ClientImplem();
        //Parcurgerea brokerilor si aplicarea criteriilor de gasire pentru castigator
        for (BrokerMediator b : brokers) {
            Client contender = ((BrokerMediatorImplem) b).verifClient(max);
            if (winner.getNume() == null && contender != null) {
                winner = contender;
            } else {
                if (winner.getNume() != null && contender != null
                        && winner.getNrLicitatiiCastigate() < contender.getNrLicitatiiCastigate())
                    winner = contender;
            }
        }
        //Dupa gasirea castigatorului se modifica valorile corespunzatoare acestuia
        int nr = winner.getNrLicitatiiCastigate() + 1;
        winner.setNrLicitatiiCastigate(nr);

        //Afisare rezultat
       afisareRezultat(licitatie, winner);


    }

    /**
     * Metoda auxiliara pentru a intoarce rezultatul unei licitatii
     * @param licitatie Licitatia incheiata
     * @param winner Castigatorul licitatiei
     */
    public void afisareRezultat(Licitatie licitatie, Client winner){
        System.out.println("Rezultat licitatia cu id: " + licitatie.id + ", pentru produsul cu id: " + licitatie.idProdus);
        Prod prod = findProdus(licitatie);
        System.out.println("Produs licitat " + prod);
        if (winner.getNume() != null && winner.pretCurent >= prod.pretMinim) {
            prod.pretVanzare = winner.pretCurent;
            winner.brokerMediator.getComision(winner);
            System.out.println("Client castigator: " + winner + "\n");
            resetLicitatie(licitatie, winner);
        } else {
            System.out.println("Nu s-a atins suma minima pentru produs in cadrul licitatiei" + "\n");
            resetNecastigator(licitatie);
        }
    }

    /**
     * Cauta produsul, in functie de id, in lista de produse
     * @param licitatie
     * @return Produsul gasit sau null daca nu a fost gasit
     */
    public Prod findProdus(Licitatie licitatie) {
        for (Prod p : this.produse) {
            if (p.id == licitatie.idProdus) {
                return p;
            }
        }
        return null;
    }

    /**
     * Reseteaza licitatia pentru cazul in care produsul nu a fost vandut
     * Reseteaza campul asociat pretului maxim al licitatiei curente.
     * Parcurge toti brokerii si reseteaza campurile corespunzatoare
     *
     * @param licitatie
     */
    public void resetNecastigator(Licitatie licitatie) {
        pretmax = 0.0;
        for (BrokerMediator b : brokers) {
            ((BrokerMediatorImplem) b).reset(licitatie);
        }
    }

    /**
     * Reseteaza licitatia pentru cazul in care produsul a fost vandut
     * Reseteaza campul asociat pretului maxim al licitatiei curente.
     * Parcurge toti brokerii si reseteaza campurile corespunzatoare
     *
     * @param licitatie
     */
    public void resetLicitatie(Licitatie licitatie, Client winner) {
        pretmax = 0.0;
        for (BrokerMediator b : brokers) {
            ((BrokerMediatorImplem) b).reset(licitatie, winner);
        }
    }

    /**
     * Parcurge toti brokerii si calculeaza pretul maxim actual al tuturor clientilor participanti
     * @return Valoarea maxima gasita
     */
    public double pretMaxPas() {
        double max = this.pretmax;
        for (BrokerMediator b : brokers) {
            if (((BrokerMediatorImplem) b).getClientiLicitatieActiva().size() > 0) {
                for (Client c : ((BrokerMediatorImplem) b).getClientiLicitatieActiva()) {
                    if (max < c.pretCurent) max = c.pretCurent;
                }
            }
        }
        this.pretmax = max;
        return max;
    }


}

