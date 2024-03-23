package Repository;

import Model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {
    private static List<Ticket> tickets;
    private TicketRepository() {
        tickets = new ArrayList<>();
    }
    private static class Holder {
        public static TicketRepository instance = new TicketRepository();
    }
    public static TicketRepository getInstance() {
        return TicketRepository.Holder.instance;
    }

    public static void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
