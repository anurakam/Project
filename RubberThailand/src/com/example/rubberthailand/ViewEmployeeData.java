package com.example.rubberthailand;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;



public class ViewEmployeeData extends Activity {
	LinearLayout mainLayout;
	int lent;
	String[] items ;
	int count;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.employee_data);
		 SharedPreferences prefs = getSharedPreferences("PREFS" , 0);
			count=(prefs.getInt("count", 0))-1;
		if(count>=0){
		mainLayout = (LinearLayout)findViewById(R.id.main_layout);
		LayoutInflater inflater =LayoutInflater.from(this);
		
		
	// Gets all stored items here
	
			// Example items
				
			//Creates a layout for each item, and add it to mainLayout
			
		   String[] fname=new String[count];
		if(count>=0){
		 	for(int i=0;i<count;i++)
			{
				fname[i]=prefs.getString("name"+i,"");		
			}}
		
			
		if(count>=0){
		 	for (int i = 0; i <count; i++) {
			View itemView = inflater.inflate(R.layout.employee_item, null);
			TextView textView 
				= (TextView) itemView.findViewById(R.id.item);
			
			textView.setText(prefs.getString("name"+i,""));
             textView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					openNote(((TextView) v).getText().toString());
					
				}
			});
			mainLayout.addView(itemView);
		}}}
	}
	
	private void openNote(String key) {
		Intent intent=new Intent(this,EditEmployee.class);
		intent.putExtra("key",key);
		startActivity(intent);
		
	}
	boolean add;
	@Override
	public void onResume(){
		
		super.onResume();
		try{
		SharedPreferences prefs = getSharedPreferences("PREFS" , 0);
			count=(prefs.getInt("count", 0))-1;
		if(count>=0){
		mainLayout = (LinearLayout)findViewById(R.id.main_layout);
		LayoutInflater inflater =LayoutInflater.from(this);
		  
					add=prefs.getBoolean("add", false);
					if(add){
				 								
						View itemView = inflater.inflate(R.layout.employee_item, null);
						TextView textView 
							= (TextView) itemView.findViewById(R.id.item);
						textView.setText(prefs.getString("name"+count,""));
						   textView.setOnClickListener(new View.OnClickListener() {
								
	@Override
	public void onClick(View v) {
		openNote(((TextView) v).getText().toString());
									
								}
							});
						mainLayout.addView(itemView);
						add =false;
						SharedPreferences pref = getSharedPreferences("PREFS", 0);
						SharedPreferences.Editor editor = pref.edit();
						editor.putBoolean("add",add);
						editor.commit();
					}
						
			
		}
	}catch(Exception e){}
		}
	@Override
	public void onPause(){
		super.onPause();
	
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override	
	public boolean onOptionsItemSelected(MenuItem item){
		Intent intent = new Intent(this,EditEmployee.class);
		startActivity(intent);
		return true;
		
	}
}