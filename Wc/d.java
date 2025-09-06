package wc;

import Ic.E;
import Ic.L;
import Ic.N;
import Ic.P;
import Ic.Y;
import Ic.b0;
import Ic.n;
import Ic.o;
import Ic.z;
import com.melon.ui.x4;
import ie.H;
import java.util.ArrayList;
import je.p;
import pc.G0;
import we.a;

public final class d implements a {
    public final int a;
    public final w b;

    public d(w w0, int v) {
        this.a = v;
        this.b = w0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        w w0 = this.b;
        switch(this.a) {
            case 0: {
                w0.x(false);
                return h0;
            }
            case 1: {
                w0.onUserEvent(Ic.H.a);
                return h0;
            }
            case 2: {
                w0.x(true);
                return h0;
            }
            case 3: {
                w0.onUserEvent(E.a);
                return h0;
            }
            case 4: {
                w0.onUserEvent(Y.a);
                return h0;
            }
            case 5: {
                w0.onUserEvent(b0.a);
                return h0;
            }
            case 6: {
                String s = w0.p();
                String s1 = w0.q();
                z z0 = w0.t();
                n n0 = z0 == null ? null : z0.a.a;
                String s2 = "";
                if(n0 != null) {
                    ArrayList arrayList0 = n0.e;
                    if(arrayList0.size() == 1) {
                        s2 = ((o)p.k0(arrayList0)).a;
                    }
                }
                G0 g00 = new G0(8, null, s, s1, s2);
                w0.sendUiEvent(new x4(w0.getMenuId(), g00, false));
                w0.trackTiaraEventLog(new b(w0, 4));
                return h0;
            }
            case 7: {
                w0.onUserEvent(L.a);
                return h0;
            }
            case 8: {
                w0.onUserEvent(N.a);
                return h0;
            }
            default: {
                w0.onUserEvent(P.a);
                return h0;
            }
        }
    }
}

