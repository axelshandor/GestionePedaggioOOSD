package classes.model;

public class Percorso {

    /**
     * 
     *      attributi
     * 
     */
    private Casello caselloIngresso;
    private Casello caselloUscita;
    private Veicolo veicolo;

    /**
     * 
     *      costruttore(i)
     * 
     * 
     * 
     * @param ingresso
     * @param uscita
     * @param veicolo
     */
    public Percorso(Casello ingresso, Casello uscita, Veicolo veicolo){
        this.caselloIngresso = ingresso;
        this.caselloUscita = uscita;
        this.veicolo = veicolo;
    }

    /**
     * 
     *      metodi
     * 
     * 
     * 
     * 
     * @return il casello di ingresso del percorso effettuato 
     */
    public Casello getCaselloIngresso() { return this.caselloIngresso; }

    
    /**
     * 
     * @return il casello di uscita del percorso effettuato 
     */
    public Casello getCaselloUscita() { return this.caselloUscita; }


    /**
     * 
     * @return il veicolo che ha effettuato il percorso 
     */
    public Veicolo getVeicolo() { return this.veicolo; }

}
