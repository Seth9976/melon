package o8;

import U4.x;
import android.content.Context;
import androidx.appcompat.app.o;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.alarm.MusicAlarmParcelable;
import com.iloen.melon.utils.system.VolumeUtils.Companion;
import com.iloen.melon.utils.system.VolumeUtils;
import com.melon.net.res.Domain;
import com.melon.net.res.Dto;
import com.melon.net.res.VoiceAlarm.Track;
import java.util.Arrays;
import k8.Y;
import k8.t;
import kotlin.jvm.internal.q;

public final class d implements Dto {
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public boolean[] f;
    public String g;
    public boolean h;
    public int i;
    public String j;
    public String k;
    public String l;
    public Track m;

    public d(int v, int v1, int v2, int v3, Track voiceAlarm$Track0, int v4) {
        int v5;
        if((v4 & 8) == 0) {
            v5 = v2;
        }
        else {
            MelonAppBase.Companion.getClass();
            Context context0 = t.a().getContext();
            v5 = Companion.getMaxVolume$default(VolumeUtils.Companion, context0, null, 2, null) / 2;
        }
        this(0, ((v4 & 2) == 0 ? v : 0), ((v4 & 4) == 0 ? v1 : 0), v5, true, new boolean[7], null, false, ((v4 & 0x100) == 0 ? v3 : 0), null, null, null, ((v4 & 0x1000) == 0 ? voiceAlarm$Track0 : null));
    }

    public d(int v, int v1, int v2, int v3, boolean z, boolean[] arr_z, String s, boolean z1, int v4, String s1, String s2, String s3, Track voiceAlarm$Track0) {
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

    public final MusicAlarmParcelable a() {
        return new MusicAlarmParcelable(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m);
    }

    @Override  // com.melon.net.res.Dto
    public final Domain asDomain() {
        return this.a();
    }

    public static d b(d d0, boolean z, Track voiceAlarm$Track0, int v) {
        int v1 = d0.a;
        int v2 = d0.b;
        int v3 = d0.c;
        int v4 = d0.d;
        boolean z1 = (v & 16) == 0 ? z : d0.e;
        boolean[] arr_z = d0.f;
        String s = d0.g;
        boolean z2 = d0.h;
        int v5 = d0.i;
        String s1 = d0.j;
        String s2 = d0.k;
        String s3 = d0.l;
        Track voiceAlarm$Track1 = (v & 0x1000) == 0 ? voiceAlarm$Track0 : d0.m;
        d0.getClass();
        q.g(arr_z, "weekDays");
        return new d(v1, v2, v3, v4, z1, arr_z, s, z2, v5, s1, s2, s3, voiceAlarm$Track1);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        Class class0 = object0 == null ? null : object0.getClass();
        if(!d.class.equals(class0)) {
            return false;
        }
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.alarm.MusicAlarm");
        if(this.a != ((d)object0).a) {
            return false;
        }
        if(this.b != ((d)object0).b) {
            return false;
        }
        if(this.c != ((d)object0).c) {
            return false;
        }
        if(this.d != ((d)object0).d) {
            return false;
        }
        if(this.e != ((d)object0).e) {
            return false;
        }
        if(!Arrays.equals(this.f, ((d)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((d)object0).g)) {
            return false;
        }
        if(this.h != ((d)object0).h) {
            return false;
        }
        if(this.i != ((d)object0).i) {
            return false;
        }
        if(!q.b(this.j, ((d)object0).j)) {
            return false;
        }
        if(!q.b(this.k, ((d)object0).k)) {
            return false;
        }
        return q.b(this.l, ((d)object0).l) ? q.b(this.m, ((d)object0).m) : false;
    }

    @Override
    public final int hashCode() {
        int v = A7.d.e((((this.a * 0x1F + this.b) * 0x1F + this.c) * 0x1F + this.d) * 0x1F, 0x1F, this.e);
        int v1 = 0;
        int v2 = (A7.d.e(((Arrays.hashCode(this.f) + v) * 0x1F + (this.g == null ? 0 : this.g.hashCode())) * 0x1F, 0x1F, this.h) + this.i) * 0x1F;
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
        int v = this.a;
        int v1 = this.b;
        int v2 = this.c;
        int v3 = this.d;
        boolean z = this.e;
        String s = Arrays.toString(this.f);
        String s1 = this.g;
        boolean z1 = this.h;
        int v4 = this.i;
        String s2 = this.j;
        String s3 = this.k;
        String s4 = this.l;
        Track voiceAlarm$Track0 = this.m;
        StringBuilder stringBuilder0 = o.t(v, v1, "MusicAlarm(id=", ", hour=", ", minute=");
        x.x(stringBuilder0, v2, ", volume=", v3, ", isOn=");
        Y.y(stringBuilder0, z, ", weekDays=", s, ", songId=");
        Y.x(stringBuilder0, s1, ", oneTimeAlarm=", z1, ", soundType=");
        stringBuilder0.append(v4);
        stringBuilder0.append(", songName=");
        stringBuilder0.append(s2);
        stringBuilder0.append(", artistId=");
        A7.d.u(stringBuilder0, s3, ", artistName=", s4, ", voiceTrack=");
        stringBuilder0.append(voiceAlarm$Track0);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

