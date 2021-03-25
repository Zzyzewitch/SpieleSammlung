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
    private int gesamt;
    public String ziehenSpieler(){
        int farbZahl = secureRand.nextInt(4);
        int wertZahl = secureRand.nextInt(11);

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


        return farbe.get(farbZahl) +" " + wert.get(wertZahl);
    }

    public String ziehenBank() {
        int farbZahl = secureRand.nextInt(4);
        int wertZahl = secureRand.nextInt(11);

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
        for (int i = 0; i < li.size(); i++) {
            gesamt += li.get(i);
            System.out.println("gesamt:::" + gesamt);
            if (gesamt > 21) {
                if (li.get(i) == 11) {
                    gesamt -= 10;
                }
                else{
                    //Mokup Bank gewinnt
                    return -1;
                }
            }
            else if(gesamt == 21){
                //Mokup BlackJack
                return -2;
            }

        }
        return gesamt;
    }
}