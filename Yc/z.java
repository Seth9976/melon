package yc;

import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import kotlin.jvm.internal.q;
import q8.d;
import q8.h;
import sd.g;
import we.k;
import xc.F;

public final class z implements k {
    public final String a;
    public final E b;
    public final ActionKind c;
    public final boolean d;
    public final String e;
    public final int f;
    public final SongInfoBase g;

    public z(String s, E e0, ActionKind actionKind0, boolean z, String s1, int v, SongInfoBase songInfoBase0) {
        this.a = s;
        this.b = e0;
        this.c = actionKind0;
        this.d = z;
        this.e = s1;
        this.f = v;
        this.g = songInfoBase0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        q.g(((d)object0), "$this$tiaraEventLogBuilder");
        ((d)object0).d(new x(((d)object0), 1));
        new g(this.a, 23).invoke(((h)((d)object0).b));
        ((d)object0).c(new F(3, this.b, this.c));
        ((d)object0).b(new A(this.d, this.e, this.f));
        ((d)object0).e(new w(this.g, 1));
        return H.a;
    }
}

