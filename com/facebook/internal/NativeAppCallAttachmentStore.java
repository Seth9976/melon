package com.facebook.internal;

import Tf.v;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import te.j;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0015\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u00013B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u001F\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0007\u00A2\u0006\u0004\b\t\u0010\rJ\u001F\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J\'\u0010\u0017\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u000B2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001B\u001A\u00020\u00112\u000E\u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0019H\u0007\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u001D\u0010\u001EJ%\u0010!\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0007\u00A2\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001A\u0004\u0018\u00010\u000FH\u0007\u00A2\u0006\u0004\b#\u0010$J\u0011\u0010%\u001A\u0004\u0018\u00010\u000FH\u0007\u00A2\u0006\u0004\b%\u0010$J!\u0010\'\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010&\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b\'\u0010(J+\u0010*\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010 \u001A\u0004\u0018\u00010\u001F2\u0006\u0010)\u001A\u00020\u0015H\u0007\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010,\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b,\u0010\u0003R\u001C\u0010.\u001A\n -*\u0004\u0018\u00010\u001F0\u001F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001A\u00020\u001F8\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b0\u0010/R\u0018\u00101\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00102\u00A8\u00064"}, d2 = {"Lcom/facebook/internal/NativeAppCallAttachmentStore;", "", "<init>", "()V", "Ljava/util/UUID;", "callId", "Landroid/graphics/Bitmap;", "attachmentBitmap", "Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "createAttachment", "(Ljava/util/UUID;Landroid/graphics/Bitmap;)Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "Landroid/net/Uri;", "attachmentUri", "(Ljava/util/UUID;Landroid/net/Uri;)Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "bitmap", "Ljava/io/File;", "outputFile", "Lie/H;", "processAttachmentBitmap", "(Landroid/graphics/Bitmap;Ljava/io/File;)V", "imageUri", "", "isContentUri", "processAttachmentFile", "(Landroid/net/Uri;ZLjava/io/File;)V", "", "attachments", "addAttachments", "(Ljava/util/Collection;)V", "cleanupAttachmentsForCall", "(Ljava/util/UUID;)V", "", "attachmentName", "openAttachment", "(Ljava/util/UUID;Ljava/lang/String;)Ljava/io/File;", "getAttachmentsDirectory", "()Ljava/io/File;", "ensureAttachmentsDirectoryExists", "create", "getAttachmentsDirectoryForCall", "(Ljava/util/UUID;Z)Ljava/io/File;", "createDirs", "getAttachmentFile", "(Ljava/util/UUID;Ljava/lang/String;Z)Ljava/io/File;", "cleanupAllAttachments", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "ATTACHMENTS_DIR_NAME", "attachmentsDirectory", "Ljava/io/File;", "Attachment", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class NativeAppCallAttachmentStore {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u001A\u0010\u001A\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0015\"\u0004\b\u001C\u0010\u0017¨\u0006\u001D"}, d2 = {"Lcom/facebook/internal/NativeAppCallAttachmentStore$Attachment;", "", "callId", "Ljava/util/UUID;", "bitmap", "Landroid/graphics/Bitmap;", "originalUri", "Landroid/net/Uri;", "(Ljava/util/UUID;Landroid/graphics/Bitmap;Landroid/net/Uri;)V", "attachmentName", "", "getAttachmentName", "()Ljava/lang/String;", "attachmentUrl", "getAttachmentUrl", "getBitmap", "()Landroid/graphics/Bitmap;", "getCallId", "()Ljava/util/UUID;", "isContentUri", "", "()Z", "setContentUri", "(Z)V", "getOriginalUri", "()Landroid/net/Uri;", "shouldCreateFile", "getShouldCreateFile", "setShouldCreateFile", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Attachment {
        @Nullable
        private final String attachmentName;
        @NotNull
        private final String attachmentUrl;
        @Nullable
        private final Bitmap bitmap;
        @NotNull
        private final UUID callId;
        private boolean isContentUri;
        @Nullable
        private final Uri originalUri;
        private boolean shouldCreateFile;

        public Attachment(@NotNull UUID uUID0, @Nullable Bitmap bitmap0, @Nullable Uri uri0) {
            q.g(uUID0, "callId");
            String s3;
            super();
            this.callId = uUID0;
            this.bitmap = bitmap0;
            this.originalUri = uri0;
            boolean z = true;
            if(uri0 == null) {
                if(bitmap0 == null) {
                    throw new FacebookException("Cannot share media without a bitmap or Uri set");
                }
                this.shouldCreateFile = true;
            }
            else {
                String s = uri0.getScheme();
                if("content".equalsIgnoreCase(s)) {
                    this.isContentUri = true;
                    String s1 = uri0.getAuthority();
                    if(s1 == null || v.r0(s1, "media", false)) {
                        z = false;
                    }
                    this.shouldCreateFile = z;
                    goto label_22;
                }
                if("file".equalsIgnoreCase(uri0.getScheme())) {
                    this.shouldCreateFile = true;
                    goto label_22;
                }
                if(!Utility.isWebUri(uri0)) {
                    throw new FacebookException("Unsupported scheme for media Uri : " + s);
                }
            }
        label_22:
            String s2 = this.shouldCreateFile ? "e73459b1-019c-4e94-8ff7-ba3e5bf6e5ed" : null;
            this.attachmentName = s2;
            if(this.shouldCreateFile) {
                String s4 = FacebookSdk.getApplicationId();
                s3 = FacebookContentProvider.Companion.getAttachmentUrl(s4, uUID0, s2);
            }
            else {
                s3 = String.valueOf(uri0);
            }
            this.attachmentUrl = s3;
        }

        @Nullable
        public final String getAttachmentName() {
            return this.attachmentName;
        }

        @NotNull
        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        @Nullable
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        public final UUID getCallId() {
            return this.callId;
        }

        @Nullable
        public final Uri getOriginalUri() {
            return this.originalUri;
        }

        public final boolean getShouldCreateFile() {
            return this.shouldCreateFile;
        }

        public final boolean isContentUri() {
            return this.isContentUri;
        }

        public final void setContentUri(boolean z) {
            this.isContentUri = z;
        }

        public final void setShouldCreateFile(boolean z) {
            this.shouldCreateFile = z;
        }
    }

    @NotNull
    public static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    @NotNull
    public static final NativeAppCallAttachmentStore INSTANCE;
    private static final String TAG;
    @Nullable
    private static File attachmentsDirectory;

    static {
        NativeAppCallAttachmentStore.INSTANCE = new NativeAppCallAttachmentStore();
        NativeAppCallAttachmentStore.TAG = "com.facebook.internal.NativeAppCallAttachmentStore";
    }

    public static final void addAttachments(@Nullable Collection collection0) {
        if(collection0 == null || collection0.isEmpty()) {
            return;
        }
        else {
            if(NativeAppCallAttachmentStore.attachmentsDirectory == null) {
                NativeAppCallAttachmentStore.cleanupAllAttachments();
            }
            NativeAppCallAttachmentStore.ensureAttachmentsDirectoryExists();
            ArrayList arrayList0 = new ArrayList();
            try {
                for(Object object0: collection0) {
                    Attachment nativeAppCallAttachmentStore$Attachment0 = (Attachment)object0;
                    if(nativeAppCallAttachmentStore$Attachment0.getShouldCreateFile()) {
                        File file0 = NativeAppCallAttachmentStore.getAttachmentFile(nativeAppCallAttachmentStore$Attachment0.getCallId(), nativeAppCallAttachmentStore$Attachment0.getAttachmentName(), true);
                        if(file0 != null) {
                            arrayList0.add(file0);
                            if(nativeAppCallAttachmentStore$Attachment0.getBitmap() != null) {
                                NativeAppCallAttachmentStore.INSTANCE.processAttachmentBitmap(nativeAppCallAttachmentStore$Attachment0.getBitmap(), file0);
                            }
                            else if(nativeAppCallAttachmentStore$Attachment0.getOriginalUri() != null) {
                                NativeAppCallAttachmentStore.INSTANCE.processAttachmentFile(nativeAppCallAttachmentStore$Attachment0.getOriginalUri(), nativeAppCallAttachmentStore$Attachment0.isContentUri(), file0);
                            }
                        }
                    }
                }
                return;
            }
            catch(IOException iOException0) {
            }
        }
        Log.e("com.facebook.internal.NativeAppCallAttachmentStore", "Got unexpected exception:" + iOException0);
        for(Object object1: arrayList0) {
            File file1 = (File)object1;
            if(file1 != null) {
                try {
                    file1.delete();
                }
                catch(Exception unused_ex) {
                }
            }
        }
        throw new FacebookException(iOException0);
    }

    public static final void cleanupAllAttachments() {
        File file0 = NativeAppCallAttachmentStore.getAttachmentsDirectory();
        if(file0 != null) {
            j.z(file0);
        }
    }

    public static final void cleanupAttachmentsForCall(@NotNull UUID uUID0) {
        q.g(uUID0, "callId");
        File file0 = NativeAppCallAttachmentStore.getAttachmentsDirectoryForCall(uUID0, false);
        if(file0 != null) {
            j.z(file0);
        }
    }

    @NotNull
    public static final Attachment createAttachment(@NotNull UUID uUID0, @NotNull Bitmap bitmap0) {
        q.g(uUID0, "callId");
        q.g(bitmap0, "attachmentBitmap");
        return new Attachment(uUID0, bitmap0, null);
    }

    @NotNull
    public static final Attachment createAttachment(@NotNull UUID uUID0, @NotNull Uri uri0) {
        q.g(uUID0, "callId");
        q.g(uri0, "attachmentUri");
        return new Attachment(uUID0, null, uri0);
    }

    @Nullable
    public static final File ensureAttachmentsDirectoryExists() {
        File file0 = NativeAppCallAttachmentStore.getAttachmentsDirectory();
        if(file0 != null) {
            file0.mkdirs();
        }
        return file0;
    }

    @Nullable
    public static final File getAttachmentFile(@NotNull UUID uUID0, @Nullable String s, boolean z) {
        q.g(uUID0, "callId");
        File file0 = NativeAppCallAttachmentStore.getAttachmentsDirectoryForCall(uUID0, z);
        if(file0 == null) {
            return null;
        }
        try {
            return new File(file0, URLEncoder.encode(s, "UTF-8"));
        }
        catch(UnsupportedEncodingException unused_ex) {
            return null;
        }
    }

    @Nullable
    public static final File getAttachmentsDirectory() {
        synchronized(NativeAppCallAttachmentStore.class) {
            if(NativeAppCallAttachmentStore.attachmentsDirectory == null) {
                NativeAppCallAttachmentStore.attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), "com.facebook.NativeAppCallAttachmentStore.files");
            }
            return NativeAppCallAttachmentStore.attachmentsDirectory;
        }
    }

    @Nullable
    public static final File getAttachmentsDirectoryForCall(@NotNull UUID uUID0, boolean z) {
        q.g(uUID0, "callId");
        if(NativeAppCallAttachmentStore.attachmentsDirectory == null) {
            return null;
        }
        File file0 = new File(NativeAppCallAttachmentStore.attachmentsDirectory, uUID0.toString());
        if(z && !file0.exists()) {
            file0.mkdirs();
        }
        return file0;
    }

    @Nullable
    public static final File openAttachment(@Nullable UUID uUID0, @Nullable String s) {
        if(!Utility.isNullOrEmpty(s) && uUID0 != null) {
            try {
                return NativeAppCallAttachmentStore.getAttachmentFile(uUID0, s, false);
            }
            catch(IOException unused_ex) {
                throw new FileNotFoundException();
            }
        }
        throw new FileNotFoundException();
    }

    private final void processAttachmentBitmap(Bitmap bitmap0, File file0) {
        FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
        try {
            bitmap0.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream0);
        }
        finally {
            Utility.closeQuietly(fileOutputStream0);
        }
    }

    private final void processAttachmentFile(Uri uri0, boolean z, File file0) {
        FileOutputStream fileOutputStream0 = new FileOutputStream(file0);
        try {
            InputStream inputStream0 = z ? FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri0) : new FileInputStream(uri0.getPath());
            Utility.copyAndCloseInputStream(inputStream0, fileOutputStream0);
        }
        finally {
            Utility.closeQuietly(fileOutputStream0);
        }
    }
}

