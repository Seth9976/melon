package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import ie.d;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\'\u0018\u0000*\u0014\b\u0000\u0010\u0001*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000*\u0014\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u00020\u0004:\u0002\u001C\u001DB\u001D\b\u0014\u0012\u0012\u0010\u0005\u001A\u000E\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0010\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0012\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001B\u001A\u00020\u00188&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0019\u0010\u001A¨\u0006\u001E"}, d2 = {"Lcom/facebook/share/model/ShareMedia;", "M", "Lcom/facebook/share/model/ShareMedia$Builder;", "B", "Lcom/facebook/share/model/ShareModel;", "builder", "<init>", "(Lcom/facebook/share/model/ShareMedia$Builder;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "Landroid/os/Bundle;", "getParameters", "()Landroid/os/Bundle;", "", "describeContents", "()I", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "params", "Landroid/os/Bundle;", "Lcom/facebook/share/model/ShareMedia$Type;", "getMediaType", "()Lcom/facebook/share/model/ShareMedia$Type;", "mediaType", "Builder", "Type", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public abstract class ShareMedia implements ShareModel {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0007\b&\u0018\u0000 \u0017*\u0014\b\u0002\u0010\u0001*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0002*\u0014\b\u0003\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\u000E\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\f\u001A\u00028\u00032\b\u0010\r\u001A\u0004\u0018\u00018\u0002H\u0016¢\u0006\u0002\u0010\u000EJ\u001D\u0010\u000F\u001A\u00028\u00032\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001A\u00028\u00032\u0006\u0010\u0015\u001A\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0016R\u001A\u0010\u0006\u001A\u00020\u0007X\u0080\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\u0018"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Builder;", "M", "Lcom/facebook/share/model/ShareMedia;", "B", "Lcom/facebook/share/model/ShareModelBuilder;", "()V", "params", "Landroid/os/Bundle;", "getParams$facebook_common_release", "()Landroid/os/Bundle;", "setParams$facebook_common_release", "(Landroid/os/Bundle;)V", "readFrom", "model", "(Lcom/facebook/share/model/ShareMedia;)Lcom/facebook/share/model/ShareMedia$Builder;", "setParameter", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)Lcom/facebook/share/model/ShareMedia$Builder;", "setParameters", "parameters", "(Landroid/os/Bundle;)Lcom/facebook/share/model/ShareMedia$Builder;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static abstract class Builder implements ShareModelBuilder {
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0014\u0010\n\u001A\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\bH\u0001¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0012\u001A\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\b2\u0006\u0010\u000F\u001A\u00020\u0004H\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Builder$Companion;", "", "<init>", "()V", "Landroid/os/Parcel;", "out", "", "parcelFlags", "", "Lcom/facebook/share/model/ShareMedia;", "media", "Lie/H;", "writeListTo$facebook_common_release", "(Landroid/os/Parcel;ILjava/util/List;)V", "writeListTo", "parcel", "readListFrom$facebook_common_release", "(Landroid/os/Parcel;)Ljava/util/List;", "readListFrom", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final List readListFrom$facebook_common_release(@NotNull Parcel parcel0) {
                q.g(parcel0, "parcel");
                Parcelable[] arr_parcelable = parcel0.readParcelableArray(ShareMedia.class.getClassLoader());
                if(arr_parcelable == null) {
                    return w.a;
                }
                List list0 = new ArrayList();
                for(int v = 0; v < arr_parcelable.length; ++v) {
                    Parcelable parcelable0 = arr_parcelable[v];
                    if(parcelable0 instanceof ShareMedia) {
                        list0.add(parcelable0);
                    }
                }
                return list0;
            }

            public final void writeListTo$facebook_common_release(@NotNull Parcel parcel0, int v, @NotNull List list0) {
                q.g(parcel0, "out");
                q.g(list0, "media");
                parcel0.writeParcelableArray(((Parcelable[])list0.toArray(new ShareMedia[0])), v);
            }
        }

        @NotNull
        public static final Companion Companion;
        @NotNull
        private Bundle params;

        static {
            Builder.Companion = new Companion(null);
        }

        public Builder() {
            this.params = new Bundle();
        }

        @NotNull
        public final Bundle getParams$facebook_common_release() {
            return this.params;
        }

        @NotNull
        public Builder readFrom(@Nullable ShareMedia shareMedia0) {
            return shareMedia0 == null ? this : this.setParameters(shareMedia0.params);
        }

        @Override  // com.facebook.share.model.ShareModelBuilder
        public ShareModelBuilder readFrom(ShareModel shareModel0) {
            return this.readFrom(((ShareMedia)shareModel0));
        }

        @NotNull
        public static final List readListFrom$facebook_common_release(@NotNull Parcel parcel0) {
            return Builder.Companion.readListFrom$facebook_common_release(parcel0);
        }

        @d
        @NotNull
        public final Builder setParameter(@NotNull String s, @NotNull String s1) {
            q.g(s, "key");
            q.g(s1, "value");
            this.params.putString(s, s1);
            return this;
        }

        @d
        @NotNull
        public final Builder setParameters(@NotNull Bundle bundle0) {
            q.g(bundle0, "parameters");
            this.params.putAll(bundle0);
            return this;
        }

        public final void setParams$facebook_common_release(@NotNull Bundle bundle0) {
            q.g(bundle0, "<set-?>");
            this.params = bundle0;
        }

        public static final void writeListTo$facebook_common_release(@NotNull Parcel parcel0, int v, @NotNull List list0) {
            Builder.Companion.writeListTo$facebook_common_release(parcel0, v, list0);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/share/model/ShareMedia$Type;", "", "(Ljava/lang/String;I)V", "PHOTO", "VIDEO", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Type {
        PHOTO,
        VIDEO;

        private static final Type[] $values() [...] // Inlined contents
    }

    @NotNull
    private final Bundle params;

    public ShareMedia(@NotNull Parcel parcel0) {
        q.g(parcel0, "parcel");
        super();
        Bundle bundle0 = parcel0.readBundle(this.getClass().getClassLoader());
        if(bundle0 == null) {
            bundle0 = new Bundle();
        }
        this.params = bundle0;
    }

    public ShareMedia(@NotNull Builder shareMedia$Builder0) {
        q.g(shareMedia$Builder0, "builder");
        super();
        this.params = new Bundle(shareMedia$Builder0.getParams$facebook_common_release());
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public abstract Type getMediaType();

    @d
    @NotNull
    public final Bundle getParameters() {
        return new Bundle(this.params);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeBundle(this.params);
    }
}

