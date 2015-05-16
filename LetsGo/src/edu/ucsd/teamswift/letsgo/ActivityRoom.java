package edu.ucsd.teamswift.letsgo;

import java.util.Date;
import java.util.List;

import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("ActivityRoom")
public class ActivityRoom extends ParseObject {

	/*
	 * Activity constructor
	 * Parse requires the default constructor so do not change.
	 */
	public ActivityRoom() {}
	
	public ParseUser getCreator()
	{
		return getParseUser("Creator");
	}
	
	public void setCreator(ParseUser creator)
	{
		put("Creator", creator);
	}
	
	public Category getCategory()
	{
		return (Category)getParseObject("Category");
	}
	
	public void setCategory(Category category)
	{
		put("Category", category);
	}
	
	
	public Date getStartDate()
	{
		return getDate("StartDate");
	}
	
	public void setStartDate(Date startDate)
	{
		put("StartDate", startDate);
	}
	
	public Date getStartTime()
	{
		return getDate("StartTime");
	}
	
	public void setStartTime(Date startTime)
	{
		put("StartTime", startTime);
	}
	
	
	public Date getEndTime()
	{
		return getDate("EndTime");
	}
	
	public void setEndTime(Date endTime)
	{
		put("EndTime", endTime);
	}
	
	
	public ParseGeoPoint getLocation()
	{
		return getParseGeoPoint("Location");
	}
	
	public void setLocation(ParseGeoPoint location)
	{
		put("Location", location);
	}
	
	
	public int getNumberOfPlayers()
	{
		return getInt("NumberOfPlayers");
	}
	
	public void setNumberOfPlayers(int numberOfPlayers)
	{
		put("NumberOfPlayers", numberOfPlayers);
	}
	
	
	public String getOtherInformation()
	{
		return getString("OtherInformation");
	}
	
	public void setOtherInformation(String otherInformation)
	{
		put("OtherInformation", otherInformation);
	}
	
	
	public int getActivityLevel()
	{
		return getInt("ActivityLevel");
	}
	
	public void setActivityLevel(int activityLevel)
	{
		put("ActivityLevel", activityLevel);
	}
	
	
	public List<ParseUser> getPlayers()
	{
		return getList("Players");
	}
	
	public void setPlayers(List<ParseUser> players)
	{
		put("Players", players);
	}
	
}
