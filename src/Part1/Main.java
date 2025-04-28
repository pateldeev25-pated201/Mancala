package Part1;
import java.util.Scanner;
/*
Name: Deev Patel
Course: ICS4UE
Teacher: Naccarato
Due Date: May 22 2023
Program summary: Create a Custom LinkedList class
*/

public class Main
{
    public static void main(String[] args)
    {
        //instantiate the needed classes
        LinkedList linkNotFromZelda = new LinkedList();
        Scanner in = new Scanner(System.in);

        //loop that runs 5 times to take an input and add it to the linked list
        for(int i = 0; i < 5; i++)
        {
            System.out.println("Enter a number: ");
            int num = in.nextInt();
            linkNotFromZelda.insert(num);
        }

        linkNotFromZelda.print();
    }
}