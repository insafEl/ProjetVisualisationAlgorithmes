package projet2.generateur;

import java.util.Random;

public class Generateur{
    public static int[] tableauAleatoire(int n) 
    {
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
			int index = (int) (Math.random() * n);
			int temp = list[i];
			list[i] = list[index];
			list[index] = temp;
		}
        return list;
    }
    
    public static int[] tableauPresqueTrie(int n) {
        int[] list = new int[n];
        Random random = new Random();
        for (int i = 0; i < n / 2; i++) {
            list[i] = i + 1; 
        }
        for (int i = n / 2; i < n; i++) {
            list[i] = i + 2;
        }
        int repetitions = n / 8;
        for (int r = 0; r < repetitions; r++) {
            int randomIndex1 = random.nextInt(n / 4) + 3 * n / 4;
            int randomIndex2 = random.nextInt(n / 4) + 3 * n / 4;
            echanger(list, randomIndex1, randomIndex2);
        }
        return list;
    }


    public static int[] tableauInverse(int n) {
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
			list[i] = n - i;
		}
        return list;
    }

    /* désordonné à p% */
    public static int[] tableauAvecDegreDesordre(int n, int p){
        Random random = new Random();
        int deg = p * n / 100;
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = i;
        }
        for (int i = 0; i < deg; i++) {
            int index1 = random.nextInt(n);
            int index2 = random.nextInt(n);
            echanger(list, index1, index2);
        }
        return list;
    }

    private static void echanger(int[] tableau, int i, int j) {
        int temp = tableau[i];
        tableau[i] = tableau[j];
        tableau[j] = temp;
    }

    public static void displayTab(int[] tab){
        for(int i=0; i < tab.length; i++)
        {  
             System.out.print(tab[i] + " ");  
        } 
        System.out.println();    
   }
}