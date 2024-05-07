import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Enum to represent different energy consumption levels
enum EnergyConsumptionLevel {
    LOW,
    MODERATE,
    HIGH
}

// Class to represent an energy-consuming device
class Device {
    private String name;
    private double powerConsumption;

    public Device(String name, double powerConsumption) {
        this.name = name;
        this.powerConsumption = powerConsumption;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getPowerConsumption() {
        return powerConsumption;
    }
}

// Class to represent the Smart Energy Management System
public class SmartEnergyManagementSystem {
    private Map<String, Device> deviceMap; // Map of device names to devices

    public SmartEnergyManagementSystem() {
        this.deviceMap = new HashMap<>();
        // Initialize with dummy data for demonstration purposes
        deviceMap.put("Lamp", new Device("Lamp", 10.0)); // Power consumption in watts
        deviceMap.put("Fridge", new Device("Fridge", 100.0));
        // Add more devices and their power consumption values as needed
    }

    // Method to estimate energy consumption level based on total power consumption
    public EnergyConsumptionLevel estimateEnergyConsumptionLevel(double totalPowerConsumption) {
        // For demonstration purposes, let's assume simple thresholds for energy consumption levels
        if (totalPowerConsumption <= 100) {
            return EnergyConsumptionLevel.LOW;
        } else if (totalPowerConsumption <= 500) {
            return EnergyConsumptionLevel.MODERATE;
        } else {
            return EnergyConsumptionLevel.HIGH;
        }
    }

    public static void main(String[] args) {
        SmartEnergyManagementSystem energyManagementSystem = new SmartEnergyManagementSystem();
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the names of devices and their respective power consumption values
        System.out.println("Enter the names of devices and their power consumption values (in watts):");
        System.out.println("Format: <Device Name> <Power Consumption>");
        System.out.println("Example: Lamp 10.0");
        System.out.println("Enter 'done' to finish input.");

        double totalPowerConsumption = 0.0;

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 2) {
                System.out.println("Invalid input format. Please try again.");
                continue;
            }
            String deviceName = parts[0];
            double powerConsumption = Double.parseDouble(parts[1]);
            energyManagementSystem.deviceMap.put(deviceName, new Device(deviceName, powerConsumption));
            totalPowerConsumption += powerConsumption;
        }

        // Estimate energy consumption level based on total power consumption
        EnergyConsumptionLevel energyConsumptionLevel = energyManagementSystem.estimateEnergyConsumptionLevel(totalPowerConsumption);
        System.out.println("Estimated Energy Consumption Level: " + energyConsumptionLevel);

        scanner.close();
    }
}
