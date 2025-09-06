package com.melon.playlist.mixup;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pc.b;
import pc.c;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/melon/playlist/mixup/DjMalrangInfo;", "Lpc/c;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjMalrangInfo implements Parcelable, c {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final b i;

    static {
        DjMalrangInfo.CREATOR = new e(25);
    }

    public DjMalrangInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, b b0) {
        q.g(s, "mainTitle");
        q.g(s1, "artistName");
        q.g(s2, "artistImg");
        q.g(s3, "songTitle");
        q.g(s4, "playlistId");
        q.g(s5, "poolId");
        q.g(s6, "playlistType");
        q.g(s7, "titleKey");
        q.g(b0, "colorType");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = s7;
        this.i = b0;
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
        if(!(object0 instanceof DjMalrangInfo)) {
            return false;
        }
        if(!q.b(this.a, ((DjMalrangInfo)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((DjMalrangInfo)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((DjMalrangInfo)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((DjMalrangInfo)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((DjMalrangInfo)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((DjMalrangInfo)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((DjMalrangInfo)object0).g)) {
            return false;
        }
        return q.b(this.h, ((DjMalrangInfo)object0).h) ? this.i == ((DjMalrangInfo)object0).i : false;
    }

    @Override
    public final int hashCode() {
        return this.i.hashCode() + x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("DjMalrangInfo(mainTitle=", this.a, ", artistName=", this.b, ", artistImg=");
        d.u(stringBuilder0, this.c, ", songTitle=", this.d, ", playlistId=");
        d.u(stringBuilder0, this.e, ", poolId=", this.f, ", playlistType=");
        d.u(stringBuilder0, this.g, ", titleKey=", this.h, ", colorType=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeString(this.i.name());
    }
}

