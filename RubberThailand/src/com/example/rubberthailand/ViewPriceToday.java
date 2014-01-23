package com.example.rubberthailand;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
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
	private Button save_price_btn;
	private TextView textView8;
	private String rubberprice, quantity, total, valueshare, valueall, date;
	private double cal;
	DataRubber dataRubber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.price_today);
		dataRubber = new DataRubber(this);
		editText1 = (EditText) findViewById(R.id.editText1);
		EditText01 = (EditText) findViewById(R.id.EditText01);
		cal_price_btn = (Button) findViewById(R.id.cal_price_btn);
		reset_price_btn = (Button) findViewById(R.id.reset_price_btn);
		save_price_btn = (Button) findViewById(R.id.save_price_btn);
		textView8 = (TextView) findViewById(R.id.textView8);
		cal_price_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				rubberprice = editText1.getText().toString();
				double rp = Double.parseDouble(rubberprice);
				quantity = EditText01.getText().toString();
				double qt = Double.parseDouble(quantity);
				cal = rp * qt;
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
		save_price_btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				confirm();
			}

		});

	}

	public void confirm() {
		AlertDialog.Builder dialogConfirm = new AlertDialog.Builder(this);
		dialogConfirm.setTitle("บันทึก");
		dialogConfirm.setIcon(R.drawable.ic_launcher);
		dialogConfirm.setCancelable(true);
		dialogConfirm.setMessage("คุณต้องการบันทึกใช่หรือไม่?");
		dialogConfirm.setPositiveButton("ใช่",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						valueshare = "";
						valueall = textView8.getText().toString();
						addPrice(date, valueall, valueshare);
						editText1.setText("");
						EditText01.setText("");
						textView8.setText("");
						Toast.makeText(ViewPriceToday.this,
								"บันทึกข้อมูลเรียบร้อยแล้ว", Toast.LENGTH_LONG)
								.show();
					}

					private void addPrice(String date, String valueall,
							String valueshare) {
						ContentValues values = new ContentValues();

						values.put("date", System.currentTimeMillis());
						values.put("valueall", valueall);
						values.put("valueshare", valueshare);

						SQLiteDatabase db = dataRubber.getWritableDatabase();
						db.insertOrThrow("rubberprice", null, values);
					}
				});
		dialogConfirm.setNegativeButton("ไม่",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.cancel();
					}
				});

		dialogConfirm.show();
	}
}
