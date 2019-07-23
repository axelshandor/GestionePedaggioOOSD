package classes.controller;

import java.util.HashMap;

import classes.model.Autostrada;
import classes.model.Veicolo;
import classes.model.Veicolo3;
import classes.model.Veicolo4;
import classes.model.Veicolo5;
import classes.model.VeicoloA;
import classes.model.VeicoloB;

public class Normativa {

	public static float IVA = 0.22f;
	static HashMap<Integer, Float> tariffeTipoAutostrada = new HashMap<Integer, Float>();  // 0 per pianura e 1 per montagna
	
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

    public static float calcoloTariffa(Veicolo veicolo, Autostrada autostrada) {
    	
    	HashMap<String, Float> tariffe = test.Main.autostrade.getAutostradaById(autostrada.getId()).getTariffe();
    	
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
    
    public static void aggiornaIva(float newIva) {
    	
    	IVA = newIva;
    	
    }
    
    public static boolean aggiornaTariffe(int tipo, float newTariffa) {
    	
    	if ( !(tariffeTipoAutostrada.containsKey(tipo)) ) return false;
    	tariffeTipoAutostrada.put(tipo, newTariffa);
    	return true;
    	
    }
    
    public static boolean aggiungiTariffa(int tipo, float newTariffa) {
    	
    	if ( tariffeTipoAutostrada.containsKey(tipo) ) return false;
    	tariffeTipoAutostrada.put(tipo, newTariffa);
    	return true;
    	
    }
    
    
}
