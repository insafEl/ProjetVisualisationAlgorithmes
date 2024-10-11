package projet2.algorithme;

import projet2.Visualizer;

public class Gnome implements Algorithme{
    public int[] tab;
    public Visualizer vis;
 
    public Gnome(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis = vis;
    }

    public Gnome(){
       
    }
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
    
    /*le tri gnome un algorithme de tri simple. Il parcourt les éléments du tableau, 
    les comparant deux à deux et les échangeant si nécessaire pour les mettre dans le bon ordre. 
    Si un échange est effectué, l'algorithme recule d'une position pour réexaminer les éléments précédents. */
    @Override
    public int sort(){ 
        int index = 0; 
        int cpt=0;
        int accs = 0;
        int n = this.tab.length;
        while (index < n) { 
            if (index == 0) {
                index++; 
            }
            if (this.tab[index] >= this.tab[index - 1]) {
                index++; 
                cpt++;
            }
            else { 
                int temp = 0; 
                temp = this.tab[index]; 
                this.tab[index] = this.tab[index - 1]; 
                this.tab[index - 1] = temp;
                accs +=2; 
                index--; 
                cpt++;
                if (this.vis != null){
                    this.vis.modifierDonnee(this.tab,"Tri gnome",cpt,accs);
                    try{
                        Thread.sleep(10); 
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            } 
        } 
        return cpt;
    }
    
}