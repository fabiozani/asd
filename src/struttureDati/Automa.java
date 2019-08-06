package struttureDati;

import java.util.ArrayList;

/**
 * Classe rappresentante un automa.
 * Caratteristiche dell'automa:
 * - insieme finito di stati e di transizioni;
 * - da ogni stato esce almeno una transizione;
 * - non esistono stati isolati;
 * - non deterministico (possono esistere più transizioni uscenti dallo stesso stato e con lo stesso evento in ingresso che sono dirette a stati diversi.
 *
 */
public class Automa {

    private int id;
    private String nome;
    private ArrayList<Stato> stati; //possibile trasformare in HashSet (no controllo su insieme)
    private ArrayList<Transizione> transizioni; //possibile trasformare in HashSet (no controllo su insieme)
    private Stato statoCorrente; //inizialmente lo stato corrente sarà lo stato iniziale

    /**
     * Costruttore della classe Automa.
     * @param id Identificatore univoco dell'automa.
     * @param nome Nome univoco dell'automa.
     * @param stati Insieme di stati dell'automa (non possono esserci stati ripetuti).
     * @param transizioni Insieme di transizioni  dell'automa (non possono esserci transizioni ripetute).
     * @param statoIniziale Stato iniziale dell'automa.
     */
    private Automa(int id, String nome, ArrayList<Stato> stati, ArrayList<Transizione> transizioni, Stato statoIniziale){
        this.stati = stati;
        this.transizioni = transizioni;
        this.statoCorrente = statoIniziale;
    }

    /**
     * Permette di costruire staticamente un'istanza della classe Automa.
     * Nel fare ciò controlla che l'insieme degli stati, quello delle transizioni e lo stato iniziale formino un automa valido.
     * @param id Identificatore univoco dell'automa.
     * @param nome Nome univoco dell'automa.
     * @param stati Insieme di stati dell'automa (non possono esserci stati ripetuti).
     * @param transizioni Insieme di transizioni  dell'automa (non possono esserci transizioni ripetute).
     * @param statoIniziale Stato iniziale dell'automa.
     * @return Istanza di un automa valido oppure null (se l'automa non è valido).
     */
    public static Automa create(int id, String nome, ArrayList<Stato> stati, ArrayList<Transizione> transizioni, Stato statoIniziale){
        Automa automa = new Automa(id,nome,stati,transizioni,statoIniziale);
        //controllo che l'automa sia veramente un automa.
        if(checkAutoma(automa))
            return automa;
        else{
            System.out.println("Automa non corretto");
            return null;
        }
    }

    /**
     * Controlla la validità dell'automa:
     * - non ci sono stati ripetuti;
     * - non ci sono transizioni ripetute;
     * - lo stato iniziale è uno stato dell'automa;
     * - da ogni stato esce almeno una transizione;
     * - non esistono stati isolati
     * @param automa Automa da controllare.
     * @return TRUE se l'automa da controllare è valido, FALSE altrimenti.
     */
    private static boolean checkAutoma(Automa automa) {
        //controllo stati duplicati
        for(int i = 0; i < automa.getStati().size() - 1; i++){
            for(int j = i; j < automa.getStati().size(); j++){
                if(automa.getStati().get(i).equals(automa.getStati().get(j)))
                    return false;
            }
        }
        //controllo che lo stato iniziale sia uno degli stati dell'automa
        if(!automa.getStati().contains(automa.getStatoCorrente()))
            return false;
        //controllo transizioni duplicate
        for(int i = 0; i < automa.getTransizioni().size() - 1; i++){
            for(int j = i; j < automa.getTransizioni().size(); j++){
                if(automa.getTransizioni().get(i).equals(automa.getTransizioni().get(j)))
                    return false;
            }
        }
        //controllo che da ogni stato esca almeno una transizione
        for (int i = 0; i < automa.getStati().size(); i++){
            boolean transizioneUscente = false;
            for(int j = 0; j < automa.getTransizioni().size(); j++){
                if(automa.getTransizioni().get(j).getStatoPartenza().equals(automa.getStati().get(i))) {
                    transizioneUscente = true;
                    break;
                }
                if (!transizioneUscente)
                    return false;
            }
        }
        //TODO: controllo stati isolati

        return true;

    }

    /**
     * Data una lista di eventi disponibili in input controlla se ci siano transizioni eseguibili.
     * Nel caso in cui siano presenti, aggiorna lo stato corrente e fornisce l'insieme di eventi in uscita della transizione.
     * @param eventiDisponibili
     */
    public ArrayList<Evento> esegui(ArrayList<Evento> eventiDisponibili){
        //TODO: esecuzione automa dati eventi disponibli. Bisogna gestire il non determinismo.
        //Non determinismo: posso andare in stati diversi oppure nello stesso stato, ma avere eventi in uscita diversi
        //TODO: gestire il caso in cui il buffer in uscita sia pieno.
        return null;
    }

    /**
     * Restituisce l'inisieme di stati dell'automa.
     * @return Insieme di stati dell'automa.
     */
    public ArrayList<Stato> getStati() {
        return stati;
    }

    /**
     * Permette di settare l'insieme di stati dell'automa.
     * @param stati Insieme di stati dell'automa.
     */
    public void setStati(ArrayList<Stato> stati) {
        this.stati = stati;
    }

    /**
     * Restituisce l'insieme di transizioni dell'automa.
     * @return Insieme di transizioni dell'automa.
     */
    public ArrayList<Transizione> getTransizioni() {
        return transizioni;
    }

    /**
     * Permette di settare l'insieme di transizioni dell'automa.
     * @param transizioni Insieme di transizioni dell'automa.
     */
    public void setTransizioni(ArrayList<Transizione> transizioni) {
        this.transizioni = transizioni;
    }

    /**
     * Restituisce lo stato corrente dell'automa.
     * @return Stato corrente dell'automa.
     */
    public Stato getStatoCorrente() {
        return statoCorrente;
    }

    /**
     * Permette di settare lo stato corrente dell'automa.
     * @param statoCorrente
     */
    public void setStatoCorrente(Stato statoCorrente) {
        this.statoCorrente = statoCorrente;
    }

    //TODO:equals

    //TODO: XML
}

