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
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Часы должны быть от 0 до 23.");
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Минуты должны быть от 0 до 59.");
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Секунды должны быть от 0 до 59.");
        }
        this.seconds = seconds;
    }

    public void addHours(int hours) {
        this.hours = (this.hours + hours) % 24;

        if (this.hours < 0) {
            this.hours += 24;
        }
    }

    public void addMinutes(int minutes) {
        int totalMinutes = this.minutes + minutes;

        addHours(totalMinutes / 60);
        this.minutes = totalMinutes % 60;

        if (this.minutes < 0) {
            this.minutes += 60;
            addHours(-1);
        }
    }

    public void addSeconds(int seconds) {
        int totalSeconds = this.seconds + seconds;

        addMinutes(totalSeconds / 60);
        this.seconds = totalSeconds % 60;

        if (this.seconds < 0) {
            this.seconds += 60;
            addMinutes(-1);
        }
    }
}
