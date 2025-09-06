package com.melon.ui;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;
import pc.w1;

public final class i implements f {
    public final String a;
    public final w1 b;
    public boolean c;

    public i(String s, w1 w10) {
        q.g(s, "menuId");
        q.g(w10, "mixUpType");
        super();
        this.a = s;
        this.b = w10;
        this.c = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.c = true;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof i && q.b(this.a, ((i)object0).a) && q.b(this.b, ((i)object0).b) && this.c == ((i)object0).c;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        boolean z = this.c;
        StringBuilder stringBuilder0 = new StringBuilder("PlayMixUp(menuId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", mixUpType=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isAllowBanContent=");
        return o.s(stringBuilder0, z, ")");
    }
}

