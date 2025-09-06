package I;

import G.S;
import d5.n;
import ie.H;
import kotlinx.coroutines.sync.Mutex.DefaultImpls;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import ne.a;
import r1.c;

public final class z0 implements v0, c {
    public final c a;
    public boolean b;
    public boolean c;
    public final Mutex d;

    public z0(c c0) {
        this.a = c0;
        this.d = MutexKt.Mutex(false);
    }

    @Override  // r1.c
    public final float B(long v) {
        return this.a.B(v);
    }

    @Override  // r1.c
    public final float R(int v) {
        return this.a.R(v);
    }

    @Override  // r1.c
    public final float S(float f) {
        return this.a.S(f);
    }

    @Override  // r1.c
    public final float W() {
        return this.a.W();
    }

    @Override  // r1.c
    public final float Y(float f) {
        return this.a.Y(f);
    }

    public final Object a(oe.c c0) {
        w0 w00;
        if(c0 instanceof w0) {
            w00 = (w0)c0;
            int v = w00.B;
            if((v & 0x80000000) == 0) {
                w00 = new w0(this, c0);
            }
            else {
                w00.B = v ^ 0x80000000;
            }
        }
        else {
            w00 = new w0(this, c0);
        }
        Object object0 = w00.r;
        a a0 = a.a;
        switch(w00.B) {
            case 0: {
                n.D(object0);
                w00.B = 1;
                object0 = this.g(w00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!((Boolean)object0).booleanValue()) {
            throw new S("The press gesture was canceled.", 2);
        }
        return H.a;
    }

    @Override  // r1.c
    public final float b() {
        return this.a.b();
    }

    public final void d() {
        this.b = true;
        Mutex mutex0 = this.d;
        if(mutex0.isLocked()) {
            DefaultImpls.unlock$default(mutex0, null, 1, null);
        }
    }

    public final Object f(oe.c c0) {
        z0 z00;
        x0 x00;
        if(c0 instanceof x0) {
            x00 = (x0)c0;
            int v = x00.D;
            if((v & 0x80000000) == 0) {
                x00 = new x0(this, c0);
            }
            else {
                x00.D = v ^ 0x80000000;
            }
        }
        else {
            x00 = new x0(this, c0);
        }
        Object object0 = x00.w;
        a a0 = a.a;
        switch(x00.D) {
            case 0: {
                n.D(object0);
                x00.r = this;
                x00.D = 1;
                if(DefaultImpls.lock$default(this.d, null, x00, 1, null) == a0) {
                    return a0;
                }
                z00 = this;
                break;
            }
            case 1: {
                z00 = x00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        z00.b = false;
        z00.c = false;
        return H.a;
    }

    public final Object g(oe.c c0) {
        z0 z00;
        y0 y00;
        if(c0 instanceof y0) {
            y00 = (y0)c0;
            int v = y00.D;
            if((v & 0x80000000) == 0) {
                y00 = new y0(this, c0);
            }
            else {
                y00.D = v ^ 0x80000000;
            }
        }
        else {
            y00 = new y0(this, c0);
        }
        Object object0 = y00.w;
        a a0 = a.a;
        switch(y00.D) {
            case 0: {
                n.D(object0);
                if(!this.b && !this.c) {
                    y00.r = this;
                    y00.D = 1;
                    if(DefaultImpls.lock$default(this.d, null, y00, 1, null) == a0) {
                        return a0;
                    }
                    z00 = this;
                    break;
                }
                return Boolean.valueOf(this.b);
            }
            case 1: {
                z00 = y00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        DefaultImpls.unlock$default(z00.d, null, 1, null);
        return Boolean.valueOf(z00.b);
    }

    @Override  // r1.c
    public final long i0(long v) {
        return this.a.i0(v);
    }

    @Override  // r1.c
    public final long j(float f) {
        return this.a.j(f);
    }

    @Override  // r1.c
    public final long k(long v) {
        return this.a.k(v);
    }

    @Override  // r1.c
    public final float m(long v) {
        return this.a.m(v);
    }

    @Override  // r1.c
    public final long p(float f) {
        return this.a.p(f);
    }

    @Override  // r1.c
    public final int z(float f) {
        return this.a.z(f);
    }
}

