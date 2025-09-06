package wc;

import Cb.j;
import Hc.P;
import Ic.m;
import bb.f;
import bb.h;
import bb.i;
import bb.k;
import bb.l;
import bb.n;
import bb.o;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.G4;
import com.melon.ui.s4;
import com.melon.ui.t4;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

public final class r implements FlowCollector {
    public final w a;

    public r(w w0) {
        this.a = w0;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, false, 3);
            return H.a;
        }
        w w0 = this.a;
        if(((o)object0) instanceof k) {
            w0.sendUiEvent(s4.a);
            return H.a;
        }
        if(((o)object0) instanceof n) {
            w0.n(new P(((n)(((o)object0))).c, ((n)(((o)object0))).b));
            return H.a;
        }
        if(((o)object0) instanceof bb.j) {
            w0.sendUiEvent(G4.a);
            return H.a;
        }
        if(((o)object0) instanceof i) {
            w0.sendUiEvent(new m(((i)(((o)object0))).a));
            return H.a;
        }
        if(((o)object0) instanceof f) {
            String s = ((f)(((o)object0))).a.getMessage();
            if(s == null) {
                return H.a;
            }
            LogU.error$default(w0.r, s, null, false, 6, null);
            w0.sendUiEvent(new t4(s));
            return H.a;
        }
        if(((o)object0) instanceof l) {
            w0.sendUiEvent(new t4(w0.b.a(((l)(((o)object0))).a)));
            return H.a;
        }
        if(!(((o)object0) instanceof bb.m)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return H.a;
    }
}

