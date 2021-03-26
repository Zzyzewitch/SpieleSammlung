package spieleSammlung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class BlackjackController {
    Karte karte = new Karte();
    menschlicherSpieler mSp = new menschlicherSpieler();
    Spieltisch spTisch = new Spieltisch(mSp);
    Bank bank = new Bank(spTisch);


    @FXML
    private Button split;

    @FXML
    private Button verdopple;

    @FXML
    private Button hold;

    @FXML
    private Button git;

    @FXML
    private Button start;

    @FXML
    private Button end;

    @FXML
    private Slider slider;

    @FXML
    private Button ok;

    @FXML
    private Label kartenBank;

    @FXML
    private Label kontostand;

    @FXML
    private Label kartenSpieler;

    @FXML
    private Label gesamtWertBank;

    @FXML
    private Label gesamtWert;

    @FXML
    private Label labelEinsatz;

    @FXML
    void doubleIt(ActionEvent event) {

    }

    @FXML
    void bestaetige(ActionEvent event) {
        labelEinsatz.setText(String.valueOf((int) slider.getValue()));
        mSp.setEinsatz((int) this.getSlider().getValue());
        System.out.println("EInstaz::::" + mSp.getEinsatz());
        mSp.setKonto(mSp.getKonto() - mSp.getEinsatz());
        kontostand.setText(String.valueOf(mSp.getKonto()));
        start.setDisable(false);

    }

    @FXML
    void hitIt(ActionEvent event) {
        karte.spielerKarten.add(karte.ziehenSpieler());
        String placeholder = karte.spielerKarten.get(0) + "\n" + karte.spielerKarten.get(1) + "\n";
        for (int i = 2; i < karte.spielerKarten.size(); i++) {
            placeholder += karte.spielerKarten.get(i) + "\n";
        }
        kartenSpieler.setText(placeholder);


        if (karte.gesamtKartenwert(karte.kartenWertSpieler) == -1) {
            gesamtWert.setText("Bank gewinnt");
            git.setDisable(true);
            hold.setDisable(true);
            verdopple.setDisable(true);
            start.setDisable(false);

        } else {
            gesamtWert.setText(String.valueOf(karte.gesamtKartenwert(karte.kartenWertSpieler)));
        }
    }

    @FXML
    void holdIt(ActionEvent event) {
        //funktions aufruf bank spiele
        git.setDisable(true);
        verdopple.setDisable(true);
        bank.spiel(karte, BlackjackController.this);

    }

    @FXML
    void splitIt(ActionEvent event) {
        if (karte.getGleich()) {
            split.setDisable(false);
            //aufruf funktion in karte neue liste überführen funktionen bei take ergänzen
        }

    }

    @FXML
    void start(ActionEvent event) {
        reset();
        karte.spielerKarten.add(karte.ziehenSpieler());
        karte.spielerKarten.add(karte.ziehenSpieler());
        karte.bankKarten.add(karte.ziehenBank());
        karte.bankKarten.add(karte.ziehenBank());
        kartenBank.setText(karte.bankKarten.get(0) + "\n" + karte.bankKarten.get(1));
        kartenSpieler.setText(karte.spielerKarten.get(0) + "\n" + karte.spielerKarten.get(1));
        gesamtWert.setText(String.valueOf(karte.gesamtKartenwert(karte.kartenWertSpieler)));
        start.setDisable(true);

        if (karte.pruefeBlackJackSpieler() == 1) {
            gesamtWert.setText("BlackJack \n Spieler gewinnt");
            git.setDisable(true);
            hold.setDisable(true);
            verdopple.setDisable(true);
            start.setDisable(false);
            //Updates einfügen von Kontostand einsatz etc. was passiert mit 3/2 auszahlung
        }

        if (karte.pruefeBlackJackBank() == 1) {
            gesamtWert.setText("BlackJack \n Bank gewinnt");
            git.setDisable(true);
            hold.setDisable(true);
            verdopple.setDisable(true);
            start.setDisable(false);
            mSp.setKonto(mSp.getKonto()- mSp.getEinsatz());
            labelEinsatz.setText(String.valueOf(mSp.getEinsatz()));
            kontostand.setText(String.valueOf(mSp.getKonto()));
        }


    }

    @FXML
    private void initialize() {
        System.out.println("In Initialize");
        gesamtWert.setText("0");
        split.setDisable(true);
        gesamtWertBank.setText("0");
        verdopple.setDisable(true);
        git.setDisable(true);
        hold.setDisable(true);
        start.setDisable(true);
        kontostand.setText(String.valueOf(mSp.getKonto()));
    }

    @FXML
    void end(ActionEvent event) {
        System.exit(0);
    }

    public void reset() {
        karte.kartenWertSpieler.clear();
        karte.kartenWertBank.clear();
        karte.spielerKarten.clear();
        karte.bankKarten.clear();
        kartenSpieler.setText("KartenSpieler");
        kartenBank.setText("KartenBank");
        gesamtWertBank.setText("0");
        gesamtWert.setText("0");
        verdopple.setDisable(false);
        git.setDisable(false);
        hold.setDisable(false);
        labelEinsatz.setText(String.valueOf(mSp.getEinsatz()));
    }


    @FXML
    public Label getkartenBank() {
        return kartenBank;
    }

    public Label getGesamtWert() {
        return gesamtWert;
    }

    public Label getKontostand() {
        return kontostand;
    }

    public Label getKartenBank() {
        return kartenBank;
    }

    public Label getKartenSpieler() {
        return kartenSpieler;
    }

    public Label getGesamtWertBank() {
        return gesamtWertBank;
    }

    public Slider getSlider() {
        return slider;
    }

    public Button getSplit() {
        return split;
    }

    public Button getGit() {
        return git;
    }

    public Button getStart() {
        return start;
    }

    public Button getEnd() {
        return end;
    }

    public Button getHold() {
        return hold;
    }

    public Button getVerdopple() {
        return verdopple;
    }


    @FXML
    public void setKartenBank(String kartenBank) {
        this.kartenBank.setText(kartenBank);
    }

    public void setGesamtWert(String gw) {
        gesamtWert.setText(gw);
    }

    public void setKontostand(String kontostand) {
        this.kontostand.setText(kontostand);
    }

    public void setKartenSpieler(String kartenSpieler) {
        this.kartenSpieler.setText(kartenSpieler);
    }

    public void setEnd(Button end) {
        this.end = end;
    }

    public void setGit(Button git) {
        this.git = git;
    }

    public void setGesamtWertBank(Label gesamtWertBank) {
        this.gesamtWertBank = gesamtWertBank;
    }

    public void setHold(Button hold) {
        this.hold = hold;
    }

    public void setSplit(Button split) {
        this.split = split;
    }

    public void setStart(Button start) {
        this.start = start;
    }

    public void setVerdopple(Button verdopple) {
        this.verdopple = verdopple;
    }
}
