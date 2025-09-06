package Nc;

import A7.d;
import U4.x;
import Ud.a;
import Ud.h;
import com.iloen.melon.playback.Playable;
import com.melon.ui.K4;
import k8.Y;
import kotlin.jvm.internal.q;
import we.k;

public final class v1 implements a, h, K4 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final Playable h;
    public final boolean i;
    public final boolean j;
    public final k k;

    public v1(String s, String s1, String s2, boolean z, boolean z1, boolean z2, boolean z3, Playable playable0, boolean z4, boolean z5, k k0) {
        q.g(s1, "artistName");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = z;
        this.e = z1;
        this.f = z2;
        this.g = z3;
        this.h = playable0;
        this.i = z4;
        this.j = z5;
        this.k = k0;
    }

    public static v1 a(v1 v10, boolean z, boolean z1, int v) {
        String s = v10.a;
        String s1 = v10.b;
        String s2 = v10.c;
        boolean z2 = v10.d;
        boolean z3 = v10.e;
        boolean z4 = v10.f;
        boolean z5 = v10.g;
        Playable playable0 = v10.h;
        if((v & 0x100) != 0) {
            z = v10.i;
        }
        if((v & 0x200) != 0) {
            z1 = v10.j;
        }
        v10.getClass();
        q.g(s1, "artistName");
        return new v1(s, s1, s2, z2, z3, z4, z5, playable0, z, z1, v10.k);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v1)) {
            return false;
        }
        if(!q.b(this.a, ((v1)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((v1)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((v1)object0).c)) {
            return false;
        }
        if(this.d != ((v1)object0).d) {
            return false;
        }
        if(this.e != ((v1)object0).e) {
            return false;
        }
        if(this.f != ((v1)object0).f) {
            return false;
        }
        if(this.g != ((v1)object0).g) {
            return false;
        }
        if(!q.b(this.h, ((v1)object0).h)) {
            return false;
        }
        if(this.i != ((v1)object0).i) {
            return false;
        }
        return this.j == ((v1)object0).j ? q.b(this.k, ((v1)object0).k) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.e((this.h.hashCode() + d.e(d.e(d.e(d.e(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g)) * 0x1F, 0x1F, this.i), 0x1F, this.j);
        return this.k == null ? v : v + this.k.hashCode();
    }

    @Override  // Ud.a
    public final boolean isMarquee() {
        return this.j;
    }

    @Override  // Ud.h
    public final boolean isSelected() {
        return this.i;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("GenreSongUiState(songName=", this.a, ", artistName=", this.b, ", albumImgUrl=");
        Y.x(stringBuilder0, this.c, ", isAdult=", this.d, ", isHoldBack=");
        x.y(stringBuilder0, this.e, ", isFree=", this.f, ", canService=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", playable=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", isSelected=");
        x.y(stringBuilder0, this.i, ", isMarquee=", this.j, ", onGenreSongUserEvent=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

