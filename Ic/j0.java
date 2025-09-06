package Ic;

import Jc.C;
import Jc.X;
import ie.H;
import kotlin.jvm.internal.q;
import we.n;

public final class j0 implements n {
    public final int a;
    public final A0 b;

    public j0(A0 a00, int v) {
        this.a = v;
        this.b = a00;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        H h0 = H.a;
        A0 a00 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((X)object0), "uiState");
                a00.onUserEvent(new U(((X)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 1: {
                q.g(((X)object0), "uiState");
                a00.onUserEvent(new T(((X)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 2: {
                q.g(((X)object0), "uiState");
                a00.onUserEvent(new S(((X)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 3: {
                q.g(((Jc.S)object0), "uiState");
                a00.onUserEvent(new G(((Jc.S)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 4: {
                q.g(((Jc.S)object0), "uiState");
                a00.onUserEvent(new F(((Jc.S)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            case 5: {
                q.g(((C)object0), "uiState");
                a00.onUserEvent(new D(((C)object0), ((int)(((Integer)object1)))));
                return h0;
            }
            default: {
                q.g(((C)object0), "uiState");
                a00.onUserEvent(new Ic.C(((C)object0), ((int)(((Integer)object1)))));
                return h0;
            }
        }
    }
}

