package test;
	
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;

import classes.model.Autostrada;
import classes.model.Casello;
import classes.model.ReteAutostradaleItaliana;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

 
public class Main extends Application {
	
	 
	 public static ReteAutostradaleItaliana autostrade = new ReteAutostradaleItaliana();
	 public static Statement statement;
	
	 
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/classes/view/home.fxml"));
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/classes/view/application.css").toExternalForm());
			
			//scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			
			e.printStackTrace();

		}
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		caricaAutostrade();
		caricaTariffeAutostradali();
		caricaCaselli();
		
		launch(args);
		
	}

	

	
	
	
	/**
     * 
     * 
     * 		CARICAMENTO AUTOSTRADE
     * 
     * 
     * @throws SQLException
     */
    public static void caricaAutostrade() throws SQLException {
    	
    	
    	statement = database.DatabaseConnect.connection();
    
    	
        ResultSet rs = statement.executeQuery("SELECT * FROM autostrada");
        
        // avanzamento della statusbar
        //classes.view.SampleController.progress(0.3f);
        
        while(rs.next()) {

            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String cittaUno = rs.getString("citta_uno");
            String cittaDue = rs.getString("citta_due");
            int tipo = rs.getInt("tipo");

            autostrade.aggiungiAutostrada( new Autostrada(id, nome, tipo, cittaUno, cittaDue) );

        } 
        
        //System.out.println("caricamento autostrade utlimato");
       
    	
    }
    
    /**
     * 
     * 
     * 		CARICAMENTO TARIFFE AUTOSTRADALI	
     * 
     * 
     * @throws SQLException
     */
    public static void caricaTariffeAutostradali() throws SQLException {
        
        ResultSet rs = statement.executeQuery("SELECT * FROM tariffa_autostradale");
        
        //classes.view.SampleController.progress(0.6f);
        
        while( rs.next() ) {
        	
        	int id_autostrada = rs.getInt("autostrada_id");
        	float tariffaA = rs.getFloat("tariffaA");
        	float tariffaB = rs.getFloat("tariffaB");
        	float tariffa3 = rs.getFloat("tariffa3");
        	float tariffa4 = rs.getFloat("tariffa4");
        	float tariffa5 = rs.getFloat("tariffa5");
        	
        	autostrade.getAutostradaById(id_autostrada).addTariffa("A", tariffaA);
        	autostrade.getAutostradaById(id_autostrada).addTariffa("B", tariffaB);
        	autostrade.getAutostradaById(id_autostrada).addTariffa("3", tariffa3);
        	autostrade.getAutostradaById(id_autostrada).addTariffa("4", tariffa4);
        	autostrade.getAutostradaById(id_autostrada).addTariffa("5", tariffa5);
        	
        }
        
        //System.out.println("caricamento tariffe ultimato");
    	
    }
    
    
    /**
     * 
     * 
     * 		CARICAMENTO CASELLI
     * 
     * 
     * @throws SQLException
     */
    public static void caricaCaselli() throws SQLException {
	
    	ResultSet rs = statement.executeQuery("SELECT * FROM casello");

        while(rs.next()){
        	
            int id = rs.getInt("id");
            int autostrada_id = rs.getInt("autostrada_id");
            String nome = rs.getString("nome");
            float chilometro = rs.getFloat("chilometro");

            autostrade.getAutostradaById(autostrada_id).addCasello( new Casello(id, nome, autostrade.getAutostradaById(autostrada_id), chilometro) );
            
        }
        
        //System.out.println("caricamento caselli ultimato");
    	
    }
	
	
	
	
	
	
	
	
	
}
