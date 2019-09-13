package dao.interfaces;

import java.util.LinkedList;

import mvc.model.Autostrada;
import dao.base.BaseDao;
import dao.exceptions.DatabaseException;

public interface BaseDaoAutostrada extends BaseDao {
	
	public LinkedList<Autostrada> caricaAutostrade() throws DatabaseException;
	public LinkedList<Float> caricaTariffeById( int id ) throws DatabaseException;

}
