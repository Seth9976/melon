package i.n.i.b.a.s.e;

import ea.b;
import java.util.ArrayList;

public final class q1 implements B7 {
    public final ArrayList a;
    public B7 b;
    public long c;
    public boolean d;
    public u e;
    public final b f;
    public final I8 g;

    public q1(B7 b70) {
        this.b = b70;
        this.c = 0x8000000000000001L;
        this.a = new ArrayList();
        this.f = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.g = new I8(1);
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int b(b b0, I8 i80, int v) {
        if(Long.compare(this.c, 0x8000000000000001L) == 0) {
            B7 b70 = this.b;
            I8 i81 = new I8(1);
            long v1 = b70.b(b0, i81, 1) == -4 ? i81.f : 0x8000000000000001L;
            if(v1 != 0x8000000000000001L) {
                this.c = v1;
            }
        }
        ArrayList arrayList0 = this.a;
        if(!arrayList0.isEmpty()) {
            if(((e7)arrayList0.get(0)).l(false)) {
                int v2 = ((e7)arrayList0.get(0)).i(b0, i80, v, false);
                if(v2 == -4) {
                    if(this.c != 0x8000000000000001L && i80.f >= this.c) {
                        arrayList0.clear();
                        i80.o();
                        return -3;
                    }
                    if(arrayList0.size() >= 2 && (((e7)arrayList0.get(1)).i(this.f, this.g, 1, false) == -4 && this.g.f < i80.f)) {
                        arrayList0.remove(0);
                        i80.o();
                        return -3;
                    }
                }
                else {
                    if(v2 == -5) {
                        if(this.e == null || (v & 2) != 0 || !this.e.equals(((u)b0.b))) {
                            this.e = (u)b0.b;
                            return -5;
                        }
                        return -3;
                    }
                    if(v2 == -3) {
                        arrayList0.remove(0);
                    }
                }
                return v2;
            }
            arrayList0.remove(0);
            return -3;
        }
        int v3 = this.b.b(b0, i80, v);
        if(v3 == -4) {
            i80.b &= 0x7FFFFFFF;
            if(this.d) {
                i80.d(0x4000000);
                this.d = false;
                return -4;
            }
            return -4;
        }
        return v3 != -5 || (v & 2) != 0 || !L7.p(this.e, ((u)b0.b)) ? v3 : -3;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void b() {
        synchronized(this) {
            this.b.b();
        }
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int c(long v) {
        ArrayList arrayList0 = this.a;
        int v1 = 0;
        if(!arrayList0.isEmpty()) {
            for(Object object0: arrayList0) {
                int v2 = ((e7)object0).h(v, true);
                ((e7)object0).A(v2);
                v1 += v2;
            }
        }
        return this.b.c(v) + v1;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final void c(q2 q20) {
        this.b.c(q20);
    }

    // 去混淆评级： 低(20)
    @Override  // i.n.i.b.a.s.e.B7
    public final boolean d() {
        return this.a.isEmpty() || !((e7)this.a.get(0)).l(false) ? this.b.d() : true;
    }

    @Override  // i.n.i.b.a.s.e.B7
    public final int j() {
        return this.b.j();
    }
}

