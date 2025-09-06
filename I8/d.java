package I8;

import android.content.Context;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class d extends i implements n {
    public final Context r;
    public final ArrayList w;

    public d(Context context0, ArrayList arrayList0, Continuation continuation0) {
        this.r = context0;
        this.w = arrayList0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        e.c(this.r, this.w);
        return H.a;
    }
}

