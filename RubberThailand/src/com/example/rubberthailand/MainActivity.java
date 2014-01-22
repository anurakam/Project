package com.example.rubberthailand;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
//import android.view.View.OnClickListener;

public class MainActivity extends Activity implements android.view.View.OnClickListener  {
	protected static final String KEY_DIFFICULTY = "manager";
	protected static final int DIFFICULTY_CAL_SHARE = 0;
	protected static final int DIFFICULTY_EMPLOYEE_DATA = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View b1 = findViewById(R.id.button1);
		b1.setOnClickListener(this);
		View b2 = findViewById(R.id.button2);
		b2.setOnClickListener(this);
		View b3 = findViewById(R.id.button3);
		b3.setOnClickListener(this);
	}
	    
	    public void onBackPressed() {
	        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
	        dialog.setTitle("ออก");
	        dialog.setIcon(R.drawable.ic_launcher);
	        dialog.setCancelable(true);
	        dialog.setMessage("คุณต้องการออกจากโปรแกรมใช่หรือไม่?");
	        dialog.setPositiveButton("ใช่", new OnClickListener() {
	        	@Override
	            public void onClick(DialogInterface dialog, int which) {
	                finish();
	            }
	        });
	        
	        dialog.setNegativeButton("ไม่ใช่", new OnClickListener() {
	        	@Override
	            public void onClick(DialogInterface dialog, int which) {
	                dialog.cancel();
	            }
	        });
	        
	        dialog.show();                
	    }

	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Intent intent = new Intent(MainActivity.this, ViewSelectRubber.class);
			startActivity(intent);
			break;
		case R.id.button2:
			openManager();
			break;
		case R.id.button3:
			Intent intent3 = new Intent(MainActivity.this, ViewManeger.class);
			startActivity(intent3);
			break;

		default:
			break;
		}	
	}
	
	private void openManager(){
		AlertDialog.Builder DialogManager = new AlertDialog.Builder(this);
		DialogManager.setTitle("การจัดการลูกจ้าง");
		DialogManager.setItems(R.array.manager, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int i) {
				// TODO Auto-generated method stub
				//switch (R.array.dif){
				showManager(i);
				
				//case DIFFICULTY_MONEYIN :
					//Intent i= new Intent(MainActivity.this, ViewInsert.class);
					//startActivity(i);
					//break;
				//}
				
			}
		});
		
		DialogManager.show();
		
	}
	private void showManager(int i) {
		Intent intent2= new Intent(this, ViewManager.class);
		intent2.putExtra(ViewManager.KEY_DIFFICULTY,i);
		startActivity(intent2);
		Log.d(TAG,"เลือก" +i);
	}

}
