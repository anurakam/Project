package com.example.rubberthailand;



import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewManager extends Activity{
	protected static final String KEY_DIFFICULTY = "manager";
	protected static final int DIFFICULTY_CAL_SHARE = 0;
	protected static final int DIFFICULTY_EMPLOYEE_DATA = 1;
	private EditText editText1;
	private EditText EditText01;
	private Button cal_btn;
	private Button reset_cal_btn;
	private TextView textView1;
	private String value,rate,total;
	private double cal;
	
	LinearLayout mainLayout;
	int lent;
	String[] items ;
	int count;
	protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      int diff = getIntent().getIntExtra(KEY_DIFFICULTY,DIFFICULTY_CAL_SHARE);
	       //insert = getInsert(diff);
	       switch (diff) {
		case DIFFICULTY_CAL_SHARE:
			setContentView(R.layout.cal_share);
			editText1 = (EditText) findViewById(R.id.editText1);
			EditText01 = (EditText) findViewById(R.id.EditText01);
			cal_btn = (Button) findViewById(R.id.cal_btn);
			reset_cal_btn = (Button) findViewById(R.id.reset_cal_btn);
			textView1 = (TextView) findViewById(R.id.textView1);
			cal_btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					value = editText1.getText().toString();
					double v = Double.parseDouble(value);
					rate = EditText01.getText().toString();
					double r = Double.parseDouble(rate);
					cal = v * (r/100);
					total = String.valueOf(cal);
					textView1.setText(total);
				}
			});
			reset_cal_btn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					editText1.setText("");
					EditText01.setText("");
					textView1.setText("");
				}
			});
	     
			break;
		case DIFFICULTY_EMPLOYEE_DATA:
			setContentView(R.layout.employee_data);
			SharedPreferences prefs = getSharedPreferences("PREFS" , 0);
			count=(prefs.getInt("count", 0))-1;
		if(count>=0){
		mainLayout = (LinearLayout)findViewById(R.id.main_layout);
		LayoutInflater inflater =LayoutInflater.from(this);
		String[] fname=new String[count];
		if(count>=0){
		 	for(int i=0;i<count;i++)
			{
				fname[i]=prefs.getString("name"+i,"");		
			}
		 	
		}
		
			
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
		
	       
	       
			break;
	
		}
	       
	     
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
