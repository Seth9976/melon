package m8;

import Qd.e;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.f;
import mb.k;
import ne.a;
import oe.i;
import va.e0;
import we.n;

public final class y extends i implements n {
    public final f B;
    public final e D;
    public final BaseActivity E;
    public int r;
    public final k w;

    public y(e e0, BaseActivity baseActivity0, Continuation continuation0, f f0, k k0) {
        this.w = k0;
        this.B = f0;
        this.D = e0;
        this.E = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.D, this.E, continuation0, this.B, this.w);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        f f0 = this.B;
        k k0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(((e0)k0).z("melon logout and kakao login scheme", true, this) == a0) {
                    return a0;
                }
                goto label_10;
            }
            case 1: {
                d5.n.D(object0);
            label_10:
                Navigator.openLoginView(r8.f.f);
                this.r = 2;
                if(f0.d(this) == a0) {
                    return a0;
                }
                break;
            }
            case 2: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        u u0 = new u(f0, this.E, k0, 1);
        this.D.a(u0);
        return H.a;
    }
}

