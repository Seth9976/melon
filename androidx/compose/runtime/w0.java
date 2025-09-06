package androidx.compose.runtime;

import F.e;
import androidx.collection.L;
import androidx.collection.T;
import ie.H;
import java.util.Collection;
import java.util.Set;
import je.p;
import jeb.synthetic.FIN;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.FlowCollector;
import oe.i;
import p0.h;
import p0.m;
import we.a;
import we.k;
import we.n;

public final class W0 extends i implements n {
    public Channel B;
    public j3.n D;
    public Object E;
    public int G;
    public Object I;
    public final a M;
    public L r;
    public k w;

    public W0(a a0, Continuation continuation0) {
        this.M = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new W0(this.M, continuation0);
        continuation1.I = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((W0)this.create(((FlowCollector)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return ne.a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object4;
        h h3;
        a a1;
        h h2;
        j3.n n1;
        long v4;
        int v3;
        int v2;
        boolean z;
        Set set0;
        Object object3;
        Object object2;
        Object object1;
        h h1;
        int v1;
        h h0;
        j3.n n0;
        Channel channel0;
        k k0;
        L l0;
        FlowCollector flowCollector0;
        ne.a a0 = ne.a.a;
    alab1:
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                flowCollector0 = (FlowCollector)this.I;
                l0 = new L();
                k0 = new T(l0, 1);
                channel0 = ChannelKt.Channel$default(0x7FFFFFFF, null, null, 6, null);
                e e0 = new e(channel0, 18);
                m.f(p0.a.h);
                synchronized(m.b) {
                    m.g = p.z0(e0, ((Collection)m.g));
                }
                n0 = new j3.n(e0, 5);
                try {
                    h0 = m.k().u(k0);
                    v1 = FIN.finallyOpen$NT();
                    h1 = h0.j();
                }
                catch(Throwable throwable0) {
                    goto label_139;
                }
                try {
                    object1 = this.M.invoke();
                    goto label_26;
                }
                catch(Throwable throwable1) {
                    try {
                        h.q(h1);
                        FIN.finallyExec$NT(v1);
                        throw throwable1;
                    label_26:
                        h.q(h1);
                        FIN.finallyCodeBegin$NT(v1);
                        h0.c();
                        FIN.finallyCodeEnd$NT(v1);
                        this.I = flowCollector0;
                        this.r = l0;
                        this.w = k0;
                        this.B = channel0;
                        this.D = n0;
                        this.E = object1;
                        this.G = 1;
                        if(flowCollector0.emit(object1, this) == a0) {
                            return a0;
                        }
                        object2 = object1;
                        goto label_63;
                    }
                    catch(Throwable throwable0) {
                        goto label_139;
                    }
                }
            }
            case 1: {
                object2 = this.E;
                n0 = this.D;
                channel0 = this.B;
                k0 = this.w;
                l0 = this.r;
                flowCollector0 = (FlowCollector)this.I;
                goto label_62;
            }
            case 2: {
                object2 = this.E;
                n0 = this.D;
                channel0 = this.B;
                k0 = this.w;
                l0 = this.r;
                flowCollector0 = (FlowCollector)this.I;
                try {
                    d5.n.D(object0);
                    object3 = object0;
                    goto label_72;
                }
                catch(Throwable throwable0) {
                    goto label_139;
                }
            }
            case 3: {
                object2 = this.E;
                n0 = this.D;
                channel0 = this.B;
                k0 = this.w;
                l0 = this.r;
                flowCollector0 = (FlowCollector)this.I;
                try {
                label_62:
                    d5.n.D(object0);
                    while(true) {
                    label_63:
                        this.I = flowCollector0;
                        this.r = l0;
                        this.w = k0;
                        this.B = channel0;
                        this.D = n0;
                        this.E = object2;
                        this.G = 2;
                        object3 = channel0.receive(this);
                        if(object3 == a0) {
                            return a0;
                        }
                    label_72:
                        set0 = (Set)object3;
                        z = false;
                        break alab1;
                    }
                }
                catch(Throwable throwable0) {
                    goto label_139;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    label_74:
        if(z) {
            goto label_103;
        }
        else {
            try {
                Object[] arr_object = l0.b;
                long[] arr_v = l0.a;
                v2 = arr_v.length - 2;
                if(v2 >= 0) {
                    Object[] arr_object1 = arr_object;
                    v3 = 0;
                    while(true) {
                    label_81:
                        v4 = arr_v[v3];
                        n1 = n0;
                        goto label_87;
                    }
                }
                else {
                    goto label_100;
                }
                goto label_101;
            }
            catch(Throwable throwable0) {
                try {
                    n1 = n0;
                    goto label_147;
                label_87:
                    if((~v4 << 7 & v4 & 0x8080808080808080L) == 0x8080808080808080L) {
                        goto label_96;
                    }
                    int v5 = 8 - (~(v3 - v2) >>> 0x1F);
                    int v6 = 0;
                    while(v6 < v5) {
                        if((v4 & 0xFFL) < 0x80L && set0.contains(arr_object1[(v3 << 3) + v6])) {
                            goto label_104;
                        }
                        v4 >>= 8;
                        ++v6;
                    }
                    if(v5 == 8) {
                    label_96:
                        if(v3 != v2) {
                            ++v3;
                            n0 = n1;
                            goto label_81;
                        label_100:
                            n1 = n0;
                        }
                    }
                label_101:
                    z = false;
                    goto label_105;
                label_103:
                    n1 = n0;
                label_104:
                    z = true;
                label_105:
                    set0 = (Set)ChannelResult.getOrNull-impl(channel0.tryReceive-PtdJZtk());
                    if(set0 != null) {
                        goto label_144;
                    }
                    if(z) {
                        l0.b();
                        h2 = m.k().u(k0);
                        a1 = this.M;
                        goto label_111;
                    }
                    goto label_142;
                }
                catch(Throwable throwable0) {
                    goto label_147;
                }
            }
        }
        goto label_104;
        try {
        label_111:
            h3 = h2.j();
        }
        catch(Throwable throwable2) {
            goto label_123;
        }
        try {
            object4 = a1.invoke();
        }
        catch(Throwable throwable3) {
            try {
                n0 = n1;
                h.q(h3);
                throw throwable3;
            }
            catch(Throwable throwable2) {
                goto label_124;
            }
        }
        try {
            h.q(h3);
            goto label_126;
        }
        catch(Throwable throwable2) {
        label_123:
            n0 = n1;
        }
        try {
        label_124:
            h2.c();
            throw throwable2;
        }
        catch(Throwable throwable0) {
            goto label_139;
        }
        try {
        label_126:
            h2.c();
            if(!q.b(object4, object2)) {
                this.I = flowCollector0;
                this.r = l0;
                this.w = k0;
                this.B = channel0;
                n0 = n1;
                goto label_133;
            }
            goto label_142;
        }
        catch(Throwable throwable0) {
            goto label_147;
        }
        try {
        label_133:
            this.D = n0;
            this.E = object4;
            this.G = 3;
            if(flowCollector0.emit(object4, this) != a0) {
                goto label_140;
            }
            return a0;
        }
        catch(Throwable throwable0) {
        label_139:
            goto label_148;
        }
    label_140:
        object2 = object4;
        goto label_63;
        try {
        label_142:
            n0 = n1;
            goto label_63;
        label_144:
            n0 = n1;
            goto label_74;
        label_147:
            n0 = n1;
        }
        catch(Throwable throwable0) {
            goto label_147;
        }
    label_148:
        n0.d();
        throw throwable0;
    }
}

