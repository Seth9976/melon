package com.melon.ui;

import Cb.j;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import vb.p;
import vb.q;
import vb.r;
import vb.s;
import we.k;

public final class m4 implements FlowCollector {
    public final k a;

    public m4(k k0) {
        this.a = k0;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((s)object0) instanceof q) {
            j.b(((q)(((s)object0))).a, false, 3);
            return H.a;
        }
        if(((s)object0) instanceof r) {
            v3 v30 = new v3(((r)(((s)object0))).a, ((r)(((s)object0))).b);
            this.a.invoke(v30);
            return H.a;
        }
        if(!(((s)object0) instanceof p)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return H.a;
    }
}

