package ad;

import Hd.F0;
import I7.c;
import Md.f;
import Sc.b;
import T2.a;
import Vb.p0;
import Vc.B;
import Yc.D;
import androidx.lifecycle.f0;
import cd.B1;
import cd.B2;
import cd.C0;
import cd.F;
import cd.G0;
import cd.G1;
import cd.H2;
import cd.K0;
import cd.O2;
import cd.P2;
import cd.Q1;
import cd.R0;
import cd.R1;
import cd.V;
import cd.X0;
import cd.Z2;
import cd.a1;
import cd.b1;
import cd.c0;
import cd.c2;
import cd.d0;
import cd.d2;
import cd.j0;
import cd.j1;
import cd.m0;
import cd.m1;
import cd.n2;
import cd.u2;
import co.ab180.airbridge.Airbridge;
import com.iloen.melon.custom.L0;
import com.iloen.melon.custom.S0;
import com.iloen.melon.net.v5x.response.FlexibleRes.OfferType;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Header;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible;
import com.iloen.melon.net.v5x.response.FlexibleRes;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.HEADER;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.LOGO;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINECONTENT;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY.OFFERING;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.STRATEGY;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TABTITLE;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAGCONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO.CONTENTS;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.VIDEO;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE;
import com.iloen.melon.net.v6x.response.BannerRes;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.FeedType;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.LISTFEED;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.NOTICE;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes.Response;
import com.iloen.melon.net.v6x.response.MainTopNotificationRes;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MusicTabPrefsHelper;
import com.melon.ui.Q;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import db.g;
import dd.A;
import dd.C;
import dd.K;
import dd.M;
import dd.N;
import dd.O;
import dd.P;
import dd.T;
import dd.U;
import dd.W;
import dd.h;
import dd.i;
import dd.j;
import dd.l;
import dd.m;
import dd.o;
import dd.t;
import dd.u;
import dd.x;
import dd.y;
import dd.z;
import e;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import je.w;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mb.k;
import p8.s;
import va.e0;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lad/q0;", "LSc/b;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class q0 extends b {
    public final k g;
    public final S0 h;
    public final c i;
    public final E j;
    public final p k;
    public final Q l;
    public final StringProviderImpl m;
    public LOGO n;
    public final p0.p o;
    public static final int p;

    public q0(k k0, S0 s00, c c0, E e0, p p0, Q q0, StringProviderImpl stringProviderImpl0, s2 s20, g g0, n n0) {
        q.g(k0, "loginUseCase");
        q.g(p0, "musicTabLogHelper");
        q.g(s20, "playlistManager");
        q.g(n0, "userEventHelper");
        super();
        this.g = k0;
        this.h = s00;
        this.i = c0;
        this.j = e0;
        this.k = p0;
        this.l = q0;
        this.m = stringProviderImpl0;
        LogU logU0 = new LogU("MusicTabViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        p0.p p1 = new p0.p();
        this.o = p1;
        p1.clear();
        n0.a = new D(1, this, q0.class, "onUserEvent", "onUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 10);
        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new ad.Q(this, null), 3, null);
    }

    @Override  // com.melon.ui.k1
    public final f cacheServiceType() {
        return f.i;
    }

    public static final void d(q0 q00, ArrayList arrayList0) {
        s s0 = q00.k.b;
        String s1 = s0 == null ? null : s0.c;
        if(s1 == null) {
            s1 = "";
        }
        com.melon.ui.n n0 = new com.melon.ui.n(arrayList0, s1, true, false, null, 0x60);
        a a0 = f0.h(q00);
        D d0 = new D(1, q00, q0.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 12);
        q00.l.d(n0, a0, d0);
    }

    public static final ArrayList e(q0 q00, RESPONSE mainMusicRes$RESPONSE0, Na.f f0, Na.f f1, Na.f f2, Na.f f3) {
        String s33;
        String s30;
        e e1;
        ArrayList arrayList12;
        ArrayList arrayList11;
        ArrayList arrayList10;
        Object object15;
        Flexible flexibleRes$RESPONSE$Flexible0;
        j1 j10;
        ArrayList arrayList9;
        ArrayList arrayList7;
        Z2 z20;
        Q1 q10;
        cd.s2 s20;
        n2 n20;
        B2 b22;
        ArrayList arrayList5;
        O2 o20;
        int v7;
        VIDEO mainMusicRes$RESPONSE$VIDEO0;
        VIDEO mainMusicRes$RESPONSE$VIDEO2;
        String s10;
        String s8;
        u2 u20;
        c2 c20;
        Iterator iterator2;
        B2 b21;
        B2 b20;
        ArrayList arrayList1;
        q00.getClass();
        ArrayList arrayList0 = new ArrayList();
        E e0 = q00.j;
        int v = arrayList0.size();
        e0.getClass();
        q.g(f3, "topNotificationResult");
        T t0 = e0.v;
        if(t0 != null) {
            if(f3 instanceof Na.e) {
                Object object0 = ((Na.e)f3).a;
                MainTopNotificationRes mainTopNotificationRes0 = object0 instanceof MainTopNotificationRes ? ((MainTopNotificationRes)object0) : null;
                Response mainTopNotificationRes$Response0 = mainTopNotificationRes0 == null ? null : mainTopNotificationRes0.getResponse();
                if((mainTopNotificationRes$Response0 == null ? null : mainTopNotificationRes$Response0.getNotice()) == null) {
                    List list0 = mainTopNotificationRes$Response0 == null ? null : mainTopNotificationRes$Response0.getFeedList();
                    if(list0 == null || list0.isEmpty()) {
                        b20 = null;
                    }
                    else {
                        goto label_15;
                    }
                }
                else {
                label_15:
                    NOTICE mainTopNotificationRes$NOTICE0 = mainTopNotificationRes$Response0 == null ? null : mainTopNotificationRes$Response0.getNotice();
                    String s = mainTopNotificationRes$NOTICE0 == null ? null : mainTopNotificationRes$NOTICE0.getOfferSeq();
                    if(s == null) {
                        mainTopNotificationRes$NOTICE0 = null;
                    }
                    else {
                        HashMap hashMap0 = MusicTabPrefsHelper.INSTANCE.getTopNotification();
                        if(hashMap0 != null) {
                            Long long0 = (Long)hashMap0.get(s);
                            if(long0 != null && System.currentTimeMillis() <= ((long)long0) + 86400000L) {
                                mainTopNotificationRes$NOTICE0 = null;
                            }
                        }
                    }
                    List list1 = mainTopNotificationRes$Response0 == null ? null : mainTopNotificationRes$Response0.getFeedList();
                    if(list1 == null || list1.isEmpty()) {
                        arrayList1 = null;
                    }
                    else {
                        arrayList1 = new ArrayList();
                        for(Object object1: list1) {
                            LISTFEED mainTopNotificationRes$LISTFEED0 = (LISTFEED)object1;
                            if(FeedType.BADGE == mainTopNotificationRes$LISTFEED0.getType()) {
                                Long long1 = (Long)MusicTabPrefsHelper.INSTANCE.getTopNotificationBadge().get("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c");
                                if(long1 != null && System.currentTimeMillis() <= ((long)long1) + 86400000L) {
                                    continue;
                                }
                                arrayList1.add(mainTopNotificationRes$LISTFEED0);
                            }
                            else {
                                HashMap hashMap1 = MusicTabPrefsHelper.INSTANCE.getTopNotification();
                                Long long2 = hashMap1 == null ? null : ((Long)hashMap1.get("babd0ba7dd565228f61fcb42013ea86b59112a9c950e0c9cfc536709ea4e4d4c"));
                                if(long2 == null || System.currentTimeMillis() > ((long)long2) + 86400000L) {
                                    arrayList1.add(mainTopNotificationRes$LISTFEED0);
                                }
                            }
                        }
                    }
                    if(mainTopNotificationRes$NOTICE0 != null || arrayList1 != null && !arrayList1.isEmpty()) {
                        t0.e = v;
                        t0.f = mainTopNotificationRes$Response0 == null ? null : mainTopNotificationRes$Response0.getStatsElements();
                        b20 = new B2(mainTopNotificationRes$NOTICE0, arrayList1, new C8.e(t0, v, 11));
                    }
                    else {
                        b20 = null;
                    }
                }
            }
            else {
                b20 = null;
            }
            List list2 = mainMusicRes$RESPONSE0.getSlotDpList();
            if(list2 != null) {
                Iterator iterator1 = list2.iterator();
                while(iterator1.hasNext()) {
                    Object object2 = iterator1.next();
                    String s1 = (String)object2;
                    r.a.getClass();
                    r r0 = R6.c.c(s1);
                    w w0 = w.a;
                    String s2 = "";
                    switch((r0 == null ? -1 : S.a[r0.ordinal()])) {
                        case -1: {
                            b21 = b20;
                            iterator2 = iterator1;
                            break;
                        }
                        case 1: {
                            b21 = b20;
                            iterator2 = iterator1;
                            V v1 = e0.b(mainMusicRes$RESPONSE0, arrayList0.size());
                            if(v1 != null) {
                                arrayList0.add(v1);
                            }
                            break;
                        }
                        case 2: {
                            b21 = b20;
                            iterator2 = iterator1;
                            B1 b10 = e0.d(mainMusicRes$RESPONSE0, arrayList0.size());
                            if(b10 != null) {
                                arrayList0.add(b10);
                            }
                            break;
                        }
                        case 3: {
                            b21 = b20;
                            iterator2 = iterator1;
                            m1 m10 = e0.c(f1, arrayList0.size());
                            if(m10 != null) {
                                arrayList0.add(m10);
                            }
                            break;
                        }
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: {
                            b21 = b20;
                            iterator2 = iterator1;
                            F f4 = e0.a(mainMusicRes$RESPONSE0, arrayList0.size(), s1);
                            if(f4 != null) {
                                arrayList0.add(f4);
                            }
                            break;
                        }
                        case 8: {
                            b21 = b20;
                            iterator2 = iterator1;
                            int v2 = arrayList0.size();
                            e0.getClass();
                            q.g(mainMusicRes$RESPONSE0, "mainMusicFetchResult");
                            A a0 = e0.x;
                            a1 a10 = null;
                            if(a0 == null) {
                                q.m("footerSlotController");
                                throw null;
                            }
                            FOOTER mainMusicRes$RESPONSE$FOOTER0 = mainMusicRes$RESPONSE0.getFooter();
                            if(mainMusicRes$RESPONSE$FOOTER0 != null) {
                                a0.e = v2;
                                a0.f = mainMusicRes$RESPONSE$FOOTER0.getStatsElements();
                                String s3 = mainMusicRes$RESPONSE$FOOTER0.getText1();
                                String s4 = "";
                                if(s3 == null) {
                                    s3 = "";
                                }
                                String s5 = mainMusicRes$RESPONSE$FOOTER0.getText2();
                                if(s5 != null) {
                                    s4 = s5;
                                }
                                a10 = new a1(s3, s4, new z(mainMusicRes$RESPONSE$FOOTER0, 0));
                            }
                            if(a10 != null) {
                                arrayList0.add(a10);
                                break;
                            }
                            break;
                        }
                        case 9: {
                            b21 = b20;
                            iterator2 = iterator1;
                            int v3 = arrayList0.size();
                            M m0 = e0.i;
                            if(m0 == null) {
                                q.m("strategySlotController");
                                throw null;
                            }
                            STRATEGY mainMusicRes$RESPONSE$STRATEGY0 = mainMusicRes$RESPONSE0.getStrategy();
                            if(mainMusicRes$RESPONSE$STRATEGY0 == null) {
                                c20 = null;
                            }
                            else {
                                List list3 = mainMusicRes$RESPONSE$STRATEGY0.getOfferingList();
                                if(list3 != null) {
                                    m0.e = v3;
                                    STRATEGY mainMusicRes$RESPONSE$STRATEGY1 = mainMusicRes$RESPONSE0.getStrategy();
                                    m0.f = mainMusicRes$RESPONSE$STRATEGY1 == null ? null : mainMusicRes$RESPONSE$STRATEGY1.getStatsElements();
                                    if(!list3.isEmpty()) {
                                        ArrayList arrayList2 = new ArrayList(je.q.Q(10, list3));
                                        int v4 = 0;
                                        for(Object object3: list3) {
                                            if(v4 >= 0) {
                                                arrayList2.add(new R1(((OFFERING)object3), new F0(((OFFERING)object3), m0, v4, 21)));
                                                ++v4;
                                                continue;
                                            }
                                            e.k.O();
                                            throw null;
                                        }
                                        c20 = new c2(arrayList2);
                                    }
                                }
                            }
                            if(c20 != null) {
                                arrayList0.add(c20);
                                break;
                            }
                            break;
                        }
                        case 10: {
                            b21 = b20;
                            iterator2 = iterator1;
                            if(b21 == null) {
                                q.g(f0, "topBannerResult");
                                dd.Q q0 = e0.f;
                                if(q0 == null) {
                                    q.m("topBannerSlotController");
                                    throw null;
                                }
                                if(f0 instanceof Na.e) {
                                    Object object4 = ((Na.e)f0).a;
                                    BannerRes bannerRes0 = object4 instanceof BannerRes ? ((BannerRes)object4) : null;
                                    if(bannerRes0 != null) {
                                        com.iloen.melon.net.v6x.response.BannerRes.RESPONSE bannerRes$RESPONSE0 = bannerRes0.getResponse();
                                        List list4 = bannerRes$RESPONSE0 == null ? null : bannerRes$RESPONSE0.getBannerList();
                                        if(list4 != null && !list4.isEmpty()) {
                                            u20 = new u2(bannerRes0, new p0(19, bannerRes0, q0));
                                        }
                                    }
                                }
                                else {
                                    u20 = null;
                                }
                                if(u20 != null) {
                                    arrayList0.add(u20);
                                    break;
                                }
                            }
                            break;
                        }
                        case 11: {
                            b21 = b20;
                            iterator2 = iterator1;
                            int v5 = arrayList0.size();
                            e0.getClass();
                            q.g(mainMusicRes$RESPONSE0, "mainMusicFetchResult");
                            dd.a a1 = e0.e;
                            cd.r r1 = null;
                            if(a1 == null) {
                                q.m("chartSlotController");
                                throw null;
                            }
                            MELONCHART mainMusicRes$RESPONSE$MELONCHART0 = mainMusicRes$RESPONSE0.getMelonChart();
                            List list5 = mainMusicRes$RESPONSE$MELONCHART0 == null ? null : mainMusicRes$RESPONSE$MELONCHART0.getCharts();
                            a1.e = v5;
                            a1.f = mainMusicRes$RESPONSE$MELONCHART0 == null ? null : mainMusicRes$RESPONSE$MELONCHART0.getStatsElements();
                            if(list5 != null && !list5.isEmpty()) {
                                String s6 = mainMusicRes$RESPONSE$MELONCHART0.getTitle();
                                List list6 = mainMusicRes$RESPONSE$MELONCHART0.getCharts();
                                if(list6 == null) {
                                    s8 = "";
                                }
                                else {
                                    Chart mainMusicRes$RESPONSE$MELONCHART$Chart0 = (Chart)je.p.m0(list6);
                                    if(mainMusicRes$RESPONSE$MELONCHART$Chart0 != null) {
                                        ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 = mainMusicRes$RESPONSE$MELONCHART$Chart0.getHeader();
                                        if(mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 != null) {
                                            String s7 = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0.subTitle;
                                            if(s7 != null) {
                                                s8 = s7;
                                            }
                                        }
                                    }
                                }
                                if(mainMusicRes$RESPONSE$MELONCHART0.getUseHighlightIcon()) {
                                    String s9 = mainMusicRes$RESPONSE$MELONCHART0.getHighLightIconImg();
                                    if(s9 != null) {
                                        s10 = s9;
                                    }
                                }
                                else {
                                    s10 = "";
                                }
                                r1 = new cd.r(new Cc.M((s6 == null ? "" : s6), s8, s10, 26.0f, 26.0f, null, null, 0x3876), mainMusicRes$RESPONSE$MELONCHART0, new B(a1, 27), new p0(17, a1, list5));
                            }
                            if(r1 != null) {
                                arrayList0.add(r1);
                                break;
                            }
                            break;
                        }
                        case 12: 
                        case 13: 
                        case 14: {
                            b21 = b20;
                            iterator2 = iterator1;
                            int v6 = arrayList0.size();
                            r r2 = R6.c.c(s1);
                            if(r2 == null || e.k.A(new r[]{r.f, r.g, r.h}).contains(r2)) {
                                switch((r2 == null ? -1 : ad.D.a[r2.ordinal()])) {
                                    case 5: {
                                        v7 = 0;
                                        VIDEO mainMusicRes$RESPONSE$VIDEO1 = mainMusicRes$RESPONSE0.getVideo_1();
                                        if(mainMusicRes$RESPONSE$VIDEO1 != null) {
                                            mainMusicRes$RESPONSE$VIDEO1.setSlotName("");
                                        }
                                        mainMusicRes$RESPONSE$VIDEO2 = mainMusicRes$RESPONSE0.getVideo_1();
                                        mainMusicRes$RESPONSE$VIDEO0 = mainMusicRes$RESPONSE$VIDEO2;
                                        break;
                                    }
                                    case 6: {
                                        v7 = 0;
                                        VIDEO mainMusicRes$RESPONSE$VIDEO3 = mainMusicRes$RESPONSE0.getVideo_2();
                                        if(mainMusicRes$RESPONSE$VIDEO3 != null) {
                                            mainMusicRes$RESPONSE$VIDEO3.setSlotName("");
                                        }
                                        mainMusicRes$RESPONSE$VIDEO2 = mainMusicRes$RESPONSE0.getVideo_2();
                                        mainMusicRes$RESPONSE$VIDEO0 = mainMusicRes$RESPONSE$VIDEO2;
                                        break;
                                    }
                                    case 7: {
                                        VIDEO mainMusicRes$RESPONSE$VIDEO4 = mainMusicRes$RESPONSE0.getVideo_3();
                                        if(mainMusicRes$RESPONSE$VIDEO4 == null) {
                                            v7 = 0;
                                        }
                                        else {
                                            v7 = 0;
                                            mainMusicRes$RESPONSE$VIDEO4.setSlotName("");
                                        }
                                        mainMusicRes$RESPONSE$VIDEO0 = mainMusicRes$RESPONSE0.getVideo_3();
                                        break;
                                    }
                                    default: {
                                        mainMusicRes$RESPONSE$VIDEO0 = null;
                                        v7 = 0;
                                    }
                                }
                                if(mainMusicRes$RESPONSE$VIDEO0 != null) {
                                    dd.V v8 = e0.t;
                                    if(v8 == null) {
                                        q.m("videoSlotController");
                                        throw null;
                                    }
                                    List list7 = mainMusicRes$RESPONSE$VIDEO0.getContents();
                                    if(list7 != null) {
                                        HEADER mainMusicRes$RESPONSE$HEADER0 = mainMusicRes$RESPONSE$VIDEO0.getHeader();
                                        bd.s s11 = mainMusicRes$RESPONSE$HEADER0 == null ? null : new bd.s(mainMusicRes$RESPONSE$HEADER0, new U(mainMusicRes$RESPONSE$HEADER0, mainMusicRes$RESPONSE$VIDEO0, v8, v6, 0), new U(mainMusicRes$RESPONSE$HEADER0, mainMusicRes$RESPONSE$VIDEO0, v8, v6, 1), null, 0x4FE);
                                        if(!list7.isEmpty()) {
                                            ArrayList arrayList3 = new ArrayList(je.q.Q(10, list7));
                                            Iterator iterator4 = list7.iterator();
                                            while(true) {
                                                int v9 = v7;
                                                if(!iterator4.hasNext()) {
                                                    break;
                                                }
                                                Object object5 = iterator4.next();
                                                v7 = v9 + 1;
                                                if(v9 >= 0) {
                                                    arrayList3.add(new H2(((CONTENTS)object5), new m(v8, ((CONTENTS)object5), mainMusicRes$RESPONSE$VIDEO0, v6, v9)));
                                                    continue;
                                                }
                                                e.k.O();
                                                throw null;
                                            }
                                            o20 = new O2(s11, arrayList3);
                                        }
                                    }
                                }
                            }
                            else {
                                o20 = null;
                            }
                            if(o20 != null) {
                                arrayList0.add(o20);
                            }
                            break;
                        }
                        case 15: {
                            iterator2 = iterator1;
                            int v10 = arrayList0.size();
                            O o0 = e0.h;
                            if(o0 == null) {
                                q.m("tagSlotController");
                                throw null;
                            }
                            o0.e = v10;
                            TAG mainMusicRes$RESPONSE$TAG0 = mainMusicRes$RESPONSE0.getTag();
                            if(mainMusicRes$RESPONSE$TAG0 == null) {
                                b21 = b20;
                                n20 = null;
                            }
                            else {
                                o0.f = mainMusicRes$RESPONSE$TAG0.getStatsElements();
                                List list8 = mainMusicRes$RESPONSE$TAG0.getContents();
                                if(list8 != null && !list8.isEmpty()) {
                                    HEADER mainMusicRes$RESPONSE$HEADER1 = mainMusicRes$RESPONSE$TAG0.getHeader();
                                    bd.s s12 = mainMusicRes$RESPONSE$HEADER1 == null ? null : new bd.s(mainMusicRes$RESPONSE$HEADER1, new N(mainMusicRes$RESPONSE$HEADER1, o0, 0), new N(mainMusicRes$RESPONSE$HEADER1, o0, 1), null, 0x4FE);
                                    List list9 = mainMusicRes$RESPONSE$TAG0.getContents();
                                    if(list9 != null) {
                                        ArrayList arrayList4 = new ArrayList(je.q.Q(10, list9));
                                        int v11 = 0;
                                        for(Object object6: list9) {
                                            if(v11 >= 0) {
                                                com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS mainMusicRes$RESPONSE$TAG$CONTENTS0 = (com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.TAG.CONTENTS)object6;
                                                List list10 = mainMusicRes$RESPONSE$TAG$CONTENTS0.getPlayLists();
                                                if(list10 == null) {
                                                    b22 = b20;
                                                    arrayList5 = w0;
                                                }
                                                else {
                                                    arrayList5 = new ArrayList(je.q.Q(10, list10));
                                                    int v12 = 0;
                                                    for(Object object7: list10) {
                                                        if(v12 >= 0) {
                                                            arrayList5.add(new d2(((TAGCONTENTS)object7), new m(o0, v11, v12, ((TAGCONTENTS)object7), mainMusicRes$RESPONSE$TAG$CONTENTS0)));
                                                            ++v12;
                                                            continue;
                                                        }
                                                        e.k.O();
                                                        throw null;
                                                    }
                                                    b22 = b20;
                                                }
                                                arrayList4.add(arrayList5);
                                                ++v11;
                                                b20 = b22;
                                                continue;
                                            }
                                            e.k.O();
                                            throw null;
                                        }
                                        w0 = arrayList4;
                                    }
                                    b21 = b20;
                                    n20 = new n2(s12, list8, w0, new z(o0, 3));
                                }
                            }
                            if(n20 != null) {
                                arrayList0.add(n20);
                                break;
                            }
                            break;
                        }
                        case 16: {
                            iterator2 = iterator1;
                            int v13 = arrayList0.size();
                            P p0 = e0.a;
                            if(p0 == null) {
                                q.m("titleSlotController");
                                throw null;
                            }
                            TABTITLE mainMusicRes$RESPONSE$TABTITLE0 = mainMusicRes$RESPONSE0.getTabTitle();
                            if(mainMusicRes$RESPONSE$TABTITLE0 == null) {
                                s20 = null;
                            }
                            else {
                                p0.e = v13;
                                String s13 = mainMusicRes$RESPONSE$TABTITLE0.getTitle();
                                if(s13 != null && s13.length() != 0) {
                                    String s14 = mainMusicRes$RESPONSE$TABTITLE0.getTitle();
                                    if(s14 != null) {
                                        s2 = s14;
                                    }
                                    s20 = new cd.s2(s2, mainMusicRes$RESPONSE$TABTITLE0.getReplaceText());
                                }
                            }
                            if(s20 != null) {
                                arrayList0.add(s20);
                                b21 = b20;
                                break;
                            }
                            b21 = b20;
                            break;
                        }
                        case 17: {
                            iterator2 = iterator1;
                            int v14 = arrayList0.size();
                            K k0 = e0.b;
                            if(k0 == null) {
                                q.m("popularSongSlotController");
                                throw null;
                            }
                            POPULARSONG mainMusicRes$RESPONSE$POPULARSONG0 = mainMusicRes$RESPONSE0.getPopularSong();
                            List list11 = mainMusicRes$RESPONSE$POPULARSONG0 == null ? null : mainMusicRes$RESPONSE$POPULARSONG0.getContents();
                            k0.e = v14;
                            POPULARSONG mainMusicRes$RESPONSE$POPULARSONG1 = mainMusicRes$RESPONSE0.getPopularSong();
                            k0.f = mainMusicRes$RESPONSE$POPULARSONG1 == null ? null : mainMusicRes$RESPONSE$POPULARSONG1.getStatsElements();
                            if(list11 == null || list11.isEmpty()) {
                                q10 = null;
                            }
                            else {
                                HEADER mainMusicRes$RESPONSE$HEADER2 = mainMusicRes$RESPONSE$POPULARSONG0.getHeader();
                                String s15 = mainMusicRes$RESPONSE$HEADER2 == null ? null : mainMusicRes$RESPONSE$HEADER2.title;
                                Cc.M m1 = new Cc.M((s15 == null ? "" : s15), null, null, 0.0f, 0.0f, null, null, 0x3FFE);
                                ArrayList arrayList6 = new ArrayList(je.q.Q(10, list11));
                                int v15 = 0;
                                for(Object object8: list11) {
                                    if(v15 >= 0) {
                                        arrayList6.add(new G1(v15, ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.POPULARSONG.CONTENTS)object8), new z(k0, 2)));
                                        ++v15;
                                        continue;
                                    }
                                    e.k.O();
                                    throw null;
                                }
                                q10 = new Q1(m1, arrayList6);
                            }
                            if(q10 != null) {
                                arrayList0.add(q10);
                                b21 = b20;
                                break;
                            }
                            b21 = b20;
                            break;
                        }
                        case 18: {
                            iterator2 = iterator1;
                            WEEKLYDJ mainMusicRes$RESPONSE$WEEKLYDJ0 = mainMusicRes$RESPONSE0.getWeeklyDj();
                            int v16 = arrayList0.size();
                            W w1 = e0.w;
                            if(w1 == null) {
                                q.m("weeklyDjSlotController");
                                throw null;
                            }
                            if(mainMusicRes$RESPONSE$WEEKLYDJ0 == null) {
                                z20 = null;
                            }
                            else {
                                Collection collection0 = mainMusicRes$RESPONSE$WEEKLYDJ0.getContents();
                                if(collection0 != null && !collection0.isEmpty()) {
                                    w1.e = v16;
                                    w1.f = mainMusicRes$RESPONSE$WEEKLYDJ0.getStatsElements();
                                    HEADER mainMusicRes$RESPONSE$HEADER3 = mainMusicRes$RESPONSE$WEEKLYDJ0.getHeader();
                                    bd.s s16 = mainMusicRes$RESPONSE$HEADER3 == null ? null : new bd.s(mainMusicRes$RESPONSE$HEADER3, new b9.a(w1, 27), new Zc.N(25, w1, mainMusicRes$RESPONSE$HEADER3), null, 0x4FE);
                                    List list12 = mainMusicRes$RESPONSE$WEEKLYDJ0.getContents();
                                    if(list12 != null) {
                                        w0 = new ArrayList(je.q.Q(10, list12));
                                        int v17 = 0;
                                        for(Object object9: list12) {
                                            if(v17 >= 0) {
                                                ((ArrayList)w0).add(new P2(((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.WEEKLYDJ.CONTENTS)object9), new C8.e(w1, v17, 12)));
                                                ++v17;
                                                continue;
                                            }
                                            e.k.O();
                                            throw null;
                                        }
                                    }
                                    z20 = new Z2(s16, w0);
                                }
                            }
                            if(z20 != null) {
                                arrayList0.add(z20);
                                b21 = b20;
                                break;
                            }
                            b21 = b20;
                            break;
                        }
                        case 19: {
                            iterator2 = iterator1;
                            if(b20 != null) {
                                arrayList0.add(b20);
                            }
                            b21 = b20;
                            break;
                        }
                        case 20: {
                            iterator2 = iterator1;
                            int v18 = arrayList0.size();
                            C c0 = e0.u;
                            if(c0 == null) {
                                q.m("magazineSlotController");
                                throw null;
                            }
                            MAGAZINE mainMusicRes$RESPONSE$MAGAZINE0 = mainMusicRes$RESPONSE0.getMagazine();
                            if(mainMusicRes$RESPONSE$MAGAZINE0 == null) {
                                j10 = null;
                            }
                            else {
                                c0.e = v18;
                                MAGAZINE mainMusicRes$RESPONSE$MAGAZINE1 = mainMusicRes$RESPONSE0.getMagazine();
                                c0.f = mainMusicRes$RESPONSE$MAGAZINE1 == null ? null : mainMusicRes$RESPONSE$MAGAZINE1.getStatsElements();
                                HEADER mainMusicRes$RESPONSE$HEADER4 = mainMusicRes$RESPONSE$MAGAZINE0.getHeader();
                                bd.s s17 = mainMusicRes$RESPONSE$HEADER4 == null ? null : new bd.s(mainMusicRes$RESPONSE$HEADER4, new dd.B(mainMusicRes$RESPONSE$HEADER4, c0, 0), new dd.B(mainMusicRes$RESPONSE$HEADER4, c0, 1), null, 0x4FE);
                                List list13 = mainMusicRes$RESPONSE$MAGAZINE0.getContents();
                                if(list13 != null && !list13.isEmpty() == 1) {
                                    List list14 = mainMusicRes$RESPONSE$MAGAZINE0.getContents();
                                    if(list14 == null) {
                                        arrayList7 = w0;
                                    }
                                    else {
                                        arrayList7 = new ArrayList(je.q.Q(10, list14));
                                        for(Object object10: list14) {
                                            String s18 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS)object10).getTitle();
                                            if(s18 == null) {
                                                s18 = "";
                                            }
                                            arrayList7.add(s18);
                                        }
                                    }
                                    List list15 = mainMusicRes$RESPONSE$MAGAZINE0.getContents();
                                    if(list15 != null) {
                                        ArrayList arrayList8 = new ArrayList(je.q.Q(10, list15));
                                        int v19 = 0;
                                        for(Object object11: list15) {
                                            if(v19 >= 0) {
                                                List list16 = ((com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MAGAZINE.CONTENTS)object11).getMagazineList();
                                                if(list16 == null) {
                                                    arrayList9 = w0;
                                                }
                                                else {
                                                    arrayList9 = new ArrayList(je.q.Q(10, list16));
                                                    int v20 = 0;
                                                    for(Object object12: list16) {
                                                        if(v20 >= 0) {
                                                            arrayList9.add(new b1(((MAGAZINECONTENT)object12), new m(((MAGAZINECONTENT)object12), c0, v20, v19, mainMusicRes$RESPONSE$MAGAZINE0)));
                                                            ++v20;
                                                            continue;
                                                        }
                                                        e.k.O();
                                                        throw null;
                                                    }
                                                }
                                                arrayList8.add(arrayList9);
                                                ++v19;
                                                continue;
                                            }
                                            e.k.O();
                                            throw null;
                                        }
                                        w0 = arrayList8;
                                    }
                                    j10 = new j1(s17, arrayList7, w0);
                                }
                            }
                            if(j10 != null) {
                                arrayList0.add(j10);
                                b21 = b20;
                                break;
                            }
                            b21 = b20;
                            break;
                        }
                        case 21: 
                        case 22: 
                        case 23: 
                        case 24: 
                        case 25: 
                        case 26: 
                        case 27: 
                        case 28: 
                        case 29: 
                        case 30: {
                            int v21 = arrayList0.size();
                            q.g(f2, "flexibleResult");
                            r r3 = R6.c.c(s1);
                            if(r3 == null || !e.k.A(new r[]{r.i, r.j, r.k, r.l, r.m, r.n, r.o, r.r, r.w, r.B}).contains(r3) || !(f2 instanceof Na.e)) {
                            label_732:
                                iterator2 = iterator1;
                                object15 = null;
                            }
                            else {
                                Object object13 = ((Na.e)f2).a;
                                FlexibleRes flexibleRes0 = object13 instanceof FlexibleRes ? ((FlexibleRes)object13) : null;
                                if(flexibleRes0 == null) {
                                    flexibleRes$RESPONSE$Flexible0 = null;
                                }
                                else {
                                    com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE flexibleRes$RESPONSE0 = flexibleRes0.getResponse();
                                    if(flexibleRes$RESPONSE0 != null) {
                                        List list17 = flexibleRes$RESPONSE0.getFlexibleList();
                                        if(list17 != null) {
                                            for(Object object14: je.p.Q0(list17)) {
                                                if(!q.b(((Flexible)object14).getSlotId(), s1)) {
                                                    continue;
                                                }
                                                goto label_485;
                                            }
                                            object14 = null;
                                        label_485:
                                            flexibleRes$RESPONSE$Flexible0 = (Flexible)object14;
                                        }
                                    }
                                }
                                if(flexibleRes$RESPONSE$Flexible0 == null) {
                                    iterator2 = iterator1;
                                    object15 = null;
                                    goto label_734;
                                }
                                else {
                                    OfferType flexibleRes$OfferType0 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                    switch((flexibleRes$OfferType0 == null ? -1 : ad.D.b[flexibleRes$OfferType0.ordinal()])) {
                                        case 1: {
                                            iterator2 = iterator1;
                                            dd.g g0 = e0.k;
                                            if(g0 != null) {
                                                object15 = g0.p(flexibleRes$RESPONSE$Flexible0, v21);
                                                goto label_734;
                                            }
                                            q.m("flexibleBasicSlotController");
                                            throw null;
                                        }
                                        case 2: {
                                            iterator2 = iterator1;
                                            dd.r r4 = e0.p;
                                            if(r4 != null) {
                                                r4.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                r4.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                r4.e = v21;
                                                OfferType flexibleRes$OfferType1 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                int v22 = flexibleRes$OfferType1 == null ? 0 : flexibleRes$OfferType1.getSetNum();
                                                Header flexibleRes$RESPONSE$Flexible$Header0 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                String s19 = flexibleRes$RESPONSE$Flexible$Header0 == null ? null : flexibleRes$RESPONSE$Flexible$Header0.getOfferSeq();
                                                Header flexibleRes$RESPONSE$Flexible$Header1 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                bd.s s20_1 = flexibleRes$RESPONSE$Flexible$Header1 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header1, new dd.q(flexibleRes$RESPONSE$Flexible$Header1, r4, 0), new dd.q(flexibleRes$RESPONSE$Flexible$Header1, r4, 1), null, 0x4FE);
                                                List list18 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                if(list18 == null) {
                                                    arrayList10 = null;
                                                }
                                                else {
                                                    arrayList10 = new ArrayList(je.q.Q(10, list18));
                                                    int v23 = 0;
                                                    for(Object object16: list18) {
                                                        if(v23 >= 0) {
                                                            arrayList10.add(new e(((Content)object16), false, new m(r4, ((Content)object16), v23, s19, v22, 2)));
                                                            ++v23;
                                                            continue;
                                                        }
                                                        e.k.O();
                                                        throw null;
                                                    }
                                                }
                                                object15 = new G0(s20_1, arrayList10);
                                                goto label_734;
                                            }
                                            q.m("flexibleSpecialSlotController");
                                            throw null;
                                        }
                                        case 3: {
                                            iterator2 = iterator1;
                                            dd.g g1 = e0.k;
                                            if(g1 != null) {
                                                object15 = g1.p(flexibleRes$RESPONSE$Flexible0, v21);
                                                goto label_734;
                                            }
                                            q.m("flexibleBasicSlotController");
                                            throw null;
                                        }
                                        case 4: {
                                            iterator2 = iterator1;
                                            y y0 = e0.q;
                                            if(y0 != null) {
                                                y0.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                y0.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                y0.e = v21;
                                                OfferType flexibleRes$OfferType2 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                int v24 = flexibleRes$OfferType2 == null ? 0 : flexibleRes$OfferType2.getSetNum();
                                                Header flexibleRes$RESPONSE$Flexible$Header2 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                String s21 = flexibleRes$RESPONSE$Flexible$Header2 == null ? null : flexibleRes$RESPONSE$Flexible$Header2.getOfferSeq();
                                                Header flexibleRes$RESPONSE$Flexible$Header3 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                bd.s s22 = flexibleRes$RESPONSE$Flexible$Header3 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header3, new x(flexibleRes$RESPONSE$Flexible$Header3, y0, 0), new x(flexibleRes$RESPONSE$Flexible$Header3, y0, 1), new x(flexibleRes$RESPONSE$Flexible$Header3, y0, 2), 0xFE);
                                                List list19 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                Content flexibleRes$RESPONSE$Flexible$Content0 = list19 == null ? null : ((Content)je.p.n0(0, list19));
                                                List list20 = flexibleRes$RESPONSE$Flexible0.getSubContents();
                                                if(list20 == null) {
                                                    arrayList11 = null;
                                                }
                                                else {
                                                    arrayList11 = new ArrayList(je.q.Q(10, list20));
                                                    int v25 = 0;
                                                    for(Object object17: list20) {
                                                        if(v25 >= 0) {
                                                            arrayList11.add(new e(((Content)object17), false, new m(((Content)object17), y0, v25, s21, v24, 4)));
                                                            ++v25;
                                                            continue;
                                                        }
                                                        e.k.O();
                                                        throw null;
                                                    }
                                                }
                                                object15 = new X0(s22, flexibleRes$RESPONSE$Flexible$Content0, arrayList11, new F0(y0, s21, v24, 18));
                                                goto label_734;
                                            }
                                            q.m("flexibleThemeLightSlotController");
                                            throw null;
                                        }
                                        case 5: {
                                            t t1 = e0.r;
                                            if(t1 != null) {
                                                t1.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                t1.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                t1.e = v21;
                                                OfferType flexibleRes$OfferType3 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                int v26 = flexibleRes$OfferType3 == null ? 0 : flexibleRes$OfferType3.getSetNum();
                                                Header flexibleRes$RESPONSE$Flexible$Header4 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                String s23 = flexibleRes$RESPONSE$Flexible$Header4 == null ? null : flexibleRes$RESPONSE$Flexible$Header4.getOfferSeq();
                                                Header flexibleRes$RESPONSE$Flexible$Header5 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                bd.s s24 = flexibleRes$RESPONSE$Flexible$Header5 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header5, null, new dd.s(flexibleRes$RESPONSE$Flexible$Header5, t1, 0), new dd.s(flexibleRes$RESPONSE$Flexible$Header5, t1, 1), 510);
                                                List list21 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                Content flexibleRes$RESPONSE$Flexible$Content1 = list21 == null ? null : ((Content)je.p.n0(0, list21));
                                                List list22 = flexibleRes$RESPONSE$Flexible0.getSubContents();
                                                if(list22 == null) {
                                                    arrayList12 = null;
                                                }
                                                else {
                                                    arrayList12 = new ArrayList(je.q.Q(10, list22));
                                                    int v27 = 0;
                                                    for(Object object18: list22) {
                                                        if(v27 >= 0) {
                                                            arrayList12.add(new e(((Content)object18), false, new m(((Content)object18), t1, v27, s23, v26, 3)));
                                                            ++v27;
                                                            continue;
                                                        }
                                                        e.k.O();
                                                        throw null;
                                                    }
                                                }
                                                iterator2 = iterator1;
                                                object15 = new K0(s24, flexibleRes$RESPONSE$Flexible$Content1, arrayList12, new F0(t1, s23, v26, 16));
                                                goto label_734;
                                            }
                                            q.m("flexibleThemeFullSlotController");
                                            throw null;
                                        }
                                        case 6: {
                                            dd.w w2 = e0.s;
                                            if(w2 != null) {
                                                w2.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                w2.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                w2.e = v21;
                                                OfferType flexibleRes$OfferType4 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                Header flexibleRes$RESPONSE$Flexible$Header6 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                Header flexibleRes$RESPONSE$Flexible$Header7 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                List list23 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                object15 = new R0((flexibleRes$RESPONSE$Flexible$Header7 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header7, null, new u(flexibleRes$RESPONSE$Flexible$Header7, w2, 0), new u(flexibleRes$RESPONSE$Flexible$Header7, w2, 1), 510)), (list23 == null ? null : ((Content)je.p.n0(0, list23))), new F0(w2, (flexibleRes$RESPONSE$Flexible$Header6 == null ? null : flexibleRes$RESPONSE$Flexible$Header6.getOfferSeq()), (flexibleRes$OfferType4 == null ? 0 : flexibleRes$OfferType4.getSetNum()), 17));
                                                iterator2 = iterator1;
                                                goto label_734;
                                            }
                                            q.m("flexibleThemeFullZeroSlotController");
                                            throw null;
                                        }
                                        case 7: {
                                            i i0 = e0.o;
                                            if(i0 != null) {
                                                i0.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                i0.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                i0.e = v21;
                                                OfferType flexibleRes$OfferType5 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                int v28 = flexibleRes$OfferType5 == null ? 0 : flexibleRes$OfferType5.getSetNum();
                                                Header flexibleRes$RESPONSE$Flexible$Header8 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                String s25 = flexibleRes$RESPONSE$Flexible$Header8 == null ? null : flexibleRes$RESPONSE$Flexible$Header8.getOfferSeq();
                                                Header flexibleRes$RESPONSE$Flexible$Header9 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                bd.s s26 = flexibleRes$RESPONSE$Flexible$Header9 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header9, new h(flexibleRes$RESPONSE$Flexible$Header9, i0, 0), new h(flexibleRes$RESPONSE$Flexible$Header9, i0, 1), null, 0x4FE);
                                                List list24 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                if(list24 == null) {
                                                    e1 = null;
                                                }
                                                else {
                                                    Content flexibleRes$RESPONSE$Flexible$Content2 = (Content)je.p.m0(list24);
                                                    if(flexibleRes$RESPONSE$Flexible$Content2 != null) {
                                                        e1 = new e(flexibleRes$RESPONSE$Flexible$Content2, false, new Oc.m(v28, 9, flexibleRes$RESPONSE$Flexible$Content2, i0, s25));
                                                    }
                                                }
                                                object15 = new c0(s26, e1);
                                                iterator2 = iterator1;
                                                goto label_734;
                                            }
                                            q.m("flexibleLiveSlotController");
                                            throw null;
                                        }
                                        case 8: {
                                            dd.p p1 = e0.l;
                                            if(p1 != null) {
                                                p1.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                p1.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                p1.e = v21;
                                                OfferType flexibleRes$OfferType6 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                int v29 = flexibleRes$OfferType6 == null ? 0 : flexibleRes$OfferType6.getSetNum();
                                                Header flexibleRes$RESPONSE$Flexible$Header10 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                String s27 = flexibleRes$RESPONSE$Flexible$Header10 == null ? null : flexibleRes$RESPONSE$Flexible$Header10.getOfferSeq();
                                                Header flexibleRes$RESPONSE$Flexible$Header11 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                bd.s s28 = flexibleRes$RESPONSE$Flexible$Header11 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header11, new o(flexibleRes$RESPONSE$Flexible$Header11, p1, 0), new o(flexibleRes$RESPONSE$Flexible$Header11, p1, 1), null, 1150);
                                                List list25 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                if(list25 != null) {
                                                    ArrayList arrayList13 = new ArrayList(je.q.Q(10, list25));
                                                    int v30 = 0;
                                                    for(Object object19: list25) {
                                                        if(v30 >= 0) {
                                                            arrayList13.add(new cd.q0(((Content)object19), new m(p1, ((Content)object19), v30, s27, v29, 1)));
                                                            ++v30;
                                                            continue;
                                                        }
                                                        e.k.O();
                                                        throw null;
                                                    }
                                                    w0 = arrayList13;
                                                }
                                                object15 = new C0(s28, w0);
                                                iterator2 = iterator1;
                                                goto label_734;
                                            }
                                            q.m("flexibleShortFormSlotController");
                                            throw null;
                                        }
                                        case 9: {
                                            dd.n n0 = e0.m;
                                            if(n0 != null) {
                                                n0.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                n0.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                n0.e = v21;
                                                OfferType flexibleRes$OfferType7 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                int v31 = flexibleRes$OfferType7 == null ? 0 : flexibleRes$OfferType7.getSetNum();
                                                Header flexibleRes$RESPONSE$Flexible$Header12 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                if(flexibleRes$RESPONSE$Flexible$Header12 == null) {
                                                    s30 = "";
                                                }
                                                else {
                                                    String s29 = flexibleRes$RESPONSE$Flexible$Header12.getOfferSeq();
                                                    if(s29 != null) {
                                                        s30 = s29;
                                                    }
                                                }
                                                Header flexibleRes$RESPONSE$Flexible$Header13 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                bd.s s31 = flexibleRes$RESPONSE$Flexible$Header13 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header13, new l(flexibleRes$RESPONSE$Flexible$Header13, n0, 0), new l(flexibleRes$RESPONSE$Flexible$Header13, n0, 1), null, 0x4FE);
                                                List list26 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                if(list26 != null) {
                                                    ArrayList arrayList14 = new ArrayList(je.q.Q(10, list26));
                                                    int v32 = 0;
                                                    for(Object object20: list26) {
                                                        if(v32 >= 0) {
                                                            arrayList14.add(new d0(((Content)object20), new m(n0, v32, s30, v31, ((Content)object20))));
                                                            ++v32;
                                                            continue;
                                                        }
                                                        e.k.O();
                                                        throw null;
                                                    }
                                                    object15 = new m0(s31, arrayList14);
                                                    iterator2 = iterator1;
                                                    goto label_734;
                                                }
                                                object15 = null;
                                                iterator2 = iterator1;
                                                goto label_734;
                                            }
                                            q.m("flexibleMusicWaveSlotController");
                                            throw null;
                                        }
                                        case 10: {
                                            dd.k k1 = e0.n;
                                            if(k1 != null) {
                                                Collection collection1 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                if(collection1 == null || collection1.isEmpty()) {
                                                    object15 = null;
                                                }
                                                else {
                                                    k1.g = flexibleRes$RESPONSE$Flexible0.getSlotId();
                                                    k1.f = flexibleRes$RESPONSE$Flexible0.getStatsElements();
                                                    k1.e = v21;
                                                    OfferType flexibleRes$OfferType8 = flexibleRes$RESPONSE$Flexible0.getOfferType();
                                                    int v33 = flexibleRes$OfferType8 == null ? 0 : flexibleRes$OfferType8.getSetNum();
                                                    Header flexibleRes$RESPONSE$Flexible$Header14 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                    if(flexibleRes$RESPONSE$Flexible$Header14 == null) {
                                                        s33 = "";
                                                    }
                                                    else {
                                                        String s32 = flexibleRes$RESPONSE$Flexible$Header14.getOfferSeq();
                                                        if(s32 != null) {
                                                            s33 = s32;
                                                        }
                                                    }
                                                    Header flexibleRes$RESPONSE$Flexible$Header15 = flexibleRes$RESPONSE$Flexible0.getHeader();
                                                    bd.s s34 = flexibleRes$RESPONSE$Flexible$Header15 == null ? null : new bd.s(flexibleRes$RESPONSE$Flexible$Header15, new j(flexibleRes$RESPONSE$Flexible$Header15, k1, 0), new j(flexibleRes$RESPONSE$Flexible$Header15, k1, 1), null, 0x4FE);
                                                    List list27 = flexibleRes$RESPONSE$Flexible0.getContents();
                                                    if(list27 != null) {
                                                        Content flexibleRes$RESPONSE$Flexible$Content3 = (Content)je.p.k0(list27);
                                                        if(flexibleRes$RESPONSE$Flexible$Content3 != null) {
                                                            object15 = new j0(s34, flexibleRes$RESPONSE$Flexible$Content3, new Oc.m(k1, s33, v33, flexibleRes$RESPONSE$Flexible$Content3, 10));
                                                        }
                                                    }
                                                }
                                                iterator2 = iterator1;
                                                goto label_734;
                                            }
                                            q.m("flexibleMusicWaveSingleSlotController");
                                            throw null;
                                        }
                                        default: {
                                            object15 = null;
                                            iterator2 = iterator1;
                                            goto label_734;
                                        }
                                    }
                                }
                                goto label_732;
                            }
                        label_734:
                            if(object15 != null) {
                                arrayList0.add(object15);
                            }
                            b21 = b20;
                            break;
                        }
                        default: {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                    }
                    iterator1 = iterator2;
                    b20 = b21;
                }
            }
            return arrayList0;
        }
        q.m("topNotificationSlotController");
        throw null;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        L0 l00 = this.getProgressUpdater();
        if(l00 == null) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new b0(this, null), 3, null);
            return H.a;
        }
        l00.a("MusicTabViewModel true", true);
        try {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new b0(this, null), 3, null);
            return H.a;
        }
        finally {
            l00.a("MusicTabViewModel false", false);
        }
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(Pc.e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof com.melon.ui.q) {
            a a0 = f0.h(this);
            D d0 = new D(1, this, q0.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 13);
            this.l.d(((com.melon.ui.q)e0), a0, d0);
            return;
        }
        if(e0 instanceof ad.M) {
            boolean z = ((e0)this.g).m();
            boolean z1 = e1.u.u(((e0)this.g).j()).equals("4");
            Airbridge.trackEvent("airbridge.ecommerce.home.viewed", je.C.S(new ie.m[]{new ie.m("action", Boolean.valueOf(z)), new ie.m("label", Boolean.valueOf(!z1))}), je.C.S(new ie.m[]{new ie.m("", Boolean.valueOf(z)), new ie.m("", Boolean.valueOf(!z1))}));
            return;
        }
        if(e0 instanceof I) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new ad.d0(this, null), 3, null);
            return;
        }
        if(e0 instanceof ad.H) {
            String s = ((ad.H)e0).a;
            if(s == null || s.length() == 0) {
                return;
            }
            ad.m.a.getClass();
            pe.b b0 = ad.m.c;
            if(b0 != null && b0.isEmpty()) {
                return;
            }
            Iterator iterator0 = b0.iterator();
            while(true) {
                if(!iterator0.hasNext()) {
                    return;
                }
                Object object0 = iterator0.next();
                if(!q.b(((ad.m)object0).name(), s)) {
                    continue;
                }
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new ad.f0(this, s, null), 3, null);
                return;
            }
        }
        if(e0 instanceof J) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new h0(this, null), 3, null);
            return;
        }
        if(e0 instanceof L) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new ad.j0(this, null), 3, null);
            return;
        }
        if(e0 instanceof ad.K) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new l0(this, null), 3, null);
            return;
        }
        if(e0 instanceof ad.F) {
            String s1 = ((ad.F)e0).a;
            String s2 = ((ad.F)e0).b;
            String s3 = ((ad.F)e0).c;
            if(s1 == null || s1.length() == 0) {
                return;
            }
            ad.a.a.getClass();
            pe.b b1 = ad.a.c;
            if(b1 != null && b1.isEmpty()) {
                return;
            }
            Iterator iterator1 = b1.iterator();
            while(true) {
                if(!iterator1.hasNext()) {
                    return;
                }
                Object object1 = iterator1.next();
                if(q.b(((ad.a)object1).name(), s1)) {
                    if(s2 == null || s2.length() == 0) {
                        return;
                    }
                    ad.b.a.getClass();
                    pe.b b2 = ad.b.c;
                    if(b2 != null && b2.isEmpty()) {
                        return;
                    }
                    Iterator iterator2 = b2.iterator();
                    while(true) {
                        if(!iterator2.hasNext()) {
                            return;
                        }
                        Object object2 = iterator2.next();
                        if(!q.b(((ad.b)object2).name(), s2)) {
                            continue;
                        }
                        BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new n0(this, s1, s2, s3, null), 3, null);
                        return;
                    }
                }
            }
        }
        if(e0 instanceof G) {
            String s4 = ((G)e0).a;
            if(s4 != null && s4.length() != 0) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new ad.p0(this, s4, null), 3, null);
            }
            return;
        }
        super.onUserEvent(e0);
    }
}

