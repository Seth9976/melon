package androidx.compose.foundation;

import K.l;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class h extends i implements n {
    public final j r;

    public h(j j0, Continuation continuation0) {
        this.r = j0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((h)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        j j0 = this.r;
        if(j0.m == null) {
            K.h h0 = new K.h();  // 初始化器: Ljava/lang/Object;-><init>()V
            l l0 = j0.c;
            if(l0 != null) {
                BuildersKt__Builders_commonKt.launch$default(j0.getCoroutineScope(), null, null, new a(l0, h0, null), 3, null);
            }
            j0.m = h0;
        }
        return H.a;
    }
}

