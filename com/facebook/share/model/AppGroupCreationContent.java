package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001D2\u00020\u0001:\u0003\u001E\u001F\u001DB\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001A\u0004\u0018\u00010\u00118\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001A\u0004\b\u0017\u0010\u0015R\u0019\u0010\u0019\u001A\u0004\u0018\u00010\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006 "}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/share/model/AppGroupCreationContent$Builder;", "builder", "<init>", "(Lcom/facebook/share/model/AppGroupCreationContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "describeContents", "()I", "out", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "description", "getDescription", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "appGroupPrivacy", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "getAppGroupPrivacy", "()Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "Companion", "AppGroupPrivacy", "Builder", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppGroupCreationContent implements ShareModel {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "", "(Ljava/lang/String;I)V", "Open", "Closed", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum AppGroupPrivacy {
        Open,
        Closed;

        private static final AppGroupPrivacy[] $values() [...] // Inlined contents
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u000E\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001A\u00020\u0002H\u0016J\u0012\u0010\u0014\u001A\u00020\u00002\b\u0010\u0015\u001A\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0016\u001A\u00020\u00002\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001A\u00020\u00002\b\u0010\n\u001A\u0004\u0018\u00010\u000BJ\u0010\u0010\u0018\u001A\u00020\u00002\b\u0010\u0010\u001A\u0004\u0018\u00010\u000BR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001C\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001C\u0010\u0010\u001A\u0004\u0018\u00010\u000BX\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000F¨\u0006\u0019"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/share/model/AppGroupCreationContent;", "()V", "appGroupPrivacy", "Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "getAppGroupPrivacy$facebook_common_release", "()Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;", "setAppGroupPrivacy$facebook_common_release", "(Lcom/facebook/share/model/AppGroupCreationContent$AppGroupPrivacy;)V", "description", "", "getDescription$facebook_common_release", "()Ljava/lang/String;", "setDescription$facebook_common_release", "(Ljava/lang/String;)V", "name", "getName$facebook_common_release", "setName$facebook_common_release", "build", "readFrom", "content", "setAppGroupPrivacy", "setDescription", "setName", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @Nullable
        private AppGroupPrivacy appGroupPrivacy;
        @Nullable
        private String description;
        @Nullable
        private String name;

        @NotNull
        public AppGroupCreationContent build() {
            return new AppGroupCreationContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final AppGroupPrivacy getAppGroupPrivacy$facebook_common_release() {
            return this.appGroupPrivacy;
        }

        @Nullable
        public final String getDescription$facebook_common_release() {
            return this.description;
        }

        @Nullable
        public final String getName$facebook_common_release() {
            return this.name;
        }

        @NotNull
        public Builder readFrom(@Nullable AppGroupCreationContent appGroupCreationContent0) {
            return appGroupCreationContent0 == null ? this : this.setName(appGroupCreationContent0.getName()).setDescription(appGroupCreationContent0.getDescription()).setAppGroupPrivacy(appGroupCreationContent0.getAppGroupPrivacy());
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((AppGroupCreationContent)shareModel0));
        }

        @NotNull
        public final Builder setAppGroupPrivacy(@Nullable AppGroupPrivacy appGroupCreationContent$AppGroupPrivacy0) {
            this.appGroupPrivacy = appGroupCreationContent$AppGroupPrivacy0;
            return this;
        }

        public final void setAppGroupPrivacy$facebook_common_release(@Nullable AppGroupPrivacy appGroupCreationContent$AppGroupPrivacy0) {
            this.appGroupPrivacy = appGroupCreationContent$AppGroupPrivacy0;
        }

        @NotNull
        public final Builder setDescription(@Nullable String s) {
            this.description = s;
            return this;
        }

        public final void setDescription$facebook_common_release(@Nullable String s) {
            this.description = s;
        }

        @NotNull
        public final Builder setName(@Nullable String s) {
            this.name = s;
            return this;
        }

        public final void setName$facebook_common_release(@Nullable String s) {
            this.name = s;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/share/model/AppGroupCreationContent$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/share/model/AppGroupCreationContent;", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
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
    private final AppGroupPrivacy appGroupPrivacy;
    @Nullable
    private final String description;
    @Nullable
    private final String name;

    static {
        AppGroupCreationContent.Companion = new Companion(null);
        AppGroupCreationContent.CREATOR = new AppGroupCreationContent.Companion.CREATOR.1();
    }

    public AppGroupCreationContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.name = parcel0.readString();
        this.description = parcel0.readString();
        this.appGroupPrivacy = (AppGroupPrivacy)parcel0.readSerializable();
    }

    private AppGroupCreationContent(Builder appGroupCreationContent$Builder0) {
        this.name = appGroupCreationContent$Builder0.getName$facebook_common_release();
        this.description = appGroupCreationContent$Builder0.getDescription$facebook_common_release();
        this.appGroupPrivacy = appGroupCreationContent$Builder0.getAppGroupPrivacy$facebook_common_release();
    }

    public AppGroupCreationContent(Builder appGroupCreationContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(appGroupCreationContent$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final AppGroupPrivacy getAppGroupPrivacy() {
        return this.appGroupPrivacy;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeString(this.name);
        parcel0.writeString(this.description);
        parcel0.writeSerializable(this.appGroupPrivacy);
    }
}

