package com.melon.ui;

import A7.d;
import androidx.appcompat.app.o;
import k8.Y;

public final class a1 extends d1 {
    public final boolean a;
    public final boolean b;
    public final boolean c;

    public a1(boolean z, boolean z1, boolean z2) {
        this.a = z;
        this.b = z1;
        this.c = z2;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof a1 && this.a == ((a1)object0).a && this.b == ((a1)object0).b && this.c == ((a1)object0).c;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.e(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b);
    }

    @Override
    public final String toString() {
        return o.s(Y.q("Ignore(hasResponse=", ", hasNotification=", this.a, ", isError=", this.b), this.c, ")");
    }
}

