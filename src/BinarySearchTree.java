import java.util.Stack;

public class BinarySearchTree {
	
	private Node headNode;
	@SuppressWarnings("unused")
	private Node currNode;
	@SuppressWarnings("unused")
	private int nodeCount;
	
	BinarySearchTree()
	{
		headNode = new Node();
		currNode = headNode;
	}

	public void InsertBinarySearchTree(Object item)
	{
		Node temp = headNode.getLeft();
		Node q = new Node(item);
		String str = ((Customer) item).getName();
		
		if(headNode.getLeftTag() == '-')
		{
			insertLeft(headNode,q);
//			System.out.println(headNode.getLeft().getInfo().toString());
		}

		else
		{				
//			System.out.println("\n"+temp.toString()+"\n");
			//boolean greater = ((Customer) q.getInfo()).compareTo((Customer) temp.getInfo());
			int val = ((Customer) temp.getInfo()).getName().compareTo(str);
			while(temp != headNode)
			{
//				System.out.println(((Customer) item).getName());
//				System.out.println("\n"+temp.toString()+"\n");

				val = ((Customer) temp.getInfo()).getName().compareTo(str);
				if(val>0)
				{
					if(temp.getLeftTag() == '-')
					{
						insertLeft(temp,q);
						break;
					}
					else
						temp = temp.getLeft();
				}
				else if(val<0)
				{
					if(temp.getRightTag() == '-')
					{
						insertRight(temp,q);
						break;
					}
					else
						temp = temp.getRight();
				}
			}
			
		}
		
		
		
		incrementCount();
	}
	
	private void insertRight(Node p, Node q) 
	{
		System.out.println("IR USED\t\t"+((Customer)q.getInfo()).toString());
		q.setRight(p.getRight(), p.getRightTag());
		p.setRight(q, '+');
		q.setLeft(p, '-');
		
		if(q.getRightTag() == '+')
			InOrderSuccesor(q).setLeft(q, '-');
	}
	
	private void insertLeft(Node p, Node q)
	{
		System.out.println("IL USED\t\t"+((Customer)q.getInfo()).toString());
		q.setLeft(p.getLeft(), p.getLeftTag());
		p.setLeft(q, '+');
		q.setRight(p, '-');
		
		if(q.getLeftTag() == '+')
			InOrderSuccesor(q).setRight(q, '-');
	}

	public Node FindCustomerIterative(Object item)
	{
		String str = ((Customer) item).getName();
		int val = 0;
		
		Node temp = headNode.getLeft();
		((Customer) temp.getInfo()).compareTo(((Customer) item));
		while(temp != headNode)
		{
			val = ((Customer) temp.getInfo()).getName().compareTo(str);
			if(val>0)
			{
				temp = temp.getLeft();
//				System.out.println(temp.toString());
			}
			else if(val<0)
			{
				temp = temp.getRight();
//				System.out.println(temp.toString());
			}
			else
			{
				System.out.println("\nFound Using Iterative\n"+((Customer)temp.getInfo()).toString());
				return temp;
			}
		}
		
		return headNode;
		
	}

	public String FindCustomerRecursive(Object item, Node temp)
	{
		if(temp.getInfo() == null)
			temp = headNode.getLeft();
		String str = ((Customer) item).getName();
		int val = ((Customer) temp.getInfo()).getName().compareTo(str);
		
		if(val>0)
			return FindCustomerRecursive(item,temp.getLeft());
		else if(val<0)
			return FindCustomerRecursive(item,temp.getRight());
		else
			return "\nFound Using Recursive\n"+((Customer)temp.getInfo()).toString();
		
	}

	private Node InOrderSuccesor(Node temp)
	{
//		System.out.println("IOS USED");
		Node q = temp.getRight();
		
		if(temp.getRightTag() == '-')
			return temp;
		else
			while(q.getLeftTag() == '+')
			{
				q = q.getLeft();
			}
		
		return q;
	}
	
	private Node PreOrderSuccesor(Node temp)
	{
		Node q;
		if(temp.getLeftTag() == '+')
			return temp.getLeft();
		else
		{
			q = temp;
			while(q.getRightTag() != '+')
				q = q.getRight();
			q = q.getRight();
		}
		return q;
			
	}

	private void incrementCount()
	{
		nodeCount++;
	}

	public void printInOrder(Customer customer)
	{
		Stack<Node> stack = new Stack<Node>();
		System.out.println("\nIn Order Print Starting With "+customer.getName());
		Node temp = FindCustomerIterative(customer);
		Node start = temp;
		
		do {
			temp = InOrderSuccesor(temp);
			if(!stack.contains(temp))
			{
				System.out.println(temp);
				stack.push(temp);
			}
			temp = temp.getRight();
			if(!stack.contains(temp) && temp.getInfo() != null)
			{
				System.out.println(temp);
				stack.push(temp);
			}
		}while( temp != start );
		
	}
	
	public void printInOrder()
	{
		Stack<Node> stack = new Stack<Node>();
		System.out.println("\nIn Order Print Starting With Head Node");
		Node temp = headNode;
		Node start = temp;
		
		do {
			temp = InOrderSuccesor(temp);
			if(!stack.contains(temp))
			{
				System.out.println(temp);
				stack.push(temp);
			}
			temp = temp.getRight();
			if(!stack.contains(temp) && temp.getInfo() != null)
			{
				System.out.println(temp);
				stack.push(temp);
			}
		}while( temp != start );
		
	}

	public void printPreOrder()
	{
		Stack<Node> stack = new Stack<Node>();
		System.out.println("\nPre Order Print Starting With Head Node");
		Node temp = headNode;
		Node start = temp;
		
		do {
			temp = PreOrderSuccesor(temp);
			if(!stack.contains(temp) && temp.getInfo() != null)
			{
				System.out.println(temp);
				stack.push(temp);
			}
//			temp = temp.getLeft();
			if(!stack.contains(temp) && temp.getInfo() != null)
			{
				System.out.println(temp);
				stack.push(temp);
			}
		}while( temp != start );
	}

}
