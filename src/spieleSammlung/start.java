package spieleSammlung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class start extends Application{

        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/blackjack.fxml"));


           // primaryStage.setTitle("BlackJack");

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();


        }


}
