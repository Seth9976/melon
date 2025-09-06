package Ub;

import Dc.i;
import Qb.x;
import Qb.y;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.playback.manager.CastHelper;
import com.melon.playback.manager.DlnaHelper;
import e.k;
import hc.f;
import hc.g;
import hc.h;
import hc.u;
import hc.v;
import hc.w;
import i.n.i.b.a.s.e.M3;
import ic.a;
import ic.b;
import ic.c;
import ic.e;
import ie.m;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;

public final class t implements s {
    public final z a;
    public final CastHelper b;
    public final DlnaHelper c;
    public final LogU d;
    public final List e;
    public final MutableStateFlow f;
    public final StateFlow g;
    public final MutableStateFlow h;
    public final StateFlow i;

    public t(z z0, CastHelper castHelper0, DlnaHelper dlnaHelper0) {
        q.g(castHelper0, "castHelper");
        q.g(dlnaHelper0, "dlnaHelper");
        super();
        this.a = z0;
        this.b = castHelper0;
        this.c = dlnaHelper0;
        this.d = Companion.create$default(LogU.Companion, "RemotePlayerManager", false, Category.Playback, 2, null);
        this.e = k.A(new r[]{castHelper0, dlnaHelper0});
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(a.a);
        this.f = mutableStateFlow0;
        this.g = FlowKt.asStateFlow(mutableStateFlow0);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(null);
        this.h = mutableStateFlow1;
        this.i = FlowKt.asStateFlow(mutableStateFlow1);
    }

    public final void a(String s) {
        switch(((a)this.g.getValue()).ordinal()) {
            case 2: {
                this.b.f(s, null);
                return;
            }
            case 3: {
                this.c.g(s, null);
                return;
            }
            default: {
                LogU.debug$default(this.d, "disconnect() - already disconnected", null, false, 6, null);
            }
        }
    }

    public final double b() {
        if(!this.c()) {
            LogU.debug$default(this.d, "not connected cast device", null, false, 6, null);
            return 0.0;
        }
        this.b.getClass();
        d d0 = new d(this.b, 5);
        return ((Number)this.b.i(d0)).doubleValue();
    }

    public final boolean c() {
        return this.g.getValue() == a.c;
    }

    public final boolean d() {
        if(!this.c()) {
            this.b.getClass();
            d d0 = new d(this.b, 6);
            return ((Boolean)this.b.i(d0)).booleanValue();
        }
        return true;
    }

    public final boolean e() {
        return this.g.getValue() == a.d;
    }

    // 去混淆评级： 低(20)
    public final boolean f() {
        return this.c() || this.e();
    }

    // 去混淆评级： 低(20)
    public final boolean g() {
        return this.d() || this.e();
    }

    public final boolean h(e e0) {
        q.g(e0, "device");
        if(e0 instanceof b) {
            this.b.getClass();
            i i0 = new i(17, ((b)e0), this.b);
            return ((Boolean)this.b.i(i0)).booleanValue();
        }
        if(e0 instanceof c) {
            this.c.getClass();
            return q.b(this.c.i(), ((c)e0).a);
        }
        return false;
    }

    public final void i(hc.i i0) {
        m m0;
        Qb.z z0 = this.a.e;
        w w0 = i0.a;
        LogU logU0 = this.d;
        LogU.debug$default(logU0, "onConnectionResult() result: " + i0, null, false, 6, null);
        h h0 = i0.b;
        MutableStateFlow mutableStateFlow0 = this.f;
        if(h0 instanceof f) {
            do {
                Object object0 = mutableStateFlow0.getValue();
                q.g(((a)object0), "it");
                LogConstantsKt.debugOnlyDebugMode(logU0, "updateConnectionState() " + ((a)object0) + " -> " + a.b + ", reason: " + ("Connecting " + w0));
            }
            while(!mutableStateFlow0.compareAndSet(object0, a.b));
        }
        else {
            MutableStateFlow mutableStateFlow1 = this.h;
            if(h0 instanceof hc.e) {
                if(w0 instanceof hc.t) {
                    this.b.getClass();
                    d d0 = new d(this.b, 0);
                    String s = (String)this.b.i(d0);
                    m0 = new m(a.c, s);
                }
                else if(w0 instanceof u) {
                    M8.a a0 = this.c.i();
                    m0 = new m(a.d, (a0 == null ? null : a0.a.l));
                }
                else if(w0 instanceof v) {
                    m0 = new m(a.a, null);
                }
                else {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                a a1 = (a)m0.a;
                String s1 = (String)m0.b;
                do {
                    Object object1 = mutableStateFlow0.getValue();
                    q.g(((a)object1), "previous");
                    LogConstantsKt.debugOnlyDebugMode(logU0, "updateConnectionState() " + ((a)object1) + " -> " + a1 + ", reason: " + ("Connected " + w0));
                }
                while(!mutableStateFlow0.compareAndSet(object1, a1));
                mutableStateFlow1.setValue(s1);
                goto label_41;
            }
            if(!(h0 instanceof g)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            do {
                Object object2 = mutableStateFlow0.getValue();
                q.g(((a)object2), "it");
                LogConstantsKt.debugOnlyDebugMode(logU0, "updateConnectionState() " + ((a)object2) + " -> " + a.a + ", reason: " + ("Disconnected " + w0));
            }
            while(!mutableStateFlow0.compareAndSet(object2, a.a));
            mutableStateFlow1.setValue(null);
        }
    label_41:
        hc.d d1 = i0.c;
        if(d1 instanceof hc.b) {
            LogU.info$default(z0.h, "stopAndPlay()", null, false, 6, null);
            z0.f(new y(2, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            return;
        }
        if(d1 instanceof hc.c) {
            LogU.info$default(z0.h, "stop()", null, false, 6, null);
            z0.f(new x(2, null));  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        }
    }

    public final void j(double f) {
        LogU.debug$default(this.d, "setCastVolume() volume: " + f, null, false, 6, null);
        CastHelper castHelper0 = this.b;
        if(Double.compare(f, 0.0) <= 0) {
            castHelper0.getClass();
            castHelper0.i(new d(castHelper0, 1));
        }
        castHelper0.getClass();
        castHelper0.i(new Ub.e(castHelper0, f));
    }

    public final void k(int v) {
        DlnaHelper dlnaHelper0 = this.c;
        if(v >= 0 && v <= dlnaHelper0.d) {
            L8.s s0 = dlnaHelper0.i;
            if(s0 == null) {
                LogU.warn$default(dlnaHelper0.b, "setVolume() error: controller is null", null, false, 6, null);
                return;
            }
            if(s0.j) {
                LogU.warn$default(dlnaHelper0.b, "setVolume(): volume is muted", null, false, 6, null);
            }
            L8.s.h(s0, v);
            return;
        }
        LogU.warn$default(dlnaHelper0.b, "setVolume() error - volume must be between 0 and 65535: " + (dlnaHelper0.i == null ? 0 : dlnaHelper0.i.i), null, false, 6, null);
    }
}

