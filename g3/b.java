package g3;

import android.os.SystemClock;
import java.util.ArrayList;

public abstract class b implements f {
    public final boolean a;
    public final ArrayList b;
    public int c;
    public j d;

    public b(boolean z) {
        this.a = z;
        this.b = new ArrayList(1);
    }

    public final void a(int v) {
        j j0 = this.d;
        for(int v1 = 0; v1 < this.c; ++v1) {
            w3.f f0 = (w3.f)(((x)this.b.get(v1)));
            synchronized(f0) {
                if(this.a && (j0.h & 8) != 8) {
                    f0.h += (long)v;
                }
            }
        }
    }

    public final void b() {
        j j0 = this.d;
        for(int v = 0; v < this.c; ++v) {
            w3.f f0 = (w3.f)(((x)this.b.get(v)));
            synchronized(f0) {
                if(this.a && (j0.h & 8) != 8) {
                    e3.b.j(f0.f > 0);
                    f0.c.getClass();
                    long v2 = SystemClock.elapsedRealtime();
                    int v3 = (int)(v2 - f0.g);
                    f0.i += (long)v3;
                    long v4 = f0.h;
                    f0.j += v4;
                    if(v3 > 0) {
                        f0.e.a(((int)Math.sqrt(v4)), ((float)v4) * 8000.0f / ((float)v3));
                        if(f0.i >= 2000L || f0.j >= 0x80000L) {
                            f0.k = (long)f0.e.b();
                        }
                        f0.b(v3, f0.h, f0.k);
                        f0.g = v2;
                        f0.h = 0L;
                    }
                    --f0.f;
                }
            }
        }
        this.d = null;
    }

    public final void c() {
        for(int v = 0; v < this.c; ++v) {
            ((x)this.b.get(v)).getClass();
        }
    }

    public final void d(j j0) {
        this.d = j0;
        for(int v = 0; v < this.c; ++v) {
            w3.f f0 = (w3.f)(((x)this.b.get(v)));
            synchronized(f0) {
                if(this.a && (j0.h & 8) != 8) {
                    if(f0.f == 0) {
                        f0.c.getClass();
                        f0.g = SystemClock.elapsedRealtime();
                    }
                    ++f0.f;
                }
            }
        }
    }

    @Override  // g3.f
    public final void r(x x0) {
        x0.getClass();
        ArrayList arrayList0 = this.b;
        if(!arrayList0.contains(x0)) {
            arrayList0.add(x0);
            ++this.c;
        }
    }
}

