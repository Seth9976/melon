package gd;

import Cb.j;
import bb.f;
import bb.g;
import bb.h;
import bb.k;
import bb.l;
import bb.m;
import bb.n;
import bb.o;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.G4;
import com.melon.ui.s4;
import com.melon.ui.t4;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

public final class q1 implements FlowCollector {
    public final r1 a;
    public final String b;

    public q1(r1 r10, String s) {
        this.a = r10;
        this.b = s;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, false, 3);
            return H.a;
        }
        r1 r10 = this.a;
        if(((o)object0) instanceof k) {
            r10.sendUiEvent(s4.a);
            return H.a;
        }
        if(((o)object0) instanceof n) {
            r1.d(r10, e.k.z(new g(this.b, ((n)(((o)object0))).b)));
            return H.a;
        }
        if(((o)object0) instanceof m) {
            r1.d(r10, ((m)(((o)object0))).a);
            return H.a;
        }
        if(((o)object0) instanceof bb.j) {
            r10.sendUiEvent(G4.a);
            return H.a;
        }
        if(((o)object0) instanceof f) {
            String s = ((f)(((o)object0))).a.getMessage();
            if(s != null) {
                LogU.error$default(r10.f, s, null, false, 6, null);
                r10.sendUiEvent(new t4(s));
                return H.a;
            }
        }
        else if(((o)object0) instanceof l) {
            r10.sendUiEvent(new t4(r10.d.a(((l)(((o)object0))).a)));
        }
        return H.a;
    }
}

