package GraphicalUserInterface;

import BusinessLogic.Operatii;
import DataModels.Monom;
import DataModels.Polynomial;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

public class Interfata {

    private JFrame frame;
    private JTextField polinom1TextField;
    private JTextField polinom2TextField;
    private Operatii operatii = new Operatii();

    public Interfata() {
        initialize();
    }

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

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(243, 222, 186));
        frame.setBounds(100, 100, 1000, 699);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelSus = new JPanel();
        panelSus.setBackground(new Color(243, 222, 186));
        panelSus.setLayout(new GridLayout(5, 1, 20, 20));

        JLabel lblTitle = new JLabel("Calculator polinomial");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        panelSus.add(lblTitle);

        JLabel lblExemplu = new JLabel("Exemplu de introducere a polinomului: 3.0x^2+2.0x^1-1");
        lblExemplu.setBackground(SystemColor.infoText);
        lblExemplu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblExemplu.setHorizontalAlignment(JLabel.CENTER);
        panelSus.add(lblExemplu);

        JLabel polinom1Label = new JLabel("POLINOM1");
        panelSus.add(polinom1Label);

        polinom1TextField = new JTextField();
        polinom1TextField.setBackground(new Color(171, 196, 170));
        panelSus.add(polinom1TextField);

        JLabel polinom2Label = new JLabel("POLINOM2");
        panelSus.add(polinom2Label);

        polinom2TextField = new JTextField();
        polinom2TextField.setBackground(new Color(171, 196, 170));
        panelSus.add(polinom2TextField);

        JLabel resultLabel = new JLabel("RESULT");
        panelSus.add(resultLabel, BorderLayout.WEST);
        frame.getContentPane().add(panelSus, BorderLayout.NORTH);

        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setBackground(new Color(171, 196, 170));
        panelSus.add(resultTextArea);

        JButton clearpoli1 = new JButton("Sterge Polinom1");
        clearpoli1.setBackground(new Color(169, 144, 126));
        panelSus.add(clearpoli1);
        clearpoli1.setHorizontalAlignment(JButton.CENTER);
        panelSus.add(clearpoli1);

        JButton clearpoli2 = new JButton("Sterge Polinom2");
        clearpoli2.setBackground(new Color(169, 144, 126));
        clearpoli1.setHorizontalAlignment(JButton.CENTER);
        panelSus.add(clearpoli2);

        frame.getContentPane().add(panelSus, BorderLayout.NORTH); //Adaug?m panoul cu componentele grafice în regiunea nord a layout-ului
        panelSus.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Setam marginile pentru panourile panelSus si panelCentral

        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(new Color(243, 222, 186));
        panelCentral.setLayout(new GridLayout(3, 2, 10, 10));


        JButton adunare = new JButton("ADUNARE");
        adunare.setBackground(new Color(169, 144, 126));
        panelCentral.add(adunare);

        JButton scadere = new JButton("SCADERE");
        scadere.setBackground(new Color(169, 144, 126));
        panelCentral.add(scadere);

        JButton inmultire = new JButton("INMULTIRE");
        inmultire.setBackground(new Color(169, 144, 126));
        panelCentral.add(inmultire);

        JButton impartire = new JButton("IMPARTIRE");
        impartire.setBackground(new Color(169, 144, 126));
        panelCentral.add(impartire);

        JButton derivare = new JButton("DERIVARE");
        derivare.setBackground(new Color(169, 144, 126));
        panelCentral.add(derivare);

        JButton integrare = new JButton("INTEGRARE");
        integrare.setBackground(new Color(169, 144, 126));
        panelCentral.add(integrare);

        frame.getContentPane().add(panelCentral, BorderLayout.CENTER);// Adaugam panoul cu butoane în regiunea centrala a layout-ului
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelJos = new JPanel();
        panelJos.setBackground(new Color(243, 222, 186));
        panelJos.setLayout(new BorderLayout(30, 30));
        panelJos.setLayout(new GridLayout(1, 1, 20, 20));
        frame.getContentPane().add(panelJos, BorderLayout.SOUTH);

        JButton exemplePoli1 = new JButton("Exemple de Polinom1");
        exemplePoli1.setBackground(new Color(169, 144, 126));
        exemplePoli1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] exemples = {"1x", "2x", "3x", "4x", "4x+1","4.6x+3", "1x^2", "2.2x^2+x^1", "1x^2+x", "12.0x^2+2x^1+4.5","3x^3+2x^1+4.5"};
                String polinom = (String) JOptionPane.showInputDialog(null, "Exemple de polinoame:", "Exemple de polinoame",
                        JOptionPane.PLAIN_MESSAGE, null, exemples, exemples[0]);
                if (polinom != null) {
                    polinom1TextField.setText(polinom);
                }
            }
        });

        panelJos.add(exemplePoli1);

        JButton exemplePoli2 = new JButton("Exemple de Polinom2");
        exemplePoli2.setBackground(new Color(169, 144, 126));
        exemplePoli2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] exemples = {"1x","1x^1","12x","2.4x^2+1x","1x^2+2x+1", "2x^3+5x^2-3x+1", "3x^4-6x^2+2","3.2x^2-6.3x^2+4"};
                String polinom = (String) JOptionPane.showInputDialog(null, "Exemple de polinoame:", "Exemple de polinoame",
                        JOptionPane.PLAIN_MESSAGE, null, exemples, exemples[0]);
                if (polinom != null) {
                    polinom2TextField.setText(polinom);
                }
            }
        });
        panelJos.add(exemplePoli2);

        frame.getContentPane().add(panelJos, BorderLayout.SOUTH);
        panelJos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        adunare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                //polynomial1 = operatii.parsePolynomial(polinom1TextField.getText());

                Polynomial polynomial2 = new Polynomial();
                //polynomial2 = operatii.parsePolynomial(polinom2TextField.getText());
                try{
                    polynomial1 = operatii.parsePolynomial(polinom1TextField.getText());
                    polynomial2 =operatii.parsePolynomial(polinom2TextField.getText());
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Ai introdus gresit polinomul", "EROARE!", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Exemplu de introducere a polinomului: 3.0x^2+2.0x^1-1", "Un mic reminder", JOptionPane.INFORMATION_MESSAGE);
                }
                Polynomial result = new Polynomial();
                result = operatii.adunare(polynomial1, polynomial2);
                resultTextArea.setText(result.toString());

            }
        });

        scadere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                try{
                    polynomial1 = operatii.parsePolynomial(polinom1TextField.getText());
                    polynomial2 =operatii.parsePolynomial(polinom2TextField.getText());
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Ai introdus gresit polinomul", "EROARE!", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Exemplu de introducere a polinomului: 3.0x^2+2.0x^1-1", "Un mic reminder", JOptionPane.INFORMATION_MESSAGE);
                }
                Polynomial result = new Polynomial();
                result = operatii.scadere(polynomial1, polynomial2);

                resultTextArea.setText(result.toString());

            }
        });

        inmultire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();

                Polynomial polynomial2 = new Polynomial();
                try{
                    polynomial1 = operatii.parsePolynomial(polinom1TextField.getText());
                    polynomial2 =operatii.parsePolynomial(polinom2TextField.getText());
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Ai introdus gresit polinomul", "EROARE!", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Exemplu de introducere a polinomului: 3.0x^2+2.0x^1-1", "Un mic reminder", JOptionPane.INFORMATION_MESSAGE);
                }

                Polynomial result = new Polynomial();
                result = operatii.inmultire(polynomial1, polynomial2);
                resultTextArea.setText(result.toString());
            }
        });

        impartire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Nu am implementat aceasta operatie!", "Dezavantaj", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        derivare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                try{
                    polynomial1 = operatii.parsePolynomial(polinom1TextField.getText());
                    polynomial2 =operatii.parsePolynomial(polinom2TextField.getText());
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Ai introdus gresit polinomul", "EROARE!", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Exemplu de introducere a polinomului: 3.0x^2+2.0x^1-1", "Un mic reminder", JOptionPane.INFORMATION_MESSAGE);
                }

                Polynomial result = new Polynomial();
                result = operatii.derivare(polynomial1);
                if (result.getPolinom().size() == 1 && (result.getPolinom().containsKey(0) && result.getPolinom().get(0).getCoeficient() == 0.0)) //verificam daca exista cheia 0 => a fost o constanta derivata, daca nu => exponent >=1
                {
                    resultTextArea.setText("0");
                }
                else {
                    resultTextArea.setText(result.toString());
                }
            }
        });

        integrare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Polynomial polynomial1 = new Polynomial();
                Polynomial polynomial2 = new Polynomial();
                try{
                    polynomial1 = operatii.parsePolynomial(polinom1TextField.getText());
                    polynomial2 =operatii.parsePolynomial(polinom2TextField.getText());
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null, "Ai introdus gresit polinomul", "EROARE!", JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(null, "Exemplu de introducere a polinomului: 3.0x^2+2.0x^1-1", "Un mic reminder", JOptionPane.INFORMATION_MESSAGE);
                }

                Polynomial result = new Polynomial();
                result = operatii.integrare(polynomial1);
                resultTextArea.setText(result.toString());
            }
        });

        clearpoli1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                polinom1TextField.setText("");
                resultTextArea.setText("");
            }
        });

        clearpoli2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                polinom2TextField.setText("");
                resultTextArea.setText("");
            }
        });
    }



}