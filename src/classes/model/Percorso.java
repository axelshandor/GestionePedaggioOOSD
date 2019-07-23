package classes.model;

public class Percorso {

    /**
     * 
     *      attributi
     * 
     */
    private float chilometroIngresso;
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
    public Percorso(float chilometroIngresso, Casello uscita, Veicolo veicolo){
        this.chilometroIngresso = chilometroIngresso;
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
    public float getChilometroIngresso() { return this.chilometroIngresso; }

    
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
