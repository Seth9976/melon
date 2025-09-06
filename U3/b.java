package u3;

import I6.I;
import I6.Q;
import I6.V;
import I6.m0;
import I6.p0;
import I6.v;
import I6.w0;
import java.util.ArrayList;
import t9.B;

public final class b implements a {
    public final ArrayList a;
    public static final I b;

    static {
        b.b = new I(new v(new B(2), m0.a), new v(new B(3), w0.a));
    }

    public b() {
        this.a = new ArrayList();
    }

    @Override  // u3.a
    public final V a(long v) {
        ArrayList arrayList0 = this.a;
        if(!arrayList0.isEmpty() && v >= ((Y3.a)arrayList0.get(0)).b) {
            ArrayList arrayList1 = new ArrayList();
            for(int v2 = 0; v2 < arrayList0.size(); ++v2) {
                Y3.a a0 = (Y3.a)arrayList0.get(v2);
                if(v >= a0.b && v < a0.d) {
                    arrayList1.add(a0);
                }
                if(v < a0.b) {
                    break;
                }
            }
            p0 p00 = V.w(b.b, arrayList1);
            Q q0 = V.o();
            for(int v1 = 0; v1 < p00.d; ++v1) {
                q0.d(((Y3.a)p00.get(v1)).a);
            }
            return q0.g();
        }
        return p0.e;
    }

    @Override  // u3.a
    public final boolean b(Y3.a a0, long v) {
        long v1 = a0.b;
        e3.b.c(Long.compare(v1, 0x8000000000000001L) != 0);
        e3.b.c(a0.c != 0x8000000000000001L);
        boolean z = v1 <= v && v < a0.d;
        ArrayList arrayList0 = this.a;
        for(int v2 = arrayList0.size() - 1; v2 >= 0; --v2) {
            if(v1 >= ((Y3.a)arrayList0.get(v2)).b) {
                arrayList0.add(v2 + 1, a0);
                return z;
            }
        }
        arrayList0.add(0, a0);
        return z;
    }

    @Override  // u3.a
    public final long c(long v) {
        ArrayList arrayList0 = this.a;
        if(!arrayList0.isEmpty() && v >= ((Y3.a)arrayList0.get(0)).b) {
            long v2 = ((Y3.a)arrayList0.get(0)).b;
            for(int v1 = 0; v1 < arrayList0.size(); ++v1) {
                long v3 = ((Y3.a)arrayList0.get(v1)).b;
                long v4 = ((Y3.a)arrayList0.get(v1)).d;
                if(v4 <= v) {
                    v2 = Math.max(v2, v4);
                }
                else {
                    if(v3 > v) {
                        break;
                    }
                    v2 = Math.max(v2, v3);
                }
            }
            return v2;
        }
        return 0x8000000000000001L;
    }

    @Override  // u3.a
    public final void clear() {
        this.a.clear();
    }

    @Override  // u3.a
    public final long d(long v) {
        long v2 = 0x8000000000000001L;
        for(int v1 = 0; true; ++v1) {
            ArrayList arrayList0 = this.a;
            if(v1 >= arrayList0.size()) {
                break;
            }
            long v3 = ((Y3.a)arrayList0.get(v1)).b;
            long v4 = ((Y3.a)arrayList0.get(v1)).d;
            if(v < v3) {
                if(v2 == 0x8000000000000001L) {
                    return v3 == 0x8000000000000001L ? 0x8000000000000000L : v3;
                }
                v2 = Math.min(v2, v3);
                return v2 == 0x8000000000000001L ? 0x8000000000000000L : v2;
            }
            if(v < v4) {
                v2 = v2 == 0x8000000000000001L ? v4 : Math.min(v2, v4);
            }
        }
        return v2 == 0x8000000000000001L ? 0x8000000000000000L : v2;
    }

    @Override  // u3.a
    public final void e(long v) {
        for(int v1 = 0; true; ++v1) {
            ArrayList arrayList0 = this.a;
            if(v1 >= arrayList0.size()) {
                break;
            }
            int v2 = Long.compare(v, ((Y3.a)arrayList0.get(v1)).b);
            if(v2 > 0 && v > ((Y3.a)arrayList0.get(v1)).d) {
                arrayList0.remove(v1);
                --v1;
            }
            else if(v2 < 0) {
                break;
            }
        }
    }
}

