import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


public class AviaSoulsTest {
    AviaSouls repository = new AviaSouls();
    Ticket ticket1 = new Ticket("Симферополь", "Москва", 5000, 7, 11);
    Ticket ticket2 = new Ticket("Симферополь", "Москва", 5500, 8, 11);
    Ticket ticket3 = new Ticket("Симферополь", "Санкт-Петербург", 12000, 9, 12);
    Ticket ticket4 = new Ticket("Симферополь", "Минск", 8000, 10, 13);
    Ticket ticket5 = new Ticket("Симферополь", "Москва", 5500, 11, 13);
    Ticket ticket6 = new Ticket("Симферополь", "Санкт-Петербург", 8000, 12, 17);
    Ticket ticket7 = new Ticket("Симферополь", "Минск", 10000, 13, 15);
    Ticket ticket8 = new Ticket("Симферополь", "Москва", 10000, 14, 15);
    Ticket ticket9 = new Ticket("Симферополь", "Санкт-Петербург", 10000, 15, 19);
    Ticket ticket10 = new Ticket("Симферополь", "Санкт-Петербург", 8200, 16, 22);
    Ticket ticket11 = new Ticket("Симферополь", "Краснодар", 4000, 17, 18);
    Ticket ticket12 = new Ticket("Симферополь", "Краснодар", 4000, 18, 19);
    Ticket ticket13 = new Ticket("Симферополь", "Самара", 9000, 20, 22);



    @BeforeEach
    public void setup() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);
        repository.add(ticket7);
        repository.add(ticket8);
        repository.add(ticket9);
        repository.add(ticket10);
        repository.add(ticket11);
        repository.add(ticket12);
        repository.add(ticket13);
    }

    @Test
    public void shouldAllTickets() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10, ticket11, ticket12, ticket13};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMethodCompareToReturnsMinusOne() {
        System.out.println(ticket1.compareTo(ticket2));
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMethodCompareToReturnsOne() {
        System.out.println(ticket2.compareTo(ticket1));
        int expected = 1;
        int actual = ticket2.compareTo(ticket1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMethodCompareToReturnsZero() {
        System.out.println(ticket2.compareTo(ticket5));
        int expected = 0;
        int actual = ticket2.compareTo(ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMethodSearchTicketsInAscendingOrderOfPriceDirectionMoscow() {
        Ticket[] expected = {ticket1, ticket2, ticket5, ticket8};
        Ticket[] actual = repository.search("Симферополь", "Москва");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testMethodSearchTicketsInAscendingOrderOfPriceDirectionSaintPetersburg() {
        Ticket[] expected = {ticket6, ticket10, ticket9, ticket3};
        Ticket[] actual = repository.search("Симферополь", "Санкт-Петербург");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMethodSearchTicketsInAscendingOrderOfPriceDirectionMinsk() {
        Ticket[] expected = {ticket4, ticket7};
        Ticket[] actual = repository.search("Симферополь", "Минск");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMethodSearchTicketsInAscendingOrderOfPriceDirectionOneCoincidencesTwo(){
        Ticket[] expected = {ticket11, ticket12};
        Ticket[] actual = repository.search("Симферополь", "Краснодар");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMethodSearchTicketsInAscendingOrderOfPriceDirectionOneCoincidencesOne(){
        Ticket[] expected = {ticket13};
        Ticket[] actual = repository.search("Симферополь", "Самара");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMethodSearchTicketsInAscendingOrderOfPriceDirectionOneCoincidencesZero(){
        Ticket[] expected = {};
        Ticket[] actual = repository.search("Симферополь", "Киев");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMethodAndSortByTicketsInAscendingOrderOfFlightTimeDirectionMoscow() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket8, ticket5, ticket2, ticket1};
        Ticket[] actual = repository.searchAndSortBy("Симферополь", "Москва", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testMethodAndSortByTicketsInAscendingOrderOfFlightTimeDirectionSaintPetersburg() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket3, ticket9, ticket6, ticket10};
        Ticket[] actual = repository.searchAndSortBy("Симферополь", "Санкт-Петербург", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testMethodAndSortByTicketsInAscendingOrderOfFlightTimeDirectionMinsk() {
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] expected = {ticket7, ticket4};
        Ticket[] actual = repository.searchAndSortBy("Симферополь", "Минск", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

}
