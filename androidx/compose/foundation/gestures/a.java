package androidx.compose.foundation.gestures;

import I.H0;
import I.I0;
import I.J0;
import I.K0;
import I.M0;
import I.X0;
import I.g1;
import I.u0;
import androidx.compose.foundation.x0;
import d5.n;
import kotlin.jvm.internal.E;
import oe.c;
import r0.q;
import x0.b;

public abstract class a {
    public static final I0 a;
    public static final H0 b;
    public static final J0 c;

    static {
        a.a = new I0();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.b = new H0();  // 初始化器: Ljava/lang/Object;-><init>()V
        a.c = new J0();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final Object a(g1 g10, long v, c c0) {
        K0 k00;
        if(c0 instanceof K0) {
            k00 = (K0)c0;
            int v1 = k00.D;
            if((v1 & 0x80000000) == 0) {
                k00 = new K0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
            }
            else {
                k00.D = v1 ^ 0x80000000;
            }
        }
        else {
            k00 = new K0(c0);  // 初始化器: Loe/c;-><init>(Lkotlin/coroutines/Continuation;)V
        }
        Object object0 = k00.B;
        ne.a a0 = ne.a.a;
        switch(k00.D) {
            case 0: {
                n.D(object0);
                E e0 = new E();  // 初始化器: Ljava/lang/Object;-><init>()V
                M0 m00 = new M0(g10, v, e0, null);
                k00.r = g10;
                k00.w = e0;
                k00.D = 1;
                return g10.e(x0.a, m00, k00) == a0 ? a0 : new b(g10.g(e0.a));
            }
            case 1: {
                E e1 = k00.w;
                g1 g11 = k00.r;
                n.D(object0);
                return new b(g11.g(e1.a));
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static q b(q q0, X0 x00, u0 u00, boolean z, boolean z1, int v) {
        if((v & 4) != 0) {
            z = true;
        }
        if((v & 8) != 0) {
            z1 = false;
        }
        return q0.then(new ScrollableElement(x00, u00, z, z1, null));
    }
}

