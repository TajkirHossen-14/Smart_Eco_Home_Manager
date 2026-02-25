
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartEcoHomeManager 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        List<Room> rooms = new ArrayList<>();

        Room living = new Room("Living Room");
        living.addAppliance(new Appliance("Light", 0.1));
        living.addAppliance(new Appliance("Fan", 0.2));
        living.addAppliance(new Appliance("TV", 0.15));
        rooms.add(living);

        Room bedroom = new Room("Bedroom");
        bedroom.addAppliance(new Appliance("Light", 0.1));
        bedroom.addAppliance(new Appliance("Fan", 0.2));
        rooms.add(bedroom);

        Room kitchen = new Room("Kitchen");
        kitchen.addAppliance(new Appliance("Light", 0.05));
        kitchen.addAppliance(new Appliance("Fridge", 0.15));
        kitchen.addAppliance(new Appliance("Exhaust Fan", 0.08));
        rooms.add(kitchen);

        WaterMonitor waterMonitor = new WaterMonitor();
        GreenEnergyManager greenEnergy = new GreenEnergyManager();
        Double currentTemperature = null;

        while (true) 
        {
            System.out.println("\n- | Smart Eco Home Manager | -\n");
            System.out.println("1. Control Room Appliances");
            System.out.println("2. Monitor Water Usage");
            System.out.println("3. Monitor Green Energy");
            System.out.println("4. Temperature Advisor");
            System.out.println("5. Show Report");
            System.out.println("6. Save Report to File");
            System.out.println("0. Exit");
            System.out.print("\nEnter Option : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) 
            {
                case 1:
                    System.out.println("\nSelect Room :");
                    for (int i = 0; i < rooms.size(); i++) 
                    {
                        System.out.println((i + 1) + ". " + rooms.get(i).getName());
                    }
                    System.out.print("Enter Room Number: ");
                    int roomChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (roomChoice > 0 && roomChoice <= rooms.size()) 
                    {
                        rooms.get(roomChoice - 1).controlAppliances(scanner);
                    } 
                    else 
                    {
                        System.out.println("Invalid Room.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Water Usage ---");
                    System.out.println("1. Bathroom\n2. Kitchen\n3. Garden");
                    System.out.print("Select Source: ");
                    int source = scanner.nextInt();
                    System.out.print("Enter amount (liters): ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    waterMonitor.addWaterUsage(source, amount);
                    break;

                case 3:
                	if (currentTemperature == null) 
                	{
                        System.out.print("Enter Current Temperature (°C): ");
                        currentTemperature = scanner.nextDouble();
                        scanner.nextLine();
                    }
                    greenEnergy.monitorGreenEnergy(scanner, currentTemperature, rooms);
                    break;

                case 4:
                    System.out.print("Enter Current Temperature (°C): ");
                    currentTemperature = scanner.nextDouble();
                    scanner.nextLine();
                    TemperatureAdvisor.suggest(currentTemperature);
                    break;

                case 5:
                    System.out.println("\n=== Smart Eco Home Report ===");
                    double totalEnergy = 0;
                    for (Room room : rooms) 
                    {
                        totalEnergy += room.getEnergyConsumption();
                    }
                    System.out.printf("Total Energy Consumption : %.2f kWh\n", totalEnergy);
                    System.out.printf("Total Green Energy Generated : %.2f kWh\n", greenEnergy.getTotalGenerated());
                    System.out.printf("\nWater Used : %.0f liters [ %s]\n",
                            waterMonitor.getTotalUsage(),
                            waterMonitor.getShortStatus());
                    if (currentTemperature != null) 
                    {
                        TemperatureAdvisor.suggest(currentTemperature);
                    } 
                    else 
                    {
                        System.out.println("Temperature Data Not Available.");
                    }
                    break;

                case 6:
                    String report = "=== Smart Eco Home Report ===\n";
                    double energy = 0;
                    for (Room room : rooms) 
                    {
                        energy += room.getEnergyConsumption();
                    }
                    report += String.format("Total Energy Consumption : %.2f kWh\n", energy);
                    report += String.format("Total Green Energy Generated : %.2f kWh\n", greenEnergy.getTotalGenerated());
                    report += "\nWater Used : " + waterMonitor.getTotalUsage() + " liters\n" + waterMonitor.getStatus();
                    if (currentTemperature != null) 
                    {
                        report += String.format("\nTemperature: %.1f°C\n", currentTemperature);
                    } 
                    else 
                    {
                        report += "\nTemperature: Not Provided\n";
                    }
                    FileManager.saveReport(report);
                    break;

                case 0:
                    System.out.println("Exiting Smart Eco Home Manager.");
                    return;

                default:
                    System.out.println("Invalid Option. Try Again.");
            }
        }
    }
}
