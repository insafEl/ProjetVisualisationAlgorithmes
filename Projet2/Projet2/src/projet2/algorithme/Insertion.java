package projet2.algorithme;

import projet2.Visualizer;

public class Insertion implements Algorithme{
    public int[] tab;
    public Visualizer vis;
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
    
    public Insertion(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis = vis;
    }

    public Insertion(){

    }
    
    @Override
    public int sort() {
        int taille = this.tab.length;  
        int cmp = 0;
        int accs = 0;
        for(int i = 1; i < taille; i++){ 
            int index = this.tab[i];  
            int j = i-1;  
            while(j >= 0 && this.tab[j] > index)  
            {
                this.tab[j+1] = this.tab[j];  
                j--;  
                if (this.vis != null){
                    this.vis.modifierDonnee(this.tab,"Tri par insertion",cmp,accs);
                    try{
                        Thread.sleep(10); 
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    cmp++;
               }  
            }
            this.tab[j+1] = index; 
            accs ++;
        }
        return cmp;
    }
    
}