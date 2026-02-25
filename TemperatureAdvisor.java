
public class TemperatureAdvisor 
{
    public static void suggest(double temperature) 
    {
        System.out.println("Current Temperature : " + temperature + "°C");
        
        if (temperature > 30) 
        {
            System.out.println("It's Hot! Use Fan or AC and Stay Hydrated.");
        } 
        else if (temperature < 15) 
        {
            System.out.println("It's Cold! Close Windows, Use Heater or Wear Warm Clothes.");
        } 
        else 
        {
            System.out.println("Temperature is Moderate.");
        }
    }
}
