package nc;

import com.iloen.melon.playback.Playable;
import e1.b;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.C;
import kotlinx.coroutines.CoroutineScope;
import lc.h;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public final List B;
    public final C D;
    public final boolean E;
    public int r;
    public final u0 w;

    public j0(u0 u00, List list0, C c0, boolean z, Continuation continuation0) {
        this.w = u00;
        this.B = list0;
        this.D = c0;
        this.E = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j0(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        String s = null;
        u0 u00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                i0 i00 = new i0(u00, this.B, this.D, null);
                this.r = 1;
                object0 = u00.U("setSelectRepeatInternal", i00, this);
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
            B0 b00 = u00.b;
            u00.m.getClass();
            b00.f(h.g(((C0)object0)));
            Playable playable0 = b.y(((C0)object0));
            if(playable0 != null) {
                s = playable0.getContentId();
            }
            if(s == null) {
                s = "";
            }
            b00.d(s, "setSelectRepeatInternal");
            b00.e(u00.i, "setSelectRepeatInternal");
        }
        return object0;
    }
}

