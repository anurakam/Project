package com.example.rubberthailand;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ViewSelectRubber extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_rubber);
		View b1 = findViewById(R.id.btn_Water);
		b1.setOnClickListener(this);
		View b2 = findViewById(R.id.btn_sheet);
		b2.setOnClickListener(this);
		View b3 = findViewById(R.id.btn_lump);
		b3.setOnClickListener(this);
		View b4 = findViewById(R.id.btn_scrap);
		b4.setOnClickListener(this);
		
	}
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_Water:
			Intent intent = new Intent(ViewSelectRubber.this, ViewPriceToday.class);
			startActivity(intent);
			break;
		case R.id.btn_sheet:
			Intent intent2 = new Intent(ViewSelectRubber.this, ViewPriceToday.class);
			startActivity(intent2);
			break;
		case R.id.btn_lump:
			Intent intent3 = new Intent(ViewSelectRubber.this, ViewPriceToday.class);
			startActivity(intent3);
			break;
		case R.id.btn_scrap:
			Intent intent4 = new Intent(ViewSelectRubber.this, ViewPriceToday.class);
			startActivity(intent4);
			break;
		default:
			break;
		}
		
	}
}
