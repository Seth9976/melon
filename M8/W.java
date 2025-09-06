package m8;

import Qd.e;
import com.iloen.melon.activity.BaseActivity;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.f;
import mb.k;
import ne.a;
import oe.i;
import we.n;

public final class w extends i implements n {
    public final e B;
    public final BaseActivity D;
    public final k E;
    public int r;
    public final f w;

    public w(e e0, BaseActivity baseActivity0, Continuation continuation0, f f0, k k0) {
        this.w = f0;
        this.B = e0;
        this.D = baseActivity0;
        this.E = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new w(this.B, this.D, continuation0, this.w, this.E);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((w)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        f f0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(f0.d(this) == a0) {
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
        u u0 = new u(f0, this.D, this.E, 0);
        this.B.a(u0);
        return H.a;
    }
}

