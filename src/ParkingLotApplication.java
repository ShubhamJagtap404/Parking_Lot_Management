import controllers.TicketController;
import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import factories.SpotAssignmentStrategyFactory;
import models.SpotAssignmentStrategyType;
import models.Ticket;
import models.VehicleType;
import repositories.GateRepository;
import repositories.VehicleRepository;
import services.TicketService;
import strategies.SpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        // Building the dependencies
        // controller -> service -> (gateRepo, vehicleRepo, spotAssStra)
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory
                .getSpotAssignmentStratey(SpotAssignmentStrategyType.RANDOM);
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, spotAssignmentStrategy);
        TicketController ticketController = new TicketController(ticketService);

        // Building the IssueTicketRequestDto object
        IssueTicketRequestDto issueTicketRequestDto = new IssueTicketRequestDto();
        issueTicketRequestDto.setGateId(123L);
        issueTicketRequestDto.setOperatorId(345L);
        issueTicketRequestDto.setVehicleNumber("MH12RX567");
        issueTicketRequestDto.setVehicleType(VehicleType.BIKE);
        issueTicketRequestDto.setOwnerName("ShubJ");

        IssueTicketResponseDto responseDto =null;

        // Triggering the issue ticket functionality
        responseDto = ticketController.issueTicket(issueTicketRequestDto);
        Ticket ticket = responseDto.getTicket();
    }
}
