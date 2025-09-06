package com.melon.ui;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import kotlin.jvm.internal.q;

public final class h implements f {
    public final String a;
    public final String b;
    public final boolean c;
    public final StatsElementsBase d;
    public boolean e;

    public h(String s, String s1, StatsElementsBase statsElementsBase0, int v) {
        if((v & 8) != 0) {
            statsElementsBase0 = null;
        }
        q.g(s, "albumId");
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
        return this == object0 || object0 instanceof h && q.b(this.a, ((h)object0).a) && q.b(this.b, ((h)object0).b) && this.c == ((h)object0).c && q.b(this.d, ((h)object0).d) && this.e == ((h)object0).e;
    }

    @Override
    public final int hashCode() {
        int v = d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
        return this.d == null ? Boolean.hashCode(this.e) + v * 961 : Boolean.hashCode(this.e) + (v + this.d.hashCode()) * 961;
    }

    @Override
    public final String toString() {
        boolean z = this.e;
        StringBuilder stringBuilder0 = d.o("PlayAlbum(albumId=", this.a, ", menuId=", this.b, ", openPlayer=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", statsElementsBase=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", onSuccessAction=null, isAllowBanContent=");
        return o.s(stringBuilder0, z, ")");
    }
}

