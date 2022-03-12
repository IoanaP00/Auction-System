public class Administrator extends Angajat {
    CasaDeLicitatii casaDeLicitatii;

    /**
     * Adauga produsul in lista de produse
     * @param p produsul care trebuie adaugat
     */
    public void addProdus(Prod p){
        casaDeLicitatii.getProduse().add(p);
    }
}
