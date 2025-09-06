package kd;

import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import com.melon.ui.s4;
import ie.H;
import jd.G2;
import jd.H2;
import jd.N;
import jd.P;
import jd.V;
import jd.Y;
import jd.d0;
import jd.m3;
import jd.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sc.A2;
import sc.D2;
import sc.E2;
import sc.I2;
import sc.S2;
import sc.u2;
import sc.v2;
import sc.z2;
import w0.h;
import we.a;
import we.k;
import zd.B;

public final class j implements a {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public j(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    public j(h h0, Object object0, k k0, int v) {
        this.a = v;
        this.b = h0;
        this.d = object0;
        this.c = k0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                h.a(((h)this.b));
                ((k)this.c).invoke(Boolean.FALSE);
                ((k)this.d).invoke(m3.c);
                return H.a;
            }
            case 1: {
                h.a(((h)this.b));
                String s = ((p)this.d).b;
                if(s != null) {
                    d0 d00 = new d0(s);
                    ((k)this.c).invoke(d00);
                }
                return H.a;
            }
            case 2: {
                h.a(((h)this.b));
                Y y0 = new Y(((G2)this.d).c);
                ((k)this.c).invoke(y0);
                return H.a;
            }
            case 3: {
                h.a(((h)this.b));
                ((a)this.d).invoke();
                ((k)this.c).invoke(s4.a);
                return H.a;
            }
            case 4: {
                h.a(((h)this.b));
                boolean z = q.b(((N)this.d).r, ((N)this.d).D);
                V v0 = new V(((N)this.d).d, ((N)this.d).b, z);
                ((k)this.c).invoke(v0);
                return H.a;
            }
            case 5: {
                h.a(((h)this.b));
                if(((H2)this.d) != H2.c) {
                    P p0 = new P(false);
                    ((k)this.c).invoke(p0);
                }
                return H.a;
            }
            case 6: {
                ((S2)this.b).d.dequeueAndClear(((v2)this.c));
                u2 u20 = new u2(((S2)this.b), ((String)this.d), null);
                BuildersKt__Builders_commonKt.launch$default(((S2)this.b).c, null, null, u20, 3, null);
                return H.a;
            }
            case 7: {
                ((S2)this.b).d.dequeueAndClear(((A2)this.c));
                z2 z20 = new z2(((S2)this.b), ((String)this.d), null);
                BuildersKt__Builders_commonKt.launch$default(((S2)this.b).c, null, null, z20, 3, null);
                return H.a;
            }
            case 8: {
                ((a)this.b).invoke();
                ((S2)this.c).d.dequeue(((E2)this.d));
                return H.a;
            }
            case 9: {
                ((S2)this.b).d.dequeueAndClear(((E2)this.c));
                D2 d20 = new D2(((S2)this.b), ((String)this.d), null);
                BuildersKt__Builders_commonKt.launch$default(((S2)this.b).c, null, null, d20, 3, null);
                ((S2)this.b).d.start();
                return H.a;
            }
            case 10: {
                ((S2)this.b).d.dequeueAndClear(((I2)this.c));
                sc.H2 h20 = new sc.H2(((S2)this.b), ((String)this.d), null);
                BuildersKt__Builders_commonKt.launch$default(((S2)this.b).c, null, null, h20, 3, null);
                ((S2)this.b).d.start();
                return H.a;
            }
            default: {
                h.a(((h)this.b));
                if(((MelonBottomSheetItem)this.d).e) {
                    ((k)this.c).invoke(B.a);
                }
                return H.a;
            }
        }
    }
}

