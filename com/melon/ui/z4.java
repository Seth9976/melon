package com.melon.ui;

import U4.x;
import kotlin.jvm.internal.q;

public final class z4 implements I4 {
    public final String a;
    public final String b;

    public z4(String s, String s1) {
        q.g(s, "castSeq");
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof z4 && q.b(this.a, ((z4)object0).a) && q.b(this.b, ((z4)object0).b);
    }

    @Override
    public final int hashCode() {
        return x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return "RadioCast(castSeq=" + this.a + ", menuId=" + this.b + ", songId=null)";
    }
}

