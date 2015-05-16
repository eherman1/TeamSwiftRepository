/* Team: SWIFT					Project: Let'sGo	  			
 * Use: Parse authentication file
 * Description: 
 * 		Makes sure Parse.initialize() and stays active throughout the application.
 *
 * Methods:
 * 		public void onCreate()
 * 
 * Created by: Steven
 */	  			
package edu.ucsd.teamswift.letsgo;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

public class MainApplication extends Application {
	
	@Override
	/* Used as a global state of this onCreate() */
	public void onCreate(){
		super.onCreate();
	
		/* Enable Local Datastore */
		Parse.enableLocalDatastore(this);

		//Register all ParseObject subclasses here:
		ParseObject.registerSubclass(Category.class);
		
		/* Keys used to authenticate LetsGo database*/
		Parse.initialize(this, "hB3eXHmQndkVq2f3Ir1I4G2WKW8va1p10ZUmi3iw", "uhv7L1VPCLM5xYdvEXHwb1tMJ1hCrYLkftaYUFeK");	
	}
}
