package com.kakao.emoticon.db;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public class CursorWrapper implements Cursor {
    private final int EXCUTE_WARNING_LIMIT;
    protected Cursor delegator;
    private String loggingName;
    private long startMillis;

    public CursorWrapper(Cursor cursor0, String s) {
        this.EXCUTE_WARNING_LIMIT = 50;
        this.delegator = cursor0;
        this.loggingName = s;
        this.startMillis = 0L;
    }

    @Override  // android.database.Cursor
    public void close() {
        this.delegator.close();
    }

    @Override  // android.database.Cursor
    public void copyStringToBuffer(int v, CharArrayBuffer charArrayBuffer0) {
        this.delegator.copyStringToBuffer(v, charArrayBuffer0);
    }

    @Override  // android.database.Cursor
    public void deactivate() {
        this.delegator.deactivate();
    }

    @Override  // android.database.Cursor
    public byte[] getBlob(int v) {
        return this.delegator.getBlob(v);
    }

    @Override  // android.database.Cursor
    public int getColumnCount() {
        return this.delegator.getColumnCount();
    }

    @Override  // android.database.Cursor
    public int getColumnIndex(String s) {
        return this.delegator.getColumnIndex(s);
    }

    @Override  // android.database.Cursor
    public int getColumnIndexOrThrow(String s) {
        return this.delegator.getColumnIndexOrThrow(s);
    }

    @Override  // android.database.Cursor
    public String getColumnName(int v) {
        return this.delegator.getColumnName(v);
    }

    @Override  // android.database.Cursor
    public String[] getColumnNames() {
        return this.delegator.getColumnNames();
    }

    @Override  // android.database.Cursor
    public int getCount() {
        return this.delegator.getCount();
    }

    @Override  // android.database.Cursor
    public double getDouble(int v) {
        return this.delegator.getDouble(v);
    }

    @Override  // android.database.Cursor
    public Bundle getExtras() {
        return this.delegator.getExtras();
    }

    @Override  // android.database.Cursor
    public float getFloat(int v) {
        return this.delegator.getFloat(v);
    }

    @Override  // android.database.Cursor
    public int getInt(int v) {
        return this.delegator.getInt(v);
    }

    @Override  // android.database.Cursor
    public long getLong(int v) {
        return this.delegator.getLong(v);
    }

    @Override  // android.database.Cursor
    public Uri getNotificationUri() {
        return null;
    }

    @Override  // android.database.Cursor
    public int getPosition() {
        return this.delegator.getPosition();
    }

    @Override  // android.database.Cursor
    public short getShort(int v) {
        return this.delegator.getShort(v);
    }

    @Override  // android.database.Cursor
    public String getString(int v) {
        return this.delegator.getString(v);
    }

    @Override  // android.database.Cursor
    public int getType(int v) {
        return 0;
    }

    @Override  // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return this.delegator.getWantsAllOnMoveCalls();
    }

    @Override  // android.database.Cursor
    public boolean isAfterLast() {
        return this.delegator.isAfterLast();
    }

    @Override  // android.database.Cursor
    public boolean isBeforeFirst() {
        return this.delegator.isBeforeFirst();
    }

    @Override  // android.database.Cursor
    public boolean isClosed() {
        return this.delegator.isClosed();
    }

    @Override  // android.database.Cursor
    public boolean isFirst() {
        return this.delegator.isFirst();
    }

    @Override  // android.database.Cursor
    public boolean isLast() {
        return this.delegator.isLast();
    }

    @Override  // android.database.Cursor
    public boolean isNull(int v) {
        return this.delegator.isNull(v);
    }

    @Override  // android.database.Cursor
    public boolean move(int v) {
        return this.delegator.move(v);
    }

    @Override  // android.database.Cursor
    public boolean moveToFirst() {
        return this.delegator.moveToFirst();
    }

    @Override  // android.database.Cursor
    public boolean moveToLast() {
        return this.delegator.moveToLast();
    }

    @Override  // android.database.Cursor
    public boolean moveToNext() {
        return this.delegator.moveToNext();
    }

    @Override  // android.database.Cursor
    public boolean moveToPosition(int v) {
        return this.delegator.moveToPosition(v);
    }

    @Override  // android.database.Cursor
    public boolean moveToPrevious() {
        return this.delegator.moveToPrevious();
    }

    private void printLog(long v) {
        if(Long.compare(System.currentTimeMillis() - v, 50L) > 0) {
            stringBuilder0.toString();
            return;
        }
        stringBuilder1.toString();
    }

    @Override  // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver0) {
        this.delegator.registerContentObserver(contentObserver0);
    }

    @Override  // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver0) {
        this.delegator.registerDataSetObserver(dataSetObserver0);
    }

    @Override  // android.database.Cursor
    public boolean requery() {
        return this.delegator.requery();
    }

    @Override  // android.database.Cursor
    public Bundle respond(Bundle bundle0) {
        return this.delegator.respond(bundle0);
    }

    @Override  // android.database.Cursor
    public void setExtras(Bundle bundle0) {
    }

    @Override  // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver0, Uri uri0) {
        this.delegator.setNotificationUri(contentResolver0, uri0);
    }

    @Override  // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver0) {
        this.delegator.unregisterContentObserver(contentObserver0);
    }

    @Override  // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver0) {
        this.delegator.unregisterDataSetObserver(dataSetObserver0);
    }
}

