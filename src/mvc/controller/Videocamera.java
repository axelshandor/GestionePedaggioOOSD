package mvc.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import mvc.model.Veicolo;
import interfaces.RiconoscimentoVeicolo;

public class Videocamera implements RiconoscimentoVeicolo {


    public Veicolo riconosciVeicolo(String targa) throws FileNotFoundException, IOException {
    	
    	System.out.println("6.1");

        String path = "/Users/universita/eclipse-workspace/GestionePedaggioAutostradale/src/test/libretti/" + targa + ".txt";
        
        System.out.println("6.2");

        BufferedReader reader = new BufferedReader( new FileReader(path) );
        
        System.out.println("6.3");

        String modello = reader.readLine();
        String marca = reader.readLine();
        int anno = Integer.parseInt( reader.readLine() );
        reader.readLine();
        int assi = Integer.parseInt( reader.readLine() );
        float peso = Float.parseFloat( reader.readLine() );
        float altezza = Float.parseFloat( reader.readLine() );
        int classeAmbientale = Integer.parseInt( reader.readLine() );

        reader.close();
        
        System.out.println("6.4");

        return Normativa.creaVeicolo(modello, marca, anno, targa, assi, peso, altezza, classeAmbientale);

    }

    

}