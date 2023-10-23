package org.example;
import java.util.*;

public class Polinom {
    // a1*x^putere+a2*x^putere-1+...+an*x^1
    // integer = cheia
    // practic puterea va fi cheia
    private TreeMap<Integer, Monom> tree = new TreeMap<Integer, Monom>();  //creez un treemap, avand cheia si monomul
    // ^ variabila de polinom

    public Polinom(TreeMap<Integer, Monom> map) {
        this.tree = tree;
    }

    public void addMonom(Monom mon) {
        tree.put(mon.getPutere(), mon);
    }  //adaugam monomul in polinom

    public Polinom adunare(Polinom a, Polinom b) {
        int ok = 0;
        Polinom s = new Polinom();
        for (Monom c : a.tree.values()) {
            ok = 0;
            for (Monom d : b.tree.values()) {
                if (c.getPutere() == d.getPutere()) {
                    s.addMonom(new Monom(c.getCoef() + d.getCoef(), c.getPutere()));
                    ok = 1;
                }
            }
            if (ok == 0) {
                s.addMonom(new Monom(c.getCoef(), c.getPutere()));
            }
        }
        for (Monom d : b.tree.values()) {
            ok = 0;
            for (Monom c : a.tree.values()) {
                if (c.getPutere() == d.getPutere()) {
                    ok = 1; }
            }
            if (ok == 0)  s.addMonom(new Monom(d.getCoef(), d.getPutere()));
        }
        return s;
    }

    public Polinom scadere(Polinom a, Polinom b) {
        int ok = 0;
        Polinom s = new Polinom();
        for (Monom c : a.tree.values()) {
            ok = 0;
            for (Monom d : b.tree.values()) {
                if (c.getPutere() == d.getPutere()) {
                    s.addMonom(new Monom(c.getCoef() - d.getCoef(), c.getPutere()));
                    ok = 1;
                }
            }
            if (ok == 0) {
                s.addMonom(new Monom(c.getCoef(), c.getPutere()));
            }
        }
        for (Monom d : b.tree.values()) {
            ok = 0;
            for (Monom c : a.tree.values()) {
                if (c.getPutere() == d.getPutere()) {
                    ok = 1;
                }
            }
            if (ok == 0) {
                s.addMonom(new Monom(-d.getCoef(), d.getPutere()));
            }
        }
        return s;
    }

    public Polinom inmultire(Polinom a, Polinom b)
    {
        Polinom s = new Polinom();
        for (Monom c: a.tree.values()) {
            for (Monom d : b.tree.values()) {
                double coef = c.getCoef() * d.getCoef();
                int power = c.getPutere() + d.getPutere();
                boolean ok = false;
                for (Monom m : s.tree.values()) {
                    if (m.getPutere() == power) {
                        m.setCoef(m.getCoef() + coef);
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    s.addMonom(new Monom(coef, power));
                }
            }
        }
        return s;
    }

    // pentru a lua cel mai mare grad, folosesc remainder.getMap().lastKey() pentru ca am treemap
    // si sunt puse in ordine crescatoare a puterii
    public String impartire(Polinom a, Polinom b) {
        Polinom cat = new Polinom();
        Polinom rest = new Polinom();
        rest.getTree().putAll(a.getTree());
        if (a.getTree().lastKey() < b.getTree().lastKey()) {
            // daca gradul maxim a lui a e < gradul maxim a lui b, returnam 0 pentru cat si a pentru rest
            return "cat = " + cat.toString() + ", rest = " + rest.toString();
        } else {
            // impartim doar in momentul in care gradul restului este pozitiv, pentru ca nu poate ajunge negativ ca nu se poate imparti asa
            while (rest.getTree().lastKey() >= b.getTree().lastKey()) {
                int gradR = rest.getTree().lastKey();
                int gradB = b.getTree().lastKey();
                int gradCat = gradR - gradB;
                double coeficientR = rest.getTree().get(gradR).getCoef();
                double coeficientB =  b.getTree().get(gradB).getCoef();
                double coeficientCat = coeficientR / coeficientB;

                Polinom termen = new Polinom();
                termen.addMonom(new Monom(coeficientCat, gradCat));

                System.out.println(termen);
                cat = adunare(cat, termen);
                Polinom produs = inmultire(b, termen);
                rest = scadere(rest, produs);
                if(rest.getTree().get(rest.getTree().lastKey()).getCoef() == 0) rest.getTree().remove(rest.getTree().lastKey());
                if (rest.getTree().lastKey() == 0) break; }

        }
        return "cat = " + cat.toString() + ", rest = " + rest.toString();
    }
    public Polinom derivare(Polinom a)
    {
        Polinom s = new Polinom();
        for (Monom c: a.tree.values())
        {
            if(c.getPutere() == 0)
                s.addMonom(new Monom(0,0));
            else
            if(c.getPutere() == 1)
                s.addMonom(new Monom(c.getCoef(), c.getPutere() - 1));
            else
                s.addMonom(new Monom(c.getCoef() * c.getPutere(), c.getPutere() - 1));
        }
        return s;
    }

    public Polinom integrare(Polinom a)
    {
        Polinom s = new Polinom();
        for (Monom c: a.tree.values())
        {
            if(c.getPutere() == 0)
                s.addMonom(new Monom(c.getCoef(), 1));
            else
                s.addMonom(new Monom(c.getCoef() / (c.getPutere() + 1), c.getPutere() + 1));
        }
        return s;
    }
    public Polinom() { }

    public TreeMap<Integer, Monom> getTree() {
        return tree;
    }

    public void setMap(TreeMap<Integer, Monom> tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        // Parcurg tree-ul in ordine inversa si verific daca nu am luat primul parametru(ok == false), vom pune in string acest prim monom
        // iar ok-ul il vom pune pe true pentru a stii ca am avut primul monom. Altfel daca coeficientul e pozitiv se adauga normal cu +,
        // iar daca este negativ se adauga fara semn, pentru ca avem deja minusul de la coeficient in momentul introducerii datelor
        String s = null;
        boolean ok = false;
        for (Monom c : tree.descendingMap().values()) {
            if (ok == false) {
                s = c.toString();
                ok = true;
            } else if (c.getCoef() > 0) {
                s = s + " + " + c.toString();
            }
            else if (c.getCoef() < 0) {
                s = s + " " + c.toString();}
        }
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        return tree.equals(((Polinom) obj).getTree());
    }
}
