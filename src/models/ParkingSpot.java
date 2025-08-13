package models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    private int spotNumber;
    private ParkingFloor parkingFloor;
    private List<VehicleType> supportedVehicleType;
    private ParkingSpotStatus status;

}
