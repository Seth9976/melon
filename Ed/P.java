package ed;

import com.melon.net.res.SearchMainContentRes.ThemeOffering;
import ie.H;
import we.a;

public final class p implements a {
    public final int a;
    public final p0 b;

    public p(p0 p00, int v) {
        this.a = v;
        this.b = p00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            p0 p00 = this.b;
            ThemeOffering searchMainContentRes$ThemeOffering0 = p00.c;
            if(searchMainContentRes$ThemeOffering0 != null) {
                q0 q00 = new q0(searchMainContentRes$ThemeOffering0, p00.f, p00.g);
                p00.e.invoke(q00);
            }
            return H.a;
        }
        p0 p01 = this.b;
        ThemeOffering searchMainContentRes$ThemeOffering1 = p01.c;
        if(searchMainContentRes$ThemeOffering1 != null) {
            q0 q01 = new q0(searchMainContentRes$ThemeOffering1, p01.f, p01.g);
            p01.e.invoke(q01);
        }
        return H.a;
    }
}

