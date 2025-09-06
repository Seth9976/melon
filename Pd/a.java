package pd;

import A7.d;
import H0.b;
import U4.x;
import com.iloen.melon.playback.Playable;
import com.melon.ui.K4;
import k8.Y;
import kotlin.jvm.internal.q;

public final class a implements K4 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final long g;
    public final long h;
    public final boolean i;
    public final boolean j;
    public final Playable k;

    public a(boolean z, boolean z1, String s, String s1, String s2, long v, long v1, long v2, boolean z2, boolean z3, Playable playable0) {
        this.a = z;
        this.b = z1;
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = v;
        this.g = v1;
        this.h = v2;
        this.i = z2;
        this.j = z3;
        this.k = playable0;
    }

    public static a a(a a0, boolean z, boolean z1, String s, String s1, String s2, long v, long v1, long v2, boolean z2, boolean z3, Playable playable0, int v3) {
        String s3 = (v3 & 4) == 0 ? s : a0.c;
        String s4 = (v3 & 8) == 0 ? s1 : a0.d;
        String s5 = (v3 & 16) == 0 ? s2 : a0.e;
        a0.getClass();
        q.g(s3, "textPlayTime");
        q.g(s4, "textPlayTime2");
        q.g(s5, "textDuration");
        return new a(((v3 & 1) == 0 ? z : a0.a), ((v3 & 2) == 0 ? z1 : a0.b), s3, s4, s5, ((v3 & 0x20) == 0 ? v : a0.f), ((v3 & 0x40) == 0 ? v1 : a0.g), ((v3 & 0x80) == 0 ? v2 : a0.h), ((v3 & 0x100) == 0 ? z2 : a0.i), ((v3 & 0x200) == 0 ? z3 : a0.j), ((v3 & 0x400) == 0 ? playable0 : a0.k));
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof a)) {
            return false;
        }
        if(this.a != ((a)object0).a) {
            return false;
        }
        if(this.b != ((a)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((a)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((a)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((a)object0).e)) {
            return false;
        }
        if(this.f != ((a)object0).f) {
            return false;
        }
        if(this.g != ((a)object0).g) {
            return false;
        }
        if(this.h != ((a)object0).h) {
            return false;
        }
        if(this.i != ((a)object0).i) {
            return false;
        }
        return this.j == ((a)object0).j ? q.b(this.k, ((a)object0).k) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.e(d.c(d.c(d.c(x.b(x.b(x.b(d.e(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j);
        return this.k == null ? v : v + this.k.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Y.q("ControllerUiState(isPlaying=", ", isPlaybackCompleted=", this.a, ", textPlayTime=", this.b);
        d.u(stringBuilder0, this.c, ", textPlayTime2=", this.d, ", textDuration=");
        b.t(this.f, this.e, ", positionMs=", stringBuilder0);
        com.iloen.melon.utils.a.s(this.g, ", durationMs=", ", seekingPositionMs=", stringBuilder0);
        stringBuilder0.append(this.h);
        stringBuilder0.append(", isSeeking=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", autoPlay=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", playable=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

