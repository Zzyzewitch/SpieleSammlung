package spieleSammlung;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Karte{
    List<String> farbe = List.of("Herz", "Pick", "Kreuz", "Karo");
    List<String> wert = List.of("2","3","4","5","6","7","8","9","10", "Bube", "Dame", "König","Ass");
    SecureRandom secureRand = new SecureRandom();

    public String ziehen(){
        return farbe.get(secureRand.nextInt(4)) +" " + wert.get(secureRand.nextInt(11));


    }

}