
import java.io.FileWriter;
import java.io.IOException;

public class FileManager 
{
    public static void saveReport(String report) 
    {
        try (FileWriter writer = new FileWriter("EcoHomeReport.txt")) 
        {
            writer.write(report);
            System.out.println("Report Saved to EcoHomeReport.txt");
        } 
        catch (IOException e) 
        {
            System.out.println("Error Saving Report: " + e.getMessage());
        }
    }
}
