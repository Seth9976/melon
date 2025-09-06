package androidx.room;

import U.w;
import d5.n;
import i.n.i.b.a.s.e.M3;
import java.util.Set;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import l2.X;
import l2.Z;
import l2.d;
import l2.j0;
import l2.m0;
import ne.a;
import oe.c;

public final class u {
    public final MutableStateFlow a;

    public u() {
        this.a = StateFlowKt.MutableStateFlow(m0.b);
    }

    public u(int v) {
        this.a = StateFlowKt.MutableStateFlow(new int[v]);
    }

    public void a(w w0, c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.B;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.B = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.r;
        a a0 = a.a;
        switch(t0.B) {
            case 0: {
                n.D(object0);
                t0.B = 1;
                if(this.a.collect(w0, t0) == a0) {
                    return;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public j0 b() {
        return (j0)this.a.getValue();
    }

    public void c(Set set0) {
        q.g(set0, "tableIds");
        if(!set0.isEmpty()) {
            while(true) {
                MutableStateFlow mutableStateFlow0 = this.a;
                Object object0 = mutableStateFlow0.getValue();
                int[] arr_v = (int[])object0;
                int[] arr_v1 = new int[arr_v.length];
                for(int v = 0; v < arr_v.length; ++v) {
                    arr_v1[v] = set0.contains(v) ? arr_v[v] + 1 : arr_v[v];
                }
                if(mutableStateFlow0.compareAndSet(object0, arr_v1)) {
                    break;
                }
            }
        }
    }

    public void d(j0 j00) {
        q.g(j00, "newState");
        do {
            MutableStateFlow mutableStateFlow0 = this.a;
            Object object0 = mutableStateFlow0.getValue();
            j0 j01 = (j0)object0;
            if((j01 instanceof Z ? true : q.b(j01, m0.b))) {
                j01 = j00;
            }
            else if(!(j01 instanceof d)) {
                if(!(j01 instanceof X)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            else if(j00.a > j01.a) {
                j01 = j00;
            }
        }
        while(!mutableStateFlow0.compareAndSet(object0, j01));
    }
}

