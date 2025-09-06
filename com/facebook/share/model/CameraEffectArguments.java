package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Set;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u0002\"!B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0019\u0010\u000B\u001A\u0004\u0018\u00010\t2\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u000E\u001A\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r2\b\u0010\n\u001A\u0004\u0018\u00010\t¢\u0006\u0004\b\u000E\u0010\u000FJ\u001C\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001F\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0019\u001A\u00020\u00062\u0006\u0010\u001A\u001A\u00020\u0016H\u0016¢\u0006\u0004\b\u001C\u0010\u001DR\u0016\u0010\u001F\u001A\u0004\u0018\u00010\u001E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010 ¨\u0006#"}, d2 = {"Lcom/facebook/share/model/CameraEffectArguments;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/CameraEffectArguments$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "key", "getString", "(Ljava/lang/String;)Ljava/lang/String;", "", "getStringArray", "(Ljava/lang/String;)[Ljava/lang/String;", "", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "", "keySet", "()Ljava/util/Set;", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Landroid/os/Bundle;", "params", "Landroid/os/Bundle;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CameraEffectArguments implements ShareModel {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001A\u00020\u0002H\u0016J!\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\r¢\u0006\u0002\u0010\u000EJ\u0016\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BJ\u000E\u0010\u0010\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u0012J\u0012\u0010\u0010\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0004\u001A\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/facebook/share/model/CameraEffectArguments$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/CameraEffectArguments;", "()V", "params", "Landroid/os/Bundle;", "getParams$facebook_common_release", "()Landroid/os/Bundle;", "build", "putArgument", "key", "", "arrayValue", "", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/facebook/share/model/CameraEffectArguments$Builder;", "value", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @NotNull
        private final Bundle params;

        public Builder() {
            this.params = new Bundle();
        }

        @NotNull
        public CameraEffectArguments build() {
            return new CameraEffectArguments(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @NotNull
        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        @NotNull
        public final Builder putArgument(@NotNull String s, @NotNull String s1) {
            q.g(s, "key");
            q.g(s1, "value");
            this.params.putString(s, s1);
            return this;
        }

        @NotNull
        public final Builder putArgument(@NotNull String s, @NotNull String[] arr_s) {
            q.g(s, "key");
            q.g(arr_s, "arrayValue");
            this.params.putStringArray(s, arr_s);
            return this;
        }

        @NotNull
        public final Builder readFrom(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((CameraEffectArguments)parcel0.readParcelable(CameraEffectArguments.class.getClassLoader())));
        }

        @NotNull
        public Builder readFrom(@Nullable CameraEffectArguments cameraEffectArguments0) {
            if(cameraEffectArguments0 != null) {
                this.params.putAll(cameraEffectArguments0.params);
            }
            return this;
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((CameraEffectArguments)shareModel0));
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/CameraEffectArguments$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/CameraEffectArguments;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final Bundle params;

    static {
        CameraEffectArguments.Companion = new Companion(null);
        CameraEffectArguments.CREATOR = new CameraEffectArguments.Companion.CREATOR.1();
    }

    public CameraEffectArguments(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.params = parcel0.readBundle(CameraEffectArguments.class.getClassLoader());
    }

    private CameraEffectArguments(Builder cameraEffectArguments$Builder0) {
        this.params = cameraEffectArguments$Builder0.getParams$facebook_common_release();
    }

    public CameraEffectArguments(Builder cameraEffectArguments$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(cameraEffectArguments$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Object get(@Nullable String s) {
        return this.params == null ? null : this.params.get(s);
    }

    @Nullable
    public final String getString(@Nullable String s) {
        return this.params == null ? null : this.params.getString(s);
    }

    @Nullable
    public final String[] getStringArray(@Nullable String s) {
        return this.params == null ? null : this.params.getStringArray(s);
    }

    @NotNull
    public final Set keySet() {
        Set set0 = this.params == null ? null : this.params.keySet();
        return set0 == null ? y.a : set0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeBundle(this.params);
    }
}

