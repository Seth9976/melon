package R3;

import B3.N;
import De.I;
import androidx.media3.common.Metadata.Entry;
import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.scte35.PrivateCommand;
import androidx.media3.extractor.metadata.scte35.SpliceInsertCommand;
import androidx.media3.extractor.metadata.scte35.SpliceNullCommand;
import androidx.media3.extractor.metadata.scte35.SpliceScheduleCommand;
import androidx.media3.extractor.metadata.scte35.TimeSignalCommand;
import e3.p;
import e3.v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends I {
    public final p j;
    public final N k;
    public v l;

    public a() {
        this.j = new p();
        this.k = new N(2);
    }

    @Override  // De.I
    public final Metadata z(K3.a a0, ByteBuffer byteBuffer0) {
        long v35;
        boolean z13;
        boolean z12;
        long v34;
        int v33;
        int v32;
        boolean z11;
        boolean z10;
        int v31;
        boolean z9;
        SpliceNullCommand spliceNullCommand0;
        int v19;
        int v18;
        long v17;
        boolean z5;
        boolean z4;
        int v16;
        boolean z3;
        long v15;
        long v14;
        boolean z2;
        p p0 = this.j;
        N n0 = this.k;
        if(this.l == null || a0.j != this.l.b) {
            v v0 = new v(a0.g);
            this.l = v0;
            v0.a(a0.g - a0.j);
        }
        byte[] arr_b = byteBuffer0.array();
        int v1 = byteBuffer0.limit();
        p0.E(arr_b, v1);
        n0.K(arr_b, v1);
        n0.O(39);
        long v2 = ((long)n0.D(1)) << 0x20 | ((long)n0.D(0x20));
        n0.O(20);
        int v3 = n0.D(12);
        int v4 = n0.D(8);
        p0.H(14);
        switch(v4) {
            case 0: {
                spliceNullCommand0 = new SpliceNullCommand();  // 初始化器: Ljava/lang/Object;-><init>()V
                return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
            }
            case 0xFF: {
                long v38 = p0.w();
                byte[] arr_b1 = new byte[v3 - 4];
                p0.e(arr_b1, 0, v3 - 4);
                spliceNullCommand0 = new PrivateCommand(v38, arr_b1, v2);
                return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
            }
            default: {
                long v5 = 0x8000000000000001L;
                switch(v4) {
                    case 4: {
                        int v6 = p0.u();
                        ArrayList arrayList0 = new ArrayList(v6);
                        for(int v7 = 0; v7 < v6; ++v7) {
                            long v8 = p0.w();
                            boolean z = (p0.u() & 0x80) != 0;
                            ArrayList arrayList1 = new ArrayList();
                            if(z) {
                                v17 = 0x8000000000000001L;
                                v15 = 0x8000000000000001L;
                                z4 = false;
                                z5 = false;
                                z3 = false;
                                v16 = 0;
                                v18 = 0;
                                v19 = 0;
                            }
                            else {
                                int v9 = p0.u();
                                boolean z1 = (v9 & 0x40) != 0;
                                long v10 = z1 ? p0.w() : 0x8000000000000001L;
                                if(!z1) {
                                    int v11 = p0.u();
                                    ArrayList arrayList2 = new ArrayList(v11);
                                    for(int v12 = 0; v12 < v11; ++v12) {
                                        arrayList2.add(new c(p0.u(), p0.w()));
                                    }
                                    arrayList1 = arrayList2;
                                }
                                if((v9 & 0x20) == 0) {
                                    v14 = 0x8000000000000001L;
                                    z2 = false;
                                }
                                else {
                                    long v13 = (long)p0.u();
                                    z2 = (v13 & 0x80L) != 0L;
                                    v14 = ((v13 & 1L) << 0x20 | p0.w()) * 1000L / 90L;
                                }
                                v15 = v14;
                                z3 = z2;
                                v16 = p0.A();
                                z4 = (v9 & 0x80) != 0;
                                z5 = z1;
                                v17 = v10;
                                v18 = p0.u();
                                v19 = p0.u();
                            }
                            arrayList0.add(new d(v8, z, z4, z5, arrayList1, v17, z3, v15, v16, v18, v19));
                        }
                        spliceNullCommand0 = new SpliceScheduleCommand(arrayList0);
                        return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
                    }
                    case 5: {
                        v v20 = this.l;
                        long v21 = p0.w();
                        boolean z6 = (p0.u() & 0x80) != 0;
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
                            int v22 = p0.u();
                            boolean z7 = (v22 & 0x40) != 0;
                            boolean z8 = (v22 & 16) != 0;
                            long v23 = !z7 || z8 ? 0x8000000000000001L : TimeSignalCommand.a(v2, p0);
                            if(!z7) {
                                int v24 = p0.u();
                                ArrayList arrayList3 = new ArrayList(v24);
                                for(int v25 = 0; v25 < v24; ++v25) {
                                    int v26 = p0.u();
                                    long v27 = z8 ? 0x8000000000000001L : TimeSignalCommand.a(v2, p0);
                                    arrayList3.add(new b(v26, v27, v20.b(v27)));
                                }
                                list0 = arrayList3;
                            }
                            if((v22 & 0x20) == 0) {
                                z9 = false;
                            }
                            else {
                                long v28 = (long)p0.u();
                                z9 = (v28 & 0x80L) != 0L;
                                v5 = ((v28 & 1L) << 0x20 | p0.w()) * 1000L / 90L;
                            }
                            int v29 = p0.A();
                            int v30 = p0.u();
                            v31 = p0.u();
                            z10 = z9;
                            z11 = (v22 & 0x80) != 0;
                            v32 = v29;
                            v33 = v30;
                            v34 = v5;
                            z12 = z8;
                            z13 = z7;
                            v35 = v23;
                        }
                        spliceNullCommand0 = new SpliceInsertCommand(v21, z6, z11, z13, z12, v35, v20.b(v35), list0, z10, v34, v32, v33, v31);
                        return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
                    }
                    case 6: {
                        v v36 = this.l;
                        long v37 = TimeSignalCommand.a(v2, p0);
                        spliceNullCommand0 = new TimeSignalCommand(v37, v36.b(v37));
                        return spliceNullCommand0 == null ? new Metadata(new Entry[0]) : new Metadata(new Entry[]{spliceNullCommand0});
                    }
                    default: {
                        return new Metadata(new Entry[0]);
                    }
                }
            }
        }
    }
}

