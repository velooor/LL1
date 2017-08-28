package com.epam.zakharchenya.task.factory;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ActionFactoryTest {

    @Test
    public void testShowAllRooms() {
        ActionFactory actionFactory = Mockito.mock(ActionFactory.class);

        when(actionFactory.getCurrentCommand(null, null, "/main/rooms")).thenReturn(true);
        boolean actual = actionFactory.getCurrentCommand(null, null, "/main/rooms");
        assertTrue(actual);
    }

    @Test
    public void testShowRoomByID() {
        ActionFactory actionFactory = Mockito.mock(ActionFactory.class);

        when(actionFactory.getCurrentCommand(null, null, "/main/room/1")).thenReturn(true);
        boolean actual = actionFactory.getCurrentCommand(null, null, "/main/room/1");
        assertTrue(actual);
    }

    @Test
    public void testAddRoom() {
        ActionFactory actionFactory = Mockito.mock(ActionFactory.class);

        when(actionFactory.getCurrentCommand(null, null, "/main/room/add")).thenReturn(true);
        boolean actual = actionFactory.getCurrentCommand(null, null, "/main/room/add");
        assertTrue(actual);
    }
}
