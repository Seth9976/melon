package Cc;

import G.e;
import G.x0;
import com.melon.ui.common.composable.PlayBgColorData;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class k2 extends i implements n {
    public final PlayBgColorData B;
    public final x0 D;
    public final x0 E;
    public final List G;
    public final boolean I;
    public int r;
    public final e w;

    public k2(e e0, PlayBgColorData playBgColorData0, x0 x00, x0 x01, List list0, boolean z, Continuation continuation0) {
        this.w = e0;
        this.B = playBgColorData0;
        this.D = x00;
        this.E = x01;
        this.G = list0;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k2(this.w, this.B, this.D, this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((k2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                return u2.c(this.w, new Integer(1), 10000L, this.B, this.D, this.E, this.G, this.I, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

