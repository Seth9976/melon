package Uf;

import Tf.o;
import kotlin.jvm.internal.q;

public final class b implements Comparable {
    public final long a;
    public static final a b;
    public static final long c;
    public static final long d;

    static {
        b.b = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        b.c = 0x7FFFFFFFFFFFFFFFL;
        b.d = 0x8000000000000003L;
    }

    public b(long v) {
        this.a = v;
    }

    public static final long a(long v, long v1) {
        long v2 = v + v1 / 1000000L;
        return -4611686018426L > v2 || v2 >= 4611686018427L ? x1.a.t(P4.a.k(v2, 0xC000000000000001L, 0x3FFFFFFFFFFFFFFFL)) : v2 * 1000000L + (v1 - v1 / 1000000L * 1000000L) << 1;
    }

    public static final void b(StringBuilder stringBuilder0, int v, int v1, int v2, String s, boolean z) {
        stringBuilder0.append(v);
        if(v1 != 0) {
            stringBuilder0.append('.');
            String s1 = o.L0(v2, String.valueOf(v1));
            int v3 = -1;
            int v4 = s1.length() - 1;
            if(v4 >= 0) {
                while(true) {
                    if(s1.charAt(v4) != 0x30) {
                        v3 = v4;
                        break;
                    }
                    if(v4 - 1 < 0) {
                        break;
                    }
                    --v4;
                }
            }
            if(z || v3 + 1 >= 3) {
                stringBuilder0.append(s1, 0, (v3 + 3) / 3 * 3);
            }
            else {
                stringBuilder0.append(s1, 0, v3 + 1);
            }
        }
        stringBuilder0.append(s);
    }

    public static int c(long v, long v1) {
        if(Long.compare(v ^ v1, 0L) >= 0 && (((int)(v ^ v1)) & 1) != 0) {
            int v2 = (((int)v) & 1) - (((int)v1) & 1);
            return v >= 0L ? v2 : -v2;
        }
        int v3 = Long.compare(v, v1);
        if(v3 < 0) {
            return -1;
        }
        return v3 == 0 ? 0 : 1;
    }

    @Override
    public final int compareTo(Object object0) {
        return b.c(this.a, ((b)object0).a);
    }

    public static final long d(long v) {
        return (((int)v) & 1) != 1 || b.g(v) ? b.i(v, d.c) : v >> 1;
    }

    public static final long e(long v) {
        if((((int)v) & 1) == 0) {
            return v >> 1;
        }
        if(v >> 1 > 0x8637BD05AF6L) {
            return 0x7FFFFFFFFFFFFFFFL;
        }
        return v >> 1 >= 0xFFFFF79C842FA50AL ? (v >> 1) * 1000000L : 0x8000000000000000L;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b && this.a == ((b)object0).a;
    }

    public static final int f(long v) {
        if(b.g(v)) {
            return 0;
        }
        return (((int)v) & 1) == 1 ? ((int)((v >> 1) % 1000L * 1000000L)) : ((int)((v >> 1) % 1000000000L));
    }

    public static final boolean g(long v) {
        return v == b.c || v == b.d;
    }

    public static final long h(long v, long v1) {
        if(b.g(v)) {
            if(b.g(v1) && (v1 ^ v) < 0L) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return v;
        }
        if(b.g(v1)) {
            return v1;
        }
        if((((int)v) & 1) == (((int)v1) & 1)) {
            long v2 = (v >> 1) + (v1 >> 1);
            if((((int)v) & 1) == 0) {
                return 0xC00000000005EB41L > v2 || v2 >= 0x3FFFFFFFFFFA14C0L ? (v2 / 1000000L << 1) + 1L : v2 << 1;
            }
            return x1.a.u(v2);
        }
        return (((int)v) & 1) == 1 ? b.a(v >> 1, v1 >> 1) : b.a(v1 >> 1, v >> 1);
    }

    @Override
    public final int hashCode() {
        return Long.hashCode(this.a);
    }

    public static final long i(long v, d d0) {
        q.g(d0, "unit");
        if(v == b.c) {
            return 0x7FFFFFFFFFFFFFFFL;
        }
        if(v == b.d) {
            return 0x8000000000000000L;
        }
        return (((int)v) & 1) == 0 ? y5.a.u(v >> 1, d.b, d0) : y5.a.u(v >> 1, d.c, d0);
    }

    public static String j(long v) {
        int v1 = 0;
        int v2 = Long.compare(v, 0L);
        if(v2 == 0) {
            return "0s";
        }
        if(v == b.c) {
            return "Infinity";
        }
        if(v == b.d) {
            return "-Infinity";
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        if(v2 < 0) {
            stringBuilder0.append('-');
        }
        long v3 = v2 >= 0 ? v : b.k(v);
        long v4 = b.i(v3, d.g);
        int v5 = b.g(v3) ? 0 : ((int)(b.i(v3, d.f) % 24L));
        int v6 = b.g(v3) ? 0 : ((int)(b.i(v3, d.e) % 60L));
        int v7 = b.g(v3) ? 0 : ((int)(b.i(v3, d.d) % 60L));
        int v8 = b.f(v3);
        boolean z = v7 != 0 || v8 != 0;
        if(v4 != 0L) {
            stringBuilder0.append(v4);
            stringBuilder0.append('d');
            v1 = 1;
        }
        if(v5 != 0 || v4 != 0L && (v6 != 0 || z)) {
            if(v1 > 0) {
                stringBuilder0.append(' ');
            }
            stringBuilder0.append(v5);
            stringBuilder0.append('h');
            ++v1;
        }
        if(v6 != 0 || z && (v5 != 0 || v4 != 0L)) {
            if(v1 > 0) {
                stringBuilder0.append(' ');
            }
            stringBuilder0.append(v6);
            stringBuilder0.append('m');
            ++v1;
        }
        if(z) {
            if(v1 > 0) {
                stringBuilder0.append(' ');
            }
            if(v7 != 0 || v4 != 0L || v5 != 0 || v6 != 0) {
                b.b(stringBuilder0, v7, v8, 9, "s", false);
            }
            else if(v8 >= 1000000) {
                b.b(stringBuilder0, v8 / 1000000, v8 % 1000000, 6, "ms", false);
            }
            else if(v8 >= 1000) {
                b.b(stringBuilder0, v8 / 1000, v8 % 1000, 3, "us", false);
            }
            else {
                stringBuilder0.append(v8);
                stringBuilder0.append("ns");
            }
            ++v1;
        }
        if(v2 < 0 && v1 > 1) {
            stringBuilder0.insert(1, '(').append(')');
        }
        return stringBuilder0.toString();
    }

    public static final long k(long v) {
        return (-(v >> 1) << 1) + ((long)(((int)v) & 1));
    }

    @Override
    public final String toString() {
        return b.j(this.a);
    }
}

