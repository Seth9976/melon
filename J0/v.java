package J0;

import java.util.ArrayList;
import je.w;
import x0.b;

public final class v {
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final float e;
    public final long f;
    public final long g;
    public final boolean h;
    public final int i;
    public final long j;
    public final ArrayList k;
    public final long l;
    public boolean m;
    public boolean n;
    public v o;

    public v(long v, long v1, long v2, boolean z, float f, long v3, long v4, boolean z1, int v5, ArrayList arrayList0, long v6, long v7) {
        this(v, v1, v2, z, f, v3, v4, z1, false, v5, v6);
        this.k = arrayList0;
        this.l = v7;
    }

    public v(long v, long v1, long v2, boolean z, float f, long v3, long v4, boolean z1, boolean z2, int v5, long v6) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = z;
        this.e = f;
        this.f = v3;
        this.g = v4;
        this.h = z1;
        this.i = v5;
        this.j = v6;
        this.l = 0L;
        this.m = z2;
        this.n = z2;
    }

    public final void a() {
        v v0 = this.o;
        if(v0 == null) {
            this.m = true;
            this.n = true;
            return;
        }
        if(v0 != null) {
            v0.a();
        }
    }

    // 去混淆评级： 低(20)
    public final boolean b() {
        return this.o == null ? this.m || this.n : this.o.b();
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("PointerInputChange(id=");
        stringBuilder0.append("PointerId(value=" + this.a + ')');
        stringBuilder0.append(", uptimeMillis=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", position=");
        stringBuilder0.append(b.i(this.c));
        stringBuilder0.append(", pressed=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", pressure=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", previousUptimeMillis=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", previousPosition=");
        stringBuilder0.append(b.i(this.g));
        stringBuilder0.append(", previousPressed=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", isConsumed=");
        stringBuilder0.append(this.b());
        stringBuilder0.append(", type=");
        switch(this.i) {
            case 1: {
                s = "Touch";
                break;
            }
            case 2: {
                s = "Mouse";
                break;
            }
            case 3: {
                s = "Stylus";
                break;
            }
            case 4: {
                s = "Eraser";
                break;
            }
            default: {
                s = "Unknown";
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(", historical=");
        ArrayList arrayList0 = this.k;
        if(arrayList0 == null) {
            arrayList0 = w.a;
        }
        stringBuilder0.append(arrayList0);
        stringBuilder0.append(",scrollDelta=");
        stringBuilder0.append(b.i(this.j));
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

