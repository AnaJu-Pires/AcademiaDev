package Repository;


import java.util.Optional;
import java.util.List;

import Model.Support.SupportTicket;

public interface SupportTicketRepositoy {
    public void saveSupportTicket(SupportTicket supportTicket);

    public Optional<SupportTicket> peekTicket();
    public Optional<SupportTicket> resolveTicket();
    public List<SupportTicket> exportAllSupportTickets();
}


