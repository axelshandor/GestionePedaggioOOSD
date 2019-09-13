package test;
	
import java.sql.SQLException;
import java.util.LinkedList;

import mvc.model.Autostrada;
import mvc.model.ReteAutostradaleItaliana;
import dao.base.DaoFactory;
import dao.exceptions.DatabaseException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

 
public class Main extends Application {
	 
	public static ReteAutostradaleItaliana autostrade = new ReteAutostradaleItaliana();
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("/mvc/view/home.fxml"));
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/mvc/view/application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch(Exception e) {
			
			e.printStackTrace();

		}
	}
	
	
	public static void main(String[] args) throws DatabaseException {
		
		caricaAutostrade();
		caricaTariffeAutostradali();
		
		launch(args);
		
	}

	/**
     * 
     * 
     * 		caricamento autostrade
     * 
     * 
     * @throws SQLException
     */
    public static void caricaAutostrade() throws DatabaseException {
	    
	    LinkedList<Autostrada> listaAutostrade = DaoFactory.getDaoFactory(DaoFactory.MYSQL).getDaoAutostrada().caricaAutostrade();
	    for ( Autostrada a: listaAutostrade ) {	 autostrade.getAutostrade().put(a.getId(), a); }
	    
    }
    
    /**
     * 
     * 
     * 		caricamento tariffe autostradali	
     * 
     * 
     * @throws SQLException
     */
    public static void caricaTariffeAutostradali() throws DatabaseException {
	    
	    DaoFactory dbFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);
	    LinkedList<Float> listaTariffe;
	    
	    for ( int id: autostrade.getAutostrade().keySet() ) {
		    listaTariffe = dbFactory.getDaoAutostrada().caricaTariffeById(id);
		    autostrade.getAutostradaById(id).addTariffe(listaTariffe);
	    }
        	
    }

}
