package i.n.i.b.a.s.e;

import B3.v;
import U4.x;
import V3.o;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import x9.a;

public final class q3 implements q4 {
    public int A;
    public int B;
    public int C;
    public boolean D;
    public U5 E;
    public ie[] F;
    public ie[] G;
    public long H;
    public long I;
    public n3 J;
    public int K;
    public static final byte[] L;
    public static final u M;
    public static final byte[] N;
    public final int a;
    public final D6 b;
    public final List c;
    public final SparseArray d;
    public final wb e;
    public final wb f;
    public final wb g;
    public final byte[] h;
    public final wb i;
    public final r6 j;
    public final a k;
    public final wb l;
    public final ArrayDeque m;
    public final ArrayDeque n;
    public final ie o;
    public int p;
    public int q;
    public long r;
    public int s;
    public wb t;
    public long u;
    public int v;
    public long w;
    public long x;
    public long y;
    public p3 z;

    static {
        q3.L = new byte[]{-94, 57, 0x4F, 82, 90, -101, 0x4F, 20, -94, 68, 108, 66, 0x7C, 100, (byte)0x8D, -12};
        ob ob0 = new ob();
        ob0.k = "application/x-emsg";
        q3.M = new u(ob0);
        q3.N = new byte[]{(byte)0xD0, (byte)0x8A, 0x4F, 24, 16, -13, 74, (byte)0x82, -74, -56, 50, -40, -85, (byte)0xA1, (byte)0x83, -45};
    }

    public q3(int v) {
        this(v, null, null, Collections.EMPTY_LIST, null);
    }

    public q3(int v, r6 r60, D6 d60, List list0, ie ie0) {
        this.a = v;
        this.j = r60;
        this.b = d60;
        this.c = Collections.unmodifiableList(list0);
        this.o = ie0;
        this.k = new a();
        this.l = new wb(16);
        this.e = new wb(Ja.u);
        this.f = new wb(5);
        this.g = new wb(1, false);
        byte[] arr_b = new byte[16];
        this.h = arr_b;
        this.i = new wb(arr_b);
        this.m = new ArrayDeque();
        this.n = new ArrayDeque();
        this.d = new SparseArray();
        this.x = 0x8000000000000001L;
        this.w = 0x8000000000000001L;
        this.y = 0x8000000000000001L;
        this.E = U5.J;
        this.F = new ie[0];
        this.G = new ie[0];
        this.K = 1;
        this.H = -1L;
        this.I = -1L;
        this.J = null;
    }

    public q3(D6 d60) {
        this(0x1003, null, d60, Collections.EMPTY_LIST, null);
    }

    public static c3 a(List list0) {
        int v = list0.size();
        List list1 = null;
        for(int v1 = 0; v1 < v; ++v1) {
            p0 p00 = (p0)list0.get(v1);
            int v2 = p00.b;
            wb wb0 = p00.c;
            if(v2 == 0x70737368) {
                if(list1 == null) {
                    list1 = new ArrayList();
                }
                byte[] arr_b = wb0.a;
                o o0 = Ja.S(arr_b);
                UUID uUID0 = o0 == null ? null : o0.a;
                if(uUID0 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                }
                else {
                    ((ArrayList)list1).add(new b(uUID0, null, "video/mp4", arr_b));
                }
            }
            else if(v2 == 1970628964) {
                try {
                    if(list1 == null) {
                        list1 = new ArrayList();
                    }
                    wb wb1 = new wb(wb0.a);
                    wb1.p();
                    wb1.j(new byte[4], 0, 4);
                    byte[] arr_b1 = new byte[16];
                    wb1.j(arr_b1, 0, 16);
                    if(Arrays.equals(arr_b1, q3.N)) {
                        wb1.o(4);
                        UUID uUID1 = new UUID(wb1.w(), wb1.w());
                        int v3 = wb1.p();
                        byte[] arr_b2 = new byte[v3];
                        wb1.j(arr_b2, 0, v3);
                        ((ArrayList)list1).add(new b(uUID1, null, "video/mp4", arr_b2));
                        return list1 == null ? null : new c3(null, false, ((b[])list1.toArray(new b[0])));
                    }
                }
                catch(Exception exception0) {
                    exception0.printStackTrace();
                }
            }
        }
        return list1 == null ? null : new c3(null, false, ((b[])list1.toArray(new b[0])));
    }

    public static void b(wb wb0, int v, w7 w70) {
        wb0.n(v + 8);
        int v1 = wb0.p();
        if((v1 & 1) != 0) {
            throw new H4("Overriding TrackEncryptionBox parameters is unsupported.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
        }
        int v2 = wb0.C();
        if(v2 == 0) {
            Arrays.fill(w70.m, 0, w70.e, false);
            return;
        }
        wb wb1 = w70.o;
        if(v2 == w70.e) {
            Arrays.fill(w70.m, 0, v2, (v1 & 2) != 0);
            wb1.l(wb0.d());
            w70.l = true;
            w70.p = true;
            wb0.j(wb1.a, 0, wb1.c);
            wb1.n(0);
            w70.p = false;
            return;
        }
        StringBuilder stringBuilder0 = x.n(v2, "Senc sample count ", " is different from fragment sample count");
        stringBuilder0.append(w70.e);
        throw new H4(stringBuilder0.toString());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    }

    public final void c(long v) {
        byte[] arr_b1;
        int v70;
        SparseArray sparseArray5;
        int v64;
        SparseArray sparseArray4;
        int v63;
        int v61;
        int v60;
        b2 b24;
        int v59;
        int v58;
        int v57;
        int v56;
        boolean z2;
        int v48;
        int v38;
        ArrayList arrayList8;
        ArrayList arrayList7;
        int v37;
        SparseArray sparseArray3;
        int v22;
        ArrayList arrayList6;
        ArrayList arrayList5;
        int v21;
        int v20;
        int v16;
        int v15;
        b2 b21;
        b2 b20;
        c3 c31;
        while(true) {
            ArrayDeque arrayDeque0 = this.m;
            if(arrayDeque0.isEmpty() || ((o0)arrayDeque0.peek()).c != v) {
                break;
            }
            o0 o00 = (o0)arrayDeque0.pop();
            int v1 = o00.b;
            ArrayList arrayList0 = o00.e;
            ArrayList arrayList1 = o00.d;
            int v2 = this.a;
            SparseArray sparseArray0 = this.d;
            if(v1 == 0x6D6F6F76) {
                M7.I("Unexpected moov box.", this.b == null);
                c3 c30 = q3.a(arrayList1);
                o0 o01 = o00.o(0x6D766578);
                o01.getClass();
                ArrayList arrayList2 = o01.d;
                SparseArray sparseArray1 = new SparseArray();
                int v3 = arrayList2.size();
                int v4 = 0;
                long v5 = 0x8000000000000001L;
                while(v4 < v3) {
                    Object object0 = arrayList2.get(v4);
                    int v6 = ((p0)object0).b;
                    wb wb0 = ((p0)object0).c;
                    if(v6 == 0x74726578) {
                        wb0.n(12);
                        c31 = c30;
                        Pair pair0 = Pair.create(wb0.p(), new b2(wb0.p() - 1, wb0.p(), wb0.p(), wb0.p()));
                        sparseArray1.put(((int)(((Integer)pair0.first))), ((b2)pair0.second));
                    }
                    else {
                        c31 = c30;
                        if(v6 == 1835362404) {
                            wb0.n(8);
                            v5 = H4.b.e(wb0.p()) == 0 ? wb0.A() : wb0.a();
                        }
                    }
                    ++v4;
                    c30 = c31;
                }
                SparseArray sparseArray2 = sparseArray1;
                ArrayList arrayList3 = i1.c(o00, new Ka(), v5, c30, (v2 & 16) != 0, false, new com.iloen.melon.fragments.radio.a(this, 16));
                int v7 = arrayList3.size();
                if(sparseArray0.size() == 0) {
                    for(int v8 = 0; v8 < v7; ++v8) {
                        U7 u70 = (U7)arrayList3.get(v8);
                        D6 d60 = u70.a;
                        int v9 = d60.a;
                        ie ie0 = this.E.i(v8, d60.b);
                        if(sparseArray2.size() == 1) {
                            b20 = (b2)sparseArray2.valueAt(0);
                        }
                        else {
                            b20 = (b2)sparseArray2.get(v9);
                            b20.getClass();
                        }
                        sparseArray0.put(v9, new p3(ie0, u70, b20));
                        this.x = Math.max(this.x, d60.e);
                    }
                    this.E.b();
                }
                else {
                    M7.J(sparseArray0.size() == v7);
                    for(int v10 = 0; v10 < v7; ++v10) {
                        U7 u71 = (U7)arrayList3.get(v10);
                        p3 p30 = (p3)sparseArray0.get(u71.a.a);
                        int v11 = u71.a.a;
                        if(sparseArray2.size() == 1) {
                            b21 = (b2)sparseArray2.valueAt(0);
                        }
                        else {
                            b21 = (b2)sparseArray2.get(v11);
                            b21.getClass();
                        }
                        p30.d = u71;
                        p30.e = b21;
                        p30.a.a(u71.a.f);
                        p30.d();
                    }
                }
            }
            else if(v1 == 0x6D6F6F66) {
                int v12 = arrayList0.size();
                int v13 = 0;
                while(v13 < v12) {
                    o0 o02 = (o0)arrayList0.get(v13);
                    if(o02.b == 1953653094) {
                        p0 p00 = o02.p(0x74666864);
                        ArrayList arrayList4 = o02.d;
                        p00.getClass();
                        wb wb1 = p00.c;
                        wb1.n(8);
                        int v14 = wb1.p();
                        p3 p31 = sparseArray0.size() == 1 ? ((p3)sparseArray0.valueAt(0)) : ((p3)sparseArray0.get(wb1.p()));
                        if(p31 == null) {
                            v15 = v12;
                            v16 = v2;
                            p31 = null;
                        }
                        else {
                            w7 w70 = p31.b;
                            if((v14 & 1) == 0) {
                                v16 = v2;
                            }
                            else {
                                v16 = v2;
                                long v17 = wb1.a();
                                w70.b = v17;
                                w70.c = v17;
                            }
                            b2 b22 = p31.e;
                            int v18 = (v14 & 2) == 0 ? b22.a : wb1.p() - 1;
                            int v19 = (v14 & 8) == 0 ? b22.b : wb1.p();
                            if((v14 & 16) == 0) {
                                v15 = v12;
                                v20 = b22.c;
                            }
                            else {
                                v15 = v12;
                                v20 = wb1.p();
                            }
                            w70.a = new b2(v18, v19, v20, ((v14 & 0x20) == 0 ? b22.d : wb1.p()));
                        }
                        if(p31 == null) {
                            v21 = v13;
                            arrayList5 = arrayList0;
                            arrayList6 = arrayList1;
                            v22 = v16;
                            sparseArray3 = sparseArray0;
                        }
                        else {
                            w7 w71 = p31.b;
                            long v23 = w71.q;
                            boolean z = w71.r;
                            p31.d();
                            p31.l = true;
                            p0 p01 = o02.p(0x74666474);
                            if(p01 == null || (v16 & 2) != 0) {
                                w71.q = v23;
                                w71.r = z;
                            }
                            else {
                                p01.c.n(8);
                                long v24 = H4.b.e(p01.c.p()) == 1 ? p01.c.a() : p01.c.A();
                                w71.q = v24;
                                w71.r = true;
                                p31.m = v24;
                            }
                            int v25 = arrayList4.size();
                            int v27 = 0;
                            int v28 = 0;
                            for(int v26 = 0; v26 < v25; ++v26) {
                                p0 p02 = (p0)arrayList4.get(v26);
                                if(p02.b == 0x7472756E) {
                                    p02.c.n(12);
                                    int v29 = p02.c.C();
                                    if(v29 > 0) {
                                        v28 += v29;
                                        ++v27;
                                    }
                                }
                            }
                            v21 = v13;
                            p31.h = 0;
                            p31.g = 0;
                            p31.f = 0;
                            w71.d = v27;
                            w71.e = v28;
                            if(w71.g.length < v27) {
                                w71.f = new long[v27];
                                w71.g = new int[v27];
                            }
                            if(w71.h.length < v28) {
                                int v30 = v28 * 0x7D / 100;
                                w71.h = new int[v30];
                                w71.i = new int[v30];
                                w71.j = new long[v30];
                                w71.k = new boolean[v30];
                                w71.m = new boolean[v30];
                            }
                            int v31 = 0;
                            int v32 = 0;
                            int v33 = 0;
                            while(true) {
                                long v34 = 0L;
                                if(v31 >= v25) {
                                    break;
                                }
                                p0 p03 = (p0)arrayList4.get(v31);
                                if(p03.b == 0x7472756E) {
                                    int v35 = v32 + 1;
                                    wb wb2 = p03.c;
                                    wb2.n(8);
                                    int v36 = wb2.p();
                                    v37 = v31;
                                    D6 d61 = p31.d.a;
                                    arrayList7 = arrayList0;
                                    b2 b23 = w71.a;
                                    arrayList8 = arrayList1;
                                    int[] arr_v = w71.g;
                                    arr_v[v32] = wb2.C();
                                    long[] arr_v1 = w71.f;
                                    v38 = v25;
                                    long v39 = w71.b;
                                    arr_v1[v32] = v39;
                                    if((v36 & 1) != 0) {
                                        arr_v1[v32] = v39 + ((long)wb2.p());
                                    }
                                    int v40 = (v36 & 4) == 0 ? 0 : 1;
                                    int v41 = v40;
                                    int v42 = (v36 & 0x100) == 0 ? 0 : 1;
                                    int v43 = (v36 & 0x200) == 0 ? 0 : 1;
                                    int v44 = (v36 & 0x800) == 0 ? 0 : 1;
                                    int v45 = (v36 & 0x400) == 0 ? 0 : 1;
                                    int v46 = v40 == 0 ? b23.d : wb2.p();
                                    int v47 = d61.b;
                                    if(d61.h == null || d61.h.length != 1 || d61.h[0] != 0L) {
                                        v48 = v33;
                                    }
                                    else {
                                        v48 = v33;
                                        v34 = L7.C(d61.i[0], 1000000L, d61.c);
                                    }
                                    int[] arr_v2 = w71.h;
                                    int[] arr_v3 = w71.i;
                                    long[] arr_v4 = w71.j;
                                    boolean[] arr_z = w71.k;
                                    int v49 = v47 != 2 || (v16 & 1) == 0 ? 0 : 1;
                                    boolean z1 = (v16 & 0x1000) != 0;
                                    int v50 = v48 + w71.g[v32];
                                    int[] arr_v5 = arr_v2;
                                    int[] arr_v6 = arr_v3;
                                    long v51 = d61.c;
                                    int v52 = v47 == 2 ? 1 : 0;
                                    long v53 = w71.q;
                                    int v54 = v48;
                                    int v55 = 0;
                                    while(v54 < v50) {
                                        if(v42 == 0) {
                                            z2 = v52;
                                            v56 = b23.b;
                                        }
                                        else {
                                            z2 = v52;
                                            v56 = wb2.p();
                                        }
                                        if(v56 < 0) {
                                            throw new H4("Unexpected negative value: " + v56);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                        }
                                        if(v43 == 0) {
                                            v57 = v54;
                                            v58 = b23.c;
                                        }
                                        else {
                                            v57 = v54;
                                            v58 = wb2.p();
                                        }
                                        if(v58 < 0) {
                                            throw new H4("Unexpected negative value: " + v58);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                        }
                                        if(v45 == 0) {
                                            v59 = v57 != 0 || v41 == 0 ? b23.d : v46;
                                        }
                                        else {
                                            v59 = wb2.p();
                                        }
                                        if(v44 == 0) {
                                            b24 = b23;
                                            v60 = 0;
                                            v61 = v35;
                                            arr_v6[v57] = 0;
                                        }
                                        else {
                                            b24 = b23;
                                            v60 = v44;
                                            v61 = v35;
                                            arr_v6[v57] = (int)(((long)wb2.p()) * 1000000L / v51);
                                        }
                                        long v62 = L7.C(v53, 1000000L, v51) - v34;
                                        arr_v4[v57] = v62;
                                        if(w71.r) {
                                            v63 = v16;
                                            sparseArray4 = sparseArray0;
                                        }
                                        else {
                                            v63 = v16;
                                            sparseArray4 = sparseArray0;
                                            arr_v4[v57] = v62 + p31.d.h;
                                        }
                                        arr_v5[v57] = v58;
                                        boolean z3 = (v59 >> 16 & 1) == 0 && (v49 == 0 || v57 == 0);
                                        arr_z[v57] = z3;
                                        v55 |= z3;
                                        v53 += (long)v56;
                                        v52 = z2 & z3;
                                        v54 = v57 + 1;
                                        sparseArray0 = sparseArray4;
                                        v16 = v63;
                                        b23 = b24;
                                        v35 = v61;
                                        v44 = v60;
                                    }
                                    v64 = v16;
                                    sparseArray5 = sparseArray0;
                                    if(v47 == 2 && v52 != 0) {
                                        w71.s = true;
                                    }
                                    if(z1 && v55 == 0) {
                                        for(int v65 = v48; v65 < v50; ++v65) {
                                            arr_z[v65] |= v47 != 2 || v65 == 0;
                                        }
                                    }
                                    w71.q = v53;
                                    v33 = v50;
                                    v32 = v35;
                                }
                                else {
                                    v37 = v31;
                                    arrayList7 = arrayList0;
                                    arrayList8 = arrayList1;
                                    v38 = v25;
                                    v64 = v16;
                                    sparseArray5 = sparseArray0;
                                }
                                v31 = v37 + 1;
                                arrayList0 = arrayList7;
                                arrayList1 = arrayList8;
                                v25 = v38;
                                sparseArray0 = sparseArray5;
                                v16 = v64;
                            }
                            arrayList5 = arrayList0;
                            arrayList6 = arrayList1;
                            v22 = v16;
                            sparseArray3 = sparseArray0;
                            D6 d62 = p31.d.a;
                            b2 b25 = w71.a;
                            b25.getClass();
                            a7 a70 = d62.k == null ? null : d62.k[b25.a];
                            p0 p04 = o02.p(0x7361697A);
                            if(p04 != null) {
                                a70.getClass();
                                wb wb3 = p04.c;
                                int v66 = a70.d;
                                wb3.n(8);
                                if((wb3.p() & 1) == 1) {
                                    wb3.o(8);
                                }
                                int v67 = wb3.z();
                                int v68 = wb3.C();
                                if(v68 > w71.e) {
                                    goto label_331;
                                }
                                if(v67 == 0) {
                                    boolean[] arr_z1 = w71.m;
                                    v70 = 0;
                                    for(int v69 = 0; v69 < v68; ++v69) {
                                        int v71 = wb3.z();
                                        v70 += v71;
                                        arr_z1[v69] = v71 > v66;
                                    }
                                }
                                else {
                                    v70 = v67 * v68;
                                    Arrays.fill(w71.m, 0, v68, v67 > v66);
                                }
                                Arrays.fill(w71.m, v68, w71.e, false);
                                if(v70 > 0) {
                                    w71.o.l(v70);
                                    w71.l = true;
                                    w71.p = true;
                                    goto label_334;
                                label_331:
                                    StringBuilder stringBuilder0 = x.n(v68, "Saiz sample count ", " is greater than fragment sample count");
                                    stringBuilder0.append(w71.e);
                                    throw new H4(stringBuilder0.toString());  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                }
                            }
                        label_334:
                            p0 p05 = o02.p(0x7361696F);
                            if(p05 != null) {
                                wb wb4 = p05.c;
                                wb4.n(8);
                                int v72 = wb4.p();
                                if((v72 & 1) == 1) {
                                    wb4.o(8);
                                }
                                int v73 = wb4.C();
                                if(v73 != 1) {
                                    throw new H4("Unexpected saio entry count: " + v73);  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                }
                                w71.c += ((v72 >> 24 & 0xFF) == 0 ? wb4.A() : wb4.a());
                            }
                            p0 p06 = o02.p(1936027235);
                            if(p06 != null) {
                                q3.b(p06.c, 0, w71);
                            }
                            String s = a70 == null ? null : a70.b;
                            wb wb5 = null;
                            wb wb6 = null;
                            for(int v74 = 0; v74 < arrayList4.size(); ++v74) {
                                p0 p07 = (p0)arrayList4.get(v74);
                                wb wb7 = p07.c;
                                int v75 = p07.b;
                                if(v75 == 0x73626770) {
                                    wb7.n(12);
                                    if(wb7.p() == 1936025959) {
                                        wb5 = wb7;
                                    }
                                }
                                else if(v75 == 0x73677064) {
                                    wb7.n(12);
                                    if(wb7.p() == 1936025959) {
                                        wb6 = wb7;
                                    }
                                }
                            }
                            if(wb5 != null && wb6 != null) {
                                wb5.n(8);
                                int v76 = H4.b.e(wb5.p());
                                wb5.o(4);
                                if(v76 == 1) {
                                    wb5.o(4);
                                }
                                if(wb5.p() != 1) {
                                    throw new H4("Entry count in sbgp != 1 (unsupported).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                }
                                wb6.n(8);
                                int v77 = H4.b.e(wb6.p());
                                wb6.o(4);
                                if(v77 == 1) {
                                    if(wb6.A() == 0L) {
                                        throw new H4("Variable length description in sgpd found (unsupported)");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                    }
                                }
                                else if(v77 >= 2) {
                                    wb6.o(4);
                                }
                                if(wb6.A() != 1L) {
                                    throw new H4("Entry count in sgpd != 1 (unsupported).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                }
                                wb6.o(1);
                                int v78 = wb6.z();
                                int v79 = (v78 & 0xF0) >> 4;
                                int v80 = v78 & 15;
                                if(wb6.z() == 1) {
                                    int v81 = wb6.z();
                                    byte[] arr_b = new byte[16];
                                    wb6.j(arr_b, 0, 16);
                                    if(v81 == 0) {
                                        int v82 = wb6.z();
                                        arr_b1 = new byte[v82];
                                        wb6.j(arr_b1, 0, v82);
                                    }
                                    else {
                                        arr_b1 = null;
                                    }
                                    w71.l = true;
                                    w71.n = new a7(true, s, v81, arr_b, v79, v80, arr_b1);
                                }
                            }
                            int v83 = arrayList4.size();
                            for(int v84 = 0; v84 < v83; ++v84) {
                                p0 p08 = (p0)arrayList4.get(v84);
                                if(p08.b == 1970628964) {
                                    wb wb8 = p08.c;
                                    wb8.n(8);
                                    wb8.j(this.h, 0, 16);
                                    if(Arrays.equals(this.h, q3.L)) {
                                        q3.b(wb8, 16, w71);
                                    }
                                }
                            }
                        }
                    }
                    else {
                        v15 = v12;
                        v21 = v13;
                        arrayList5 = arrayList0;
                        arrayList6 = arrayList1;
                        v22 = v2;
                        sparseArray3 = sparseArray0;
                    }
                    v13 = v21 + 1;
                    v12 = v15;
                    arrayList0 = arrayList5;
                    arrayList1 = arrayList6;
                    sparseArray0 = sparseArray3;
                    v2 = v22;
                }
                SparseArray sparseArray6 = sparseArray0;
                c3 c32 = q3.a(arrayList1);
                if(c32 != null) {
                    int v85 = sparseArray6.size();
                    for(int v86 = 0; v86 < v85; ++v86) {
                        p3 p32 = (p3)sparseArray6.valueAt(v86);
                        a7[] arr_a7 = p32.d.a.k;
                        a7 a71 = arr_a7 == null ? null : arr_a7[p32.b.a.a];
                        c3 c33 = c32.a((a71 == null ? null : a71.b));
                        ob ob0 = p32.d.a.f.a();
                        ob0.n = c33;
                        u u0 = new u(ob0);
                        p32.a.a(u0);
                    }
                }
                SparseArray sparseArray7 = sparseArray6;
                if(this.w == 0x8000000000000001L) {
                    continue;
                }
                int v87 = sparseArray7.size();
                for(int v88 = 0; v88 < v87; ++v88) {
                    p3 p33 = (p3)sparseArray7.valueAt(v88);
                    long v89 = this.w;
                    int v90 = p33.f;
                    w7 w72 = p33.b;
                    if(w72.s) {
                        p33.i = 0;
                    }
                    else {
                        while(v90 < w72.e && w72.j[v90] + ((long)w72.i[v90]) < v89) {
                            if(w72.k[v90]) {
                                p33.i = v90;
                            }
                            ++v90;
                        }
                    }
                }
                this.w = 0x8000000000000001L;
            }
            else if(!arrayDeque0.isEmpty()) {
                ((o0)arrayDeque0.peek()).e.add(o00);
            }
            else if(o00.b == 1835430497 && (this.K == 1 || this.K == 2)) {
                n3 n30 = this.J;
                if(n30 != null) {
                    this.E.t(n30);
                    this.K = 4;
                }
            }
        }
        this.p = 0;
        this.s = 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void d(long v, long v1) {
        SparseArray sparseArray0 = this.d;
        int v2 = sparseArray0.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            ((p3)sparseArray0.valueAt(v3)).d();
        }
        this.n.clear();
        this.v = 0;
        this.w = v1;
        this.m.clear();
        this.p = 0;
        this.s = 0;
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final boolean e(i5 i50) {
        return Ja.F(i50, true, false);
    }

    // This method was un-flattened
    @Override  // i.n.i.b.a.s.e.q4
    public final int f(i5 i50, v v0) {
        int v27;
        r6 r62;
        int v22;
        byte[] arr_b1;
        wb wb5;
        boolean z1;
        int v21;
        r6 r61;
        ArrayDeque arrayDeque2;
        long v53;
        long v52;
        long v41;
        long v40;
        long v39;
        long v38;
        String s2;
        String s1;
        while(true) {
            int v1 = this.p;
            ArrayDeque arrayDeque0 = this.m;
            SparseArray sparseArray0 = this.d;
            if(v1 != 0) {
                long v2 = 0x7FFFFFFFFFFFFFFFL;
                ArrayDeque arrayDeque1 = this.n;
                r6 r60 = this.j;
                switch(v1) {
                    case 1: {
                        int v30 = ((int)this.r) - this.s;
                        wb wb6 = this.t;
                        if(wb6 == null) {
                            ((D2)i50).g(v30);
                        }
                        else {
                            ((D2)i50).f(wb6.a, 8, v30, false);
                            int v31 = this.q;
                            p0 p00 = new p0(v31, wb6);
                            long v32 = ((D2)i50).d;
                            if(v31 != 1952871009) {
                                if(arrayDeque0.isEmpty()) {
                                alab1:
                                    switch(v31) {
                                        case 1701671783: {
                                            if(this.F.length != 0) {
                                                wb6.n(8);
                                                int v34 = H4.b.e(wb6.p());
                                                switch(v34) {
                                                    case 0: {
                                                        s1 = wb6.x();
                                                        s1.getClass();
                                                        s2 = wb6.x();
                                                        s2.getClass();
                                                        long v35 = wb6.A();
                                                        long v36 = L7.C(wb6.A(), 1000000L, v35);
                                                        long v37 = this.y == 0x8000000000000001L ? 0x8000000000000001L : this.y + v36;
                                                        v38 = L7.C(wb6.A(), 1000L, v35);
                                                        v39 = wb6.A();
                                                        v40 = v36;
                                                        v41 = v37;
                                                        break;
                                                    }
                                                    case 1: {
                                                        long v42 = wb6.A();
                                                        long v43 = L7.C(wb6.a(), 1000000L, v42);
                                                        long v44 = L7.C(wb6.A(), 1000L, v42);
                                                        long v45 = wb6.A();
                                                        s1 = wb6.x();
                                                        s1.getClass();
                                                        s2 = wb6.x();
                                                        s2.getClass();
                                                        v38 = v44;
                                                        v39 = v45;
                                                        v41 = v43;
                                                        v40 = 0x8000000000000001L;
                                                        break;
                                                    }
                                                    default: {
                                                        x.u(v34, "Skipping unsupported emsg version: ", "FragmentedMp4Extractor");
                                                        break alab1;
                                                    }
                                                }
                                                byte[] arr_b2 = new byte[wb6.d()];
                                                wb6.j(arr_b2, 0, wb6.d());
                                                g9 g90 = new g9(s1, s2, v38, v39, arr_b2);
                                                wb wb7 = new wb(this.k.n(g90));
                                                int v46 = wb7.d();
                                                ie[] arr_ie1 = this.F;
                                                for(int v47 = 0; v47 < arr_ie1.length; ++v47) {
                                                    ie ie1 = arr_ie1[v47];
                                                    wb7.n(0);
                                                    ie1.b(v46, wb7);
                                                }
                                                if(v41 == 0x8000000000000001L) {
                                                    arrayDeque1.addLast(new m3(v40, v46));
                                                    this.v += v46;
                                                }
                                                else {
                                                    if(r60 != null) {
                                                        v41 = r60.a(v41);
                                                    }
                                                    long v48 = v41;
                                                    ie[] arr_ie2 = this.F;
                                                    for(int v49 = 0; v49 < arr_ie2.length; ++v49) {
                                                        arr_ie2[v49].f(v48, 1, v46, 0, null);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                        case 1936286840: {
                                            wb6.n(8);
                                            int v50 = H4.b.e(wb6.p());
                                            wb6.o(4);
                                            long v51 = wb6.A();
                                            if(v50 == 0) {
                                                v52 = wb6.A();
                                                v53 = wb6.A();
                                            }
                                            else {
                                                v52 = wb6.a();
                                                v53 = wb6.a();
                                            }
                                            long v54 = v53 + v32;
                                            long v55 = v52;
                                            long v56 = L7.C(v55, 1000000L, v51);
                                            wb6.o(2);
                                            int v57 = wb6.b();
                                            int[] arr_v = new int[v57];
                                            long[] arr_v1 = new long[v57];
                                            long[] arr_v2 = new long[v57];
                                            long v58 = v56;
                                            long[] arr_v3 = new long[v57];
                                            for(int v59 = 0; v59 < v57; ++v59) {
                                                int v60 = wb6.p();
                                                if((v60 & 0x80000000) != 0) {
                                                    throw new H4("Unhandled indirect reference");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                                }
                                                long v61 = wb6.A();
                                                arr_v[v59] = v60 & 0x7FFFFFFF;
                                                arr_v1[v59] = v54;
                                                arr_v2[v59] = v58;
                                                v55 += v61;
                                                long v62 = L7.C(v55, 1000000L, v51);
                                                arr_v3[v59] = v62 - arr_v2[v59];
                                                wb6.o(4);
                                                v54 += (long)arr_v[v59];
                                                v58 = v62;
                                            }
                                            Pair pair0 = Pair.create(v56, new e1(arr_v, arr_v1, arr_v3, arr_v2));
                                            this.y = (long)(((Long)pair0.first));
                                            this.E.t(((sd)pair0.second));
                                            this.K = 3;
                                        }
                                    }
                                }
                                else {
                                    ((o0)arrayDeque0.peek()).d.add(p00);
                                }
                            }
                            else if(this.K == 1) {
                                long v33 = this.x;
                                if(v33 > 0L) {
                                    if(this.J == null) {
                                        this.J = new n3(v33);
                                    }
                                    o3 o31 = this.h(wb6);
                                    if(o31 != null) {
                                        this.J.a.add(o31);
                                    }
                                }
                            }
                        }
                        this.c(((D2)i50).d);
                        continue;
                    }
                    case 2: {
                        int v63 = sparseArray0.size();
                        p3 p34 = null;
                        for(int v64 = 0; v64 < v63; ++v64) {
                            w7 w73 = ((p3)sparseArray0.valueAt(v64)).b;
                            if(w73.p) {
                                long v65 = w73.c;
                                if(v65 < v2) {
                                    v2 = v65;
                                    p34 = (p3)sparseArray0.valueAt(v64);
                                }
                            }
                        }
                        if(p34 == null) {
                            this.p = 3;
                        }
                        else {
                            int v66 = (int)(v2 - ((D2)i50).d);
                            if(v66 < 0) {
                                throw new H4("Offset to encryption data was negative.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                            }
                            ((D2)i50).g(v66);
                            ((D2)i50).f(p34.b.o.a, 0, p34.b.o.c, false);
                            p34.b.o.n(0);
                            p34.b.p = false;
                        }
                        continue;
                    }
                    case 5: {
                        long v3 = ((D2)i50).c;
                        if(v3 >= 16L) {
                            try {
                                wb wb0 = new wb(16);
                                ((D2)i50).k(wb0.a, 0, 16, true);
                                if(wb0.p() == 16 && wb0.p() == 0x6D66726F) {
                                    wb0.o(4);
                                    long v4 = wb0.A();
                                    long v5 = v3 - v4;
                                    if(v4 >= 0L && v5 >= 0L) {
                                        this.H = v4;
                                        v0.a = v5;
                                        this.p = 6;
                                        return 1;
                                    }
                                }
                            }
                            catch(Exception exception0) {
                                exception0.printStackTrace();
                            }
                        }
                        this.E.t(new K8(this.x));
                        this.K = 2;
                        v0.a = this.I;
                        this.p = 2;
                        return 1;
                    }
                    case 6: {
                        try {
                            wb wb1 = new wb(((int)this.H));
                            ((D2)i50).k(wb1.a, 0, ((int)this.H), false);
                            if(this.H != ((long)wb1.p()) || wb1.p() != 1835430497) {
                                goto label_56;
                            }
                            else {
                                while(wb1.d() > 8) {
                                    int v6 = wb1.p();
                                    if(wb1.p() == 1952871009) {
                                        if(this.J == null) {
                                            this.J = new n3(this.x);
                                        }
                                        wb wb2 = new wb(v6);
                                        wb1.j(wb2.a, 8, v6 - 8);
                                        o3 o30 = this.h(wb2);
                                        if(o30 == null) {
                                            continue;
                                        }
                                        this.J.a.add(o30);
                                    }
                                    else {
                                        wb1.o(v6 - 8);
                                    }
                                }
                                n3 n30 = this.J;
                                if(n30 == null) {
                                    goto label_53;
                                }
                                else {
                                    this.E.t(n30);
                                    this.K = 4;
                                }
                            }
                            v0.a = this.I;
                            this.p = 2;
                            return 1;
                        }
                        catch(Exception exception1) {
                        }
                        exception1.printStackTrace();
                        goto label_56;
                    label_53:
                        this.E.t(new K8(this.x));
                        this.K = 2;
                        v0.a = this.I;
                        this.p = 2;
                        return 1;
                    label_56:
                        this.E.t(new K8(this.x));
                        this.K = 2;
                        v0.a = this.I;
                        this.p = 2;
                        return 1;
                    label_61:
                        p3 p30 = this.z;
                        if(p30 == null) {
                            int v7 = sparseArray0.size();
                            p3 p31 = null;
                            for(int v8 = 0; v8 < v7; ++v8) {
                                p3 p32 = (p3)sparseArray0.valueAt(v8);
                                boolean z = p32.l;
                                w7 w70 = p32.b;
                                if((z || p32.f != p32.d.b) && (!z || p32.h != w70.d)) {
                                    long v9 = z ? w70.f[p32.h] : p32.d.c[p32.f];
                                    if(v9 < v2) {
                                        p31 = p32;
                                        v2 = v9;
                                    }
                                }
                            }
                            if(p31 == null) {
                                int v10 = (int)(this.u - ((D2)i50).d);
                                if(v10 < 0) {
                                    throw new H4("Offset to end of mdat was negative.");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                }
                                ((D2)i50).g(v10);
                                this.p = 0;
                                this.s = 0;
                                continue;
                            }
                            else {
                                int v11 = (int)((p31.l ? p31.b.f[p31.h] : p31.d.c[p31.f]) - ((D2)i50).d);
                                if(v11 < 0) {
                                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                    v11 = 0;
                                }
                                ((D2)i50).g(v11);
                                this.z = p31;
                                p30 = p31;
                            }
                        }
                        w7 w71 = p30.b;
                        if(this.p == 3) {
                            int v12 = p30.l ? w71.h[p30.f] : p30.d.d[p30.f];
                            this.A = v12;
                            if(p30.f < p30.i) {
                                ((D2)i50).g(v12);
                                a7 a70 = p30.b();
                                if(a70 != null) {
                                    wb wb3 = w71.o;
                                    int v13 = a70.d;
                                    if(v13 != 0) {
                                        wb3.o(v13);
                                    }
                                    if(w71.l && w71.m[p30.f]) {
                                        wb3.o(wb3.b() * 6);
                                    }
                                }
                                if(!p30.c()) {
                                    this.z = null;
                                }
                                this.p = 3;
                                return 0;
                            }
                            if(p30.d.a.g == 1) {
                                this.A = v12 - 8;
                                ((D2)i50).g(8);
                            }
                            if("audio/ac4".equals(p30.d.a.f.l)) {
                                this.B = p30.a(this.A, 7);
                                Ja.w(this.A, this.i);
                                p30.a.b(7, this.i);
                                this.B += 7;
                            }
                            else {
                                this.B = p30.a(this.A, 0);
                            }
                            this.A += this.B;
                            this.p = 4;
                            this.C = 0;
                        }
                        p3 p33 = this.z;
                        w7 w72 = p33.b;
                        D6 d60 = p30.d.a;
                        ie ie0 = p30.a;
                        long v14 = p30.l ? w71.j[p30.f] + ((long)w71.i[p30.f]) : p30.d.f[p30.f];
                        long v15 = this.J == null || p33.m > 0L ? v14 : v14 + this.J.c;
                        if(r60 != null) {
                            v15 = r60.a(v15);
                        }
                        int v16 = d60.j;
                        u u0 = d60.f;
                        if(v16 == 0) {
                            arrayDeque2 = arrayDeque1;
                            r62 = r60;
                            while(true) {
                                int v24 = this.B;
                                int v25 = this.A;
                                if(v24 >= v25) {
                                    break;
                                }
                                int v26 = ie0.e(i50, v25 - v24, false);
                                this.B += v26;
                            }
                        }
                        else {
                            wb wb4 = this.f;
                            byte[] arr_b = wb4.a;
                            arr_b[0] = 0;
                            arr_b[1] = 0;
                            arr_b[2] = 0;
                            int v17 = 4 - v16;
                            while(true) {
                                arrayDeque2 = arrayDeque1;
                                if(this.B >= this.A) {
                                    break;
                                }
                                int v18 = this.C;
                                if(v18 == 0) {
                                    r61 = r60;
                                    ((D2)i50).f(arr_b, v17, v16 + 1, false);
                                    wb4.n(0);
                                    int v19 = wb4.p();
                                    if(v19 < 1) {
                                        throw new H4("Invalid NAL length");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                                    }
                                    this.C = v19 - 1;
                                    this.e.n(0);
                                    ie0.b(4, this.e);
                                    ie0.b(1, wb4);
                                    if(this.G.length > 0) {
                                        String s = u0.l;
                                        int v20 = arr_b[4];
                                        if("video/avc".equals(s)) {
                                            v21 = v17;
                                            if((v20 & 0x1F) == 6) {
                                                z1 = true;
                                                goto label_167;
                                            }
                                        }
                                        else {
                                            v21 = v17;
                                        }
                                        if("video/hevc".equals(s) && (v20 & 0x7E) >> 1 == 39) {
                                            z1 = true;
                                            goto label_167;
                                        }
                                    }
                                    else {
                                        v21 = v17;
                                    }
                                    z1 = false;
                                label_167:
                                    this.D = z1;
                                    this.B += 5;
                                    this.A += v21;
                                    v17 = v21;
                                }
                                else {
                                    r61 = r60;
                                    if(this.D) {
                                        this.g.l(v18);
                                        wb5 = wb4;
                                        arr_b1 = arr_b;
                                        ((D2)i50).f(this.g.a, 0, this.C, false);
                                        ie0.b(this.C, this.g);
                                        v22 = this.C;
                                        int v23 = Ja.V(this.g.c, this.g.a);
                                        this.g.n(((int)"video/hevc".equals(u0.l)));
                                        this.g.m(v23);
                                        Ja.y(v15, this.g, this.G);
                                    }
                                    else {
                                        wb5 = wb4;
                                        arr_b1 = arr_b;
                                        v22 = ie0.e(i50, v18, false);
                                    }
                                    this.B += v22;
                                    this.C -= v22;
                                    wb4 = wb5;
                                    arr_b = arr_b1;
                                }
                                arrayDeque1 = arrayDeque2;
                                r60 = r61;
                            }
                            r62 = r60;
                        }
                        if(p30.l) {
                            v27 = w71.k[p30.f] ? 1 : 0;
                        }
                        else {
                            v27 = p30.d.g[p30.f];
                        }
                        if(p30.b() != null) {
                            v27 |= 0x40000000;
                        }
                        a7 a71 = p30.b();
                        he he0 = a71 == null ? null : a71.c;
                        if(w72.s && this.z.f != 0) {
                            v27 |= 0x2000000;
                        }
                        ie0.f(v15, v27, this.A, 0, he0);
                        while(!arrayDeque2.isEmpty()) {
                            m3 m30 = (m3)arrayDeque2.removeFirst();
                            this.v -= m30.b;
                            long v28 = r62 == null ? v15 + m30.a : r62.a(v15 + m30.a);
                            ie[] arr_ie = this.F;
                            for(int v29 = 0; v29 < arr_ie.length; ++v29) {
                                arr_ie[v29].f(v28, 1, m30.b, this.v, null);
                            }
                        }
                        if(!p30.c()) {
                            this.z = null;
                        }
                        this.p = 3;
                        return 0;
                    }
                    default: {
                        goto label_61;
                    }
                }
            }
            wb wb8 = this.l;
            if(this.s == 0) {
                if(!((D2)i50).f(wb8.a, 0, 8, true)) {
                    return -1;
                }
                this.s = 8;
                wb8.n(0);
                this.r = wb8.A();
                this.q = wb8.p();
            }
            long v67 = this.r;
            if(v67 == 1L) {
                ((D2)i50).f(wb8.a, 8, 8, false);
                this.s += 8;
                this.r = wb8.a();
            }
            else if(v67 == 0L) {
                long v68 = ((D2)i50).c;
                if(v68 == -1L && !arrayDeque0.isEmpty()) {
                    v68 = ((o0)arrayDeque0.peek()).c;
                }
                if(v68 != -1L) {
                    this.r = v68 - ((D2)i50).d + ((long)this.s);
                }
            }
            int v69 = this.s;
            if(this.r < ((long)v69)) {
                break;
            }
            long v70 = ((D2)i50).d - ((long)v69);
            boolean z2 = (this.q == 1835295092 || this.q == 0x6D6F6F66) && this.K == 1 && this.x >= 0L && (this.a & 0x2000) != 0;
            if(this.q == 0x6D6F6F66) {
                int v71 = sparseArray0.size();
                for(int v72 = 0; v72 < v71; ++v72) {
                    w7 w74 = ((p3)sparseArray0.valueAt(v72)).b;
                    w74.getClass();
                    w74.c = v70;
                    w74.b = v70;
                }
            }
            int v73 = this.q;
            switch(v73) {
                case 1835295092: {
                    this.z = null;
                    this.u = this.r + v70;
                    long v74 = ((D2)i50).c;
                    if(z2 && v74 > 16L) {
                        v0.a = v74 - 16L;
                        this.I = v70;
                        this.p = 5;
                        return 1;
                    }
                    this.p = 2;
                    continue;
                }
                case 1701082227: 
                case 0x6D646961: 
                case 1835430497: 
                case 1835626086: 
                case 0x6D6F6F66: 
                case 0x6D6F6F76: 
                case 0x6D766578: 
                case 1937007212: 
                case 1953653094: 
                case 1953653099: {
                    long v76 = ((D2)i50).d + this.r - 8L;
                    arrayDeque0.push(new o0(v73, v76));
                    if(this.r == ((long)this.s)) {
                        this.c(v76);
                        continue;
                    }
                    break;
                }
                case 0x636F3634: 
                case 0x63747473: 
                case 1701606260: 
                case 1701671783: 
                case 0x68646C72: 
                case 0x6D646864: 
                case 1835362404: 
                case 0x6D766864: 
                case 0x70737368: 
                case 0x7361696F: 
                case 0x7361697A: 
                case 0x73626770: 
                case 1936027235: 
                case 0x73677064: 
                case 1936286840: 
                case 1937007471: 
                case 1937011555: 
                case 1937011556: 
                case 1937011571: 
                case 1937011578: 
                case 1937011827: 
                case 1937013298: 
                case 0x74666474: 
                case 0x74666864: 
                case 1952871009: 
                case 0x746B6864: 
                case 0x74726578: 
                case 0x7472756E: 
                case 1970628964: {
                    if(this.s != 8) {
                        throw new H4("Leaf atom defines extended atom size (unsupported).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    long v75 = this.r;
                    if(v75 > 0x7FFFFFFFL) {
                        throw new H4("Leaf atom with length > 2147483647 (unsupported).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    wb wb9 = new wb(((int)v75));
                    System.arraycopy(wb8.a, 0, wb9.a, 0, 8);
                    this.t = wb9;
                    this.p = 1;
                    continue;
                }
                default: {
                    if(this.r > 0x7FFFFFFFL) {
                        throw new H4("Skipping atom with length > 2147483647 (unsupported).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
                    }
                    this.t = null;
                    this.p = 1;
                    continue;
                }
            }
            this.p = 0;
            this.s = 0;
        }
        throw new H4("Atom size less than header length (unsupported).");  // 初始化器: Ljava/io/IOException;-><init>(Ljava/lang/String;)V
    }

    @Override  // i.n.i.b.a.s.e.q4
    public final void g(U5 u50) {
        int v;
        this.E = u50;
        this.p = 0;
        this.s = 0;
        ie[] arr_ie = new ie[2];
        this.F = arr_ie;
        ie ie0 = this.o;
        if(ie0 == null) {
            v = 0;
        }
        else {
            arr_ie[0] = ie0;
            v = 1;
        }
        int v1 = 100;
        if((this.a & 4) != 0) {
            arr_ie[v] = u50.i(100, 5);
            v1 = 101;
            ++v;
        }
        ie[] arr_ie1 = (ie[])L7.s(v, this.F);
        this.F = arr_ie1;
        for(int v2 = 0; v2 < arr_ie1.length; ++v2) {
            arr_ie1[v2].a(q3.M);
        }
        List list0 = this.c;
        this.G = new ie[list0.size()];
        int v3 = 0;
        while(v3 < this.G.length) {
            ie ie1 = this.E.i(v1, 3);
            ie1.a(((u)list0.get(v3)));
            this.G[v3] = ie1;
            ++v3;
            ++v1;
        }
        D6 d60 = this.b;
        if(d60 != null) {
            p3 p30 = new p3(u50.i(0, d60.b), new U7(this.b, new long[0], new int[0], 0, new long[0], new int[0], 0L), new b2(0, 0, 0, 0));
            this.d.put(0, p30);
            this.E.b();
        }
    }

    public final o3 h(wb wb0) {
        long v7;
        long v6;
        try {
            wb0.n(8);
            int v = wb0.p();
            int v1 = wb0.p();
            int v2 = wb0.p();
            int v3 = wb0.p();
            p3 p30 = (p3)this.d.get(v1);
            if(p30 == null) {
                return null;
            }
            long v4 = p30.d.a.c;
            long[] arr_v = new long[v3];
            long[] arr_v1 = new long[v3];
            for(int v5 = 0; v5 < v3; ++v5) {
                if((v >> 24 & 0xFF) == 1) {
                    v6 = wb0.w();
                    v7 = wb0.w();
                }
                else {
                    v6 = wb0.A();
                    v7 = wb0.A();
                }
                int v8 = (v2 >> 2 & 3) + (v2 >> 4 & 3) + 2;
                int v9 = v8 + ((v2 & 3) + 1);
                byte[] arr_b = new byte[v9];
                wb0.j(arr_b, 0, v9);
                for(int v10 = v8; v10 < v9; ++v10) {
                    int v11 = arr_b[v10];
                }
                arr_v[v5] = v7;
                arr_v1[v5] = BigInteger.valueOf(v6).multiply(BigInteger.valueOf(1000000L)).divide(BigInteger.valueOf(v4)).longValue();
            }
            return new o3(arr_v, arr_v1);
        }
        catch(Exception exception0) {
            M7.H("FragmentedMp4Extractor", "IOException while parsing \'tfra\' box", exception0);
            return null;
        }
    }
}

