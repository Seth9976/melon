package com.iloen.melon.utils.log.error;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

public class UncaughtExceptionHandlerContentProvider extends ContentProvider {
    @Override  // android.content.ContentProvider
    public int delete(Uri uri0, String s, String[] arr_s) {
        return 0;
    }

    @Override  // android.content.ContentProvider
    public String getType(Uri uri0) {
        return null;
    }

    @Override  // android.content.ContentProvider
    public Uri insert(Uri uri0, ContentValues contentValues0) {
        return null;
    }

    @Override  // android.content.ContentProvider
    public boolean onCreate() {
        Thread.setDefaultUncaughtExceptionHandler(new MelonUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler()));
        return true;
    }

    @Override  // android.content.ContentProvider
    public Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        return null;
    }

    @Override  // android.content.ContentProvider
    public int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        return 0;
    }
}

