package ca.ubc.cs.cpsc210.meetup.util;

import ca.ubc.cs.cpsc210.meetup.exceptions.IllegalTimeException;

public class CourseTime extends EventTime {

    /**
     * Represent a course time
     *
     * @param start The "HH:MM" at which a course (or section) starts
     * @param end   The "HH:MM" at which a course (or section) starts
     * @throws ca.ubc.cs.cpsc210.meetup.exceptions.IllegalTimeException
     */
    public CourseTime(String start, String end) throws IllegalTimeException {
        super(start, end);
    }


}