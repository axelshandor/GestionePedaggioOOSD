package interfaces;

import java.io.IOException;

import mvc.model.Casello;
import dao.exceptions.DatabaseException;

public interface Ingresso {
    
    public void ingressoTelepass(Casello caselloINgresso, String targa) throws DatabaseException;
    public void ingressoBiglietto(Casello caselloIngresso) throws IOException;

}