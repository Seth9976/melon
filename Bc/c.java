package bc;

import Ac.Z1;
import Cb.j;
import L8.s;
import M8.f;
import Nb.K0;
import Nb.v0;
import Nb.z0;
import Tf.v;
import U4.F;
import U4.y;
import Ub.d;
import Ub.q;
import Vb.p0;
import Vb.q0;
import Vb.s0;
import Vb.t0;
import Vb.u0;
import Xb.g;
import Xb.h;
import ac.B;
import ac.u;
import ac.z;
import android.content.Context;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import b3.E;
import b3.G;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.appwidget.CoverWidgetMessageUpdateWorker;
import com.iloen.melon.constants.CType;
import com.iloen.melon.mcache.CacheUrlBuilder;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.common.NotificationActionTypeHelper;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.res.ContentsInfo;
import com.melon.playback.manager.DlnaHelper;
import d5.n;
import fa.b;
import ie.H;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import je.p;
import je.w;
import k8.t;
import kc.A1;
import kc.i;
import kc.v1;
import kc.w1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import mb.k;
import ne.a;
import va.Y;
import va.e0;
import va.o;

public final class c {
    public final Context a;
    public final cc.c b;
    public final e c;
    public final b d;
    public final q e;
    public final t0 f;
    public final A1 g;
    public final u0 h;
    public final LogU i;
    public boolean j;

    public c(Context context0, cc.c c0, e e0, b b0, q q0, t0 t00, A1 a10, u0 u00) {
        kotlin.jvm.internal.q.g(context0, "context");
        kotlin.jvm.internal.q.g(e0, "streamingOption");
        kotlin.jvm.internal.q.g(q0, "playbackManager");
        kotlin.jvm.internal.q.g(t00, "playerRules");
        kotlin.jvm.internal.q.g(a10, "melonMediaUpdateCallback");
        super();
        this.a = context0;
        this.b = c0;
        this.c = e0;
        this.d = b0;
        this.e = q0;
        this.f = t00;
        this.g = a10;
        this.h = u00;
        this.i = Companion.create$default(LogU.Companion, "MelonStreamingHelper", false, Category.Playback, 2, null);
    }

    public final Object a(E e0, z0 z00, int v, oe.c c0) {
        Object object1;
        B b0;
        a a2;
        H h1;
        int v5;
        int v4;
        E e1;
        z0 z01;
        E e3;
        B b4;
        Object object4;
        z0 z03;
        Va.b b3;
        int v7;
        int v6;
        int v9;
        Va.b b6;
        Integer integer1;
        int v12;
        Integer integer0;
        String s22;
        A1 a11;
        a a6;
        Va.a a5;
        String s20;
        String s18;
        String s16;
        String s15;
        String s13;
        String s11;
        String s9;
        String s8;
        String s7;
        boolean z4;
        String s6;
        String s5;
        String s1;
        bc.a a0;
        if(c0 instanceof bc.a) {
            a0 = (bc.a)c0;
            int v1 = a0.S;
            if((v1 & 0x80000000) == 0) {
                a0 = new bc.a(this, c0);
            }
            else {
                a0.S = v1 ^ 0x80000000;
            }
        }
        else {
            a0 = new bc.a(this, c0);
        }
        Object object0 = a0.M;
        a a1 = a.a;
        H h0 = H.a;
        A1 a10 = this.g;
        switch(a0.S) {
            case 0: {
                n.D(object0);
                if(this.j) {
                    kotlin.jvm.internal.q.g(e0, "mediaItem");
                    Bundle bundle0 = e0.d.I;
                    if(bundle0 != null) {
                        bundle0.putBoolean("acquireOwnership", true);
                    }
                    this.j = false;
                }
                e e5 = this.c;
                e5.getClass();
                kotlin.jvm.internal.q.g(e0, "mediaItem");
                G g0 = e0.d;
                kotlin.jvm.internal.q.g(z00, "playerType");
                boolean z = z00.a;
                t t0 = MelonAppBase.Companion;
                String s = Z.l(t0);
                Nb.u0 u00 = Nb.u0.b;
                boolean z1 = z00.equals(u00);
                v0 v00 = v0.b;
                if(z1) {
                    s1 = "CHRMCAST";
                }
                else if(z00.equals(v00)) {
                    s1 = "DLNA";
                }
                else {
                    t0.getClass();
                    s1 = t.a().getMelonCpKey();
                }
                String s2 = F.E(e0).getQueryParameter("contentsId");
                String s3 = s2 == null ? "" : s2;
                if(s3.length() == 0) {
                    throw new Exception("Invalid contentsId");
                }
                String s4 = e.a(e0).getValue();
                kotlin.jvm.internal.q.f(s4, "getValue(...)");
                if(F.M(e0)) {
                    s5 = s4;
                    s6 = "MP4";
                }
                else {
                    s5 = s4;
                    boolean z2 = e5.b();
                    s6 = NetUtils.INSTANCE.getSongMetaType(z2);
                }
                boolean z3 = z00.equals(v00);
                u0 u01 = this.h;
                if(z3 && kotlin.jvm.internal.q.b(s6, "AAC") && !u01.e()) {
                    s6 = "MP3";
                }
                kotlin.jvm.internal.q.f("", "getSessionId(...)");
                Bundle bundle1 = g0.I;
                if(bundle1 == null) {
                    z4 = false;
                }
                else {
                    z4 = bundle1.getBoolean("acquireOwnership");
                    bundle1.remove("acquireOwnership");
                }
                if(e.a(e0).equals(CType.MV)) {
                    s7 = NetUtils.INSTANCE.getMvBitrate(z00);
                }
                else {
                    boolean z5 = e5.b();
                    s7 = NetUtils.INSTANCE.getSongBitrate(z5);
                }
                if(F.M(e0)) {
                    s8 = s7;
                    s9 = "MP4";
                }
                else {
                    s8 = s7;
                    boolean z6 = e5.b();
                    s9 = NetUtils.INSTANCE.getSongMetaType(z6);
                }
                String s10 = !z00.equals(v00) || !kotlin.jvm.internal.q.b(s9, "AAC") || u01.e() ? s8 : "320";
                CType cType0 = e.a(e0);
                if(!kotlin.jvm.internal.q.b(CType.SONG, cType0) || (!MediaCodecInfoCompat.INSTANCE.isFlacSupported() || !((e0)o.a()).j().getHasFlacStProd() || e5.b())) {
                    s11 = "";
                }
                else {
                    int v10 = MelonSettingInfo.getCdStreamingType();
                    s11 = "FLAC16";
                    if(v10 != 2 && v10 != 1) {
                        s11 = "";
                    }
                }
                if(z00.equals(v00) && !s11.equals("")) {
                    DlnaHelper dlnaHelper0 = ((Ub.t)u01.d()).c;
                    s s12 = dlnaHelper0.i;
                    List list0 = s12 == null ? w.a : s12.b;
                    boolean z7 = false;
                    Iterator iterator0 = list0.iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            s13 = s11;
                            break;
                        }
                        Object object5 = iterator0.next();
                        f f0 = (f)object5;
                        s13 = s11;
                        try {
                            if(f0.a("audio/flac") || f0.a("audio/x-flac")) {
                                goto label_145;
                            }
                            goto label_146;
                        }
                        catch(Exception exception0) {
                            LogU.error$default(dlnaHelper0.b, va.e.b("isSupportedFlac() error : ", exception0.getMessage()), null, false, 6, null);
                            z7 = false;
                            break;
                        }
                    label_145:
                        z7 = true;
                    label_146:
                        s11 = s13;
                    }
                    s11 = z7 ? s13 : "";
                }
                String s14 = "Unknown";
                if(z) {
                    Ub.t t1 = (Ub.t)u01.d();
                    if(z00.equals(u00)) {
                        t1.b.getClass();
                        d d0 = new d(t1.b, 3);
                        s15 = (String)t1.b.i(d0);
                        s16 = s15 == null ? "" : s15;
                    }
                    else if(z00.equals(v00)) {
                        M8.a a3 = t1.c.i();
                        if(a3 == null) {
                            s16 = "Unknown";
                        }
                        else {
                            s15 = a3.a.n;
                            s16 = s15 == null ? "Unknown" : s15;
                        }
                    }
                    else {
                        s16 = "";
                    }
                }
                else {
                    s16 = "";
                }
                if(z) {
                    Ub.t t2 = (Ub.t)u01.d();
                    if(z00.equals(u00)) {
                        t2.b.getClass();
                        d d1 = new d(t2.b, 2);
                        s14 = (String)t2.b.i(d1);
                        if(s14 == null) {
                            goto label_196;
                        }
                        else {
                            goto label_192;
                        }
                    }
                    else if(z00.equals(v00)) {
                        M8.a a4 = t2.c.i();
                        if(a4 == null) {
                        label_192:
                            s18 = s14;
                        }
                        else {
                            String s17 = a4.a.o;
                            s18 = s17 == null ? "Unknown" : s17;
                        }
                    }
                    else {
                        s18 = "";
                    }
                }
                else {
                label_196:
                    s18 = "";
                }
                MelonAppBase.Companion.getClass();
                String s19 = kotlin.jvm.internal.q.b(t.a().getMelonCpKey(), "14LNM3") ? "Y" : "N";
                CType cType1 = e.a(e0);
                if(!kotlin.jvm.internal.q.b(CType.SONG, cType1) || (z || !MediaCodecInfoCompat.isAc4Supported() || !MelonSettingInfo.isUseSpatialStreaming() || e5.b())) {
                    s20 = "";
                }
                else {
                    switch(MelonSettingInfo.getSpatialStreamingType()) {
                        case 1: {
                            s20 = "AC4";
                            break;
                        }
                        case 2: {
                            s20 = "AC4";
                            break;
                        }
                        default: {
                            s20 = "";
                        }
                    }
                }
                Va.b b7 = new Va.b(s, s1, s3, s5, s6, "", (z4 ? "Y" : ""), s10, s11, s16, s18, v, s19, "wifi", s20, ((g0.I == null ? false : g0.I.getBoolean("targetMusicwave")) ? "Y" : ""));
                if(z00.equals(u00)) {
                    a5 = Va.a.c;
                }
                else {
                    a5 = z00.equals(v00) ? Va.a.d : Va.a.b;
                }
                a0.r = e0;
                a0.w = z00;
                a0.B = b7;
                v9 = v;
                a0.G = v9;
                a0.S = 1;
                Object object6 = this.d.a(a5, b7, a0);
                if(object6 != a1) {
                    b6 = b7;
                    object0 = object6;
                label_224:
                    kotlin.jvm.internal.q.f(e0.a, "mediaId");
                    a0.r = e0;
                    a0.w = z00;
                    a0.B = b6;
                    a0.D = object0;
                    a0.E = (B)object0;
                    a0.G = v9;
                    a0.I = 0;
                    a0.S = 2;
                    PlaylistId playlistId0 = a10.b();
                    w1 w10 = new w1(a10, e0.a, ((B)object0).i, null);
                    H h2 = i.a(a10.a, playlistId0, "updateDurationLimit", w10, a0);
                    if(h2 != a.a) {
                        h2 = h0;
                    }
                    if(h2 != a1) {
                        z03 = z00;
                        b3 = b6;
                        v7 = v9;
                        b4 = (B)object0;
                        object4 = object0;
                        e3 = e0;
                        v6 = 0;
                    label_246:
                        Notification httpResponse$Notification0 = b4.a;
                        if(httpResponse$Notification0 == null) {
                            a6 = a1;
                            h1 = h0;
                            a11 = a10;
                        }
                        else {
                            LogConstantsKt.infoOnlyDebugMode(this.i, "handleNotificationIfNeeded() notification: " + httpResponse$Notification0);
                            j.b(httpResponse$Notification0, false, 2);
                            MelonAppBase.Companion.getClass();
                            MelonAppBase melonAppBase0 = t.a();
                            boolean z8 = melonAppBase0.isAppForeground();
                            boolean z9 = melonAppBase0.isLockScreenForeground();
                            h1 = h0;
                            String s21 = v.p0(httpResponse$Notification0.message, "<br />", "\n");
                            if(z8 || melonAppBase0.isCarConnected()) {
                                a6 = a1;
                                a11 = a10;
                            }
                            else {
                                if(!NotificationActionTypeHelper.isExtraValue1Player(httpResponse$Notification0) || !NotificationActionTypeHelper.isExtraValue2MultiStreaming(httpResponse$Notification0)) {
                                    a6 = a1;
                                    a11 = a10;
                                }
                                else {
                                    y y0 = new y8.s(CoverWidgetMessageUpdateWorker.class).b();
                                    Context context0 = t.a().getContext();
                                    a6 = a1;
                                    kotlin.jvm.internal.q.g(context0, "context");
                                    a11 = a10;
                                    V4.s.c0(context0).r("CoverWidgetMessageUpdateWorker", 1, y0);
                                }
                                if(NotificationActionTypeHelper.isExtraValue1Player(httpResponse$Notification0) && NotificationActionTypeHelper.isExtraValue2BGStreaming(httpResponse$Notification0)) {
                                    throw new Yb.n(httpResponse$Notification0.message, new Yb.f(2));
                                }
                                if(NotificationActionTypeHelper.isExtraValue1Player(httpResponse$Notification0) && NotificationActionTypeHelper.isExtraValue2TrackZeroDeleted(httpResponse$Notification0)) {
                                    kotlin.jvm.internal.q.g(e3, "item");
                                    Yb.e e6 = new Yb.e(e3);  // 初始化器: LBf/a;-><init>(Ljava/lang/Object;)V
                                    Yb.f f1 = new Yb.f(Yb.a.a, e6);
                                    throw new Yb.n(httpResponse$Notification0.message, f1);
                                }
                                if(!z9 && s21.length() > 0) {
                                    ToastManager.show(s21);
                                    bc.d.a(httpResponse$Notification0);
                                }
                            }
                            if(NotificationActionTypeHelper.isStatusNull(httpResponse$Notification0)) {
                                ToastManager.debug("Invalid action code");
                                throw new Yb.n(httpResponse$Notification0.message);
                            }
                            if(!NotificationActionTypeHelper.isStatusError(httpResponse$Notification0)) {
                                if(!NotificationActionTypeHelper.isViewTypePopup(httpResponse$Notification0)) {
                                    if(NotificationActionTypeHelper.isViewTypeToast(httpResponse$Notification0)) {
                                        ToastManager.show(s21);
                                        bc.d.a(httpResponse$Notification0);
                                    }
                                }
                                else if(NotificationActionTypeHelper.isExtraValue1Player(httpResponse$Notification0)) {
                                    boolean z10_1 = NotificationActionTypeHelper.isExtraValue2MultiStreaming(httpResponse$Notification0);
                                    q q0 = this.e;
                                    if(z10_1) {
                                        if(t.a().isCarConnected()) {
                                            this.j = true;
                                        }
                                        q0.b(new Xb.f(s21));
                                    }
                                    else if(NotificationActionTypeHelper.isExtraValue2Login(httpResponse$Notification0)) {
                                        q0.b(new g(s21));
                                    }
                                    else if(NotificationActionTypeHelper.isExtraValue2Buy(httpResponse$Notification0)) {
                                        ArrayList arrayList0 = httpResponse$Notification0.buttons;
                                        if(arrayList0 == null) {
                                        label_316:
                                            s22 = "";
                                        }
                                        else {
                                            Buttons httpResponse$Notification$Buttons0 = (Buttons)p.k0(arrayList0);
                                            if(httpResponse$Notification$Buttons0 == null) {
                                                goto label_316;
                                            }
                                            else {
                                                s22 = httpResponse$Notification$Buttons0.linkUri;
                                                if(s22 == null) {
                                                    s22 = "";
                                                }
                                            }
                                        }
                                        q0.b(new h(s21, s22));
                                    }
                                    else if(NotificationActionTypeHelper.isExtraValue2TrackZeroDeleted(httpResponse$Notification0)) {
                                        kotlin.jvm.internal.q.f(e3.a, "mediaId");
                                        q0.b(new Xb.d(e3.a, s21));
                                    }
                                    else {
                                        httpResponse$Notification0.message = s21;
                                        NotificationActionTypeHelper.performActionType(httpResponse$Notification0);
                                    }
                                    bc.d.a(httpResponse$Notification0);
                                }
                                else {
                                    httpResponse$Notification0.message = s21;
                                    NotificationActionTypeHelper.performActionType(httpResponse$Notification0);
                                    bc.d.a(httpResponse$Notification0);
                                }
                            }
                            else if(NotificationActionTypeHelper.isViewTypePopup(httpResponse$Notification0)) {
                                httpResponse$Notification0.message = s21;
                                NotificationActionTypeHelper.performActionType(httpResponse$Notification0);
                                Z1 z10 = new Z1(this, e3, b4, 14);
                                if(NotificationActionTypeHelper.isViewTypeSubBlock(httpResponse$Notification0)) {
                                    z10.invoke();
                                    throw new Yb.n(httpResponse$Notification0.message, Yb.f.c);
                                }
                            }
                            else if(NotificationActionTypeHelper.isViewTypeToast(httpResponse$Notification0)) {
                                ToastManager.show(s21);
                                bc.d.a(httpResponse$Notification0);
                            }
                        }
                        try {
                            integer0 = Integer.parseInt(b4.j);
                        }
                        catch(Throwable throwable0) {
                            integer0 = n.t(throwable0);
                        }
                        if(integer0 instanceof ie.o) {
                            integer0 = null;
                        }
                        t0 t00 = this.f;
                        if(integer0 == null) {
                            v12 = v6;
                        }
                        else {
                            int v11 = integer0.intValue();
                            t00.d.getClass();
                            MelonSettingInfo.setPlaybackRetryCount(String.valueOf(v11));
                            MutableStateFlow mutableStateFlow0 = t00.e;
                            while(true) {
                                Object object7 = mutableStateFlow0.getValue();
                                kotlin.jvm.internal.q.g(((s0)object7), "it");
                                v12 = v6;
                                if(mutableStateFlow0.compareAndSet(object7, s0.a(((s0)object7), v11, 0, false, 6))) {
                                    break;
                                }
                                v6 = v12;
                            }
                        }
                        try {
                            integer1 = Integer.parseInt(b4.k);
                        }
                        catch(Throwable throwable1) {
                            integer1 = n.t(throwable1);
                        }
                        if(integer1 instanceof ie.o) {
                            integer1 = null;
                        }
                        if(integer1 != null) {
                            int v13 = integer1.intValue();
                            t00.d.getClass();
                            MelonSettingInfo.setPlaybackErrorCount(String.valueOf(v13));
                            MutableStateFlow mutableStateFlow1 = t00.e;
                            while(true) {
                                Object object8 = mutableStateFlow1.getValue();
                                kotlin.jvm.internal.q.g(((s0)object8), "it");
                                if(mutableStateFlow1.compareAndSet(object8, s0.a(((s0)object8), 0, v13, false, 5))) {
                                    break;
                                }
                            }
                        }
                        if(!TextUtils.isEmpty(b3.i)) {
                            k k0 = o.a();
                            Y y1 = new Y(((e0)k0), b4.m, null);
                            BuildersKt__Builders_commonKt.launch$default(((e0)k0).i, null, null, y1, 3, null);
                        }
                        kotlin.jvm.internal.q.f(e3.a, "mediaId");
                        a0.r = e3;
                        a0.w = z03;
                        a0.B = null;
                        a0.D = object4;
                        a0.E = b4;
                        a0.G = v7;
                        a0.I = v12;
                        a0.S = 3;
                        a10 = a11;
                        PlaylistId playlistId1 = a10.b();
                        v1 v10_1 = new v1(a10, e3.a, b4, null);
                        H h3 = ((com.melon.playlist.b)a10.a).i0(playlistId1, "updateDataFromGetStreamInfo", true, false, v10_1, a0);
                        a a7 = a.a;
                        if(h3 != a7) {
                            h3 = h1;
                        }
                        if(h3 != a7) {
                            h3 = h1;
                        }
                        a2 = a6;
                        if(h3 != a2) {
                            e1 = e3;
                            v4 = v12;
                            v5 = v7;
                            object1 = object4;
                            b0 = b4;
                            z01 = z03;
                        label_405:
                            a0.r = null;
                            a0.w = null;
                            a0.B = null;
                            a0.D = object1;
                            a0.E = b0;
                            a0.G = v5;
                            a0.I = v4;
                            a0.S = 4;
                            Object object9 = a10.c(e1, z01, b0.q, a0);
                            H h4 = object9 == a.a ? object9 : h1;
                            if(h4 != a2) {
                            label_419:
                                if(b0.d.equals(K0.b)) {
                                    for(Object object10: e.k.e(new String[]{b0.b, b0.e.a, b0.e.b})) {
                                        kotlin.jvm.internal.q.g(((String)object10), "<this>");
                                        if(((String)object10).length() == 0) {
                                            kotlin.jvm.internal.q.f("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.", "getString(...)");
                                            throw new Sb.b("해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요.", new IllegalStateException("getStreamingInfoWithCheck() Invalid server response"));
                                        }
                                        if(false) {
                                            break;
                                        }
                                    }
                                }
                                return object1;
                            }
                        }
                        return a2;
                    }
                }
                return a1;
            }
            case 1: {
                int v8 = a0.G;
                Va.b b5 = a0.B;
                z0 z04 = a0.w;
                E e4 = a0.r;
                n.D(object0);
                b6 = b5;
                z00 = z04;
                v9 = v8;
                e0 = e4;
                goto label_224;
            }
            case 2: {
                v6 = a0.I;
                v7 = a0.G;
                B b2 = a0.E;
                Object object3 = a0.D;
                b3 = a0.B;
                z0 z02 = a0.w;
                E e2 = a0.r;
                n.D(object0);
                z03 = z02;
                object4 = object3;
                b4 = b2;
                e3 = e2;
                goto label_246;
            }
            case 3: {
                int v2 = a0.I;
                int v3 = a0.G;
                B b1 = a0.E;
                Object object2 = a0.D;
                z01 = a0.w;
                e1 = a0.r;
                n.D(object0);
                v4 = v2;
                v5 = v3;
                b0 = b1;
                object1 = object2;
                h1 = h0;
                a2 = a1;
                goto label_405;
            }
            case 4: {
                b0 = a0.E;
                object1 = a0.D;
                n.D(object0);
                goto label_419;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object b(E e0, z0 z00, int v, oe.c c0) {
        bc.b b0;
        if(c0 instanceof bc.b) {
            b0 = (bc.b)c0;
            int v1 = b0.E;
            if((v1 & 0x80000000) == 0) {
                b0 = new bc.b(this, c0);
            }
            else {
                b0.E = v1 ^ 0x80000000;
            }
        }
        else {
            b0 = new bc.b(this, c0);
        }
        Object object0 = b0.B;
        a a0 = a.a;
        switch(b0.E) {
            case 0: {
                n.D(object0);
                b0.r = e0;
                b0.w = z00;
                b0.E = 1;
                object0 = this.a(e0, z00, v, b0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                z00 = b0.w;
                e0 = b0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU logU0 = this.i;
        LogConstantsKt.debugOnlyDebugMode(logU0, "getStreamingItemSource() playerType: " + z00 + ", info: " + ((B)object0));
        ac.k k0 = ((B)object0).e;
        String s = ((B)object0).b;
        if(((B)object0).d.equals(K0.b)) {
            CacheUrlBuilder cacheUrlBuilder0 = new CacheUrlBuilder(s, k0.a);
            cacheUrlBuilder0.cacheEnable(Ob.b.b());
            cacheUrlBuilder0.bitrate(((B)object0).g);
            cacheUrlBuilder0.metaType(((B)object0).h);
            String s1 = cacheUrlBuilder0.build();
            kotlin.jvm.internal.q.f(s1, "build(...)");
            s = Ob.b.c(s1, k0.b);
        }
        for(Object object1: ((B)object0).p) {
            String s2 = F.E(e0).getQueryParameter("contentsId");
            if(s2 == null) {
                s2 = "";
            }
            if(!s2.equals("")) {
                continue;
            }
            goto label_44;
        }
        object1 = null;
    label_44:
        if(((ContentsInfo)object1) == null) {
            LogConstantsKt.debugOnlyDebugMode(logU0, "updateMediaItem() ContentsInfo is null");
        }
        else {
            androidx.media3.common.c c1 = e0.d.a();
            boolean z = !F.M(e0);
            c1.c = "";
            c1.d = F.i(((ContentsInfo)object1));
            c1.b = F.i(((ContentsInfo)object1));
            G g0 = new G(c1);
            b3.s s3 = e0.a();
            s3.k = g0;
            Uri uri0 = F.E(e0);
            if(!q0.a(uri0).equals(Uri.EMPTY)) {
                Uri.Builder uri$Builder0 = uri0.buildUpon().clearQuery();
                Set set0 = uri0.getQueryParameterNames();
                kotlin.jvm.internal.q.f(set0, "getQueryParameterNames(...)");
                ArrayList arrayList0 = new ArrayList();
                for(Object object2: set0) {
                    if(!kotlin.jvm.internal.q.b(((String)object2), "data")) {
                        arrayList0.add(object2);
                    }
                }
                for(Object object3: arrayList0) {
                    uri$Builder0.appendQueryParameter(((String)object3), uri0.getQueryParameter(((String)object3)));
                }
                Uri uri1 = uri$Builder0.build();
                p0 p00 = new p0(0, uri0, uri1);
                LogConstantsKt.buildDebug(q0.a, true, p00);
                kotlin.jvm.internal.q.f(uri1, "also(...)");
                uri0 = uri1;
            }
            s3.b = uri0;
            e0 = s3.a();
        }
        Uri uri2 = Uri.parse(s);
        kotlin.jvm.internal.q.f(uri2, "parse(...)");
        b9.a a1 = new b9.a(((B)object0), 1);
        z z1 = new z(((B)object0).c, a1, ((B)object0).o, ((B)object0).n);
        return new ac.q(e0, uri2, u.a, z1, ((B)object0).f);
    }

    public static boolean c(E e0) {
        kotlin.jvm.internal.q.g(e0, "mediaItem");
        return kotlin.jvm.internal.q.b(F.E(e0).getScheme(), "play");
    }
}

