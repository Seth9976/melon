package rd;

import Ic.h;
import Pc.d;
import com.iloen.melon.playback.Playable;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.interfaces.StringProviderImpl;
import kotlin.jvm.internal.q;
import m9.k;
import m9.l;
import p8.e;

public final class e0 {
    public final d a;
    public final h b;
    public final h c;
    public final c1 d;

    public e0(StringProviderImpl stringProviderImpl0, h h0, e e0, h h1, c1 c10) {
        q.g(stringProviderImpl0, "stringProvider");
        super();
        this.a = stringProviderImpl0;
        this.b = h0;
        this.c = h1;
        this.d = c10;
    }

    public final String a(int v) {
        return ((StringProviderImpl)this.a).a(v);
    }

    public final void b(q8.d d0, ActionKind actionKind0, Playable playable0) {
        d0.c(new l(7, actionKind0, this));
        d0.k(new k(14, playable0));
        d0.d(new d0(this, playable0, 0));
    }
}

