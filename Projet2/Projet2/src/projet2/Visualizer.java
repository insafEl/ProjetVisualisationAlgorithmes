package projet2;

import javax.swing.*;
import java.awt.*;

public class Visualizer extends JPanel 
{
    private int[] donnee;
    private String comment;
    private int cmt;
    private int accs;
    public Visualizer(int[] donnee) 
    {
        this.donnee = donnee;
        setPreferredSize(new Dimension(1000, 1000));
    }
    
    public void modifierDonnee(int[] nouvelleDonnee,String nouvComment, int cmt,int accs) 
    {
        this.donnee = nouvelleDonnee;
        this.comment=nouvComment;
        this.cmt=cmt;
        this.accs=accs;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        Font font1 = new Font("Arial", Font.BOLD, 20);
        g.setFont(font1);
        g.drawString(comment, 20, 20);
        g.setColor(Color.BLACK);
        Font font2 = new Font("Arial", Font.BOLD, 15);
        g.setFont(font2);
        g.drawString("Nombre de comparaisons: "+String.valueOf(cmt), 20, 40);
        g.drawString("Accès aux données: "+String.valueOf(accs), 20, 60);
        
        int largeurBarre = getWidth() / donnee.length;
        
        int valeurMax = Integer.MIN_VALUE;
        for (int valeur : donnee) 
        {
            if (valeur > valeurMax) 
            {
                valeurMax = valeur;
            }
        }
        for (int i = 0; i < donnee.length; i++) 
        {
            int hauteurBarre = (int) ((double) donnee[i] / valeurMax * getHeight());
            int x = i * largeurBarre;
            int y = getHeight() - hauteurBarre;
            g.setColor(Color.MAGENTA);
            g.fillRect(x, y, largeurBarre, hauteurBarre);
            g.setColor(Color.YELLOW);
            g.drawRect(x, y, largeurBarre, hauteurBarre);
        }
    }
    
}


