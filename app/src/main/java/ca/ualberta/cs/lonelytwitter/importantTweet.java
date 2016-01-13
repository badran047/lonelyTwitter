package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by badran on 1/12/16.
 */
public class importantTweet extends Tweet {
    public importantTweet(Date date, String message) {
        super(date, message);
        this.setIsImportant(Boolean.TRUE);
    }

    public importantTweet(Srting message) {
        super(message);
        this.setIsImportant(Boolean.TRUE);
    }
}
