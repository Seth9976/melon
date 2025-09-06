package com.melon.ui;

import A7.d;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class w4 implements I4 {
    public final String a;
    public final String b;
    public final StatsElementsBase c;

    public w4(String s, String s1, StatsElementsBase statsElementsBase0) {
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
        this.c = statsElementsBase0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof w4 && q.b(this.a, ((w4)object0).a) && q.b(this.b, ((w4)object0).b) && q.b(this.c, ((w4)object0).c);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, false);
        StatsElementsBase statsElementsBase0 = this.c;
        if(statsElementsBase0 != null) {
            v = statsElementsBase0.hashCode();
        }
        return v1 + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Album(albumId=", this.a, ", menuId=", this.b, ", openPlayer=false, statsElementsBase=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

