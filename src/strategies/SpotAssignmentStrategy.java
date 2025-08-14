package strategies;

import models.ParkingLot;
import models.ParkingSpot;
import models.Vehicle;

public interface SpotAssignmentStrategy {
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
