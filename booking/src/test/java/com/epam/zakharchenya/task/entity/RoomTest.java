package com.epam.zakharchenya.task.entity;

import com.epam.zakharchenya.task.Config;
import com.epam.zakharchenya.task.daoservice.BookingLogic;
import com.epam.zakharchenya.task.logic.SearchCommandLogic;
import com.epam.zakharchenya.task.util.ContextHolder;
import com.google.gson.JsonArray;
import config.DBUnitConfig;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class RoomTest  extends DBUnitConfig {
    private static String path = "room-data.xml";
    private static int ID = 1;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream(path));

        tester.setDataSet(beforeData);
        tester.onSetup();
        ContextHolder.setApplicationContext(new AnnotationConfigApplicationContext(Config.class));
    }

    public RoomTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
        BookingLogic bookingLogic = new BookingLogic();
        ArrayList<Room> rooms = bookingLogic.loadAll();
        BookingLogic.closeDAO();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));

        Assert.assertEquals(expectedData.getTable("apartment").getRowCount(), rooms.size());
    }

    @Test
    public void testGetByID() throws Exception {
        BookingLogic bookingLogic = new BookingLogic();
        Room room = bookingLogic.loadById(ID);
        BookingLogic.closeDAO();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
        int id = Integer.valueOf(expectedData.getTable("apartment").getValue(0, "ID").toString());
        assertEquals(id, room.getApId());

    }

}