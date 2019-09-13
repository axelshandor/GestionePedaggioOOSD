package dao.interfaces;

import mvc.model.Casello;
import dao.base.BaseDao;
import dao.exceptions.DatabaseException;

public interface BaseDaoCasello extends BaseDao {

	public Casello getCaselloById( int id ) throws DatabaseException;
	public float getKmById( int id ) throws DatabaseException;
	public void addCasello(String nome, int idAutostrada, float chilometro ) throws DatabaseException;
	public void modificaCasello( int id, int autostrada_id, String nome, float chilometro ) throws DatabaseException;
	public void eliminaCaselloById( int id ) throws DatabaseException;
	
}
