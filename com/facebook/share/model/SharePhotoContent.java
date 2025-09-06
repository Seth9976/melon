package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0017B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u001D\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/model/SharePhotoContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/SharePhotoContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/SharePhotoContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/facebook/share/model/SharePhoto;", "photos", "Ljava/util/List;", "getPhotos", "()Ljava/util/List;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SharePhotoContent extends ShareContent {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u0006J\u0016\u0010\u000B\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fJ\b\u0010\r\u001A\u00020\u0002H\u0016J\u0012\u0010\u000E\u001A\u00020\u00002\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u0010\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fR\u001A\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/SharePhotoContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/SharePhotoContent;", "()V", "photos", "", "Lcom/facebook/share/model/SharePhoto;", "getPhotos$facebook_common_release", "()Ljava/util/List;", "addPhoto", "photo", "addPhotos", "", "build", "readFrom", "content", "setPhotos", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder {
        @NotNull
        private final List photos;

        public Builder() {
            this.photos = new ArrayList();
        }

        @NotNull
        public final Builder addPhoto(@Nullable SharePhoto sharePhoto0) {
            if(sharePhoto0 != null) {
                SharePhoto sharePhoto1 = new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto0).build();
                this.photos.add(sharePhoto1);
            }
            return this;
        }

        @NotNull
        public final Builder addPhotos(@Nullable List list0) {
            if(list0 != null) {
                for(Object object0: list0) {
                    this.addPhoto(((SharePhoto)object0));
                }
            }
            return this;
        }

        @NotNull
        public SharePhotoContent build() {
            return new SharePhotoContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @NotNull
        public final List getPhotos$facebook_common_release() {
            return this.photos;
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public com.facebook.share.model.ShareContent.Builder readFrom(ShareContent shareContent0) {
            return this.readFrom(((SharePhotoContent)shareContent0));
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((SharePhotoContent)shareModel0));
        }

        @NotNull
        public Builder readFrom(@Nullable SharePhotoContent sharePhotoContent0) {
            return sharePhotoContent0 == null ? this : ((Builder)super.readFrom(sharePhotoContent0)).addPhotos(sharePhotoContent0.getPhotos());
        }

        @NotNull
        public final Builder setPhotos(@Nullable List list0) {
            this.photos.clear();
            this.addPhotos(list0);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/SharePhotoContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/SharePhotoContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    @NotNull
    private final List photos;

    static {
        SharePhotoContent.Companion = new Companion(null);
        SharePhotoContent.CREATOR = new SharePhotoContent.Companion.CREATOR.1();
    }

    public SharePhotoContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.photos = p.P0(com.facebook.share.model.SharePhoto.Builder.Companion.readPhotoListFrom$facebook_common_release(parcel0));
    }

    private SharePhotoContent(Builder sharePhotoContent$Builder0) {
        super(sharePhotoContent$Builder0);
        this.photos = p.P0(sharePhotoContent$Builder0.getPhotos$facebook_common_release());
    }

    public SharePhotoContent(Builder sharePhotoContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(sharePhotoContent$Builder0);
    }

    @Override  // com.facebook.share.model.ShareContent
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List getPhotos() {
        return this.photos;
    }

    @Override  // com.facebook.share.model.ShareContent
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        com.facebook.share.model.SharePhoto.Builder.Companion.writePhotoListTo$facebook_common_release(parcel0, v, this.photos);
    }
}

