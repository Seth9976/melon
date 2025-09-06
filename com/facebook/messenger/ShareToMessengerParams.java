package com.facebook.messenger;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000F\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001A\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001A\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\r\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u000F\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/facebook/messenger/ShareToMessengerParams;", "", "builder", "Lcom/facebook/messenger/ShareToMessengerParamsBuilder;", "(Lcom/facebook/messenger/ShareToMessengerParamsBuilder;)V", "externalUri", "Landroid/net/Uri;", "getExternalUri", "()Landroid/net/Uri;", "metaData", "", "getMetaData", "()Ljava/lang/String;", "mimeType", "getMimeType", "uri", "getUri", "Companion", "facebook-messenger_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareToMessengerParams {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0005H\u0007R\u0017\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/facebook/messenger/ShareToMessengerParams$Companion;", "", "()V", "VALID_EXTERNAL_URI_SCHEMES", "", "", "getVALID_EXTERNAL_URI_SCHEMES", "()Ljava/util/Set;", "VALID_MIME_TYPES", "getVALID_MIME_TYPES", "VALID_URI_SCHEMES", "getVALID_URI_SCHEMES", "newBuilder", "Lcom/facebook/messenger/ShareToMessengerParamsBuilder;", "uri", "Landroid/net/Uri;", "mimeType", "facebook-messenger_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Set getVALID_EXTERNAL_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_EXTERNAL_URI_SCHEMES;
        }

        @NotNull
        public final Set getVALID_MIME_TYPES() {
            return ShareToMessengerParams.VALID_MIME_TYPES;
        }

        @NotNull
        public final Set getVALID_URI_SCHEMES() {
            return ShareToMessengerParams.VALID_URI_SCHEMES;
        }

        @NotNull
        public final ShareToMessengerParamsBuilder newBuilder(@NotNull Uri uri0, @NotNull String s) {
            q.g(uri0, "uri");
            q.g(s, "mimeType");
            return new ShareToMessengerParamsBuilder(uri0, s);
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final Set VALID_EXTERNAL_URI_SCHEMES;
    @NotNull
    private static final Set VALID_MIME_TYPES;
    @NotNull
    private static final Set VALID_URI_SCHEMES;
    @Nullable
    private final Uri externalUri;
    @Nullable
    private final String metaData;
    @NotNull
    private final String mimeType;
    @NotNull
    private final Uri uri;

    static {
        ShareToMessengerParams.Companion = new Companion(null);
        HashSet hashSet0 = new HashSet();
        hashSet0.add("image/*");
        hashSet0.add("image/jpeg");
        hashSet0.add("image/png");
        hashSet0.add("image/gif");
        hashSet0.add("image/webp");
        hashSet0.add("video/*");
        hashSet0.add("video/mp4");
        hashSet0.add("audio/*");
        hashSet0.add("audio/mpeg");
        ShareToMessengerParams.VALID_MIME_TYPES = p.T0(hashSet0);
        HashSet hashSet1 = new HashSet();
        hashSet1.add("content");
        hashSet1.add("android.resource");
        hashSet1.add("file");
        ShareToMessengerParams.VALID_URI_SCHEMES = p.T0(hashSet1);
        HashSet hashSet2 = new HashSet();
        hashSet2.add("http");
        hashSet2.add("https");
        ShareToMessengerParams.VALID_EXTERNAL_URI_SCHEMES = p.T0(hashSet2);
    }

    public ShareToMessengerParams(@NotNull ShareToMessengerParamsBuilder shareToMessengerParamsBuilder0) {
        q.g(shareToMessengerParamsBuilder0, "builder");
        super();
        Uri uri0 = shareToMessengerParamsBuilder0.getUri();
        if(uri0 == null) {
            throw new IllegalStateException("Must provide non-null uri");
        }
        this.uri = uri0;
        String s = shareToMessengerParamsBuilder0.getMimeType();
        if(s == null) {
            throw new IllegalStateException("Must provide mimeType");
        }
        this.mimeType = s;
        this.metaData = shareToMessengerParamsBuilder0.getMetaData();
        Uri uri1 = shareToMessengerParamsBuilder0.getExternalUri();
        this.externalUri = uri1;
        String s1 = uri0.getScheme();
        if(!p.d0(ShareToMessengerParams.VALID_URI_SCHEMES, s1)) {
            throw new IllegalArgumentException(("Unsupported URI scheme: " + uri0.getScheme()).toString());
        }
        if(!ShareToMessengerParams.VALID_MIME_TYPES.contains(s)) {
            throw new IllegalArgumentException(("Unsupported mime-type: " + s).toString());
        }
        if(uri1 != null) {
            String s2 = uri1.getScheme();
            if(!p.d0(ShareToMessengerParams.VALID_EXTERNAL_URI_SCHEMES, s2)) {
                throw new IllegalArgumentException(("Unsupported external uri scheme: " + uri1.getScheme()).toString());
            }
        }
    }

    @Nullable
    public final Uri getExternalUri() {
        return this.externalUri;
    }

    @Nullable
    public final String getMetaData() {
        return this.metaData;
    }

    @NotNull
    public final String getMimeType() {
        return this.mimeType;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    @NotNull
    public static final ShareToMessengerParamsBuilder newBuilder(@NotNull Uri uri0, @NotNull String s) {
        return ShareToMessengerParams.Companion.newBuilder(uri0, s);
    }
}

