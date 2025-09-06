package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0016B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/facebook/share/model/ShareHashtag;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/share/model/ShareHashtag$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareHashtag$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "hashtag", "Ljava/lang/String;", "getHashtag", "()Ljava/lang/String;", "Companion", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareHashtag implements ShareModel {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001A\u00020\u0002H\u0016J\u0015\u0010\n\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\fH\u0000¢\u0006\u0002\b\rJ\u0012\u0010\n\u001A\u00020\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000F\u001A\u00020\u00002\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005R\"\u0010\u0006\u001A\u0004\u0018\u00010\u00052\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005@BX\u0086\u000E¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/facebook/share/model/ShareHashtag$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/ShareHashtag;", "()V", "<set-?>", "", "hashtag", "getHashtag", "()Ljava/lang/String;", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "readFrom$facebook_common_release", "model", "setHashtag", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @Nullable
        private String hashtag;

        @NotNull
        public ShareHashtag build() {
            return new ShareHashtag(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final String getHashtag() {
            return this.hashtag;
        }

        @NotNull
        public Builder readFrom(@Nullable ShareHashtag shareHashtag0) {
            return shareHashtag0 == null ? this : this.setHashtag(shareHashtag0.getHashtag());
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareHashtag)shareModel0));
        }

        @NotNull
        public final Builder readFrom$facebook_common_release(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((ShareHashtag)parcel0.readParcelable(ShareHashtag.class.getClassLoader())));
        }

        @NotNull
        public final Builder setHashtag(@Nullable String s) {
            this.hashtag = s;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/ShareHashtag$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/ShareHashtag;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final String hashtag;

    static {
        ShareHashtag.Companion = new Companion(null);
        ShareHashtag.CREATOR = new ShareHashtag.Companion.CREATOR.1();
    }

    public ShareHashtag(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.hashtag = parcel0.readString();
    }

    private ShareHashtag(Builder shareHashtag$Builder0) {
        this.hashtag = shareHashtag$Builder0.getHashtag();
    }

    public ShareHashtag(Builder shareHashtag$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(shareHashtag$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getHashtag() {
        return this.hashtag;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.hashtag);
    }
}

