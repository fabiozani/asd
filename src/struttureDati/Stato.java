package struttureDati;

/**
 * Classe rappresentante lo stato di un automa.
 */
public class Stato {
    private int id;
    private String nome;

    /**
     * Costruttotre della classe Stato.
     * @param id Identificatore univoco dello stato.
     * @param nome Nome univoco dello stato.
     */
    private Stato(int id,String nome){
        this.id = id;
        this.nome = nome;
    }

    /**
     * Metodo statico per la creazione di una nuova istanza della classe Stato.
     * @param id Identificatore univoco dello stato.
     * @param nome Nome univoco dello stato.
     * @return Nuova istanza della classe Stato.
     */
    public static Stato create(int id, String nome){
        return new Stato(id, nome);
    }

    /**
     * Getter per l'identificatore univoco dello stato.
     * @return Identificatore univoco dello stato.
     */
    public int getID() {
        return id;
    }

    /**
     * Setter per l'identificatore univoco dello stato.
     * @param id identificatore univoco dello stato.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dello stato.
     * @return Nome dello stato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Permette di settare il nome dello stato.
     * @param nome Nome dello stato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Rappresentazione testuale dello stato.
     * @return rappresentazione testuale dello stato (ID).
     */
    @Override
    public String toString() {
        return getNome();
    }

    /**
     * Controlla l'uguaglianza tra lo stato e l'oggetto passato in input.
     * @param obj Oggetto (stato) di cui si vuole controllare l'uguaglianza con questa istanza di Stato
     * @return TRUE se i due stati sono uguali, FALSE altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if(!obj.getClass().equals(this.getClass()))
            return false;
        Stato s = (Stato) obj;
        if(this.id == s.getID() || this.getNome()==s.getNome())
            return true;
        return false;
    }

    //TODO: scrivi in XML?
}
