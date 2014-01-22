package com.example.rubberthailand;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataRubber extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "Rubber.db";
	private static final int DATABASE_VERSION = 1;

	public DataRubber(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE rubberprice ("
				+ "_id  INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "date TEXT NOT NULL,"
				+ "value_all TEXT NOT NULL,"
				+ "value_share TEXT NOT NULL);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS money");
		onCreate(db);
	}

}
