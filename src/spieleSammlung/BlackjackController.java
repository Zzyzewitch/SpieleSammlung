package spieleSammlung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
        private Label kartenBank;

        @FXML
        private Label kontostand;

        @FXML
        private Label kartenSpieler;

        @FXML
        void doubleIt(ActionEvent event) {

        }

        @FXML
        void hitIt(ActionEvent event) {
               spielerKarten.add(karte.ziehen());
               String placeholder= "" ;
               for(int i = 0; i < spielerKarten.size()-1; i++){
                       placeholder = spielerKarten.get(i) + "\n";
               }
               kartenSpieler.setText(placeholder);
        }

        @FXML
        void holdIt(ActionEvent event) {

        }

        @FXML
        void splitIt(ActionEvent event) {

        }

        @FXML
        void start(ActionEvent event) {

               spielerKarten.add(karte.ziehen());
               spielerKarten.add(karte.ziehen());

               bankKarten.add(karte.ziehen());
               bankKarten.add(karte.ziehen());

               kartenBank.setText(bankKarten.get(0) +"\n" + bankKarten.get(1));
               kartenSpieler.setText(spielerKarten.get(0) + "\n" + spielerKarten.get(1));

        }

        @FXML
        private void initialize(){
                System.out.println("In Initialize");
        }

}
