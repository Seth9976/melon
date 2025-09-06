package com.iloen.melon.alliance.storage;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;

public class AllianceProvider extends ContentProvider {
    public AllianceSQLiteOpenHelper a;
    public static final UriMatcher b;

    static {
        UriMatcher uriMatcher0 = new UriMatcher(-1);
        AllianceProvider.b = uriMatcher0;
        uriMatcher0.addURI("com.iloen.melon.alliance.provider", "shared", 100);
        uriMatcher0.addURI("com.iloen.melon.alliance.provider", "shared/#", 101);
    }

    public AllianceProvider() {
        this.a = null;
    }

    @Override  // android.content.ContentProvider
    public final int bulkInsert(Uri uri0, ContentValues[] arr_contentValues) {
        long v2;
        SQLiteDatabase sQLiteDatabase0 = this.a == null ? null : this.a.getWritableDatabase();
        if(sQLiteDatabase0 == null) {
            LogU.w("AllianceProvider", "bulkInsert() failed to get writable database.");
            return 0;
        }
        if(AllianceProvider.b.match(uri0) != 100) {
            throw new IllegalArgumentException("Unknown URI " + uri0);
        }
        try {
            sQLiteDatabase0.beginTransaction();
            v2 = 0L;
            for(int v = 0; v < arr_contentValues.length; ++v) {
                v2 = sQLiteDatabase0.insert("shared", null, arr_contentValues[v]);
                if(v2 < 0L) {
                    LogU.w("AllianceProvider", "bulkInsert() failed to insert.");
                    break;
                }
            }
            sQLiteDatabase0.setTransactionSuccessful();
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
        if(v2 > 0L) {
            this.getContext().getContentResolver().notifyChange(Uri.withAppendedPath(uri0, "update"), null);
        }
        return (int)v2;
    }

    @Override  // android.content.ContentProvider
    public final int delete(Uri uri0, String s, String[] arr_s) {
        int v;
        SQLiteDatabase sQLiteDatabase0 = this.a == null ? null : this.a.getWritableDatabase();
        if(sQLiteDatabase0 == null) {
            LogU.w("AllianceProvider", "delete() failed to get writable database.");
            return 0;
        }
        switch(AllianceProvider.b.match(uri0)) {
            case 100: {
                v = sQLiteDatabase0.delete("shared", s, arr_s);
                break;
            }
            case 101: {
                v = sQLiteDatabase0.delete("shared", "_id=" + ((String)uri0.getPathSegments().get(1)) + (TextUtils.isEmpty(s) ? "" : " AND (" + s + ")"), arr_s);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown URI " + uri0);
            }
        }
        if(v > 0) {
            this.getContext().getContentResolver().notifyChange(Uri.withAppendedPath(uri0, "remove"), null);
        }
        return v;
    }

    @Override  // android.content.ContentProvider
    public final String getType(Uri uri0) {
        switch(AllianceProvider.b.match(uri0)) {
            case 100: {
                return "vnd.android.cursor.dir/vnd.com.iloen.melon.alliance.provider/shared";
            }
            case 101: {
                return "vnd.android.cursor.item/vnd.com.iloen.melon.alliance.provider/shared";
            }
            default: {
                throw new IllegalArgumentException("Unknown URI " + uri0);
            }
        }
    }

    @Override  // android.content.ContentProvider
    public final Uri insert(Uri uri0, ContentValues contentValues0) {
        LogU.v("AllianceProvider", "insert() " + uri0);
        SQLiteDatabase sQLiteDatabase0 = this.a == null ? null : this.a.getWritableDatabase();
        if(sQLiteDatabase0 == null) {
            LogU.w("AllianceProvider", "insert() failed to get writable database.");
            return null;
        }
        if(AllianceProvider.b.match(uri0) != 100) {
            throw new IllegalArgumentException("Unknown URI " + uri0);
        }
        long v = sQLiteDatabase0.insert("shared", null, contentValues0);
        if(v != -1L) {
            Uri uri1 = ContentUris.withAppendedId(Uri.withAppendedPath(uri0, "insert"), v);
            this.getContext().getContentResolver().notifyChange(uri1, null);
            return uri1;
        }
        return null;
    }

    @Override  // android.content.ContentProvider
    public final boolean onCreate() {
        LogU.v("AllianceProvider", "onCreate()");
        this.a = new AllianceSQLiteOpenHelper(this.getContext());
        return true;
    }

    @Override  // android.content.ContentProvider
    public final Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        SQLiteDatabase sQLiteDatabase0 = this.a == null ? null : this.a.getReadableDatabase();
        if(sQLiteDatabase0 == null) {
            LogU.w("AllianceProvider", "query() failed to get readable database.");
            return null;
        }
        SQLiteQueryBuilder sQLiteQueryBuilder0 = new SQLiteQueryBuilder();
        String s2 = uri0.getQueryParameter("groupby");
        switch(AllianceProvider.b.match(uri0)) {
            case 100: {
                sQLiteQueryBuilder0.setTables("shared");
                break;
            }
            case 101: {
                sQLiteQueryBuilder0.setTables("shared");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(1)));
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown URI " + uri0);
            }
        }
        String s3 = sQLiteQueryBuilder0.buildQuery(arr_s, s, s2, null, s1, null);
        LogU.v("AllianceProvider", "query() SQL = " + s3);
        try {
            return sQLiteDatabase0.rawQuery(s3, arr_s1);
        }
        catch(Exception exception0) {
            LogU.w("AllianceProvider", exception0.getMessage());
            return null;
        }
    }

    @Override  // android.content.ContentProvider
    public final int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        int v;
        LogU.v("AllianceProvider", "update() " + uri0);
        SQLiteDatabase sQLiteDatabase0 = this.a == null ? null : this.a.getWritableDatabase();
        if(sQLiteDatabase0 == null) {
            LogU.w("AllianceProvider", "update() failed to get writable database.");
            return 0;
        }
        switch(AllianceProvider.b.match(uri0)) {
            case 100: {
                v = sQLiteDatabase0.update("shared", contentValues0, s, arr_s);
                break;
            }
            case 101: {
                v = sQLiteDatabase0.update("shared", contentValues0, "_id=" + ((String)uri0.getPathSegments().get(1)) + (TextUtils.isEmpty(s) ? "" : " AND (" + s + ")"), arr_s);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown URI " + uri0);
            }
        }
        if(v > 0) {
            this.getContext().getContentResolver().notifyChange(Uri.withAppendedPath(uri0, "update"), null);
        }
        return v;
    }
}

