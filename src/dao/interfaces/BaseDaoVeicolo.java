package dao.interfaces;

import dao.base.BaseDao;
import dao.exceptions.DatabaseException;

public interface BaseDaoVeicolo extends BaseDao {

	public void addTargaAutomobileConTelepass( String targa ) throws DatabaseException;
	public void eliminaAutomobileConTelepass( String targa ) throws DatabaseException;
	
}
