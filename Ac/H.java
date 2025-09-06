package ac;

import A7.d;
import H0.e;
import U4.x;
import com.iloen.melon.constants.CType;
import kotlin.jvm.internal.q;

public final class h extends e {
    public final String e;
    public final CType f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;

    public h(String s, CType cType0, String s1, String s2, String s3, String s4, String s5, String s6) {
        this.e = s;
        this.f = cType0;
        this.g = s1;
        this.h = s2;
        this.i = s3;
        this.j = s4;
        this.k = s5;
        this.l = s6;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof h)) {
            return false;
        }
        if(!q.b(this.e, ((h)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((h)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((h)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((h)object0).h)) {
            return false;
        }
        if(!q.b(this.i, ((h)object0).i)) {
            return false;
        }
        if(!q.b(this.j, ((h)object0).j)) {
            return false;
        }
        return q.b(this.k, ((h)object0).k) ? q.b(this.l, ((h)object0).l) : false;
    }

    @Override
    public final int hashCode() {
        return this.l.hashCode() + x.b(x.b(x.b(x.b(x.b((this.f.hashCode() + this.e.hashCode() * 0x1F) * 0x1F, 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("OfflinePlay(songId=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", contentsType=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", metaType=");
        d.u(stringBuilder0, this.g, ", bitrate=", this.h, ", hwKey=");
        d.u(stringBuilder0, this.i, ", bInfo=", this.j, ", freeYn=");
        return d.n(stringBuilder0, this.k, ", memberKey=", this.l, ")");
    }
}

