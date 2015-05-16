/* Project: Lets Go
 * Group: Team Swift
 * Description: When the user presses the forgot password button on the Opening Page
 * 		this dialog window should appear.  Uses the forgot_password_popup_dialog.xml layout.
 * 
 * Page Created: Steven
 * Page Modified by:
 * 
 */

package edu.ucsd.teamswift.letsgo;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordDialog extends DialogFragment {

	EditText emailUserEditText;
	String emailString;
	Activity MainAcitvity;
	String ss;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		MainAcitvity = getActivity();
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

	    /*
	     * Have to set the properties of the builder object which is the dialog.
	     * View inflate will use the layout forgot_password_dialog as the view.
	     */
		
		final View dialogForgetPass = View.inflate(getActivity(), R.layout.forgot_password_dialog,null);
	    builder.setTitle("Please enter your email address and we'll send you a recovery link.").setView(dialogForgetPass).setPositiveButton(R.string.submitBut,
	    											new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int id) {
            	   
            	   // Find in the layout
            	   emailUserEditText= (EditText)dialogForgetPass.findViewById(R.id.emailEditText);
            	   // Get the user email
            	   emailString = emailUserEditText.getText().toString();
            	   // Call Parse to request reset password and sent an email
            	   ParseUser.requestPasswordResetInBackground(emailString, new RequestPasswordResetCallback() {
            		   public void done(ParseException e) {
            		     if (e == null) {
            		    	 // An email was successfully sent with reset instructions.
            		    	 Toast.makeText(MainAcitvity.getApplicationContext(), 
                                     "An email was successfully sent with reset instructions.", Toast.LENGTH_LONG).show();
            		     } else {
            		    	 // Something went wrong. Look at the ParseException to see what's up.
            		    	 Toast.makeText(MainAcitvity.getApplicationContext(), 
                                     "Something went wrong. Please try again", Toast.LENGTH_LONG).show();
            		     }
            		   }
            		 });
               }
           }).setNegativeButton(R.string.cancelBut, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                   ForgotPasswordDialog.this.getDialog().cancel();
               }
           }); 
	    
		return builder.create();
	}
	
	
}