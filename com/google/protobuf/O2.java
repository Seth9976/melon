package com.google.protobuf;

import Vd.w;
import com.iloen.melon.utils.a;
import e0.b;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import sun.misc.Unsafe;
import y8.s;

public final class o2 implements E2 {
    public final int[] a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final l2 e;
    public final boolean f;
    public final boolean g;
    public final int[] h;
    public final int i;
    public final int j;
    public final u2 k;
    public final Z1 l;
    public final T2 m;
    public final h1 n;
    public final h2 o;
    public static final int[] p;
    public static final Unsafe q;

    static {
        o2.p = new int[0];
        o2.q = Y2.j();
    }

    public o2(int[] arr_v, Object[] arr_object, int v, int v1, l2 l20, int[] arr_v1, int v2, int v3, u2 u20, Z1 z10, T2 t20, h1 h10, h2 h20) {
        this.a = arr_v;
        this.b = arr_object;
        this.c = v;
        this.d = v1;
        this.g = l20 instanceof A1;
        this.f = h10 != null && l20 instanceof GeneratedMessageLite.ExtendableMessage;
        this.h = arr_v1;
        this.i = v2;
        this.j = v3;
        this.k = u20;
        this.l = z10;
        this.m = t20;
        this.n = h10;
        this.e = l20;
        this.o = h20;
    }

    public final Object A(int v, int v1, Object object0) {
        E2 e20 = this.q(v1);
        if(!this.v(v, v1, object0)) {
            return e20.d();
        }
        int v2 = this.U(v1);
        Object object1 = o2.q.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(o2.u(object1)) {
            return object1;
        }
        Object object2 = e20.d();
        if(object1 != null) {
            e20.a(object2, object1);
        }
        return object2;
    }

    public static o2 B(D2 d20, u2 u20, Z1 z10, T2 t20, h1 h10, h2 h20) {
        Field field3;
        int v86;
        int v85;
        int v84;
        int v83;
        int v82;
        int v81;
        int v80;
        Field field1;
        int v77;
        Field field0;
        int v76;
        int v70;
        int v64;
        Object[] arr_object2;
        int v63;
        int v14;
        int[] arr_v;
        int v13;
        int v12;
        int v11;
        int v10;
        int v9;
        int v8;
        int v2;
        String s = d20.b;
        int v = s.length();
        if(s.charAt(0) >= 0xD800) {
            for(int v1 = 1; true; v1 = v2) {
                v2 = v1 + 1;
                if(s.charAt(v1) < 0xD800) {
                    break;
                }
            }
        }
        else {
            v2 = 1;
        }
        int v3 = v2 + 1;
        int v4 = s.charAt(v2);
        if(v4 >= 0xD800) {
            int v5 = v4 & 0x1FFF;
            int v6 = 13;
            int v7;
            while((v7 = s.charAt(v3)) >= 0xD800) {
                v5 |= (v7 & 0x1FFF) << v6;
                v6 += 13;
                ++v3;
            }
            v4 = v5 | v7 << v6;
            ++v3;
        }
        if(v4 == 0) {
            v8 = 0;
            v9 = 0;
            v10 = 0;
            v11 = 0;
            v12 = 0;
            v13 = 0;
            arr_v = o2.p;
            v14 = 0;
        }
        else {
            int v15 = v3 + 1;
            int v16 = s.charAt(v3);
            if(v16 >= 0xD800) {
                int v17 = v16 & 0x1FFF;
                int v18 = 13;
                int v19;
                while((v19 = s.charAt(v15)) >= 0xD800) {
                    v17 |= (v19 & 0x1FFF) << v18;
                    v18 += 13;
                    ++v15;
                }
                v16 = v17 | v19 << v18;
                ++v15;
            }
            int v20 = v15 + 1;
            int v21 = s.charAt(v15);
            if(v21 >= 0xD800) {
                int v22 = v21 & 0x1FFF;
                int v23 = 13;
                int v24;
                while((v24 = s.charAt(v20)) >= 0xD800) {
                    v22 |= (v24 & 0x1FFF) << v23;
                    v23 += 13;
                    ++v20;
                }
                v21 = v22 | v24 << v23;
                ++v20;
            }
            int v25 = v20 + 1;
            int v26 = s.charAt(v20);
            if(v26 >= 0xD800) {
                int v27 = v26 & 0x1FFF;
                int v28 = 13;
                int v29;
                while((v29 = s.charAt(v25)) >= 0xD800) {
                    v27 |= (v29 & 0x1FFF) << v28;
                    v28 += 13;
                    ++v25;
                }
                v26 = v27 | v29 << v28;
                ++v25;
            }
            int v30 = v25 + 1;
            int v31 = s.charAt(v25);
            if(v31 >= 0xD800) {
                int v32 = v31 & 0x1FFF;
                int v33 = 13;
                int v34;
                while((v34 = s.charAt(v30)) >= 0xD800) {
                    v32 |= (v34 & 0x1FFF) << v33;
                    v33 += 13;
                    ++v30;
                }
                v31 = v32 | v34 << v33;
                ++v30;
            }
            int v35 = v30 + 1;
            v10 = s.charAt(v30);
            if(v10 >= 0xD800) {
                int v36 = v10 & 0x1FFF;
                int v37 = 13;
                int v38;
                while((v38 = s.charAt(v35)) >= 0xD800) {
                    v36 |= (v38 & 0x1FFF) << v37;
                    v37 += 13;
                    ++v35;
                }
                v10 = v36 | v38 << v37;
                ++v35;
            }
            int v39 = v35 + 1;
            int v40 = s.charAt(v35);
            if(v40 >= 0xD800) {
                int v41 = v40 & 0x1FFF;
                int v42 = 13;
                int v43;
                while((v43 = s.charAt(v39)) >= 0xD800) {
                    v41 |= (v43 & 0x1FFF) << v42;
                    v42 += 13;
                    ++v39;
                }
                v40 = v41 | v43 << v42;
                ++v39;
            }
            int v44 = v39 + 1;
            int v45 = s.charAt(v39);
            if(v45 >= 0xD800) {
                int v46 = v45 & 0x1FFF;
                int v47 = 13;
                int v48;
                while((v48 = s.charAt(v44)) >= 0xD800) {
                    v46 |= (v48 & 0x1FFF) << v47;
                    v47 += 13;
                    ++v44;
                }
                v45 = v46 | v48 << v47;
                ++v44;
            }
            int v49 = v44 + 1;
            int v50 = s.charAt(v44);
            if(v50 >= 0xD800) {
                int v51 = v50 & 0x1FFF;
                int v52 = 13;
                int v53;
                while((v53 = s.charAt(v49)) >= 0xD800) {
                    v51 |= (v53 & 0x1FFF) << v52;
                    v52 += 13;
                    ++v49;
                }
                v50 = v51 | v53 << v52;
                ++v49;
            }
            v11 = v26;
            v8 = v40;
            v14 = v16;
            v3 = v49;
            arr_v = new int[v50 + v40 + v45];
            v12 = v31;
            v9 = v16 * 2 + v21;
            v13 = v50;
        }
        Unsafe unsafe0 = o2.q;
        Object[] arr_object = d20.c;
        Class class0 = d20.a.getClass();
        int[] arr_v1 = new int[v10 * 3];
        Object[] arr_object1 = new Object[v10 * 2];
        int v54 = v13 + v8;
        int v55 = v54;
        int v56 = v13;
        int v57 = 0;
        int v58 = 0;
        while(v3 < v) {
            int v59 = s.charAt(v3);
            if(v59 >= 0xD800) {
                int v60 = v59 & 0x1FFF;
                int v61 = v3 + 1;
                int v62 = 13;
                while(true) {
                    v63 = s.charAt(v61);
                    arr_object2 = arr_object;
                    if(v63 < 0xD800) {
                        break;
                    }
                    v60 |= (v63 & 0x1FFF) << v62;
                    v62 += 13;
                    ++v61;
                    arr_object = arr_object2;
                }
                v59 = v60 | v63 << v62;
                v64 = v61 + 1;
            }
            else {
                arr_object2 = arr_object;
                v64 = v3 + 1;
            }
            int v65 = s.charAt(v64);
            if(v65 >= 0xD800) {
                int v66 = v65 & 0x1FFF;
                int v67 = v64 + 1;
                int v68 = 13;
                int v69;
                while((v69 = s.charAt(v67)) >= 0xD800) {
                    v66 |= (v69 & 0x1FFF) << v68;
                    v68 += 13;
                    ++v67;
                }
                v65 = v66 | v69 << v68;
                v70 = v67 + 1;
            }
            else {
                v70 = v64 + 1;
            }
            if((v65 & 0x400) != 0) {
                arr_v[v58] = v57;
                ++v58;
            }
            if((v65 & 0xFF) >= 51) {
                int v71 = v70 + 1;
                int v72 = s.charAt(v70);
                if(v72 >= 0xD800) {
                    int v73 = v72 & 0x1FFF;
                    int v74 = 13;
                    int v75;
                    while((v75 = s.charAt(v71)) >= 0xD800) {
                        v73 |= (v75 & 0x1FFF) << v74;
                        v74 += 13;
                        ++v71;
                    }
                    v72 = v73 | v75 << v74;
                    ++v71;
                }
                switch((v65 & 0xFF) - 51) {
                    case 12: {
                        if(!b.a(d20.a(), 1) && (v65 & 0x800) == 0) {
                            v76 = v71;
                        }
                        else {
                            v76 = v71;
                            arr_object1[v57 / 3 * 2 + 1] = arr_object2[v9];
                            ++v9;
                        }
                        break;
                    }
                    case 9: 
                    case 17: {
                        v76 = v71;
                        arr_object1[v57 / 3 * 2 + 1] = arr_object2[v9];
                        ++v9;
                        break;
                    }
                    default: {
                        v76 = v71;
                    }
                }
                Object object0 = arr_object2[v72 * 2];
                if(object0 instanceof Field) {
                    field0 = (Field)object0;
                }
                else {
                    field0 = o2.N(class0, ((String)object0));
                    arr_object2[v72 * 2] = field0;
                }
                v77 = v9;
                int v78 = (int)unsafe0.objectFieldOffset(field0);
                int v79 = v72 * 2 + 1;
                Object object1 = arr_object2[v79];
                if(object1 instanceof Field) {
                    field1 = (Field)object1;
                }
                else {
                    field1 = o2.N(class0, ((String)object1));
                    arr_object2[v79] = field1;
                }
                v80 = v78;
                v81 = v57;
                v82 = v76;
                v83 = (int)unsafe0.objectFieldOffset(field1);
                v84 = v54;
                v85 = 0;
            }
            else {
                Field field2 = o2.N(class0, ((String)arr_object2[v9]));
                switch(v65 & 0xFF) {
                    case 9: 
                    case 17: {
                        v84 = v54;
                        arr_object1[v57 / 3 * 2 + 1] = field2.getType();
                        v86 = v9 + 1;
                        break;
                    }
                    case 12: 
                    case 30: 
                    case 44: {
                        v84 = v54;
                        if(d20.a() == 1 || (v65 & 0x800) != 0) {
                            arr_object1[v57 / 3 * 2 + 1] = arr_object2[v9 + 1];
                            v86 = v9 + 2;
                            break;
                        }
                        v86 = v9 + 1;
                        break;
                    }
                    case 27: 
                    case 49: {
                        v84 = v54;
                        arr_object1[v57 / 3 * 2 + 1] = arr_object2[v9 + 1];
                        v86 = v9 + 2;
                        break;
                    }
                    case 50: {
                        arr_v[v56] = v57;
                        int v87 = v57 / 3 * 2;
                        arr_object1[v87] = arr_object2[v9 + 1];
                        if((v65 & 0x800) == 0) {
                            v86 = v9 + 2;
                            ++v56;
                            v84 = v54;
                        }
                        else {
                            v86 = v9 + 3;
                            arr_object1[v87 + 1] = arr_object2[v9 + 2];
                            v84 = v54;
                            ++v56;
                        }
                        break;
                    }
                    default: {
                        v84 = v54;
                        v86 = v9 + 1;
                        break;
                    }
                }
                v80 = (int)unsafe0.objectFieldOffset(field2);
                if((v65 & 0x1000) == 0 || (v65 & 0xFF) > 17) {
                    v77 = v86;
                    v81 = v57;
                    v83 = 0xFFFFF;
                    v82 = v70;
                    v85 = 0;
                }
                else {
                    v82 = v70 + 1;
                    int v88 = s.charAt(v70);
                    if(v88 >= 0xD800) {
                        int v89 = v88 & 0x1FFF;
                        int v90 = 13;
                        int v91;
                        while((v91 = s.charAt(v82)) >= 0xD800) {
                            v89 |= (v91 & 0x1FFF) << v90;
                            v90 += 13;
                            ++v82;
                        }
                        v88 = v89 | v91 << v90;
                        ++v82;
                    }
                    int v92 = v88 / 0x20 + v14 * 2;
                    Object object2 = arr_object2[v92];
                    if(object2 instanceof Field) {
                        field3 = (Field)object2;
                    }
                    else {
                        field3 = o2.N(class0, ((String)object2));
                        arr_object2[v92] = field3;
                    }
                    v77 = v86;
                    v81 = v57;
                    v83 = (int)unsafe0.objectFieldOffset(field3);
                    v85 = v88 % 0x20;
                }
                if((v65 & 0xFF) >= 18 && (v65 & 0xFF) <= 49) {
                    arr_v[v55] = v80;
                    ++v55;
                }
            }
            arr_v1[v81] = v59;
            arr_v1[v81 + 1] = ((v65 & 0x200) == 0 ? 0 : 0x20000000) | ((v65 & 0x100) == 0 ? 0 : 0x10000000) | ((v65 & 0x800) == 0 ? 0 : 0x80000000) | (v65 & 0xFF) << 20 | v80;
            v57 = v81 + 3;
            arr_v1[v81 + 2] = v85 << 20 | v83;
            v3 = v82;
            arr_object = arr_object2;
            v54 = v84;
            v9 = v77;
        }
        return new o2(arr_v1, arr_object1, v11, v12, d20.a, arr_v, v13, v54, u20, z10, t20, h10, h20);
    }

    public static long C(int v) [...] // Inlined contents

    public static int D(long v, Object object0) {
        return (int)(((Integer)Y2.c.k(object0, v)));
    }

    public static long E(long v, Object object0) {
        return (long)(((Long)Y2.c.k(object0, v)));
    }

    public final int F(Object object0, byte[] arr_b, int v, int v1, int v2, long v3, g g0) {
        int v9;
        Unsafe unsafe0 = o2.q;
        Object object1 = this.p(v2);
        g2 g20 = unsafe0.getObject(object0, v3);
        h2 h20 = this.o;
        h20.getClass();
        if(!g20.a) {
            h20.getClass();
            g2 g21 = g2.b.c();
            h20.a(g21, g20);
            unsafe0.putObject(object0, v3, g21);
            g20 = g21;
        }
        h20.getClass();
        s s0 = ((f2)object1).a;
        h20.getClass();
        int v4 = h.x(arr_b, v, g0);
        int v5 = g0.a;
        if(v5 < 0 || v5 > v1 - v4) {
            throw R1.h();
        }
        int v6 = v4 + v5;
        Object object2 = s0.c;
        String s1 = "";
        Object object3 = object2;
        while(v4 < v6) {
            int v7 = v4 + 1;
            int v8 = arr_b[v4];
            if(v8 < 0) {
                v7 = h.w(v8, arr_b, v7, g0);
                v8 = g0.a;
            }
            switch(v8 >>> 3) {
                case 1: {
                    j3 j30 = (j3)s0.a;
                    if((v8 & 7) == j30.b) {
                        v9 = o2.m(arr_b, v7, v1, j30, null, g0);
                        s1 = g0.c;
                        v4 = v9;
                        continue;
                    }
                    break;
                }
                case 2: {
                    j3 j31 = (j3)s0.b;
                    if((v8 & 7) == j31.b) {
                        v9 = o2.m(arr_b, v7, v1, j31, object2.getClass(), g0);
                        object3 = g0.c;
                        v4 = v9;
                        continue;
                    }
                }
            }
            v4 = h.H(v8, arr_b, v7, v1, g0);
        }
        if(v4 != v6) {
            throw R1.g();
        }
        g20.put(s1, object3);
        return v6;
    }

    public final int G(Object object0, byte[] arr_b, int v, int v1, int v2, g g0) {
        int v56;
        Object object6;
        int v60;
        Object object7;
        int v58;
        int v54;
        int v53;
        g1 g12;
        int v52;
        int v51;
        int v47;
        int v46;
        Unsafe unsafe2;
        int v30;
        Unsafe unsafe5;
        int v43;
        int v42;
        int v34;
        int v35;
        Object object3;
        Unsafe unsafe4;
        int v38;
        int v37;
        Unsafe unsafe3;
        int v31;
        int v29;
        int v28;
        int v27;
        int v26;
        int v19;
        Object object2;
        o2 o21;
        int v18;
        int v17;
        Unsafe unsafe1;
        g1 g11;
        int v16;
        int v15;
        int v14;
        o2 o20 = this;
        Object object1 = object0;
        g1 g10 = g0.d;
        o2.l(object1);
        Unsafe unsafe0 = o2.q;
        int v3 = v;
        int v4 = -1;
        int v5 = 0;
        int v6 = 0xFFFFF;
        int v7 = 0;
        int v8 = 0;
        while(true) {
            if(v3 >= v1) {
                v16 = v6;
                unsafe1 = unsafe0;
                o21 = o20;
                object2 = object1;
                v52 = v3;
                v51 = v8;
                break;
            }
            int v9 = v3 + 1;
            int v10 = arr_b[v3];
            if(v10 < 0) {
                v9 = h.w(v10, arr_b, v9, g0);
                v10 = g0.a;
            }
            int v11 = v10 >>> 3;
            int v12 = o20.d;
            int v13 = o20.c;
            if(v11 <= v4) {
                v14 = v11 < v13 || v11 > v12 ? -1 : o20.Q(v11, 0);
            }
            else if(v11 < v13 || v11 > v12) {
                v14 = -1;
            }
            else {
                v14 = o20.Q(v11, v5 / 3);
            }
            if(v14 == -1) {
                v15 = v9;
                v16 = v6;
                g11 = g10;
                unsafe1 = unsafe0;
                v17 = 0;
                v18 = v11;
                o21 = o20;
                object2 = object1;
                v19 = v10;
            }
            else {
                int[] arr_v = o20.a;
                int v20 = arr_v[v14 + 1];
                int v21 = (v20 & 0xFF00000) >>> 20;
                long v22 = (long)(v20 & 0xFFFFF);
                if(v21 <= 17) {
                    int v23 = arr_v[v14 + 2];
                    int v24 = 1 << (v23 >>> 20);
                    int v25 = v23 & 0xFFFFF;
                    if(v25 == v6) {
                        v26 = v10 & 7;
                        v29 = v7;
                        v28 = v6;
                    }
                    else {
                        if(v6 != 0xFFFFF) {
                            unsafe0.putInt(object1, ((long)v6), v7);
                        }
                        if(v25 == 0xFFFFF) {
                            v26 = v10 & 7;
                            v27 = 0;
                        }
                        else {
                            v26 = v10 & 7;
                            v27 = unsafe0.getInt(object1, ((long)v25));
                        }
                        v28 = v25;
                        v29 = v27;
                    }
                    switch(v21) {
                        case 0: {
                            v30 = v9;
                            v8 = v10;
                            v31 = v14;
                            unsafe3 = unsafe0;
                            if(v26 == 1) {
                                double f = Double.longBitsToDouble(h.f(v30, arr_b));
                                Y2.c.o(object0, v22, f);
                                object1 = object0;
                                v3 = v30 + 8;
                                v4 = v11;
                                v6 = v28;
                                v7 = v29 | v24;
                                unsafe0 = unsafe3;
                                v5 = v31;
                                continue;
                            }
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 1: {
                            v30 = v9;
                            v8 = v10;
                            v31 = v14;
                            unsafe3 = unsafe0;
                            if(v26 == 5) {
                                float f1 = Float.intBitsToFloat(h.e(v30, arr_b));
                                Y2.c.p(object1, v22, f1);
                                v3 = v30 + 4;
                                goto label_124;
                            }
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 2: 
                        case 3: {
                            v30 = v9;
                            v8 = v10;
                            v31 = v14;
                            unsafe3 = unsafe0;
                            if(v26 == 0) {
                                int v32 = h.z(arr_b, v30, g0);
                                unsafe3.putLong(object1, v22, g0.b);
                                unsafe0 = unsafe3;
                                v4 = v11;
                                v6 = v28;
                                v7 = v29 | v24;
                                v3 = v32;
                                v5 = v31;
                                continue;
                            }
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 7: {
                        label_145:
                            object3 = object1;
                            if(v26 == 0) {
                                v35 = h.z(arr_b, v9, g0);
                                v8 = v10;
                                Y2.c.m(object3, v22, g0.b != 0L);
                                v34 = v29 | v24;
                                v5 = v14;
                                v4 = v11;
                                v3 = v35;
                                object1 = object3;
                                v6 = v28;
                                v7 = v34;
                                continue;
                            }
                            else {
                                v8 = v10;
                                v31 = v14;
                                v30 = v9;
                                unsafe2 = unsafe0;
                                object1 = object3;
                                break;
                            }
                            goto label_158;
                        }
                        case 8: {
                        label_158:
                            object3 = object1;
                            if(v26 == 2) {
                                if((0x20000000 & v20) == 0) {
                                    v35 = h.r(arr_b, v9, g0);
                                }
                                else {
                                    v35 = h.x(arr_b, v9, g0);
                                    int v36 = g0.a;
                                    if(v36 < 0) {
                                        throw R1.f();
                                    }
                                    if(v36 == 0) {
                                        g0.c = "";
                                    }
                                    else {
                                        g0.c = b3.a.t(arr_b, v35, v36);
                                        v35 += v36;
                                    }
                                }
                                unsafe0.putObject(object3, v22, g0.c);
                                v34 = v29 | v24;
                                v5 = v14;
                                v8 = v10;
                                v4 = v11;
                                v3 = v35;
                                object1 = object3;
                                v6 = v28;
                                v7 = v34;
                                continue;
                            }
                            else {
                                v30 = v9;
                                unsafe2 = unsafe0;
                                v8 = v10;
                                v31 = v14;
                                object1 = object3;
                                break;
                            }
                            goto label_182;
                        }
                        case 9: {
                        label_182:
                            if(v26 == 2) {
                                Object object4 = o20.z(v14, object1);
                                v5 = v14;
                                object3 = object1;
                                v35 = h.E(object4, o20.q(v14), arr_b, v9, v1, g0);
                                o20.R(v5, object3, object4);
                                v34 = v29 | v24;
                                v8 = v10;
                                v4 = v11;
                                v3 = v35;
                                object1 = object3;
                                v6 = v28;
                                v7 = v34;
                                continue;
                            }
                            else {
                                object3 = object1;
                                v30 = v9;
                                unsafe2 = unsafe0;
                                v8 = v10;
                                v31 = v14;
                            }
                            object1 = object3;
                            break;
                        }
                        case 10: {
                            v37 = v9;
                            v38 = v14;
                            unsafe4 = unsafe0;
                            if(v26 == 2) {
                                v3 = h.d(arr_b, v37, g0);
                                unsafe4.putObject(object1, v22, g0.c);
                                unsafe0 = unsafe4;
                                v6 = v28;
                                v7 = v29 | v24;
                                v5 = v38;
                                v8 = v10;
                                v4 = v11;
                                continue;
                            }
                            goto label_241;
                        }
                        case 4: 
                        case 11: {
                            v30 = v9;
                            v8 = v10;
                            v31 = v14;
                            unsafe3 = unsafe0;
                            if(v26 == 0) {
                                int v33 = h.x(arr_b, v30, g0);
                                unsafe3.putInt(object1, v22, g0.a);
                                unsafe0 = unsafe3;
                                v7 = v29 | v24;
                                v3 = v33;
                                v6 = v28;
                                v5 = v31;
                                v4 = v11;
                                continue;
                            }
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 12: {
                            v37 = v9;
                            v38 = v14;
                            unsafe4 = unsafe0;
                            if(v26 == 0) {
                                int v39 = h.x(arr_b, v37, g0);
                                int v40 = g0.a;
                                int v41 = v39;
                                I1 i10 = o20.o(v38);
                                if((v20 & 0x80000000) == 0 || i10 == null || i10.a(v40)) {
                                    unsafe4.putInt(object1, v22, v40);
                                    v5 = v38;
                                    v8 = v10;
                                    v4 = v11;
                                    unsafe0 = unsafe4;
                                    v6 = v28;
                                    v7 = v29 | v24;
                                    v3 = v41;
                                }
                                else {
                                    o2.r(object1).f(v10, ((long)v40));
                                    v3 = v41;
                                    v5 = v38;
                                    v8 = v10;
                                    v4 = v11;
                                    unsafe0 = unsafe4;
                                    v6 = v28;
                                    v7 = v29;
                                }
                                continue;
                            }
                        label_241:
                            unsafe2 = unsafe4;
                            v30 = v37;
                            v8 = v10;
                            v31 = v38;
                            break;
                        }
                        case 6: 
                        case 13: {
                            object3 = object1;
                            v8 = v10;
                            v31 = v14;
                            if(v26 == 5) {
                                unsafe0.putInt(object3, v22, h.e(v9, arr_b));
                                v35 = v9 + 4;
                                v34 = v29 | v24;
                                v5 = v31;
                                v4 = v11;
                                v3 = v35;
                                object1 = object3;
                                v6 = v28;
                                v7 = v34;
                                continue;
                            }
                            else {
                                v30 = v9;
                                unsafe2 = unsafe0;
                                object1 = object3;
                                break;
                            }
                            goto label_145;
                        }
                        case 5: 
                        case 14: {
                            v8 = v10;
                            v31 = v14;
                            if(v26 == 1) {
                                unsafe0.putLong(object1, v22, h.f(v9, arr_b));
                                unsafe3 = unsafe0;
                                v3 = v9 + 8;
                            label_124:
                                v34 = v29 | v24;
                                unsafe0 = unsafe3;
                                v5 = v31;
                                v4 = v11;
                                v6 = v28;
                                v7 = v34;
                                continue;
                            }
                            else {
                                v30 = v9;
                                unsafe3 = unsafe0;
                            }
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 15: {
                            v42 = v9;
                            v43 = v14;
                            unsafe5 = unsafe0;
                            if(v26 == 0) {
                                v3 = h.x(arr_b, v42, g0);
                                unsafe5.putInt(object1, v22, -(g0.a & 1) ^ g0.a >>> 1);
                                v34 = v29 | v24;
                                v8 = v10;
                                v5 = v43;
                                v4 = v11;
                                unsafe0 = unsafe5;
                                v6 = v28;
                                v7 = v34;
                                continue;
                            }
                            goto label_273;
                        }
                        case 16: {
                            v42 = v9;
                            v43 = v14;
                            if(v26 == 0) {
                                int v44 = h.z(arr_b, v42, g0);
                                unsafe0.putLong(object1, v22, -(g0.b & 1L) ^ g0.b >>> 1);
                                v8 = v10;
                                v4 = v11;
                                v6 = v28;
                                v7 = v29 | v24;
                                v3 = v44;
                                v5 = v43;
                                continue;
                            }
                            else {
                                unsafe5 = unsafe0;
                            }
                        label_273:
                            unsafe2 = unsafe5;
                            v8 = v10;
                            v31 = v43;
                            v30 = v42;
                            break;
                        }
                        case 17: {
                            if(v26 == 3) {
                                Object object5 = o20.z(v14, object1);
                                v3 = h.D(object5, o20.q(v14), arr_b, v9, v1, v11 << 3 | 4, g0);
                                o20.R(v14, object1, object5);
                                v8 = v10;
                                v5 = v14;
                                v4 = v11;
                                v6 = v28;
                                v7 = v29 | v24;
                                continue;
                            }
                            else {
                                v30 = v9;
                                unsafe2 = unsafe0;
                                v8 = v10;
                            }
                            v31 = v14;
                            break;
                        }
                        default: {
                            v30 = v9;
                            unsafe2 = unsafe0;
                            v8 = v10;
                            v31 = v14;
                            break;
                        }
                    }
                    o21 = o20;
                    object2 = object1;
                    unsafe1 = unsafe2;
                    g11 = g10;
                    v17 = v31;
                    v15 = v30;
                    v18 = v11;
                    v16 = v28;
                    v19 = v8;
                    v7 = v29;
                }
                else {
                    v8 = v10;
                    if(v21 == 27) {
                        if((v10 & 7) == 2) {
                            O1 o10 = (O1)unsafe0.getObject(object1, v22);
                            if(!((c)o10).a) {
                                int v45 = o10.size();
                                o10 = o10.n((v45 == 0 ? 10 : v45 * 2));
                                unsafe0.putObject(object1, v22, o10);
                            }
                            v3 = h.i(o20.q(v14), v8, arr_b, v9, v1, o10, g0);
                            v5 = v14;
                            v4 = v11;
                            object1 = object0;
                            continue;
                        }
                        else {
                            unsafe1 = unsafe0;
                            v16 = v6;
                            g11 = g10;
                            v46 = v11;
                            v47 = v7;
                            o21 = this;
                            v15 = v9;
                            goto label_362;
                        }
                        goto label_324;
                    }
                    else {
                    label_324:
                        if(v21 <= 49) {
                            g11 = g10;
                            unsafe1 = unsafe0;
                            v16 = v6;
                            v47 = v7;
                            int v48 = o20.I(object0, arr_b, v9, v1, v8, v11, v10 & 7, v14, ((long)v20), v21, v22, g0);
                            v18 = v11;
                            if(v48 == v9) {
                                o21 = this;
                                object2 = object0;
                                v15 = v48;
                                v17 = v14;
                                v19 = v8;
                                goto label_386;
                            }
                            else {
                                o20 = this;
                                object1 = object0;
                                v3 = v48;
                                v4 = v18;
                                goto label_379;
                            }
                            goto label_343;
                        }
                        else {
                        label_343:
                            v16 = v6;
                            g11 = g10;
                            unsafe1 = unsafe0;
                            v46 = v11;
                            v47 = v7;
                            if(v21 == 50) {
                                if((v10 & 7) == 2) {
                                    int v49 = this.F(object0, arr_b, v9, v1, v14, v22, g0);
                                    if(v49 == v9) {
                                        o21 = this;
                                        v15 = v49;
                                        goto label_362;
                                    }
                                    else {
                                        o20 = this;
                                        object1 = object0;
                                        v3 = v49;
                                        v4 = v46;
                                        goto label_379;
                                    }
                                    goto label_360;
                                }
                                else {
                                label_360:
                                    o21 = this;
                                    v15 = v9;
                                }
                            label_362:
                                v18 = v46;
                                v17 = v14;
                                v19 = v8;
                                v7 = v47;
                                object2 = object0;
                                goto label_387;
                            }
                            else {
                                int v50 = this.H(object0, arr_b, v9, v1, v8, v46, v10 & 7, v20, v21, v22, v14, g0);
                                o21 = this;
                                object2 = object0;
                                v19 = v8;
                                v18 = v46;
                                if(v50 == v9) {
                                    v15 = v50;
                                    v17 = v14;
                                }
                                else {
                                    v8 = v19;
                                    v3 = v50;
                                    o20 = o21;
                                    v4 = v18;
                                    object1 = object2;
                                label_379:
                                    v5 = v14;
                                    v6 = v16;
                                    v7 = v47;
                                    g10 = g11;
                                    goto label_566;
                                }
                            }
                        }
                    label_386:
                        v7 = v47;
                    }
                }
            }
        label_387:
            if(v19 == v2 && v2 != 0) {
                v51 = v19;
                v52 = v15;
                break;
            }
            if(o21.f) {
                g12 = g11;
                if(g12 != g1.b()) {
                    y1 y10 = g12.a(v18, o21.e);
                    if(y10 == null) {
                        v8 = v19;
                        v53 = h.s(v19, arr_b, v15, v1, o2.r(object2), g0);
                        v54 = v17;
                        v56 = v7;
                        v3 = v53;
                        goto label_559;
                    }
                    else {
                        v8 = v19;
                        ((GeneratedMessageLite.ExtendableMessage)object2).ensureExtensionsAreMutable();
                        o1 o11 = ((GeneratedMessageLite.ExtendableMessage)object2).extensions;
                        int v55 = v8 >>> 3;
                        x1 x10 = y10.d;
                        j3 j30 = x10.b;
                        l2 l20 = y10.c;
                        boolean z = false;
                        if(!x10.c || !x10.d) {
                            v54 = v17;
                            v56 = v7;
                            if(j30 != j3.g) {
                                switch(j30.ordinal()) {
                                    case 0: {
                                        object6 = Double.longBitsToDouble(h.f(v15, arr_b));
                                        v53 = v15 + 8;
                                        goto label_546;
                                    }
                                    case 1: {
                                        object6 = Float.intBitsToFloat(h.e(v15, arr_b));
                                        v53 = v15 + 4;
                                        goto label_546;
                                    }
                                    case 2: 
                                    case 3: {
                                        v58 = h.z(arr_b, v15, g0);
                                        object7 = g0.b;
                                        v53 = v58;
                                        object6 = object7;
                                        goto label_546;
                                    }
                                    case 7: {
                                        v58 = h.z(arr_b, v15, g0);
                                        if(g0.b != 0L) {
                                            z = true;
                                        }
                                        object7 = Boolean.valueOf(z);
                                        v53 = v58;
                                        object6 = object7;
                                        goto label_546;
                                    }
                                    case 8: {
                                        v53 = h.r(arr_b, v15, g0);
                                        object6 = g0.c;
                                        goto label_546;
                                    }
                                    case 9: {
                                        int v59 = v55 << 3 | 4;
                                        Class class0 = l20.getClass();
                                        E2 e20 = B2.c.a(class0);
                                        if(x10.c) {
                                            v60 = h.g(e20, arr_b, v15, v1, v59, g0);
                                            o11.a(x10, g0.c);
                                        }
                                        else {
                                            Object object8 = o11.a.get(x10);
                                            if(object8 == null) {
                                                object8 = e20.d();
                                                o11.o(x10, object8);
                                            }
                                            v60 = h.D(object8, e20, arr_b, v15, v1, v59, g0);
                                        }
                                        v53 = v60;
                                        break;
                                    }
                                    case 10: {
                                        Class class1 = l20.getClass();
                                        E2 e21 = B2.c.a(class1);
                                        if(x10.c) {
                                            int v61 = h.h(e21, arr_b, v15, v1, g0);
                                            o11.a(x10, g0.c);
                                            v53 = v61;
                                        }
                                        else {
                                            Object object9 = o11.a.get(x10);
                                            if(object9 == null) {
                                                object9 = e21.d();
                                                o11.o(x10, object9);
                                            }
                                            v53 = h.E(object9, e21, arr_b, v15, v1, g0);
                                        }
                                        break;
                                    }
                                    case 11: {
                                        v15 = h.d(arr_b, v15, g0);
                                        object6 = g0.c;
                                        v53 = v15;
                                        goto label_546;
                                    }
                                    case 4: 
                                    case 12: {
                                        v58 = h.x(arr_b, v15, g0);
                                        object7 = g0.a;
                                        v53 = v58;
                                        object6 = object7;
                                        goto label_546;
                                    }
                                    case 13: {
                                        throw new IllegalStateException("Shouldn\'t reach here.");
                                    }
                                    case 6: 
                                    case 14: {
                                        object6 = h.e(v15, arr_b);
                                        v53 = v15 + 4;
                                        goto label_546;
                                    }
                                    case 5: 
                                    case 15: {
                                        object6 = h.f(v15, arr_b);
                                        v53 = v15 + 8;
                                        goto label_546;
                                    }
                                    case 16: {
                                        v15 = h.x(arr_b, v15, g0);
                                        object6 = (int)(-(g0.a & 1) ^ g0.a >>> 1);
                                        v53 = v15;
                                        goto label_546;
                                    }
                                    case 17: {
                                        v15 = h.z(arr_b, v15, g0);
                                        object6 = (long)(-(g0.b & 1L) ^ g0.b >>> 1);
                                        v53 = v15;
                                    label_546:
                                        if(x10.c) {
                                            o11.a(x10, object6);
                                        }
                                        else {
                                            o11.o(x10, object6);
                                        }
                                        break;
                                    }
                                    default: {
                                        object6 = null;
                                        v53 = v15;
                                        goto label_546;
                                    }
                                }
                                v3 = v53;
                                goto label_559;
                            }
                            h.x(arr_b, v15, g0);
                            throw null;
                        }
                        else {
                            switch(j30.ordinal()) {
                                case 0: {
                                    v54 = v17;
                                    v56 = v7;
                                    W0 w00 = new W0(W0.d, 0, true);
                                    v53 = h.k(arr_b, v15, w00, g0);
                                    o11.o(x10, w00);
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 1: {
                                    v54 = v17;
                                    v56 = v7;
                                    q1 q10 = new q1(q1.d, 0, true);
                                    v53 = h.n(arr_b, v15, q10, g0);
                                    o11.o(x10, q10);
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 2: 
                                case 3: {
                                    v54 = v17;
                                    c2 c20 = new c2();
                                    v53 = h.x(arr_b, v15, g0);
                                    int v57 = g0.a + v53;
                                    while(v53 < v57) {
                                        v53 = h.z(arr_b, v53, g0);
                                        c20.d(g0.b);
                                    }
                                    v56 = v7;
                                    if(v53 != v57) {
                                        throw R1.h();
                                    }
                                    o11.o(x10, c20);
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 7: {
                                    v54 = v17;
                                    j j0 = new j(j.d, 0, true);
                                    v53 = h.j(arr_b, v15, j0, g0);
                                    o11.o(x10, j0);
                                    v56 = v7;
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 4: 
                                case 12: {
                                    v54 = v17;
                                    D1 d10 = new D1();
                                    v53 = h.q(arr_b, v15, d10, g0);
                                    o11.o(x10, d10);
                                    v56 = v7;
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 13: {
                                    D1 d12 = new D1();
                                    v53 = h.q(arr_b, v15, d12, g0);
                                    F2.k(((GeneratedMessageLite.ExtendableMessage)object2), v55, d12, null, null, o21.m);
                                    o11.o(x10, d12);
                                    v54 = v17;
                                    v56 = v7;
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 6: 
                                case 14: {
                                    v54 = v17;
                                    D1 d11 = new D1();
                                    v53 = h.l(arr_b, v15, d11, g0);
                                    o11.o(x10, d11);
                                    v56 = v7;
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 5: 
                                case 15: {
                                    v54 = v17;
                                    c2 c21 = new c2();
                                    v53 = h.m(arr_b, v15, c21, g0);
                                    o11.o(x10, c21);
                                    v56 = v7;
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 16: {
                                    D1 d13 = new D1();
                                    v53 = h.o(arr_b, v15, d13, g0);
                                    o11.o(x10, d13);
                                    v54 = v17;
                                    v56 = v7;
                                    v3 = v53;
                                    goto label_559;
                                }
                                case 17: {
                                    c2 c22 = new c2();
                                    v53 = h.p(arr_b, v15, c22, g0);
                                    o11.o(x10, c22);
                                    v54 = v17;
                                    v56 = v7;
                                    v3 = v53;
                                    goto label_559;
                                }
                                default: {
                                    throw new IllegalStateException("Type cannot be packed: " + x10.b);
                                }
                            }
                        }
                    }
                    goto label_554;
                }
            }
            else {
            label_554:
                g12 = g11;
            }
            v8 = v19;
            v54 = v17;
            v56 = v7;
            v3 = h.s(v8, arr_b, v15, v1, o2.r(object2), g0);
        label_559:
            v7 = v56;
            o20 = o21;
            v4 = v18;
            object1 = object2;
            g10 = g12;
            v6 = v16;
            v5 = v54;
        label_566:
            unsafe0 = unsafe1;
        }
        if(v16 != 0xFFFFF) {
            unsafe1.putInt(object2, ((long)v16), v7);
        }
        S2 s20 = null;
        int v62 = o21.i;
        while(v62 < o21.j) {
            s20 = (S2)o21.n(object2, o21.h[v62], s20, o21.m, object0);
            ++v62;
            object2 = object0;
        }
        if(s20 != null) {
            o21.m.getClass();
            ((A1)object0).unknownFields = s20;
        }
        if(v2 == 0) {
            if(v52 != v1) {
                throw R1.g();
            }
            return v52;
        }
        if(v52 > v1 || v51 != v2) {
            throw R1.g();
        }
        return v52;
    }

    public final int H(Object object0, byte[] arr_b, int v, int v1, int v2, int v3, int v4, int v5, int v6, long v7, int v8, g g0) {
        Unsafe unsafe0 = o2.q;
        long v9 = (long)(this.a[v8 + 2] & 0xFFFFF);
        boolean z = true;
        switch(v6) {
            case 51: {
                if(v4 == 1) {
                    unsafe0.putObject(object0, v7, Double.longBitsToDouble(h.f(v, arr_b)));
                    unsafe0.putInt(object0, v9, v3);
                    return v + 8;
                }
                break;
            }
            case 52: {
                if(v4 == 5) {
                    unsafe0.putObject(object0, v7, Float.intBitsToFloat(h.e(v, arr_b)));
                    unsafe0.putInt(object0, v9, v3);
                    return v + 4;
                }
                break;
            }
            case 53: 
            case 54: {
                if(v4 == 0) {
                    int v11 = h.z(arr_b, v, g0);
                    unsafe0.putObject(object0, v7, g0.b);
                    unsafe0.putInt(object0, v9, v3);
                    return v11;
                }
                break;
            }
            case 58: {
                if(v4 == 0) {
                    int v13 = h.z(arr_b, v, g0);
                    if(g0.b == 0L) {
                        z = false;
                    }
                    unsafe0.putObject(object0, v7, Boolean.valueOf(z));
                    unsafe0.putInt(object0, v9, v3);
                    return v13;
                }
                break;
            }
            case 59: {
                if(v4 == 2) {
                    int v14 = h.x(arr_b, v, g0);
                    int v15 = g0.a;
                    if(v15 == 0) {
                        unsafe0.putObject(object0, v7, "");
                    }
                    else {
                        if((v5 & 0x20000000) != 0 && b3.a.F(arr_b, v14, v14 + v15) != 0) {
                            throw R1.c();
                        }
                        unsafe0.putObject(object0, v7, new String(arr_b, v14, v15, P1.a));
                        v14 += v15;
                    }
                    unsafe0.putInt(object0, v9, v3);
                    return v14;
                }
                break;
            }
            case 60: {
                if(v4 == 2) {
                    Object object2 = this.A(v3, v8, object0);
                    int v16 = h.E(object2, this.q(v8), arr_b, v, v1, g0);
                    this.S(v3, object0, object2, v8);
                    return v16;
                }
                break;
            }
            case 61: {
                if(v4 == 2) {
                    int v17 = h.d(arr_b, v, g0);
                    unsafe0.putObject(object0, v7, g0.c);
                    unsafe0.putInt(object0, v9, v3);
                    return v17;
                }
                break;
            }
            case 55: 
            case 62: {
                if(v4 == 0) {
                    int v12 = h.x(arr_b, v, g0);
                    unsafe0.putObject(object0, v7, g0.a);
                    unsafe0.putInt(object0, v9, v3);
                    return v12;
                }
                break;
            }
            case 0x3F: {
                if(v4 == 0) {
                    int v18 = h.x(arr_b, v, g0);
                    int v19 = g0.a;
                    I1 i10 = this.o(v8);
                    if(i10 != null && !i10.a(v19)) {
                        o2.r(object0).f(v2, ((long)v19));
                        return v18;
                    }
                    unsafe0.putObject(object0, v7, v19);
                    unsafe0.putInt(object0, v9, v3);
                    return v18;
                }
                break;
            }
            case 57: 
            case 0x40: {
                if(v4 == 5) {
                    unsafe0.putObject(object0, v7, h.e(v, arr_b));
                    unsafe0.putInt(object0, v9, v3);
                    return v + 4;
                }
                break;
            }
            case 56: 
            case 65: {
                if(v4 == 1) {
                    unsafe0.putObject(object0, v7, h.f(v, arr_b));
                    unsafe0.putInt(object0, v9, v3);
                    return v + 8;
                }
                break;
            }
            case 66: {
                if(v4 == 0) {
                    int v20 = h.x(arr_b, v, g0);
                    unsafe0.putObject(object0, v7, ((int)(-(g0.a & 1) ^ g0.a >>> 1)));
                    unsafe0.putInt(object0, v9, v3);
                    return v20;
                }
                break;
            }
            case 67: {
                if(v4 == 0) {
                    int v21 = h.z(arr_b, v, g0);
                    unsafe0.putObject(object0, v7, ((long)(-(g0.b & 1L) ^ g0.b >>> 1)));
                    unsafe0.putInt(object0, v9, v3);
                    return v21;
                }
                break;
            }
            case 68: {
                if(v4 == 3) {
                    Object object1 = this.A(v3, v8, object0);
                    int v10 = h.D(object1, this.q(v8), arr_b, v, v1, v2 & -8 | 4, g0);
                    this.S(v3, object0, object1, v8);
                    return v10;
                }
                return v;
            }
            default: {
                return v;
            }
        }
        return v;
    }

    public final int I(Object object0, byte[] arr_b, int v, int v1, int v2, int v3, int v4, int v5, long v6, int v7, long v8, g g0) {
        int v23;
        Unsafe unsafe0 = o2.q;
        O1 o10 = (O1)unsafe0.getObject(object0, v8);
        if(!((c)o10).a) {
            o10 = o10.n(o10.size() * 2);
            unsafe0.putObject(object0, v8, o10);
        }
        switch(v7) {
            case 26: {
                if(v4 == 2) {
                    if(Long.compare(v6 & 0x20000000L, 0L) == 0) {
                        int v28 = h.x(arr_b, v, g0);
                        int v29 = g0.a;
                        if(v29 < 0) {
                            throw R1.f();
                        }
                        if(v29 == 0) {
                            o10.add("");
                            goto label_133;
                        }
                        else {
                            o10.add(new String(arr_b, v28, v29, P1.a));
                        }
                    alab1:
                        while(true) {
                            v28 += v29;
                            while(true) {
                            label_133:
                                if(v28 >= v1) {
                                    break alab1;
                                }
                                int v30 = h.x(arr_b, v28, g0);
                                if(v2 != g0.a) {
                                    break alab1;
                                }
                                v28 = h.x(arr_b, v30, g0);
                                v29 = g0.a;
                                if(v29 < 0) {
                                    throw R1.f();
                                }
                                if(v29 != 0) {
                                    o10.add(new String(arr_b, v28, v29, P1.a));
                                    break;
                                }
                                o10.add("");
                            }
                        }
                        return v28;
                    }
                    int v31 = h.x(arr_b, v, g0);
                    int v32 = g0.a;
                    if(v32 < 0) {
                        throw R1.f();
                    }
                    if(v32 == 0) {
                        o10.add("");
                        goto label_157;
                    }
                    int v33 = v31 + v32;
                    if(b3.a.F(arr_b, v31, v33) != 0) {
                        throw R1.c();
                    }
                    o10.add(new String(arr_b, v31, v32, P1.a));
                alab2:
                    while(true) {
                        v31 = v33;
                        while(true) {
                        label_157:
                            if(v31 >= v1) {
                                return v31;
                            }
                            int v34 = h.x(arr_b, v31, g0);
                            if(v2 != g0.a) {
                                return v31;
                            }
                            v31 = h.x(arr_b, v34, g0);
                            int v35 = g0.a;
                            if(v35 < 0) {
                                throw R1.f();
                            }
                            if(v35 != 0) {
                                v33 = v31 + v35;
                                if(b3.a.F(arr_b, v31, v33) != 0) {
                                    break alab2;
                                }
                                o10.add(new String(arr_b, v31, v35, P1.a));
                                break;
                            }
                            o10.add("");
                        }
                    }
                    throw R1.c();
                }
                break;
            }
            case 27: {
                return v4 == 2 ? h.i(this.q(v5), v2, arr_b, v, v1, o10, g0) : v;
            }
            case 28: {
                if(v4 == 2) {
                    int v36 = h.x(arr_b, v, g0);
                    int v37 = g0.a;
                    if(v37 < 0) {
                        throw R1.f();
                    }
                    if(v37 > arr_b.length - v36) {
                        throw R1.h();
                    }
                    if(v37 == 0) {
                        o10.add(o.b);
                        goto label_185;
                    }
                    else {
                        o10.add(o.d(arr_b, v36, v37));
                    }
                alab3:
                    while(true) {
                        v36 += v37;
                        while(true) {
                        label_185:
                            if(v36 >= v1) {
                                return v36;
                            }
                            int v38 = h.x(arr_b, v36, g0);
                            if(v2 != g0.a) {
                                return v36;
                            }
                            v36 = h.x(arr_b, v38, g0);
                            v37 = g0.a;
                            if(v37 < 0) {
                                throw R1.f();
                            }
                            if(v37 > arr_b.length - v36) {
                                break alab3;
                            }
                            if(v37 != 0) {
                                o10.add(o.d(arr_b, v36, v37));
                                break;
                            }
                            o10.add(o.b);
                        }
                    }
                    throw R1.h();
                }
                break;
            }
            case 18: 
            case 35: {
                switch(v4) {
                    case 1: {
                        ((W0)o10).d(Double.longBitsToDouble(h.f(v, arr_b)));
                        int v9;
                        for(v9 = v + 8; v9 < v1; v9 = v10 + 8) {
                            int v10 = h.x(arr_b, v9, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            ((W0)o10).d(Double.longBitsToDouble(h.f(v10, arr_b)));
                        }
                        return v9;
                    }
                    case 2: {
                        return h.k(arr_b, v, o10, g0);
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 19: 
            case 36: {
                switch(v4) {
                    case 2: {
                        return h.n(arr_b, v, o10, g0);
                    }
                    case 5: {
                        ((q1)o10).d(Float.intBitsToFloat(h.e(v, arr_b)));
                        int v11;
                        for(v11 = v + 4; v11 < v1; v11 = v12 + 4) {
                            int v12 = h.x(arr_b, v11, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            ((q1)o10).d(Float.intBitsToFloat(h.e(v12, arr_b)));
                        }
                        return v11;
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 20: 
            case 21: 
            case 37: 
            case 38: {
                switch(v4) {
                    case 0: {
                        int v13 = h.z(arr_b, v, g0);
                        ((c2)o10).d(g0.b);
                        while(v13 < v1) {
                            int v14 = h.x(arr_b, v13, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            v13 = h.z(arr_b, v14, g0);
                            ((c2)o10).d(g0.b);
                        }
                        return v13;
                    }
                    case 2: {
                        int v15 = h.x(arr_b, v, g0);
                        int v16 = g0.a + v15;
                        while(v15 < v16) {
                            v15 = h.z(arr_b, v15, g0);
                            ((c2)o10).d(g0.b);
                        }
                        if(v15 != v16) {
                            throw R1.h();
                        }
                        return v15;
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 25: 
            case 42: {
                switch(v4) {
                    case 0: {
                        int v21 = h.z(arr_b, v, g0);
                        ((j)o10).d(Long.compare(g0.b, 0L) != 0);
                        while(v21 < v1) {
                            int v22 = h.x(arr_b, v21, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            v21 = h.z(arr_b, v22, g0);
                            ((j)o10).d(g0.b != 0L);
                        }
                        return v21;
                    }
                    case 2: {
                        return h.j(arr_b, v, o10, g0);
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 22: 
            case 29: 
            case 39: 
            case 43: {
                switch(v4) {
                    case 0: {
                        return h.y(v2, arr_b, v, v1, o10, g0);
                    }
                    case 2: {
                        return h.q(arr_b, v, o10, g0);
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 30: 
            case 44: {
                switch(v4) {
                    case 0: {
                        v23 = h.y(v2, arr_b, v, v1, o10, g0);
                        break;
                    }
                    case 2: {
                        v23 = h.q(arr_b, v, o10, g0);
                        break;
                    }
                    default: {
                        return v;
                    }
                }
                F2.j(object0, v3, o10, this.o(v5), null, this.m);
                return v23;
            }
            case 24: 
            case 0x1F: 
            case 41: 
            case 45: {
                switch(v4) {
                    case 2: {
                        return h.l(arr_b, v, o10, g0);
                    }
                    case 5: {
                        ((D1)o10).d(h.e(v, arr_b));
                        int v19;
                        for(v19 = v + 4; v19 < v1; v19 = v20 + 4) {
                            int v20 = h.x(arr_b, v19, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            ((D1)o10).d(h.e(v20, arr_b));
                        }
                        return v19;
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 23: 
            case 0x20: 
            case 40: 
            case 46: {
                switch(v4) {
                    case 1: {
                        ((c2)o10).d(h.f(v, arr_b));
                        int v17;
                        for(v17 = v + 8; v17 < v1; v17 = v18 + 8) {
                            int v18 = h.x(arr_b, v17, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            ((c2)o10).d(h.f(v18, arr_b));
                        }
                        return v17;
                    }
                    case 2: {
                        return h.m(arr_b, v, o10, g0);
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 33: 
            case 0x2F: {
                switch(v4) {
                    case 0: {
                        int v24 = h.x(arr_b, v, g0);
                        ((D1)o10).d(-(g0.a & 1) ^ g0.a >>> 1);
                        while(v24 < v1) {
                            int v25 = h.x(arr_b, v24, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            v24 = h.x(arr_b, v25, g0);
                            ((D1)o10).d(-(g0.a & 1) ^ g0.a >>> 1);
                        }
                        return v24;
                    }
                    case 2: {
                        return h.o(arr_b, v, o10, g0);
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 34: 
            case 0x30: {
                switch(v4) {
                    case 0: {
                        int v26 = h.z(arr_b, v, g0);
                        ((c2)o10).d(-(g0.b & 1L) ^ g0.b >>> 1);
                        while(v26 < v1) {
                            int v27 = h.x(arr_b, v26, g0);
                            if(v2 != g0.a) {
                                break;
                            }
                            v26 = h.z(arr_b, v27, g0);
                            ((c2)o10).d(-(g0.b & 1L) ^ g0.b >>> 1);
                        }
                        return v26;
                    }
                    case 2: {
                        return h.p(arr_b, v, o10, g0);
                    }
                    default: {
                        return v;
                    }
                }
            }
            case 49: {
                if(v4 == 3) {
                    E2 e20 = this.q(v5);
                    int v39 = v2 & -8 | 4;
                    int v40 = h.g(e20, arr_b, v, v1, v39, g0);
                    o10.add(g0.c);
                    while(v40 < v1) {
                        int v41 = h.x(arr_b, v40, g0);
                        if(v2 != g0.a) {
                            break;
                        }
                        v40 = h.g(e20, arr_b, v41, v1, v39, g0);
                        o10.add(g0.c);
                    }
                    return v40;
                }
                break;
            }
            default: {
                return v;
            }
        }
        return v;
    }

    public final void J(Object object0, long v, w w0, E2 e20, g1 g10) {
        O1 o10 = this.l.a(v, object0);
        t t0 = (t)w0.e;
        int v1 = w0.b;
        if((v1 & 7) != 3) {
            throw R1.d();
        }
        while(true) {
            Object object1 = e20.d();
            w0.n(object1, e20, g10);
            e20.b(object1);
            o10.add(object1);
            if(t0.g() || w0.d != 0) {
                break;
            }
            int v2 = t0.E();
            if(v2 != v1) {
                w0.d = v2;
                return;
            }
        }
    }

    public final void K(Object object0, int v, w w0, E2 e20, g1 g10) {
        O1 o10 = this.l.a(((long)(v & 0xFFFFF)), object0);
        t t0 = (t)w0.e;
        int v1 = w0.b;
        if((v1 & 7) != 2) {
            throw R1.d();
        }
        while(true) {
            Object object1 = e20.d();
            w0.q(object1, e20, g10);
            e20.b(object1);
            o10.add(object1);
            if(t0.g() || w0.d != 0) {
                break;
            }
            int v2 = t0.E();
            if(v2 != v1) {
                w0.d = v2;
                return;
            }
        }
    }

    public final void L(int v, w w0, Object object0) {
        if((0x20000000 & v) != 0) {
            w0.v0(2);
            Y2.p(object0, ((long)(v & 0xFFFFF)), ((t)w0.e).D());
            return;
        }
        if(this.g) {
            w0.v0(2);
            Y2.p(object0, ((long)(v & 0xFFFFF)), ((t)w0.e).C());
            return;
        }
        Y2.p(object0, ((long)(v & 0xFFFFF)), w0.w());
    }

    public final void M(int v, w w0, Object object0) {
        Z1 z10 = this.l;
        if((0x20000000 & v) != 0) {
            w0.m0(z10.a(((long)(v & 0xFFFFF)), object0), true);
            return;
        }
        w0.m0(z10.a(((long)(v & 0xFFFFF)), object0), false);
    }

    public static Field N(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(NoSuchFieldException noSuchFieldException0) {
            Field[] arr_field = class0.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(s.equals(field0.getName())) {
                    return field0;
                }
            }
            StringBuilder stringBuilder0 = a.n("Field ", s, " for ");
            stringBuilder0.append(class0.getName());
            stringBuilder0.append(" not found. Known fields are ");
            stringBuilder0.append(Arrays.toString(arr_field));
            throw new RuntimeException(stringBuilder0.toString(), noSuchFieldException0);
        }
    }

    public final void O(int v, Object object0) {
        int v1 = this.a[v + 2];
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        Y2.n(1 << (v1 >>> 20) | Y2.c.i(object0, ((long)(0xFFFFF & v1))), ((long)(0xFFFFF & v1)), object0);
    }

    public final void P(int v, int v1, Object object0) {
        Y2.n(v, ((long)(this.a[v1 + 2] & 0xFFFFF)), object0);
    }

    public final int Q(int v, int v1) {
        int[] arr_v = this.a;
        int v2 = arr_v.length / 3 - 1;
        while(v1 <= v2) {
            int v3 = v2 + v1 >>> 1;
            int v4 = v3 * 3;
            int v5 = arr_v[v4];
            if(v == v5) {
                return v4;
            }
            if(v < v5) {
                v2 = v3 - 1;
            }
            else {
                v1 = v3 + 1;
            }
        }
        return -1;
    }

    public final void R(int v, Object object0, Object object1) {
        int v1 = this.U(v);
        o2.q.putObject(object0, ((long)(v1 & 0xFFFFF)), object1);
        this.O(v, object0);
    }

    public final void S(int v, Object object0, Object object1, int v1) {
        int v2 = this.U(v1);
        o2.q.putObject(object0, ((long)(v2 & 0xFFFFF)), object1);
        this.P(v, v1, object0);
    }

    public static int T(int v) [...] // Inlined contents

    public final int U(int v) {
        return this.a[v + 1];
    }

    public final void V(Object object0, e2 e20) {
        int v26;
        int v25;
        int v24;
        int v23;
        Map.Entry map$Entry1;
        int v10;
        int v9;
        int v8;
        Iterator iterator1;
        Map.Entry map$Entry0;
        h1 h10 = this.n;
        if(this.f) {
            h10.getClass();
            o1 o10 = ((GeneratedMessageLite.ExtendableMessage)object0).extensions;
            if(o10.a.isEmpty()) {
                map$Entry0 = null;
                iterator1 = null;
            }
            else {
                Iterator iterator0 = o10.k();
                Object object1 = iterator0.next();
                map$Entry0 = (Map.Entry)object1;
                iterator1 = iterator0;
            }
        }
        else {
            map$Entry0 = null;
            iterator1 = null;
        }
        int[] arr_v = this.a;
        Unsafe unsafe0 = o2.q;
        int v = 0;
        int v1 = 0xFFFFF;
        int v2 = 0;
        while(v < arr_v.length) {
            int v3 = this.U(v);
            int v4 = arr_v[v];
            int v5 = (v3 & 0xFF00000) >>> 20;
            if(v5 <= 17) {
                int v6 = arr_v[v + 2];
                int v7 = v6 & 0xFFFFF;
                if(v7 != v1) {
                    v2 = v7 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v7));
                    v1 = v7;
                }
                v8 = 1 << (v6 >>> 20);
                v9 = v1;
                v10 = v2;
                map$Entry1 = map$Entry0;
            }
            else {
                v9 = v1;
                v10 = v2;
                map$Entry1 = map$Entry0;
                v8 = 0;
            }
            while(map$Entry1 != null) {
                h10.getClass();
                if(((x1)map$Entry1.getKey()).a > v4) {
                    break;
                }
                h10.b(e20, map$Entry1);
                if(iterator1.hasNext()) {
                    Object object2 = iterator1.next();
                    map$Entry1 = (Map.Entry)object2;
                }
                else {
                    map$Entry1 = null;
                }
            }
            long v11 = (long)(v3 & 0xFFFFF);
            switch(v5) {
                case 0: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        double f = Y2.c.g(v11, object0);
                        ((x)e20.a).getClass();
                        ((x)e20.a).Z(v4, Double.doubleToRawLongBits(f));
                    }
                    break;
                }
                case 1: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        float f1 = Y2.c.h(v11, object0);
                        ((x)e20.a).getClass();
                        ((x)e20.a).X(v4, Float.floatToRawIntBits(f1));
                    }
                    break;
                }
                case 2: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        long v12 = unsafe0.getLong(object0, v11);
                        ((x)e20.a).m0(v4, v12);
                    }
                    break;
                }
                case 3: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        long v13 = unsafe0.getLong(object0, v11);
                        ((x)e20.a).m0(v4, v13);
                    }
                    break;
                }
                case 4: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        int v14 = unsafe0.getInt(object0, v11);
                        ((x)e20.a).b0(v4, v14);
                    }
                    break;
                }
                case 5: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        long v15 = unsafe0.getLong(object0, v11);
                        ((x)e20.a).Z(v4, v15);
                    }
                    break;
                }
                case 6: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        int v16 = unsafe0.getInt(object0, v11);
                        ((x)e20.a).X(v4, v16);
                    }
                    break;
                }
                case 7: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        boolean z = Y2.c.d(v11, object0);
                        ((x)e20.a).T(v4, z);
                    }
                    break;
                }
                case 8: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        Object object3 = unsafe0.getObject(object0, v11);
                        if(object3 instanceof String) {
                            ((x)e20.a).h0(v4, ((String)object3));
                        }
                        else {
                            ((x)e20.a).V(v4, ((o)object3));
                        }
                    }
                    break;
                }
                case 9: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        Object object4 = unsafe0.getObject(object0, v11);
                        E2 e21 = this.q(v);
                        ((x)e20.a).d0(v4, ((l2)object4), e21);
                    }
                    break;
                }
                case 10: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        o o0 = (o)unsafe0.getObject(object0, v11);
                        ((x)e20.a).V(v4, o0);
                    }
                    break;
                }
                case 11: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        int v17 = unsafe0.getInt(object0, v11);
                        ((x)e20.a).k0(v4, v17);
                    }
                    break;
                }
                case 12: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        int v18 = unsafe0.getInt(object0, v11);
                        ((x)e20.a).b0(v4, v18);
                    }
                    break;
                }
                case 13: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        int v19 = unsafe0.getInt(object0, v11);
                        ((x)e20.a).X(v4, v19);
                    }
                    break;
                }
                case 14: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        long v20 = unsafe0.getLong(object0, v11);
                        ((x)e20.a).Z(v4, v20);
                    }
                    break;
                }
                case 15: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        int v21 = unsafe0.getInt(object0, v11);
                        ((x)e20.a).k0(v4, v21 >> 0x1F ^ v21 << 1);
                    }
                    break;
                }
                case 16: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        long v22 = unsafe0.getLong(object0, v11);
                        ((x)e20.a).m0(v4, v22 << 1 ^ v22 >> 0x3F);
                    }
                    break;
                }
                case 17: {
                    if(this.t(object0, v, v9, v10, v8)) {
                        e20.a(v4, unsafe0.getObject(object0, v11), this.q(v));
                    }
                    break;
                }
                case 18: {
                    v23 = v9;
                    v24 = v10;
                    F2.q(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 19: {
                    v23 = v9;
                    v24 = v10;
                    F2.u(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 20: {
                    v23 = v9;
                    v24 = v10;
                    F2.x(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 21: {
                    v23 = v9;
                    v24 = v10;
                    F2.F(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 22: {
                    v23 = v9;
                    v24 = v10;
                    F2.w(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 23: {
                    v23 = v9;
                    v24 = v10;
                    F2.t(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 24: {
                    v23 = v9;
                    v24 = v10;
                    F2.s(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 25: {
                    v23 = v9;
                    v24 = v10;
                    F2.o(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 26: {
                    v25 = v9;
                    v26 = v10;
                    F2.D(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 27: {
                    v25 = v9;
                    v26 = v10;
                    F2.y(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, this.q(v));
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 28: {
                    v25 = v9;
                    v26 = v10;
                    F2.p(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 29: {
                    v23 = v9;
                    v24 = v10;
                    F2.E(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 30: {
                    v23 = v9;
                    v24 = v10;
                    F2.r(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 0x1F: {
                    v23 = v9;
                    v24 = v10;
                    F2.z(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 0x20: {
                    v23 = v9;
                    v24 = v10;
                    F2.A(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 33: {
                    v23 = v9;
                    v24 = v10;
                    F2.B(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    v9 = v23;
                    v10 = v24;
                    break;
                }
                case 34: {
                    F2.C(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, false);
                    break;
                }
                case 35: {
                    v25 = v9;
                    v26 = v10;
                    F2.q(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 36: {
                    v25 = v9;
                    v26 = v10;
                    F2.u(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 37: {
                    v25 = v9;
                    v26 = v10;
                    F2.x(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 38: {
                    v25 = v9;
                    v26 = v10;
                    F2.F(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 39: {
                    v25 = v9;
                    v26 = v10;
                    F2.w(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 40: {
                    v25 = v9;
                    v26 = v10;
                    F2.t(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 41: {
                    v25 = v9;
                    v26 = v10;
                    F2.s(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 42: {
                    v25 = v9;
                    v26 = v10;
                    F2.o(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 43: {
                    v25 = v9;
                    v26 = v10;
                    F2.E(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 44: {
                    v25 = v9;
                    v26 = v10;
                    F2.r(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 45: {
                    v25 = v9;
                    v26 = v10;
                    F2.z(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 46: {
                    v25 = v9;
                    v26 = v10;
                    F2.A(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 0x2F: {
                    v25 = v9;
                    v26 = v10;
                    F2.B(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 0x30: {
                    v25 = v9;
                    v26 = v10;
                    F2.C(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, true);
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 49: {
                    v25 = v9;
                    v26 = v10;
                    F2.v(arr_v[v], ((List)unsafe0.getObject(object0, v11)), e20, this.q(v));
                    v9 = v25;
                    v10 = v26;
                    break;
                }
                case 50: {
                    Object object5 = unsafe0.getObject(object0, v11);
                    if(object5 != null) {
                        Object object6 = this.p(v);
                        this.o.getClass();
                        s s0 = ((f2)object6).a;
                        x x0 = (x)e20.a;
                        x0.getClass();
                        Iterator iterator2 = ((g2)object5).entrySet().iterator();
                        while(true) {
                            if(!iterator2.hasNext()) {
                                break;
                            }
                            Object object7 = iterator2.next();
                            x0.j0(v4, 2);
                            x0.l0(f2.a(s0, ((Map.Entry)object7).getKey(), ((Map.Entry)object7).getValue()));
                            Object object8 = ((Map.Entry)object7).getKey();
                            Object object9 = ((Map.Entry)object7).getValue();
                            o1.q(x0, ((j3)s0.a), 1, object8);
                            o1.q(x0, ((j3)s0.b), 2, object9);
                        }
                    }
                    break;
                }
                case 51: {
                    if(this.v(v4, v, object0)) {
                        double f2 = (double)(((Double)Y2.c.k(object0, v11)));
                        ((x)e20.a).getClass();
                        ((x)e20.a).Z(v4, Double.doubleToRawLongBits(f2));
                    }
                    break;
                }
                case 52: {
                    if(this.v(v4, v, object0)) {
                        float f3 = (float)(((Float)Y2.c.k(object0, v11)));
                        ((x)e20.a).getClass();
                        ((x)e20.a).X(v4, Float.floatToRawIntBits(f3));
                    }
                    break;
                }
                case 53: {
                    if(this.v(v4, v, object0)) {
                        long v27 = o2.E(v11, object0);
                        ((x)e20.a).m0(v4, v27);
                    }
                    break;
                }
                case 54: {
                    if(this.v(v4, v, object0)) {
                        long v28 = o2.E(v11, object0);
                        ((x)e20.a).m0(v4, v28);
                    }
                    break;
                }
                case 55: {
                    if(this.v(v4, v, object0)) {
                        int v29 = o2.D(v11, object0);
                        ((x)e20.a).b0(v4, v29);
                    }
                    break;
                }
                case 56: {
                    if(this.v(v4, v, object0)) {
                        long v30 = o2.E(v11, object0);
                        ((x)e20.a).Z(v4, v30);
                    }
                    break;
                }
                case 57: {
                    if(this.v(v4, v, object0)) {
                        int v31 = o2.D(v11, object0);
                        ((x)e20.a).X(v4, v31);
                    }
                    break;
                }
                case 58: {
                    if(this.v(v4, v, object0)) {
                        boolean z1 = ((Boolean)Y2.c.k(object0, v11)).booleanValue();
                        ((x)e20.a).T(v4, z1);
                    }
                    break;
                }
                case 59: {
                    if(this.v(v4, v, object0)) {
                        Object object10 = unsafe0.getObject(object0, v11);
                        if(object10 instanceof String) {
                            ((x)e20.a).h0(v4, ((String)object10));
                        }
                        else {
                            ((x)e20.a).V(v4, ((o)object10));
                        }
                    }
                    break;
                }
                case 60: {
                    if(this.v(v4, v, object0)) {
                        Object object11 = unsafe0.getObject(object0, v11);
                        E2 e22 = this.q(v);
                        ((x)e20.a).d0(v4, ((l2)object11), e22);
                    }
                    break;
                }
                case 61: {
                    if(this.v(v4, v, object0)) {
                        o o1 = (o)unsafe0.getObject(object0, v11);
                        ((x)e20.a).V(v4, o1);
                    }
                    break;
                }
                case 62: {
                    if(this.v(v4, v, object0)) {
                        int v32 = o2.D(v11, object0);
                        ((x)e20.a).k0(v4, v32);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.v(v4, v, object0)) {
                        int v33 = o2.D(v11, object0);
                        ((x)e20.a).b0(v4, v33);
                    }
                    break;
                }
                case 0x40: {
                    if(this.v(v4, v, object0)) {
                        int v34 = o2.D(v11, object0);
                        ((x)e20.a).X(v4, v34);
                    }
                    break;
                }
                case 65: {
                    if(this.v(v4, v, object0)) {
                        long v35 = o2.E(v11, object0);
                        ((x)e20.a).Z(v4, v35);
                    }
                    break;
                }
                case 66: {
                    if(this.v(v4, v, object0)) {
                        int v36 = o2.D(v11, object0);
                        ((x)e20.a).k0(v4, v36 >> 0x1F ^ v36 << 1);
                    }
                    break;
                }
                case 67: {
                    if(this.v(v4, v, object0)) {
                        long v37 = o2.E(v11, object0);
                        ((x)e20.a).m0(v4, v37 << 1 ^ v37 >> 0x3F);
                    }
                    break;
                }
                case 68: {
                    if(this.v(v4, v, object0)) {
                        e20.a(v4, unsafe0.getObject(object0, v11), this.q(v));
                    }
                }
            }
            v += 3;
            v2 = v10;
            v1 = v9;
            map$Entry0 = map$Entry1;
        }
        while(map$Entry0 != null) {
            h10.b(e20, map$Entry0);
            if(iterator1.hasNext()) {
                Object object12 = iterator1.next();
                map$Entry0 = (Map.Entry)object12;
            }
            else {
                map$Entry0 = null;
            }
        }
        this.m.getClass();
        ((A1)object0).unknownFields.g(e20);
    }

    @Override  // com.google.protobuf.E2
    public final void a(Object object0, Object object1) {
        o2.l(object0);
        object1.getClass();
        for(int v = 0; true; v += 3) {
            int[] arr_v = this.a;
            if(v >= arr_v.length) {
                break;
            }
            int v1 = this.U(v);
            long v2 = (long)(0xFFFFF & v1);
            int v3 = arr_v[v];
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    if(this.s(v, object1)) {
                        double f = Y2.c.g(v2, object1);
                        Y2.c.o(object0, v2, f);
                        this.O(v, object0);
                    }
                    break;
                }
                case 1: {
                    if(this.s(v, object1)) {
                        float f1 = Y2.c.h(v2, object1);
                        Y2.c.p(object0, v2, f1);
                        this.O(v, object0);
                    }
                    break;
                }
                case 2: {
                    if(this.s(v, object1)) {
                        Y2.o(object0, v2, Y2.c.j(object1, v2));
                        this.O(v, object0);
                    }
                    break;
                }
                case 3: {
                    if(this.s(v, object1)) {
                        Y2.o(object0, v2, Y2.c.j(object1, v2));
                        this.O(v, object0);
                    }
                    break;
                }
                case 4: {
                    if(this.s(v, object1)) {
                        Y2.n(Y2.c.i(object1, v2), v2, object0);
                        this.O(v, object0);
                    }
                    break;
                }
                case 5: {
                    if(this.s(v, object1)) {
                        Y2.o(object0, v2, Y2.c.j(object1, v2));
                        this.O(v, object0);
                    }
                    break;
                }
                case 6: {
                    if(this.s(v, object1)) {
                        Y2.n(Y2.c.i(object1, v2), v2, object0);
                        this.O(v, object0);
                    }
                    break;
                }
                case 7: {
                    if(this.s(v, object1)) {
                        boolean z = Y2.c.d(v2, object1);
                        Y2.c.m(object0, v2, z);
                        this.O(v, object0);
                    }
                    break;
                }
                case 8: {
                    if(this.s(v, object1)) {
                        Y2.p(object0, v2, Y2.c.k(object1, v2));
                        this.O(v, object0);
                    }
                    break;
                }
                case 9: {
                    this.x(v, object0, object1);
                    break;
                }
                case 10: {
                    if(this.s(v, object1)) {
                        Y2.p(object0, v2, Y2.c.k(object1, v2));
                        this.O(v, object0);
                    }
                    break;
                }
                case 11: {
                    if(this.s(v, object1)) {
                        Y2.n(Y2.c.i(object1, v2), v2, object0);
                        this.O(v, object0);
                    }
                    break;
                }
                case 12: {
                    if(this.s(v, object1)) {
                        Y2.n(Y2.c.i(object1, v2), v2, object0);
                        this.O(v, object0);
                    }
                    break;
                }
                case 13: {
                    if(this.s(v, object1)) {
                        Y2.n(Y2.c.i(object1, v2), v2, object0);
                        this.O(v, object0);
                    }
                    break;
                }
                case 14: {
                    if(this.s(v, object1)) {
                        Y2.o(object0, v2, Y2.c.j(object1, v2));
                        this.O(v, object0);
                    }
                    break;
                }
                case 15: {
                    if(this.s(v, object1)) {
                        Y2.n(Y2.c.i(object1, v2), v2, object0);
                        this.O(v, object0);
                    }
                    break;
                }
                case 16: {
                    if(this.s(v, object1)) {
                        Y2.o(object0, v2, Y2.c.j(object1, v2));
                        this.O(v, object0);
                    }
                    break;
                }
                case 17: {
                    this.x(v, object0, object1);
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    this.l.getClass();
                    O1 o10 = (O1)Y2.c.k(object0, v2);
                    O1 o11 = (O1)Y2.c.k(object1, v2);
                    int v4 = o10.size();
                    int v5 = o11.size();
                    if(v4 > 0 && v5 > 0) {
                        if(!((c)o10).a) {
                            o10 = o10.n(v5 + v4);
                        }
                        o10.addAll(o11);
                    }
                    if(v4 > 0) {
                        o11 = o10;
                    }
                    Y2.p(object0, v2, o11);
                    break;
                }
                case 50: {
                    Object object2 = Y2.c.k(object0, v2);
                    Object object3 = Y2.c.k(object1, v2);
                    Y2.p(object0, v2, this.o.a(object2, object3));
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: {
                    if(this.v(v3, v, object1)) {
                        Y2.p(object0, v2, Y2.c.k(object1, v2));
                        this.P(v3, v, object0);
                    }
                    break;
                }
                case 60: {
                    this.y(v, object0, object1);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.v(v3, v, object1)) {
                        Y2.p(object0, v2, Y2.c.k(object1, v2));
                        this.P(v3, v, object0);
                    }
                    break;
                }
                case 68: {
                    this.y(v, object0, object1);
                }
            }
        }
        F2.l(this.m, object0, object1);
        if(this.f) {
            this.n.getClass();
            o1 o12 = ((GeneratedMessageLite.ExtendableMessage)object1).extensions;
            if(!o12.a.isEmpty()) {
                ((GeneratedMessageLite.ExtendableMessage)object0).ensureExtensionsAreMutable().m(o12);
            }
        }
    }

    @Override  // com.google.protobuf.E2
    public final void b(Object object0) {
        if(o2.u(object0)) {
            if(object0 instanceof A1) {
                ((A1)object0).clearMemoizedSerializedSize();
                ((A1)object0).clearMemoizedHashCode();
                ((A1)object0).markImmutable();
            }
            int[] arr_v = this.a;
            for(int v = 0; v < arr_v.length; v += 3) {
                int v1 = this.U(v);
                long v2 = (long)(0xFFFFF & v1);
                switch((v1 & 0xFF00000) >>> 20) {
                    case 9: 
                    case 17: {
                        if(this.s(v, object0)) {
                            this.q(v).b(o2.q.getObject(object0, v2));
                        }
                        break;
                    }
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 29: 
                    case 30: 
                    case 0x1F: 
                    case 0x20: 
                    case 33: 
                    case 34: 
                    case 35: 
                    case 36: 
                    case 37: 
                    case 38: 
                    case 39: 
                    case 40: 
                    case 41: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 0x2F: 
                    case 0x30: 
                    case 49: {
                        this.l.getClass();
                        c c0 = (c)(((O1)Y2.c.k(object0, v2)));
                        if(c0.a) {
                            c0.a = false;
                        }
                        break;
                    }
                    case 50: {
                        Unsafe unsafe0 = o2.q;
                        Object object1 = unsafe0.getObject(object0, v2);
                        if(object1 != null) {
                            this.o.getClass();
                            ((g2)object1).a = false;
                            unsafe0.putObject(object0, v2, object1);
                        }
                        break;
                    }
                    case 60: 
                    case 68: {
                        if(this.v(arr_v[v], v, object0)) {
                            this.q(v).b(o2.q.getObject(object0, v2));
                        }
                    }
                }
            }
            this.m.getClass();
            S2 s20 = ((A1)object0).unknownFields;
            if(s20.e) {
                s20.e = false;
            }
            if(this.f) {
                this.n.getClass();
                ((GeneratedMessageLite.ExtendableMessage)object0).extensions.l();
            }
        }
    }

    @Override  // com.google.protobuf.E2
    public final boolean c(Object object0) {
        int v11;
        int v10;
        int v9;
        int v = 0xFFFFF;
        int v1 = 0;
        int v2 = 0;
        while(v2 < this.i) {
            int v3 = this.h[v2];
            int v4 = this.a[v3];
            int v5 = this.U(v3);
            int v6 = this.a[v3 + 2];
            int v7 = v6 & 0xFFFFF;
            int v8 = 1 << (v6 >>> 20);
            if(v7 == v) {
                v11 = v;
                v9 = v3;
                v10 = v1;
            }
            else {
                if(v7 != 0xFFFFF) {
                    v1 = o2.q.getInt(object0, ((long)v7));
                }
                v9 = v3;
                v10 = v1;
                v11 = v7;
            }
            if((0x10000000 & v5) == 0 || this.t(object0, v9, v11, v10, v8)) {
                switch((v5 & 0xFF00000) >>> 20) {
                    case 9: 
                    case 17: {
                        if(!this.t(object0, v9, v11, v10, v8) || this.q(v9).c(Y2.c.k(object0, ((long)(v5 & 0xFFFFF))))) {
                            break;
                        }
                        return false;
                    }
                    case 27: 
                    case 49: {
                        List list0 = (List)Y2.c.k(object0, ((long)(v5 & 0xFFFFF)));
                        if(!list0.isEmpty()) {
                            E2 e21 = this.q(v9);
                            for(int v12 = 0; v12 < list0.size(); ++v12) {
                                if(!e21.c(list0.get(v12))) {
                                    return false;
                                }
                            }
                        }
                        break;
                    }
                    case 50: {
                        Object object1 = Y2.c.k(object0, ((long)(v5 & 0xFFFFF)));
                        this.o.getClass();
                        g2 g20 = (g2)object1;
                        if(!g20.isEmpty() && ((j3)((f2)this.p(v9)).a.b).a == k3.j) {
                            E2 e20 = null;
                            Iterator iterator0 = g20.values().iterator();
                            while(true) {
                                if(!iterator0.hasNext()) {
                                    break;
                                }
                                Object object2 = iterator0.next();
                                if(e20 == null) {
                                    Class class0 = object2.getClass();
                                    e20 = B2.c.a(class0);
                                }
                                if(e20.c(object2)) {
                                    continue;
                                }
                                return false;
                            }
                        }
                        break;
                    }
                    case 60: 
                    case 68: {
                        if(this.v(v4, v9, object0) && !this.q(v9).c(Y2.c.k(object0, ((long)(v5 & 0xFFFFF))))) {
                            return false;
                        }
                    }
                }
                ++v2;
                v = v11;
                v1 = v10;
                continue;
            }
            return false;
        }
        if(this.f) {
            this.n.getClass();
            return ((GeneratedMessageLite.ExtendableMessage)object0).extensions.i();
        }
        return true;
    }

    @Override  // com.google.protobuf.E2
    public final Object d() {
        this.k.getClass();
        return ((A1)this.e).newMutableInstance();
    }

    @Override  // com.google.protobuf.E2
    public final void e(Object object0, e2 e20) {
        e20.getClass();
        this.V(object0, e20);
    }

    @Override  // com.google.protobuf.E2
    public final void f(Object object0, w w0, g1 g10) {
        S2 s23;
        y1 y10;
        T2 t21;
        Object object2;
        E2 e22;
        I1 i12;
        O1 o13;
        S2 s24;
        T2 t23;
        I1 i11;
        O1 o12;
        t t0;
        int v6;
        T2 t22;
        Object object3;
        double f;
        o1 o11;
        Z1 z10;
        int v5;
        int v4;
        S2 s21;
        Object object1;
        int v3;
        int v2;
        g10.getClass();
        o2.l(object0);
        T2 t20 = this.m;
        int[] arr_v = this.h;
        int v = this.j;
        int v1 = this.i;
        S2 s20 = null;
        o1 o10 = null;
        while(true) {
            try {
            label_8:
                v2 = w0.h();
            }
            catch(Throwable throwable0) {
                object1 = object0;
                v4 = v1;
                goto label_604;
            }
            try {
                v3 = v2 < this.c || v2 > this.d ? -1 : this.Q(v2, 0);
            }
            catch(Throwable throwable0) {
                object1 = object0;
                s21 = s20;
                v4 = v1;
                goto label_603;
            }
            if(v3 >= 0) {
                try {
                    object2 = object0;
                    t21 = t20;
                    s21 = s20;
                    v5 = this.U(v3);
                    z10 = this.l;
                    switch((v5 & 0xFF00000) >>> 20) {
                        case 0: {
                            goto label_111;
                        }
                        case 1: {
                            goto label_122;
                        }
                        case 2: {
                            goto label_130;
                        }
                        case 3: {
                            goto label_137;
                        }
                        case 4: {
                            goto label_144;
                        }
                        case 5: {
                            goto label_151;
                        }
                        case 6: {
                            goto label_158;
                        }
                        case 7: {
                            goto label_165;
                        }
                        case 8: {
                            goto label_173;
                        }
                        case 9: {
                            goto label_179;
                        }
                        case 10: {
                            goto label_188;
                        }
                        case 11: {
                            goto label_194;
                        }
                        case 12: {
                            goto label_201;
                        }
                        case 13: {
                            goto label_223;
                        }
                        case 14: {
                            goto label_230;
                        }
                        case 15: {
                            goto label_237;
                        }
                        case 16: {
                            goto label_245;
                        }
                        case 17: {
                            goto label_264;
                        }
                        case 18: {
                            goto label_272;
                        }
                        case 19: {
                            goto label_276;
                        }
                        case 20: {
                            goto label_280;
                        }
                        case 21: {
                            goto label_284;
                        }
                        case 22: {
                            goto label_288;
                        }
                        case 23: {
                            goto label_292;
                        }
                        case 24: {
                            goto label_296;
                        }
                        case 25: {
                            goto label_300;
                        }
                        case 26: {
                            goto label_304;
                        }
                        case 27: {
                            goto label_308;
                        }
                        case 28: {
                            goto label_312;
                        }
                        case 29: {
                            goto label_316;
                        }
                        case 30: {
                            goto label_320;
                        }
                        case 0x1F: {
                            goto label_337;
                        }
                        case 0x20: {
                            goto label_342;
                        }
                        case 33: {
                            goto label_347;
                        }
                        case 34: {
                            goto label_352;
                        }
                        case 35: {
                            goto label_357;
                        }
                        case 36: {
                            goto label_362;
                        }
                        case 37: {
                            goto label_367;
                        }
                        case 38: {
                            goto label_372;
                        }
                        case 39: {
                            goto label_377;
                        }
                        case 40: {
                            goto label_382;
                        }
                        case 41: {
                            goto label_387;
                        }
                        case 42: {
                            goto label_392;
                        }
                        case 43: {
                            goto label_398;
                        }
                        case 44: {
                            goto label_408;
                        }
                        case 45: {
                            goto label_429;
                        }
                        case 46: {
                            goto label_433;
                        }
                        case 0x2F: {
                            goto label_437;
                        }
                        case 0x30: {
                            goto label_441;
                        }
                        case 49: {
                            goto label_451;
                        }
                        case 50: {
                            goto label_459;
                        }
                        case 51: {
                            goto label_471;
                        }
                        case 52: {
                            goto label_476;
                        }
                        case 53: {
                            goto label_481;
                        }
                        case 54: {
                            goto label_486;
                        }
                        case 55: {
                            goto label_491;
                        }
                        case 56: {
                            goto label_496;
                        }
                        case 57: {
                            goto label_501;
                        }
                        case 58: {
                            goto label_506;
                        }
                        case 59: {
                            goto label_511;
                        }
                        case 60: {
                            goto label_515;
                        }
                        case 61: {
                            goto label_522;
                        }
                        case 62: {
                            goto label_526;
                        }
                        case 0x3F: {
                            goto label_531;
                        }
                        case 0x40: {
                            goto label_542;
                        }
                        case 65: {
                            goto label_547;
                        }
                        case 66: {
                            goto label_552;
                        }
                        case 67: {
                            goto label_557;
                        }
                        case 68: {
                            goto label_570;
                        }
                    }
                }
                catch(Throwable throwable0) {
                    goto label_600;
                }
                if(s21 == null) {
                    try {
                        s20 = t21.a(object2);
                    }
                    catch(Q1 unused_ex) {
                        goto label_578;
                    }
                    catch(Throwable throwable0) {
                        goto label_600;
                    }
                }
                else {
                    s20 = s21;
                }
                try {
                    if(t21.b(0, w0, s20)) {
                        v4 = v1;
                        o11 = o10;
                        goto label_614;
                    }
                    else {
                        goto label_100;
                    }
                    return;
                }
                catch(Q1 unused_ex) {
                    object1 = object2;
                    v4 = v1;
                    o11 = o10;
                    goto label_582;
                }
                catch(Throwable throwable0) {
                    object1 = object2;
                    v4 = v1;
                    t20 = t21;
                    goto label_604;
                }
            label_100:
                s23 = s20;
                while(v1 < v) {
                    s23 = this.n(object2, arr_v[v1], s23, t21, object0);
                    ++v1;
                }
                if(s23 != null) {
                    t21.c(object2, s23);
                    return;
                    try {
                    label_111:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(1);
                        f = ((t)w0.e).n();
                        object3 = object1;
                    }
                    catch(Q1 unused_ex) {
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        goto label_602;
                    }
                    try {
                        object1 = object3;
                        Y2.c.o(object3, ((long)(v5 & 0xFFFFF)), f);
                        object1 = object3;
                    }
                    catch(Q1 unused_ex) {
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        object1 = object3;
                        goto label_602;
                    }
                    try {
                        this.O(v3, object1);
                        goto label_613;
                    label_122:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(5);
                        float f1 = ((t)w0.e).r();
                        Y2.c.p(object1, ((long)(v5 & 0xFFFFF)), f1);
                        this.O(v3, object1);
                        goto label_613;
                    label_130:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(0);
                        Y2.o(object1, ((long)(v5 & 0xFFFFF)), ((t)w0.e).u());
                        this.O(v3, object1);
                        goto label_613;
                    label_137:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(0);
                        Y2.o(object1, ((long)(v5 & 0xFFFFF)), ((t)w0.e).G());
                        this.O(v3, object1);
                        goto label_613;
                    label_144:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(0);
                        Y2.n(((t)w0.e).t(), ((long)(v5 & 0xFFFFF)), object1);
                        this.O(v3, object1);
                        goto label_613;
                    label_151:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(1);
                        Y2.o(object1, ((long)(v5 & 0xFFFFF)), ((t)w0.e).q());
                        this.O(v3, object1);
                        goto label_613;
                    label_158:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(5);
                        Y2.n(((t)w0.e).p(), ((long)(v5 & 0xFFFFF)), object1);
                        this.O(v3, object1);
                        goto label_613;
                    label_165:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(0);
                        boolean z = ((t)w0.e).l();
                        Y2.c.m(object1, ((long)(v5 & 0xFFFFF)), z);
                        this.O(v3, object1);
                        goto label_613;
                    label_173:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        this.L(v5, w0, object1);
                        this.O(v3, object1);
                        goto label_613;
                    label_179:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        l2 l20 = (l2)this.z(v3, object1);
                        E2 e20 = this.q(v3);
                        w0.v0(2);
                        w0.q(l20, e20, g10);
                        this.R(v3, object1, l20);
                        goto label_613;
                    label_188:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        Y2.p(object1, ((long)(v5 & 0xFFFFF)), w0.w());
                        this.O(v3, object1);
                        goto label_613;
                    label_194:
                        object1 = object2;
                        v4 = v1;
                        o11 = o10;
                        w0.v0(0);
                        Y2.n(((t)w0.e).F(), ((long)(v5 & 0xFFFFF)), object1);
                        this.O(v3, object1);
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        goto label_602;
                    }
                    try {
                    label_201:
                        object1 = object2;
                        v4 = v1;
                        t22 = t21;
                        w0.v0(0);
                        v6 = ((t)w0.e).o();
                        goto label_209;
                    }
                    catch(Q1 unused_ex) {
                        try {
                            t21 = t22;
                            o11 = o10;
                            s20 = s21;
                            goto label_582;
                        }
                        catch(Q1 unused_ex) {
                            s20 = s21;
                            goto label_582;
                        }
                        catch(Throwable throwable0) {
                            goto label_602;
                        }
                        try {
                        label_209:
                            I1 i10 = this.o(v3);
                            if(i10 != null && !i10.a(v6)) {
                                t21 = t22;
                                s20 = F2.n(object1, v2, v6, s21, t21);
                                o11 = o10;
                                goto label_614;
                            }
                            else {
                                goto label_215;
                            }
                            goto label_223;
                        }
                        catch(Q1 unused_ex) {
                            t21 = t22;
                            o11 = o10;
                            s20 = s21;
                            goto label_582;
                        }
                        catch(Throwable throwable0) {
                            t21 = t22;
                            goto label_602;
                        }
                    }
                    catch(Throwable throwable0) {
                        t21 = t22;
                        goto label_602;
                    }
                    try {
                        try {
                        label_215:
                            t21 = t22;
                            o11 = o10;
                            Y2.n(v6, ((long)(v5 & 0xFFFFF)), object1);
                            this.O(v3, object1);
                            goto label_613;
                        }
                        catch(Q1 unused_ex) {
                            s20 = s21;
                            goto label_582;
                        }
                        try {
                            t21 = t22;
                            s20 = F2.n(object1, v2, v6, s21, t21);
                            o11 = o10;
                            goto label_614;
                        }
                        catch(Q1 unused_ex) {
                            o11 = o10;
                            s20 = s21;
                            goto label_582;
                        }
                    }
                    catch(Throwable throwable0) {
                        goto label_602;
                    }
                    try {
                    label_223:
                        object1 = object2;
                        v4 = v1;
                        t22 = t21;
                        w0.v0(5);
                        Y2.n(((t)w0.e).y(), ((long)(v5 & 0xFFFFF)), object1);
                        this.O(v3, object1);
                        t21 = t22;
                        o11 = o10;
                        goto label_613;
                    label_230:
                        object1 = object2;
                        v4 = v1;
                        t22 = t21;
                        w0.v0(1);
                        Y2.o(object1, ((long)(v5 & 0xFFFFF)), ((t)w0.e).z());
                        this.O(v3, object1);
                        t21 = t22;
                        o11 = o10;
                        goto label_613;
                    label_237:
                        object1 = object2;
                        v4 = v1;
                        t22 = t21;
                        w0.v0(0);
                        Y2.n(((t)w0.e).A(), ((long)(v5 & 0xFFFFF)), object1);
                        this.O(v3, object1);
                        t21 = t22;
                        o11 = o10;
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                        t21 = t22;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        t20 = t22;
                        goto label_603;
                    }
                    try {
                    label_245:
                        object1 = object2;
                        v4 = v1;
                        w0.v0(0);
                        t22 = t21;
                        t0 = (t)w0.e;
                        t22 = t21;
                        goto label_255;
                    }
                    catch(Q1 unused_ex) {
                        t21 = t22;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                    }
                    try {
                        t22 = t21;
                        t20 = t22;
                        goto label_603;
                    label_255:
                        Y2.o(object1, ((long)(v5 & 0xFFFFF)), t0.B());
                        this.O(v3, object1);
                        t21 = t22;
                        o11 = o10;
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                        t21 = t22;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        t20 = t22;
                        goto label_603;
                    }
                    try {
                    label_264:
                        object1 = object2;
                        v4 = v1;
                        l2 l21 = (l2)this.z(v3, object1);
                        E2 e21 = this.q(v3);
                        w0.v0(3);
                        w0.n(l21, e21, g10);
                        this.R(v3, object1, l21);
                        o11 = o10;
                        goto label_613;
                    label_272:
                        object1 = object2;
                        v4 = v1;
                        w0.C(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_276:
                        object1 = object2;
                        v4 = v1;
                        w0.Q(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_280:
                        object1 = object2;
                        v4 = v1;
                        w0.W(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_284:
                        object1 = object2;
                        v4 = v1;
                        w0.s0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_288:
                        object1 = object2;
                        v4 = v1;
                        w0.T(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_292:
                        object1 = object2;
                        v4 = v1;
                        w0.N(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_296:
                        object1 = object2;
                        v4 = v1;
                        w0.K(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_300:
                        object1 = object2;
                        v4 = v1;
                        w0.t(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_304:
                        object1 = object2;
                        v4 = v1;
                        this.M(v5, w0, object1);
                        o11 = o10;
                        goto label_613;
                    label_308:
                        object1 = object2;
                        v4 = v1;
                        this.K(object1, v5, w0, this.q(v3), g10);
                        o11 = o10;
                        goto label_613;
                    label_312:
                        object1 = object2;
                        v4 = v1;
                        w0.z(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    label_316:
                        object1 = object2;
                        v4 = v1;
                        w0.p0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        o11 = o10;
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        goto label_602;
                    }
                    try {
                    label_320:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        o12 = z10.a(((long)(v5 & 0xFFFFF)), object1);
                        w0.F(o12);
                        i11 = this.o(v3);
                        object3 = object1;
                        t23 = t20;
                        s24 = s21;
                    }
                    catch(Q1 unused_ex) {
                        t21 = t20;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        goto label_603;
                    }
                    try {
                        t21 = t23;
                        s20 = F2.j(object3, v2, o12, i11, s24, t23);
                        o11 = o10;
                        goto label_614;
                    }
                    catch(Q1 unused_ex) {
                        goto label_418;
                    }
                    catch(Throwable throwable0) {
                    }
                    object1 = object3;
                    s21 = s24;
                    t21 = t23;
                    goto label_602;
                    try {
                    label_337:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.a0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_342:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.d0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_347:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.g0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_352:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.j0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_357:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.C(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_362:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.Q(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_367:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.W(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_372:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.s0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_377:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.T(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_382:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.N(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_387:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.K(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_392:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.t(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    label_398:
                        object1 = object2;
                        v4 = v1;
                        t20 = t21;
                        w0.p0(z10.a(((long)(v5 & 0xFFFFF)), object1));
                        t21 = t20;
                        o11 = o10;
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                        t21 = t20;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        goto label_603;
                    }
                    try {
                    label_408:
                        object3 = object2;
                        v4 = v1;
                        o13 = z10.a(((long)(v5 & 0xFFFFF)), object3);
                        w0.F(o13);
                        i12 = this.o(v3);
                        t23 = t21;
                        s24 = s21;
                    }
                    catch(Q1 unused_ex) {
                        object1 = object3;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        object1 = object3;
                        goto label_602;
                    }
                    try {
                        s20 = F2.j(object3, v2, o13, i12, s24, t23);
                        t21 = t23;
                    }
                    catch(Q1 unused_ex) {
                    label_418:
                        s21 = s24;
                        object1 = object3;
                        t21 = t23;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        object1 = object3;
                        s21 = s24;
                        t20 = t23;
                        goto label_603;
                    }
                    o11 = o10;
                    goto label_614;
                    try {
                    label_429:
                        object3 = object2;
                        v4 = v1;
                        w0.a0(z10.a(((long)(v5 & 0xFFFFF)), object3));
                        o11 = o10;
                        goto label_613;
                    label_433:
                        object3 = object2;
                        v4 = v1;
                        w0.d0(z10.a(((long)(v5 & 0xFFFFF)), object3));
                        o11 = o10;
                        goto label_613;
                    label_437:
                        object3 = object2;
                        v4 = v1;
                        w0.g0(z10.a(((long)(v5 & 0xFFFFF)), object3));
                        o11 = o10;
                        goto label_613;
                    label_441:
                        object3 = object2;
                        v4 = v1;
                        w0.j0(z10.a(((long)(v5 & 0xFFFFF)), object3));
                        o11 = o10;
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                        object1 = object3;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                    }
                    object1 = object3;
                    goto label_602;
                    try {
                        try {
                        label_451:
                            v4 = v1;
                            object1 = object0;
                            e22 = this.q(v3);
                            object1 = object0;
                        }
                        catch(Q1 unused_ex) {
                            object1 = object0;
                            o11 = o10;
                            s20 = s21;
                            goto label_582;
                        }
                        try {
                            this.J(object1, ((long)(v5 & 0xFFFFF)), w0, e22, g10);
                            o11 = o10;
                            goto label_613;
                        }
                        catch(Q1 unused_ex) {
                            o11 = o10;
                            s20 = s21;
                            goto label_582;
                        }
                    }
                    catch(Throwable throwable0) {
                        goto label_602;
                    }
                    try {
                    label_459:
                        v4 = v1;
                        this.w(object2, v3, this.p(v3), g10, w0);
                    }
                    catch(Q1 unused_ex) {
                        object1 = object0;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        object1 = object0;
                        goto label_602;
                    }
                    o11 = o10;
                    goto label_613;
                    try {
                    label_471:
                        v4 = v1;
                        w0.v0(1);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).n());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_476:
                        v4 = v1;
                        w0.v0(5);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).r());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_481:
                        v4 = v1;
                        w0.v0(0);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).u());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_486:
                        v4 = v1;
                        w0.v0(0);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).G());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_491:
                        v4 = v1;
                        w0.v0(0);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).t());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_496:
                        v4 = v1;
                        w0.v0(1);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).q());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_501:
                        v4 = v1;
                        w0.v0(5);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).p());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_506:
                        v4 = v1;
                        w0.v0(0);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), Boolean.valueOf(((t)w0.e).l()));
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_511:
                        v4 = v1;
                        this.L(v5, w0, object2);
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_515:
                        v4 = v1;
                        l2 l22 = (l2)this.A(v2, v3, object2);
                        E2 e23 = this.q(v3);
                        w0.v0(2);
                        w0.q(l22, e23, g10);
                        this.S(v2, object2, l22, v3);
                        o11 = o10;
                        goto label_613;
                    label_522:
                        v4 = v1;
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), w0.w());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_526:
                        v4 = v1;
                        w0.v0(0);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).F());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_531:
                        v4 = v1;
                        w0.v0(0);
                        int v7 = ((t)w0.e).o();
                        I1 i13 = this.o(v3);
                        if(i13 == null || i13.a(v7)) {
                            Y2.p(object2, ((long)(v5 & 0xFFFFF)), v7);
                            this.P(v2, v3, object2);
                            o11 = o10;
                            goto label_613;
                        }
                        else {
                            s20 = F2.n(object2, v2, v7, s21, t21);
                            o11 = o10;
                            goto label_614;
                        }
                    label_542:
                        v4 = v1;
                        w0.v0(5);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).y());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_547:
                        v4 = v1;
                        w0.v0(1);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).z());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_552:
                        v4 = v1;
                        w0.v0(0);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).A());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    label_557:
                        v4 = v1;
                        w0.v0(0);
                        Y2.p(object2, ((long)(v5 & 0xFFFFF)), ((t)w0.e).B());
                        this.P(v2, v3, object2);
                        o11 = o10;
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                        object1 = object2;
                        o11 = o10;
                        s20 = s21;
                        goto label_582;
                    }
                    catch(Throwable throwable0) {
                        object1 = object2;
                        goto label_602;
                    }
                    try {
                    label_570:
                        l2 l23 = (l2)this.A(v2, v3, object2);
                        E2 e24 = this.q(v3);
                        w0.v0(3);
                        w0.n(l23, e24, g10);
                        this.S(v2, object2, l23, v3);
                        v4 = v1;
                        o11 = o10;
                        goto label_613;
                    }
                    catch(Q1 unused_ex) {
                    }
                    catch(Throwable throwable0) {
                        goto label_600;
                    }
                label_578:
                    object1 = object2;
                    v4 = v1;
                    o11 = o10;
                    s20 = s21;
                    try {
                    label_582:
                        t21.getClass();
                        if(s20 == null) {
                            s20 = t21.a(object1);
                        }
                        if(t21.b(0, w0, s20)) {
                            goto label_614;
                        }
                        else {
                            goto label_590;
                        }
                        return;
                    }
                    catch(Throwable throwable0) {
                    }
                    t20 = t21;
                    goto label_604;
                label_590:
                    S2 s25 = s20;
                    for(int v8 = v4; v8 < v; ++v8) {
                        s25 = this.n(object1, arr_v[v8], s25, t21, object0);
                    }
                    if(s25 != null) {
                        t21.c(object1, s25);
                    }
                }
            }
            else if(v2 == 0x7FFFFFFF) {
                S2 s22 = s20;
                while(v1 < v) {
                    s22 = this.n(object0, arr_v[v1], s22, t20, object0);
                    ++v1;
                }
                if(s22 != null) {
                    t20.c(object0, s22);
                    return;
                }
            }
            else {
                h1 h10 = this.n;
                if(this.f) {
                    try {
                        h10.getClass();
                        y10 = g10.a(v2, this.e);
                    }
                    catch(Throwable throwable0) {
                        object2 = object0;
                        s21 = s20;
                        t21 = t20;
                        goto label_600;
                    }
                }
                else {
                    y10 = null;
                }
                if(y10 == null) {
                    try {
                        object1 = object0;
                        s21 = s20;
                        t20.getClass();
                    }
                    catch(Throwable throwable0) {
                        t21 = t20;
                        goto label_601;
                    }
                    if(s21 == null) {
                        try {
                            s20 = t20.a(object1);
                        }
                        catch(Throwable throwable0) {
                            v4 = v1;
                            goto label_603;
                        }
                    }
                    else {
                        s20 = s21;
                    }
                    try {
                        if(t20.b(0, w0, s20)) {
                            goto label_8;
                        }
                    }
                    catch(Throwable throwable0) {
                        t21 = t20;
                        v4 = v1;
                        t20 = t21;
                        goto label_604;
                    }
                    s23 = s20;
                    while(v1 < v) {
                        s23 = this.n(object1, arr_v[v1], s23, t20, object0);
                        ++v1;
                    }
                    t21 = t20;
                    object2 = object1;
                    if(s23 != null) {
                        t21.c(object2, s23);
                        return;
                    }
                }
                else {
                    if(o10 == null) {
                        try {
                            h10.getClass();
                            o10 = ((GeneratedMessageLite.ExtendableMessage)object0).ensureExtensionsAreMutable();
                            s20 = h10.a(object0, w0, y10, g10, o10, s20, t20);
                            goto label_8;
                        }
                        catch(Throwable throwable0) {
                        }
                    }
                    else {
                        s20 = h10.a(object0, w0, y10, g10, o10, s20, t20);
                        goto label_8;
                    }
                    object1 = object0;
                    v4 = v1;
                    goto label_604;
                }
            }
            return;
        label_600:
            object1 = object2;
        label_601:
            v4 = v1;
        label_602:
            t20 = t21;
        label_603:
            s20 = s21;
        label_604:
            S2 s26 = s20;
            for(int v9 = v4; v9 < v; ++v9) {
                s26 = this.n(object1, arr_v[v9], s26, t20, object0);
            }
            if(s26 != null) {
                t20.c(object1, s26);
            }
            throw throwable0;
        label_613:
            s20 = s21;
        label_614:
            t20 = t21;
            o10 = o11;
            v1 = v4;
        }
    }

    @Override  // com.google.protobuf.E2
    public final void g(Object object0, byte[] arr_b, int v, int v1, g g0) {
        this.G(object0, arr_b, v, v1, 0, g0);
    }

    @Override  // com.google.protobuf.E2
    public final int h(A1 a10) {
        int v8;
        int v7;
        int[] arr_v = this.a;
        int v1 = 0;
        for(int v = 0; v < arr_v.length; v += 3) {
            int v2 = this.U(v);
            int v3 = arr_v[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 0x4D5;
            int v6 = 37;
            switch((v2 & 0xFF00000) >>> 20) {
                case 0: {
                    v7 = v1 * 53;
                    v8 = P1.b(Double.doubleToLongBits(Y2.c.g(v4, a10)));
                    v1 = v8 + v7;
                    break;
                }
                case 1: {
                    v7 = v1 * 53;
                    v8 = Float.floatToIntBits(Y2.c.h(v4, a10));
                    v1 = v8 + v7;
                    break;
                }
                case 2: {
                    v7 = v1 * 53;
                    v8 = P1.b(Y2.c.j(a10, v4));
                    v1 = v8 + v7;
                    break;
                }
                case 3: {
                    v7 = v1 * 53;
                    v8 = P1.b(Y2.c.j(a10, v4));
                    v1 = v8 + v7;
                    break;
                }
                case 4: {
                    v7 = v1 * 53;
                    v8 = Y2.c.i(a10, v4);
                    v1 = v8 + v7;
                    break;
                }
                case 5: {
                    v7 = v1 * 53;
                    v8 = P1.b(Y2.c.j(a10, v4));
                    v1 = v8 + v7;
                    break;
                }
                case 6: {
                    v1 = Y2.c.i(a10, v4) + v1 * 53;
                    break;
                }
                case 7: {
                    if(Y2.c.d(v4, a10)) {
                        v5 = 0x4CF;
                    }
                    v1 = v5 + v1 * 53;
                    break;
                }
                case 8: {
                    v1 = ((String)Y2.c.k(a10, v4)).hashCode() + v1 * 53;
                    break;
                }
                case 9: {
                    Object object0 = Y2.c.k(a10, v4);
                    if(object0 != null) {
                        v6 = object0.hashCode();
                    }
                    v1 = v1 * 53 + v6;
                    break;
                }
                case 10: {
                    v1 = Y2.c.k(a10, v4).hashCode() + v1 * 53;
                    break;
                }
                case 11: {
                    v1 = Y2.c.i(a10, v4) + v1 * 53;
                    break;
                }
                case 12: {
                    v1 = Y2.c.i(a10, v4) + v1 * 53;
                    break;
                }
                case 13: {
                    v1 = Y2.c.i(a10, v4) + v1 * 53;
                    break;
                }
                case 14: {
                    v1 = P1.b(Y2.c.j(a10, v4)) + v1 * 53;
                    break;
                }
                case 15: {
                    v1 = Y2.c.i(a10, v4) + v1 * 53;
                    break;
                }
                case 16: {
                    v1 = P1.b(Y2.c.j(a10, v4)) + v1 * 53;
                    break;
                }
                case 17: {
                    Object object1 = Y2.c.k(a10, v4);
                    if(object1 != null) {
                        v6 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v6;
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    v1 = Y2.c.k(a10, v4).hashCode() + v1 * 53;
                    break;
                }
                case 50: {
                    v1 = Y2.c.k(a10, v4).hashCode() + v1 * 53;
                    break;
                }
                case 51: {
                    if(this.v(v3, v, a10)) {
                        v1 = P1.b(Double.doubleToLongBits(((double)(((Double)Y2.c.k(a10, v4)))))) + v1 * 53;
                    }
                    break;
                }
                case 52: {
                    if(this.v(v3, v, a10)) {
                        v1 = Float.floatToIntBits(((float)(((Float)Y2.c.k(a10, v4))))) + v1 * 53;
                    }
                    break;
                }
                case 53: {
                    if(this.v(v3, v, a10)) {
                        v1 = P1.b(o2.E(v4, a10)) + v1 * 53;
                    }
                    break;
                }
                case 54: {
                    if(this.v(v3, v, a10)) {
                        v1 = P1.b(o2.E(v4, a10)) + v1 * 53;
                    }
                    break;
                }
                case 55: {
                    if(this.v(v3, v, a10)) {
                        v1 = o2.D(v4, a10) + v1 * 53;
                    }
                    break;
                }
                case 56: {
                    if(this.v(v3, v, a10)) {
                        v1 = P1.b(o2.E(v4, a10)) + v1 * 53;
                    }
                    break;
                }
                case 57: {
                    if(this.v(v3, v, a10)) {
                        v1 = o2.D(v4, a10) + v1 * 53;
                    }
                    break;
                }
                case 58: {
                    if(this.v(v3, v, a10)) {
                        if(((Boolean)Y2.c.k(a10, v4)).booleanValue()) {
                            v5 = 0x4CF;
                        }
                        v1 = v5 + v1 * 53;
                    }
                    break;
                }
                case 59: {
                    if(this.v(v3, v, a10)) {
                        v1 = ((String)Y2.c.k(a10, v4)).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 60: {
                    if(this.v(v3, v, a10)) {
                        v1 = Y2.c.k(a10, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 61: {
                    if(this.v(v3, v, a10)) {
                        v1 = Y2.c.k(a10, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 62: {
                    if(this.v(v3, v, a10)) {
                        v1 = o2.D(v4, a10) + v1 * 53;
                    }
                    break;
                }
                case 0x3F: {
                    if(this.v(v3, v, a10)) {
                        v1 = o2.D(v4, a10) + v1 * 53;
                    }
                    break;
                }
                case 0x40: {
                    if(this.v(v3, v, a10)) {
                        v1 = o2.D(v4, a10) + v1 * 53;
                    }
                    break;
                }
                case 65: {
                    if(this.v(v3, v, a10)) {
                        v1 = P1.b(o2.E(v4, a10)) + v1 * 53;
                    }
                    break;
                }
                case 66: {
                    if(this.v(v3, v, a10)) {
                        v1 = o2.D(v4, a10) + v1 * 53;
                    }
                    break;
                }
                case 67: {
                    if(this.v(v3, v, a10)) {
                        v1 = P1.b(o2.E(v4, a10)) + v1 * 53;
                    }
                    break;
                }
                case 68: {
                    if(this.v(v3, v, a10)) {
                        v1 = Y2.c.k(a10, v4).hashCode() + v1 * 53;
                    }
                }
            }
        }
        this.m.getClass();
        int v9 = a10.unknownFields.hashCode() + v1 * 53;
        if(this.f) {
            this.n.getClass();
            return ((GeneratedMessageLite.ExtendableMessage)a10).extensions.a.hashCode() + v9 * 53;
        }
        return v9;
    }

    @Override  // com.google.protobuf.E2
    public final int i(A1 a10) {
        int v39;
        int v38;
        int v35;
        int v33;
        int v32;
        int v31;
        int v30;
        int v25;
        int v19;
        int v18;
        int v17;
        int v16;
        int v15;
        int v13;
        int v12;
        int v11;
        int v9;
        Unsafe unsafe0 = o2.q;
        int v = 0xFFFFF;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(true) {
            int[] arr_v = this.a;
            if(v1 >= arr_v.length) {
                break;
            }
            int v4 = this.U(v1);
            int v5 = (v4 & 0xFF00000) >>> 20;
            int v6 = arr_v[v1];
            int v7 = arr_v[v1 + 2];
            int v8 = v7 & 0xFFFFF;
            if(v5 <= 17) {
                if(v8 != v) {
                    v2 = v8 == 0xFFFFF ? 0 : unsafe0.getInt(a10, ((long)v8));
                    v = v8;
                }
                v9 = 1 << (v7 >>> 20);
            }
            else {
                v9 = 0;
            }
            long v10 = (long)(v4 & 0xFFFFF);
            switch(v5) {
                case 0: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.O(v6) + 8;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 1: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.O(v6) + 4;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 2: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.Q(unsafe0.getLong(a10, v10)) + x.O(v6);
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 3: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.Q(unsafe0.getLong(a10, v10)) + x.O(v6);
                    }
                    v1 += 3;
                    continue;
                }
                case 4: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v11 = x.O(v6);
                        v12 = x.Q(unsafe0.getInt(a10, v10));
                        v3 += v12 + v11;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 5: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v13 = x.O(v6) + 8;
                        v3 += v13;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 6: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v13 = x.O(v6) + 4;
                        v3 += v13;
                    }
                    v1 += 3;
                    continue;
                }
                case 7: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v13 = x.O(v6) + 1;
                        v3 += v13;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 8: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        Object object0 = unsafe0.getObject(a10, v10);
                        v3 = (object0 instanceof o ? x.J(v6, ((o)object0)) : x.N(((String)object0)) + x.O(v6)) + v3;
                    }
                    v1 += 3;
                    continue;
                }
                case 9: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        int v14 = ((com.google.protobuf.b)(((l2)unsafe0.getObject(a10, v10)))).getSerializedSize(this.q(v1));
                        v3 += x.P(v14) + v14 + x.O(v6);
                    }
                    v1 += 3;
                    continue;
                }
                case 10: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.J(v6, ((o)unsafe0.getObject(a10, v10)));
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 11: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v11 = x.O(v6);
                        v12 = x.P(unsafe0.getInt(a10, v10));
                        v3 += v12 + v11;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 12: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.Q(unsafe0.getInt(a10, v10)) + x.O(v6);
                    }
                    v1 += 3;
                    continue;
                }
                case 13: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v13 = x.O(v6) + 4;
                        v3 += v13;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 14: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.O(v6) + 8;
                    }
                    v1 += 3;
                    continue;
                }
                case 15: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.L(unsafe0.getInt(a10, v10)) + x.O(v6);
                    }
                    v1 += 3;
                    continue;
                }
                case 16: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += x.M(unsafe0.getLong(a10, v10)) + x.O(v6);
                    }
                    v1 += 3;
                    continue;
                }
                case 17: {
                    if(this.t(a10, v1, v, v2, v9)) {
                        v3 += ((com.google.protobuf.b)(((l2)unsafe0.getObject(a10, v10)))).getSerializedSize(this.q(v1)) + x.O(v6) * 2;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 18: {
                    v15 = F2.c(v6, ((List)unsafe0.getObject(a10, v10)));
                    v3 += v15;
                    v1 += 3;
                    continue;
                }
                case 19: {
                    v15 = F2.b(v6, ((List)unsafe0.getObject(a10, v10)));
                    v3 += v15;
                    v1 += 3;
                    continue;
                }
                case 20: {
                    List list0 = (List)unsafe0.getObject(a10, v10);
                    if(list0.size() != 0) {
                        v16 = x.O(v6) * list0.size() + F2.e(list0);
                        v3 += v16;
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 21: {
                    List list1 = (List)unsafe0.getObject(a10, v10);
                    v17 = list1.size();
                    if(v17 != 0) {
                        v18 = F2.i(list1);
                        v19 = x.O(v6);
                        v16 = v19 * v17 + v18;
                        v3 += v16;
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 22: {
                    List list2 = (List)unsafe0.getObject(a10, v10);
                    v17 = list2.size();
                    if(v17 != 0) {
                        v18 = F2.d(list2);
                        v19 = x.O(v6);
                        v16 = v19 * v17 + v18;
                        v3 += v16;
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 23: {
                    v15 = F2.c(v6, ((List)unsafe0.getObject(a10, v10)));
                    v3 += v15;
                    v1 += 3;
                    continue;
                }
                case 24: {
                    v15 = F2.b(v6, ((List)unsafe0.getObject(a10, v10)));
                    v3 += v15;
                    v1 += 3;
                    continue;
                }
                case 25: {
                    int v20 = ((List)unsafe0.getObject(a10, v10)).size();
                    v3 += (v20 == 0 ? 0 : (x.O(v6) + 1) * v20);
                    v1 += 3;
                    continue;
                }
                case 26: {
                    List list3 = (List)unsafe0.getObject(a10, v10);
                    int v21 = list3.size();
                    if(v21 != 0) {
                        v16 = x.O(v6) * v21;
                        if(list3 instanceof Y1) {
                            Y1 y10 = (Y1)list3;
                            for(int v22 = 0; v22 < v21; ++v22) {
                                Object object1 = y10.m();
                                v16 = (object1 instanceof o ? x.K(((o)object1)) : x.N(((String)object1))) + v16;
                            }
                        }
                        else {
                            for(int v23 = 0; v23 < v21; ++v23) {
                                Object object2 = list3.get(v23);
                                v16 = (object2 instanceof o ? x.K(((o)object2)) : x.N(((String)object2))) + v16;
                            }
                        }
                        v3 += v16;
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 27: {
                    List list4 = (List)unsafe0.getObject(a10, v10);
                    E2 e20 = this.q(v1);
                    int v24 = list4.size();
                    if(v24 != 0) {
                        v25 = x.O(v6) * v24;
                        for(int v26 = 0; v26 < v24; ++v26) {
                            int v27 = ((com.google.protobuf.b)(((l2)list4.get(v26)))).getSerializedSize(e20);
                            v25 += x.P(v27) + v27;
                        }
                        v3 += v25;
                    }
                    v1 += 3;
                    continue;
                }
                case 28: {
                    List list5 = (List)unsafe0.getObject(a10, v10);
                    int v28 = list5.size();
                    if(v28 != 0) {
                        v16 = x.O(v6) * v28;
                        for(int v29 = 0; v29 < list5.size(); ++v29) {
                            v16 += x.K(((o)list5.get(v29)));
                        }
                        v3 += v16;
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 29: {
                    List list6 = (List)unsafe0.getObject(a10, v10);
                    v17 = list6.size();
                    if(v17 != 0) {
                        v18 = F2.h(list6);
                        v19 = x.O(v6);
                        v16 = v19 * v17 + v18;
                        v3 += v16;
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 30: {
                    List list7 = (List)unsafe0.getObject(a10, v10);
                    v17 = list7.size();
                    if(v17 != 0) {
                        v18 = F2.a(list7);
                        v19 = x.O(v6);
                        v16 = v19 * v17 + v18;
                        v3 += v16;
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 0x1F: {
                    v15 = F2.b(v6, ((List)unsafe0.getObject(a10, v10)));
                    v3 += v15;
                    v1 += 3;
                    continue;
                }
                case 0x20: {
                    v15 = F2.c(v6, ((List)unsafe0.getObject(a10, v10)));
                    v3 += v15;
                    v1 += 3;
                    continue;
                }
                case 33: {
                    List list8 = (List)unsafe0.getObject(a10, v10);
                    v17 = list8.size();
                    if(v17 != 0) {
                        v3 += x.O(v6) * v17 + F2.f(list8);
                        v1 += 3;
                        continue;
                    }
                    v16 = 0;
                    v3 += v16;
                    v1 += 3;
                    continue;
                }
                case 34: {
                    List list9 = (List)unsafe0.getObject(a10, v10);
                    v17 = list9.size();
                    v3 += (v17 == 0 ? 0 : x.O(v6) * v17 + F2.g(list9));
                    v1 += 3;
                    continue;
                }
                case 35: {
                    v30 = ((List)unsafe0.getObject(a10, v10)).size() * 8;
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 36: {
                    v30 = ((List)unsafe0.getObject(a10, v10)).size() * 4;
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 37: {
                    v30 = F2.e(((List)unsafe0.getObject(a10, v10)));
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 38: {
                    v30 = F2.i(((List)unsafe0.getObject(a10, v10)));
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 39: {
                    v30 = F2.d(((List)unsafe0.getObject(a10, v10)));
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 40: {
                    v30 = ((List)unsafe0.getObject(a10, v10)).size() * 8;
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 41: {
                    v30 = ((List)unsafe0.getObject(a10, v10)).size() * 4;
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 42: {
                    v30 = ((List)unsafe0.getObject(a10, v10)).size();
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 43: {
                    v30 = F2.h(((List)unsafe0.getObject(a10, v10)));
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 44: {
                    v30 = F2.a(((List)unsafe0.getObject(a10, v10)));
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 45: {
                    v30 = ((List)unsafe0.getObject(a10, v10)).size() * 4;
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 46: {
                    v30 = ((List)unsafe0.getObject(a10, v10)).size() * 8;
                    if(v30 > 0) {
                        v31 = x.O(v6);
                        v32 = x.P(v30);
                        v3 += v32 + v31 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x2F: {
                    v30 = F2.f(((List)unsafe0.getObject(a10, v10)));
                    if(v30 > 0) {
                        v3 += x.P(v30) + x.O(v6) + v30;
                        break;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x30: {
                    v30 = F2.g(((List)unsafe0.getObject(a10, v10)));
                    if(v30 > 0) {
                        v33 = x.P(v30) + x.O(v6);
                        v3 += v33 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 49: {
                    List list10 = (List)unsafe0.getObject(a10, v10);
                    E2 e21 = this.q(v1);
                    int v34 = list10.size();
                    if(v34 == 0) {
                        v35 = 0;
                    }
                    else {
                        v35 = 0;
                        for(int v36 = 0; v36 < v34; ++v36) {
                            v35 += ((com.google.protobuf.b)(((l2)list10.get(v36)))).getSerializedSize(e21) + x.O(v6) * 2;
                        }
                    }
                    v3 += v35;
                    v1 += 3;
                    continue;
                }
                case 50: {
                    Object object3 = unsafe0.getObject(a10, v10);
                    Object object4 = this.p(v1);
                    this.o.getClass();
                    g2 g20 = (g2)object3;
                    f2 f20 = (f2)object4;
                    if(g20.isEmpty()) {
                        v25 = 0;
                    }
                    else {
                        v25 = 0;
                        for(Object object5: g20.entrySet()) {
                            Object object6 = ((Map.Entry)object5).getKey();
                            Object object7 = ((Map.Entry)object5).getValue();
                            f20.getClass();
                            int v37 = f2.a(f20.a, object6, object7);
                            v25 += x.P(v37) + v37 + x.O(v6);
                        }
                    }
                    v3 += v25;
                    v1 += 3;
                    continue;
                }
                case 51: {
                    if(this.v(v6, v1, a10)) {
                        v3 += x.O(v6) + 8;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 52: {
                    if(this.v(v6, v1, a10)) {
                        v3 += x.O(v6) + 4;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 53: {
                    if(this.v(v6, v1, a10)) {
                        v30 = x.O(v6);
                        v33 = x.Q(o2.E(v10, a10));
                        v3 += v33 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 54: {
                    if(this.v(v6, v1, a10)) {
                        v30 = x.O(v6);
                        v33 = x.Q(o2.E(v10, a10));
                        v3 += v33 + v30;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 55: {
                    if(this.v(v6, v1, a10)) {
                        v38 = x.O(v6);
                        v39 = x.Q(o2.D(v10, a10));
                        v3 += v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 56: {
                    if(this.v(v6, v1, a10)) {
                        v15 = x.O(v6) + 8;
                        v3 += v15;
                        break;
                    }
                    v1 += 3;
                    continue;
                }
                case 57: {
                    if(this.v(v6, v1, a10)) {
                        v15 = x.O(v6) + 4;
                        v3 += v15;
                        break;
                    }
                    v1 += 3;
                    continue;
                }
                case 58: {
                    if(this.v(v6, v1, a10)) {
                        v15 = x.O(v6) + 1;
                        v3 += v15;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 59: {
                    if(this.v(v6, v1, a10)) {
                        Object object8 = unsafe0.getObject(a10, v10);
                        v3 = (object8 instanceof o ? x.J(v6, ((o)object8)) : x.N(((String)object8)) + x.O(v6)) + v3;
                    }
                    v1 += 3;
                    continue;
                }
                case 60: {
                    if(this.v(v6, v1, a10)) {
                        int v40 = ((com.google.protobuf.b)(((l2)unsafe0.getObject(a10, v10)))).getSerializedSize(this.q(v1));
                        v3 += x.P(v40) + v40 + x.O(v6);
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 61: {
                    if(this.v(v6, v1, a10)) {
                        v15 = x.J(v6, ((o)unsafe0.getObject(a10, v10)));
                        v3 += v15;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 62: {
                    if(this.v(v6, v1, a10)) {
                        v38 = x.O(v6);
                        v39 = x.P(o2.D(v10, a10));
                        v3 += v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x3F: {
                    if(this.v(v6, v1, a10)) {
                        v15 = x.Q(o2.D(v10, a10)) + x.O(v6);
                        v3 += v15;
                        break;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x40: {
                    if(this.v(v6, v1, a10)) {
                        v15 = x.O(v6) + 4;
                        v3 += v15;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 65: {
                    if(this.v(v6, v1, a10)) {
                        v15 = x.O(v6) + 8;
                        v3 += v15;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 66: {
                    if(this.v(v6, v1, a10)) {
                        v3 += x.L(o2.D(v10, a10)) + x.O(v6);
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 67: {
                    if(this.v(v6, v1, a10)) {
                        v3 += x.M(o2.E(v10, a10)) + x.O(v6);
                    }
                    v1 += 3;
                    continue;
                }
                case 68: {
                    if(this.v(v6, v1, a10)) {
                        v3 += ((com.google.protobuf.b)(((l2)unsafe0.getObject(a10, v10)))).getSerializedSize(this.q(v1)) + x.O(v6) * 2;
                    }
                    break;
                }
                default: {
                    v1 += 3;
                    continue;
                }
            }
            v1 += 3;
        }
        this.m.getClass();
        int v41 = a10.unknownFields.c() + v3;
        if(this.f) {
            this.n.getClass();
            return ((GeneratedMessageLite.ExtendableMessage)a10).extensions.h() + v41;
        }
        return v41;
    }

    @Override  // com.google.protobuf.E2
    public final boolean j(A1 a10, A1 a11) {
        int[] arr_v = this.a;
        for(int v = 0; true; v += 3) {
            boolean z = true;
            if(v >= arr_v.length) {
                break;
            }
            int v1 = this.U(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch((v1 & 0xFF00000) >>> 20) {
                case 0: {
                    if(!this.k(a10, a11, v) || Double.doubleToLongBits(Y2.c.g(v2, a10)) != Double.doubleToLongBits(Y2.c.g(v2, a11))) {
                        z = false;
                    }
                    break;
                }
                case 1: {
                    if(!this.k(a10, a11, v) || Float.floatToIntBits(Y2.c.h(v2, a10)) != Float.floatToIntBits(Y2.c.h(v2, a11))) {
                        z = false;
                    }
                    break;
                }
                case 2: {
                    if(!this.k(a10, a11, v) || Y2.c.j(a10, v2) != Y2.c.j(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 3: {
                    if(!this.k(a10, a11, v) || Y2.c.j(a10, v2) != Y2.c.j(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 4: {
                    if(!this.k(a10, a11, v) || Y2.c.i(a10, v2) != Y2.c.i(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 5: {
                    if(!this.k(a10, a11, v) || Y2.c.j(a10, v2) != Y2.c.j(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 6: {
                    if(!this.k(a10, a11, v) || Y2.c.i(a10, v2) != Y2.c.i(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 7: {
                    if(!this.k(a10, a11, v) || Y2.c.d(v2, a10) != Y2.c.d(v2, a11)) {
                        z = false;
                    }
                    break;
                }
                case 8: {
                    if(!this.k(a10, a11, v) || !F2.m(Y2.c.k(a10, v2), Y2.c.k(a11, v2))) {
                        z = false;
                    }
                    break;
                }
                case 9: {
                    if(!this.k(a10, a11, v) || !F2.m(Y2.c.k(a10, v2), Y2.c.k(a11, v2))) {
                        z = false;
                    }
                    break;
                }
                case 10: {
                    if(!this.k(a10, a11, v) || !F2.m(Y2.c.k(a10, v2), Y2.c.k(a11, v2))) {
                        z = false;
                    }
                    break;
                }
                case 11: {
                    if(!this.k(a10, a11, v) || Y2.c.i(a10, v2) != Y2.c.i(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 12: {
                    if(!this.k(a10, a11, v) || Y2.c.i(a10, v2) != Y2.c.i(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 13: {
                    if(!this.k(a10, a11, v) || Y2.c.i(a10, v2) != Y2.c.i(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 14: {
                    if(!this.k(a10, a11, v) || Y2.c.j(a10, v2) != Y2.c.j(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 15: {
                    if(!this.k(a10, a11, v) || Y2.c.i(a10, v2) != Y2.c.i(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 16: {
                    if(!this.k(a10, a11, v) || Y2.c.j(a10, v2) != Y2.c.j(a11, v2)) {
                        z = false;
                    }
                    break;
                }
                case 17: {
                    if(!this.k(a10, a11, v) || !F2.m(Y2.c.k(a10, v2), Y2.c.k(a11, v2))) {
                        z = false;
                    }
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    z = F2.m(Y2.c.k(a10, v2), Y2.c.k(a11, v2));
                    break;
                }
                case 50: {
                    z = F2.m(Y2.c.k(a10, v2), Y2.c.k(a11, v2));
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: 
                case 68: {
                    long v3 = (long)(arr_v[v + 2] & 0xFFFFF);
                    if(Y2.c.i(a10, v3) != Y2.c.i(a11, v3) || !F2.m(Y2.c.k(a10, v2), Y2.c.k(a11, v2))) {
                        z = false;
                    }
                }
            }
            if(!z) {
                return false;
            }
        }
        this.m.getClass();
        S2 s20 = a10.unknownFields;
        this.m.getClass();
        if(!s20.equals(a11.unknownFields)) {
            return false;
        }
        if(this.f) {
            this.n.getClass();
            o1 o10 = ((GeneratedMessageLite.ExtendableMessage)a10).extensions;
            this.n.getClass();
            return o10.equals(((GeneratedMessageLite.ExtendableMessage)a11).extensions);
        }
        return true;
    }

    public final boolean k(A1 a10, A1 a11, int v) {
        return this.s(v, a10) == this.s(v, a11);
    }

    public static void l(Object object0) {
        if(!o2.u(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
    }

    public static int m(byte[] arr_b, int v, int v1, j3 j30, Class class0, g g0) {
        switch(j30.ordinal()) {
            case 0: {
                g0.c = Double.longBitsToDouble(h.f(v, arr_b));
                return v + 8;
            }
            case 1: {
                g0.c = Float.intBitsToFloat(h.e(v, arr_b));
                return v + 4;
            }
            case 2: 
            case 3: {
                int v2 = h.z(arr_b, v, g0);
                g0.c = g0.b;
                return v2;
            }
            case 7: {
                int v4 = h.z(arr_b, v, g0);
                g0.c = Boolean.valueOf(g0.b != 0L);
                return v4;
            }
            case 8: {
                int v5 = h.x(arr_b, v, g0);
                int v6 = g0.a;
                if(v6 < 0) {
                    throw R1.f();
                }
                if(v6 == 0) {
                    g0.c = "";
                    return v5;
                }
                g0.c = b3.a.t(arr_b, v5, v6);
                return v5 + v6;
            }
            case 10: {
                return h.h(B2.c.a(class0), arr_b, v, v1, g0);
            }
            case 11: {
                return h.d(arr_b, v, g0);
            }
            case 4: 
            case 12: 
            case 13: {
                int v3 = h.x(arr_b, v, g0);
                g0.c = g0.a;
                return v3;
            }
            case 6: 
            case 14: {
                g0.c = h.e(v, arr_b);
                return v + 4;
            }
            case 5: 
            case 15: {
                g0.c = h.f(v, arr_b);
                return v + 8;
            }
            case 16: {
                int v7 = h.x(arr_b, v, g0);
                g0.c = (int)(-(g0.a & 1) ^ g0.a >>> 1);
                return v7;
            }
            case 17: {
                int v8 = h.z(arr_b, v, g0);
                g0.c = (long)(-(g0.b & 1L) ^ g0.b >>> 1);
                return v8;
            }
            default: {
                throw new RuntimeException("unsupported field type.");
            }
        }
    }

    public final Object n(Object object0, int v, Object object1, T2 t20, Object object2) {
        int v1 = this.a[v];
        int v2 = this.U(v);
        Object object3 = Y2.c.k(object0, ((long)(v2 & 0xFFFFF)));
        if(object3 != null) {
            I1 i10 = this.o(v);
            if(i10 != null) {
                this.o.getClass();
                Object object4 = this.p(v);
                this.o.getClass();
                s s0 = ((f2)object4).a;
                Iterator iterator0 = ((g2)object3).entrySet().iterator();
                while(iterator0.hasNext()) {
                    Object object5 = iterator0.next();
                    Map.Entry map$Entry0 = (Map.Entry)object5;
                    if(!i10.a(((int)(((Integer)map$Entry0.getValue()))))) {
                        if(object1 == null) {
                            object1 = t20.a(object2);
                        }
                        int v3 = f2.a(s0, map$Entry0.getKey(), map$Entry0.getValue());
                        byte[] arr_b = new byte[v3];
                        u u0 = new u(arr_b, v3);
                        try {
                            Object object6 = map$Entry0.getKey();
                            Object object7 = map$Entry0.getValue();
                            o1.q(u0, ((j3)s0.a), 1, object6);
                            o1.q(u0, ((j3)s0.b), 2, object7);
                        }
                        catch(IOException iOException0) {
                            throw new RuntimeException(iOException0);
                        }
                        if(u0.o0() != 0) {
                            throw new IllegalStateException("Did not write as much data as expected.");
                        }
                        n n0 = new n(arr_b);
                        t20.getClass();
                        ((S2)object1).f(v1 << 3 | 2, n0);
                        iterator0.remove();
                    }
                }
                return object1;
            }
        }
        return object1;
    }

    public final I1 o(int v) {
        return (I1)this.b[v / 3 * 2 + 1];
    }

    public final Object p(int v) {
        return this.b[v / 3 * 2];
    }

    public final E2 q(int v) {
        int v1 = v / 3 * 2;
        Object[] arr_object = this.b;
        E2 e20 = (E2)arr_object[v1];
        if(e20 != null) {
            return e20;
        }
        E2 e21 = B2.c.a(((Class)arr_object[v1 + 1]));
        arr_object[v1] = e21;
        return e21;
    }

    public static S2 r(Object object0) {
        S2 s20 = ((A1)object0).unknownFields;
        if(s20 == S2.f) {
            s20 = new S2();
            ((A1)object0).unknownFields = s20;
        }
        return s20;
    }

    public final boolean s(int v, Object object0) {
        int v1 = this.a[v + 2];
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.U(v);
            switch((v2 & 0xFF00000) >>> 20) {
                case 0: {
                    return Double.doubleToRawLongBits(Y2.c.g(((long)(v2 & 0xFFFFF)), object0)) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(Y2.c.h(((long)(v2 & 0xFFFFF)), object0)) != 0;
                }
                case 2: {
                    return Y2.c.j(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return Y2.c.j(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return Y2.c.i(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return Y2.c.j(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return Y2.c.i(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return Y2.c.d(((long)(v2 & 0xFFFFF)), object0);
                }
                case 8: {
                    Object object1 = Y2.c.k(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof o)) {
                        throw new IllegalArgumentException();
                    }
                    return !o.b.equals(object1);
                }
                case 9: {
                    return Y2.c.k(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = Y2.c.k(object0, ((long)(v2 & 0xFFFFF)));
                    return !o.b.equals(object2);
                }
                case 11: {
                    return Y2.c.i(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return Y2.c.i(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return Y2.c.i(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return Y2.c.j(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return Y2.c.i(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return Y2.c.j(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return Y2.c.k(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (1 << (v1 >>> 20) & Y2.c.i(object0, ((long)(v1 & 0xFFFFF)))) != 0;
    }

    public final boolean t(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.s(v, object0) : (v2 & v3) != 0;
    }

    public static boolean u(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof A1 ? ((A1)object0).isMutable() : true;
    }

    public final boolean v(int v, int v1, Object object0) {
        return Y2.c.i(object0, ((long)(this.a[v1 + 2] & 0xFFFFF))) == v;
    }

    public final void w(Object object0, int v, Object object1, g1 g10, w w0) {
        int v1 = this.U(v);
        g2 g20 = Y2.c.k(object0, ((long)(v1 & 0xFFFFF)));
        h2 h20 = this.o;
        if(g20 == null) {
            h20.getClass();
            g20 = g2.b.c();
            Y2.p(object0, ((long)(v1 & 0xFFFFF)), g20);
        }
        else {
            h20.getClass();
            if(!g20.a) {
                h20.getClass();
                g2 g21 = g2.b.c();
                h20.a(g21, g20);
                Y2.p(object0, ((long)(v1 & 0xFFFFF)), g21);
                g20 = g21;
            }
        }
        h20.getClass();
        h20.getClass();
        s s0 = ((f2)object1).a;
        w0.v0(2);
        t t0 = (t)w0.e;
        int v2 = t0.k(t0.F());
        Object object2 = s0.c;
        String s1 = "";
        Object object3 = object2;
        try {
        alab1:
            while(true) {
                while(true) {
                    int v4 = w0.h();
                    if(v4 == 0x7FFFFFFF || t0.g()) {
                        break alab1;
                    }
                    try {
                        switch(v4) {
                            case 1: {
                                s1 = w0.H(((j3)s0.a), null, null);
                                continue;
                            }
                            case 2: {
                                object3 = w0.H(((j3)s0.b), object2.getClass(), g10);
                                continue;
                            }
                            default: {
                                if(w0.x0()) {
                                    continue;
                                }
                            }
                        }
                        throw new R1("Unable to parse map entry.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    catch(Q1 q10) {
                    }
                    break;
                }
                if(!w0.x0()) {
                    throw new R1("Unable to parse map entry.", q10);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
                }
            }
            g20.put(s1, object3);
        }
        finally {
            t0.j(v2);
        }
    }

    public final void x(int v, Object object0, Object object1) {
        if(!this.s(v, object1)) {
            return;
        }
        int v1 = this.U(v);
        Unsafe unsafe0 = o2.q;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.a[v] + " is present but null: " + object1);
        }
        E2 e20 = this.q(v);
        if(!this.s(v, object0)) {
            if(o2.u(object2)) {
                Object object3 = e20.d();
                e20.a(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.O(v, object0);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!o2.u(object4)) {
            Object object5 = e20.d();
            e20.a(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        e20.a(object4, object2);
    }

    public final void y(int v, Object object0, Object object1) {
        int[] arr_v = this.a;
        int v1 = arr_v[v];
        if(!this.v(v1, v, object1)) {
            return;
        }
        int v2 = this.U(v);
        Unsafe unsafe0 = o2.q;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + arr_v[v] + " is present but null: " + object1);
        }
        E2 e20 = this.q(v);
        if(!this.v(v1, v, object0)) {
            if(o2.u(object2)) {
                Object object3 = e20.d();
                e20.a(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.P(v1, v, object0);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!o2.u(object4)) {
            Object object5 = e20.d();
            e20.a(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        e20.a(object4, object2);
    }

    public final Object z(int v, Object object0) {
        E2 e20 = this.q(v);
        int v1 = this.U(v);
        if(!this.s(v, object0)) {
            return e20.d();
        }
        Object object1 = o2.q.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(o2.u(object1)) {
            return object1;
        }
        Object object2 = e20.d();
        if(object1 != null) {
            e20.a(object2, object1);
        }
        return object2;
    }
}

