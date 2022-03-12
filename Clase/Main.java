/**
 * Clasa in care formez toate obiectele necesare si in care se solicita licitatiile
 *
 * @author Popescu Ioana-Maria, 324CB
 */
public class Main {

    public static void main(String[] args){
        CasaDeLicitatii casa = new CasaLicitatiiImplem();
        Administrator administrator = AdministratorSingleton.Instanta();
        administrator.casaDeLicitatii = casa;

        //Brokers
        BrokerMediator broker1 = new BrokerMediatorImplem(1);
        BrokerMediator broker2 = new BrokerMediatorImplem(2);
        BrokerMediator broker3 = new BrokerMediatorImplem(3);

        casa.brokers.add(broker1);
        casa.brokers.add(broker2);
        casa.brokers.add(broker3);

        //Clienti
        PersoanaFizica c1 = new PersoanaFizica(1, "N1", "A1", "1990");
        PersoanaJuridica c2 = new PersoanaJuridica(2, "N2", "A2", Companie.SRL, 200.0);
        PersoanaFizica c3 = new PersoanaFizica(3, "N3", "A3", "2000");
        PersoanaJuridica c4 = new PersoanaJuridica(4, "N4", "A4", Companie.SA, 300.0);
        PersoanaFizica c5 = new PersoanaFizica(5, "N5", "A5", "1993");
        PersoanaJuridica c6 = new PersoanaJuridica(6, "N6", "A6", Companie.SRL, 250.0);


        ProdusFactory factory = new ProdusFactory();

        //Tablouri
        Prod t1 = factory.getProdus(ProdusFactory.TipProdus.Tablou, 1, "Tablou1", 200, 2010);
        ((Tablou) t1).setCulori(Culori.ulei);
        ((Tablou) t1).setNumePictor("Pictor1");
        Prod t2 = factory.getProdus(ProdusFactory.TipProdus.Tablou, 2, "Tablou2", 123, 2020);
        ((Tablou) t2).setCulori(Culori.tempera);
        ((Tablou) t2).setNumePictor("Pictor2");
        Prod t3 = factory.getProdus(ProdusFactory.TipProdus.Tablou, 3, "Tablou3", 170, 1990);
        ((Tablou) t3).setCulori(Culori.acrilic);
        ((Tablou) t3).setNumePictor("Pictor3");
        Prod t4 = factory.getProdus(ProdusFactory.TipProdus.Tablou, 4, "Tablou4", 250, 1999);
        ((Tablou) t4).setCulori(Culori.acrilic);
        ((Tablou) t4).setNumePictor("Pictor2");
        Prod t5 = factory.getProdus(ProdusFactory.TipProdus.Tablou, 5, "Tablou5", 150, 2018);
        ((Tablou) t5).setCulori(Culori.tempera);
        ((Tablou) t5).setNumePictor("Pictor5");
        Prod t6 = factory.getProdus(ProdusFactory.TipProdus.Tablou, 6, "Tablou6", 175, 1995);
        ((Tablou) t6).setCulori(Culori.ulei);
        ((Tablou) t6).setNumePictor("Pictor1");
        Prod t7 = factory.getProdus(ProdusFactory.TipProdus.Tablou, 7, "Tablou7", 200, 2001);
        ((Tablou) t7).setCulori(Culori.tempera);
        ((Tablou) t7).setNumePictor("Pictor4");


        //Mobile
        Prod m1 = factory.getProdus(ProdusFactory.TipProdus.Mobila, 8, "M1", 300, 2020);
        ((Mobila) m1).setTip("Pat");
        ((Mobila) m1).setMaterial("Lemn");
        Prod m2 = factory.getProdus(ProdusFactory.TipProdus.Mobila, 9, "M2", 900, 2010);
        ((Mobila) m2).setTip("Scaun");
        ((Mobila) m2).setMaterial("Plastic");
        Prod m3 = factory.getProdus(ProdusFactory.TipProdus.Mobila, 10, "M3", 200, 2019);
        ((Mobila) m3).setTip("Dulap");
        ((Mobila) m3).setMaterial("Lemn");
        Prod m4 = factory.getProdus(ProdusFactory.TipProdus.Mobila, 11, "M4", 249, 2021);
        ((Mobila) m4).setTip("Birou");
        ((Mobila) m4).setMaterial("Metal");
        Prod m5 = factory.getProdus(ProdusFactory.TipProdus.Mobila, 12, "M5", 175, 2015);
        ((Mobila) m5).setTip("Dulap");
        ((Mobila) m5).setMaterial("Lemn");
        Prod m6 = factory.getProdus(ProdusFactory.TipProdus.Mobila, 13, "M6", 199, 2019);
        ((Mobila) m6).setTip("Biblioteca");
        ((Mobila) m6).setMaterial("Lemn");
        Prod m7 = factory.getProdus(ProdusFactory.TipProdus.Mobila, 14, "M7", 215, 2021);
        ((Mobila) m7).setTip("Canapea");
        ((Mobila) m7).setMaterial("Piele");

        //Bijuterii
        Prod b1 = factory.getProdus(ProdusFactory.TipProdus.Bijuterie, 15, "B1", 100, 2021);
        ((Bijuterie) b1).setMaterial("M1");
        ((Bijuterie) b1).setPiatraPretioasa(false);
        Prod b2 = factory.getProdus(ProdusFactory.TipProdus.Bijuterie, 16, "B2", 200, 2020);
        ((Bijuterie) b2).setMaterial("M2");
        ((Bijuterie) b2).setPiatraPretioasa(true);
        Prod b3 = factory.getProdus(ProdusFactory.TipProdus.Bijuterie, 17, "B3", 150, 2021);
        ((Bijuterie) b3).setMaterial("M3");
        ((Bijuterie) b3).setPiatraPretioasa(true);
        Prod b4 = factory.getProdus(ProdusFactory.TipProdus.Bijuterie, 18, "B4", 175, 2021);
        ((Bijuterie) b4).setMaterial("M2");
        ((Bijuterie) b4).setPiatraPretioasa(false);
        Prod b5 = factory.getProdus(ProdusFactory.TipProdus.Bijuterie, 19, "B5", 200, 2019);
        ((Bijuterie) b5).setMaterial("M1");
        ((Bijuterie) b5).setPiatraPretioasa(true);
        Prod b6 = factory.getProdus(ProdusFactory.TipProdus.Bijuterie, 20, "B6", 100, 2020);
        ((Bijuterie) b6).setMaterial("M4");
        ((Bijuterie) b6).setPiatraPretioasa(true);

        //Adaugare produse
        administrator.addProdus(t1);
        administrator.addProdus(t2);
        administrator.addProdus(t3);
        administrator.addProdus(t4);
        administrator.addProdus(t5);
        administrator.addProdus(t6);
        administrator.addProdus(t7);

        administrator.addProdus(m1);
        administrator.addProdus(m2);
        administrator.addProdus(m3);
        administrator.addProdus(m4);
        administrator.addProdus(m5);
        administrator.addProdus(m6);
        administrator.addProdus(m7);

        administrator.addProdus(b1);
        administrator.addProdus(b2);
        administrator.addProdus(b3);
        administrator.addProdus(b4);
        administrator.addProdus(b5);
        administrator.addProdus(b6);


        //Leg broker->casa
        broker1.addCasaLicitatii(casa);
        broker2.addCasaLicitatii(casa);
        broker3.addCasaLicitatii(casa);

//        Legaturi broker - clienti

        //Insert teste aici
        c1.solicitaLicitatie(casa, 1, 200.0);
        c1.solicitaLicitatie(casa, 5, 200.0);
        c1.solicitaLicitatie(casa, 9, 200.0);

        c2.solicitaLicitatie(casa, 4, 300.0);
        c2.solicitaLicitatie(casa, 9, 300.0);
        c2.solicitaLicitatie(casa, 6, 300.0);

        c3.solicitaLicitatie(casa, 4, 110.0);
        c3.solicitaLicitatie(casa, 7, 110.0);
        c3.solicitaLicitatie(casa, 9, 110.0);

        c4.solicitaLicitatie(casa, 11, 250.0);
        c4.solicitaLicitatie(casa, 7, 250.0);
        c4.solicitaLicitatie(casa, 4, 250.0);

        c5.solicitaLicitatie(casa, 5, 250.0);
        c5.solicitaLicitatie(casa, 8, 250.0);
        c5.solicitaLicitatie(casa, 2, 250.0);

        c6.solicitaLicitatie(casa, 10, 250.0);
        c6.solicitaLicitatie(casa, 5, 250.0);
        c6.solicitaLicitatie(casa, 7, 250.0);


        //End teste
    }
}
