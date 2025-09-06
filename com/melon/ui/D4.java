package com.melon.ui;

import com.iloen.melon.custom.L0;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import ie.H;
import k8.Y;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import ne.a;
import oe.i;
import vb.o;
import we.k;
import we.n;

public final class d4 extends i implements n {
    public n4 B;
    public kotlin.jvm.internal.n D;
    public int E;
    public int G;
    public int I;
    public final L0 M;
    public final n4 N;
    public final N3 S;
    public final kotlin.jvm.internal.n T;
    public L0 r;
    public String w;

    public d4(L0 l00, n4 n40, N3 n30, k k0, Continuation continuation0) {
        this.M = l00;
        this.N = n40;
        this.S = n30;
        this.T = (kotlin.jvm.internal.n)k0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d4(this.M, this.N, this.S, ((k)this.T), continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d4)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        L0 l00;
        String s;
        Object object1;
        int v4;
        n4 n41;
        int v3;
        kotlin.jvm.internal.n n0;
        L0 l01;
        Object object2;
        int v7;
        n4 n42;
        k k1;
        a a0 = a.a;
        int v = 0;
        switch(this.I) {
            case 0: {
                d5.n.D(object0);
                s = "ShareSNSPopupUserEventHelper ShareSongInstagram";
                n41 = this.N;
                o o0 = n41.a;
                SnsManager.SnsType snsManager$SnsType0 = SnsManager.SnsType.e;
                L0 l02 = this.M;
                N3 n30 = this.S;
                n0 = this.T;
                if(l02 == null) {
                    this.r = null;
                    this.w = null;
                    this.B = n41;
                    this.D = n0;
                    this.E = 0;
                    this.G = 0;
                    this.I = 1;
                    object2 = o0.e(((M3)n30).a, snsManager$SnsType0, this);
                    if(object2 != a0) {
                        v7 = 0;
                        n42 = n41;
                        k1 = n0;
                    label_59:
                        this.r = null;
                        this.w = null;
                        this.B = null;
                        this.D = null;
                        this.E = v;
                        this.G = v7;
                        this.I = 2;
                        return n4.a(n42, ((Flow)object2), k1, this) != a0 ? H.a : a0;
                    }
                }
                else {
                    l02.a("ShareSNSPopupUserEventHelper ShareSongInstagram true", true);
                    try {
                        this.r = l02;
                        this.w = "ShareSNSPopupUserEventHelper ShareSongInstagram";
                        this.B = n41;
                        this.D = n0;
                        this.E = 0;
                        this.G = 0;
                        this.I = 3;
                        object1 = o0.e(((M3)n30).a, snsManager$SnsType0, this);
                    }
                    catch(Throwable throwable0) {
                        l00 = l02;
                        Y.v(s, " false", l00, false);
                        throw throwable0;
                    }
                    if(object1 != a0) {
                        v3 = 0;
                        v4 = 0;
                        l01 = l02;
                        try {
                        label_85:
                            this.r = l01;
                            this.w = s;
                            this.B = null;
                            this.D = null;
                            this.E = v4;
                            this.G = v3;
                            this.I = 4;
                            if(n4.a(n41, ((Flow)object1), ((k)n0), this) == a0) {
                                return a0;
                            }
                        }
                        catch(Throwable throwable0) {
                            l00 = l01;
                            Y.v(s, " false", l00, false);
                            throw throwable0;
                        }
                        l00 = l01;
                    label_100:
                        Y.v(s, " false", l00, false);
                        return H.a;
                    }
                }
                return a0;
            }
            case 1: {
                int v5 = this.G;
                int v6 = this.E;
                k1 = (k)this.D;
                n42 = this.B;
                d5.n.D(object0);
                v7 = v5;
                v = v6;
                object2 = object0;
                goto label_59;
            }
            case 2: {
                Flow flow0 = (Flow)this.B;
                d5.n.D(object0);
                return H.a;
            }
            case 3: {
                int v1 = this.G;
                int v2 = this.E;
                k k0 = (k)this.D;
                n4 n40 = this.B;
                String s1 = this.w;
                l01 = this.r;
                try {
                    s = s1;
                    d5.n.D(object0);
                    n0 = k0;
                    v3 = v1;
                    s = s1;
                    n41 = n40;
                    v4 = v2;
                    object1 = object0;
                    goto label_85;
                }
                catch(Throwable throwable0) {
                    l00 = l01;
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                }
            }
            case 4: {
                Flow flow1 = (Flow)this.B;
                s = this.w;
                l00 = this.r;
                try {
                    d5.n.D(object0);
                    goto label_100;
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l00, false);
                    throw throwable0;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

