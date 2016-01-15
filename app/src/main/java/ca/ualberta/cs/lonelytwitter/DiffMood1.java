package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by badran on 1/12/16.
 */
public class DiffMood1 extends CurrentMood {
    public DiffMood1() {
    }

    public DiffMood1(Date date) {

        super(date);
    }

    @Override
    public String showMood() {
        return "Happy";
    }
}
