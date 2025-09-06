package l8;

import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.popup.FullscreenProgressDialog;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class g extends i implements n {
    public final BaseActivity r;

    public g(BaseActivity baseActivity0, Continuation continuation0) {
        this.r = baseActivity0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        BaseActivity baseActivity0 = this.r;
        FullscreenProgressDialog fullscreenProgressDialog0 = baseActivity0.fullscreenProgressDialog;
        if(fullscreenProgressDialog0 != null) {
            if(fullscreenProgressDialog0.isShowing()) {
                fullscreenProgressDialog0.dismiss();
            }
            baseActivity0.fullscreenProgressDialog = null;
        }
        return H.a;
    }
}

