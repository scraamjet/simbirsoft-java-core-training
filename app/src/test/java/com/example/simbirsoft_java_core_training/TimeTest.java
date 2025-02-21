package com.example.simbirsoft_java_core_training;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.example.simbirsoft_java_core_training.classes.Task4.Time;

import org.junit.Test;

public class TimeTest {

    @Test
    public void testValidTimeCreation() {
        Time time = new Time(12, 30, 45);
        assertEquals("12:30:45", time.toString());
    }

    @Test
    public void testInvalidHours() {
        assertThrows(IllegalArgumentException.class, () -> new Time(24, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Time(-1, 0, 0));
    }

    @Test
    public void testInvalidMinutes() {
        assertThrows(IllegalArgumentException.class, () -> new Time(12, 60, 0));
        assertThrows(IllegalArgumentException.class, () -> new Time(12, -1, 0));
    }

    @Test
    public void testInvalidSeconds() {
        assertThrows(IllegalArgumentException.class, () -> new Time(12, 0, 60));
        assertThrows(IllegalArgumentException.class, () -> new Time(12, 0, -1));
    }

    @Test
    public void testAddHours() {
        Time time = new Time(22, 15, 30);
        time.addHours(5);
        assertEquals("03:15:30", time.toString());
    }

    @Test
    public void testAddMinutes() {
        Time time = new Time(10, 50, 30);
        time.addMinutes(15);
        assertEquals("11:05:30", time.toString());
    }

    @Test
    public void testAddSeconds() {
        Time time = new Time(10, 59, 50);
        time.addSeconds(15);
        assertEquals("11:00:05", time.toString());
    }

    @Test
    public void testAddMinutesOverflow() {
        Time time = new Time(23, 50, 0);
        time.addMinutes(18);
        assertEquals("00:08:00", time.toString());
    }

    @Test
    public void testAddSecondsOverflow() {
        Time time = new Time(23, 59, 50);
        time.addSeconds(20);
        assertEquals("00:00:10", time.toString());
    }
}
