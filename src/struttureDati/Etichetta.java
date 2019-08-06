package struttureDati;

/**
 * Classe rappresentante un'etichetta (di osservabilità o di rilevanza)
 */
public class Etichetta {

    private String id;
    private TipoEtichetta tipoEtichetta;

    /**
     * Costruttore della classe Etichetta.
     * @param id Identificatore univoco dell'etichetta.
     * @param tipoEtichetta Tipo di etichetta (osservablità o rilevanza).
     */
    private Etichetta(String id, TipoEtichetta tipoEtichetta){
        this.id = id;
        this.tipoEtichetta = tipoEtichetta;
    }

    /**
     * Permette di creare in modo statico un'istanza della classe Etichetta.
     * @param id Identificatore univoco dell'etichetta.
     * @param tipoEtichetta Tipo di etichetta (osservablità o rilevanza).
     * @return Istanza della classe Etichetta.
     */
    public static Etichetta create(String id, TipoEtichetta tipoEtichetta){
        return new Etichetta(id,tipoEtichetta);
    }

    /**
     * Restituisce l'ID dell'etichetta.
     * @return Identificatore univoco dell'etichetta.
     */
    public String getId() {
        return id;
    }

    /**
     * Permette di settare l'identificatore univoco dell'etichetta.
     * @param id Identificatore univoco dell'etichetta.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Restituisce il tipo di etichetta.
     * @return Tipo di etichetta.
     */
    public TipoEtichetta getTipoEtichetta() {
        return tipoEtichetta;
    }

    /**
     * Permette di settare il tipo di etichetta.
     * @param tipoEtichetta Tipo di etichetta.
     */
    public void setTipoEtichetta(TipoEtichetta tipoEtichetta) {
        this.tipoEtichetta = tipoEtichetta;
    }

    /**
     * Restituisce una rappresentazione testuale dell'etichetta.
     * @return Rappresentazione testuale dell'etichetta.
     */
    @Override
    public String toString() {
        return getId();
    }
}
