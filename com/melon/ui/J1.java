package com.melon.ui;

import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import ne.a;
import oe.i;
import we.n;

public final class j1 extends i implements n {
    public Object B;
    public final Y0 D;
    public final k1 E;
    public long r;
    public int w;

    public j1(Y0 y00, k1 k10, Continuation continuation0) {
        this.D = y00;
        this.E = k10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new j1(this.D, this.E, continuation0);
        continuation1.B = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v1;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.B;
        a a0 = a.a;
        k1 k10 = this.E;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                Y0 y00 = this.D;
                if(y00 instanceof X0) {
                    if(((X0)y00).a) {
                        k10.latestFetchTime = 0L;
                    }
                    if(!k10.isFetchEnabled()) {
                        return H.a;
                    }
                    long v = k1.access$getCurrentTimeMillis(k10);
                    f1 f10 = new f1(((X0)y00).b);
                    this.B = coroutineScope0;
                    this.r = v;
                    this.w = 1;
                    if(k10.onFetchStart(f10, this) == a0) {
                        return a0;
                    }
                    v1 = v;
                    break;
                }
                if(!(y00 instanceof W0)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                e1 e10 = new e1(((W0)y00).a);
                this.B = null;
                this.w = 2;
                return k10.onFetchStart(e10, this) == a0 ? a0 : H.a;
            }
            case 1: {
                v1 = this.r;
                d5.n.D(object0);
                break;
            }
            case 2: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        CoroutineScopeKt.ensureActive(coroutineScope0);
        k10.latestFetchTime = v1;
        return H.a;
    }
}

