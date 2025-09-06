package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0016B\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/facebook/gamingservices/model/ContextSwitchContent;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/gamingservices/model/ContextSwitchContent$Builder;", "builder", "<init>", "(Lcom/facebook/gamingservices/model/ContextSwitchContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "out", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "contextID", "Ljava/lang/String;", "getContextID", "()Ljava/lang/String;", "CREATOR", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ContextSwitchContent implements ShareModel {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001A\u00020\u0002H\u0016J\u000E\u0010\u000B\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\rJ\u0012\u0010\u000B\u001A\u00020\u00002\b\u0010\u000E\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000F\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005R\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/facebook/gamingservices/model/ContextSwitchContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/model/ContextSwitchContent;", "()V", "contextID", "", "getContextID$facebook_gamingservices_release", "()Ljava/lang/String;", "setContextID$facebook_gamingservices_release", "(Ljava/lang/String;)V", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "setContextID", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @Nullable
        private String contextID;

        @NotNull
        public ContextSwitchContent build() {
            return new ContextSwitchContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final String getContextID$facebook_gamingservices_release() {
            return this.contextID;
        }

        @NotNull
        public final Builder readFrom(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((ContextSwitchContent)parcel0.readParcelable(ContextSwitchContent.class.getClassLoader())));
        }

        @NotNull
        public Builder readFrom(@Nullable ContextSwitchContent contextSwitchContent0) {
            if(contextSwitchContent0 != null) {
                Builder contextSwitchContent$Builder0 = this.setContextID(contextSwitchContent0.getContextID());
                return contextSwitchContent$Builder0 == null ? this : contextSwitchContent$Builder0;
            }
            return this;
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ContextSwitchContent)shareModel0));
        }

        @NotNull
        public final Builder setContextID(@Nullable String s) {
            this.contextID = s;
            return this;
        }

        public final void setContextID$facebook_gamingservices_release(@Nullable String s) {
            this.contextID = s;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u001D\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/model/ContextSwitchContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/model/ContextSwitchContent;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/model/ContextSwitchContent;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CREATOR implements Parcelable.Creator {
        private CREATOR() {
        }

        public CREATOR(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public ContextSwitchContent createFromParcel(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return new ContextSwitchContent(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        @NotNull
        public ContextSwitchContent[] newArray(int v) {
            return new ContextSwitchContent[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    @NotNull
    public static final CREATOR CREATOR;
    @Nullable
    private final String contextID;

    static {
        ContextSwitchContent.CREATOR = new CREATOR(null);
    }

    public ContextSwitchContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.contextID = parcel0.readString();
    }

    private ContextSwitchContent(Builder contextSwitchContent$Builder0) {
        this.contextID = contextSwitchContent$Builder0.getContextID$facebook_gamingservices_release();
    }

    public ContextSwitchContent(Builder contextSwitchContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(contextSwitchContent$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getContextID() {
        return this.contextID;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeString(this.contextID);
    }
}

