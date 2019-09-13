package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.exceptions.DatabaseException;
import dao.interfaces.BaseDaoVeicolo;

public abstract class DaoVeicolo implements BaseDaoVeicolo {

	public static final String ADD_AUTO_TELEPASS = "INSERT INTO automobile_con_telepass(targa) VALUES(?)";
	public static final String ELIMINA_AUTO_TELEPASS = "DELETE FROM automobile_con_telepass WHERE targa = ?";
	
	@Override
	public void addTargaAutomobileConTelepass(String targa) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(ADD_AUTO_TELEPASS);
			pStmt.setString(1, targa);
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
			
		}

	}

	@Override
	public void eliminaAutomobileConTelepass(String targa) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(ELIMINA_AUTO_TELEPASS);
			pStmt.setString(1, targa);
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
			
		}

	}

}
