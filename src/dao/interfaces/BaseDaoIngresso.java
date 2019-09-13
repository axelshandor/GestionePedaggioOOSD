package dao.interfaces;

import mvc.model.Casello;
import dao.base.BaseDao;
import dao.exceptions.DatabaseException;

public interface BaseDaoIngresso extends BaseDao {

	public void aggiungiIngressoTelepass( Casello caselloIngresso, String targa ) throws DatabaseException;
	public void rimuoviIngressoTelepass( String targa ) throws DatabaseException;
	public float getChilometroIngressoTelepass( String targa ) throws DatabaseException;
	
}
