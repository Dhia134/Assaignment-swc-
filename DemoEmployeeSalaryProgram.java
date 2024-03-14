
/**
 * Write a description of class DemoEmployeeSalaryProgram here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DemoEmployeeSalaryProgram {
    public static void main(String[] args) {
        String fileName = "C:/Users/HP/OneDrive/Documents/employeeSalaries.txt"; 

        try {
            Scanner scanner = new Scanner(new File(fileName));
            double highestSalary = Double.MIN_VALUE;
            String topEmployee = "";
            int leastYearsOfService = Integer.MAX_VALUE;
            String leastServiceEmployee = "";

            PrintWriter outputFile = new PrintWriter("employeeData.txt");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");

                String employeeName = tokens[0];
                double baseSalary = Double.parseDouble(tokens[1]);
                int yearsOfService = Integer.parseInt(tokens[2]);

                double annualSalary = baseSalary * Math.pow(1.05, yearsOfService);

                
                if (annualSalary > highestSalary) {
                    highestSalary = annualSalary;
                    topEmployee = employeeName;
                }

                // Update employee with least years of service
                if (yearsOfService < leastYearsOfService) {
                    leastYearsOfService = yearsOfService;
                    leastServiceEmployee = employeeName;
                }

                // Write to output file
                outputFile.println(employeeName + "," + annualSalary);
            }

            scanner.close();
            outputFile.close();

            
            System.out.println("Top-performing employee: " + topEmployee);
            System.out.println("Employee with least years of service: " + leastServiceEmployee);
            System.out.println("Results saved in employeeData.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + fileName);
        }
    }
}