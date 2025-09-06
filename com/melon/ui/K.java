package com.melon.ui;

import A7.d;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class k implements f {
    public final String a;
    public final String b;
    public final boolean c;
    public final StatsElementsBase d;
    public final boolean e;
    public boolean f;

    public k(String s, String s1, StatsElementsBase statsElementsBase0, int v) {
        if((v & 8) != 0) {
            statsElementsBase0 = null;
        }
        q.g(s, "playlistId");
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
        this.c = false;
        this.d = statsElementsBase0;
        this.e = false;
        this.f = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.f = true;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k && q.b(this.a, ((k)object0).a) && q.b(this.b, ((k)object0).b) && this.c == ((k)object0).c && q.b(this.d, ((k)object0).d) && this.e == ((k)object0).e && this.f == ((k)object0).f;
    }

    @Override
    public final int hashCode() {
        int v = d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
        return this.d == null ? Boolean.hashCode(this.f) + d.e(v * 0x1F, 0x1F, this.e) : Boolean.hashCode(this.f) + d.e((v + this.d.hashCode()) * 0x1F, 0x1F, this.e);
    }

    @Override
    public final String toString() {
        boolean z = this.f;
        StringBuilder stringBuilder0 = d.o("PlayPlaylist(playlistId=", this.a, ", menuId=", this.b, ", needShufflePlay=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", statsElements=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", openPlayer=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isAllowBanContent=");
        stringBuilder0.append(z);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

