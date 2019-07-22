package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import classes.model.Casello;

public interface Uscita {
    
    public float uscitaTelepass(Casello caselloUscita, String targa) throws SQLException, FileNotFoundException, IOException;
    public float uscitaBiglietto(Casello caselloUscita, String targa) throws FileNotFoundException, IOException, SQLException;

}