package mvc.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import mvc.model.Veicolo;
import interfaces.RiconoscimentoVeicolo;

public class Videocamera implements RiconoscimentoVeicolo {


    public Veicolo riconosciVeicolo(String targa) throws FileNotFoundException, IOException {

        String path = "/Users/universita/eclipse-workspace/GestionePedaggioAutostradale/src/test/libretti/" + targa + ".txt";

        BufferedReader reader = new BufferedReader( new FileReader(path) );

        String modello = reader.readLine();
        String marca = reader.readLine();
        int anno = Integer.parseInt( reader.readLine() );
        reader.readLine();
        int assi = Integer.parseInt( reader.readLine() );
        float peso = Float.parseFloat( reader.readLine() );
        float altezza = Float.parseFloat( reader.readLine() );
        int classeAmbientale = Integer.parseInt( reader.readLine() );

        reader.close();

        return Normativa.creaVeicolo(modello, marca, anno, targa, assi, peso, altezza, classeAmbientale);

    }

    

}