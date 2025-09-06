package wc;

import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.k1;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class s extends i implements n {
    public boolean r;
    public final w w;

    public s(w w0, Continuation continuation0) {
        this.w = w0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new s(this.w, continuation0);
        continuation1.r = ((Boolean)object0).booleanValue();
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((Boolean)object0).booleanValue();
        ((s)this.create(((Boolean)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        boolean z = this.r;
        d5.n.D(object0);
        LogU logU0 = new LogU("AlbumDetailViewModel");
        logU0.setCategory(Category.Login);
        logU0.setUseThreadInfo(true);
        LogU.debug$default(logU0, "AlbumDetailViewModel - isLogin: " + z, null, false, 6, null);
        k1.startFetch$default(this.w, true, null, null, 6, null);
        return H.a;
    }
}

