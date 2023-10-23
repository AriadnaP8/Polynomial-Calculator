package org.example;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interfata {

    private JFrame frame;
    private JTextField polinom1;
    private JTextField polinom2;
    private JTextField rezultat;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfata window = new Interfata();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Interfata() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(242, 231, 196));
        frame.setBounds(100, 100, 706, 706);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        polinom1 = new JTextField();
        polinom1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        polinom1.setBounds(275, 149, 385, 48);
        frame.getContentPane().add(polinom1);
        polinom1.setColumns(10);

        polinom2 = new JTextField();
        polinom2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        polinom2.setBounds(275, 207, 385, 48);
        frame.getContentPane().add(polinom2);
        polinom2.setColumns(10);

        JLabel textpol1 = new JLabel("Introduceti primul polinom:");
        textpol1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textpol1.setBounds(20, 155, 241, 31);
        frame.getContentPane().add(textpol1);

        JLabel textpol2 = new JLabel("Introduceti al doilea polinom:");
        textpol2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        textpol2.setBounds(10, 213, 252, 31);
        frame.getContentPane().add(textpol2);

        JLabel lblNewLabel = new JLabel("Calculator de polinoame");
        lblNewLabel.setFont(new Font("Goudy Stout", Font.BOLD, 20));
        lblNewLabel.setBounds(60, 39, 567, 66);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblSelectatiOperatiaDorita = new JLabel("Selectati operatia dorita:");
        lblSelectatiOperatiaDorita.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblSelectatiOperatiaDorita.setBounds(24, 290, 220, 31);
        frame.getContentPane().add(lblSelectatiOperatiaDorita);

        final JButton adunare = new JButton("+");
        adunare.setOpaque(true);
        adunare.setBorderPainted(false);
        adunare.setBackground(new Color(128, 128, 255));
        adunare.setFont(new Font("Goudy Stout", Font.BOLD, 70));
        adunare.setBounds(35, 342, 96, 96);
        frame.getContentPane().add(adunare);
        adunare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom a = new Polinom();
                Polinom b = new Polinom();
                Polinom s = new Polinom();
                try {
                    a = parse(polinom1.getText());
                    b = parse(polinom2.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                s = s.adunare(a, b);
                rezultat.setText(s.toString());
            }
        });

        JButton scadere = new JButton("−");
        scadere.setOpaque(true);
        scadere.setBorderPainted(false);
        scadere.setBackground(new Color(250, 250, 0));
        scadere.setOpaque(true);
        scadere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        scadere.setFont(new Font("Goudy Stout", Font.BOLD, 70));
        scadere.setBounds(141, 342, 96, 96);
        frame.getContentPane().add(scadere);
        scadere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom a = new Polinom();
                Polinom b = new Polinom();
                Polinom s = new Polinom();
                try {
                    a = parse(polinom1.getText());
                    b = parse(polinom2.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                s = s.scadere(a, b);
                rezultat.setText(s.toString());
            }
        });

        JButton inmultire = new JButton(".");
        inmultire.setBackground(new Color(255, 150, 6));
        inmultire.setOpaque(true);
        inmultire.setBorderPainted(false);
        inmultire.setVerticalAlignment(SwingConstants.TOP);
        inmultire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        inmultire.setFont(new Font("Goudy Stout", Font.BOLD, 45));
        inmultire.setBounds(247, 342, 96, 96);
        frame.getContentPane().add(inmultire);
        inmultire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom a = new Polinom();
                Polinom b = new Polinom();
                Polinom s = new Polinom();
                try {
                    a = parse(polinom1.getText());
                    b = parse(polinom2.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                s = s.inmultire(a, b);
                rezultat.setText(s.toString());
            }
        });

        JButton impartire = new JButton("÷");
        impartire.setBackground(new Color(37, 208, 6));
        impartire.setOpaque(true);
        impartire.setBorderPainted(false);
        impartire.setFont(new Font("Goudy Stout", Font.BOLD, 70));
        impartire.setBounds(353, 342, 96, 96);
        frame.getContentPane().add(impartire);
        impartire.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom a = new Polinom();
                Polinom b = new Polinom();
                Polinom s = new Polinom();
                String rez;
                try {
                    a = parse(polinom1.getText());
                    b = parse(polinom2.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                rez = s.impartire(a, b).toString();
                rezultat.setText(rez);
            }
        });

        JButton derivata = new JButton("'");
        derivata.setBackground(new Color(227, 0, 0));
        derivata.setOpaque(true);
        derivata.setBorderPainted(false);
        derivata.setFont(new Font("Goudy Stout", Font.BOLD, 70));
        derivata.setBounds(459, 342, 96, 96);
        frame.getContentPane().add(derivata);
        derivata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom a = new Polinom();
                Polinom s = new Polinom();
                try {
                    a = parse(polinom1.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                s = s.derivare(a);
                rezultat.setText(s.toString());
            }
        });

        JButton integrare = new JButton("∫");
        integrare.setBackground(new Color(83, 240, 249));
        integrare.setOpaque(true);
        integrare.setBorderPainted(false);
        integrare.setFont(new Font("Goudy Stout", Font.BOLD, 70));
        integrare.setBounds(564, 342, 96, 96);
        frame.getContentPane().add(integrare);
        integrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom a = new Polinom();
                Polinom s = new Polinom();
                try {
                    a = parse(polinom1.getText());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                s = s.integrare(a);
                rezultat.setText(s.toString());
            }
        });

        JLabel lblRezultatulFinalEste = new JLabel("Rezultatul final este:");
        lblRezultatulFinalEste.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblRezultatulFinalEste.setBounds(249, 480, 187, 31);
        frame.getContentPane().add(lblRezultatulFinalEste);

        rezultat = new JTextField();
        rezultat.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rezultat.setBounds(118, 521, 437, 55);
        frame.getContentPane().add(rezultat);
        rezultat.setColumns(10);

        JLabel lblSelectatiOperatiaDorita_1 = new JLabel("________________");
        lblSelectatiOperatiaDorita_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblSelectatiOperatiaDorita_1.setBounds(247, 586, 187, 31);
        frame.getContentPane().add(lblSelectatiOperatiaDorita_1);

        JLabel lblSelectatiOperatiaDorita_1_1 = new JLabel("_________");
        lblSelectatiOperatiaDorita_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblSelectatiOperatiaDorita_1_1.setBounds(286, 596, 200, 31);
        frame.getContentPane().add(lblSelectatiOperatiaDorita_1_1);

        JLabel lblSelectatiOperatiaDorita_1_1_1 = new JLabel("____");
        lblSelectatiOperatiaDorita_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblSelectatiOperatiaDorita_1_1_1.setBounds(307, 606, 200, 31);
        frame.getContentPane().add(lblSelectatiOperatiaDorita_1_1_1);
    }

    // PARSAREA

    public static Polinom parse(String polinomString){
        // Parse the polynomial string
        Polinom polinomFinal = new Polinom();
        Matcher matcher = Pattern.compile("([+-]?(?:(?:\\d+x\\^\\d+)|(?:x\\^\\d+)|(?:\\d+x)|(?:\\d+)|(?:x)))").matcher(polinomString);
        while (matcher.find()) {
            Polinom p =  new Polinom();
            p.addMonom(creareMonom(matcher.group()));
            polinomFinal = polinomFinal.adunare(polinomFinal, p);
        }

        return polinomFinal;
    }

    private static Monom creareMonom(String string) {
        double coeficient;
        int grad;

        // Caută indicii de unde încep și se termină coeficientul și gradul
        int coefStartIndex = 0, coefEndIndex = 0, gradStartIndex = 0, gradEndIndex = 0;
        boolean foundX = false, pozitiv = true;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(c == '+') {
                coefStartIndex = i + 1;
                pozitiv = true;
            }
            if(c == '-')
            {
                coefStartIndex = i;
                pozitiv = false;
            }
            if (c == 'x') {
                foundX = true;
                coefEndIndex = i;
            } else if (c == '^') {
                gradStartIndex = i + 1;
                gradEndIndex = string.length();
            }
        }
        if (!foundX) {
            // Dacă nu am găsit 'x', atunci coeficientul este întregul string
            coeficient = Double.parseDouble(string);
            grad = 0;
        } else if (gradEndIndex == 0) {
            // Dacă nu am găsit '^', atunci gradul este 1 și coeficientul este reprezentat de string-ul de dinaintea lui 'x'
            grad = 1;
            if(coefEndIndex == coefStartIndex) coeficient = 1.0;
            else if(coefEndIndex - coefStartIndex == 1 && pozitiv == false) coeficient = -1.0;
                 else coeficient = Double.parseDouble(string.substring(coefStartIndex, coefEndIndex));
        } else {
            // Altfel, gradul este reprezentat de string-ul după '^', iar coeficientul este reprezentat de string-ul între 'x' și '^'
            grad = Integer.parseInt(string.substring(gradStartIndex, gradEndIndex));
            if(coefEndIndex == coefStartIndex) coeficient = 1.0;
            else if(coefEndIndex - coefStartIndex == 1 && pozitiv == false) coeficient = -1.0;
                else coeficient = Double.parseDouble(string.substring(coefStartIndex, coefEndIndex));
        }
        return new Monom(coeficient, grad);
    }
}