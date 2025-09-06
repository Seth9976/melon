package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class zzby extends SQLiteOpenHelper {
    public zzby(Context context0, String s, SQLiteDatabase.CursorFactory sQLiteDatabase$CursorFactory0, int v) {
        if(s.equals("")) {
            s = null;
        }
        super(context0, s, null, 1);
    }
}

