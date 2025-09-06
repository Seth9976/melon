package com.facebook.gamingservices.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000F\u0018\u0000 \u001D2\u00020\u0001:\u0002\u001E\u001DB\u0011\b\u0012\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0010\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0015\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000B\u0010\fJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001C\u0010\u0015\u001A\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001A\u0004\u0018\u00010\u000E8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\u001AR\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u000E8\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u0018\u001A\u0004\b\u001C\u0010\u001A¨\u0006\u001F"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent;", "Lcom/facebook/share/model/ShareModel;", "Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "builder", "<init>", "(Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "", "getFilters", "()Ljava/util/List;", "out", "", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "filters", "Ljava/util/List;", "maxSize", "Ljava/lang/Integer;", "getMaxSize", "()Ljava/lang/Integer;", "minSize", "getMinSize", "CREATOR", "Builder", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ContextChooseContent implements ShareModel {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0015\u001A\u00020\u0002H\u0016J\u000E\u0010\u0016\u001A\u00020\u00002\u0006\u0010\u0017\u001A\u00020\u0018J\u0012\u0010\u0016\u001A\u00020\u00002\b\u0010\u0019\u001A\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\u001A\u001A\u00020\u00002\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0015\u0010\u001B\u001A\u00020\u00002\b\u0010\u000B\u001A\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001CJ\u0015\u0010\u001D\u001A\u00020\u00002\b\u0010\u0012\u001A\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001CR\"\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001E\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0011\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001E\u0010\u0012\u001A\u0004\u0018\u00010\fX\u0080\u000E¢\u0006\u0010\n\u0002\u0010\u0011\u001A\u0004\b\u0013\u0010\u000E\"\u0004\b\u0014\u0010\u0010¨\u0006\u001E"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "Lcom/facebook/share/model/ShareModelBuilder;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "()V", "filters", "", "", "getFilters$facebook_gamingservices_release", "()Ljava/util/List;", "setFilters$facebook_gamingservices_release", "(Ljava/util/List;)V", "maxSize", "", "getMaxSize$facebook_gamingservices_release", "()Ljava/lang/Integer;", "setMaxSize$facebook_gamingservices_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "minSize", "getMinSize$facebook_gamingservices_release", "setMinSize$facebook_gamingservices_release", "build", "readFrom", "parcel", "Landroid/os/Parcel;", "model", "setFilters", "setMaxSize", "(Ljava/lang/Integer;)Lcom/facebook/gamingservices/model/ContextChooseContent$Builder;", "setMinSize", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Builder implements ShareModelBuilder {
        @Nullable
        private List filters;
        @Nullable
        private Integer maxSize;
        @Nullable
        private Integer minSize;

        @NotNull
        public ContextChooseContent build() {
            return new ContextChooseContent(this, null);
        }

        @Override  // com.facebook.share.ShareBuilder
        public Object build() {
            return this.build();
        }

        @Nullable
        public final List getFilters$facebook_gamingservices_release() {
            return this.filters;
        }

        @Nullable
        public final Integer getMaxSize$facebook_gamingservices_release() {
            return this.maxSize;
        }

        @Nullable
        public final Integer getMinSize$facebook_gamingservices_release() {
            return this.minSize;
        }

        @NotNull
        public final Builder readFrom(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return this.readFrom(((ContextChooseContent)parcel0.readParcelable(ContextChooseContent.class.getClassLoader())));
        }

        @NotNull
        public Builder readFrom(@Nullable ContextChooseContent contextChooseContent0) {
            if(contextChooseContent0 != null) {
                Builder contextChooseContent$Builder0 = this.setFilters(contextChooseContent0.getFilters()).setMaxSize(contextChooseContent0.getMaxSize()).setMinSize(contextChooseContent0.getMinSize());
                return contextChooseContent$Builder0 == null ? this : contextChooseContent$Builder0;
            }
            return this;
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ContextChooseContent)shareModel0));
        }

        @NotNull
        public final Builder setFilters(@Nullable List list0) {
            this.filters = list0;
            return this;
        }

        public final void setFilters$facebook_gamingservices_release(@Nullable List list0) {
            this.filters = list0;
        }

        @NotNull
        public final Builder setMaxSize(@Nullable Integer integer0) {
            this.maxSize = integer0;
            return this;
        }

        public final void setMaxSize$facebook_gamingservices_release(@Nullable Integer integer0) {
            this.maxSize = integer0;
        }

        @NotNull
        public final Builder setMinSize(@Nullable Integer integer0) {
            this.minSize = integer0;
            return this;
        }

        public final void setMinSize$facebook_gamingservices_release(@Nullable Integer integer0) {
            this.minSize = integer0;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0006H\u0016J\u001D\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001A\u00020\nH\u0016¢\u0006\u0002\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/facebook/gamingservices/model/ContextChooseContent$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/facebook/gamingservices/model/ContextChooseContent;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/facebook/gamingservices/model/ContextChooseContent;", "facebook-gamingservices_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CREATOR implements Parcelable.Creator {
        private CREATOR() {
        }

        public CREATOR(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public ContextChooseContent createFromParcel(@NotNull Parcel parcel0) {
            q.g(parcel0, "parcel");
            return new ContextChooseContent(parcel0);
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        @NotNull
        public ContextChooseContent[] newArray(int v) {
            return new ContextChooseContent[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    @NotNull
    public static final CREATOR CREATOR;
    @Nullable
    private final List filters;
    @Nullable
    private final Integer maxSize;
    @Nullable
    private final Integer minSize;

    static {
        ContextChooseContent.CREATOR = new CREATOR(null);
    }

    public ContextChooseContent(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        this.filters = parcel0.createStringArrayList();
        this.maxSize = parcel0.readInt();
        this.minSize = parcel0.readInt();
    }

    private ContextChooseContent(Builder contextChooseContent$Builder0) {
        this.filters = contextChooseContent$Builder0.getFilters$facebook_gamingservices_release();
        this.maxSize = contextChooseContent$Builder0.getMaxSize$facebook_gamingservices_release();
        this.minSize = contextChooseContent$Builder0.getMinSize$facebook_gamingservices_release();
    }

    public ContextChooseContent(Builder contextChooseContent$Builder0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(contextChooseContent$Builder0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List getFilters() {
        return this.filters == null ? null : Collections.unmodifiableList(this.filters);
    }

    @Nullable
    public final Integer getMaxSize() {
        return this.maxSize;
    }

    @Nullable
    public final Integer getMinSize() {
        return this.minSize;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "out");
        parcel0.writeStringList(this.filters);
        int v1 = 0;
        parcel0.writeInt((this.maxSize == null ? 0 : ((int)this.maxSize)));
        Integer integer0 = this.minSize;
        if(integer0 != null) {
            v1 = (int)integer0;
        }
        parcel0.writeInt(v1);
    }
}

