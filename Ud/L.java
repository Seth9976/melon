package ud;

import N0.v;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.Z;
import ie.H;
import kotlin.jvm.internal.q;
import we.k;
import yc.b;

public final class l implements k {
    public final int a;
    public final Z b;

    public l(Z z0, int v) {
        this.a = v;
        this.b = z0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                ((I0)this.b).n(((float)(((Float)object0))));
                return H.a;
            }
            case 1: {
                q.g(((v)object0), "coordinates");
                if(Float.intBitsToFloat(((int)(((v)object0).j0(0L) & 0xFFFFFFFFL))) < b.f) {
                    ((I0)this.b).n(1.0f);
                }
                return H.a;
            }
            default: {
                q.g(((v)object0), "coordinates");
                if(Float.intBitsToFloat(((int)(((v)object0).j0(0L) & 0xFFFFFFFFL))) < b.f) {
                    ((I0)this.b).n(1.0f);
                }
                return H.a;
            }
        }
    }
}

