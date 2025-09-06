package O;

import android.graphics.Typeface;
import android.view.ViewStructure;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import androidx.media3.session.legacy.V;
import e1.M;
import e1.N;
import e1.j;
import e1.k;
import e1.s;
import e1.t;
import e1.y;
import i1.c;
import ie.H;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.o;
import we.p;

public final class h extends r implements p {
    public final int f;
    public final Object g;

    public h(Object object0, int v) {
        this.f = v;
        this.g = object0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        switch(this.f) {
            case 0: {
                ((Number)object1).intValue();
                int v2 = ((Number)object3).intValue();
                if((v2 & 6) == 0) {
                    v2 |= (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2);
                }
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x83) != 130)) {
                    ((o)this.g).invoke(((a)object0), ((androidx.compose.runtime.p)(((l)object2))), ((int)(v2 & 14)));
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 1: {
                c c0 = (c)this.g;
                N n0 = ((k)c0.e).b(((j)object0), ((y)object1), ((s)object2).a, ((t)object3).a);
                if(!(n0 instanceof M)) {
                    V v3 = new V(n0, c0.j);
                    c0.j = v3;
                    Object object4 = v3.c;
                    q.e(object4, "null cannot be cast to non-null type android.graphics.Typeface");
                    return (Typeface)object4;
                }
                q.e(((M)n0).a, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface)((M)n0).a;
            }
            default: {
                int v = ((Number)object0).intValue();
                int v1 = ((Number)object1).intValue();
                ((ViewStructure)this.g).setDimens(v, v1, 0, 0, ((Number)object2).intValue() - v, ((Number)object3).intValue() - v1);
                return H.a;
            }
        }
    }
}

