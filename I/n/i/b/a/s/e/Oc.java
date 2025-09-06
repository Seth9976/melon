package i.n.i.b.a.s.e;

import B3.N;
import Pe.z;
import a4.b;
import a4.g;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jeb.synthetic.Objects;

public final class oc extends i4 {
    public final int m;
    public final Object n;

    public oc() {
        this.m = 1;
        super();
        this.n = new wb(1, false);
    }

    public oc(List list0) {
        this.m = 0;
        super();
        byte[] arr_b = (byte[])list0.get(0);
        this.n = new id((arr_b[0] & 0xFF) << 8 | arr_b[1] & 0xFF, arr_b[3] & 0xFF | (arr_b[2] & 0xFF) << 8);
    }

    @Override  // i.n.i.b.a.s.e.i4
    public final T4 b(byte[] arr_b, int v, boolean z) {
        int v60;
        int v59;
        int v58;
        int v57;
        z z4;
        int v55;
        gd gd3;
        int v54;
        int[] arr_v;
        g g1;
        int v50;
        T4 t40;
        List list0;
        int v36;
        int v35;
        int v34;
        int v33;
        F3 f30;
        Object object0 = this.n;
        if(this.m != 0) {
            ((wb)object0).i(v, arr_b);
            ArrayList arrayList0 = new ArrayList();
            while(((wb)object0).d() > 0) {
                if(((wb)object0).d() < 8) {
                    throw new m6("Incomplete Mp4Webvtt Top Level box header found.");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                }
                int v1 = ((wb)object0).p();
                if(((wb)object0).p() == 0x76747463) {
                    int v2 = v1 - 8;
                    String s = null;
                    E3 e30 = null;
                    while(v2 > 0) {
                        if(v2 < 8) {
                            throw new m6("Incomplete vtt cue box header found.");  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
                        }
                        int v3 = ((wb)object0).p();
                        int v4 = ((wb)object0).p();
                        String s1 = new String(((wb)object0).a, ((wb)object0).b, v3 - 8, b9.c);
                        ((wb)object0).o(v3 - 8);
                        v2 = v2 - 8 - (v3 - 8);
                        if(v4 == 1937011815) {
                            ve ve0 = new ve();
                            we.e(s1, ve0);
                            e30 = ve0.a();
                        }
                        else if(v4 == 0x7061796C) {
                            s = we.a(null, s1.trim(), Collections.EMPTY_LIST);
                        }
                    }
                    if(s == null) {
                        s = "";
                    }
                    if(e30 == null) {
                        ve ve1 = new ve();
                        ve1.c = s;
                        f30 = ve1.a().a();
                    }
                    else {
                        e30.a = s;
                        f30 = e30.a();
                    }
                    arrayList0.add(f30);
                }
                else {
                    ((wb)object0).o(v1 - 8);
                }
            }
            return new z(arrayList0);
        }
        if(z) {
            ((id)object0).f.c.clear();
            ((id)object0).f.d.clear();
            ((id)object0).f.e.clear();
            ((id)object0).f.f.clear();
            ((id)object0).f.g.clear();
            ((id)object0).f.h = null;
            ((id)object0).f.i = null;
        }
        z z1 = Objects.alloc(z);
        Paint paint0 = ((id)object0).b;
        Canvas canvas0 = ((id)object0).c;
        g g0 = ((id)object0).f;
        N n0 = new N(arr_b, v, 6, 0);
        while(n0.h() >= 0x30 && n0.a(8) == 15) {
            int v5 = n0.a(8);
            int v6 = n0.a(16);
            int v7 = n0.a(16);
            int v8 = n0.u() + v7;
            if(v7 * 8 > n0.h()) {
                Log.w("DvbParser", "Data field length exceeds limit");
                n0.v(n0.h());
            }
            else {
                switch(v5) {
                    case 16: {
                        if(v6 == g0.a) {
                            h1 h10 = (h1)g0.i;
                            n0.a(8);
                            int v9 = n0.a(4);
                            int v10 = n0.a(2);
                            n0.v(2);
                            int v11 = v7 - 2;
                            SparseArray sparseArray0 = new SparseArray();
                            while(v11 > 0) {
                                int v12 = n0.a(8);
                                n0.v(8);
                                v11 -= 6;
                                sparseArray0.put(v12, new fd(n0.a(16), n0.a(16)));
                            }
                            h1 h11 = new h1(v9, v10, sparseArray0);
                            if(v10 != 0) {
                                g0.i = h11;
                                g0.c.clear();
                                g0.d.clear();
                                g0.e.clear();
                            }
                            else if(h10 != null && h10.a != v9) {
                                g0.i = h11;
                            }
                        }
                        break;
                    }
                    case 17: {
                        h1 h12 = (h1)g0.i;
                        SparseArray sparseArray1 = g0.c;
                        if(v6 == g0.a && h12 != null) {
                            int v13 = n0.a(8);
                            n0.v(4);
                            boolean z2 = n0.y();
                            n0.v(3);
                            int v14 = n0.a(16);
                            int v15 = n0.a(16);
                            n0.a(3);
                            int v16 = n0.a(3);
                            n0.v(2);
                            int v17 = n0.a(8);
                            int v18 = n0.a(8);
                            int v19 = n0.a(4);
                            int v20 = n0.a(2);
                            n0.v(2);
                            int v21 = v7 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while(v21 > 0) {
                                int v22 = n0.a(16);
                                int v23 = n0.a(2);
                                n0.a(2);
                                int v24 = n0.a(12);
                                n0.v(4);
                                int v25 = n0.a(12);
                                if(v23 == 1 || v23 == 2) {
                                    n0.a(8);
                                    n0.a(8);
                                    v21 -= 8;
                                }
                                else {
                                    v21 -= 6;
                                }
                                sparseArray2.put(v22, new hd(v24, v25));
                            }
                            gd gd0 = new gd(v13, z2, v14, v15, v16, v17, v18, v19, v20, sparseArray2);
                            if(h12.b == 0) {
                                gd gd1 = (gd)sparseArray1.get(v13);
                                if(gd1 != null) {
                                    SparseArray sparseArray3 = gd1.j;
                                    for(int v26 = 0; v26 < sparseArray3.size(); ++v26) {
                                        int v27 = sparseArray3.keyAt(v26);
                                        hd hd0 = (hd)sparseArray3.valueAt(v26);
                                        gd0.j.put(v27, hd0);
                                    }
                                }
                            }
                            sparseArray1.put(gd0.a, gd0);
                        }
                        break;
                    }
                    case 18: {
                        if(v6 == g0.a) {
                            dd dd0 = id.b(n0, v7);
                            g0.d.put(dd0.a, dd0);
                        }
                        else if(v6 == g0.b) {
                            dd dd1 = id.b(n0, v7);
                            g0.f.put(dd1.a, dd1);
                        }
                        break;
                    }
                    case 19: {
                        if(v6 == g0.a) {
                            ed ed0 = id.e(n0);
                            g0.e.put(ed0.a, ed0);
                        }
                        else if(v6 == g0.b) {
                            ed ed1 = id.e(n0);
                            g0.g.put(ed1.a, ed1);
                        }
                        break;
                    }
                    case 20: {
                        if(v6 == g0.a) {
                            n0.v(4);
                            boolean z3 = n0.y();
                            n0.v(3);
                            int v28 = n0.a(16);
                            int v29 = n0.a(16);
                            if(z3) {
                                int v30 = n0.a(16);
                                int v31 = n0.a(16);
                                int v32 = n0.a(16);
                                v33 = v30;
                                v34 = n0.a(16);
                                v35 = v31;
                                v36 = v32;
                            }
                            else {
                                v35 = v28;
                                v34 = v29;
                                v33 = 0;
                                v36 = 0;
                            }
                            g0.h = new b(v28, v29, v33, v35, v36, v34);
                        }
                    }
                }
                n0.x(v8 - n0.u());
            }
        }
        h1 h13 = (h1)g0.i;
        if(h13 == null) {
            list0 = Collections.EMPTY_LIST;
        }
        else {
            b b0 = (b)g0.h;
            if(b0 == null) {
                b0 = ((id)object0).d;
            }
            Bitmap bitmap0 = ((id)object0).g;
            if(bitmap0 == null) {
            label_190:
                Bitmap bitmap1 = Bitmap.createBitmap(b0.a + 1, b0.b + 1, Bitmap.Config.ARGB_8888);
                ((id)object0).g = bitmap1;
                canvas0.setBitmap(bitmap1);
            }
            else {
                int v37 = bitmap0.getWidth();
                if(b0.a + 1 == v37) {
                    int v38 = ((id)object0).g.getHeight();
                    if(b0.b + 1 != v38) {
                        goto label_190;
                    }
                }
                else {
                    goto label_190;
                }
            }
            ArrayList arrayList1 = new ArrayList();
            SparseArray sparseArray4 = (SparseArray)h13.c;
            for(int v39 = 0; v39 < sparseArray4.size(); ++v39) {
                canvas0.save();
                fd fd0 = (fd)sparseArray4.valueAt(v39);
                int v40 = sparseArray4.keyAt(v39);
                gd gd2 = (gd)g0.c.get(v40);
                int v41 = b0.c + fd0.a;
                int v42 = fd0.b + b0.e;
                int v43 = gd2.c;
                int v44 = gd2.f;
                int v45 = v41 + v43;
                int v46 = v42 + gd2.d;
                int v47 = gd2.d;
                canvas0.clipRect(v41, v42, Math.min(v45, b0.d), Math.min(v46, b0.f));
                dd dd2 = (dd)g0.d.get(v44);
                if(dd2 == null) {
                    dd dd3 = (dd)g0.f.get(v44);
                    dd2 = dd3 == null ? ((id)object0).e : dd3;
                }
                SparseArray sparseArray5 = gd2.j;
                int v48 = 0;
                while(v48 < sparseArray5.size()) {
                    int v49 = sparseArray5.keyAt(v48);
                    hd hd1 = (hd)sparseArray5.valueAt(v48);
                    ed ed2 = (ed)g0.e.get(v49);
                    if(ed2 == null) {
                        ed2 = (ed)g0.g.get(v49);
                    }
                    if(ed2 == null) {
                        z4 = z1;
                        g1 = g0;
                        gd3 = gd2;
                        v50 = v43;
                        v55 = v47;
                        v54 = v48;
                    }
                    else {
                        Paint paint1 = ed2.b ? null : ((id)object0).a;
                        v50 = v43;
                        int v51 = gd2.e;
                        g1 = g0;
                        int v52 = hd1.b + v42;
                        int v53 = hd1.a + v41;
                        if(v51 == 3) {
                            arr_v = dd2.d;
                        }
                        else {
                            arr_v = v51 == 2 ? dd2.c : dd2.b;
                        }
                        v54 = v48;
                        gd3 = gd2;
                        v55 = v47;
                        z4 = z1;
                        id.c(ed2.c, arr_v, v51, v53, v52, paint1, canvas0);
                        id.c(ed2.d, arr_v, v51, v53, v52 + 1, paint1, canvas0);
                    }
                    v48 = v54 + 1;
                    gd2 = gd3;
                    v47 = v55;
                    v43 = v50;
                    g0 = g1;
                    z1 = z4;
                }
                if(gd2.b) {
                    int v56 = gd2.e;
                    if(v56 == 3) {
                        v57 = dd2.d[gd2.g];
                    }
                    else {
                        v57 = v56 == 2 ? dd2.c[gd2.h] : dd2.b[gd2.i];
                    }
                    paint0.setColor(v57);
                    v58 = v47;
                    v59 = v43;
                    v60 = v42;
                    canvas0.drawRect(((float)v41), ((float)v42), ((float)v45), ((float)v46), paint0);
                }
                else {
                    v58 = v47;
                    v60 = v42;
                    v59 = v43;
                }
                arrayList1.add(new F3(null, null, null, Bitmap.createBitmap(((id)object0).g, v41, v60, v59, v58), ((float)v60) / ((float)b0.b), 0, 0, ((float)v41) / ((float)b0.a), 0, 0x80000000, -3.402823E+38f, ((float)v59) / ((float)b0.a), ((float)v58) / ((float)b0.b), false, 0xFF000000, 0x80000000, 0.0f, null, null));
                canvas0.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas0.restore();
            }
            list0 = Collections.unmodifiableList(arrayList1);
        }
        t40 = z1;
        super(list0, 4);
        return t40;
    }
}

