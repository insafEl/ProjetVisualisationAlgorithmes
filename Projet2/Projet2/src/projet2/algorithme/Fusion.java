package projet2.algorithme;

import projet2.Visualizer;

public class Fusion implements Algorithme{
    public int[] tab;
    public Visualizer vis;

    public Fusion(int[] tab, Visualizer vis){
        this.tab = tab;
        this.vis = vis;
    }
    
    public Fusion(){
    }
    
    @Override
    public void setTab(int[] tab){
        this.tab = tab;
    }
    /*
     * Cette fonction prend en entrée un tableau et trie ses valeurs en utilisant l'algorithme de tri fusion.
     * elle divise le tableau en deux parties récursivement jusqu'à ce que chaque sous-tableau ait une taille de 1.
     * Ensuite, elle fusionne les sous-tableaux triés pour obtenir un tableau trié final.
     * elle retourne le nombre d'accés aux données.
     */
    @Override
    public int sort() {
        int cmt = 0 ;
        int accs = 0;
        int[] info;
        int longueur=this.tab.length;
        if (longueur>0){
            info = triFusion(this.tab,0,longueur-1);
            cmt +=  info[0];
            accs +=  info[1];
        }
        return cmt;
    }
    private int[] triFusion(int tableau[],int deb,int fin){
        int cmt = 0;
        int accs = 0;
        int[] info = new int[2];
        if (deb!=fin){
            int milieu=(fin+deb)/2;
            triFusion(tableau,deb,milieu);
            triFusion(tableau,milieu+1,fin);
            info = fusion(this.tab,deb,milieu,fin);
            cmt +=  info[0];
            accs +=  info[1];
        }
        return info;
    }
    private int[] fusion(int tableau[],int deb1,int fin1,int fin2){
        int[] info = new int[2];
        int cmt = 0;
        int accs = 0;
        int deb2=fin1+1;
        int table1[]=new int[fin1-deb1+1];
        for(int i=deb1;i<=fin1;i++){
            table1[i-deb1]=tableau[i];
        }
        int compt1=deb1;
        int compt2=deb2;
        for(int i=deb1;i<=fin2;i++){        
            if (compt1==deb2){
                cmt ++;
                break; 
            }
            else if (compt2==(fin2+1)){
                cmt +=2;
                tableau[i]=table1[compt1-deb1]; 
                accs ++;
                compt1++;
            }
            else if (table1[compt1-deb1]<tableau[compt2]){
                cmt += 3;
                tableau[i]=table1[compt1-deb1];
                accs ++;
                compt1++;
            }
            else{
                cmt += 4;
                tableau[i]=tableau[compt2];
                accs ++;
                compt2++;
            }
            if (this.vis != null){
                this.vis.modifierDonnee(this.tab,"Tri par fusion",cmt,accs);
                    try{
                        Thread.sleep(10); 
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
            }
        }
        info[0] = cmt;
        info[1] = accs;
        return info;
    }
    
}