package mvc.controller.viewer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import mvc.controller.PercorrenzaAutostradale;
import mvc.controller.Videocamera;
import mvc.model.Casello;
import mvc.model.Veicolo;
import dao.base.DaoFactory;
import dao.exceptions.DatabaseException;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;

public class HomeController implements Initializable {

	// ATTRIBUTI

	private DaoFactory dbFactory = DaoFactory.getDaoFactory(DaoFactory.MYSQL);

	Videocamera videocamera = new Videocamera();
	Veicolo v;
	String targa;

	int idAutostrada;
	int idAutostradaModificaCasello;
	int idAutostradaAggiuntaCasello;
	int idCaselloIngresso;
	int idCaselloUscita;
	int idCaselloModifica;
	int idCaselloElimina;

	boolean ingresso;


	// ATTRIBUTI FXML

	@FXML
	private Button btnAA000AA;

	@FXML
	private Button btnAA001AA;

	@FXML
	private Button btnAA002AA;

	@FXML
	private Button btnAA003AA;

	@FXML
	private Button btnAA004AA;

	@FXML
	private Label labelVeicolo;

	@FXML
	private Button btnAA005AA;

	@FXML
	private Button btnModificaCasello;

	@FXML
	private Button btnAggiungiCasello;

	@FXML
	private Button btnClose;

	@FXML
	private Button btnStart;

	@FXML
	private SplitMenuButton sceltaTipoIngresso;

	@FXML
	private MenuItem sceltaTelepass;

	@FXML
	private MenuItem sceltaBiglietto;

	@FXML
	private SplitMenuButton sceltaAutostrada;
	
	@FXML
	private SplitMenuButton sceltaAutostradaAggiuntaCasello;

	@FXML
	private MenuItem autostrada1;

	@FXML
	private MenuItem autostrada2;

	@FXML
	private MenuItem autostrada3;

	@FXML
	private MenuItem autostrada4;

	@FXML
	private MenuItem autostrada5;

	@FXML
	private SplitMenuButton sceltaCaselloUscita;

	@FXML
	private SplitMenuButton sceltaCaselloIngresso;
	
	@FXML
	private SplitMenuButton sceltaCaselloModifica;

	@FXML
	private MenuItem casello1;
	
	@FXML
	private MenuItem casello1Modifica;

	@FXML
	private MenuItem casello2;
	
	@FXML
	private MenuItem casello2Modifica;

	@FXML
	private MenuItem casello3;
	
	@FXML
	private MenuItem casello3Modifica;

	@FXML
	private MenuItem casello4;
	
	@FXML
	private MenuItem casello4Modifica;

	@FXML
	private MenuItem casello5;

	@FXML
	private MenuItem casello5Modifica;
	
	@FXML
	private MenuItem casello6;
	
	@FXML
	private MenuItem casello6Modifica;

	@FXML
	private MenuItem casello7;
	
	@FXML
	private MenuItem casello7Modifica;

	@FXML
	private MenuItem casello8;
	
	@FXML
	private MenuItem casello8Modifica;

	@FXML
	private MenuItem casello9;
	
	@FXML
	private MenuItem casello9Modifica;

	@FXML
	private MenuItem casello10;
	
	@FXML
	private MenuItem casello10Modifica;

	@FXML
	private MenuItem casello11;
	
	@FXML
	private MenuItem casello11Modifica;

	@FXML
	private MenuItem casello12;
	
	@FXML
	private MenuItem casello12Modifica;

	@FXML
	private MenuItem casello13;
	
	@FXML
	private MenuItem casello13Modifica;

	@FXML
	private MenuItem casello14;
	
	@FXML
	private MenuItem casello14Modifica;

	@FXML
	private MenuItem casello15;
	
	@FXML
	private MenuItem casello15Modifica;

	@FXML
	private MenuItem casello1u;

	@FXML
	private MenuItem casello2u;

	@FXML
	private MenuItem casello3u;

	@FXML
	private MenuItem casello4u;

	@FXML
	private MenuItem casello5u;

	@FXML
	private MenuItem casello6u;

	@FXML
	private MenuItem casello7u;

	@FXML
	private MenuItem casello8u;

	@FXML
	private MenuItem casello9u;

	@FXML
	private MenuItem casello10u;

	@FXML
	private MenuItem casello11u;

	@FXML
	private MenuItem casello12u;

	@FXML
	private MenuItem casello13u;

	@FXML
	private MenuItem casello14u;

	@FXML
	private MenuItem casello15u;
	
	@FXML
	private MenuItem casello1Elimina;
	
	@FXML
	private MenuItem casello2Elimina;
	
	@FXML
	private MenuItem casello3Elimina;
	
	@FXML
	private MenuItem casello4Elimina;
	
	@FXML
	private MenuItem casello5Elimina;
	
	@FXML
	private MenuItem casello6Elimina;
	
	@FXML
	private MenuItem casello7Elimina;
	
	@FXML
	private MenuItem casello8Elimina;
	
	@FXML
	private MenuItem casello9Elimina;
	
	@FXML
	private MenuItem casello10Elimina;
	
	@FXML
	private MenuItem casello11Elimina;
	
	@FXML
	private MenuItem casello12Elimina;
	
	@FXML
	private MenuItem casello13Elimina;
	
	@FXML
	private MenuItem casello14Elimina;
	
	@FXML
	private MenuItem casello15Elimina;
	
	@FXML
	private MenuItem autostradaAggiuntaCasello1;
	
	@FXML
	private MenuItem autostradaAggiuntaCasello2;
	
	@FXML
	private MenuItem autostradaAggiuntaCasello3;
	
	@FXML
	private MenuItem autostradaAggiuntaCasello4;
	
	@FXML
	private MenuItem autostradaAggiuntaCasello5;
	
	@FXML
	private SplitMenuButton sceltaCaselloEliminazione;

	@FXML
	private AnchorPane pannelloPedaggio;

	@FXML
	private AnchorPane pannelloModificaCasello;
	
	@FXML
	private AnchorPane pannelloAggiungiCasello;

	@FXML
	private Label labelPedaggio;

	@FXML
	private AnchorPane pannelloBase;
	
	@FXML
	private AnchorPane pannelloAggiuntaCasello;

	@FXML
	private Button btnCloseErrore;
	
	@FXML
	private Button btnModifica;
	
	@FXML
	private Button btnElimina;

	@FXML
	private Label labelErrore;
	
	@FXML
	private TextField labelChilometroCaselloModifica;
	
	@FXML
	private TextField labelNomeCaselloModifica;
	
	@FXML
	private TextField labelAutostradaIdCaselloModifica;
	
	@FXML
	private TextField labelNomeCaselloAggiunta;
	
	@FXML
	private TextField labelChilometroCaselloAggiunta;
	
	@FXML
	private Button btnAggiungi;

	//  METODI

	@FXML
	void clickBtnAA000AA(Event event) throws FileNotFoundException, IOException {

		targa = "AA000AA";
		v = videocamera.riconosciVeicolo("AA000AA");

		labelVeicolo.setText("marca : " + v.getMarca() + " \nmodello : " + v.getModello() + "\nassi : " + v.getNumeroAssi() + "\naltezza : " + v.getAltezza());

		sceltaAutostrada.setDisable(false);

	}

	@FXML
	void clickBtnAA001AA(Event event) throws FileNotFoundException, IOException {

		targa = "AA001AA";
		v = videocamera.riconosciVeicolo("AA001AA");

		labelVeicolo.setText("marca : " + v.getMarca() + " \nmodello : " + v.getModello() + "\nassi : " + v.getNumeroAssi() + "\naltezza : " + v.getAltezza());

		sceltaAutostrada.setDisable(false);

	}

	@FXML
	void clickBtnAA002AA(Event event) throws FileNotFoundException, IOException {

		targa = "AA002AA";
		v = videocamera.riconosciVeicolo("AA002AA");

		labelVeicolo.setText("marca : " + v.getMarca() + " \nmodello : " + v.getModello() + "\nassi : " + v.getNumeroAssi() + "\naltezza : " + v.getAltezza());

		sceltaAutostrada.setDisable(false);

	}

	@FXML
	void clickBtnAA003AA(Event event) throws FileNotFoundException, IOException {

		targa = "AA003AA";
		v = videocamera.riconosciVeicolo("AA003AA");

		labelVeicolo.setText("marca : " + v.getMarca() + " \nmodello : " + v.getModello() + "\nassi : " + v.getNumeroAssi() + "\naltezza : " + v.getAltezza());

		sceltaAutostrada.setDisable(false);

	}

	@FXML
	void clickBtnAA004AA(Event event) throws FileNotFoundException, IOException {

		targa = "AA004AA";
		v = videocamera.riconosciVeicolo("AA004AA");

		labelVeicolo.setText("marca : " + v.getMarca() + " \nmodello : " + v.getModello() + "\nassi : " + v.getNumeroAssi() + "\naltezza : " + v.getAltezza());

		sceltaAutostrada.setDisable(false);

	}

	@FXML
	void clickBtnAA005AA(Event event) throws FileNotFoundException, IOException {

		targa = "AA005AA";
		v = videocamera.riconosciVeicolo("AA005AA");

		labelVeicolo.setText("marca : " + v.getMarca() + " \nmodello : " + v.getModello() + "\nassi : " + v.getNumeroAssi() + "\naltezza : " + v.getAltezza());

		sceltaAutostrada.setDisable(false);

	}

	@FXML
	void clickBtnModificaCasello(Event event) {

		pannelloBase.setDisable(true);
		pannelloModificaCasello.setVisible(true);

	}

	@FXML
	void clickBtnAggiungiCasello(Event event) {

		pannelloBase.setDisable(true);
		pannelloAggiungiCasello.setVisible(true);
		
	}

	@FXML
	void clickStart(Event event) throws IOException, DatabaseException {

		PercorrenzaAutostradale percorrenza = new PercorrenzaAutostradale();
		Float prezzo;

		// controlliamo che i caselli scelti siano stati già caricato, altrimenti li carichiamo
		if ( !( test.Main.autostrade.getAutostradaById(idAutostrada).getCaselli().containsKey(idCaselloIngresso)) ) {
			Casello casello = dbFactory.getDaoCasello().getCaselloById(idCaselloIngresso);
			test.Main.autostrade.getAutostradaById(idAutostrada).addCasello(casello);
		}
		if ( !( test.Main.autostrade.getAutostradaById(idAutostrada).getCaselli().containsKey(idCaselloUscita)) ) {
			Casello casello = dbFactory.getDaoCasello().getCaselloById(idCaselloUscita);
			test.Main.autostrade.getAutostradaById(idAutostrada).addCasello(casello);
		}

		if ( ingresso ) {	

			// biglietto
			percorrenza.ingressoBiglietto( test.Main.autostrade.getAutostradaById(idAutostrada).getCaselloById(idCaselloIngresso) );
			prezzo = percorrenza.uscitaBiglietto( test.Main.autostrade.getAutostradaById(idAutostrada).getCaselloById(idCaselloUscita), targa );

		} else {

			// telepass
			percorrenza.ingressoTelepass( test.Main.autostrade.getAutostradaById(idAutostrada).getCaselloById(idCaselloIngresso), targa  );
			prezzo = percorrenza.uscitaTelepass( test.Main.autostrade.getAutostradaById(idAutostrada).getCaselloById(idCaselloUscita), targa );


		}

		labelPedaggio.setText(prezzo.toString() + " €");
		pannelloBase.setDisable(true);
		pannelloPedaggio.setVisible(true);

	}


	@FXML
	void clickTelepass(Event event) {

		ingresso = false;
		sceltaTipoIngresso.setText("telepass");

		btnStart.setDisable(false);

	}

	@FXML
	void clickBiglietto(Event event) {

		ingresso = true;
		sceltaTipoIngresso.setText("biglietto");

		btnStart.setDisable(false);

	}

	@FXML
	void closeApplication(Event event) {

		Platform.exit();

	}

	@FXML
	void clickAutostrada1(Event event) {

		idAutostrada = 1;
		sceltaAutostrada.setText(autostrada1.getText());

		casello1.setVisible(true);
		casello2.setVisible(true);
		casello3.setVisible(true);
		casello1u.setVisible(true);
		casello2u.setVisible(true);
		casello3u.setVisible(true);

		casello4.setVisible(false);
		casello5.setVisible(false);
		casello6.setVisible(false);
		casello4u.setVisible(false);
		casello5u.setVisible(false);
		casello6u.setVisible(false);
		casello7.setVisible(false);
		casello8.setVisible(false);
		casello9.setVisible(false);
		casello7u.setVisible(false);
		casello8u.setVisible(false);
		casello9u.setVisible(false);
		casello10.setVisible(false);
		casello11.setVisible(false);
		casello12.setVisible(false);
		casello10u.setVisible(false);
		casello11u.setVisible(false);
		casello12u.setVisible(false);
		casello13.setVisible(false);
		casello14.setVisible(false);
		casello15.setVisible(false);
		casello13u.setVisible(false);
		casello14u.setVisible(false);
		casello15u.setVisible(false);

		sceltaCaselloIngresso.setDisable(false);

	}

	@FXML
	void clickAutostrada2(Event event) {

		idAutostrada = 2;
		sceltaAutostrada.setText(autostrada2.getText());

		casello1.setVisible(false);
		casello2.setVisible(false);
		casello3.setVisible(false);
		casello1u.setVisible(false);
		casello2u.setVisible(false);
		casello3u.setVisible(false);

		casello4.setVisible(true);
		casello5.setVisible(true);
		casello6.setVisible(true);
		casello4u.setVisible(true);
		casello5u.setVisible(true);
		casello6u.setVisible(true);

		casello7.setVisible(false);
		casello8.setVisible(false);
		casello9.setVisible(false);
		casello7u.setVisible(false);
		casello8u.setVisible(false);
		casello9u.setVisible(false);
		casello10.setVisible(false);
		casello11.setVisible(false);
		casello12.setVisible(false);
		casello10u.setVisible(false);
		casello11u.setVisible(false);
		casello12u.setVisible(false);
		casello13.setVisible(false);
		casello14.setVisible(false);
		casello15.setVisible(false);
		casello13u.setVisible(false);
		casello14u.setVisible(false);
		casello15u.setVisible(false);

		sceltaCaselloIngresso.setDisable(false);

	}

	@FXML
	void clickAutostrada3(Event event) {

		idAutostrada = 3;
		sceltaAutostrada.setText(autostrada3.getText());

		casello1.setVisible(false);
		casello2.setVisible(false);
		casello3.setVisible(false);
		casello1u.setVisible(false);
		casello2u.setVisible(false);
		casello3u.setVisible(false);
		casello4.setVisible(false);
		casello5.setVisible(false);
		casello6.setVisible(false);
		casello4u.setVisible(false);
		casello5u.setVisible(false);
		casello6u.setVisible(false);

		casello7.setVisible(true);
		casello8.setVisible(true);
		casello9.setVisible(true);
		casello7u.setVisible(true);
		casello8u.setVisible(true);
		casello9u.setVisible(true);

		casello10.setVisible(false);
		casello11.setVisible(false);
		casello12.setVisible(false);
		casello10u.setVisible(false);
		casello11u.setVisible(false);
		casello12u.setVisible(false);
		casello13.setVisible(false);
		casello14.setVisible(false);
		casello15.setVisible(false);
		casello13u.setVisible(false);
		casello14u.setVisible(false);
		casello15u.setVisible(false);

		sceltaCaselloIngresso.setDisable(false);

	}

	@FXML
	void clickAutostrada4(Event event) {

		idAutostrada = 4;
		sceltaAutostrada.setText(autostrada4.getText());

		casello1.setVisible(false);
		casello2.setVisible(false);
		casello3.setVisible(false);
		casello1u.setVisible(false);
		casello2u.setVisible(false);
		casello3u.setVisible(false);
		casello4.setVisible(false);
		casello5.setVisible(false);
		casello6.setVisible(false);
		casello4u.setVisible(false);
		casello5u.setVisible(false);
		casello6u.setVisible(false);
		casello7.setVisible(false);
		casello8.setVisible(false);
		casello9.setVisible(false);
		casello7u.setVisible(false);
		casello8u.setVisible(false);
		casello9u.setVisible(false);

		casello10.setVisible(true);
		casello11.setVisible(true);
		casello12.setVisible(true);
		casello10u.setVisible(true);
		casello11u.setVisible(true);
		casello12u.setVisible(true);

		casello13.setVisible(false);
		casello14.setVisible(false);
		casello15.setVisible(false);
		casello13u.setVisible(false);
		casello14u.setVisible(false);
		casello15u.setVisible(false);

		sceltaCaselloIngresso.setDisable(false);

	}

	@FXML
	void clickAutostrada5(Event event) {

		idAutostrada = 5;
		sceltaAutostrada.setText(autostrada5.getText());

		casello1.setVisible(false);
		casello2.setVisible(false);
		casello3.setVisible(false);
		casello1u.setVisible(false);
		casello2u.setVisible(false);
		casello3u.setVisible(false);
		casello4.setVisible(false);
		casello5.setVisible(false);
		casello6.setVisible(false);
		casello4u.setVisible(false);
		casello5u.setVisible(false);
		casello6u.setVisible(false);
		casello7.setVisible(false);
		casello8.setVisible(false);
		casello9.setVisible(false);
		casello7u.setVisible(false);
		casello8u.setVisible(false);
		casello9u.setVisible(false);
		casello10.setVisible(false);
		casello11.setVisible(false);
		casello12.setVisible(false);
		casello10u.setVisible(false);
		casello11u.setVisible(false);
		casello12u.setVisible(false);

		casello13.setVisible(true);
		casello14.setVisible(true);
		casello15.setVisible(true);
		casello13u.setVisible(true);
		casello14u.setVisible(true);
		casello15u.setVisible(true);

		sceltaCaselloIngresso.setDisable(false);

	}


	@FXML
	void clickCasello1(Event event) {

		idCaselloIngresso = 1;
		sceltaCaselloIngresso.setText(casello1.getText());

		casello1u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello1Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 1;
		sceltaCaselloModifica.setText(casello1Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello2(Event event) {

		idCaselloIngresso = 2;
		sceltaCaselloIngresso.setText(casello2.getText());

		casello2u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello2Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 2;
		sceltaCaselloModifica.setText(casello2Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello3(Event event) {

		idCaselloIngresso = 3;
		sceltaCaselloIngresso.setText(casello3.getText());

		casello3u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello3Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 3;
		sceltaCaselloModifica.setText(casello3Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello4(Event event) {

		idCaselloIngresso = 4;
		sceltaCaselloIngresso.setText(casello4.getText());

		casello4u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello4Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 4;
		sceltaCaselloModifica.setText(casello4Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello5(Event event) {

		idCaselloIngresso = 5;
		sceltaCaselloIngresso.setText(casello5.getText());

		casello5u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello5Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 5;
		sceltaCaselloModifica.setText(casello5Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello6(Event event) {

		idCaselloIngresso = 6;
		sceltaCaselloIngresso.setText(casello6.getText());

		casello6u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello6Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 6;
		sceltaCaselloModifica.setText(casello6Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello7(Event event) {

		idCaselloIngresso = 7;
		sceltaCaselloIngresso.setText(casello7.getText());

		casello7u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello7Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 7;
		sceltaCaselloModifica.setText(casello7Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello8(Event event) {

		idCaselloIngresso = 8;
		sceltaCaselloIngresso.setText(casello8.getText());

		casello8u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello8Modifica(Event event) throws DatabaseException {
	
		idCaselloModifica = 8;
		sceltaCaselloModifica.setText(casello8Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello9(Event event) {

		idCaselloIngresso = 9;
		sceltaCaselloIngresso.setText(casello9.getText());

		casello9u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello9Modifica(Event event) throws DatabaseException {
	
		idCaselloModifica = 9;
		sceltaCaselloModifica.setText(casello9Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello10(Event event) {

		idCaselloIngresso = 10;
		sceltaCaselloIngresso.setText(casello10.getText());

		casello10u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello10Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 10;
		sceltaCaselloModifica.setText(casello10Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello11(Event event) {

		idCaselloIngresso = 11;
		sceltaCaselloIngresso.setText(casello11.getText());

		casello11u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello11Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 11;
		sceltaCaselloModifica.setText(casello11Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello12(Event event) {

		idCaselloIngresso = 12;
		sceltaCaselloIngresso.setText(casello12.getText());

		casello12u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello12Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 12;
		sceltaCaselloModifica.setText(casello12Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello13(Event event) {

		idCaselloIngresso = 13;
		sceltaCaselloIngresso.setText(casello13.getText());

		casello13u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello13Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 13;
		sceltaCaselloModifica.setText(casello13Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello14(Event event) {

		idCaselloIngresso = 14;
		sceltaCaselloIngresso.setText(casello14.getText());

		casello14u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello14Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 14;
		sceltaCaselloModifica.setText(casello14Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}

	@FXML
	void clickCasello15(Event event) {

		idCaselloIngresso = 15;
		sceltaCaselloIngresso.setText(casello15.getText());

		casello15u.setVisible(false);

		sceltaCaselloUscita.setDisable(false);

	}
	
	@FXML
	void clickCasello15Modifica(Event event) throws DatabaseException {
		
		idCaselloModifica = 15;
		sceltaCaselloModifica.setText(casello15Modifica.getText());
		
		Casello casello = dbFactory.getDaoCasello().getCaselloById( idCaselloModifica );
		labelNomeCaselloModifica.setText( casello.getNome() );
		labelChilometroCaselloModifica.setText( new Float( casello.getChilometro() ).toString() );
		labelAutostradaIdCaselloModifica.setText( new Integer( casello.getIdAutostradaAppartenenza() ).toString() );
		
	}
	
	@FXML
	void clickCasello1Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 1;
		sceltaCaselloEliminazione.setText(casello1Elimina.getText());
		
	}
	
	@FXML
	void clickCasello2Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 2;
		sceltaCaselloEliminazione.setText(casello2Elimina.getText());
		
	}
	
	@FXML
	void clickCasello3Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 3;
		sceltaCaselloEliminazione.setText(casello3Elimina.getText());
		
	}
	
	@FXML
	void clickCasello4Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 4;
		sceltaCaselloEliminazione.setText(casello4Elimina.getText());
		
	}
	
	@FXML
	void clickCasello5Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 5;
		sceltaCaselloEliminazione.setText(casello5Elimina.getText());
		
	}
	
	@FXML
	void clickCasello6Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 6;
		sceltaCaselloEliminazione.setText(casello6Elimina.getText());
		
	}
	
	@FXML
	void clickCasello7Elimina(Event event) throws DatabaseException {
			
		idCaselloElimina = 7;
		sceltaCaselloEliminazione.setText(casello7Elimina.getText());
	
	}
	
	@FXML
	void clickCasello8Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 8;
		sceltaCaselloEliminazione.setText(casello8Elimina.getText());
		
	}
	
	@FXML
	void clickCasello9Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 9;
		sceltaCaselloEliminazione.setText(casello9Elimina.getText());
		
	}
	
	@FXML
	void clickCasello10Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 10;
		sceltaCaselloEliminazione.setText(casello10Elimina.getText());
		
	}
	
	@FXML
	void clickCasello11Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 11;
		sceltaCaselloEliminazione.setText(casello11Elimina.getText());
		
	}
	
	@FXML
	void clickCasello12Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 12;
		sceltaCaselloEliminazione.setText(casello12Elimina.getText());
		
	}
	
	@FXML
	void clickCasello13Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 13;
		sceltaCaselloEliminazione.setText(casello13Elimina.getText());
		
	}
	
	@FXML
	void clickCasello14Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 14;
		sceltaCaselloEliminazione.setText(casello14Elimina.getText());
		
	}
	
	@FXML
	void clickCasello15Elimina(Event event) throws DatabaseException {
		
		idCaselloElimina = 15;
		sceltaCaselloEliminazione.setText(casello15Elimina.getText());
		
	}


	@FXML
	void clickCasello1u(Event event) {

		idCaselloUscita = 1;
		sceltaCaselloUscita.setText(casello1u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello2u(Event event) {

		idCaselloUscita = 2;
		sceltaCaselloUscita.setText(casello2u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello3u(Event event) {

		idCaselloUscita = 3;
		sceltaCaselloUscita.setText(casello3u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello4u(Event event) {

		idCaselloUscita = 4;
		sceltaCaselloUscita.setText(casello4u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello5u(Event event) {

		idCaselloUscita = 5;
		sceltaCaselloUscita.setText(casello5u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello6u(Event event) {

		idCaselloUscita = 6;
		sceltaCaselloUscita.setText(casello6u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello7u(Event event) {

		idCaselloUscita = 7;
		sceltaCaselloUscita.setText(casello7u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello8u(Event event) {

		idCaselloUscita = 8;
		sceltaCaselloUscita.setText(casello8u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello9u(Event event) {

		idCaselloUscita = 9;
		sceltaCaselloUscita.setText(casello9u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello10u(Event event) {

		idCaselloUscita = 10;
		sceltaCaselloUscita.setText(casello10u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello11u(Event event) {

		idCaselloUscita = 11;
		sceltaCaselloUscita.setText(casello11u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello12u(Event event) {

		idCaselloUscita = 12;
		sceltaCaselloUscita.setText(casello12u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello13u(Event event) {

		idCaselloUscita = 13;
		sceltaCaselloUscita.setText(casello13u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello14u(Event event) {

		idCaselloUscita = 14;
		sceltaCaselloUscita.setText(casello14u.getText());

		sceltaTipoIngresso.setDisable(false);

	}

	@FXML
	void clickCasello15u(Event event) {

		idCaselloUscita = 15;
		sceltaCaselloUscita.setText(casello15u.getText());

		sceltaTipoIngresso.setDisable(false);


	}

	@FXML
	void clickModifica(Event event) throws DatabaseException {
		
		String nuovoNome = labelNomeCaselloModifica.getText();
		float chilometro = Float.parseFloat( labelChilometroCaselloModifica.getText() );  
		int autostrada_id = Integer.parseInt( labelAutostradaIdCaselloModifica.getText() ); 
		
		dbFactory.getDaoCasello().modificaCasello(idCaselloModifica, autostrada_id, nuovoNome, chilometro);
		
		pannelloModificaCasello.setVisible(false);
		pannelloBase.setDisable(false);
		
	}
	
	@FXML
	void clickBtnElimina(Event event) throws DatabaseException {
		
		dbFactory.getDaoCasello().eliminaCaselloById(idCaselloElimina);
		
		pannelloAggiungiCasello.setVisible(false);
		pannelloBase.setDisable(false);
		
	}
	
	@FXML
	void clickAutostradaAggiunta1(Event event) throws DatabaseException {
		
		idAutostradaAggiuntaCasello = 1;
		sceltaAutostradaAggiuntaCasello.setText( autostradaAggiuntaCasello1.getText() );
		
	}
	
	@FXML
	void clickAutostradaAggiunta2(Event event) throws DatabaseException {
		
		idAutostradaAggiuntaCasello = 2;
		sceltaAutostradaAggiuntaCasello.setText( autostradaAggiuntaCasello2.getText() );
		
	}
	
	@FXML
	void clickAutostradaAggiunta3(Event event) throws DatabaseException {
		
		idAutostradaAggiuntaCasello = 3;
		sceltaAutostradaAggiuntaCasello.setText( autostradaAggiuntaCasello3.getText() );
		
	}
	
	@FXML
	void clickAutostradaAggiunta4(Event event) throws DatabaseException {
		
		idAutostradaAggiuntaCasello = 4;
		sceltaAutostradaAggiuntaCasello.setText( autostradaAggiuntaCasello4.getText() );
		
	}
	
	@FXML
	void clickAutostradaAggiunta5(Event event) throws DatabaseException {
		
		idAutostradaAggiuntaCasello = 5;
		sceltaAutostradaAggiuntaCasello.setText( autostradaAggiuntaCasello5.getText() );
		
	}
	
	@FXML
	void clickAggiungi(Event event) throws DatabaseException {
		
		float chilometro = Float.parseFloat( labelChilometroCaselloAggiunta.getText() );
		String nome = labelNomeCaselloAggiunta.getText();
		
		dbFactory.getDaoCasello().addCasello(nome, idAutostradaAggiuntaCasello, chilometro);
		
		pannelloAggiungiCasello.setVisible(false);
		pannelloBase.setDisable(false);
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnAA000AA.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAA000AA.setEffect(shadow);

		});

		btnAA000AA.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAA000AA.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnAA000AA.setEffect(shadow);

		});

		btnAA001AA.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAA001AA.setEffect(shadow);

		});

		btnAA001AA.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAA001AA.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnAA001AA.setEffect(shadow);

		});

		btnAA002AA.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAA002AA.setEffect(shadow);

		});

		btnAA002AA.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAA002AA.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnAA002AA.setEffect(shadow);

		});

		btnAA003AA.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAA003AA.setEffect(shadow);

		});

		btnAA003AA.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAA003AA.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnAA003AA.setEffect(shadow);

		});

		btnAA004AA.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAA004AA.setEffect(shadow);

		});

		btnAA004AA.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAA004AA.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnAA004AA.setEffect(shadow);

		});

		btnAA005AA.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAA005AA.setEffect(shadow);

		});

		btnAA005AA.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAA005AA.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnAA005AA.setEffect(shadow);

		});

		btnModificaCasello.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnModificaCasello.setEffect(shadow);

		});

		btnModificaCasello.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnModificaCasello.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnModificaCasello.setEffect(shadow);

		});

		btnAggiungiCasello.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAggiungiCasello.setEffect(shadow);

		});

		btnAggiungiCasello.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAggiungiCasello.setStyle("-fx-background-color: #282938; -fx-background-radius: 1");
			btnAggiungiCasello.setEffect(shadow);

		});

		btnClose.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnClose.setEffect(shadow);

		});

		btnClose.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnClose.setEffect(shadow);

		});

		btnStart.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnStart.setEffect(shadow);

		});

		btnStart.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnStart.setEffect(shadow);

		});
		
		btnModifica.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnModifica.setEffect(shadow);

		});

		btnModifica.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnModifica.setEffect(shadow);

		});
		
		btnElimina.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnElimina.setEffect(shadow);

		});

		btnElimina.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnElimina.setEffect(shadow);

		});
		
		btnAggiungi.setOnMouseEntered(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setColor(javafx.scene.paint.Color.TRANSPARENT);

			btnAggiungi.setEffect(shadow);

		});

		btnAggiungi.setOnMouseExited(e -> {

			DropShadow shadow = new DropShadow();
			shadow.setWidth(20.0);
			shadow.setHeight(20.0);
			shadow.setRadius(9.5);
			shadow.setOffsetX(2.0);
			shadow.setOffsetY(2.0);

			btnAggiungi.setEffect(shadow);

		});

		pannelloPedaggio.setOnMouseClicked(e -> {

			pannelloPedaggio.setVisible(false);
			pannelloBase.setDisable(false);

		});

	}


}
