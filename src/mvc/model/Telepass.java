package mvc.model;

public class Telepass {

    /**
     * 
     *      attributi
     * 
     * 
     * 
     */
    private int id;
    private String iban;
    private String indirizzoResidenza;
    private String email;
    private String targaVeicolo;

    /**
     * 
     *      costruttore(i)
     * 
     * 
     * 
     * @param id
     * @param iban
     * @param indirizzo
     * @param email
     * @param targa
     */
    public Telepass(int id, String iban, String indirizzo, String email, String targa){
        this.id = id;
        this.iban = iban;
        this.indirizzoResidenza = indirizzo;
        this.email = email;
        this.targaVeicolo = targa;
    }


    /**
     * 
     *      metodi
     * 
     * 
     * 
     * 
     * @return l'id del telepass
     */
    public int getId() { return this.id; }


    /**
     * 
     * @return l'iban del conto collegato al telepass
     */
    public String getIban() { return this.iban; }


    /**
     * 
     * @return la residenza dell'intestatario del telepass
     */
    public String getResidenza() { return this.indirizzoResidenza; }


    /**
     * 
     * @return l'email collegata al telepass
     */
    public String getEmail() { return this.email; }


    /**
     * 
     * @return la targa dell'auto collegata al telepass
     */
    public String getTarga() { return this.targaVeicolo; }

}
