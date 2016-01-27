package ca.ualberta.cs.lonelytwitter;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by badran on 1/26/16.
 */
public class TweetList {
    private ArrayList<Tweet> tweets= new ArrayList<Tweet>();

    public void add(Tweet tweet){

        if (this.hasTweet(tweet)) {
            throw new IllegalArgumentException();
        }
        tweets.add(tweet);
    }

    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    public ArrayList<Tweet> getTweets(int index){
        //return tweets.get(index);
        ArrayList<Tweet> tweets1 = new ArrayList<Tweet>();

        Collections.sort(tweets1, new Comparator<Tweet>() {
            //@Override
            public int compare(Tweet r1, Tweet r2) {
                return r1.getDate().compareTo(r2.getDate());
            }
        });
        return tweets1;
    }

    public int getCount(){
        return tweets.size();
    }

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }
}
