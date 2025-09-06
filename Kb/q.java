package kb;

import H0.b;
import e.k;
import ie.H;
import ie.m;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.n;

public final class q extends i implements n {
    public s B;
    public String D;
    public String E;
    public Iterator G;
    public m I;
    public int M;
    public int N;
    public int S;
    public int T;
    public int V;
    public Object W;
    public final ArrayList X;
    public final List Y;
    public final s Z;
    public final String b0;
    public final String c0;
    public List r;
    public List w;

    public q(ArrayList arrayList0, List list0, s s0, String s1, String s2, Continuation continuation0) {
        this.X = arrayList0;
        this.Y = list0;
        this.Z = s0;
        this.b0 = s1;
        this.c0 = s2;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new q(this.X, this.Y, this.Z, this.b0, this.c0, continuation0);
        continuation1.W = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((q)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        int v6;
        int v5;
        String s5;
        List list3;
        int v4;
        s s4;
        String s3;
        List list2;
        Iterator iterator0;
        int v1;
        List list5;
        s s11;
        int v13;
        String s10;
        int v12;
        Iterator iterator2;
        int v11;
        String s9;
        m m2;
        Iterator iterator3;
        s s12;
        List list6;
        FlowCollector flowCollector0 = (FlowCollector)this.W;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.V) {
            case 0: {
                list3 = b.m(object0);
                list6 = this.X;
                s12 = this.Z;
                s5 = this.b0;
                s3 = this.c0;
                v6 = 0;
                v5 = 0;
                iterator3 = list6.iterator();
                break;
            }
            case 1: {
                int v7 = this.T;
                int v8 = this.S;
                int v9 = this.N;
                int v10 = this.M;
                m m1 = this.I;
                Iterator iterator1 = this.G;
                String s6 = this.E;
                String s7 = this.D;
                s s8 = this.B;
                list2 = this.w;
                List list4 = this.r;
                d5.n.D(object0);
                m2 = m1;
                v4 = v7;
                s9 = s7;
                v11 = v10;
                iterator2 = iterator1;
                v12 = v8;
                s10 = s6;
                v13 = v9;
                s11 = s8;
                list5 = list4;
                goto label_89;
            }
            case 2: {
                int v = this.T;
                v1 = this.S;
                int v2 = this.N;
                int v3 = this.M;
                iterator0 = this.G;
                String s = this.E;
                String s1 = this.D;
                s s2 = this.B;
                List list0 = this.w;
                List list1 = this.r;
                d5.n.D(object0);
                list2 = list0;
                s3 = s;
                s4 = s2;
                v4 = v;
                list3 = list1;
                s5 = s1;
                v5 = v3;
                v6 = v2;
                object1 = object0;
                goto label_112;
            }
            case 3: {
                m m0 = (m)this.B;
                d5.n.D(object0);
                return h0;
            }
            case 4: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(iterator3.hasNext()) {
            Object object2 = iterator3.next();
            v13 = v6 + 1;
            if(v6 < 0) {
                k.O();
                throw null;
            }
            kb.H h1 = new kb.H(v13, list6.size());
            this.W = flowCollector0;
            this.r = list3;
            this.w = list6;
            this.B = s12;
            this.D = s5;
            this.E = s3;
            this.G = iterator3;
            this.I = (m)object2;
            this.M = v5;
            this.N = v13;
            this.S = v6;
            this.T = 0;
            this.V = 1;
            if(flowCollector0.emit(h1, this) == a0) {
                return a0;
            }
            list2 = list6;
            s10 = s3;
            v12 = v6;
            iterator2 = iterator3;
            s11 = s12;
            list5 = list3;
            s9 = s5;
            v11 = v5;
            m2 = (m)object2;
            v4 = 0;
        label_89:
            this.W = flowCollector0;
            this.r = list5;
            this.w = list2;
            this.B = s11;
            this.D = s9;
            this.E = s10;
            this.G = iterator2;
            this.I = null;
            this.M = v11;
            this.N = v13;
            this.S = v12;
            this.T = v4;
            this.V = 2;
            object1 = s.a(s11, s9, s10, ((File)m2.a), ((String)m2.b), this);
            if(object1 == a0) {
                return a0;
            }
            s4 = s11;
            v5 = v11;
            s5 = s9;
            list3 = list5;
            iterator0 = iterator2;
            s3 = s10;
            v1 = v12;
            v6 = v13;
        label_112:
            if(((String)object1) != null) {
                list3.add(((String)object1));
                iterator3 = iterator0;
                list6 = list2;
                s12 = s4;
                continue;
            }
            this.W = null;
            this.r = null;
            this.w = null;
            this.B = null;
            this.D = null;
            this.E = null;
            this.G = null;
            this.I = null;
            this.M = v5;
            this.N = v6;
            this.S = v1;
            this.T = v4;
            this.V = 3;
            return flowCollector0.emit(E.a, this) == a0 ? a0 : h0;
        }
        G g0 = new G(this.Y, list3);
        this.W = null;
        this.r = null;
        this.w = null;
        this.B = null;
        this.D = null;
        this.E = null;
        this.G = null;
        this.I = null;
        this.V = 4;
        return flowCollector0.emit(g0, this) == a0 ? a0 : h0;
    }
}

