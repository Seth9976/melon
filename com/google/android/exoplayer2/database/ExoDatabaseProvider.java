package com.google.android.exoplayer2.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.android.exoplayer2.util.Log;

public final class ExoDatabaseProvider extends SQLiteOpenHelper implements DatabaseProvider {
    public static final String DATABASE_NAME = "exoplayer_internal.db";
    private static final String TAG = "ExoDatabaseProvider";
    private static final int VERSION = 1;

    public ExoDatabaseProvider(Context context0) {
        super(context0.getApplicationContext(), "exoplayer_internal.db", null, 1);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase0) {
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        ExoDatabaseProvider.wipeDatabase(sQLiteDatabase0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
    }

    private static void wipeDatabase(SQLiteDatabase sQLiteDatabase0) {
        try(Cursor cursor0 = sQLiteDatabase0.query("sqlite_master", new String[]{"type", "name"}, null, null, null, null, null)) {
            while(true) {
                if(!cursor0.moveToNext()) {
                    return;
                }
                String s = cursor0.getString(0);
                String s1 = cursor0.getString(1);
                if(!"sqlite_sequence".equals(s1)) {
                    String s2 = "DROP " + s + " IF EXISTS " + s1;
                    try {
                        sQLiteDatabase0.execSQL(s2);
                    }
                    catch(SQLException sQLException0) {
                        String s3 = String.valueOf(s2);
                        Log.e("ExoDatabaseProvider", (s3.length() == 0 ? new String("Error executing ") : "Error executing " + s3), sQLException0);
                    }
                }
            }
        }
    }
}

