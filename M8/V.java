package m8;

import A8.j;
import A8.l;
import com.iloen.melon.activity.BaseActivity;
import ie.H;
import ie.p;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.f;
import mb.k;
import ne.a;
import oe.i;
import we.n;

public final class v extends i implements n {
    public final BaseActivity B;
    public final j D;
    public final k E;
    public int r;
    public final f w;

    public v(f f0, BaseActivity baseActivity0, j j0, k k0, Continuation continuation0) {
        this.w = f0;
        this.B = baseActivity0;
        this.D = j0;
        this.E = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new v(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((v)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        f f0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(f0.b(this.B, this.D, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                ((p)object0).getClass();
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        l l0 = f0.a.c();
        if(l0 != null) {
            this.r = 2;
            if(k.b(this.E, l0, this) == a0) {
                return a0;
            }
        }
        return H.a;
    }
}

