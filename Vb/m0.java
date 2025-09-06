package Vb;

import b3.E;
import b3.G;
import b3.s;
import com.iloen.melon.player.playlist.mixup.composables.c;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public final G B;
    public final o0 r;
    public final E w;

    public m0(o0 o00, E e0, G g0, Continuation continuation0) {
        this.r = o00;
        this.w = e0;
        this.B = g0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m0(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((m0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        o0 o00 = this.r;
        o00.getClass();
        o00.B0();
        E e0 = o00.W();
        if(e0 != null) {
            s s0 = this.w.a();
            s0.k = this.B;
            E e1 = s0.a();
            if(q.b(e1, E.g)) {
                LogU.debug$default(o00.l, "updateCurrentMediaItem() MediaItem.EMPTY", null, false, 6, null);
                return H.a;
            }
            o00.N0(new c(o00, e0, e1, 8));
            o00.v0();
        }
        return H.a;
    }
}

