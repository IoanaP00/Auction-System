/**
 * AdministratorSingleton - asigura o singura instanta a unui administrator
 * pentru casele de licitatii
 */
public class AdministratorSingleton {
    private static Administrator unicaInstanta;

    private AdministratorSingleton() {
    }

    public static Administrator Instanta() {
        if (unicaInstanta == null)
            unicaInstanta = new Administrator();
        return unicaInstanta;
    }
}
