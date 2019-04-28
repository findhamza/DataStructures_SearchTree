
public class Node {

	private char lTag;
	private char rTag;
	private Node lLink;
	private Node rLink;
	private Object info;
	
	public Node()
	{
		info = null;
		lLink = this;
		rLink = this;
		lTag = '-';
		rTag = '+';
	}
	
	public Node(Object info)
	{
		this.info = info;
		lLink = this;
		rLink = this;
		lTag = '-';
		rTag = '+';
	}
	
	public Node(char lTag, Node lLink, Object info, Node rLink, char rTag)
	{
		this.info = info;
		this.lLink = lLink;
		this.rLink = rLink;
		this.lTag = lTag;
		this.rTag = rTag;
	}
	
	public void setRight(Node rLink, char rTag)
	{
		this.rLink = rLink;
		this.rTag = rTag;
	}
	
	public Node getRight()
	{
		return rLink;
	}
	
	public void setLeft(Node lLink, char lTag)
	{
		this.lLink = lLink;
		this.lTag = lTag;
	}
	
	public Node getLeft()
	{
		return lLink;
	}
	
	public void setRightTag(char rTag)
	{
		this.rTag = rTag;
	}
	
	public char getRightTag()
	{
		return rTag;
	}
	
	public void setLeftTag(char lTag)
	{
		this.lTag = lTag;
	}
	
	public char getLeftTag()
	{
		return lTag;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}
	
	public String toString()
	{
		return lTag+" "+((Customer) info).toString()+" "+rTag;
	}

}
