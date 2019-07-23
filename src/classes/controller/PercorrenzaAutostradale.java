package classes.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

import classes.controller.Pedaggio;
import classes.model.Casello;
import classes.model.Percorso;
import classes.model.Veicolo;

public class PercorrenzaAutostradale implements interfaces.Ingresso, interfaces.Uscita {

    @Override
    public void ingressoTelepass(Casello caselloIngresso, String targa) throws SQLException {

    	System.out.println("Ingresso telepass");
    	
    	test.Main.statement = database.DatabaseConnect.connection();
    	
    	String query1 = "INSERT INTO automobile_con_telepass values('" + targa + "');";
        String query2 = "INSERT INTO ingresso_telepass values('" + targa + "', " + caselloIngresso.getId() + " );";

        test.Main.statement.execute(query1);
        test.Main.statement.execute(query2);

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
        fw.write("autostrada : " + CaselloIngresso.getAutostradaAppartenenza().getNome()); // nome autostrada
        fw.flush();
        fw.close();

    }

    
    @Override
    public float uscitaTelepass(Casello caselloUscita, String targa) throws SQLException, FileNotFoundException, IOException {
    	
    	test.Main.statement = database.DatabaseConnect.connection();
        	
        ResultSet rs = test.Main.statement.executeQuery("SELECT * FROM casello INNER JOIN ingresso_telepass ON casello.id = ingresso_telepass.casello_id WHERE automobile_telepass_targa  = '" + targa + "';");
        
        rs.next();
        float chilometroIngresso = rs.getFloat("chilometro");
        
        String query1 = "DELETE FROM ingresso_telepass WHERE automobile_telepass_targa = '" + targa + "';" ;

        String query2 = "DELETE FROM automobile_con_telepass WHERE targa = '" + targa + "';";

        test.Main.statement.execute(query1);

        test.Main.statement.execute(query2);

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
        
        float chilometroIngresso = test.Main.autostrade.getAutostradaById( caselloUscita.getAutostradaAppartenenza().getId() ).getCaselloById(idCasello).getChilometro();

        Videocamera videocamera = new Videocamera();
        
        Veicolo veicolo = videocamera.riconosciVeicolo(targa);

        Percorso percorso = new Percorso(chilometroIngresso, caselloUscita, veicolo);
        
        float prezzo = Pedaggio.pedaggio(percorso);

        return Pagamento.paga(prezzo);
       
    }


}