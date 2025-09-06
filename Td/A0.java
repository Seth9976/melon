package td;

import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class a0 extends i implements n {
    public final b0 r;
    public final v1 w;

    public a0(b0 b00, v1 v10, Continuation continuation0) {
        this.r = b00;
        this.w = v10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a0(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((a0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        b0 b00 = this.r;
        z z0 = b00.n;
        if(z0 != null) {
            LogU.debug$default(z0.a, "updateData current=" + this.w.a + ", prev=" + this.w.b + ", next=" + this.w.c, null, false, 6, null);
            z0.e[z0.c] = this.w.a;
            z0.e[0] = this.w.b;
            z0.e[z0.d] = this.w.c;
        }
        z z1 = b00.n;
        if(z1 != null) {
            z1.a(b00.o);
        }
        return H.a;
    }
}

