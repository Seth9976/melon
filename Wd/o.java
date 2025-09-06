package wd;

import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import v9.d;
import vd.G;
import we.n;

public final class o extends i implements n {
    public final t r;

    public o(t t0, Continuation continuation0) {
        this.r = t0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new o(this.r, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((o)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        f f0;
        d5.n.D(object0);
        t t0 = this.r;
        List list0 = t0.d;
        if(list0 == null || list0.isEmpty()) {
            f0 = f.a;
        }
        else {
            ArrayList arrayList0 = new ArrayList(q.Q(10, list0));
            int v = 0;
            for(Object object1: list0) {
                String s = null;
                if(v >= 0) {
                    ContextItemType contextItemType0 = ((ContextItemInfo)object1).a;
                    kotlin.jvm.internal.q.e(contextItemType0, "null cannot be cast to non-null type com.iloen.melon.types.ContextUserItemType");
                    String s1 = ((ContextItemInfo)object1).c.a;
                    if(s1 != null) {
                        s = s1;
                    }
                    String s2 = "";
                    if(s == null) {
                        s = "";
                    }
                    String s3 = ((d)contextItemType0).R;
                    if(s3 != null) {
                        s2 = s3;
                    }
                    arrayList0.add(new e(s, s2, ((d)contextItemType0).S, list0.size() - 1 == v));
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
            f0 = new g(arrayList0);
        }
        t0.updateUiState(new G(f0, 7));
        return H.a;
    }
}

