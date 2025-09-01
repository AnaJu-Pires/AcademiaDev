package Repository.impl;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import Model.Support.SupportTicket;
import Repository.SupportTicketRepositoy;

public class SupportTicketRepositoyImpl implements SupportTicketRepositoy {
    private final Queue<SupportTicket> supportTickets = new LinkedList<>();

    @Override
    public void saveSupportTicket(SupportTicket supportTicket) {
        supportTickets.add(supportTicket);
        System.out.println("Support ticket saved.");
    }

    @Override
    public Optional<SupportTicket> peekTicket() {
        return Optional.ofNullable(supportTickets.peek());
    }

    @Override
    public Optional<SupportTicket> resolveTicket() {
        return Optional.ofNullable(supportTickets.poll());
    }

    @Override
    public List<SupportTicket> exportAllSupportTickets() {
        List<SupportTicket> supportTickets = new ArrayList<>(this.supportTickets.size());
        supportTickets.addAll(this.supportTickets);
        return supportTickets;
    }
}
