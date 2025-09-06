package Cc;

import A7.d;
import kotlin.jvm.internal.q;
import we.a;

public final class s {
    public final String a;
    public final String b;
    public final String c;
    public final a d;
    public final a e;

    public s(String s, String s1, String s2, a a0, a a1) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = a0;
        this.e = a1;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s && q.b(this.a, ((s)object0).a) && q.b(this.b, ((s)object0).b) && q.b(this.c, ((s)object0).c) && q.b(this.d, ((s)object0).d) && q.b(this.e, ((s)object0).e);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        a a0 = this.e;
        if(a0 != null) {
            v = a0.hashCode();
        }
        return (((v1 * 961 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("CastData(imgUrl=", this.a, ", typeName=null, title=", this.b, ", subTitle=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", onClickPlay=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", onClickItem=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

