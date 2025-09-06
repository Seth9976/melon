package D2;

import android.content.Context;
import android.content.SharedPreferences;
import de.c;
import e1.G;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.a;

public final class v0 extends r implements a {
    public final int f;
    public final Context g;
    public final String h;

    public v0(Context context0, String s, int v) {
        this.f = v;
        this.g = context0;
        this.h = s;
        super(0);
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                return c.p(this.g, this.h);
            }
            case 1: {
                return G.x(this.g, this.h);
            }
            default: {
                SharedPreferences sharedPreferences0 = this.g.getSharedPreferences(this.h, 0);
                q.f(sharedPreferences0, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
                return sharedPreferences0;
            }
        }
    }
}

