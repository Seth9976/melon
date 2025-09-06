package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001B2\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001C\u001BB\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u001A\u0010\u0017\u001A\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001D"}, d2 = {"Lcom/facebook/share/model/ShareVideo;", "Lcom/facebook/share/model/ShareMedia;", "Lcom/facebook/share/model/ShareVideo$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareVideo$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "localUrl", "Landroid/net/Uri;", "getLocalUrl", "()Landroid/net/Uri;", "Lcom/facebook/share/model/ShareMedia$Type;", "mediaType", "Lcom/facebook/share/model/ShareMedia$Type;", "getMediaType", "()Lcom/facebook/share/model/ShareMedia$Type;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareVideo extends ShareMedia {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u0002H\u0016J\u0015\u0010\u000B\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\rH\u0000¢\u0006\u0002\b\u000EJ\u0012\u0010\u000B\u001A\u00020\u00002\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0010\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareVideo$Builder;", "Lcom/facebook/share/model/ShareMedia$Builder;", "Lcom/facebook/share/model/ShareVideo;", "()V", "localUrl", "Landroid/net/Uri;", "getLocalUrl$facebook_common_release", "()Landroid/net/Uri;", "setLocalUrl$facebook_common_release", "(Landroid/net/Uri;)V", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_common_release", "model", "setLocalUrl", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder {
        @Nullable
        private Uri localUrl;

        @NotNull
        public ShareVideo build() {
            return new ShareVideo(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final Uri getLocalUrl$facebook_common_release() {
            return this.localUrl;
        }

        @Override  // com.facebook.share.model.ShareMedia$Builder
        public com.facebook.share.model.ShareMedia.Builder readFrom(ShareMedia shareMedia0) {
            return this.readFrom(((ShareVideo)shareMedia0));
        }

        @Override  // com.facebook.share.model.ShareMedia$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareVideo)shareModel0));
        }

        @NotNull
        public Builder readFrom(@Nullable ShareVideo shareVideo0) {
            return shareVideo0 == null ? this : this.setLocalUrl(shareVideo0.getLocalUrl());
        }

        @NotNull
        public final Builder readFrom$facebook_common_release(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((ShareVideo)parcel0.readParcelable(ShareVideo.class.getClassLoader())));
        }

        @NotNull
        public final Builder setLocalUrl(@Nullable Uri uri0) {
            this.localUrl = uri0;
            return this;
        }

        public final void setLocalUrl$facebook_common_release(@Nullable Uri uri0) {
            this.localUrl = uri0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareVideo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareVideo;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Uri localUrl;
    @NotNull
    private final Type mediaType;

    static {
        ShareVideo.Companion = new Companion(null);
        ShareVideo.CREATOR = new ShareVideo.Companion.CREATOR.1();
    }

    public ShareVideo(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.mediaType = Type.VIDEO;
        this.localUrl = (Uri)parcel0.readParcelable(Uri.class.getClassLoader());
    }

    private ShareVideo(Builder shareVideo$Builder0) {
        super(shareVideo$Builder0);
        this.mediaType = Type.VIDEO;
        this.localUrl = shareVideo$Builder0.getLocalUrl$facebook_common_release();
    }

    public ShareVideo(Builder shareVideo$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareVideo$Builder0);
    }

    @Override  // com.facebook.share.model.ShareMedia
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Uri getLocalUrl() {
        return this.localUrl;
    }

    @Override  // com.facebook.share.model.ShareMedia
    @NotNull
    public Type getMediaType() {
        return this.mediaType;
    }

    @Override  // com.facebook.share.model.ShareMedia
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeParcelable(this.localUrl, 0);
    }
}

