package ca.ubc.cs.cpsc210.meetup.util;

import ca.ubc.cs.cpsc210.meetup.exceptions.IllegalTimeException;


/**
 * Created by Fabian on 04/04/2015.
 */
public class EventTime implements Comparable<EventTime> {

    protected int startHours;
    protected int startMinutes;
    protected int endHours;
    protected int endMinutes;

    /**
     * Represent an event time
     * @param start The "HH:MM" at which an event starts
     * @param end The "HH:MM" at which an event starts
     * @throws ca.ubc.cs.cpsc210.meetup.exceptions.IllegalTimeException
     */
    public EventTime(String start, String end) throws IllegalTimeException {
        int indexOfColon = start.indexOf(":");
        if (indexOfColon <= 0)
            throw new IllegalTimeException("Missing a : in a start time.");
        startHours = Integer.parseInt(start.substring(0, indexOfColon));
        startMinutes = Integer.parseInt(start.substring(indexOfColon+1, start.length()));
        indexOfColon = end.indexOf(":");
        if (indexOfColon <= 0)
            throw new IllegalTimeException("Missing a : in an end time.");
        endHours = Integer.parseInt(end.substring(0, indexOfColon));
        endMinutes = Integer.parseInt(end.substring(indexOfColon+1, end.length()));

        if (startHours > endHours)
            throw new IllegalTimeException("Start time must be less than end time.");
        else if (startHours == endHours && startMinutes > endMinutes)
            throw new IllegalTimeException("Start time must be less than end time.");
    }

    public String getEndTime() {
        if (endMinutes == 0)
            return new String(endHours + ":00");
        else
            return new String(endHours + ":" + endMinutes); }


    public String getStartTime() {
        if (startMinutes == 0)
            return new String(startHours + ":00");
        else
            return new String(startHours + ":" + startMinutes); }

    @Override
    public int compareTo(EventTime other) {
        if (startHours > other.startHours)
            // if THIS starts later than OTHER, return 1
            return 1;
        else if (startHours == other.startHours) {
            if (startMinutes < other.startMinutes)
                // if they start at the same hour but THIS starts sooner than LATER, return -1
                return -1;
            else if (startMinutes == other.startMinutes && endMinutes == other.endMinutes)
                // if they start same hour and minutes and end at the same minutes, return 0
                return 0;
            else
                // if they start at the same time but don't end at the same time || THIS starts later in minutes
                return 1;
        }
        // if THIS starts sooner than OTHER (by hour), return -1
        else
            return -1;
    }


    public String toString() {
        return new String(getStartTime() + " to " + getEndTime());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + endHours;
        result = prime * result + endMinutes;
        result = prime * result + startHours;
        result = prime * result + startMinutes;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CourseTime other = (CourseTime) obj;
        if (endHours != other.endHours)
            return false;
        if (endMinutes != other.endMinutes)
            return false;
        if (startHours != other.startHours)
            return false;
        if (startMinutes != other.startMinutes)
            return false;
        return true;
    }





}


