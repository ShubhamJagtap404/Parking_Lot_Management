package controllers;

import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import dtos.ResponseStatus;
import models.Ticket;
import services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) {
        IssueTicketResponseDto responseDto = new IssueTicketResponseDto();
        try {
            Ticket ticket = ticketService.issueTicket(requestDto.getVehicleNumber(),
                    requestDto.getOwnerName(), requestDto.getGateId(), requestDto.getOperatorId());
            responseDto.setTicket(ticket);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FALIURE);
            responseDto.setTicket(null);
        }
        return responseDto;
    }
}
