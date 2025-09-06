package zd;

import H8.q;
import Pc.e;
import androidx.lifecycle.f0;
import androidx.media3.session.legacy.V;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.J4;
import com.melon.ui.K4;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n0;
import com.melon.ui.popup.context.more.b;
import ie.H;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mb.k;
import ne.a;
import oe.i;
import pb.l;
import qb.I;
import va.e0;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lzd/c0;", "Lcom/melon/ui/n0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class c0 extends n0 {
    public final I a;
    public final q b;
    public final V c;
    public final l d;
    public final StringProviderImpl e;
    public final CoroutineDispatcher f;
    public final boolean g;
    public final LogU h;
    public Q i;
    public Q j;
    public final MutableStateFlow k;
    public final StateFlow l;
    public static final int m;

    public c0(I i0, q q0, V v0, l l0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0, k k0) {
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        super();
        this.a = i0;
        this.b = q0;
        this.c = v0;
        this.d = l0;
        this.e = stringProviderImpl0;
        this.f = coroutineDispatcher0;
        this.g = ((e0)k0).m();
        LogU logU0 = new LogU("MoreListPopupViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.h = logU0;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(J4.a);
        this.k = mutableStateFlow0;
        this.l = FlowKt.asStateFlow(mutableStateFlow0);
    }

    public static final Object b(c0 c00, Flow flow0, i i0) {
        Object object0 = flow0.collect(new a0(c00), i0);
        return object0 == a.a ? object0 : H.a;
    }

    public final void c() {
        T2.a a0 = f0.h(this);
        zd.V v0 = new zd.V(this, null);
        BuildersKt__Builders_commonKt.launch$default(a0, this.f, null, v0, 2, null);
    }

    public final void d(boolean z) {
        N n0;
        K4 k40 = (K4)this.getUiState().getValue();
        if(k40 instanceof N) {
            ((N)k40).getClass();
            n0 = new N(z, ((N)k40).b);
        }
        else {
            n0 = new N(z, 0);
        }
        do {
            Object object0 = this.k.getValue();
            kotlin.jvm.internal.q.g(((K4)object0), "it");
        }
        while(!this.k.compareAndSet(object0, n0));
    }

    @Override  // com.melon.ui.n0
    public final void onUserEvent(e e0) {
        M m0;
        String s1;
        String s;
        zd.a a0 = null;
        kotlin.jvm.internal.q.g(e0, "userEvent");
        if(e0 instanceof zd.I) {
            this.c();
            return;
        }
        if(e0 instanceof z) {
            Q q0 = this.i;
            if(q0 != null) {
                K4 k40 = (K4)this.l.getValue();
                boolean z = !(k40 instanceof N) || !((N)k40).a;
                if(q0 instanceof b) {
                    T2.a a1 = f0.h(this);
                    T t0 = new T(null, q0, this, z);
                    BuildersKt__Builders_commonKt.launch$default(a1, this.f, null, t0, 2, null);
                    return;
                }
                T2.a a2 = f0.h(this);
                U u0 = new U(null, q0, this, z);
                BuildersKt__Builders_commonKt.launch$default(a2, this.f, null, u0, 2, null);
            }
        }
        else {
            if(e0 instanceof C) {
                this.sendUiEvent(new i0(((C)e0).a));
                return;
            }
            if(e0 instanceof L) {
                this.j = this.i;
                this.i = ((L)e0).a;
                this.c();
                return;
            }
            if(e0 instanceof K) {
                this.d(((K)e0).a);
                return;
            }
            if(e0 instanceof A) {
                this.sendUiEvent(new g0(((A)e0).a, ((A)e0).b, ((A)e0).c));
                return;
            }
            if(e0 instanceof F) {
                this.i = this.j;
                this.c();
                return;
            }
            if(e0 instanceof B) {
                this.sendUiEvent(h0.a);
                return;
            }
            if(e0 instanceof zd.H) {
                Q q1 = this.i;
                if(q1 instanceof q0) {
                    BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new W(this, q1, null), 2, null);
                    return;
                }
                if(q1 instanceof b) {
                    BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new X(this, q1, null), 2, null);
                    return;
                }
                if(q1 == null) {
                    s = "";
                }
                else {
                    s = q1.a();
                    if(s == null) {
                        s = "";
                    }
                }
                if(q1 == null) {
                    s1 = "N10001";
                }
                else {
                    s1 = q1.f();
                    if(s1 == null) {
                        s1 = "N10001";
                    }
                }
                if(s.length() != 0) {
                    BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new Y(this, s1, s, null), 2, null);
                }
            }
            else {
                if(e0 instanceof D) {
                    this.sendUiEvent(new j0(((D)e0).a));
                    return;
                }
                if(e0 instanceof E) {
                    this.sendUiEvent(k0.a);
                    return;
                }
                if(e0 instanceof J) {
                    Q q2 = this.i;
                    if(q2 instanceof zd.a) {
                        a0 = (zd.a)q2;
                    }
                    if(a0 == null) {
                        m0 = M.T;
                    }
                    else {
                        m0 = a0.a;
                        if(m0 == null) {
                            m0 = M.T;
                        }
                    }
                    Q q3 = this.j;
                    this.i = q3;
                    if(q3 != null) {
                        T2.a a3 = f0.h(this);
                        b0 b00 = new b0(this, q3, ((J)e0).b, ((J)e0).c, m0, null);
                        BuildersKt__Builders_commonKt.launch$default(a3, this.f, null, b00, 2, null);
                    }
                }
                else if(e0 instanceof y) {
                    this.sendUiEvent(new zd.f0(((y)e0).a, ((y)e0).b, ((y)e0).c));
                }
            }
        }
    }
}

