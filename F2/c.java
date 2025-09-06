package f2;

import android.graphics.RectF;
import androidx.appcompat.app.o;
import androidx.datastore.preferences.protobuf.m;
import c2.B0;
import c2.l0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends m {
    public final HashMap c;
    public final d d;

    public c(d d0) {
        this.d = d0;
        super(0);
        this.c = new HashMap();
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void d(l0 l00) {
        ArrayList arrayList0 = this.d.b;
        if((l00.a.d() & 0x207) != 0) {
            this.c.remove(l00);
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                a a0 = (a)arrayList0.get(v);
                int v1 = a0.c;
                a0.c = v1 - 1;
                if(v1 > 0 && v1 - 1 == 0) {
                    ArrayList arrayList1 = a0.a;
                    int v2 = arrayList1.size() - 1;
                    if(v2 >= 0) {
                        throw o.g(v2, arrayList1);
                    }
                }
            }
        }
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final void e(l0 l00) {
        ArrayList arrayList0 = this.d.b;
        if((l00.a.d() & 0x207) != 0) {
            for(int v = arrayList0.size() - 1; v >= 0; --v) {
                a a0 = (a)arrayList0.get(v);
                ++a0.c;
            }
        }
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final B0 f(B0 b00, List list0) {
        ArrayList arrayList0 = this.d.b;
        RectF rectF0 = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
        for(int v = list0.size() - 1; v >= 0; --v) {
            l0 l00 = (l0)list0.get(v);
            Integer integer0 = (Integer)this.c.get(l00);
            if(integer0 != null) {
                int v1 = (int)integer0;
                float f = l00.a.a();
                if((v1 & 1) != 0) {
                    rectF0.left = f;
                }
                if((v1 & 2) != 0) {
                    rectF0.top = f;
                }
                if((v1 & 4) != 0) {
                    rectF0.right = f;
                }
                if((v1 & 8) != 0) {
                    rectF0.bottom = f;
                }
            }
        }
        S1.d.b(b00.a.g(0x207), b00.a.g(0x40));
        for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
            ArrayList arrayList1 = ((a)arrayList0.get(v2)).a;
            int v3 = arrayList1.size() - 1;
            if(v3 >= 0) {
                throw o.g(v3, arrayList1);
            }
        }
        return b00;
    }

    @Override  // androidx.datastore.preferences.protobuf.m
    public final x9.c g(l0 l00, x9.c c0) {
        if((l00.a.d() & 0x207) != 0) {
            S1.d d0 = (S1.d)c0.c;
            S1.d d1 = (S1.d)c0.b;
            int v = d0.a == d1.a ? 0 : 1;
            if(d0.b != d1.b) {
                v |= 2;
            }
            if(d0.c != d1.c) {
                v |= 4;
            }
            if(d0.d != d1.d) {
                v |= 8;
            }
            this.c.put(l00, v);
        }
        return c0;
    }
}

