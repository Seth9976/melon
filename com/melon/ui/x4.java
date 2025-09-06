package com.melon.ui;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;
import pc.w1;

public final class x4 implements I4 {
    public final String a;
    public final w1 b;
    public final boolean c;

    public x4(String s, w1 w10, boolean z) {
        q.g(s, "menuId");
        super();
        this.a = s;
        this.b = w10;
        this.c = z;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof x4 && q.b(this.a, ((x4)object0).a) && q.b(this.b, ((x4)object0).b) && this.c == ((x4)object0).c;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MixUp(menuId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", mixUpType=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isHideToolBar=");
        return o.s(stringBuilder0, this.c, ")");
    }
}

