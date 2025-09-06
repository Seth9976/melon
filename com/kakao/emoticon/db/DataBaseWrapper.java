package com.kakao.emoticon.db;

import U4.x;
import android.annotation.TargetApi;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Map;

@TargetApi(5)
public class DataBaseWrapper {
    public final int EXCUTE_WARNING_LIMIT;
    private long beginTransactionAt;
    protected SQLiteDatabase delegator;
    private boolean isAvailableIndexedBy;
    private String sqliteVersion;

    public DataBaseWrapper(SQLiteDatabase sQLiteDatabase0, String s) {
        this.EXCUTE_WARNING_LIMIT = 50;
        this.delegator = sQLiteDatabase0;
        this.sqliteVersion = s;
        this.isAvailableIndexedBy = true;
    }

    public void acquireReference() {
        this.delegator.acquireReference();
    }

    private String appendArrayArgsLog(String[] arr_s) {
        return arr_s == null ? "" : x.m(new StringBuilder(", ["), TextUtils.join(", ", arr_s), "]");
    }

    public void beginTransaction() {
        this.delegator.beginTransaction();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener0) {
        this.delegator.beginTransactionWithListener(sQLiteTransactionListener0);
    }

    private boolean checkAvailableIndex() [...] // Inlined contents

    public void close() {
        this.delegator.close();
    }

    public SQLiteStatement compileStatement(String s) {
        return this.delegator.compileStatement(s);
    }

    public int delete(String s, String s1, String[] arr_s) {
        return this.delegator.delete(s, s1, arr_s);
    }

    public void endTransaction() {
        this.delegator.endTransaction();
    }

    @Override
    public boolean equals(Object object0) {
        return this.delegator.equals(object0);
    }

    public void execSQL(String s) {
        this.delegator.execSQL(s);
    }

    public void execSQL(String s, Object[] arr_object) {
        this.delegator.execSQL(s, arr_object);
    }

    public long getMaximumSize() {
        return this.delegator.getMaximumSize();
    }

    public long getPageSize() {
        return this.delegator.getPageSize();
    }

    public SQLiteDatabase getSqliteDatabase() {
        return this.delegator;
    }

    public String getSqliteVersion() {
        return this.sqliteVersion;
    }

    public Map getSyncedTables() {
        return this.delegator.getSyncedTables();
    }

    public int getVersion() {
        return this.delegator.getVersion();
    }

    @Override
    public int hashCode() {
        return this.delegator.hashCode();
    }

    public boolean inTransaction() {
        return this.delegator.inTransaction();
    }

    public long insert(String s, String s1, ContentValues contentValues0) {
        return this.delegator.insert(s, s1, contentValues0);
    }

    public long insertOrThrow(String s, String s1, ContentValues contentValues0) {
        return this.delegator.insertOrThrow(s, s1, contentValues0);
    }

    public long insertWithOnConflict(String s, String s1, ContentValues contentValues0, int v) {
        return this.delegator.insertWithOnConflict(s, s1, contentValues0, v);
    }

    public boolean isAvailableIndexedBy() {
        return this.isAvailableIndexedBy;
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegator.isDbLockedByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        return this.delegator.isDbLockedByOtherThreads();
    }

    public boolean isOpen() {
        return this.delegator.isOpen();
    }

    public boolean isReadOnly() {
        return this.delegator.isReadOnly();
    }

    public void markTableSyncable(String s, String s1) {
        this.delegator.markTableSyncable(s, s1);
    }

    public void markTableSyncable(String s, String s1, String s2) {
        this.delegator.markTableSyncable(s, s1, s2);
    }

    public boolean needUpgrade(int v) {
        return this.delegator.needUpgrade(v);
    }

    private void printLog(String s, long v) {
        stringBuilder0.toString();
        if(System.currentTimeMillis() - v > 50L) {
        }
    }

    public Cursor query(String s, String s1, String[] arr_s, String s2, String[] arr_s1, String s3, String s4, String s5) {
        return this.query(false, s, s1, arr_s, s2, arr_s1, s3, s4, s5, null);
    }

    public Cursor query(String s, String s1, String[] arr_s, String s2, String[] arr_s1, String s3, String s4, String s5, String s6) {
        return this.query(false, s, s1, arr_s, s2, arr_s1, s3, s4, s5, s6);
    }

    public Cursor query(String s, String[] arr_s, String s1, String[] arr_s1, String s2, String s3, String s4) {
        return this.query(false, s, null, arr_s, s1, arr_s1, s2, s3, s4, null);
    }

    public Cursor query(String s, String[] arr_s, String s1, String[] arr_s1, String s2, String s3, String s4, String s5) {
        return this.query(false, s, null, arr_s, s1, arr_s1, s2, s3, s4, s5);
    }

    public Cursor query(boolean z, String s, String s1, String[] arr_s, String s2, String[] arr_s1, String s3, String s4, String s5, String s6) {
        if(this.isAvailableIndexedBy() && !TextUtils.isEmpty(s1)) {
            s = s + " INDEXED BY " + s1;
        }
        Cursor cursor0 = this.delegator.query(z, s, arr_s, s2, arr_s1, s3, s4, s5, s6);
        if(cursor0 != null) {
            cursor0.getCount();
        }
        return new CursorWrapper(cursor0, null);
    }

    public Cursor queryWithFactory(SQLiteDatabase.CursorFactory sQLiteDatabase$CursorFactory0, boolean z, String s, String[] arr_s, String s1, String[] arr_s1, String s2, String s3, String s4, String s5) {
        return new CursorWrapper(this.delegator.queryWithFactory(sQLiteDatabase$CursorFactory0, z, s, arr_s, s1, arr_s1, s2, s3, s4, s5), "");
    }

    public Cursor rawQuery(String s, String[] arr_s) {
        return new CursorWrapper(this.delegator.rawQuery(s, arr_s), s);
    }

    public Cursor rawQueryWithFactory(SQLiteDatabase.CursorFactory sQLiteDatabase$CursorFactory0, String s, String[] arr_s, String s1) {
        return new CursorWrapper(this.delegator.rawQueryWithFactory(sQLiteDatabase$CursorFactory0, s, arr_s, s1), s);
    }

    public void releaseReference() {
        this.delegator.releaseReference();
    }

    public void releaseReferenceFromContainer() {
        this.delegator.releaseReferenceFromContainer();
    }

    public long replace(String s, String s1, ContentValues contentValues0) {
        return this.delegator.replace(s, s1, contentValues0);
    }

    public long replaceOrThrow(String s, String s1, ContentValues contentValues0) {
        return this.delegator.replaceOrThrow(s, s1, contentValues0);
    }

    public void setLocale(Locale locale0) {
        this.delegator.setLocale(locale0);
    }

    public void setLockingEnabled(boolean z) {
        this.delegator.setLockingEnabled(z);
    }

    public long setMaximumSize(long v) {
        return this.delegator.setMaximumSize(v);
    }

    public void setPageSize(long v) {
        this.delegator.setPageSize(v);
    }

    public void setTransactionSuccessful() {
        this.delegator.setTransactionSuccessful();
    }

    public void setVersion(int v) {
        this.delegator.setVersion(v);
    }

    @Override
    public String toString() {
        return this.delegator.toString();
    }

    public int update(String s, ContentValues contentValues0, String s1, String[] arr_s) {
        return this.delegator.update(s, contentValues0, s1, arr_s);
    }

    public int updateWithOnConflict(String s, ContentValues contentValues0, String s1, String[] arr_s, int v) {
        return this.delegator.updateWithOnConflict(s, contentValues0, s1, arr_s, v);
    }

    public boolean yieldIfContended() {
        return this.delegator.yieldIfContended();
    }

    public boolean yieldIfContendedSafely() {
        return this.delegator.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long v) {
        return this.delegator.yieldIfContendedSafely(v);
    }
}

