package td;

import com.melon.ui.playermusic.BgType.Album;
import com.melon.ui.playermusic.l;
import ie.H;
import we.a;
import we.k;
import we.n;

public final class h implements n {
    public final a a;
    public final k b;
    public final k c;
    public final boolean d;
    public final boolean e;
    public final a f;
    public final Album g;

    public h(a a0, k k0, k k1, boolean z, boolean z1, a a1, Album bgType$Album0, int v) {
        this.a = a0;
        this.b = k0;
        this.c = k1;
        this.d = z;
        this.e = z1;
        this.f = a1;
        this.g = bgType$Album0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Integer)object1).getClass();
        l.a(this.a, this.b, this.c, this.d, this.e, this.f, this.g, ((androidx.compose.runtime.l)object0), 0x61B0001);
        return H.a;
    }
}

