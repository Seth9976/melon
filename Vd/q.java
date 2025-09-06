package vd;

import J0.N;
import J0.y;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import ie.H;
import kotlin.coroutines.Continuation;
import ne.a;
import we.k;

public final class q implements PointerInputEventHandler {
    public final k a;
    public final b0 b;
    public final b0 c;
    public final a0 d;

    public q(k k0, b0 b00, b0 b01, a0 a00) {
        this.a = k0;
        this.b = b00;
        this.c = b01;
        this.d = a00;
    }

    @Override  // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(y y0, Continuation continuation0) {
        Object object0 = ((N)y0).m0(new p(this.a, this.b, this.c, this.d, null), continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

