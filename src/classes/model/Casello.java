package classes.model;

public class Casello {

    /**
     * 
     *      attributi
     * 
     * 
     * 
     */
    private int id;
    private String nome;
    private Autostrada autostradaAppartenenza;
    private float chilometro;

    /**
     * 
     *      costruttore(i)
     * 
     * 
     * 
     * @param id
     * @param nome
     * @param autostradaAppartenenza
     * @param chilometro
     */
    public Casello(int id, String nome, Autostrada autostradaAppartenenza, float chilometro){
        this.id = id;
        this.nome = nome;
        this.autostradaAppartenenza = autostradaAppartenenza;
        this.chilometro = chilometro;
    }

    /**
     * 
     *      metodi
     * 
     * 
     * 
     * 
     * @return l'id del casello 
     */
    public int getId(){
        return this.id;
    }


    /**
     * 
     * @return il nome del casello
     */
    public String getNome() { return this.nome; }
    /**
     * 
     * @param nuovoNome
     */
    public void setNome(String nuovoNome) { this.nome = nuovoNome; }


    /**
     * 
     * @return l'autostrada di appartenenza del casello 
     */
    public Autostrada getAutostradaAppartenenza() { return this.autostradaAppartenenza; }
    /**
     * 
     * @param nuovaAutostrada
     */
    public void setAutostradaAppartenenza(Autostrada nuovaAutostrada) { this.autostradaAppartenenza = nuovaAutostrada; }


    /**
     * 
     * @return il chilometro in cui si trova il casello 
     */
    public float getChilometro() { return this.chilometro; }
    /**
     * 
     * @param nuovoChilometro
     */
    public void setChilometro(float nuovoChilometro) { this.chilometro = nuovoChilometro; }

}
