package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002$#B\u0011\b\u0012\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0010\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001A\u0004\b\u0018\u0010\u0016R\u0019\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0019\u0010\u001F\u001A\u0004\u0018\u00010\u001E8\u0006¢\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/facebook/share/model/ShareVideoContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareModel;", "builder", "<init>", "(Lcom/facebook/share/model/ShareVideoContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "contentDescription", "Ljava/lang/String;", "getContentDescription", "()Ljava/lang/String;", "contentTitle", "getContentTitle", "Lcom/facebook/share/model/SharePhoto;", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto", "()Lcom/facebook/share/model/SharePhoto;", "Lcom/facebook/share/model/ShareVideo;", "video", "Lcom/facebook/share/model/ShareVideo;", "getVideo", "()Lcom/facebook/share/model/ShareVideo;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareVideoContent extends ShareContent implements ShareModel {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001A\u00020\u0002H\u0016J\u0012\u0010\u001A\u001A\u00020\u00002\b\u0010\u001B\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001C\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u001D\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u001E\u001A\u00020\u00002\b\u0010\r\u001A\u0004\u0018\u00010\u000EJ\u0010\u0010\u001F\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0014R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001C\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0014X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lcom/facebook/share/model/ShareVideoContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareVideoContent;", "()V", "contentDescription", "", "getContentDescription$facebook_common_release", "()Ljava/lang/String;", "setContentDescription$facebook_common_release", "(Ljava/lang/String;)V", "contentTitle", "getContentTitle$facebook_common_release", "setContentTitle$facebook_common_release", "previewPhoto", "Lcom/facebook/share/model/SharePhoto;", "getPreviewPhoto$facebook_common_release", "()Lcom/facebook/share/model/SharePhoto;", "setPreviewPhoto$facebook_common_release", "(Lcom/facebook/share/model/SharePhoto;)V", "video", "Lcom/facebook/share/model/ShareVideo;", "getVideo$facebook_common_release", "()Lcom/facebook/share/model/ShareVideo;", "setVideo$facebook_common_release", "(Lcom/facebook/share/model/ShareVideo;)V", "build", "readFrom", "content", "setContentDescription", "setContentTitle", "setPreviewPhoto", "setVideo", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder {
        @Nullable
        private String contentDescription;
        @Nullable
        private String contentTitle;
        @Nullable
        private SharePhoto previewPhoto;
        @Nullable
        private ShareVideo video;

        @NotNull
        public ShareVideoContent build() {
            return new ShareVideoContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final String getContentDescription$facebook_common_release() {
            return this.contentDescription;
        }

        @Nullable
        public final String getContentTitle$facebook_common_release() {
            return this.contentTitle;
        }

        @Nullable
        public final SharePhoto getPreviewPhoto$facebook_common_release() {
            return this.previewPhoto;
        }

        @Nullable
        public final ShareVideo getVideo$facebook_common_release() {
            return this.video;
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public com.facebook.share.model.ShareContent.Builder readFrom(ShareContent shareContent0) {
            return this.readFrom(((ShareVideoContent)shareContent0));
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareVideoContent)shareModel0));
        }

        @NotNull
        public Builder readFrom(@Nullable ShareVideoContent shareVideoContent0) {
            return shareVideoContent0 == null ? this : ((Builder)super.readFrom(shareVideoContent0)).setContentDescription(shareVideoContent0.getContentDescription()).setContentTitle(shareVideoContent0.getContentTitle()).setPreviewPhoto(shareVideoContent0.getPreviewPhoto()).setVideo(shareVideoContent0.getVideo());
        }

        @NotNull
        public final Builder setContentDescription(@Nullable String s) {
            this.contentDescription = s;
            return this;
        }

        public final void setContentDescription$facebook_common_release(@Nullable String s) {
            this.contentDescription = s;
        }

        @NotNull
        public final Builder setContentTitle(@Nullable String s) {
            this.contentTitle = s;
            return this;
        }

        public final void setContentTitle$facebook_common_release(@Nullable String s) {
            this.contentTitle = s;
        }

        @NotNull
        public final Builder setPreviewPhoto(@Nullable SharePhoto sharePhoto0) {
            this.previewPhoto = sharePhoto0 == null ? null : new com.facebook.share.model.SharePhoto.Builder().readFrom(sharePhoto0).build();
            return this;
        }

        public final void setPreviewPhoto$facebook_common_release(@Nullable SharePhoto sharePhoto0) {
            this.previewPhoto = sharePhoto0;
        }

        @NotNull
        public final Builder setVideo(@Nullable ShareVideo shareVideo0) {
            if(shareVideo0 == null) {
                return this;
            }
            this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom(shareVideo0).build();
            return this;
        }

        public final void setVideo$facebook_common_release(@Nullable ShareVideo shareVideo0) {
            this.video = shareVideo0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareVideoContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareVideoContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String contentDescription;
    @Nullable
    private final String contentTitle;
    @Nullable
    private final SharePhoto previewPhoto;
    @Nullable
    private final ShareVideo video;

    static {
        ShareVideoContent.Companion = new Companion(null);
        ShareVideoContent.CREATOR = new ShareVideoContent.Companion.CREATOR.1();
    }

    public ShareVideoContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.contentDescription = parcel0.readString();
        this.contentTitle = parcel0.readString();
        com.facebook.share.model.SharePhoto.Builder sharePhoto$Builder0 = new com.facebook.share.model.SharePhoto.Builder().readFrom$facebook_common_release(parcel0);
        this.previewPhoto = sharePhoto$Builder0.getImageUrl$facebook_common_release() != null || sharePhoto$Builder0.getBitmap$facebook_common_release() != null ? sharePhoto$Builder0.build() : null;
        this.video = new com.facebook.share.model.ShareVideo.Builder().readFrom$facebook_common_release(parcel0).build();
    }

    private ShareVideoContent(Builder shareVideoContent$Builder0) {
        super(shareVideoContent$Builder0);
        this.contentDescription = shareVideoContent$Builder0.getContentDescription$facebook_common_release();
        this.contentTitle = shareVideoContent$Builder0.getContentTitle$facebook_common_release();
        this.previewPhoto = shareVideoContent$Builder0.getPreviewPhoto$facebook_common_release();
        this.video = shareVideoContent$Builder0.getVideo$facebook_common_release();
    }

    public ShareVideoContent(Builder shareVideoContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareVideoContent$Builder0);
    }

    @Override  // com.facebook.share.model.ShareContent, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @Nullable
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @Nullable
    public final SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    @Nullable
    public final ShareVideo getVideo() {
        return this.video;
    }

    @Override  // com.facebook.share.model.ShareContent, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.contentDescription);
        parcel0.writeString(this.contentTitle);
        parcel0.writeParcelable(this.previewPhoto, 0);
        parcel0.writeParcelable(this.video, 0);
    }
}

