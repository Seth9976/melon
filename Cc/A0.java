package Cc;

import Ac.A;
import K.m;
import Q0.k0;
import U8.h;
import X0.i;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.lyric.LyricsInfo;
import kotlin.jvm.internal.q;
import we.a;
import we.o;

public final class a0 implements o {
    public final int a;
    public final boolean b;
    public final int c;
    public final Object d;
    public final Object e;

    public a0(int v, int v1, Object object0, Object object1, boolean z) {
        this.a = v1;
        this.b = z;
        this.d = object0;
        this.c = v;
        this.e = object1;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            ((Number)object2).intValue();
            q.g(((r0.q)object0), "$this$composed");
            ((p)(((l)object1))).a0(0x1FF03545);
            Object object3 = ((p)(((l)object1))).k(k0.i);
            m m0 = ((p)(((l)object1))).N();
            if(m0 == k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
            }
            r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new h(((w0.h)object3), this.b, ((we.k)this.d), this.c, ((LyricsInfo)this.e)));
            ((p)(((l)object1))).p(false);
            return q0;
        }
        ((Number)object2).intValue();
        q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x1FF03545);
        w0.h h0 = (w0.h)((p)(((l)object1))).k(k0.i);
        m m1 = ((p)(((l)object1))).N();
        if(m1 == k.a) {
            m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        i i0 = new i(this.c);
        A a0 = new A(h0, ((a)this.e), 22);
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, this.b, ((String)this.d), i0, a0);
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

