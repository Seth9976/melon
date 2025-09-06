package hd;

import K.m;
import Q0.k0;
import X0.i;
import android.content.Context;
import androidx.compose.runtime.a0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.LIKETOPINFO.LIKEIMGINFO;
import jd.q2;
import kotlin.jvm.internal.q;
import w0.h;
import we.k;
import we.o;

public final class s implements o {
    public final int a;
    public final Object b;
    public final k c;
    public final Context d;
    public final Object e;
    public final Object f;

    public s(Object object0, k k0, Context context0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = k0;
        this.d = context0;
        this.e = object1;
        this.f = object2;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        switch(this.a) {
            case 0: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object4 = ((p)(((l)object1))).k(k0.i);
                m m1 = ((p)(((l)object1))).N();
                if(m1 == androidx.compose.runtime.k.a) {
                    m1 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q1 = androidx.compose.foundation.q.l(((r0.q)object0), m1, null, true, null, new i(0), new r(((h)object4), ((LIKEIMGINFO)this.b), this.c, this.d, ((String)this.e), ((String)this.f), 0));
                ((p)(((l)object1))).p(false);
                return q1;
            }
            case 1: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object5 = ((p)(((l)object1))).k(k0.i);
                m m2 = ((p)(((l)object1))).N();
                if(m2 == androidx.compose.runtime.k.a) {
                    m2 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q2 = androidx.compose.foundation.q.l(((r0.q)object0), m2, null, true, null, new i(0), new r(((h)object5), ((LIKEIMGINFO)this.b), this.c, this.d, ((String)this.e), ((String)this.f), 1));
                ((p)(((l)object1))).p(false);
                return q2;
            }
            default: {
                ((Number)object2).intValue();
                q.g(((r0.q)object0), "$this$composed");
                ((p)(((l)object1))).a0(0x1FF03545);
                Object object3 = ((p)(((l)object1))).k(k0.i);
                m m0 = ((p)(((l)object1))).N();
                if(m0 == androidx.compose.runtime.k.a) {
                    m0 = androidx.appcompat.app.o.d(((p)(((l)object1))));
                }
                r0.q q0 = androidx.compose.foundation.q.l(((r0.q)object0), m0, null, true, null, new i(0), new r(((h)object3), ((b0)this.b), this.c, this.d, ((q2)this.e), ((a0)this.f), 2));
                ((p)(((l)object1))).p(false);
                return q0;
            }
        }
    }
}

