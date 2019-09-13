package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.model.Casello;
import dao.exceptions.DatabaseException;
import dao.interfaces.BaseDaoIngresso;

public abstract class DaoIngresso implements BaseDaoIngresso {
	
	public static final String ADD_INGRESSO_TELEPASS = "INSERT INTO ingresso_telepass( automobile_telepass_targa, chilometro_ingresso, casello_id  ) VALUES( ?, ?, ? );";
	public static final String ELIMINA_INGRESSO_TELEPASS = "DELETE FROM ingresso_telepass WHERE automobile_targa_telepass = ?;";
	public static final String CHILOMETRO_INGRESSO = "SELECT * FROM ingresso_telepass WHERE automobile_telepass_targa = ?;";

	@Override
	public void aggiungiIngressoTelepass(Casello caselloIngresso, String targa) throws DatabaseException {

		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(ADD_INGRESSO_TELEPASS);
			pStmt.setString(1, targa);
			pStmt.setFloat(2, caselloIngresso.getChilometro());
			pStmt.setInt(3, caselloIngresso.getId());
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
			
		}

	}

	
	@Override
	public void rimuoviIngressoTelepass(String targa) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(ELIMINA_INGRESSO_TELEPASS);
			pStmt.setString(1, targa);
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		}catch (SQLException e ) {
			
		}

	}
	
	
	@Override
	public float getChilometroIngressoTelepass( String targa ) throws DatabaseException {
		
		Connection conn = getConnection();
		ResultSet rs = null;
		float chilometro = 0;
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(CHILOMETRO_INGRESSO);
			pStmt.setString(1, targa);
			
			rs = pStmt.executeQuery();
			rs.next();
			
			chilometro = rs.getFloat("chilometro_ingresso");
			
			closeConnection(conn, pStmt, rs);
			
		} catch ( SQLException e ) {
			System.out.print("ERRORE");
		}
		
		return chilometro;
		
	}

}
