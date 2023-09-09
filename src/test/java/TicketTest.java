import org.junit.Test;

import java.util.Comparator;

public class TicketTest {

    @Test

    public void sortingTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","EKB",210,9,13);
        Ticket ticket2 = new Ticket("NVS","MSK",320,11,14);
        Ticket ticket3 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket4 = new Ticket("KRG","SPB",400,3,6);
        Ticket ticket5 = new Ticket("AST","EKB",410,9,11);
        Ticket ticket6 = new Ticket("MSK","EKB",210,12,13);
        Ticket ticket7 = new Ticket("AST","EKB",400,10,15);
        Ticket ticket8 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket9 = new Ticket("AST","EKB",410,10,12);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("AST", "EKB");
        Ticket[] expected = {ticket5, ticket9, ticket8};
    }

    @Test

    public void sortingTestNotExisting() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","EKB",210,9,13);
        Ticket ticket2 = new Ticket("NVS","MSK",320,11,14);
        Ticket ticket3 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket4 = new Ticket("KRG","SPB",400,3,6);
        Ticket ticket5 = new Ticket("AST","EKB",410,9,11);
        Ticket ticket6 = new Ticket("MSK","EKB",210,12,13);
        Ticket ticket7 = new Ticket("AST","EKB",400,10,15);
        Ticket ticket8 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket9 = new Ticket("AST","EKB",410,10,12);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("AST", "NYK");
        Ticket[] expected = { };
    }

    @Test

    public void sortingTestBoundary() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","EKB",210,9,13);
        Ticket ticket2 = new Ticket("NVS","MSK",320,11,14);
        Ticket ticket3 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket4 = new Ticket("KRG","SPB",400,3,6);
        Ticket ticket5 = new Ticket("AST","EKB",410,9,11);
        Ticket ticket6 = new Ticket("MSK","EKB",210,12,13);
        Ticket ticket7 = new Ticket("AST","EKB",400,10,15);
        Ticket ticket8 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket9 = new Ticket("AST","EKB",410,10,12);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] actual = manager.search("KRG", "SPB");
        Ticket[] expected = { };
    }

    @Test

    public void sortingTestComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK","EKB",210,9,13);
        Ticket ticket2 = new Ticket("NVS","MSK",320,11,14);
        Ticket ticket3 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket4 = new Ticket("KRG","SPB",400,3,6);
        Ticket ticket5 = new Ticket("AST","EKB",410,9,11);
        Ticket ticket6 = new Ticket("MSK","EKB",210,12,13);
        Ticket ticket7 = new Ticket("MSK","EKB",400,12,15);
        Ticket ticket8 = new Ticket("NYK","MSK",510,4,10);
        Ticket ticket9 = new Ticket("AST","EKB",410,10,12);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "EKB", comparator);
        Ticket[] expected = {ticket6, ticket7, ticket1};
    }
}
