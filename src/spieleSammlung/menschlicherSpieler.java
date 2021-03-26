package spieleSammlung;

public class menschlicherSpieler {
    private int konto = 1_000_000;
    private int einsatz = 5;


    public int getEinsatz() {
        return einsatz;
    }

    public int getKonto() {
        return konto;
    }

    public void setEinsatz(int einsatz) {
        this.einsatz = einsatz;
    }

    public void setKonto(int konto) {
        this.konto = konto;
    }

}
