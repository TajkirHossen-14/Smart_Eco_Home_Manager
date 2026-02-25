
import java.util.ArrayList;
import java.util.Scanner;

public class Room 
{
    private String name;
    private ArrayList<Appliance> appliances;

    public Room(String name) 
    {
        this.name = name;
        appliances = new ArrayList<>();
    }

    public void addAppliance(Appliance appliance) 
    {
        appliances.add(appliance);
    }

    public void controlAppliances(Scanner scanner) 
    {
        while (true) 
        {
            System.out.println("\n--- " + name + " Appliances ---");
            
            for (int i = 0; i < appliances.size(); i++) 
            {
                System.out.println((i + 1) + ". " + appliances.get(i));
            }
            System.out.println("0. Go Back");
            System.out.print("Select Appliance Number to Toggle: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 0)         break;

            if (choice > 0 && choice <= appliances.size()) 
            {
                Appliance selected = appliances.get(choice - 1);
                selected.toggle();
                
                if (selected.isOn()) 
                {
                    System.out.println(selected.getName() + " is now ON");
                } 
                else 
                {
                    System.out.println(selected.getName() + " is now OFF");
                }
            } 
            else 
            {
                System.out.println("Invalid Choice!");
            }
        }
    }

    public double getEnergyConsumption() 
    {
        double total = 0;
        
        for (Appliance appliance : appliances) 
        {
            total += appliance.getEnergyConsumption();
        }
        return total;
    }

    public String getName() 
    {
        return name;
    }
}
