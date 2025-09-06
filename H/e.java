package H;

import I.Z0;
import J0.N;
import J0.y;
import Y.t;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import we.k;

public final class e implements PointerInputEventHandler {
    public final int a;
    public final k b;

    public e(int v, k k0) {
        this.a = v;
        this.b = k0;
        super();
    }

    @Override  // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(y y0, Continuation continuation0) {
        if(this.a != 0) {
            H h0 = ((N)y0).m0(new t(this.b, null), continuation0);
            return h0 == a.a ? h0 : H.a;
        }
        H h1 = Z0.c(y0, new f(this.b, null), continuation0);
        a a0 = a.a;
        H h2 = H.a;
        if(h1 != a0) {
            h1 = h2;
        }
        return h1 == a0 ? h1 : h2;
    }
}

