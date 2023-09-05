package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldSortWhichTicketLess() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Madrid", "Tbilisi", 20_000, 10,13);
        Ticket ticket2 = new Ticket("Chicago", "Madrid", 30_000, 13,16);
        Ticket ticket3 = new Ticket("Madrid", "Tbilisi", 40_000, 10,12);
        Ticket ticket4 = new Ticket("Madrid", "Tbilisi", 50_500, 15,18);
        Ticket ticket5 = new Ticket("Madrid", "Tbilisi", 50_000, 12,15);
        Ticket ticket6 = new Ticket("Minsk", "Stockholm", 25_000, 7,10);
        Ticket ticket7 = new Ticket("Milan", "Paris", 35_000, 4,7);
        Ticket ticket8 = new Ticket("Madrid", "Tbilisi", 28_000, 1,4);
        Ticket ticket9 = new Ticket("LA", "Berlin", 39_000, 4,7);
        Ticket ticket10 = new Ticket("Madrid", "Tbilisi", 19_000, 16,19);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("Madrid", "Tbilisi");
        Ticket[] expected = {ticket10, ticket1, ticket8, ticket3, ticket5, ticket4 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNonExistentTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Madrid", "Tbilisi", 20_000, 10,13);
        Ticket ticket2 = new Ticket("Chicago", "Madrid", 30_000, 13,16);
        Ticket ticket3 = new Ticket("Madrid", "Tbilisi", 40_000, 10,12);
        Ticket ticket4 = new Ticket("Madrid", "Tbilisi", 50_500, 15,18);
        Ticket ticket5 = new Ticket("Madrid", "Tbilisi", 50_000, 12,15);
        Ticket ticket6 = new Ticket("Minsk", "Stockholm", 25_000, 7,10);
        Ticket ticket7 = new Ticket("Milan", "Paris", 35_000, 4,7);
        Ticket ticket8 = new Ticket("Madrid", "Tbilisi", 28_000, 1,4);
        Ticket ticket9 = new Ticket("LA", "Berlin", 39_000, 4,7);
        Ticket ticket10 = new Ticket("Madrid", "Tbilisi", 19_000, 16,19);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("Stockholm", "Tbilisi");
        Ticket[] expected = { };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOnlyOne() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Madrid", "Tbilisi", 20_000, 10,13);
        Ticket ticket2 = new Ticket("Chicago", "Madrid", 30_000, 13,16);
        Ticket ticket3 = new Ticket("Madrid", "Tbilisi", 40_000, 10,12);
        Ticket ticket4 = new Ticket("Madrid", "Tbilisi", 50_500, 15,18);
        Ticket ticket5 = new Ticket("Madrid", "Tbilisi", 50_000, 12,15);
        Ticket ticket6 = new Ticket("Minsk", "Stockholm", 25_000, 7,10);
        Ticket ticket7 = new Ticket("Milan", "Paris", 35_000, 4,7);
        Ticket ticket8 = new Ticket("Madrid", "Tbilisi", 28_000, 1,4);
        Ticket ticket9 = new Ticket("LA", "Berlin", 39_000, 4,7);
        Ticket ticket10 = new Ticket("Madrid", "Tbilisi", 19_000, 16,19);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("Milan", "Paris");
        Ticket[] expected = { ticket7 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Madrid", "Tbilisi", 20_000, 10,13);
        Ticket ticket2 = new Ticket("Chicago", "Madrid", 30_000, 13,16);
        Ticket ticket3 = new Ticket("Madrid", "Tbilisi", 40_000, 10,12);
        Ticket ticket4 = new Ticket("Madrid", "Tbilisi", 50_500, 15,18);
        Ticket ticket5 = new Ticket("Madrid", "Tbilisi", 50_000, 12,16);
        Ticket ticket6 = new Ticket("Minsk", "Stockholm", 25_000, 7,10);
        Ticket ticket7 = new Ticket("Milan", "Paris", 35_000, 4,7);
        Ticket ticket8 = new Ticket("Madrid", "Tbilisi", 28_000, 1,5);
        Ticket ticket9 = new Ticket("LA", "Berlin", 39_000, 4,7);
        Ticket ticket10 = new Ticket("Madrid", "Tbilisi", 19_000, 16,21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Madrid", "Tbilisi", comparator);
        Ticket[] expected = { ticket3, ticket1, ticket4, ticket5, ticket8, ticket10 };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNonExistentWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Madrid", "Tbilisi", 20_000, 10,13);
        Ticket ticket2 = new Ticket("Chicago", "Madrid", 30_000, 13,16);
        Ticket ticket3 = new Ticket("Madrid", "Tbilisi", 40_000, 10,12);
        Ticket ticket4 = new Ticket("Madrid", "Tbilisi", 50_500, 15,18);
        Ticket ticket5 = new Ticket("Madrid", "Tbilisi", 50_000, 12,16);
        Ticket ticket6 = new Ticket("Minsk", "Stockholm", 25_000, 7,10);
        Ticket ticket7 = new Ticket("Milan", "Paris", 35_000, 4,7);
        Ticket ticket8 = new Ticket("Madrid", "Tbilisi", 28_000, 1,5);
        Ticket ticket9 = new Ticket("LA", "Berlin", 39_000, 4,7);
        Ticket ticket10 = new Ticket("Madrid", "Tbilisi", 19_000, 16,21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Tbilisi", "Madrid", comparator);
        Ticket[] expected = { };

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortOnlyOneWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Madrid", "Tbilisi", 20_000, 10,13);
        Ticket ticket2 = new Ticket("Chicago", "Madrid", 30_000, 13,16);
        Ticket ticket3 = new Ticket("Madrid", "Tbilisi", 40_000, 10,12);
        Ticket ticket4 = new Ticket("Madrid", "Tbilisi", 50_500, 15,18);
        Ticket ticket5 = new Ticket("Madrid", "Tbilisi", 50_000, 12,16);
        Ticket ticket6 = new Ticket("Minsk", "Stockholm", 25_000, 7,10);
        Ticket ticket7 = new Ticket("Milan", "Paris", 35_000, 4,7);
        Ticket ticket8 = new Ticket("Madrid", "Tbilisi", 28_000, 1,5);
        Ticket ticket9 = new Ticket("LA", "Berlin", 39_000, 4,7);
        Ticket ticket10 = new Ticket("Madrid", "Tbilisi", 19_000, 16,21);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Milan", "Paris", comparator);
        Ticket[] expected = { ticket7 };

        Assertions.assertArrayEquals(expected, actual);
    }
}
