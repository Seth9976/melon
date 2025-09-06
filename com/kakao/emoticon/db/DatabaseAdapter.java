package com.kakao.emoticon.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.kakao.emoticon.KakaoEmoticon;

public class DatabaseAdapter extends BaseDatabaseAdapter {
    static final String DATABASE_NAME = "KakaoEmoticons.db";
    private static final int DATABASE_VERSION = 6;
    private static volatile DatabaseAdapter instance;

    public DatabaseAdapter(Context context0, String s, int v) {
        super(context0, s, v);
    }

    @Override  // com.kakao.emoticon.db.BaseDatabaseAdapter
    public void dispose() {
        super.dispose();
        DatabaseAdapter.instance = null;
    }

    @Override  // com.kakao.emoticon.db.BaseDatabaseAdapter
    public void doUpgrade(SQLiteDatabase sQLiteDatabase0, int v) {
        switch(v) {
            case -1: 
            case 0: 
            case 1: {
                this.upgrade1(sQLiteDatabase0);
                this.upgrade2(sQLiteDatabase0);
                this.upgrade3(sQLiteDatabase0);
                this.upgrade4(sQLiteDatabase0);
                break;
            }
            case 2: {
                this.upgrade2(sQLiteDatabase0);
                this.upgrade3(sQLiteDatabase0);
                this.upgrade4(sQLiteDatabase0);
                break;
            }
            case 3: {
                this.upgrade3(sQLiteDatabase0);
                this.upgrade4(sQLiteDatabase0);
                break;
            }
            case 4: {
                this.upgrade4(sQLiteDatabase0);
                break;
            }
            case 5: {
                break;
            }
            default: {
                return;
            }
        }
        this.upgrade5(sQLiteDatabase0);
    }

    public static final DatabaseAdapter getInstance() {
        if(DatabaseAdapter.instance == null || DatabaseAdapter.instance.getDB() == null || !DatabaseAdapter.instance.getDB().isOpen()) {
            Class class0 = DatabaseAdapter.class;
            synchronized(class0) {
                if(DatabaseAdapter.instance == null || DatabaseAdapter.instance.getDB() == null || !DatabaseAdapter.instance.getDB().isOpen()) {
                    try {
                        try {
                            DatabaseAdapter.instance = new DatabaseAdapter(KakaoEmoticon.getApplication().getApplicationContext(), "KakaoEmoticons.db", 6);
                        }
                        catch(SQLiteException unused_ex) {
                            if(DatabaseAdapter.instance != null && DatabaseAdapter.instance.getDB() != null) {
                                try {
                                    DatabaseAdapter.instance.getDB().close();
                                }
                                catch(Exception unused_ex) {
                                }
                            }
                            DatabaseAdapter.instance = null;
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
        }
        return DatabaseAdapter.instance;
    }

    private void upgrade1(SQLiteDatabase sQLiteDatabase0) {
        try {
            sQLiteDatabase0.execSQL("ALTER TABLE emoticons ADD COLUMN is_show Integer DEFAULT 1");
        }
        catch(Exception unused_ex) {
        }
    }

    private void upgrade2(SQLiteDatabase sQLiteDatabase0) {
        try {
            sQLiteDatabase0.execSQL("ALTER TABLE emoticons ADD COLUMN resource_count Integer DEFAULT 0");
            sQLiteDatabase0.execSQL("DROP TABLE emoticon_resources");
        }
        catch(Exception unused_ex) {
        }
    }

    private void upgrade3(SQLiteDatabase sQLiteDatabase0) {
        try {
            sQLiteDatabase0.execSQL("ALTER TABLE emoticons ADD COLUMN server_order_index Integer DEFAULT 0");
        }
        catch(Exception unused_ex) {
        }
    }

    private void upgrade4(SQLiteDatabase sQLiteDatabase0) {
        try {
            sQLiteDatabase0.execSQL("CREATE TABLE emoticon_logs (_id integer primary key autoincrement, log TEXT);");
        }
        catch(Exception unused_ex) {
        }
    }

    private void upgrade5(SQLiteDatabase sQLiteDatabase0) {
        try {
            sQLiteDatabase0.execSQL("ALTER TABLE emoticons ADD COLUMN is_event_item Integer DEFAULT 0");
        }
        catch(Exception unused_ex) {
        }
    }
}

