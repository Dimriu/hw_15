import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket(
                "Симферополь",
                "Москва",
                5000,
                7,
                11
        );

        Ticket ticket2 = new Ticket(
                "Симферополь",
                "Москва",
                5500,
                8,
                11
        );

        System.out.println(ticket1.compareTo(ticket2));
        System.out.println(ticket2.compareTo(ticket1));
        Ticket[] tickets1 = {ticket1, ticket2};
        Arrays.sort(tickets1);

        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets2 = {ticket1, ticket2};
        Arrays.sort(tickets2, timeComparator);

    }

}
