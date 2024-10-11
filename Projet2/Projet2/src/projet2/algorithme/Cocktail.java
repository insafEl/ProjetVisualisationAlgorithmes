package projet2.algorithme;

import projet2.Visualizer;

public class Cocktail implements Algorithme{
    public int[] tab;
    public Visualizer vis;
    
    public Cocktail(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis = vis;
    }

    public Cocktail(){
        
    }
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
    
    @Override
    public int sort() {
        int cmt = 0;
        int accs = 0;
        boolean echangé = true;
        while (echangé) {
            echangé = false;
            // Tri ascendant
            for (int i = 0; i < this.tab.length - 1; i++) {
                cmt ++;
                if (this.vis != null){
                    this.vis.modifierDonnee(this.tab,"Tri cocktail",cmt,accs);
                    try{
                        Thread.sleep(10); 
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                if (this.tab[i] > this.tab[i + 1]) {
                    // Échanger les éléments
                    int temp = this.tab[i];
                    this.tab[i] = this.tab[i + 1];
                    this.tab[i + 1] = temp;
                    echangé = true;
                    accs ++;
                }
            }
            if (!echangé){
                break;
            }
            echangé = false;
            // Tri descendant
            for (int i = this.tab.length - 2; i >= 0; i--){
                cmt++;
                if (this.tab[i] > this.tab[i + 1]) {
                    // Échanger les éléments
                    int temp = this.tab[i];
                    this.tab[i] = this.tab[i + 1];
                    this.tab[i + 1] = temp;
                    echangé = true;
                    accs ++;
                }
            }
        }
        return cmt;
    }
    
}