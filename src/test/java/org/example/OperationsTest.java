package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationsTest {
    @Test
    public void addTest() {
        Polinom a = new Polinom();
        Polinom b = new Polinom();
        Polinom c = new Polinom();
        a.addMonom(new Monom(2, 1));
        a.addMonom(new Monom(1, 0));
        b.addMonom(new Monom(8, 1));
        b.addMonom(new Monom(3, 2));
        b.addMonom(new Monom(10, 0));
        c.addMonom(new Monom(3, 2));
        c.addMonom(new Monom(10, 1));
        c.addMonom(new Monom(11, 0));

        assertEquals(c.adunare(a, b), c);
    }

    @Test
    public void scadTest() {
        Polinom a = new Polinom();
        Polinom b = new Polinom();
        Polinom c = new Polinom();
        a.addMonom(new Monom(2, 1));
        a.addMonom(new Monom(1, 0));
        b.addMonom(new Monom(8, 1));
        b.addMonom(new Monom(3, 2));
        b.addMonom(new Monom(10, 0));
        c.addMonom(new Monom(-3, 2));
        c.addMonom(new Monom(-6, 1));
        c.addMonom(new Monom(-9, 0));

        assertEquals(c.scadere(a, b), c);
    }

    @Test
    public void inmulTest() {
        Polinom a = new Polinom();
        Polinom b = new Polinom();
        Polinom c = new Polinom();
        a.addMonom(new Monom(2, 1));
        a.addMonom(new Monom(1, 0));
        b.addMonom(new Monom(8, 1));
        b.addMonom(new Monom(3, 2));
        b.addMonom(new Monom(10, 0));
        c.addMonom(new Monom(6, 3));
        c.addMonom(new Monom(19, 2));
        c.addMonom(new Monom(28, 1));
        c.addMonom(new Monom(10, 0));

        assertEquals(c.inmultire(a, b), c);
    }

    public void inparTest() {
        Polinom a = new Polinom();
        Polinom b = new Polinom();
        Polinom c = new Polinom();
        a.addMonom(new Monom(2, 1));
        a.addMonom(new Monom(1, 0));
        b.addMonom(new Monom(8, 1));
        b.addMonom(new Monom(3, 2));
        b.addMonom(new Monom(10, 0));
        c.addMonom(new Monom(6, 3));
        c.addMonom(new Monom(19, 2));
        c.addMonom(new Monom(28, 1));
        c.addMonom(new Monom(10, 0));

        assertEquals(c.impartire(a, b), c);
    }

    @Test
    public void derivTest() {
        Polinom a = new Polinom();
        Polinom c = new Polinom();
        a.addMonom(new Monom(2, 1));
        a.addMonom(new Monom(1, 0));
        c.addMonom(new Monom(2, 0));

        assertEquals(c.derivare(a), c);
    }

    @Test
    public void integTest() {
        Polinom a = new Polinom();
        Polinom c = new Polinom();
        a.addMonom(new Monom(2, 1));
        a.addMonom(new Monom(1, 0));
        c.addMonom(new Monom(1, 2));
        c.addMonom(new Monom(1, 1));

        assertEquals(c.integrare(a), c);
    }
}
