package com.melon.ui;

import A7.d;
import U4.x;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;
import we.a;

public final class m implements f {
    public final String a;
    public final String b;
    public final boolean c;
    public final StatsElementsBase d;
    public final a e;
    public boolean f;

    public m(String s, String s1, StatsElementsBase statsElementsBase0, a a0, int v) {
        if((v & 16) != 0) {
            a0 = null;
        }
        q.g(s, "songId");
        q.g(s1, "menuId");
        super();
        this.a = s;
        this.b = s1;
        this.c = false;
        this.d = statsElementsBase0;
        this.e = a0;
        this.f = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.f = true;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof m && q.b(this.a, ((m)object0).a) && q.b(this.b, ((m)object0).b) && this.c == ((m)object0).c && q.b(this.d, ((m)object0).d) && q.b(this.e, ((m)object0).e) && this.f == ((m)object0).f;
    }

    @Override
    public final int hashCode() {
        int v = d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
        int v1 = 0;
        int v2 = this.d == null ? 0 : this.d.hashCode();
        a a0 = this.e;
        if(a0 != null) {
            v1 = a0.hashCode();
        }
        return Boolean.hashCode(this.f) + ((v + v2) * 0x1F + v1) * 0x1F;
    }

    @Override
    public final String toString() {
        boolean z = this.f;
        StringBuilder stringBuilder0 = d.o("PlaySong(songId=", this.a, ", menuId=", this.b, ", openPlayer=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", statsElementsBase=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", onSuccessAction=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isAllowBanContent=");
        stringBuilder0.append(z);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

