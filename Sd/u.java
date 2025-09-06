package sd;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import b3.Z;
import kotlin.jvm.internal.q;

public final class u extends w {
    public final boolean a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;

    public u(String s, String s1, String s2, String s3, String s4, String s5, String s6, boolean z, boolean z1) {
        q.g(s4, "title1");
        q.g(s5, "title2");
        super();
        this.a = z;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = s3;
        this.f = s4;
        this.g = s5;
        this.h = s6;
        this.i = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof u)) {
            return false;
        }
        if(this.a != ((u)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((u)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((u)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((u)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((u)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((u)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((u)object0).g)) {
            return false;
        }
        return q.b(this.h, ((u)object0).h) ? this.i == ((u)object0).i : false;
    }

    @Override
    public final int hashCode() {
        int v = Boolean.hashCode(this.a);
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        String s = this.e;
        if(s != null) {
            v1 = s.hashCode();
        }
        return Boolean.hashCode(this.i) + x.b(x.b(x.b(((((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Z.p("MusicWavePlayerUiState(isEmpty=", ", imgUrl=", this.b, ", imgShape=", this.a);
        d.u(stringBuilder0, this.c, ", musicWaveId=", this.d, ", musicWaveType=");
        d.u(stringBuilder0, this.e, ", title1=", this.f, ", title2=");
        d.u(stringBuilder0, this.g, ", contentDesc=", this.h, ", isPlaying=");
        return o.s(stringBuilder0, this.i, ")");
    }
}

