package l4;

import java.util.Collection;

public final class a implements x {
    public final h a;

    public a(h h0) {
        this.a = h0;
        super();
    }

    @Override  // l4.x
    public void b(y y0, u u0, Collection collection0) {
        h h0 = this.a;
        if(y0 == h0.z && u0 != null) {
            N n0 = h0.y.a;
            String s = u0.f();
            K k0 = new K(n0, s, h0.b(n0, s));
            k0.i(u0);
            if(h0.d != k0) {
                h0.j(h0, k0, h0.z, 3, true, h0.y, collection0);
                h0.y = null;
                h0.z = null;
            }
        }
        else if(y0 == h0.e) {
            if(u0 != null) {
                h0.q(h0.d, u0);
            }
            K k1 = h0.d.a();
            if(k1 != null) {
                k1.p(collection0);
            }
        }
    }
}

