package e1;

import androidx.collection.u;
import androidx.compose.foundation.S;
import androidx.compose.foundation.w;
import androidx.compose.ui.text.font.AndroidFontLoader;
import com.iloen.melon.custom.S0;
import e3.h;
import x9.b;

public final class k implements i {
    public final AndroidFontLoader a;
    public final a b;
    public final b c;
    public final r d;
    public final S0 e;
    public final w f;

    public k(AndroidFontLoader androidFontLoader0, a a0) {
        r r0 = new r(l.b);
        S0 s00 = new S0(2);
        super();
        this.a = androidFontLoader0;
        this.b = a0;
        this.c = l.a;
        this.d = r0;
        this.e = s00;
        this.f = new w(this, 9);
    }

    public final N a(K k0) {
        N n2;
        b b0 = this.c;
        S s0 = new S(23, this, k0);
        synchronized(((h)b0.a)) {
            N n0 = (N)((u)b0.b).get(k0);
            if(n0 != null) {
                if(n0.d()) {
                    return n0;
                }
                N n1 = (N)((u)b0.b).remove(k0);
            }
        }
        try {
            n2 = (N)s0.invoke(new S(24, b0, k0));
        }
        catch(Exception exception0) {
            throw new IllegalStateException("Could not load font", exception0);
        }
        synchronized(((h)b0.a)) {
            if(((u)b0.b).get(k0) == null && n2.d()) {
                ((u)b0.b).put(k0, n2);
            }
            return n2;
        }
    }

    public final N b(j j0, y y0, int v, int v1) {
        this.b.getClass();
        int v2 = this.b.a;
        y y1 = v2 == 0 || v2 == 0x7FFFFFFF ? y0 : new y(P4.a.j(y0.a + v2, 1, 1000));
        this.a.getClass();
        return this.a(new K(j0, y1, v, v1, null));
    }
}

