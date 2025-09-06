package kd;

import androidx.compose.runtime.b0;
import com.melon.ui.s4;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.f;
import jd.Q;
import jd.m3;
import jd.q;
import vd.h;
import w0.p;
import we.a;
import we.k;

public final class e implements a {
    public final int a;
    public final k b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;

    public e(Object object0, Object object1, k k0, f f0, Object object2, int v) {
        this.a = v;
        this.c = object0;
        this.d = object1;
        this.b = k0;
        this.e = f0;
        this.f = object2;
        super();
    }

    public e(h h0, k k0, b0 b00, b0 b01, b0 b02) {
        this.a = 2;
        super();
        this.c = h0;
        this.b = k0;
        this.d = b00;
        this.e = b01;
        this.f = b02;
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                k k1 = (k)this.e;
                k k2 = (k)this.f;
                w0.h.a(((w0.h)this.c));
                int v = ((m3)((b0)this.d).getValue()).ordinal();
                k k3 = this.b;
                switch(v) {
                    case 0: {
                        k3.invoke(m3.c);
                        k1.invoke(new Q(m3.c));
                        return H.a;
                    }
                    case 1: {
                        k3.invoke(m3.c);
                        k1.invoke(new Q(m3.c));
                        return H.a;
                    }
                    case 2: {
                        k3.invoke(m3.a);
                        k2.invoke(Boolean.TRUE);
                        k1.invoke(new Q(m3.a));
                        return H.a;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            case 1: {
                a a0 = (a)this.d;
                a a1 = (a)this.e;
                p p0 = (p)this.f;
                H h1 = H.a;
                switch(((q)this.c).ordinal()) {
                    case 0: {
                        a0.invoke();
                        a1.invoke();
                        return h1;
                    }
                    case 1: {
                        a0.invoke();
                        return Boolean.valueOf(p.b(p0));
                    }
                    case 2: {
                        a0.invoke();
                        this.b.invoke(s4.a);
                        return h1;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
            }
            default: {
                b0 b00 = (b0)this.d;
                b0 b01 = (b0)this.e;
                b0 b02 = (b0)this.f;
                k k0 = this.b;
                H h0 = H.a;
                switch(((h)this.c).ordinal()) {
                    case 1: {
                        if(k0 != null) {
                            Boolean boolean0 = (Boolean)b01.getValue();
                            boolean0.booleanValue();
                            k0.invoke(boolean0);
                            return h0;
                        }
                        break;
                    }
                    case 2: {
                        if(k0 != null) {
                            k0.invoke(((Number)b00.getValue()).intValue());
                            return h0;
                        }
                        break;
                    }
                    case 6: {
                        if(k0 != null) {
                            k0.invoke(((String)b02.getValue()));
                            return h0;
                        }
                        break;
                    }
                    default: {
                        if(k0 != null) {
                            k0.invoke(h0);
                            return h0;
                        }
                    }
                }
                return h0;
            }
        }
    }
}

