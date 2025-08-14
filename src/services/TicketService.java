package services;

import exceptions.GateNotFoundException;
import models.Gate;
import models.Ticket;
import models.Vehicle;
import repositories.GateRepository;
import repositories.VehicleRepository;
import strategies.SpotAssignmentStrategy;

import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public Ticket issueTicket(String vehicleNumber,
                              String ownerName,
                              Long gateId,
                              Long operatorId) throws GateNotFoundException {
        Ticket ticket = new Ticket();

        Optional<Gate> gateOptional = gateRepository.findByGateId(gateId);
        if(gateOptional.isEmpty()) {
            throw new GateNotFoundException("Gate with id " + gateId + " is invalid");
        }
        Gate gate = gateOptional.get();
        ticket.setGate(gate);
        ticket.setOperator(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle = null;
        if(optionalVehicle.isEmpty()) {
            Vehicle newVehicle = new Vehicle();
            newVehicle.setNumber(vehicleNumber);
            newVehicle.setOwnerName(ownerName);
            vehicle = vehicleRepository.save(newVehicle);
        }else {
            vehicle = optionalVehicle.get();
        }
        ticket.setVehicle(vehicle);
        ticket.setParkingSpot(spotAssignmentStrategy.assignParkingSpot(gate.getParkingLot(), vehicle));
        return ticket;
    }
}
