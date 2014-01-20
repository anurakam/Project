package com.example.rubberthailand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ViewManeger extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_manager);
		View b1 = findViewById(R.id.cal_share_btn);
		b1.setOnClickListener(this);
		View b2 = findViewById(R.id.em_data_btn);
		b2.setOnClickListener(this);
		
	}
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cal_share_btn:
			Intent intent = new Intent(ViewManeger.this, ViewCalShare.class);
			startActivity(intent);
			break;
		case R.id.em_data_btn:
			Intent intent2 = new Intent(ViewManeger.this, ViewEmployeeData.class);
			startActivity(intent2);
			break;

		default:
			break;
		}
		
	}
}
