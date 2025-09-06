package com.melon.ui;

import Cb.j;
import Vc.B;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import tb.b;
import tb.c;
import tb.d;
import tb.e;

public final class s3 implements FlowCollector {
    public final B a;
    public final String b;
    public final List c;
    public final String d;

    public s3(B b0, String s, List list0, String s1) {
        this.a = b0;
        this.b = s;
        this.c = list0;
        this.d = s1;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(((e)object0) instanceof d) {
            j.b(((d)(((e)object0))).a, false, 3);
            return H.a;
        }
        B b0 = this.a;
        if(((e)object0) instanceof c) {
            b0.invoke(new l3(this.b, this.d, ((c)(((e)object0))).a, this.c));
            return H.a;
        }
        if(!(((e)object0) instanceof b)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        b0.invoke(n3.a);
        return H.a;
    }
}

