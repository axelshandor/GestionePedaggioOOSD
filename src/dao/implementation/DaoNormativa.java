package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.exceptions.DatabaseException;
import dao.interfaces.BaseDaoNormativa;

public abstract class DaoNormativa implements BaseDaoNormativa {
	
	private static final String AGGIORNA_TARIFFA = "UPDATE tariffa_tipo_autostrada SET tariffa = ? WHERE autostrada_tipo = ?;";
	private static final String AGGIUNGI_TARIFFA = "INSERT INTO tariffa_tipo_autostrada(tariffa, autostrada_tipo) VALUES(?, ?);";

	@Override
	public void aggiornaTariffa(int tipo, float nuovaTariffa) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(AGGIORNA_TARIFFA);
			pStmt.setFloat(1, nuovaTariffa);
			pStmt.setInt(2, tipo);
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
			
		}

	}
	
	@Override
	public void aggiungiTariffa(int tipo, float nuovaTariffa) throws DatabaseException {
		
		Connection conn = getConnection();
		
		try {
			
			PreparedStatement pStmt = conn.prepareStatement(AGGIUNGI_TARIFFA);
			pStmt.setFloat(1, nuovaTariffa);
			pStmt.setInt(2, tipo);
			
			pStmt.execute();
			
			closeConnection(conn, pStmt, null);
			
		} catch ( SQLException e ) {
			
		}
		
	}

}
