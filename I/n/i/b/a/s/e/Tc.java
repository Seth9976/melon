package i.n.i.b.a.s.e;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class tc extends SQLiteOpenHelper {
    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase0) {
        sQLiteDatabase0.execSQL("CREATE TABLE keys (storage_name TEXT NOT NULL, uri TEXT NOT NULL, init_data TEXT NOT NULL, key_set_id TEXT NOT NULL, timestamp NUMBER NOT NULL, PRIMARY KEY (storage_name, uri, init_data, key_set_id) )");
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS keys");
    }
}

