package Mancala;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

public class Game implements ActionListener
{
    //Variable Setup
    GUI ui;
    Node head;
    Node probe;
    Boolean P1;
    LinkedList dean = new LinkedList(); //Dean asked me to name the object after him (even though he didn't do anything and the object doesn't do anything)

    //Constructor
    public Game()
    {
        this.head = null;
        this.probe = null;
        this.P1 = true;
        this.ui = new GUI();
        setNode();
        SetAction();
        SetGraphics();
    }
    //Check Win Conditions
    //Post a victory pop-up when either store P1 is full or store P2 is full
    private void CheckVictory()
    {
        //create temp variables to store the values of the stores
        int temp1;
        int temp2;
        int temp3;
        int temp4;
        int temp5;
        int temp6;
        int temp7;
        int temp8;
        probe = head;
        //if it's player 1's turn, we check the first 4 pockets, if it's player 2's turn we check the other four pockets
        if(P1)
        {
            for (int i = 0; i < 7; i++)
            {
                probe = probe.next;
            }
            temp1 = probe.number;
            probe = probe.next;
            temp2 = probe.number;
            probe = probe.next;
            temp3 = probe.number;
            probe = probe.next;
            temp4 = probe.number;
            probe = probe.next;
            temp5 = probe.number;
            probe = probe.next;
            temp6 = probe.number;
        }

        else
        {
            for (int i = 0; i < 7; i++)
            {
                probe = probe.next;
            }
            temp1 = probe.number;
            probe = probe.next;
            temp2 = probe.number;
            probe = probe.next;
            temp3 = probe.number;
            probe = probe.next;
            temp4 = probe.number;
            probe = probe.next;
            temp5 = probe.number;
            probe = probe.next;
            temp6 = probe.number;
        }
        
        //if a player can't make a move, the the number stones in each mancala are compared and the player with the most stones wins
        if(temp1 == 0 && temp2 == 0 && temp3 == 0 && temp4 == 0 && temp5 == 0 && temp6 == 0)
        {
            probe = head;
            for (int i = 0; i < 6; i++)
            {
                probe = probe.next;
            }   
            temp7 = probe.number;
            for (int i = 0; i < 6; i++)
            {
                probe = probe.next;
            }
            temp8 = probe.number;

            //if player 1's store is greater than player 2's store, then player 1 wins
            if(temp7 > temp8)
            {
                JOptionPane.showMessageDialog(null, "Player 1 Wins!");
                System.exit(0);
            }
            else if(temp7 < temp8)
            {
                JOptionPane.showMessageDialog(null, "Player 2 Wins!");
                System.exit(0);
            }
            else if(temp7 == temp8)
            {
                JOptionPane.showMessageDialog(null, "Tie!");
                System.exit(0);
            }
        }
        //set the probe back to the head
        probe = head;
    }
    
    //Left this in
    //was part of the starter code, is not commented
    private void SetGraphics()
    {
        probe = head;
        for(int i = 0; i <= 13; i++)
        {
            if(i == 6)
            {
                this.ui.user1Store.setText(""+this.probe.number);
            }
            else if(i==13)
            {
                this.ui.user2Store.setText(""+this.probe.number);
            }
            else
            {
                int temp = i-7;
                if(i<=5)
                {
                    this.ui.user1[i].setText(""+this.probe.number);
                }
                else if(i>6&&i<13)
                {
                    this.ui.user2[temp].setText(""+this.probe.number);
                }
            }
            this.probe = this.probe.next;
        }
        this.probe = this.head;
        if(P1)
        {
            this.ui.playerTurn.setText("Player 1 Turn");
        }
        else if(!P1)
        {
            this.ui.playerTurn.setText("Player 2 Turn");
        }
    }
    //Left the button Press
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for(int i =0;i<6;i++)
        {
            if(e.getSource() == this.ui.user1[i])
            {
                if(P1 && !ui.user1[i].getText().equals("0"))
                {
                    action(i);
                }
                else if (!P1)
                {
                    JOptionPane.showMessageDialog(null, "Not your turn");
                }
                else if(ui.user1[i].getText().equals("0"))
                {
                    JOptionPane.showMessageDialog(null, "You can't from move an empty pocket");
                }
            }
            if(e.getSource() == this.ui.user2[i])
            {
                if(!P1 && !ui.user1[i].getText().equals(0))
                {
                    action(i+7);
                }
                else if(P1)
                {
                    JOptionPane.showMessageDialog(null, "Not your turn");
                }
                else if(ui.user1[i].getText().equals("0"))
                {
                    JOptionPane.showMessageDialog(null, "You can't from move an empty pocket");
                }
            }
        }
        //add action for restart button
        if(e.getSource() == this.ui.restart)
        {
            System.out.println("Restarting");
            ResetGraphics();
            SetGraphics();
        }

    }
    private void ResetGraphics()
    {
        probe = head;
        for(int i = 0; i <= 13; i++)
        {
            if(i == 6)
            {
                this.probe.number = 0;
            }
            else if(i==13)
            {
                this.probe.number = 0;
            }
            else
            {
                this.probe.number = 4;
            }
            this.probe = this.probe.next;
        }
        this.probe = this.head;
        P1 = true;
        SetGraphics();
    }
    //Fill in code here.  You need to use the PlayGame(index) Method.
    //PlayGame can be modified.  I programmed it to work based on which button was pressed.  Usage code above
    private void action(int index)
    {
        //move the probe to the index of the button pressed
        for (int i = 0; i < index; i++)
        {
            probe = probe.getNext();
        }
        //set the temp variable to the number of stones in the pocket
        int temp = probe.number;
        //set the number of stones in the pocket to 0
        probe.number = 0;
        for (int i = 0; i < temp; i++)
        {
            //move the probe to the next pocket and increment the next pockets by 1
            probe = probe.next;
            probe.number++;
            //if the probe is at the end of the linked list, set it back to the head
            if(index + 1 > 13)
            {
                index = 0;
            }
            else 
            {
                index++;
            }
        }

        //final end of turn stuffs
        ChangeOpposite(index);
        CheckVictory();
        //if the last stone lands in the store, the player gets another turn, if not the turn is over and the other player goes
        if (index != 6 && index != 13)
        {
            P1 = !P1;
            CheckVictory();
        }
        PlayGame(index); //Mr Naccarato wants us to use linkedlists to save on memory, but im making this stupid line to use more memory
    }
    //This also needs to be filled in
    private void PlayGame(int index)
    {
        //You're going to need a lot of loops here to run through the pockets and stores
        //Set graphics once game is finished running
            SetGraphics();
    }
    //If the last Stone lands in an empty pocket, you take all the mancala pieces in the opponents side.  Specifically the 
    //pocket directly across.  You're going to have to traverse your linked list until you get to the opposite side.  
    //If I were coding this, I'd use a temp to store your probe, that way you have the initial spot saved while you probe to the
    //spot you need.
    private void ChangeOpposite(int index)
    {
        //the probe is currently at the pressed button, we store the value in a temp variable
        int temp = probe.number;
        //if the pocket has 1 stone in it (it had 0 but then 1 was just added) and it is not a mancala, then we can take the opposite pocket
        if(temp == 1 && index != 6 && index != 13)
        {
            //create a new probe that will go to the opposite side
            Node opposite = head;
            probe = head;
            for (int i = 0; i < 12 - index; i++)
            {
                opposite = opposite.next;
            }
            //store the opposite value in a temporary number
            int temp2 = opposite.number;
            opposite.number = 0;

            //add the two temp variables together and add them to the store
            probe = head;
            //if it is player 1's turn, then we add the stones to player 1's store
            if(P1)
            {
                for (int i = 0; i < 6; i++)
                {
                    probe = probe.next;
                }
                probe.number += temp2;
            }
            //if it is player 2's turn, then we add the stones to player 2's store
            else if(!P1)
            {
                for (int i = 0; i < 13; i++)
                {
                    probe = probe.next;
                }
                probe.number += temp2;
            }
            //set the probe back to the original pocket
            probe = head;
            opposite.number = 0;
        }
        SetGraphics();
    }


    private void SetAction() //Starter code, will not comment
    {
        //Set the action listeners for the buttons
        for(int i =0;i<6;i++)
        {
            this.ui.user1[i].addActionListener(this);
        }
        for(int i = 0 ; i < 6 ;i++)
        {
            this.ui.user2[i].addActionListener(this);
        }
    }
    //Create your Linked List here.  Your linked list needs to be circular so the last node.next needs to point back to the top
    private void setNode()
    {
        //create the first node, which is the head
        head = new Node(4);
        probe = head; //set the probe equal to the head
        for (int i = 0; i < 13; i++) //loop through 13 times to create the rest of the nodes
        {
            probe.setNext(new Node(4));
            //the mancalas are set to 0
            if(i == 5 || i == 12)
            {
                probe.setNext(new Node(0));
            }
            //move the probe to the next node
            probe = probe.next;
        }
        //set the last node to point back to the head
        probe.setNext(head);
    }
}
