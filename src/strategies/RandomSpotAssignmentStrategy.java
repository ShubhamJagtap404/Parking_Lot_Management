package strategies;

import models.*;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        for(ParkingFloor floor : parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot : floor.getParkingSpots()) {
                if(parkingSpot.getSupportedVehicleType().contains(vehicle.getVehicleType())
                && parkingSpot.getStatus().equals(ParkingSpotStatus.EMPTY)) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
