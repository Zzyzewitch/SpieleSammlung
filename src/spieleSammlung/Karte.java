package spieleSammlung;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Karte{
    List<String> farbe = List.of("Herz", "Pick", "Kreuz", "Karo");
    List<String> wert = List.of("2","3","4","5","6","7","8","9","10", "Bube", "Dame", "König","Ass");
    SecureRandom secureRand = new SecureRandom();
    List<Integer> kartenWertSpieler = new ArrayList<>();
    List<Integer> kartenWertBank = new ArrayList<>();
    List<String> spielerKarten = new ArrayList<>();
    List<String> bankKarten = new ArrayList<>();
    private boolean gleich;
    private int gesamt;
    private static int zaehler;


    public String ziehenSpieler(){
        zaehler++;
        int farbZahl = secureRand.nextInt(4);
        int wertZahl = secureRand.nextInt(13);

        if(wertZahl == 8 || wertZahl == 9 || wertZahl == 10 || wertZahl == 11){
            kartenWertSpieler.add(10);
        }

        else if(wertZahl == 0){
            kartenWertSpieler.add(2);
        }

        else if(wertZahl == 1){
            kartenWertSpieler.add(3);
        }

        else if(wertZahl == 2){
            kartenWertSpieler.add(4);
        }

        else if(wertZahl == 3){
            kartenWertSpieler.add(5);
        }

        else if(wertZahl == 4){
            kartenWertSpieler.add(6);
        }

        else if(wertZahl == 5){
            kartenWertSpieler.add(7);
        }

        else if(wertZahl == 6){
            kartenWertSpieler.add(8);
        }

        else if(wertZahl == 7){
            kartenWertSpieler.add(9);
        }

        else{
            kartenWertSpieler.add(11);
        }
        if (zaehler==2 && kartenWertSpieler.get(0) == kartenWertSpieler.get(1)){
            gleich = true;

        }

        return farbe.get(farbZahl) +" " + wert.get(wertZahl);
    }

    public String ziehenBank() {

        int farbZahl = secureRand.nextInt(4);
        int wertZahl = secureRand.nextInt(13);

        if(wertZahl == 8 || wertZahl == 9 || wertZahl == 10 || wertZahl == 11){
            kartenWertBank.add(10);
        }

        else if(wertZahl == 0){
            kartenWertBank.add(2);
        }

        else if(wertZahl == 1){
            kartenWertBank.add(3);
        }

        else if(wertZahl == 2){
            kartenWertBank.add(4);
        }

        else if(wertZahl == 3){
            kartenWertBank.add(5);
        }

        else if(wertZahl == 4){
            kartenWertBank.add(6);
        }

        else if(wertZahl == 5){
            kartenWertBank.add(7);
        }

        else if(wertZahl == 6){
            kartenWertBank.add(8);
        }

        else if(wertZahl == 7){
            kartenWertBank.add(9);
        }

        else{
            kartenWertBank.add(11);
        }


        return farbe.get(farbZahl) + " " + wert.get(wertZahl);
    }
    public int gesamtKartenwert(List<Integer> li){
        gesamt = 0;
        boolean bg = true;
        for (int i = 0; i < li.size(); i++) {
            gesamt += li.get(i);
            System.out.println("gesamt:::" + gesamt);
            if (gesamt > 21) {
                for (int j = 0; j < li.size(); j++) {
                    if (li.get(j) == 11) {
                        gesamt -= 10;
                        bg = false;
                    }
                }
                if(bg){
                    return -1;
                }

            }

        }
        return gesamt;
    }

    public int pruefeBlackJackBank(){
        if ((kartenWertBank.get(0) == 10 || kartenWertBank.get(1) == 10) && (kartenWertBank.get(0) == 11 || kartenWertBank.get(1) == 11)){
            System.out.println("bj bei bank");
            return 1;
        }
        else {
            return 0;
        }
    }

    public int pruefeBlackJackSpieler() {
        if ((kartenWertSpieler.get(0) == 10 || kartenWertSpieler.get(1) == 10) && (kartenWertSpieler.get(0) == 11 || kartenWertSpieler.get(1) == 11)) {
            System.out.println("bj bei spieler");
            return 1;
        }
        else {
            return 0;
        }
    }








    //set und get
    public boolean getGleich(){
        return gleich;
    }
}