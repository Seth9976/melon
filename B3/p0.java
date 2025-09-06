package b3;

import android.util.Pair;
import e3.b;

public abstract class p0 {
    public static final l0 a;
    public static final String b;
    public static final String c;
    public static final String d;

    static {
        p0.a = new l0();  // 初始化器: Ljava/lang/Object;-><init>()V
        p0.b = "0";
        p0.c = "1";
        p0.d = "2";
    }

    // 去混淆评级： 低(20)
    public int a(boolean z) {
        return this.p() ? -1 : 0;
    }

    public abstract int b(Object arg1);

    // 去混淆评级： 低(20)
    public int c(boolean z) {
        return this.p() ? -1 : this.o() - 1;
    }

    public final int d(int v, m0 m00, o0 o00, int v1, boolean z) {
        int v2 = this.f(v, m00, false).c;
        if(this.m(v2, o00, 0L).o == v) {
            int v3 = this.e(v2, v1, z);
            return v3 == -1 ? -1 : this.m(v3, o00, 0L).n;
        }
        return v + 1;
    }

    public int e(int v, int v1, boolean z) {
        switch(v1) {
            case 0: {
                return v == this.c(z) ? -1 : v + 1;
            }
            case 1: {
                return v;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException();
                }
                return v == this.c(z) ? this.a(z) : v + 1;
            }
        }
    }

    @Override
    public boolean equals(Object object0) {
        if(this != object0) {
            if(object0 instanceof p0 && ((p0)object0).o() == this.o() && ((p0)object0).h() == this.h()) {
                o0 o00 = new o0();
                m0 m00 = new m0();
                o0 o01 = new o0();
                m0 m01 = new m0();
                for(int v = 0; v < this.o(); ++v) {
                    if(!this.m(v, o00, 0L).equals(((p0)object0).m(v, o01, 0L))) {
                        return false;
                    }
                }
                for(int v1 = 0; v1 < this.h(); ++v1) {
                    if(!this.f(v1, m00, true).equals(((p0)object0).f(v1, m01, true))) {
                        return false;
                    }
                }
                int v2 = this.a(true);
                if(v2 == ((p0)object0).a(true)) {
                    int v3 = this.c(true);
                    if(v3 == ((p0)object0).c(true)) {
                        while(v2 != v3) {
                            int v4 = this.e(v2, 0, true);
                            if(v4 != ((p0)object0).e(v2, 0, true)) {
                                return false;
                            }
                            v2 = v4;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public abstract m0 f(int arg1, m0 arg2, boolean arg3);

    public m0 g(Object object0, m0 m00) {
        return this.f(this.b(object0), m00, true);
    }

    public abstract int h();

    @Override
    public int hashCode() {
        o0 o00 = new o0();
        m0 m00 = new m0();
        int v = this.o() + 0xD9;
        for(int v1 = 0; v1 < this.o(); ++v1) {
            v = v * 0x1F + this.m(v1, o00, 0L).hashCode();
        }
        int v2 = this.h() + v * 0x1F;
        for(int v3 = 0; v3 < this.h(); ++v3) {
            v2 = v2 * 0x1F + this.f(v3, m00, true).hashCode();
        }
        for(int v4 = this.a(true); v4 != -1; v4 = this.e(v4, 0, true)) {
            v2 = v2 * 0x1F + v4;
        }
        return v2;
    }

    public final Pair i(o0 o00, m0 m00, int v, long v1) {
        Pair pair0 = this.j(o00, m00, v, v1, 0L);
        pair0.getClass();
        return pair0;
    }

    public final Pair j(o0 o00, m0 m00, int v, long v1, long v2) {
        b.g(v, this.o());
        this.m(v, o00, v2);
        if(v1 == 0x8000000000000001L) {
            v1 = o00.l;
            if(v1 == 0x8000000000000001L) {
                return null;
            }
        }
        int v3 = o00.n;
        this.f(v3, m00, false);
        while(v3 < o00.o && m00.e != v1 && this.f(v3 + 1, m00, false).e <= v1) {
            ++v3;
        }
        this.f(v3, m00, true);
        long v4 = v1 - m00.e;
        long v5 = m00.d;
        if(v5 != 0x8000000000000001L) {
            v4 = Math.min(v4, v5 - 1L);
        }
        Object object0 = m00.b;
        object0.getClass();
        return Pair.create(object0, Math.max(0L, v4));
    }

    public int k(int v, int v1, boolean z) {
        switch(v1) {
            case 0: {
                return v == this.a(z) ? -1 : v - 1;
            }
            case 1: {
                return v;
            }
            default: {
                if(v1 != 2) {
                    throw new IllegalStateException();
                }
                return v == this.a(z) ? this.c(z) : v - 1;
            }
        }
    }

    public abstract Object l(int arg1);

    public abstract o0 m(int arg1, o0 arg2, long arg3);

    public final void n(int v, o0 o00) {
        this.m(v, o00, 0L);
    }

    public abstract int o();

    public final boolean p() {
        return this.o() == 0;
    }
}

