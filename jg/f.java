package jg;

import A7.d;
import Tf.o;
import Tf.v;
import U4.x;
import java.util.List;
import kotlin.jvm.internal.q;
import mg.c;

public final class f implements c {
    public b a;
    public int b;
    public String c;
    public String d;

    @Override  // mg.c
    public final boolean a() {
        return this.a == b.d;
    }

    @Override  // mg.c
    public final String b() {
        return this.d + ' ' + this.b + ' ' + this.c;
    }

    @Override  // mg.c
    public final void c(String s) {
        b b0;
        List list0 = o.R0(s, new String[]{" "}, 3, 2);
        if(list0.size() < 3) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        String s1 = (String)list0.get(0);
        q.g(s1, "<set-?>");
        this.d = s1;
        Integer integer0 = v.t0(((String)list0.get(1)));
        if(integer0 == null) {
            throw new IllegalArgumentException();
        }
        int v1 = (int)integer0;
        b[] arr_b = b.values();
        for(int v = 0; true; ++v) {
            b0 = null;
            if(v >= arr_b.length) {
                break;
            }
            b b1 = arr_b[v];
            if(b1.a == v1) {
                b0 = b1;
                break;
            }
        }
        b b2 = b.c;
        if(b0 == null) {
            b0 = b2;
        }
        if(b0 == b2) {
            throw new IllegalArgumentException(("unexpected status code:" + v1).toString());
        }
        this.a = b0;
        this.b = b0.a;
        this.c = (String)list0.get(2);
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof f && q.b(this.a, ((f)object0).a) && this.b == ((f)object0).b && q.b(this.c, ((f)object0).c) && q.b(this.d, ((f)object0).d);
    }

    @Override  // mg.c
    public final String getVersion() {
        return this.d;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.b(this.b, (this.a == null ? 0 : this.a.hashCode()) * 0x1F, 0x1F);
        int v2 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("StartLine(status=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", statusCode=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", reasonPhrase=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", version=");
        return x.m(stringBuilder0, this.d, ")");
    }
}

