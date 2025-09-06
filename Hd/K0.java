package hd;

import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import ed.w0;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.F;
import we.k;
import we.n;

public final class k0 implements n {
    public final int a;
    public final A1 b;
    public final k c;

    public k0(int v, A1 a10, k k0) {
        this.a = v;
        this.b = a10;
        this.c = k0;
        super();
    }

    public k0(A1 a10, k k0, int v, int v1) {
        this.a = v1;
        this.b = a10;
        this.c = k0;
        super();
    }

    public k0(k k0, A1 a10) {
        this.a = 4;
        super();
        this.c = k0;
        this.b = a10;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                o0.a(this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                o0.a(this.b, this.c, ((l)object0), 1);
                return H.a;
            }
            case 2: {
                int v1 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    A1 a11 = this.b;
                    ArrayList arrayList0 = a11.h.albumList;
                    List list0 = arrayList0 == null ? null : je.p.K0(3, arrayList0);
                    F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f0.a = 1;
                    if((list0 == null ? 0 : list0.size()) == 3) {
                        f0.a = 0;
                    }
                    f0.g(0.0f, false, f0.a, new m0(f0, this.c, a11.d, a11.e, 2), ((p)(((l)object0))), 0, 3);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            case 3: {
                int v2 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v2 & 1, (v2 & 3) != 2)) {
                    A1 a12 = this.b;
                    ArrayList arrayList1 = a12.j.mvList;
                    List list1 = arrayList1 == null ? null : je.p.K0(3, arrayList1);
                    F f1 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                    f1.a = 1;
                    if((list1 == null ? 0 : list1.size()) == 3) {
                        f1.a = 0;
                    }
                    f0.g(0.0f, false, f1.a, new m0(f1, this.c, a12.d, a12.e, 1), ((p)(((l)object0))), 0x30, 1);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
            default: {
                int v = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
                    k k0 = this.c;
                    boolean z = ((p)(((l)object0))).g(k0);
                    A1 a10 = this.b;
                    boolean z1 = ((p)(((l)object0))).i(a10);
                    w0 w00 = ((p)(((l)object0))).N();
                    if(z || z1 || w00 == androidx.compose.runtime.k.a) {
                        w00 = new w0(13, k0, a10);
                        ((p)(((l)object0))).l0(w00);
                    }
                    f0.g(0.0f, false, 1, w00, ((p)(((l)object0))), 0x180, 3);
                    return H.a;
                }
                ((p)(((l)object0))).T();
                return H.a;
            }
        }
    }
}

