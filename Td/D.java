package td;

import android.content.Context;
import com.melon.ui.playermusic.PlayerViewCalculator;
import kotlin.jvm.internal.q;
import we.a;

public final class d implements a {
    public final int a;
    public final com.melon.ui.playermusic.d b;

    public d(com.melon.ui.playermusic.d d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            return ((PlayerViewCalculator)this.b.m.getValue()).c();
        }
        Context context0 = this.b.requireContext();
        q.f(context0, "requireContext(...)");
        return new PlayerViewCalculator(context0);
    }
}

