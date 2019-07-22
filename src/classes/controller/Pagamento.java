package classes.controller;

import java.util.Scanner;

import classes.model.Carta;


public class Pagamento {

    public static float paga(float prezzo){

        System.out.println("L'importo da pagare è : " + prezzo + " €\n\nSelezionare il tipo di pagamento : Carta o Contanti");

        Scanner tastiera = new Scanner(System.in);

        //String tipoPagamento = tastiera.nextLine();

        /*
        switch(tipoPagamento){
            case "Carta" :
                pagamentoCarta(prezzo);
            break;
            case "Contanti" :
                pagamentoContanti(prezzo);
            break;
        }
		*/
        tastiera.close();

        return prezzo;
        
    }

    public static void pagamentoCarta(float prezzo) {

        System.out.println("Inserire carta per il pagamento : ");
        Carta carta = new Carta("numeroCarta", 2020, 05, "nome", "cognome", 111);
        System.out.println("Pagamento efettuato\n");

    }

    public static void pagamentoContanti(float prezzo) {

        System.out.println("Inserire denaro per il pagamento : ");
        System.out.println("Pagamento efettuato\n");

    }

}
