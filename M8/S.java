package m8;

import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.k;
import ne.a;
import oe.i;
import r8.f;
import va.e0;
import we.n;

public final class s extends i implements n {
    public final BaseActivity B;
    public int r;
    public final k w;

    public s(k k0, BaseActivity baseActivity0, Continuation continuation0) {
        this.w = k0;
        this.B = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(((e0)this.w).z("melonapp://kakao/logout", true, this) == a0) {
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
        this.B.goToHome();
        Navigator.openLoginView(f.f);
        return H.a;
    }
}

