/**
 * Interfata pentru BrokerMediator
 */
public interface BrokerMediator {

    void addClient(Client c);
    void addCasaLicitatii(CasaDeLicitatii c);
    void startLicitatie(Licitatie licitatie);
    void getComision(Client c);
    void removeProduct(Licitatie licitatie);
}
