package com.melon.playlist.station;

import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.net.v5x.response.CastDetailRes.CAST;
import com.iloen.melon.net.v5x.response.CastDetailRes.PROGRAM;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import tc.a;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playlist/station/CastData;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CastData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final CAST b;
    public final PROGRAM c;
    public final String d;
    public final String e;

    static {
        CastData.CREATOR = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public CastData(String s, CAST castDetailRes$CAST0, PROGRAM castDetailRes$PROGRAM0, String s1, String s2) {
        q.g(s, "castSeq");
        q.g(s1, "bbsChannelSeq");
        q.g(s2, "bbsContsId");
        super();
        this.a = s;
        this.b = castDetailRes$CAST0;
        this.c = castDetailRes$PROGRAM0;
        this.d = s1;
        this.e = s2;
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
        if(!(object0 instanceof CastData)) {
            return false;
        }
        if(!q.b(this.a, ((CastData)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((CastData)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((CastData)object0).c)) {
            return false;
        }
        return q.b(this.d, ((CastData)object0).d) ? q.b(this.e, ((CastData)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        PROGRAM castDetailRes$PROGRAM0 = this.c;
        if(castDetailRes$PROGRAM0 != null) {
            v1 = castDetailRes$PROGRAM0.hashCode();
        }
        return this.e.hashCode() + x.b(((v * 0x1F + v2) * 0x1F + v1) * 0x1F, 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CastData(castSeq=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", castInfo=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", program=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", bbsChannelSeq=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", bbsContsId=");
        return x.m(stringBuilder0, this.e, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeSerializable(this.b);
        parcel0.writeSerializable(this.c);
        parcel0.writeString(this.d);
        parcel0.writeString(this.e);
    }
}

