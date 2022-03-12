# Auction-System
Popescu Ioana-Maria, 324 CB

Pentru realizarea proiectului meu am urmat clasele descrise in cerinta, 
alaturi de un Main si cateva clase/interfete auxiliare, in special pentru 
realizrea design pattern-urilor.

Functionalitati: 
   4 design patterns:
 	 Mediator: Brokerul este un mediator intre casa de licitatii si clienti, 
 			prin acesta se fac toate interactiunile licitatiei(cu exceptia 
 			solicitarii, deoarece clientului ii este asociat un broker aleator 
 			dupa ce se inscrie la o licitaie);

   Builder: Licitatia este construita cu intermediul unui Builder, pentru 
 			a seta doar campurile relevante in momentul respectiv;


   Factory: Diferitele tipuri de produse posibile sunt instantiate cu 
 			ajutorul unui Factory DP, ajutand in formarea diferitelor tipuri 
 			de produse posibile; intoarce eroare daca incearca sa se formeze 
 			un tip necunoscut de produs;

   Singleton: Adiminul este construit cu un Singleton, deoarece fiecare 
 			casa de licitatii poate avea un singur administrator, ce are 
 			responsabilitatea de a adauga produse pentru licitatii.

  -Genericitate: Se intalnesc mai multe ArrayList-uri ce au un tip de date
 		(ex: in broker ArrayList<Client>), adaugat in special pentru asigurarea
 		parcurgerii acestor liste mai usor cu enhanced for loops;


  -Concepte POO (încapsulare, moștenire, abstractizare, polimorfism)
 			Mostenire: ex - Bijuterie, Mobila, Tablou mostenesc Produs;
 			Polimorfism: Metoda reset din Broker, pentru diferitele tipuri de 
 				resetare a campurilor, +alte override-uri marcate la nivelul 
 				codului propriu zis
 			Abstractizare: sunt prezente clase abstracte(Produs) si intefete
 				(BrokerMediator);
 			Incapsulare: sunt setate campuri cu private(ex: BrokerMediatorImplem)

 -Testarea aplicației cu minim 10 scenarii: am testat aplicatia cu 10 teste 
 		diferite, valorile fiind oferite in arhiva.


 Mecanism de licitatie: 
 		Initial, programul citeste toate obiectele de care are nevoie pentru a 
 	putea incepe(casa de licitatii, administratorul, brokerii, clientii, 
 	diferite tipuri de produse). Dupa ce acestea sunt formate, impreuna cu 
 	legaturile dintre ele, clientii vor solicita participarea la anumite 
 	licitatii. Aceasta informatie ajunge la casa de licitatii, fiecarui client 
 	ii este asociat un broker(in cazul in care nu avea deja asignat unul) si se 
 	adauga un participant la licitatia pentru obiectul respectiv(daca este 
 	primul care liciteaza, atunci se formeaza o licitatie noua).
 		Dupa ce se atinge numarul necesar de participanti licitatia incepe, iar 
 	brokerii isi vor cauta clientii care participa la licitatia tocmai inceputa, 
 	apoi le vor cere o suma de bani initiala(intre 50-75% din pretul maxim al 
 	sau). Aceste sume sunt trimise de catre broker la casa de licitatii, unde se 
 	calculeaza maximul, trinsmis brokerilor. Apoi pentru fiecare pas ulterior, 
 	brokerul cere fiecarui client care a licitat mai putin o suma noua(cu 5-20% 
 	mai mare decat maximul gasit la pasul anterior) si se calculeaza noul maxim.
 	Dupa ce se termina pasul final, se cauta in toti brokerii clientul care a 
 	castigat, se afiseaza, iar apoi brokerul isi ia comisionul calculat 
 	corespunzator. 
 		La final, se reseteaza toate campurile aferente licitatiei curente
	(in casa de licitatii, in brokeri, in clienti) si se continua solicitarea 
	celorlalte licitatii.
