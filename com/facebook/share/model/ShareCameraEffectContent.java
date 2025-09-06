package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001F2\u000E\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 \u001FB\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000ER(\u0010\u0011\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R(\u0010\u0016\u001A\u0004\u0018\u00010\u00152\b\u0010\u0010\u001A\u0004\u0018\u00010\u00158\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R(\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u0010\u001A\u0004\u0018\u00010\u001A8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E¨\u0006!"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareCameraEffectContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareCameraEffectContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "out", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "<set-?>", "effectId", "Ljava/lang/String;", "getEffectId", "()Ljava/lang/String;", "Lcom/facebook/share/model/CameraEffectArguments;", "arguments", "Lcom/facebook/share/model/CameraEffectArguments;", "getArguments", "()Lcom/facebook/share/model/CameraEffectArguments;", "Lcom/facebook/share/model/CameraEffectTextures;", "textures", "Lcom/facebook/share/model/CameraEffectTextures;", "getTextures", "()Lcom/facebook/share/model/CameraEffectTextures;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareCameraEffectContent extends ShareContent {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000B\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001A\u00020\u0002H\u0016J\u0012\u0010\u0017\u001A\u00020\u00002\b\u0010\u0018\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0019\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u001A\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u000BJ\u0010\u0010\u001B\u001A\u00020\u00002\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001C"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent$Builder;", "Lcom/facebook/share/model/ShareContent$Builder;", "Lcom/facebook/share/model/ShareCameraEffectContent;", "()V", "arguments", "Lcom/facebook/share/model/CameraEffectArguments;", "getArguments$facebook_common_release", "()Lcom/facebook/share/model/CameraEffectArguments;", "setArguments$facebook_common_release", "(Lcom/facebook/share/model/CameraEffectArguments;)V", "effectId", "", "getEffectId$facebook_common_release", "()Ljava/lang/String;", "setEffectId$facebook_common_release", "(Ljava/lang/String;)V", "textures", "Lcom/facebook/share/model/CameraEffectTextures;", "getTextures$facebook_common_release", "()Lcom/facebook/share/model/CameraEffectTextures;", "setTextures$facebook_common_release", "(Lcom/facebook/share/model/CameraEffectTextures;)V", "build", "readFrom", "model", "setArguments", "setEffectId", "setTextures", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder extends com.facebook.share.model.ShareContent.Builder {
        @Nullable
        private CameraEffectArguments arguments;
        @Nullable
        private String effectId;
        @Nullable
        private CameraEffectTextures textures;

        @NotNull
        public ShareCameraEffectContent build() {
            return new ShareCameraEffectContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final CameraEffectArguments getArguments$facebook_common_release() {
            return this.arguments;
        }

        @Nullable
        public final String getEffectId$facebook_common_release() {
            return this.effectId;
        }

        @Nullable
        public final CameraEffectTextures getTextures$facebook_common_release() {
            return this.textures;
        }

        @NotNull
        public Builder readFrom(@Nullable ShareCameraEffectContent shareCameraEffectContent0) {
            return shareCameraEffectContent0 == null ? this : ((Builder)super.readFrom(shareCameraEffectContent0)).setEffectId(shareCameraEffectContent0.getEffectId()).setArguments(shareCameraEffectContent0.getArguments()).setTextures(shareCameraEffectContent0.getTextures());
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public com.facebook.share.model.ShareContent.Builder readFrom(ShareContent shareContent0) {
            return this.readFrom(((ShareCameraEffectContent)shareContent0));
        }

        @Override  // com.facebook.share.model.ShareContent$Builder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareCameraEffectContent)shareModel0));
        }

        @NotNull
        public final Builder setArguments(@Nullable CameraEffectArguments cameraEffectArguments0) {
            this.arguments = cameraEffectArguments0;
            return this;
        }

        public final void setArguments$facebook_common_release(@Nullable CameraEffectArguments cameraEffectArguments0) {
            this.arguments = cameraEffectArguments0;
        }

        @NotNull
        public final Builder setEffectId(@Nullable String s) {
            this.effectId = s;
            return this;
        }

        public final void setEffectId$facebook_common_release(@Nullable String s) {
            this.effectId = s;
        }

        @NotNull
        public final Builder setTextures(@Nullable CameraEffectTextures cameraEffectTextures0) {
            this.textures = cameraEffectTextures0;
            return this;
        }

        public final void setTextures$facebook_common_release(@Nullable CameraEffectTextures cameraEffectTextures0) {
            this.textures = cameraEffectTextures0;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareCameraEffectContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private CameraEffectArguments arguments;
    @Nullable
    private String effectId;
    @Nullable
    private CameraEffectTextures textures;

    static {
        ShareCameraEffectContent.Companion = new Companion(null);
        ShareCameraEffectContent.CREATOR = new ShareCameraEffectContent.Companion.CREATOR.1();
    }

    public ShareCameraEffectContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super(parcel0);
        this.effectId = parcel0.readString();
        this.arguments = new com.facebook.share.model.CameraEffectArguments.Builder().readFrom(parcel0).build();
        this.textures = new com.facebook.share.model.CameraEffectTextures.Builder().readFrom(parcel0).build();
    }

    private ShareCameraEffectContent(Builder shareCameraEffectContent$Builder0) {
        super(shareCameraEffectContent$Builder0);
        this.effectId = shareCameraEffectContent$Builder0.getEffectId$facebook_common_release();
        this.arguments = shareCameraEffectContent$Builder0.getArguments$facebook_common_release();
        this.textures = shareCameraEffectContent$Builder0.getTextures$facebook_common_release();
    }

    public ShareCameraEffectContent(Builder shareCameraEffectContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareCameraEffectContent$Builder0);
    }

    @Nullable
    public final CameraEffectArguments getArguments() {
        return this.arguments;
    }

    @Nullable
    public final String getEffectId() {
        return this.effectId;
    }

    @Nullable
    public final CameraEffectTextures getTextures() {
        return this.textures;
    }

    @Override  // com.facebook.share.model.ShareContent
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        super.writeToParcel(parcel0, v);
        parcel0.writeString(this.effectId);
        parcel0.writeParcelable(this.arguments, 0);
        parcel0.writeParcelable(this.textures, 0);
    }
}

