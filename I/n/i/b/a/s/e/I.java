package i.n.i.b.a.s.e;

import android.util.Pair;

public abstract class i {
    public static final f a;

    static {
        i.a = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public abstract int a();

    public int b(int v, int v1, boolean z) {
        switch(v1) {
            case 0: {
                return v == this.n(z) ? -1 : v + 1;
            }
            case 1: {
                return v;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException();
                }
                return v == this.n(z) ? this.e(z) : v + 1;
            }
        }
    }

    public final int c(int v, g g0, h h0, int v1, boolean z) {
        int v2 = this.h(v, g0, false).c;
        if(this.j(v2, h0, 0L).p == v) {
            int v3 = this.b(v2, v1, z);
            return v3 == -1 ? -1 : this.j(v3, h0, 0L).o;
        }
        return v + 1;
    }

    public abstract int d(Object arg1);

    // 去混淆评级： 低(20)
    public int e(boolean z) {
        return this.p() ? -1 : 0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof i && ((i)object0).l() == this.l() && ((i)object0).a() == this.a()) {
                h h0 = new h();
                g g0 = new g();
                h h1 = new h();
                g g1 = new g();
                for(int v = 0; v < this.l(); ++v) {
                    if(!this.j(v, h0, 0L).equals(((i)object0).j(v, h1, 0L))) {
                        return false;
                    }
                }
                for(int v1 = 0; v1 < this.a(); ++v1) {
                    if(!this.h(v1, g0, true).equals(((i)object0).h(v1, g1, true))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final Pair f(h h0, g g0, int v, long v1) {
        Pair pair0 = this.g(h0, g0, v, v1, 0L);
        pair0.getClass();
        return pair0;
    }

    public final Pair g(h h0, g g0, int v, long v1, long v2) {
        M7.z(v, this.l());
        this.j(v, h0, v2);
        if(v1 == 0x8000000000000001L) {
            v1 = h0.m;
            if(v1 == 0x8000000000000001L) {
                return null;
            }
        }
        int v3 = h0.o;
        this.h(v3, g0, false);
        while(v3 < h0.p && g0.e != v1 && this.h(v3 + 1, g0, false).e <= v1) {
            ++v3;
        }
        this.h(v3, g0, true);
        long v4 = v1 - g0.e;
        Object object0 = g0.b;
        object0.getClass();
        return Pair.create(object0, v4);
    }

    public abstract g h(int arg1, g arg2, boolean arg3);

    @Override
    public final int hashCode() {
        h h0 = new h();
        g g0 = new g();
        int v = this.l() + 0xD9;
        for(int v2 = 0; v2 < this.l(); ++v2) {
            v = v * 0x1F + this.j(v2, h0, 0L).hashCode();
        }
        int v3 = this.a() + v * 0x1F;
        for(int v1 = 0; v1 < this.a(); ++v1) {
            v3 = v3 * 0x1F + this.h(v1, g0, true).hashCode();
        }
        return v3;
    }

    public g i(Object object0, g g0) {
        return this.h(this.d(object0), g0, true);
    }

    public abstract h j(int arg1, h arg2, long arg3);

    public final void k(int v, h h0) {
        this.j(v, h0, 0L);
    }

    public abstract int l();

    public int m(int v, int v1, boolean z) {
        switch(v1) {
            case 0: {
                return v == this.e(z) ? -1 : v - 1;
            }
            case 1: {
                return v;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException();
                }
                return v == this.e(z) ? this.n(z) : v - 1;
            }
        }
    }

    // 去混淆评级： 低(20)
    public int n(boolean z) {
        return this.p() ? -1 : this.l() - 1;
    }

    public abstract Object o(int arg1);

    public final boolean p() {
        return this.l() == 0;
    }
}

