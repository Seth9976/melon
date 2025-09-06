package wc;

import Ic.D;
import Ic.F;
import Ic.G;
import Ic.Q;
import Ic.S;
import Ic.T;
import Ic.U;
import Jc.C;
import Jc.X;
import ie.H;
import kotlin.jvm.internal.q;
import we.n;

public final class c implements n {
    public final int a;
    public final w b;

    public c(w w0, int v) {
        this.a = v;
        this.b = w0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        w w0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((X)object0), "uiState");
                w0.onUserEvent(new Q(((X)object0), ((X)object0).a.getArtistIds(), ((int)(((Integer)object1)))));
                return h0;
            }
            case 1: {
                q.g(((X)object0), "uiState");
                w0.onUserEvent(new U(((X)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 2: {
                q.g(((X)object0), "uiState");
                w0.onUserEvent(new T(((X)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 3: {
                q.g(((X)object0), "uiState");
                w0.onUserEvent(new S(((X)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 4: {
                q.g(((C)object0), "uiState");
                w0.onUserEvent(new D(((C)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 5: {
                q.g(((C)object0), "uiState");
                w0.onUserEvent(new Ic.C(((C)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 6: {
                q.g(((Jc.S)object0), "uiState");
                w0.onUserEvent(new G(((Jc.S)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            default: {
                q.g(((Jc.S)object0), "uiState");
                w0.onUserEvent(new F(((Jc.S)object0), ((int)(((Integer)object1)))));
                return h0;
            }
        }
    }
}

