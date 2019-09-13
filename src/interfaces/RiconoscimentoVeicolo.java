package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import mvc.model.Veicolo;

public interface RiconoscimentoVeicolo {

    public Veicolo riconosciVeicolo(String targa) throws FileNotFoundException, IOException;

}
