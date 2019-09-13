package dao.implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.base.MySqlDaoFactory;
import dao.exceptions.DatabaseException;

public class DaoVeicoloMySql extends DaoVeicolo {

	@Override
	public Connection getConnection() throws DatabaseException {
		return MySqlDaoFactory.getConnection();
	}

	@Override
	public void closeConnection( Connection conn, Statement stmt, ResultSet rs ) throws DatabaseException {
		MySqlDaoFactory.closeConnection(conn, stmt, rs);
	}
	
}
