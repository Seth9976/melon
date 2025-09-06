package com.facebook.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdk;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0011\u0018\u0000 \u00192\u00020\u0001:\u0003\u0017\u0018\u0019B1\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u0001¢\u0006\u0002\u0010\u000BR\u0011\u0010\b\u001A\u00020\t¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\n\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001A\u00020\t8F¢\u0006\u0006\u001A\u0004\b\u0016\u0010\r¨\u0006\u001A"}, d2 = {"Lcom/facebook/internal/ImageRequest;", "", "context", "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "callback", "Lcom/facebook/internal/ImageRequest$Callback;", "allowCachedRedirects", "", "callerTag", "(Landroid/content/Context;Landroid/net/Uri;Lcom/facebook/internal/ImageRequest$Callback;ZLjava/lang/Object;)V", "getAllowCachedRedirects", "()Z", "getCallback", "()Lcom/facebook/internal/ImageRequest$Callback;", "getCallerTag", "()Ljava/lang/Object;", "getContext", "()Landroid/content/Context;", "getImageUri", "()Landroid/net/Uri;", "isCachedRedirectAllowed", "Builder", "Callback", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ImageRequest {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\f\u001A\u00020\rJ\t\u0010\u000E\u001A\u00020\u0003HÂ\u0003J\t\u0010\u000F\u001A\u00020\u0005HÂ\u0003J\u001D\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\b2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\u000E\u0010\u0015\u001A\u00020\u00002\u0006\u0010\u0007\u001A\u00020\bJ\u0010\u0010\u0016\u001A\u00020\u00002\b\u0010\t\u001A\u0004\u0018\u00010\nJ\u0010\u0010\u0017\u001A\u00020\u00002\b\u0010\u000B\u001A\u0004\u0018\u00010\u0001J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2 = {"Lcom/facebook/internal/ImageRequest$Builder;", "", "context", "Landroid/content/Context;", "imageUri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "allowCachedRedirects", "", "callback", "Lcom/facebook/internal/ImageRequest$Callback;", "callerTag", "build", "Lcom/facebook/internal/ImageRequest;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "setAllowCachedRedirects", "setCallback", "setCallerTag", "toString", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder {
        private boolean allowCachedRedirects;
        @Nullable
        private Callback callback;
        @Nullable
        private Object callerTag;
        @NotNull
        private final Context context;
        @NotNull
        private final Uri imageUri;

        public Builder(@NotNull Context context0, @NotNull Uri uri0) {
            q.g(context0, "context");
            q.g(uri0, "imageUri");
            super();
            this.context = context0;
            this.imageUri = uri0;
        }

        @NotNull
        public final ImageRequest build() {
            Callback imageRequest$Callback0 = this.callback;
            boolean z = this.allowCachedRedirects;
            Object object0 = this.callerTag == null ? new Object() : this.callerTag;
            return new ImageRequest(this.context, this.imageUri, imageRequest$Callback0, z, object0, null);
        }

        private final Context component1() {
            return this.context;
        }

        private final Uri component2() {
            return this.imageUri;
        }

        @NotNull
        public final Builder copy(@NotNull Context context0, @NotNull Uri uri0) {
            q.g(context0, "context");
            q.g(uri0, "imageUri");
            return new Builder(context0, uri0);
        }

        public static Builder copy$default(Builder imageRequest$Builder0, Context context0, Uri uri0, int v, Object object0) {
            if((v & 1) != 0) {
                context0 = imageRequest$Builder0.context;
            }
            if((v & 2) != 0) {
                uri0 = imageRequest$Builder0.imageUri;
            }
            return imageRequest$Builder0.copy(context0, uri0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Builder)) {
                return false;
            }
            return q.b(this.context, ((Builder)object0).context) ? q.b(this.imageUri, ((Builder)object0).imageUri) : false;
        }

        @Override
        public int hashCode() {
            return this.imageUri.hashCode() + this.context.hashCode() * 0x1F;
        }

        @NotNull
        public final Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        @NotNull
        public final Builder setCallback(@Nullable Callback imageRequest$Callback0) {
            this.callback = imageRequest$Callback0;
            return this;
        }

        @NotNull
        public final Builder setCallerTag(@Nullable Object object0) {
            this.callerTag = object0;
            return this;
        }

        @Override
        @NotNull
        public String toString() {
            return "Builder(context=" + this.context + ", imageUri=" + this.imageUri + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001A\u00020\u00042\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/facebook/internal/ImageRequest$Callback;", "", "Lcom/facebook/internal/ImageResponse;", "response", "Lie/H;", "onCompleted", "(Lcom/facebook/internal/ImageResponse;)V", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        void onCompleted(@Nullable ImageResponse arg1);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\nH\u0007J,\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\n2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0004H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/internal/ImageRequest$Companion;", "", "()V", "ACCESS_TOKEN_PARAM", "", "HEIGHT_PARAM", "MIGRATION_PARAM", "MIGRATION_VALUE", "PATH", "UNSPECIFIED_DIMENSION", "", "WIDTH_PARAM", "getProfilePictureUri", "Landroid/net/Uri;", "userId", "width", "height", "accessToken", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final Uri getProfilePictureUri(@Nullable String s, int v, int v1) {
            return this.getProfilePictureUri(s, v, v1, "");
        }

        @NotNull
        public final Uri getProfilePictureUri(@Nullable String s, int v, int v1, @Nullable String s1) {
            Validate.notNullOrEmpty(s, "userId");
            int v2 = Math.max(v, 0);
            int v3 = Math.max(v1, 0);
            if(v2 == 0 && v3 == 0) {
                throw new IllegalArgumentException("Either width or height must be greater than 0");
            }
            Uri.Builder uri$Builder0 = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, "%s/%s/picture", Arrays.copyOf(new Object[]{FacebookSdk.getGraphApiVersion(), s}, 2)));
            if(v3 != 0) {
                uri$Builder0.appendQueryParameter("height", String.valueOf(v3));
            }
            if(v2 != 0) {
                uri$Builder0.appendQueryParameter("width", String.valueOf(v2));
            }
            uri$Builder0.appendQueryParameter("migration_overrides", "{october_2012:true}");
            if(!Utility.isNullOrEmpty(s1)) {
                uri$Builder0.appendQueryParameter("access_token", s1);
            }
            else if(Utility.isNullOrEmpty(FacebookSdk.getClientToken()) || Utility.isNullOrEmpty(FacebookSdk.getApplicationId())) {
                Log.d("ImageRequest", "Needs access token to fetch profile picture. Without an access token a default silhoutte picture is returned");
            }
            else {
                uri$Builder0.appendQueryParameter("access_token", FacebookSdk.getApplicationId() + '|' + FacebookSdk.getClientToken());
            }
            Uri uri0 = uri$Builder0.build();
            q.f(uri0, "builder.build()");
            return uri0;
        }
    }

    @NotNull
    private static final String ACCESS_TOKEN_PARAM = "access_token";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String HEIGHT_PARAM = "height";
    @NotNull
    private static final String MIGRATION_PARAM = "migration_overrides";
    @NotNull
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    @NotNull
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    @NotNull
    private static final String WIDTH_PARAM = "width";
    private final boolean allowCachedRedirects;
    @Nullable
    private final Callback callback;
    @NotNull
    private final Object callerTag;
    @NotNull
    private final Context context;
    @NotNull
    private final Uri imageUri;

    static {
        ImageRequest.Companion = new Companion(null);
    }

    private ImageRequest(Context context0, Uri uri0, Callback imageRequest$Callback0, boolean z, Object object0) {
        this.context = context0;
        this.imageUri = uri0;
        this.callback = imageRequest$Callback0;
        this.allowCachedRedirects = z;
        this.callerTag = object0;
    }

    public ImageRequest(Context context0, Uri uri0, Callback imageRequest$Callback0, boolean z, Object object0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(context0, uri0, imageRequest$Callback0, z, object0);
    }

    public final boolean getAllowCachedRedirects() {
        return this.allowCachedRedirects;
    }

    @Nullable
    public final Callback getCallback() {
        return this.callback;
    }

    @NotNull
    public final Object getCallerTag() {
        return this.callerTag;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final Uri getImageUri() {
        return this.imageUri;
    }

    @NotNull
    public static final Uri getProfilePictureUri(@Nullable String s, int v, int v1) {
        return ImageRequest.Companion.getProfilePictureUri(s, v, v1);
    }

    @NotNull
    public static final Uri getProfilePictureUri(@Nullable String s, int v, int v1, @Nullable String s1) {
        return ImageRequest.Companion.getProfilePictureUri(s, v, v1, s1);
    }

    public final boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }
}

