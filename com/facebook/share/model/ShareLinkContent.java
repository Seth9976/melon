package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\u0018\u0000 \u00162\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0016B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/facebook/share/model/ShareLinkContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareLinkContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareLinkContent$Builder;)V", "Landroid/os/Parcel;", "source", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "quote", "Ljava/lang/String;", "getQuote", "()Ljava/lang/String;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareLinkContent extends ShareContent {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\t\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u0002H\u0016J\u0012\u0010\u000B\u001A\u00020\u00002\b\u0010\f\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\r\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000E"}, d2 = {"Lcom/facebook/share/model/ShareLinkContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareLinkContent;", "()V", "quote", "", "getQuote$facebook_common_release", "()Ljava/lang/String;", "setQuote$facebook_common_release", "(Ljava/lang/String;)V", "build", "readFrom", "model", "setQuote", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder {
        @Nullable
        private String quote;

        @NotNull
        public ShareLinkContent build() {
            return new ShareLinkContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final String getQuote$facebook_common_release() {
            return this.quote;
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public com.facebook.share.model.ShareContent.Builder readFrom(ShareContent shareContent0) {
            return this.readFrom(((ShareLinkContent)shareContent0));
        }

        @NotNull
        public Builder readFrom(@Nullable ShareLinkContent shareLinkContent0) {
            return shareLinkContent0 == null ? this : ((Builder)super.readFrom(shareLinkContent0)).setQuote(shareLinkContent0.getQuote());
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareLinkContent)shareModel0));
        }

        @NotNull
        public final Builder setQuote(@Nullable String s) {
            this.quote = s;
            return this;
        }

        public final void setQuote$facebook_common_release(@Nullable String s) {
            this.quote = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareLinkContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareLinkContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String quote;

    static {
        ShareLinkContent.Companion = new Companion(null);
        ShareLinkContent.CREATOR = new ShareLinkContent.Companion.CREATOR.1();
    }

    public ShareLinkContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "source");
        super(parcel0);
        this.quote = parcel0.readString();
    }

    private ShareLinkContent(Builder shareLinkContent$Builder0) {
        super(shareLinkContent$Builder0);
        this.quote = shareLinkContent$Builder0.getQuote$facebook_common_release();
    }

    public ShareLinkContent(Builder shareLinkContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareLinkContent$Builder0);
    }

    @Override  // com.facebook.share.model.ShareContent
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getQuote() {
        return this.quote;
    }

    @Override  // com.facebook.share.model.ShareContent
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.quote);
    }
}

