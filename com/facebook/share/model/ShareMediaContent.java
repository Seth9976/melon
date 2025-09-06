package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0018\u0017B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R%\u0010\u0013\u001A\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareMediaContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareMediaContent$Builder;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/facebook/share/model/ShareMedia;", "media", "Ljava/util/List;", "getMedia", "()Ljava/util/List;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareMediaContent extends ShareContent {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001E\u0010\t\u001A\u00020\u00002\u0016\u0010\u0004\u001A\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\nJ\u0018\u0010\u000B\u001A\u00020\u00002\u0010\u0010\f\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006J\b\u0010\r\u001A\u00020\u0002H\u0016J\u0012\u0010\u000E\u001A\u00020\u00002\b\u0010\u000F\u001A\u0004\u0018\u00010\u0002H\u0016J\u001E\u0010\u0010\u001A\u00020\u00002\u0016\u0010\u0004\u001A\u0012\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006\u0018\u00010\nR\"\u0010\u0004\u001A\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareMediaContent;", "()V", "media", "", "Lcom/facebook/share/model/ShareMedia;", "getMedia$facebook_common_release", "()Ljava/util/List;", "addMedia", "", "addMedium", "medium", "build", "readFrom", "content", "setMedia", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder {
        @NotNull
        private final List media;

        public Builder() {
            this.media = new ArrayList();
        }

        @NotNull
        public final Builder addMedia(@Nullable List list0) {
            if(list0 != null) {
                for(Object object0: list0) {
                    this.addMedium(((ShareMedia)object0));
                }
            }
            return this;
        }

        @NotNull
        public final Builder addMedium(@Nullable ShareMedia shareMedia0) {
            SharePhoto sharePhoto0;
            if(shareMedia0 != null) {
                if(shareMedia0 instanceof SharePhoto) {
                    sharePhoto0 = new com.facebook.share.model.SharePhoto.Builder().readFrom(((SharePhoto)shareMedia0)).build();
                }
                else if(shareMedia0 instanceof ShareVideo) {
                    sharePhoto0 = new com.facebook.share.model.ShareVideo.Builder().readFrom(((ShareVideo)shareMedia0)).build();
                }
                else {
                    throw new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
                }
                this.media.add(sharePhoto0);
                return this;
            }
            return this;
        }

        @NotNull
        public ShareMediaContent build() {
            return new ShareMediaContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @NotNull
        public final List getMedia$facebook_common_release() {
            return this.media;
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public com.facebook.share.model.ShareContent.Builder readFrom(ShareContent shareContent0) {
            return this.readFrom(((ShareMediaContent)shareContent0));
        }

        @NotNull
        public Builder readFrom(@Nullable ShareMediaContent shareMediaContent0) {
            return shareMediaContent0 == null ? this : ((Builder)super.readFrom(shareMediaContent0)).addMedia(shareMediaContent0.getMedia());
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareMediaContent)shareModel0));
        }

        @NotNull
        public final Builder setMedia(@Nullable List list0) {
            this.media.clear();
            this.addMedia(list0);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareMediaContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareMediaContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final List media;

    static {
        ShareMediaContent.Companion = new Companion(null);
        ShareMediaContent.CREATOR = new ShareMediaContent.Companion.CREATOR.1();
    }

    public ShareMediaContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        ArrayList arrayList0;
        super(parcel0);
        Parcelable[] arr_parcelable = parcel0.readParcelableArray(ShareMedia.class.getClassLoader());
        if(arr_parcelable == null) {
            arrayList0 = w.a;
        }
        else {
            arrayList0 = new ArrayList();
            for(int v = 0; v < arr_parcelable.length; ++v) {
                ShareMedia shareMedia0 = (ShareMedia)arr_parcelable[v];
                if(shareMedia0 != null) {
                    arrayList0.add(shareMedia0);
                }
            }
        }
        this.media = arrayList0;
    }

    private ShareMediaContent(Builder shareMediaContent$Builder0) {
        super(shareMediaContent$Builder0);
        this.media = p.P0(shareMediaContent$Builder0.getMedia$facebook_common_release());
    }

    public ShareMediaContent(Builder shareMediaContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareMediaContent$Builder0);
    }

    @Override  // com.facebook.share.model.ShareContent
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final List getMedia() {
        return this.media;
    }

    @Override  // com.facebook.share.model.ShareContent
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeParcelableArray(((Parcelable[])this.media.toArray(new ShareMedia[0])), v);
    }
}

