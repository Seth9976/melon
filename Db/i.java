package Db;

import A0.c;
import Hb.g;
import Hb.j;
import Hb.n;
import Hb.o;
import android.util.Log;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;
import we.a;

public final class i {
    public final String a;
    public o b;
    public final c c;

    public i(String s) {
        q.g(o.c, "options");
        super();
        this.a = s;
        this.b = o.c;
        c c0 = new c(14, false);
        c0.b = o.c;
        this.c = c0;
    }

    public static void a(i i0, a a0, a a1, int v) {
        if((v & 2) != 0) {
            a0 = new Vb.i(9);
        }
        i0.getClass();
        i0.d(n.b, a1, null, a0);
    }

    public static void b(i i0, a a0, a a1, int v) {
        if((v & 2) != 0) {
            a0 = new Vb.i(9);
        }
        i0.getClass();
        i0.d(n.e, a1, null, a0);
    }

    public static void c(i i0, a a0, a a1, int v) {
        if((v & 2) != 0) {
            a0 = new Vb.i(9);
        }
        i0.getClass();
        i0.d(n.c, a1, null, a0);
    }

    public final void d(n n0, a a0, Throwable throwable0, a a1) {
        if(h.c.D() && ((Boolean)a1.invoke()).booleanValue()) {
            String s = (String)a0.invoke();
            c c0 = this.c;
            c0.getClass();
            String s1 = this.a;
            q.g(s1, "tag");
            q.g(s, "message");
            j j0 = ((o)c0.b).a;
            if(!j0.equals(g.b)) {
                s1 = s1 + "[" + j0.a + "]";
            }
            if(((o)c0.b).b) {
                q.f("jeb-dexdec-sb-st-2174", "getName(...)");
                s = "[jeb-" + Thread.currentThread().getId() + "]" + " " + s;
            }
            int v = n0.ordinal();
            switch(v) {
                case 0: {
                    Log.v(s1, s, throwable0);
                    break;
                }
                case 1: {
                    Log.d(s1, s, throwable0);
                    return;
                }
                case 2: {
                    Log.i(s1, s, throwable0);
                    return;
                }
                case 3: {
                    Log.w(s1, s, throwable0);
                    return;
                }
                default: {
                    if(v != 4) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    Log.e(s1, s, throwable0);
                }
            }
        }
    }

    public final void e(j j0) {
        if(this.b.a.equals(j0)) {
            return;
        }
        o o0 = o.a(this.b, j0, false, 2);
        this.b = o0;
        this.c.b = o0;
    }

    public static void f(i i0, a a0, a a1, int v) {
        if((v & 2) != 0) {
            a0 = new Vb.i(9);
        }
        i0.getClass();
        i0.d(n.a, a1, null, a0);
    }

    public static void g(i i0, a a0, a a1, int v) {
        if((v & 2) != 0) {
            a0 = new Vb.i(9);
        }
        i0.getClass();
        i0.d(n.d, a1, null, a0);
    }
}

