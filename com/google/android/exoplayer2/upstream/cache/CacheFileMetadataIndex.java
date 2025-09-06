package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.database.VersionTable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class CacheFileMetadataIndex {
    private static final String[] COLUMNS = null;
    private static final int COLUMN_INDEX_LAST_TOUCH_TIMESTAMP = 2;
    private static final int COLUMN_INDEX_LENGTH = 1;
    private static final int COLUMN_INDEX_NAME = 0;
    private static final String COLUMN_LAST_TOUCH_TIMESTAMP = "last_touch_timestamp";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_NAME = "name";
    private static final String TABLE_PREFIX = "ExoPlayerCacheFileMetadata";
    private static final String TABLE_SCHEMA = "(name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)";
    private static final int TABLE_VERSION = 1;
    private static final String WHERE_NAME_EQUALS = "name = ?";
    private final DatabaseProvider databaseProvider;
    private String tableName;

    static {
        CacheFileMetadataIndex.COLUMNS = new String[]{"name", "length", "last_touch_timestamp"};
    }

    public CacheFileMetadataIndex(DatabaseProvider databaseProvider0) {
        this.databaseProvider = databaseProvider0;
    }

    public static void delete(DatabaseProvider databaseProvider0, long v) {
        try {
            String s = Long.toHexString(v);
            String s1 = CacheFileMetadataIndex.getTableName(s);
            SQLiteDatabase sQLiteDatabase0 = databaseProvider0.getWritableDatabase();
            sQLiteDatabase0.beginTransactionNonExclusive();
            try {
                VersionTable.removeVersion(sQLiteDatabase0, 2, s);
                CacheFileMetadataIndex.dropTable(sQLiteDatabase0, s1);
                sQLiteDatabase0.setTransactionSuccessful();
            }
            finally {
                sQLiteDatabase0.endTransaction();
            }
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    private static void dropTable(SQLiteDatabase sQLiteDatabase0, String s) {
        String s1 = String.valueOf(s);
        sQLiteDatabase0.execSQL((s1.length() == 0 ? new String("DROP TABLE IF EXISTS ") : "DROP TABLE IF EXISTS " + s1));
    }

    public Map getAll() {
        try(Cursor cursor0 = this.getCursor()) {
            Map map0 = new HashMap(cursor0.getCount());
            while(true) {
                if(!cursor0.moveToNext()) {
                    break;
                }
                ((HashMap)map0).put(cursor0.getString(0), new CacheFileMetadata(cursor0.getLong(1), cursor0.getLong(2)));
            }
            return map0;
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    private Cursor getCursor() {
        Assertions.checkNotNull(this.tableName);
        return this.databaseProvider.getReadableDatabase().query(this.tableName, CacheFileMetadataIndex.COLUMNS, null, null, null, null, null);
    }

    private static String getTableName(String s) {
        String s1 = String.valueOf(s);
        return s1.length() == 0 ? new String("ExoPlayerCacheFileMetadata") : "ExoPlayerCacheFileMetadata" + s1;
    }

    public void initialize(long v) {
        try {
            String s = Long.toHexString(v);
            this.tableName = CacheFileMetadataIndex.getTableName(s);
            if(VersionTable.getVersion(this.databaseProvider.getReadableDatabase(), 2, s) != 1) {
                SQLiteDatabase sQLiteDatabase0 = this.databaseProvider.getWritableDatabase();
                sQLiteDatabase0.beginTransactionNonExclusive();
                try {
                    VersionTable.setVersion(sQLiteDatabase0, 2, s, 1);
                    CacheFileMetadataIndex.dropTable(sQLiteDatabase0, this.tableName);
                    sQLiteDatabase0.execSQL("CREATE TABLE " + this.tableName + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    sQLiteDatabase0.setTransactionSuccessful();
                }
                finally {
                    sQLiteDatabase0.endTransaction();
                }
                return;
            }
            return;
        }
        catch(SQLException sQLException0) {
        }
        throw new DatabaseIOException(sQLException0);
    }

    public void remove(String s) {
        Assertions.checkNotNull(this.tableName);
        try {
            this.databaseProvider.getWritableDatabase().delete(this.tableName, "name = ?", new String[]{s});
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    public void removeAll(Set set0) {
        Assertions.checkNotNull(this.tableName);
        try {
            SQLiteDatabase sQLiteDatabase0 = this.databaseProvider.getWritableDatabase();
            sQLiteDatabase0.beginTransactionNonExclusive();
            try {
                for(Object object0: set0) {
                    sQLiteDatabase0.delete(this.tableName, "name = ?", new String[]{((String)object0)});
                }
                sQLiteDatabase0.setTransactionSuccessful();
            }
            finally {
                sQLiteDatabase0.endTransaction();
            }
            return;
        }
        catch(SQLException sQLException0) {
        }
        throw new DatabaseIOException(sQLException0);
    }

    public void set(String s, long v, long v1) {
        Assertions.checkNotNull(this.tableName);
        try {
            SQLiteDatabase sQLiteDatabase0 = this.databaseProvider.getWritableDatabase();
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("name", s);
            contentValues0.put("length", v);
            contentValues0.put("last_touch_timestamp", v1);
            sQLiteDatabase0.replaceOrThrow(this.tableName, null, contentValues0);
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }
}

