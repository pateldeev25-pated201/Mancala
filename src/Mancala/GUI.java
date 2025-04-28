package Mancala;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
public class GUI extends JPanel
{
    JButton user1[];
    JButton user2[];
    JButton restart;
    JLabel user1Store;
    JLabel user2Store;
    JLabel playerTurn;
    GridBagConstraints constraints; 
    GridBagLayout layout; 
    //Create layout.  It's ugly, but it works
    public GUI()
    {
        user1 = new JButton[6];
        user2 = new JButton[6];
        restart = new JButton("Restart");
        playerTurn = new JLabel("Turn: Player 1");
        user1Store = new JLabel("0");
        user2Store = new JLabel("0");
        constraints = new GridBagConstraints();
        layout = new GridBagLayout();
        this.setLayout(layout);
        constraints.gridy = 0;
        this.add(playerTurn,constraints);
        for(int i =0; i < 6; i++)
        {
            user1[i] = new JButton("4");
            user2[i] = new JButton("4");
        }
        constraints.gridy = 1;
        this.add(user1Store,constraints);
        for(int i =0;i<6;i++)
        {
            constraints.gridx = i+1;
            this.add(user1[5-i],constraints);
        }
        constraints.gridx = 7;
        this.add(user2Store,constraints);
        constraints.gridy = 2;
        for(int i =0;i<6;i++)
        {
            constraints.gridx = i+1;
            this.add(user2[i],constraints);
        }

        //add restart button below the other button
        constraints.gridy = 3;
        constraints.gridx = 8;
        this.add(restart,constraints);


    }
}
