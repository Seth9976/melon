package gc;

import B0.s;
import Cb.i;
import I6.V;
import L8.h;
import Nb.v0;
import Nb.w0;
import Nb.x0;
import Nb.y0;
import Nb.z0;
import U4.F;
import Ub.c;
import Ub.t;
import Vb.j;
import Vb.n0;
import Vb.o0;
import Vb.q0;
import Vb.t0;
import Vb.u0;
import Vd.w;
import Wb.a;
import android.app.Service;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaRouter2;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import androidx.appcompat.app.o;
import androidx.media3.common.d;
import androidx.media3.common.e;
import b3.N;
import b3.a0;
import b3.b0;
import b3.i0;
import b3.k;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.S0;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventVideo.Started;
import com.iloen.melon.playback.EpPlayLogger;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playback.manager.CastHelper;
import d3.g;
import dd.v;
import e3.b;
import e3.x;
import ie.m;
import ie.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import je.p;
import k8.Y;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import va.e0;

public abstract class y extends e {
    public final Service j;
    public final CoroutineScope k;
    public final LogU l;
    public final r m;
    public final E n;
    public Job o;
    public final r p;
    public final r q;
    public final r r;
    public final r s;
    public final r t;

    public y(Service service0, CoroutineScope coroutineScope0, u0 u00) {
        super(Looper.getMainLooper());
        this.j = service0;
        this.k = coroutineScope0;
        this.l = Companion.create$default(LogU.Companion, "MediaPlayer", false, Category.Playback, 2, null);
        this.m = g.Q(new v(((o0)this)));
        E e0 = new E(service0, new S0(((o0)this), 17), u00);
        this.n = e0;
        this.p = g.Q(new v(16));
        this.q = g.Q(new j(((o0)this), 2));
        this.r = g.Q(new j(((o0)this), 3));
        this.s = g.Q(new j(((o0)this), 4));
        this.t = g.Q(new j(((o0)this), 1));
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new u(((o0)this), null), 3, null);
        c c0 = this.D0();
        z0 z00 = e0.e.a1();
        c0.getClass();
        q.g(z00, "playerType");
        c0.l = z00;
    }

    public final c D0() {
        return (c)this.s.getValue();
    }

    public abstract Comparable E0(b3.E arg1, z0 arg2, oe.c arg3);

    public final ArrayList F0(b3.E e0, long v) {
        V v1 = this.s0().b();
        q.f(v1, "getPlaylist(...)");
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, v1));
        for(Object object0: v1) {
            b0 b00 = (b0)object0;
            if(q.b(b00.c.a, e0.a)) {
                a0 a00 = b00.c();
                long v2 = x.M(v);
                b.c(v2 == 0x8000000000000001L || v2 >= 0L);
                a00.m = v2;
                b00 = new b0(a00);
            }
            arrayList0.add(b00);
        }
        return arrayList0;
    }

    public final void G0(b3.E e0, long v) {
        boolean z2;
        int v5;
        Vb.c c2;
        Nb.u0 u03;
        m m1;
        m m0;
        k k1;
        Nb.u0 u02;
        int v1;
        String s;
        hc.k k0;
        a a0 = new a(e0, v, 1);
        LogConstantsKt.buildInfo$default(this.l, false, a0, 1, null);
        this.B0();
        Job job0 = this.o;
        if(job0 != null) {
            LogU.debug$default(this.l, "cancelPrepareItem()", null, false, 6, null);
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        E e1 = this.n;
        e1.d();
        u0 u00 = ((o0)this).z;
        if(((t)u00.d()).f()) {
            V v2 = ((o0)this).s0().b();
            q.f(v2, "getPlaylist(...)");
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, v2));
            for(Object object0: v2) {
                q.f(((b0)object0).c, "mediaItem");
                arrayList0.add(((b0)object0).c);
            }
            t t0 = (t)u00.d();
            if((t0.c() ? u0.a(e0) : t0.e() && !Vb.c.d(e0) && !Vb.c.c(u00.b(), e0))) {
                k0 = new hc.k(true, hc.j.a, "");
            }
            else {
                boolean z = false;
                t t1 = (t)u00.d();
                if(!t1.c()) {
                    if(t1.e() && !arrayList0.isEmpty()) {
                        for(Object object2: arrayList0) {
                            if(!Vb.c.d(((b3.E)object2)) && !Vb.c.c(u00.b(), ((b3.E)object2))) {
                                z = true;
                                break;
                            }
                        }
                    }
                }
                else if(!arrayList0.isEmpty()) {
                    for(Object object1: arrayList0) {
                        if(u0.a(((b3.E)object1))) {
                            z = true;
                            break;
                        }
                    }
                }
                hc.j j0 = z ? hc.j.c : hc.j.b;
                t t2 = (t)u00.d();
                if(t2.c()) {
                    Uri uri0 = q0.a(F.E(e0));
                    Uri uri1 = Uri.EMPTY;
                    if(uri0.equals(uri1)) {
                        if(Vb.c.d(e0)) {
                            s = "뮤직웨이브는 크롬캐스트 재생 기능을 지원하지 않습니다.";
                            q.d("뮤직웨이브는 크롬캐스트 재생 기능을 지원하지 않습니다.");
                        }
                        else {
                            goto label_70;
                        }
                    }
                    else if(F.M(e0) && !q0.a(F.E(e0)).equals(uri1)) {
                        s = "저장한 비디오는 크롬캐스트 재생 기능을 지원하지 않습니다.";
                        q.d("저장한 비디오는 크롬캐스트 재생 기능을 지원하지 않습니다.");
                    }
                    else {
                        s = "저장한 곡은 크롬캐스트 재생 기능을 지원하지 않습니다.";
                        q.d("저장한 곡은 크롬캐스트 재생 기능을 지원하지 않습니다.");
                    }
                }
                else if(!t2.e()) {
                label_70:
                    s = "";
                }
                else if(Vb.c.c(u00.b(), e0)) {
                    s = "DCF곡은 DLNA 재생 기능을 지원하지 않습니다.";
                    q.d("DCF곡은 DLNA 재생 기능을 지원하지 않습니다.");
                }
                else if(Vb.c.d(e0)) {
                    s = "뮤직웨이브는 DLNA 재생 기능을 지원하지 않습니다.";
                    q.d("뮤직웨이브는 DLNA 재생 기능을 지원하지 않습니다.");
                }
                else {
                    s = "";
                }
                k0 = new hc.k(false, j0, s);
            }
            LogConstantsKt.debugOnlyDebugMode(((o0)this).e1(), "handlePrepareItem() " + F.D(e0) + ", remoteAvailable: " + k0);
            String s1 = k0.c;
            if(s1.length() > 0) {
                ToastManager.show(s1);
            }
            v1 = !k0.a;
            if(!k0.a) {
                switch(k0.b.ordinal()) {
                    case 1: {
                        y.K0(((o0)this), false, 0, null, "handlePrepareItem() Not available remote", 7);
                        break;
                    }
                    case 2: {
                        ((o0)this).q1();
                    }
                }
            }
        }
        else {
            v1 = 0;
        }
        if(v1 == 0) {
            LogU logU0 = e1.d;
            u0 u01 = e1.c;
            t t3 = (t)u01.d();
            boolean z1 = t3.c();
            y0 y00 = y0.b;
            if(z1) {
                u02 = Nb.u0.b;
            }
            else if(t3.e()) {
                u02 = v0.b;
            }
            else {
                u02 = y00;
            }
            if(!u02.equals(y00)) {
                LogConstantsKt.debugOnlyDebugMode(logU0, "getPlayerTypeFromMediaItem() RemoteType: " + i.o(u02));
            }
            else if(F.M(e0)) {
                u02 = x0.b;
            }
            else {
                u02 = w0.b;
            }
            if(q.b(e1.e.a1(), u02)) {
                LogConstantsKt.debugOnlyDebugMode(logU0, "selectPlayerType() Reuse player: " + u02.a());
            }
            else {
                Bf.a a1 = e1.e;
                e1.e = e1.a(u02);
                LogConstantsKt.debugOnlyDebugMode(logU0, "selectPlayerType() Previous player has been released. " + u02.a());
                a1.p1();
                a1.l1();
            }
            z0 z00 = e1.e.a1();
            if(!z00.a) {
                k1 = new w(0).e();
            }
            else if(z00 instanceof Nb.u0) {
                CastHelper castHelper0 = ((t)u01.d()).b;
                k1 = castHelper0.j;
                if(Build.VERSION.SDK_INT >= 30) {
                    MediaRouter2 mediaRouter20 = MediaRouter2.getInstance(castHelper0.a);
                    q.f(mediaRouter20, "getInstance(...)");
                    List list0 = mediaRouter20.getControllers();
                    q.f(list0, "getControllers(...)");
                    if(list0.size() == 2) {
                        w w0 = new w(1);
                        w0.w0(s.g(mediaRouter20.getControllers().get(1)).getId());
                        k1 = w0.e();
                    }
                }
            }
            else if(z00 instanceof v0) {
                k1 = new w(1).e();
            }
            else {
                LogU.error$default(u01.d, "getDeviceInfo() Not supported playerType: " + z00, null, false, 6, null);
                k1 = k.e;
                q.d(k1);
            }
            c c0 = this.D0();
            c0.getClass();
            c0.l = u02;
            this.N0(new h(v, this, e0, k1));
            this.v0();
            LogU.info$default(((o0)this).e1(), o.o("onPreparingMediaItem() ", u02.a(), ", ", F.D(e0)), null, false, 6, null);
            jc.j.c(("onPreparingMediaItem() " + F.D(e0) + ", " + F.E(e0)));
            if(F.M(e0) && !q0.a(F.E(e0)).equals(Uri.EMPTY)) {
                LogU.info$default(((o0)this).e1(), "updateLocalVideoArtworkData() " + F.D(e0), null, false, 6, null);
                n0 n00 = new n0(((o0)this), e0, null);
                BuildersKt__Builders_commonKt.launch$default(((o0)this).u, ((o0)this).x, null, n00, 2, null);
            }
            AtomicReference atomicReference0 = ((o0)this).J;
            Object object3 = atomicReference0.get();
            q.f(object3, "get(...)");
            if(!q.b(((ac.q)object3).a.a, e0.a)) {
                atomicReference0.set(new ac.q(e0, null, null, null, 30));
                ((o0)this).K.set(0);
            }
            kc.h h0 = ((o0)this).B;
            N n0 = e1.m.q(h0);
            MutableStateFlow mutableStateFlow0 = (MutableStateFlow)((o0)this).m.getValue();
            do {
                Object object4 = mutableStateFlow0.getValue();
                d d0 = ((i0)object4).a();
                d0.a = n0;
            }
            while(!o.B(d0, mutableStateFlow0, object4));
            ((o0)this).v0();
            t0 t00 = ((o0)this).F;
            t00.getClass();
            LogU logU1 = t00.c;
            Vb.c c1 = t00.d;
            mb.k k2 = va.o.a();
            if(F.M(e0)) {
                m0 = new m(Boolean.FALSE, "Video Item");
                m1 = m0;
                u03 = u02;
                c2 = c1;
            }
            else if(!((e0)k2).m()) {
                m0 = new m(Boolean.FALSE, "Login User");
                m1 = m0;
                u03 = u02;
                c2 = c1;
            }
            else if(e1.u.u(((e0)k2).j()).equals("4")) {
                m0 = new m(Boolean.FALSE, "Invalid Goods State");
                m1 = m0;
                u03 = u02;
                c2 = c1;
            }
            else {
                MelonAppBase.Companion.getClass();
                Context context0 = k8.t.a().getContext();
                c1.getClass();
                q.g(context0, "context");
                if((SystemSettingUtils.isIgnoringBatteryOptimizations(context0) && !SystemSettingUtils.isBackgroundRestricted(context0) ? SystemSettingUtils.areNotificationsEnabled(context0) : false)) {
                    m0 = new m(Boolean.FALSE, "Ignored System Setting");
                    m1 = m0;
                    u03 = u02;
                    c2 = c1;
                }
                else {
                    MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
                    q.f(melonPrefs0, "getInstance(...)");
                    c2 = c1;
                    long v3 = melonPrefs0.getLong("VERSION_CODE_FOR_OPTIMIZATION", 0L);
                    if(v3 == 260061801L) {
                        MelonPrefs melonPrefs1 = MelonPrefs.getInstance();
                        q.f(melonPrefs1, "getInstance(...)");
                        long v4 = (System.currentTimeMillis() - melonPrefs1.getLong("UsageOptimizationPopupTime", 0L)) / 3600000L;
                        MelonPrefs melonPrefs2 = MelonPrefs.getInstance();
                        q.f(melonPrefs2, "getInstance(...)");
                        String s2 = melonPrefs2.getString("GAP_HOUR_OF_USAGE_OPTIMIZATION", "");
                        if(s2 == null) {
                            v5 = -1;
                        }
                        else {
                            try {
                                v5 = Integer.parseInt(s2);
                            }
                            catch(NumberFormatException unused_ex) {
                                u03 = u02;
                                v5 = 3;
                                goto label_208;
                            }
                        }
                        u03 = u02;
                        if(((long)v5) < 0L) {
                            v5 = 3;
                        }
                    label_208:
                        LogConstantsKt.debugOnlyDebugMode(logU1, "shouldDisplayUsageOptimizationPopup() gapHour: " + v4 + ", interval: " + v5);
                        z2 = v4 >= ((long)v5);
                    }
                    else {
                        LogU.debug$default(t00.c, H0.b.g(v3, "Version code changed: ", " >> 260061801"), null, false, 6, null);
                        u03 = u02;
                        z2 = true;
                    }
                    m1 = z2 ? new m(Boolean.TRUE, "") : new m(Boolean.FALSE, "Skip Optimization Popup");
                }
            }
            boolean z3 = ((Boolean)m1.a).booleanValue();
            String s3 = (String)m1.b;
            if(!z3) {
                LogConstantsKt.debugOnlyDebugMode(logU1, "shouldDisplayUsageOptimizationPopup() " + s3);
            }
            if(z3) {
                c2.getClass();
                MelonPrefs melonPrefs3 = MelonPrefs.getInstance();
                q.f(melonPrefs3, "getInstance(...)");
                melonPrefs3.setLong("VERSION_CODE_FOR_OPTIMIZATION", 260061801L);
                MelonPrefs melonPrefs4 = MelonPrefs.getInstance();
                q.f(melonPrefs4, "getInstance(...)");
                melonPrefs4.setLong("UsageOptimizationPopupTime", System.currentTimeMillis());
                t00.b.b(Xb.e.a);
            }
            EpPlayLogger.INSTANCE.setAnalytics(null, 0L);
            if(((com.melon.playlist.b)h0.a).t() != null && false) {
                LogConstantsKt.debugOnlyDebugMode(((o0)this).e1(), "onPreparingMediaItem() EventVideo.Started");
                EventBusHelper.post(Started.INSTANCE);
            }
            this.M0(this.getPlayWhenReady());
            gc.x x0 = new gc.x(this, e0, u03, null);
            Job job1 = BuildersKt__Builders_commonKt.launch$default(this.k, Dispatchers.getIO(), null, x0, 2, null);
            DefaultImpls.invokeOnCompletion$default(job1, true, false, new n(this, 1), 2, null);
            this.o = job1;
        }
    }

    public final void H0(List list0) {
        b0 b00;
        q.g(list0, "mediaItems");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("handleReplaceMediaItems()");
        i.a(stringBuilder0, "fromIndex: 0");
        i.a(stringBuilder0, "toIndex: 2147483647");
        i.a(stringBuilder0, "mediaItems: " + list0.size());
        LogConstantsKt.infoOnlyDebugMode(this.l, stringBuilder0.toString());
        this.B0();
        int v = this.s0().b().size();
        if(0x7FFFFFFF <= v) {
            v = 0x7FFFFFFF;
        }
        b3.E e0 = this.W();
        String s = e0 == null ? null : e0.a;
        V v1 = this.s0().b();
        q.f(v1, "getPlaylist(...)");
        ArrayList arrayList0 = p.Q0(v1);
        int v2 = 0;
        List list1 = arrayList0.subList(0, v);
        HashMap hashMap0 = new HashMap();
        for(Object object0: list1) {
            hashMap0.put(((b0)object0).c.a, ((b0)object0));
        }
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, list0));
        for(Object object1: list0) {
            b3.E e1 = (b3.E)object1;
            if(hashMap0.containsKey(e1.a)) {
                Object object2 = hashMap0.get(e1.a);
                q.d(object2);
                a0 a00 = ((b0)object2).c();
                a00.c = e1;
                b00 = new b0(a00);
            }
            else {
                b00 = e.p0(e1);
            }
            arrayList1.add(b00);
        }
        list1.clear();
        arrayList0.addAll(0, arrayList1);
        Iterator iterator2 = arrayList0.iterator();
        while(true) {
            if(!iterator2.hasNext()) {
                v2 = -1;
                break;
            }
            Object object3 = iterator2.next();
            if(q.b(((b0)object3).c.a, s)) {
                break;
            }
            ++v2;
        }
        if(v2 != -1) {
            MutableStateFlow mutableStateFlow0 = (MutableStateFlow)this.m.getValue();
            do {
                Object object4 = mutableStateFlow0.getValue();
                d d0 = ((i0)object4).a();
                d0.b(arrayList0);
                d0.y = v2;
            }
            while(!o.B(d0, mutableStateFlow0, object4));
            this.v0();
            return;
        }
        y.K0(this, false, 0, null, "replaceMediaItemsImpl() Changed index", 5);
    }

    public final void I0(long v) {
        LogU.info$default(this.l, va.e.a(v, "seekToPositionImpl() positionMs: "), null, false, 6, null);
        this.B0();
        if(this.getCurrentTimeline().p()) {
            LogU.warn$default(this.l, "seekToPositionImpl() Empty timeline.", null, false, 6, null);
            return;
        }
        E e0 = this.n;
        boolean z = e0.c();
        r r0 = this.m;
        if(z) {
            if(v > -1L && v <= e0.e.Y0()) {
                MutableStateFlow mutableStateFlow0 = (MutableStateFlow)r0.getValue();
                do {
                    Object object0 = mutableStateFlow0.getValue();
                    d d0 = ((i0)object0).a();
                    d0.d = 2;
                    d0.B = v;
                }
                while(!o.B(d0, mutableStateFlow0, object0));
                this.v0();
                n n0 = new n(this, 0);
                LogU.info$default(e0.d, va.e.a(v, "seekToPosition() positionMs: "), null, false, 6, null);
                if(e0.c()) {
                    MutableStateFlow mutableStateFlow1 = e0.f;
                    do {
                        Object object1 = mutableStateFlow1.getValue();
                        q.g(((gc.F)object1), "state");
                    }
                    while(!mutableStateFlow1.compareAndSet(object1, gc.F.a(((gc.F)object1), null, n0, 7)));
                    e0.e.m1(v);
                }
            }
            return;
        }
        MutableStateFlow mutableStateFlow2 = (MutableStateFlow)r0.getValue();
        do {
            Object object2 = mutableStateFlow2.getValue();
            d d1 = ((i0)object2).a();
            d1.B = v;
        }
        while(!o.B(d1, mutableStateFlow2, object2));
        this.v0();
    }

    public final void J0(List list0, int v, long v1) {
        q.g(list0, "mediaItems");
        StringBuilder stringBuilder0 = Y.p("setMediaItemsImpl()");
        i.a(stringBuilder0, "mediaItems: " + list0.size());
        i.a(stringBuilder0, "startIndex: " + v);
        i.a(stringBuilder0, "startPositionMs: " + v1);
        LogU logU0 = this.l;
        LogConstantsKt.infoOnlyDebugMode(logU0, stringBuilder0.toString());
        this.B0();
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object0: list0) {
            arrayList0.add(e.p0(((b3.E)object0)));
        }
        if(v == -1 || v >= arrayList0.size()) {
            v = 0;
        }
        if(v1 == 0x8000000000000001L) {
            v1 = x.Z(((b0)arrayList0.get(v)).l);
        }
        StringBuilder stringBuilder1 = Y.p("setMediaItemsImpl() Adjust");
        i.a(stringBuilder1, "mediaItems: " + arrayList0.size());
        i.a(stringBuilder1, "startIndex: " + v);
        i.a(stringBuilder1, "startPositionMs: " + v1);
        LogConstantsKt.debugOnlyDebugMode(logU0, stringBuilder1.toString());
        y.K0(this, false, 0, null, "setMediaItemsImpl() Adjust", 7);
        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)this.m.getValue();
        do {
            Object object1 = mutableStateFlow0.getValue();
            d d0 = ((i0)object1).a();
            d0.b(arrayList0);
            d0.y = v;
            d0.B = v1;
        }
        while(!o.B(d0, mutableStateFlow0, object1));
        this.v0();
    }

    public static void K0(y y0, boolean z, int v, Sb.a a0, String s, int v1) {
        m m0;
        boolean z1 = (v1 & 1) == 0 ? z : true;
        int v2 = (v1 & 2) == 0 ? v : -1;
        String s1 = null;
        Sb.a a1 = (v1 & 4) == 0 ? a0 : null;
        String s2 = (v1 & 8) == 0 ? s : "";
        ((o0)y0).getClass();
        q.g(s2, "reason");
        ((o0)y0).Y0();
        Job job0 = ((o0)y0).o;
        if(job0 != null) {
            LogU.debug$default(((o0)y0).l, "cancelPrepareItem()", null, false, 6, null);
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        ((o0)y0).n.d();
        V v3 = ((o0)y0).s0().b();
        q.f(v3, "getPlaylist(...)");
        if(v2 < 0 || v2 >= v3.size()) {
            m0 = v3.isEmpty() ? new m(-1, 0L) : new m(((o0)y0).L(), ((o0)y0).getContentPosition());
        }
        else {
            m0 = new m(v2, 0L);
        }
        int v4 = ((Number)m0.a).intValue();
        long v5 = ((Number)m0.b).longValue();
        m m1 = new m(1, 1);
        m m2 = new m(4, 5);
        if(a1 == null && !v3.isEmpty() && z1) {
            m1 = m2;
        }
        int v6 = ((Number)m1.a).intValue();
        int v7 = ((Number)m1.b).intValue();
        gc.p p0 = new gc.p(z1, v4, v5, v6, a1);
        LogConstantsKt.buildDebug(((o0)y0).l, true, p0);
        if(s2.length() > 0) {
            if(a1 != null) {
                s1 = a1.getMessage();
            }
            jc.j.c(("stop() " + s2 + ", " + s1));
        }
        ((o0)y0).N0(new gc.q(v6, v4, v5, v7, a1));
        ((o0)y0).v0();
    }

    public final void L0(boolean z, int v) {
        String s;
        boolean z1 = true;
        switch(v) {
            case -1: {
                s = "PLAYER_COMMAND_DO_NOT_PLAY";
                break;
            }
            case 0: {
                s = "PLAYER_COMMAND_PLAY_WHEN_READY";
                break;
            }
            case 1: {
                s = "PLAYER_COMMAND_RESUME_AFTER_GAIN";
                break;
            }
            default: {
                s = "Unknown";
            }
        }
        LogU.debug$default(this.l, "updatePlayWhenReady() playWhenReady: " + z + ", playerCommand: " + s, null, false, 6, null);
        c c0 = this.D0();
        c0.n = MelonSettingInfo.isKeepAudioFocus();
        if(v == -2 || v != 1 && (!z || v != 0)) {
            z1 = false;
        }
        LogConstantsKt.debugOnlyDebugMode(this.l, "setPlayerPlayWhenReady() playWhenReady: " + z1);
        E e0 = this.n;
        if(z1) {
            e0.getClass();
            if(e0.c()) {
                e0.e.k1();
            }
        }
        else {
            e0.getClass();
            if(e0.c()) {
                e0.e.j1();
            }
        }
        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)this.m.getValue();
        do {
            Object object0 = mutableStateFlow0.getValue();
            d d0 = ((i0)object0).a();
            d0.b = z1;
            d0.c = !z || v != -2 && v != -1 ? 1 : 2;
            d0.B = this.getContentPosition();
        }
        while(!o.B(d0, mutableStateFlow0, object0));
        this.v0();
    }

    public final void M0(boolean z) {
        c c0 = this.D0();
        int v = this.getPlaybackState();
        LogU.debug$default(c0.d, "updateAudioFocus() isRemote: " + (c0.l == null ? null : Boolean.valueOf(c0.l.a)) + ", playWhenReady: " + z + ", Player.State: " + F.a0(v), null, false, 6, null);
        int v1 = -1;
        if(c0.l != null && c0.l.a) {
            c0.a();
            if(z) {
                v1 = 0;
            }
        }
        else if(v == 1) {
            c0.a();
            if(z) {
                v1 = 0;
            }
        }
        else if(z) {
            if(!c0.e()) {
                c0.i("requestFocus() : no permission");
                c0.j(0);
                v1 = -2;
            }
            else if(c0.f()) {
                c0.i("requestFocus() : oncall & not remote");
                ToastManager.showShort(0x7F130796);  // string:not_play_on_busy "통화중에는 재생할 수 없습니다."
                c0.j(0);
            }
            else if(c0.j == 1) {
                c0.i("requestFocus() : already have a focus");
                v1 = 0;
            }
            else if(!c0.n || !c0.k) {
                if(c0.h == null) {
                    AudioFocusRequest.Builder audioFocusRequest$Builder0 = new AudioFocusRequest.Builder(1);
                    boolean z1 = c0.n;
                    Object object0 = c0.g.getValue();
                    q.f(object0, "getValue(...)");
                    c0.h = audioFocusRequest$Builder0.setAudioAttributes(((AudioAttributes)object0)).setWillPauseWhenDucked(z1).setOnAudioFocusChangeListener(((Ub.b)c0.f.getValue())).build();
                }
                AudioManager audioManager0 = (AudioManager)c0.e.getValue();
                AudioFocusRequest audioFocusRequest0 = c0.h;
                q.d(audioFocusRequest0);
                int v2 = audioManager0.requestAudioFocus(audioFocusRequest0);
                c0.k = v2 == 1;
                c0.i("requestFocus() : " + (v2 == 1 ? "AudioManager.AUDIOFOCUS_REQUEST_ : " + v2 : "AudioManager.AUDIOFOCUS_REQUEST_GRANTED"));
                if(c0.k) {
                    c0.j(1);
                    v1 = 0;
                }
                else {
                    c0.j(0);
                }
            }
            else {
                c0.i("requestFocus() : ignore this request. because the keep audio focus setting is on. ");
                v1 = 0;
            }
        }
        c0.o = v1;
        this.L0(z, v1);
        if(!z) {
            c0.m = false;
        }
    }

    public final void N0(we.k k0) {
        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)this.m.getValue();
        do {
            Object object0 = mutableStateFlow0.getValue();
            d d0 = (d)k0.invoke(((i0)object0).a());
            d0.getClass();
        }
        while(!mutableStateFlow0.compareAndSet(object0, new i0(d0)));
    }

    @Override  // androidx.media3.common.e
    public final i0 s0() {
        return (i0)((MutableStateFlow)this.m.getValue()).getValue();
    }
}

