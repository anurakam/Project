package com.example.rubberthailand;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewManager extends Activity {
	protected static final String KEY_DIFFICULTY = "manager";
	protected static final int DIFFICULTY_CAL_SHARE = 0;
	protected static final int DIFFICULTY_EMPLOYEE_DATA = 1;
	private EditText editText1;
	private EditText EditText01;
	private Button cal_btn;
	private Button reset_cal_btn;
	private Button save_cal_btn;
	private TextView textView1;
	private String value, rate, total, date, valueshare, valueall;
	private double cal;
	DataRubber dataRubber;
	DataEmployee dataEmployee;
	private SQLiteDatabase EmployeeDB;
	private Cursor EmployeeCursor;

	private TextView textEmployee;
	private ListView listEmployee;
	private ArrayList<String> ArrayEmployee;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int diff = getIntent()
				.getIntExtra(KEY_DIFFICULTY, DIFFICULTY_CAL_SHARE);
		// insert = getInsert(diff);
		switch (diff) {
		case DIFFICULTY_CAL_SHARE:
			setContentView(R.layout.cal_share);
			dataRubber = new DataRubber(this);
			editText1 = (EditText) findViewById(R.id.editText1);
			EditText01 = (EditText) findViewById(R.id.EditText01);
			cal_btn = (Button) findViewById(R.id.cal_btn);
			reset_cal_btn = (Button) findViewById(R.id.reset_cal_btn);
			save_cal_btn = (Button) findViewById(R.id.save_cal_btn);
			textView1 = (TextView) findViewById(R.id.textView1);
			cal_btn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					value = editText1.getText().toString();
					double v = Double.parseDouble(value);
					rate = EditText01.getText().toString();
					double r = Double.parseDouble(rate);
					cal = v * (r / 100);
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

			save_cal_btn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					confirm();
				}
			});

			break;
		case DIFFICULTY_EMPLOYEE_DATA:
			setContentView(R.layout.employee_data);

			listEmployee = (ListView) findViewById(R.id.listEmployee);

			ArrayEmployee = new ArrayList<String>();
			dataEmployee = new DataEmployee(this);
			EmployeeDB = dataEmployee.getReadableDatabase();
			EmployeeCursor = EmployeeDB.rawQuery(
					"SELECT fname FROM employeedata", null);
			EmployeeCursor.moveToFirst();
			while (!EmployeeCursor.isAfterLast()) {
				ArrayEmployee.add(EmployeeCursor.getString(EmployeeCursor
						.getColumnIndex("fname")));
				EmployeeCursor.moveToNext();
			}

			ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(
					getApplicationContext(),
					android.R.layout.simple_list_item_1, ArrayEmployee);
			listEmployee.setAdapter(adapterDir);

			listEmployee.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View view,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(ViewManager.this,
							ViewEmployeeData.class);
					intent.putExtra("index", arg2 + 1);
					intent.putExtra("fname", ArrayEmployee.get(arg2));
					startActivity(intent);
				}
			});

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this, EditEmployee.class);
		startActivity(intent);
		return true;

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
						valueshare = textView1.getText().toString();
						valueall = "";
						addPrice(date, valueall, valueshare);
						editText1.setText("");
						EditText01.setText("");
						textView1.setText("");
						Toast.makeText(ViewManager.this,
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
