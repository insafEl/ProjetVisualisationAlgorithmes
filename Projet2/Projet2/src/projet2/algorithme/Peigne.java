package projet2.algorithme;

import projet2.Visualizer;

public class Peigne implements Algorithme{
    public int[] tab;
    public Visualizer vis;
 
    public Peigne(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis = vis;
    }
    
    public Peigne(){

    }
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
    
    /* le tri a peigne commence par definir un grand pas = taille du tableau /1.3 
    et compare les elements et les echange s'ils sont pas ordonnés et apres chaque passage le pas est reduit 
    jusqu'a ce qu'il atteigne une taille minimale*/
    
    @Override
        public int sort(){
        int n = this.tab.length;
        int gap = n;
        double shrink= 1.3;
        boolean swapped= true;
        int cpt=0;
        int accs = 0;
        while(gap !=1 || swapped  ){
            gap = (int)(gap/shrink);
            if (gap <=1){
                gap = 1;
            }
            swapped = false;
            for (int i=0;i<n-gap;i++){
                cpt++;
                if (this.vis != null){
                this.vis.modifierDonnee(this.tab,"Tri à peigne",cpt,accs);
                        try 
                        {
                            Thread.sleep(10); 
                        } catch (InterruptedException e) 
                        {
                            e.printStackTrace();
                        }}
                if (this.tab[i]>this.tab[i+gap]){
                    int temp= this.tab[i];
                    this.tab[i] = this.tab[i+gap];
                    this.tab[i+gap]=temp;
                    swapped= true;
                    accs += 2;
                }
            }
        }
    return cpt;
    }
        
}