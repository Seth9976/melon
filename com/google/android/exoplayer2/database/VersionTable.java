package com.google.android.exoplayer2.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public final class VersionTable {
    private static final String COLUMN_FEATURE = "feature";
    private static final String COLUMN_INSTANCE_UID = "instance_uid";
    private static final String COLUMN_VERSION = "version";
    public static final int FEATURE_CACHE_CONTENT_METADATA = 1;
    public static final int FEATURE_CACHE_FILE_METADATA = 2;
    public static final int FEATURE_OFFLINE = 0;
    private static final String PRIMARY_KEY = "PRIMARY KEY (feature, instance_uid)";
    private static final String SQL_CREATE_TABLE_IF_NOT_EXISTS = "CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))";
    private static final String TABLE_NAME = "ExoPlayerVersions";
    public static final int VERSION_UNSET = -1;
    private static final String WHERE_FEATURE_AND_INSTANCE_UID_EQUALS = "feature = ? AND instance_uid = ?";

    private static String[] featureAndInstanceUidArguments(int v, String s) {
        return new String[]{Integer.toString(v), s};
    }

    public static int getVersion(SQLiteDatabase sQLiteDatabase0, int v, String s) {
        try {
            if(!VersionTable.tableExists(sQLiteDatabase0, "ExoPlayerVersions")) {
                return -1;
            }
            try(Cursor cursor0 = sQLiteDatabase0.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", VersionTable.featureAndInstanceUidArguments(v, s), null, null, null)) {
                if(cursor0.getCount() == 0) {
                    return -1;
                }
                cursor0.moveToNext();
                return cursor0.getInt(0);
            }
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    public static void removeVersion(SQLiteDatabase sQLiteDatabase0, int v, String s) {
        try {
            if(!VersionTable.tableExists(sQLiteDatabase0, "ExoPlayerVersions")) {
                return;
            }
            sQLiteDatabase0.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", VersionTable.featureAndInstanceUidArguments(v, s));
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    public static void setVersion(SQLiteDatabase sQLiteDatabase0, int v, String s, int v1) {
        try {
            sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("feature", v);
            contentValues0.put("instance_uid", s);
            contentValues0.put("version", v1);
            sQLiteDatabase0.replaceOrThrow("ExoPlayerVersions", null, contentValues0);
        }
        catch(SQLException sQLException0) {
            throw new DatabaseIOException(sQLException0);
        }
    }

    public static boolean tableExists(SQLiteDatabase sQLiteDatabase0, String s) {
        return DatabaseUtils.queryNumEntries(sQLiteDatabase0, "sqlite_master", "tbl_name = ?", new String[]{s}) > 0L;
    }
}

