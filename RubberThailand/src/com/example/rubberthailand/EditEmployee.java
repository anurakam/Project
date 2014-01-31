package com.example.rubberthailand;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class EditEmployee extends Activity{
	private EditText editEmployee;
	private EditText editLname;
	private EditText editPhone;
	private EditText editAddress;
	private DataEmployee dataEmployee;
	private Button save_em_btn;
	private String fname,lname,phone,address;
	// String[] head;
	// String name ;
	// String lname ;
	 //int count;
	// int count1;
	 private TextView header;
	// String namefile[]=new String[100];
	// String lnamefile[]=new String[100];
	// public String key;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				// SharedPreferences pref = getSharedPreferences("PREFS" , 0);
				
		//key=getIntent().getStringExtra("key");
		setContentView(R.layout.employee_new);
		editEmployee=(EditText) findViewById(R.id.editEmployee);
		editLname=(EditText) findViewById(R.id.editLname);
		editPhone=(EditText) findViewById(R.id.editPhone);
		editAddress=(EditText) findViewById(R.id.editAddress);
		save_em_btn=(Button)findViewById(R.id.save_em_btn);
		header= (TextView) findViewById(R.id.header);
		header.setText("เพิ่มข้อมูลลูกจ้างใหม่");
		
		save_em_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fname=editEmployee.getText().toString();
				lname=editLname.getText().toString();
				phone=editPhone.getText().toString();
				address=editAddress.getText().toString();
				addEmployee(fname,lname,phone,address);
				Toast.makeText(EditEmployee.this,
						"บันทึกข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_LONG)
						.show();
			}
			private void addEmployee(String fname,String lname,String phone,String address){
				ContentValues values = new ContentValues();

				values.put("fname", fname);
				values.put("lname", lname);
				values.put("phone", phone);
				values.put("address", address);

				SQLiteDatabase db = dataEmployee.getWritableDatabase();
				db.insertOrThrow("employeedata", null, values);
			}
		});
		
		//prefs.getString("name"+count,"");
		
	/*if(key!=null){	
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
		editLname.setText(data);
		}catch(IOException ioe){
			ioe.printStackTrace();
		} 
		}
		
	else header.setText("เพิ่มข้อมูลลูกจ้างใหม่");
		count=pref.getInt("count",0);	
		
		 		*/	}
	
	//boolean add =false;
	//int check ;
	//int check1;
		/*@Override
		public void onPause(){
			super.onPause();
			//Stop music
			
			check=editEmployee.getText().toString().length();
			check1=editLname.getText().toString().length();
	        //Store data to Array
			if(check>0&&check1>0){
			try{
				StringTokenizer str= new StringTokenizer(editEmployee.getText().toString(),"\n");
				name=(String)str.nextToken();
				namefile[count]=name;
				StringTokenizer str1= new StringTokenizer(editLname.getText().toString(),"\n");
				lname=(String)str1.nextToken();
				lnamefile[count1]=lname;
				Toast.makeText(getApplicationContext(),"save successfully.", Toast.LENGTH_SHORT).show();	
				
				FileOutputStream fosname = openFileOutput(name,Context.MODE_PRIVATE);
				fosname.write(editEmployee.getText().toString().getBytes());
				fosname.flush();
				fosname.close();
				
				FileOutputStream foslname1 = openFileOutput(lname,Context.MODE_PRIVATE);
				foslname1.write(editLname.getText().toString().getBytes());
				foslname1.flush();
				foslname1.close();
				}catch(Exception e){}
			
			SharedPreferences pref = getSharedPreferences("PREFS", 0);
			SharedPreferences.Editor editor = pref.edit();
			if(key==null){	editor.putBoolean("add",true);}
			else{editor.putBoolean("add",false);}
			editor.putString("name"+count,namefile[count]);
			editor.putString("lname"+count1,lnamefile[count1]);
			editor.putInt("count",++count);
			editor.putInt("count1",++count1);
			editor.commit();
			
		}
}*/
	

}

