package G8;

import E9.w;
import H8.c;
import H8.g;
import H8.t;
import Tf.o;
import a.a;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.utils.log.LogConstantsKt;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.q;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import w7.d;
import we.n;

public final class k extends i implements n {
    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new k(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((k)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        long v = System.currentTimeMillis();
        d d0 = G8.i.a;
        d0.f();
        Iterable iterable0 = (List)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new g(4));
        ArrayList arrayList0 = new ArrayList();
        for(Object object1: iterable0) {
            if(o.H0(((t)object1).e)) {
                arrayList0.add(object1);
            }
        }
        H h0 = H.a;
        if(!arrayList0.isEmpty()) {
            G8.g.a.m();
            ArrayList arrayList1 = new ArrayList(q.Q(10, arrayList0));
            for(Object object2: arrayList0) {
                arrayList1.add(((t)object2).f);
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = p.Q0(arrayList1);
            while(!arrayList3.isEmpty()) {
                List list0 = A7.d.p(arrayList3, 500, arrayList3);
                arrayList3.removeAll(list0);
                H8.i i0 = G8.g.g();
                i0.getClass();
                StringBuilder stringBuilder0 = Y.p("SELECT * FROM local_contents WHERE display_name in (");
                a.k(list0.size(), stringBuilder0);
                stringBuilder0.append(")");
                arrayList2.addAll(((List)w.N(((LocalContentDatabase_Impl)i0.b), true, false, new c(stringBuilder0.toString(), 3, list0))));
            }
            ArrayList arrayList4 = new ArrayList(q.Q(10, arrayList0));
            for(Object object3: arrayList0) {
                t t0 = (t)object3;
                for(Object object4: arrayList2) {
                    if(!kotlin.jvm.internal.q.b(((H8.k)object4).d, t0.f)) {
                        continue;
                    }
                    goto label_44;
                }
                object4 = null;
            label_44:
                if(((H8.k)object4) != null) {
                    String s = ((H8.k)object4).c;
                    t0.getClass();
                    kotlin.jvm.internal.q.g(s, "<set-?>");
                    t0.e = s;
                }
                arrayList4.add(h0);
            }
            d0.f();
            G8.i.f(arrayList0);
        }
        LogConstantsKt.debug(l.a, "updateLocalPlaylist() " + arrayList0.size() + " file(s) updated", v);
        return h0;
    }
}

