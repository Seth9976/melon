package jd;

import Cc.c1;
import Cc.e0;
import P0.h;
import P0.i;
import P0.j;
import P0.k;
import android.content.Context;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.a;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import com.melon.ui.musicwave.ChannelInfoData;
import hd.U1;
import ie.H;
import kd.G;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import r0.q;
import we.n;
import y0.M;

public final class u implements n {
    public final int a;
    public final K4 b;
    public final A c;

    public u(K4 k40, A a0) {
        this.a = 1;
        super();
        this.b = k40;
        this.c = a0;
    }

    public u(A a0, K4 k40) {
        this.a = 0;
        super();
        this.c = a0;
        this.b = k40;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        V v6;
        MutableStateFlow mutableStateFlow4;
        MutableStateFlow mutableStateFlow3;
        Flow flow1;
        A a3;
        H h0 = H.a;
        boolean z = true;
        K4 k40 = this.b;
        if(this.a != 0) {
            int v = (int)(((Integer)object1));
            p p0 = (p)(((l)object0));
            if(p0.Q(v & 1, (v & 3) != 2)) {
                Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
                q q0 = androidx.compose.foundation.q.f(a.n(e0.X(r0.n.a, context0, p0), 0.0f, 48.0f, 0.0f, 0.0f, 13).then(d.c), e0.T(p0, 0x7F060171), M.a);  // color:gray990e
                N0.M m0 = M.p.d(r0.d.a, false);
                int v1 = p0.P;
                i0 i00 = p0.m();
                q q1 = r0.a.d(p0, q0);
                k.y.getClass();
                i i0 = j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, j.f);
                w.x(p0, i00, j.e);
                h h1 = j.g;
                if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                    A7.d.q(v1, p0, v1, h1);
                }
                w.x(p0, q1, j.d);
                we.a a0 = this.c.getDefaultNetworkErrorHandle().a();
                we.a a1 = this.c.getDefaultNetworkErrorHandle().b();
                c1.w(((L)k40).a, a0, a1, 0.0f, 0.0f, p0, 0, 24);
                p0.p(true);
                return h0;
            }
            p0.T();
            return h0;
        }
        int v2 = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
            LogU logU0 = A.k;
            A a2 = this.c;
            LogU.debug$default(logU0, "renderUi: channel pos = " + ((M0)a2.getViewModel()).j + " Success = " + k40, null, false, 6, null);
            a2.j = StateFlowKt.MutableStateFlow(d9.j.b(("MusicWaveChannelDetailFragment" + ((M0)a2.getViewModel()).j)));
            b0 b00 = ((p)(((l)object0))).N();
            V v3 = androidx.compose.runtime.k.a;
            if(b00 == v3) {
                b00 = w.s(Boolean.FALSE);
                ((p)(((l)object0))).l0(b00);
            }
            int v4 = ((Number)B.a.r(((u1)a2.i.getValue()).l, ((p)(((l)object0))), 0).getValue()).intValue();
            int v5 = ((M0)a2.getViewModel()).j;
            ChannelInfoData channelInfoData0 = ((M0)a2.getViewModel()).g();
            StringBuilder stringBuilder0 = o.t(v4, v5, "currentChannelPosition = ", " viewModel.channelPosition = ", " title = ");
            stringBuilder0.append(channelInfoData0.b);
            LogU.debug$default(logU0, stringBuilder0.toString(), null, false, 6, null);
            if(v4 != ((M0)a2.getViewModel()).j) {
                z = false;
            }
            b00.setValue(Boolean.valueOf(z));
            MutableStateFlow mutableStateFlow0 = a2.j;
            StateFlow stateFlow0 = ((M0)a2.getViewModel()).x;
            StateFlow stateFlow1 = ((M0)a2.getViewModel()).y;
            MutableStateFlow mutableStateFlow1 = ((M0)a2.getViewModel()).p;
            MutableStateFlow mutableStateFlow2 = ((M0)a2.getViewModel()).F;
            Flow flow0 = ((M0)a2.getViewModel()).z;
            ChannelInfoData channelInfoData1 = ((M0)a2.getViewModel()).g();
            boolean z1 = ((Boolean)b00.getValue()).booleanValue();
            boolean z2 = ((p)(((l)object0))).i(a2);
            U1 u10 = ((p)(((l)object0))).N();
            if(z2 || u10 == v3) {
                mutableStateFlow4 = mutableStateFlow2;
                mutableStateFlow3 = mutableStateFlow1;
                a3 = a2;
                flow1 = flow0;
                v6 = v3;
                U1 u11 = new U1(1, a3, A.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 9);
                ((p)(((l)object0))).l0(u11);
                u10 = u11;
            }
            else {
                a3 = a2;
                flow1 = flow0;
                mutableStateFlow3 = mutableStateFlow1;
                mutableStateFlow4 = mutableStateFlow2;
                v6 = v3;
            }
            boolean z3 = ((p)(((l)object0))).i(a3);
            U1 u12 = ((p)(((l)object0))).N();
            if(z3 || u12 == v6) {
                U1 u13 = new U1(1, a3, A.class, "onUiEvent", "onUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 10);
                ((p)(((l)object0))).l0(u13);
                u12 = u13;
            }
            boolean z4 = ((p)(((l)object0))).i(a3);
            Ic.h h2 = ((p)(((l)object0))).N();
            if(z4 || h2 == v6) {
                Ic.h h3 = new Ic.h(0, a3, A.class, "showSelectImageSelectorDialog", "showSelectImageSelectorDialog()V", 0, 19);
                ((p)(((l)object0))).l0(h3);
                h2 = h3;
            }
            G.p(((N)k40), mutableStateFlow0, stateFlow0, stateFlow1, mutableStateFlow3, mutableStateFlow4, flow1, channelInfoData1, z1, u10, u12, h2, ((p)(((l)object0))), 0);
            return h0;
        }
        ((p)(((l)object0))).T();
        return h0;
    }
}

