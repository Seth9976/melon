package m8;

import android.text.TextUtils;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.utils.Navigator;
import com.melon.ui.popup.b;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mb.k;
import ne.a;
import oe.i;
import r8.f;
import va.e0;
import we.n;

public final class q0 extends i implements n {
    public final BaseActivity B;
    public int r;
    public final r0 w;

    public q0(r0 r00, BaseActivity baseActivity0, Continuation continuation0) {
        this.w = r00;
        this.B = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new q0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        r0 r00 = this.w;
        k k0 = r00.c;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Flow flow0 = ((e0)k0).k();
                this.r = 1;
                if(FlowKt.first(flow0, this) == a0) {
                    return a0;
                }
                goto label_11;
            }
            case 1: {
                d5.n.D(object0);
            label_11:
                q.d("");
                this.r = 2;
                if(r00.d.a.a.d("", this) == a0) {
                    return a0;
                }
                goto label_16;
            }
            case 2: {
                d5.n.D(object0);
            label_16:
                this.r = 3;
                if(((e0)k0).z("token expired", false, this) == a0) {
                    return a0;
                }
                break;
            }
            case 3: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        BaseActivity baseActivity0 = this.B;
        baseActivity0.goToHome();
        Navigator.openLoginView(f.f);
        String s = r00.c1().getQueryParameter("message");
        if(!TextUtils.isEmpty(s)) {
            b.d(b.a, baseActivity0.getSupportFragmentManager(), "안내", s, false, false, false, "확인", null, null, null, null, 0x7B8);
        }
        return H.a;
    }
}

