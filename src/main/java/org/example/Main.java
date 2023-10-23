package org.example;


import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Polinom a = new Polinom();
        Polinom b = new Polinom();
        Polinom c = new Polinom();
        a.addMonom(new Monom(2, 1));
        a.addMonom(new Monom(1, 0));
        b.addMonom(new Monom(8, 1));
        b.addMonom(new Monom(3, 2));
        b.addMonom(new Monom(10, 0));

        // Afisam polinoamele a si b
        System.out.println("a(x) = " + a);
        System.out.println("b(x) = " + b);

        System.out.println("Adunare:");
        c = c.adunare(a, b);
        System.out.println(c.toString());

        System.out.println("\nScadere:");
        c = c.scadere(a, b);
        System.out.println(c.toString());

        System.out.println("\nInmultire:");
        c = c.inmultire(a, b);
        System.out.println(c.toString());

        System.out.println("\nImpartire:");
        String rez = c.impartire(b, a);
        System.out.println(rez);

        System.out.println("\nDerivare:");
        c = c.derivare(b);
        System.out.println(c.toString());

        System.out.println("\nIntegrare:");
        c = c.integrare(b);
        System.out.println(c.toString());
    }
}
