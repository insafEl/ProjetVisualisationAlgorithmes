package projet2.algorithme;

import projet2.Visualizer;

public class Shell implements Algorithme{
    public int[] tab;
    public Visualizer vis;
 
    public Shell(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis = vis;
    }

    public Shell(){
    }
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
    /*
     * Cette fontion prend en entrée un tableau d'entiers et trie ses valeurs en utilisant l'algorithme de tri de shell.
     * cet algorithme est une amélioration du tri par insertion.
     * on tri en séparant le tableau de n position, puis en décremente ce n jusqu'à 1.
     * elle retourne le nombre d'accés aux données.
     */
    
    @Override
    public int sort() {
        int cmt = 0;
        int accs = 0;
        int longueur=this.tab.length;
        int n=0;
        while(n<longueur){
            n=3*n+1;
        }
        while(n!=0){
            n=n/3;
            for (int i=n;i<longueur;i++){
                int valeur=this.tab[i];
                int j=i;
                cmt++;
                if (this.vis != null){
                    this.vis.modifierDonnee(this.tab,"Tri de shell",cmt,accs);
                try{
                    Thread.sleep(10); 
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                }
                while((j>(n-1)) && (this.tab[j-n]>valeur)){
                    this.tab[j]=this.tab[j-n];
                    accs ++;
                    j=j-n;
                }
                this.tab[j]=valeur;
                accs ++;
            }
        }
        return cmt;
    }
    
}