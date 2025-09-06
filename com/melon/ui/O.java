package com.melon.ui;

import A7.d;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class o implements f {
    public final String a;
    public final String b;
    public final boolean c;
    public final StatsElementsBase d;
    public boolean e;

    public o(String s, String s1, StatsElementsBase statsElementsBase0, int v) {
        q.g(s, "mvId");
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
        this.c = false;
        this.d = statsElementsBase0;
        this.e = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.e = true;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof o && q.b(this.a, ((o)object0).a) && q.b(this.b, ((o)object0).b) && this.c == ((o)object0).c && q.b(this.d, ((o)object0).d) && this.e == ((o)object0).e;
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, true);
        return this.d == null ? Boolean.hashCode(this.e) + v * 0x1F : Boolean.hashCode(this.e) + (v + this.d.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        boolean z = this.e;
        StringBuilder stringBuilder0 = d.o("PlayVideoByMvId(mvId=", this.a, ", menuId=", this.b, ", isFullscreen=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", openPlayer=true, statsElementsBase=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", isAllowBanContent=");
        return androidx.appcompat.app.o.s(stringBuilder0, z, ")");
    }
}

