package com.example.rubberthailand;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPriceToday extends Activity {
	private EditText editText1;
	private EditText EditText01;
	private Button cal_price_btn;
	private Button reset_price_btn;
	private TextView textView8;
	private String rubberprice, quantity, total;
	private double cal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.price_today);
		editText1 = (EditText) findViewById(R.id.editText1);
		EditText01 = (EditText) findViewById(R.id.EditText01);
		cal_price_btn = (Button) findViewById(R.id.cal_price_btn);
		reset_price_btn = (Button) findViewById(R.id.reset_price_btn);
		textView8 = (TextView) findViewById(R.id.textView8);
		cal_price_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				rubberprice = editText1.getText().toString();
				double rp = Double.parseDouble(rubberprice);
				quantity = EditText01.getText().toString();
				double qt = Double.parseDouble(quantity);
				cal = rp + qt;
				total = String.valueOf(cal);
				textView8.setText(total);
			}
		});
		reset_price_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				editText1.setText("");
				EditText01.setText("");
				textView8.setText("");
			}
		});
	}
}
