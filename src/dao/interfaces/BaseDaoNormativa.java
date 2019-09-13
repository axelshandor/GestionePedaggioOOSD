package dao.interfaces;

import dao.base.BaseDao;
import dao.exceptions.DatabaseException;

public interface BaseDaoNormativa extends BaseDao {
	
	public void aggiornaTariffa(int tipo, float nuovaTariffa) throws DatabaseException;
	public void aggiungiTariffa(int tipo, float nuovaTariffa) throws DatabaseException;

}
