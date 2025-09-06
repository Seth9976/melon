package androidx.media3.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import e3.b;

public class StandaloneDatabaseProvider extends SQLiteOpenHelper {
    public StandaloneDatabaseProvider(Context context0) {
        super(context0.getApplicationContext(), "exoplayer_internal.db", null, 1);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase0) {
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
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
                        b.q("SADatabaseProvider", "Error executing " + s2, sQLException0);
                    }
                }
            }
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
    }
}

