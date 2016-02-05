/**
 * Provides files for the application
 */
package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The main activity for a small, personal Twitter app to capture, notes and comments.
 * <p>It saves the input tweets in the json files.</p>
 * A sample code is as:<br>
 *     <code>
 *         for(int i=0; i<10; i++)
 *         		for (int j=0; j<i; j++)
 *         			doSomething();
 *     </code>
 * The list of important activities in this class are as follows:
 * <ul>
 *     <li>item 1</li>
 *     <li>item 2</li>
 *     <li>item 3</li>
 *     <li>item 4</li>
 * </ul>
 * @since 1.2.1
 * @see LonelyTwitterActivity for more information
 * @author Hasan
 * @version 2.3
 * @deprecated
 *
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * This arrayList is for keeping the tweets and their date of posting.<br>
	 * This is blah blah.
	 * @see #loadFromFile()
	 */
	public ArrayList<String> listOfItems;
	static final String GENERAL_FILE_NAME = "fileName.json";
	private int calculateTweetSize(){
		//
		return -1;
	}

	private String removeStopWords(String text){
		//
		return "";
	}

	/**
	 * This starts the next activity which is blah blah.
	 * @param intent This is the intent to be run immediately after hitting "start" button.
	 */
	private void startSecondActivity(Intent intent){
		//
	}

	/**
	 * This method does something
	 * @param s is some parameter!
	 * @return The value that is used for some job!
	 * @throws ...
	 * @deprecated
	 */
	public String someMethod(String s){
		return "";
	}

	/**
	 * This evaluates the next activity
	 * @param intent This is the intent to be run
	 * @return
	 */
	public boolean evaluateSecondActivity(Intent intent){
		int count = 0;
		String s = "";
		String expression1 = "", expression2 = "", expression3 = "", expression4 = "";

		//This is a call to intent to do ...
		Intent intent1 = new Intent();
		startSecondActivity(intent1);
		String S = someMethod(expression1 + expression2 + expression3 +
							expression4);
		someMethod(expression1 + expression2 + expression3 +
				expression4);

		for (int i=0; i<10; i++)
		try{
			int a = 1;
			int b = 2;
			if (a < 2) {
				someMethod("first choice");
			} else
				someMethod("Second choice");
			while (1 < 2) {
				int j = 0;
				//int count = 10; //AVOID
				//
			}
		}
		catch (Exception e){}
		return true;
	}

	/**
	 * This implements the filename
	 */
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();
	private ArrayAdapter<Tweet> adapter;

	/**
	 * This is called when the activity is first created
	 * @param savedInstanceState
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/**
		 * Implementation of the save button
		 */
		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet latestTweet = new NormalTweet(text);
				ImportantTweet latestImportantTweet = new ImportantTweet(text);
				// latestTweet.setMessage(latestTweet.getMessage() + "!");
				tweets.add(latestTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
				//saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});

		/**
		 * Implementation of the clear button
		 */
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				tweets.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	/**
	 * This is called when the activity starts
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		//String[] tweets = loadFromFile();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * This loads tweets from files
	 * <p>It loads the tweets from the json files.</p>
	 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();

			// Took from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 01-19 2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();
			tweets = gson.fromJson(in, listType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * This saves tweets in files
	 * <p>It saves the input tweets in the json files.</p>
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			Gson gson = new Gson();
			gson.toJson(tweets, out);
			out.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}