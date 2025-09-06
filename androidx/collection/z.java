package androidx.collection;

import E.a;
import je.n;

public final class z extends m {
    public int f;

    public z() {
        this(6);
    }

    public z(int v) {
        this.a = S.a;
        this.b = o.a;
        this.c = a.c;
        if(v >= 0) {
            this.f(S.e(v));
            return;
        }
        a.c("Capacity must be a positive value.");
        throw null;
    }

    public final void c() {
        this.e = 0;
        long[] arr_v = this.a;
        if(arr_v != S.a) {
            n.e0(arr_v, 0x8080808080808080L);
            int v = this.d >> 3;
            this.a[v] |= 0xFFL << ((this.d & 7) << 3);
        }
        n.c0(0, this.d, null, this.c);
        this.f = S.a(this.d) - this.e;
    }

    public final int d(int v) {
        int v12;
        long v11;
        Object[] arr_object1;
        int[] arr_v2;
        long[] arr_v8;
        long[] arr_v7;
        int v1 = v * 0xCC9E2D51 ^ v * 0xCC9E2D51 << 16;
        int v2 = this.d;
        int v3 = v1 >>> 7 & v2;
        int v4 = 0;
        while(true) {
            int v5 = (v3 & 7) << 3;
            long v6 = this.a[(v3 >> 3) + 1] << 0x40 - v5 & -((long)v5) >> 0x3F | this.a[v3 >> 3] >>> v5;
            long v7 = v6 ^ ((long)(v1 & 0x7F)) * 0x101010101010101L;
            for(long v8 = ~v7 & v7 - 0x101010101010101L & 0x8080808080808080L; v8 != 0L; v8 &= v8 - 1L) {
                int v9 = v3 + (Long.numberOfTrailingZeros(v8) >> 3) & v2;
                if(this.b[v9] == v) {
                    return v9;
                }
            }
            if(Long.compare(~v6 << 6 & v6 & 0x8080808080808080L, 0L) != 0) {
                int v10 = this.e(v1 >>> 7);
                if(this.f == 0 && (this.a[v10 >> 3] >> ((v10 & 7) << 3) & 0xFFL) != 0xFEL) {
                    if(this.d <= 8 || Long.compareUnsigned(((long)this.e) * 0x20L, ((long)this.d) * 25L) > 0) {
                        v11 = (long)(v1 & 0x7F);
                        v12 = 1;
                        long[] arr_v3 = this.a;
                        int[] arr_v4 = this.b;
                        Object[] arr_object2 = this.c;
                        int v27 = this.d;
                        this.f(S.c(this.d));
                        long[] arr_v5 = this.a;
                        int[] arr_v6 = this.b;
                        Object[] arr_object3 = this.c;
                        int v28 = this.d;
                        int v29 = 0;
                        while(v29 < v27) {
                            if((arr_v3[v29 >> 3] >> ((v29 & 7) << 3) & 0xFFL) < 0x80L) {
                                int v30 = arr_v4[v29];
                                int v31 = v30 * 0xCC9E2D51 ^ v30 * 0xCC9E2D51 << 16;
                                int v32 = this.e(v31 >>> 7);
                                int v33 = (v32 & 7) << 3;
                                arr_v7 = arr_v5;
                                arr_v8 = arr_v3;
                                long v34 = arr_v5[v32 >> 3] & ~(0xFFL << v33) | ((long)(v31 & 0x7F)) << v33;
                                arr_v7[v32 >> 3] = v34;
                                arr_v7[(v32 - 7 & v28) + (v28 & 7) >> 3] = v34;
                                arr_v6[v32] = v30;
                                arr_object3[v32] = arr_object2[v29];
                            }
                            else {
                                arr_v7 = arr_v5;
                                arr_v8 = arr_v3;
                            }
                            ++v29;
                            arr_v3 = arr_v8;
                            arr_v5 = arr_v7;
                        }
                    }
                    else {
                        long[] arr_v = this.a;
                        int v13 = this.d;
                        int[] arr_v1 = this.b;
                        Object[] arr_object = this.c;
                        for(int v14 = 0; v14 < v13 + 7 >> 3; ++v14) {
                            long v15 = arr_v[v14] & 0x8080808080808080L;
                            arr_v[v14] = 0xFEFEFEFEFEFEFEFEL & ~v15 + (v15 >>> 7);
                        }
                        v11 = (long)(v1 & 0x7F);
                        int v16 = n.k0(arr_v);
                        arr_v[v16 - 1] |= 0xFF00000000000000L;
                        arr_v[v16] = arr_v[0];
                        int v17 = 0;
                        while(v17 != v13) {
                            int v18 = (v17 & 7) << 3;
                            long v19 = arr_v[v17 >> 3] >> v18 & 0xFFL;
                            if(v19 != 0x80L && v19 == 0xFEL) {
                                int v20 = arr_v1[v17];
                                int v21 = v20 * 0xCC9E2D51 ^ v20 * 0xCC9E2D51 << 16;
                                int v22 = this.e(v21 >>> 7);
                                int v23 = v21 >>> 7 & v13;
                                if((v22 - v23 & v13) / 8 == (v17 - v23 & v13) / 8) {
                                    arr_v[v17 >> 3] = ((long)(v21 & 0x7F)) << v18 | ~(0xFFL << v18) & arr_v[v17 >> 3];
                                    arr_v[arr_v.length - 1] = arr_v[0] & 0xFFFFFFFFFFFFFFL | 0x8000000000000000L;
                                    ++v17;
                                }
                                else {
                                    long v24 = arr_v[v22 >> 3];
                                    int v25 = (v22 & 7) << 3;
                                    if((v24 >> v25 & 0xFFL) == 0x80L) {
                                        arr_v2 = arr_v1;
                                        arr_object1 = arr_object;
                                        arr_v[v22 >> 3] = ~(0xFFL << v25) & v24 | ((long)(v21 & 0x7F)) << v25;
                                        arr_v[v17 >> 3] = arr_v[v17 >> 3] & ~(0xFFL << v18) | 0x80L << v18;
                                        arr_v2[v22] = arr_v2[v17];
                                        arr_v2[v17] = 0;
                                        arr_object1[v22] = arr_object1[v17];
                                        arr_object1[v17] = null;
                                    }
                                    else {
                                        arr_v2 = arr_v1;
                                        arr_object1 = arr_object;
                                        arr_v[v22 >> 3] = ((long)(v21 & 0x7F)) << v25 | ~(0xFFL << v25) & v24;
                                        int v26 = arr_v2[v22];
                                        arr_v2[v22] = arr_v2[v17];
                                        arr_v2[v17] = v26;
                                        Object object0 = arr_object1[v22];
                                        arr_object1[v22] = arr_object1[v17];
                                        arr_object1[v17] = object0;
                                        --v17;
                                    }
                                    arr_v[arr_v.length - 1] = arr_v[0] & 0xFFFFFFFFFFFFFFL | 0x8000000000000000L;
                                    ++v17;
                                    arr_v1 = arr_v2;
                                    arr_object = arr_object1;
                                }
                            }
                            else {
                                ++v17;
                            }
                        }
                        v12 = 1;
                        this.f = S.a(this.d) - this.e;
                    }
                    v10 = this.e(v1 >>> 7);
                }
                else {
                    v11 = (long)(v1 & 0x7F);
                    v12 = 1;
                }
                ++this.e;
                int v35 = this.f;
                long[] arr_v9 = this.a;
                long v36 = arr_v9[v10 >> 3];
                int v37 = (v10 & 7) << 3;
                if((v36 >> v37 & 0xFFL) != 0x80L) {
                    v12 = 0;
                }
                this.f = v35 - v12;
                int v38 = this.d;
                long v39 = v36 & ~(0xFFL << v37) | v11 << v37;
                arr_v9[v10 >> 3] = v39;
                arr_v9[(v10 - 7 & v38) + (v38 & 7) >> 3] = v39;
                return v10;
            }
            v4 += 8;
            v3 = v3 + v4 & v2;
        }
    }

    public final int e(int v) {
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

    public final void f(int v) {
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
        this.c = new Object[v1];
    }

    public final Object g(int v) {
        int v10;
        int v1 = v * 0xCC9E2D51 ^ v * 0xCC9E2D51 << 16;
        int v2 = this.d;
        int v3 = v1 >>> 7 & v2;
        int v4 = 0;
        while(true) {
            int v5 = (v3 & 7) << 3;
            long v6 = this.a[(v3 >> 3) + 1] << 0x40 - v5 & -((long)v5) >> 0x3F | this.a[v3 >> 3] >>> v5;
            long v7 = ((long)(v1 & 0x7F)) * 0x101010101010101L ^ v6;
            long v8 = ~v7 & v7 - 0x101010101010101L & 0x8080808080808080L;
            while(v8 != 0L) {
                int v9 = (Long.numberOfTrailingZeros(v8) >> 3) + v3 & v2;
                if(this.b[v9] == v) {
                    v10 = v9;
                    goto label_17;
                }
                v8 &= v8 - 1L;
            }
            if((v6 & ~v6 << 6 & 0x8080808080808080L) == 0L) {
                goto label_30;
            }
            else {
                v10 = -1;
            }
        label_17:
            if(v10 >= 0) {
                --this.e;
                long[] arr_v = this.a;
                int v11 = this.d;
                int v12 = (v10 & 7) << 3;
                long v13 = arr_v[v10 >> 3] & ~(0xFFL << v12) | 0xFEL << v12;
                arr_v[v10 >> 3] = v13;
                arr_v[(v10 - 7 & v11) + (v11 & 7) >> 3] = v13;
                Object[] arr_object = this.c;
                Object object0 = arr_object[v10];
                arr_object[v10] = null;
                return object0;
            }
            return null;
        label_30:
            v4 += 8;
            v3 = v3 + v4 & v2;
        }
    }

    public final void h(int v, Object object0) {
        int v1 = this.d(v);
        this.b[v1] = v;
        this.c[v1] = object0;
    }
}

