package Mc;

import F8.p;
import androidx.fragment.app.FragmentActivity;
import com.iloen.melon.utils.system.ScreenUtils;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class d extends i implements n {
    public boolean r;
    public final g w;

    public d(g g0, Continuation continuation0) {
        this.w = g0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new d(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((d)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        g g0 = this.w;
        if(!ScreenUtils.isDarkMode(g0.getContext())) {
            FragmentActivity fragmentActivity0 = g0.getActivity();
            ScreenUtils.setAppearanceLightStatusBars((fragmentActivity0 == null ? null : fragmentActivity0.getWindow()), z);
        }
        p p0 = g0.g;
        if(p0 != null) {
            p0.j(((int)z));
        }
        return H.a;
    }
}

