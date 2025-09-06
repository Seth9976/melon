package jg;

import Tf.o;
import U4.x;
import java.util.List;
import kotlin.jvm.internal.q;
import mg.c;

public final class e implements c {
    public String a;
    public String b;
    public String c;

    public e(String s, String s1, String s2) {
        q.g(s, "method");
        q.g(s1, "uri");
        q.g(s2, "version");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
    }

    @Override  // mg.c
    public final boolean a() {
        return false;
    }

    @Override  // mg.c
    public final String b() {
        return this.a + ' ' + this.b + ' ' + this.c;
    }

    @Override  // mg.c
    public final void c(String s) {
        List list0 = o.R0(s, new String[]{" "}, 3, 2);
        if(list0.size() < 3) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        this.a = (String)list0.get(0);
        this.b = (String)list0.get(1);
        String s1 = (String)list0.get(2);
        q.g(s1, "<set-?>");
        this.c = s1;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof e && q.b(this.a, ((e)object0).a) && q.b(this.b, ((e)object0).b) && q.b(this.c, ((e)object0).c);
    }

    @Override  // mg.c
    public final String getVersion() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v = s.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("StartLine(method=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", uri=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", version=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

