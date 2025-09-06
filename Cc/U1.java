package Cc;

import Q0.P;
import android.view.MotionEvent;
import ie.H;
import j5.d;
import kotlin.jvm.internal.q;
import we.a;
import we.k;
import x0.b;
import y0.N;

public final class u1 implements k {
    public final int a;
    public final a b;

    public u1(int v, a a0) {
        this.a = v;
        this.b = a0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f = 0.0f;
        H h0 = H.a;
        a a0 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((d)object0), "it");
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            case 1: {
                q.g(((N)object0), "$this$graphicsLayer");
                z z0 = (z)a0.invoke();
                ((N)object0).G((z0 == null ? 0.0f : ((float)z0.a)));
                if(z0 != null) {
                    f = (float)z0.b;
                }
                ((N)object0).I(f);
                return h0;
            }
            case 2: {
                q.g(((N)object0), "$this$graphicsLayer");
                z z1 = (z)a0.invoke();
                if(z1 != null) {
                    f = z1.c;
                }
                ((N)object0).a(f);
                return h0;
            }
            case 3: {
                q.g(((N)object0), "$this$graphicsLayer");
                float f1 = ((Number)a0.invoke()).floatValue();
                ((N)object0).r(f1);
                ((N)object0).s(f1);
                return h0;
            }
            case 4: {
                b b0 = (b)object0;
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            case 5: {
                q.g(object0, "it");
                return a0.invoke();
            }
            case 6: {
                ((Boolean)object0).booleanValue();
                a0.invoke();
                return h0;
            }
            case 7: {
                q.g(((G4.a)object0), "it");
                return a0.invoke();
            }
            case 8: {
                q.g(((MotionEvent)object0), "it");
                if(((MotionEvent)object0).getAction() == 0) {
                    a0.invoke();
                    return true;
                }
                return false;
            }
            case 9: {
                b b1 = (b)object0;
                a0.invoke();
                return h0;
            }
            case 10: {
                b b2 = (b)object0;
                a0.invoke();
                return h0;
            }
            case 11: {
                b b3 = (b)object0;
                a0.invoke();
                return h0;
            }
            case 12: {
                b b4 = (b)object0;
                a0.invoke();
                return h0;
            }
            case 13: {
                q.g(((N)object0), "$this$graphicsLayer");
                float f2 = (1.0f - Math.abs(((Number)a0.invoke()).floatValue())) * 0.08f + 0.92f;
                ((N)object0).r(f2);
                ((N)object0).s(f2);
                return h0;
            }
            case 14: {
                q.g(object0, "it");
                a0.invoke();
                return h0;
            }
            case 15: {
                q.g(object0, "it");
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            case 16: {
                q.g(object0, "it");
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            case 17: {
                q.g(object0, "it");
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            case 18: {
                q.g(object0, "it");
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            case 19: {
                q.g(object0, "it");
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            case 20: {
                q.g(object0, "it");
                if(a0 != null) {
                    a0.invoke();
                }
                return h0;
            }
            default: {
                q.g(((androidx.compose.runtime.H)object0), "$this$DisposableEffect");
                return new P(a0, 7);
            }
        }
    }
}

