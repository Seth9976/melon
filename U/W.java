package U;

import K.f;
import K.g;
import K.h;
import K.i;
import K.k;
import K.o;
import Y.Q;
import androidx.compose.foundation.K;
import androidx.room.W;
import d5.n;
import f1.j;
import f1.x;
import f1.y;
import java.util.ArrayList;
import java.util.Set;
import je.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;

public final class w implements FlowCollector {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public w(Object object0, Object object1, Object object2, Object object3, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = object3;
        super();
    }

    public Object a(int[] arr_v, Continuation continuation0) {
        w w1;
        W w0;
        String[] arr_s = (String[])this.d;
        FlowCollector flowCollector0 = (FlowCollector)this.c;
        if(continuation0 instanceof W) {
            w0 = (W)continuation0;
            int v = w0.E;
            if((v & 0x80000000) == 0) {
                w0 = new W(this, continuation0);
            }
            else {
                w0.E = v ^ 0x80000000;
            }
        }
        else {
            w0 = new W(this, continuation0);
        }
        Object object0 = w0.B;
        a a0 = a.a;
        switch(w0.E) {
            case 0: {
                n.D(object0);
                H h0 = (H)this.b;
                if(h0.a == null) {
                    Set set0 = je.n.A0(arr_s);
                    w0.r = this;
                    w0.w = arr_v;
                    w0.E = 1;
                    if(flowCollector0.emit(set0, w0) == a0) {
                        return a0;
                    }
                }
                else {
                    int[] arr_v1 = (int[])this.e;
                    ArrayList arrayList0 = new ArrayList();
                    int v1 = 0;
                    for(int v2 = 0; v1 < arr_s.length; ++v2) {
                        String s = arr_s[v1];
                        Object object1 = h0.a;
                        if(object1 == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        int v3 = arr_v1[v2];
                        if(((int[])object1)[v3] != arr_v[v3]) {
                            arrayList0.add(s);
                        }
                        ++v1;
                    }
                    if(!arrayList0.isEmpty()) {
                        Set set1 = p.T0(arrayList0);
                        w0.r = this;
                        w0.w = arr_v;
                        w0.E = 2;
                        if(flowCollector0.emit(set1, w0) == a0) {
                            return a0;
                        }
                    }
                }
                w1 = this;
                break;
            }
            case 1: 
            case 2: {
                arr_v = w0.w;
                w1 = w0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((H)w1.b).a = arr_v;
        return ie.H.a;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        switch(this.a) {
            case 0: {
                Q q0 = (Q)this.d;
                f0 f00 = (f0)this.b;
                if(((Boolean)object0).booleanValue() && f00.b()) {
                    x x0 = q0.m();
                    b0.o(((y)this.c), f00, x0, ((j)this.e), q0.b);
                    return ie.H.a;
                }
                b0.k(f00);
                return ie.H.a;
            }
            case 1: {
                F f0 = (F)this.d;
                F f1 = (F)this.c;
                F f2 = (F)this.b;
                int v = 1;
                if(((k)object0) instanceof o) {
                    ++f2.a;
                }
                else if(((k)object0) instanceof K.p) {
                    --f2.a;
                }
                else if(((k)object0) instanceof K.n) {
                    --f2.a;
                }
                else if(((k)object0) instanceof h) {
                    ++f1.a;
                }
                else if(((k)object0) instanceof i) {
                    --f1.a;
                }
                else if(((k)object0) instanceof f) {
                    ++f0.a;
                }
                else if(((k)object0) instanceof g) {
                    --f0.a;
                }
                int v1 = 0;
                boolean z = f2.a > 0;
                boolean z1 = f1.a > 0;
                boolean z2 = f0.a > 0;
                K k0 = (K)this.e;
                if(k0.b != z) {
                    k0.b = z;
                    v1 = 1;
                }
                if(k0.c != z1) {
                    k0.c = z1;
                    v1 = 1;
                }
                if(k0.d == z2) {
                    v = v1;
                }
                else {
                    k0.d = z2;
                }
                if(v != 0) {
                    P0.f.m(k0);
                }
                return ie.H.a;
            }
            default: {
                return this.a(((int[])object0), continuation0);
            }
        }
    }
}

