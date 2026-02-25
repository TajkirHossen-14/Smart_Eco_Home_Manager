
public class Appliance 
{
    private String name;
    private boolean isOn;
    private double energyConsumption;

    public Appliance(String name, double energyConsumption) 
    {
        this.name = name;
        this.energyConsumption = energyConsumption;
        this.isOn = false;
    }

    public void toggle() 
    {
    	if (isOn == true) 
    	{
    	    isOn = false;
    	} 
    	else 
    	{
    	    isOn = true;
    	}
    }

    public boolean isOn() 
    {
        return isOn;
    }

    public double getEnergyConsumption() 
    {
    	if (isOn) 
    	{
            return energyConsumption;
        } 
    	else 
    	{
            return 0;
        }
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() 
    {
    	if (isOn == true)
            return name + " [ON]";
        else
            return name + " [OFF]";
    }
}
