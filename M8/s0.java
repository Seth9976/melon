package m8;

import androidx.fragment.app.I;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.o;
import ne.a;
import oe.i;
import r8.f;
import va.e0;
import we.n;

public final class s0 extends i implements n {
    public final t0 B;
    public final BaseActivity D;
    public int r;
    public final String w;

    public s0(String s, t0 t00, BaseActivity baseActivity0, Continuation continuation0) {
        this.w = s;
        this.B = t00;
        this.D = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s0(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        t0 t00 = this.B;
        o o0 = t00.d;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = this.w;
                if(s != null && s.length() != 0) {
                    this.r = 1;
                    if(o0.a.a.d(s, this) == a0) {
                        return a0;
                    }
                }
                goto label_12;
            }
            case 1: {
                d5.n.D(object0);
            label_12:
                this.r = 2;
                if(((e0)t00.c).z("token expired", false, this) == a0) {
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
        BaseActivity baseActivity0 = this.D;
        I i0 = baseActivity0.getCurrentFragment();
        boolean z = o0.d();
        if(i0 instanceof LoginSimpleAccountFragment) {
            if(z) {
                Navigator.INSTANCE.openMelonLoginView(f.f);
                return H.a;
            }
            baseActivity0.onBackPressedCallback();
            return H.a;
        }
        Navigator.openLoginView(f.f);
        return H.a;
    }
}

