
public class SearchTree {

	public static void main(String[] args)
	{
		BinarySearchTree bsTree = new BinarySearchTree();

		System.out.println("INSERTION: ");
		bsTree.InsertBinarySearchTree(new Customer("McManus",2951492));
		bsTree.InsertBinarySearchTree(new Customer("Figueroa",2911864));
		bsTree.InsertBinarySearchTree(new Customer("Wimalasekara",2951601));
		bsTree.InsertBinarySearchTree(new Customer("Parker",2936122));
		bsTree.InsertBinarySearchTree(new Customer("Abo-Shear",2951882));
		bsTree.InsertBinarySearchTree(new Customer("Syed",2917890));
		bsTree.InsertBinarySearchTree(new Customer("Khadka",2948075));
		bsTree.InsertBinarySearchTree(new Customer("Musco",5843622));

		bsTree.FindCustomerIterative(new Customer("Musco",5843622));
		System.out.println(bsTree.FindCustomerRecursive(new Customer("Musco",5843622), new Node()));
		bsTree.FindCustomerIterative(new Customer("Parker",2936122));
		System.out.println(bsTree.FindCustomerRecursive(new Customer("Parker",2936122), new Node()));

		System.out.println();
		bsTree.printInOrder(new Customer("Figueroa",2911864));

		System.out.println("\nINSERTION: ");
		bsTree.InsertBinarySearchTree(new Customer("Bolen",2941568));
		bsTree.InsertBinarySearchTree(new Customer("Skinner",2941882));
		bsTree.InsertBinarySearchTree(new Customer("Krischke ",2956622));
		
		bsTree.printInOrder();
		
		bsTree.printPreOrder();
	}

}
