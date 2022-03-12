public class ClientImplem extends Client {

    //Constructors
    public ClientImplem() {
    }


    /**
     * Asociaza aleator o valoare a pretului initial in functie de pretul maxim al clientului
     *
     * @param licitatie Licitatia activa
     */
    public void getPretInit(Licitatie licitatie) {
        int procentInitial = ((int) ((Math.random() * (75 - 50)) + 50));
        this.pretCurent = (procentInitial * this.pretMaxim) / 100;
    }

    /**
     * Asociaza aleator o valoare a unui pret intermediar, prin adaugarea unui procent random
     * la valoarea maxima gasita la pasul precedent
     *
     * @param max Maximul de la pasul anterior
     * @return Noul pret curent al clientului
     */
    public double comunicaNewPrice(double max) {
        double pretNou = pretCurent;
        if (pretNou != max) {
            int procentRaise = ((int) ((Math.random() * (20 - 5)) + 5));
            pretNou = max + (procentRaise * this.pretCurent) / 100;
            if (pretNou > this.pretMaxim) pretNou = this.pretMaxim;
        }
        return pretNou;
    }


    /**
     * Anunta casa de licitatii ca un client s-a inscris la o licitatie pentru un anumit produs
     * Daca licitatia pentru produsul respectiv asteapta noi clienti, atunci acesta se va adauga la
     * lista participanti, altfel se creeaza o licitatie noua.
     *
     * @param c        Casa de licitatii la care clientul se inscrie
     * @param idProdus Produsul pe care clientul in cere
     * @param pretMax  Pretul maxim pe care clientul este dispus sa-l plateasca
     */
    public void solicitaLicitatie(CasaDeLicitatii c, int idProdus, double pretMax) {
        this.pretMaxim = pretMax;
        int current = this.getNrParticipari() + 1;
        this.setNrParticipari(current);
        int ok = 0;
        //Se cauta o licitatie deja existenta si se verifica daca se poate incepe
        for (Licitatie licitatie : c.getLicitatii()) {
            if (licitatie.idProdus == idProdus) {
                licitatie.participanti.add(this);
                ok = 1;
                c.verificaLicitatie(licitatie);
                break;
            }
        }
        //Daca nu s-a gasit licitatia se deschide una noua
        if (ok == 0) {
            int idLicitatie = c.getLicitatii().size();
            int nrPasi = ((int) ((Math.random() * (10 - 3)) + 3));
            Licitatie licitatie = new LicitatieBuilder().setId(idLicitatie)
                    .setIdProdus(idProdus).setNrParticipanti(3).setNrPasiMaxim(nrPasi).getLicitatie();
            licitatie.participanti.add(this);
            c.getLicitatii().add(licitatie);
        }
    }


}
