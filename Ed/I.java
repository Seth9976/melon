package ed;

import Cc.P0;
import Cc.c1;
import Ce.g;
import Ic.z;
import Jc.t0;
import M.j;
import M.w;
import M.y;
import P0.h;
import P0.k;
import Q.B;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.Contents;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.RESPONSE.KeywordList;
import com.melon.net.res.common.SongInfoBase;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import r0.d;
import r0.n;
import we.p;
import xc.f;
import xc.s;
import yc.r;

public final class i implements p {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public i(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v6;
        String s1;
        int v5;
        List list0;
        switch(this.a) {
            case 0: {
                b0 b00 = (b0)this.b;
                e0 e00 = (e0)this.c;
                a z$a0 = (a)this.d;
                ((Integer)object3).getClass();
                q.g(((B)object0), "$this$HorizontalPager");
                g g0 = ((int)(((Integer)object1))) == 0 ? new g(0, 4, 1) : new g(5, 9, 1);  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                y y0 = w.a(j.c, d.m, ((l)object2), 0);
                androidx.compose.runtime.p p0 = (androidx.compose.runtime.p)(((l)object2));
                int v1 = p0.P;
                i0 i00 = p0.m();
                r0.q q0 = r0.a.d(((l)object2), n.a);
                k.y.getClass();
                P0.i i0 = P0.j.b;
                p0.e0();
                if(p0.O) {
                    p0.l(i0);
                }
                else {
                    p0.o0();
                }
                androidx.compose.runtime.w.x(((l)object2), y0, P0.j.f);
                androidx.compose.runtime.w.x(((l)object2), i00, P0.j.e);
                h h1 = P0.j.g;
                if(p0.O || !q.b(p0.N(), v1)) {
                    A7.d.q(v1, p0, v1, h1);
                }
                androidx.compose.runtime.w.x(((l)object2), q0, P0.j.d);
                p0.a0(0x1C422740);
                int v2 = g0.a;
                int v3 = g0.b;
                if(v2 <= v3) {
                    int v4 = v2;
                    while(true) {
                        p0.a0(0x6C030815);
                        fd.a a0 = null;
                        if(((Boolean)b00.getValue()).booleanValue()) {
                            KeywordList searchHotKeywordAndMenuListRes$RESPONSE$KeywordList0 = e00.a.currentHotKeywordList;
                            if(searchHotKeywordAndMenuListRes$RESPONSE$KeywordList0 != null) {
                                list0 = searchHotKeywordAndMenuListRes$RESPONSE$KeywordList0.contents;
                                goto label_52;
                            }
                        }
                        else {
                            KeywordList searchHotKeywordAndMenuListRes$RESPONSE$KeywordList1 = e00.a.yesterdayHotKeywordList;
                            if(searchHotKeywordAndMenuListRes$RESPONSE$KeywordList1 != null) {
                                list0 = searchHotKeywordAndMenuListRes$RESPONSE$KeywordList1.contents;
                                goto label_52;
                            }
                        }
                        list0 = null;
                    label_52:
                        if(list0 == null) {
                            v6 = v4;
                            p0.p(false);
                        }
                        else {
                            Contents searchHotKeywordAndMenuListRes$Contents0 = (Contents)je.p.n0(v4, list0);
                            if(searchHotKeywordAndMenuListRes$Contents0 != null) {
                                try {
                                    String s = searchHotKeywordAndMenuListRes$Contents0.rankingGap;
                                    q.f(s, "rankingGap");
                                    v5 = 0;
                                    v5 = Math.abs(Integer.parseInt(s));
                                    s1 = "";
                                }
                                catch(NumberFormatException unused_ex) {
                                }
                                if(!((Boolean)b00.getValue()).booleanValue()) {
                                    a0 = new fd.a((searchHotKeywordAndMenuListRes$Contents0.rankType == null ? "NONE" : searchHotKeywordAndMenuListRes$Contents0.rankType), (v5 <= 0 ? "" : String.valueOf(v5)));
                                }
                                String s2 = searchHotKeywordAndMenuListRes$Contents0.keyword;
                                if(s2 != null) {
                                    s1 = s2;
                                }
                                boolean z = p0.i(searchHotKeywordAndMenuListRes$Contents0);
                                boolean z1 = p0.i(z$a0);
                                boolean z2 = p0.e(v4);
                                t0 t00 = p0.N();
                                if((z | z1 | z2) != 0 || t00 == androidx.compose.runtime.k.a) {
                                    t0 t01 = new t0(searchHotKeywordAndMenuListRes$Contents0, b00, z$a0, v4, 4);
                                    v6 = v4;
                                    p0.l0(t01);
                                    t00 = t01;
                                }
                                else {
                                    v6 = v4;
                                }
                                z$a0.G(v4 + 1, s1, a0, t00, ((l)object2), 0);
                                p0.p(false);
                            }
                        }
                        if(v6 == v3) {
                            break;
                        }
                        v4 = v6 + 1;
                    }
                }
                p0.p(false);
                p0.p(true);
                return H.a;
            }
            case 1: {
                ArrayList arrayList0 = (ArrayList)this.b;
                z z3 = (z)this.c;
                xc.k k1 = (xc.k)this.d;
                int v7 = (int)(((Integer)object1));
                int v8 = (int)(((Integer)object3));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$items");
                if((v8 & 0x30) == 0) {
                    v8 |= (((androidx.compose.runtime.p)(((l)object2))).e(v7) ? 0x20 : 16);
                }
                boolean z4 = false;
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v8 & 1, (v8 & 0x91) != 0x90)) {
                    Object object4 = arrayList0.get(v7);
                    q.f(object4, "get(...)");
                    boolean z5 = ((androidx.compose.runtime.p)(((l)object2))).i(z3);
                    boolean z6 = ((androidx.compose.runtime.p)(((l)object2))).i(k1);
                    P0 p00 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    V v9 = androidx.compose.runtime.k.a;
                    if(((v8 & 0x70) == 0x20 | z5 | z6) != 0 || p00 == v9) {
                        p00 = new P0(v7, z3, k1, 11);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p00);
                    }
                    boolean z7 = ((androidx.compose.runtime.p)(((l)object2))).i(z3);
                    f f0 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((v8 & 0x70) == 0x20 || z7 || f0 == v9) {
                        f0 = new f(v7, z3, 0);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f0);
                    }
                    boolean z8 = ((androidx.compose.runtime.p)(((l)object2))).i(k1);
                    boolean z9 = ((androidx.compose.runtime.p)(((l)object2))).i(arrayList0);
                    P0 p01 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((z8 | z9 | ((v8 & 0x70) == 0x20 ? 1 : 0)) != 0 || p01 == v9) {
                        p01 = new P0(k1, arrayList0, v7, 12);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p01);
                    }
                    if((v8 & 0x70) == 0x20) {
                        z4 = true;
                    }
                    boolean z10 = ((androidx.compose.runtime.p)(((l)object2))).i(z3);
                    f f1 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z10 || z4 || f1 == v9) {
                        f1 = new f(v7, z3, 1);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f1);
                    }
                    c1.P(((Kd.g)object4), false, false, p00, f0, p01, f1, false, ((androidx.compose.runtime.p)(((l)object2))), 0, 0xFF86);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 2: {
                ArrayList arrayList1 = (ArrayList)this.b;
                z z11 = (z)this.c;
                s s3 = (s)this.d;
                int v10 = (int)(((Integer)object1));
                int v11 = (int)(((Integer)object3));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$items");
                if((v11 & 0x30) == 0) {
                    v11 |= (((androidx.compose.runtime.p)(((l)object2))).e(v10) ? 0x20 : 16);
                }
                boolean z12 = false;
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v11 & 1, (v11 & 0x91) != 0x90)) {
                    Object object5 = arrayList1.get(v10);
                    q.f(object5, "get(...)");
                    boolean z13 = ((androidx.compose.runtime.p)(((l)object2))).i(z11);
                    boolean z14 = ((androidx.compose.runtime.p)(((l)object2))).i(s3);
                    P0 p02 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    V v12 = androidx.compose.runtime.k.a;
                    if(((v11 & 0x70) == 0x20 | z13 | z14) != 0 || p02 == v12) {
                        p02 = new P0(v10, z11, s3, 13);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p02);
                    }
                    boolean z15 = ((androidx.compose.runtime.p)(((l)object2))).i(z11);
                    f f2 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((v11 & 0x70) == 0x20 || z15 || f2 == v12) {
                        f2 = new f(v10, z11, 2);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f2);
                    }
                    boolean z16 = ((androidx.compose.runtime.p)(((l)object2))).i(s3);
                    boolean z17 = ((androidx.compose.runtime.p)(((l)object2))).i(arrayList1);
                    P0 p03 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((z16 | z17 | ((v11 & 0x70) == 0x20 ? 1 : 0)) != 0 || p03 == v12) {
                        p03 = new P0(s3, arrayList1, v10, 14);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p03);
                    }
                    if((v11 & 0x70) == 0x20) {
                        z12 = true;
                    }
                    boolean z18 = ((androidx.compose.runtime.p)(((l)object2))).i(z11);
                    f f3 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z18 || z12 || f3 == v12) {
                        f3 = new f(v10, z11, 3);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f3);
                    }
                    c1.P(((Kd.g)object5), false, false, p02, f2, p03, f3, false, ((androidx.compose.runtime.p)(((l)object2))), 0, 0xFF86);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 3: {
                ArrayList arrayList2 = (ArrayList)this.b;
                z z19 = (z)this.c;
                xc.z z20 = (xc.z)this.d;
                int v13 = (int)(((Integer)object1));
                int v14 = (int)(((Integer)object3));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$items");
                if((v14 & 0x30) == 0) {
                    v14 |= (((androidx.compose.runtime.p)(((l)object2))).e(v13) ? 0x20 : 16);
                }
                boolean z21 = false;
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v14 & 1, (v14 & 0x91) != 0x90)) {
                    Object object6 = arrayList2.get(v13);
                    q.f(object6, "get(...)");
                    boolean z22 = ((androidx.compose.runtime.p)(((l)object2))).i(z19);
                    boolean z23 = ((androidx.compose.runtime.p)(((l)object2))).i(z20);
                    P0 p04 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    V v15 = androidx.compose.runtime.k.a;
                    if(((v14 & 0x70) == 0x20 | z22 | z23) != 0 || p04 == v15) {
                        p04 = new P0(v13, z19, z20, 15);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p04);
                    }
                    boolean z24 = ((androidx.compose.runtime.p)(((l)object2))).i(z19);
                    f f4 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((v14 & 0x70) == 0x20 || z24 || f4 == v15) {
                        f4 = new f(v13, z19, 4);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f4);
                    }
                    boolean z25 = ((androidx.compose.runtime.p)(((l)object2))).i(z20);
                    boolean z26 = ((androidx.compose.runtime.p)(((l)object2))).i(arrayList2);
                    P0 p05 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((z25 | z26 | ((v14 & 0x70) == 0x20 ? 1 : 0)) != 0 || p05 == v15) {
                        p05 = new P0(z20, arrayList2, v13, 16);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p05);
                    }
                    if((v14 & 0x70) == 0x20) {
                        z21 = true;
                    }
                    boolean z27 = ((androidx.compose.runtime.p)(((l)object2))).i(z19);
                    f f5 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z27 || z21 || f5 == v15) {
                        f5 = new f(v13, z19, 5);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f5);
                    }
                    c1.P(((Kd.g)object6), false, false, p04, f4, p05, f5, false, ((androidx.compose.runtime.p)(((l)object2))), 0, 0xFF86);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            case 4: {
                ArrayList arrayList3 = (ArrayList)this.b;
                z z28 = (z)this.c;
                xc.H h2 = (xc.H)this.d;
                int v16 = (int)(((Integer)object1));
                int v17 = (int)(((Integer)object3));
                q.g(((androidx.compose.foundation.lazy.a)object0), "$this$items");
                if((v17 & 0x30) == 0) {
                    v17 |= (((androidx.compose.runtime.p)(((l)object2))).e(v16) ? 0x20 : 16);
                }
                boolean z29 = false;
                if(((androidx.compose.runtime.p)(((l)object2))).Q(v17 & 1, (v17 & 0x91) != 0x90)) {
                    Object object7 = arrayList3.get(v16);
                    q.f(object7, "get(...)");
                    boolean z30 = ((androidx.compose.runtime.p)(((l)object2))).i(z28);
                    boolean z31 = ((androidx.compose.runtime.p)(((l)object2))).i(h2);
                    P0 p06 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    V v18 = androidx.compose.runtime.k.a;
                    if(((v17 & 0x70) == 0x20 | z30 | z31) != 0 || p06 == v18) {
                        p06 = new P0(v16, z28, h2, 17);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p06);
                    }
                    boolean z32 = ((androidx.compose.runtime.p)(((l)object2))).i(z28);
                    f f6 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((v17 & 0x70) == 0x20 || z32 || f6 == v18) {
                        f6 = new f(v16, z28, 6);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f6);
                    }
                    boolean z33 = ((androidx.compose.runtime.p)(((l)object2))).i(h2);
                    boolean z34 = ((androidx.compose.runtime.p)(((l)object2))).i(arrayList3);
                    P0 p07 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if((z33 | z34 | ((v17 & 0x70) == 0x20 ? 1 : 0)) != 0 || p07 == v18) {
                        p07 = new P0(h2, arrayList3, v16, 18);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(p07);
                    }
                    if((v17 & 0x70) == 0x20) {
                        z29 = true;
                    }
                    boolean z35 = ((androidx.compose.runtime.p)(((l)object2))).i(z28);
                    f f7 = ((androidx.compose.runtime.p)(((l)object2))).N();
                    if(z35 || z29 || f7 == v18) {
                        f7 = new f(v16, z28, 7);
                        ((androidx.compose.runtime.p)(((l)object2))).l0(f7);
                    }
                    c1.P(((Kd.g)object7), false, false, p06, f6, p07, f7, false, ((androidx.compose.runtime.p)(((l)object2))), 0, 0xFF86);
                    return H.a;
                }
                ((androidx.compose.runtime.p)(((l)object2))).T();
                return H.a;
            }
            default: {
                we.k k0 = (we.k)this.d;
                int v = (int)(((Integer)object0));
                q.g(((SongInfoBase)object1), "songInfo");
                q.g(((zc.d)object2), "currentEventType");
                ((b0)this.b).setValue(zc.d.f);
                yc.h h0 = new yc.h(((b0)this.b), ((zc.d)object2), null);
                BuildersKt__Builders_commonKt.launch$default(((CoroutineScope)this.c), null, null, h0, 3, null);
                if(!((Boolean)object3).booleanValue() && k0 != null) {
                    k0.invoke(new r(((SongInfoBase)object1), v));
                }
                return H.a;
            }
        }
    }
}

