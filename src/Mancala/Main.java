package Mancala;
import javax.swing.JFrame;

public class Main 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame();
        Game game = new Game();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Linked lists are stinky");
        frame.add(game.ui);
        frame.setVisible(true);
    }
}
