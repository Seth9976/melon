package com.melon.ui;

import A7.d;
import U4.x;
import k8.Y;
import kotlin.jvm.internal.q;
import we.a;

public final class r4 implements I4 {
    public final String a;
    public final String b;
    public final boolean c;
    public final String d;
    public final a e;
    public final String f;
    public final a g;

    public r4(String s, String s1, String s2, a a0, String s3, a a1, int v) {
        if((v & 8) != 0) {
            s2 = null;
        }
        if((v & 16) != 0) {
            a0 = null;
        }
        if((v & 0x20) != 0) {
            s3 = null;
        }
        if((v & 0x40) != 0) {
            a1 = null;
        }
        q.g(s1, "message");
        super();
        this.a = s;
        this.b = s1;
        this.c = false;
        this.d = s2;
        this.e = a0;
        this.f = s3;
        this.g = a1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof r4)) {
            return false;
        }
        if(!q.b(this.a, ((r4)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((r4)object0).b)) {
            return false;
        }
        if(this.c != ((r4)object0).c) {
            return false;
        }
        if(!q.b(this.d, ((r4)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((r4)object0).e)) {
            return false;
        }
        return q.b(this.f, ((r4)object0).f) ? q.b(this.g, ((r4)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
        int v1 = 0;
        int v2 = this.d == null ? 0 : this.d.hashCode();
        int v3 = this.e == null ? 0 : this.e.hashCode();
        int v4 = this.f == null ? 0 : this.f.hashCode();
        a a0 = this.g;
        if(a0 != null) {
            v1 = a0.hashCode();
        }
        return (((v + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("AlertTwoButton(title=", this.a, ", message=", this.b, ", shouldRetain=");
        Y.y(stringBuilder0, this.c, ", okBtnText=", this.d, ", okBtnAction=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", cancelBtnText=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", cancelBtnAction=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

