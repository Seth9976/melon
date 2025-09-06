package p0;

import De.I;
import androidx.collection.B;
import java.util.ArrayList;
import java.util.Iterator;
import je.n;
import kb.D;
import xe.a;

public final class l implements Iterable, a {
    public final long a;
    public final long b;
    public final long c;
    public final long[] d;
    public static final l e;

    static {
        l.e = new l(null, 0L, 0L, 0L);
    }

    public l(long[] arr_v, long v, long v1, long v2) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = arr_v;
    }

    public final l a(l l0) {
        l l2;
        l l1 = l.e;
        if(l0 == l1) {
            return this;
        }
        if(this == l1) {
            return l1;
        }
        long v = l0.c;
        long[] arr_v = l0.d;
        long v1 = l0.b;
        long v2 = l0.a;
        long v3 = this.c;
        if(l0.c == v3) {
            long[] arr_v1 = this.d;
            if(arr_v == arr_v1) {
                return new l(arr_v1, this.a & ~v2, this.b & ~v1, v3);
            }
        }
        if(arr_v == null) {
            l2 = this;
        }
        else {
            l2 = this;
            for(int v4 = 0; v4 < arr_v.length; ++v4) {
                l2 = l2.b(arr_v[v4]);
            }
        }
        if(Long.compare(v1, 0L) != 0) {
            for(int v5 = 0; v5 < 0x40; ++v5) {
                if((1L << v5 & v1) != 0L) {
                    l2 = l2.b(((long)v5) + v);
                }
            }
        }
        if(v2 != 0L) {
            for(int v6 = 0; v6 < 0x40; ++v6) {
                if((1L << v6 & v2) != 0L) {
                    l2 = l2.b(((long)v6) + v + 0x40L);
                }
            }
        }
        return l2;
    }

    public final l b(long v) {
        long v1 = this.c;
        long v2 = v - v1;
        int v3 = Long.compare(v2, 0L);
        if(v3 >= 0 && v2 < 0x40L) {
            return (this.b & 1L << ((int)v2)) == 0L ? this : new l(this.d, this.a, this.b & ~(1L << ((int)v2)), v1);
        }
        if(v2 >= 0x40L && v2 < 0x80L) {
            long v4 = 1L << ((int)v2) - 0x40;
            return (this.a & v4) == 0L ? this : new l(this.d, this.a & ~v4, this.b, v1);
        }
        if(v3 < 0) {
            long[] arr_v = this.d;
            if(arr_v != null) {
                int v5 = q.b(arr_v, v);
                if(v5 >= 0) {
                    int v6 = arr_v.length - 1;
                    if(v6 == 0) {
                        return new l(null, this.a, this.b, this.c);
                    }
                    long[] arr_v1 = new long[v6];
                    if(v5 > 0) {
                        n.V(arr_v, arr_v1, 0, 0, v5);
                    }
                    if(v5 < v6) {
                        n.V(arr_v, arr_v1, v5, v5 + 1, arr_v.length);
                    }
                    return new l(arr_v1, this.a, this.b, this.c);
                }
            }
        }
        return this;
    }

    public final boolean d(long v) {
        long v1 = v - this.c;
        int v2 = Long.compare(v1, 0L);
        if(v2 >= 0 && v1 < 0x40L) {
            return (1L << ((int)v1) & this.b) != 0L;
        }
        if(v1 >= 0x40L && v1 < 0x80L) {
            return (1L << ((int)v1) - 0x40 & this.a) != 0L;
        }
        return v2 <= 0 ? this.d != null && q.b(this.d, v) >= 0 : false;
    }

    public final l e(l l0) {
        l l3;
        l l1 = l.e;
        if(l0 == l1) {
            return this;
        }
        if(this == l1) {
            return l0;
        }
        long v = l0.c;
        long[] arr_v = l0.d;
        long v1 = l0.b;
        long v2 = l0.a;
        long v3 = this.c;
        long v4 = this.b;
        long v5 = this.a;
        if(Long.compare(l0.c, v3) == 0) {
            long[] arr_v1 = this.d;
            if(arr_v == arr_v1) {
                return new l(arr_v1, v5 | v2, v4 | v1, v3);
            }
        }
        int v6 = 0;
        if(this.d == null) {
            l l2 = l0;
            long v7 = this.c;
            if(Long.compare(v4, 0L) != 0) {
                for(int v8 = 0; v8 < 0x40; ++v8) {
                    if((1L << v8 & v4) != 0L) {
                        l2 = l2.g(((long)v8) + v7);
                    }
                }
            }
            if(v5 != 0L) {
                while(v6 < 0x40) {
                    if((1L << v6 & v5) != 0L) {
                        l2 = l2.g(((long)v6) + v7 + 0x40L);
                    }
                    ++v6;
                }
            }
            return l2;
        }
        if(arr_v == null) {
            l3 = this;
        }
        else {
            l3 = this;
            for(int v9 = 0; v9 < arr_v.length; ++v9) {
                l3 = l3.g(arr_v[v9]);
            }
        }
        if(v1 != 0L) {
            for(int v10 = 0; v10 < 0x40; ++v10) {
                if((1L << v10 & v1) != 0L) {
                    l3 = l3.g(((long)v10) + v);
                }
            }
        }
        if(v2 != 0L) {
            while(v6 < 0x40) {
                if((1L << v6 & v2) != 0L) {
                    l3 = l3.g(((long)v6) + v + 0x40L);
                }
                ++v6;
            }
        }
        return l3;
    }

    public final l g(long v) {
        long v11;
        long v10;
        long v1 = this.c;
        long v2 = v - v1;
        long v3 = this.a;
        long v4 = this.b;
        long[] arr_v = this.d;
        if(Long.compare(v2, 0L) >= 0 && v2 < 0x40L) {
            return (v4 & 1L << ((int)v2)) == 0L ? new l(arr_v, v3, v4 | 1L << ((int)v2), v1) : this;
        }
        if(Long.compare(v2, 0x40L) >= 0 && v2 < 0x80L) {
            long v5 = 1L << ((int)v2) - 0x40;
            return (v3 & v5) == 0L ? new l(arr_v, v5 | v3, v4, v1) : this;
        }
        if(v2 < 0x80L) {
            if(arr_v == null) {
                return new l(new long[]{v}, v3, v4, v1);
            }
            int v14 = q.b(arr_v, v);
            if(v14 < 0) {
                long[] arr_v3 = new long[arr_v.length + 1];
                n.V(arr_v, arr_v3, 0, 0, -(v14 + 1));
                n.V(arr_v, arr_v3, -v14, -(v14 + 1), arr_v.length);
                arr_v3[-(v14 + 1)] = v;
                return new l(arr_v3, this.a, this.b, this.c);
            }
        }
        else if(!this.d(v)) {
            long v6 = (v + 1L) / 0x40L * 0x40L >= 0L ? (v + 1L) / 0x40L * 0x40L : 0x7FFFFFFFFFFFFF80L;
            long v7 = this.c;
            long v8 = v3;
            D d0 = null;
            while(true) {
                if(v7 >= v6) {
                    v10 = v7;
                    v11 = v4;
                    break;
                }
                if(v4 != 0L) {
                    if(d0 == null) {
                        d0 = new D(arr_v);
                    }
                    for(int v9 = 0; v9 < 0x40; ++v9) {
                        if((v4 & 1L << v9) != 0L) {
                            ((B)d0.b).a(((long)v9) + v7);
                        }
                    }
                }
                if(v8 == 0L) {
                    v10 = v6;
                    v11 = 0L;
                    break;
                }
                v7 += 0x40L;
                v4 = v8;
                v8 = 0L;
            }
            if(d0 != null) {
                B b0 = (B)d0.b;
                int v12 = b0.b;
                if(v12 == 0) {
                    return new l(arr_v, v8, v11, v10).g(v);
                }
                long[] arr_v1 = new long[v12];
                long[] arr_v2 = b0.a;
                for(int v13 = 0; v13 < v12; ++v13) {
                    arr_v1[v13] = arr_v2[v13];
                }
                return arr_v1 == null ? new l(arr_v, v8, v11, v10).g(v) : new l(arr_v1, v8, v11, v10).g(v);
            }
            return new l(arr_v, v8, v11, v10).g(v);
        }
        return this;
    }

    @Override
    public final Iterator iterator() {
        return I.P(new k(this, null));
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(super.toString());
        stringBuilder0.append(" [");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, this));
        for(Object object0: this) {
            arrayList0.add(String.valueOf(((Number)object0).longValue()));
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("");
        int v = arrayList0.size();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object1 = arrayList0.get(v1);
            boolean z = true;
            ++v2;
            if(v2 > 1) {
                stringBuilder1.append(", ");
            }
            if(object1 != null) {
                z = object1 instanceof CharSequence;
            }
            if(z) {
                stringBuilder1.append(((CharSequence)object1));
            }
            else if(object1 instanceof Character) {
                stringBuilder1.append(((Character)object1).charValue());
            }
            else {
                stringBuilder1.append(String.valueOf(object1));
            }
        }
        stringBuilder1.append("");
        stringBuilder0.append(stringBuilder1.toString());
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }
}

