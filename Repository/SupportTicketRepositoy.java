package Repository;


import java.util.Optional;

import Model.Support.SupportTicket;

public interface SupportTicketRepositoy {
    public void saveSupportTicket(SupportTicket supportTicket);

    public Optional<SupportTicket> peekTicket();
    public Optional<SupportTicket> resolveTicket();
}


