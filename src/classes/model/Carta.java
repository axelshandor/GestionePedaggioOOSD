package classes.model;

public class Carta {

    /**
     * 
     *      attributi 
     * 
     * 
     * 
     */
    private String numeroCarta;
    private int meseScadenza;
    private int annoScadenza;
    private String nomeIntestatario;
    private String cognomeIntestatario;
    private int cvv;

    /**
     * 
     *      costruttore(i)
     * 
     * 
     * 
     * @param numeroCarta
     * @param dataScadenza
     * @param nome
     * @param cognome
     * @param cvv
     */
    public Carta(String numeroCarta, int annoScadenza, int meseScadenza, String nome, String cognome, int cvv){
        this.numeroCarta = numeroCarta;
        this.annoScadenza = annoScadenza;
        this.meseScadenza = meseScadenza;
        this.nomeIntestatario = nome;
        this.cognomeIntestatario = cognome;
        this.cvv = cvv;
    }

    /**
     *
     *      metodi
     * 
     * 
     * 
     *  
     * @return il numero di carta 
     */
    public String getNumeroCarta() { return this.numeroCarta; }


    /**
     * 
     * @return l'anno di scadenza della carta
     */
    public int getAnnoScadenza() { return this.annoScadenza; }


    /**
     * 
     * @return il mese di scadenza della carta
     */
    public int getMeseScadenza() { return this.meseScadenza; }


    /**
     * 
     * @return il nome dell'intestatario della carta
     */
    public String getNomeIntestatario() { return this.nomeIntestatario; }


    /**
     * 
     * @return il cognome dell'intestatario della carta
     */
    public String getCognomeIntestatario() { return this.cognomeIntestatario; }

    
    /**
     * 
     * @return il cvv della carta
     */
    public int getCvv() { return this.cvv; }

}
