package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by badran on 1/12/16.
 */
public class DiffMood0 extends CurrentMood {
    public DiffMood0() {
    }

    public DiffMood0(Date date) {

        super(date);
    }

    @Override
    public String showMood() {
        return "Sad";
    }
}
