package vb;

import A7.d;
import Q0.a;
import U4.x;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import kotlin.jvm.internal.q;

public final class f extends a {
    public final String c;
    public final String d;
    public final String e;
    public String f;
    public String g;
    public final String h;
    public final ContsTypeCode i;

    public f(String s, String s1, String s2, String s3) {
        this.c = s;
        this.d = s1;
        this.e = s2;
        this.f = null;
        this.g = null;
        this.h = s3;
        q.f(ContsTypeCode.MUSIC_WAVE, "MUSIC_WAVE");
        this.i = ContsTypeCode.MUSIC_WAVE;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        if(!q.b(this.c, ((f)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((f)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((f)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((f)object0).f)) {
            return false;
        }
        return q.b(this.g, ((f)object0).g) ? q.b(this.h, ((f)object0).h) : false;
    }

    @Override  // Q0.a
    public final String h() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(this.c.hashCode() * 0x1F, 0x1F, this.d), 0x1F, this.e);
        int v1 = 0;
        int v2 = this.f == null ? 0 : this.f.hashCode();
        int v3 = this.g == null ? 0 : this.g.hashCode();
        String s = this.h;
        if(s != null) {
            v1 = s.hashCode();
        }
        return ((v + v2) * 0x1F + v3) * 0x1F + v1;
    }

    @Override  // Q0.a
    public final ContsTypeCode i() {
        return this.i;
    }

    @Override
    public final String toString() {
        String s = this.f;
        String s1 = this.g;
        StringBuilder stringBuilder0 = d.o("MusicWaveSharableProperties(contentsId=", this.c, ", type=", this.d, ", title=");
        d.u(stringBuilder0, this.e, ", imageUrl=", s, ", linkUrl=");
        return d.n(stringBuilder0, s1, ", contentsIdForLog=", this.h, ")");
    }
}

