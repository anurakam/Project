package com.example.rubberthailand;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class EditEmployee extends ViewEmployeeData{
	private EditText editEmployee;
	 String[] head;
	 String name ;
	 int count;
	 private TextView header;
	 String namefile[]=new String[100];
	 public String key;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				 SharedPreferences pref = getSharedPreferences("PREFS" , 0);
				
		key=getIntent().getStringExtra("key");
		setContentView(R.layout.employee_new);
		editEmployee=(EditText) findViewById(R.id.editEmployee);
		header= (TextView) findViewById(R.id.header);
		
		//prefs.getString("name"+count,"");
		
	if(key!=null){	
		try{
			
			header.setText(key);
		
		FileInputStream fln =openFileInput(key);
		InputStreamReader reader = new InputStreamReader(fln);
		char[] buffer =new char[100];
		String data="";
		int charReadCount;
		while((charReadCount=reader.read(buffer))>0){
			String readString =String.copyValueOf(buffer, 0, charReadCount);
			data+=readString;
			buffer=new char[100];
		}reader.close();
		editEmployee.setText(data);
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
		}
		
	else header.setText("เพิ่มข้อมูลลูกจ้างใหม่");
		count=pref.getInt("count",0);	
		
		 			}
	
	boolean add =false;
	int check ;
@Override
		public void onPause(){
			super.onPause();
			//Stop music
			
			check=editEmployee.getText().toString().length();
	        //Store data to Array
			if(check>0){
			try{
				StringTokenizer str= new StringTokenizer(editEmployee.getText().toString(),"\n");
				name=(String)str.nextToken();
				namefile[count]=name;
				
				Toast.makeText(getApplicationContext(),"save successfully.", Toast.LENGTH_SHORT).show();	
				
				FileOutputStream fos = openFileOutput(name,Context.MODE_PRIVATE);
				fos.write(editEmployee.getText().toString().getBytes());
				fos.flush();
				fos.close();
				}catch(Exception e){}
			
			SharedPreferences pref = getSharedPreferences("PREFS", 0);
			SharedPreferences.Editor editor = pref.edit();
			if(key==null){	editor.putBoolean("add",true);}
			else{editor.putBoolean("add",false);}
			editor.putString("name"+count,namefile[count]);
			editor.putInt("count",++count);
			
			editor.commit();
			
		}
}
	

}

