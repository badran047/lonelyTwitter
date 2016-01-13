package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by badran on 1/12/16.
 */
public abstract class Tweet {
    private Date date;
    private String message;
    protected boolean isImportant;

    public abstract Boolean isImportant();

    public boolean isImportant() {
        return isImportant;
    }

    public Tweet(Date date, String message) {
        message = "hello all.";
        this.date = date;
        this.message = message;
        this.isImportant = Boolean.FALSE;
    }

    public Tweet(Srting message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) throws TweetToolLongException{
        if (message.length() > 140) {
            throw new TweetToolLongException();
        }
        this.message = message;
    }
}
