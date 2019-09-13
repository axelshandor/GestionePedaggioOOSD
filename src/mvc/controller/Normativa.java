package mvc.controller;

import java.util.HashMap;

import mvc.model.Veicolo;
import mvc.model.Veicolo3;
import mvc.model.Veicolo4;
import mvc.model.Veicolo5;
import mvc.model.VeicoloA;
import mvc.model.VeicoloB;
import dao.base.DaoFactory;
import dao.exceptions.DatabaseException;

public class Normativa {

	public static float IVA = 0.22f;
	public static HashMap<Integer, Float> tariffeTipoAutostrada = new HashMap<Integer, Float>();  // 0 per pianura e 1 per montagna
	
    /**
     * 
     * @param modello
     * @param marca
     * @param anno
     * @param targa
     * @param assi
     * @param peso
     * @param altezza
     * @param classeAmbientale
     * 
     * @return il veicolo creato secondo il tipo corrispondente
     */
    public static Veicolo creaVeicolo( String modello, String marca, int anno, String targa, int assi, float peso, float altezza, int classeAmbientale ){
        
        if ( assi < 2 || ( assi == 2 && altezza <= 1.3 ) ) return new VeicoloA(modello, marca, anno, targa, assi, peso, altezza, classeAmbientale);
        if ( assi == 2 && altezza > 1.3 ) return new VeicoloB(modello, marca, anno, targa, assi, peso, altezza, classeAmbientale);
        if ( assi == 3 ) return new Veicolo3(modello, marca, anno, targa, assi, peso, altezza, classeAmbientale);
        if ( assi == 4 ) return new Veicolo4(modello, marca, anno, targa, assi, peso, altezza, classeAmbientale);
        return new Veicolo5(modello, marca, anno, targa, assi, peso, altezza, classeAmbientale);

    }

    public static float calcoloTariffa(Veicolo veicolo, int id) {
    	
    	HashMap<String, Float> tariffe = test.Main.autostrade.getAutostradaById(id).getTariffe();
    	
    	if (veicolo instanceof VeicoloA) return tariffe.get("A");
    	if (veicolo instanceof VeicoloB) return tariffe.get("B");
    	if (veicolo instanceof Veicolo3) return tariffe.get("3");
    	if (veicolo instanceof Veicolo4) return tariffe.get("4");
    	
    	return tariffe.get("5");
    	
    }
    
    
    public static double arrotondamentoPrezzo(double prezzo) {
    	
    	prezzo = (double)(Math.round(prezzo*10))/10;
    	return prezzo;
    	
    }
    
    
    public static void aggiornaIva(float newIva) {	IVA = newIva; 	}
    
    
    public static boolean aggiornaTariffaTipo(int tipo, float nuovaTariffa) throws DatabaseException {
    	
	// controlliamo che effettivamente una tariffa del tipo che vogliamo cambiare esista
    	if ( !(tariffeTipoAutostrada.containsKey(tipo)) ) return false;
    	// aggiorniamo la tariffa nel database
    	DaoFactory.getDaoFactory(DaoFactory.MYSQL).getDaoNormativa().aggiornaTariffa(tipo, nuovaTariffa);
    	// aggiorniamo la tariffa nella classe Normativa ( in cui ci troviamo )
    	tariffeTipoAutostrada.put(tipo, nuovaTariffa);
    	
    	return true;
    	
    }
    
    
    public static boolean aggiungiTariffa(int tipo, float nuovaTariffa) throws DatabaseException {
    	
	// controlliamo che la tariffa che vogliamo aggiungere non sia già presente nel sistema
    	if ( tariffeTipoAutostrada.containsKey(tipo) ) return false;
    	// aggiungiamo la tariffa nel database
    	DaoFactory.getDaoFactory(DaoFactory.MYSQL).getDaoNormativa().aggiungiTariffa(tipo, nuovaTariffa);;
    	// aggiungiamo la tariffa nella classe Normativa ( in cui ci troviamo )
    	tariffeTipoAutostrada.put(tipo, nuovaTariffa);
    	return true;
    	
    }
    
    
}
