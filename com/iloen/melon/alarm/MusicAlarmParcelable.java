package com.iloen.melon.alarm;

import A7.d;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import androidx.appcompat.app.o;
import com.melon.net.res.Domain;
import com.melon.net.res.VoiceAlarm.Track;
import java.util.Arrays;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import o8.f;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/iloen/melon/alarm/MusicAlarmParcelable;", "Landroid/os/Parcelable;", "Lcom/melon/net/res/Domain;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicAlarmParcelable implements Parcelable, Domain {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final boolean e;
    public final boolean[] f;
    public final String g;
    public final boolean h;
    public final int i;
    public final String j;
    public final String k;
    public final String l;
    public final Track m;

    static {
        MusicAlarmParcelable.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public MusicAlarmParcelable(int v, int v1, int v2, int v3, boolean z, boolean[] arr_z, String s, boolean z1, int v4, String s1, String s2, String s3, Track voiceAlarm$Track0) {
        q.g(arr_z, "weekDays");
        super();
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = z;
        this.f = arr_z;
        this.g = s;
        this.h = z1;
        this.i = v4;
        this.j = s1;
        this.k = s2;
        this.l = s3;
        this.m = voiceAlarm$Track0;
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
        if(!(object0 instanceof MusicAlarmParcelable)) {
            return false;
        }
        if(this.a != ((MusicAlarmParcelable)object0).a) {
            return false;
        }
        if(this.b != ((MusicAlarmParcelable)object0).b) {
            return false;
        }
        if(this.c != ((MusicAlarmParcelable)object0).c) {
            return false;
        }
        if(this.d != ((MusicAlarmParcelable)object0).d) {
            return false;
        }
        if(this.e != ((MusicAlarmParcelable)object0).e) {
            return false;
        }
        if(!q.b(this.f, ((MusicAlarmParcelable)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((MusicAlarmParcelable)object0).g)) {
            return false;
        }
        if(this.h != ((MusicAlarmParcelable)object0).h) {
            return false;
        }
        if(this.i != ((MusicAlarmParcelable)object0).i) {
            return false;
        }
        if(!q.b(this.j, ((MusicAlarmParcelable)object0).j)) {
            return false;
        }
        if(!q.b(this.k, ((MusicAlarmParcelable)object0).k)) {
            return false;
        }
        return q.b(this.l, ((MusicAlarmParcelable)object0).l) ? q.b(this.m, ((MusicAlarmParcelable)object0).m) : false;
    }

    @Override
    public final int hashCode() {
        int v = Arrays.hashCode(this.f);
        int v1 = 0;
        int v2 = d.b(this.i, d.e(((v + d.e(d.b(this.d, d.b(this.c, d.b(this.b, this.a * 0x1F, 0x1F), 0x1F), 0x1F), 0x1F, this.e)) * 0x1F + (this.g == null ? 0 : this.g.hashCode())) * 0x1F, 0x1F, this.h), 0x1F);
        int v3 = this.j == null ? 0 : this.j.hashCode();
        int v4 = this.k == null ? 0 : this.k.hashCode();
        int v5 = this.l == null ? 0 : this.l.hashCode();
        Track voiceAlarm$Track0 = this.m;
        if(voiceAlarm$Track0 != null) {
            v1 = voiceAlarm$Track0.hashCode();
        }
        return (((v2 + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        String s = Arrays.toString(this.f);
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "MusicAlarmParcelable(id=", ", hour=", ", minute=");
        x.x(stringBuilder0, this.c, ", volume=", this.d, ", isOn=");
        Y.y(stringBuilder0, this.e, ", weekDays=", s, ", songId=");
        Y.x(stringBuilder0, this.g, ", oneTimeAlarm=", this.h, ", soundType=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", songName=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", artistId=");
        d.u(stringBuilder0, this.k, ", artistName=", this.l, ", voiceTrack=");
        stringBuilder0.append(this.m);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeInt(this.a);
        parcel0.writeInt(this.b);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
        parcel0.writeInt(((int)this.e));
        parcel0.writeBooleanArray(this.f);
        parcel0.writeString(this.g);
        parcel0.writeInt(((int)this.h));
        parcel0.writeInt(this.i);
        parcel0.writeString(this.j);
        parcel0.writeString(this.k);
        parcel0.writeString(this.l);
        Track voiceAlarm$Track0 = this.m;
        if(voiceAlarm$Track0 == null) {
            parcel0.writeInt(0);
            return;
        }
        parcel0.writeInt(1);
        voiceAlarm$Track0.writeToParcel(parcel0, v);
    }
}

