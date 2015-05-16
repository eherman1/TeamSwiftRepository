/* Project: Lets Go	
 * Group: Team Swift
 * Description: Opening Page of "Lets Go" Android Application. Allows user to
 * 			    sign up or sign in to application
 * 
 * Page Created: Steven
 * Page Modified by:
 * 		Sang : Created event handling for lets go play and active activities
 * 			 
 */

package edu.ucsd.teamswift.letsgo;

import com.parse.ParseUser;
import com.parse.LogInCallback;
import com.parse.ParseException;

import edu.ucsd.teamswift.letsgo.DialogPopUp;
import android.app.Activity;	
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInPage extends Activity {

	
	Button forgotPasswordBut;
	Button signUpBut;
	Button logInBut;
	
	String emailString;
	String passwordStirng;
	EditText passwordEditText;
	EditText emailEditText;
	
	
	// PageContext is a variable to hold the page name to pass it to DialogPopUp()
	Context pageContext = SignInPage.this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//Parse is now located in MainApplication.java
		
		/* Lets program look for and find the page buttons */
		forgotPasswordBut = (Button)this.findViewById(R.id.forgotPasswordBut);
		signUpBut = (Button)this.findViewById(R.id.signUpBut);
		logInBut = (Button)this.findViewById(R.id.logInBut);
		emailEditText = (EditText) findViewById(R.id.userEmail);
		passwordEditText = (EditText) findViewById(R.id.userPassword);
		
	
		/*
		 * Forgot Password Button
		 * 
		 * Displays the forgot password dialog box
		 * The class is located in ForgotPasswordDialog.java
		 */
		forgotPasswordBut.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				/* TODO
				 * Warning: Forgot password is being used as a temporary link to the
				 * CreateActivityPage.java
				 */
				//DialogFragment dialogPopup = new ForgotPasswordDialog();			
				//dialogPopup.show(getFragmentManager(), "ForgotPasswordDialogTag");
				
				//Intent will allow user to move to sign up page
				Intent moveToCreatePage = new Intent(SignInPage.this, CreateActivityPage.class);
				
				//Makes it so the sign up page is a unique task
				moveToCreatePage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					
				//Then moves to Sign Up Page
				startActivity(moveToCreatePage);
			}
		});
			
		/*
		 * Sign Up Button
		 * 
		 * Transitions to the Sign Up Page
		 */
		signUpBut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
			
				//Intent will allow user to transition to sign up page
				Intent moveToSignUpPage = new Intent(SignInPage.this, SignUpPage.class);
				
				//Makes it so the sign up page is a unique task
				moveToSignUpPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					
				//Then moves to Sign Up Page
				startActivity(moveToSignUpPage);
				
				//Method to apply transition animation between activities
				//overridePendingTransition(R.animator.transition_to_sign_up_page, R.animator.transition_sign_up_page_2);
			}
		});
	
		/*
		 * Log In Button
		 * 
		 * Logic that handles the log in and transitions to the Home Page
		 */
		logInBut.setOnClickListener(new View.OnClickListener() {				
			@Override
			public void onClick(View v) {
				//Before transition, check if Login Credential are good on parse carry token 
				// getText from the login page and store it in strings
				emailString = emailEditText.getText().toString();
				passwordStirng = passwordEditText.getText().toString();

				// Send data to parse for verification
				//ParseUser.logInInBackground(emailString, passwordStirng, new LogInCallback() {
				
				
				//Temp log in so no sign in
				ParseUser.logInInBackground("p@w.com", "abc", new LogInCallback() {
					public void done(ParseUser user, ParseException e) {
						if (user != null) {
							// if the user exist and authenticated, send user to home screen
							Intent moveToHomePage = new Intent(SignInPage.this, HomePage.class);
							moveToHomePage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
							startActivity(moveToHomePage);
						} else {
							//Break this "if" statement to give pop up for each individual error in field
							if (emailString.equals("") || passwordStirng.equals("")) {
								
								/* Pop up menu to tell user to complete form */
								// Call DialogPopUp("title", "msg", "context")
								DialogPopUp.DialogPop("There was a problem", "Please fill the blank fields", pageContext);
								
							}
							
							else {
								/* Pop up menu to tell user to complete form */
								// Call DialogPopUp("title", "msg", "context")
								DialogPopUp.DialogPop("There was a problem", "No such user exist, please sign up", pageContext);
							
							}
						}
					}
				
				});
						
			}
		});
	}
}
