package com.example.rubberthailand;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewCalShare extends Activity{
	private EditText editText1;
	private EditText EditText01;
	private Button cal_btn;
	private Button reset_cal_btn;
	private Button save_cal_btn;
	private TextView textView1;
	private String value,rate,total;
	private double cal;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
		
		
		
	}
		
}
