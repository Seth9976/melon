package sc;

import com.iloen.melon.utils.MelonSettingInfo;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class e0 extends i implements n {
    public final boolean B;
    public int r;
    public final P0 w;

    public e0(Continuation continuation0, P0 p00, boolean z) {
        this.w = p00;
        this.B = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new e0(continuation0, this.w, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((e0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        boolean z = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                d0 d00 = new d0(z, null);
                this.r = 1;
                object0 = this.w.e0(d00, this);
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
        g1 g10 = (g1)object0;
        MelonSettingInfo.setOfflineModeSP(z);
        return object0;
    }
}

