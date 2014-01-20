package com.example.rubberthailand;





import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
//import android.view.View.OnClickListener;

public class MainActivity extends Activity implements android.view.View.OnClickListener  {

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
			Intent intent2 = new Intent(MainActivity.this, ViewPriceBeyond.class);
			startActivity(intent2);
			break;
		case R.id.button3:
			Intent intent3 = new Intent(MainActivity.this, ViewManeger.class);
			startActivity(intent3);
			break;

		default:
			break;
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
