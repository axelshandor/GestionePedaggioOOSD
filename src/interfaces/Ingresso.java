package interfaces;

import java.io.IOException;
import java.sql.SQLException;

import classes.model.Casello;

public interface Ingresso {
    
    public void ingressoTelepass(Casello caselloINgresso, String targa) throws SQLException;
    public void ingressoBiglietto(Casello caselloIngresso) throws IOException;

}