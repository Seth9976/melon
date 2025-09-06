package gd;

import Ac.b0;
import Cb.j;
import com.melon.ui.s4;
import e.k;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import je.p;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import lb.b;
import lb.c;
import lb.d;
import lb.e;

public final class d3 implements FlowCollector {
    public final e3 a;
    public final int b;
    public final B c;

    public d3(e3 e30, int v, B b0) {
        this.a = e30;
        this.b = v;
        this.c = b0;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        String s1;
        Iterator iterator0;
        ArrayList arrayList0;
        String s;
        if(((e)object0) instanceof b) {
            j.b(((b)(((e)object0))).a, false, 3);
            return H.a;
        }
        e3 e30 = this.a;
        if(((e)object0) instanceof c) {
            e30.sendUiEvent(s4.a);
            return H.a;
        }
        if(!(((e)object0) instanceof d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        Object object1 = e30.getUiState().getValue();
        E2 e20 = object1 instanceof E2 ? ((E2)object1) : null;
        if(e20 != null) {
            B b0 = this.c;
            if(b0 instanceof y) {
                s = "recommend";
                arrayList0 = new ArrayList(q.Q(10, e20.a));
                iterator0 = e20.a.iterator();
                goto label_21;
            }
            else if(b0 instanceof x) {
                s = "powerdj";
                arrayList0 = new ArrayList(q.Q(10, e20.a));
                iterator0 = e20.a.iterator();
            label_21:
                while(iterator0.hasNext()) {
                    Object object2 = iterator0.next();
                    B2 b20 = (B2)object2;
                    B b1 = (B)p.m0(b20.b);
                    if(b1 != null) {
                        if(b1 instanceof y) {
                            s1 = "recommend";
                        }
                        else {
                            s1 = b1 instanceof x ? "powerdj" : null;
                        }
                        if(kotlin.jvm.internal.q.b(s1, s)) {
                            ArrayList arrayList1 = new ArrayList(q.Q(10, b20.b));
                            int v = 0;
                            for(Object object3: b20.b) {
                                if(v >= 0) {
                                    B b2 = (B)object3;
                                    if(v == this.b) {
                                        if(b2 instanceof y) {
                                            b2 = new y(((y)b2).a, ((y)b2).b, ((y)b2).c, ((d)(((e)object0))).a, ((y)b2).d, ((y)b2).e);
                                        }
                                        else if(b2 instanceof x) {
                                            b2 = new x(((x)b2).a, ((x)b2).b, ((x)b2).c, ((x)b2).d, ((x)b2).e, ((x)b2).g, ((d)(((e)object0))).a);
                                        }
                                    }
                                    arrayList1.add(b2);
                                    ++v;
                                    continue;
                                }
                                k.O();
                                throw null;
                            }
                            b20 = new B2(b20.a, arrayList1);
                        }
                    }
                    arrayList0.add(b20);
                }
                e30.updateUiState(new b0(17, arrayList0));
            }
        }
        return H.a;
    }
}

