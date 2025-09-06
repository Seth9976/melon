package rd;

import Ic.h;
import android.content.Context;
import jd.N2;
import od.b;
import p8.e;
import we.a;

public final class d1 implements a {
    public final int a;
    public final K1 b;
    public final Context c;

    public d1(K1 k10, Context context0, int v) {
        this.a = v;
        this.b = k10;
        this.c = context0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h h0 = new h(0, this.b, K1.class, "getCurrentPlayable", "getCurrentPlayable()Lcom/iloen/melon/playback/Playable;", 0, 22);
            e e0 = new e(10);
            h h1 = new h(0, this.b.g(), b.class, "getRecmdKey", "getRecmdKey()Ljava/lang/String;", 0, 23);
            c1 c10 = new c1(this.b, this.c, 0);
            return new e0(this.b.b, h0, e0, h1, c10);
        }
        h h2 = new h(0, this.b, K1.class, "getCurrentPlayable", "getCurrentPlayable()Lcom/iloen/melon/playback/Playable;", 0, 24);
        e e1 = new e(9);
        N2 n20 = new N2(1, this.b.g(), b.class, "getImpressionId", "getImpressionId(Lcom/iloen/melon/playback/Playable;)Ljava/lang/String;", 0, 28);
        N2 n21 = new N2(1, this.b.g(), b.class, "getImpressionProvider", "getImpressionProvider(Lcom/iloen/melon/playback/Playable;)Ljava/lang/String;", 0, 29);
        h h3 = new h(0, this.b.g(), b.class, "getRecmdKey", "getRecmdKey()Ljava/lang/String;", 0, 25);
        c1 c11 = new c1(this.b, this.c, 1);
        b1 b10 = new b1(this.b, 3);
        return new B0(this.b.b, h2, e1, n20, n21, h3, c11, b10);
    }
}

