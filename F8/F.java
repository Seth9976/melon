package F8;

import android.view.View;
import com.iloen.melon.custom.title.TitleBar;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final TitleBar r;

    public f(TitleBar titleBar0, Continuation continuation0) {
        this.r = titleBar0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        View view0 = this.r.h;
        if(view0 != null) {
            view0.sendAccessibilityEvent(8);
            return H.a;
        }
        return null;
    }
}

