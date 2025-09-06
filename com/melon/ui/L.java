package com.melon.ui;

import A7.d;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class l implements f {
    public final String a;
    public final String b;
    public final StatsElementsBase c;
    public boolean d;

    public l(String s, String s1, StatsElementsBase statsElementsBase0, int v) {
        if((v & 4) != 0) {
            statsElementsBase0 = null;
        }
        q.g(s, "castSeq");
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
        this.c = statsElementsBase0;
        this.d = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.d = true;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof l && q.b(this.a, ((l)object0).a) && q.b(this.b, ((l)object0).b) && q.b(this.c, ((l)object0).c) && this.d == ((l)object0).d;
    }

    @Override
    public final int hashCode() {
        int v = x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
        return this.c == null ? Boolean.hashCode(this.d) + d.e(v * 0x1F, 0x1F, false) : Boolean.hashCode(this.d) + d.e((v + this.c.hashCode()) * 0x1F, 0x1F, false);
    }

    @Override
    public final String toString() {
        boolean z = this.d;
        StringBuilder stringBuilder0 = d.o("PlayRadioCast(castSeq=", this.a, ", menuId=", this.b, ", statsElementsBase=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", openPlayer=false, isAllowBanContent=");
        stringBuilder0.append(z);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

