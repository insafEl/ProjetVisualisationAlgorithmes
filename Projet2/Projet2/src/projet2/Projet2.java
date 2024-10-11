package projet2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import projet2.algorithme.*;
import projet2.generateur.Generateur;

public class Projet2 extends JFrame implements ActionListener {
    JButton randomButton, inverseButton, presqueOrdonneButton, degreDesordreButton;
    JTextField degreDesordreField,tailleField;
    JCheckBox selectionCheckBox, bulleCheckBox,cocktailCheckBox,fusionCheckBox, gnomeCheckBox, insertionCheckBox, peigneCheckBox,rapideCheckBox;
    JCheckBox shellCheckBox, tasCheckBox;
    int[] tableau;
    
    public Projet2() {
        
        setTitle("Analyse des algorithmes de tri");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        degreDesordreField = new JTextField(10);
        tailleField = new JTextField(10);
        
        randomButton = new JButton("Aléatoire");
        inverseButton = new JButton("Inversé");
        presqueOrdonneButton = new JButton("Presque Ordonné");
        degreDesordreButton =new JButton("Aléatoire avec le pourcentage de désordre");
        selectionCheckBox = new JCheckBox("Tri par sélection");
        bulleCheckBox = new JCheckBox("Tri à bulles");
        cocktailCheckBox = new JCheckBox("Tri cocktail");
        fusionCheckBox = new JCheckBox("Tri par fusion");
        gnomeCheckBox = new JCheckBox("Tri gnome");
        insertionCheckBox = new JCheckBox("Tri par insertion");
        peigneCheckBox = new JCheckBox("Tri à peigne");
        rapideCheckBox = new JCheckBox("Tri rapide");
        shellCheckBox = new JCheckBox("Tri de shell");
        tasCheckBox = new JCheckBox("Tri par tas");

        randomButton.addActionListener(this);
        inverseButton.addActionListener(this);
        presqueOrdonneButton.addActionListener(this);
        degreDesordreButton.addActionListener(this);
        
        JLabel label0 = new JLabel("Entrer la taille du tableau (par défaut 100):");
        add(label0);
        add(tailleField);
        JLabel label1 = new JLabel("Choisir les algorithmes à visualiser:");
        add(label1);
        add(selectionCheckBox);
        add(bulleCheckBox);
        add(cocktailCheckBox);
        add(fusionCheckBox);
        add(gnomeCheckBox);
        add(insertionCheckBox);
        add(peigneCheckBox);
        add(rapideCheckBox);
        add(shellCheckBox);
        add(tasCheckBox);
        JLabel label2 = new JLabel("Choisir le niveau de désordre:");
        add(label2);
        add(randomButton);
        add(inverseButton);
        add(presqueOrdonneButton);
        JLabel label3 = new JLabel("Choisir le pourcentage de désordre (par défaut 70):");
        add(label3);
        add(degreDesordreField);
        add(degreDesordreButton);
        setVisible(true);
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {
        int taille;
        if (tailleField.getText().isEmpty()) {
            taille = 100;
        } else {
            taille=Integer.parseInt(tailleField.getText());
        }
        
        if (e.getSource() == randomButton) {
            tableau = Generateur.tableauAleatoire(taille); 
        } else if (e.getSource() == inverseButton) {
            tableau = Generateur.tableauInverse(taille); 
        } else if (e.getSource() == presqueOrdonneButton) {
            tableau = Generateur.tableauPresqueTrie(taille);
        } else if (e.getSource() == degreDesordreButton) {
            int degre;
            if (degreDesordreField.getText().isEmpty()) {
                degre = 70;
            } else {
                degre = Integer.parseInt(degreDesordreField.getText());
            }
            tableau = Generateur.tableauAvecDegreDesordre(taille, degre); 
        }
        System.out.print("Le tableu genere :");
        Generateur.displayTab(tableau);
        
        JFrame frame = new JFrame("Visualiseurs d'algorithmes");
        frame.setLayout(new GridLayout(2, 2)); 
            
            if (selectionCheckBox.isSelected()) {
                Visualizer visualizerSelection = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerSelection);
                Algorithme algoSelection = new Selection(tableau.clone(), visualizerSelection);
                Thread threadSelection = new Thread(() -> {
                    algoSelection.sort();
                });
                threadSelection.start();
            }
            if (bulleCheckBox.isSelected()) {
                Visualizer visualizerBulle = new Visualizer(tableau.clone());
                frame.getContentPane().add(visualizerBulle);
                Algorithme algoBulle = new Bulle(tableau.clone(), visualizerBulle);
                Thread threadBulle = new Thread(() -> {
                    algoBulle.sort();
                });
                threadBulle.start();
            }
            if (cocktailCheckBox.isSelected()) {
                Visualizer visualizerCocktail = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerCocktail); 
                Algorithme algoCocktail = new Cocktail(tableau.clone(),visualizerCocktail);
                Thread threadCocktail = new Thread(() -> {
                    algoCocktail.sort();
                });
                threadCocktail.start();
            }
            if (fusionCheckBox.isSelected()) {
                Visualizer visualizerFusion = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerFusion); 
                Algorithme algoFusion = new Fusion(tableau.clone(),visualizerFusion);
                Thread threadFusion = new Thread(() -> {
                    algoFusion.sort();
                });
                threadFusion.start();
            }
            if (gnomeCheckBox.isSelected()) {
                Visualizer visualizerGnome = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerGnome); 
                Algorithme algoGnome = new Gnome(tableau.clone(),visualizerGnome);
                Thread threadGnome = new Thread(() -> {
                    algoGnome.sort();
                });
                threadGnome.start();
            }
            if (insertionCheckBox.isSelected()) {
                Visualizer visualizerInsertion = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerInsertion);
                Algorithme algoInsertion = new Insertion(tableau.clone(),visualizerInsertion);
                Thread threadInsertion = new Thread(() -> {
                    algoInsertion.sort();
                });
                threadInsertion.start();
            }
            if (peigneCheckBox.isSelected()) {
                Visualizer visualizerPeigne = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerPeigne); 
                Algorithme algoPeigne = new Peigne(tableau.clone(),visualizerPeigne);
                Thread threadPeigne = new Thread(() -> {
                    algoPeigne.sort();
                });
                threadPeigne.start();
            }
            if (rapideCheckBox.isSelected()) {
                Visualizer visualizerRapide = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerRapide); 
                Algorithme algoRapide = new Rapide(tableau.clone(),visualizerRapide);
                Thread threadRapide = new Thread(() -> {
                    algoRapide.sort();
                });
                threadRapide.start();
            }
            if (shellCheckBox.isSelected()) {
                Visualizer visualizerShell = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerShell); 
                Algorithme algoShell = new Shell(tableau.clone(),visualizerShell);
                Thread threadShell = new Thread(() -> {
                    algoShell.sort();
                });
                threadShell.start();
            }
            if (tasCheckBox.isSelected()) {
                Visualizer visualizerTas = new Visualizer(tableau.clone()); 
                frame.getContentPane().add(visualizerTas); 
                Algorithme algoTas = new Tas(tableau.clone(),visualizerTas);
                Thread threadTas = new Thread(() -> {
                    algoTas.sort();
                    
                });
                threadTas.start();
            }
            frame.pack();
            frame.setVisible(true);
        }

    public static void main(String[] args) {
        Projet2 project2 = new Projet2();
    }
    
}
