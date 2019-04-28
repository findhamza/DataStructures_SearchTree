
public class Customer {

	private String name;
	private int number;
	
	public Customer() {
		name = null;
	}
	
	public Customer(String name, int number)
	{
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString()
	{
		return String.format("%-19s%18s","NAME: "+name,"|NUMBER: "+number+"|");
	}

	public boolean compareTo(Customer info)
	{
		if(name.compareTo(info.getName())>0)
			return true;
		else
			if(name.compareTo(info.getName())== 0)
				if(number>info.getNumber())
					return true;
		
		return false;
		
	}

}
