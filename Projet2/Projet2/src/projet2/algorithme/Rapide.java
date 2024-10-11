package projet2.algorithme;

import projet2.Visualizer;

public class Rapide implements Algorithme {
    public int[] tab;
    public Visualizer vis;
    private int acc; 

    public Rapide(int[] tab, Visualizer vis) {
        this.tab = tab;
        this.vis = vis;
        this.acc = 0;
    }

    public Rapide() {
    }

    @Override
    public void setTab(int[] tab) {
        this.tab = tab;
    }

    @Override
    public int sort() {
        if (tab == null || tab.length <= 1)
            return 0;
        return triRapide(0, tab.length - 1);
    }

    private int triRapide(int debut, int fin) {
        int compteur = 0;
        if (debut < fin) {
            int pivotIndex = partitionner(debut, fin);
            compteur += pivotIndex - debut;
            compteur += fin - pivotIndex;
            compteur += triRapide(debut, pivotIndex - 1);
            compteur += triRapide(pivotIndex + 1, fin);
        }
         if (this.vis != null){
            this.vis.modifierDonnee(this.tab,"Tri rapide",compteur,acc);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return compteur;
    }

    private int partitionner(int debut, int fin) {
        int pivot = tab[fin];
        int i = debut - 1;
        for (int j = debut; j < fin; j++) {
            if (tab[j] <= pivot) {
                i++;
                echanger(i, j);
            }
            acc += 2;
        }
        echanger(i + 1, fin);
        acc += 2;
        return i + 1;
    }

    private void echanger(int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
        acc += 3;
    }
}