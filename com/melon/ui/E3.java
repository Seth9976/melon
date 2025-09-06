package com.melon.ui;

import A7.d;
import kotlin.jvm.internal.q;
import we.a;

public final class e3 implements K4 {
    public final Integer a;
    public final String b;
    public final String c;
    public final String d;
    public final a e;
    public final boolean f;

    public e3(Integer integer0, String s, String s1, String s2, a a0, boolean z) {
        this.a = integer0;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = a0;
        this.f = z;
    }

    public e3(String s, String s1, String s2, b9.a a0, int v) {
        this(((v & 1) == 0 ? null : 0x7F080786), ((v & 2) == 0 ? s : null), ((v & 4) == 0 ? s1 : null), ((v & 8) == 0 ? s2 : null), ((v & 16) == 0 ? a0 : null), (v & 0x20) == 0);  // drawable:noimage_logo_large
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e3)) {
            return false;
        }
        if(!q.b(this.a, ((e3)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((e3)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((e3)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((e3)object0).d)) {
            return false;
        }
        return q.b(this.e, ((e3)object0).e) ? this.f == ((e3)object0).f : false;
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
        return Boolean.hashCode(this.f) + ((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("NotificationScreenUiState(icon=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", message=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", subMessage=");
        d.u(stringBuilder0, this.c, ", buttonName=", this.d, ", action=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isForceDarkMode=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

