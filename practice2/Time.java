package oop24.practice2;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            throw new IllegalArgumentException("Invalid hour");
        }

        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            throw new IllegalArgumentException("Invalid minute");
        }

        if (second >= 0 && second < 60) {
            this.second = second;
        } else {
            throw new IllegalArgumentException("Invalid second");
        }
    }

    public String toUniversal() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String toStandard() {
        int standardHour = (hour == 0 || hour == 12) ? 12 : hour % 12;
        String amPm = (hour < 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", standardHour, minute, second, amPm);
    }

    public void add(Time t) {
        this.second += t.second;
        if (this.second >= 60) {
            this.second -= 60;
            this.minute += 1;
        }

        this.minute += t.minute;
        if (this.minute >= 60) {
            this.minute -= 60;
            this.hour += 1;
        }

        this.hour += t.hour;
        if (this.hour >= 24) {
            this.hour -= 24;
        }
    }


    public static void main(String[] args) {
        Time t = new Time(23, 5, 6);
        System.out.println(t.toUniversal());  // должно быть "23:05:06"
        System.out.println(t.toStandard());   // должно быть "11:05:06 PM"

        Time t2 = new Time(4, 24, 33);
        t.add(t2);
        System.out.println(t.toUniversal());  // "03:29:39"
    }
}
