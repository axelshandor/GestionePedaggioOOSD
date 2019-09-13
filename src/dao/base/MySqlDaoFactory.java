package dao.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.exceptions.DatabaseException;
import dao.implementation.DaoAutostradaMySql;
import dao.implementation.DaoCaselloMySql;
import dao.implementation.DaoIngressoMySql;
import dao.implementation.DaoNormativaMySql;
import dao.implementation.DaoVeicoloMySql;
import dao.interfaces.BaseDaoAutostrada;
import dao.interfaces.BaseDaoCasello;
import dao.interfaces.BaseDaoIngresso;
import dao.interfaces.BaseDaoNormativa;
import dao.interfaces.BaseDaoVeicolo;


public class MySqlDaoFactory extends DaoFactory {

	private static String URL = "jdbc:mysql://localhost:3306/gestione_autostradale";	
	
	public static Connection getConnection() throws DatabaseException {
		
		Connection conn = null;
		
		try {	
			conn = DriverManager.getConnection(URL, "root", "Alessio97");		
		} catch (SQLException e)  {
			// logger ...
			throw new DatabaseException(e.getMessage());
		}
		
		return conn;
		
	}
	
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws DatabaseException {
			
		try  {				
			if (rs != null)  {  rs.close(); }
			if (stmt != null)  { stmt.close(); }
			if (conn != null)  { conn.close(); }
		} catch (SQLException e)  {
			//logger.debug(se.getMessage(),  se);
			throw new DatabaseException(e.toString());
		}
			
	}


	@Override
	public BaseDaoCasello getDaoCasello() {
		return new DaoCaselloMySql();
	}

	@Override
	public BaseDaoAutostrada getDaoAutostrada() {
		return new DaoAutostradaMySql();
	}

	@Override
	public BaseDaoVeicolo getDaoVeicolo() {
		return new DaoVeicoloMySql();
	}

	@Override
	public BaseDaoIngresso getDaoIngresso() {
		return new DaoIngressoMySql();
	}


	@Override
	public BaseDaoNormativa getDaoNormativa() {
		return new DaoNormativaMySql();
	} 
	
}
