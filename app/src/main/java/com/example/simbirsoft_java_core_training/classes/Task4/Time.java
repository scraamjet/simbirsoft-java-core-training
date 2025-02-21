package com.example.simbirsoft_java_core_training.classes.Task4;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        setTime(hours, minutes, seconds);
    }

    public void setTime(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void setHours(int hours) {
        if (hours < 0 || hours >= 24) {
            throw new IllegalArgumentException("Часы должны быть от 0 до 23.");
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Минуты должны быть от 0 до 59.");
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Секунды должны быть от 0 до 59.");
        }
        this.seconds = seconds;
    }

    public void addHours(int h) {
        setHours((hours + h + 24) % 24);;
    }

    public void addMinutes(int m) {
        int totalMinutes = minutes + m;
        addHours(totalMinutes / 60);
        setMinutes(totalMinutes % 60);
    }

    public void addSeconds(int s) {
        int totalSeconds = seconds + s;
        addMinutes(totalSeconds / 60);
        setSeconds(totalSeconds % 60);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

