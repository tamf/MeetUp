package ca.ubc.cs.cpsc210.meetup.util;

import ca.ubc.cs.cpsc210.meetup.exceptions.IllegalTimeException;

/**
 * Created by Fabian on 30/03/2015.
 */
public class BreakTime extends EventTime {
    /**
     * Represent a break time
     * @param start The "HH:MM" at which a break starts
     * @param end The "HH:MM" at which a break ends
     * @throws ca.ubc.cs.cpsc210.meetup.exceptions.IllegalTimeException
     */
    public BreakTime(String start, String end) throws IllegalTimeException {
        super(start, end);
    }

    /**
     *
     * @param otherBreakTime
     * @return true if this overlaps with otherBreakTime, otherwise false
     */

    public boolean isSubsetOf(BreakTime otherBreakTime) {
        return (startsLaterThan(otherBreakTime) && endsSoonerThan(otherBreakTime));
    }


    /**
     *
     * @param otherBreakTime
     * @return true if this starts at the same time or later than otherBreakTime, otherwise false
     */
    public boolean startsLaterThan(BreakTime otherBreakTime) {
        // if this start hours is greater (later) than start hours of otherBreakTime, return true
        if (startHours > otherBreakTime.startHours) {
            return true;
        // if they both start same hours and (minutes are same or this start minutes is later), return true
        } else if (startHours == otherBreakTime.startHours && startMinutes >= otherBreakTime.startMinutes) {
            return true;
        // otherwise, this means otherBreakTime has a later start time and we will return false
        } else {
            return false;
        }
    }
    /**
     *
     * @param otherBreakTime
     * @return true if this starts at the same time or later than otherBreakTime
     */
    public boolean endsSoonerThan(BreakTime otherBreakTime) {
        if (endHours < otherBreakTime.endHours) {
            return true;
        } else if (endHours == otherBreakTime.endHours && endMinutes <= otherBreakTime.endMinutes) {
            return true;
        } else {
            return false;
        }

    }
}
