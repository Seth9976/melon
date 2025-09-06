package com.melon.ui;

import A7.d;
import k8.Y;
import kotlin.jvm.internal.q;

public final class N0 extends O0 {
    public final boolean a;
    public final boolean b;
    public final String c;
    public final M0 d;

    public N0(boolean z, boolean z1, String s, M0 m00) {
        this.a = z;
        this.b = z1;
        this.c = s;
        this.d = m00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof N0)) {
            return false;
        }
        if(this.a != ((N0)object0).a) {
            return false;
        }
        if(this.b != ((N0)object0).b) {
            return false;
        }
        return q.b(this.c, ((N0)object0).c) ? q.b(this.d, ((N0)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.e(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b);
        return this.c == null ? this.d.hashCode() + v * 0x1F : this.d.hashCode() + (v + this.c.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Y.q("OnCheckLocationAgreementAndPermissionForMalrang(isAgree=", ", passWebAgreeProcess=", this.a, ", menuId=", this.b);
        stringBuilder0.append(this.c);
        stringBuilder0.append(", endAction=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

