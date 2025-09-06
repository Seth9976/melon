package com.iloen.melon.utils.ui;

import H0.b;
import Ra.d;
import android.content.res.Configuration;
import android.text.TextUtils;
import androidx.compose.ui.platform.ComposeView;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.custom.l1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventNotificationScheme;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.iloen.melon.fragments.settings.SettingScreenFragment;
import com.iloen.melon.net.HttpResponse.Notification.Buttons;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.NotificationActionType;
import com.iloen.melon.net.v4x.common.NotificationActionTypeHelper;
import com.iloen.melon.net.v4x.request.MainBottomSlidePopupReq;
import com.iloen.melon.net.v4x.response.MainBottomSlidePopupRes.Response.Banner;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes.Response.NoticePopup.EXPIREDBANS;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes.Response.NoticePopup;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes.Response;
import com.iloen.melon.net.v4x.response.MainNoticePopupRes;
import com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.Alert;
import com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion;
import com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.REMOVEBANS;
import com.iloen.melon.net.v4x.response.NotificationLoginRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER.BANON;
import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER;
import com.iloen.melon.popup.H;
import com.iloen.melon.popup.MelonBasePopup;
import com.iloen.melon.popup.MelonMainPromotionPopup;
import com.iloen.melon.popup.MelonTMPPopup;
import com.iloen.melon.popup.MelonTextNCheckPopup;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.ContentList;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.data.database.entity.BannerPopupEntity;
import d3.g;
import d5.n;
import e1.u;
import e3.h;
import i.n.i.b.a.s.e.M3;
import ie.r;
import java.lang.ref.WeakReference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import k8.o;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ne.a;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p8.f;
import p8.i;
import va.e0;
import vd.G;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 /2\u00020\u0001:\u0003/01B)\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\r\u0010\u0010\u001A\u00020\r¢\u0006\u0004\b\u0010\u0010\u000FJ\r\u0010\u0011\u001A\u00020\r¢\u0006\u0004\b\u0011\u0010\u000FJ\r\u0010\u0012\u001A\u00020\r¢\u0006\u0004\b\u0012\u0010\u000FJ\r\u0010\u0013\u001A\u00020\r¢\u0006\u0004\b\u0013\u0010\u000FJ\u0015\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001A\u00020\r¢\u0006\u0004\b\u0018\u0010\u000FJ\r\u0010\u0019\u001A\u00020\r¢\u0006\u0004\b\u0019\u0010\u000FJ\u0015\u0010\u001A\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010\u001C\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\u001C\u0010\u001DJ\u0015\u0010\u001F\u001A\u00020\r2\u0006\u0010\u001E\u001A\u00020\u0004¢\u0006\u0004\b\u001F\u0010\u001BJ\u0017\u0010\"\u001A\u00020\r2\b\u0010!\u001A\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\r\u0010\"\u001A\u00020\r¢\u0006\u0004\b\"\u0010\u000FR\u001B\u0010)\u001A\u00020$8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(R\u001B\u0010.\u001A\u00020*8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001A\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper;", "", "Lcom/iloen/melon/MusicBrowserActivity;", "activity", "", "shouldShowMiniPlayer", "isLockByInfoPush", "", "lastTabIndex", "<init>", "(Lcom/iloen/melon/MusicBrowserActivity;ZZI)V", "getActivity", "()Lcom/iloen/melon/MusicBrowserActivity;", "Lie/H;", "onCreate", "()V", "onStop", "onDestroy", "onResume", "onPause", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onEventLogin", "onEventShowMainPopups", "setShouldShowMiniPlayer", "(Z)V", "setLastTabIndexIndex", "(I)V", "isLock", "setLock", "Lcom/iloen/melon/net/v4x/response/NotificationLoginRes;", "notificationLoginRes", "showLoginPopup", "(Lcom/iloen/melon/net/v4x/response/NotificationLoginRes;)V", "Lmb/k;", "o", "Lie/j;", "getLoginUseCase", "()Lmb/k;", "loginUseCase", "Lmb/o;", "p", "getSimpleAccountUseCase", "()Lmb/o;", "simpleAccountUseCase", "Companion", "FloatingPopupInfo", "CurrentBottomTabInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicBrowserPopupHelper {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper$Companion;", "", "", "TAG", "Ljava/lang/String;", "TIARA_DEFAULT_ORD_NUM", "FLOATING_TYPE_BASIC", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u000B\b\u0082\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u001A\u0004\b\u001A\u0010\b\"\u0004\b\u001B\u0010\u0018¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper$CurrentBottomTabInfo;", "", "", "page", "menuId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper$CurrentBottomTabInfo;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getPage", "setPage", "(Ljava/lang/String;)V", "b", "getMenuId", "setMenuId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class CurrentBottomTabInfo {
        public String a;
        public String b;

        public CurrentBottomTabInfo() {
            this(null, null, 3, null);
        }

        public CurrentBottomTabInfo(@NotNull String s, @NotNull String s1) {
            q.g(s, "page");
            q.g(s1, "menuId");
            super();
            this.a = s;
            this.b = s1;
        }

        public CurrentBottomTabInfo(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            this(s, s1);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final CurrentBottomTabInfo copy(@NotNull String s, @NotNull String s1) {
            q.g(s, "page");
            q.g(s1, "menuId");
            return new CurrentBottomTabInfo(s, s1);
        }

        public static CurrentBottomTabInfo copy$default(CurrentBottomTabInfo musicBrowserPopupHelper$CurrentBottomTabInfo0, String s, String s1, int v, Object object0) {
            if((v & 1) != 0) {
                s = musicBrowserPopupHelper$CurrentBottomTabInfo0.a;
            }
            if((v & 2) != 0) {
                s1 = musicBrowserPopupHelper$CurrentBottomTabInfo0.b;
            }
            return musicBrowserPopupHelper$CurrentBottomTabInfo0.copy(s, s1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof CurrentBottomTabInfo)) {
                return false;
            }
            return q.b(this.a, ((CurrentBottomTabInfo)object0).a) ? q.b(this.b, ((CurrentBottomTabInfo)object0).b) : false;
        }

        @NotNull
        public final String getMenuId() [...] // 潜在的解密器

        @NotNull
        public final String getPage() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.b.hashCode() + this.a.hashCode() * 0x1F;
        }

        public final void setMenuId(@NotNull String s) {
            q.g(s, "<set-?>");
            this.b = s;
        }

        public final void setPage(@NotNull String s) {
            q.g(s, "<set-?>");
            this.a = s;
        }

        @Override
        @NotNull
        public String toString() {
            return "CurrentBottomTabInfo(page=" + this.a + ", menuId=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001C\u0010\b\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper$FloatingPopupInfo;", "", "Lp8/f;", "floatingPopupLogBuilder", "<init>", "(Lp8/f;)V", "component1", "()Lp8/f;", "copy", "(Lp8/f;)Lcom/iloen/melon/utils/ui/MusicBrowserPopupHelper$FloatingPopupInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lp8/f;", "getFloatingPopupLogBuilder", "setFloatingPopupLogBuilder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class FloatingPopupInfo {
        public static final int $stable = 8;
        public f a;

        public FloatingPopupInfo() {
            this(null, 1, null);
        }

        public FloatingPopupInfo(@Nullable f f0) {
            this.a = f0;
        }

        public FloatingPopupInfo(f f0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                f0 = null;
            }
            this(f0);
        }

        @Nullable
        public final f component1() {
            return this.a;
        }

        @NotNull
        public final FloatingPopupInfo copy(@Nullable f f0) {
            return new FloatingPopupInfo(f0);
        }

        public static FloatingPopupInfo copy$default(FloatingPopupInfo musicBrowserPopupHelper$FloatingPopupInfo0, f f0, int v, Object object0) {
            if((v & 1) != 0) {
                f0 = musicBrowserPopupHelper$FloatingPopupInfo0.a;
            }
            return musicBrowserPopupHelper$FloatingPopupInfo0.copy(f0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof FloatingPopupInfo ? q.b(this.a, ((FloatingPopupInfo)object0).a) : false;
        }

        @Nullable
        public final f getFloatingPopupLogBuilder() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a == null ? 0 : this.a.hashCode();
        }

        public final void setFloatingPopupLogBuilder(@Nullable f f0) {
            this.a = f0;
        }

        @Override
        @NotNull
        public String toString() {
            return "FloatingPopupInfo(floatingPopupLogBuilder=" + this.a + ")";
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public boolean a;
    public boolean b;
    public int c;
    public final WeakReference d;
    public MelonMainPromotionPopup e;
    public MelonBasePopup f;
    public Banner g;
    public MelonTextPopup h;
    public MelonBasePopup i;
    public ComposeView j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final MutableStateFlow n;
    public final r o;
    public final r p;
    public final r q;
    public final r r;

    static {
        MusicBrowserPopupHelper.Companion = new Companion(null);
        MusicBrowserPopupHelper.$stable = 8;
    }

    public MusicBrowserPopupHelper(@Nullable MusicBrowserActivity musicBrowserActivity0, boolean z, boolean z1, int v) {
        this.a = z;
        this.b = z1;
        this.c = v;
        this.d = new WeakReference(musicBrowserActivity0);
        this.n = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.o = g.Q(new H(11));
        this.p = g.Q(new H(12));
        this.q = g.Q(new H(13));
        this.r = g.Q(new H(14));
        this.onCreate();
    }

    public final void a() {
        boolean z = this.b;
        StringBuilder stringBuilder0 = Y.q("clearAllPopup() isSyncPopup:", ", shouldShowMiniPlayer:", this.k, ", isLockByInfoPush:", this.a);
        stringBuilder0.append(z);
        LogU.Companion.d("MusicBrowserPopupHelper", stringBuilder0.toString());
        MelonMainPromotionPopup melonMainPromotionPopup0 = this.e;
        if(melonMainPromotionPopup0 != null) {
            if(melonMainPromotionPopup0.isShowing()) {
                melonMainPromotionPopup0.dismiss();
            }
            this.e = null;
        }
        MelonBasePopup melonBasePopup0 = this.f;
        if(melonBasePopup0 != null) {
            if(melonBasePopup0.isShowing()) {
                melonBasePopup0.dismiss();
            }
            this.f = null;
        }
        this.c();
        this.l(false, true);
    }

    public static final void access$bannerViewableLog(MusicBrowserPopupHelper musicBrowserPopupHelper0, BANNER floatingBannerRes$RESPONSE$BANNER0) {
        musicBrowserPopupHelper0.f();
        Builder viewImpContent$Builder0 = new Builder();
        StatsElementsBase statsElementsBase0 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
        String s = statsElementsBase0 == null ? null : statsElementsBase0.impressionProvider;
        String s1 = "";
        if(s == null) {
            s = "";
        }
        Builder viewImpContent$Builder1 = viewImpContent$Builder0.impProvider(s);
        String s2 = musicBrowserPopupHelper0.getActivity() == null ? null : "vimp";
        if(s2 == null) {
            s2 = "";
        }
        Builder viewImpContent$Builder2 = viewImpContent$Builder1.impType(s2);
        StatsElementsBase statsElementsBase1 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
        String s3 = statsElementsBase1 == null ? null : statsElementsBase1.rangeCode;
        if(s3 == null) {
            s3 = "";
        }
        Builder viewImpContent$Builder3 = viewImpContent$Builder2.impArea(s3).impOrdNum("1");
        String s4 = musicBrowserPopupHelper0.getActivity() == null ? null : "플로팅배너";
        if(s4 == null) {
            s4 = "";
        }
        ViewImpContent viewImpContent0 = viewImpContent$Builder3.layer1(s4).build();
        q.f(viewImpContent0, "build(...)");
        ContentList contentList0 = new ContentList();
        contentList0.addContent(viewImpContent0);
        i i0 = new i();  // 初始化器: Lp8/f;-><init>()V
        if(musicBrowserPopupHelper0.getActivity() != null) {
            s1 = "멜론홈탭";
        }
        i0.b = s1;
        i0.c = "";
        i0.I = "";
        i0.Q = "slot_personal";
        i0.N = "0647dcc15b20c4f83f";
        i0.M = "toros_melon_slot_personal_base";
        i0.O = "app_user_id";
        i0.Z = contentList0;
        i0.a().track();
    }

    public static final void access$dismissLayerPopup(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        MelonMainPromotionPopup melonMainPromotionPopup0 = musicBrowserPopupHelper0.e;
        if(melonMainPromotionPopup0 != null) {
            if(melonMainPromotionPopup0.isShowing()) {
                melonMainPromotionPopup0.dismiss();
            }
            musicBrowserPopupHelper0.e = null;
        }
    }

    public static final void access$dismissNoticePopup(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        MelonBasePopup melonBasePopup0 = musicBrowserPopupHelper0.f;
        if(melonBasePopup0 != null) {
            if(melonBasePopup0.isShowing()) {
                melonBasePopup0.dismiss();
            }
            musicBrowserPopupHelper0.f = null;
        }
    }

    public static final Object access$getBannedJson(MusicBrowserPopupHelper musicBrowserPopupHelper0, String s, String s1, Continuation continuation0) {
        ArrayList arrayList1;
        MusicBrowserPopupHelper.getBannedJson.1 musicBrowserPopupHelper$getBannedJson$10;
        musicBrowserPopupHelper0.getClass();
        if(continuation0 instanceof MusicBrowserPopupHelper.getBannedJson.1) {
            musicBrowserPopupHelper$getBannedJson$10 = (MusicBrowserPopupHelper.getBannedJson.1)continuation0;
            int v = musicBrowserPopupHelper$getBannedJson$10.D;
            if((v & 0x80000000) == 0) {
                musicBrowserPopupHelper$getBannedJson$10 = new MusicBrowserPopupHelper.getBannedJson.1(musicBrowserPopupHelper0, continuation0);
            }
            else {
                musicBrowserPopupHelper$getBannedJson$10.D = v ^ 0x80000000;
            }
        }
        else {
            musicBrowserPopupHelper$getBannedJson$10 = new MusicBrowserPopupHelper.getBannedJson.1(musicBrowserPopupHelper0, continuation0);
        }
        Object object0 = musicBrowserPopupHelper$getBannedJson$10.w;
        a a0 = a.a;
        switch(musicBrowserPopupHelper$getBannedJson$10.D) {
            case 0: {
                ArrayList arrayList0 = b.m(object0);
                MusicBrowserPopupHelper.getBannedJson.2 musicBrowserPopupHelper$getBannedJson$20 = new MusicBrowserPopupHelper.getBannedJson.2(musicBrowserPopupHelper0, s, s1, arrayList0, null);
                musicBrowserPopupHelper$getBannedJson$10.r = arrayList0;
                musicBrowserPopupHelper$getBannedJson$10.D = 1;
                if(BuildersKt.withContext(Dispatchers.getIO(), musicBrowserPopupHelper$getBannedJson$20, musicBrowserPopupHelper$getBannedJson$10) == a0) {
                    return a0;
                }
                arrayList1 = arrayList0;
                break;
            }
            case 1: {
                arrayList1 = musicBrowserPopupHelper$getBannedJson$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return arrayList1.size() > 0 ? arrayList1.toString() : null;
    }

    public static final d access$getBannerPopupUseCase(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        return (d)musicBrowserPopupHelper0.q.getValue();
    }

    public static final ComposeView access$getFloatingPopupLayout$p(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        return musicBrowserPopupHelper0.j;
    }

    public static final StateFlow access$getLoginPopUpStateFlow(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        return FlowKt.asStateFlow(musicBrowserPopupHelper0.n);
    }

    public static final void access$handleSimpleLogin(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        musicBrowserPopupHelper0.getClass();
        String s = ((o)(((Ma.g)Y.f(MelonAppBase.Companion, Ma.g.class)))).m().b();
        if(s != null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new MusicBrowserPopupHelper.handleSimpleLogin.1.1(s, null), 3, null);
        }
        musicBrowserPopupHelper0.b(null);
    }

    public static final Object access$isSimpleLoginBannerAvailable(MusicBrowserPopupHelper musicBrowserPopupHelper0, Continuation continuation0) {
        MusicBrowserPopupHelper.isSimpleLoginBannerAvailable.1 musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10;
        musicBrowserPopupHelper0.getClass();
        if(continuation0 instanceof MusicBrowserPopupHelper.isSimpleLoginBannerAvailable.1) {
            musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10 = (MusicBrowserPopupHelper.isSimpleLoginBannerAvailable.1)continuation0;
            int v = musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10.D;
            if((v & 0x80000000) == 0) {
                musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10 = new MusicBrowserPopupHelper.isSimpleLoginBannerAvailable.1(musicBrowserPopupHelper0, continuation0);
            }
            else {
                musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10.D = v ^ 0x80000000;
            }
        }
        else {
            musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10 = new MusicBrowserPopupHelper.isSimpleLoginBannerAvailable.1(musicBrowserPopupHelper0, continuation0);
        }
        Object object0 = musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10.w;
        a a0 = a.a;
        boolean z = false;
        switch(musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10.D) {
            case 0: {
                n.D(object0);
                try {
                    int v1 = ((e0)musicBrowserPopupHelper0.getLoginUseCase()).m() || !musicBrowserPopupHelper0.getSimpleAccountUseCase().d() ? 0 : 1;
                    d d0 = (d)musicBrowserPopupHelper0.q.getValue();
                    musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10.r = v1;
                    musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10.D = 1;
                    Object object1 = d0.b("0", "FLOATING_SIMPLE_LOGIN", musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10);
                    if(object1 == a0) {
                        return a0;
                    }
                    object0 = object1;
                    int v2 = v1;
                    goto label_28;
                label_26:
                    v2 = musicBrowserPopupHelper$isSimpleLoginBannerAvailable$10.r;
                    n.D(object0);
                label_28:
                    if(((List)object0).isEmpty()) {
                        if(v2 != 0) {
                            z = true;
                        }
                        return Boolean.valueOf(z);
                    }
                    if(LocalDate.parse(new JSONObject("").getString("expiration"), DateTimeFormatter.BASIC_ISO_DATE).isBefore(LocalDate.now()) && v2 != 0) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
                catch(Exception unused_ex) {
                    break;
                }
            }
            case 1: {
                goto label_26;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return false;
    }

    public static final void access$loginViewableLog(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        musicBrowserPopupHelper0.f();
        Builder viewImpContent$Builder0 = new Builder();
        String s = musicBrowserPopupHelper0.getActivity() == null ? null : "vimp";
        String s1 = "";
        if(s == null) {
            s = "";
        }
        Builder viewImpContent$Builder1 = viewImpContent$Builder0.impType(s).impArea("");
        String s2 = musicBrowserPopupHelper0.getActivity() == null ? null : "로그인플로팅배너";
        if(s2 == null) {
            s2 = "";
        }
        ViewImpContent viewImpContent0 = viewImpContent$Builder1.layer1(s2).build();
        q.f(viewImpContent0, "build(...)");
        ContentList contentList0 = new ContentList();
        contentList0.addContent(viewImpContent0);
        i i0 = new i();  // 初始化器: Lp8/f;-><init>()V
        if(musicBrowserPopupHelper0.getActivity() != null) {
            s1 = "멜론홈탭";
        }
        i0.b = s1;
        i0.c = "";
        i0.I = "";
        i0.Q = "slot_personal";
        i0.N = "0647dcc15b20c4f83f";
        i0.M = "toros_melon_slot_personal_base";
        i0.O = "app_user_id";
        i0.Z = contentList0;
        i0.a().track();
    }

    public static final void access$setFloatingPopupLayout$p(MusicBrowserPopupHelper musicBrowserPopupHelper0, ComposeView composeView0) {
        musicBrowserPopupHelper0.j = composeView0;
    }

    public static final void access$setLayerPopup$p(MusicBrowserPopupHelper musicBrowserPopupHelper0, MelonMainPromotionPopup melonMainPromotionPopup0) {
        musicBrowserPopupHelper0.e = melonMainPromotionPopup0;
    }

    public static final void access$showBottomPopupOrLayerPopup(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        musicBrowserPopupHelper0.n.setValue(Boolean.TRUE);
        RequestBuilder.newInstance(new MainBottomSlidePopupReq(musicBrowserPopupHelper0.getActivity())).tag("MusicBrowserPopupHelper").listener(new k(musicBrowserPopupHelper0, 1)).errorListener(new k(musicBrowserPopupHelper0, 2)).request();
    }

    public static final void access$showMixUpMalrangGuidePopup(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        musicBrowserPopupHelper0.getClass();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MusicBrowserPopupHelper.showMixUpMalrangGuidePopup.1(musicBrowserPopupHelper0, null), 3, null);
    }

    public static final Object access$showNoticePopup(MusicBrowserPopupHelper musicBrowserPopupHelper0, MainNoticePopupRes mainNoticePopupRes0, Continuation continuation0) {
        ArrayList arrayList1;
        NoticePopup mainNoticePopupRes$Response$NoticePopup0;
        MusicBrowserPopupHelper.showNoticePopup.1 musicBrowserPopupHelper$showNoticePopup$10;
        musicBrowserPopupHelper0.getClass();
        if(continuation0 instanceof MusicBrowserPopupHelper.showNoticePopup.1) {
            musicBrowserPopupHelper$showNoticePopup$10 = (MusicBrowserPopupHelper.showNoticePopup.1)continuation0;
            int v = musicBrowserPopupHelper$showNoticePopup$10.B;
            if((v & 0x80000000) == 0) {
                musicBrowserPopupHelper$showNoticePopup$10 = new MusicBrowserPopupHelper.showNoticePopup.1(musicBrowserPopupHelper0, continuation0);
            }
            else {
                musicBrowserPopupHelper$showNoticePopup$10.B = v ^ 0x80000000;
            }
        }
        else {
            musicBrowserPopupHelper$showNoticePopup$10 = new MusicBrowserPopupHelper.showNoticePopup.1(musicBrowserPopupHelper0, continuation0);
        }
        Object object0 = musicBrowserPopupHelper$showNoticePopup$10.r;
        a a0 = a.a;
        switch(musicBrowserPopupHelper$showNoticePopup$10.B) {
            case 0: {
                n.D(object0);
                com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                logU$Companion0.d("MusicBrowserPopupHelper", "showNoticePopup");
                if(mainNoticePopupRes0 == null) {
                    mainNoticePopupRes$Response$NoticePopup0 = null;
                }
                else {
                    Response mainNoticePopupRes$Response0 = mainNoticePopupRes0.response;
                    mainNoticePopupRes$Response$NoticePopup0 = mainNoticePopupRes$Response0 == null ? null : mainNoticePopupRes$Response0.noticePopup;
                }
                if(musicBrowserPopupHelper0.getActivity() == null || mainNoticePopupRes$Response$NoticePopup0 == null) {
                    logU$Companion0.d("MusicBrowserPopupHelper", "showNoticePopup getActivity() == null || noticePopupRes == null");
                    return false;
                }
                String s = mainNoticePopupRes$Response$NoticePopup0.content;
                if(s == null) {
                    LogU.Companion.d("MusicBrowserPopupHelper", "showNoticePopup noticePopupRes.content == null || noticePopupRes.content.trim { it <= \' \' }.isEmpty()");
                    return false;
                }
                int v1 = s.length() - 1;
                int v2 = 0;
                boolean z = false;
                while(v2 <= v1) {
                    boolean z1 = q.h(s.charAt((z ? v1 : v2)), 0x20) <= 0;
                    if(z) {
                        if(!z1) {
                            break;
                        }
                        --v1;
                    }
                    else if(z1) {
                        ++v2;
                    }
                    else {
                        z = true;
                    }
                }
                if(s.subSequence(v2, v1 + 1).toString().length() == 0) {
                    LogU.Companion.d("MusicBrowserPopupHelper", "showNoticePopup noticePopupRes.content == null || noticePopupRes.content.trim { it <= \' \' }.isEmpty()");
                    return false;
                }
                ArrayList arrayList0 = mainNoticePopupRes$Response$NoticePopup0.expiredBans;
                if(arrayList0 == null) {
                    arrayList1 = null;
                }
                else {
                    arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                    for(Object object1: arrayList0) {
                        arrayList1.add(((EXPIREDBANS)object1).id);
                    }
                }
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(musicBrowserPopupHelper0.g(), null, null, new MusicBrowserPopupHelper.showNoticePopup.result.1(arrayList1, musicBrowserPopupHelper0, mainNoticePopupRes$Response$NoticePopup0, null), 3, null);
                musicBrowserPopupHelper$showNoticePopup$10.B = 1;
                object0 = deferred0.await(musicBrowserPopupHelper$showNoticePopup$10);
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
        l1.B("showNoticePopup() result : ", ((Boolean)object0).booleanValue(), LogU.Companion, "MusicBrowserPopupHelper");
        return (Boolean)object0;
    }

    public static final void access$showNoticePopupOnlyCloseButton(MusicBrowserPopupHelper musicBrowserPopupHelper0, NoticePopup mainNoticePopupRes$Response$NoticePopup0) {
        musicBrowserPopupHelper0.getClass();
        LogU.Companion.d("MusicBrowserPopupHelper", "showNoticePopupOnlyCloseButton()");
        MelonTextPopup melonTextPopup0 = new MelonTextPopup(musicBrowserPopupHelper0.getActivity(), 1);
        melonTextPopup0.setTitleName((musicBrowserPopupHelper0.getActivity() == null ? null : "안내"));
        melonTextPopup0.setBodyMsg(mainNoticePopupRes$Response$NoticePopup0.content);
        melonTextPopup0.setPopupOnClickListener(new Xb.a(3));
        melonTextPopup0.show();
        musicBrowserPopupHelper0.f = melonTextPopup0;
    }

    public static final void access$showNoticePopupWithOption(MusicBrowserPopupHelper musicBrowserPopupHelper0, NoticePopup mainNoticePopupRes$Response$NoticePopup0) {
        musicBrowserPopupHelper0.getClass();
        LogU.Companion.d("MusicBrowserPopupHelper", "showNoticePopupWithOption()");
        MelonTextNCheckPopup melonTextNCheckPopup0 = new MelonTextNCheckPopup(musicBrowserPopupHelper0.getActivity(), 0x7F0D0138);  // layout:check_popup_layout
        melonTextNCheckPopup0.setTitleName((musicBrowserPopupHelper0.getActivity() == null ? null : "안내"));
        melonTextNCheckPopup0.setBodyMsg(mainNoticePopupRes$Response$NoticePopup0.content);
        melonTextNCheckPopup0.setCheckMsg(mainNoticePopupRes$Response$NoticePopup0.dpTitle);
        melonTextNCheckPopup0.setPopupOnClickListener(new com.iloen.melon.utils.ui.a(musicBrowserPopupHelper0, mainNoticePopupRes$Response$NoticePopup0));
        melonTextNCheckPopup0.show();
        musicBrowserPopupHelper0.f = melonTextNCheckPopup0;
    }

    public static final void access$trackFloatingBannerCloseClick(MusicBrowserPopupHelper musicBrowserPopupHelper0, BANNER floatingBannerRes$RESPONSE$BANNER0) {
        musicBrowserPopupHelper0.f();
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        String s = null;
        String s1 = musicBrowserPopupHelper0.getActivity() == null ? null : "닫기";
        String s2 = "";
        if(s1 == null) {
            s1 = "";
        }
        g0.a = s1;
        g0.d = ActionKind.ClickContent;
        String s3 = musicBrowserPopupHelper0.getActivity() == null ? null : "멜론홈탭";
        if(s3 == null) {
            s3 = "";
        }
        g0.b = s3;
        g0.c = "";
        String s4 = musicBrowserPopupHelper0.getActivity() == null ? null : "플로팅배너";
        if(s4 == null) {
            s4 = "";
        }
        g0.y = s4;
        String s5 = musicBrowserPopupHelper0.getActivity() == null ? null : "닫기";
        if(s5 == null) {
            s5 = "";
        }
        g0.F = s5;
        StatsElementsBase statsElementsBase0 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
        String s6 = statsElementsBase0 == null ? null : statsElementsBase0.impressionProvider;
        if(s6 == null) {
            s6 = "";
        }
        g0.H = s6;
        g0.e = floatingBannerRes$RESPONSE$BANNER0.getBannerSeq() == null ? "" : floatingBannerRes$RESPONSE$BANNER0.getBannerSeq();
        String s7 = musicBrowserPopupHelper0.getActivity() == null ? null : "배너";
        if(s7 == null) {
            s7 = "";
        }
        g0.f = s7;
        g0.g = " ";
        g0.j = "melon_admin";
        g0.I = "";
        StatsElementsBase statsElementsBase1 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
        if(statsElementsBase1 != null) {
            s = statsElementsBase1.rangeCode;
        }
        if(s == null) {
            s = "";
        }
        g0.J = s;
        g0.K = floatingBannerRes$RESPONSE$BANNER0.getTargetId() == null ? "" : floatingBannerRes$RESPONSE$BANNER0.getTargetId();
        String s8 = floatingBannerRes$RESPONSE$BANNER0.getBannerSeq();
        if(s8 != null) {
            s2 = s8;
        }
        g0.R = s2;
        g0.a().track();
    }

    public static final void access$trackFloatingBannerItemClick(MusicBrowserPopupHelper musicBrowserPopupHelper0, BANNER floatingBannerRes$RESPONSE$BANNER0) {
        String s5;
        musicBrowserPopupHelper0.f();
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        String s = null;
        String s1 = musicBrowserPopupHelper0.getActivity() == null ? null : "페이지이동";
        String s2 = "";
        if(s1 == null) {
            s1 = "";
        }
        String s3 = "멜론홈탭";
        g0.a = s1;
        g0.d = ActionKind.ClickContent;
        if(musicBrowserPopupHelper0.getActivity() == null) {
            s3 = "";
        }
        g0.b = s3;
        g0.c = "";
        String s4 = musicBrowserPopupHelper0.getActivity() == null ? null : "플로팅배너";
        if(s4 == null) {
            s4 = "";
        }
        g0.y = s4;
        if(TextUtils.isEmpty(floatingBannerRes$RESPONSE$BANNER0.linkurl)) {
            s5 = floatingBannerRes$RESPONSE$BANNER0.scheme;
            if(s5 == null) {
                s5 = "";
            }
        }
        else {
            s5 = floatingBannerRes$RESPONSE$BANNER0.linkurl;
        }
        g0.B = s5;
        String s6 = floatingBannerRes$RESPONSE$BANNER0.getImgUrl();
        if(s6 == null) {
            s6 = "";
        }
        g0.E = s6;
        StatsElementsBase statsElementsBase0 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
        String s7 = statsElementsBase0 == null ? null : statsElementsBase0.impressionProvider;
        if(s7 == null) {
            s7 = "";
        }
        g0.H = s7;
        g0.e = floatingBannerRes$RESPONSE$BANNER0.getBannerSeq() == null ? "" : floatingBannerRes$RESPONSE$BANNER0.getBannerSeq();
        String s8 = musicBrowserPopupHelper0.getActivity() == null ? null : "배너";
        if(s8 == null) {
            s8 = "";
        }
        g0.f = s8;
        g0.g = " ";
        g0.j = "melon_admin";
        g0.I = "";
        StatsElementsBase statsElementsBase1 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
        if(statsElementsBase1 != null) {
            s = statsElementsBase1.rangeCode;
        }
        if(s == null) {
            s = "";
        }
        g0.J = s;
        g0.K = floatingBannerRes$RESPONSE$BANNER0.getTargetId() == null ? "" : floatingBannerRes$RESPONSE$BANNER0.getTargetId();
        String s9 = floatingBannerRes$RESPONSE$BANNER0.getBannerSeq();
        if(s9 != null) {
            s2 = s9;
        }
        g0.R = s2;
        g0.a().track();
    }

    public final void b(BANNER floatingBannerRes$RESPONSE$BANNER0) {
        this.l(false, true);
        String s = floatingBannerRes$RESPONSE$BANNER0 == null ? null : floatingBannerRes$RESPONSE$BANNER0.getBannerSeq();
        if(s == null) {
            s = "";
        }
        BANON floatingBannerRes$RESPONSE$BANNER$BANON0 = floatingBannerRes$RESPONSE$BANNER0 == null ? null : floatingBannerRes$RESPONSE$BANNER0.getBanOn();
        if(floatingBannerRes$RESPONSE$BANNER$BANON0 != null) {
            String s1 = floatingBannerRes$RESPONSE$BANNER$BANON0.getSeq();
            if(s1 != null && s1.length() > 0) {
                BuildersKt__Builders_commonKt.launch$default(this.g(), null, null, new MusicBrowserPopupHelper.closeFloatingBannerPopup.1(this, s, floatingBannerRes$RESPONSE$BANNER$BANON0, null), 3, null);
            }
        }
    }

    public final void c() {
        MelonBasePopup melonBasePopup0 = this.i;
        if(melonBasePopup0 != null) {
            if(melonBasePopup0.isShowing()) {
                melonBasePopup0.dismiss();
            }
            this.i = null;
        }
        MelonTextPopup melonTextPopup0 = this.h;
        if(melonTextPopup0 != null) {
            if(melonTextPopup0.isShowing()) {
                melonTextPopup0.dismiss();
            }
            this.h = null;
        }
        this.m = false;
    }

    public static void d(String s) {
        if(s != null && s.length() != 0) {
            EventNotificationScheme eventNotificationScheme0 = new EventNotificationScheme();
            eventNotificationScheme0.scheme = s;
            EventBusHelper.post(eventNotificationScheme0);
        }
    }

    public final void e() {
        LogU.Companion.d("MusicBrowserPopupHelper", "fetchAndShowLayerPopup()");
        MusicBrowserActivity musicBrowserActivity0 = this.getActivity();
        if(musicBrowserActivity0 != null && Td.b.d(musicBrowserActivity0)) {
            BuildersKt__Builders_commonKt.launch$default(this.g(), null, null, new MusicBrowserPopupHelper.fetchAndShowLayerPopup.1(this, musicBrowserActivity0, null), 3, null);
        }
    }

    public final CurrentBottomTabInfo f() {
        String s = "";
        switch(this.c) {
            case 0: {
                if(this.getActivity() != null) {
                    s = "멜론홈탭_뮤직";
                }
                return new CurrentBottomTabInfo(s, "1000002436");
            }
            case 1: {
                if(this.getActivity() != null) {
                    s = "멜론홈탭_스테이션";
                }
                return new CurrentBottomTabInfo(s, "1000002394");
            }
            case 2: {
                if(this.getActivity() != null) {
                    s = "멜론홈탭_탐색";
                }
                return new CurrentBottomTabInfo(s, "1000002471");
            }
            case 3: {
                if(this.getActivity() != null) {
                    s = "멜론홈탭_보관함";
                }
                return new CurrentBottomTabInfo(s, "1000002392");
            }
            case 4: {
                if(this.getActivity() != null) {
                    s = "멜론홈탭_바로가기";
                }
                return new CurrentBottomTabInfo(s, "1000003080");
            }
            default: {
                return new CurrentBottomTabInfo("", "");
            }
        }
    }

    public final CoroutineScope g() {
        return (CoroutineScope)this.r.getValue();
    }

    @Nullable
    public final MusicBrowserActivity getActivity() {
        return this.d == null ? null : ((MusicBrowserActivity)this.d.get());
    }

    @NotNull
    public final mb.k getLoginUseCase() {
        return (mb.k)this.o.getValue();
    }

    @NotNull
    public final mb.o getSimpleAccountUseCase() {
        return (mb.o)this.p.getValue();
    }

    public final void h(Notification httpResponse$Notification0, NotificationActionType notificationActionType0) {
        if(httpResponse$Notification0 == null) {
            LogU.Companion.d("MusicBrowserPopupHelper", "performActionType() invalid notification");
            return;
        }
        if(NotificationActionTypeHelper.isViewTypePopup(notificationActionType0)) {
            if(this.getActivity() != null && this.l && !this.b) {
                ArrayList arrayList0 = httpResponse$Notification0.buttons;
                String s = httpResponse$Notification0.message;
                Buttons httpResponse$Notification$Buttons0 = HttpResponse.Companion.getNotificationButton(arrayList0, 0);
                Buttons httpResponse$Notification$Buttons1 = HttpResponse.Companion.getNotificationButton(arrayList0, 1);
                String s1 = null;
                String s2 = httpResponse$Notification$Buttons0 == null ? null : httpResponse$Notification$Buttons0.label;
                if(httpResponse$Notification$Buttons1 != null) {
                    s1 = httpResponse$Notification$Buttons1.label;
                }
                int v = httpResponse$Notification$Buttons0 == null || httpResponse$Notification$Buttons1 == null ? 1 : 2;
                String s3 = "안내";
                MelonTextPopup melonTextPopup0 = new MelonTextPopup(this.getActivity(), v);
                melonTextPopup0.setCancelable(false);
                if(this.getActivity() == null) {
                    s3 = "";
                }
                melonTextPopup0.setTitleName(s3);
                melonTextPopup0.setBodyMsg(s);
                if(TextUtils.isEmpty(s2)) {
                    MusicBrowserActivity musicBrowserActivity0 = this.getActivity();
                    if(musicBrowserActivity0 != null) {
                        musicBrowserActivity0.getString(0x7F130227);  // string:confirm "확인"
                    }
                }
                TextUtils.isEmpty(s1);
                melonTextPopup0.setIsFromNotification(true);
                melonTextPopup0.setPopupOnClickListener(new com.iloen.melon.utils.ui.b(v, httpResponse$Notification$Buttons0, this, httpResponse$Notification$Buttons1, melonTextPopup0));
                melonTextPopup0.show();
                this.h = melonTextPopup0;
            }
            return;
        }
        if(NotificationActionTypeHelper.isViewTypeToast(notificationActionType0)) {
            ToastManager.show(httpResponse$Notification0.message);
            return;
        }
        LogU.Companion.d("MusicBrowserPopupHelper", "performActionType() actionType ignored - " + notificationActionType0);
    }

    public final void i() {
        if(this.k && !(MelonFragmentManager.getInstance().getCurrentFragment() instanceof SettingScreenFragment)) {
            if(this.getActivity() != null && !this.b) {
                BuildersKt__Builders_commonKt.launch$default(this.g(), null, null, new MusicBrowserPopupHelper.showPopupWithPriority.1(this, null), 3, null);
            }
            if(this.getActivity() != null) {
                BuildersKt__Builders_commonKt.launch$default(this.g(), null, null, new MusicBrowserPopupHelper.fetchAndShowFloatingBannerPopup.1(this, null), 3, null);
            }
        }
    }

    public final void j(BANNER floatingBannerRes$RESPONSE$BANNER0) {
        this.f();
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        String s = null;
        String s1 = this.getActivity() == null ? null : "페이지이동";
        String s2 = "";
        if(s1 == null) {
            s1 = "";
        }
        g0.a = s1;
        g0.d = ActionKind.ClickContent;
        String s3 = this.getActivity() == null ? null : "멜론홈탭";
        if(s3 == null) {
            s3 = "";
        }
        g0.b = s3;
        g0.c = "";
        String s4 = this.getActivity() == null ? null : "로그인플로팅배너";
        if(s4 == null) {
            s4 = "";
        }
        g0.y = s4;
        g0.I = "";
        if(floatingBannerRes$RESPONSE$BANNER0 != null) {
            StatsElementsBase statsElementsBase0 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
            if(statsElementsBase0 != null) {
                s = statsElementsBase0.rangeCode;
            }
        }
        if(s != null) {
            s2 = s;
        }
        g0.J = s2;
        g0.a().track();
    }

    public final void k(BANNER floatingBannerRes$RESPONSE$BANNER0) {
        this.f();
        p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        String s = null;
        String s1 = this.getActivity() == null ? null : "닫기";
        String s2 = "";
        if(s1 == null) {
            s1 = "";
        }
        g0.a = s1;
        g0.d = ActionKind.ClickContent;
        String s3 = this.getActivity() == null ? null : "멜론홈탭";
        if(s3 == null) {
            s3 = "";
        }
        g0.b = s3;
        g0.c = "";
        String s4 = this.getActivity() == null ? null : "로그인플로팅배너";
        if(s4 == null) {
            s4 = "";
        }
        g0.y = s4;
        String s5 = this.getActivity() == null ? null : "닫기";
        if(s5 == null) {
            s5 = "";
        }
        g0.F = s5;
        g0.I = "";
        if(floatingBannerRes$RESPONSE$BANNER0 != null) {
            StatsElementsBase statsElementsBase0 = floatingBannerRes$RESPONSE$BANNER0.getStatsElements();
            if(statsElementsBase0 != null) {
                s = statsElementsBase0.rangeCode;
            }
        }
        if(s != null) {
            s2 = s;
        }
        g0.J = s2;
        g0.a().track();
    }

    public final void l(boolean z, boolean z1) {
        int v = 8;
        if(z1) {
            ComposeView composeView0 = this.j;
            if(composeView0 != null) {
                composeView0.setVisibility(8);
            }
            this.j = null;
            return;
        }
        ComposeView composeView1 = this.j;
        if(composeView1 != null) {
            if(z) {
                composeView1.getVisibility();
            }
            if(z) {
                v = 0;
            }
            composeView1.setVisibility(v);
        }
    }

    public final void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        if(this.e != null && this.e.isShowing()) {
            MelonMainPromotionPopup melonMainPromotionPopup0 = this.e;
            if(melonMainPromotionPopup0 != null) {
                melonMainPromotionPopup0.setConfigurationChanged(configuration0.orientation);
            }
        }
    }

    public final void onCreate() {
        LogU.Companion.d("MusicBrowserPopupHelper", "onCreate()");
        x8.f.execute$default(new c9.b(), null, 1, null);  // 初始化器: Lx8/f;-><init>()V
        this.l = true;
        this.onEventShowMainPopups();
        BuildersKt__Builders_commonKt.launch$default(this.g(), null, null, new we.n(null) {
            public int r;
            public final MusicBrowserPopupHelper w;

            {
                this.w = musicBrowserPopupHelper0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.onCreate.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.onCreate.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        StateFlow stateFlow0 = MusicBrowserPopupHelper.access$getLoginPopUpStateFlow(this.w);
                        com.iloen.melon.utils.ui.MusicBrowserPopupHelper.onCreate.1.1 musicBrowserPopupHelper$onCreate$1$10 = new FlowCollector() {
                            public final MusicBrowserPopupHelper a;

                            {
                                this.a = musicBrowserPopupHelper0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                            }

                            public final Object emit(boolean z, Continuation continuation0) {
                                com.iloen.melon.utils.ui.MusicBrowserPopupHelper.onCreate.1.1.emit.1 musicBrowserPopupHelper$onCreate$1$1$emit$10;
                                if(continuation0 instanceof com.iloen.melon.utils.ui.MusicBrowserPopupHelper.onCreate.1.1.emit.1) {
                                    musicBrowserPopupHelper$onCreate$1$1$emit$10 = (com.iloen.melon.utils.ui.MusicBrowserPopupHelper.onCreate.1.1.emit.1)continuation0;
                                    int v = musicBrowserPopupHelper$onCreate$1$1$emit$10.B;
                                    if((v & 0x80000000) == 0) {
                                        musicBrowserPopupHelper$onCreate$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                            public int B;
                                            public Object r;

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                this.r = object0;
                                                this.B |= 0x80000000;
                                                return continuation0.emit(false, this);
                                            }
                                        };
                                    }
                                    else {
                                        musicBrowserPopupHelper$onCreate$1$1$emit$10.B = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    musicBrowserPopupHelper$onCreate$1$1$emit$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                        public int B;
                                        public Object r;

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            this.r = object0;
                                            this.B |= 0x80000000;
                                            return continuation0.emit(false, this);
                                        }
                                    };
                                }
                                Object object0 = musicBrowserPopupHelper$onCreate$1$1$emit$10.r;
                                a a0 = a.a;
                                MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.a;
                                switch(musicBrowserPopupHelper$onCreate$1$1$emit$10.B) {
                                    case 0: {
                                        n.D(object0);
                                        if(!z && musicBrowserPopupHelper0.m) {
                                            musicBrowserPopupHelper$onCreate$1$1$emit$10.B = 1;
                                            if(DelayKt.delay(1000L, musicBrowserPopupHelper$onCreate$1$1$emit$10) == a0) {
                                                return a0;
                                            }
                                            goto label_20;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        n.D(object0);
                                    label_20:
                                        MelonBasePopup melonBasePopup0 = musicBrowserPopupHelper0.i;
                                        if(melonBasePopup0 != null) {
                                            melonBasePopup0.show();
                                        }
                                        musicBrowserPopupHelper0.m = false;
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                return ie.H.a;
                            }
                        };
                        this.r = 1;
                        if(stateFlow0.collect(musicBrowserPopupHelper$onCreate$1$10, this) == a0) {
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
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }, 3, null);
    }

    public final void onDestroy() {
        this.a();
    }

    public final void onEventLogin() {
        this.i();
    }

    public final void onEventShowMainPopups() {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("MusicBrowserPopupHelper", "onEventShowMainPopups() userVisibleHint: " + this.l);
        MusicBrowserActivity musicBrowserActivity0 = this.getActivity();
        if((musicBrowserActivity0 == null || !musicBrowserActivity0.isInMultiWindowMode()) && !this.k) {
            logU$Companion0.d("MusicBrowserPopupHelper", "initAndShowPopups()");
            if(this.l && this.getActivity() != null) {
                MusicBrowserActivity musicBrowserActivity1 = this.getActivity();
                if(Td.b.d(musicBrowserActivity1)) {
                    boolean z = MelonPrefs.getInstance().getBoolean("MarketingAcceptShown", false);
                    if(!z) {
                        l0 l00 = musicBrowserActivity1 == null ? null : musicBrowserActivity1.getSupportFragmentManager();
                        com.iloen.melon.utils.ui.c c0 = new com.iloen.melon.utils.ui.c(musicBrowserActivity1, this, 0);
                        com.iloen.melon.utils.ui.c c1 = new com.iloen.melon.utils.ui.c(musicBrowserActivity1, this, 1);
                        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K && musicBrowserActivity1 != null) {
                            l00.C();
                            if(com.melon.ui.popup.b.b(l00, "showMarketingPushPopup", null, null, 12) == null) {
                                q.f("마케팅 동의 팝업", "getString(...)");
                                List list0 = e.k.A(new Object[]{0x7F0807BB, "마케팅 동의 팝업"});  // drawable:push
                                h.t(null, null, (musicBrowserActivity1 == null ? null : "나중에"), true, c0, (musicBrowserActivity1 == null ? null : "받기"), new G(c1, 2), null, false, false, vd.h.h, false, list0, 5443).show(l00, "showMarketingPushPopup");
                            }
                        }
                    }
                    if(!this.k && z) {
                        this.k = true;
                        this.i();
                    }
                }
            }
        }
    }

    public final void onPause() {
        this.l = false;
    }

    public final void onResume() {
        this.l = true;
    }

    public final void onStop() {
        MelonAppBase.Companion.getClass();
        t.a().getRequestQueue().cancelAll("MusicBrowserPopupHelper");
    }

    public final void setLastTabIndexIndex(int v) {
        this.c = v;
    }

    public final void setLock(boolean z) {
        boolean z1 = this.b;
        this.b = z;
        StringBuilder stringBuilder0 = Y.q("setLock() prevLock:", ", this.isLockByInfoPush:", z1, ", isLock:", z);
        stringBuilder0.append(z);
        LogU.Companion.d("MusicBrowserPopupHelper", stringBuilder0.toString());
        if(z && !z1) {
            this.a();
        }
    }

    public final void setShouldShowMiniPlayer(boolean z) {
        LogU.Companion.d("MusicBrowserPopupHelper", "setShouldShowMiniPlayer()");
        this.a = z;
        this.l(z, false);
    }

    public final void showLoginPopup() {
        if(this.m) {
            MelonBasePopup melonBasePopup0 = this.i;
            if(melonBasePopup0 != null) {
                melonBasePopup0.show();
            }
            this.m = false;
        }
    }

    public final void showLoginPopup(@Nullable NotificationLoginRes notificationLoginRes0) {
        LogU.Companion.d("MusicBrowserPopupHelper", "showLoginPopup()");
        this.c();
        if(notificationLoginRes0 != null && this.l && !this.b) {
            String s = u.v(((e0)va.o.a()).j());
            com.iloen.melon.net.v4x.response.NotificationLoginRes.Response notificationLoginRes$Response0 = notificationLoginRes0.response;
            if(notificationLoginRes$Response0 != null) {
                BuildersKt__Builders_commonKt.launch$default(this.g(), null, null, new we.n(this, s, null) {
                    public final MusicBrowserPopupHelper B;
                    public final String D;
                    public int r;
                    public final com.iloen.melon.net.v4x.response.NotificationLoginRes.Response w;

                    {
                        this.w = notificationLoginRes$Response0;
                        this.B = musicBrowserPopupHelper0;
                        this.D = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1(this.w, this.B, this.D, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        String s = this.D;
                        com.iloen.melon.net.v4x.response.NotificationLoginRes.Response notificationLoginRes$Response0 = this.w;
                        MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.B;
                        String s1 = null;
                        switch(this.r) {
                            case 0: {
                                n.D(object0);
                                com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.1 musicBrowserPopupHelper$showLoginPopup$1$10 = new we.n(musicBrowserPopupHelper0, s, null) {
                                    public final MusicBrowserPopupHelper B;
                                    public final String D;
                                    public int r;
                                    public final com.iloen.melon.net.v4x.response.NotificationLoginRes.Response w;

                                    {
                                        this.w = notificationLoginRes$Response0;
                                        this.B = musicBrowserPopupHelper0;
                                        this.D = s;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.1(this.w, this.B, this.D, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        a a0 = a.a;
                                        ie.H h0 = ie.H.a;
                                        switch(this.r) {
                                            case 0: {
                                                n.D(object0);
                                                ArrayList arrayList0 = this.w.removeBans;
                                                if(arrayList0 != null && !arrayList0.isEmpty()) {
                                                    ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                                                    for(Object object1: arrayList0) {
                                                        arrayList1.add(((REMOVEBANS)object1).id);
                                                    }
                                                    d d0 = MusicBrowserPopupHelper.access$getBannerPopupUseCase(this.B);
                                                    this.r = 1;
                                                    object0 = d0.a(this.D, "PROMOTION", arrayList1, this);
                                                    if(object0 == a0) {
                                                        return a0;
                                                    }
                                                    Y.t("showLoginPopup() deleted : ", ((Number)object0).intValue(), LogU.Companion, "MusicBrowserPopupHelper");
                                                    return h0;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                n.D(object0);
                                                Y.t("showLoginPopup() deleted : ", ((Number)object0).intValue(), LogU.Companion, "MusicBrowserPopupHelper");
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        return h0;
                                    }
                                };
                                this.r = 1;
                                if(BuildersKt.withContext(Dispatchers.getIO(), musicBrowserPopupHelper$showLoginPopup$1$10, this) == a0) {
                                    return a0;
                                }
                                goto label_13;
                            }
                            case 1: {
                                n.D(object0);
                            label_13:
                                Promotion notificationLoginRes$Response$Promotion0 = notificationLoginRes$Response0.promotion;
                                if(notificationLoginRes$Response$Promotion0 != null) {
                                    ArrayList arrayList0 = notificationLoginRes$Response$Promotion0.alert == null ? null : notificationLoginRes$Response$Promotion0.alert.buttons;
                                    boolean z = notificationLoginRes$Response$Promotion0.sheet != null;
                                    if(arrayList0 != null && !arrayList0.isEmpty() || z) {
                                        MelonTMPPopup melonTMPPopup0 = new MelonTMPPopup(musicBrowserPopupHelper0.getActivity(), (z ? 0x7F0D0894 : 0x7F0D0138), (z ? 0x7F140011 : 0));  // layout:tmp_webview_popup_layout
                                        melonTMPPopup0.setTitleName((musicBrowserPopupHelper0.getActivity() == null ? null : "안내"));
                                        Alert notificationLoginRes$Response$Promotion$Alert0 = notificationLoginRes$Response$Promotion0.alert;
                                        if(notificationLoginRes$Response$Promotion$Alert0 != null) {
                                            s1 = notificationLoginRes$Response$Promotion$Alert0.message;
                                        }
                                        melonTMPPopup0.setBodyMsg(s1);
                                        if(arrayList0 != null) {
                                            melonTMPPopup0.setGoLinkMsg(((com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.Buttons)arrayList0.get(0)).label);
                                            melonTMPPopup0.setGoLinkUrl(((com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.Buttons)arrayList0.get(0)).linkUri);
                                            melonTMPPopup0.setMessageId(notificationLoginRes$Response0.messageId);
                                        }
                                        melonTMPPopup0.setPromotionRes(notificationLoginRes$Response$Promotion0);
                                        melonTMPPopup0.setCheckMsg((notificationLoginRes$Response$Promotion0.banOn == null ? "" : notificationLoginRes$Response$Promotion0.banOn.message));
                                        melonTMPPopup0.setPopupOnClickListener(new j(notificationLoginRes$Response$Promotion0, musicBrowserPopupHelper0, s));
                                        musicBrowserPopupHelper0.i = melonTMPPopup0;
                                        musicBrowserPopupHelper0.m = true;
                                        if(!((Boolean)MusicBrowserPopupHelper.access$getLoginPopUpStateFlow(musicBrowserPopupHelper0).getValue()).booleanValue()) {
                                            this.r = 2;
                                            if(DelayKt.delay(1000L, this) == a0) {
                                                return a0;
                                            }
                                            musicBrowserPopupHelper0.showLoginPopup();
                                            return ie.H.a;
                                        }
                                        this.r = 3;
                                        if(DelayKt.delay(3000L, this) == a0) {
                                            return a0;
                                        }
                                        musicBrowserPopupHelper0.showLoginPopup();
                                        return ie.H.a;
                                    }
                                }
                                break;
                            }
                            case 2: {
                                n.D(object0);
                                musicBrowserPopupHelper0.showLoginPopup();
                                return ie.H.a;
                            }
                            case 3: {
                                n.D(object0);
                                musicBrowserPopupHelper0.showLoginPopup();
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        return ie.H.a;

                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                        @e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper$showLoginPopup$1$2$1$1", f = "MusicBrowserPopupHelper.kt", l = {939}, m = "invokeSuspend")
                        final class com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1 extends oe.i implements we.n {
                            public final String B;
                            public final String D;
                            public final com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.BANON E;
                            public int r;
                            public final MusicBrowserPopupHelper w;

                            public com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, String s, String s1, com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.BANON notificationLoginRes$Response$Promotion$BANON0, Continuation continuation0) {
                                this.w = musicBrowserPopupHelper0;
                                this.B = s;
                                this.D = s1;
                                this.E = notificationLoginRes$Response$Promotion$BANON0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1(this.w, this.B, this.D, this.E, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                a a0 = a.a;
                                switch(this.r) {
                                    case 0: {
                                        n.D(object0);
                                        com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1.1 musicBrowserPopupHelper$showLoginPopup$1$2$1$1$10 = new we.n(this.B, this.D, this.E, null) {
                                            public final String B;
                                            public final String D;
                                            public final com.iloen.melon.net.v4x.response.NotificationLoginRes.Response.Promotion.BANON E;
                                            public int r;
                                            public final MusicBrowserPopupHelper w;

                                            {
                                                this.w = musicBrowserPopupHelper0;
                                                this.B = s;
                                                this.D = s1;
                                                this.E = notificationLoginRes$Response$Promotion$BANON0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                return new com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1.1(this.w, this.B, this.D, this.E, continuation0);
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                return ((com.iloen.melon.utils.ui.MusicBrowserPopupHelper.showLoginPopup.1.2.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                a a0 = a.a;
                                                switch(this.r) {
                                                    case 0: {
                                                        n.D(object0);
                                                        d d0 = MusicBrowserPopupHelper.access$getBannerPopupUseCase(this.w);
                                                        BannerPopupEntity bannerPopupEntity0 = new BannerPopupEntity();
                                                        bannerPopupEntity0.setMemberKey(this.B);
                                                        q.d(this.D);
                                                        bannerPopupEntity0.setId(this.D);
                                                        String s = this.E.query;
                                                        q.f(s, "query");
                                                        bannerPopupEntity0.setBanOn(s);
                                                        bannerPopupEntity0.setPopupType("PROMOTION");
                                                        this.r = 1;
                                                        object0 = d0.c(bannerPopupEntity0, this);
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
                                                LogU.Companion.d("MusicBrowserPopupHelper", "showLoginPopup() inserted : " + ((Number)object0).longValue());
                                                return ie.H.a;
                                            }
                                        };
                                        this.r = 1;
                                        return BuildersKt.withContext(Dispatchers.getIO(), musicBrowserPopupHelper$showLoginPopup$1$2$1$1$10, this) == a0 ? a0 : ie.H.a;
                                    }
                                    case 1: {
                                        n.D(object0);
                                        return ie.H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        }

                    }
                }, 3, null);
            }
        }
    }
}

