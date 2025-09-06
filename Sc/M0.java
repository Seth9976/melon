package sc;

import com.iloen.melon.playback.Playable;
import e1.b;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.CoroutineScope;
import lc.h;
import ne.a;
import oe.i;
import we.n;

public final class m0 extends i implements n {
    public final List B;
    public final C D;
    public final boolean E;
    public int r;
    public final P0 w;

    public m0(P0 p00, List list0, C c0, boolean z, Continuation continuation0) {
        this.w = p00;
        this.B = list0;
        this.D = c0;
        this.E = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new m0(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        P0 p00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                l0 l00 = new l0(p00, this.B, this.D, null);
                this.r = 1;
                object0 = p00.e0(l00, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(this.E) {
            p00.s.getClass();
            ArrayList arrayList0 = h.h(((g1)object0));
            p00.d.h(arrayList0);
            Playable playable0 = b.y(((g1)object0));
            p00.d.e(playable0, "selectRepeat");
            p00.d.f(p00.m, "selectRepeat");
        }
        return object0;
    }
}

