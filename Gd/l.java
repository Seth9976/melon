package gd;

import Ac.p2;
import Cc.P3;
import Cc.R3;
import F.s;
import O.j;
import X0.u;
import X0.x;
import Yc.D;
import android.content.Context;
import android.text.TextUtils;
import androidx.compose.foundation.S;
import cd.X;
import com.iloen.melon.custom.B1;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.response.AppBanerListRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v4x.response.DjTagPlylstListRes.RESPONSE.PLYLSTLIST;
import com.iloen.melon.net.v4x.response.DjTagPlylstListRes.RESPONSE;
import com.iloen.melon.net.v5x.response.DjTagInformV5Res.RESPONSE.RELTAGLIST;
import com.iloen.melon.net.v5x.response.DjThemeListRecmTagRes.RESPONSE.RECMTAGLIST;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.C1;
import com.melon.ui.D1;
import com.melon.ui.G1;
import com.melon.ui.H4;
import com.melon.ui.I4;
import com.melon.ui.J1;
import com.melon.ui.Y1;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.k2;
import com.melon.ui.z1;
import ie.H;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import je.p;
import je.w;
import kotlin.jvm.internal.q;
import m0.b;
import we.k;

public final class l implements k {
    public final int a;
    public final Object b;
    public final Object c;

    public l(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        w w0;
        o6 o60;
        int v1;
        Y5 y51;
        Y5 y50;
        H h0 = H.a;
        Object object1 = this.c;
        Object object2 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.h(((x)object0), ((gd.x)object2).c + " " + "프로필 사진");
                return h0;
            }
            case 1: {
                q.g(((R3)object0), "state");
                String s = ((gd.H)object2).a;
                if(s != null && ((k)object1) != null) {
                    boolean z = ((R3)object0).equals(P3.h);
                    ((k)object1).invoke(new U(s, ((gd.H)object2).f, z));
                }
                return h0;
            }
            case 2: {
                return b0.c(((b0)object2), ((g1)object1), ((d1)object0));
            }
            case 3: {
                q.g(((R3)object0), "state");
                String s1 = ((c0)object2).a;
                if(s1 != null && ((k)object1) != null) {
                    boolean z1 = ((R3)object0).equals(P3.h);
                    ((k)object1).invoke(new n0(s1, ((c0)object2).f, z1));
                }
                return h0;
            }
            case 4: {
                return u0.c(((u0)object2), ((g1)object1), ((d1)object0));
            }
            case 5: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                S s2 = new S(27, new B1(15), ((B0)object2).a);
                X x0 = new X(((B0)object2).a, 18);
                b b0 = new b(0xBEF78951, new Yc.l(((B0)object2).a, 9, ((k)object1)), true);
                ((j)(((O.w)object0))).u(((B0)object2).a.size(), s2, x0, b0);
                return h0;
            }
            case 6: {
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof Y1 || ((k2)object0) instanceof z1 || ((k2)object0) instanceof J1 || ((k2)object0) instanceof D1) {
                    D d0 = new D(1, ((I0)object2), I0.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 23);
                    ((I0)object2).getClass();
                    ((I0)object2).a.x(((I0)object2), d0, ((zd.q)object1), ((k2)object0));
                }
                return h0;
            }
            case 7: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                S s3 = new S(29, new B1(17), ((i1)object2).a);
                X x1 = new X(((i1)object2).a, 20);
                b b1 = new b(0xBEF78951, new Yc.l(((i1)object2).a, 11, ((k)object1)), true);
                ((j)(((O.w)object0))).u(((i1)object2).a.size(), s3, x1, b1);
                return h0;
            }
            case 8: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                y1 y10 = new y1(0, new B1(18), ((gd.D1)object2).d);
                X x2 = new X(((gd.D1)object2).d, 21);
                b b2 = new b(0xBEF78951, new Yc.l(((gd.D1)object2).d, 12, ((k)object1)), true);
                ((j)(((O.w)object0))).u(((gd.D1)object2).d.size(), y10, x2, b2);
                return h0;
            }
            case 9: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                y1 y11 = new y1(1, new B1(19), ((h2)object2).a);
                s s4 = new s(22, ((h2)object2).a);
                b b3 = new b(0xBEF78951, new a2(((h2)object2).a, ((k)object1), 0), true);
                ((j)(((O.w)object0))).u(((h2)object2).a.size(), y11, s4, b3);
                return h0;
            }
            case 10: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                y1 y12 = new y1(2, new B1(20), ((u2)object2).a);
                X x3 = new X(((u2)object2).a, 22);
                b b4 = new b(0xBEF78951, new Yc.l(((u2)object2).a, 13, ((k)object1)), true);
                ((j)(((O.w)object0))).u(((u2)object2).a.size(), y12, x3, b4);
                return h0;
            }
            case 11: {
                q.g(((O.w)object0), "$this$MelonLazyColumn");
                s s5 = new s(23, ((E2)object2).a);
                b b5 = new b(0xDA480CDF, new a2(((E2)object2).a, ((k)object1), 1), true);
                ((j)(((O.w)object0))).u(((E2)object2).a.size(), null, s5, b5);
                return h0;
            }
            case 12: {
                q.g(((vd.w)object0), "clickEvent");
                ((k3)object2).sendUserEvent(new A3(((H4)(((I4)object1))).a, ((vd.w)object0).a));
                return h0;
            }
            case 13: {
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof Y1 || ((k2)object0) instanceof z1 || ((k2)object0) instanceof J1 || ((k2)object0) instanceof D1) {
                    Z0 z00 = new Z0(1, ((k3)object2), k3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 29);
                    ((k3)object2).getClass();
                    ((k3)object2).a.x(((k3)object2), z00, ((zd.q)object1), ((k2)object0));
                }
                return h0;
            }
            case 14: {
                return E3.c(((g1)object2), ((E3)object1), ((d1)object0));
            }
            case 15: {
                q.g(((vd.w)object0), "clickEvent");
                ((H3)object2).sendUserEvent(new Y3(((H4)(((I4)object1))).a, ((vd.w)object0).a));
                return h0;
            }
            case 16: {
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof Y1 || ((k2)object0) instanceof z1 || ((k2)object0) instanceof J1 || ((k2)object0) instanceof D1) {
                    j3 j30 = new j3(1, ((H3)object2), H3.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 8);
                    ((H3)object2).getClass();
                    ((H3)object2).a.x(((H3)object2), j30, ((zd.q)object1), ((k2)object0));
                }
                return h0;
            }
            case 17: {
                int v = (int)(((Integer)object0));
                if(((k)object2) != null) {
                    ((k)object2).invoke(new T3(((M3)object1), v));
                }
                return h0;
            }
            case 18: {
                return f4.c(((g1)object2), ((f4)object1), ((d1)object0));
            }
            case 19: {
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof Y1 || ((k2)object0) instanceof z1 || ((k2)object0) instanceof J1 || ((k2)object0) instanceof D1) {
                    j3 j31 = new j3(1, ((l4)object2), l4.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 17);
                    ((l4)object2).getClass();
                    ((l4)object2).e.x(((l4)object2), j31, ((zd.q)object1), ((k2)object0));
                }
                return h0;
            }
            case 20: {
                return B4.c(((B4)object2), ((g1)object1), ((d1)object0));
            }
            case 21: {
                q.g(((vd.w)object0), "clickEvent");
                ((F4)object2).sendUserEvent(new S4(((H4)(((I4)object1))).a, ((vd.w)object0).a));
                return h0;
            }
            case 22: {
                ((k)object2).invoke(new P4(((K4)object1), ((int)(((Integer)object0)))));
                return h0;
            }
            case 23: {
                return d5.c(((d5)object2), ((g1)object1), ((d1)object0));
            }
            case 24: {
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof Y1 || ((k2)object0) instanceof z1 || ((k2)object0) instanceof J1 || ((k2)object0) instanceof D1) {
                    v5 v50 = new v5(1, ((R5)object2), R5.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 1);
                    ((R5)object2).getClass();
                    ((R5)object2).a.x(((R5)object2), v50, ((zd.q)object1), ((k2)object0));
                }
                return h0;
            }
            case 25: {
                q.g(((d1)object0), "fetchResult");
                if(((d1)object0) instanceof c1) {
                    RESPONSE djTagPlylstListRes$RESPONSE0 = (RESPONSE)((c1)(((d1)object0))).a;
                    ArrayList arrayList2 = new ArrayList();
                    if(((g1)object2) instanceof f1) {
                        arrayList2.add(new W5(((n6)object1).h, ((List)((n6)object1).k.getValue())));
                    }
                    ((n6)object1).j = djTagPlylstListRes$RESPONSE0.lastIndexKey;
                    Pc.b b6 = ((n6)object1).a;
                    ArrayList arrayList3 = djTagPlylstListRes$RESPONSE0.plylstList;
                    q.f(arrayList3, "plylstList");
                    ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList3));
                    for(Object object4: arrayList3) {
                        boolean z2 = q.b(((PLYLSTLIST)object4).seriesYn, "Y");
                        String s6 = ((PLYLSTLIST)object4).plylstseq;
                        String s7 = ((PLYLSTLIST)object4).thumbimg;
                        if(((n6)object1).i != null) {
                            q.f("%s곡", "getString(...)");
                            String s8 = String.format("%s곡", Arrays.copyOf(new Object[]{((PLYLSTLIST)object4).songcnt}, 1));
                            String s9 = ((PLYLSTLIST)object4).plylsttitle;
                            String s10 = StringUtils.getTrimmed(((PLYLSTLIST)object4).ownernickname, 13);
                            String s11 = StringUtils.getCountString(((PLYLSTLIST)object4).likecnt, -1);
                            ArrayList arrayList5 = ((PLYLSTLIST)object4).taglist;
                            if(arrayList5 == null) {
                                y50 = null;
                            }
                            else {
                                TagInfoBase tagInfoBase0 = (TagInfoBase)p.n0(0, arrayList5);
                                if(tagInfoBase0 != null) {
                                    y50 = new Y5(tagInfoBase0.tagSeq, tagInfoBase0.tagName);
                                }
                            }
                            ArrayList arrayList6 = ((PLYLSTLIST)object4).taglist;
                            if(arrayList6 == null) {
                                y51 = null;
                            }
                            else {
                                TagInfoBase tagInfoBase1 = (TagInfoBase)p.n0(1, arrayList6);
                                if(tagInfoBase1 != null) {
                                    y51 = new Y5(tagInfoBase1.tagSeq, tagInfoBase1.tagName);
                                }
                            }
                            arrayList4.add(Boolean.valueOf(arrayList2.add(new V5(z2, s6, s7, s8, s9, s10, s11, y50, y51, ((PLYLSTLIST)object4).ownermemberkey, ((PLYLSTLIST)object4).fameregyn, ((PLYLSTLIST)object4).withdrawyn, ((PLYLSTLIST)object4).upyn, ((PLYLSTLIST)object4).statsElements, ((PLYLSTLIST)object4).delYn))));
                            continue;
                        }
                        q.m("context");
                        throw null;
                    }
                    b6.d(arrayList2, djTagPlylstListRes$RESPONSE0.hasMore);
                    return new c6(p.P0(b6.a));
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new a6(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((n6)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new i.n.i.b.a.s.e.M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new b6(((b1)(((d1)object0))).a);
            }
            case 26: {
                q.g(((O.w)object0), "$this$MelonLazyRow");
                y1 y13 = new y1(8, new B1(29), ((u6)object2).g);
                X x4 = new X(((u6)object2).g, 27);
                b b7 = new b(0xBEF78951, new p2(((u6)object2).g, ((u6)object2), ((k)object1), 8), true);
                ((j)(((O.w)object0))).u(((u6)object2).g.size(), y13, x4, b7);
                return h0;
            }
            case 27: {
                if(((d1)object0) instanceof c1) {
                    com.iloen.melon.net.v5x.response.DjTagInformV5Res.RESPONSE djTagInformV5Res$RESPONSE0 = (com.iloen.melon.net.v5x.response.DjTagInformV5Res.RESPONSE)((c1)(((d1)object0))).a;
                    String s12 = String.format("#%s", Arrays.copyOf(new Object[]{djTagInformV5Res$RESPONSE0.tagName}, 1));
                    String s13 = djTagInformV5Res$RESPONSE0.imgUrl;
                    com.iloen.melon.net.v4x.response.AppBanerListRes.RESPONSE appBanerListRes$RESPONSE0 = (com.iloen.melon.net.v4x.response.AppBanerListRes.RESPONSE)((kotlin.jvm.internal.H)object2).a;
                    if(appBanerListRes$RESPONSE0 == null) {
                        o60 = null;
                    }
                    else {
                        ArrayList arrayList7 = appBanerListRes$RESPONSE0.contentsList;
                        if(arrayList7 == null) {
                            o60 = null;
                        }
                        else {
                            CONTENTSLIST appBanerListRes$RESPONSE$CONTENTSLIST0 = (CONTENTSLIST)p.m0(arrayList7);
                            if(appBanerListRes$RESPONSE$CONTENTSLIST0 == null) {
                                o60 = null;
                            }
                            else {
                                MelonLinkInfo melonLinkInfo0 = MelonLinkInfo.a(appBanerListRes$RESPONSE$CONTENTSLIST0, appBanerListRes$RESPONSE$CONTENTSLIST0.menuId);
                                if(TextUtils.isEmpty(appBanerListRes$RESPONSE$CONTENTSLIST0.bgcolor)) {
                                    Context context0 = ((C6)object1).h;
                                    if(context0 != null) {
                                        v1 = ColorUtils.getColor(context0, 0x7F06002C);  // color:bg_banner
                                        goto label_214;
                                    }
                                    q.m("context");
                                    throw null;
                                }
                                else {
                                    v1 = melonLinkInfo0.l;
                                }
                            label_214:
                                o60 = new o6(appBanerListRes$RESPONSE$CONTENTSLIST0.imgurl, v1, appBanerListRes$RESPONSE$CONTENTSLIST0.menuId, melonLinkInfo0, appBanerListRes$RESPONSE$CONTENTSLIST0.banerseq, appBanerListRes$RESPONSE$CONTENTSLIST0.contstypecode, appBanerListRes$RESPONSE$CONTENTSLIST0.contsid);
                            }
                        }
                    }
                    String s14 = StringUtils.getCountString(djTagInformV5Res$RESPONSE0.plylstCnt, -1);
                    String s15 = djTagInformV5Res$RESPONSE0.genreCode;
                    ArrayList arrayList8 = djTagInformV5Res$RESPONSE0.relTagList;
                    q.f(arrayList8, "relTagList");
                    ArrayList arrayList9 = new ArrayList(je.q.Q(10, arrayList8));
                    for(Object object5: arrayList8) {
                        arrayList9.add(new r6(((RELTAGLIST)object5).tagSeq, String.format("#%s", Arrays.copyOf(new Object[]{((RELTAGLIST)object5).tagName}, 1))));
                    }
                    return new u6(s12, s13, o60, s14, s15, false, arrayList9, ((C6)object1).i);
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new s6(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((C6)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new i.n.i.b.a.s.e.M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new t6(((b1)(((d1)object0))).a);
            }
            case 28: {
                q.g(((k2)object0), "popupEvent");
                if(((k2)object0) instanceof Y1 || ((k2)object0) instanceof G1 || ((k2)object0) instanceof C1 || ((k2)object0) instanceof z1 || ((k2)object0) instanceof J1 || ((k2)object0) instanceof D1) {
                    v5 v51 = new v5(1, ((J6)object2), J6.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 10);
                    ((J6)object2).getClass();
                    ((J6)object2).c.x(((J6)object2), v51, ((zd.q)object1), ((k2)object0));
                }
                return h0;
            }
            default: {
                q.g(((d1)object0), "fetchResult");
                if(((d1)object0) instanceof c1) {
                    ResponseBase responseBase0 = ((c1)(((d1)object0))).a;
                    com.iloen.melon.net.v5x.response.DjThemeListRecmTagRes.RESPONSE djThemeListRecmTagRes$RESPONSE0 = responseBase0 instanceof com.iloen.melon.net.v5x.response.DjThemeListRecmTagRes.RESPONSE ? ((com.iloen.melon.net.v5x.response.DjThemeListRecmTagRes.RESPONSE)responseBase0) : null;
                    ArrayList arrayList0 = new ArrayList();
                    if(!((List)object2).isEmpty()) {
                        arrayList0.addAll(((List)object2));
                    }
                    if(djThemeListRecmTagRes$RESPONSE0 == null) {
                        w0 = w.a;
                    }
                    else {
                        ArrayList arrayList1 = djThemeListRecmTagRes$RESPONSE0.recommnedTagList;
                        if(arrayList1 == null) {
                            w0 = w.a;
                        }
                        else {
                            w0 = new ArrayList(je.q.Q(10, arrayList1));
                            for(Object object3: arrayList1) {
                                ((ArrayList)w0).add(new a7(((RECMTAGLIST)object3).tagSeq, ((RECMTAGLIST)object3).tagName));
                            }
                        }
                    }
                    if(!w0.isEmpty()) {
                        arrayList0.add(new b7(((O7)object1).g.a(0x7F13065A)));  // string:melondj_recommend_tag "추천태그"
                        arrayList0.addAll(w0);
                    }
                    return new h7(arrayList0, w0, null, ((O7)object1).k);
                }
                if(((d1)object0) instanceof com.melon.ui.Z0) {
                    return new f7(((com.melon.ui.Z0)(((d1)object0))).a);
                }
                if(((d1)object0) instanceof a1) {
                    ((O7)object1).cancelFetch();
                    return null;
                }
                if(!(((d1)object0) instanceof b1)) {
                    throw new i.n.i.b.a.s.e.M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return new g7(((b1)(((d1)object0))).a);
            }
        }
    }
}

