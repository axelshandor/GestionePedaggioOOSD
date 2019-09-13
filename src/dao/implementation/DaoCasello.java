package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mvc.model.Casello;
import dao.exceptions.DatabaseException;
import dao.interfaces.BaseDaoCasello;

public abstract class DaoCasello implements BaseDaoCasello {

	private static final String CASELLO_BY_ID = "SELECT * FROM casello WHERE id = ?;";
	private static final String KM_BY_ID = "SELECT chilometro FROM casello WHERE id = ?;";
	private static final String ADD_CASELLO = "INSERT INTO casello( autostrada_id, nome, chilometro ) VALUES( ?,?,? );";
	private static final String MOD_CASELLO = "UPDATE casello SET autostrada_id = ?, nome = ?, chilometro = ? WHERE id = ?;";
	private static final String CANC_CASELLO = "DELETE FROM casello WHERE id = ?";
	
	@Override
	public Casello getCaselloById( int id ) throws DatabaseException {
		
		Connection conn = getConnection();
		ResultSet rs = null;
		Casello casello = null;
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(CASELLO_BY_ID);
			pStmt.setInt(1, id);
			
			rs = pStmt.executeQuery();
			
			rs.next();
			
			int idCasello = rs.getInt("id");
			String nome = rs.getString("nome");
			int idAutostrada = rs.getInt("autostrada_id");
			float chilometro = rs.getFloat("chilometro");
			
			casello = new Casello(idCasello, nome, idAutostrada, chilometro);
			
			closeConnection(conn, pStmt, rs);
			
		} catch ( SQLException e ) {
			
		}

		return casello;
			
	}
	
	@Override
	public float getKmById( int id ) throws DatabaseException {
		
		Connection conn = getConnection();
		ResultSet rs = null;
		float km = 0;
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(KM_BY_ID);
			pStmt.setInt(1, id);
			
			rs = pStmt.executeQuery();
			
			rs.next();
			
			km = rs.getFloat("chilometro");
			
			closeConnection(conn, pStmt, rs);
			
		} catch ( SQLException e ) {
			
		}

		return km;
		
	}
	
	@Override
	public void addCasello( String nome, int idAutostrada, float chilometro ) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(ADD_CASELLO);
			pStmt.setInt(1, idAutostrada);
			pStmt.setString(2, nome);
			pStmt.setFloat(3, chilometro);
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
			
		}
		
	}
	
	@Override
	public void modificaCasello( int id, int autostrada_id, String nome, float chilometro ) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(MOD_CASELLO);
			pStmt.setInt( 1, autostrada_id );
			pStmt.setString(2, nome);
			pStmt.setFloat(3, chilometro);
			pStmt.setInt(4, id);
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
	
		}
		
	}
	
	@Override
	public void eliminaCaselloById( int id ) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(CANC_CASELLO);
			pStmt.setInt(1, id);
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
			
		}
		
	}

}
