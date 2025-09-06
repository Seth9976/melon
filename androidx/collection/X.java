package androidx.collection;

import je.n;
import kotlin.jvm.internal.q;

public final class x {
    public long[] a;
    public int[] b;
    public int[] c;
    public int d;
    public int e;
    public int f;

    public x() {
        this.a = S.a;
        this.b = o.a;
        this.c = o.a;
        this.e(S.e(6));
    }

    public final void a() {
        this.e = 0;
        long[] arr_v = this.a;
        if(arr_v != S.a) {
            n.e0(arr_v, 0x8080808080808080L);
            int v = this.d >> 3;
            this.a[v] |= 0xFFL << ((this.d & 7) << 3);
        }
        this.f = S.a(this.d) - this.e;
    }

    public final int b(int v) {
        long v6;
        int v1 = this.d;
        int v2 = v & v1;
        int v3 = 0;
        while(true) {
            int v4 = (v2 & 7) << 3;
            long v5 = this.a[(v2 >> 3) + 1] << 0x40 - v4 & -((long)v4) >> 0x3F | this.a[v2 >> 3] >>> v4;
            v6 = v5 & ~v5 << 7 & 0x8080808080808080L;
            if(v6 != 0L) {
                break;
            }
            v3 += 8;
            v2 = v2 + v3 & v1;
        }
        return v2 + (Long.numberOfTrailingZeros(v6) >> 3) & v1;
    }

    public final int c(int v) {
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
                    return v9;
                }
            }
            if((v6 & ~v6 << 6 & 0x8080808080808080L) != 0L) {
                return -1;
            }
            v4 += 8;
            v3 = v3 + v4 & v2;
        }
    }

    public final int d(int v) {
        int v1 = this.c(v);
        return v1 < 0 ? -1 : this.c[v1];
    }

    public final void e(int v) {
        long[] arr_v;
        int v1 = v <= 0 ? 0 : Math.max(7, S.d(v));
        this.d = v1;
        if(v1 == 0) {
            arr_v = S.a;
        }
        else {
            arr_v = new long[(v1 + 15 & -8) >> 3];
            n.e0(arr_v, 0x8080808080808080L);
        }
        this.a = arr_v;
        arr_v[v1 >> 3] |= 0xFFL << ((v1 & 7) << 3);
        this.f = S.a(this.d) - this.e;
        this.b = new int[v1];
        this.c = new int[v1];
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof x)) {
            return false;
        }
        if(((x)object0).e != this.e) {
            return false;
        }
        int[] arr_v = this.b;
        int[] arr_v1 = this.c;
        long[] arr_v2 = this.a;
        int v = arr_v2.length - 2;
        if(v >= 0) {
            int v1 = 0;
            while(true) {
                long v2 = arr_v2[v1];
                if((~v2 << 7 & v2 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v3 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v4 = 0; v4 < v3; ++v4) {
                        if((0xFFL & v2) < 0x80L) {
                            int v5 = (v1 << 3) + v4;
                            int v6 = arr_v[v5];
                            int v7 = arr_v1[v5];
                            int v8 = ((x)object0).c(v6);
                            if(v8 < 0 || v7 != ((x)object0).c[v8]) {
                                return false;
                            }
                        }
                        v2 >>= 8;
                    }
                    if(v3 == 8) {
                        goto label_28;
                    }
                    break;
                }
            label_28:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        return true;
    }

    public final void f(int v, int v1) {
        int v14;
        long v13;
        int[] arr_v4;
        int[] arr_v3;
        long[] arr_v11;
        int v11;
        int v2 = v * 0xCC9E2D51 ^ v * 0xCC9E2D51 << 16;
        int v3 = this.d;
        int v4 = v2 >>> 7 & v3;
        int v5 = 0;
        while(true) {
            int v6 = (v4 & 7) << 3;
            long v7 = -((long)v6) >> 0x3F & this.a[(v4 >> 3) + 1] << 0x40 - v6 | this.a[v4 >> 3] >>> v6;
            long v8 = v7 ^ ((long)(v2 & 0x7F)) * 0x101010101010101L;
            long v9 = v8 - 0x101010101010101L & ~v8 & 0x8080808080808080L;
            while(v9 != 0L) {
                int v10 = (Long.numberOfTrailingZeros(v9) >> 3) + v4 & v3;
                if(this.b[v10] == v) {
                    v11 = v10;
                    goto label_125;
                }
                v9 &= v9 - 1L;
            }
            if(Long.compare(v7 & ~v7 << 6 & 0x8080808080808080L, 0L) == 0) {
                goto label_130;
            }
            else {
                int v12 = this.b(v2 >>> 7);
                if(this.f == 0 && (this.a[v12 >> 3] >> ((v12 & 7) << 3) & 0xFFL) != 0xFEL) {
                    if(this.d <= 8 || Long.compareUnsigned(((long)this.e) * 0x20L, ((long)this.d) * 25L) > 0) {
                        v13 = (long)(v2 & 0x7F);
                        v14 = 0;
                        long[] arr_v5 = this.a;
                        int[] arr_v6 = this.b;
                        int[] arr_v7 = this.c;
                        int v30 = this.d;
                        this.e(S.c(this.d));
                        long[] arr_v8 = this.a;
                        int[] arr_v9 = this.b;
                        int[] arr_v10 = this.c;
                        int v31 = this.d;
                        int v32 = 0;
                        while(v32 < v30) {
                            if((arr_v5[v32 >> 3] >> ((v32 & 7) << 3) & 0xFFL) < 0x80L) {
                                int v33 = arr_v6[v32];
                                int v34 = v33 * 0xCC9E2D51 ^ v33 * 0xCC9E2D51 << 16;
                                int v35 = this.b(v34 >>> 7);
                                arr_v11 = arr_v8;
                                int v36 = (v35 & 7) << 3;
                                long v37 = arr_v11[v35 >> 3] & ~(0xFFL << v36) | ((long)(v34 & 0x7F)) << v36;
                                arr_v11[v35 >> 3] = v37;
                                arr_v11[(v35 - 7 & v31) + (v31 & 7) >> 3] = v37;
                                arr_v9[v35] = v33;
                                arr_v10[v35] = arr_v7[v32];
                            }
                            else {
                                arr_v11 = arr_v8;
                            }
                            ++v32;
                            arr_v8 = arr_v11;
                        }
                    }
                    else {
                        long[] arr_v = this.a;
                        int v15 = this.d;
                        int[] arr_v1 = this.b;
                        int[] arr_v2 = this.c;
                        for(int v16 = 0; v16 < v15 + 7 >> 3; ++v16) {
                            long v17 = arr_v[v16] & 0x8080808080808080L;
                            arr_v[v16] = 0xFEFEFEFEFEFEFEFEL & ~v17 + (v17 >>> 7);
                        }
                        v13 = (long)(v2 & 0x7F);
                        int v18 = n.k0(arr_v);
                        arr_v[v18 - 1] |= 0xFF00000000000000L;
                        arr_v[v18] = arr_v[0];
                        int v19 = 0;
                        while(v19 != v15) {
                            int v20 = (v19 & 7) << 3;
                            long v21 = arr_v[v19 >> 3] >> v20 & 0xFFL;
                            if(v21 != 0x80L && v21 == 0xFEL) {
                                int v22 = arr_v1[v19];
                                int v23 = v22 * 0xCC9E2D51 ^ v22 * 0xCC9E2D51 << 16;
                                int v24 = this.b(v23 >>> 7);
                                int v25 = v23 >>> 7 & v15;
                                if((v24 - v25 & v15) / 8 == (v19 - v25 & v15) / 8) {
                                    arr_v[v19 >> 3] = ((long)(v23 & 0x7F)) << v20 | arr_v[v19 >> 3] & ~(0xFFL << v20);
                                    arr_v[arr_v.length - 1] = arr_v[0] & 0xFFFFFFFFFFFFFFL | 0x8000000000000000L;
                                    ++v19;
                                }
                                else {
                                    long v26 = arr_v[v24 >> 3];
                                    int v27 = (v24 & 7) << 3;
                                    if((v26 >> v27 & 0xFFL) == 0x80L) {
                                        arr_v3 = arr_v1;
                                        arr_v4 = arr_v2;
                                        arr_v[v24 >> 3] = ~(0xFFL << v27) & v26 | ((long)(v23 & 0x7F)) << v27;
                                        arr_v[v19 >> 3] = arr_v[v19 >> 3] & ~(0xFFL << v20) | 0x80L << v20;
                                        arr_v3[v24] = arr_v3[v19];
                                        arr_v3[v19] = 0;
                                        arr_v4[v24] = arr_v4[v19];
                                        arr_v4[v19] = 0;
                                    }
                                    else {
                                        arr_v3 = arr_v1;
                                        arr_v4 = arr_v2;
                                        arr_v[v24 >> 3] = ((long)(v23 & 0x7F)) << v27 | ~(0xFFL << v27) & v26;
                                        int v28 = arr_v3[v24];
                                        arr_v3[v24] = arr_v3[v19];
                                        arr_v3[v19] = v28;
                                        int v29 = arr_v4[v24];
                                        arr_v4[v24] = arr_v4[v19];
                                        arr_v4[v19] = v29;
                                        --v19;
                                    }
                                    arr_v[arr_v.length - 1] = arr_v[0] & 0xFFFFFFFFFFFFFFL | 0x8000000000000000L;
                                    ++v19;
                                    arr_v1 = arr_v3;
                                    arr_v2 = arr_v4;
                                }
                            }
                            else {
                                ++v19;
                            }
                        }
                        v14 = 0;
                        this.f = S.a(this.d) - this.e;
                    }
                    v12 = this.b(v2 >>> 7);
                }
                else {
                    v13 = (long)(v2 & 0x7F);
                    v14 = 0;
                }
                ++this.e;
                int v38 = this.f;
                long[] arr_v12 = this.a;
                long v39 = arr_v12[v12 >> 3];
                int v40 = (v12 & 7) << 3;
                if((v39 >> v40 & 0xFFL) == 0x80L) {
                    v14 = 1;
                }
                this.f = v38 - v14;
                int v41 = this.d;
                long v42 = v39 & ~(0xFFL << v40) | v13 << v40;
                arr_v12[v12 >> 3] = v42;
                arr_v12[(v12 - 7 & v41) + (v41 & 7) >> 3] = v42;
                v11 = ~v12;
            }
        label_125:
            if(v11 < 0) {
                v11 = ~v11;
            }
            this.b[v11] = v;
            this.c[v11] = v1;
            return;
        label_130:
            v5 += 8;
            v4 = v4 + v5 & v3;
        }
    }

    @Override
    public final int hashCode() {
        int[] arr_v = this.b;
        int[] arr_v1 = this.c;
        long[] arr_v2 = this.a;
        int v = arr_v2.length - 2;
        if(v >= 0) {
            int v2 = 0;
            for(int v1 = 0; true; ++v1) {
                long v3 = arr_v2[v1];
                if((~v3 << 7 & v3 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v4 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v5 = 0; v5 < v4; ++v5) {
                        if((0xFFL & v3) < 0x80L) {
                            int v6 = (v1 << 3) + v5;
                            v2 += arr_v1[v6] ^ arr_v[v6];
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
        int[] arr_v1 = this.c;
        long[] arr_v2 = this.a;
        int v = arr_v2.length - 2;
        if(v >= 0) {
            int v1 = 0;
            int v2 = 0;
            while(true) {
                long v3 = arr_v2[v1];
                if((~v3 << 7 & v3 & 0x8080808080808080L) != 0x8080808080808080L) {
                    int v4 = 8 - (~(v1 - v) >>> 0x1F);
                    for(int v5 = 0; v5 < v4; ++v5) {
                        if((0xFFL & v3) < 0x80L) {
                            int v6 = (v1 << 3) + v5;
                            int v7 = arr_v[v6];
                            int v8 = arr_v1[v6];
                            stringBuilder0.append(v7);
                            stringBuilder0.append("=");
                            stringBuilder0.append(v8);
                            ++v2;
                            if(v2 < this.e) {
                                stringBuilder0.append(", ");
                            }
                        }
                        v3 >>= 8;
                    }
                    if(v4 == 8) {
                        goto label_29;
                    }
                    break;
                }
            label_29:
                if(v1 == v) {
                    break;
                }
                ++v1;
            }
        }
        stringBuilder0.append('}');
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }
}

