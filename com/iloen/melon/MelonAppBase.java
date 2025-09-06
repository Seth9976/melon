package com.iloen.melon;

import Cc.c1;
import Pd.h;
import Pd.i;
import Ub.q;
import Ub.s;
import Y8.d;
import Z8.g;
import a7.c;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Build;
import co.ab180.airbridge.Airbridge;
import co.ab180.airbridge.AirbridgeOptionBuilder;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.iloen.melon.mcache.MelonStreamCacheManager;
import com.iloen.melon.net.NetworkStatusManager;
import com.iloen.melon.net.OkHttpStack;
import com.iloen.melon.task.MelonServiceManager;
import com.iloen.melon.utils.FlipperManager;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.billing.BillingUtils;
import com.iloen.melon.utils.log.AdIdManager;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.ServerPhase;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.template.TemplateImageCacheManager;
import com.iloen.melon.utils.ui.MelonThemeUtils;
import com.kakao.emoticon.KakaoEmoticon;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ServerHosts;
import com.kakao.sdk.partner.model.KakaoPhase;
import com.kakao.sdk.partner.model.ServerHostsKt;
import com.kakao.tiara.TiaraConfiguration.Builder;
import com.kakao.tiara.TiaraConfiguration;
import com.kakao.tiara.TiaraTracker;
import com.kakaoent.trevi.ad.TreviAd;
import com.kakaoent.trevi.ad.constants.ServerConfig;
import com.melon.data.database.MelonDatabase;
import com.melon.playback.FloatingLyricService;
import com.melon.playlist.b;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import com.melon.utils.system.DeviceData;
import d5.n;
import i5.e;
import i5.f;
import ie.H;
import ie.r;
import io.netty.util.NetUtil;
import javax.inject.Inject;
import jd.e3;
import k8.A;
import k8.B;
import k8.D;
import k8.Y;
import k8.t;
import k8.u;
import k8.v;
import k8.x;
import k8.y;
import kc.d1;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import ne.a;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.j;
import p8.p;
import va.Z;
import va.e0;
import va.o;
import w8.V0;

@Metadata(d1 = {"\u0000\u009E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 \u00A3\u00012\u00020\u00012\u00020\u0002:\u0002\u00A4\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\u000B\u0010\u0004J\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\u00052\b\b\u0002\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u001D\u0010\u0016\u001A\u00020\u00052\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013\u00A2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001A\u00020\u00188\u0006@\u0006X\u0086.\u00A2\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\"\u0010$\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\"\"\u0004\b#\u0010\u0012R$\u0010(\u001A\u00020\u000F2\u0006\u0010%\u001A\u00020\u000F8\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b&\u0010 \u001A\u0004\b\'\u0010\"R\"\u00100\u001A\u00020)8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b*\u0010+\u001A\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00104\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b1\u0010 \u001A\u0004\b2\u0010\"\"\u0004\b3\u0010\u0012R\"\u00108\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b5\u0010 \u001A\u0004\b6\u0010\"\"\u0004\b7\u0010\u0012R\"\u0010<\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010 \u001A\u0004\b:\u0010\"\"\u0004\b;\u0010\u0012R$\u0010D\u001A\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b>\u0010?\u001A\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010L\u001A\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bF\u0010G\u001A\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010N\u001A\u00020M8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bN\u0010O\u001A\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010U\u001A\u00020T8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bU\u0010V\u001A\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001A\u00020[8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b\\\u0010]\u001A\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010d\u001A\u00020\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bb\u0010c\u001A\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010i\u001A\u00020\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bh\u0010c\u001A\u0004\bi\u0010e\"\u0004\bj\u0010gR\"\u0010n\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bk\u0010 \u001A\u0004\bl\u0010\"\"\u0004\bm\u0010\u0012R\"\u0010p\u001A\u00020\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bo\u0010c\u001A\u0004\bp\u0010e\"\u0004\bq\u0010gR\"\u0010s\u001A\u00020\u00138\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\br\u0010c\u001A\u0004\bs\u0010e\"\u0004\bt\u0010gR\"\u0010v\u001A\u00020u8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bv\u0010w\u001A\u0004\bx\u0010y\"\u0004\bz\u0010{R%\u0010}\u001A\u00020|8\u0006@\u0006X\u0087.\u00A2\u0006\u0015\n\u0004\b}\u0010~\u001A\u0005\b\u007F\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0084\u0001\u001A\u00030\u0083\u00018\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001A\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R*\u0010\u008B\u0001\u001A\u00030\u008A\u00018\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u008B\u0001\u0010\u008C\u0001\u001A\u0006\b\u008D\u0001\u0010\u008E\u0001\"\u0006\b\u008F\u0001\u0010\u0090\u0001R*\u0010\u0092\u0001\u001A\u00030\u0091\u00018\u0006@\u0006X\u0087.\u00A2\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u0093\u0001\u001A\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0015\u0010\u009B\u0001\u001A\u00030\u0098\u00018F\u00A2\u0006\b\u001A\u0006\b\u0099\u0001\u0010\u009A\u0001R\u0013\u0010\u009C\u0001\u001A\u00020\u00138F\u00A2\u0006\u0007\u001A\u0005\b\u009C\u0001\u0010eR\u0013\u0010\u009D\u0001\u001A\u00020\u00138F\u00A2\u0006\u0007\u001A\u0005\b\u009D\u0001\u0010eR\u0013\u0010\u009E\u0001\u001A\u00020\u00138F\u00A2\u0006\u0007\u001A\u0005\b\u009E\u0001\u0010eR\u001D\u0010\u009F\u0001\u001A\u00020\u00138FX\u0087\u0004\u00A2\u0006\u000E\u0012\u0005\b\u00A0\u0001\u0010\u0004\u001A\u0005\b\u009F\u0001\u0010eR\u001D\u0010\u00A1\u0001\u001A\u00020\u00138FX\u0087\u0004\u00A2\u0006\u000E\u0012\u0005\b\u00A2\u0001\u0010\u0004\u001A\u0005\b\u00A1\u0001\u0010e\u00A8\u0006\u00A5\u0001"}, d2 = {"Lcom/iloen/melon/MelonAppBase;", "Landroid/app/Application;", "Li5/f;", "<init>", "()V", "Lie/H;", "onCreate", "", "level", "onTrimMemory", "(I)V", "onLowMemory", "Li5/e;", "newImageLoader", "()Li5/e;", "", "cpKey", "updateMelonCpKey", "(Ljava/lang/String;)V", "", "isForeground", "isTopStack", "setMusicMsgFragmentVisualStatus", "(ZZ)V", "Lcom/android/volley/RequestQueue;", "requestQueue", "Lcom/android/volley/RequestQueue;", "getRequestQueue", "()Lcom/android/volley/RequestQueue;", "setRequestQueue", "(Lcom/android/volley/RequestQueue;)V", "d", "Ljava/lang/String;", "getMelonCpId", "()Ljava/lang/String;", "setMelonCpId", "melonCpId", "value", "e", "getMelonCpKey", "melonCpKey", "", "f", "F", "getMelonImageviewDefaultRadius", "()F", "setMelonImageviewDefaultRadius", "(F)V", "melonImageviewDefaultRadius", "g", "getHostAddress", "setHostAddress", "hostAddress", "h", "getMelonProtocolUserAgent", "setMelonProtocolUserAgent", "melonProtocolUserAgent", "i", "getMelonWebViewUserAgent", "setMelonWebViewUserAgent", "melonWebViewUserAgent", "LY8/d;", "j", "LY8/d;", "getGoogleIapLifecycle", "()LY8/d;", "setGoogleIapLifecycle", "(LY8/d;)V", "googleIapLifecycle", "LZ8/g;", "k", "LZ8/g;", "getOneStoreIapLifecycle", "()LZ8/g;", "setOneStoreIapLifecycle", "(LZ8/g;)V", "oneStoreIapLifecycle", "Lcom/melon/utils/system/DeviceData;", "deviceData", "Lcom/melon/utils/system/DeviceData;", "getDeviceData", "()Lcom/melon/utils/system/DeviceData;", "setDeviceData", "(Lcom/melon/utils/system/DeviceData;)V", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "LUb/s;", "remoteManager", "LUb/s;", "getRemoteManager", "()LUb/s;", "setRemoteManager", "(LUb/s;)V", "l", "Z", "isAppPip", "()Z", "setAppPip", "(Z)V", "m", "isVideoMiniPlayer", "setVideoMiniPlayer", "n", "getMusicMessageCurrentInboxSeq", "setMusicMessageCurrentInboxSeq", "musicMessageCurrentInboxSeq", "o", "isLoanedAudioFocus", "setLoanedAudioFocus", "w", "isAndroidAutoConnected", "setAndroidAutoConnected", "LUb/q;", "playbackManager", "LUb/q;", "getPlaybackManager", "()LUb/q;", "setPlaybackManager", "(LUb/q;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "LPd/i;", "appVisibilityManager", "LPd/i;", "getAppVisibilityManager", "()LPd/i;", "setAppVisibilityManager", "(LPd/i;)V", "Lw8/V0;", "appWidgetUpdater", "Lw8/V0;", "getAppWidgetUpdater", "()Lw8/V0;", "setAppWidgetUpdater", "(Lw8/V0;)V", "Lcom/melon/data/database/MelonDatabase;", "melonDatabase", "Lcom/melon/data/database/MelonDatabase;", "getMelonDatabase", "()Lcom/melon/data/database/MelonDatabase;", "setMelonDatabase", "(Lcom/melon/data/database/MelonDatabase;)V", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "isMusicMessageForeground", "isMusicMessageTopStack", "isCarConnected", "isAppForeground", "isAppForeground$annotations", "isLockScreenForeground", "isLockScreenForeground$annotations", "Companion", "k8/t", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MelonAppBase extends Hilt_MelonAppBase implements f {
    public static final int $stable = 8;
    public final r B;
    @NotNull
    public static final t Companion;
    @Inject
    public i appVisibilityManager;
    @Inject
    public V0 appWidgetUpdater;
    public final LogU c;
    public String d;
    @Inject
    public DeviceData deviceData;
    public String e;
    public float f;
    public String g;
    public String h;
    public String i;
    public static MelonAppBase instance;
    public d j;
    public g k;
    public boolean l;
    public boolean m;
    @Inject
    public MelonDatabase melonDatabase;
    public String n;
    public boolean o;
    @Inject
    public q playbackManager;
    @Inject
    public z playerUseCase;
    @Inject
    public s2 playlistManager;
    public int r;
    @Inject
    public s remoteManager;
    public RequestQueue requestQueue;
    public boolean w;

    static {
        MelonAppBase.Companion = new t();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public MelonAppBase() {
        LogU logU0 = new LogU("MelonAppBase");
        logU0.setCategory(Category.None);
        logU0.setUseThreadInfo(true);
        this.c = logU0;
        this.d = "";
        this.e = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.n = "";
        this.B = d3.g.Q(new e3(this, 4));
        MelonAppBase.Companion.getClass();
        MelonAppBase.instance = this;
    }

    public static final Object access$handleLifecycleEvent(MelonAppBase melonAppBase0, h h0, Continuation continuation0) {
        v v0;
        melonAppBase0.getClass();
        if(continuation0 instanceof v) {
            v0 = (v)continuation0;
            int v1 = v0.B;
            if((v1 & 0x80000000) == 0) {
                v0 = new v(melonAppBase0, continuation0);
            }
            else {
                v0.B = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new v(melonAppBase0, continuation0);
        }
        Object object0 = v0.r;
        a a0 = a.a;
        switch(v0.B) {
            case 0: {
                n.D(object0);
                if(h0 instanceof Pd.f) {
                    ec.f f0 = new ec.f(1, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ec.d(f0, null), 3, null);
                    b b0 = (b)((d3)melonAppBase0.getPlaylistManager()).a;
                    d1 d10 = new d1(b0, null);
                    BuildersKt__Builders_commonKt.launch$default(b0.m, null, null, d10, 3, null);
                    return H.a;
                }
                if(h0 instanceof Pd.d && ((Pd.d)h0).a instanceof MusicBrowserActivity) {
                    k k0 = o.a();
                    v0.B = 1;
                    object0 = ((e0)k0).o(v0);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_29;
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_29:
                if(((Boolean)object0).booleanValue()) {
                    e0 e00 = (e0)o.a();
                    Z z0 = new Z(e00, null);
                    BuildersKt__Builders_commonKt.launch$default(e00.i, null, null, z0, 3, null);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    @NotNull
    public final i getAppVisibilityManager() {
        i i0 = this.appVisibilityManager;
        if(i0 != null) {
            return i0;
        }
        kotlin.jvm.internal.q.m("appVisibilityManager");
        throw null;
    }

    @NotNull
    public final V0 getAppWidgetUpdater() {
        V0 v00 = this.appWidgetUpdater;
        if(v00 != null) {
            return v00;
        }
        kotlin.jvm.internal.q.m("appWidgetUpdater");
        throw null;
    }

    @NotNull
    public final Context getContext() {
        MelonAppBase.Companion.getClass();
        Context context0 = t.a().getApplicationContext();
        kotlin.jvm.internal.q.f(context0, "getApplicationContext(...)");
        return context0;
    }

    @NotNull
    public final DeviceData getDeviceData() {
        DeviceData deviceData0 = this.deviceData;
        if(deviceData0 != null) {
            return deviceData0;
        }
        kotlin.jvm.internal.q.m("deviceData");
        throw null;
    }

    @Nullable
    public final d getGoogleIapLifecycle() {
        return this.j;
    }

    @NotNull
    public final String getHostAddress() {
        return this.g;
    }

    @NotNull
    public final String getMelonCpId() {
        return this.d;
    }

    @NotNull
    public final String getMelonCpKey() {
        return this.e;
    }

    @NotNull
    public final MelonDatabase getMelonDatabase() {
        MelonDatabase melonDatabase0 = this.melonDatabase;
        if(melonDatabase0 != null) {
            return melonDatabase0;
        }
        kotlin.jvm.internal.q.m("melonDatabase");
        throw null;
    }

    public final float getMelonImageviewDefaultRadius() {
        return this.f;
    }

    @NotNull
    public final String getMelonProtocolUserAgent() {
        return this.h;
    }

    @NotNull
    public final String getMelonWebViewUserAgent() {
        return this.i;
    }

    @NotNull
    public final String getMusicMessageCurrentInboxSeq() {
        return this.n;
    }

    @Nullable
    public final g getOneStoreIapLifecycle() {
        return this.k;
    }

    @NotNull
    public final q getPlaybackManager() {
        q q0 = this.playbackManager;
        if(q0 != null) {
            return q0;
        }
        kotlin.jvm.internal.q.m("playbackManager");
        throw null;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        kotlin.jvm.internal.q.m("playerUseCase");
        throw null;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        s2 s20 = this.playlistManager;
        if(s20 != null) {
            return s20;
        }
        kotlin.jvm.internal.q.m("playlistManager");
        throw null;
    }

    @NotNull
    public final s getRemoteManager() {
        s s0 = this.remoteManager;
        if(s0 != null) {
            return s0;
        }
        kotlin.jvm.internal.q.m("remoteManager");
        throw null;
    }

    @NotNull
    public final RequestQueue getRequestQueue() {
        RequestQueue requestQueue0 = this.requestQueue;
        if(requestQueue0 != null) {
            return requestQueue0;
        }
        kotlin.jvm.internal.q.m("requestQueue");
        throw null;
    }

    public final boolean isAndroidAutoConnected() {
        return this.w;
    }

    public final boolean isAppForeground() {
        return ((AppVisibilityManagerImpl)this.getAppVisibilityManager()).e;
    }

    @ie.d
    public static void isAppForeground$annotations() {
    }

    public final boolean isAppPip() {
        return this.l;
    }

    public final boolean isCarConnected() {
        return this.w;
    }

    public final boolean isLoanedAudioFocus() {
        return this.o;
    }

    public final boolean isLockScreenForeground() {
        return ((AppVisibilityManagerImpl)this.getAppVisibilityManager()).f;
    }

    @ie.d
    public static void isLockScreenForeground$annotations() {
    }

    public final boolean isMusicMessageForeground() {
        return this.r == 2 || this.r == 3;
    }

    public final boolean isMusicMessageTopStack() {
        return this.r == 1 || this.r == 3;
    }

    public final boolean isVideoMiniPlayer() {
        return this.m;
    }

    @Override  // i5.f
    @NotNull
    public e newImageLoader() {
        return c1.V(this);
    }

    @Override  // com.iloen.melon.Hilt_MelonAppBase
    public void onCreate() {
        ServerHosts serverHosts0;
        super.onCreate();
        LogU.info$default(this.c, "onCreate()", null, false, 6, null);
        LogU.debug$default(this.c, "migrateMelonDb()", null, false, 6, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new A(this, null), 3, null);
        MelonThemeUtils.initTheme();
        I8.e.b(this, "From application", false);
        if(A8.b.d()) {
            MelonPrefs.getInstance().setString("domainPrefix", "");
        }
        LogU.debug$default(this.c, "initVolley()", null, false, 6, null);
        RequestQueue requestQueue0 = Volley.newRequestQueue(this.getApplicationContext(), new OkHttpStack());
        kotlin.jvm.internal.q.f(requestQueue0, "newRequestQueue(...)");
        this.setRequestQueue(requestQueue0);
        LogU.verbose$default(this.c, "initEnvironment", null, false, 6, null);
        Context context0 = this.getContext();
        kotlin.jvm.internal.q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        kotlin.jvm.internal.q.f(context1, "getApplicationContext(...)");
        Db.h.b = com.melon.log.data.a.a(context1);
        Db.e e0 = new Db.e(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        BuildersKt__Builders_commonKt.launch$default(Db.h.d, null, null, e0, 3, null);
        CharSequence charSequence0 = "";
        this.d = "AS40";
        this.e = Ob.b.b() ? "14LNC3" : "18LNM3";
        this.f = (float)ScreenUtils.dipToPixel(this.getContext(), 3.9f);
        String s = NetUtil.LOCALHOST4.getHostAddress();
        if(s == null) {
            s = "";
        }
        this.g = s;
        String s1 = Build.VERSION.RELEASE;
        String s2 = AppUtils.getVersionName(this.getContext());
        String s3 = Build.MODEL;
        String s4 = Y.l(A7.d.o("; ", this.d, "; Android ", s1, "; "), s2, "; ", s3);
        this.i = s4;
        kotlin.jvm.internal.q.g(s4, "<this>");
        int v = s4.length();
        int v1 = 0;
        while(v1 < v) {
            int v2 = s4.charAt(v1);
            int v3 = 0;
            while(true) {
                if(v3 < 1) {
                    if(v2 == new char[]{';'}[v3]) {
                        break;
                    }
                    else {
                        ++v3;
                        continue;
                    }
                }
                v3 = -1;
                break;
            }
            if(v3 < 0) {
                charSequence0 = s4.subSequence(v1, s4.length());
                break;
            }
            else {
                ++v1;
                continue;
            }
            goto label_73;
        }
        this.h = charSequence0.toString();
        LogU.debug$default(this.c, "initErrorReport()", null, false, 6, null);
        c c0 = c.a();
        boolean z = A8.b.d() || A8.b.a().equalsIgnoreCase("QA");
        G1.f f0 = c0.a.b;
        synchronized(f0) {
            f0.b = false;
            f0.g = Boolean.valueOf(z);
            SharedPreferences.Editor sharedPreferences$Editor0 = ((SharedPreferences)f0.c).edit();
            sharedPreferences$Editor0.putBoolean("firebase_crashlytics_collection_enabled", z);
            sharedPreferences$Editor0.apply();
            synchronized(f0.e) {
                if(!f0.f()) {
                    if(f0.a) {
                        f0.f = new TaskCompletionSource();
                        f0.a = false;
                    }
                }
                else if(!f0.a) {
                    ((TaskCompletionSource)f0.f).trySetResult(null);
                    f0.a = true;
                }
            }
        }
    label_73:
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new x(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        LogU.info$default(this.c, "initRemoteConfig()", null, false, 6, null);
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        kotlin.jvm.internal.q.g(coroutineScope0, "coroutineScope");
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new vc.b(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        vc.c.a();
        MelonSettingInfo.loadSettings(this);
        MelonServiceManager.INSTANCE.register(FloatingLyricService.class);
        if(A8.b.f()) {
            serverHosts0 = ServerHostsKt.withPhase(ServerHosts.Companion, KakaoPhase.SANDBOX);
        }
        else {
            serverHosts0 = A8.b.b().equalsIgnoreCase("CBT") ? ServerHostsKt.withPhase(ServerHosts.Companion, KakaoPhase.CBT) : ServerHostsKt.withPhase(ServerHosts.Companion, KakaoPhase.PRODUCTION);
        }
        Context context2 = this.getContext();
        kotlin.jvm.internal.q.f("5c2982b2ec377339ee67d3686f4813ac", "getString(...)");
        KakaoSdk.init$default(context2, "5c2982b2ec377339ee67d3686f4813ac", null, null, serverHosts0, null, null, 0x60, null);
        KakaoEmoticon.init(new y(new k8.z()));
        u9.f f1 = u9.f.g.b(this, "mcache");
        Ob.d d0 = Ob.b.a();
        Ob.c c1 = new Ob.c(f1.f, d0.a, false, false);
        LogU.info$default(Ob.b.b, "initialize() options: " + c1, null, false, 6, null);
        Ob.b.e(new Mc.q(c1, 9));
        MelonStreamCacheManager melonStreamCacheManager0 = MelonStreamCacheManager.getInstance();
        kotlin.jvm.internal.q.f(melonStreamCacheManager0, "getInstance(...)");
        melonStreamCacheManager0.setLogListener(new Ob.a());  // 初始化器: Ljava/lang/Object;-><init>()V
        AdIdManager.INSTANCE.init();
        try {
            p8.q.d = this.getPackageManager().getApplicationInfo("com.iloen.melon", 0x80);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            LogU.debug$default(p8.q.a, "initialize() - Err: " + packageManager$NameNotFoundException0, null, false, 6, null);
        }
        TiaraConfiguration tiaraConfiguration0 = new Builder().sessionTimeout(300).syncTiaraUserToWebview(true).cookieDomains(p8.q.c).build();
        kotlin.jvm.internal.q.f(tiaraConfiguration0, "build(...)");
        TiaraTracker.initialize(this, tiaraConfiguration0);
        p8.q.c();
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        AdIdManager.INSTANCE.getAdId(j0);
        p8.q.c().putGlobalCustomProperty("adtrack_service_origin", "melon");
        p8.o o0 = new p8.o(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        BuildersKt__Builders_commonKt.launch$default(p8.q.b, null, null, o0, 3, null);
        p p0 = new p(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        BuildersKt__Builders_commonKt.launch$default(p8.q.b, null, null, p0, 3, null);
        MelonAppBase.Companion.getClass();
        MelonAppBase melonAppBase0 = t.a();
        TreviAd.INSTANCE.register(melonAppBase0, "melon", "b5735429724aded3822eb664190ade79", (ServerPhase.isSandBox ? ServerConfig.QA : ServerConfig.PRODUCTION));
        String s5 = va.e.b("initIap() billingType:", BillingUtils.getBillingType());
        LogU.debug$default(this.c, s5, null, false, 6, null);
        if(kotlin.jvm.internal.q.b(BillingUtils.getBillingType(), "GOOGLE")) {
            R6.d d1 = d.f;
            d d2 = d.g;
            if(d2 == null) {
                synchronized(d1) {
                    d2 = d.g;
                    if(d2 == null) {
                        d2 = new d(this);
                        d.g = d2;
                    }
                }
            }
            this.j = d2;
        }
        else if(kotlin.jvm.internal.q.b(BillingUtils.getBillingType(), "ONE_STORE")) {
            R6.c c2 = g.i;
            g g0 = g.j;
            if(g0 == null) {
                synchronized(c2) {
                    g0 = g.j;
                    if(g0 == null) {
                        g0 = new g(this);
                        g.j = g0;
                    }
                }
            }
            this.k = g0;
        }
        LogU.debug$default(this.c, "initAirbridge()", null, false, 6, null);
        AirbridgeOptionBuilder airbridgeOptionBuilder0 = new AirbridgeOptionBuilder("", "6896f5c2f17e4de09e7daf5c5a78e668");
        airbridgeOptionBuilder0.setSDKSignature("9ef7bf9e-e866-4d6a-9ba1-9bda96cad17e", "4d8201289c34b65a8885081decceccb894ae32018541d6642b7c989171d3b135");
        airbridgeOptionBuilder0.setTrackMetaDeferredAppLinkEnabled(true);
        Airbridge.initializeSDK(this, airbridgeOptionBuilder0.build());
        kotlin.jvm.internal.q.f("", "getMemberKey(...)");
        Airbridge.setUserID("");
        pd.f f2 = (pd.f)this.B.getValue();
        f2.getClass();
        this.registerActivityLifecycleCallbacks(f2);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new pd.e(f2, null), 3, null);
        Ub.t t0 = (Ub.t)this.getRemoteManager();
        for(Object object1: t0.e) {
            ((Ub.r)object1).c(t0);
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new u(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new B(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        if(!MelonPrefs.getInstance().getBoolean("offlineMigration", false)) {
            new k9.k().start();  // 初始化器: Ljava/lang/Thread;-><init>()V
        }
        if(Td.b.e(this.getContext(), "android.permission.READ_MEDIA_AUDIO")) {
            Context context3 = this.getContext();
            u9.f.g.b(context3, "lyric").b();
        }
        Context context4 = this.getContext();
        NetworkStatusManager.INSTANCE.initialize(context4);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new D(this, null), 3, null);
        if(A8.b.f()) {
            FlipperManager.INSTANCE.initFlipper(this);
        }
    }

    @Override  // android.app.Application
    public void onLowMemory() {
        LogU.warn$default(this.c, "============== onLowMemory ===============", null, false, 6, null);
        super.onLowMemory();
        Glide.get(this).clearMemory();
        TemplateImageCacheManager.clear();
        System.gc();
    }

    @Override  // android.app.Application
    public void onTrimMemory(int v) {
        LogU.warn$default(this.c, "============= onTrimMemory() level:" + v, null, false, 6, null);
        Glide.get(this).trimMemory(v);
        TemplateImageCacheManager.clear();
        System.gc();
        super.onTrimMemory(v);
    }

    public final void setAndroidAutoConnected(boolean z) {
        this.w = z;
    }

    public final void setAppPip(boolean z) {
        this.l = z;
    }

    public final void setAppVisibilityManager(@NotNull i i0) {
        kotlin.jvm.internal.q.g(i0, "<set-?>");
        this.appVisibilityManager = i0;
    }

    public final void setAppWidgetUpdater(@NotNull V0 v00) {
        kotlin.jvm.internal.q.g(v00, "<set-?>");
        this.appWidgetUpdater = v00;
    }

    public final void setDeviceData(@NotNull DeviceData deviceData0) {
        kotlin.jvm.internal.q.g(deviceData0, "<set-?>");
        this.deviceData = deviceData0;
    }

    public final void setGoogleIapLifecycle(@Nullable d d0) {
        this.j = d0;
    }

    public final void setHostAddress(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "<set-?>");
        this.g = s;
    }

    public final void setLoanedAudioFocus(boolean z) {
        this.o = z;
    }

    public final void setMelonCpId(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "<set-?>");
        this.d = s;
    }

    public final void setMelonDatabase(@NotNull MelonDatabase melonDatabase0) {
        kotlin.jvm.internal.q.g(melonDatabase0, "<set-?>");
        this.melonDatabase = melonDatabase0;
    }

    public final void setMelonImageviewDefaultRadius(float f) {
        this.f = f;
    }

    public final void setMelonProtocolUserAgent(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "<set-?>");
        this.h = s;
    }

    public final void setMelonWebViewUserAgent(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "<set-?>");
        this.i = s;
    }

    public final void setMusicMessageCurrentInboxSeq(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "<set-?>");
        this.n = s;
    }

    public final void setMusicMsgFragmentVisualStatus(boolean z, boolean z1) {
        int v;
        if(z && z1) {
            v = 3;
        }
        else if(z) {
            v = 2;
        }
        else {
            v = z1 ? 1 : 0;
        }
        this.r = v;
    }

    public final void setOneStoreIapLifecycle(@Nullable g g0) {
        this.k = g0;
    }

    public final void setPlaybackManager(@NotNull q q0) {
        kotlin.jvm.internal.q.g(q0, "<set-?>");
        this.playbackManager = q0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        kotlin.jvm.internal.q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        kotlin.jvm.internal.q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }

    public final void setRemoteManager(@NotNull s s0) {
        kotlin.jvm.internal.q.g(s0, "<set-?>");
        this.remoteManager = s0;
    }

    public final void setRequestQueue(@NotNull RequestQueue requestQueue0) {
        kotlin.jvm.internal.q.g(requestQueue0, "<set-?>");
        this.requestQueue = requestQueue0;
    }

    public final void setVideoMiniPlayer(boolean z) {
        this.m = z;
    }

    public final void updateMelonCpKey(@NotNull String s) {
        kotlin.jvm.internal.q.g(s, "cpKey");
        this.e = s;
        LogU.debug$default(this.c, "updateMelonCpKey() cpKey:" + s, null, false, 6, null);
    }

    public static void updateMelonCpKey$default(MelonAppBase melonAppBase0, String s, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMelonCpKey");
        }
        if((v & 1) != 0) {
            melonAppBase0.getClass();
            s = Ob.b.b() ? "14LNC3" : "18LNM3";
        }
        melonAppBase0.updateMelonCpKey(s);
    }
}

