package jd;

import A7.d;
import U4.x;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;

public final class x2 extends y2 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final List h;
    public final String i;
    public final boolean j;

    public x2(String s, String s1, String s2, String s3, String s4, String s5, String s6, ArrayList arrayList0, String s7, boolean z, int v) {
        if((v & 0x80) != 0) {
            arrayList0 = null;
        }
        if((v & 0x100) != 0) {
            s7 = null;
        }
        if((v & 0x200) != 0) {
            z = false;
        }
        this(s, s1, s2, s3, s4, s5, s6, arrayList0, s7, z);
    }

    public x2(String s, String s1, String s2, String s3, String s4, String s5, String s6, List list0, String s7, boolean z) {
        q.g(s, "uniqueKey");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = s6;
        this.h = list0;
        this.i = s7;
        this.j = z;
    }

    @Override  // jd.y2
    public final String a() {
        return this.d;
    }

    @Override  // jd.y2
    public final String b() {
        return this.a;
    }

    public static x2 c(x2 x20, String s) {
        x20.getClass();
        q.g(x20.a, "uniqueKey");
        q.g(s, "content");
        q.g(x20.e, "msgSeq");
        return new x2(x20.a, x20.b, s, x20.d, x20.e, x20.f, x20.g, x20.h, x20.i, x20.j);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x2)) {
            return false;
        }
        if(!q.b(this.a, ((x2)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((x2)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((x2)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((x2)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((x2)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((x2)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((x2)object0).g)) {
            return false;
        }
        if(!q.b(this.h, ((x2)object0).h)) {
            return false;
        }
        return q.b(this.i, ((x2)object0).i) ? this.j == ((x2)object0).j : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = x.b((x.b((this.a.hashCode() * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F, 0x1F, this.c) + (this.d == null ? 0 : this.d.hashCode())) * 0x1F, 0x1F, this.e);
        int v2 = this.f == null ? 0 : this.f.hashCode();
        int v3 = this.g == null ? 0 : this.g.hashCode();
        int v4 = this.h == null ? 0 : this.h.hashCode();
        String s = this.i;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.j) + ((((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MusicWaveMessage(uniqueKey=", this.a, ", uniqueId=", this.b, ", content=");
        d.u(stringBuilder0, this.c, ", messageType=", this.d, ", msgSeq=");
        d.u(stringBuilder0, this.e, ", userImgUrl=", this.f, ", name=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", attachedImgDataList=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", regDate=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", isReported=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

