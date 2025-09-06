package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0013\u0018\u0000 \"2\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#\"B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0018\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001A\u0004\b\u0019\u0010\u0015R\u0019\u0010\u001A\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u0013\u001A\u0004\b\u001B\u0010\u0015R\u0019\u0010\u001C\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u0013\u001A\u0004\b\u001D\u0010\u0015R\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u0013\u001A\u0004\b\u001F\u0010\u0015R\u0019\u0010 \u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b \u0010\u0013\u001A\u0004\b!\u0010\u0015¨\u0006$"}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/internal/ShareFeedContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/internal/ShareFeedContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "toId", "Ljava/lang/String;", "getToId", "()Ljava/lang/String;", "link", "getLink", "linkName", "getLinkName", "linkCaption", "getLinkCaption", "linkDescription", "getLinkDescription", "picture", "getPicture", "mediaSource", "getMediaSource", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareFeedContent extends ShareContent {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b!\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001C\u001A\u00020\u0002H\u0016J\u0012\u0010\u001D\u001A\u00020\u00002\b\u0010\u001E\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001F\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u0010\u0010 \u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u0005J\u0010\u0010!\u001A\u00020\u00002\b\u0010\r\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001A\u00020\u00002\b\u0010\u0010\u001A\u0004\u0018\u00010\u0005J\u0010\u0010#\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0005J\u0010\u0010$\u001A\u00020\u00002\b\u0010\u0016\u001A\u0004\u0018\u00010\u0005J\u0010\u0010%\u001A\u00020\u00002\b\u0010\u0019\u001A\u0004\u0018\u00010\u0005R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001C\u0010\r\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001C\u0010\u0019\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\t¨\u0006&"}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/internal/ShareFeedContent;", "()V", "link", "", "getLink$facebook_common_release", "()Ljava/lang/String;", "setLink$facebook_common_release", "(Ljava/lang/String;)V", "linkCaption", "getLinkCaption$facebook_common_release", "setLinkCaption$facebook_common_release", "linkDescription", "getLinkDescription$facebook_common_release", "setLinkDescription$facebook_common_release", "linkName", "getLinkName$facebook_common_release", "setLinkName$facebook_common_release", "mediaSource", "getMediaSource$facebook_common_release", "setMediaSource$facebook_common_release", "picture", "getPicture$facebook_common_release", "setPicture$facebook_common_release", "toId", "getToId$facebook_common_release", "setToId$facebook_common_release", "build", "readFrom", "content", "setLink", "setLinkCaption", "setLinkDescription", "setLinkName", "setMediaSource", "setPicture", "setToId", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder {
        @Nullable
        private String link;
        @Nullable
        private String linkCaption;
        @Nullable
        private String linkDescription;
        @Nullable
        private String linkName;
        @Nullable
        private String mediaSource;
        @Nullable
        private String picture;
        @Nullable
        private String toId;

        @NotNull
        public ShareFeedContent build() {
            return new ShareFeedContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final String getLink$facebook_common_release() {
            return this.link;
        }

        @Nullable
        public final String getLinkCaption$facebook_common_release() {
            return this.linkCaption;
        }

        @Nullable
        public final String getLinkDescription$facebook_common_release() {
            return this.linkDescription;
        }

        @Nullable
        public final String getLinkName$facebook_common_release() {
            return this.linkName;
        }

        @Nullable
        public final String getMediaSource$facebook_common_release() {
            return this.mediaSource;
        }

        @Nullable
        public final String getPicture$facebook_common_release() {
            return this.picture;
        }

        @Nullable
        public final String getToId$facebook_common_release() {
            return this.toId;
        }

        @NotNull
        public Builder readFrom(@Nullable ShareFeedContent shareFeedContent0) {
            return shareFeedContent0 == null ? this : ((Builder)super.readFrom(shareFeedContent0)).setToId(shareFeedContent0.getToId()).setLink(shareFeedContent0.getLink()).setLinkName(shareFeedContent0.getLinkName()).setLinkCaption(shareFeedContent0.getLinkCaption()).setLinkDescription(shareFeedContent0.getLinkDescription()).setPicture(shareFeedContent0.getPicture()).setMediaSource(shareFeedContent0.getMediaSource());
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public com.facebook.share.model.ShareContent.Builder readFrom(ShareContent shareContent0) {
            return this.readFrom(((ShareFeedContent)shareContent0));
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareFeedContent)shareModel0));
        }

        @NotNull
        public final Builder setLink(@Nullable String s) {
            this.link = s;
            return this;
        }

        public final void setLink$facebook_common_release(@Nullable String s) {
            this.link = s;
        }

        @NotNull
        public final Builder setLinkCaption(@Nullable String s) {
            this.linkCaption = s;
            return this;
        }

        public final void setLinkCaption$facebook_common_release(@Nullable String s) {
            this.linkCaption = s;
        }

        @NotNull
        public final Builder setLinkDescription(@Nullable String s) {
            this.linkDescription = s;
            return this;
        }

        public final void setLinkDescription$facebook_common_release(@Nullable String s) {
            this.linkDescription = s;
        }

        @NotNull
        public final Builder setLinkName(@Nullable String s) {
            this.linkName = s;
            return this;
        }

        public final void setLinkName$facebook_common_release(@Nullable String s) {
            this.linkName = s;
        }

        @NotNull
        public final Builder setMediaSource(@Nullable String s) {
            this.mediaSource = s;
            return this;
        }

        public final void setMediaSource$facebook_common_release(@Nullable String s) {
            this.mediaSource = s;
        }

        @NotNull
        public final Builder setPicture(@Nullable String s) {
            this.picture = s;
            return this;
        }

        public final void setPicture$facebook_common_release(@Nullable String s) {
            this.picture = s;
        }

        @NotNull
        public final Builder setToId(@Nullable String s) {
            this.toId = s;
            return this;
        }

        public final void setToId$facebook_common_release(@Nullable String s) {
            this.toId = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/internal/ShareFeedContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/internal/ShareFeedContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String link;
    @Nullable
    private final String linkCaption;
    @Nullable
    private final String linkDescription;
    @Nullable
    private final String linkName;
    @Nullable
    private final String mediaSource;
    @Nullable
    private final String picture;
    @Nullable
    private final String toId;

    static {
        ShareFeedContent.Companion = new Companion(null);
        ShareFeedContent.CREATOR = new ShareFeedContent.Companion.CREATOR.1();
    }

    public ShareFeedContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.toId = parcel0.readString();
        this.link = parcel0.readString();
        this.linkName = parcel0.readString();
        this.linkCaption = parcel0.readString();
        this.linkDescription = parcel0.readString();
        this.picture = parcel0.readString();
        this.mediaSource = parcel0.readString();
    }

    private ShareFeedContent(Builder shareFeedContent$Builder0) {
        super(shareFeedContent$Builder0);
        this.toId = shareFeedContent$Builder0.getToId$facebook_common_release();
        this.link = shareFeedContent$Builder0.getLink$facebook_common_release();
        this.linkName = shareFeedContent$Builder0.getLinkName$facebook_common_release();
        this.linkCaption = shareFeedContent$Builder0.getLinkCaption$facebook_common_release();
        this.linkDescription = shareFeedContent$Builder0.getLinkDescription$facebook_common_release();
        this.picture = shareFeedContent$Builder0.getPicture$facebook_common_release();
        this.mediaSource = shareFeedContent$Builder0.getMediaSource$facebook_common_release();
    }

    public ShareFeedContent(Builder shareFeedContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareFeedContent$Builder0);
    }

    @Override  // com.facebook.share.model.ShareContent
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getLink() {
        return this.link;
    }

    @Nullable
    public final String getLinkCaption() {
        return this.linkCaption;
    }

    @Nullable
    public final String getLinkDescription() {
        return this.linkDescription;
    }

    @Nullable
    public final String getLinkName() {
        return this.linkName;
    }

    @Nullable
    public final String getMediaSource() {
        return this.mediaSource;
    }

    @Nullable
    public final String getPicture() {
        return this.picture;
    }

    @Nullable
    public final String getToId() {
        return this.toId;
    }

    @Override  // com.facebook.share.model.ShareContent
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.toId);
        parcel0.writeString(this.link);
        parcel0.writeString(this.linkName);
        parcel0.writeString(this.linkCaption);
        parcel0.writeString(this.linkDescription);
        parcel0.writeString(this.picture);
        parcel0.writeString(this.mediaSource);
    }
}

