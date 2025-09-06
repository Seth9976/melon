package bc;

import U4.F;
import b3.E;
import com.iloen.melon.constants.CType;
import k9.j;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import oc.L;
import oc.w;
import oc.x;

public final class e {
    public s2 a;

    public static CType a(E e0) {
        q.f(e0.a, "mediaId");
        return F.Y(e0.a).b;
    }

    public final boolean b() {
        s2 s20 = this.a;
        if(s20 != null) {
            w w0 = ((d3)s20).k();
            return w0 instanceof x && ((L)((x)w0).y().getValue()).e() && j.a() == 5;
        }
        q.m("playlistManager");
        throw null;
    }
}

