
public class WaterMonitor 
{
    private double bathroomUsage;
    private double kitchenUsage;
    private double gardenUsage;

    public void addWaterUsage(int source, double amount) 
    {
        switch(source) 
        {
            case 1:
                bathroomUsage += amount;         break;                
            case 2:
                kitchenUsage += amount;          break;                
            case 3:
                gardenUsage += amount;           break;                
            default:
                System.out.println("Invalid Option.");
        }
    }

    public void showUsage() 
    {
        System.out.println("\n-- Water Usage Report --");
        System.out.println("Bathroom: " + bathroomUsage + " liters");
        System.out.println("Kitchen: " + kitchenUsage + " liters");
        System.out.println("Garden: " + gardenUsage + " liters");
    }

    public String getStatus() 
    {
        return "Bathroom: " + bathroomUsage + "L\n" +
               "Kitchen: " + kitchenUsage + "L\n" +
               "Garden: " + gardenUsage + "L\n";
    }

    public String getShortStatus() 
    {
        return "Bathroom: " + bathroomUsage + " liters, Kitchen: " + kitchenUsage +
               " liters, Garden: " + gardenUsage + " liters";
    }

    public double getTotalUsage() 
    {
        return bathroomUsage + kitchenUsage + gardenUsage;
    }
}
