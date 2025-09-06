package Vb;

import Ac.Z1;
import E9.w;
import Hd.F0;
import I6.V;
import Nb.x0;
import Nb.z0;
import U4.F;
import Ub.q;
import Wb.b;
import ac.a;
import ac.d;
import ac.v;
import ac.z;
import android.app.Service;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import b3.E;
import b3.G;
import b3.b0;
import b3.i0;
import b3.s;
import bc.c;
import com.gaudiolab.sol.android.Parameters;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.CollectionRulesDcf;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.drm.MelonFile;
import com.iloen.melon.drm.downloadable.DownloadableDcfController;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.net.v4x.common.YNType;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.DateUtils;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.image.ImageUrl;
import com.iloen.melon.utils.image.MelonImageFetcherType;
import com.iloen.melon.utils.log.DcfLog;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.player.SongMetaParser;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.iloen.melon.utils.system.SimpleTextNotificationKt;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.playback.command.SetABRangeRepeatResult.SetRangeAResult.Failure;
import com.melon.playback.command.SetABRangeRepeatResult.SetRangeAResult.FailureDisabledStreamCache;
import com.melon.playback.command.SetABRangeRepeatResult.SetRangeAResult.Success;
import com.melon.playback.melon.MelonMediaPlayer.becomingNoisyAll.1;
import com.melon.playback.melon.MelonMediaPlayer.checkNetworkConnectReceiver.1;
import com.melon.playback.melon.MelonMediaPlayer.customActionReceiver.1;
import com.melon.playback.melon.MelonMediaPlayer.headSetReceiver.1;
import com.melon.playback.melon.MelonMediaPlayer.screenOffReceiver.1;
import com.melon.playback.melon.MelonMediaPlayer.unmountReceiver.1;
import com.melon.playback.melon.MelonMediaPlayer.useMobileDataSettingChangeReceiver.1;
import com.melon.playlist.interfaces.PlayableData;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import d3.g;
import d5.n;
import e1.m;
import gc.y;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.io.File;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import je.A;
import je.p;
import k8.Y;
import kc.e3;
import kc.h;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import mb.k;
import nc.C0;
import oc.L;
import oc.Q;
import oc.T;
import oc.a0;
import oc.k0;
import oc.n0;
import oc.u;
import va.e0;
import va.e;

public final class o0 extends y {
    public final q A;
    public final h B;
    public final b C;
    public final c D;
    public final ec.c E;
    public final t0 F;
    public final com.melon.playback.melon.drm.c G;
    public final r H;
    public final r I;
    public final AtomicReference J;
    public final AtomicInteger K;
    public final AtomicInteger L;
    public final AtomicInteger M;
    public final AtomicInteger N;
    public d O;
    public final MelonMediaPlayer.unmountReceiver.1 P;
    public final MelonMediaPlayer.becomingNoisyAll.1 Q;
    public final MelonMediaPlayer.useMobileDataSettingChangeReceiver.1 R;
    public final MelonMediaPlayer.checkNetworkConnectReceiver.1 S;
    public final MelonMediaPlayer.screenOffReceiver.1 T;
    public final MelonMediaPlayer.headSetReceiver.1 U;
    public final MelonMediaPlayer.customActionReceiver.1 V;
    public final h0 W;
    public volatile boolean X;
    public final Mutex Y;
    public Job Z;
    public final d0 a0;
    public final CoroutineScope u;
    public final CoroutineDispatcher v;
    public final CoroutineDispatcher w;
    public final CoroutineDispatcher x;
    public final MainCoroutineDispatcher y;
    public final u0 z;

    public o0(Service service0, CoroutineScope coroutineScope0, CoroutineDispatcher coroutineDispatcher0, CoroutineDispatcher coroutineDispatcher1, CoroutineDispatcher coroutineDispatcher2, MainCoroutineDispatcher mainCoroutineDispatcher0, u0 u00, q q0, h h0, b b0, c c0, ec.c c1, t0 t00, com.melon.playback.melon.drm.c c2, k k0) {
        super(service0, coroutineScope0, u00);
        this.u = coroutineScope0;
        this.v = coroutineDispatcher0;
        this.w = coroutineDispatcher1;
        this.x = coroutineDispatcher2;
        this.y = mainCoroutineDispatcher0;
        this.z = u00;
        this.A = q0;
        this.B = h0;
        this.C = b0;
        this.D = c0;
        this.E = c1;
        this.F = t00;
        this.G = c2;
        this.H = g.Q(new i(0));
        r r0 = g.Q(new j(this, 0));
        this.I = r0;
        this.J = new AtomicReference(ac.q.f);
        this.K = new AtomicInteger(0);
        this.L = new AtomicInteger(0);
        this.M = new AtomicInteger(0);
        this.N = new AtomicInteger(-1);
        this.O = a.a;
        MelonMediaPlayer.unmountReceiver.1 melonMediaPlayer$unmountReceiver$10 = new MelonMediaPlayer.unmountReceiver.1(this);
        this.P = melonMediaPlayer$unmountReceiver$10;
        MelonMediaPlayer.becomingNoisyAll.1 melonMediaPlayer$becomingNoisyAll$10 = new MelonMediaPlayer.becomingNoisyAll.1(this);
        this.Q = melonMediaPlayer$becomingNoisyAll$10;
        MelonMediaPlayer.useMobileDataSettingChangeReceiver.1 melonMediaPlayer$useMobileDataSettingChangeReceiver$10 = new MelonMediaPlayer.useMobileDataSettingChangeReceiver.1(this);
        this.R = melonMediaPlayer$useMobileDataSettingChangeReceiver$10;
        MelonMediaPlayer.checkNetworkConnectReceiver.1 melonMediaPlayer$checkNetworkConnectReceiver$10 = new MelonMediaPlayer.checkNetworkConnectReceiver.1(this);
        this.S = melonMediaPlayer$checkNetworkConnectReceiver$10;
        MelonMediaPlayer.screenOffReceiver.1 melonMediaPlayer$screenOffReceiver$10 = new MelonMediaPlayer.screenOffReceiver.1(this);
        this.T = melonMediaPlayer$screenOffReceiver$10;
        MelonMediaPlayer.headSetReceiver.1 melonMediaPlayer$headSetReceiver$10 = new MelonMediaPlayer.headSetReceiver.1(this);
        this.U = melonMediaPlayer$headSetReceiver$10;
        MelonMediaPlayer.customActionReceiver.1 melonMediaPlayer$customActionReceiver$10 = new MelonMediaPlayer.customActionReceiver.1();
        this.V = melonMediaPlayer$customActionReceiver$10;
        this.W = new h0(CoroutineExceptionHandler.Key, this);
        this.H(((Nb.t0)r0.getValue()));
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.intent.action.MEDIA_EJECT");
        intentFilter0.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter0.addAction("android.intent.action.MEDIA_SCANNER_FINISHED");
        intentFilter0.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
        intentFilter0.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter0.addDataScheme("file");
        w.S(this.j, melonMediaPlayer$unmountReceiver$10, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION");
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("com.iloen.melon.intent.action.setting.changed.3g.usage");
        intentFilter1.addAction("android.intent.action.AIRPLANE_MODE");
        w.S(this.j, melonMediaPlayer$useMobileDataSettingChangeReceiver$10, intentFilter1, "com.iloen.melon.permission.SIG_PERMISSION");
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        w.S(this.j, melonMediaPlayer$checkNetworkConnectReceiver$10, intentFilter2, "com.iloen.melon.permission.SIG_PERMISSION");
        IntentFilter intentFilter3 = new IntentFilter();
        intentFilter3.addAction("android.media.AUDIO_BECOMING_NOISY");
        w.S(this.j, melonMediaPlayer$becomingNoisyAll$10, intentFilter3, "com.iloen.melon.permission.SIG_PERMISSION");
        IntentFilter intentFilter4 = new IntentFilter();
        intentFilter4.addAction("android.intent.action.SCREEN_OFF");
        this.j.registerReceiver(melonMediaPlayer$screenOffReceiver$10, intentFilter4, "com.iloen.melon.permission.SIG_PERMISSION", null);
        IntentFilter intentFilter5 = new IntentFilter();
        intentFilter5.addAction("android.intent.action.HEADSET_PLUG");
        this.j.registerReceiver(melonMediaPlayer$headSetReceiver$10, intentFilter5, "com.iloen.melon.permission.SIG_PERMISSION", null);
        IntentFilter intentFilter6 = new IntentFilter();
        intentFilter6.addAction("com.iloen.melon.response_like_content");
        intentFilter6.addAction("com.iloen.melon.intent.action.playback.playmode");
        intentFilter6.addAction("android.appwidget.action.APPWIDGET_UPDATE");
        w.S(this.j, melonMediaPlayer$customActionReceiver$10, intentFilter6, "com.iloen.melon.permission.SIG_PERMISSION");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new o(q0, this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new Vb.r(q0, this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new t(q0, this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new Vb.w(q0, this, null), 3, null);
        this.Y = MutexKt.Mutex$default(false, 1, null);
        this.a0 = new d0(this);
    }

    @Override  // gc.y
    public final Comparable E0(E e0, z0 z00, oe.c c0) {
        z0 z02;
        MCacheError mCacheError1;
        z0 z01;
        E e1;
        int v4;
        long v3;
        long v2;
        C c1;
        if(c0 instanceof C) {
            c1 = (C)c0;
            int v = c1.I;
            if((v & 0x80000000) == 0) {
                c1 = new C(this, c0);
            }
            else {
                c1.I = v ^ 0x80000000;
            }
        }
        else {
            c1 = new C(this, c0);
        }
        Comparable comparable0 = c1.E;
        Comparable comparable1 = ne.a.a;
        c c2 = this.D;
        switch(c1.I) {
            case 0: {
                n.D(comparable0);
                int v1 = this.K.get();
                try {
                    LogConstantsKt.buildDebug$default(this.e1(), false, new F0(e0, z00, v1, 7), 1, null);
                    v2 = ((long)v1) * 5000L + (F.M(e0) ? 30000L : 10000L);
                    c2.getClass();
                    if(c.c(e0)) {
                        v3 = v2 - 10000L;
                        if(v3 <= 0L) {
                            v3 = 0x8000000000000001L;
                        }
                    }
                    else {
                        v3 = 0x8000000000000001L;
                    }
                    LogConstantsKt.debugOnlyDebugMode(this.e1(), "getMediaItemUri() timeoutMs: " + v2 + ", delayTimeMs: " + v3);
                    v4 = v1;
                    goto label_33;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    goto label_55;
                }
                catch(MCacheError mCacheError0) {
                }
                v4 = v1;
                goto label_67;
                try {
                label_33:
                    D d0 = new D(v4, v3, this, e0, z00, null);
                    c1.r = e0;
                    c1.w = z00;
                    c1.D = v4;
                    c1.I = 1;
                    comparable0 = TimeoutKt.withTimeout(v2, d0, c1);
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    goto label_55;
                }
                catch(MCacheError mCacheError0) {
                    goto label_67;
                }
                if(comparable0 == comparable1) {
                    return comparable1;
                }
                e1 = e0;
                z01 = z00;
                return (Uri)comparable0;
            }
            case 1: {
                try {
                    v4 = c1.D;
                    z01 = c1.w;
                    e1 = c1.r;
                    n.D(comparable0);
                    return (Uri)comparable0;
                }
                catch(TimeoutCancellationException timeoutCancellationException0) {
                    e0 = e1;
                label_55:
                    c2.getClass();
                    boolean z = c.c(e0);
                    int v5 = 0x7F1303D9;  // string:error_network_connectivity "해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 
                                          // 후 다시 이용해주세요."
                    Service service0 = this.j;
                    if((!z || NetUtils.isConnected()) && !F.M(e0) && (!SystemSettingUtils.isPowerSaveMode(service0) && !SystemSettingUtils.isBackgroundRestricted(service0) && SystemSettingUtils.isIgnoringBatteryOptimizations(service0))) {
                        v5 = 0x7F1303E7;  // string:error_playback_reason_preparing_timeout "재생 준비시간이 초과되었습니다.\n네트워크 연결을 확인해 
                                          // 주세요."
                    }
                    String s = service0.getString(v5);
                    kotlin.jvm.internal.q.f(s, "getString(...)");
                    throw new Yb.w(s, timeoutCancellationException0);
                }
                catch(MCacheError mCacheError0) {
                    z00 = z01;
                    e0 = e1;
                }
            label_67:
                mCacheError1 = mCacheError0;
                LogConstantsKt.debugOnlyDebugMode(this.e1(), "getMediaItemUri() MCacheError: " + mCacheError1);
                if(MelonSettingInfo.isUseErrorReport()) {
                    Sb.a a0 = new Sb.a(e.b("MCacheError: ", mCacheError1.getLocalizedMessage()), mCacheError1);
                    c1.r = e0;
                    c1.w = z00;
                    c1.B = mCacheError1;
                    c1.D = v4;
                    c1.I = 2;
                    if(this.r1(z00, a0, e0, c1) == comparable1) {
                        return comparable1;
                    }
                    z02 = z00;
                    goto label_84;
                }
                goto label_85;
            }
            case 2: {
                break;
            }
            case 3: {
                n.D(comparable0);
                return (Uri)comparable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        v4 = c1.D;
        mCacheError1 = c1.B;
        z02 = c1.w;
        e0 = c1.r;
        n.D(comparable0);
    label_84:
        z00 = z02;
    label_85:
        this.Y0();
        this.w1("14LNM3", "getMediaItemUri() MCacheError: " + mCacheError1.getMessage());
        c1.r = null;
        c1.w = null;
        c1.B = null;
        c1.D = v4;
        c1.I = 3;
        comparable0 = this.b1(e0, z00, v4, c1);
        return comparable0 == comparable1 ? comparable1 : ((Uri)comparable0);
    }

    public static final Object O0(o0 o00, oe.c c0) {
        Mutex mutex1;
        l l0;
        if(c0 instanceof l) {
            l0 = (l)c0;
            int v = l0.D;
            if((v & 0x80000000) == 0) {
                l0 = new l(o00, c0);
            }
            else {
                l0.D = v ^ 0x80000000;
            }
        }
        else {
            l0 = new l(o00, c0);
        }
        Object object0 = l0.w;
        ne.a a0 = ne.a.a;
        switch(l0.D) {
            case 0: {
                n.D(object0);
                if(o00.X) {
                    Mutex mutex0 = o00.Y;
                    l0.r = mutex0;
                    l0.D = 1;
                    if(mutex0.lock(null, l0) == a0) {
                        return a0;
                    }
                    mutex1 = mutex0;
                    goto label_24;
                }
                break;
            }
            case 1: {
                mutex1 = l0.r;
                n.D(object0);
            label_24:
                try {
                    if(o00.X) {
                        o00.B.getClass();
                        kotlin.jvm.internal.q.g(o00.a0, "listener");
                        ((com.melon.playlist.b)o00.B.a).getClass();
                        ((com.melon.playlist.b)o00.B.a).t = null;
                        MutableStateFlow mutableStateFlow0 = (MutableStateFlow)o00.m.getValue();
                        do {
                            Object object1 = mutableStateFlow0.getValue();
                            androidx.media3.common.d d0 = ((i0)object1).a();
                            d0.b(je.w.a);
                            d0.y = -1;
                            d0.B = 0x8000000000000001L;
                        }
                        while(!mutableStateFlow0.compareAndSet(object1, new i0(d0)));
                        o00.v0();
                        o00.X = false;
                    }
                }
                finally {
                    mutex1.unlock(null);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public static final Object P0(o0 o00, a0 a00, oe.c c0) {
        I i0;
        if(c0 instanceof I) {
            i0 = (I)c0;
            int v = i0.D;
            if((v & 0x80000000) == 0) {
                i0 = new I(o00, c0);
            }
            else {
                i0.D = v ^ 0x80000000;
            }
        }
        else {
            i0 = new I(o00, c0);
        }
        Object object0 = i0.w;
        ne.a a0 = ne.a.a;
        switch(i0.D) {
            case 0: {
                n.D(object0);
                List list0 = a00.a().c();
                i0.r = a00;
                i0.D = 1;
                object0 = o00.u1(list0, i0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                a00 = i0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new Z1(o00, a00, ((List)object0), 8));
        return H.a;
    }

    public static final Object Q0(o0 o00, Q q0, long v, oe.c c0) {
        J j0;
        if(c0 instanceof J) {
            j0 = (J)c0;
            int v1 = j0.E;
            if((v1 & 0x80000000) == 0) {
                j0 = new J(o00, c0);
            }
            else {
                j0.E = v1 ^ 0x80000000;
            }
        }
        else {
            j0 = new J(o00, c0);
        }
        Object object0 = j0.B;
        ne.a a0 = ne.a.a;
        switch(j0.E) {
            case 0: {
                n.D(object0);
                List list0 = q0.c();
                j0.r = q0;
                j0.w = v;
                j0.E = 1;
                object0 = o00.u1(list0, j0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = j0.w;
                q0 = j0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new f(o00, ((List)object0), q0, v, 0));
        return H.a;
    }

    public static final Object R0(o0 o00, u u0, oe.c c0) {
        K k0;
        if(c0 instanceof K) {
            k0 = (K)c0;
            int v = k0.D;
            if((v & 0x80000000) == 0) {
                k0 = new K(o00, c0);
            }
            else {
                k0.D = v ^ 0x80000000;
            }
        }
        else {
            k0 = new K(o00, c0);
        }
        Object object0 = k0.w;
        ne.a a0 = ne.a.a;
        switch(k0.D) {
            case 0: {
                n.D(object0);
                List list0 = u0.a.c();
                k0.r = u0;
                k0.D = 1;
                object0 = o00.u1(list0, k0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                u0 = k0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new Z1(o00, ((List)object0), u0, 7));
        return H.a;
    }

    public static final Object S0(o0 o00, PlaylistId playlistId0, Q q0, long v, oe.c c0) {
        M m0;
        if(c0 instanceof M) {
            m0 = (M)c0;
            int v1 = m0.E;
            if((v1 & 0x80000000) == 0) {
                m0 = new M(o00, c0);
            }
            else {
                m0.E = v1 ^ 0x80000000;
            }
        }
        else {
            m0 = new M(o00, c0);
        }
        Object object0 = m0.B;
        ne.a a0 = ne.a.a;
        switch(m0.E) {
            case 0: {
                n.D(object0);
                LogU logU0 = o00.e1();
                StringBuilder stringBuilder0 = Y.p("handleMelonPlaylistChangedResult()");
                Cb.i.a(stringBuilder0, "newPlaylistId: " + playlistId0);
                LogConstantsKt.debugOnlyDebugMode(logU0, stringBuilder0.toString());
                List list0 = q0.c();
                m0.r = q0;
                m0.w = v;
                m0.E = 1;
                object0 = o00.u1(list0, m0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = m0.w;
                q0 = m0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new Vb.e(o00, ((List)object0), q0, v, m.q(o00.B)));
        return H.a;
    }

    public static final Object T0(o0 o00, T t0, oe.c c0) {
        N n0;
        if(c0 instanceof N) {
            n0 = (N)c0;
            int v = n0.D;
            if((v & 0x80000000) == 0) {
                n0 = new N(o00, c0);
            }
            else {
                n0.D = v ^ 0x80000000;
            }
        }
        else {
            n0 = new N(o00, c0);
        }
        Object object0 = n0.w;
        ne.a a0 = ne.a.a;
        switch(n0.D) {
            case 0: {
                n.D(object0);
                List list0 = t0.d.c();
                n0.r = t0;
                n0.D = 1;
                object0 = o00.u1(list0, n0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                t0 = n0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new Z1(o00, t0, ((List)object0), 4));
        return H.a;
    }

    public static final Object U0(o0 o00, k0 k00, oe.c c0) {
        O o0;
        if(c0 instanceof O) {
            o0 = (O)c0;
            int v = o0.D;
            if((v & 0x80000000) == 0) {
                o0 = new O(o00, c0);
            }
            else {
                o0.D = v ^ 0x80000000;
            }
        }
        else {
            o0 = new O(o00, c0);
        }
        Object object0 = o0.w;
        ne.a a0 = ne.a.a;
        switch(o0.D) {
            case 0: {
                n.D(object0);
                List list0 = k00.a.c();
                o0.r = k00;
                o0.D = 1;
                object0 = o00.u1(list0, o0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                k00 = o0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new Z1(o00, k00, ((List)object0), 6));
        return H.a;
    }

    public static final Object V0(o0 o00, n0 n00, oe.c c0) {
        P p0;
        if(c0 instanceof P) {
            p0 = (P)c0;
            int v = p0.D;
            if((v & 0x80000000) == 0) {
                p0 = new P(o00, c0);
            }
            else {
                p0.D = v ^ 0x80000000;
            }
        }
        else {
            p0 = new P(o00, c0);
        }
        Object object0 = p0.w;
        ne.a a0 = ne.a.a;
        switch(p0.D) {
            case 0: {
                n.D(object0);
                List list0 = n00.a.c();
                p0.r = n00;
                p0.D = 1;
                object0 = o00.u1(list0, p0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n00 = p0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        o00.j1(new Z1(o00, ((List)object0), n00, 5));
        return H.a;
    }

    public static ArrayList W0(V v0, List list0) {
        b0 b00;
        int v1 = je.D.N(je.q.Q(10, v0));
        if(v1 < 16) {
            v1 = 16;
        }
        LinkedHashMap linkedHashMap0 = new LinkedHashMap(v1);
        for(Object object0: v0) {
            linkedHashMap0.put(((b0)object0).c.a, object0);
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
        for(Object object1: list0) {
            E e0 = (E)object1;
            if(linkedHashMap0.containsKey(e0.a)) {
                Object object2 = linkedHashMap0.get(e0.a);
                kotlin.jvm.internal.q.d(object2);
                b3.a0 a00 = ((b0)object2).c();
                a00.c = e0;
                b00 = new b0(a00);
            }
            else {
                b00 = androidx.media3.common.e.p0(e0);
            }
            arrayList0.add(b00);
        }
        return arrayList0;
    }

    public final Object X0(E e0, oe.c c0) {
        Vb.k k0;
        if(c0 instanceof Vb.k) {
            k0 = (Vb.k)c0;
            int v = k0.B;
            if((v & 0x80000000) == 0) {
                k0 = new Vb.k(this, c0);
            }
            else {
                k0.B = v ^ 0x80000000;
            }
        }
        else {
            k0 = new Vb.k(this, c0);
        }
        Object object0 = k0.r;
        ne.a a0 = ne.a.a;
        switch(k0.B) {
            case 0: {
                n.D(object0);
                kotlin.jvm.internal.q.g(e0, "mediaItem");
                Uri uri0 = q0.a(F.E(e0));
                if(uri0.equals(Uri.EMPTY)) {
                    return false;
                }
                k0.B = 1;
                object0 = StorageUtils.INSTANCE.exist(uri0, this.j, k0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ((Boolean)object0).getClass();
        return (Boolean)object0;
    }

    public final void Y0() {
        this.B0();
        d d0 = this.O;
        a a0 = a.a;
        if(d0 instanceof ac.b) {
            this.s1(a0);
            return;
        }
        if(d0 instanceof ac.c) {
            this.s1(a0);
            ToastManager.show(0x7F1308B9);  // string:range_repeat_mode_release_toast "구간 반복을 해제합니다."
        }
    }

    public final ac.w Z0(ac.q q0) {
        String s13;
        ac.m m0;
        String s12;
        String s11;
        ac.g g0;
        ie.o o0;
        ac.n n0;
        String s4;
        String s2;
        int v1;
        String s = q0.a.a;
        kotlin.jvm.internal.q.f(s, "mediaId");
        v v0 = q0.c;
        Service service0 = this.j;
        kotlin.jvm.internal.q.g(service0, "context");
        kotlin.jvm.internal.q.g(this.B, "melonCurrentPlaylist");
        kotlin.jvm.internal.q.g(v0, "source");
        String s1 = s.length() <= 0 ? "" : F.Y(s).a;
        Playable playable0 = m.t(this.B, s1);
        kc.i i0 = this.B.a;
        oc.w w0 = ((com.melon.playlist.b)i0).u();
        boolean z = w0 instanceof pc.d && d5.t.k(((pc.d)w0));
        if(z) {
            oc.w w1 = ((com.melon.playlist.b)i0).u();
            Q q1 = w1 == null ? null : w1.getState();
            pc.z0 z00 = q1 instanceof pc.z0 ? ((pc.z0)q1) : null;
            oc.w w2 = ((com.melon.playlist.b)i0).u();
            Q q2 = w2 == null ? null : w2.getState();
            if(q2 == null) {
                v1 = -1;
            }
            else {
                List list0 = q2.c();
                if(list0 == null) {
                    v1 = -1;
                }
                else {
                    Object object0 = null;
                    Iterator iterator0 = p.V0(list0).iterator();
                    while(((Sf.b)iterator0).b.hasNext()) {
                        Object object1 = ((Sf.b)iterator0).next();
                        if(kotlin.jvm.internal.q.b(((PlayableData)((A)object1).b).b, s1)) {
                            object0 = object1;
                            break;
                        }
                    }
                    v1 = ((A)object0) == null ? -1 : ((A)object0).a;
                }
            }
            if(v1 >= 0) {
                ++v1;
            }
            if(z00 == null) {
                s2 = "";
            }
            else {
                pc.c c0 = z00.c;
                if(c0 == null) {
                    s2 = "";
                }
                else {
                    DjMalrangInfo djMalrangInfo0 = c0 instanceof DjMalrangInfo ? ((DjMalrangInfo)c0) : null;
                    if(djMalrangInfo0 == null) {
                        s2 = "";
                    }
                    else {
                        s2 = n.w(djMalrangInfo0);
                        if(s2 == null) {
                            s2 = "";
                        }
                    }
                }
            }
            String s3 = String.valueOf(v1);
            if(playable0 == null) {
                s4 = "";
            }
            else {
                DateTimeFormatter dateTimeFormatter0 = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneId.of("GMT+09:00"));
                kotlin.jvm.internal.q.f(dateTimeFormatter0, "withZone(...)");
                s4 = n.x(playable0, service0, dateTimeFormatter0);
            }
            n0 = new ac.n(s2, s3, s4);
        }
        else {
            n0 = ac.n.d;
        }
        if(playable0 == null) {
            m0 = ac.m.p;
        }
        else {
            kotlin.jvm.internal.q.f("", "getTrackId(...)");
            kotlin.jvm.internal.q.f("", "getContentId(...)");
            CType cType0 = playable0.getCtype();
            kotlin.jvm.internal.q.f(cType0, "getCtype(...)");
            if(!playable0.isTypeOfMv()) {
                boolean z1 = !playable0.isTypeOfLive();
            }
            kotlin.jvm.internal.q.d("");
            String s5 = DateUtils.convertLongToString(playable0.getCreatedAt(), "yyyyMMddHHmmss");
            kotlin.jvm.internal.q.f(s5, "convertLongToString(...)");
            kotlin.jvm.internal.q.f("", "getBitrate(...)");
            kotlin.jvm.internal.q.f("", "getMetatype(...)");
            boolean z2 = playable0.getDurationLimit() >= 0L;
            String s6 = YNType.valueOf(playable0.isFree());
            kotlin.jvm.internal.q.f(s6, "valueOf(...)");
            kotlin.jvm.internal.q.f("", "getMenuid(...)");
            kotlin.jvm.internal.q.f("", "getOriginMenuId(...)");
            kotlin.jvm.internal.q.f("", "getStatsElements(...)");
            if(v0 instanceof ac.r) {
                try {
                    if(playable0.isDcfFile()) {
                        try {
                            AbsDcfController absDcfController0 = R8.m.a(service0, R8.m.a);
                            o0 = StorageUtils.isScopedStorage() ? absDcfController0.d("") : absDcfController0.d("");
                        }
                        finally {
                            R8.m.b(service0);
                        }
                    }
                    else if(StorageUtils.isScopedStorage()) {
                        Uri uri0 = Uri.parse("");
                        MelonFile melonFile0 = new MelonFile(service0, uri0);
                        Song song0 = SongMetaParser.parseMeta(uri0, null, 10);
                        if(song0 != null) {
                            melonFile0.e(song0.b);
                            melonFile0.f(song0.d);
                        }
                        o0 = melonFile0;
                    }
                    else {
                        MelonFile melonFile1 = new MelonFile("");
                        Song song1 = SongMetaParser.parseMeta("", null, 10);
                        if(song1 != null) {
                            melonFile1.e(song1.b);
                            melonFile1.f(song1.d);
                        }
                        o0 = melonFile1;
                    }
                }
                catch(Throwable throwable0) {
                    o0 = n.t(throwable0);
                }
                g0 = new ac.f(((MelonFile)(o0 instanceof ie.o ? null : o0)));
            }
            else if(v0 instanceof ac.t) {
                kotlin.jvm.internal.q.f("", "getSongidString(...)");
                CType cType1 = playable0.getCtype();
                kotlin.jvm.internal.q.f(cType1, "getCtype(...)");
                kotlin.jvm.internal.q.f("", "getMetatype(...)");
                kotlin.jvm.internal.q.f("", "getBitrate(...)");
                MelonAppBase.Companion.getClass();
                String s7 = DeviceIdentifier.id(k8.t.a().getDeviceData().a);
                byte[] arr_b = k9.i.a();
                String s8 = null;
                if(arr_b != null) {
                    try {
                        s8 = MelonCryptoManager.getBInfo(arr_b);
                    }
                    catch(Exception unused_ex) {
                    }
                }
                kotlin.jvm.internal.q.f(s8, "getBInfo(...)");
                String s9 = YNType.valueOf(playable0.isFree());
                kotlin.jvm.internal.q.f(s9, "valueOf(...)");
                String s10 = MelonSettingInfo.getOfflineMemberKey();
                if(TextUtils.isEmpty(s10)) {
                label_128:
                    s12 = s9;
                    s11 = "";
                }
                else {
                    try {
                        s11 = MelonCryptoManager.decrypt(s10);
                        s12 = s9;
                        goto label_130;
                    }
                    catch(Exception unused_ex) {
                    }
                    goto label_128;
                }
            label_130:
                kotlin.jvm.internal.q.f(s11, "getMemberKey(...)");
                g0 = new ac.h("", cType1, "", "", (s7 == null ? "" : s7), s8, s12, s11);
            }
            else {
                ac.g g1 = ac.g.e;
                if(!(v0 instanceof ac.u) || !((e0)va.o.a()).m()) {
                    g0 = g1;
                }
                else if(playable0.isOnAir()) {
                    kotlin.jvm.internal.q.f("", "getLiveSeq(...)");
                    g0 = new ac.e("");
                }
                else if(!playable0.hasCid() || playable0.getDurationLimit() >= 0L) {
                    g0 = g1;
                }
                else {
                    g0 = new ac.i(playable0.getIsMusicWaveSong());
                }
            }
            m0 = new ac.m("", "", cType0, "", s5, "", "", z2, s6, "", "", "", g0, n0, new Hc.C(service0, playable0, z, n0));
        }
        LogConstantsKt.debugOnlyDebugMode(ec.a.a, "fromPlayable() " + m0);
        z z3 = q0.d;
        com.melon.playlist.b b0 = (com.melon.playlist.b)this.E.a;
        b0.Y("getIsUseSmartPlaylistOrNull");
        Boolean boolean0 = b0.o.getValue() == e3.c ? ((Boolean)b0.r.getValue()) : null;
        boolean z4 = boolean0 == null ? false : boolean0.booleanValue();
        oc.w w3 = b0.u();
        if(w3 == null) {
            return new ac.w(System.currentTimeMillis(), m0, z3, ac.p.j);
        }
        boolean z5 = w3.getId() == PlaylistId.SMART || w3.getId() == PlaylistId.DRAWER;
        switch(ec.b.a[w3.getId().ordinal()]) {
            case 1: {
                s13 = "song";
                break;
            }
            case 2: {
                s13 = "playlist";
                break;
            }
            default: {
                s13 = "";
            }
        }
        Q q3 = w3.getState();
        if(q3 instanceof C0) {
            DrawerPlaylistInfo drawerPlaylistInfo0 = ((C0)q3).g;
            if(drawerPlaylistInfo0 != null) {
                switch(drawerPlaylistInfo0.getLandingFrom()) {
                    case "DJ": {
                        return drawerPlaylistInfo0.isRecentOrLike() ? new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "dj", "", drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode())) : new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "dj", drawerPlaylistInfo0.getContsId(), drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode()));
                    }
                    case "LIKE": {
                        return drawerPlaylistInfo0.isRecentOrLike() ? new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "like", "", drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode())) : new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "like", drawerPlaylistInfo0.getContsId(), drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode()));
                    }
                    case "MADE_BY_ME": {
                        return drawerPlaylistInfo0.isRecentOrLike() ? new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "created", "", drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode())) : new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "created", drawerPlaylistInfo0.getContsId(), drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode()));
                    }
                    case "RECENT": {
                        return drawerPlaylistInfo0.isRecentOrLike() ? new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "recent", "", drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode())) : new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "recent", drawerPlaylistInfo0.getContsId(), drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode()));
                    }
                    default: {
                        return drawerPlaylistInfo0.isRecentOrLike() ? new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "", "", drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode())) : new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "", drawerPlaylistInfo0.getContsId(), drawerPlaylistInfo0.getContsTypeCode(), drawerPlaylistInfo0.getSeedContsId(), drawerPlaylistInfo0.getSeedContsTypeCode()));
                    }
                }
            }
        }
        return new ac.w(System.currentTimeMillis(), m0, z3, new ac.p(z4, w3.getId(), z5, s13, "", "", "", "", ""));
    }

    public final Uri a1(Uri uri0) {
        Uri uri1;
        String s1;
        Service service0;
        try {
            service0 = this.j;
            DownloadableDcfController downloadableDcfController0 = (DownloadableDcfController)R8.m.a(service0, 1);
            DcfFile dcfFile0 = downloadableDcfController0.j(uri0);
            if(dcfFile0.i != 0L) {
                DcfError dcfError1 = new DcfError(((int)dcfFile0.i));
                dcfError1.b = dcfFile0;
                throw new Yb.k("Unable to load dcf file: " + dcfError1.getMessage(), dcfError1);
            }
            String s = uri0.getScheme();
            if(s == null) {
                kotlin.jvm.internal.q.f("재생파일 오류입니다.", "getString(...)");
                throw new Sb.b("재생파일 오류입니다.", new IllegalStateException("getDcfUri() Invalid scheme"));
            }
            switch(s) {
                case "content": {
                    s1 = uri0.toString();
                    break;
                }
                case "file": {
                    s1 = uri0.getPath();
                    break;
                }
                default: {
                    kotlin.jvm.internal.q.f("재생파일 오류입니다.", "getString(...)");
                    throw new Sb.b("재생파일 오류입니다.", new IllegalStateException("getDcfUri() Invalid scheme"));
                }
            }
            uri1 = Uri.parse(downloadableDcfController0.k(s1));
            kotlin.jvm.internal.q.d(uri1);
            return uri1;
        }
        catch(DcfError dcfError0) {
            throw new Yb.k("Unable to load dcf file: " + dcfError0.getMessage(), dcfError0);
        }
        finally {
            R8.m.b(service0);
        }
    }

    public final Comparable b1(E e0, z0 z00, int v, oe.c c0) {
        y8.t t0;
        x x0;
        if(c0 instanceof x) {
            x0 = (x)c0;
            int v1 = x0.D;
            if((v1 & 0x80000000) == 0) {
                x0 = new x(this, c0);
            }
            else {
                x0.D = v1 ^ 0x80000000;
            }
        }
        else {
            x0 = new x(this, c0);
        }
        Object object0 = x0.w;
        Comparable comparable0 = ne.a.a;
        switch(x0.D) {
            case 0: {
                n.D(object0);
                x0.r = e0;
                x0.D = 1;
                object0 = this.f1(e0, z00, v, x0);
                if(object0 == comparable0) {
                    return comparable0;
                }
                break;
            }
            case 1: {
                e0 = x0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        this.J.set(((ac.q)object0));
        ac.j j0 = ((ac.q)object0).e;
        if(kotlin.jvm.internal.q.b(j0, ac.j.f)) {
            kotlin.jvm.internal.q.f(e0.a, "mediaId");
            v0 v00 = F.Y(e0.a);
            String s = v00.b.getValue();
            kotlin.jvm.internal.q.f(s, "getValue(...)");
            t0 = new y8.t(v00.c, s, "SO0100", "", null);
        }
        else {
            kotlin.jvm.internal.q.g(j0, "<this>");
            t0 = new y8.t(j0.a, j0.b, j0.c, j0.d, j0.e);
        }
        byte[] arr_b = null;
        LogConstantsKt.debugOnlyDebugMode(this.e1(), "onUpdateSolMetaDataBase() metaData: " + t0);
        Log.d("[GaudioSolMusicOne] ", "setMetaData: " + t0);
        y8.f.b().e = t0;
        String s1 = t0.e;
        if(s1 != null) {
            if(s1.length() != 0) {
                try {
                    arr_b = Base64.getDecoder().decode(s1);
                }
                catch(Exception unused_ex) {
                }
            }
            y8.f.b().c.metadata = arr_b;
            Parameters parameters0 = y8.f.b().c;
            parameters0.metadataLength = arr_b == null ? 0 : arr_b.length;
            y8.f.b().d.set(true);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(y8.f.b), null, null, new y8.e(t0, null), 3, null);
        return ((ac.q)object0).b;
    }

    public final Comparable c1(E e0, oe.c c0) {
        Yb.k k1;
        Uri uri0;
        Vb.y y0;
        if(c0 instanceof Vb.y) {
            y0 = (Vb.y)c0;
            int v = y0.E;
            if((v & 0x80000000) == 0) {
                y0 = new Vb.y(this, c0);
            }
            else {
                y0.E = v ^ 0x80000000;
            }
        }
        else {
            y0 = new Vb.y(this, c0);
        }
        Object object0 = y0.B;
        Comparable comparable0 = ne.a.a;
        switch(y0.E) {
            case 0: {
                n.D(object0);
                kotlin.jvm.internal.q.g(e0, "mediaItem");
                uri0 = q0.a(F.E(e0));
                if(Vb.c.c(this.j, e0)) {
                    try {
                        return this.a1(uri0);
                    }
                    catch(Yb.k k0) {
                        LogU.error$default(this.e1(), "getLocalUri() DrmException: " + k0, null, false, 6, null);
                        DcfLog.e("MelonMediaPlayer", "getLocalUri() " + k0.c);
                        if(MelonSettingInfo.isUseErrorReport()) {
                            z0 z00 = this.n.e.a1();
                            y0.r = uri0;
                            y0.w = k0;
                            y0.E = 1;
                            if(this.r1(z00, k0, e0, y0) != comparable0) {
                                k1 = k0;
                                goto label_36;
                            }
                            return comparable0;
                        }
                        k1 = k0;
                        goto label_36;
                    }
                }
                return uri0;
            }
            case 1: {
                k1 = y0.w;
                uri0 = y0.r;
                n.D(object0);
            label_36:
                Vb.z z0 = new Vb.z(this, null);
                y0.r = uri0;
                y0.w = k1;
                y0.E = 2;
                if(BuildersKt.withContext(this.y, z0, y0) == comparable0) {
                    return comparable0;
                }
                break;
            }
            case 2: {
                k1 = y0.w;
                uri0 = y0.r;
                n.D(object0);
                break;
            }
            case 3: {
                Uri uri1 = y0.r;
                n.D(object0);
                return this.a1(uri1);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        y0.r = uri0;
        y0.w = null;
        y0.E = 3;
        return this.v1(k1, y0) == comparable0 ? comparable0 : this.a1(uri0);
    }

    public final Object d1(E e0, oe.c c0) {
        Vb.A a0;
        if(c0 instanceof Vb.A) {
            a0 = (Vb.A)c0;
            int v = a0.D;
            if((v & 0x80000000) == 0) {
                a0 = new Vb.A(this, c0);
            }
            else {
                a0.D = v ^ 0x80000000;
            }
        }
        else {
            a0 = new Vb.A(this, c0);
        }
        Comparable comparable0 = a0.w;
        ne.a a1 = ne.a.a;
        switch(a0.D) {
            case 0: {
                n.D(comparable0);
                a0.r = e0;
                a0.D = 1;
                comparable0 = this.c1(e0, a0);
                if(comparable0 == a1) {
                    return a1;
                }
                break;
            }
            case 1: {
                e0 = a0.r;
                n.D(comparable0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        ac.q q0 = new ac.q(e0, ((Uri)comparable0), ac.r.a, null, 24);
        this.J.set(q0);
        return q0;
    }

    public final LogU e1() {
        return (LogU)this.H.getValue();
    }

    public final Object f1(E e0, z0 z00, int v, oe.c c0) {
        E e1;
        int v2;
        z0 z02;
        Boolean boolean1;
        E e2;
        B b0;
        if(c0 instanceof B) {
            b0 = (B)c0;
            int v1 = b0.G;
            if((v1 & 0x80000000) == 0) {
                b0 = new B(this, c0);
            }
            else {
                b0.G = v1 ^ 0x80000000;
            }
        }
        else {
            b0 = new B(this, c0);
        }
        Boolean boolean0 = b0.D;
        ne.a a0 = ne.a.a;
        switch(b0.G) {
            case 0: {
                n.D(boolean0);
                b0.r = e0;
                z02 = z00;
                b0.w = z02;
                b0.B = v;
                b0.G = 1;
                Object object0 = this.X0(e0, b0);
                if(object0 != a0) {
                    e2 = e0;
                    v2 = v;
                    boolean1 = object0;
                label_41:
                    if(boolean1.booleanValue()) {
                        b0.r = null;
                        b0.w = null;
                        b0.B = v2;
                        b0.G = 2;
                        Object object1 = this.d1(e2, b0);
                        if(object1 != a0) {
                            return object1;
                        }
                    }
                    else if(!NetUtils.isConnected()) {
                        b0.r = e2;
                        b0.w = null;
                        b0.B = v2;
                        b0.G = 3;
                        boolean z = false;
                        if(k9.j.a() != 1) {
                            kotlin.jvm.internal.q.g(this.B, "<this>");
                            oc.w w0 = ((com.melon.playlist.b)this.B.a).u();
                            if(w0 instanceof oc.x && ((L)((oc.x)w0).y().getValue()).e()) {
                                z = true;
                            }
                        }
                        boolean0 = Boolean.valueOf(z);
                        if(boolean0 != a0) {
                            e1 = e2;
                        label_63:
                            if(!boolean0.booleanValue()) {
                                kotlin.jvm.internal.q.f("해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 후 다시 이용해주세요.", "getString(...)");
                                throw new Yb.g("해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 후 다시 이용해주세요.", new IllegalStateException("getItemUriAndPrepare() Network not connected"));
                            }
                            MelonAppBase.Companion.getClass();
                            if(!AndroidSettings.isAutoTimeChecked(k8.t.a())) {
                                throw new Yb.q();
                            }
                            int v3 = k9.j.a();
                            if(v3 != 1 && v3 != 5) {
                                throw new Yb.p("Check System Settings: Invalid Product State: " + Y.B(v3));
                            }
                            kotlin.jvm.internal.q.g(e1, "mediaItem");
                            v0 v00 = F.X(e1);
                            if(!k9.e.c(v00.c, v00.b.getValue()).booleanValue()) {
                                kotlin.jvm.internal.q.f("해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 후 다시 이용해주세요.", "getString(...)");
                                throw new Yb.g("해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 후 다시 이용해주세요.", new IllegalStateException("getItemUriAndPrepare() Network not connected"));
                            }
                            b0.r = null;
                            b0.w = null;
                            b0.B = v2;
                            b0.G = 4;
                            Object object2 = this.g1(e1, b0);
                            if(object2 != a0) {
                                return object2;
                            }
                        }
                    }
                    else {
                        ec.f f0 = new ec.f(1, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ec.d(f0, null), 3, null);
                        this.D.getClass();
                        if(!c.c(e2)) {
                            kotlin.jvm.internal.q.f("곡 재생에 실패하였습니다.", "getString(...)");
                            throw new Sb.b("곡 재생에 실패하였습니다.", new IllegalStateException("getItemUriAndPrepare() Invalid mediaItem"));
                        }
                        b0.r = null;
                        b0.w = null;
                        b0.B = v2;
                        b0.G = 5;
                        Object object3 = this.h1(e2, z02, v2, b0);
                        if(object3 != a0) {
                            return object3;
                        }
                    }
                }
                break;
            }
            case 1: {
                v2 = b0.B;
                z0 z01 = b0.w;
                e2 = b0.r;
                n.D(boolean0);
                boolean1 = boolean0;
                z02 = z01;
                goto label_41;
            }
            case 2: {
                n.D(boolean0);
                return boolean0;
            }
            case 3: {
                v2 = b0.B;
                e1 = b0.r;
                n.D(boolean0);
                goto label_63;
            }
            case 4: {
                n.D(boolean0);
                return boolean0;
            }
            case 5: {
                n.D(boolean0);
                return boolean0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }

    public final Object g1(E e0, oe.c c0) {
        H h1;
        E e2;
        Uri uri0;
        Vb.E e1;
        if(c0 instanceof Vb.E) {
            e1 = (Vb.E)c0;
            int v = e1.D;
            if((v & 0x80000000) == 0) {
                e1 = new Vb.E(this, c0);
            }
            else {
                e1.D = v ^ 0x80000000;
            }
        }
        else {
            e1 = new Vb.E(this, c0);
        }
        Object object0 = e1.w;
        ne.a a0 = ne.a.a;
        switch(e1.D) {
            case 0: {
                n.D(object0);
                kotlin.jvm.internal.q.g(e0, "mediaItem");
                String s = e0.a;
                h h0 = this.B;
                kotlin.jvm.internal.q.g(h0, "melonCurrentPlaylist");
                v0 v00 = F.X(e0);
                PremiumContentsEntity premiumContentsEntity0 = k9.e.b(v00.c, v00.b.getValue());
                if(premiumContentsEntity0 != null) {
                    try {
                        String s1 = ec.g.a(premiumContentsEntity0);
                        uri0 = s1.length() > 0 ? Uri.parse(s1) : Uri.EMPTY;
                    }
                    catch(Throwable throwable0) {
                        uri0 = n.t(throwable0);
                    }
                    Throwable throwable1 = ie.p.a(uri0);
                    if(throwable1 != null) {
                        LogU.error$default(ec.g.b, "getOfflineUri() Failed to get offline uri", throwable1, false, 4, null);
                        uri0 = Uri.EMPTY;
                    }
                    kotlin.jvm.internal.q.f(uri0, "getOrElse(...)");
                    if(!uri0.equals(Uri.EMPTY)) {
                        Playable playable0 = m.t(h0, F.X(e0).a);
                        if(playable0 == null) {
                            LogU.error$default(ec.g.b, "updatePlayable() Invalid Playable: " + s, null, false, 6, null);
                        }
                        else {
                            playable0.setBitrate(premiumContentsEntity0.e);
                            playable0.setMetatype(premiumContentsEntity0.d);
                            playable0.setMimeType(premiumContentsEntity0.f);
                            playable0.setLoggingToken("");
                        }
                        androidx.media3.common.c c1 = e0.d.a();
                        String s2 = ImageUrl.getOfflineImagePath(MelonImageFetcherType.Large, premiumContentsEntity0);
                        File file0 = new File(k9.d.a, s2);
                        if(file0.exists()) {
                            MelonAppBase.Companion.getClass();
                            Uri uri1 = FileUtils.getFileUri(k8.t.a().getContext(), file0);
                            k8.t.a().getContext().grantUriPermission("com.google.android.projection.gearhead", uri1, 1);
                            c1.m = uri1;
                            G g0 = new G(c1);
                            s s3 = e0.a();
                            s3.k = g0;
                            e2 = s3.a();
                        }
                        else {
                            e2 = e0;
                        }
                        ac.q q0 = new ac.q(e2, uri0, ac.t.a, null, 24);
                        e1.r = q0;
                        e1.D = 1;
                        if(kotlin.jvm.internal.q.b(e2, E.g)) {
                            h1 = H.a;
                        }
                        else {
                            l0 l00 = new l0(this, e2, null);
                            h1 = BuildersKt.withContext(this.y, l00, e1);
                            if(h1 != ne.a.a) {
                                h1 = H.a;
                            }
                        }
                        return h1 == a0 ? a0 : q0;
                    }
                    LogU.error$default(ec.g.b, "getOfflineUriAndPrepare() Invalid Offline Uri: " + s, null, false, 6, null);
                    MelonAppBase.Companion.getClass();
                    kotlin.jvm.internal.q.f("재생파일 오류입니다.", "getString(...)");
                    throw new Sb.b("재생파일 오류입니다.", new IllegalStateException("getMediaItemSource() Invalid Offline Item uri"));
                }
                LogU.error$default(ec.g.b, "getOfflineUriAndPrepare() Invalid Offline Item: " + s, null, false, 6, null);
                MelonAppBase.Companion.getClass();
                kotlin.jvm.internal.q.f("재생파일 오류입니다.", "getString(...)");
                throw new Sb.b("재생파일 오류입니다.", new IllegalStateException("getMediaItemSource() Invalid Offline Item"));
            }
            case 1: {
                ac.q q1 = e1.r;
                n.D(object0);
                return q1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public final Object h1(E e0, z0 z00, int v, oe.c c0) {
        H h0;
        Vb.F f0;
        if(c0 instanceof Vb.F) {
            f0 = (Vb.F)c0;
            int v1 = f0.E;
            if((v1 & 0x80000000) == 0) {
                f0 = new Vb.F(this, c0);
            }
            else {
                f0.E = v1 ^ 0x80000000;
            }
        }
        else {
            f0 = new Vb.F(this, c0);
        }
        Object object0 = f0.B;
        ne.a a0 = ne.a.a;
        switch(f0.E) {
            case 0: {
                n.D(object0);
                f0.w = v;
                f0.E = 1;
                c c1 = this.D;
                c1.getClass();
                String s = F.E(e0).getQueryParameter("liveSeq");
                if(s == null) {
                    s = "";
                }
                object0 = s.length() <= 0 ? c1.b(e0, z00, v, f0) : c1.b.b(e0, f0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = f0.w;
                n.D(object0);
                break;
            }
            case 2: {
                Object object1 = f0.r;
                n.D(object0);
                return object1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        E e1 = ((ac.q)object0).a;
        f0.r = object0;
        f0.w = v;
        f0.E = 2;
        if(kotlin.jvm.internal.q.b(e1, E.g)) {
            h0 = H.a;
        }
        else {
            l0 l00 = new l0(this, e1, null);
            h0 = BuildersKt.withContext(this.y, l00, f0);
            if(h0 != a0) {
                h0 = H.a;
            }
        }
        return h0 == a0 ? a0 : object0;
    }

    public final Object i1(z0 z00, Sb.a a0, E e0, oe.c c0) {
        int v5;
        E e1;
        Sb.a a2;
        H h1;
        Vb.G g0;
        if(c0 instanceof Vb.G) {
            g0 = (Vb.G)c0;
            int v = g0.E;
            if((v & 0x80000000) == 0) {
                g0 = new Vb.G(this, c0);
            }
            else {
                g0.E = v ^ 0x80000000;
            }
        }
        else {
            g0 = new Vb.G(this, c0);
        }
        Object object0 = g0.B;
        ne.a a1 = ne.a.a;
        H h0 = H.a;
        AtomicInteger atomicInteger0 = this.K;
        t0 t00 = this.F;
        switch(g0.E) {
            case 0: {
                n.D(object0);
                g0.r = a0;
                g0.w = e0;
                g0.E = 1;
                if(!(a0 instanceof Yb.w) || atomicInteger0.get() >= ((s0)t00.f.getValue()).a) {
                    h1 = this.r1(z00, a0, e0, g0);
                    if(h1 != a1) {
                        h1 = h0;
                    }
                }
                else {
                    h1 = h0;
                }
                if(h1 == a1) {
                    return a1;
                }
                a2 = a0;
                e1 = e0;
                goto label_34;
            }
            case 1: {
                e1 = g0.w;
                Sb.a a3 = g0.r;
                n.D(object0);
                a2 = a3;
            label_34:
                int v1 = atomicInteger0.getAndIncrement();
                int v2 = ((s0)t00.f.getValue()).a;
                Service service0 = this.j;
                if(v1 >= v2 || F.M(e1)) {
                    goto label_47;
                }
                LogConstantsKt.buildDebug(this.e1(), true, new H8.o(v2, v1, 1));
                kotlin.jvm.internal.q.f("재생 요청 중입니다...(%1$d/%2$d)", "getString(...)");
                ToastManager.show(String.format("재생 요청 중입니다...(%1$d/%2$d)", Arrays.copyOf(new Object[]{new Integer(v1 + 1), new Integer(v2)}, 2)));
                Vb.H h2 = new Vb.H(this, e1, null);
                g0.r = null;
                g0.w = null;
                g0.E = 2;
                if(BuildersKt.withContext(this.x, h2, g0) == a1) {
                    return a1;
                label_47:
                    atomicInteger0.set(0);
                    AtomicInteger atomicInteger1 = this.L;
                    int v3 = atomicInteger1.getAndIncrement();
                    int v4 = ((s0)t00.f.getValue()).b;
                    boolean z = ((AppVisibilityManagerImpl)t00.a).e;
                    boolean z1 = v3 < v4 && !z;
                    LogConstantsKt.buildDebug(this.e1(), true, new Vb.h(v4, v3, !z, z1));
                    if(z1) {
                        kotlin.jvm.internal.q.g(e1, "<this>");
                        kotlin.jvm.internal.q.f(e1.a, "mediaId");
                        CType cType0 = F.Y(e1.a).b;
                        if(cType0.equals(CType.LIVE)) {
                            v5 = 0x7F1303ED;  // string:error_player_video "비디오 재생 중 문제가 발생했습니다.\n잠시 후 다시 시도해 주세요."
                        }
                        else {
                            v5 = cType0.equals(CType.MV) ? 0x7F1303E6 : 0x7F1303E5;  // string:error_playback_play_next_mv "재생에 실패하여 다음 비디오 재생을 요청합니다."
                        }
                        ToastManager.show(service0.getString(v5));
                        this.t();
                    }
                    else {
                        atomicInteger1.set(0);
                        y.K0(this, false, 0, a2, "handleMediaPlayerException()", 3);
                    }
                    String s = a2.getMessage();
                    if(s == null) {
                        s = "";
                    }
                    Xb.i i0 = new Xb.i(s);
                    this.A.b(i0);
                    return h0;
                }
                this.p1(this.L(), this.getContentPosition());
                return h0;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(object0);
        this.p1(this.L(), this.getContentPosition());
        return h0;
    }

    public final void j1(we.a a0) {
        try {
            this.B0();
            a0.invoke();
        }
        catch(Exception exception0) {
            this.k1(new Yb.o("whenHandleMelonPlaylistChange", exception0), this.n.e.a1(), null);
        }
    }

    public final void k1(Yb.o o0, z0 z00, E e0) {
        Vb.Q q0 = new Vb.Q(this, o0, z00, e0, null);
        BuildersKt__Builders_commonKt.launch$default(this.u, null, null, q0, 3, null);
        a7.c.a().c(o0);
        y.K0(this, false, -1, o0, null, 8);
        S s0 = new S(this, null);
        BuildersKt__Builders_commonKt.launch$default(this.u, this.v, null, s0, 2, null);
    }

    public final void l1(int v, int v1, long v2) {
        LogConstantsKt.buildDebug$default(this.e1(), false, new H8.p(v, v1, 5, v2), 1, null);
        me.i i0 = this.v.plus(this.W);
        W w0 = new W(this, v2, null);
        BuildersKt__Builders_commonKt.launch$default(this.u, i0, null, w0, 2, null);
    }

    public final void m1(int v, int v1, long v2) {
        LogConstantsKt.buildDebug$default(this.e1(), false, new H8.p(v, v1, 4, v2), 1, null);
        me.i i0 = this.v.plus(this.W);
        Z z0 = new Z(this, null);
        BuildersKt__Builders_commonKt.launch$default(this.u, i0, null, z0, 2, null);
    }

    public final Object n1(oe.c c0) {
        Mutex mutex3;
        Mutex mutex2;
        int v2;
        Mutex mutex0;
        Vb.a0 a00;
        H h0 = H.a;
        if(c0 instanceof Vb.a0) {
            a00 = (Vb.a0)c0;
            int v = a00.G;
            if((v & 0x80000000) == 0) {
                a00 = new Vb.a0(this, c0);
            }
            else {
                a00.G = v ^ 0x80000000;
            }
        }
        else {
            a00 = new Vb.a0(this, c0);
        }
        Object object0 = a00.D;
        ne.a a0 = ne.a.a;
        int v1 = 0;
        switch(a00.G) {
            case 0: {
                n.D(object0);
                if(!this.X) {
                    mutex0 = this.Y;
                    a00.r = mutex0;
                    a00.w = 0;
                    a00.G = 1;
                    if(mutex0.lock(null, a00) == a0) {
                        return a0;
                    }
                    v2 = 0;
                    goto label_29;
                }
                return h0;
            }
            case 1: {
                v2 = a00.w;
                Mutex mutex1 = a00.r;
                n.D(object0);
                mutex0 = mutex1;
            label_29:
                if(!this.X) {
                    try {
                        a00.r = mutex0;
                        a00.w = v2;
                        a00.B = 0;
                        a00.G = 2;
                        H h1 = ((com.melon.playlist.b)this.B.a).U(this.a0, a00);
                        if(h1 != a0) {
                            h1 = h0;
                        }
                        if(h1 == a0) {
                            return a0;
                            try {
                            label_39:
                                v1 = a00.B;
                                v2 = a00.w;
                                mutex2 = a00.r;
                                n.D(object0);
                                mutex0 = mutex2;
                            }
                            catch(Throwable throwable1) {
                                mutex3 = mutex2;
                                goto label_64;
                            }
                        }
                        c0 c00 = new c0(this, null);
                        a00.r = mutex0;
                        a00.w = v2;
                        a00.B = v1;
                        a00.G = 3;
                        if(CoroutineScopeKt.coroutineScope(c00, a00) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        mutex3 = mutex0;
                        throwable1 = throwable0;
                        goto label_64;
                    }
                }
                break;
            }
            case 2: {
                goto label_39;
            }
            case 3: {
                try {
                    mutex3 = a00.r;
                    n.D(object0);
                    mutex0 = mutex3;
                    break;
                }
                catch(Throwable throwable1) {
                }
            label_64:
                mutex3.unlock(null);
                throw throwable1;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex0.unlock(null);
        return h0;
    }

    public final void o1() {
        LogConstantsKt.infoOnlyDebugMode(this.e1(), "resetResumeAfterGain()");
        this.D0().m = false;
    }

    public final void p1(int v, long v1) {
        E e0;
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append("seekItemImpl() mediaItemIndex: " + v);
        Cb.i.a(stringBuilder0, "positionMs: " + v1);
        LogConstantsKt.debugOnlyDebugMode(this.l, stringBuilder0.toString());
        this.B0();
        try {
            e0 = this.getCurrentTimeline().m(v, ((b3.o0)this.b), 0L).c;
        }
        catch(Throwable throwable0) {
            e0 = n.t(throwable0);
        }
        Throwable throwable1 = ie.p.a(e0);
        if(throwable1 != null) {
            LogU.error$default(this.l, e.b("prepareItem() getMediaItemAt() error: ", throwable1.getMessage()), null, false, 6, null);
        }
        E e1 = E.g;
        if(e0 instanceof ie.o) {
            e0 = e1;
        }
        kotlin.jvm.internal.q.f(e0, "getOrDefault(...)");
        if(e0.equals(e1)) {
            ToastManager.show((kotlin.jvm.internal.q.b(this.n.e.a1(), x0.b) ? 0x7F13082C : 0x7F13082B));  // string:playlist_empty_mv "재생할 비디오가 없습니다."
            y.K0(this, false, 0, null, "prepareItem() mediaItem is empty.", 7);
        }
        else {
            MutableStateFlow mutableStateFlow0 = (MutableStateFlow)this.m.getValue();
            do {
                Object object0 = mutableStateFlow0.getValue();
                androidx.media3.common.d d0 = ((i0)object0).a();
                d0.y = v;
            }
            while(!androidx.appcompat.app.o.B(d0, mutableStateFlow0, object0));
            this.v0();
            this.G0(e0, v1);
        }
        this.Y0();
    }

    public final void q1() {
        AtomicInteger atomicInteger0 = this.M;
        int v = atomicInteger0.getAndIncrement();
        LogConstantsKt.buildDebug(this.e1(), true, new C8.e(v, this, 5));
        this.F.getClass();
        if(v < 3) {
            if(this.N.get() == 7) {
                this.k();
                return;
            }
            this.t();
            return;
        }
        atomicInteger0.set(0);
        y.K0(this, false, 0, null, "seekToNextOrPrevious()", 7);
    }

    public final Object r1(z0 z00, Sb.a a0, E e0, oe.c c0) {
        f0 f00 = new f0(this, a0, e0, z00, null);
        Object object0 = BuildersKt.withContext(this.x, f00, c0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    public final void s1(d d0) {
        this.O = d0;
        Nb.t0 t00 = (Nb.t0)this.I.getValue();
        r0 r00 = new r0(d0);
        t00.getClass();
        String s = F.a0(this.getPlaybackState());
        LogConstantsKt.infoOnlyDebugMode(t00.c, "onMelonEvents() [" + s + "] " + r00);
        MutableStateFlow mutableStateFlow0 = t00.b.b;
        do {
            Object object0 = mutableStateFlow0.getValue();
            kotlin.jvm.internal.q.g(((fc.a)object0), "state");
        }
        while(!mutableStateFlow0.compareAndSet(object0, fc.a.a(((fc.a)object0), 0, false, null, 0L, 0L, null, null, null, null, r00.a, 0x1FF)));
    }

    public final Object t1(long v, oe.c c0) {
        g0 g00;
        if(c0 instanceof g0) {
            g00 = (g0)c0;
            int v1 = g00.D;
            if((v1 & 0x80000000) == 0) {
                g00 = new g0(this, c0);
            }
            else {
                g00.D = v1 ^ 0x80000000;
            }
        }
        else {
            g00 = new g0(this, c0);
        }
        Object object0 = g00.w;
        ne.a a0 = ne.a.a;
        switch(g00.D) {
            case 0: {
                n.D(object0);
                this.B0();
                LogConstantsKt.buildDebug$default(this.e1(), false, new Cc.h0(v, 13), 1, null);
                g00.r = v;
                g00.D = 1;
                if(this.n1(g00) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = g00.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(v < 0L) {
            LogU.error$default(this.e1(), e.a(v, "setRangeRepeatA() Invalid positionMs: "), null, false, 6, null);
            return new Failure(e.a(v, "Invalid positionMs: "));
        }
        E e0 = this.W();
        if(e0 == null) {
            LogU.error$default(this.e1(), "setRangeRepeatA() currentMediaItem is null", null, false, 6, null);
            return new Failure("currentMediaItem is null");
        }
        this.D.getClass();
        if(c.c(e0) && !Ob.b.b()) {
            LogU.error$default(this.e1(), "setRangeRepeatA() CacheManager is disabled", null, false, 6, null);
            return FailureDisabledStreamCache.a;
        }
        this.s1(new ac.b(v));
        return Success.a;
    }

    public final Object u1(List list0, oe.c c0) {
        j0 j00 = new j0(list0, this, System.currentTimeMillis(), null);
        return BuildersKt.withContext(this.w, j00, c0);
    }

    public final Object v1(Yb.k k0, oe.c c0) {
        ie.m m0;
        Vb.k0 k00;
        if(c0 instanceof Vb.k0) {
            k00 = (Vb.k0)c0;
            int v = k00.B;
            if((v & 0x80000000) == 0) {
                k00 = new Vb.k0(this, c0);
            }
            else {
                k00.B = v ^ 0x80000000;
            }
        }
        else {
            k00 = new Vb.k0(this, c0);
        }
        Object object0 = k00.r;
        ne.a a0 = ne.a.a;
        switch(k00.B) {
            case 0: {
                n.D(object0);
                LogU logU0 = this.e1();
                DcfError dcfError0 = k0.d;
                LogU.info$default(logU0, e.b("tryExtendDrmContents() ", dcfError0.getMessage()), null, false, 6, null);
                DcfFile dcfFile0 = dcfError0.b;
                if(dcfFile0 == null) {
                    m0 = new ie.m(Boolean.TRUE, "Not found file");
                }
                else if(AndroidSettings.isAirplaneMode()) {
                    m0 = new ie.m(Boolean.TRUE, "AirplaneMode");
                }
                else if(dcfError0.a != -101) {
                    m0 = new ie.m(Boolean.TRUE, "Unknown Error: " + dcfError0.getMessage());
                }
                else if(NetUtils.checkDataNetwork() == 2) {
                    m0 = new ie.m(Boolean.TRUE, "Not Available Network");
                }
                else if(!NetUtils.isConnected()) {
                    m0 = new ie.m(Boolean.TRUE, "Not Available Network");
                }
                else if(((e0)va.o.a()).m()) {
                    m0 = new ie.m(Boolean.FALSE, "");
                }
                else {
                    m0 = new ie.m(Boolean.TRUE, "Need Login");
                }
                String s = (String)m0.b;
                if(((Boolean)m0.a).booleanValue()) {
                    LogConstantsKt.debugOnlyDebugMode(this.e1(), "tryExtendDrmContents() Throw Exception: " + s);
                    throw k0;
                }
                kotlin.jvm.internal.q.d(dcfFile0);
                k00.B = 1;
                object0 = this.G.a(dcfFile0, false, k00);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((com.melon.playback.melon.drm.f)object0) instanceof com.melon.playback.melon.drm.e) {
            LogConstantsKt.debugOnlyDebugMode(this.e1(), "tryExtendDrmContents() Success");
            CollectionRulesDcf collectionRulesDcf0 = ((com.melon.playback.melon.drm.e)(((com.melon.playback.melon.drm.f)object0))).b;
            if(((AppVisibilityManagerImpl)this.F.a).e && collectionRulesDcf0 != null && collectionRulesDcf0.c && collectionRulesDcf0.d) {
                kotlin.jvm.internal.q.f("요청하신 DCF 파일의 재생 기간연장을 완료했습니다.", "getString(...)");
                String s1 = this.j.getString(0x7F1302A8, new Object[]{new Integer(((com.melon.playback.melon.drm.e)(((com.melon.playback.melon.drm.f)object0))).a), new Integer(collectionRulesDcf0.f), new Integer(collectionRulesDcf0.e)});  // string:dcf_auto_extend_result_stat2 "(차감 %1$d, 잔여 %2$d/전체 %3$d)"
                kotlin.jvm.internal.q.f(s1, "getString(...)");
                SimpleTextNotificationKt.showSimpleTextNotification("요청하신 DCF 파일의 재생 기간연장을 완료했습니다.", s1);
            }
            return H.a;
        }
        if(!(((com.melon.playback.melon.drm.f)object0) instanceof com.melon.playback.melon.drm.d)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        LogConstantsKt.errorOnlyDebugMode(this.e1(), "tryExtendDrmContents() Failed " + ((com.melon.playback.melon.drm.d)(((com.melon.playback.melon.drm.f)object0))).a.getMessage());
        throw ((com.melon.playback.melon.drm.d)(((com.melon.playback.melon.drm.f)object0))).a;
    }

    public final void w1(String s, String s1) {
        LogU.info$default(this.e1(), "updateMelonCpKey() reason: " + s1, null, false, 6, null);
        MelonAppBase.Companion.getClass();
        MelonAppBase melonAppBase0 = k8.t.a();
        if(s.length() > 0) {
            melonAppBase0.updateMelonCpKey(s);
            return;
        }
        MelonAppBase.updateMelonCpKey$default(melonAppBase0, null, 1, null);
    }
}

