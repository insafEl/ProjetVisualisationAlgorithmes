package projet2.algorithme;

import projet2.Visualizer;

public class Selection implements Algorithme{
    public int[] tab;
    public Visualizer vis;
    
    public Selection(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis = vis;
    }

    public Selection(){
    }
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
    /*
     * Cette fontion prend en entrée un tableau d'entiers et trie ses valeurs en utilisant l'algorithme de tri par selection.
     * elle commence par parcourir le tableau et cherche la plus petite valeur et la place en première position.
     * puis il passe a la deuxième valeur et il repète la même opération jusqu'à la fin du tableau.
     * il retourne le nombre d'accés aux données.
     */
    
    @Override
    public int sort() {
        int cmt = 0;
        int accs = 0;
        for (int i = 0; i < this.tab.length - 1; i++) {
            int index = i;  
            for (int j = i + 1; j < this.tab.length; j++){
                cmt ++;
                if (this.vis != null){
                    this.vis.modifierDonnee(this.tab,"Tri par selection",cmt,accs);
                try{
                    Thread.sleep(10); 
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                }
                if (tab[j] < tab[index]){ 
                    index = j;
                }
            }
            int min = tab[index];
            tab[index] = tab[i]; 
            tab[i] = min;
            accs += 2;
        }
        return cmt;
    }
}