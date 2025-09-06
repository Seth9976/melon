package kc;

import com.iloen.melon.playback.Playable;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class k2 extends i implements n {
    public final r2 B;
    public final boolean D;
    public Object r;
    public final List w;

    public k2(List list0, r2 r20, Continuation continuation0, boolean z) {
        this.w = list0;
        this.B = r20;
        this.D = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new k2(this.w, this.B, continuation0, this.D);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        d5.n.D(object0);
        for(Object object1: this.w) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new j2(((Playable)object1), this.B, this.D, null), 3, null);
        }
        return H.a;
    }
}

