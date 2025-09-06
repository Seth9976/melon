package com.melon.data.newlogin;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.log.LogU;

public class AccountStubProvider extends ContentProvider {
    @Override  // android.content.ContentProvider
    public final int delete(Uri uri0, String s, String[] arr_s) {
        LogU.v("AccountStubProvider", "delete() uri:" + uri0);
        return 0;
    }

    @Override  // android.content.ContentProvider
    public final String getType(Uri uri0) {
        LogU.v("AccountStubProvider", "getType() uri:" + uri0);
        return "";
    }

    @Override  // android.content.ContentProvider
    public final Uri insert(Uri uri0, ContentValues contentValues0) {
        LogU.v("AccountStubProvider", "insert() uri:" + uri0);
        return null;
    }

    @Override  // android.content.ContentProvider
    public final boolean onCreate() {
        String s;
        LogU.v("AccountStubProvider", "onCreate()");
        try {
            s = "UNKNOWN";
            s = this.getCallingPackage();
        }
        catch(Exception unused_ex) {
        }
        Reporter.createReporter(Type.PLAYER, LogLevel.INFO).setMessage("AccountStubProvider in use :" + s);
        return true;
    }

    @Override  // android.content.ContentProvider
    public final Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        LogU.v("AccountStubProvider", "query() uri:" + uri0);
        return null;
    }

    @Override  // android.content.ContentProvider
    public final int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        LogU.v("AccountStubProvider", "update() uri:" + uri0);
        return 0;
    }
}

