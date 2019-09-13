package mvc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import mvc.controller.Pedaggio;
import mvc.model.Casello;
import mvc.model.Percorso;
import mvc.model.Veicolo;
import dao.base.DaoFactory;
import dao.exceptions.DatabaseException;

public class PercorrenzaAutostradale implements interfaces.Ingresso, interfaces.Uscita {
	
	private DaoFactory dbFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

	@Override
	public void ingressoTelepass(Casello caselloIngresso, String targa) throws DatabaseException {

	    	System.out.println("Ingresso telepass");
	    	
	    	dbFactory.getDaoIngresso().aggiungiIngressoTelepass(caselloIngresso, targa);
	    	dbFactory.getDaoVeicolo().addTargaAutomobileConTelepass(targa);
      
	}

	
	@Override
	public void ingressoBiglietto(Casello CaselloIngresso) throws IOException {

	        String path = "/Users/universita/eclipse-workspace/GestionePedaggioAutostradale/src/test/biglietti/biglietto.txt";
	
	        File file = new File(path);
	
	        try {
	            file.createNewFile();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	
	        FileWriter fw = new FileWriter(file);
	
	        fw.write("casello : " + CaselloIngresso.getNome() + "\n"); // nome casello
	        fw.write("id : " + CaselloIngresso.getId() + "\n"); // id casello
	        fw.write("autostrada : " +  test.Main.autostrade.getAutostradaById(CaselloIngresso.getIdAutostradaAppartenenza()).getNome() ); // id autostrada appartenenza 
	        fw.flush();
	        fw.close();

	}

    
	@Override
	public float uscitaTelepass(Casello caselloUscita, String targa) throws DatabaseException, FileNotFoundException, IOException {
        	
	        float chilometroIngresso = dbFactory.getDaoIngresso().getChilometroIngressoTelepass(targa);
	        dbFactory.getDaoIngresso().rimuoviIngressoTelepass(targa);
	        dbFactory.getDaoVeicolo().eliminaAutomobileConTelepass(targa);
	
	        Videocamera videocamera = new Videocamera();
	        Veicolo veicolo = videocamera.riconosciVeicolo(targa);
	        Percorso percorso = new Percorso(chilometroIngresso, caselloUscita, veicolo);
	
	        float prezzo = Pedaggio.pedaggio(percorso);
	
	        return Pagamento.paga(prezzo);

	}

	
	@Override
	public float uscitaBiglietto(Casello caselloUscita, String targa) throws IOException{

	        String path = "/Users/universita/eclipse-workspace/GestionePedaggioAutostradale/src/test/biglietti/biglietto.txt";
	        
	        BufferedReader reader = new BufferedReader( new FileReader(path) );
	        
	        reader.readLine();
	        String idCaselloStringa = reader.readLine();
	        reader.readLine();
	        
	        int idCasello = Integer.parseInt( idCaselloStringa.substring(5) );
	        
	        System.out.println("adfs  : " + idCasello);
	        
	        reader.close();
	        
	        float chilometroIngresso = test.Main.autostrade.getAutostradaById( caselloUscita.getIdAutostradaAppartenenza() ).getCaselloById(idCasello).getChilometro();
	
	        Videocamera videocamera = new Videocamera();
	        Veicolo veicolo = videocamera.riconosciVeicolo(targa);
	        Percorso percorso = new Percorso(chilometroIngresso, caselloUscita, veicolo);
	        
	        float prezzo = Pedaggio.pedaggio(percorso);
	
	        return Pagamento.paga(prezzo);
	       
	}


}