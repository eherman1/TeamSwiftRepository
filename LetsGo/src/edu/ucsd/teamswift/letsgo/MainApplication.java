/*
 * MainApplication
 * 
 * Author: Steven Lee
 * 
 * Makes sure Parse.initialize() stays active throughout the application.
 */
package edu.ucsd.teamswift.letsgo;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Application;

public class MainApplication extends Application {
	
	@Override
	public void onCreate()
	{
		super.onCreate();
		
		//Parse activation
		//Enable Local Datastore.
		Parse.enableLocalDatastore(this);

		//Register all ParseObject subclasses here:
		ParseObject.registerSubclass(Category.class);
		ParseObject.registerSubclass(ActivityRoom.class);
		
		Parse.initialize(this, "hB3eXHmQndkVq2f3Ir1I4G2WKW8va1p10ZUmi3iw", "uhv7L1VPCLM5xYdvEXHwb1tMJ1hCrYLkftaYUFeK");	
	}

}
