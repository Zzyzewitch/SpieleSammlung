package spieleSammlung;

public class Bank {
Spieltisch sptisch = new Spieltisch();
    public void spiel(Karte ka, BlackjackController bc){
        while(ka.gesamtKartenwert(ka.kartenWertBank) < 17 && ka.gesamtKartenwert(ka.kartenWertBank) != -1 && ka.gesamtKartenwert(ka.kartenWertBank) != -2){
            hitIt(ka, bc);
        }
        sptisch.spielEnde(ka,Bank.this, bc);
    }

    public void hitIt (Karte ka, BlackjackController bc){
        ka.bankKarten.add(ka.ziehenBank());
        String placeholder= ka.bankKarten.get(0) + "\n" + ka.bankKarten.get(1) + "\n";
        for(int i = 2; i < ka.bankKarten.size(); i++){
            placeholder += ka.bankKarten.get(i) + "\n";
        }
        bc.getkartenBank().setText(placeholder);

        if (ka.gesamtKartenwert(ka.kartenWertSpieler)== -1) {
            bc.getGesamtWert().setText("Spieler gewinnt");
            bc.getGesamtWertBank().setText("Spieler gewinnt");
            bc.getGit().setDisable(true);
            bc.getHold().setDisable(true);
            bc.getVerdopple().setDisable(true);
            bc.getStart().setDisable(false);
        }
        else {
            bc.getGesamtWertBank().setText(String.valueOf(ka.gesamtKartenwert(ka.kartenWertSpieler)));
        }
    }




}
