package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetnaTacka,krajnjaTacka;
    boolean pocetnaPripadaIntervalu,krajnjaPripadaIntervalu;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripadaIntervalu, boolean krajnjaPripadaIntervalu) {
        if (krajnjaTacka > pocetnaTacka ) throw new IllegalArgumentException();
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pocetnaPripadaIntervalu = pocetnaPripadaIntervalu;
        this.krajnjaPripadaIntervalu = krajnjaPripadaIntervalu;
    }

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;
        pocetnaPripadaIntervalu = false;
        krajnjaPripadaIntervalu = false;

    }

//    public boolean isIn(double v) {
  //  }

    public boolean isNull() {
        if (pocetnaTacka == 0 && krajnjaTacka == 0 && pocetnaPripadaIntervalu == false && krajnjaPripadaIntervalu == false) return true;
        return false;
    }

    public Interval intersect(Interval interval) {
    }
}
