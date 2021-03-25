package spieleSammlung;

public class Spieltisch {

    menschlicherSpieler mSp = new menschlicherSpieler();

    public void spielEnde(Karte ka, Bank ba, BlackjackController bc){
       if (ka.gesamtKartenwert(ka.kartenWertSpieler) < ka.gesamtKartenwert(ka.kartenWertBank)){
           bc.getGesamtWertBank().setText("Bank gewinnt");
           bc.getGesamtWert().setText("Bank gewinnt");
           bc.getStart().setDisable(false);
       }
       else if (ka.gesamtKartenwert(ka.kartenWertSpieler) > ka.gesamtKartenwert(ka.kartenWertBank)){
           bc.getGesamtWertBank().setText("Spieler gewinnt");
           bc.getGesamtWert().setText("Spieler gewinnt");
           bc.getStart().setDisable(false);
       }
       else if (ka.gesamtKartenwert(ka.kartenWertSpieler) == ka.gesamtKartenwert(ka.kartenWertBank)){
           bc.getGesamtWertBank().setText("Remi");
           bc.getGesamtWert().setText("Remi");
           bc.getStart().setDisable(false);
       }
    }
}
