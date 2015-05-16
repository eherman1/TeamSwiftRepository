/* Team: SWIFT					Project: Let'sGo	  			
 * Use: Called from LetsGo button on Home Page
 * Description: 
 * 		This creates and populates the list view on the Create Category Page
 * 		by calling parse and getting the categories it will create a click-able  
 * 	  list to create an activity
 * 
 * Methods:
 *		protected void onCreate(Bundle savedInstanceState)
 * 		private void fillListView()
 * 		private void retrieveCategories() 
 * 		
 * 		protected void objectsWereRetrievedSuccessfully(List<Category> categoryList)
 * 
 * Created by: Steven
 * 
 * Modified by: Sang, added progressDialog and modified and added comments
 */
package edu.ucsd.teamswift.letsgo;

import com.parse.ParseUser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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
	
	String userName;
	String activityType;
	int activityLevel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_actvity_page);
		
		/* Allows program to look for and find buttons on Page */
		textUserName = (TextView)findViewById(R.id.textViewUserName);
		textActivityName = (TextView)findViewById(R.id.textViewActivityName);
		inputStartDate = (EditText)findViewById(R.id.inputStartDate);
		inputStartTime = (EditText)findViewById(R.id.inputStartTime);
		inputLocation = (EditText)findViewById(R.id.inputLocation);
		inputNumPeople = (EditText)findViewById(R.id.inputNumPeople);
		inputOtherInfo = (EditText)findViewById(R.id.inputOtherInfo);
		cancelCreateBut = (Button)findViewById(R.id.cancelCreateBut);
		createBut = (Button)findViewById(R.id.createBut);
		
		/* Gets the current Parse User */
		userName = ParseUser.getCurrentUser().getUsername();
		
		/* Get information from previous Activity Page */ 
		activityType = getIntent().getStringExtra("ActivityName");
		activityLevel = getIntent().getIntExtra("ActivityLevel", 0);
		
		/* Fills automatically user name and Activity Type fields from\previous screen */
		textUserName.setText(userName);
		textActivityName.setText(activityType);
		
		/* Listener for cancel button to go back to HomePage */
		cancelCreateBut.setOnClickListener(new View.OnClickListener(){	
			@Override
			public void onClick (View v) {
				
				/* Creation of an Intent to move to CreateCategoryPage.java */
				Intent moveToCreateCategoryPage = new Intent(CreateActivityPage.this, CreateCategoryPage.class);
				
				/* Clears all other activities including this one when returning to the Main Activity */
				moveToCreateCategoryPage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
				/* Move to CreateCategoryPage */
				startActivity(moveToCreateCategoryPage);
			}
		});
	}
	/******************************************************************************/
	              //Jake make fields and pop up for confirmation
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

	@Override
	/* */
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
