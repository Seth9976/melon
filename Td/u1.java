package td;

import H8.q;
import I7.c;
import Ua.h;
import Ua.n;
import androidx.lifecycle.c0;
import androidx.media3.session.legacy.V;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.n4;
import com.melon.ui.t3;
import d5.i;
import eb.y;
import ge.b;
import hc.l;
import kc.s2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mb.k;
import ob.a;
import ob.z;
import qb.I;
import qd.W;
import wc.w;
import wc.x;
import wd.t;
import xd.r;
import yc.E;

public abstract class u1 implements b {
    public static t1 a(c0 c00, CoroutineDispatcher coroutineDispatcher0, CoroutineDispatcher coroutineDispatcher1, CoroutineDispatcher coroutineDispatcher2, StringProviderImpl stringProviderImpl0, s2 s20, z z0, a a0, l l0, k k0, V v0, Q q0, t3 t30, b3 b30, n4 n40, W w0) {
        return new t1(c00, coroutineDispatcher0, coroutineDispatcher1, coroutineDispatcher2, stringProviderImpl0, s20, z0, a0, l0, k0, v0, q0, t30, b30, n40, w0);
    }

    public static w b(h h0, c c0, q q0, k k0, n4 n40, t3 t30, b3 b30, y y0, Q q1, n n0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0) {
        return new w(h0, c0, q0, k0, n40, t30, b30, y0, q1, n0, stringProviderImpl0, coroutineDispatcher0);
    }

    public static x c(h h0, c c0, q q0, k k0, n4 n40, t3 t30, b3 b30, y y0, Q q1, n n0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0) {
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        x x0 = new x(h0, c0, q0, k0, n40, t30, b30, y0, q1, n0, stringProviderImpl0, coroutineDispatcher0);  // 初始化器: Lwc/w;-><init>(LUa/h;LI7/c;LH8/q;Lmb/k;Lcom/melon/ui/n4;Lcom/melon/ui/t3;Lcom/melon/ui/b3;Leb/y;Lcom/melon/ui/Q;LUa/n;Lcom/melon/ui/interfaces/StringProviderImpl;Lkotlinx/coroutines/CoroutineDispatcher;)V
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        x0.z = mutableStateFlow0;
        x0.A = FlowKt.asStateFlow(mutableStateFlow0);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(0.0f);
        x0.B = mutableStateFlow1;
        x0.C = FlowKt.asStateFlow(mutableStateFlow1);
        return x0;
    }

    public static t d(i i0, StringProviderImpl stringProviderImpl0) {
        return new t(i0, stringProviderImpl0);
    }

    public static r e(x9.c c0, q q0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0) {
        return new r(c0, q0, stringProviderImpl0, coroutineDispatcher0);
    }

    public static E f(c c0, Q q0, t3 t30, b3 b30, n4 n40) {
        return new E(c0, q0, t30, b30, n40);
    }

    public static zd.c0 g(I i0, q q0, V v0, pb.l l0, StringProviderImpl stringProviderImpl0, CoroutineDispatcher coroutineDispatcher0, k k0) {
        return new zd.c0(i0, q0, v0, l0, stringProviderImpl0, coroutineDispatcher0, k0);
    }
}

