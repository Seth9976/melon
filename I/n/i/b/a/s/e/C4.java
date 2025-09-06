package i.n.i.b.a.s.e;

import B3.N;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c4 extends Ja {
    public final wb K;
    public final N L;
    public r6 M;

    public c4() {
        this.K = new wb(1, false);
        this.L = new N(6);
    }

    @Override  // i.n.i.b.a.s.e.Ja
    public final x8 p(s s0, ByteBuffer byteBuffer0) {
        boolean z13;
        boolean z12;
        long v35;
        long v34;
        int v33;
        int v32;
        boolean z11;
        int v31;
        boolean z10;
        boolean z9;
        ja ja0;
        int v20;
        int v19;
        long v18;
        boolean z5;
        boolean z4;
        int v17;
        boolean z3;
        long v16;
        long v15;
        boolean z2;
        int v13;
        if(this.M == null || s0.i != this.M.c()) {
            long v = s0.f;
            r6 r60 = new r6(v);
            this.M = r60;
            r60.a(v - s0.i);
        }
        byte[] arr_b = byteBuffer0.array();
        int v1 = byteBuffer0.limit();
        wb wb0 = this.K;
        wb0.i(v1, arr_b);
        this.L.c(v1, arr_b);
        this.L.v(39);
        long v2 = ((long)this.L.a(1)) << 0x20 | ((long)this.L.a(0x20));
        this.L.v(20);
        int v3 = this.L.a(12);
        int v4 = this.L.a(8);
        wb0.o(14);
        switch(v4) {
            case 0: {
                ja0 = new ja();  // 初始化器: Ljava/lang/Object;-><init>()V
                return ja0 == null ? new x8(new b[0]) : new x8(new b[]{ja0});
            }
            case 0xFF: {
                long v37 = wb0.A();
                byte[] arr_b1 = new byte[v3 - 4];
                wb0.j(arr_b1, 0, v3 - 4);
                ja0 = new fa(v37, arr_b1, v2);
                return ja0 == null ? new x8(new b[0]) : new x8(new b[]{ja0});
            }
            default: {
                long v5 = 0x8000000000000001L;
                switch(v4) {
                    case 4: {
                        int v6 = wb0.z();
                        ArrayList arrayList0 = new ArrayList(v6);
                        int v7 = 0;
                        while(v7 < v6) {
                            long v8 = wb0.A();
                            boolean z = (wb0.z() & 0x80) != 0;
                            ArrayList arrayList1 = new ArrayList();
                            if(z) {
                                v13 = v6;
                                v18 = 0x8000000000000001L;
                                v16 = 0x8000000000000001L;
                                z4 = false;
                                z5 = false;
                                z3 = false;
                                v17 = 0;
                                v19 = 0;
                                v20 = 0;
                            }
                            else {
                                int v9 = wb0.z();
                                boolean z1 = (v9 & 0x40) != 0;
                                long v10 = z1 ? wb0.A() : 0x8000000000000001L;
                                if(!z1) {
                                    int v11 = wb0.z();
                                    ArrayList arrayList2 = new ArrayList(v11);
                                    for(int v12 = 0; v12 < v11; ++v12) {
                                        arrayList2.add(new p5(wb0.z(), wb0.A()));
                                    }
                                    arrayList1 = arrayList2;
                                }
                                v13 = v6;
                                if((v9 & 0x20) == 0) {
                                    v15 = 0x8000000000000001L;
                                    z2 = false;
                                }
                                else {
                                    long v14 = (long)wb0.z();
                                    z2 = (v14 & 0x80L) != 0L;
                                    v15 = ((v14 & 1L) << 0x20 | wb0.A()) * 1000L / 90L;
                                }
                                v16 = v15;
                                z3 = z2;
                                v17 = wb0.b();
                                z4 = (v9 & 0x80) != 0;
                                z5 = z1;
                                v18 = v10;
                                v19 = wb0.z();
                                v20 = wb0.z();
                            }
                            arrayList0.add(new q5(v8, z, z4, z5, arrayList1, v18, z3, v16, v17, v19, v20));
                            ++v7;
                            v6 = v13;
                        }
                        ja0 = new ka(arrayList0);
                        return ja0 == null ? new x8(new b[0]) : new x8(new b[]{ja0});
                    }
                    case 5: {
                        r6 r61 = this.M;
                        long v21 = wb0.A();
                        boolean z6 = (wb0.z() & 0x80) != 0;
                        List list0 = Collections.EMPTY_LIST;
                        if(z6) {
                            v35 = 0x8000000000000001L;
                            v34 = 0x8000000000000001L;
                            z11 = false;
                            z13 = false;
                            z12 = false;
                            z10 = false;
                            v32 = 0;
                            v33 = 0;
                            v31 = 0;
                        }
                        else {
                            int v22 = wb0.z();
                            boolean z7 = (v22 & 0x40) != 0;
                            boolean z8 = (v22 & 16) != 0;
                            long v23 = !z7 || z8 ? 0x8000000000000001L : la.a(v2, wb0);
                            if(!z7) {
                                int v24 = wb0.z();
                                ArrayList arrayList3 = new ArrayList(v24);
                                for(int v25 = 0; v25 < v24; ++v25) {
                                    int v26 = wb0.z();
                                    long v27 = z8 ? 0x8000000000000001L : la.a(v2, wb0);
                                    arrayList3.add(new u4(v26, v27, r61.b(v27)));
                                }
                                list0 = arrayList3;
                            }
                            if((v22 & 0x20) == 0) {
                                z9 = false;
                            }
                            else {
                                long v28 = (long)wb0.z();
                                z9 = (v28 & 0x80L) != 0L;
                                v5 = ((v28 & 1L) << 0x20 | wb0.A()) * 1000L / 90L;
                            }
                            int v29 = wb0.b();
                            int v30 = wb0.z();
                            z10 = z9;
                            v31 = wb0.z();
                            z11 = (v22 & 0x80) != 0;
                            v32 = v29;
                            v33 = v30;
                            v34 = v5;
                            v35 = v23;
                            z12 = z8;
                            z13 = z7;
                        }
                        ja0 = new ia(v21, z6, z11, z13, z12, v35, r61.b(v35), list0, z10, v34, v32, v33, v31);
                        return ja0 == null ? new x8(new b[0]) : new x8(new b[]{ja0});
                    }
                    case 6: {
                        r6 r62 = this.M;
                        long v36 = la.a(v2, wb0);
                        ja0 = new la(v36, r62.b(v36));
                        return ja0 == null ? new x8(new b[0]) : new x8(new b[]{ja0});
                    }
                    default: {
                        return new x8(new b[0]);
                    }
                }
            }
        }
    }
}

