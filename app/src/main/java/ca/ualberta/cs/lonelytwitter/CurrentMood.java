package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by badran on 1/12/16.
 */
public abstract class CurrentMood {
    protected Date date;

    public CurrentMood(Date date) {
        this.date = date;
    }

    public CurrentMood() {
        this.date = new Date(System.currentTimeMillis());
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public abstract String showMood();

}
