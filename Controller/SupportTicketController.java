package Controller;

import java.util.Optional;

import Controller.dto.SupportTicketDto;
import Exception.BusinessException;
import Service.SupportTicketService;

public class SupportTicketController {
    private final SupportTicketService supportTicketService;

    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    public void saveSupportTicket(SupportTicketDto supportTicket) {
        try {
            supportTicketService.saveSupportTicket(supportTicket);
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    public Optional<SupportTicketDto> getNextTicket() {
        return supportTicketService.findNextTicketInQueue();
    }

    public Optional<SupportTicketDto> resolveNextTicket() {
        return supportTicketService.resolveNextTicketInQueue();
    }
}
