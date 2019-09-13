package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import mvc.model.Casello;
import dao.exceptions.DatabaseException;

public interface Uscita {
    
    public float uscitaTelepass(Casello caselloUscita, String targa) throws DatabaseException, FileNotFoundException, IOException;
    public float uscitaBiglietto(Casello caselloUscita, String targa) throws FileNotFoundException, IOException, SQLException;

}