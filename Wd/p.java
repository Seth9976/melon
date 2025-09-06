package wd;

import Pa.b;
import Pa.c;
import Pc.e;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.q4;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class p extends i implements n {
    public final t B;
    public int r;
    public final e w;

    public p(e e0, Continuation continuation0, t t0) {
        this.w = e0;
        this.B = t0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p(this.w, continuation0, this.B);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Flow flow0;
        t t0 = this.B;
        StringProviderImpl stringProviderImpl0 = t0.b;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = ((j)this.w).a;
                if(s.length() == 0) {
                    t0.sendUiEvent(new q4(28, stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.b(0x7F1300B4, new Object[]{new Integer(MelonLimits.TextLimit.c.a)}), null, null));  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                if(q.b(t0.c, "M20002")) {
                    MelonLimits.TextLimit melonLimits$TextLimit0 = MelonLimits.TextLimit.c;
                    if(melonLimits$TextLimit0.a(s) != 0) {
                        t0.sendUiEvent(new q4(28, stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.b(0x7F1300B4, new Object[]{new Integer(melonLimits$TextLimit0.a)}), null, null));  // string:alert_dlg_title_info "안내"
                        return h0;
                    }
                }
                List list0 = t0.f;
                String s1 = t0.g;
                this.r = 1;
                t0.a.getClass();
                flow0 = FlowKt.flatMapConcat(FlowKt.flow(new b(t0.a, s, list0, null)), new c(t0.a, s, s1, null));
                if(flow0 == a0) {
                    return a0;
                }
                goto label_25;
            }
            case 1: {
                d5.n.D(object0);
                flow0 = object0;
            label_25:
                this.r = 2;
                H h1 = flow0.collect(new s(t0), this);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
                    return a0;
                }
                t0.sendUiEvent(wd.i.a);
                return h0;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
        t0.sendUiEvent(wd.i.a);
        return h0;
    }
}

