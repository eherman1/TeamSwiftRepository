package edu.ucsd.teamswift.letsgo;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateActivityPage extends Activity {

	private TextView textUserName;
	private TextView textActivityName;
	
	private EditText inputStartDate;
	private EditText inputStartTime;
	private EditText inputLocation;
	private EditText inputNumPeople;
	private EditText inputOtherInfo;
	
	private Button cancelCreateBut;
	private Button createBut;
	
	ParseUser user;
	String userName;
	String categoryId;
	Category category;
	String activityName;
	int activityLevel;
	int numberOfPlayers;

					 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_actvity_page);

		textUserName = (TextView)findViewById(R.id.textViewUserName);
		textActivityName = (TextView)findViewById(R.id.textViewActivityName);
		inputStartDate = (EditText)findViewById(R.id.inputStartDate);
		inputStartTime = (EditText)findViewById(R.id.inputStartTime);
		inputLocation = (EditText)findViewById(R.id.inputLocation);
		inputNumPeople = (EditText)findViewById(R.id.inputNumPeople);
		inputOtherInfo = (EditText)findViewById(R.id.inputOtherInfo);
		cancelCreateBut = (Button)findViewById(R.id.cancelCreateBut);
		createBut = (Button)findViewById(R.id.createBut);
		
		//Get the current Parse User
		user = ParseUser.getCurrentUser();
		userName = user.getUsername();
		
		//Get information from previous Activity Page
		categoryId = getIntent().getStringExtra("CategoryId");
		
		//Uses the categoryId to find the Category on Parse
		ParseQuery<Category> categoryQuery = ParseQuery.getQuery("Category");
		categoryQuery.getInBackground(categoryId, new GetCallback<Category>() {

			@Override
			public void done(Category retrievedCategory, ParseException e) {
				if (e == null) {
					successfullyRetrievedCategory(retrievedCategory);
				} else {
					Log.e("CreateActivityPage - Parse Exeception", "Could not retrieved category");
				}
			}
			
		});
		
		//Fill in the automatically filled fields
		textUserName.setText(userName);
		
		//user click on cancel button, go back to homepage
		cancelCreateBut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick (View v) {
				
				Intent moveToCreateCategoryPage = new Intent(CreateActivityPage.this, CreateCategoryPage.class);
				
				//Clears all other activities including this one when returning to the Main Activity
				moveToCreateCategoryPage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				startActivity(moveToCreateCategoryPage);
			}
			
			
		});
		
		createBut.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			
				/*
				 * ActivityRoom:
				 * 
				 * Creator
				 * Category
				 * StartDate
				 * StartTime
				 * EndTime
				 * Location
				 * NumberOfPlayers
				 * OtherInformation
				 * ActivityLevel
				 * Players
				 */
				ActivityRoom createdActivityRoom = new ActivityRoom();
				
				createdActivityRoom.setCreator(ParseUser.getCurrentUser());

				createdActivityRoom.setCategory(category);
				
				//start date
				//start time
				//end time
				//location
				
				numberOfPlayers = Integer.parseInt(inputNumPeople.getText().toString());
				createdActivityRoom.setNumberOfPlayers(numberOfPlayers);
				
				createdActivityRoom.setOtherInformation(inputOtherInfo.getText().toString());
				
				createdActivityRoom.setActivityLevel(activityLevel);
				
				createdActivityRoom.saveInBackground();
			}
			
		});
		
		
	}
	
	/*
	 * successfullyRetrievedCategory
	 * 
	 * The function called after Parse retrieves the category user wanted to create.
	 */
	protected void successfullyRetrievedCategory(Category retrievedCategory) {
		category = retrievedCategory;
		activityName = category.getCategoryName();
		activityLevel = category.getActivityLevel();
		
		textActivityName.setText(activityName);
	}
	
	
	//Jake make fields and pop up for confirmation
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
