package ba.unsa.etf.rpr.tutorijal02;

import com.sun.nio.sctp.AbstractNotificationHandler;

public class Interval {
    double pocetnaTacka,krajnjaTacka;
    boolean pocetnaPripadaIntervalu,krajnjaPripadaIntervalu;

    @Override
    public boolean equals(Object o) {
        Interval i=(Interval) o;
        if (pocetnaTacka!=i.pocetnaTacka || pocetnaPripadaIntervalu!=i.pocetnaPripadaIntervalu || krajnjaTacka!=i.krajnjaTacka || krajnjaPripadaIntervalu!=i.krajnjaPripadaIntervalu)
            return false;
        return true;
    }

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaPripadaIntervalu, boolean krajnjaPripadaIntervalu) {
        if (krajnjaTacka < pocetnaTacka ) throw new IllegalArgumentException();
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

    public boolean isNull() {
        if (pocetnaTacka == 0 && krajnjaTacka == 0 && pocetnaPripadaIntervalu == false && krajnjaPripadaIntervalu == false) return true;
        return false;
    }
    @Override
    public String toString() {
        if(isNull()) return "()";
        String s=new String();
    if (pocetnaPripadaIntervalu) {
        s="["+pocetnaTacka+","+krajnjaTacka;
        if (krajnjaPripadaIntervalu) s=s+"]";
        else s=s+")";
    } else {
        s="("+pocetnaTacka+","+krajnjaTacka;
        if(krajnjaPripadaIntervalu) s=s+"]";
        else s=s+")";
    }
    return s;
    }

    public boolean isIn(double v) {
        if (v>krajnjaTacka || v<pocetnaTacka) return false;
        if (v>=krajnjaTacka && !krajnjaPripadaIntervalu) return false;
        if (v<= pocetnaTacka && !pocetnaPripadaIntervalu) return false;
        return true;
    }
    public static Interval intersect(Interval i1, Interval i2) {
        Interval i=new Interval();
        if (i2.pocetnaTacka>=i1.pocetnaTacka && i2.krajnjaTacka>=i1.krajnjaTacka ) {
            i.pocetnaTacka=i2.pocetnaTacka;
            i.pocetnaPripadaIntervalu=i2.pocetnaPripadaIntervalu;
            i.krajnjaTacka=i1.krajnjaTacka;
            i.krajnjaPripadaIntervalu=i1.krajnjaPripadaIntervalu;
        }
        else if (i1.pocetnaTacka<i2.pocetnaTacka && i1.krajnjaTacka>i2.krajnjaTacka ) {
            i.pocetnaTacka=i2.pocetnaTacka;
            i.pocetnaPripadaIntervalu=i2.pocetnaPripadaIntervalu;
            i.krajnjaTacka=i2.krajnjaTacka;
            i.krajnjaPripadaIntervalu=i2.krajnjaPripadaIntervalu;
        }
        return i;
    }
    public Interval intersect(Interval interval) {
        return Interval.intersect(this,interval);
    }

}
