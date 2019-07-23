package classes.controller;

import classes.model.Casello;
import classes.model.Percorso;
import classes.model.Veicolo;
import classes.model.Veicolo3;
import classes.model.Veicolo4;
import classes.model.Veicolo5;
import classes.model.VeicoloA;
import classes.model.VeicoloB;

public class Pedaggio {
    
	
    public static float pedaggio(Percorso percorso){
    	
    	float chilometri = percorso.getChilometroIngresso() - percorso.getCaselloUscita().getChilometro();
    	chilometri = Math.abs(chilometri);
    	
    	float tariffa = classes.controller.Normativa.calcoloTariffa(percorso.getVeicolo(), percorso.getCaselloUscita().getAutostradaAppartenenza());
    	float result = chilometri * tariffa;
    	
    	result = result + ( result * classes.controller.Normativa.IVA );
    	
        return (float)classes.controller.Normativa.arrotondamentoPrezzo(result);

    }
    
    /*
     * 
     * 
     * 		questo è un esempio di implementazione di un futuro metodo di calcolo del pedaggio .
     * 		ciò permette di non perdere i vecchi metodi che possono essere usati simultaneamente a quelli che saranno aggiunti in futuro
     * 
     * 
    public static float pedaggio2021(float chilometroIngresso, Casello caselloUscita, Veicolo v) {
    	
    	
    	
    }
    
     */
    
}
