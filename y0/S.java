package y0;

import androidx.appcompat.app.o;
import androidx.collection.z;
import z0.c;
import z0.d;
import z0.g;
import z0.h;
import z0.j;

public final class s {
    public final long a;
    public static final long b;
    public static final long c;
    public static final long d;
    public static final long e;
    public static final long f;
    public static final long g;
    public static final int h;

    static {
        s.b = 0xFF00000000000000L;
        s.c = 0xFFFFFFFF00000000L;
        s.d = 0xFFFF000000000000L;
        s.e = 0xFF0000FF00000000L;
        s.f = 0L;
        s.g = M.b(0.0f, 0.0f, 0.0f, 0.0f, d.u);
    }

    public s(long v) {
        this.a = v;
    }

    public static final s a(long v) {
        return new s(v);
    }

    public static final long b(long v, c c0) {
        c c1 = s.g(v);
        int v1 = c1.c;
        int v2 = c0.c;
        if((v1 | v2) < 0) {
            return j.e(c1, c0).a(v);
        }
        z z0 = h.a;
        int v3 = v1 | v2 << 6;
        g g0 = z0.b(v3);
        if(g0 == null) {
            g0 = j.e(c1, c0);
            z0.h(v3, g0);
        }
        return g0.a(v);
    }

    public static long c(long v, float f) {
        return M.b(s.i(v), s.h(v), s.f(v), f, s.g(v));
    }

    public static final boolean d(long v, long v1) {
        return v == v1;
    }

    public static final float e(long v) {
        return (0x3FL & v) == 0L ? ((float)(((double)((v >>> 56 & 0xFFL) >>> 11)) * 2048.0 + ((double)(v >>> 56 & 0xFFL)))) / 255.0f : ((float)(((double)((v >>> 6 & 0x3FFL) >>> 11)) * 2048.0 + ((double)(v >>> 6 & 0x3FFL)))) / 1023.0f;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof s && this.a == ((s)object0).a;
    }

    public static final float f(long v) {
        if((0x3FL & v) == 0L) {
            return ((float)(((double)((v >>> 0x20 & 0xFFL) >>> 11)) * 2048.0 + ((double)(v >>> 0x20 & 0xFFL)))) / 255.0f;
        }
        int v1 = (short)(((int)(v >>> 16 & 0xFFFFL)));
        int v2 = (0xFFFF & v1) >>> 10 & 0x1F;
        if(v2 == 0) {
            if((v1 & 0x3FF) != 0) {
                float f = Float.intBitsToFloat((v1 & 0x3FF) + 0x3F000000) - y.a;
                return (0x8000 & v1) == 0 ? f : -f;
            }
            return Float.intBitsToFloat((0x8000 & v1) << 16);
        }
        int v3 = (v1 & 0x3FF) << 13;
        if(v2 == 0x1F) {
            if(v3 != 0) {
                v3 |= 0x400000;
            }
            return Float.intBitsToFloat(0x7F800000 | (0x8000 & v1) << 16 | v3);
        }
        return Float.intBitsToFloat(v2 + 0x70 << 23 | (0x8000 & v1) << 16 | v3);
    }

    public static final c g(long v) {
        return d.y[((int)(v & 0x3FL))];
    }

    public static final float h(long v) {
        if((0x3FL & v) == 0L) {
            return ((float)(((double)((v >>> 40 & 0xFFL) >>> 11)) * 2048.0 + ((double)(v >>> 40 & 0xFFL)))) / 255.0f;
        }
        int v1 = (short)(((int)(v >>> 0x20 & 0xFFFFL)));
        int v2 = (0xFFFF & v1) >>> 10 & 0x1F;
        if(v2 == 0) {
            if((v1 & 0x3FF) != 0) {
                float f = Float.intBitsToFloat((v1 & 0x3FF) + 0x3F000000) - y.a;
                return (0x8000 & v1) == 0 ? f : -f;
            }
            return Float.intBitsToFloat((0x8000 & v1) << 16);
        }
        int v3 = (v1 & 0x3FF) << 13;
        if(v2 == 0x1F) {
            if(v3 != 0) {
                v3 |= 0x400000;
            }
            return Float.intBitsToFloat(0x7F800000 | (0x8000 & v1) << 16 | v3);
        }
        return Float.intBitsToFloat(v2 + 0x70 << 23 | (0x8000 & v1) << 16 | v3);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public static final float i(long v) {
        if(Long.compare(0x3FL & v, 0L) == 0) {
            return ((float)(((double)((v >>> 0x30 & 0xFFL) >>> 11)) * 2048.0 + ((double)(v >>> 0x30 & 0xFFL)))) / 255.0f;
        }
        int v1 = (short)(((int)(v >>> 0x30 & 0xFFFFL)));
        int v2 = (0xFFFF & v1) >>> 10 & 0x1F;
        if(v2 == 0) {
            if((v1 & 0x3FF) != 0) {
                float f = Float.intBitsToFloat((v1 & 0x3FF) + 0x3F000000) - y.a;
                return (0x8000 & v1) == 0 ? f : -f;
            }
            return Float.intBitsToFloat((0x8000 & v1) << 16);
        }
        int v3 = (v1 & 0x3FF) << 13;
        if(v2 == 0x1F) {
            if(v3 != 0) {
                v3 |= 0x400000;
            }
            return Float.intBitsToFloat(0x7F800000 | (0x8000 & v1) << 16 | v3);
        }
        return Float.intBitsToFloat(v2 + 0x70 << 23 | (0x8000 & v1) << 16 | v3);
    }

    public static String j(long v) {
        StringBuilder stringBuilder0 = new StringBuilder("Color(");
        stringBuilder0.append(s.i(v));
        stringBuilder0.append(", ");
        stringBuilder0.append(s.h(v));
        stringBuilder0.append(", ");
        stringBuilder0.append(s.f(v));
        stringBuilder0.append(", ");
        stringBuilder0.append(s.e(v));
        stringBuilder0.append(", ");
        return o.r(stringBuilder0, s.g(v).a, ')');
    }

    @Override
    public final String toString() {
        return s.j(this.a);
    }
}

