package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by badran on 1/12/16.
 */
public class NormalTweet extends Tweet implements Tweetable {
    @Override
    public Boolean isImportant() {
        return false;
    }

    public NormalTweet(Date date, String message) {
        super(date, message);
    }

    public NormalTweet(String message) {
        super(message);
    }

    public String getMessage() {
        return null;
    }

    public Date getDate() {
        return this.date = date;
    }
}
