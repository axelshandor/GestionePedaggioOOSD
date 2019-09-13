package dao.base;

import dao.base.MySqlDaoFactory;
import dao.interfaces.BaseDaoAutostrada;
import dao.interfaces.BaseDaoCasello;
import dao.interfaces.BaseDaoIngresso;
import dao.interfaces.BaseDaoNormativa;
import dao.interfaces.BaseDaoVeicolo;

public abstract class DaoFactory {

	public static final int MYSQL = 1;
	
	/*
   	 *	Requisite "Abstract Base Class with Virtual Methods"
     	 *	There will be a method for each DAO that can be
     	 * 	created. The concrete factories will have to implement these methods.
	 */
	
	public abstract BaseDaoCasello getDaoCasello();
	public abstract BaseDaoAutostrada getDaoAutostrada();
	public abstract BaseDaoVeicolo getDaoVeicolo();
	public abstract BaseDaoIngresso getDaoIngresso();
	public abstract BaseDaoNormativa getDaoNormativa();
	    
	/**
	 * 
	 * @param highwayType
	 * @return
	 */
	public static DaoFactory getDaoFactory( int DbmsType )  {
		
		switch ( DbmsType )  {
			case MYSQL:
				return new MySqlDaoFactory();
			// other case
			default:
				return null;
		}
		    
	}
	
}
