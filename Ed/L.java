package ed;

import Ac.U2;
import M.Q;
import androidx.compose.runtime.p;
import com.iloen.melon.net.v6x.response.SearchTagBase;
import df.d;
import e.k;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.o;

public final class l implements o {
    public final int a;
    public final ArrayList b;
    public final int c;
    public final U2 d;
    public final v0 e;
    public final Object f;

    public l(ArrayList arrayList0, int v, U2 u20, K0 k00, v0 v00) {
        this.a = 1;
        super();
        this.b = arrayList0;
        this.c = v;
        this.d = u20;
        this.f = k00;
        this.e = v00;
    }

    public l(ArrayList arrayList0, int v, U2 u20, v0 v00, o o0) {
        this.a = 0;
        super();
        this.b = arrayList0;
        this.c = v;
        this.d = u20;
        this.e = v00;
        this.f = o0;
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.a != 0) {
            K0 k00 = (K0)this.f;
            int v = (int)(((Integer)object2));
            q.g(((Q)object0), "$this$FlowRow");
            if(((p)(((androidx.compose.runtime.l)object1))).Q(v & 1, (v & 17) != 16)) {
                ArrayList arrayList0 = this.b;
                if(arrayList0 == null) {
                    ((p)(((androidx.compose.runtime.l)object1))).a0(0x892E250A);
                }
                else {
                    ((p)(((androidx.compose.runtime.l)object1))).a0(0x892E250B);
                    int v1 = 0;
                    for(Object object3: arrayList0) {
                        if(v1 >= 0) {
                            d.k(((SearchTagBase)object3), this.c, v1, this.d, k00.d, this.e, ((p)(((androidx.compose.runtime.l)object1))), 0);
                            ++v1;
                            continue;
                        }
                        k.O();
                        throw null;
                    }
                }
                ((p)(((androidx.compose.runtime.l)object1))).p(false);
                return H.a;
            }
            ((p)(((androidx.compose.runtime.l)object1))).T();
            return H.a;
        }
        o o0 = (o)this.f;
        int v2 = (int)(((Integer)object2));
        q.g(((Q)object0), "$this$FlowRow");
        if(((p)(((androidx.compose.runtime.l)object1))).Q(v2 & 1, (v2 & 17) != 16)) {
            ArrayList arrayList1 = this.b;
            if(arrayList1 == null) {
                ((p)(((androidx.compose.runtime.l)object1))).a0(-1911060375);
            }
            else {
                ((p)(((androidx.compose.runtime.l)object1))).a0(-1911060374);
                int v3 = 0;
                for(Object object4: arrayList1) {
                    if(v3 >= 0) {
                        q.d(((SearchTagBase)object4));
                        d.h(((SearchTagBase)object4), this.c, v3, this.d, this.e, o0, ((p)(((androidx.compose.runtime.l)object1))), 0);
                        ++v3;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
            ((p)(((androidx.compose.runtime.l)object1))).p(false);
            return H.a;
        }
        ((p)(((androidx.compose.runtime.l)object1))).T();
        return H.a;
    }
}

