package td;

import Ic.h;
import Pc.d;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.interfaces.StringProviderImpl;
import kotlin.jvm.internal.q;
import m9.l;
import p8.e;
import rd.x0;
import sd.j;

public final class g0 {
    public final d a;
    public final h b;

    public g0(StringProviderImpl stringProviderImpl0, h h0, e e0) {
        q.g(stringProviderImpl0, "stringProvider");
        super();
        this.a = stringProviderImpl0;
        this.b = h0;
    }

    public final String a(int v) {
        return ((StringProviderImpl)this.a).a(v);
    }

    public final void b(q8.d d0, ActionKind actionKind0, Playable playable0) {
        d0.c(new l(14, actionKind0, this));
        d0.k(new x0(29, playable0));
        d0.d(new j(this, 4));
    }
}

