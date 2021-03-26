package spieleSammlung;

public class Spieltisch {

    public Spieltisch(menschlicherSpieler mSp) {
        this.mSp = mSp;
    }

    menschlicherSpieler mSp;

    public void spielEnde(Karte ka, Bank ba, BlackjackController bc) {
        if (ka.gesamtKartenwert(ka.kartenWertSpieler) < ka.gesamtKartenwert(ka.kartenWertBank)) {
            bc.getGesamtWertBank().setText("Bank gewinnt");
            bc.getGesamtWert().setText("Bank gewinnt");
            bc.getStart().setDisable(false);
            mSp.setKonto(mSp.getKonto() - mSp.getEinsatz());
            mSp.setEinsatz(0);
            bc.getKontostand().setText(String.valueOf(mSp.getKonto()));
        } else if (ka.gesamtKartenwert(ka.kartenWertSpieler) > ka.gesamtKartenwert(ka.kartenWertBank)) {
            bc.getGesamtWertBank().setText("Spieler gewinnt");
            bc.getGesamtWert().setText("Spieler gewinnt");
            bc.getStart().setDisable(false);
            mSp.setKonto(mSp.getKonto() + 2 * mSp.getEinsatz());
            mSp.setEinsatz(0);
            bc.getKontostand().setText(String.valueOf(mSp.getKonto()));
        } else if (ka.gesamtKartenwert(ka.kartenWertSpieler) == ka.gesamtKartenwert(ka.kartenWertBank)) {
            bc.getGesamtWertBank().setText("Remi");
            bc.getGesamtWert().setText("Remi");
            bc.getStart().setDisable(false);
            mSp.setEinsatz(0);
            bc.getKontostand().setText(String.valueOf(mSp.getKonto()));
        }
    }

}

