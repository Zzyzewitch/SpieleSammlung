package spieleSammlung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

public class BlackjackController {
Karte karte = new Karte();
List<String> spielerKarten = new ArrayList<>();
List<String> bankKarten = new ArrayList<>();

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
        private Label kartenBank;

        @FXML
        private Label kontostand;

        @FXML
        private Label kartenSpieler;


        @FXML
        private Label gesamtWert;


        @FXML
        void doubleIt(ActionEvent event) {

        }

        @FXML
        void hitIt(ActionEvent event) {
               spielerKarten.add(karte.ziehenSpieler());
               String placeholder= spielerKarten.get(0) + "\n" + spielerKarten.get(1) + "\n";
               for(int i = 2; i < spielerKarten.size(); i++){
                       placeholder += spielerKarten.get(i) + "\n";
               }
               kartenSpieler.setText(placeholder);

               if(karte.gesamtKartenwert(karte.kartenWertSpieler)== -2) {
                   gesamtWert.setText("BlackJack");
                   git.setDisable(true);
                   hold.setDisable(true);
                   verdopple.setDisable(true);
               }
               else if (karte.gesamtKartenwert(karte.kartenWertSpieler)== -1) {
                   gesamtWert.setText("Bank gewinnt");
                   git.setDisable(true);
                   hold.setDisable(true);
                   verdopple.setDisable(true);
               }
               else {
                   gesamtWert.setText(String.valueOf(karte.gesamtKartenwert(karte.kartenWertSpieler)));
               }
        }

        @FXML
        void holdIt(ActionEvent event) {

        }

        @FXML
        void splitIt(ActionEvent event) {
            if(karte.getGleich()){
                split.setDisable(false);
                //aufruf funktion in karte neue liste überführen funktionen bei take ergänzen
            }

        }

        @FXML
        void start(ActionEvent event) {

               spielerKarten.add(karte.ziehenSpieler());
               spielerKarten.add(karte.ziehenSpieler());

               bankKarten.add(karte.ziehenBank());
               bankKarten.add(karte.ziehenBank());

               kartenBank.setText(bankKarten.get(0) +"\n" + bankKarten.get(1));
               kartenSpieler.setText(spielerKarten.get(0) + "\n" + spielerKarten.get(1));
               gesamtWert.setText(String.valueOf(karte.gesamtKartenwert(karte.kartenWertSpieler)));
               start.setDisable(true);

        }

        @FXML
        private void initialize(){
                System.out.println("In Initialize");
                gesamtWert.setText("0");
                split.setDisable(true);
        }

        @FXML
        void end(ActionEvent event) {
            System.exit(0);
        }


}
