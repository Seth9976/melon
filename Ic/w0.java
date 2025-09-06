package Ic;

import Cb.j;
import Hc.P;
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

public final class w0 implements FlowCollector {
    public final A0 a;

    public w0(A0 a00) {
        this.a = a00;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, false, 3);
            return H.a;
        }
        A0 a00 = this.a;
        if(((o)object0) instanceof k) {
            a00.sendUiEvent(s4.a);
            return H.a;
        }
        if(((o)object0) instanceof n) {
            a00.n(new P(((n)(((o)object0))).c, ((n)(((o)object0))).b));
            return H.a;
        }
        if(((o)object0) instanceof bb.j) {
            a00.sendUiEvent(G4.a);
            return H.a;
        }
        if(((o)object0) instanceof i) {
            a00.sendUiEvent(new m(((i)(((o)object0))).a));
            return H.a;
        }
        if(((o)object0) instanceof f) {
            String s = ((f)(((o)object0))).a.getMessage();
            if(s == null) {
                return H.a;
            }
            LogU.error$default(a00.r, s, null, false, 6, null);
            a00.sendUiEvent(new t4(s));
            return H.a;
        }
        if(((o)object0) instanceof l) {
            a00.sendUiEvent(new t4(a00.b.a(((l)(((o)object0))).a)));
            return H.a;
        }
        if(!(((o)object0) instanceof bb.m)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return H.a;
    }
}

