package com.iloen.melon.appwidget;

import D2.f;
import E2.a;
import V4.s;
import android.content.Context;
import d5.n;
import ie.H;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import oe.c;
import w8.b;
import w8.k0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/appwidget/CloseMessageAction;", "LE2/a;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CloseMessageAction implements a {
    public final Object a(Context context0, f f0, c c0) {
        w8.a a0;
        if(c0 instanceof w8.a) {
            a0 = (w8.a)c0;
            int v = a0.E;
            if((v & 0x80000000) == 0) {
                a0 = new w8.a(this, c0);
            }
            else {
                a0.E = v ^ 0x80000000;
            }
        }
        else {
            a0 = new w8.a(this, c0);
        }
        Object object0 = a0.B;
        ne.a a1 = ne.a.a;
        switch(a0.E) {
            case 0: {
                n.D(object0);
                q.g(context0, "context");
                s.c0(context0).b0("CoverWidgetMessageUpdateWorker");
                b b0 = new b(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                a0.r = context0;
                a0.w = f0;
                a0.E = 1;
                if(d5.f.Y(context0, f0, b0, a0) == a1) {
                    return a1;
                }
                break;
            }
            case 1: {
                f0 = a0.w;
                context0 = a0.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        k0 k00 = new k0();
        a0.r = null;
        a0.w = null;
        a0.E = 2;
        return k00.g(context0, f0, a0) == a1 ? a1 : H.a;
    }
}

