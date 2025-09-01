package Controller;

import Controller.dto.SupportTicketDto;
import Service.SupportTicketService;

public class SupportTicketController {
    private final SupportTicketService supportTicketService;

    public SupportTicketController(SupportTicketService supportTicketService) {
        this.supportTicketService = supportTicketService;
    }

    public void saveSupportTicket(SupportTicketDto supportTicket) {
        try {
            supportTicketService.saveSupportTicket(supportTicket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
