package ed;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;
import we.a;

public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final a g;

    public b(String s, String s1, String s2, String s3, String s4, String s5, a a0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = a0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof b)) {
            return false;
        }
        if(!q.b(this.a, ((b)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((b)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((b)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((b)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((b)object0).e)) {
            return false;
        }
        return q.b(this.f, ((b)object0).f) ? q.b(this.g, ((b)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        return this.g.hashCode() + x.b(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ArchiveThemeBanner(adminTitle=", this.a, ", imgUrl=", this.b, ", bgColor=");
        d.u(stringBuilder0, this.c, ", text1=", this.d, ", text1Color=");
        d.u(stringBuilder0, this.e, ", text2=", this.f, ", clickAction=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

