package com.google.firebase.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.a;
import com.google.firebase.e;
import java.util.concurrent.atomic.AtomicBoolean;

public class FirebaseInitProvider extends ContentProvider {
    public static final a a;
    public static final AtomicBoolean b;

    static {
        FirebaseInitProvider.a = new a(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
        FirebaseInitProvider.b = new AtomicBoolean(false);
    }

    @Override  // android.content.ContentProvider
    public final void attachInfo(Context context0, ProviderInfo providerInfo0) {
        Preconditions.checkNotNull(providerInfo0, "FirebaseInitProvider ProviderInfo cannot be null.");
        if("com.google.firebase.firebaseinitprovider".equals(providerInfo0.authority)) {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable in application\'s build.gradle.");
        }
        super.attachInfo(context0, providerInfo0);
    }

    @Override  // android.content.ContentProvider
    public final int delete(Uri uri0, String s, String[] arr_s) {
        return 0;
    }

    @Override  // android.content.ContentProvider
    public final String getType(Uri uri0) {
        return null;
    }

    @Override  // android.content.ContentProvider
    public final Uri insert(Uri uri0, ContentValues contentValues0) {
        return null;
    }

    @Override  // android.content.ContentProvider
    public final boolean onCreate() {
        AtomicBoolean atomicBoolean0;
        try {
            atomicBoolean0 = FirebaseInitProvider.b;
            atomicBoolean0.set(true);
            if(e.f(this.getContext()) == null) {
                Log.i("FirebaseInitProvider", "FirebaseApp initialization unsuccessful");
            }
            else {
                Log.i("FirebaseInitProvider", "FirebaseApp initialization successful");
            }
            return false;
        }
        finally {
            atomicBoolean0.set(false);
        }
    }

    @Override  // android.content.ContentProvider
    public final Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        return null;
    }

    @Override  // android.content.ContentProvider
    public final int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        return 0;
    }
}

