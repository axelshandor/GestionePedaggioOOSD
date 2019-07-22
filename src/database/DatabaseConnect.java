package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnect {

    
    public static Statement connection() throws SQLException {
    	
    	Connection conn = null;
        
        try {

        	String url = "jdbc:mysql://localhost:3306/gestione_autostradale";
            String user = "root";
            String password = "Alessio97";

            conn = DriverManager.getConnection(url, user, password);

            if (conn != null) {
                //System.out.println("Connected");
            }

        } catch(SQLException ex) {

            System.out.println("Si è presentato un errore. Forse utente/password sono errati");
            ex.printStackTrace();

        }
        
        return conn.createStatement();
    	
    }
    
}