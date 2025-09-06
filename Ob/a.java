package ob;

import android.content.Context;
import com.iloen.melon.custom.L0;
import com.iloen.melon.playback.Playable;
import ie.H;
import kb.D;
import kc.s2;
import kotlin.jvm.internal.q;
import oe.i;
import ua.u;

public final class a {
    public final Context a;
    public final s2 b;
    public final u c;

    public a(Context context0, s2 s20, u u0) {
        q.g(context0, "context");
        q.g(s20, "playlistManager");
        super();
        this.a = context0;
        this.b = s20;
        this.c = u0;
    }

    public static Object a(Playable playable0, L0 l00, i i0) {
        Object object0 = new D(29).m(playable0, l00, i0);
        return object0 == ne.a.a ? object0 : H.a;
    }
}

