import java.util.Scanner; //importiamo la libreria con cui possiamo fare le funzioni di input
import java.util.Random; //importiamo la libreria con cui possiamo fare le funzioni di estrazione casuale

public class App
{
    public static void main(String[] args) throws Exception 
    {
        Scanner input = new Scanner(System.in); //dichiariamo la variabile "input" di tipo "Scanner" a cui attribuiamo la funzione "new Scanner(System.in)" con cui gestiamo l'input dell'utente
        Random r=new Random(); //dichiariamo la variabile "r" di tipo "Random" a cui attribuiamo la funzione "new Random()" con cui gestiamo le estrazioni casuali del codice
        
        System.out.println("Benvenuto al gioco Sette & Mezzo"); //Stampiamo nel terminale la scritta "Benvenuto al gioco Sette & Mezzo"

        boolean pescaCarta = true; //dichiariamo la variabile "pescaCarta" di tipo "boolean", inizializzandola come "true". con questa variabile chiederemo all'utente se intende pescare ancora o meno
        boolean scelta = true; //dichiariamo la variabile "scelta" di tipo "boolean", inizializzandola come "true". con questa variabile l'utente sceglierà se giocare ancora o meno
        int seme; //dichiariamo la variabile "seme" di tipo "int". con questa variabile gestiremo i semi delle carte.
        int puntata=0; //dichiariamo la variabile "puntata" di tipo "int" inizializzandola a 0. con questa variabile gestiremo la puntata dell'utente.
        int budget=100; //dichiariamo la variabile "budget" di tipo "int" inizializzandola a 100. con questa variabile gestiremo il budget dell'utente.
        boolean [][] mazzo= new boolean [10][4]; /*dichiariamo l'array bidimensinale ([][]) "mazzo" 
        //di tipo "boolean" (true o false per vedere se la carta estratta è già uscita(true) o meno(false))
        a cui attribuiamo le dimensioni [10] per il numero di carte per ogni seme e [4] per il numero di semi */
        String nomeSeme=""; //dichiariamo la variabile "nomeSeme" di tipo "String" inizializzandola come vuota ("") che poi andremo a modificare con il nome del seme estratto
        int cartaUtente, cartaBanco; //dichiariamo le variabili "cartaUtente" e "cartaBanco" con cui gestiamo le carte estratte dell'utente e del banco
        
        
        do //ciclo do while con condizione la variabile "scelta" inizializzata come true con cui ripetiamo il codice sottostante in caso la scelta di rigiocare dell'utente sia vera, in caso sia falsa usciamo dal ciclo 
        {
            //queste due variabili le dichiariamo qui e non sopra il do perchè ad ogni partita si devono resettare e tornare a 0
            double punteggioUtente = 0; //dichiariamo la variabile "punteggioUtente" di tipo double(non int perchè i punteggi sono decimali)inizializzata uguale a 0
            double punteggioBanco = 0; //dichiariamo la variabile "punteggioBanco" di tipo double inizializzata uguale a 0

            if (budget>0) //ciclo if con condizione budget>0 con cui controlliamo il budget dell'utente, se la condizione non è vera usciamo dall'if
            {
                
                System.out.println("Il tuo budget è: "+budget); //stampiamo il budget dell'utente
                
                do //ciclo do while con cui controlliamo che la puntata dell'utente sia valida e lo ripetiamo finchè non inserisce una puntata valida
                {
                    System.out.println("Inserisci la puntata: ");
                    puntata= input.nextInt(); //l'utente inserisce la sua puntata
                    if (puntata>budget) //controlliamo se la puntata dell'utente sia maggiore del budget
                    {
                        System.out.println("Non c'hai na lira gioca di meno");    
                    }
                    else if (puntata==0) //controlliamo se la puntata sia 0
                    {
                        System.out.println("Puntata minima 1 euro");    
                    }
                } while (puntata>budget || puntata==0);

                do //ciclo do while con condizione la variabile "pescaCarta" inizializzata come true con cui ripetiamo il codice sottostante in caso l'utente voglia pescare un'altra carta se inserisce true, inserendo false usciamo dal ciclo
                {               
                    
                    //ciclo do while con condizione mazzo[cartaUtente][seme] (con cui controlliamo se esistano ancora carte all'interno di "mazzo")
                    do 
                    {
                        cartaUtente= r.nextInt(10); //inizializziamo la variabile "cartaUtente" a cui diamo il valore "r.nextInt(10)" estraendo quindi un numero casuale (r.) di tipo intero (nextInt) da 0 a 9 (10)
                        seme=r.nextInt(4); //inizializziamo la variabile "seme" a cui diamo il valore "r.nextInt(4)" estraendo quindi un numero casuale (r.) di tipo intero (nextInt) da 0 a 3 (4)
                    } while (mazzo[cartaUtente][seme]);
                        
                    mazzo[cartaUtente][seme]=true; //eliminiamo dall'array mazzo la carta dell'utente
                    cartaUtente=cartaUtente+1; //visto che cartaUtente va da 0 a 9 gli aggiungiamo 1 così che vada a 0 a 10
                    
                    switch (seme) //switch con cui controlliamo i casi del seme
                    {
                        case 0: nomeSeme = "denari"; //caso 0 con cui attribuiamo alla variabile nomeSeme "denari"
                            break;
                        case 1: nomeSeme = "bastoni"; //caso 1 con cui attribuiamo alla variabile nomeSeme "bastoni"
                            break;
                        case 2: nomeSeme = "spade"; //caso 2 con cui attribuiamo alla variabile nomeSeme "spade"
                            break;
                        case 3: nomeSeme = "coppe"; //caso 3 con cui attribuiamo alla variabile nomeSeme "coppe"
                            break;
                    }
                    
                    if (cartaUtente >= 8) //if con cui controlliamo che la carta dell'utente sia maggiore o uguale ad 8
                    {
                        punteggioUtente = punteggioUtente + 0.5; //aggiungiamo 0.5 alla variabile punteggioUtente
                    } 
                    else //else con cui escludiamo le carte >= di 8 
                    {
                        punteggioUtente = punteggioUtente + cartaUtente; //aggiungiamo il valore della carta estratta alla variabile punteggioUtente
                    }
                
                    System.out.println("\nHai pescato la carta " + cartaUtente + " di " + nomeSeme); //stampiamo la carta uscita
                    System.out.println("Punteggio corrente " + punteggioUtente); //stampiamo il punteggio dell'utente
                    
                    if (punteggioUtente < 7.5) //controlliamo se il punteggio dell'utente è minore di 7.5
                    {
                        System.out.println("Vuoi pescare un'altra carta?(true/false)"); //chiediamo all'utente se vuole un'altra carta
                        pescaCarta = input.nextBoolean(); //l'utente inserisce la sua scelta (true o false) con cui inizializziamo la variabile pescaCarta
                    }
                    else if (punteggioUtente==7.5) //controlliamo se il punteggio dell'utente è uguale a 7.5
                    {
                        System.out.println("Hai fatto 7.5!");
                        pescaCarta=false; //non facciamo pescare all'utente un'altra carta perchè ha fatto 7.5 quindi inizializziamo la variabile pescaCarta come false
                    }
                    
                    if (punteggioUtente>7.5) //controlliamo se il punteggio dell'utente è maggiore di 7.5
                    {
                        System.out.println("Hai sballato");
                        budget-=puntata; //l'utente ha perso quindi aggiorniamo il budget dell'utente rimuovendogli la puntata
                        System.out.println("Il tuo budget aggiornato è: "+budget); //stampiamo il budget aggiornato
                        pescaCarta=false; //inizializziamo la variabile pescaCarta come false
                    }
                } while (pescaCarta);
            }
    
            if (punteggioUtente<=7.5) //controlliamo che il punteggio dell'utente sia <= di 7.5, se lo è iniziamo la mano del pc
            {
                
                //stesso codice di prima ma con le variabili del banco invece che dell'utente
                do //ripetiamo il ciclo do while finchè punteggioBanco<punteggioUtente e punteggioBanco<=7.5
                {
                    do 
                    {
                        cartaBanco= r.nextInt(10);
                        seme=r.nextInt(4);       
                    } while (mazzo[cartaBanco][seme]);
                        
                    mazzo[cartaBanco][seme]=true;
                    cartaBanco=cartaBanco+1;
                    
                    switch (seme) 
                    {
                        case 0: nomeSeme = "denari";
                            break;
                        case 1: nomeSeme = "bastoni";
                            break;
                        case 2: nomeSeme = "spade";
                            break;
                        case 3: nomeSeme = "coppe";
                            break;
                    }
                    
                    if (cartaBanco >= 8) 
                    {
                        punteggioBanco = punteggioBanco + 0.5;
                    } 
                    else 
                    {
                        punteggioBanco = punteggioBanco + cartaBanco;
                    }
                    System.out.println("\nIl banco ha pescato la carta " + cartaBanco + " di " + nomeSeme);
                    System.out.println("Punteggio corrente del banco " + punteggioBanco);
            
                } while (punteggioBanco<punteggioUtente && punteggioBanco<=7.5);
                
                //confrontiamo i punteggi dell'utente e del banco
                if (punteggioBanco>7.5) //se il banco sballa
                {
                    System.out.println("Il banco ha sballato");
                    budget+=puntata; //aggiungiamo la puntata dell'utente al suo budget
                    System.out.println("Il tuo budget aggiornato è: "+budget);
                }
                else if (punteggioBanco==punteggioUtente) //se il banco pareggia l'utente
                {
                    System.out.println("Pareggio. Vince il banco");
                    budget-=puntata;
                    System.out.println("Il tuo budget aggiornato è: "+budget);
                }
                else if (punteggioUtente>punteggioBanco)  //se l'utente vince
                {
                    System.out.println("Hai vinto");
                    budget+=puntata;
                    System.out.println("Il tuo budget aggiornato è: "+budget);
                }
                else //se l'utente perde
                {
                    System.out.println("Vince il banco");
                    budget-=puntata;
                    System.out.println("Il tuo budget aggiornato è: "+budget);
                }
            }
            
            System.out.println("Vuoi giocare ancora?(true/false)"); //chiediamo all'utente se vuole giocare ancora
            scelta=input.nextBoolean(); //l'utente inserisce la sua scelta (true/false) che sarà il valore che attribuiremo alla variabile scelta 
            
            if (scelta && budget<=0) //se inserisce true, quindi vuole ancora giocare e il suo budget però è <= a 0
            {
                System.out.println("Hai terminato il budget"); //stampiamo che l'utente ha terminato il budget
                scelta=false; //inizilizziamo scelta come false così che usciamo dal while sottostante
            }
        }while (scelta); 
        
        input.close(); //liberiamo la memoria utilizzata dalla variabile input
        System.out.println("Grazie per aver giocato!!");
    }
}