package M7;

import android.content.Context;
import e1.G;
import we.a;

public final class r extends kotlin.jvm.internal.r implements a {
    public final int f;
    public final Context g;

    public r(Context context0, int v) {
        this.f = v;
        this.g = context0;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        return this.f == 0 ? G.x(this.g, E.b) : G.x(this.g, E.a);
    }
}

