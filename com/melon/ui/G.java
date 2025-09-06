package com.melon.ui;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import java.util.List;
import kotlin.jvm.internal.q;

public final class g implements f {
    public final List a;
    public final String b;
    public boolean c;

    public g(List list0, String s) {
        q.g(list0, "playableList");
        q.g(s, "menuId");
        super();
        this.a = list0;
        this.b = s;
        this.c = false;
    }

    @Override  // com.melon.ui.f
    public final void a() {
        this.c = true;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof g && q.b(this.a, ((g)object0).a) && q.b(this.b, ((g)object0).b) && this.c == ((g)object0).c;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.c) + d.e(d.e(d.e(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, false), 0x1F, false), 0x1F, false);
    }

    @Override
    public final String toString() {
        boolean z = this.c;
        StringBuilder stringBuilder0 = new StringBuilder("AddSongPlayableList(playableList=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", menuId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", excludeGenre=false, shuffle=false, openPlayer=false, isAllowBanContent=");
        return o.s(stringBuilder0, z, ")");
    }
}

