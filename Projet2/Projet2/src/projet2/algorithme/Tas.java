package projet2.algorithme;

import projet2.Visualizer;

public class Tas implements Algorithme {
    private int[] tab;
    private Visualizer vis;
    private int accs;
    private int cmt;
    
    public Tas(int[] tab, Visualizer vis) {
        this.tab = tab;
        this.vis = vis;
        this.accs = 0;
        this.cmt = 0;
    }

    public Tas() {
    }

    @Override
    public void setTab(int[] tab) {
        this.tab = tab;
    }

    /*
     * Cette fonction prend en entrée un tableau d'entiers et trie ses valeurs en
     * utilisant l'algorithme de tri par tas. elle commence par faire un tas en
     * utilisant la fonction entasser. on prend que les valeurs inférieures à la
     * taille du tableau/2 car le reste sont des feuilles. elle retourne le nombre
     * d'accès aux données.
     */

    @Override
    public int sort() {
        int n = this.tab.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            cmt += entasser(this.tab, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            echanger(this.tab, 0, i);
            cmt += entasser(this.tab, i, 0);
        }
        return cmt;
    }

    private int entasser(int[] tableau, int n, int i) {
        int max = i;
        int gauche = 2 * i + 1;
        int droite = 2 * i + 2; 
        if (this.vis != null){
        this.vis.modifierDonnee(this.tab,"Tri par tas",cmt,accs);
        try{
            Thread.sleep(10); 
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        }  
        cmt += 2;
        if (gauche < n && tableau[gauche] > tableau[max]) {
            max = gauche;
            accs += 2;
        }
        if (droite < n && tableau[droite] > tableau[max]) {
            max = droite;
            accs += 2;
        }
        if (max != i) {
            echanger(tableau, i, max);
            cmt += entasser(tableau, n, max);
        }
        accs += 2;
        return cmt;
    }

    private void echanger(int[] tableau, int i, int j) {
        int temp = tableau[i];
        tableau[i] = tableau[j];
        tableau[j] = temp;
        accs += 3;
    }
}
