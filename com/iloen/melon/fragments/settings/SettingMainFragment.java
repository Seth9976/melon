package com.iloen.melon.fragments.settings;

import A8.M;
import De.d;
import E9.w;
import Gd.u;
import H8.i;
import J8.V2;
import J8.x;
import M6.B;
import S2.c;
import U8.l;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.f0;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import b3.Z;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.google.android.material.search.e;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.AppVersionInfo;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.custom.SettingLoginView;
import com.iloen.melon.custom.U;
import com.iloen.melon.custom.c1;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmListFragment;
import com.iloen.melon.fragments.webview.MelonWebViewWithTitleBarFragment.CopyLightFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.AuthLocationReq;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq.CallerType;
import com.iloen.melon.net.v4x.request.DeviceInformDeviceCheckReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.request.SettingInformGuideUrlReq;
import com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes;
import com.iloen.melon.net.v4x.response.SettingInformGuideUrlRes.Response;
import com.iloen.melon.net.v4x.response.SettingInformGuideUrlRes;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.MutexLockUtil;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ReentrantMutexContextElement;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.network.ServerPhase;
import com.iloen.melon.utils.network.UrlUtil;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.shortcut.ShortCutItem;
import com.iloen.melon.utils.shortcut.ShortcutManager;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.MelonThemeUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.utils.system.DeviceData;
import d3.g;
import e1.b;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;
import je.p;
import k8.Y;
import k8.t;
import kc.D2;
import kc.Y2;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.guava.ListenableFutureKt;
import kotlinx.coroutines.sync.Mutex;
import mb.k;
import mb.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r8.f;
import v9.h;
import va.e0;
import vd.V;
import we.a;

@Metadata(d1 = {"\u0000\u00BF\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001k\b\u0007\u0018\u0000 z2\u00020\u0001:\u0001zB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ\u000F\u0010\f\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u000F\u0010\bJ+\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00102\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u00142\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u000F\u0010\u001B\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0003J\u000F\u0010\u001C\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0003J\u000F\u0010\u001D\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0003J\u000F\u0010\u001E\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0003J-\u0010%\u001A\u00020\u000B2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010$\u001A\u0004\u0018\u00010#H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001D\u0010*\u001A\b\u0012\u0002\b\u0003\u0018\u00010)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J\u0011\u0010-\u001A\u0004\u0018\u00010,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u0011\u00100\u001A\u0004\u0018\u00010/H\u0014\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b2\u0010\u0003J\u000F\u00103\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b3\u0010\u0003J\u0017\u00104\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0014H\u0003\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b6\u0010\u0003J\u000F\u00107\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b7\u0010\u0003J\u0017\u00109\u001A\u00020\u00062\u0006\u00108\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010;\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b;\u0010\u0003J\u000F\u0010<\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b<\u0010\rJ\u000F\u0010=\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b=\u0010\u0003J\u000F\u0010>\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b>\u0010\u0003J\u0017\u0010@\u001A\u00020\u00062\u0006\u0010?\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b@\u0010:J\u000F\u0010A\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bA\u0010\u0003J\u000F\u0010B\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bB\u0010\u0003R\u0018\u0010D\u001A\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001A\u00020F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001A\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u001B\u0010R\u001A\u00020M8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bN\u0010O\u001A\u0004\bP\u0010QR\"\u0010T\u001A\u00020S8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bT\u0010U\u001A\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010[\u001A\u00020Z8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b[\u0010\\\u001A\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010b\u001A\u00020a8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bb\u0010c\u001A\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010i\u001A\u00020h8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010l\u001A\u00020k8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010o\u001A\u00020n8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010r\u001A\u00020q8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010u\u001A\u00020t8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bu\u0010vR\u0011\u0010y\u001A\u00020C8F\u00A2\u0006\u0006\u001A\u0004\bw\u0010x\u00A8\u0006{"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingMainFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "isTopLevelFragment", "()Z", "inState", "onRestoreInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "onStart", "onStop", "onDestroyView", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "registerIsLoginFlow", "registerSmartPlaylistUseFlow", "initView", "(Landroid/view/View;)V", "updateSmartPlaylistDesc", "updateView", "deviceYn", "updateDeviceRegisterInfo", "(Z)V", "updateVersionInfoView", "isEnabledStopReservation", "updateNetworkUsingView", "updateRelatedUserInfo", "hasPermission", "setLocationPermitSubText", "updateStreamingInfoButton", "updateDomainInfo", "LJ8/V2;", "_binding", "LJ8/V2;", "", "mScrollPositionY", "I", "mScrollToNetworkOption", "Z", "mFaqUrl", "Ljava/lang/String;", "Lcom/iloen/melon/fragments/settings/SettingMainViewModel;", "settingMainViewModel$delegate", "Lie/j;", "getSettingMainViewModel", "()Lcom/iloen/melon/fragments/settings/SettingMainViewModel;", "settingMainViewModel", "Lmb/k;", "loginUseCase", "Lmb/k;", "getLoginUseCase", "()Lmb/k;", "setLoginUseCase", "(Lmb/k;)V", "Lmb/o;", "simpleAccountUseCase", "Lmb/o;", "getSimpleAccountUseCase", "()Lmb/o;", "setSimpleAccountUseCase", "(Lmb/o;)V", "Lcom/melon/utils/system/DeviceData;", "deviceData", "Lcom/melon/utils/system/DeviceData;", "getDeviceData", "()Lcom/melon/utils/system/DeviceData;", "setDeviceData", "(Lcom/melon/utils/system/DeviceData;)V", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "com/iloen/melon/fragments/settings/SettingMainFragment$mSettingStatusChangeListener$1", "mSettingStatusChangeListener", "Lcom/iloen/melon/fragments/settings/SettingMainFragment$mSettingStatusChangeListener$1;", "Landroid/view/View$OnClickListener;", "mOnItemClickListener", "Landroid/view/View$OnClickListener;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "mPrefListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "Landroid/view/View$OnTouchListener;", "mExportDbTouchListener", "Landroid/view/View$OnTouchListener;", "getBinding", "()LJ8/V2;", "binding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingMainFragment extends Hilt_SettingMainFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\nJ\u000E\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingMainFragment$Companion;", "", "<init>", "()V", "TAG", "", "TAG_GUIDE_REQ", "ARG_SCROLL_POSITION", "ARG_SCROLL_TO_NETWORK_OPTION", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingMainFragment;", "scrollToNetworkOption", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingMainFragment newInstance() {
            return this.newInstance(false);
        }

        @NotNull
        public final SettingMainFragment newInstance(boolean z) {
            SettingMainFragment settingMainFragment0 = new SettingMainFragment();
            new Bundle().putBoolean("argScrollToNetworkOption", z);
            return settingMainFragment0;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[AddPosition.values().length];
            try {
                arr_v[2] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_SCROLL_POSITION = "argScrollPosition";
    @NotNull
    private static final String ARG_SCROLL_TO_NETWORK_OPTION = "argScrollToNetworkOption";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SettingMainFragment";
    @NotNull
    private static final String TAG_GUIDE_REQ = "SettingMainFragment + GuideReq";
    @Nullable
    private V2 _binding;
    @Inject
    public DeviceData deviceData;
    @NotNull
    private final LogU log;
    @Inject
    public k loginUseCase;
    @NotNull
    private final View.OnTouchListener mExportDbTouchListener;
    @Nullable
    private String mFaqUrl;
    @NotNull
    private View.OnClickListener mOnItemClickListener;
    @NotNull
    private final SharedPreferences.OnSharedPreferenceChangeListener mPrefListener;
    private int mScrollPositionY;
    private boolean mScrollToNetworkOption;
    @NotNull
    private final com.iloen.melon.fragments.settings.SettingMainFragment.mSettingStatusChangeListener.1 mSettingStatusChangeListener;
    @NotNull
    private final j settingMainViewModel$delegate;
    @Inject
    public o simpleAccountUseCase;

    static {
        SettingMainFragment.Companion = new Companion(null);
        SettingMainFragment.$stable = 8;
    }

    public SettingMainFragment() {
        this.mScrollPositionY = -1;
        com.iloen.melon.fragments.settings.SettingMainFragment.special..inlined.viewModels.default.2 settingMainFragment$special$$inlined$viewModels$default$20 = new a() {
            final a $ownerProducer;

            {
                this.$ownerProducer = a0;
                super(0);
            }

            @NotNull
            public final r0 invoke() {
                return (r0)this.$ownerProducer.invoke();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        j j0 = g.P(ie.k.c, settingMainFragment$special$$inlined$viewModels$default$20);
        d d0 = I.a.b(SettingMainViewModel.class);
        com.iloen.melon.fragments.settings.SettingMainFragment.special..inlined.viewModels.default.3 settingMainFragment$special$$inlined$viewModels$default$30 = new a() {
            final j $owner$delegate;

            {
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final q0 invoke() {
                return ((r0)this.$owner$delegate.getValue()).getViewModelStore();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        com.iloen.melon.fragments.settings.SettingMainFragment.special..inlined.viewModels.default.4 settingMainFragment$special$$inlined$viewModels$default$40 = new a(j0) {
            final a $extrasProducer;
            final j $owner$delegate;

            {
                this.$extrasProducer = a0;
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final c invoke() {
                a a0 = this.$extrasProducer;
                if(a0 != null) {
                    c c0 = (c)a0.invoke();
                    if(c0 != null) {
                        return c0;
                    }
                }
                r0 r00 = (r0)this.$owner$delegate.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                return n0 != null ? n0.getDefaultViewModelCreationExtras() : S2.a.b;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        };
        this.settingMainViewModel$delegate = new i(d0, settingMainFragment$special$$inlined$viewModels$default$30, new a(j0) {
            final j $owner$delegate;
            final androidx.fragment.app.I $this_viewModels;

            {
                this.$this_viewModels = i0;
                this.$owner$delegate = j0;
                super(0);
            }

            @NotNull
            public final o0 invoke() {
                r0 r00 = (r0)this.$owner$delegate.getValue();
                n n0 = r00 instanceof n ? ((n)r00) : null;
                if(n0 != null) {
                    o0 o00 = n0.getDefaultViewModelProviderFactory();
                    return o00 == null ? this.$this_viewModels.getDefaultViewModelProviderFactory() : o00;
                }
                return this.$this_viewModels.getDefaultViewModelProviderFactory();
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }, settingMainFragment$special$$inlined$viewModels$default$40);
        LogU logU0 = Z.g("SettingMainFragment", true);
        logU0.setCategory(Category.Login);
        this.log = logU0;
        this.mSettingStatusChangeListener = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "intent");
                String s = intent0.getAction();
                LogU.Companion.d("SettingMainFragment", "onReceive() intent: " + intent0);
                if("com.iloen.melon.intent.action.setting.changed.3g.usage.noti".equals(s) && SettingMainFragment.this.isAdded()) {
                    SettingMainFragment.this.updateView();
                }
            }
        };
        this.mOnItemClickListener = new E(this, 2);
        this.mPrefListener = new z(this);
        this.mExportDbTouchListener = new e(2);

        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/m0;", "VM", "Landroidx/fragment/app/I;", "invoke", "()Landroidx/fragment/app/I;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.settings.SettingMainFragment.special..inlined.viewModels.default.1 extends r implements a {
            final androidx.fragment.app.I $this_viewModels;

            public com.iloen.melon.fragments.settings.SettingMainFragment.special..inlined.viewModels.default.1(androidx.fragment.app.I i0) {
                this.$this_viewModels = i0;
                super(0);
            }

            @NotNull
            public final androidx.fragment.app.I invoke() {
                return this.$this_viewModels;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        }

    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    public static boolean d0(View view0, MotionEvent motionEvent0) {
        return SettingMainFragment.mExportDbTouchListener$lambda$32(view0, motionEvent0);
    }

    public static void e0(SettingMainFragment settingMainFragment0, SettingInformGuideUrlRes settingInformGuideUrlRes0) {
        SettingMainFragment.onFetchStart$lambda$6(settingMainFragment0, settingInformGuideUrlRes0);
    }

    public static void g0(SettingMainFragment settingMainFragment0, SettingItemView settingItemView0, boolean z) {
        SettingMainFragment.initView$lambda$21$lambda$13$lambda$12(settingMainFragment0, settingItemView0, z);
    }

    @NotNull
    public final V2 getBinding() {
        V2 v20 = this._binding;
        q.d(v20);
        return v20;
    }

    @NotNull
    public final DeviceData getDeviceData() {
        DeviceData deviceData0 = this.deviceData;
        if(deviceData0 != null) {
            return deviceData0;
        }
        q.m("deviceData");
        throw null;
    }

    @NotNull
    public final k getLoginUseCase() {
        k k0 = this.loginUseCase;
        if(k0 != null) {
            return k0;
        }
        q.m("loginUseCase");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @Nullable
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settings");
    }

    private final SettingMainViewModel getSettingMainViewModel() {
        return (SettingMainViewModel)this.settingMainViewModel$delegate.getValue();
    }

    @NotNull
    public final o getSimpleAccountUseCase() {
        o o0 = this.simpleAccountUseCase;
        if(o0 != null) {
            return o0;
        }
        q.m("simpleAccountUseCase");
        throw null;
    }

    public static void h0(SettingMainFragment settingMainFragment0, View view0) {
        SettingMainFragment.initView$lambda$21$lambda$20(settingMainFragment0, view0);
    }

    public static void i0(SettingMainFragment settingMainFragment0, View view0) {
        SettingMainFragment.initView$lambda$21$lambda$9(settingMainFragment0, view0);
    }

    private final void initView(View view0) {
        String s;
        if(this.mScrollPositionY != -1 || this.mScrollToNetworkOption) {
            new Handler(Looper.getMainLooper()).post(() -> SettingMainFragment.initView$lambda$21$lambda$7(this));
        }
        V2 v20 = this.getBinding();
        D d0 = (View view0, int v, int v1, int v2, int v3) -> SettingMainFragment.initView$lambda$21$lambda$8(this, view0, v, v1, v2, v3);
        v20.M.setOnScrollChangeListener(d0);
        V2 v21 = this.getBinding();
        E e0 = new E(this, 0);
        v21.s.setOnClickListener(e0);
        ViewUtils.setOnClickListener(this.getBinding().y, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().m, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().I, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().o, this.mOnItemClickListener);
        if(!TextUtils.isEmpty(this.mFaqUrl)) {
            this.updateStreamingInfoButton();
        }
        ViewUtils.setOnClickListener(this.getBinding().u, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().H, this.mOnItemClickListener);
        this.getBinding().t.a(MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal());
        ViewUtils.setOnClickListener(this.getBinding().t, this.mOnItemClickListener);
        if(MelonSettingInfo.isEqualizerStatusOn()) {
            s = b.F().d;
        }
        else {
            s = this.getString(0x7F130922);  // string:set_off "OFF"
            q.d(s);
        }
        V2 v22 = this.getBinding();
        int v = ScreenUtils.dipToPixel(v22.l.getContext(), 96.0f);
        v22.l.setSubTextMaxWidth(v);
        v22.l.setSubTextEllipsize(TextUtils.TruncateAt.END);
        v22.l.setSubText(s);
        ViewUtils.setOnClickListener(this.getBinding().l, this.mOnItemClickListener);
        SettingItemView settingItemView0 = this.getBinding().G;
        settingItemView0.setLoginRequired(true);
        settingItemView0.setRadioButtonUpdateManually(true);
        settingItemView0.setViewType(12);
        Boolean boolean0 = ((d3)this.playlistManager).m();
        settingItemView0.setRadioOnOff(this.isLoginUser() && (boolean0 == null ? false : boolean0.booleanValue()));
        settingItemView0.setRadioBtnClickListener(new F(this, settingItemView0, 0));
        this.updateSmartPlaylistDesc();
        ViewUtils.setOnClickListener(this.getBinding().w, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().e, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().J, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().f, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().z, this.mOnItemClickListener);
        this.getBinding().r.setViewType(12);
        V2 v23 = this.getBinding();
        A a0 = new A(this, 2);
        v23.r.setRadioBtnClickListener(a0);
        ViewUtils.setOnClickListener(this.getBinding().C, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().d, this.mOnItemClickListener);
        TextView textView0 = this.getBinding().d.j;
        if(textView0 != null) {
            ViewUtils.showWhen(textView0, true);
        }
        ViewUtils.setOnClickListener(this.getBinding().k, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().B, this.mOnItemClickListener);
        if(StorageUtils.isScopedStorage()) {
            ViewUtils.setOnClickListener(this.getBinding().j, this.mOnItemClickListener);
        }
        else {
            ViewUtils.hideWhen(this.getBinding().j, true);
        }
        ViewUtils.setOnClickListener(this.getBinding().D, this.mOnItemClickListener);
        this.getBinding().v.setViewType(12);
        TextView textView1 = (TextView)this.getBinding().v.findViewById(0x7F0A0B49);  // id:text
        if(this.getDeviceData().i()) {
            ViewUtils.setEnable(textView1, false);
            this.getBinding().v.setRadioClickable(false);
        }
        else {
            ViewUtils.setEnable(textView1, true);
            V2 v24 = this.getBinding();
            F f0 = new F(this, view0, 1);
            v24.v.setRadioBtnClickListener(f0);
        }
        ViewUtils.setOnClickListener(this.getBinding().g, this.mOnItemClickListener);
        this.getBinding().A.setSubTextColor(0x7F060163);  // color:gray700s
        ViewUtils.setOnClickListener(this.getBinding().A, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().q, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().F, this.mOnItemClickListener);
        ((MelonTextView)this.getBinding().n.b).setOnTouchListener(this.mExportDbTouchListener);
        V2 v25 = this.getBinding();
        E e1 = new E(this, 1);
        ((MelonTextView)v25.n.e).setOnClickListener(e1);
        ViewUtils.setOnClickListener(this.getBinding().h, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().x, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().c, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().p, this.mOnItemClickListener);
        V2 v26 = this.getBinding();
        boolean z = A8.b.e();
        ViewUtils.hideWhen(v26.K, z);
        ViewUtils.setOnClickListener(this.getBinding().i, this.mOnItemClickListener);
        ViewUtils.setOnClickListener(this.getBinding().E, this.mOnItemClickListener);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.settings.SettingMainFragment$initView$1$3$1", f = "SettingMainFragment.kt", l = {365, 1058}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1 extends oe.i implements we.n {
            int I$0;
            int I$1;
            int I$2;
            int I$3;
            long J$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            Object L$8;
            int label;

            public com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1(SettingMainFragment settingMainFragment0, Continuation continuation0) {
                SettingMainFragment.this = settingMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1(SettingMainFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s5;
                DevLog devLog2;
                String s4;
                long v1;
                long v;
                String s3;
                String s2;
                DevLog devLog1;
                Mutex mutex2;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        mutex2 = ((e0)SettingMainFragment.this.getLoginUseCase()).n;
                        SettingMainFragment settingMainFragment0 = SettingMainFragment.this;
                        MutexLockUtil mutexLockUtil0 = MutexLockUtil.INSTANCE;
                        LogU.debug$default(mutexLockUtil0.getLog(), androidx.appcompat.app.o.j(mutex2.hashCode(), "ReentrantLock[", "]  try : SettingMainFragment Click Login Button"), null, false, 6, null);
                        devLog1 = DevLog.Companion.get("MutexLockUtil");
                        ReentrantMutexContextKey reentrantMutexContextKey1 = l1.b("ReentrantLock[", mutex2.hashCode(), "]  try : SettingMainFragment Click Login Button", devLog1, mutex2);
                        s2 = "SettingMainFragment Click Login Button";
                        s3 = "";
                        if(this.getContext().get(reentrantMutexContextKey1) != null) {
                            try {
                                v = System.currentTimeMillis();
                                LogU.debug$default(mutexLockUtil0.getLog(), "ReentrantLock[" + mutex2.hashCode() + "]  Lock obtain : SettingMainFragment Click Login Button", null, false, 6, null);
                                devLog1.put("ReentrantLock[" + mutex2.hashCode() + "]  Lock obtain : SettingMainFragment Click Login Button");
                                LogU.debug$default(c9.i.b, "set skipTmpCall false in SettingMainFragment", null, false, 6, null);
                                FragmentActivity fragmentActivity0 = settingMainFragment0.getActivity();
                                MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
                                if(musicBrowserActivity0 != null) {
                                    musicBrowserActivity0.setSkipTmpCall(false);
                                }
                                if(!((e0)settingMainFragment0.getLoginUseCase()).m()) {
                                    Navigator.openLoginView(f.i);
                                }
                                else if(settingMainFragment0.getSimpleAccountUseCase().d()) {
                                    try {
                                        q.g(f.i, "returnUri");
                                        u u0 = new u();
                                        Bundle bundle0 = new Bundle();
                                        bundle0.putParcelable("returnUri", f.i);
                                        u0.setArguments(bundle0);
                                        Navigator.INSTANCE.open(u0);
                                        break;
                                    label_38:
                                        k k0 = settingMainFragment0.getLoginUseCase();
                                        this.L$0 = null;
                                        this.L$1 = mutex2;
                                        this.L$2 = "SettingMainFragment Click Login Button";
                                        this.L$3 = devLog1;
                                        this.L$4 = "";
                                        this.L$5 = null;
                                        this.L$6 = null;
                                        this.L$7 = null;
                                        this.L$8 = null;
                                        this.I$0 = 0;
                                        this.I$1 = 0;
                                        this.I$2 = 0;
                                        this.J$0 = v;
                                        this.I$3 = 0;
                                        this.label = 1;
                                        if(((e0)k0).z("SettingMainFragment Click Login Button", true, this) == a0) {
                                            return a0;
                                        }
                                        goto label_62;
                                    }
                                    catch(Throwable throwable0) {
                                    }
                                    goto label_57;
                                }
                                else {
                                    goto label_38;
                                label_57:
                                    v1 = v;
                                    s4 = "SettingMainFragment Click Login Button";
                                    devLog2 = devLog1;
                                    s5 = "";
                                    goto label_108;
                                label_62:
                                    v1 = v;
                                    s4 = "SettingMainFragment Click Login Button";
                                    devLog2 = devLog1;
                                    s5 = "";
                                    goto label_101;
                                }
                                break;
                            }
                            catch(Throwable throwable0) {
                                v1 = v;
                                s4 = "SettingMainFragment Click Login Button";
                                devLog2 = devLog1;
                                s5 = "";
                                goto label_108;
                            }
                        }
                        ReentrantMutexContextElement reentrantMutexContextElement0 = new ReentrantMutexContextElement(reentrantMutexContextKey1);
                        com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1.invokeSuspend..inlined.withReentrantLockLogging.default.1 settingMainFragment$initView$1$3$1$invokeSuspend$$inlined$withReentrantLockLogging$default$10 = new we.n(null, null, mutex2, "", "SettingMainFragment Click Login Button", devLog1, settingMainFragment0, "SettingMainFragment Click Login Button") {
                            final String $caller$inlined;
                            final String $callerTag$inlined;
                            final DevLog $devLog$inlined;
                            final Object $owner;
                            final Object $ownerStr$inlined;
                            final Mutex $this_withReentrantLock;
                            final Mutex $this_withReentrantLockLogging$inlined;
                            int I$0;
                            int I$1;
                            int I$2;
                            int I$3;
                            long J$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;

                            {
                                this.$this_withReentrantLock = mutex0;
                                this.$owner = object0;
                                this.$this_withReentrantLockLogging$inlined = mutex1;
                                this.$ownerStr$inlined = object1;
                                this.$caller$inlined = s;
                                this.$devLog$inlined = devLog0;
                                SettingMainFragment.this = settingMainFragment0;
                                this.$callerTag$inlined = s1;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1.invokeSuspend..inlined.withReentrantLockLogging.default.1(this.$this_withReentrantLock, this.$owner, continuation0, this.$this_withReentrantLockLogging$inlined, this.$ownerStr$inlined, this.$caller$inlined, this.$devLog$inlined, SettingMainFragment.this, this.$callerTag$inlined);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1.invokeSuspend..inlined.withReentrantLockLogging.default.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                long v2;
                                Mutex mutex2;
                                Object object2;
                                long v1;
                                int v;
                                Mutex mutex1;
                                Object object1;
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Mutex mutex0 = this.$this_withReentrantLock;
                                        object1 = this.$owner;
                                        this.L$0 = mutex0;
                                        this.L$1 = object1;
                                        this.I$0 = 0;
                                        this.label = 1;
                                        if(mutex0.lock(object1, this) == a0) {
                                            return a0;
                                        }
                                        mutex1 = mutex0;
                                        v = 0;
                                        goto label_18;
                                    }
                                    case 1: {
                                        v = this.I$0;
                                        object1 = this.L$1;
                                        mutex1 = (Mutex)this.L$0;
                                        d5.n.D(object0);
                                        try {
                                        label_18:
                                            v1 = System.currentTimeMillis();
                                            LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + this.$this_withReentrantLockLogging$inlined.hashCode() + "] " + this.$ownerStr$inlined + " Lock obtain : " + this.$caller$inlined, null, false, 6, null);
                                            this.$devLog$inlined.put("ReentrantLock[" + this.$this_withReentrantLockLogging$inlined.hashCode() + "] " + this.$ownerStr$inlined + " Lock obtain : " + this.$caller$inlined);
                                            LogU.debug$default(c9.i.b, "set skipTmpCall false in SettingMainFragment", null, false, 6, null);
                                            FragmentActivity fragmentActivity0 = SettingMainFragment.this.getActivity();
                                            MusicBrowserActivity musicBrowserActivity0 = fragmentActivity0 instanceof MusicBrowserActivity ? ((MusicBrowserActivity)fragmentActivity0) : null;
                                            if(musicBrowserActivity0 != null) {
                                                musicBrowserActivity0.setSkipTmpCall(false);
                                            }
                                            if(!((e0)SettingMainFragment.this.getLoginUseCase()).m()) {
                                                Navigator.openLoginView(f.i);
                                                object2 = object1;
                                                mutex2 = mutex1;
                                                v2 = v1;
                                            }
                                            else if(SettingMainFragment.this.getSimpleAccountUseCase().d()) {
                                                q.g(f.i, "returnUri");
                                                u u0 = new u();
                                                Bundle bundle0 = new Bundle();
                                                bundle0.putParcelable("returnUri", f.i);
                                                u0.setArguments(bundle0);
                                                Navigator.INSTANCE.open(u0);
                                                object2 = object1;
                                                mutex2 = mutex1;
                                                v2 = v1;
                                            }
                                            else {
                                                k k0 = SettingMainFragment.this.getLoginUseCase();
                                                this.L$0 = mutex1;
                                                this.L$1 = object1;
                                                this.L$2 = null;
                                                this.L$3 = null;
                                                this.I$0 = v;
                                                this.I$1 = 0;
                                                this.I$2 = 0;
                                                this.J$0 = v1;
                                                this.I$3 = 0;
                                                this.label = 2;
                                                if(((e0)k0).z(this.$callerTag$inlined, true, this) == a0) {
                                                    return a0;
                                                }
                                                object2 = object1;
                                                mutex2 = mutex1;
                                                v2 = v1;
                                                goto label_68;
                                            }
                                            goto label_76;
                                        }
                                        catch(Throwable throwable0) {
                                            object2 = object1;
                                            mutex2 = mutex1;
                                            goto label_72;
                                        }
                                        object2 = object1;
                                        mutex2 = mutex1;
                                        v2 = v1;
                                        goto label_76;
                                    }
                                    case 2: {
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                v2 = this.J$0;
                                Continuation continuation0 = (Continuation)this.L$3;
                                Continuation continuation1 = (Continuation)this.L$2;
                                object2 = this.L$1;
                                mutex2 = (Mutex)this.L$0;
                                try {
                                    d5.n.D(object0);
                                label_68:
                                    ToastManager.showShort(0x7F130615);  // string:melon_logout_ok "멜론 로그아웃 되었습니다."
                                    goto label_76;
                                }
                                catch(Throwable throwable0) {
                                    v1 = v2;
                                }
                                try {
                                label_72:
                                    long v3 = System.currentTimeMillis() - v1;
                                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + this.$this_withReentrantLockLogging$inlined.hashCode() + "] " + this.$ownerStr$inlined + " Lock return : " + this.$caller$inlined + " (" + v3 + "ms)", null, false, 6, null);
                                    this.$devLog$inlined.put("ReentrantLock[" + this.$this_withReentrantLockLogging$inlined.hashCode() + "] " + this.$ownerStr$inlined + " Lock return : " + this.$caller$inlined + " (" + v3 + "ms)");
                                    throw throwable0;
                                label_76:
                                    long v4 = System.currentTimeMillis() - v2;
                                    LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), "ReentrantLock[" + this.$this_withReentrantLockLogging$inlined.hashCode() + "] " + this.$ownerStr$inlined + " Lock return : " + this.$caller$inlined + " (" + v4 + "ms)", null, false, 6, null);
                                    this.$devLog$inlined.put("ReentrantLock[" + this.$this_withReentrantLockLogging$inlined.hashCode() + "] " + this.$ownerStr$inlined + " Lock return : " + this.$caller$inlined + " (" + v4 + "ms)");
                                }
                                catch(Throwable throwable1) {
                                    mutex2.unlock(object2);
                                    throw throwable1;
                                }
                                mutex2.unlock(object2);
                                return H.a;
                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.L$4 = null;
                        this.L$5 = null;
                        this.L$6 = null;
                        this.I$0 = 0;
                        this.I$1 = 0;
                        this.label = 2;
                        return BuildersKt.withContext(reentrantMutexContextElement0, settingMainFragment$initView$1$3$1$invokeSuspend$$inlined$withReentrantLockLogging$default$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        v1 = this.J$0;
                        Continuation continuation0 = (Continuation)this.L$8;
                        Continuation continuation1 = (Continuation)this.L$7;
                        ReentrantMutexContextKey reentrantMutexContextKey2 = (ReentrantMutexContextKey)this.L$6;
                        Mutex mutex3 = (Mutex)this.L$5;
                        s5 = this.L$4;
                        devLog2 = (DevLog)this.L$3;
                        s4 = (String)this.L$2;
                        mutex2 = (Mutex)this.L$1;
                        String s6 = (String)this.L$0;
                        try {
                            d5.n.D(object0);
                        label_101:
                            ToastManager.showShort(0x7F130615);  // string:melon_logout_ok "멜론 로그아웃 되었습니다."
                            s3 = s5;
                            devLog1 = devLog2;
                            s2 = s4;
                            v = v1;
                            break;
                        }
                        catch(Throwable throwable0) {
                        }
                    label_108:
                        long v2 = System.currentTimeMillis() - v1;
                        StringBuilder stringBuilder0 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s5);
                        H0.b.t(v2, s4, " (", stringBuilder0);
                        stringBuilder0.append("ms)");
                        LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder0.toString(), null, false, 6, null);
                        StringBuilder stringBuilder1 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s5);
                        H0.b.t(v2, s4, " (", stringBuilder1);
                        l1.C(stringBuilder1, "ms)", devLog2);
                        throw throwable0;
                    }
                    case 2: {
                        ReentrantMutexContextKey reentrantMutexContextKey0 = (ReentrantMutexContextKey)this.L$6;
                        Mutex mutex0 = (Mutex)this.L$5;
                        DevLog devLog0 = (DevLog)this.L$3;
                        String s = (String)this.L$2;
                        Mutex mutex1 = (Mutex)this.L$1;
                        String s1 = (String)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                long v3 = System.currentTimeMillis() - v;
                StringBuilder stringBuilder2 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
                H0.b.t(v3, s2, " (", stringBuilder2);
                stringBuilder2.append("ms)");
                LogU.debug$default(MutexLockUtil.INSTANCE.getLog(), stringBuilder2.toString(), null, false, 6, null);
                StringBuilder stringBuilder3 = l1.t("ReentrantLock[", "] ", " Lock return : ", mutex2.hashCode(), s3);
                H0.b.t(v3, s2, " (", stringBuilder3);
                l1.C(stringBuilder3, "ms)", devLog1);
                return H.a;
            }
        }


        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.settings.SettingMainFragment$initView$1$5$1$1$1", f = "SettingMainFragment.kt", l = {446}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.5.1.1.1 extends oe.i implements we.n {
            final SettingItemView $this_apply;
            final boolean $tryUseSmartPlaylist;
            int label;

            public com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.5.1.1.1(SettingMainFragment settingMainFragment0, boolean z, SettingItemView settingItemView0, Continuation continuation0) {
                SettingMainFragment.this = settingMainFragment0;
                this.$tryUseSmartPlaylist = z;
                this.$this_apply = settingItemView0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.5.1.1.1(SettingMainFragment.this, this.$tryUseSmartPlaylist, this.$this_apply, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.5.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                boolean z = false;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        B b0 = ListenableFutureKt.future$default(((d3)SettingMainFragment.this.playlistManager).b, null, null, new Y2(((d3)SettingMainFragment.this.playlistManager), this.$tryUseSmartPlaylist, false, null), 3, null);
                        this.label = 1;
                        if(ListenableFutureKt.await(b0, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                Boolean boolean0 = ((d3)SettingMainFragment.this.playlistManager).m();
                SettingItemView settingItemView0 = this.$this_apply;
                if(SettingMainFragment.this.isLoginUser() && (boolean0 == null ? false : boolean0.booleanValue())) {
                    z = true;
                }
                settingItemView0.setRadioOnOff(z);
                SettingMainFragment.this.updateSmartPlaylistDesc();
                return H.a;
            }
        }

    }

    private static final void initView$lambda$21$lambda$13$lambda$12(SettingMainFragment settingMainFragment0, SettingItemView settingItemView0, boolean z) {
        String s = settingMainFragment0.getString((z ? 0x7F130A3A : 0x7F130A3B));  // string:smart_playlist_switch_off_popup_desc "스마트 재생목록 설정을 끄고 기존 로컬 재생목록으로 변경하시겠습니까?"
        q.f(s, "getString(...)");
        com.melon.ui.popup.b.x(settingMainFragment0.getParentFragmentManager(), (settingItemView0.getContext() == null ? null : "안내"), s, false, false, null, null, new y(settingMainFragment0, settingItemView0, !z), null, null, null, 0xEF8);
    }

    private static final H initView$lambda$21$lambda$13$lambda$12$lambda$11(SettingMainFragment settingMainFragment0, boolean z, SettingItemView settingItemView0) {
        BuildersKt__Builders_commonKt.launch$default(f0.f(settingMainFragment0), null, null, new com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.5.1.1.1(settingMainFragment0, z, settingItemView0, null), 3, null);
        return H.a;
    }

    private static final void initView$lambda$21$lambda$15(SettingMainFragment settingMainFragment0, boolean z) {
        if(!AndroidSettings.canDrawOverlays()) {
            MelonTextPopup melonTextPopup0 = new MelonTextPopup(settingMainFragment0.getActivity(), 2);
            melonTextPopup0.setTitle(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            melonTextPopup0.setBodyMsg(settingMainFragment0.getString(0x7F1309AA));  // string:setting_lockscreen_popup_version_R "잠금화면 기능을 사용하시려면 멜론앱에서 다른앱 위에 사용 권한을 허용해 
                                                                                     // 주세요"
            melonTextPopup0.setPopupOnClickListener((DialogInterface dialogInterface0, int v) -> SettingMainFragment.initView$lambda$21$lambda$15$lambda$14(settingMainFragment0, melonTextPopup0, dialogInterface0, v));
            melonTextPopup0.show();
        }
        MelonSettingInfo.setUseLockScreen(z);
        ToastManager.show((z ? 0x7F1310EB : 0x7F1310EA));  // string:use_lock_screen_setting_on "곡 재생 중 잠금 화면을 사용할 수 있습니다."
    }

    private static final void initView$lambda$21$lambda$15$lambda$14(SettingMainFragment settingMainFragment0, MelonTextPopup melonTextPopup0, DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            Intent intent0 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent0.setData(Uri.parse("package:com.iloen.melon"));
            settingMainFragment0.startActivity(intent0);
            return;
        }
        V2 v20 = settingMainFragment0.getBinding();
        boolean z = MelonSettingInfo.isUseLockScreen();
        v20.r.setRadioOnOff(z);
        melonTextPopup0.dismiss();
    }

    private static final void initView$lambda$21$lambda$19$lambda$18(SettingMainFragment settingMainFragment0, View view0, boolean z) {
        MelonSettingInfo.setUseDataNetwork(z);
        if(z) {
            Intent intent0 = new Intent("com.iloen.melon.intent.action.setting.changed.3g.usage.noti");
            Context context0 = view0.getContext();
            if(context0 != null) {
                context0.sendBroadcast(intent0);
            }
            if(!((e0)settingMainFragment0.getLoginUseCase()).m() && NetUtils.isConnected()) {
                x8.f.execute$default(new c9.b(), null, 1, null);  // 初始化器: Lx8/f;-><init>()V
            }
        }
        Intent intent1 = new Intent("com.iloen.melon.intent.action.setting.changed.3g.usage");
        Context context1 = view0.getContext();
        if(context1 != null) {
            context1.sendBroadcast(intent1);
        }
        ToastManager.show((z ? 0x7F1310E9 : 0x7F1310E8));  // string:use_3g_setting_on "Wi-Fi가 연결되지 않았을 경우 데이터 네트워크를 사용합니다."
    }

    private static final void initView$lambda$21$lambda$20(SettingMainFragment settingMainFragment0, View view0) {
        settingMainFragment0.getSettingMainViewModel().onClickLoggerUnlock();
    }

    private static final void initView$lambda$21$lambda$7(SettingMainFragment settingMainFragment0) {
        if(!settingMainFragment0.isFragmentValid()) {
            return;
        }
        if(settingMainFragment0.mScrollToNetworkOption) {
            V2 v20 = settingMainFragment0.getBinding();
            int v = settingMainFragment0.getBinding().b.getLeft();
            int v1 = settingMainFragment0.getBinding().b.getTop();
            v20.M.scrollTo(v, v1);
            return;
        }
        settingMainFragment0.getBinding().M.scrollTo(0, settingMainFragment0.mScrollPositionY);
    }

    private static final void initView$lambda$21$lambda$8(SettingMainFragment settingMainFragment0, View view0, int v, int v1, int v2, int v3) {
        settingMainFragment0.mScrollPositionY = v1;
        TitleBar titleBar0 = settingMainFragment0.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.f(v1 > 0);
        }
    }

    private static final void initView$lambda$21$lambda$9(SettingMainFragment settingMainFragment0, View view0) {
        androidx.lifecycle.D d0 = settingMainFragment0.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.settings.SettingMainFragment.initView.1.3.1(settingMainFragment0, null), 3, null);
    }

    private final boolean isEnabledStopReservation() {
        return Calendar.getInstance().getTimeInMillis() <= MelonSettingInfo.getMelonTimer();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isTopLevelFragment() {
        return true;
    }

    public static void j0(SettingMainFragment settingMainFragment0, DeviceInformDeviceCheckRes deviceInformDeviceCheckRes0) {
        SettingMainFragment.updateRelatedUserInfo$lambda$24(settingMainFragment0, deviceInformDeviceCheckRes0);
    }

    public static void l0(SettingMainFragment settingMainFragment0, View view0) {
        SettingMainFragment.mOnItemClickListener$lambda$30(settingMainFragment0, view0);
    }

    public static void m0(SettingMainFragment settingMainFragment0, boolean z) {
        SettingMainFragment.initView$lambda$21$lambda$15(settingMainFragment0, z);
    }

    private static final boolean mExportDbTouchListener$lambda$32(View view0, MotionEvent motionEvent0) {
        long v1;
        int v;
        if(motionEvent0.getAction() == 0) {
            Object object0 = view0.getTag();
            if(object0 instanceof Pair) {
                Object object1 = ((Pair)object0).first;
                q.e(object1, "null cannot be cast to non-null type kotlin.Int");
                v = (int)(((Integer)object1));
                Object object2 = ((Pair)object0).second;
                q.e(object2, "null cannot be cast to non-null type kotlin.Long");
                v1 = (long)(((Long)object2));
            }
            else {
                v1 = System.currentTimeMillis();
                v = 1;
            }
            LogU.Companion.d("SettingMainFragment", "count:" + v + ", time:" + v1);
            if(Long.compare(System.currentTimeMillis() - v1, 1000L) < 0) {
                if(v < 10) {
                    view0.setTag(new Pair(((int)(v + 1)), System.currentTimeMillis()));
                    return false;
                }
                view0.setTag(null);
                Context context0 = view0.getContext();
                q.f(context0, "getContext(...)");
                FileUtils.exportUserDb(context0);
                return false;
            }
            view0.setTag(null);
        }
        return false;
    }

    private static final void mOnItemClickListener$lambda$30(SettingMainFragment settingMainFragment0, View view0) {
        switch(view0.getId()) {
            case 0x7F0A059F: {  // id:item_advanced
                SettingAdvancedFragment.newInstance().open();
                return;
            }
            case 0x7F0A05A0: {  // id:item_alarm
                Context context1 = settingMainFragment0.getContext();
                if(com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, context1, null, null, 6, null)) {
                    SettingMusicAlarmListFragment.Companion.newInstance().open();
                    return;
                }
                break;
            }
            case 0x7F0A05A2: {  // id:item_banned_contents
                if(!settingMainFragment0.isLoginUser()) {
                    settingMainFragment0.showLoginPopup();
                    return;
                }
                SettingBannedContentsFragment.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05A3: {  // id:item_bg_autoplay
                SettingBackgroundAutoPlayFragment.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05A5: {  // id:item_cache_setting
                SettingCacheFragment.newInstance().open();
                return;
            }
            case 0x7F0A05A8: {  // id:item_copyright
                MelonAppBase.Companion.getClass();
                if(NetUtils.showNetworkPopupOrToast(t.a().getContext(), false)) {
                    CopyLightFragment.newInstance().open();
                    return;
                }
                break;
            }
            case 0x7F0A05AE: {  // id:item_developer
                Navigator.open(new La.a());
                return;
            }
            case 0x7F0A05AF: {  // id:item_download_folder
                SettingDownloadFolderFragment.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05B0: {  // id:item_download_quality
                SettingDownloadSongFragment.newInstance().open();
                return;
            }
            case 0x7F0A05B1: {  // id:item_eq
                l l0 = new l();
                Navigator.INSTANCE.open(l0);
                return;
            }
            case 0x7F0A05B2: {  // id:item_identification
                Navigator.openUrlFullScreenView(M.W);
                return;
            }
            case 0x7F0A05B4: {  // id:item_kakao_account
                if(!settingMainFragment0.isLoginUser()) {
                    settingMainFragment0.showLoginPopup();
                    return;
                }
                Navigator.openUrl(M.P, OpenType.FullScreen);
                return;
            }
            case 0x7F0A05B5: {  // id:item_laboratory
                SettingLaboratoryFragment.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05B9: {  // id:item_location_permit
                if(!settingMainFragment0.isLoginUser()) {
                    settingMainFragment0.showLoginPopup();
                    return;
                }
                Navigator.openAuthLocationAgreeUrl(settingMainFragment0.getContext(), MelonSettingInfo.getLocationPermission());
                return;
            }
            case 0x7F0A05BC: {  // id:item_loudness_normalization
                SettingLoudnessNormalizationFragment.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05BE: {  // id:item_my_info
                if(!settingMainFragment0.isLoginUser()) {
                    settingMainFragment0.showLoginPopup();
                    return;
                }
                Navigator.openUrl(M.S, OpenType.DefaultWebView);
                return;
            }
            case 0x7F0A05C0: {  // id:item_offline_playback
                SettingOfflinePlayback.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05C1: {  // id:item_paid_service_term
                Navigator.openUrlFullScreenView(M.f0);
                return;
            }
            case 0x7F0A05C2: {  // id:item_password
                Navigator.openUrlFullScreenView(UrlUtil.INSTANCE.getUpdateMelonPasswordUrl());
                return;
            }
            case 0x7F0A05C4: {  // id:item_playling_list
                SettingAddPositionFragment.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05C5: {  // id:item_push_setting
                SettingPushFragment.newInstance().open();
                return;
            }
            case 0x7F0A05C6: {  // id:item_registration_device
                if(!settingMainFragment0.isLoginUser()) {
                    settingMainFragment0.showLoginPopup();
                    return;
                }
                Context context0 = settingMainFragment0.getContext();
                q.f(CallerType.SET, "SET");
                Navigator.INSTANCE.openDeviceRegisterUrl(context0, CallerType.SET);
                return;
            }
            case 0x7F0A05C7: {  // id:item_reservations_stop
                Context context2 = settingMainFragment0.getContext();
                if(com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, context2, null, null, 6, null)) {
                    SettingStopTimerFragment.Companion.newInstance().open();
                    return;
                }
                break;
            }
            case 0x7F0A05CA: {  // id:item_screen_setting
                SettingScreenFragment.Companion.newInstance().open();
                return;
            }
            case 0x7F0A05CC: {  // id:item_server_phase
                if(!A8.b.c().equalsIgnoreCase("BETA_PLAYSTORE") && !A8.b.c().equalsIgnoreCase("BETA_ONESTORE")) {
                    SettingServerPhaseFragment.Companion.newInstance().open();
                    return;
                }
                ToastManager.show(0x7F1309C8);  // string:setting_server_phase_iap_warn "인앱 샌드박스 테스트는 Sandbox Phase 에서만 가능합니다."
                return;
            }
            case 0x7F0A05CF: {  // id:item_shortcut_setting
                List list0 = ShortcutManager.getInstance().makeShortCutListItems();
                q.f(list0, "makeShortCutListItems(...)");
                List list1 = p.P0(list0);
                l0 l00 = settingMainFragment0.getChildFragmentManager();
                String s = settingMainFragment0.getString(0x7F130A0A);  // string:shortcut_title "바로가기 설치"
                com.iloen.melon.fragments.artistchannel.viewholder.f f0 = new com.iloen.melon.fragments.artistchannel.viewholder.f(9);
                if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
                    l00.C();
                    if(com.melon.ui.popup.b.b(l00, "showShortCutPopup", null, null, 12) == null) {
                        V v0 = new V();
                        v0.e = s;
                        v0.f = list1;
                        v0.setShouldRetain(true);
                        v0.h = f0;
                        v0.show(l00, "showShortCutPopup");
                        return;
                    }
                }
                break;
            }
            case 0x7F0A05D1: {  // id:item_sound_quality
                SettingSongFragment.newInstance().open();
                return;
            }
            case 0x7F0A05D5: {  // id:item_video_quality
                SettingMusicVideoFragment.newInstance().open();
                return;
            }
            case 0x7F0A05BB:   // id:item_login
            case 0x7F0A069C: {  // id:iv_thumb_circle_default
                if(!((e0)settingMainFragment0.getLoginUseCase()).m()) {
                    Navigator.openLoginView(f.i);
                    return;
                }
                if(settingMainFragment0.getSimpleAccountUseCase().d()) {
                    q.g(f.i, "returnUri");
                    u u0 = new u();
                    Bundle bundle0 = new Bundle();
                    bundle0.putParcelable("returnUri", f.i);
                    u0.setArguments(bundle0);
                    Navigator.INSTANCE.open(u0);
                    return;
                }
                break;
            }
            case 0x7F0A0BA3: {  // id:title_play_settings
                if(!TextUtils.isEmpty(settingMainFragment0.mFaqUrl)) {
                    Navigator.openUrl(settingMainFragment0.mFaqUrl, OpenType.DefaultWebViewWithMiniPlayer);
                    return;
                }
                break;
            }
        }
    }

    private static final H mOnItemClickListener$lambda$30$lambda$29(List list0) {
        q.g(list0, "pairList");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(((Boolean)((m)object0).b).booleanValue()) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object1: arrayList0) {
            arrayList1.add(ShortcutManager.getInstance().createShortcutData(((ShortCutItem)((m)object1).a)));
        }
        ShortcutManager.getInstance().requestShortcut(arrayList1, new com.iloen.melon.fragments.musicmessage.e(15));
        return H.a;
    }

    private static final void mOnItemClickListener$lambda$30$lambda$29$lambda$28(String s) {
        ShortcutManager.getInstance().sendClickLog(s);
    }

    private static final void mPrefListener$lambda$31(SettingMainFragment settingMainFragment0, SharedPreferences sharedPreferences0, String s) {
        if("Use3g".equals(s)) {
            settingMainFragment0.updateNetworkUsingView();
        }
    }

    public static H n0(SettingMainFragment settingMainFragment0, SettingItemView settingItemView0, boolean z) {
        return SettingMainFragment.initView$lambda$21$lambda$13$lambda$12$lambda$11(settingMainFragment0, z, settingItemView0);
    }

    // 检测为 Lambda 实现
    public static void o0(SettingMainFragment settingMainFragment0, View view0, int v, int v1, int v2, int v3) [...]

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            if(bundle0.containsKey("argScrollPosition")) {
                this.mScrollPositionY = bundle0.getInt("argScrollPosition");
            }
            if(bundle0.containsKey("argScrollToNetworkOption")) {
                this.mScrollToNetworkOption = bundle0.getBoolean("argScrollToNetworkOption");
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D0840, viewGroup0, false);  // layout:setting_view
        int v = 0x7F0A0572;  // id:index_bar_app_usage
        View view1 = De.I.C(view0, 0x7F0A0572);  // id:index_bar_app_usage
        if(((MelonTextView)view1) != null && ((MelonTextView)De.I.C(view0, 0x7F0A0573)) != null) {  // id:index_bar_download_setting
            v = 0x7F0A059F;  // id:item_advanced
            View view2 = De.I.C(view0, 0x7F0A059F);  // id:item_advanced
            if(((SettingItemView)view2) != null) {
                v = 0x7F0A05A0;  // id:item_alarm
                View view3 = De.I.C(view0, 0x7F0A05A0);  // id:item_alarm
                if(((SettingItemView)view3) != null && ((MelonTextView)De.I.C(view0, 0x7F0A05A1)) != null) {  // id:item_app_info
                    v = 0x7F0A05A2;  // id:item_banned_contents
                    View view4 = De.I.C(view0, 0x7F0A05A2);  // id:item_banned_contents
                    if(((SettingItemView)view4) != null) {
                        v = 0x7F0A05A3;  // id:item_bg_autoplay
                        View view5 = De.I.C(view0, 0x7F0A05A3);  // id:item_bg_autoplay
                        if(((SettingItemView)view5) != null) {
                            v = 0x7F0A05A5;  // id:item_cache_setting
                            View view6 = De.I.C(view0, 0x7F0A05A5);  // id:item_cache_setting
                            if(((SettingItemView)view6) != null) {
                                v = 0x7F0A05A8;  // id:item_copyright
                                View view7 = De.I.C(view0, 0x7F0A05A8);  // id:item_copyright
                                if(((SettingItemView)view7) != null) {
                                    v = 0x7F0A05AE;  // id:item_developer
                                    View view8 = De.I.C(view0, 0x7F0A05AE);  // id:item_developer
                                    if(((SettingItemView)view8) != null) {
                                        v = 0x7F0A05AF;  // id:item_download_folder
                                        View view9 = De.I.C(view0, 0x7F0A05AF);  // id:item_download_folder
                                        if(((SettingItemView)view9) != null) {
                                            v = 0x7F0A05B0;  // id:item_download_quality
                                            View view10 = De.I.C(view0, 0x7F0A05B0);  // id:item_download_quality
                                            if(((SettingItemView)view10) != null) {
                                                v = 0x7F0A05B1;  // id:item_eq
                                                View view11 = De.I.C(view0, 0x7F0A05B1);  // id:item_eq
                                                if(((SettingItemView)view11) != null) {
                                                    v = 0x7F0A05B2;  // id:item_identification
                                                    View view12 = De.I.C(view0, 0x7F0A05B2);  // id:item_identification
                                                    if(((SettingItemView)view12) != null) {
                                                        v = 0x7F0A05B3;  // id:item_info_version
                                                        View view13 = De.I.C(view0, 0x7F0A05B3);  // id:item_info_version
                                                        if(view13 != null) {
                                                            int v1 = 0x7F0A06B3;  // id:iv_version_up
                                                            View view14 = De.I.C(view13, 0x7F0A06B3);  // id:iv_version_up
                                                            if(((MelonImageView)view14) == null) {
                                                                throw new NullPointerException("Missing required view with ID: " + view13.getResources().getResourceName(v1));
                                                            }
                                                            v1 = 0x7F0A0C56;  // id:tv_current_version
                                                            View view15 = De.I.C(view13, 0x7F0A0C56);  // id:tv_current_version
                                                            if(((MelonTextView)view15) == null) {
                                                                throw new NullPointerException("Missing required view with ID: " + view13.getResources().getResourceName(v1));
                                                            }
                                                            v1 = 0x7F0A0D4E;  // id:tv_version_state
                                                            View view16 = De.I.C(view13, 0x7F0A0D4E);  // id:tv_version_state
                                                            if(((MelonTextView)view16) == null) {
                                                                throw new NullPointerException("Missing required view with ID: " + view13.getResources().getResourceName(v1));
                                                            }
                                                            J8.u u0 = new J8.u(((RelativeLayout)view13), ((MelonImageView)view14), ((MelonTextView)view15), ((MelonTextView)view16), 4);
                                                            v = 0x7F0A05B4;  // id:item_kakao_account
                                                            View view17 = De.I.C(view0, 0x7F0A05B4);  // id:item_kakao_account
                                                            if(((SettingItemView)view17) != null) {
                                                                v = 0x7F0A05B5;  // id:item_laboratory
                                                                View view18 = De.I.C(view0, 0x7F0A05B5);  // id:item_laboratory
                                                                if(((SettingItemView)view18) != null) {
                                                                    v = 0x7F0A05B9;  // id:item_location_permit
                                                                    View view19 = De.I.C(view0, 0x7F0A05B9);  // id:item_location_permit
                                                                    if(((SettingItemView)view19) != null) {
                                                                        v = 0x7F0A05BA;  // id:item_lock_screen
                                                                        View view20 = De.I.C(view0, 0x7F0A05BA);  // id:item_lock_screen
                                                                        if(((SettingItemView)view20) != null) {
                                                                            v = 0x7F0A05BB;  // id:item_login
                                                                            View view21 = De.I.C(view0, 0x7F0A05BB);  // id:item_login
                                                                            if(((SettingLoginView)view21) != null) {
                                                                                v = 0x7F0A05BC;  // id:item_loudness_normalization
                                                                                View view22 = De.I.C(view0, 0x7F0A05BC);  // id:item_loudness_normalization
                                                                                if(((SettingItemView)view22) != null) {
                                                                                    v = 0x7F0A05BE;  // id:item_my_info
                                                                                    View view23 = De.I.C(view0, 0x7F0A05BE);  // id:item_my_info
                                                                                    if(((SettingItemView)view23) != null) {
                                                                                        v = 0x7F0A05BF;  // id:item_network_using_setting
                                                                                        View view24 = De.I.C(view0, 0x7F0A05BF);  // id:item_network_using_setting
                                                                                        if(((SettingItemView)view24) != null) {
                                                                                            v = 0x7F0A05C0;  // id:item_offline_playback
                                                                                            View view25 = De.I.C(view0, 0x7F0A05C0);  // id:item_offline_playback
                                                                                            if(((SettingItemView)view25) != null) {
                                                                                                v = 0x7F0A05C1;  // id:item_paid_service_term
                                                                                                View view26 = De.I.C(view0, 0x7F0A05C1);  // id:item_paid_service_term
                                                                                                if(((SettingItemView)view26) != null) {
                                                                                                    v = 0x7F0A05C2;  // id:item_password
                                                                                                    View view27 = De.I.C(view0, 0x7F0A05C2);  // id:item_password
                                                                                                    if(((SettingItemView)view27) != null) {
                                                                                                        v = 0x7F0A05C4;  // id:item_playling_list
                                                                                                        View view28 = De.I.C(view0, 0x7F0A05C4);  // id:item_playling_list
                                                                                                        if(((SettingItemView)view28) != null) {
                                                                                                            v = 0x7F0A05C5;  // id:item_push_setting
                                                                                                            View view29 = De.I.C(view0, 0x7F0A05C5);  // id:item_push_setting
                                                                                                            if(((SettingItemView)view29) != null) {
                                                                                                                v = 0x7F0A05C6;  // id:item_registration_device
                                                                                                                View view30 = De.I.C(view0, 0x7F0A05C6);  // id:item_registration_device
                                                                                                                if(((SettingItemView)view30) != null) {
                                                                                                                    v = 0x7F0A05C7;  // id:item_reservations_stop
                                                                                                                    View view31 = De.I.C(view0, 0x7F0A05C7);  // id:item_reservations_stop
                                                                                                                    if(((SettingItemView)view31) != null) {
                                                                                                                        v = 0x7F0A05CA;  // id:item_screen_setting
                                                                                                                        View view32 = De.I.C(view0, 0x7F0A05CA);  // id:item_screen_setting
                                                                                                                        if(((SettingItemView)view32) != null) {
                                                                                                                            v = 0x7F0A05CC;  // id:item_server_phase
                                                                                                                            View view33 = De.I.C(view0, 0x7F0A05CC);  // id:item_server_phase
                                                                                                                            if(((SettingItemView)view33) != null) {
                                                                                                                                v = 0x7F0A05CF;  // id:item_shortcut_setting
                                                                                                                                View view34 = De.I.C(view0, 0x7F0A05CF);  // id:item_shortcut_setting
                                                                                                                                if(((SettingItemView)view34) != null) {
                                                                                                                                    v = 0x7F0A05D0;  // id:item_smart_playlist
                                                                                                                                    View view35 = De.I.C(view0, 0x7F0A05D0);  // id:item_smart_playlist
                                                                                                                                    if(((SettingItemView)view35) != null) {
                                                                                                                                        v = 0x7F0A05D1;  // id:item_sound_quality
                                                                                                                                        View view36 = De.I.C(view0, 0x7F0A05D1);  // id:item_sound_quality
                                                                                                                                        if(((SettingItemView)view36) != null) {
                                                                                                                                            v = 0x7F0A05D4;  // id:item_verify_adult
                                                                                                                                            View view37 = De.I.C(view0, 0x7F0A05D4);  // id:item_verify_adult
                                                                                                                                            if(((SettingItemView)view37) != null) {
                                                                                                                                                v = 0x7F0A05D5;  // id:item_video_quality
                                                                                                                                                View view38 = De.I.C(view0, 0x7F0A05D5);  // id:item_video_quality
                                                                                                                                                if(((SettingItemView)view38) != null && ((FrameLayout)De.I.C(view0, 0x7F0A074D)) != null) {  // id:layout_title
                                                                                                                                                    v = 0x7F0A0793;  // id:ll_developer
                                                                                                                                                    View view39 = De.I.C(view0, 0x7F0A0793);  // id:ll_developer
                                                                                                                                                    if(((LinearLayout)view39) != null) {
                                                                                                                                                        v = 0x7F0A096C;  // id:profile_image
                                                                                                                                                        View view40 = De.I.C(view0, 0x7F0A096C);  // id:profile_image
                                                                                                                                                        if(view40 != null) {
                                                                                                                                                            x.b(view40);
                                                                                                                                                            v = 0x7F0A0A34;  // id:scrollview_bottom_padding
                                                                                                                                                            View view41 = De.I.C(view0, 0x7F0A0A34);  // id:scrollview_bottom_padding
                                                                                                                                                            if(view41 != null) {
                                                                                                                                                                v = 0x7F0A0A78;  // id:setting_scrollview
                                                                                                                                                                View view42 = De.I.C(view0, 0x7F0A0A78);  // id:setting_scrollview
                                                                                                                                                                if(((ScrollView)view42) != null) {
                                                                                                                                                                    v = 0x7F0A0A9A;  // id:smart_playlist_desc
                                                                                                                                                                    View view43 = De.I.C(view0, 0x7F0A0A9A);  // id:smart_playlist_desc
                                                                                                                                                                    if(((MelonTextView)view43) != null) {
                                                                                                                                                                        v = 0x7F0A0BA3;  // id:title_play_settings
                                                                                                                                                                        View view44 = De.I.C(view0, 0x7F0A0BA3);  // id:title_play_settings
                                                                                                                                                                        if(((MelonTextView)view44) != null) {
                                                                                                                                                                            v = 0x7F0A0BD1;  // id:top_margin
                                                                                                                                                                            View view45 = De.I.C(view0, 0x7F0A0BD1);  // id:top_margin
                                                                                                                                                                            if(view45 != null) {
                                                                                                                                                                                this._binding = new V2(((RelativeLayout)view0), ((MelonTextView)view1), ((SettingItemView)view2), ((SettingItemView)view3), ((SettingItemView)view4), ((SettingItemView)view5), ((SettingItemView)view6), ((SettingItemView)view7), ((SettingItemView)view8), ((SettingItemView)view9), ((SettingItemView)view10), ((SettingItemView)view11), ((SettingItemView)view12), u0, ((SettingItemView)view17), ((SettingItemView)view18), ((SettingItemView)view19), ((SettingItemView)view20), ((SettingLoginView)view21), ((SettingItemView)view22), ((SettingItemView)view23), ((SettingItemView)view24), ((SettingItemView)view25), ((SettingItemView)view26), ((SettingItemView)view27), ((SettingItemView)view28), ((SettingItemView)view29), ((SettingItemView)view30), ((SettingItemView)view31), ((SettingItemView)view32), ((SettingItemView)view33), ((SettingItemView)view34), ((SettingItemView)view35), ((SettingItemView)view36), ((SettingItemView)view37), ((SettingItemView)view38), ((LinearLayout)view39), view41, ((ScrollView)view42), ((MelonTextView)view43), ((MelonTextView)view44), view45);
                                                                                                                                                                                V2 v20 = this.getBinding();
                                                                                                                                                                                q.f(v20.a, "getRoot(...)");
                                                                                                                                                                                return v20.a;
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
        RequestBuilder.newInstance(new SettingInformGuideUrlReq(this.getContext())).tag("SettingMainFragment + GuideReq").listener(new A(this, 0)).request();
        return false;
    }

    private static final void onFetchStart$lambda$6(SettingMainFragment settingMainFragment0, SettingInformGuideUrlRes settingInformGuideUrlRes0) {
        if(settingMainFragment0.isFragmentValid() && settingInformGuideUrlRes0 != null && settingInformGuideUrlRes0.isSuccessful()) {
            Response settingInformGuideUrlRes$Response0 = settingInformGuideUrlRes0.response;
            if(settingInformGuideUrlRes$Response0 != null) {
                settingMainFragment0.mFaqUrl = settingInformGuideUrlRes$Response0.guideUrl;
                settingMainFragment0.updateStreamingInfoButton();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.mScrollPositionY = this.getBinding().M.getScrollY();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        this.updateView();
        this.updateRelatedUserInfo();
        this.updateDomainInfo();
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 instanceof U) {
            int v = ((U)fragmentActivity0).getMiniPlayerHeight();
            V2 v20 = this.getBinding();
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-1, v);
            v20.L.setLayoutParams(linearLayout$LayoutParams0);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        int v = this.mScrollPositionY;
        if(v != -1) {
            bundle0.putInt("argScrollPosition", v);
        }
        bundle0.putBoolean("argScrollToNetworkOption", this.mScrollToNetworkOption);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.iloen.melon.intent.action.setting.changed.3g.usage.noti");
        intentFilter0.addAction("com.iloen.melon.intent.action.setting.changed.autoplay");
        Context context0 = this.getContext();
        if(context0 != null) {
            w.S(context0, this.mSettingStatusChangeListener, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION");
        }
        Context context1 = this.getContext();
        if(context1 != null) {
            SharedPreferences sharedPreferences0 = context1.getSharedPreferences("com.iloen.melon.tablet.Preference.SETTING", 0);
            if(sharedPreferences0 != null) {
                sharedPreferences0.registerOnSharedPreferenceChangeListener(this.mPrefListener);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            fragmentActivity0.unregisterReceiver(this.mSettingStatusChangeListener);
        }
        Context context0 = this.getContext();
        if(context0 != null) {
            SharedPreferences sharedPreferences0 = context0.getSharedPreferences("com.iloen.melon.tablet.Preference.SETTING", 0);
            if(sharedPreferences0 != null) {
                sharedPreferences0.unregisterOnSharedPreferenceChangeListener(this.mPrefListener);
            }
        }
        this.cancelRequest("SettingMainFragment + GuideReq");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            boolean z = A8.b.d();
            F8.m m0 = new F8.m(2, !z);
            if(!z) {
                m0.c = new Gd.f(13);
            }
            F8.p p0 = new F8.p(1);
            p0.g(m0);
            titleBar0.a(p0);
            titleBar0.setTitle((titleBar0.getContext() == null ? null : "설정"));
            titleBar0.f(false);
        }
        androidx.lifecycle.D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(null) {
            int label;

            {
                SettingMainFragment.this = settingMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingMainFragment.onViewCreated.2(SettingMainFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingMainFragment.onViewCreated.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.settings.SettingMainFragment.onViewCreated.2.1 settingMainFragment$onViewCreated$2$10 = new we.n(null) {
                            int label;

                            {
                                SettingMainFragment.this = settingMainFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.settings.SettingMainFragment.onViewCreated.2.1(SettingMainFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.SettingMainFragment.onViewCreated.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StateFlow stateFlow0 = SettingMainFragment.this.getSettingMainViewModel().getEnableLogger();
                                        com.iloen.melon.fragments.settings.SettingMainFragment.onViewCreated.2.1.1 settingMainFragment$onViewCreated$2$1$10 = new FlowCollector() {
                                            @Override  // kotlinx.coroutines.flow.FlowCollector
                                            public Object emit(Object object0, Continuation continuation0) {
                                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                                            }

                                            public final Object emit(boolean z, Continuation continuation0) {
                                                if(A8.b.d() && z) {
                                                    int v = ColorUtils.getColor(SettingMainFragment.this.getContext(), 0x7F0603F2);  // color:melon_green
                                                    ((MelonTextView)SettingMainFragment.this.getBinding().n.e).setTextColor(v);
                                                    return H.a;
                                                }
                                                int v1 = ColorUtils.getColor(SettingMainFragment.this.getContext(), 0x7F060163);  // color:gray700s
                                                ((MelonTextView)SettingMainFragment.this.getBinding().n.e).setTextColor(v1);
                                                return H.a;
                                            }
                                        };
                                        this.label = 1;
                                        if(stateFlow0.collect(settingMainFragment$onViewCreated$2$1$10, this) == a0) {
                                            return a0;
                                        }
                                        break;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        break;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                            }
                        };
                        this.label = 1;
                        return f0.j(SettingMainFragment.this, s.d, settingMainFragment$onViewCreated$2$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
        this.initView(view0);
        this.registerIsLoginFlow();
        this.registerSmartPlaylistUseFlow();
    }

    private static final void onViewCreated$lambda$2$lambda$1(View view0) {
        Navigator.open(new La.a());
    }

    public static H q0(List list0) {
        return SettingMainFragment.mOnItemClickListener$lambda$30$lambda$29(list0);
    }

    // 检测为 Lambda 实现
    public static void r0(SettingMainFragment settingMainFragment0) [...]

    private final void registerIsLoginFlow() {
        androidx.lifecycle.D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(null) {
            int label;

            {
                SettingMainFragment.this = settingMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1(SettingMainFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1.1 settingMainFragment$registerIsLoginFlow$1$10 = new we.n(null) {
                            int label;

                            {
                                SettingMainFragment.this = settingMainFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1.1(SettingMainFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)SettingMainFragment.this.getLoginUseCase()).n()), 1);
                                        com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1.1.1 settingMainFragment$registerIsLoginFlow$1$1$10 = new we.n(null) {
                                            boolean Z$0;
                                            int label;

                                            {
                                                SettingMainFragment.this = settingMainFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1.1.1(SettingMainFragment.this, continuation0);
                                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                            }

                                            public final Object invoke(boolean z, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.settings.SettingMainFragment.registerIsLoginFlow.1.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                boolean z = this.Z$0;
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                LogU logU0 = new LogU("SettingMainFragment");
                                                logU0.setCategory(Category.Login);
                                                logU0.setUseThreadInfo(true);
                                                LogU.debug$default(logU0, "SettingMainFragment - isLogin: " + z, null, false, 6, null);
                                                if(SettingMainFragment.this.isFragmentValid()) {
                                                    SettingMainFragment.this.updateView();
                                                    SettingMainFragment.this.updateRelatedUserInfo();
                                                }
                                                return H.a;
                                            }
                                        };
                                        this.label = 1;
                                        return FlowKt.collectLatest(flow0, settingMainFragment$registerIsLoginFlow$1$1$10, this) == a0 ? a0 : H.a;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.label = 1;
                        return f0.j(SettingMainFragment.this, s.e, settingMainFragment$registerIsLoginFlow$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    private final void registerSmartPlaylistUseFlow() {
        androidx.lifecycle.D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(null) {
            int label;

            {
                SettingMainFragment.this = settingMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1(SettingMainFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1.1 settingMainFragment$registerSmartPlaylistUseFlow$1$10 = new we.n(null) {
                            int label;

                            {
                                SettingMainFragment.this = settingMainFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1.1(SettingMainFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Flow flow0 = FlowKt.drop(FlowKt.filterNotNull(((com.melon.playlist.b)((d3)SettingMainFragment.this.playlistManager).a).r), 1);
                                        com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1.1.1 settingMainFragment$registerSmartPlaylistUseFlow$1$1$10 = new we.n(null) {
                                            boolean Z$0;
                                            int label;

                                            {
                                                SettingMainFragment.this = settingMainFragment0;
                                                super(2, continuation0);
                                            }

                                            @Override  // oe.a
                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                Continuation continuation1 = new com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1.1.1(SettingMainFragment.this, continuation0);
                                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                                return continuation1;
                                            }

                                            @Override  // we.n
                                            public Object invoke(Object object0, Object object1) {
                                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                            }

                                            public final Object invoke(boolean z, Continuation continuation0) {
                                                return ((com.iloen.melon.fragments.settings.SettingMainFragment.registerSmartPlaylistUseFlow.1.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                            }

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                boolean z = this.Z$0;
                                                if(this.label != 0) {
                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                }
                                                d5.n.D(object0);
                                                LogU.debug$default(SettingMainFragment.this.log, "isUseSmartPlaylist changed to " + z, null, false, 6, null);
                                                if(SettingMainFragment.this.isFragmentValid()) {
                                                    SettingMainFragment.this.updateView();
                                                }
                                                return H.a;
                                            }
                                        };
                                        this.label = 1;
                                        return FlowKt.collectLatest(flow0, settingMainFragment$registerSmartPlaylistUseFlow$1$1$10, this) == a0 ? a0 : H.a;
                                    }
                                    case 1: {
                                        d5.n.D(object0);
                                        return H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        this.label = 1;
                        return f0.j(SettingMainFragment.this, s.e, settingMainFragment$registerSmartPlaylistUseFlow$1$10, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    // 检测为 Lambda 实现
    public static void s0(SettingMainFragment settingMainFragment0, MelonTextPopup melonTextPopup0, DialogInterface dialogInterface0, int v) [...]

    public final void setDeviceData(@NotNull DeviceData deviceData0) {
        q.g(deviceData0, "<set-?>");
        this.deviceData = deviceData0;
    }

    private final void setLocationPermitSubText(boolean z) {
        if(this.getContext() != null) {
            if(z) {
                V2 v20 = this._binding;
                if(v20 != null) {
                    SettingItemView settingItemView0 = v20.q;
                    if(settingItemView0 != null) {
                        settingItemView0.setSubText("동의완료");
                    }
                }
            }
            else {
                V2 v21 = this._binding;
                if(v21 != null) {
                    SettingItemView settingItemView1 = v21.q;
                    if(settingItemView1 != null) {
                        settingItemView1.setSubText("동의필요");
                    }
                }
            }
        }
    }

    public final void setLoginUseCase(@NotNull k k0) {
        q.g(k0, "<set-?>");
        this.loginUseCase = k0;
    }

    public final void setSimpleAccountUseCase(@NotNull o o0) {
        q.g(o0, "<set-?>");
        this.simpleAccountUseCase = o0;
    }

    public static void t0(SettingMainFragment settingMainFragment0, View view0, boolean z) {
        SettingMainFragment.initView$lambda$21$lambda$19$lambda$18(settingMainFragment0, view0, z);
    }

    public static void u0(String s) {
        SettingMainFragment.mOnItemClickListener$lambda$30$lambda$29$lambda$28(s);
    }

    private final void updateDeviceRegisterInfo(boolean z) {
        String s;
        V2 v20 = this._binding;
        if(v20 != null) {
            SettingItemView settingItemView0 = v20.B;
            if(settingItemView0 != null) {
                if(z) {
                    s = "";
                }
                else {
                    s = this.getString(0x7F1309B8);  // string:setting_nonregistered "미등록"
                    q.f(s, "getString(...)");
                }
                settingItemView0.setSubText(s);
            }
        }
    }

    private final void updateDomainInfo() {
        int v;
        if(A8.b.d()) {
            return;
        }
        String s = ServerPhase.INSTANCE.getDomainPrefix();
        if("rel-".equals(s)) {
            v = 0x7F1309CA;  // string:setting_server_phase_rel_domain "REL 서버"
        }
        else if("cbt-".equals(s)) {
            v = 0x7F1309C7;  // string:setting_server_phase_cbt_domain "CBT 서버"
        }
        else {
            v = "sandbox-".equals(s) ? 0x7F1309CB : 0x7F1309C9;  // string:setting_server_phase_sandbox_domain "SANDBOX 서버"
        }
        this.getBinding().E.setSubTextColor(0x7F06045C);  // color:red400s
        V2 v20 = this.getBinding();
        String s1 = this.getString(v);
        v20.E.setSubText(s1);
    }

    private final void updateNetworkUsingView() {
        boolean z = this.getDeviceData().i() ? false : MelonSettingInfo.isUseDataNetwork();
        this.getBinding().v.setRadioOnOff(z);
    }

    private final void updateRelatedUserInfo() {
        if(!this.isLoginUser()) {
            this.updateDeviceRegisterInfo(true);
            return;
        }
        RequestBuilder.newInstance(new DeviceInformDeviceCheckReq(this.getContext(), CallerType.SET)).tag("SettingMainFragment").listener(new A(this, 1)).request();
        com.iloen.melon.fragments.settings.SettingMainFragment.updateRelatedUserInfo.2 settingMainFragment$updateRelatedUserInfo$20 = new V8.c() {
            @Override  // V8.c
            public void onLocationPermission(boolean z) {
                SettingMainFragment.this.setLocationPermitSubText(z);
                MelonPrefs.getInstance().setBoolean("USER_LOCATION_PERMISSION", z);
            }

            @Override  // V8.c
            public void onLocationReqError() {
                boolean z = MelonSettingInfo.getLocationPermission();
                SettingMainFragment.this.setLocationPermitSubText(z);
            }
        };
        if(!((e0)va.o.a()).m()) {
            return;
        }
        RequestBuilder.newInstance(new AuthLocationReq(this.getContext())).tag("LocationPermissionHelper").listener(new V8.b(settingMainFragment$updateRelatedUserInfo$20, this)).errorListener(new V8.a(settingMainFragment$updateRelatedUserInfo$20, this)).request();
    }

    private static final void updateRelatedUserInfo$lambda$24(SettingMainFragment settingMainFragment0, DeviceInformDeviceCheckRes deviceInformDeviceCheckRes0) {
        if(deviceInformDeviceCheckRes0 != null && deviceInformDeviceCheckRes0.isSuccessful(false)) {
            com.iloen.melon.net.v4x.response.DeviceInformDeviceCheckRes.Response deviceInformDeviceCheckRes$Response0 = deviceInformDeviceCheckRes0.response;
            if(deviceInformDeviceCheckRes$Response0 != null) {
                boolean z = ProtocolUtils.parseBoolean(deviceInformDeviceCheckRes$Response0.deviceYn);
                ((e0)settingMainFragment0.getLoginUseCase()).A(z);
                settingMainFragment0.updateDeviceRegisterInfo(z);
            }
        }
    }

    private final void updateSmartPlaylistDesc() {
        this.getBinding().N.setText((q.b(((d3)this.playlistManager).m(), Boolean.TRUE) ? this.getString(0x7F130A2C) : this.getString(0x7F130A2B)));  // string:smart_playlist_setting_popup_connnected_playlist_desc_when_on "OFF시, 현재 단말에 
                                                                                                                                                     // 있는 재생목록 기준으로 전환됩니다.\n스마트 재생목록은 서버에 저장되어 있으니 언제든 ON 해보세요."
    }

    private final void updateStreamingInfoButton() {
        boolean z = TextUtils.isEmpty(this.mFaqUrl);
        this.getBinding().O.setCompoundDrawablesWithIntrinsicBounds(0, 0, (z ? 0 : 0x7F080475), 0);  // drawable:ic_info_15_tint_gray500s
        String s = null;
        ViewUtils.setOnClickListener(this.getBinding().O, (z ? null : this.mOnItemClickListener));
        MelonTextView melonTextView0 = this.getBinding().O;
        if(this.getContext() != null) {
            s = "재생 품질";
        }
        ViewUtils.setContentDescriptionWithButtonClassName(melonTextView0, s);
    }

    private final void updateVersionInfoView() {
        String s = AppUtils.getVersionName(this.getContext());
        V2 v20 = this.getBinding();
        String s1 = this.getString(0x7F1309E9);  // string:setting_title_info_current_version "%1$s 버전"
        q.f(s1, "getString(...)");
        String s2 = String.format(s1, Arrays.copyOf(new Object[]{s}, 1));
        ((MelonTextView)v20.n.b).setText(s2);
        AppVersionInfo appVersionInfo0 = MelonSettingInfo.getAppVersionInfo();
        if((q.b((appVersionInfo0 == null ? null : appVersionInfo0.a), "1") || q.b((appVersionInfo0 == null ? null : appVersionInfo0.a), "2")) && !Tf.o.H0(appVersionInfo0.d)) {
            V2 v21 = this.getBinding();
            String s3 = this.getString(0x7F1309EB);  // string:setting_title_info_version_update "%s 업데이트"
            q.f(s3, "getString(...)");
            String s4 = String.format(s3, Arrays.copyOf(new Object[]{appVersionInfo0.b}, 1));
            ((MelonTextView)v21.n.e).setText(s4);
            Drawable drawable0 = ((MelonTextView)v21.n.e).getResources().getDrawable(0x7F080918, null);  // drawable:shape_round13_5_stroke_0_5dp_gray200s
            ((MelonTextView)v21.n.e).setBackground(drawable0);
            int v = ScreenUtils.dipToPixel(((MelonTextView)v21.n.e).getContext(), 10.0f);
            ((MelonTextView)v21.n.e).setPadding(v, 0, v, 0);
            com.iloen.melon.fragments.settings.q q0 = new com.iloen.melon.fragments.settings.q(2, appVersionInfo0, this);
            ((MelonTextView)v21.n.e).setOnClickListener(q0);
            ((MelonImageView)this.getBinding().n.d).setVisibility(0);
        }
    }

    private static final void updateVersionInfoView$lambda$23$lambda$22(AppVersionInfo appVersionInfo0, SettingMainFragment settingMainFragment0, View view0) {
        try {
            Intent intent0 = new Intent("android.intent.action.VIEW");
            intent0.setData(Uri.parse(appVersionInfo0.d));
            settingMainFragment0.startActivity(intent0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            LogU.Companion.w("SettingMainFragment", "updateVersionInfoView() error:" + activityNotFoundException0);
            Navigator.openMarket("com.iloen.melon");
        }
    }

    private final void updateView() {
        String s3;
        c1 c10;
        if(((e0)this.getLoginUseCase()).m()) {
            if(!e1.u.I(((e0)this.getLoginUseCase()).j())) {
                c10 = this.getSimpleAccountUseCase().d() ? c1.b : c1.c;
            }
            else if(this.getSimpleAccountUseCase().d()) {
                c10 = c1.e;
            }
            else {
                c10 = c1.d;
            }
            this.getBinding().s.setViewType(c10);
            this.getBinding().s.setUserId("");
        }
        else {
            this.getBinding().s.setViewType(c1.a);
        }
        this.updateDeviceRegisterInfo(((e0)this.getLoginUseCase()).j().getMacOk());
        this.updateVersionInfoView();
        this.getBinding().A.a(MelonSettingInfo.getUsePushAlert() || MelonSettingInfo.getUseMarketingPushAlert());
        AddPosition addPosition0 = MelonSettingInfo.getPlayListAddPosition();
        q.f(addPosition0, "getPlayListAddPosition(...)");
        switch(addPosition0.ordinal()) {
            case 1: {
                V2 v21 = this.getBinding();
                String s1 = this.getString(0x7F13092A);  // string:setting_addposition_end "맨 끝"
                v21.z.setSubText(s1);
                break;
            }
            case 2: {
                V2 v22 = this.getBinding();
                String s2 = this.getString(0x7F130929);  // string:setting_addposition_after "재생 곡 뒤"
                v22.z.setSubText(s2);
                break;
            }
            default: {
                V2 v20 = this.getBinding();
                String s = this.getString(0x7F13092B);  // string:setting_addposition_first "맨 처음"
                v20.z.setSubText(s);
            }
        }
        V2 v23 = this.getBinding();
        boolean z = MelonSettingInfo.isUseLockScreen();
        v23.r.setRadioOnOff(z);
        V2 v24 = this.getBinding();
        boolean z1 = this.isEnabledStopReservation();
        v24.C.a(z1);
        this.updateNetworkUsingView();
        int v = MelonThemeUtils.getCurrentTheme();
        if(v == 0) {
            s3 = this.getString(0x7F1309C6);  // string:setting_screen_white "화이트"
        }
        else {
            switch(v) {
                case 1: {
                    s3 = this.getString(0x7F1309C3);  // string:setting_screen_black "블랙"
                    break;
                }
                case 2: {
                    s3 = this.getString(0x7F1309C5);  // string:setting_screen_follow_system "시스템 설정"
                    break;
                }
                default: {
                    s3 = this.getString(0x7F1309C3);  // string:setting_screen_black "블랙"
                }
            }
        }
        q.d(s3);
        this.getBinding().D.setSubText(s3);
        V2 v25 = this.getBinding();
        boolean z2 = this.isLoginUser();
        ViewUtils.showWhen(v25.u, z2);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(null) {
            Object L$0;
            int label;

            {
                SettingMainFragment.this = settingMainFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.settings.SettingMainFragment.updateView.1(SettingMainFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.settings.SettingMainFragment.updateView.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                SettingItemView settingItemView1;
                ne.a a0 = ne.a.a;
                boolean z = true;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        SettingItemView settingItemView0 = SettingMainFragment.this.getBinding().G;
                        if(SettingMainFragment.this.isLoginUser()) {
                            B b0 = ListenableFutureKt.future$default(((d3)SettingMainFragment.this.playlistManager).b, null, null, new D2(((d3)SettingMainFragment.this.playlistManager), null), 3, null);
                            this.L$0 = settingItemView0;
                            this.label = 1;
                            Object object1 = ListenableFutureKt.await(b0, this);
                            if(object1 == a0) {
                                return a0;
                            }
                            settingItemView1 = settingItemView0;
                            object0 = object1;
                            goto label_21;
                        }
                        else {
                            z = false;
                            settingItemView1 = settingItemView0;
                        }
                        break;
                    }
                    case 1: {
                        settingItemView1 = (SettingItemView)this.L$0;
                        d5.n.D(object0);
                    label_21:
                        if(!((Boolean)object0).booleanValue()) {
                            z = false;
                        }
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                settingItemView1.setRadioOnOff(z);
                return H.a;
            }
        }, 3, null);
    }
}

