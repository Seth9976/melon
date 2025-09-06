package l8;

import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.popup.FullscreenProgressDialog;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class k extends i implements n {
    public final BaseActivity r;
    public final String w;

    public k(BaseActivity baseActivity0, String s, Continuation continuation0) {
        this.r = baseActivity0;
        this.w = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        BaseActivity baseActivity0 = this.r;
        if(!baseActivity0.isFinishing()) {
            FullscreenProgressDialog fullscreenProgressDialog0 = new FullscreenProgressDialog(baseActivity0);
            fullscreenProgressDialog0.setCancelable(false);
            fullscreenProgressDialog0.setText(this.w);
            fullscreenProgressDialog0.show();
            baseActivity0.fullscreenProgressDialog = fullscreenProgressDialog0;
        }
        return H.a;
    }
}

