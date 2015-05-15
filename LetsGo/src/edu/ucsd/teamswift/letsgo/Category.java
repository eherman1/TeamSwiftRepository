/*
 * Category
 *
 * This class acts like a wrapper for the ParseObject class Category
 */
package edu.ucsd.teamswift.letsgo;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName(value = "Category")
public class Category extends ParseObject {
	
	/*
	 * Category constructor
	 */
	public Category() {}

	public String getCategoryId()
	{
		return getObjectId();
	}
	
	public String getCategoryName()
	{
		return getString("Name");
	}
	
	public boolean isJoinOnly()
	{
		return getBoolean("JoinOnly");
	}
	
	public int getActivityLevel()
	{
		return getInt("ActivityLevel");
	}
	
	//get and set CategoryIcon
	/* TODO */
}