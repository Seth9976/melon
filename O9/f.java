package O9;

import N9.b;
import N9.c;
import androidx.lifecycle.f0;
import com.melon.ui.K4;
import ie.H;
import ie.o;
import ie.p;
import jd.A2;
import jd.M0;
import jd.N;
import jd.l0;
import jd.t;
import jd.z0;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class f extends i implements n {
    public final g B;
    public int r;
    public Object w;

    public f(g g0, Continuation continuation0) {
        this.B = g0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new f(this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        c c1;
        Object object1;
        CoroutineScope coroutineScope0;
        a a0 = a.a;
        g g0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                g0.i = 0;
                coroutineScope0 = (CoroutineScope)this.w;
                break;
            }
            case 1: {
                coroutineScope0 = (CoroutineScope)this.w;
                try {
                    d5.n.D(object0);
                    object1 = object0;
                    goto label_22;
                }
                catch(Throwable throwable0) {
                    goto label_25;
                }
            }
            case 2: {
                CoroutineScope coroutineScope1 = (CoroutineScope)this.w;
                d5.n.D(object0);
                coroutineScope0 = coroutineScope1;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(CoroutineScopeKt.isActive(coroutineScope0)) {
            g0.e.invoke(b.b);
            try {
                O9.c c0 = (O9.c)g0.c.invoke();
                this.w = coroutineScope0;
                this.r = 1;
                object1 = ((t)g0.a).a(c0, this);
                if(object1 == a0) {
                    return a0;
                }
            label_22:
                c1 = (c)object1;
            }
            catch(Throwable throwable0) {
            label_25:
                c1 = d5.n.t(throwable0);
            }
            if(!(c1 instanceof o)) {
                g0.i = 0;
                g0.e.invoke(b.d);
                g0.h = c1.c * 1000L;
                g0.d.invoke(c1);
                M0 m00 = g0.f;
                if(m00 != null) {
                    A2 a20 = c1.f;
                    m00.p.setValue(a20.a);
                    m00.q = a20.b;
                    m00.t = a20.c;
                    m00.s = a20.c == null ? false : a20.c.contains("");
                    K4 k40 = (K4)m00.getUiState().getValue();
                    if(k40 instanceof N) {
                        m00.updateUiState(new l0(((N)k40), m00, 0));
                    }
                    String s = a20.d.a;
                    if(s != null && s.length() != 0 && !s.equals(m00.u)) {
                        m00.u = s;
                        m00.b.s();
                        m00.l();
                    }
                    BuildersKt__Builders_commonKt.launch$default(f0.h(m00), Dispatchers.getDefault(), null, new z0(m00, a20.e.a, null), 2, null);
                }
            }
            if(p.a(c1) != null) {
                int v = g0.i + 1;
                g0.i = v;
                if(v >= 5) {
                    g0.e.invoke(b.c);
                    CoroutineScopeKt.cancel$default(coroutineScope0, "retry count exceeded", null, 2, null);
                }
            }
            this.w = coroutineScope0;
            this.r = 2;
            if(DelayKt.delay(g0.h, this) != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

