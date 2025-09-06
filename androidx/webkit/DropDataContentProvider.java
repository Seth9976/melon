package androidx.webkit;

import T4.m;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;

public final class DropDataContentProvider extends ContentProvider {
    public DropDataContentProviderBoundaryInterface a;

    public final DropDataContentProviderBoundaryInterface a() {
        if(this.a == null) {
            DropDataContentProviderBoundaryInterface dropDataContentProviderBoundaryInterface0 = m.a.getDropDataProvider();
            this.a = dropDataContentProviderBoundaryInterface0;
            dropDataContentProviderBoundaryInterface0.onCreate();
        }
        return this.a;
    }

    @Override  // android.content.ContentProvider
    public final Bundle call(String s, String s1, Bundle bundle0) {
        return this.a().call(s, s1, bundle0);
    }

    @Override  // android.content.ContentProvider
    public final int delete(Uri uri0, String s, String[] arr_s) {
        throw new UnsupportedOperationException("delete method is not supported.");
    }

    @Override  // android.content.ContentProvider
    public final String getType(Uri uri0) {
        return this.a().getType(uri0);
    }

    @Override  // android.content.ContentProvider
    public final Uri insert(Uri uri0, ContentValues contentValues0) {
        throw new UnsupportedOperationException("Insert method is not supported.");
    }

    @Override  // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override  // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri0, String s) {
        return this.a().openFile(this, uri0);
    }

    @Override  // android.content.ContentProvider
    public final Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        return this.a().query(uri0, arr_s, s, arr_s1, s1);
    }

    @Override  // android.content.ContentProvider
    public final int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        throw new UnsupportedOperationException("update method is not supported.");
    }
}

