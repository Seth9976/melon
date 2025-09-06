package com.melon.ui.musicwave;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/ui/musicwave/ChannelInfoData;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ChannelInfoData implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    static {
        ChannelInfoData.CREATOR = new e(22);
    }

    public ChannelInfoData(String s, String s1, String s2, boolean z, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = z;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = s7;
        this.j = s8;
        this.k = s9;
        this.l = s10;
        this.m = s11;
        this.n = s12;
    }

    // 去混淆评级： 低(40)
    public final boolean a() {
        return q.b(this.g, "");
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
        if(!(object0 instanceof ChannelInfoData)) {
            return false;
        }
        if(!q.b(this.a, ((ChannelInfoData)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((ChannelInfoData)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((ChannelInfoData)object0).c)) {
            return false;
        }
        if(this.d != ((ChannelInfoData)object0).d) {
            return false;
        }
        if(!q.b(this.e, ((ChannelInfoData)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((ChannelInfoData)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((ChannelInfoData)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((ChannelInfoData)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((ChannelInfoData)object0).i)) {
            return false;
        }
        if(!q.b(this.j, ((ChannelInfoData)object0).j)) {
            return false;
        }
        if(!q.b(this.k, ((ChannelInfoData)object0).k)) {
            return false;
        }
        if(!q.b(this.l, ((ChannelInfoData)object0).l)) {
            return false;
        }
        return q.b(this.m, ((ChannelInfoData)object0).m) ? q.b(this.n, ((ChannelInfoData)object0).n) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e((((this.a == null ? 0 : this.a.hashCode()) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F, 0x1F, this.d);
        int v2 = this.e == null ? 0 : this.e.hashCode();
        int v3 = this.f == null ? 0 : this.f.hashCode();
        int v4 = this.g == null ? 0 : this.g.hashCode();
        int v5 = this.h == null ? 0 : this.h.hashCode();
        int v6 = this.i == null ? 0 : this.i.hashCode();
        int v7 = this.j == null ? 0 : this.j.hashCode();
        int v8 = this.k == null ? 0 : this.k.hashCode();
        int v9 = this.l == null ? 0 : this.l.hashCode();
        int v10 = this.m == null ? 0 : this.m.hashCode();
        String s = this.n;
        if(s != null) {
            v = s.hashCode();
        }
        return (((((((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ChannelInfoData(id=", this.a, ", title=", this.b, ", mData=");
        Y.x(stringBuilder0, this.c, ", isChatAvail=", this.d, ", key=");
        d.u(stringBuilder0, this.e, ", type=", this.f, ", hostMemberKey=");
        d.u(stringBuilder0, this.g, ", hostName=", this.h, ", hostImgUrl=");
        d.u(stringBuilder0, this.i, ", eventBgImgUrl=", this.j, ", eventBgColor=");
        d.u(stringBuilder0, this.k, ", artistChatBgColor=", this.l, ", chatCleanUrl=");
        return d.n(stringBuilder0, this.m, ", profileCleanUrl=", this.n, ")");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
        parcel0.writeString(this.c);
        parcel0.writeInt(((int)this.d));
        parcel0.writeString(this.e);
        parcel0.writeString(this.f);
        parcel0.writeString(this.g);
        parcel0.writeString(this.h);
        parcel0.writeString(this.i);
        parcel0.writeString(this.j);
        parcel0.writeString(this.k);
        parcel0.writeString(this.l);
        parcel0.writeString(this.m);
        parcel0.writeString(this.n);
    }
}

