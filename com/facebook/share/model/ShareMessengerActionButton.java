package com.facebook.share.model;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001:\u0001\u0016B\u0019\b\u0014\u0012\u000E\u0010\u0003\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/facebook/share/model/ShareMessengerActionButton;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/ShareMessengerActionButton$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class ShareMessengerActionButton implements ShareModel {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0014\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001A\u00028\u00012\b\u0010\r\u001A\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000EJ\u0015\u0010\u000F\u001A\u00028\u00012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010R\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0011"}, d2 = {"Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "M", "Lcom/facebook/share/model/ShareMessengerActionButton;", "B", "Lcom/facebook/share/model/ShareModelBuilder;", "()V", "title", "", "getTitle$facebook_common_release", "()Ljava/lang/String;", "setTitle$facebook_common_release", "(Ljava/lang/String;)V", "readFrom", "model", "(Lcom/facebook/share/model/ShareMessengerActionButton;)Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "setTitle", "(Ljava/lang/String;)Lcom/facebook/share/model/ShareMessengerActionButton$Builder;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static abstract class Builder implements ShareModelBuilder {
        @Nullable
        private String title;

        @Nullable
        public final String getTitle$facebook_common_release() {
            return this.title;
        }

        @NotNull
        public Builder readFrom(@Nullable ShareMessengerActionButton shareMessengerActionButton0) {
            return shareMessengerActionButton0 == null ? this : this.setTitle(shareMessengerActionButton0.getTitle());
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareMessengerActionButton)shareModel0));
        }

        @NotNull
        public final Builder setTitle(@Nullable String s) {
            this.title = s;
            return this;
        }

        public final void setTitle$facebook_common_release(@Nullable String s) {
            this.title = s;
        }
    }

    @Nullable
    private final String title;

    public ShareMessengerActionButton(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.title = parcel0.readString();
    }

    public ShareMessengerActionButton(@NotNull Builder shareMessengerActionButton$Builder0) {
        q.g(shareMessengerActionButton$Builder0, "builder");
        super();
        this.title = shareMessengerActionButton$Builder0.getTitle$facebook_common_release();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.title);
    }
}

