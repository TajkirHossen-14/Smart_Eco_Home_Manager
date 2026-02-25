
import java.util.List;
import java.util.Scanner;

public class GreenEnergyManager 
{
    private double totalGenerated;

    public void generateEnergy(double temperature, double energyUsed, boolean isDaytime) 
    {
        double factor = 1.0;

        if (!isDaytime) 
        {
            factor *= 0.5;
        }

        if (temperature >= 30) 
        {
            factor *= 1.2;
        } 
        else if (temperature < 18) 
        {
            factor *= 0.7;
        }

        if (energyUsed > 1.5) 
        {
            factor *= 1.3;
        } 
        else if (energyUsed < 0.5) 
        {
            factor *= 0.8;
        }

        double generated = factor * 1.0;
        totalGenerated += generated;

        System.out.println("\n--- Green Energy Monitor ---");
        System.out.println("Daytime: " + (isDaytime ? "Yes" : "No"));
        System.out.printf("Total Energy Used: %.2f kWh\n", energyUsed);
        System.out.printf("Based on current conditions, green energy generated: %.2f kWh\n", generated);
    }

    public void monitorGreenEnergy(Scanner scanner, double temperature, List<Room> rooms) 
    {
        System.out.print("Is It Daytime? (Yes/No): ");
        String timeInput = scanner.nextLine();
        boolean isDaytime = timeInput.equalsIgnoreCase("Yes");

        double totalEnergyUsed = 0;
        for (Room room : rooms) 
        {
            totalEnergyUsed += room.getEnergyConsumption();
        }

        generateEnergy(temperature, totalEnergyUsed, isDaytime);
    }

    public double getTotalGenerated() 
    {
        return totalGenerated;
    }
}
