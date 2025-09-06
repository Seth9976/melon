package l8;

import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import com.iloen.melon.activity.BaseActivity;
import com.melon.ui.popup.b;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import sd.j;
import vd.e;
import we.n;

public final class h extends i implements n {
    public boolean r;
    public final BaseActivity w;

    public h(BaseActivity baseActivity0, Continuation continuation0) {
        this.w = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new h(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((h)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        BaseActivity baseActivity0 = this.w;
        e e0 = null;
        if(z) {
            l0 l00 = baseActivity0.getSupportFragmentManager();
            if(l00 != null && !l00.T() && !l00.K) {
                l00.C();
                if(b.b(l00, "BlockingProgressDialogFragment", null, new j(7), 4) == null) {
                    e e1 = new e();
                    e1.f = null;
                    e1.showNow(l00, "BlockingProgressDialogFragment");
                    return H.a;
                }
            }
        }
        else {
            l0 l01 = baseActivity0.getSupportFragmentManager();
            if(l01 != null && !l01.T() && !l01.K) {
                l01.C();
                w w0 = b.b(l01, "BlockingProgressDialogFragment", null, null, 12);
                if(w0 != null) {
                    if(w0 instanceof e) {
                        e0 = (e)w0;
                    }
                    if(e0 != null) {
                        e0.dismissAllowingStateLoss();
                    }
                }
            }
        }
        return H.a;
    }
}

