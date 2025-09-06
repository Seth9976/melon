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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\u0018\u0000 \'2\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002(\'B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001F\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R!\u0010\u0016\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u001A8\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u001F\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8F¢\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"R\u0019\u0010#\u001A\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/facebook/share/model/ShareStoryContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareStoryContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareStoryContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "", "readUnmodifiableStringList", "(Landroid/os/Parcel;)Ljava/util/List;", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/facebook/share/model/ShareMedia;", "backgroundAsset", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAsset", "()Lcom/facebook/share/model/ShareMedia;", "Lcom/facebook/share/model/SharePhoto;", "stickerAsset", "Lcom/facebook/share/model/SharePhoto;", "getStickerAsset", "()Lcom/facebook/share/model/SharePhoto;", "backgroundColorList", "Ljava/util/List;", "getBackgroundColorList", "()Ljava/util/List;", "attributionLink", "Ljava/lang/String;", "getAttributionLink", "()Ljava/lang/String;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareStoryContent extends ShareContent {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001C\u001A\u00020\u0002H\u0016J\u0012\u0010\u001D\u001A\u00020\u00002\b\u0010\u001E\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001F\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u0018\u0010 \u001A\u00020\u00002\u0010\u0010\n\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000BJ\u0016\u0010!\u001A\u00020\u00002\u000E\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011J\u0010\u0010\"\u001A\u00020\u00002\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001A\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\"\u0010\u0010\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006#"}, d2 = {"Lcom/facebook/share/model/ShareStoryContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareStoryContent;", "()V", "attributionLink", "", "getAttributionLink$facebook_common_release", "()Ljava/lang/String;", "setAttributionLink$facebook_common_release", "(Ljava/lang/String;)V", "backgroundAsset", "Lcom/facebook/share/model/ShareMedia;", "getBackgroundAsset$facebook_common_release", "()Lcom/facebook/share/model/ShareMedia;", "setBackgroundAsset$facebook_common_release", "(Lcom/facebook/share/model/ShareMedia;)V", "backgroundColorList", "", "getBackgroundColorList$facebook_common_release", "()Ljava/util/List;", "setBackgroundColorList$facebook_common_release", "(Ljava/util/List;)V", "stickerAsset", "Lcom/facebook/share/model/SharePhoto;", "getStickerAsset$facebook_common_release", "()Lcom/facebook/share/model/SharePhoto;", "setStickerAsset$facebook_common_release", "(Lcom/facebook/share/model/SharePhoto;)V", "build", "readFrom", "model", "setAttributionLink", "setBackgroundAsset", "setBackgroundColorList", "setStickerAsset", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder {
        @Nullable
        private String attributionLink;
        @Nullable
        private ShareMedia backgroundAsset;
        @Nullable
        private List backgroundColorList;
        @Nullable
        private SharePhoto stickerAsset;

        @NotNull
        public ShareStoryContent build() {
            return new ShareStoryContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final String getAttributionLink$facebook_common_release() {
            return this.attributionLink;
        }

        @Nullable
        public final ShareMedia getBackgroundAsset$facebook_common_release() {
            return this.backgroundAsset;
        }

        @Nullable
        public final List getBackgroundColorList$facebook_common_release() {
            return this.backgroundColorList;
        }

        @Nullable
        public final SharePhoto getStickerAsset$facebook_common_release() {
            return this.stickerAsset;
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public com.facebook.share.model.ShareContent.Builder readFrom(ShareContent shareContent0) {
            return this.readFrom(((ShareStoryContent)shareContent0));
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareStoryContent)shareModel0));
        }

        @NotNull
        public Builder readFrom(@Nullable ShareStoryContent shareStoryContent0) {
            return shareStoryContent0 == null ? this : ((Builder)super.readFrom(shareStoryContent0)).setBackgroundAsset(shareStoryContent0.getBackgroundAsset()).setStickerAsset(shareStoryContent0.getStickerAsset()).setBackgroundColorList(shareStoryContent0.getBackgroundColorList()).setAttributionLink(shareStoryContent0.getAttributionLink());
        }

        @NotNull
        public final Builder setAttributionLink(@Nullable String s) {
            this.attributionLink = s;
            return this;
        }

        public final void setAttributionLink$facebook_common_release(@Nullable String s) {
            this.attributionLink = s;
        }

        @NotNull
        public final Builder setBackgroundAsset(@Nullable ShareMedia shareMedia0) {
            this.backgroundAsset = shareMedia0;
            return this;
        }

        public final void setBackgroundAsset$facebook_common_release(@Nullable ShareMedia shareMedia0) {
            this.backgroundAsset = shareMedia0;
        }

        @NotNull
        public final Builder setBackgroundColorList(@Nullable List list0) {
            this.backgroundColorList = list0 == null ? null : p.P0(list0);
            return this;
        }

        public final void setBackgroundColorList$facebook_common_release(@Nullable List list0) {
            this.backgroundColorList = list0;
        }

        @NotNull
        public final Builder setStickerAsset(@Nullable SharePhoto sharePhoto0) {
            this.stickerAsset = sharePhoto0;
            return this;
        }

        public final void setStickerAsset$facebook_common_release(@Nullable SharePhoto sharePhoto0) {
            this.stickerAsset = sharePhoto0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareStoryContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareStoryContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String attributionLink;
    @Nullable
    private final ShareMedia backgroundAsset;
    @Nullable
    private final List backgroundColorList;
    @Nullable
    private final SharePhoto stickerAsset;

    static {
        ShareStoryContent.Companion = new Companion(null);
        ShareStoryContent.CREATOR = new ShareStoryContent.Companion.CREATOR.1();
    }

    public ShareStoryContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.backgroundAsset = (ShareMedia)parcel0.readParcelable(ShareMedia.class.getClassLoader());
        this.stickerAsset = (SharePhoto)parcel0.readParcelable(SharePhoto.class.getClassLoader());
        this.backgroundColorList = this.readUnmodifiableStringList(parcel0);
        this.attributionLink = parcel0.readString();
    }

    private ShareStoryContent(Builder shareStoryContent$Builder0) {
        super(shareStoryContent$Builder0);
        this.backgroundAsset = shareStoryContent$Builder0.getBackgroundAsset$facebook_common_release();
        this.stickerAsset = shareStoryContent$Builder0.getStickerAsset$facebook_common_release();
        this.backgroundColorList = shareStoryContent$Builder0.getBackgroundColorList$facebook_common_release();
        this.attributionLink = shareStoryContent$Builder0.getAttributionLink$facebook_common_release();
    }

    public ShareStoryContent(Builder shareStoryContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareStoryContent$Builder0);
    }

    @Override  // com.facebook.share.model.ShareContent
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAttributionLink() {
        return this.attributionLink;
    }

    @Nullable
    public final ShareMedia getBackgroundAsset() {
        return this.backgroundAsset;
    }

    @Nullable
    public final List getBackgroundColorList() {
        return this.backgroundColorList == null ? null : p.P0(this.backgroundColorList);
    }

    @Nullable
    public final SharePhoto getStickerAsset() {
        return this.stickerAsset;
    }

    private final List readUnmodifiableStringList(Parcel parcel0) {
        ArrayList arrayList0 = new ArrayList();
        parcel0.readStringList(arrayList0);
        return arrayList0.isEmpty() ? null : p.P0(arrayList0);
    }

    @Override  // com.facebook.share.model.ShareContent
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeParcelable(this.backgroundAsset, 0);
        parcel0.writeParcelable(this.stickerAsset, 0);
        parcel0.writeStringList(this.getBackgroundColorList());
        parcel0.writeString(this.attributionLink);
    }
}

