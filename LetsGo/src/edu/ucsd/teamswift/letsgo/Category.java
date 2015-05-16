/* Team: SWIFT					Project: Let'sGo	  			
 * Use: Category from parse
 * Description: 
 * 		The class that all other activity categories will inherit 
 * 		fields (ie Basketball, Baseball, E-Sports, etc);
 * 
 * Methods:
 * 		public public Category()
 * 		public String getCategoryName()
 * 		public boolean isJoinOnly()
 *    public int getActivityLevel()
 * 		public Bitmap getCategoryIcon()
 * 		private void giveIcon(Bitmap I)
 * 
 * Created by: Steven
 * 
 * Modified by: Sang, Added public Bitmap getCategoryIcon() and included all comments
 */
package edu.ucsd.teamswift.letsgo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName(value = "Category")
public class Category extends ParseObject {
	
	/* Variables */
	private Bitmap icon;
	
	/* Category constructor */
	public Category() {}
	public String getCategoryId()
	{
		return getObjectId();
	}
	
	public String getCategoryName()
	{
		return getString("Name");
	}
	
 /* Gets the boolean if the activity is a join only Activity for Category List
	* If false then will create on Create Activity List
	* If true then create on Join Activity List */
	public boolean isJoinOnly(){
		return getBoolean("JoinOnly");
	}
	
	/* Gets Integer of each category of Activities
	 * If 0 then not physical (ie chess)
	 * If 1 then physical (ie football)
	 * Other number used for future */
	public int getActivityLevel(){
		return getInt("ActivityLevel");
	}
	
	/* Gets the icon of activity from database and converts to bitmap*/
	public Bitmap getCategoryIcon(){
		
		// Locate the column named "Icon" and set the string
		final ParseFile fileObject = getParseFile("Icon");
		
		/* If a activity has no icon then return Null */
		if(fileObject == null)
			return null;
		
	/******* Delete NOT Until we know for sure we do not need **********/	
//		fileObject.getDataInBackground(new GetDataCallback(){
//			@Override
//			public void done(byte[] data, ParseException e) {
//				if(e == null){	
//					Bitmap icon = BitmapFactory.decodeByteArray(data, 0, data.length);
//				  giveIcon(icon);	  
//				} 
//				else {
//					giveIcon(null);
//					Log.e("bitmap","There was a problem downloading the data.");
//				}
//			}
//		});
		
		
		
		/* Try / Catch to get icon from */
		try {
			
			/* Parse files are in byte array form and use getData()
			 * to get download data synchronously*/
			byte[] data = fileObject.getData();
			
			/* Decode array into Bitmap */
			Bitmap icon = BitmapFactory.decodeByteArray(data, 0, data.length);
			
			/* Need method to get icon out of nested method */
			giveIcon(icon);
			
		} 
		/* Exception handling if try fails */
		catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
		/* return bitmap icon*/
		return icon;
	}
	
	/* Created method to get icon out of nested method*/
	private void giveIcon(Bitmap I){
		icon = I;
	}

}
