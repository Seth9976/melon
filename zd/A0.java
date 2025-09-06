package zd;

import Cb.j;
import bb.f;
import bb.g;
import bb.h;
import bb.i;
import bb.k;
import bb.l;
import bb.m;
import bb.n;
import bb.o;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.G4;
import com.melon.ui.K4;
import com.melon.ui.s4;
import com.melon.ui.t4;
import i.n.i.b.a.s.e.M3;
import ie.H;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;

public final class a0 implements FlowCollector {
    public final c0 a;

    public a0(c0 c00) {
        this.a = c00;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((o)object0) instanceof h) {
            j.b(((h)(((o)object0))).a, ((h)(((o)object0))).b, 2);
            return H.a;
        }
        c0 c00 = this.a;
        if(((o)object0) instanceof k) {
            c00.sendUiEvent(s4.a);
            return H.a;
        }
        if(((o)object0) instanceof n) {
            int v = ((n)(((o)object0))).c;
            N n0 = new N(((n)(((o)object0))).b, v);
            MutableStateFlow mutableStateFlow0 = c00.k;
            do {
                Object object1 = mutableStateFlow0.getValue();
                q.g(((K4)object1), "it");
            }
            while(!mutableStateFlow0.compareAndSet(object1, n0));
            c00.sendUiEvent(new m0(((n)(((o)object0))).b, v, ((n)(((o)object0))).d));
            return H.a;
        }
        if(((o)object0) instanceof m) {
            g g0 = (g)p.m0(((m)(((o)object0))).a);
            c00.d((g0 == null ? false : g0.b));
            return H.a;
        }
        if(((o)object0) instanceof i) {
            c00.sendUiEvent(new l0(((i)(((o)object0))).a));
            return H.a;
        }
        if(((o)object0) instanceof f) {
            String s = ((f)(((o)object0))).a.getMessage();
            if(s == null) {
                return H.a;
            }
            LogU.error$default(c00.h, s, null, false, 6, null);
            c00.sendUiEvent(new t4(s));
            return H.a;
        }
        if(((o)object0) instanceof l) {
            c00.sendUiEvent(new t4(c00.e.a(((l)(((o)object0))).a)));
            return H.a;
        }
        if(!q.b(((o)object0), bb.j.a)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        c00.sendUiEvent(G4.a);
        return H.a;
    }
}

