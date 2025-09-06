package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+*B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0017\u0010\u001C\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001FR\u0019\u0010!\u001A\u0004\u0018\u00010 8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$R\u001A\u0010&\u001A\u00020%8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/facebook/share/model/SharePhoto;", "Lcom/facebook/share/model/ShareMedia;", "Lcom/facebook/share/model/SharePhoto$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/SharePhoto$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "Landroid/net/Uri;", "imageUrl", "Landroid/net/Uri;", "getImageUrl", "()Landroid/net/Uri;", "", "userGenerated", "Z", "getUserGenerated", "()Z", "", "caption", "Ljava/lang/String;", "getCaption", "()Ljava/lang/String;", "Lcom/facebook/share/model/ShareMedia$Type;", "mediaType", "Lcom/facebook/share/model/ShareMedia$Type;", "getMediaType", "()Lcom/facebook/share/model/ShareMedia$Type;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SharePhoto extends ShareMedia {
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001F2\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001FB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001A\u00020\u0002H\u0016J\u0015\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0012\u0010\u0016\u001A\u00020\u00002\b\u0010\u001A\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001B\u001A\u00020\u00002\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u001C\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\tJ\u0010\u0010\u001D\u001A\u00020\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\rJ\u000E\u0010\u001E\u001A\u00020\u00002\u0006\u0010\u0012\u001A\u00020\u0011R\"\u0010\u0006\u001A\u0004\u0018\u00010\u00052\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\"\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\u0004\u001A\u0004\u0018\u00010\t@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\"\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0004\u001A\u0004\u0018\u00010\r@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u001E\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u0011@BX\u0080\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/facebook/share/model/SharePhoto$Builder;", "Lcom/facebook/share/model/ShareMedia$Builder;", "Lcom/facebook/share/model/SharePhoto;", "()V", "<set-?>", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap$facebook_common_release", "()Landroid/graphics/Bitmap;", "", "caption", "getCaption$facebook_common_release", "()Ljava/lang/String;", "Landroid/net/Uri;", "imageUrl", "getImageUrl$facebook_common_release", "()Landroid/net/Uri;", "", "userGenerated", "getUserGenerated$facebook_common_release", "()Z", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_common_release", "model", "setBitmap", "setCaption", "setImageUrl", "setUserGenerated", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareMedia.Builder {
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0004\b\f\u0010\rJ\u001D\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u000F\u001A\u00020\u0004H\u0000¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/model/SharePhoto$Builder$Companion;", "", "<init>", "()V", "Landroid/os/Parcel;", "out", "", "parcelFlags", "", "Lcom/facebook/share/model/SharePhoto;", "photos", "Lie/H;", "writePhotoListTo$facebook_common_release", "(Landroid/os/Parcel;ILjava/util/List;)V", "writePhotoListTo", "parcel", "readPhotoListFrom$facebook_common_release", "(Landroid/os/Parcel;)Ljava/util/List;", "readPhotoListFrom", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final List readPhotoListFrom$facebook_common_release(@NotNull Parcel parcel0) {
                q.g(parcel0, "parcel");
                Iterable iterable0 = com.facebook.share.model.ShareMedia.Builder.Companion.readListFrom$facebook_common_release(parcel0);
                List list0 = new ArrayList();
                for(Object object0: iterable0) {
                    if(object0 instanceof SharePhoto) {
                        list0.add(object0);
                    }
                }
                return list0;
            }

            public final void writePhotoListTo$facebook_common_release(@NotNull Parcel parcel0, int v, @NotNull List list0) {
                q.g(parcel0, "out");
                q.g(list0, "photos");
                parcel0.writeParcelableArray(((SharePhoto[])list0.toArray(new SharePhoto[0])), v);
            }
        }

        @NotNull
        public static final Companion Companion;
        @Nullable
        private Bitmap bitmap;
        @Nullable
        private String caption;
        @Nullable
        private Uri imageUrl;
        private boolean userGenerated;

        static {
            Builder.Companion = new Companion(null);
        }

        @NotNull
        public SharePhoto build() {
            return new SharePhoto(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final Bitmap getBitmap$facebook_common_release() {
            return this.bitmap;
        }

        @Nullable
        public final String getCaption$facebook_common_release() {
            return this.caption;
        }

        @Nullable
        public final Uri getImageUrl$facebook_common_release() {
            return this.imageUrl;
        }

        public final boolean getUserGenerated$facebook_common_release() {
            return this.userGenerated;
        }

        @Override  // com.facebook.share.model.ShareMedia$Builder
        public com.facebook.share.model.ShareMedia.Builder readFrom(ShareMedia shareMedia0) {
            return this.readFrom(((SharePhoto)shareMedia0));
        }

        @Override  // com.facebook.share.model.ShareMedia$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((SharePhoto)shareModel0));
        }

        @NotNull
        public Builder readFrom(@Nullable SharePhoto sharePhoto0) {
            return sharePhoto0 == null ? this : ((Builder)super.readFrom(sharePhoto0)).setBitmap(sharePhoto0.getBitmap()).setImageUrl(sharePhoto0.getImageUrl()).setUserGenerated(sharePhoto0.getUserGenerated()).setCaption(sharePhoto0.getCaption());
        }

        @NotNull
        public final Builder readFrom$facebook_common_release(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((SharePhoto)parcel0.readParcelable(SharePhoto.class.getClassLoader())));
        }

        @NotNull
        public final Builder setBitmap(@Nullable Bitmap bitmap0) {
            this.bitmap = bitmap0;
            return this;
        }

        @NotNull
        public final Builder setCaption(@Nullable String s) {
            this.caption = s;
            return this;
        }

        @NotNull
        public final Builder setImageUrl(@Nullable Uri uri0) {
            this.imageUrl = uri0;
            return this;
        }

        @NotNull
        public final Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/SharePhoto$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/SharePhoto;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class com.facebook.share.model.SharePhoto.Companion {
        private com.facebook.share.model.SharePhoto.Companion() {
        }

        public com.facebook.share.model.SharePhoto.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final com.facebook.share.model.SharePhoto.Companion Companion;
    @Nullable
    private final Bitmap bitmap;
    @Nullable
    private final String caption;
    @Nullable
    private final Uri imageUrl;
    @NotNull
    private final Type mediaType;
    private final boolean userGenerated;

    static {
        SharePhoto.Companion = new com.facebook.share.model.SharePhoto.Companion(null);
        SharePhoto.CREATOR = new SharePhoto.Companion.CREATOR.1();
    }

    public SharePhoto(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.mediaType = Type.PHOTO;
        this.bitmap = (Bitmap)parcel0.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri)parcel0.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel0.readByte() != 0;
        this.caption = parcel0.readString();
    }

    private SharePhoto(Builder sharePhoto$Builder0) {
        super(sharePhoto$Builder0);
        this.mediaType = Type.PHOTO;
        this.bitmap = sharePhoto$Builder0.getBitmap$facebook_common_release();
        this.imageUrl = sharePhoto$Builder0.getImageUrl$facebook_common_release();
        this.userGenerated = sharePhoto$Builder0.getUserGenerated$facebook_common_release();
        this.caption = sharePhoto$Builder0.getCaption$facebook_common_release();
    }

    public SharePhoto(Builder sharePhoto$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(sharePhoto$Builder0);
    }

    @Override  // com.facebook.share.model.ShareMedia
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @Nullable
    public final String getCaption() {
        return this.caption;
    }

    @Nullable
    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    @Override  // com.facebook.share.model.ShareMedia
    @NotNull
    public Type getMediaType() {
        return this.mediaType;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    @Override  // com.facebook.share.model.ShareMedia
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeParcelable(this.bitmap, 0);
        parcel0.writeParcelable(this.imageUrl, 0);
        parcel0.writeByte(((byte)this.userGenerated));
        parcel0.writeString(this.caption);
    }
}

