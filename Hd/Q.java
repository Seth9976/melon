package hd;

import K.m;
import Q0.k0;
import X0.i;
import android.content.Context;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.LIKETOPINFO.LIKEIMGINFO;
import w0.h;
import we.k;
import we.o;

public final class q implements o {
    public final int a;
    public final boolean b;
    public final k c;
    public final LIKEIMGINFO d;
    public final Context e;
    public final String f;
    public final String g;

    public q(boolean z, k k0, LIKEIMGINFO musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0, Context context0, String s, String s1, int v) {
        this.a = v;
        this.b = z;
        this.c = k0;
        this.d = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO$LIKEIMGINFO0;
        this.e = context0;
        this.f = s;
        this.g = s1;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            ((Number)object2).intValue();
            kotlin.jvm.internal.q.g(((r0.q)object0), "$this$composed");
            ((p)(((l)object1))).a0(0x1FF03545);
            Object object3 = ((p)(((l)object1))).k(k0.i);
            m m0 = ((p)(((l)object1))).N();
            if(m0 == androidx.compose.runtime.k.a) {
                m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
            }
            r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new hd.p(((h)object3), this.b, this.c, this.d, this.e, this.f, this.g, 1));
            ((p)(((l)object1))).p(false);
            return q0;
        }
        ((Number)object2).intValue();
        kotlin.jvm.internal.q.g(((r0.q)object0), "$this$composed");
        ((p)(((l)object1))).a0(0x1FF03545);
        Object object4 = ((p)(((l)object1))).k(k0.i);
        m m1 = ((p)(((l)object1))).N();
        if(m1 == androidx.compose.runtime.k.a) {
            m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
        }
        r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new hd.p(((h)object4), this.b, this.c, this.d, this.e, this.f, this.g, 0));
        ((p)(((l)object1))).p(false);
        return q1;
    }
}

