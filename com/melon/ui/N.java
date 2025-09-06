package com.melon.ui;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import java.util.List;
import kotlin.jvm.internal.q;
import we.a;

public final class n implements f {
    public final List a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final a f;
    public boolean g;

    public n(List list0, String s, boolean z, boolean z1, a a0, int v) {
        if((v & 4) != 0) {
            z = false;
        }
        if((v & 8) != 0) {
            z1 = false;
        }
        if((v & 0x20) != 0) {
            a0 = null;
        }
        q.g(list0, "playableList");
        q.g(s, "menuId");
        super();
        this.a = list0;
        this.b = s;
        this.c = z;
        this.d = z1;
        this.e = false;
        this.f = a0;
        this.g = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.g = true;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n && q.b(this.a, ((n)object0).a) && q.b(this.b, ((n)object0).b) && this.c == ((n)object0).c && this.d == ((n)object0).d && this.e == ((n)object0).e && q.b(this.f, ((n)object0).f) && this.g == ((n)object0).g;
    }

    @Override
    public final int hashCode() {
        int v = d.e(d.e(d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e);
        return this.f == null ? Boolean.hashCode(this.g) + v * 0x1F : Boolean.hashCode(this.g) + (v + this.f.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        boolean z = this.g;
        StringBuilder stringBuilder0 = new StringBuilder("PlaySongPlayableList(playableList=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", menuId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", excludeGenre=");
        x.y(stringBuilder0, this.c, ", shuffle=", this.d, ", openPlayer=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", onSuccessAction=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", isAllowBanContent=");
        return o.s(stringBuilder0, z, ")");
    }
}

