package com.epam.zakharchenya.task.entity;

import java.sql.Timestamp;

public class Room extends DatabaseEntity {
    private int apId;
    private Timestamp startDate;
    private Timestamp endDate;

    public Room(int apId, Timestamp startDate, Timestamp endDate) {
        this.apId = apId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Room() {
    }

    public int getApId() {
        return apId;
    }

    public void setApId(int apartmentId) {
        this.apId = apartmentId;
    }

    
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (apId != room.apId) return false;
        if (!startDate.equals(room.startDate)) return false;
        return endDate.equals(room.endDate);

    }

    @Override
    public int hashCode() {
        int result = apId;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Id " + apId +
                ", startDate " + startDate +
                ", endDate " + endDate +
                '}';
    }
}
