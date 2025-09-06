package td;

import Ic.h;
import Pc.d;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.interfaces.StringProviderImpl;
import kotlin.jvm.internal.q;
import m9.l;
import p8.e;
import sd.j;

public final class n0 {
    public final d a;
    public final h b;

    public n0(StringProviderImpl stringProviderImpl0, h h0, e e0) {
        q.g(stringProviderImpl0, "stringProvider");
        super();
        this.a = stringProviderImpl0;
        this.b = h0;
    }

    public final String a(int v) {
        return ((StringProviderImpl)this.a).a(v);
    }

    public final void b(q8.d d0, ActionKind actionKind0, Playable playable0) {
        d0.c(new l(16, actionKind0, this));
        d0.k(new f0(25, playable0));
        d0.d(new j(this, 5));
    }
}

