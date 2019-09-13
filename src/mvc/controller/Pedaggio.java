package mvc.controller;

import mvc.model.Percorso;

public class Pedaggio {
    
	
    public static float pedaggio(Percorso percorso){
    	
	   System.out.println("km ingresso :" + percorso.getChilometroIngresso());
	   System.out.println("km uscita :" + percorso.getCaselloUscita().getChilometro() );

	    float chilometri = percorso.getChilometroIngresso() - percorso.getCaselloUscita().getChilometro();
	    chilometri = Math.abs(chilometri);
	    	
	    float tariffa = mvc.controller.Normativa.calcoloTariffa(percorso.getVeicolo(), percorso.getCaselloUscita().getIdAutostradaAppartenenza());
	    float result = chilometri * tariffa;
	    	
	    result = result + ( result * mvc.controller.Normativa.IVA );
	    	
	    return (float)mvc.controller.Normativa.arrotondamentoPrezzo(result);

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
