package com.melon.ui;

import A7.d;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class y4 implements I4 {
    public final String a;
    public final String b;
    public final StatsElementsBase c;

    public y4(String s, String s1, StatsElementsBase statsElementsBase0, int v) {
        if((v & 16) != 0) {
            statsElementsBase0 = null;
        }
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
        this.c = statsElementsBase0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof y4 && this.a.equals(((y4)object0).a) && q.b(this.b, ((y4)object0).b) && q.b(this.c, ((y4)object0).c);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, false), 0x1F, false);
        StatsElementsBase statsElementsBase0 = this.c;
        if(statsElementsBase0 != null) {
            v = statsElementsBase0.hashCode();
        }
        return v1 + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Playlist(playlistSeq=", this.a, ", menuId=", this.b, ", needShufflePlay=false, openPlayer=false, statsElements=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

