package com.iloen.melon.fragments.present;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001D\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\b¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001A\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001A\u0010\u001B\u001A\u00020\u00042\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001B\u0010\u001CR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001D\u001A\u0004\b\u001E\u0010\u0012R\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001F\u001A\u0004\b\u0005\u0010\u0014¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/present/PresentData;", "Landroid/os/Parcelable;", "", "songId", "", "isAdult", "<init>", "(Ljava/lang/String;Z)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "()Z", "copy", "(Ljava/lang/String;Z)Lcom/iloen/melon/fragments/present/PresentData;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSongId", "Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PresentData implements Parcelable {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class Creator implements Parcelable.Creator {
        public final PresentData createFromParcel(Parcel parcel0) {
            q.g(parcel0, "parcel");
            String s = parcel0.readString();
            return parcel0.readInt() == 0 ? new PresentData(s, false) : new PresentData(s, true);
        }

        @Override  // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel0) {
            return this.createFromParcel(parcel0);
        }

        public final PresentData[] newArray(int v) {
            return new PresentData[v];
        }

        @Override  // android.os.Parcelable$Creator
        public Object[] newArray(int v) {
            return this.newArray(v);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Parcelable.Creator CREATOR;
    private final boolean isAdult;
    @NotNull
    private final String songId;

    static {
        PresentData.CREATOR = new Creator();
    }

    public PresentData(@NotNull String s, boolean z) {
        q.g(s, "songId");
        super();
        this.songId = s;
        this.isAdult = z;
    }

    @NotNull
    public final String component1() {
        return this.songId;
    }

    public final boolean component2() {
        return this.isAdult;
    }

    @NotNull
    public final PresentData copy(@NotNull String s, boolean z) {
        q.g(s, "songId");
        return new PresentData(s, z);
    }

    public static PresentData copy$default(PresentData presentData0, String s, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            s = presentData0.songId;
        }
        if((v & 2) != 0) {
            z = presentData0.isAdult;
        }
        return presentData0.copy(s, z);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PresentData)) {
            return false;
        }
        return q.b(this.songId, ((PresentData)object0).songId) ? this.isAdult == ((PresentData)object0).isAdult : false;
    }

    @NotNull
    public final String getSongId() {
        return this.songId;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.isAdult) + this.songId.hashCode() * 0x1F;
    }

    public final boolean isAdult() {
        return this.isAdult;
    }

    @Override
    @NotNull
    public String toString() {
        return "PresentData(songId=" + this.songId + ", isAdult=" + this.isAdult + ")";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.songId);
        parcel0.writeInt(((int)this.isAdult));
    }
}

