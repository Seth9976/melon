package com.iloen.melon.alliance.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.system.DeviceIdentifier;
import jeb.synthetic.TWR;

public class AllianceSQLiteOpenHelper extends SQLiteOpenHelper {
    public AllianceSQLiteOpenHelper(Context context0) {
        super(context0, "alliance.db", null, 1);
    }

    public static void c(SQLiteDatabase sQLiteDatabase0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("device_id", DeviceIdentifier.id(MelonAppBase.instance.getDeviceData().a));
        sQLiteDatabase0.insert("shared", null, contentValues0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase0) {
        sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS shared(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, device_id TEXT NOT NULL);");
        Cursor cursor0 = sQLiteDatabase0.rawQuery("select count(*) from shared", null);
        if(cursor0 != null) {
            try {
                if(!cursor0.moveToFirst()) {
                    AllianceSQLiteOpenHelper.c(sQLiteDatabase0);
                }
                else if(cursor0.getInt(0) <= 0) {
                    AllianceSQLiteOpenHelper.c(sQLiteDatabase0);
                }
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
            cursor0.close();
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
    }
}

