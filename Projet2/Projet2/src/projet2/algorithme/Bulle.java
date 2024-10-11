package projet2.algorithme;

import projet2.Visualizer;

public class Bulle implements Algorithme{
    public int[] tab;
    public Visualizer vis;
  
    public Bulle(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis= vis;
    }
    
    public Bulle(){
       
    }
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
     
    /*
     * Cette fontion prend en entrée un tableau d'entiers et trie ses valeurs en utilisant l'algorithme de tri a bulle.
     * elle commence par parcourir le tableau et comparer les valeurs successives 2 à 2 en remontant la plus grande valeur
     * elle repète la même opération pour tout le tableau aprés chaque parcours.
     * elle retourne le nombre d'accés aux données.
     */
    @Override
    public int sort() {
        int cmt = 0;
        int accs = 0;
        int out, in;
        for (out = this.tab.length - 1; out > 0; out--){
            for (in = 0; in < out; in++) {
                cmt ++;
                if (this.vis != null){
                    vis.modifierDonnee(this.tab,"Tri à bulles",cmt,accs);
                    try 
                    {
                        Thread.sleep(10); // Attendre 100 millisecondes entre les itérations
                    } catch (InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                }
                if (this.tab[in] > this.tab[in + 1]){
                    echanger(this.tab, in, in + 1);
                    accs ++;
                }
            }
        }
        return cmt;
    }
    private static void echanger(int[] tableau, int i, int j){
        int temp = tableau[i];
        tableau[i] = tableau[j];
        tableau[j] = temp;
    }
    
}