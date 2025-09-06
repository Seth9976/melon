package rd;

import android.content.Context;
import com.iloen.melon.playback.Playable;
import we.k;

public final class c1 implements k {
    public final int a;
    public final K1 b;
    public final Context c;

    public c1(K1 k10, Context context0, int v) {
        this.a = v;
        this.b = k10;
        this.c = context0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return this.b.g().d(this.c, ((Playable)object0));
    }
}

