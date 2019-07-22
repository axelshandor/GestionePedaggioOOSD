package classes.model;

import java.util.HashMap;

public class ReteAutostradaleItaliana {

    private HashMap<Integer, Autostrada> autostradeItaliane = new HashMap<Integer, Autostrada>();

    public Autostrada getAutostradaById(int id){
        return autostradeItaliane.get(id);
    }

    public HashMap<Integer, Autostrada> getAutostrade(){

        return this.autostradeItaliane;
        
    }

    public void aggiungiAutostrada(Autostrada autostrada){

        autostradeItaliane.put(autostrada.getId(), autostrada);

    }

}