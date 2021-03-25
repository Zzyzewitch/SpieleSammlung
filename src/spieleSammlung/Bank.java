package spieleSammlung;

public class Bank {

    public void HitIt (Karte ka, BlackjackController bc){
        bc.bankKarten.add(ka.ziehenSpieler());
        String placeholder= bc.bankKarten.get(0) + "\n" + bc.bankKarten.get(1) + "\n";
        for(int i = 2; i < bc.bankKarten.size(); i++){
            placeholder += bc.bankKarten.get(i) + "\n";
        }
        bc.getkartenBank().setText(placeholder);

        if(ka.gesamtKartenwert(ka.kartenWertBank)== -2) {
            bc.getGesamtWert().setText("BlackJack");
            bc.getGit().setDisable(true);
            bc.getHold().setDisable(true);
            bc.getVerdopple().setDisable(true);
        }
        else if (ka.gesamtKartenwert(ka.kartenWertSpieler)== -1) {
            bc.getGesamtWert().setText("Bank gewinnt");
            bc.getGit().setDisable(true);
            bc.getHold().setDisable(true);
            bc.getVerdopple().setDisable(true);
        }
        else {
            bc.getGesamtWert().setText(String.valueOf(ka.gesamtKartenwert(ka.kartenWertSpieler)));
        }

    }
}
