package struttureDati;

import java.util.ArrayList;

/**
 * Classe rappresentante una transizione tra stati all'interno di un automa.
 */
public class Transizione {
    private String id;
    private Stato statoPartenza;
    private Stato statoArrivo;
    private Evento eventoIngresso;
    private ArrayList<Evento> eventiUscita;
    //private HashSet<Evento> entiUscita; //possiblità per il futuro (più veloce ma non preserva l'ordine.
    private Etichetta etichettaOsservabilita;
    private Etichetta etichettaRilevanza;

    /**
     * Costruttore della classe Transizione.
     * @param id Identificatore univoco della transizione.
     * @param statoPartenza Stato di partenza della transizione (non può essere nullo).
     * @param statoArrivo Stato di arrivo della transizione (non può essere nullo).
     * @param eventoIngresso Evento in ingresso alla transizione (la fa scattare se la transizione è abilitata). Può essere nullo.
     * @param eventiUscita Lista degli eventi in uscita dalla transizione che può essere vuota (è possibile passare il valore null).
     * @param etichettaOsservabilita Etichetta di osservabilità associata alla transizione.
     * @param etichettaRilevanza Etichetta di rilevanza associata alla transizione.
     */
    private Transizione(String id, Stato statoPartenza, Stato statoArrivo, Evento eventoIngresso, ArrayList<Evento> eventiUscita, Etichetta etichettaOsservabilita, Etichetta etichettaRilevanza) {
        this.id = id;
        this.statoPartenza = statoPartenza;
        this.statoArrivo = statoArrivo;
        this.eventoIngresso = eventoIngresso;
        this.eventiUscita = eventiUscita;
        this.etichettaOsservabilita = etichettaOsservabilita;
        this.etichettaRilevanza = etichettaRilevanza;
    }

    /**
     * Metodo statico per la creazione di un'istanza della classe Transizione.
     *      * @param id Identificatore univoco della transizione.
     *      * @param statoPartenza Stato di partenza della transizione (non può essere nullo).
     *      * @param statoArrivo Stato di arrivo della transizione (non può essere nullo).
     *      * @param eventoIngresso Evento in ingresso alla transizione (la fa scattare se la transizione è abilitata). Può essere nullo.
     *      * @param eventiUscita Lista degli eventi in uscita dalla transizione che può essere vuota (è possibile passare il valore null).
     *      * @param etichettaOsservabilita Etichetta di osservabilità associata alla transizione.
     *      * @param etichettaRilevanza Etichetta di rilevanza associata alla transizione.
     * @return Istanza della classe transizione.
     */
    public static Transizione create(String id, Stato statoPartenza, Stato statoArrivo, Evento eventoIngresso, ArrayList<Evento> eventiUscita, Etichetta etichettaOsservabilita, Etichetta etichettaRilevanza){
        return new Transizione(id,statoPartenza,statoArrivo,eventoIngresso,eventiUscita,etichettaOsservabilita,etichettaRilevanza);
    }

    /**
     * Restituisce l'ID della transizione
     * @return ID della transizione
     */
    public String getId() {
        return id;
    }

    /**
     * Permette di settare l'ID della transizione
     * @param id ID della transizione.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Restituisce lo stato di partenza della transizione.
     * @return Stato di partenza della transizione.
     */
    public Stato getStatoPartenza() {
        return statoPartenza;
    }

    /**
     * Permette di settare lo stato di partenza della transizione.
     * @param statoPartenza Stato di partenza della transizione.
     */
    public void setStatoPartenza(Stato statoPartenza) {
        this.statoPartenza = statoPartenza;
    }

    /**
     * Restituisce lo stato di arrivo della transizione.
     * @return Stato dia rrivo della transizione.
     */
    public Stato getStatoArrivo() {
        return statoArrivo;
    }

    /**
     * Permette di settare lo stato di arrivo della transizione.
     * @param statoArrivo Stato di arrivo della transizione.
     */
    public void setStatoArrivo(Stato statoArrivo) {
        this.statoArrivo = statoArrivo;
    }

    /**
     * Restituisce l'evento in ingresso alla transizione.
     * @return Evento in ingresso alla transizione.
     */
    public Evento getEventoIngresso() {
        return eventoIngresso;
    }

    /**
     * Permette di settare l'evento in ingresso alla transizione.
     * @param eventoIngresso Evento in ingresso alla transizione.
     */
    public void setEventoIngresso(Evento eventoIngresso) {
        this.eventoIngresso = eventoIngresso;
    }

    /**
     * Restituisce la lista di eventi in uscita dalla transizione.
     * @return Lista degli eventi in uscita dalla transizione.
     */
    public ArrayList<Evento> getEventiUscita() {
        return eventiUscita;
    }

    /**
     * Permette di settare la lista di eventi in uscita dalla transizione.
     * @param eventiUscita Lista degli eventi in uscita dalla transizione.
     */
    public void setEventiUscita(ArrayList<Evento> eventiUscita) {
        this.eventiUscita = eventiUscita;
    }

    /**
     * Permette di aggiungere un evento alla lista di eventi in uscita dalla transizione.
     * Non permettendo duplicati nella lista, controlla che l'evento non sia già presente nella lista.
     *
     * @param evento Evento da aggiungere.
     */
    public void aggiungiEventoUscita(Evento evento){
        if(!eventoPresente(evento)) {
            if (eventiUscita == null)
                eventiUscita = new ArrayList<>();
            eventiUscita.add(evento);
        }
    }

    /**
     * Permette di rimuovere un evento dalla lista di eventi in uscita dalla transizione.
     * @param evento Evento da rimuovere.
     * @return TRUE se è stato possibile rimuovere l'evento dalla lista, FALSE altrimenti.
     */
    public boolean rimuoviEvento(Evento evento){
        return eventiUscita.remove(evento);
    }

    /**
     * Controlla se l'evento indicato è presente nella lista di eventi in uscita dalla transizione.
     * @param evento Evento di cui si vuole controllare la presenza nella lista.
     * @return TRUE se l'elemento è contenuto nella lista, FALSE altrimenti.
     */
    public boolean eventoPresente(Evento evento){
        return eventiUscita.contains(evento);
    }

    /**
     * Restituisce l'etichetta di osservabilità associata alla transizione.
     * @return Etichetta di osservabilità associata alla transizione.
     */
    public Etichetta getEtichettaOsservabilita() {
        return etichettaOsservabilita;
    }

    /**
     * Permette di settare l'etichetta di osservabilità associata alla transizione.
     * @param etichettaOsservabilita Etichetta di osservabilità associata alla transizione.
     */
    public void setEtichettaOsservabilita(Etichetta etichettaOsservabilita) {
        this.etichettaOsservabilita = etichettaOsservabilita;
    }

    /**
     * Restituisce l'etichetta di rilevanza associata alla transizione.
     * @return Etichetta di rilevanza associata alla transizione.
     */
    public Etichetta getEtichettaRilevanza() {
        return etichettaRilevanza;
    }

    /**
     * Permette di settare l'etichetta di rilevanza associata alla transizione.
     * @param etichettaRilevanza Etichetta di rilevanza associata alla transizione.
     */
    public void setEtichettaRilevanza(Etichetta etichettaRilevanza) {
        this.etichettaRilevanza = etichettaRilevanza;
    }

    /**
     * Restituisce una stringa rappresentante la transizione nel formato: "statoPartenza -> statoArrivo [(eventoIngresso/({eventiUscita})] oss: etichettaOsservabilita, ril: etichettaRilevanza".
     * @return Stringa rappresentante la transizione.
     */
    @Override
    public String toString() {
        String stati = id + ": " + statoPartenza.toString() + " -> " + statoArrivo.toString();
        String uscita;
        if (eventiUscita!=null)
            uscita = "/{" + eventiUscita.get(0).toString();
        else
            uscita = "";
        for (Evento evento : eventiUscita){
            uscita += ", " +evento.toString();
        }
        String eventi = (eventoIngresso!=null ? eventoIngresso.toString() : "") + uscita;
        return  stati + " [" + eventi + "] " + "oss: " + etichettaOsservabilita.toString() + ", ril: " + etichettaRilevanza.toString();
    }

    @Override
    public boolean equals(Object obj) {
        Transizione t = (Transizione) obj;
        if(t.getId() == id)
            return true;
        if(t.getStatoPartenza() == statoPartenza && t.getStatoArrivo() == statoArrivo && t.getEventoIngresso() == eventoIngresso && t.getEventiUscita()==eventiUscita)
            return true;
        return false;
    }

    //TODO: scrivi in XML?
}
