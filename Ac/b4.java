package Ac;

import F8.A;
import a1.t;
import androidx.compose.runtime.b0;
import f1.x;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import w0.p;
import we.n;

public final class b4 extends i implements n {
    public final b0 B;
    public final l4 D;
    public final p r;
    public final h4 w;

    public b4(p p0, h4 h40, b0 b00, l4 l40, Continuation continuation0) {
        this.r = p0;
        this.w = h40;
        this.B = b00;
        this.D = l40;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b4(this.r, this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((b4)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        p.b(this.r);
        b0 b00 = this.B;
        boolean z = ((x)b00.getValue()).a.b.length() > 0;
        A a0 = this.w.e;
        if(a0 != null) {
            a0.j(z);
        }
        int v = this.D.a.length();
        long v1 = t.b(v, v);
        b00.setValue(new x(this.D.a, v1, 4));
        return H.a;
    }
}

