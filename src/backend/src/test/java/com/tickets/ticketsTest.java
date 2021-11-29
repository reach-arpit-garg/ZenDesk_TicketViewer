package com.tickets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

//Load the context
public class ticketsTest {

    tickets t = new tickets();

    @Test
    public void testGetAllTickets() {
        assertEquals(25, t.getAllTickets(1, 25).size());
        assertEquals(1, t.getAllTickets(5, 25).size());
    }

    @Test
    public void testGetTicketsCount() {
        assertEquals(101, t.getTicketsCount());
    }

    @Test
    public void testGetTicketDetails() {
        assertEquals(2, t.getTicketDetails(2).id);
    }

    @Test
    public void testNotAuthorizationGetTickets() {
        t.authStr = "abc";
        assertEquals("AuthorizationError", t.getAllTickets(1, 5).get(0).description);
    }

    @Test
    public void testAuthorizationGetTickets() {
        assertNotEquals("AuthorizationError", t.getAllTickets(1, 5).get(0).description);
    }

}
