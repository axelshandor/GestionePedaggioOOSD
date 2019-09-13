package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import mvc.model.Autostrada;
import dao.exceptions.DatabaseException;
import dao.interfaces.BaseDaoAutostrada;

public abstract class DaoAutostrada implements BaseDaoAutostrada {
	
	// QUERIES
	private final static String ALL_AUTOSTRADE = "SELECT * FROM autostrada;";
	private final static String TARIFFE_BY_ID = "SELECT * FROM tariffa_autostradale WHERE autostrada_id = ?";
	

	@Override
	public LinkedList<Autostrada> caricaAutostrade() throws DatabaseException {
		
		// creazione dell'ogetto di connessione
		Connection conn = getConnection();
		ResultSet rs = null;
		LinkedList<Autostrada> autostrade = new LinkedList<Autostrada>();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(ALL_AUTOSTRADE);
			rs = pStmt.executeQuery();
			
			while ( rs.next() ) {
				
				int id = rs.getInt("id");
				String nome  = rs.getString("nome");
				String cittaUno = rs.getString("citta_uno");
				String cittaDue = rs.getString("citta_due");
				int tipo = rs.getInt("tipo");
				autostrade.add( new Autostrada(id, nome, tipo, cittaUno, cittaDue) );
				
			}
			
			closeConnection(conn, pStmt, rs);
			
		} catch ( SQLException e ) {
			
			
			
		}
		
		return autostrade;
	}
	
	@Override
	public LinkedList<Float> caricaTariffeById( int id ) throws DatabaseException {
		
		Connection conn = getConnection();
		ResultSet rs = null;
		LinkedList<Float> tariffe = new LinkedList<Float>();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(TARIFFE_BY_ID);
			pStmt.setInt(1, id);
			
			rs = pStmt.executeQuery();
			
			rs.next();
			tariffe.add(rs.getFloat("tariffaA"));
			tariffe.add(rs.getFloat("tariffaB"));
			tariffe.add(rs.getFloat("tariffa3"));
			tariffe.add(rs.getFloat("tariffa4"));
			tariffe.add(rs.getFloat("tariffa5"));
			
			closeConnection(conn, pStmt, rs);
			
		} catch ( SQLException e ) {
			
		}
		
		return tariffe;
		
	}

}
