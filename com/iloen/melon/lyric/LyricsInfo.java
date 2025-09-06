package com.iloen.melon.lyric;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/lyric/LyricsInfo;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LyricsInfo implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final long a;
    public final String b;

    static {
        LyricsInfo.CREATOR = new e(13);
    }

    public LyricsInfo(long v, String s) {
        q.g(s, "text");
        super();
        this.a = v;
        this.b = s;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof LyricsInfo)) {
            return false;
        }
        return this.a == ((LyricsInfo)object0).a ? q.b(this.b, ((LyricsInfo)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + Long.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "LyricsInfo(time=" + this.a + ", text=" + this.b + ")";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeLong(this.a);
        parcel0.writeString(this.b);
    }
}

