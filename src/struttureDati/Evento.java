package struttureDati;

/**
 * Classe rappresentante un evento.
 */
public class Evento {
    private int id;
    private String nome;

    /**
     * Contruttore della classe Evento.
     * @param id Identificatore univoco dell'evento.
     * @param nome Nome univoco dell'evento.
     */
    private Evento(int id, String nome){
        this.id =id;
        this.nome = nome;
    }

    /**
     * Permette di creare in modo statico un'istanza della classe Evento.
     * @param id Identificatore univoco dell'evento.
     * @param nome Nome univoco dell'evento.
     * @return Istanza della classe Evento.
     */
    public static Evento create(int id, String nome){
        return new Evento(id, nome);
    }

    /**
     * Restituisce l'identificatore univoco dell'evento.
     * @return Identificatore univoco dell'evento.
     */
    public int getId() {
        return id;
    }

    /**
     * Permette di settare l'identificatore univoco dell'evento.
     * @param id Identificatore univoco dell'evento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce il nome univoco dell'evento.
     * @return Nome univoco dell'evento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Permette di inserire il nome univoco dell'evento.
     * @param nome Nome univoco dell'evento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce una rappresentazione testuale dell'evento.
     * @return Rappresentazione testuale dell'evento.
     */
    @Override
    public String toString() {
        return getNome();
    }

    /**
     * Controlla l'uguaglianza tra l'evento e l'oggetto passato in input.
     * @param obj Oggetto (evento) di cui si vuole controllare l'uguaglianza con questa istanza di Evento
     * @return TRUE se i due eventi sono uguali, FALSE altrimenti
     */
    @Override
    public boolean equals(Object obj) {
        if(!obj.getClass().equals(this.getClass()))
            return false;
        Evento e = (Evento) obj;
        if(this.id == e.getId() || this.getNome()==e.getNome())
            return true;
        return false;
    }
}
