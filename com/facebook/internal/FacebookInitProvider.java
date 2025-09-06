package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000BJ\u0012\u0010\f\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u001C\u0010\r\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016JK\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001A\u00020\u00062\u000E\u0010\u0014\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0015\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u0016J9\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u0018¨\u0006\u001A"}, d2 = {"Lcom/facebook/internal/FacebookInitProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", "uri", "Landroid/net/Uri;", "selection", "", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookInitProvider extends ContentProvider {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/FacebookInitProvider$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    private static final String TAG;

    static {
        FacebookInitProvider.Companion = new Companion(null);
        FacebookInitProvider.TAG = "FacebookInitProvider";
    }

    @Override  // android.content.ContentProvider
    public int delete(@NotNull Uri uri0, @Nullable String s, @Nullable String[] arr_s) {
        q.g(uri0, "uri");
        return 0;
    }

    @Override  // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri0) {
        q.g(uri0, "uri");
        return null;
    }

    @Override  // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri0, @Nullable ContentValues contentValues0) {
        q.g(uri0, "uri");
        return null;
    }

    @Override  // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context0 = this.getContext();
            if(context0 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            FacebookSdk.sdkInitialize(context0);
            return false;
        }
        catch(Exception exception0) {
        }
        Log.i("FacebookInitProvider", "Failed to auto initialize the Facebook SDK", exception0);
        return false;
    }

    @Override  // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri0, @Nullable String[] arr_s, @Nullable String s, @Nullable String[] arr_s1, @Nullable String s1) {
        q.g(uri0, "uri");
        return null;
    }

    @Override  // android.content.ContentProvider
    public int update(@NotNull Uri uri0, @Nullable ContentValues contentValues0, @Nullable String s, @Nullable String[] arr_s) {
        q.g(uri0, "uri");
        return 0;
    }
}

