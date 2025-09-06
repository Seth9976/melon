package androidx.collection;

import kotlin.jvm.internal.q;

public abstract class m {
    public long[] a;
    public int[] b;
    public Object[] c;
    public int d;
    public int e;

    public final boolean a(int v) {
        int v1 = v * 0xCC9E2D51 ^ v * 0xCC9E2D51 << 16;
        int v2 = this.d;
        int v3 = v1 >>> 7 & v2;
        int v4 = 0;
        while(true) {
            int v5 = (v3 & 7) << 3;
            long v6 = this.a[(v3 >> 3) + 1] << 0x40 - v5 & -((long)v5) >> 0x3F | this.a[v3 >> 3] >>> v5;
            long v7 = ((long)(v1 & 0x7F)) * 0x101010101010101L ^ v6;
            for(long v8 = ~v7 & v7 - 0x101010101010101L & 0x8080808080808080L; v8 != 0L; v8 &= v8 - 1L) {
                int v9 = (Long.numberOfTrailingZeros(v8) >> 3) + v3 & v2;
                if(this.b[v9] == v) {
                    return v9 >= 0;
                }
            }
            if((v6 & ~v6 << 6 & 0x8080808080808080L) != 0L) {
                return false;
            }
            v4 += 8;
            v3 = v3 + v4 & v2;
        }
    }

    public final Object b(int v) {
        int v1 = v * 0xCC9E2D51 ^ v * 0xCC9E2D51 << 16;
        int v2 = this.d;
        int v3 = v1 >>> 7 & v2;
        int v4 = 0;
        while(true) {
            int v5 = (v3 & 7) << 3;
            long v6 = this.a[(v3 >> 3) + 1] << 0x40 - v5 & -((long)v5) >> 0x3F | this.a[v3 >> 3] >>> v5;
            long v7 = ((long)(v1 & 0x7F)) * 0x101010101010101L ^ v6;
            for(long v8 = ~v7 & v7 - 0x101010101010101L & 0x8080808080808080L; v8 != 0L; v8 &= v8 - 1L) {
                int v9 = (Long.numberOfTrailingZeros(v8) >> 3) + v3 & v2;
                if(this.b[v9] == v) {
                    return v9 < 0 ? null : this.c[v9];
                }
            }
            if((v6 & ~v6 << 6 & 0x8080808080808080L) != 0L) {
                throw new ArrayIndexOutOfBoundsException(-1);
            }
            v4 += 8;
            v3 = v3 + v4 & v2;
        }
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof m)) {
            return false;
        }
        if(((m)object0).e != this.e) {
            return false;
        }
        int[] arr_v = this.b;
        Object[] arr_object = this.c;
        long[] arr_v1 = this.a;
        int v = arr_v1.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v1[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            int v6 = arr_v[v5];
                            Object object1 = arr_object[v5];
                            if(object1 == null) {
                                if(((m)object0).b(v6) != null || !((m)object0).a(v6)) {
                                    return false;
                                }
                            }
                            else if(!object1.equals(((m)object0).b(v6))) {
                                return false;
                            }
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_30;
                    }
                    break;
                }
            label_30:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int[] arr_v = this.b;
        Object[] arr_object = this.c;
        long[] arr_v1 = this.a;
        int v = arr_v1.length - 2;
        if(v >= 0) {
            int v2 = 0;
            for(int v1 = 0; true; ++v1) {
                long v3 = arr_v1[v1];
                if((~v3 << 7 & v3 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v4 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v5 = 0; v5 < v4; ++v5) {
                        if((0xFFL & v3) < 0x80L) {
                            int v6 = (v1 << 3) + v5;
                            int v7 = arr_v[v6];
                            Object object0 = arr_object[v6];
                            v2 += (object0 == null ? 0 : object0.hashCode()) ^ v7;
                        }
                        v3 >>= 8;
                    }
                    if(v4 != 8) {
                        return v2;
                    }
                }
                if(v1 == v) {
                    break;
                }
            }
            return v2;
        }
        return 0;
    }

    @Override
    public final String toString() {
        if(this.e == 0) {
            return "{}";
        }
        StringBuilder stringBuilder0 = new StringBuilder("{");
        int[] arr_v = this.b;
        Object[] arr_object = this.c;
        long[] arr_v1 = this.a;
        int v = arr_v1.length - 2;
        if(v >= 0) {
            int v1 = 0;
            int v2 = 0;
            while(true) {
                long v3 = arr_v1[v1];
                if((~v3 << 7 & v3 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v4 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v5 = 0; v5 < v4; ++v5) {
                        if((0xFFL & v3) < 0x80L) {
                            int v6 = (v1 << 3) + v5;
                            int v7 = arr_v[v6];
                            String s = arr_object[v6];
                            stringBuilder0.append(v7);
                            stringBuilder0.append("=");
                            if(s == this) {
                                s = "(this)";
                            }
                            stringBuilder0.append(s);
                            ++v2;
                            if(v2 < this.e) {
                                stringBuilder0.append(", ");
                            }
                        }
                        v3 >>= 8;
                    }
                    if(v4 == 8) {
                        goto label_31;
                    }
                    break;
                }
            label_31:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        stringBuilder0.append('}');
        String s1 = stringBuilder0.toString();
        q.f(s1, "toString(...)");
        return s1;
    }
}

