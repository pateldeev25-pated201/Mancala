package Part1;

public class Node
{
	//initial variables
	int number;
	Node next;

	//constructor
	public Node(int number)
	{
		this.number = number;
		this.next = null;
    }

	//returns the number
	public Node getNext()
	{
		return next;
	}

	//set the next node
	public void setNext(Node node)
	{
		this.next = node;
	}
}
