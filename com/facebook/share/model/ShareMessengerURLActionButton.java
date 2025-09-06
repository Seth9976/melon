package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import ie.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0003#\"$B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001A\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001A\u00020\t8\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0019\u0010\u000BR\u0017\u0010\u001B\u001A\u00020\t8\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001A\u001A\u0004\b\u001C\u0010\u000BR\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u001D8\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/facebook/share/model/ShareMessengerURLActionButton;", "Lcom/facebook/share/model/ShareMessengerActionButton;", "Lcom/facebook/share/model/ShareMessengerURLActionButton$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareMessengerURLActionButton$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "getIsMessengerExtensionURL", "()Z", "dest", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/net/Uri;", "url", "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "fallbackUrl", "getFallbackUrl", "isMessengerExtensionURL", "Z", "shouldHideWebviewShareButton", "getShouldHideWebviewShareButton", "Lcom/facebook/share/model/ShareMessengerURLActionButton$WebviewHeightRatio;", "webviewHeightRatio", "Lcom/facebook/share/model/ShareMessengerURLActionButton$WebviewHeightRatio;", "getWebviewHeightRatio", "()Lcom/facebook/share/model/ShareMessengerURLActionButton$WebviewHeightRatio;", "Companion", "Builder", "WebviewHeightRatio", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001C\u001A\u00020\u0002H\u0016J\u0012\u0010\u001D\u001A\u00020\u00002\b\u0010\u001E\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u001F\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u000E\u0010 \u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010!\u001A\u00020\u00002\u0006\u0010\u0010\u001A\u00020\u000BJ\u0010\u0010\"\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0005J\u0010\u0010#\u001A\u00020\u00002\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001C\u0010\u0016\u001A\u0004\u0018\u00010\u0017X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006$"}, d2 = {"Lcom/facebook/share/model/ShareMessengerURLActionButton$Builder;", "Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "Lcom/facebook/share/model/ShareMessengerURLActionButton;", "()V", "fallbackUrl", "Landroid/net/Uri;", "getFallbackUrl$facebook_common_release", "()Landroid/net/Uri;", "setFallbackUrl$facebook_common_release", "(Landroid/net/Uri;)V", "isMessengerExtensionURL", "", "isMessengerExtensionURL$facebook_common_release", "()Z", "setMessengerExtensionURL$facebook_common_release", "(Z)V", "shouldHideWebviewShareButton", "getShouldHideWebviewShareButton$facebook_common_release", "setShouldHideWebviewShareButton$facebook_common_release", "url", "getUrl$facebook_common_release", "setUrl$facebook_common_release", "webviewHeightRatio", "Lcom/facebook/share/model/ShareMessengerURLActionButton$WebviewHeightRatio;", "getWebviewHeightRatio$facebook_common_release", "()Lcom/facebook/share/model/ShareMessengerURLActionButton$WebviewHeightRatio;", "setWebviewHeightRatio$facebook_common_release", "(Lcom/facebook/share/model/ShareMessengerURLActionButton$WebviewHeightRatio;)V", "build", "readFrom", "model", "setFallbackUrl", "setIsMessengerExtensionURL", "setShouldHideWebviewShareButton", "setUrl", "setWebviewHeightRatio", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareMessengerActionButton.Builder {
        @Nullable
        private Uri fallbackUrl;
        private boolean isMessengerExtensionURL;
        private boolean shouldHideWebviewShareButton;
        @Nullable
        private Uri url;
        @Nullable
        private WebviewHeightRatio webviewHeightRatio;

        @NotNull
        public ShareMessengerURLActionButton build() {
            return new ShareMessengerURLActionButton(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final Uri getFallbackUrl$facebook_common_release() {
            return this.fallbackUrl;
        }

        public final boolean getShouldHideWebviewShareButton$facebook_common_release() {
            return this.shouldHideWebviewShareButton;
        }

        @Nullable
        public final Uri getUrl$facebook_common_release() {
            return this.url;
        }

        @Nullable
        public final WebviewHeightRatio getWebviewHeightRatio$facebook_common_release() {
            return this.webviewHeightRatio;
        }

        public final boolean isMessengerExtensionURL$facebook_common_release() {
            return this.isMessengerExtensionURL;
        }

        @Override  // com.facebook.share.model.ShareMessengerActionButton$Builder
        public com.facebook.share.model.ShareMessengerActionButton.Builder readFrom(ShareMessengerActionButton shareMessengerActionButton0) {
            return this.readFrom(((ShareMessengerURLActionButton)shareMessengerActionButton0));
        }

        @NotNull
        public Builder readFrom(@Nullable ShareMessengerURLActionButton shareMessengerURLActionButton0) {
            return shareMessengerURLActionButton0 == null ? this : this.setUrl(shareMessengerURLActionButton0.getUrl()).setIsMessengerExtensionURL(shareMessengerURLActionButton0.isMessengerExtensionURL()).setFallbackUrl(shareMessengerURLActionButton0.getFallbackUrl()).setWebviewHeightRatio(shareMessengerURLActionButton0.getWebviewHeightRatio()).setShouldHideWebviewShareButton(shareMessengerURLActionButton0.getShouldHideWebviewShareButton());
        }

        @Override  // com.facebook.share.model.ShareMessengerActionButton$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareMessengerURLActionButton)shareModel0));
        }

        @NotNull
        public final Builder setFallbackUrl(@Nullable Uri uri0) {
            this.fallbackUrl = uri0;
            return this;
        }

        public final void setFallbackUrl$facebook_common_release(@Nullable Uri uri0) {
            this.fallbackUrl = uri0;
        }

        @NotNull
        public final Builder setIsMessengerExtensionURL(boolean z) {
            this.isMessengerExtensionURL = z;
            return this;
        }

        public final void setMessengerExtensionURL$facebook_common_release(boolean z) {
            this.isMessengerExtensionURL = z;
        }

        @NotNull
        public final Builder setShouldHideWebviewShareButton(boolean z) {
            this.shouldHideWebviewShareButton = z;
            return this;
        }

        public final void setShouldHideWebviewShareButton$facebook_common_release(boolean z) {
            this.shouldHideWebviewShareButton = z;
        }

        @NotNull
        public final Builder setUrl(@Nullable Uri uri0) {
            this.url = uri0;
            return this;
        }

        public final void setUrl$facebook_common_release(@Nullable Uri uri0) {
            this.url = uri0;
        }

        @NotNull
        public final Builder setWebviewHeightRatio(@Nullable WebviewHeightRatio shareMessengerURLActionButton$WebviewHeightRatio0) {
            this.webviewHeightRatio = shareMessengerURLActionButton$WebviewHeightRatio0;
            return this;
        }

        public final void setWebviewHeightRatio$facebook_common_release(@Nullable WebviewHeightRatio shareMessengerURLActionButton$WebviewHeightRatio0) {
            this.webviewHeightRatio = shareMessengerURLActionButton$WebviewHeightRatio0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareMessengerURLActionButton$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareMessengerURLActionButton;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareMessengerURLActionButton$WebviewHeightRatio;", "", "(Ljava/lang/String;I)V", "WebviewHeightRatioFull", "WebviewHeightRatioTall", "WebviewHeightRatioCompact", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact;

        private static final WebviewHeightRatio[] $values() [...] // Inlined contents
    }

    @NotNull
    public static final Parcelable.Creator CREATOR;
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final Uri fallbackUrl;
    private final boolean isMessengerExtensionURL;
    private final boolean shouldHideWebviewShareButton;
    @Nullable
    private final Uri url;
    @Nullable
    private final WebviewHeightRatio webviewHeightRatio;

    static {
        ShareMessengerURLActionButton.Companion = new Companion(null);
        ShareMessengerURLActionButton.CREATOR = new ShareMessengerURLActionButton.Companion.CREATOR.1();
    }

    public ShareMessengerURLActionButton(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.url = (Uri)parcel0.readParcelable(Uri.class.getClassLoader());
        boolean z = false;
        this.isMessengerExtensionURL = parcel0.readByte() != 0;
        this.fallbackUrl = (Uri)parcel0.readParcelable(Uri.class.getClassLoader());
        this.webviewHeightRatio = (WebviewHeightRatio)parcel0.readSerializable();
        if(parcel0.readByte() != 0) {
            z = true;
        }
        this.shouldHideWebviewShareButton = z;
    }

    private ShareMessengerURLActionButton(Builder shareMessengerURLActionButton$Builder0) {
        super(shareMessengerURLActionButton$Builder0);
        this.url = shareMessengerURLActionButton$Builder0.getUrl$facebook_common_release();
        this.isMessengerExtensionURL = shareMessengerURLActionButton$Builder0.isMessengerExtensionURL$facebook_common_release();
        this.fallbackUrl = shareMessengerURLActionButton$Builder0.getFallbackUrl$facebook_common_release();
        this.webviewHeightRatio = shareMessengerURLActionButton$Builder0.getWebviewHeightRatio$facebook_common_release();
        this.shouldHideWebviewShareButton = shareMessengerURLActionButton$Builder0.getShouldHideWebviewShareButton$facebook_common_release();
    }

    public ShareMessengerURLActionButton(Builder shareMessengerURLActionButton$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareMessengerURLActionButton$Builder0);
    }

    @Nullable
    public final Uri getFallbackUrl() {
        return this.fallbackUrl;
    }

    @d
    public final boolean getIsMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    public final boolean getShouldHideWebviewShareButton() {
        return this.shouldHideWebviewShareButton;
    }

    @Nullable
    public final Uri getUrl() {
        return this.url;
    }

    @Nullable
    public final WebviewHeightRatio getWebviewHeightRatio() {
        return this.webviewHeightRatio;
    }

    public final boolean isMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    @Override  // com.facebook.share.model.ShareMessengerActionButton
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        super.writeToParcel(parcel0, v);
        parcel0.writeParcelable(this.url, 0);
        parcel0.writeByte(((byte)this.isMessengerExtensionURL));
        parcel0.writeParcelable(this.fallbackUrl, 0);
        parcel0.writeSerializable(this.webviewHeightRatio);
        parcel0.writeByte(((byte)this.isMessengerExtensionURL));
    }
}

