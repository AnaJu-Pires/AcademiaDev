package Repository.impl;

import java.util.Queue;
import java.util.LinkedList;

import Model.Support.SupportTicket;
import Repository.SupportTicketRepositoy;

public class SupportTicketRepositoyImpl implements SupportTicketRepositoy {
    private final Queue<SupportTicket> supportTickets = new LinkedList<>();

    

    @Override
    public void saveSupportTicket(SupportTicket supportTicket) {
        supportTickets.add(supportTicket);
        System.out.println("Support ticket saved.");
    }
}
