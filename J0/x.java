package J0;

import A7.d;
import java.util.ArrayList;
import x0.b;

public final class x {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final boolean e;
    public final float f;
    public final int g;
    public final boolean h;
    public final ArrayList i;
    public final long j;
    public final long k;

    public x(long v, long v1, long v2, long v3, boolean z, float f, int v4, boolean z1, ArrayList arrayList0, long v5, long v6) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = v3;
        this.e = z;
        this.f = f;
        this.g = v4;
        this.h = z1;
        this.i = arrayList0;
        this.j = v5;
        this.k = v6;
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof x && u.d(this.a, ((x)object0).a) && this.b == ((x)object0).b && b.b(this.c, ((x)object0).c) && b.b(this.d, ((x)object0).d) && this.e == ((x)object0).e && Float.compare(this.f, ((x)object0).f) == 0 && this.g == ((x)object0).g && this.h == ((x)object0).h && this.i.equals(((x)object0).i) && b.b(this.j, ((x)object0).j) && b.b(this.k, ((x)object0).k);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.k) + d.c(H0.b.a(this.i, d.e(d.b(this.g, d.a(this.f, d.e(d.c(d.c(d.c(Long.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F), 0x1F), 0x1F, this.h), 0x1F), 0x1F, this.j);
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("PointerInputEventData(id=");
        stringBuilder0.append("PointerId(value=" + this.a + ')');
        stringBuilder0.append(", uptime=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", positionOnScreen=");
        stringBuilder0.append(b.i(this.c));
        stringBuilder0.append(", position=");
        stringBuilder0.append(b.i(this.d));
        stringBuilder0.append(", down=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", pressure=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", type=");
        switch(this.g) {
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
        stringBuilder0.append(", activeHover=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", historical=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", scrollDelta=");
        stringBuilder0.append(b.i(this.j));
        stringBuilder0.append(", originalEventPosition=");
        stringBuilder0.append(b.i(this.k));
        stringBuilder0.append(')');
        return stringBuilder0.toString();
    }
}

