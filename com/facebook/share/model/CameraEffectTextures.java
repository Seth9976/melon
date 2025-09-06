package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import java.util.Set;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0019\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u000F\u0010\u0010J\u001C\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0086\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u001B\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0016\u0010 \u001A\u0004\u0018\u00010\u001F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/facebook/share/model/CameraEffectTextures;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/share/model/CameraEffectTextures$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/CameraEffectTextures$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "key", "Landroid/graphics/Bitmap;", "getTextureBitmap", "(Ljava/lang/String;)Landroid/graphics/Bitmap;", "Landroid/net/Uri;", "getTextureUri", "(Ljava/lang/String;)Landroid/net/Uri;", "", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "", "keySet", "()Ljava/util/Set;", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Bundle;", "textures", "Landroid/os/Bundle;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CameraEffectTextures implements ShareModel {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\u0002H\u0016J\u001A\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000E\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010J\u0018\u0010\u000E\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012J\u000E\u0010\u0013\u001A\u00020\u00002\u0006\u0010\u0014\u001A\u00020\u0015J\u0012\u0010\u0013\u001A\u00020\u00002\b\u0010\u0016\u001A\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/facebook/share/model/CameraEffectTextures$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/CameraEffectTextures;", "()V", "textures", "Landroid/os/Bundle;", "getTextures$facebook_common_release", "()Landroid/os/Bundle;", "build", "putParcelableTexture", "key", "", "parcelableTexture", "Landroid/os/Parcelable;", "putTexture", "texture", "Landroid/graphics/Bitmap;", "textureUrl", "Landroid/net/Uri;", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @NotNull
        private final Bundle textures;

        public Builder() {
            this.textures = new Bundle();
        }

        @NotNull
        public CameraEffectTextures build() {
            return new CameraEffectTextures(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @NotNull
        public final Bundle getTextures$facebook_common_release() {
            return this.textures;
        }

        private final Builder putParcelableTexture(String s, Parcelable parcelable0) {
            if(s.length() > 0 && parcelable0 != null) {
                this.textures.putParcelable(s, parcelable0);
            }
            return this;
        }

        @NotNull
        public final Builder putTexture(@NotNull String s, @Nullable Bitmap bitmap0) {
            q.g(s, "key");
            return this.putParcelableTexture(s, bitmap0);
        }

        @NotNull
        public final Builder putTexture(@NotNull String s, @Nullable Uri uri0) {
            q.g(s, "key");
            return this.putParcelableTexture(s, uri0);
        }

        @NotNull
        public final Builder readFrom(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((CameraEffectTextures)parcel0.readParcelable(CameraEffectTextures.class.getClassLoader())));
        }

        @NotNull
        public Builder readFrom(@Nullable CameraEffectTextures cameraEffectTextures0) {
            if(cameraEffectTextures0 != null) {
                this.textures.putAll(cameraEffectTextures0.textures);
            }
            return this;
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((CameraEffectTextures)shareModel0));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/CameraEffectTextures$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/CameraEffectTextures;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Bundle textures;

    static {
        CameraEffectTextures.Companion = new Companion(null);
        CameraEffectTextures.CREATOR = new CameraEffectTextures.Companion.CREATOR.1();
    }

    public CameraEffectTextures(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.textures = parcel0.readBundle(CameraEffectTextures.class.getClassLoader());
    }

    private CameraEffectTextures(Builder cameraEffectTextures$Builder0) {
        this.textures = cameraEffectTextures$Builder0.getTextures$facebook_common_release();
    }

    public CameraEffectTextures(Builder cameraEffectTextures$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(cameraEffectTextures$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Object get(@Nullable String s) {
        return this.textures == null ? null : this.textures.get(s);
    }

    @Nullable
    public final Bitmap getTextureBitmap(@Nullable String s) {
        Object object0 = this.textures == null ? null : this.textures.get(s);
        return object0 instanceof Bitmap ? ((Bitmap)object0) : null;
    }

    @Nullable
    public final Uri getTextureUri(@Nullable String s) {
        Object object0 = this.textures == null ? null : this.textures.get(s);
        return object0 instanceof Uri ? ((Uri)object0) : null;
    }

    @NotNull
    public final Set keySet() {
        Set set0 = this.textures == null ? null : this.textures.keySet();
        return set0 == null ? y.a : set0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeBundle(this.textures);
    }
}

