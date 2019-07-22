package classes.model;

public abstract class Veicolo {

    /**
     * 
     *      attributi 
     * 
     * 
     * 
     */
    private String modello;
    private String marca;
    private int annoImmatricolazione;
    private String targa;
    private int numeroAssi;
    private float peso;
    private float altezza;
    private int classeAmbientale;		//   1-6

    /**
     * 
     *      costruttore(i)
     * 
     * 
     * 
     * @param modello
     * @param marca
     * @param annoImmatricolazione
     * @param targa
     * @param assi
     * @param peso
     * @param altezza
     * @param classeAmbientale
     */
    public Veicolo(String modello, String marca, int annoImmatricolazione, String targa, int assi, float peso, float altezza, int classeAmbientale) {
        this.modello = modello;
        this.marca = marca;
        this.annoImmatricolazione = annoImmatricolazione;
        this.targa = targa;
        this.numeroAssi = assi;
        this. peso = peso;
        this.altezza = altezza;
        this.classeAmbientale = classeAmbientale;
    }

    /**
     * 
     *      metodi
     * 
     * 
     * 
     * 
     * @return il modello del veicolo 
     */
    public String getModello() { return this.modello; }


    /**
     * 
     * @return la marca del veicolo 
     */
    public String getMarca() { return this.marca; }


    /**
     * 
     * @return l'anno di immatricolazione del veicolo 
     */
    public int getAnnoImmatricolazione() { return this.annoImmatricolazione; }


    /**
     * 
     * @return la targa del veicolo
     */
    public String getTarga() { return this.targa; }


    /**
     * 
     * @return il numero di assi del veicolo 
     */
    public int getNumeroAssi() { return this.numeroAssi; }


    /**
     * 
     * @return il peso del veicolo 
     */
    public float getPeso() { return this.peso; }


    /**
     * 
     * @return l'altezza del veicolo 
     */
    public float getAltezza() { return this.altezza; }

    
    /**
     * 
     * @return la classe ambiantale del veicolo 
     */
    public int getClasseAmbientale() { return this.classeAmbientale; }

}
