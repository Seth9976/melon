package Dd;

import Bc.i;
import Ge.o0;
import Kd.g;
import Q0.k0;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.common.LinkInfoBase;
import ie.f;
import java.util.List;
import kotlin.jvm.internal.q;
import ld.m;
import w0.h;
import we.a;
import we.k;
import we.o;

public final class k1 implements o {
    public final int a;
    public final f b;
    public final Object c;
    public final int d;
    public final Object e;
    public final Object f;

    public k1(String s, a a0, g g0, m m0, int v) {
        this.a = 4;
        super();
        this.c = s;
        this.b = a0;
        this.e = g0;
        this.f = m0;
        this.d = v;
    }

    public k1(List list0, int v, k k0, Context context0, a a0) {
        this.a = 3;
        super();
        this.c = list0;
        this.d = v;
        this.b = k0;
        this.e = context0;
        this.f = a0;
    }

    public k1(a a0, k k0, String s, String s1, int v) {
        this.a = 1;
        super();
        this.e = a0;
        this.b = k0;
        this.c = s;
        this.f = s1;
        this.d = v;
    }

    public k1(k k0, Context context0, List list0, int v, k k1) {
        this.a = 2;
        super();
        this.b = k0;
        this.c = context0;
        this.e = list0;
        this.d = v;
        this.f = k1;
    }

    public k1(k k0, String s, LinkInfoBase linkInfoBase0, i i0, int v) {
        this.a = 0;
        super();
        this.b = k0;
        this.c = s;
        this.e = linkInfoBase0;
        this.f = i0;
        this.d = v;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.a) {
            case 0: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object3 = ((p)(((l)object1))).k(k0.i);
                K.m m1 = ((p)(((l)object1))).N();
                if(m1 == androidx.compose.runtime.k.a) {
                    m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new X0.i(0), new j1(((h)object3), ((k)this.b), ((String)this.c), ((LinkInfoBase)this.e), ((i)this.f), this.d));
                ((p)(((l)object1))).p(false);
                return q1;
            }
            case 1: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object4 = ((p)(((l)object1))).k(k0.i);
                K.m m2 = ((p)(((l)object1))).N();
                if(m2 == androidx.compose.runtime.k.a) {
                    m2 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q2 = androidx.compose.foundation.q.l(((r0.q)object0), m2, null, true, null, new X0.i(0), new j1(((h)object4), ((a)this.e), ((k)this.b), ((String)this.c), ((String)this.f), this.d));
                ((p)(((l)object1))).p(false);
                return q2;
            }
            case 2: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object5 = ((p)(((l)object1))).k(k0.i);
                K.m m3 = ((p)(((l)object1))).N();
                if(m3 == androidx.compose.runtime.k.a) {
                    m3 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q3 = androidx.compose.foundation.q.l(((r0.q)object0), m3, null, true, null, new X0.i(0), new j1(((h)object5), ((k)this.b), ((Context)this.c), ((List)this.e), this.d, ((k)this.f)));
                ((p)(((l)object1))).p(false);
                return q3;
            }
            case 3: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object6 = ((p)(((l)object1))).k(k0.i);
                K.m m4 = ((p)(((l)object1))).N();
                if(m4 == androidx.compose.runtime.k.a) {
                    m4 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q4 = androidx.compose.foundation.q.l(((r0.q)object0), m4, null, true, null, new X0.i(0), new j1(((h)object6), ((List)this.c), this.d, ((k)this.b), ((Context)this.e), ((a)this.f)));
                ((p)(((l)object1))).p(false);
                return q4;
            }
            default: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x6D4D6540);
                K.m m0 = ((p)(((l)object1))).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                X0.i i0 = new X0.i(0);
                o0 o00 = new o0(((g)this.e), ((m)this.f), this.d, 4);
                r0.q q0 = androidx.compose.foundation.q.o(((r0.q)object0), m0, ((String)this.c), i0, null, ((a)this.b), o00, 388);
                ((p)(((l)object1))).p(false);
                return q0;
            }
        }
    }
}

