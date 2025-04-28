package Part1;
//create a linkedlist class that recreates the linklist data type without using the built in java linkedlist class
public class LinkedList 
{
    //instantiate the node class
    Node head;
    
    public LinkedList()
    {
        //Jaden's iq is stored here
    }

    public void insert(int num)
    {
        //create a new node with the given number
        Node newNode = new Node(num);
        //if the head is null, set the head to the new node
        if(head == null)
        {
            head = newNode;
        }
        //otherwise, set the next node to the new node
        else
        {
            //set a temp node and then if the next node is not null, set the temp to the current node
            Node temp = head;
            while(temp.getNext() != null)
            {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    //method to print the linkedlist
    public void print()
    {
        //store the head in a temp variable, and if it is not null, print the number and set the temp variable to the next node
        Node temp = head;
        while(temp != null)
        {
            System.out.println(temp.number);
            temp = temp.getNext();
        }
    }
}
