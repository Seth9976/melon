package hd;

import Cd.t;
import Q1.c;
import Tf.o;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v6x.response.MusicDnaMonthListRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.MusicDnaMainMonthlyLogRes;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYCHART;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYDNA;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYHISTORY;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYRECENTLIST;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYTITLE;
import com.melon.net.res.MusicDnaMainRes.RESPONSE;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.K4;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.g1;
import com.melon.ui.k1;
import com.melon.ui.n4;
import d5.n;
import e1.F;
import gd.v5;
import i.n.i.b.a.s.e.M3;
import ib.f;
import ib.m;
import ie.H;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mb.k;
import ne.a;
import p8.s;
import va.e0;
import va.e;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lhd/m1;", "Lcom/melon/ui/k1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class m1 extends k1 {
    public final f a;
    public final m b;
    public final n4 c;
    public final Q d;
    public final k e;
    public final LogU f;
    public s g;
    public final MutableStateFlow h;
    public final StateFlow i;
    public final MutableStateFlow j;
    public final StateFlow k;
    public ArrayList l;
    public Uri m;
    public static final int n;

    public m1(f f0, F f1, m m0, n4 n40, Q q0, k k0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = f0;
        this.b = m0;
        this.c = n40;
        this.d = q0;
        this.e = k0;
        LogU logU0 = new LogU("MusicDnaMainViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.f = logU0;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow("");
        this.h = mutableStateFlow0;
        this.i = FlowKt.asStateFlow(mutableStateFlow0);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(Boolean.TRUE);
        this.j = mutableStateFlow1;
        this.k = FlowKt.asStateFlow(mutableStateFlow1);
        this.l = new ArrayList();
    }

    public static Y0 c(m1 m10, MusicDnaMainMonthlyLogRes musicDnaMainMonthlyLogRes0, MusicDnaMonthListRes musicDnaMonthListRes0, d1 d10) {
        ArrayList arrayList1;
        String s;
        ArrayList arrayList0 = null;
        q.g(d10, "fetchResult");
        if(d10 instanceof Z0) {
            return new W0(((Z0)d10).a);
        }
        if(d10 instanceof b1) {
            return new V0(c.q(((b1)d10).a));
        }
        if(d10 instanceof c1) {
            RESPONSE musicDnaMainRes$RESPONSE0 = (RESPONSE)((c1)d10).a;
            m10.g = new s(musicDnaMainRes$RESPONSE0.section, musicDnaMainRes$RESPONSE0.page, musicDnaMainRes$RESPONSE0.menuId, null);
            if(musicDnaMainMonthlyLogRes0 == null) {
                s = "";
            }
            else {
                com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE musicDnaMainMonthlyLogRes$RESPONSE0 = musicDnaMainMonthlyLogRes0.response;
                if(musicDnaMainMonthlyLogRes$RESPONSE0 == null) {
                    s = "";
                }
                else {
                    s = musicDnaMainMonthlyLogRes$RESPONSE0.curMonth;
                    if(s == null) {
                        s = "";
                    }
                }
            }
            m10.h.setValue(s);
            if(musicDnaMonthListRes0 == null) {
                arrayList1 = null;
            }
            else {
                com.iloen.melon.net.v6x.response.MusicDnaMonthListRes.RESPONSE musicDnaMonthListRes$RESPONSE0 = musicDnaMonthListRes0.response;
                arrayList1 = musicDnaMonthListRes$RESPONSE0 == null ? null : musicDnaMonthListRes$RESPONSE0.logMonths;
            }
            m10.l = arrayList1;
            com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE musicDnaMainMonthlyLogRes$RESPONSE1 = musicDnaMainMonthlyLogRes0 == null ? null : musicDnaMainMonthlyLogRes0.response;
            com.iloen.melon.net.v6x.response.MusicDnaMonthListRes.RESPONSE musicDnaMonthListRes$RESPONSE1 = musicDnaMonthListRes0 == null ? null : musicDnaMonthListRes0.response;
            ArrayList arrayList2 = new ArrayList();
            String s1 = musicDnaMainRes$RESPONSE0.totCount;
            q.f(s1, "totCount");
            String s2 = musicDnaMainRes$RESPONSE0.intro;
            q.f(s2, "intro");
            arrayList2.add(new N0(s1, s2));
            MYDNA musicDnaMainRes$RESPONSE$MYDNA0 = musicDnaMainRes$RESPONSE0.myDna;
            if(musicDnaMainRes$RESPONSE$MYDNA0 != null) {
                if(musicDnaMainRes$RESPONSE$MYDNA0.card != null && !musicDnaMainRes$RESPONSE$MYDNA0.card.isEmpty()) {
                    q.f("", "getMemberNickName(...)");
                    arrayList2.add(new O0(""));
                }
                arrayList2.add(new P0(musicDnaMainRes$RESPONSE$MYDNA0));
            }
            MYTITLE musicDnaMainRes$RESPONSE$MYTITLE0 = musicDnaMainRes$RESPONSE0.myTitle;
            if(musicDnaMainRes$RESPONSE$MYTITLE0 != null) {
                arrayList2.add(new T0(musicDnaMainRes$RESPONSE$MYTITLE0));
            }
            MYCHART musicDnaMainRes$RESPONSE$MYCHART0 = musicDnaMainRes$RESPONSE0.myChart;
            if(musicDnaMainRes$RESPONSE$MYCHART0 != null) {
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = musicDnaMainRes$RESPONSE$MYCHART0.songList;
                if(arrayList5 != null) {
                    int v = 0;
                    for(Object object0: arrayList5) {
                        if(v >= 0) {
                            arrayList4.add(((SongInfoBase)object0));
                            if((v + 1) % 4 == 0) {
                                arrayList3.add(arrayList4);
                                arrayList4 = new ArrayList();
                            }
                            else if(v == musicDnaMainRes$RESPONSE$MYCHART0.songList.size() - 1 && (v < 4 || v > 7)) {
                                arrayList3.add(arrayList4);
                            }
                            ++v;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                }
                String s3 = musicDnaMainRes$RESPONSE$MYCHART0.title;
                q.f(s3, "title");
                arrayList2.add(new M0(s3, arrayList3));
            }
            MYRECENTLIST musicDnaMainRes$RESPONSE$MYRECENTLIST0 = musicDnaMainRes$RESPONSE0.myRecentList;
            if(musicDnaMainRes$RESPONSE$MYRECENTLIST0 != null) {
                arrayList2.add(new S0(musicDnaMainRes$RESPONSE$MYRECENTLIST0, musicDnaMainRes$RESPONSE0.monthFlag));
            }
            if(musicDnaMainMonthlyLogRes$RESPONSE1 != null) {
                if(musicDnaMonthListRes$RESPONSE1 != null) {
                    arrayList0 = musicDnaMonthListRes$RESPONSE1.logMonths;
                }
                String s4 = musicDnaMainMonthlyLogRes$RESPONSE1.curMonth;
                q.f(s4, "curMonth");
                arrayList2.add(new R0(musicDnaMainMonthlyLogRes$RESPONSE1, arrayList0, m10.e(s4)));
            }
            MYHISTORY musicDnaMainRes$RESPONSE$MYHISTORY0 = musicDnaMainRes$RESPONSE0.myHistory;
            if(musicDnaMainRes$RESPONSE$MYHISTORY0 != null) {
                arrayList2.add(new Q0(musicDnaMainRes$RESPONSE$MYHISTORY0));
            }
            return new X0(arrayList2);
        }
        if(!(d10 instanceof a1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return null;
    }

    public static void d(m1 m10, String s, ActionKind actionKind0, String s1, String s2, String s3, String s4, String s5, String s6, int v) {
        s s7 = m10.g;
        if(s7 != null) {
            e1.m.F(new hd.Z0(s4, s, actionKind0, s7, s1, ((v & 16) == 0 ? s2 : ""), "", s3, "", ((v & 0x80) == 0 ? s5 : ""), s6)).track();
        }
    }

    public final String e(String s) {
        int v = s.length();
        if(v > 1) {
            String s1 = s.substring(v - 2, v);
            q.f(s1, "substring(...)");
            String s2 = e.h(o.N0(s1, "0"), "");
            if(v > 5) {
                String s3 = s.substring(0, 4);
                q.f(s3, "substring(...)");
                String s4 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
                try {
                    q.d(s4);
                    if(Integer.parseInt(s4) > Integer.parseInt(s3)) {
                        String s5 = s3.substring(s3.length() - 2, s3.length());
                        q.f(s5, "substring(...)");
                        return s5 + "" + " " + s2;
                    }
                    return s2;
                }
                catch(NumberFormatException numberFormatException0) {
                    LogU.debug$default(this.f, "number format exception : " + numberFormatException0, null, false, 6, null);
                }
            }
        }
        return "";
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        K4 k41;
        Object object4;
        MusicDnaMonthListRes musicDnaMonthListRes1;
        MusicDnaMainMonthlyLogRes musicDnaMainMonthlyLogRes2;
        int v16;
        L0 l03;
        String s2;
        Deferred deferred12;
        Deferred deferred11;
        L0 l02;
        MusicDnaMonthListRes musicDnaMonthListRes0;
        int v9;
        int v8;
        Deferred deferred7;
        MusicDnaMainMonthlyLogRes musicDnaMainMonthlyLogRes0;
        int v7;
        Deferred deferred5;
        Deferred deferred3;
        int v4;
        String s1;
        int v3;
        m1 m11;
        String s;
        L0 l01;
        int v2;
        m1 m10;
        L0 l00;
        hd.b1 b10;
        if(continuation0 instanceof hd.b1) {
            b10 = (hd.b1)continuation0;
            int v = b10.V;
            if((v & 0x80000000) == 0) {
                b10 = new hd.b1(this, ((oe.c)continuation0));
            }
            else {
                b10.V = v ^ 0x80000000;
            }
        }
        else {
            b10 = new hd.b1(this, ((oe.c)continuation0));
        }
        Object object0 = b10.S;
        a a0 = a.a;
        int v1 = 0;
        switch(b10.V) {
            case 0: {
                n.D(object0);
                l00 = this.getProgressUpdater();
                if(l00 == null) {
                    Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new f1(this, null), 3, null);
                    b10.r = null;
                    b10.w = null;
                    b10.B = this;
                    b10.M = 0;
                    b10.N = 0;
                    b10.V = 1;
                    object0 = deferred0.await(b10);
                    if(object0 == a0) {
                        return a0;
                    }
                    m10 = this;
                    v2 = 0;
                    goto label_55;
                }
                else {
                    l00.a("MusicDnaMainViewModel true", true);
                    try {
                        Deferred deferred1 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new f1(this, null), 3, null);
                        b10.r = l00;
                        b10.w = "MusicDnaMainViewModel";
                        b10.B = this;
                        b10.M = 0;
                        b10.N = 0;
                        b10.V = 5;
                        object0 = deferred1.await(b10);
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        s = "MusicDnaMainViewModel";
                        Y.v(s, " false", l01, false);
                        throw throwable0;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    m11 = this;
                    v3 = 0;
                    s1 = "MusicDnaMainViewModel";
                    v4 = 0;
                    goto label_143;
                }
                break;
            }
            case 1: {
                int v5 = b10.N;
                int v6 = b10.M;
                m10 = b10.B;
                n.D(object0);
                v1 = v6;
                v2 = v5;
            label_55:
                ((Boolean)object0).getClass();
                m10.j.setValue(((Boolean)object0));
                Deferred deferred2 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new hd.d1(this, null), 3, null);
                deferred3 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new e1(this, null), 3, null);
                Deferred deferred4 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new hd.c1(this, null), 3, null);
                b10.r = null;
                b10.w = null;
                b10.B = null;
                b10.D = deferred3;
                b10.E = deferred4;
                b10.M = v1;
                b10.N = v2;
                b10.V = 2;
                object0 = deferred2.await(b10);
                if(object0 == a0) {
                    return a0;
                }
                deferred5 = deferred4;
                v7 = v1;
                goto label_79;
            }
            case 2: {
                v2 = b10.N;
                v7 = b10.M;
                deferred5 = b10.E;
                deferred3 = b10.D;
                Deferred deferred6 = (Deferred)b10.B;
                n.D(object0);
            label_79:
                b10.r = null;
                b10.w = null;
                b10.B = null;
                b10.D = null;
                b10.E = deferred5;
                b10.G = (MusicDnaMainMonthlyLogRes)object0;
                b10.M = v7;
                b10.N = v2;
                b10.V = 3;
                Object object1 = deferred3.await(b10);
                if(object1 == a0) {
                    return a0;
                }
                musicDnaMainMonthlyLogRes0 = (MusicDnaMainMonthlyLogRes)object0;
                object0 = object1;
                deferred7 = deferred5;
                v8 = v7;
                v9 = v2;
                goto label_105;
            }
            case 3: {
                int v10 = b10.N;
                int v11 = b10.M;
                MusicDnaMainMonthlyLogRes musicDnaMainMonthlyLogRes1 = b10.G;
                deferred7 = b10.E;
                Deferred deferred8 = (Deferred)b10.B;
                n.D(object0);
                v9 = v10;
                musicDnaMainMonthlyLogRes0 = musicDnaMainMonthlyLogRes1;
                v8 = v11;
            label_105:
                b10.r = null;
                b10.w = null;
                b10.B = null;
                b10.D = null;
                b10.E = null;
                b10.G = musicDnaMainMonthlyLogRes0;
                b10.I = (MusicDnaMonthListRes)object0;
                b10.M = v8;
                b10.N = v9;
                b10.V = 4;
                Object object2 = deferred7.await(b10);
                if(object2 == a0) {
                    return a0;
                }
                musicDnaMonthListRes0 = (MusicDnaMonthListRes)object0;
                object0 = object2;
                goto label_124;
            }
            case 4: {
                musicDnaMonthListRes0 = b10.I;
                musicDnaMainMonthlyLogRes0 = b10.G;
                Deferred deferred9 = (Deferred)b10.B;
                n.D(object0);
            label_124:
                K4 k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), new com.iloen.melon.player.playlist.mixup.composables.c(this, musicDnaMainMonthlyLogRes0, musicDnaMonthListRes0, 13));
                if(k40 != null) {
                    this.updateUiState(new t(k40, 29));
                    return H.a;
                }
                break;
            }
            case 5: {
                try {
                    int v12 = b10.N;
                    int v13 = b10.M;
                    m1 m12 = b10.B;
                    s1 = b10.w;
                    l02 = b10.r;
                    n.D(object0);
                    v4 = v12;
                    l00 = l02;
                    m11 = m12;
                    v3 = v13;
                }
                catch(Throwable throwable0) {
                    s = s1;
                    l01 = l02;
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_143:
                    ((Boolean)object0).getClass();
                    m11.j.setValue(((Boolean)object0));
                    Deferred deferred10 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new hd.d1(this, null), 3, null);
                    deferred11 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new e1(this, null), 3, null);
                    deferred12 = BuildersKt__Builders_commonKt.async$default(f0.h(this), null, null, new hd.c1(this, null), 3, null);
                    b10.r = l00;
                    b10.w = s1;
                    b10.B = null;
                    b10.D = deferred11;
                    b10.E = deferred12;
                    b10.M = v3;
                    b10.N = v4;
                    b10.V = 6;
                    object0 = deferred10.await(b10);
                    if(object0 != a0) {
                        goto label_173;
                    }
                    return a0;
                }
                catch(Throwable throwable0) {
                    l01 = l00;
                    s = s1;
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
                goto label_173;
            }
            case 6: {
                int v14 = b10.N;
                int v15 = b10.M;
                Deferred deferred13 = b10.E;
                Deferred deferred14 = b10.D;
                Deferred deferred15 = (Deferred)b10.B;
                s2 = b10.w;
                l03 = b10.r;
                try {
                    n.D(object0);
                    v4 = v14;
                    l00 = l03;
                    deferred12 = deferred13;
                    v3 = v15;
                    deferred11 = deferred14;
                    s1 = s2;
                }
                catch(Throwable throwable0) {
                    s = s2;
                    l01 = l03;
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_173:
                    b10.r = l00;
                    b10.w = s1;
                    b10.B = null;
                    b10.D = null;
                    b10.E = deferred12;
                    b10.G = (MusicDnaMainMonthlyLogRes)object0;
                    b10.M = v3;
                    b10.N = v4;
                    b10.V = 7;
                    Object object3 = deferred11.await(b10);
                    if(object3 == a0) {
                        return a0;
                    }
                    v16 = v3;
                    musicDnaMainMonthlyLogRes2 = (MusicDnaMainMonthlyLogRes)object0;
                    object0 = object3;
                    goto label_206;
                }
                catch(Throwable throwable0) {
                    l01 = l00;
                    s = s1;
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
            }
            case 7: {
                int v17 = b10.N;
                int v18 = b10.M;
                musicDnaMainMonthlyLogRes2 = b10.G;
                Deferred deferred16 = b10.E;
                Deferred deferred17 = (Deferred)b10.B;
                s2 = b10.w;
                l03 = b10.r;
                try {
                    n.D(object0);
                    v16 = v18;
                    v4 = v17;
                    l00 = l03;
                    deferred12 = deferred16;
                    s1 = s2;
                }
                catch(Throwable throwable0) {
                    s = s2;
                    l01 = l03;
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
                try {
                label_206:
                    musicDnaMonthListRes1 = (MusicDnaMonthListRes)object0;
                    b10.r = l00;
                    b10.w = s1;
                    b10.B = null;
                    b10.D = null;
                    b10.E = null;
                    b10.G = musicDnaMainMonthlyLogRes2;
                    b10.I = musicDnaMonthListRes1;
                    b10.M = v16;
                    b10.N = v4;
                    b10.V = 8;
                    object4 = deferred12.await(b10);
                    if(object4 == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    l01 = l00;
                    s = s1;
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
                try {
                    l01 = l00;
                    s = s1;
                    k41 = this.handleDefaultHttpResponseResult(((Na.f)object4), new com.iloen.melon.player.playlist.mixup.composables.c(this, musicDnaMainMonthlyLogRes2, musicDnaMonthListRes1, 13));
                    goto label_235;
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
            }
            case 8: {
                MusicDnaMonthListRes musicDnaMonthListRes2 = b10.I;
                MusicDnaMainMonthlyLogRes musicDnaMainMonthlyLogRes3 = b10.G;
                Deferred deferred18 = (Deferred)b10.B;
                s = b10.w;
                l01 = b10.r;
                try {
                    n.D(object0);
                    k41 = this.handleDefaultHttpResponseResult(((Na.f)object0), new com.iloen.melon.player.playlist.mixup.composables.c(this, musicDnaMainMonthlyLogRes3, musicDnaMonthListRes2, 13));
                label_235:
                    if(k41 != null) {
                        this.updateUiState(new t(k41, 29));
                    }
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
                Y.v(s, " false", l01, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(Pc.e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof T) {
            Context context0 = Y.a(MelonAppBase.Companion);
            if(((T)e0) instanceof N) {
                BuildersKt__Builders_commonKt.launch$default(f0.h(this), null, null, new h1(this, context0, e0, null), 3, null);
                return;
            }
            if(((T)e0) instanceof S) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(new hd.g1(CoroutineExceptionHandler.Key, this))), null, null, new i1(this, context0, e0, null), 3, null);
                return;
            }
            if(((T)e0) instanceof O) {
                A8.m m0 = ((O)e0).a;
                String s = m0.d;
                String s1 = m0.a;
                switch(((O)e0).b) {
                    case "ALBUM_THUMB": 
                    case "FAV_SONG": 
                    case "RECNT_SONG": {
                        Navigator.openAlbumInfo(s1);
                        break;
                    }
                    case "HISTORY_TAG": {
                        Navigator.openMelonDJTagHubDetail(s1);
                        break;
                    }
                    case "MONTHLY_LOG": {
                        Navigator.INSTANCE.openMusicDnaMonthlyLog(s1, false);
                        break;
                    }
                    case "MY_CHART": {
                        Navigator.open(new R1());
                        break;
                    }
                    case "MY_HISTORY": 
                    case "MY_TITLE": {
                        MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                        melonLinkInfo0.b = m0.b;
                        melonLinkInfo0.a = m0.c;
                        if(s.length() > 0) {
                            melonLinkInfo0.c = s;
                        }
                        MelonLinkExecutor.open(melonLinkInfo0);
                        break;
                    }
                    case "RECNT_ARTIST": {
                        Navigator.openArtistInfo(s1);
                        break;
                    }
                    case "RECNT_GNR": {
                        Navigator.openGenreDetail(s1);
                        break;
                    }
                    case "SCHEME_BTN": {
                        MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
                        melonLinkInfo1.c = s;
                        MelonLinkExecutor.open(melonLinkInfo1);
                    }
                }
                q.f("페이지이동", "getString(...)");
                ActionKind actionKind0 = ActionKind.ClickContent;
                String s2 = ((O)e0).c.c;
                String s3 = ((O)e0).c.e;
                String s4 = ((O)e0).c.d;
                String s5 = ((O)e0).c.f;
                String s6 = ((O)e0).c.g;
                String s7 = ((O)e0).c.h;
                String s8 = ((O)e0).c.i;
                String s9 = ((O)e0).c.j;
                s s10 = this.g;
                if(s10 != null) {
                    e1.m.F(new hd.Z0(s6, "페이지이동", actionKind0, s10, s2, s3, s4, s5, s9, s7, s8)).track();
                }
                return;
            }
            if(((T)e0) instanceof hd.Q) {
                this.sendUiEvent(new J(((hd.Q)e0).a));
                q.f("음악재생", "getString(...)");
                m1.d(this, "음악재생", ActionKind.PlayMusic, ((hd.Q)e0).b.c, ((hd.Q)e0).b.e, ((hd.Q)e0).b.f, ((hd.Q)e0).b.g, ((hd.Q)e0).b.h, ((hd.Q)e0).b.i, 520);
                return;
            }
            if(!(((T)e0) instanceof P)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            this.sendUiEvent(new I(((P)e0).a));
            return;
        }
        if(e0 instanceof N3) {
            T2.a a0 = f0.h(this);
            boolean z = ((e0)this.e).m();
            v5 v50 = new v5(1, this, m1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 22);
            L0 l00 = this.getProgressUpdater();
            this.c.b(((N3)e0), a0, z, v50, l00);
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            T2.a a1 = f0.h(this);
            v5 v51 = new v5(1, this, m1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 23);
            this.d.d(((com.melon.ui.q)e0), a1, v51);
            return;
        }
        super.onUserEvent(e0);
    }
}

