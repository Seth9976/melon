package m8;

import A8.l;
import A8.u;
import android.text.TextUtils;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.f;
import mb.k;
import ne.a;
import oe.i;
import va.e0;
import va.h0;
import va.i0;
import we.n;

public final class r extends i implements n {
    public final BaseActivity B;
    public final String D;
    public final f E;
    public final k G;
    public int r;
    public final o w;

    public r(o o0, BaseActivity baseActivity0, String s, f f0, k k0, Continuation continuation0) {
        this.w = o0;
        this.B = baseActivity0;
        this.D = s;
        this.E = f0;
        this.G = k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.w, this.B, this.D, this.E, this.G, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        BaseActivity baseActivity0 = this.B;
        o o0 = this.w;
        String s = this.D;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                o0.s1(baseActivity0);
                u u0 = TextUtils.isEmpty(s) ? u.d : u.c;
                l l0 = this.E.a.c();
                this.r = 1;
                object0 = ((e0)this.G).u(l0, u0, this);
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
        o0.r1();
        if(((i0)object0) instanceof h0) {
            if(TextUtils.isEmpty(s)) {
                baseActivity0.goToHome();
                return H.a;
            }
            Navigator.openUrl(s, OpenType.FullScreen);
        }
        return H.a;
    }
}

