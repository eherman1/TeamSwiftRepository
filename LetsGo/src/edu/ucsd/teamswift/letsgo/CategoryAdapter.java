/*
 * CategoryAdapter
 * 
 * Author: Steven Lee
 * 
 * An adapter will turn an array into a usable format for a ListView.
 * This adapter will turn arrays of activities into a usable list for our activity pages.
 */
package edu.ucsd.teamswift.letsgo;

import java.util.List;

import com.parse.ParseImageView;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<Category> {
	
	private ProgressDialog progressDialog;
		
	public CategoryAdapter(Context context, List<Category> values) {
		super(context, R.layout.category_row_horizontal, values);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		//The inflater makes the xml take up the entire view
		LayoutInflater theInflater;
		
		/*
		 * Optimization for the list.
		 * Creates the view if the view doesn't already exist, else
		 * re-uses the old convertView.
		 */
		if(convertView == null){
			theInflater = LayoutInflater.from(getContext());
			convertView = theInflater.inflate(R.layout.category_row_horizontal, parent, false);
		}

		//Get one of the items from the array and grab its name to fill the textview
		Category currentCategory = (Category)getItem(position);
		String categoryName = currentCategory.getCategoryName();
		
		//Find the TextView in the list item xml so we can change its text and image
		TextView categoryNameTextView = (TextView)convertView.findViewById(R.id.categoryNameTextView);
	
		//Fill in the text
		categoryNameTextView.setText(categoryName);
		
		/*TODO Adding Icon Image to list*/
		Bitmap categoryIcon = getItem(position).getCategoryIcon();

    //If there is a picture or no problems
		if (categoryIcon != null) {
			
			Drawable d = new BitmapDrawable(getContext().getResources(), categoryIcon);
			categoryNameTextView.setCompoundDrawablesWithIntrinsicBounds(d, null, null, null);
		}
		//use default picture
		else{
			categoryNameTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_launcher, 0, 0, 0);
		}
		return convertView;
	}

}
