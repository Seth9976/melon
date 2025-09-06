package com.facebook;

import Tf.o;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0005¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000BJ\u0012\u0010\f\u001A\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u001C\u0010\r\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u0011H\u0016J\u001A\u0010\u0012\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0014\u001A\u00020\bH\u0016J\u001E\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b\u0018\u00010\u00162\u0006\u0010\u0005\u001A\u00020\u0006H\u0002JK\u0010\u0018\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001A\u00020\u00062\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\b\u0010\u001B\u001A\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u001CJ9\u0010\u001D\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u001E¨\u0006 "}, d2 = {"Lcom/facebook/FacebookContentProvider;", "Landroid/content/ContentProvider;", "()V", "delete", "", "uri", "Landroid/net/Uri;", "s", "", "strings", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getType", "insert", "contentValues", "Landroid/content/ContentValues;", "onCreate", "", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", "parseCallIdAndAttachmentName", "Landroid/util/Pair;", "Ljava/util/UUID;", "query", "Landroid/database/Cursor;", "strings2", "s2", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class FacebookContentProvider extends ContentProvider {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001A\u00020\u00042\b\u0010\t\u001A\u0004\u0018\u00010\u00042\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u0004H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/FacebookContentProvider$Companion;", "", "()V", "ATTACHMENT_URL_BASE", "", "INVALID_FILE_NAME", "TAG", "kotlin.jvm.PlatformType", "getAttachmentUrl", "applicationId", "callId", "Ljava/util/UUID;", "attachmentName", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String getAttachmentUrl(@Nullable String s, @NotNull UUID uUID0, @Nullable String s1) {
            q.g(uUID0, "callId");
            return String.format("%s%s/%s/%s", Arrays.copyOf(new Object[]{"content://com.facebook.app.FacebookContentProvider", s, uUID0.toString(), s1}, 4));
        }
    }

    @NotNull
    private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String INVALID_FILE_NAME = "..";
    private static final String TAG;

    static {
        FacebookContentProvider.Companion = new Companion(null);
        FacebookContentProvider.TAG = "com.facebook.FacebookContentProvider";
    }

    @Override  // android.content.ContentProvider
    public int delete(@NotNull Uri uri0, @Nullable String s, @Nullable String[] arr_s) {
        q.g(uri0, "uri");
        return 0;
    }

    @NotNull
    public static final String getAttachmentUrl(@Nullable String s, @NotNull UUID uUID0, @Nullable String s1) {
        return FacebookContentProvider.Companion.getAttachmentUrl(s, uUID0, s1);
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
        return true;
    }

    @Override  // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NotNull Uri uri0, @NotNull String s) {
        q.g(uri0, "uri");
        q.g(s, "mode");
        Pair pair0 = this.parseCallIdAndAttachmentName(uri0);
        if(pair0 == null) {
            throw new FileNotFoundException();
        }
        try {
            File file0 = NativeAppCallAttachmentStore.openAttachment(((UUID)pair0.first), ((String)pair0.second));
            if(file0 == null) {
                throw new FileNotFoundException();
            }
            return ParcelFileDescriptor.open(file0, 0x10000000);
        }
        catch(FileNotFoundException fileNotFoundException0) {
        }
        Log.e("com.facebook.FacebookContentProvider", "Got unexpected exception:" + fileNotFoundException0);
        throw fileNotFoundException0;
    }

    private final Pair parseCallIdAndAttachmentName(Uri uri0) {
        try {
            String s = uri0.getPath();
            if(s != null) {
                String s1 = s.substring(1);
                q.f(s1, "this as java.lang.String).substring(startIndex)");
                String[] arr_s = (String[])o.R0(s1, new String[]{"/"}, 0, 6).toArray(new String[0]);
                String s2 = arr_s[0];
                String s3 = arr_s[1];
                return "..".contentEquals(s2) || "..".contentEquals(s3) ? null : new Pair(UUID.fromString(s2), s3);
            }
        }
        catch(Exception unused_ex) {
        }
        return null;
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

