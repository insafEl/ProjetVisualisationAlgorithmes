package projet2;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import projet2.generateur.Generateur;
import projet2.algorithme.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.jfree.chart.ChartUtilities;
import java.io.File;
import java.awt.GridLayout;


public class Graphe {

    private static long timestamp;

    public static void startTimer() {
        timestamp = System.nanoTime();
    }

    public static double endTimer() {
        return (System.nanoTime() - timestamp) / 1000000.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisissez le type du tableau :");
        System.out.println("1. Random");
        System.out.println("2. Presque ordonné");
        System.out.println("3. Inversé");
        System.out.println("4. Avec degré de désordre");
        System.out.print("Entrez le numéro de votre choix : ");
        int choix = scanner.nextInt();
        int p = 0;
        if (choix == 4) {
            System.out.print("Entrez degré de désordre souhaité : ");
            p = scanner.nextInt();
        }

        Map<Integer, Algorithme> algorithmes = new HashMap<>();
        algorithmes.put(0, new Bulle());
        algorithmes.put(1, new Cocktail());
        algorithmes.put(2, new Fusion());
        algorithmes.put(3, new Gnome());
        algorithmes.put(4, new Insertion());
        algorithmes.put(5, new Peigne());
        algorithmes.put(6, new Rapide());
        algorithmes.put(7, new Selection());
        algorithmes.put(8, new Shell());
        algorithmes.put(9, new Tas());

        final int BULLE = 0, COCKTAIL = 1, FUSION = 2, GNOME = 3, INSERTION = 4, PEIGNE = 5, RAPIDE = 6, SELECTION = 7, SHELL = 8, TAS = 9;
        int max = 14, runs = 10;
        double[][] stats = new double[10][max];
        int[][] acces = new int[10][max];
        for (int i = 0; i < 10; i++) {
            switch (i) {
                case BULLE:
                    System.out.print("Execution tri bulle...");
                    break;
                case COCKTAIL:
                    System.out.print("Execution tri cocktail...");
                    break;
                case FUSION:
                    System.out.print("Execution tri fusion...");
                    break;
                case GNOME:
                    System.out.print("Execution tri gnome...");
                    break;
                case INSERTION:
                    System.out.print("Execution tri insertion...");
                    break;
                case PEIGNE:
                    System.out.print("Execution tri peigne...");
                    break;
                case RAPIDE:
                    System.out.print("Execution tri rapide...");
                    break;
                case SELECTION:
                    System.out.print("Execution tri selection...");
                    break;
                case SHELL:
                    System.out.print("Execution tri shell...");
                    break;
                case TAS:
                    System.out.print("Execution tri tas...");
                    break;
            }

            for (int j = 0; j < max; j++) {
                int[] ac = new int[runs];
                double avg = 0;
                for (int k = 0; k < runs; k++) {
                    int[] a;
                    switch (choix) {
                        case 1:
                            a = Generateur.tableauAleatoire((int) Math.pow(2, j + 1));
                            break;
                        case 2:
                            a = Generateur.tableauPresqueTrie((int) Math.pow(2, j + 1));
                            break;
                        case 3:
                            a = Generateur.tableauInverse((int) Math.pow(2, j + 1));
                            break;
                        case 4:
                            a = Generateur.tableauAvecDegreDesordre((int) Math.pow(2, j + 1), p);
                            break;
                        default:
                            System.out.println("Choix invalide. Utilisation d'un tableau aléatoire par défaut.");
                            a = Generateur.tableauAleatoire((int) Math.pow(2, j + 1));
                    }
                    startTimer();
                    algorithmes.get(i).setTab(a);
                    ac[i] = algorithmes.get(i).sort();
                    avg += endTimer();
                }
                avg /= runs;
                acces[i][j] = ac[i];
                stats[i][j] = avg;
            }
            System.out.println("ok.");
        }

        String[] triNames = {"Bulle", "Cocktail", "Fusion", "Gnome", "Insertion", "Peigne", "Rapide", "Selection", "Shell", "Tas"};

        XYSeriesCollection timeDataset = new XYSeriesCollection();
XYSeriesCollection accessDataset = new XYSeriesCollection();

for (int i = 0; i < 10; i++) {
    XYSeries timeSeries = new XYSeries(triNames[i] + " Temps");
    XYSeries accessSeries = new XYSeries(triNames[i] + " Comparaisons");

    for (int j = 0; j < max; j++) {
        timeSeries.add(Math.pow(2, j + 1), stats[i][j]);
        accessSeries.add(Math.pow(2, j + 1), acces[i][j]); // Ajout des données d'accès aux données
    }

    timeDataset.addSeries(timeSeries);
    accessDataset.addSeries(accessSeries);
}

// Création du graphique pour le temps moyen d'exécution
JFreeChart timeChart = ChartFactory.createXYLineChart(
        "Temps moyen d'exécution en fonction de n sur tableau aléatoire",
        "Taille du tableau (n)",
        "Temps moyen (ms)",
        timeDataset
);

// Création du graphique pour le nombre moyen de comparaisons
JFreeChart accessChart = ChartFactory.createXYLineChart(
        "Nombre moyen de comparaisons en fonction de n sur tableau aléatoire",
        "Taille du tableau (n)",
        "Nombre moyen de comparaisons",
        accessDataset
);

// Création et sauvegarde des fichiers image pour chaque graphique
File timeFile = new File("temps_moyens.png");
File accessFile = new File("comparaisons_moyennes.png");
try {
    ChartUtilities.saveChartAsPNG(timeFile, timeChart, 800, 600);
    ChartUtilities.saveChartAsPNG(accessFile, accessChart, 800, 600);
    System.out.println("Graphiques sauvegardés avec succès.");
} catch (Exception e) {
    System.err.println("Erreur lors de la sauvegarde des graphiques : " + e.getMessage());
}

// Création du panel pour les graphiques
JPanel chartPanel = new JPanel(new GridLayout(1, 2)); // Une ligne, deux colonnes

// Création du graphique pour le temps moyen d'exécution
ChartPanel timeChartPanel = new ChartPanel(timeChart);
timeChartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

// Création du graphique pour le nombre moyen de comparaisons
ChartPanel accessChartPanel = new ChartPanel(accessChart);
accessChartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

// Ajout des graphiques au panel
chartPanel.add(timeChartPanel);
chartPanel.add(accessChartPanel);

// Création de la fenêtre principale
SwingUtilities.invokeLater(() -> {
    JFrame frame = new JFrame("Graphiques");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(chartPanel); // Ajout du panel contenant les graphiques
    frame.pack();
    frame.setVisible(true);
});

        scanner.close();
    }
}
