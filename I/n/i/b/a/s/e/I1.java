package i.n.i.b.a.s.e;

import B3.N;
import B3.q;
import H4.b;
import U4.x;
import V3.a;
import V3.d;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class i1 {
    public static final byte[] a;
    public static final byte[] b;

    static {
        i1.a = "OpusHead".getBytes(b9.c);
        i1.b = new byte[]{(byte)0x89, 0x74, -37, -50, 0x7B, -25, 76, 81, (byte)0x84, -7, 0x71, 72, -7, -120, 37, 84};
    }

    public static Pair a(int v, wb wb0) {
        wb0.n(v + 12);
        wb0.o(1);
        i1.d(wb0);
        wb0.o(2);
        int v1 = wb0.z();
        if((v1 & 0x80) != 0) {
            wb0.o(2);
        }
        if((v1 & 0x40) != 0) {
            wb0.o(wb0.b());
        }
        if((v1 & 0x20) != 0) {
            wb0.o(2);
        }
        wb0.o(1);
        i1.d(wb0);
        String s = mb.a(wb0.z());
        if(!"audio/mpeg".equals(s) && !"audio/vnd.dts".equals(s) && !"audio/vnd.dts.hd".equals(s)) {
            wb0.o(12);
            wb0.o(1);
            int v2 = i1.d(wb0);
            byte[] arr_b = new byte[v2];
            wb0.j(arr_b, 0, v2);
            return Pair.create(s, arr_b);
        }
        return Pair.create(s, null);
    }

    public static U7 b(D6 d60, o0 o00, Ka ka0) {
        int[] arr_v29;
        long[] arr_v28;
        int[] arr_v25;
        int v68;
        int v66;
        int v65;
        int v63;
        int[] arr_v22;
        long v54;
        int v49;
        int v26;
        long[] arr_v10;
        long[] arr_v9;
        long v25;
        int v24;
        long[] arr_v8;
        long v23;
        int[] arr_v7;
        int[] arr_v5;
        int v43;
        int[] arr_v18;
        int v42;
        int v41;
        int v6;
        int v5;
        int v4;
        boolean z;
        h1 h10;
        u u0 = d60.f;
        p0 p00 = o00.p(1937011578);
        if(p00 == null) {
            p0 p01 = o00.p(1937013298);
            if(p01 == null) {
                throw new H4("Track has no sample table size information");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
            }
            h10 = new d(p01);
        }
        else {
            h10 = new h1(p00, u0);
        }
        int v = h10.b();
        if(v == 0) {
            return new U7(d60, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        p0 p02 = o00.p(1937007471);
        if(p02 == null) {
            p02 = o00.p(0x636F3634);
            p02.getClass();
            z = true;
        }
        else {
            z = false;
        }
        p0 p03 = o00.p(1937011555);
        p03.getClass();
        p0 p04 = o00.p(1937011827);
        p04.getClass();
        wb wb0 = p04.c;
        p0 p05 = o00.p(1937011571);
        wb wb1 = p05 == null ? null : p05.c;
        p0 p06 = o00.p(0x63747473);
        wb wb2 = p06 == null ? null : p06.c;
        a a0 = new a(p03.c, p02.c, z);
        wb0.n(12);
        int v1 = wb0.C();
        int v2 = wb0.C();
        int v3 = wb0.C();
        if(wb2 == null) {
            v4 = 0;
        }
        else {
            wb2.n(12);
            v4 = wb2.C();
        }
        if(wb1 == null) {
            v5 = 0;
            v6 = -1;
        }
        else {
            wb1.n(12);
            v5 = wb1.C();
            if(v5 > 0) {
                v6 = wb1.C() - 1;
            }
            else {
                wb1 = null;
                v6 = -1;
            }
        }
        int v7 = h10.a();
        int v8 = d60.b;
        long v9 = d60.c;
        long[] arr_v = d60.i;
        long[] arr_v1 = d60.h;
        if(v7 == -1 || !"audio/raw".equals(u0.l) && !"audio/g711-mlaw".equals(u0.l) && !"audio/g711-alaw".equals(u0.l) || v1 - 1 != 0 || v4 != 0 || v5 != 0) {
            long[] arr_v11 = new long[v];
            int[] arr_v12 = new int[v];
            long[] arr_v13 = new long[v];
            int[] arr_v14 = new int[v];
            v25 = v9;
            int v27 = v3;
            int v28 = v6;
            v26 = 0;
            int v29 = 0;
            int v30 = 0;
            long v31 = 0L;
            long v32 = 0L;
            int v33 = v5;
            int v34 = v4;
            int v35 = v2;
            arr_v8 = arr_v1;
            int v36 = 0;
            int v37 = v1 - 1;
            v24 = v8;
            int v38 = 0;
            while(true) {
                if(v38 >= v) {
                    goto label_181;
                }
                long v39 = v32;
                int v40 = v29;
                boolean z1 = true;
                while(v40 == 0) {
                    z1 = a0.a();
                    if(!z1) {
                        break;
                    }
                    v40 = a0.c;
                    v39 = a0.d;
                }
                v41 = v37;
                v42 = v35;
                if(z1) {
                    if(wb2 != null) {
                        int v44 = v30;
                        while(v44 == 0 && v34 > 0) {
                            v44 = wb2.C();
                            v36 = wb2.p();
                            --v34;
                        }
                        v30 = v44 - 1;
                    }
                    arr_v11[v38] = v39;
                    int v45 = h10.c();
                    arr_v12[v38] = v45;
                    if(v45 > v26) {
                        v26 = v45;
                    }
                    arr_v13[v38] = v31 + ((long)v36);
                    arr_v14[v38] = wb1 == null ? 1 : 0;
                    if(v38 == v28) {
                        arr_v14[v38] = 1;
                        --v33;
                        if(v33 > 0) {
                            wb1.getClass();
                            v28 = wb1.C() - 1;
                        }
                    }
                    v31 += (long)v27;
                    v35 = v42 - 1;
                    if(v35 != 0 || v41 <= 0) {
                        v37 = v41;
                    }
                    else {
                        v37 = v41 - 1;
                        v35 = wb0.C();
                        v27 = wb0.p();
                    }
                    long v46 = v39 + ((long)arr_v12[v38]);
                    ++v38;
                    v32 = v46;
                    v29 = v40 - 1;
                    continue;
                label_181:
                    v41 = v37;
                    v42 = v35;
                    arr_v18 = arr_v14;
                    arr_v5 = arr_v12;
                    v43 = v29;
                }
                else {
                    Log.w("AtomParsers", "Unexpected end of chunk data");
                    long[] arr_v15 = Arrays.copyOf(arr_v11, v38);
                    int[] arr_v16 = Arrays.copyOf(arr_v12, v38);
                    long[] arr_v17 = Arrays.copyOf(arr_v13, v38);
                    arr_v18 = Arrays.copyOf(arr_v14, v38);
                    arr_v11 = arr_v15;
                    arr_v5 = arr_v16;
                    arr_v13 = arr_v17;
                    v = v38;
                    v43 = v40;
                }
                break;
            }
            boolean z2 = true;
            if(wb2 != null) {
                while(v34 > 0) {
                    if(wb2.C() != 0) {
                        z2 = false;
                        break;
                    }
                    wb2.p();
                    --v34;
                }
            }
            if(v33 != 0 || v42 != 0 || v43 != 0 || v41 != 0 || v30 != 0 || !z2) {
                StringBuilder stringBuilder0 = new StringBuilder("Inconsistent stbl box for track ");
                x.x(stringBuilder0, d60.a, ": remainingSynchronizationSamples ", v33, ", remainingSamplesAtTimestampDelta ");
                x.x(stringBuilder0, v42, ", remainingSamplesInChunk ", v43, ", remainingTimestampDeltaChanges ");
                stringBuilder0.append(v41);
                stringBuilder0.append(", remainingSamplesAtTimestampOffset ");
                stringBuilder0.append(v30);
                stringBuilder0.append((z2 ? "" : ", ctts invalid"));
                Log.w("AtomParsers", stringBuilder0.toString());
            }
            arr_v7 = arr_v18;
            arr_v9 = arr_v11;
            v23 = v31 + ((long)v36);
            arr_v10 = arr_v13;
        }
        else {
            int v10 = a0.a;
            long[] arr_v2 = new long[v10];
            int[] arr_v3 = new int[v10];
            while(a0.a()) {
                int v11 = a0.b;
                arr_v2[v11] = a0.d;
                arr_v3[v11] = a0.c;
            }
            int v13 = 0;
            for(int v12 = 0; v12 < v10; ++v12) {
                v13 += L7.c(arr_v3[v12], 0x2000 / v7);
            }
            long[] arr_v4 = new long[v13];
            arr_v5 = new int[v13];
            long[] arr_v6 = new long[v13];
            arr_v7 = new int[v13];
            int v15 = 0;
            int v16 = 0;
            for(int v14 = 0; v14 < v10; ++v14) {
                int v18 = arr_v3[v14];
                long v19 = arr_v2[v14];
                int v20 = v18;
                for(int v17 = 0; v20 > 0; ++v17) {
                    int v21 = Math.min(0x2000 / v7, v20);
                    arr_v4[v17] = v19;
                    int v22 = v7 * v21;
                    arr_v5[v17] = v22;
                    v16 = Math.max(v16, v22);
                    arr_v6[v17] = ((long)v15) * ((long)v3);
                    arr_v7[v17] = 1;
                    v19 += (long)arr_v5[v17];
                    v15 += v21;
                    v20 -= v21;
                }
            }
            v23 = ((long)v15) * ((long)v3);
            arr_v8 = arr_v1;
            v24 = v8;
            v25 = v9;
            arr_v9 = arr_v4;
            arr_v10 = arr_v6;
            v26 = v16;
        }
        int[] arr_v19 = arr_v5;
        long v47 = L7.C(v23, 1000000L, d60.c);
        if(arr_v8 == null) {
            L7.o(arr_v10, v25);
            return new U7(d60, arr_v9, arr_v19, v26, arr_v10, arr_v7, v47);
        }
        int v48 = v26;
        if(arr_v8.length == 1) {
            v49 = v24;
            if(v49 != 1 || arr_v10.length < 2) {
                v54 = v23;
            }
            else {
                arr_v.getClass();
                long v50 = arr_v[0];
                long v51 = L7.C(arr_v8[0], d60.c, d60.d) + v50;
                long v52 = arr_v10[0];
                if(v52 > v50 || v50 >= arr_v10[L7.d(4, 0, arr_v10.length - 1)] || arr_v10[L7.d(arr_v10.length - 4, 0, arr_v10.length - 1)] >= v51 || v51 > v23) {
                    v54 = v23;
                }
                else {
                    long v53 = L7.C(v50 - v52, u0.T, d60.c);
                    v54 = v23;
                    long v55 = L7.C(v23 - v51, u0.T, d60.c);
                    if((v53 != 0L || v55 != 0L) && v53 <= 0x7FFFFFFFL && v55 <= 0x7FFFFFFFL) {
                        ka0.a = (int)v53;
                        ka0.b = (int)v55;
                        L7.o(arr_v10, v25);
                        return new U7(d60, arr_v9, arr_v19, v48, arr_v10, arr_v7, L7.C(arr_v8[0], 1000000L, d60.d));
                    }
                }
            }
        }
        else {
            v54 = v23;
            v49 = v24;
        }
        if(arr_v8.length == 1 && arr_v8[0] == 0L) {
            arr_v.getClass();
            long v56 = arr_v[0];
            for(int v57 = 0; v57 < arr_v10.length; ++v57) {
                arr_v10[v57] = L7.C(arr_v10[v57] - v56, 1000000L, d60.c);
            }
            return new U7(d60, arr_v9, arr_v19, v48, arr_v10, arr_v7, L7.C(v54 - v56, 1000000L, d60.c));
        }
        int[] arr_v20 = new int[arr_v8.length];
        int[] arr_v21 = new int[arr_v8.length];
        arr_v.getClass();
        int v58 = 0;
        int v59 = 0;
        int v60 = 0;
        int v61 = 0;
        while(v58 < arr_v8.length) {
            long v62 = arr_v[v58];
            if(v62 == -1L) {
                arr_v22 = arr_v19;
                v63 = v48;
            }
            else {
                arr_v22 = arr_v19;
                v63 = v48;
                long v64 = L7.C(arr_v8[v58], d60.c, d60.d);
                arr_v20[v58] = L7.y(arr_v10, v62, true);
                arr_v21[v58] = L7.g(arr_v10, v62 + v64, v49 == 1);
                while(true) {
                    v65 = arr_v20[v58];
                    v66 = arr_v21[v58];
                    if(v65 >= v66 || (arr_v7[v65] & 1) != 0) {
                        break;
                    }
                    arr_v20[v58] = v65 + 1;
                }
                v60 |= (v61 == v65 ? 0 : 1);
                v61 = v66;
                v59 = v66 - v65 + v59;
            }
            ++v58;
            arr_v19 = arr_v22;
            v48 = v63;
        }
        int[] arr_v23 = arr_v19;
        int v67 = v60 | (v59 == v ? 0 : 1);
        long[] arr_v24 = v67 == 0 ? arr_v9 : new long[v59];
        if(v67 == 0) {
            arr_v25 = arr_v23;
            v68 = 0;
        }
        else {
            v68 = v67;
            arr_v25 = new int[v59];
        }
        int v69 = v68 == 0 ? v48 : 0;
        int[] arr_v26 = v68 == 0 ? arr_v7 : new int[v59];
        long[] arr_v27 = new long[v59];
        int v70 = 0;
        int v71 = 0;
        long v72 = 0L;
        while(v70 < arr_v8.length) {
            long v73 = arr_v[v70];
            int v74 = arr_v20[v70];
            int v75 = arr_v21[v70];
            if(v68 == 0) {
                arr_v28 = arr_v9;
                arr_v29 = arr_v23;
            }
            else {
                int v76 = v75 - v74;
                System.arraycopy(arr_v9, v74, arr_v24, v71, v76);
                arr_v28 = arr_v9;
                arr_v29 = arr_v23;
                System.arraycopy(arr_v29, v74, arr_v25, v71, v76);
                System.arraycopy(arr_v7, v74, arr_v26, v71, v76);
            }
            while(v74 < v75) {
                arr_v27[v71] = L7.C(v72, 1000000L, d60.d) + L7.C(Math.max(0L, arr_v10[v74] - v73), 1000000L, d60.c);
                if(v68 != 0 && arr_v25[v71] > v69) {
                    v69 = arr_v29[v74];
                }
                ++v71;
                ++v74;
            }
            arr_v23 = arr_v29;
            v72 += arr_v8[v70];
            ++v70;
            arr_v9 = arr_v28;
        }
        return new U7(d60, arr_v24, arr_v25, v69, arr_v27, arr_v26, L7.C(v72, 1000000L, d60.d));
    }

    // This method was un-flattened
    public static ArrayList c(o0 o00, Ka ka0, long v, c3 c30, boolean z, boolean z1, Da da0) {
        int v2;
        ArrayList arrayList2;
        long[] arr_v8;
        long[] arr_v7;
        Pair pair7;
        int v63;
        int v53;
        ArrayList arrayList6;
        String s4;
        int v46;
        c3 c32;
        c3 c31;
        int v45;
        int v38;
        int v37;
        int v36;
        int v42;
        int v39;
        int[] arr_v2;
        int v35;
        int v34;
        long v33;
        c5 c50;
        ArrayList arrayList4;
        int v31;
        int v32;
        a7[] arr_a71;
        String s2;
        Pair pair1;
        o0 o05;
        int v30;
        int v80;
        String s12;
        int v75;
        List list3;
        List list2;
        c3 c33;
        int v70;
        int v69;
        int v16;
        long v11;
        long v9;
        D6 d60;
        ArrayList arrayList3;
        int v3;
        ArrayList arrayList0 = o00.e;
        ArrayList arrayList1 = new ArrayList();
        int v1 = 0;
        while(v1 < arrayList0.size()) {
            o0 o01 = (o0)arrayList0.get(v1);
            if(o01.b == 1953653099) {
                p0 p00 = o00.p(0x6D766864);
                p00.getClass();
                o0 o02 = o01.o(0x6D646961);
                o02.getClass();
                p0 p01 = o02.p(0x68646C72);
                p01.getClass();
                p01.c.n(16);
                switch(p01.c.p()) {
                    case 0x6D657461: {
                        v3 = 5;
                        break;
                    }
                    case 0x736F756E: {
                        v3 = 1;
                        break;
                    }
                    case 0x636C6370: 
                    case 0x7362746C: 
                    case 1937072756: 
                    case 1952807028: {
                        break;
                    }
                    case 0x76696465: {
                        v3 = 2;
                        break;
                    }
                    default: {
                        v3 = -1;
                        arrayList3 = arrayList1;
                        v2 = v1;
                        d60 = null;
                        goto label_631;
                    }
                }
                p0 p02 = o01.p(0x746B6864);
                p02.getClass();
                wb wb0 = p02.c;
                wb0.n(8);
                int v4 = b.e(wb0.p());
                wb0.o((v4 == 0 ? 8 : 16));
                int v5 = wb0.p();
                wb0.o(4);
                int v6 = wb0.b;
                int v7 = v4 == 0 ? 4 : 8;
                int v8 = 0;
                while(true) {
                    v9 = 0x8000000000000001L;
                    if(v8 >= v7) {
                        break;
                    }
                    if(wb0.a[v6 + v8] != -1) {
                        long v10 = v4 == 0 ? wb0.A() : wb0.a();
                        if(v10 == 0L) {
                            goto label_48;
                        }
                        else {
                            v11 = v10;
                            goto label_49;
                        }
                    }
                    ++v8;
                }
                wb0.o(v7);
            label_48:
                v11 = 0x8000000000000001L;
            label_49:
                wb0.o(16);
                int v12 = wb0.p();
                int v13 = wb0.p();
                wb0.o(4);
                int v14 = wb0.p();
                int v15 = wb0.p();
                if(v12 == 0 && v13 == 0x10000 && v14 == 0xFFFF0000 && v15 == 0) {
                    v16 = 90;
                }
                else if(v12 != 0 || v13 != 0xFFFF0000 || v14 != 0x10000 || v15 != 0) {
                    v16 = v12 != 0xFFFF0000 || v13 != 0 || v14 != 0 || v15 != 0xFFFF0000 ? 0 : 180;
                }
                else {
                    v16 = 270;
                }
                long v17 = v == 0x8000000000000001L ? v11 : v;
                p00.c.n(8);
                int v18 = b.e(p00.c.p()) == 0 ? 8 : 16;
                p00.c.o(v18);
                long v19 = p00.c.A();
                if(v17 != 0x8000000000000001L) {
                    v9 = L7.C(v17, 1000000L, v19);
                }
                o0 o03 = o02.o(1835626086);
                o03.getClass();
                o0 o04 = o03.o(1937007212);
                o04.getClass();
                p0 p03 = o02.p(0x6D646864);
                p03.getClass();
                p03.c.n(8);
                int v20 = b.e(p03.c.p());
                p03.c.o((v20 == 0 ? 8 : 16));
                long v21 = p03.c.A();
                p03.c.o((v20 == 0 ? 4 : 8));
                int v22 = p03.c.b();
                Pair pair0 = Pair.create(v21, "" + ((char)((v22 >> 10 & 0x1F) + 0x60)) + ((char)((v22 >> 5 & 0x1F) + 0x60)) + ((char)((v22 & 0x1F) + 0x60)));
                p0 p04 = o04.p(1937011556);
                p04.getClass();
                wb wb1 = p04.c;
                String s = (String)pair0.second;
                wb1.n(12);
                int v23 = wb1.p();
                a7[] arr_a7 = new a7[v23];
                int v24 = 0;
                int v25 = 0;
                u u0 = null;
                int v26 = 0;
                while(v24 < v23) {
                    int v27 = wb1.b;
                    int v28 = wb1.p();
                    M7.I("childAtomSize should be positive", v28 > 0);
                    int v29 = wb1.p();
                alab1:
                    switch(v29) {
                        case 0x61763031: 
                        case 0x61766331: 
                        case 0x61766332: 
                        case 0x61766333: 
                        case 0x61766334: 
                        case 0x64766131: 
                        case 0x64766176: 
                        case 0x64766831: 
                        case 0x64766865: 
                        case 1701733238: 
                        case 0x68657631: 
                        case 1752589105: 
                        case 0x6D317620: 
                        case 1836070006: 
                        case 1932670515: 
                        case 0x76703038: 
                        case 0x76703039: {
                            arrayList4 = arrayList1;
                            o05 = o01;
                            pair1 = pair0;
                            v30 = v23;
                            arr_a71 = arr_a7;
                            v32 = v24;
                            int v65 = v25;
                            wb1.n(v27 + 16);
                            wb1.o(16);
                            int v66 = wb1.b();
                            int v67 = wb1.b();
                            wb1.o(50);
                            int v68 = wb1.b;
                            if(v29 == 1701733238) {
                                v69 = v28;
                                v70 = v27;
                                Pair pair5 = i1.e(wb1, v70, v69);
                                if(pair5 == null) {
                                    c33 = c30;
                                }
                                else {
                                    v29 = (int)(((Integer)pair5.first));
                                    c33 = c30 == null ? null : c30.a(((a7)pair5.second).b);
                                    arr_a71[v32] = (a7)pair5.second;
                                }
                                wb1.n(v68);
                            }
                            else {
                                v69 = v28;
                                v70 = v27;
                                c33 = c30;
                            }
                            String s10 = v29 == 0x6D317620 ? "video/mpeg" : null;
                            float f = 1.0f;
                            int v71 = -1;
                            v34 = v70;
                            s2 = s;
                            List list0 = null;
                            byte[] arr_b5 = null;
                            List list1 = null;
                            String s11 = null;
                            boolean z2 = false;
                            while(true) {
                                if(v68 - v34 < v69) {
                                    wb1.n(v68);
                                    int v72 = wb1.b;
                                    int v73 = wb1.p();
                                    list2 = list1;
                                    if(v73 == 0 && wb1.b - v34 == v69) {
                                        v31 = v69;
                                        break;
                                    }
                                    else {
                                        M7.I("childAtomSize should be positive", v73 > 0);
                                        int v74 = wb1.p();
                                        if(v74 == 0x61766343) {
                                            M7.J(s10 == null);
                                            wb1.n(v72 + 8);
                                            Pb pb0 = Pb.a(wb1);
                                            list3 = pb0.a;
                                            v75 = pb0.b;
                                            if(!z2) {
                                                f = pb0.e;
                                            }
                                            s11 = pb0.f;
                                            s12 = "video/avc";
                                        }
                                        else {
                                            switch(v74) {
                                                case 1685480259: 
                                                case 0x64767643: {
                                                    v80 = v69;
                                                    q q0 = q.a(wb1);
                                                    if(q0 == null) {
                                                        list1 = list2;
                                                    }
                                                    else {
                                                        s11 = q0.b;
                                                        list1 = list2;
                                                        s10 = "video/dolby-vision";
                                                    }
                                                    v68 += v73;
                                                    v69 = v80;
                                                    continue;
                                                }
                                                case 0x68766343: {
                                                    M7.J(s10 == null);
                                                    wb1.n(v72 + 8);
                                                    B7.b b0 = B7.b.c(wb1);
                                                    list3 = (List)b0.c;
                                                    v75 = b0.a;
                                                    s11 = (String)b0.b;
                                                    s12 = "video/hevc";
                                                    break;
                                                }
                                                default: {
                                                    if(v74 == 0x76706343) {
                                                        M7.J(s10 == null);
                                                        s10 = v29 == 0x76703038 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                                                    }
                                                    else {
                                                        switch(v74) {
                                                            case 1681012275: {
                                                                M7.J(s10 == null);
                                                                s10 = "video/3gpp";
                                                                break;
                                                            }
                                                            case 1702061171: {
                                                                M7.J(s10 == null);
                                                                Pair pair6 = i1.a(v72, wb1);
                                                                s10 = (String)pair6.first;
                                                                byte[] arr_b6 = (byte[])pair6.second;
                                                                if(arr_b6 != null) {
                                                                    list0 = h9.l(arr_b6);
                                                                }
                                                                break;
                                                            }
                                                            case 0x70617370: {
                                                                wb1.n(v72 + 8);
                                                                f = ((float)wb1.C()) / ((float)wb1.C());
                                                                list1 = list2;
                                                                z2 = true;
                                                                v68 += v73;
                                                                continue;
                                                            }
                                                            case 0x73743364: {
                                                                int v76 = wb1.z();
                                                                wb1.o(3);
                                                                if(v76 == 0) {
                                                                    int v77 = wb1.z();
                                                                    switch(v77) {
                                                                        case 0: {
                                                                            v71 = 0;
                                                                            break;
                                                                        }
                                                                        case 1: {
                                                                            list1 = list2;
                                                                            v71 = 1;
                                                                            v68 += v73;
                                                                            continue;
                                                                        }
                                                                        case 2: {
                                                                            list1 = list2;
                                                                            v71 = 2;
                                                                            v68 += v73;
                                                                            continue;
                                                                        }
                                                                        default: {
                                                                            if(v77 == 3) {
                                                                                v71 = 3;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                break;
                                                            }
                                                            case 0x73763364: {
                                                                arr_b5 = null;
                                                                for(int v78 = v72 + 8; v78 - v72 < v73; v78 += v79) {
                                                                    wb1.n(v78);
                                                                    int v79 = wb1.p();
                                                                    if(wb1.p() == 0x70726F6A) {
                                                                        arr_b5 = Arrays.copyOfRange(wb1.a, v78, v79 + v78);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                    list1 = list2;
                                                    v68 += v73;
                                                    continue;
                                                }
                                            }
                                        }
                                        s10 = s12;
                                        list0 = list3;
                                        v80 = v69;
                                        v65 = v75;
                                        list1 = list2;
                                        v68 += v73;
                                        v69 = v80;
                                        continue;
                                    }
                                }
                                list2 = list1;
                                v31 = v69;
                                break;
                            }
                            if(s10 != null) {
                                ob ob8 = new ob();
                                ob8.a = Integer.toString(v5);
                                ob8.k = s10;
                                ob8.h = s11;
                                ob8.p = v66;
                                ob8.q = v67;
                                ob8.t = f;
                                ob8.s = v16;
                                ob8.u = arr_b5;
                                ob8.v = v71;
                                ob8.m = list0;
                                ob8.n = c33;
                                ob8.E = list2;
                                u0 = new u(ob8);
                            }
                            v25 = v65;
                            break;
                        }
                        default: {
                            v30 = v23;
                            if(v29 != 1701733217 && v29 != 0x6D703461) {
                                switch(v29) {
                                    case 0x2E6D7032: 
                                    case 0x2E6D7033: 
                                    case 0x4F707573: 
                                    case 0x61632D33: 
                                    case 0x61632D34: 
                                    case 0x616C6163: 
                                    case 0x616C6177: 
                                    case 0x64747363: 
                                    case 0x64747365: 
                                    case 1685353320: 
                                    case 0x6474736C: 
                                    case 1700998451: 
                                    case 0x664C6143: 
                                    case 0x6C70636D: 
                                    case 1935764850: 
                                    case 0x73617762: 
                                    case 0x736F7774: 
                                    case 0x74776F73: 
                                    case 1970037111: {
                                        break;
                                    }
                                    default: {
                                        if(v29 != 1414810956 && v29 != 1954034535 && v29 != 2004251764) {
                                            switch(v29) {
                                                case 0x63616D6D: {
                                                    ob ob0 = new ob();
                                                    ob0.a = Integer.toString(v5);
                                                    ob0.k = "application/x-camera-motion";
                                                    v31 = v28;
                                                    arrayList4 = arrayList1;
                                                    u0 = new u(ob0);
                                                    goto label_124;
                                                }
                                                case 0x6D657474: {
                                                    wb1.n(v27 + 16);
                                                    wb1.x();
                                                    String s1 = wb1.x();
                                                    if(s1 != null) {
                                                        ob ob1 = new ob();
                                                        ob1.a = Integer.toString(v5);
                                                        ob1.k = s1;
                                                        u0 = new u(ob1);
                                                    }
                                                    v31 = v28;
                                                    arrayList4 = arrayList1;
                                                label_124:
                                                    o05 = o01;
                                                    pair1 = pair0;
                                                    s2 = s;
                                                    arr_a71 = arr_a7;
                                                    v32 = v24;
                                                    break;
                                                }
                                                case 0x63363038: 
                                                case 1937010800: {
                                                    break;
                                                }
                                                default: {
                                                    v31 = v28;
                                                    arrayList4 = arrayList1;
                                                    goto label_124;
                                                }
                                            }
                                        }
                                        else {
                                            wb1.n(v27 + 16);
                                            String s3 = "application/ttml+xml";
                                            switch(v29) {
                                                case 1414810956: {
                                                label_143:
                                                    arr_a71 = arr_a7;
                                                    v32 = v24;
                                                    v33 = 0x7FFFFFFFFFFFFFFFL;
                                                    c50 = null;
                                                    break;
                                                }
                                                case 0x63363038: {
                                                    s3 = "application/x-mp4-cea-608";
                                                    arr_a71 = arr_a7;
                                                    v32 = v24;
                                                    v33 = 0x7FFFFFFFFFFFFFFFL;
                                                    c50 = null;
                                                    v26 = 1;
                                                    break;
                                                }
                                                case 1937010800: {
                                                    arr_a71 = arr_a7;
                                                    v32 = v24;
                                                    v33 = 0L;
                                                    c50 = null;
                                                    break;
                                                }
                                                case 1954034535: {
                                                    byte[] arr_b = new byte[v28 - 16];
                                                    wb1.j(arr_b, 0, v28 - 16);
                                                    c50 = h9.l(arr_b);
                                                    s3 = "application/x-quicktime-tx3g";
                                                    arr_a71 = arr_a7;
                                                    v32 = v24;
                                                    v33 = 0x7FFFFFFFFFFFFFFFL;
                                                    break;
                                                }
                                                case 2004251764: {
                                                    s3 = "application/x-mp4-vtt";
                                                    goto label_143;
                                                }
                                                default: {
                                                    throw new IllegalStateException();
                                                }
                                            }
                                            ob ob2 = new ob();
                                            ob2.a = Integer.toString(v5);
                                            ob2.k = s3;
                                            ob2.c = s;
                                            ob2.o = v33;
                                            ob2.m = c50;
                                            v31 = v28;
                                            u0 = new u(ob2);
                                            arrayList4 = arrayList1;
                                            o05 = o01;
                                            pair1 = pair0;
                                            s2 = s;
                                        }
                                        v34 = v27;
                                        break alab1;
                                    }
                                }
                            }
                            arr_a71 = arr_a7;
                            v32 = v24;
                            int[] arr_v = Ja.l;
                            int[] arr_v1 = Ja.j;
                            wb1.n(v27 + 16);
                            if(z1) {
                                v35 = wb1.b();
                                wb1.o(6);
                            }
                            else {
                                wb1.o(8);
                                v35 = 0;
                            }
                            switch(v35) {
                                case 0: 
                                case 1: {
                                    arr_v2 = arr_v;
                                    v39 = wb1.b();
                                    wb1.o(6);
                                    int v40 = wb1.b;
                                    wb1.b = v40 + 2;
                                    int v41 = (wb1.a[v40] & 0xFF) << 8 | wb1.a[v40 + 1] & 0xFF;
                                    wb1.b = v40 + 4;
                                    if(v35 == 1) {
                                        wb1.o(16);
                                    }
                                    v42 = v41;
                                    break;
                                }
                                case 2: {
                                    wb1.o(16);
                                    arr_v2 = arr_v;
                                    v42 = (int)Math.round(Double.longBitsToDouble(wb1.w()));
                                    v39 = wb1.C();
                                    wb1.o(20);
                                    break;
                                }
                                default: {
                                    v36 = v28;
                                    arrayList4 = arrayList1;
                                    v37 = v16;
                                    o05 = o01;
                                    pair1 = pair0;
                                    v38 = v25;
                                    v34 = v27;
                                    goto label_428;
                                }
                            }
                            int v43 = wb1.b;
                            if(v29 == 1701733217) {
                                Pair pair2 = i1.e(wb1, v27, v28);
                                if(pair2 == null) {
                                    c32 = c30;
                                }
                                else {
                                    int v44 = (int)(((Integer)pair2.first));
                                    if(c30 == null) {
                                        v45 = v44;
                                        c31 = null;
                                    }
                                    else {
                                        v45 = v44;
                                        c31 = c30.a(((a7)pair2.second).b);
                                    }
                                    arr_a71[v32] = (a7)pair2.second;
                                    c32 = c31;
                                    v29 = v45;
                                }
                                wb1.n(v43);
                            }
                            else {
                                c32 = c30;
                            }
                            int[] arr_v3 = arr_v1;
                            switch(v29) {
                                case 0x2E6D7032: 
                                case 0x2E6D7033: {
                                    s4 = "audio/mpeg";
                                    v46 = -1;
                                    break;
                                }
                                case 0x4F707573: {
                                    s4 = "audio/opus";
                                    v46 = -1;
                                    break;
                                }
                                case 0x61632D33: {
                                    s4 = "audio/ac3";
                                    v46 = -1;
                                    break;
                                }
                                case 0x61632D34: {
                                    s4 = "audio/ac4";
                                    v46 = -1;
                                    break;
                                }
                                case 0x616C6163: {
                                    s4 = "audio/alac";
                                    v46 = -1;
                                    break;
                                }
                                case 0x616C6177: {
                                    s4 = "audio/g711-alaw";
                                    v46 = -1;
                                    break;
                                }
                                case 0x64747363: {
                                    s4 = "audio/vnd.dts";
                                    v46 = -1;
                                    break;
                                }
                                case 0x64747365: {
                                    s4 = "audio/vnd.dts.hd;profile=lbr";
                                    v46 = -1;
                                    break;
                                }
                                case 1685353320: 
                                case 0x6474736C: {
                                    s4 = "audio/vnd.dts.hd";
                                    v46 = -1;
                                    break;
                                }
                                case 1700998451: {
                                    s4 = "audio/eac3";
                                    v46 = -1;
                                    break;
                                }
                                case 0x664C6143: {
                                    s4 = "audio/flac";
                                    v46 = -1;
                                    break;
                                }
                                case 1935764850: {
                                    s4 = "audio/3gpp";
                                    v46 = -1;
                                    break;
                                }
                                case 0x73617762: {
                                    s4 = "audio/amr-wb";
                                    v46 = -1;
                                    break;
                                }
                                case 0x6C70636D: 
                                case 0x736F7774: {
                                    s4 = "audio/raw";
                                    v46 = 2;
                                    break;
                                }
                                case 0x74776F73: {
                                    v46 = 0x10000000;
                                    s4 = "audio/raw";
                                    break;
                                }
                                case 1970037111: {
                                    s4 = "audio/g711-mlaw";
                                    v46 = -1;
                                    break;
                                }
                                default: {
                                    s4 = null;
                                    v46 = -1;
                                    break;
                                }
                            }
                            arrayList4 = arrayList1;
                            v37 = v16;
                            o05 = o01;
                            pair1 = pair0;
                            v38 = v25;
                            int v47 = v39;
                            int v48 = v42;
                            int v49 = v43;
                            ArrayList arrayList5 = null;
                            String s5 = null;
                            while(v49 - v27 < v28) {
                                wb1.n(v49);
                                int v50 = wb1.p();
                                int v51 = v49;
                                M7.I("childAtomSize should be positive", v50 > 0);
                                int v52 = wb1.p();
                                if(v52 == 1702061171) {
                                label_381:
                                    arrayList6 = arrayList5;
                                    v53 = v27;
                                }
                                else {
                                    if(z1 && v52 == 2002876005) {
                                        arrayList6 = arrayList5;
                                        v53 = v27;
                                        goto label_383;
                                    }
                                    else if(v52 == 1684103987) {
                                        wb1.n(v51 + 8);
                                        String s6 = Integer.toString(v5);
                                        int v54 = arr_v3[(wb1.z() & 0xC0) >> 6];
                                        int v55 = wb1.z();
                                        int v56 = arr_v2[(v55 & 56) >> 3];
                                        if((v55 & 4) != 0) {
                                            ++v56;
                                        }
                                        v53 = v27;
                                        arrayList6 = arrayList5;
                                        ob ob3 = new ob();
                                        ob3.a = s6;
                                        ob3.k = "audio/ac3";
                                        ob3.x = v56;
                                        ob3.y = v54;
                                        ob3.n = c32;
                                        ob3.c = s;
                                        u0 = new u(ob3);
                                        goto label_410;
                                    }
                                    else {
                                        arrayList6 = arrayList5;
                                        v53 = v27;
                                        if(v52 == 0x64656333) {
                                            wb1.n(v51 + 8);
                                            String s7 = Integer.toString(v5);
                                            wb1.o(2);
                                            int v57 = arr_v3[(wb1.z() & 0xC0) >> 6];
                                            int v58 = wb1.z();
                                            int v59 = arr_v2[(v58 & 14) >> 1];
                                            if((v58 & 1) != 0) {
                                                ++v59;
                                            }
                                            if((wb1.z() & 30) >> 1 > 0 && (wb1.z() & 2) != 0) {
                                                v59 += 2;
                                            }
                                            String s8 = wb1.d() <= 0 || (wb1.z() & 1) == 0 ? "audio/eac3" : "audio/eac3-joc";
                                            ob ob4 = new ob();
                                            ob4.a = s7;
                                            ob4.k = s8;
                                            ob4.x = v59;
                                            ob4.y = v57;
                                            ob4.n = c32;
                                            ob4.c = s;
                                            u0 = new u(ob4);
                                            goto label_410;
                                        }
                                        else {
                                            switch(v52) {
                                                case 0x616C6163: {
                                                    byte[] arr_b3 = new byte[v50 - 12];
                                                    wb1.n(v51 + 12);
                                                    wb1.j(arr_b3, 0, v50 - 12);
                                                    wb wb2 = new wb(arr_b3);
                                                    wb2.n(9);
                                                    int v61 = wb2.z();
                                                    wb2.n(20);
                                                    Pair pair3 = Pair.create(wb2.C(), v61);
                                                    int v62 = (int)(((Integer)pair3.first));
                                                    v47 = (int)(((Integer)pair3.second));
                                                    arrayList5 = h9.l(arr_b3);
                                                    v48 = v62;
                                                    goto label_411;
                                                }
                                                case 0x644F7073: {
                                                    byte[] arr_b1 = Arrays.copyOf(i1.a, i1.a.length + (v50 - 8));
                                                    wb1.n(v51 + 8);
                                                    wb1.j(arr_b1, i1.a.length, v50 - 8);
                                                    arrayList5 = M7.n(arr_b1);
                                                    goto label_411;
                                                }
                                                case 1684103988: {
                                                    wb1.n(v51 + 8);
                                                    wb1.o(1);
                                                    int v60 = (wb1.z() & 0x20) >> 5 == 1 ? 48000 : 44100;
                                                    ob ob5 = new ob();
                                                    ob5.a = Integer.toString(v5);
                                                    ob5.k = "audio/ac4";
                                                    ob5.x = 2;
                                                    ob5.y = v60;
                                                    ob5.n = c32;
                                                    ob5.c = s;
                                                    u0 = new u(ob5);
                                                    goto label_410;
                                                }
                                                case 1684305011: {
                                                    ob ob6 = new ob();
                                                    ob6.a = Integer.toString(v5);
                                                    ob6.k = s4;
                                                    ob6.x = v47;
                                                    ob6.y = v48;
                                                    ob6.n = c32;
                                                    ob6.c = s;
                                                    u0 = new u(ob6);
                                                    goto label_410;
                                                }
                                                case 0x64664C61: {
                                                    byte[] arr_b2 = new byte[v50 - 8];
                                                    arr_b2[0] = 102;
                                                    arr_b2[1] = 76;
                                                    arr_b2[2] = 97;
                                                    arr_b2[3] = 67;
                                                    wb1.n(v51 + 12);
                                                    wb1.j(arr_b2, 4, v50 - 12);
                                                    arrayList5 = h9.l(arr_b2);
                                                    goto label_411;
                                                }
                                                default: {
                                                    goto label_410;
                                                }
                                            }
                                        }
                                    }
                                    goto label_381;
                                }
                            label_383:
                                if(v52 == 1702061171) {
                                    v63 = v51;
                                }
                                else {
                                    v63 = wb1.b;
                                    while(true) {
                                        if(v63 - v51 < v50) {
                                            wb1.n(v63);
                                            int v64 = wb1.p();
                                            M7.I("childAtomSize should be positive", v64 > 0);
                                            if(wb1.p() == 1702061171) {
                                                break;
                                            }
                                            else {
                                                v63 += v64;
                                                continue;
                                            }
                                        }
                                        v63 = -1;
                                        break;
                                    }
                                }
                                if(v63 != -1) {
                                    Pair pair4 = i1.a(v63, wb1);
                                    String s9 = (String)pair4.first;
                                    byte[] arr_b4 = (byte[])pair4.second;
                                    if(arr_b4 == null) {
                                        s4 = s9;
                                    }
                                    else {
                                        if("audio/mp4a-latm".equals(s9)) {
                                            h1 h10 = Ja.l(new N(arr_b4, arr_b4.length, 6, 0), false);
                                            v48 = h10.a;
                                            s5 = (String)h10.c;
                                            v47 = h10.b;
                                        }
                                        arrayList5 = h9.l(arr_b4);
                                        s4 = s9;
                                        goto label_411;
                                    }
                                }
                            label_410:
                                arrayList5 = arrayList6;
                            label_411:
                                v49 = v51 + v50;
                                v27 = v53;
                            }
                            v36 = v28;
                            v34 = v27;
                            if(u0 == null && s4 != null) {
                                ob ob7 = new ob();
                                ob7.a = Integer.toString(v5);
                                ob7.k = s4;
                                ob7.h = s5;
                                ob7.x = v47;
                                ob7.y = v48;
                                ob7.z = v46;
                                ob7.m = arrayList5;
                                ob7.n = c32;
                                ob7.c = s;
                                u0 = new u(ob7);
                            }
                        label_428:
                            s2 = s;
                            v25 = v38;
                            v16 = v37;
                            v31 = v36;
                        }
                    }
                    wb1.n(v34 + v31);
                    v24 = v32 + 1;
                    arr_a7 = arr_a71;
                    s = s2;
                    arrayList1 = arrayList4;
                    pair0 = pair1;
                    o01 = o05;
                    v23 = v30;
                }
                arrayList3 = arrayList1;
                v2 = v1;
                if(z) {
                    arr_v8 = null;
                    arr_v7 = null;
                }
                else {
                    o0 o06 = o01.o(1701082227);
                    if(o06 != null) {
                        p0 p05 = o06.p(1701606260);
                        if(p05 == null) {
                            pair7 = null;
                        }
                        else {
                            wb wb3 = p05.c;
                            wb3.n(8);
                            int v81 = b.e(wb3.p());
                            int v82 = wb3.C();
                            long[] arr_v4 = new long[v82];
                            long[] arr_v5 = new long[v82];
                            for(int v83 = 0; v83 < v82; ++v83) {
                                arr_v4[v83] = v81 == 1 ? wb3.a() : wb3.A();
                                arr_v5[v83] = v81 == 1 ? wb3.w() : ((long)wb3.p());
                                int v84 = wb3.b;
                                wb3.b = v84 + 2;
                                if(((short)(wb3.a[v84 + 1] & 0xFF | (wb3.a[v84] & 0xFF) << 8)) != 1) {
                                    throw new IllegalArgumentException("Unsupported media rate.");
                                }
                                wb3.o(2);
                            }
                            pair7 = Pair.create(arr_v4, arr_v5);
                        }
                        if(pair7 != null) {
                            long[] arr_v6 = (long[])pair7.first;
                            arr_v7 = (long[])pair7.second;
                            arr_v8 = arr_v6;
                        }
                    }
                }
                d60 = u0 == null ? null : new D6(v5, v3, ((long)(((Long)pair0.first))), v19, v9, u0, v26, arr_a7, v25, arr_v8, arr_v7);
            label_631:
                D6 d61 = (D6)da0.a(d60);
                if(d61 == null) {
                    arrayList2 = arrayList3;
                }
                else {
                    o0 o07 = o01.o(0x6D646961);
                    o07.getClass();
                    o0 o08 = o07.o(1835626086);
                    o08.getClass();
                    o0 o09 = o08.o(1937007212);
                    o09.getClass();
                    arrayList2 = arrayList3;
                    arrayList2.add(i1.b(d61, o09, ka0));
                }
            }
            else {
                arrayList2 = arrayList1;
                v2 = v1;
            }
            v1 = v2 + 1;
            arrayList1 = arrayList2;
        }
        return arrayList1;
    }

    public static int d(wb wb0) {
        int v = wb0.z();
        int v1;
        for(v1 = v & 0x7F; (v & 0x80) == 0x80; v1 = v1 << 7 | v & 0x7F) {
            v = wb0.z();
        }
        return v1;
    }

    public static Pair e(wb wb0, int v, int v1) {
        byte[] arr_b3;
        int v14;
        int v13;
        boolean z;
        for(int v2 = wb0.b; v2 - v < v1; v2 += v3) {
            wb0.n(v2);
            int v3 = wb0.p();
            M7.I("childAtomSize should be positive", v3 > 0);
            if(wb0.p() == 0x73696E66) {
                int v4 = v2 + 8;
                int v5 = -1;
                int v6 = 0;
                Integer integer0 = null;
                String s = null;
                while(v4 - v2 < v3) {
                    wb0.n(v4);
                    int v7 = wb0.p();
                    int v8 = wb0.p();
                    if(v8 == 0x66726D61) {
                        integer0 = wb0.p();
                    }
                    else {
                        switch(v8) {
                            case 0x73636869: {
                                v5 = v4;
                                v6 = v7;
                                break;
                            }
                            case 0x7363686D: {
                                wb0.o(4);
                                s = wb0.g(4, b9.c);
                            }
                        }
                    }
                    v4 += v7;
                }
                a7 a70 = null;
                for(int v9 = v5 + 8; v9 - v5 < v6; v9 += v10) {
                    wb0.n(v9);
                    int v10 = wb0.p();
                    int v11 = wb0.p();
                    if(v11 == 1970628964) {
                        byte[] arr_b = new byte[16];
                        wb0.j(arr_b, 0, 16);
                        if(Arrays.equals(arr_b, i1.b)) {
                            z = true;
                        }
                    }
                    else {
                        z = false;
                    }
                    if(v11 == 1952804451 || z) {
                        int v12 = b.e(wb0.p());
                        wb0.o(1);
                        if(v12 == 0) {
                            wb0.o(1);
                            v13 = 0;
                            v14 = 0;
                        }
                        else {
                            int v15 = wb0.z();
                            v14 = v15 & 15;
                            v13 = (v15 & 0xF0) >> 4;
                        }
                        boolean z1 = wb0.z() == 1;
                        int v16 = wb0.z();
                        byte[] arr_b1 = new byte[16];
                        wb0.j(arr_b1, 0, 16);
                        if(!z1 || v16 != 0) {
                            arr_b3 = null;
                        }
                        else {
                            int v17 = wb0.z();
                            byte[] arr_b2 = new byte[v17];
                            wb0.j(arr_b2, 0, v17);
                            arr_b3 = arr_b2;
                        }
                        a70 = new a7(z1, s, v16, arr_b1, v13, v14, arr_b3);
                        break;
                    }
                }
                Pair pair0 = integer0 == null || a70 == null ? null : Pair.create(integer0, a70);
                if(pair0 != null) {
                    return pair0;
                }
            }
        }
        return null;
    }
}

