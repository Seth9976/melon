package com.melon.ui;

import A7.d;
import U4.x;
import kotlin.jvm.internal.q;
import we.a;

public final class q4 implements I4 {
    public final String a;
    public final String b;
    public final String c;
    public final a d;

    public q4(int v, String s, String s1, String s2, a a0) {
        if((v & 8) != 0) {
            s2 = null;
        }
        if((v & 16) != 0) {
            a0 = null;
        }
        q.g(s, "title");
        q.g(s1, "message");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = a0;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q4 && q.b(this.a, ((q4)object0).a) && q.b(this.b, ((q4)object0).b) && q.b(this.c, ((q4)object0).c) && q.b(this.d, ((q4)object0).d);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, false);
        int v2 = this.c == null ? 0 : this.c.hashCode();
        a a0 = this.d;
        if(a0 != null) {
            v = a0.hashCode();
        }
        return (v1 + v2) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Alert(title=", this.a, ", message=", this.b, ", shouldRetain=false, okBtnText=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", okBtnAction=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

