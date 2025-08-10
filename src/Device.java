public class Device {
	
	//declare global variables
	private String SKU;
	private String Name;
	private boolean Avail;
			
	//create constructor method
	public Device()
	{
		Name = "";
		SKU = "";
		Avail = true;
	}
	
	//setName method
	public void setName(String Name)
	{	
		this.Name = Name;
	}
	
	//getName method
	public String getName()
	{		
		return Name;
	}
	
	//setSKU method
	public void setSKU(String SKU)
	{	
			this.SKU = SKU;
	}
	
	//getSKU method
	public String getSKU()
	{		
		return SKU;
	}
	
	//setdeviceAvail method
	public void setAvail(boolean Avail)
	{
		this.Avail = Avail;
	}
	
	//getdeviceAvail method
	public boolean getAvail()
	{
		return Avail;
	}
	//method to return availability string
	public String getAvailString(boolean Avail)
	{
		//if statement to determine what string will be returned depending on boolean
		if(Avail == true)
		{
			return "Available";
		}	
		else
		{
			return "Checked Out";
		}
	}
}
