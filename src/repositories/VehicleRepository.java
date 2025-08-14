package repositories;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    // Output Vheicle object will have id present
    public Vehicle save(Vehicle vehicle) {
            return null;
    }

    public Optional<Vehicle> findByVehicleId(Long id) {
        return null;
    }

    public Optional<Vehicle> findByVehicleNumber(String vehicleNumber) {
        return null;
    }
}
