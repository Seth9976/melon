package m8;

import com.iloen.melon.activity.BaseActivity;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.f;
import ne.a;
import oe.i;
import we.n;

public final class p extends i implements n {
    public final boolean B;
    public final BaseActivity D;
    public int r;
    public final f w;

    public p(f f0, boolean z, BaseActivity baseActivity0, Continuation continuation0) {
        this.w = f0;
        this.B = z;
        this.D = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(this.w.d(this) == a0) {
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
        if(this.B) {
            this.D.onBackPressedCallback();
        }
        return H.a;
    }
}

