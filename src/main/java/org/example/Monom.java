package org.example;

public class Monom
{
    // monom = coef * x^putere
    private double coef;
    private int putere;

    public Monom(double coef, int putere)
    {
        this.coef = coef;
        this.putere = putere;
    }

    public double getCoef()
    {
        return coef;
    }

    public void setCoef(double coef)
    {
        this.coef = coef;
    }

    public int getPutere()
    {
        return putere;
    }

    public void setPutere(int putere)
    {
        this.putere = putere;
    }

    @java.lang.Override
    public java.lang.String toString()
    {
        if(putere == 0)     // daca puterea este 0, va afisa doar coef
            return ""+coef;
        if(putere == 1)     // va afisa de coef*x
            return coef + "*x";
        else return coef + "*x^" + putere;  // va afisa normal coef * x ^ putere
    }

    @Override
    public boolean equals(Object obj) {
        // suprascrie functia de equals pentru a compara corect obiectele clasei monom
        Monom obj1 = (Monom) obj;
        if(coef == obj1.getCoef() && putere == obj1.getPutere())
        {
            return true;
        }
        else return false;
    }
}
