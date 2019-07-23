package classes.model;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

import classes.model.Casello;

public class Autostrada {

    /**
     * 
     *      attributi 
     * 
     * 
     * 
     */
    private int id;
    private String nome;
    private int tipo;       // 0 = pianura, 1 = montagna
    private String cittaUno;
    private String cittaDue;
    // l'HashMap caselli conterrà le coppie < idCasello, Casello >
    private HashMap<Integer, Casello> caselli = new HashMap<Integer, Casello>();
    // l'HashMap tariffe conterrà le coppie < nomeTariffa, tariffa > dove
    // il nome tariffa sarà esattamente il nome della classe del veicolo ( es. A, B, 3 ...)
    private HashMap<String, Float> tariffe = new HashMap<String, Float>();

    /**
     * 
     *      costruttore(i)
     * 
     * 
     * 
     * @param id
     * @param nome
     * @param tipo
     * @param cittaUno
     * @param cittaDue
     * @param caselli
     * @param tariffe
     */
    public Autostrada(int id, String nome, int tipo, String cittaUno, String cittaDue){
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.cittaUno = cittaUno;
        this.cittaDue = cittaDue;
    }

    /**
     * 
     *      metodi
     * 
     *
     * 
     * 
     * @return l'id dell'Autostrada
     */
    public int getId(){
        return this.id;
    }

    
    /**
     * 
     * @return il nome dell'Autostrada 
     */
    public String getNome() { return this.nome; }
    /**
     * 
     * @param nuovoNome
     */
    public void setNome(String nuovoNome) { this.nome = nuovoNome; }


    /**
     * 
     * @return il tipo di Autostrada, 0 se pianura 1 se montagna
     */
    public int getTipo() { return this.tipo; }
    /**
     * 
     * @param nuovoTipo
     */
    public void setTipo(int nuovoTipo) { this.tipo = nuovoTipo; }


    /**
     * 
     * @return la città di partenza ( o arrivo ) dell'Autostrada
     */
    public String getCittaUno() { return this.cittaUno; }
    /**
     * 
     * @param nuovaCitta
     */
    public void setCittaUno(String nuovaCitta) { this.cittaUno = nuovaCitta; }


    /**
     * 
     * @return la città di arrivo ( o partenza ) dell'Autostrada
     */
    public String getCittaDue() { return this.cittaDue; }
    /**
     * 
     * @param nuovaCitta
     */
    public void setCittaDue(String nuovaCitta) { this.cittaDue = nuovaCitta; }


    /**
     * 
     * @return l'HashMap contenente i caselli appartenenti all'Autostrada
     */
    public HashMap<Integer, Casello> getCaselli() { return this.caselli; }
    /**
     * 
     *  Metodo che ritorna un set di coppie id - Casello
     * 
     * @return Set<Map.Entry<Integer, Casello>>
     */
    public Set<Map.Entry<Integer, Casello>> getCaselliSet() { return this.caselli.entrySet(); }
    /**
     * 
     * @param id del Casello 
     * @return il Casello dato il suo id
     */
    public Casello getCaselloById(int id) { return this.caselli.get(id); }
    /**
     *
     * @param id del Casello
     * @return true se c'è un casello con l'id dato, false altrimenti
     */
    public boolean isCaselloById(int id){
        return this.caselli.containsKey(id);
    }
    /**
     * 
     * @param nuovoCasello
     * @return true se il casello è stato correttamente aggiunto false altrimenti
     */
    public boolean addCasello(Casello nuovoCasello) { 
        if ( ( isCaselloById(nuovoCasello.getId()) ) ) return false;  // casello gi presente
        this.caselli.put(nuovoCasello.getId(), nuovoCasello); 
        return true;
    }
    /**
     * 
     * @param nuovoCasello
     * @return true se il casello è stato correttamente aggiornato false altrimenti
     */
    public boolean aggiornaCasello(Casello nuovoCasello) {
        if ( !( isCaselloById(nuovoCasello.getId()) ) ) return false;  // casello non presente
        this.caselli.put(nuovoCasello.getId(), nuovoCasello);
        return true;
    }
    /**
     * 
     * @param caselli
     */
    public void addCaselli( List<Casello> caselli ) {
        for (Casello c : caselli){
            this.caselli.put(c.getId(), c);
        }
    }
    /**
     * 
     * @param caselli
     */
    public void addCaselli( HashMap<Integer, Casello> caselli ) {
    	
        this.caselli = caselli;
        
    }

    /**
     * 
     * @return l'HashMap contenente le coppie nomeTariffa - tariffa
     */
    public HashMap<String, Float> getTariffe() { return this.tariffe; }
    /**
     * 
     * @param nomeTariffa
     * @return il valore della tariffa corrispondente al nome dato
     */
    public float getTariffaByName(String nomeTariffa) { return this.tariffe.get(nomeTariffa); }
    /**
     * 
     * @param classeVeicolo
     * @param nuovaTariffa
     * @return true se la tariffa è stata correttamente aggiunta false altrimenti
     */
    public boolean addTariffa(String classeVeicolo, float nuovaTariffa) {
        if ( this.tariffe.containsKey(classeVeicolo) ) return false;  // tariffa gia presente
        this.tariffe.put(classeVeicolo, nuovaTariffa);
        return true;
    }
    /**
     * 
     * @param classeVeicolo
     * @param nuovaTariffa
     * @return true se la tariffa è stata correttamente aggiornata false altrimenti
     */
    public boolean aggiornaTariffa(String classeVeicolo, float nuovaTariffa) {
        if ( !( this.tariffe.containsKey(classeVeicolo) ) ) return false;  // tariffa non presente
        this.tariffe.put(classeVeicolo, nuovaTariffa);
        return true;
    }

}
