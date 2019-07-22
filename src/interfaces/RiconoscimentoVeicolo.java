package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import classes.model.Veicolo;

public interface RiconoscimentoVeicolo {

    public Veicolo riconosciVeicolo(String targa) throws FileNotFoundException, IOException;

}
