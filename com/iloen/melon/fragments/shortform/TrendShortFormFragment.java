package com.iloen.melon.fragments.shortform;

import De.d;
import H8.i;
import J8.l1;
import S2.c;
import Tf.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.n;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.b;
import androidx.viewpager2.widget.e;
import c2.b0;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.f1;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment.OnDismissListener;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response;
import com.iloen.melon.net.v6x.response.TrendShortFormRes;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.data.Meta.Builder;
import d3.g;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import ie.k;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.I;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.h;
import va.e0;
import we.a;

@Metadata(d1 = {"\u0000\u00F8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0086\u0001\b\u0007\u0018\u0000 \u008C\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u008C\u0001B\u0007\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0010\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u000F\u0010\u0011\u001A\u00020\fH\u0017\u00A2\u0006\u0004\b\u0011\u0010\u0005J+\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u000F\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0019\u001A\u00020\u00162\b\u0010\u000F\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u001CH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0011\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u000F\u0010$\u001A\u00020#H\u0016\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010\'\u001A\u00020&H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010*\u001A\u00020\f2\u0006\u0010)\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b*\u0010\u000EJ\u001D\u0010.\u001A\b\u0012\u0002\b\u0003\u0018\u00010-2\u0006\u0010,\u001A\u00020+H\u0014\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b0\u0010\u0005J\u000F\u00101\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b1\u0010\u0005J-\u00108\u001A\u00020&2\b\u00103\u001A\u0004\u0018\u0001022\b\u00105\u001A\u0004\u0018\u0001042\b\u00107\u001A\u0004\u0018\u000106H\u0014\u00A2\u0006\u0004\b8\u00109J\u000F\u0010:\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b:\u0010\u0005J\u001B\u0010=\u001A\u00020\u001C*\u00020;2\u0006\u0010<\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\b=\u0010>J\u001B\u0010?\u001A\u00020\u001C*\u00020;2\u0006\u0010<\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\b?\u0010>J\u000F\u0010@\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b@\u0010\u0005J\u0017\u0010C\u001A\u00020\f2\u0006\u0010B\u001A\u00020AH\u0002\u00A2\u0006\u0004\bC\u0010DJ\u0017\u0010F\u001A\u00020\f2\u0006\u0010E\u001A\u00020&H\u0002\u00A2\u0006\u0004\bF\u0010GJ\u000F\u0010H\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bH\u0010\u0005J\u000F\u0010I\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bI\u0010\u0005J\u000F\u0010J\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bJ\u0010\u0005J\u0019\u0010K\u001A\u0004\u0018\u0001062\u0006\u0010<\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\bK\u0010LJ\u0019\u0010N\u001A\u00020&2\b\u0010M\u001A\u0004\u0018\u000106H\u0002\u00A2\u0006\u0004\bN\u0010OJ\u001D\u0010S\u001A\u00020\f2\f\u0010R\u001A\b\u0012\u0004\u0012\u00020Q0PH\u0002\u00A2\u0006\u0004\bS\u0010TJ\u0017\u0010V\u001A\u00020\f2\u0006\u0010U\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\bV\u0010\u001FJ\u000F\u0010W\u001A\u00020\fH\u0002\u00A2\u0006\u0004\bW\u0010\u0005J\u001F\u0010Z\u001A\u00020\f2\u0006\u0010X\u001A\u00020\u001C2\u0006\u0010Y\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\bZ\u0010[J\u000F\u0010\\\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\\\u0010\u0005R\u0014\u0010^\u001A\u00020]8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b^\u0010_R\"\u0010a\u001A\u00020`8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\ba\u0010b\u001A\u0004\bc\u0010d\"\u0004\be\u0010fR\u0016\u0010h\u001A\u00020g8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010k\u001A\u00020j8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010n\u001A\u00020m8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010q\u001A\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010s\u001A\u00020\u001C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001A\u0002068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bu\u0010vR(\u0010y\u001A\u0004\u0018\u00010w2\b\u0010x\u001A\u0004\u0018\u00010w8\u0002@BX\u0082\u000E\u00A2\u0006\f\n\u0004\by\u0010z\"\u0004\b{\u0010|R\u001D\u0010\u0081\u0001\u001A\u00020}8FX\u0086\u0084\u0002\u00A2\u0006\r\n\u0004\b~\u0010\u007F\u001A\u0005\b\b\u0010\u0080\u0001R\u001C\u0010\u0083\u0001\u001A\u0005\u0018\u00010\u0082\u00018\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0085\u0001\u001A\u00030\u0082\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001A\u00030\u0086\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008A\u0001\u001A\u00030\u0089\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u008A\u0001\u0010\u008B\u0001\u00A8\u0006\u008D\u0001"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormFragment;", "Lcom/iloen/melon/fragments/FetcherBaseFragment;", "Landroid/media/AudioManager$OnAudioFocusChangeListener;", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment$OnDismissListener;", "<init>", "()V", "Lv8/a;", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes;", "getViewModel", "()Lv8/a;", "Landroid/os/Bundle;", "outState", "Lie/H;", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "onStart", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "focusChange", "onAudioFocusChange", "(I)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/custom/f1;", "getInsetHandlingType", "()Lcom/iloen/melon/custom/f1;", "", "isScreenLandscapeSupported", "()Z", "inState", "onRestoreInstanceState", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "onPause", "onStop", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "dismiss", "Landroidx/viewpager2/widget/ViewPager2;", "position", "getStartPosition", "(Landroidx/viewpager2/widget/ViewPager2;I)I", "getTabPosition", "registerIsLoginFlow", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent;", "event", "handleClickEvent", "(Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel$ClickEvent;)V", "isEnable", "startSoundAnim", "(Z)V", "initAudioFocus", "requestAudioFocus", "abandonAudioFocus", "getSelectedSlotUiType", "(I)Ljava/lang/String;", "uiType", "isSoundSupported", "(Ljava/lang/String;)Z", "", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "list", "initPager", "(Ljava/util/List;)V", "defaultPage", "goMatchedSlotId", "clickSoundBtn", "beforePos", "afterPos", "sendSwipeLog", "(II)V", "animateOnBoarding", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Landroid/media/AudioManager;", "audioManager", "Landroid/media/AudioManager;", "Landroid/media/AudioFocusRequest;", "audioFocusRequest", "Landroid/media/AudioFocusRequest;", "LJ8/l1;", "viewBinding", "LJ8/l1;", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewPagerAdapter;", "viewPagerAdapter", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewPagerAdapter;", "selectedPosition", "I", "slotId", "Ljava/lang/String;", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;", "value", "bottomSheetBaseFragment", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;", "setBottomSheetBaseFragment", "(Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;)V", "Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel;", "viewModel$delegate", "Lie/j;", "()Lcom/iloen/melon/fragments/shortform/TrendShortFormViewModel;", "viewModel", "Landroid/content/BroadcastReceiver;", "becomingNoisyAll", "Landroid/content/BroadcastReceiver;", "headSetReceiver", "com/iloen/melon/fragments/shortform/TrendShortFormFragment$viewPagerCallBack$1", "viewPagerCallBack", "Lcom/iloen/melon/fragments/shortform/TrendShortFormFragment$viewPagerCallBack$1;", "Landroid/animation/ValueAnimator;", "onboardingAnimator", "Landroid/animation/ValueAnimator;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendShortFormFragment extends Hilt_TrendShortFormFragment implements AudioManager.OnAudioFocusChangeListener, OnDismissListener {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001A\u00020\n2\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SLOT_ID", "RESOURCE_SOUND_ON", "RESOURCE_SOUND_OFF", "newInstance", "Lcom/iloen/melon/fragments/shortform/TrendShortFormFragment;", "slotId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final TrendShortFormFragment newInstance(@Nullable String s) {
            Bundle bundle0 = Y.b("argSlotId", s);
            TrendShortFormFragment trendShortFormFragment0 = new TrendShortFormFragment();
            trendShortFormFragment0.setArguments(bundle0);
            return trendShortFormFragment0;
        }

        public static TrendShortFormFragment newInstance$default(Companion trendShortFormFragment$Companion0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = "";
            }
            return trendShortFormFragment$Companion0.newInstance(s);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[h.values().length];
            try {
                arr_v[3] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[0] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[1] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[2] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_SLOT_ID = "argSlotId";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String RESOURCE_SOUND_OFF = "animation/ic_common_sound_off.json";
    @NotNull
    private static final String RESOURCE_SOUND_ON = "animation/ic_common_sound_on.json";
    @NotNull
    private static final String TAG = "TrendShortFormFragment";
    private AudioFocusRequest audioFocusRequest;
    private AudioManager audioManager;
    @Nullable
    private BroadcastReceiver becomingNoisyAll;
    @Nullable
    private MelonBottomSheetBaseFragment bottomSheetBaseFragment;
    @NotNull
    private final BroadcastReceiver headSetReceiver;
    @NotNull
    private final LogU log;
    @NotNull
    private final ValueAnimator onboardingAnimator;
    @Inject
    public z playerUseCase;
    private int selectedPosition;
    @NotNull
    private String slotId;
    private l1 viewBinding;
    @NotNull
    private final j viewModel$delegate;
    @Nullable
    private TrendShortFormViewPagerAdapter viewPagerAdapter;
    @NotNull
    private final com.iloen.melon.fragments.shortform.TrendShortFormFragment.viewPagerCallBack.1 viewPagerCallBack;

    static {
        TrendShortFormFragment.Companion = new Companion(null);
        TrendShortFormFragment.$stable = 8;
    }

    public TrendShortFormFragment() {
        LogU logU0 = new LogU("TrendShortFormFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
        this.selectedPosition = -1;
        this.slotId = "";
        com.iloen.melon.fragments.shortform.TrendShortFormFragment.special..inlined.viewModels.default.2 trendShortFormFragment$special$$inlined$viewModels$default$20 = new a() {
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
        j j0 = g.P(k.c, trendShortFormFragment$special$$inlined$viewModels$default$20);
        d d0 = I.a.b(TrendShortFormViewModel.class);
        com.iloen.melon.fragments.shortform.TrendShortFormFragment.special..inlined.viewModels.default.3 trendShortFormFragment$special$$inlined$viewModels$default$30 = new a() {
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
        com.iloen.melon.fragments.shortform.TrendShortFormFragment.special..inlined.viewModels.default.4 trendShortFormFragment$special$$inlined$viewModels$default$40 = new a(j0) {
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
        this.viewModel$delegate = new i(d0, trendShortFormFragment$special$$inlined$viewModels$default$30, new a(j0) {
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
        }, trendShortFormFragment$special$$inlined$viewModels$default$40);
        this.becomingNoisyAll = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "intent");
                if("android.media.AUDIO_BECOMING_NOISY".equals(intent0.getAction())) {
                    LogU.debug$default(TrendShortFormFragment.access$getLog$p(TrendShortFormFragment.this), "becomingNoisyAll - ACTION_AUDIO_BECOMING_NOISY", null, false, 6, null);
                    TrendShortFormFragment.this.getViewModel().setSoundFlag(false);
                }
            }
        };
        this.headSetReceiver = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                q.g(context0, "context");
                q.g(intent0, "intent");
                if(q.b(intent0.getAction(), "android.intent.action.HEADSET_PLUG")) {
                    switch(intent0.getIntExtra("state", -1)) {
                        case 0: {
                            LogU.debug$default(TrendShortFormFragment.access$getLog$p(TrendShortFormFragment.this), "headSetReceiver - Headset unplugged", null, false, 6, null);
                            TrendShortFormFragment.this.getViewModel().setSoundFlag(false);
                            break;
                        }
                        case 1: {
                            LogU.debug$default(TrendShortFormFragment.access$getLog$p(TrendShortFormFragment.this), "headSetReceiver - Headset plugged", null, false, 6, null);
                        }
                    }
                }
            }
        };
        this.viewPagerCallBack = new androidx.viewpager2.widget.j() {
            @Override  // androidx.viewpager2.widget.j
            public void onPageSelected(int v) {
                String s = TrendShortFormFragment.access$getSelectedSlotUiType(TrendShortFormFragment.this, v);
                if(TrendShortFormFragment.access$isSoundSupported(TrendShortFormFragment.this, s)) {
                    l1 l10 = TrendShortFormFragment.access$getViewBinding$p(TrendShortFormFragment.this);
                    if(l10 != null) {
                        l10.c.setVisibility(0);
                        goto label_11;
                    }
                    q.m("viewBinding");
                    throw null;
                }
                l1 l11 = TrendShortFormFragment.access$getViewBinding$p(TrendShortFormFragment.this);
                if(l11 != null) {
                    l11.c.setVisibility(8);
                label_11:
                    if(TrendShortFormFragment.access$getSelectedPosition$p(TrendShortFormFragment.this) > 0 && TrendShortFormFragment.access$getSelectedPosition$p(TrendShortFormFragment.this) != v) {
                        TrendShortFormFragment trendShortFormFragment0 = TrendShortFormFragment.this;
                        l1 l12 = TrendShortFormFragment.access$getViewBinding$p(trendShortFormFragment0);
                        if(l12 == null) {
                            q.m("viewBinding");
                            throw null;
                        }
                        q.f(l12.f, "viewPager");
                        int v1 = TrendShortFormFragment.access$getTabPosition(trendShortFormFragment0, l12.f, TrendShortFormFragment.access$getSelectedPosition$p(TrendShortFormFragment.this));
                        TrendShortFormFragment trendShortFormFragment1 = TrendShortFormFragment.this;
                        l1 l13 = TrendShortFormFragment.access$getViewBinding$p(trendShortFormFragment1);
                        if(l13 == null) {
                            q.m("viewBinding");
                            throw null;
                        }
                        q.f(l13.f, "viewPager");
                        int v2 = TrendShortFormFragment.access$getTabPosition(trendShortFormFragment1, l13.f, v);
                        TrendShortFormFragment.access$sendSwipeLog(TrendShortFormFragment.this, v1, v2);
                        if(v1 == TrendShortFormFragment.this.getViewModel().getListSize() - 1 && v2 == 0) {
                            ToastManager.show(0x7F131099);  // string:trend_scroll_done_msg "오늘의 트렌드를 모두 확인했어요."
                            TrendShortFormFragment.access$setSelectedPosition$p(TrendShortFormFragment.this, v);
                            return;
                        }
                    }
                    TrendShortFormFragment.access$setSelectedPosition$p(TrendShortFormFragment.this, v);
                    return;
                }
                q.m("viewBinding");
                throw null;
            }
        };
        this.onboardingAnimator = new ValueAnimator();

        @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001A\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/m0;", "VM", "Landroidx/fragment/app/I;", "invoke", "()Landroidx/fragment/app/I;", "<anonymous>"}, k = 3, mv = {2, 2, 0})
        public final class com.iloen.melon.fragments.shortform.TrendShortFormFragment.special..inlined.viewModels.default.1 extends r implements a {
            final androidx.fragment.app.I $this_viewModels;

            public com.iloen.melon.fragments.shortform.TrendShortFormFragment.special..inlined.viewModels.default.1(androidx.fragment.app.I i0) {
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

    public static void L(F f0, TrendShortFormFragment trendShortFormFragment0, ValueAnimator valueAnimator0) {
        TrendShortFormFragment.animateOnBoarding$lambda$14(f0, trendShortFormFragment0, valueAnimator0);
    }

    private final void abandonAudioFocus() {
        AudioManager audioManager0 = this.audioManager;
        if(audioManager0 != null) {
            AudioFocusRequest audioFocusRequest0 = this.audioFocusRequest;
            if(audioFocusRequest0 != null) {
                int v = audioManager0.abandonAudioFocusRequest(audioFocusRequest0);
                Y.t("abandonAudioFocus() result : ", v, LogU.Companion, "TrendShortFormFragment");
                if(1 == v) {
                    this.getViewModel().setSoundFlag(false);
                }
                return;
            }
            q.m("audioFocusRequest");
            throw null;
        }
        q.m("audioManager");
        throw null;
    }

    public static final LogU access$getLog$p(TrendShortFormFragment trendShortFormFragment0) {
        return trendShortFormFragment0.log;
    }

    public static final int access$getSelectedPosition$p(TrendShortFormFragment trendShortFormFragment0) {
        return trendShortFormFragment0.selectedPosition;
    }

    public static final String access$getSelectedSlotUiType(TrendShortFormFragment trendShortFormFragment0, int v) {
        return trendShortFormFragment0.getSelectedSlotUiType(v);
    }

    public static final int access$getTabPosition(TrendShortFormFragment trendShortFormFragment0, ViewPager2 viewPager20, int v) {
        return trendShortFormFragment0.getTabPosition(viewPager20, v);
    }

    public static final boolean access$isSoundSupported(TrendShortFormFragment trendShortFormFragment0, String s) {
        return trendShortFormFragment0.isSoundSupported(s);
    }

    public static final void access$sendSwipeLog(TrendShortFormFragment trendShortFormFragment0, int v, int v1) {
        trendShortFormFragment0.sendSwipeLog(v, v1);
    }

    public static final void access$setSelectedPosition$p(TrendShortFormFragment trendShortFormFragment0, int v) {
        trendShortFormFragment0.selectedPosition = v;
    }

    private final void animateOnBoarding() {
        l1 l10 = this.viewBinding;
        if(l10 != null) {
            j0 j00 = l10.f.getAdapter();
            int v = j00 == null ? 0 : j00.getItemCount();
            TrendOnBoardingFlag trendOnBoardingFlag0 = TrendOnBoardingFlag.INSTANCE;
            if(v > 0) {
                trendOnBoardingFlag0.setFlag(true);
                int v1 = ScreenUtils.dipToPixel(this.getContext(), 106.0f);
                F f0 = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
                l1 l11 = this.viewBinding;
                if(l11 == null) {
                    q.m("viewBinding");
                    throw null;
                }
                l11.f.setUserInputEnabled(false);
                if(!this.onboardingAnimator.isRunning()) {
                    this.onboardingAnimator.removeAllUpdateListeners();
                    this.onboardingAnimator.removeAllListeners();
                    this.onboardingAnimator.setIntValues(new int[]{0, -v1});
                    this.onboardingAnimator.setDuration(500L);
                    this.onboardingAnimator.setRepeatCount(1);
                    this.onboardingAnimator.setRepeatMode(2);
                    b0 b00 = new b0(3, f0, this);
                    this.onboardingAnimator.addUpdateListener(b00);
                    com.iloen.melon.fragments.shortform.TrendShortFormFragment.animateOnBoarding.2 trendShortFormFragment$animateOnBoarding$20 = new AnimatorListenerAdapter() {
                        @Override  // android.animation.AnimatorListenerAdapter
                        public void onAnimationEnd(Animator animator0) {
                            q.g(animator0, "animation");
                            this.a = 0;
                            l1 l10 = TrendShortFormFragment.this.viewBinding;
                            if(l10 != null) {
                                if(l10.f.n.b.m) {
                                    l1 l11 = TrendShortFormFragment.this.viewBinding;
                                    if(l11 == null) {
                                        q.m("viewBinding");
                                        throw null;
                                    }
                                    b b0 = l11.f.n;
                                    e e0 = b0.b;
                                    if(e0.m) {
                                        e0.m = false;
                                        e0.e();
                                        androidx.viewpager2.widget.d d0 = e0.g;
                                        if(d0.c == 0) {
                                            int v = d0.b;
                                            if(v != e0.h) {
                                                e0.a(v);
                                            }
                                            e0.b(0);
                                            e0.c();
                                        }
                                        else {
                                            e0.b(2);
                                        }
                                        VelocityTracker velocityTracker0 = b0.d;
                                        velocityTracker0.computeCurrentVelocity(1000, ((float)b0.e));
                                        int v1 = (int)velocityTracker0.getXVelocity();
                                        int v2 = (int)velocityTracker0.getYVelocity();
                                        if(!b0.c.fling(v1, v2)) {
                                            ViewPager2 viewPager20 = b0.a;
                                            View view0 = viewPager20.k.e(viewPager20.g);
                                            if(view0 != null) {
                                                int[] arr_v = viewPager20.k.b(viewPager20.g, view0);
                                                int v3 = arr_v[0];
                                                if(v3 != 0 || arr_v[1] != 0) {
                                                    viewPager20.j.smoothScrollBy(v3, arr_v[1]);
                                                }
                                            }
                                        }
                                    }
                                }
                                l1 l12 = TrendShortFormFragment.this.viewBinding;
                                if(l12 != null) {
                                    l12.f.setUserInputEnabled(true);
                                    return;
                                }
                                q.m("viewBinding");
                                throw null;
                            }
                            q.m("viewBinding");
                            throw null;
                        }

                        @Override  // android.animation.AnimatorListenerAdapter
                        public void onAnimationRepeat(Animator animator0) {
                            q.g(animator0, "animation");
                        }

                        @Override  // android.animation.AnimatorListenerAdapter
                        public void onAnimationStart(Animator animator0) {
                            q.g(animator0, "animation");
                        }
                    };
                    this.onboardingAnimator.addListener(trendShortFormFragment$animateOnBoarding$20);
                    this.onboardingAnimator.setStartDelay(1000L);
                    this.onboardingAnimator.start();
                    return;
                }
            }
            return;
        }
        q.m("viewBinding");
        throw null;
    }

    private static final void animateOnBoarding$lambda$14(F f0, TrendShortFormFragment trendShortFormFragment0, ValueAnimator valueAnimator0) {
        int v5;
        q.g(valueAnimator0, "animation");
        Object object0 = valueAnimator0.getAnimatedValue();
        q.e(object0, "null cannot be cast to non-null type kotlin.Int");
        int v = (int)(((Integer)object0));
        int v1 = v - f0.a;
        f0.a = v;
        l1 l10 = trendShortFormFragment0.viewBinding;
        if(l10 != null) {
            b b0 = l10.f.n;
            e e0 = b0.b;
            int v2 = 0;
            boolean z = true;
            if(!e0.m) {
                if(l10 != null) {
                    if(e0.f == 1) {
                        return;
                    }
                    b0.g = 0;
                    b0.f = 0.0f;
                    b0.h = SystemClock.uptimeMillis();
                    VelocityTracker velocityTracker0 = b0.d;
                    if(velocityTracker0 == null) {
                        b0.d = VelocityTracker.obtain();
                        b0.e = ViewConfiguration.get(b0.a.getContext()).getScaledMaximumFlingVelocity();
                    }
                    else {
                        velocityTracker0.clear();
                    }
                    e0.e = 4;
                    e0.d(true);
                    if(e0.f != 0) {
                        b0.c.stopScroll();
                    }
                    MotionEvent motionEvent0 = MotionEvent.obtain(b0.h, b0.h, 0, 0.0f, 0.0f, 0);
                    b0.d.addMovement(motionEvent0);
                    motionEvent0.recycle();
                    goto label_34;
                }
                q.m("viewBinding");
                throw null;
            }
        label_34:
            l1 l11 = trendShortFormFragment0.viewBinding;
            if(l11 != null) {
                b b1 = l11.f.n;
                if(!b1.b.m) {
                    return;
                }
                float f1 = b1.f - ((float)v1);
                b1.f = f1;
                int v3 = Math.round(f1 - ((float)b1.g));
                b1.g += v3;
                long v4 = SystemClock.uptimeMillis();
                if(b1.a.getOrientation() == 0) {
                    v5 = v3;
                }
                else {
                    z = false;
                    v5 = 0;
                }
                if(!z) {
                    v2 = v3;
                }
                float f2 = 0.0f;
                float f3 = z ? b1.f : 0.0f;
                if(!z) {
                    f2 = b1.f;
                }
                b1.c.scrollBy(v5, v2);
                MotionEvent motionEvent1 = MotionEvent.obtain(b1.h, v4, 2, f3, f2, 0);
                b1.d.addMovement(motionEvent1);
                motionEvent1.recycle();
                return;
            }
            q.m("viewBinding");
            throw null;
        }
        q.m("viewBinding");
        throw null;
    }

    private final void clickSoundBtn() {
        this.getViewModel().setSoundFlag(!((Boolean)this.getViewModel().getSoundAble().getValue()).booleanValue());
        this.getViewModel().clickSoundButton();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment$OnDismissListener
    public void dismiss() {
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public f1 getInsetHandlingType() {
        return f1.b;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    private final String getSelectedSlotUiType(int v) {
        l1 l10 = this.viewBinding;
        if(l10 != null) {
            q.f(l10.f, "viewPager");
            int v1 = this.getTabPosition(l10.f, v);
            List list0 = (List)this.getViewModel().getList().getValue();
            SLOTLIST trendShortFormRes$Response$SLOTLIST0 = list0 == null ? null : ((SLOTLIST)list0.get(v1));
            return trendShortFormRes$Response$SLOTLIST0 == null ? null : trendShortFormRes$Response$SLOTLIST0.uiType;
        }
        q.m("viewBinding");
        throw null;
    }

    private final int getStartPosition(ViewPager2 viewPager20, int v) {
        TrendShortFormViewPagerAdapter trendShortFormViewPagerAdapter0 = this.viewPagerAdapter;
        if(trendShortFormViewPagerAdapter0 != null) {
            com.iloen.melon.custom.n n0 = trendShortFormViewPagerAdapter0.getPositionProvider();
            return n0 == null ? 0 : n0.b(v, viewPager20.getCurrentItem());
        }
        return 0;
    }

    private final int getTabPosition(ViewPager2 viewPager20, int v) {
        TrendShortFormViewPagerAdapter trendShortFormViewPagerAdapter0 = this.viewPagerAdapter;
        if(trendShortFormViewPagerAdapter0 != null) {
            com.iloen.melon.custom.n n0 = trendShortFormViewPagerAdapter0.getPositionProvider();
            return n0 == null ? 0 : n0.c(v);
        }
        return 0;
    }

    @NotNull
    public final TrendShortFormViewModel getViewModel() {
        return (TrendShortFormViewModel)this.viewModel$delegate.getValue();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public v8.a getViewModel() {
        return this.getViewModel();
    }

    private final void goMatchedSlotId(int v) {
        if(!o.H0(this.slotId)) {
            List list0 = (List)this.getViewModel().getList().getValue();
            int v1 = -1;
            if(list0 != null) {
                int v2 = 0;
                for(Object object0: list0) {
                    if(q.b(((SLOTLIST)object0).slotId, this.slotId)) {
                        l1 l10 = this.viewBinding;
                        if(l10 != null) {
                            q.f(l10.f, "viewPager");
                            v1 = this.getStartPosition(l10.f, v2);
                            break;
                        }
                        q.m("viewBinding");
                        throw null;
                    }
                    ++v2;
                }
            }
            if(v1 >= 0) {
                l1 l11 = this.viewBinding;
                if(l11 != null) {
                    l11.f.c(v1, false);
                    this.slotId = "";
                    return;
                }
                q.m("viewBinding");
                throw null;
            }
            ToastManager.show(0x7F130598);  // string:main_trend_no_slot "해당 슬롯을 찾을 수 없습니다."
            l1 l12 = this.viewBinding;
            if(l12 != null) {
                l12.f.c(v, false);
                this.slotId = "";
                return;
            }
            q.m("viewBinding");
            throw null;
        }
        l1 l13 = this.viewBinding;
        if(l13 != null) {
            l13.f.c(v, false);
            return;
        }
        q.m("viewBinding");
        throw null;
    }

    private final void handleClickEvent(ClickEvent trendShortFormViewModel$ClickEvent0) {
        if(trendShortFormViewModel$ClickEvent0 instanceof ShowComment) {
            FragmentActivity fragmentActivity0 = this.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    MelonBottomSheetBaseFragment melonBottomSheetBaseFragment0 = this.bottomSheetBaseFragment;
                    if(melonBottomSheetBaseFragment0 != null) {
                        melonBottomSheetBaseFragment0.dismiss();
                    }
                    Param cmtListFragment$Param0 = new Param();
                    cmtListFragment$Param0.chnlSeq = ((ShowComment)trendShortFormViewModel$ClickEvent0).getBbsParam().getBbsChnlSeq();
                    cmtListFragment$Param0.contsRefValue = "";
                    cmtListFragment$Param0.showTitle = true;
                    cmtListFragment$Param0.theme = v9.c.c;
                    ud.j j0 = new ud.j(this, cmtListFragment$Param0);
                    j0.show(l00, "CastPlayerCommentBottomSheetFragment");
                    this.setBottomSheetBaseFragment(j0);
                }
            }
            return;
        }
        if(!(trendShortFormViewModel$ClickEvent0 instanceof ShowLoginPopup)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        this.showLoginPopup();
    }

    private final void initAudioFocus() {
        Object object0 = this.requireContext().getSystemService("audio");
        q.e(object0, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager)object0;
        AudioAttributes audioAttributes0 = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        AudioFocusRequest audioFocusRequest0 = new AudioFocusRequest.Builder(1).setAudioAttributes(audioAttributes0).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this).build();
        q.f(audioFocusRequest0, "build(...)");
        this.audioFocusRequest = audioFocusRequest0;
    }

    private final void initPager(List list0) {
        if(list0.isEmpty()) {
            return;
        }
        this.viewPagerAdapter = null;
        TrendShortFormViewPagerAdapter trendShortFormViewPagerAdapter0 = new TrendShortFormViewPagerAdapter(this, list0, new com.iloen.melon.fragments.shortform.k(this, 0));
        this.viewPagerAdapter = trendShortFormViewPagerAdapter0;
        l1 l10 = this.viewBinding;
        if(l10 != null) {
            l10.f.setAdapter(trendShortFormViewPagerAdapter0);
            l10.f.setOffscreenPageLimit(1);
            ((ArrayList)l10.f.c.b).remove(this.viewPagerCallBack);
            ((ArrayList)l10.f.c.b).add(this.viewPagerCallBack);
            this.goMatchedSlotId((this.selectedPosition > 0 ? this.selectedPosition : this.getStartPosition(l10.f, 0)));
            this.animateOnBoarding();
            return;
        }
        q.m("viewBinding");
        throw null;
    }

    private static final H initPager$lambda$9(TrendShortFormFragment trendShortFormFragment0, int v) {
        if(trendShortFormFragment0.isSoundSupported(trendShortFormFragment0.getSelectedSlotUiType(v))) {
            trendShortFormFragment0.clickSoundBtn();
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    private final boolean isSoundSupported(String s) {
        return !q.b(s, "M03");
    }

    @Override  // android.media.AudioManager$OnAudioFocusChangeListener
    public void onAudioFocusChange(int v) {
        Y.t("onAudioFocusChange() focusChange : ", v, LogU.Companion, "TrendShortFormFragment");
        if(v != -2 && v != -1) {
            return;
        }
        this.getViewModel().setSoundFlag(false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        String s;
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 == null) {
            s = "";
        }
        else {
            s = bundle1.getString("argSlotId");
            if(s == null) {
                s = "";
            }
        }
        this.slotId = s;
        this.initAudioFocus();
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
        View view0 = this.getLayoutInflater().inflate(0x7F0D02C3, viewGroup0, false);  // layout:fragment_tab_trend_short_form
        int v = 0x7F0A055D;  // id:img_back
        View view1 = De.I.C(view0, 0x7F0A055D);  // id:img_back
        if(((ImageView)view1) != null) {
            v = 0x7F0A0564;  // id:img_sound
            View view2 = De.I.C(view0, 0x7F0A0564);  // id:img_sound
            if(((CheckableImageView)view2) != null) {
                v = 0x7F0A074D;  // id:layout_title
                View view3 = De.I.C(view0, 0x7F0A074D);  // id:layout_title
                if(((ConstraintLayout)view3) != null) {
                    v = 0x7F0A07B1;  // id:lottie_animation_image
                    View view4 = De.I.C(view0, 0x7F0A07B1);  // id:lottie_animation_image
                    if(((LottieAnimationView)view4) != null && ((MelonTextView)De.I.C(view0, 0x7F0A0BAA)) != null) {  // id:title_tv
                        v = 0x7F0A0DC9;  // id:view_pager
                        View view5 = De.I.C(view0, 0x7F0A0DC9);  // id:view_pager
                        if(((ViewPager2)view5) != null) {
                            this.viewBinding = new l1(((FrameLayout)view0), ((ImageView)view1), ((CheckableImageView)view2), ((ConstraintLayout)view3), ((LottieAnimationView)view4), ((ViewPager2)view5));
                            q.f(((FrameLayout)view0), "getRoot(...)");
                            return (FrameLayout)view0;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable v9.h h0, @Nullable String s) {
        this.getViewModel().request(i0);
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        super.onPause();
        this.abandonAudioFocus();
        this.onboardingAnimator.cancel();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argSlotId", this.slotId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @SuppressLint({"UnspecifiedRegisterReceiverFlag"})
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.media.AUDIO_BECOMING_NOISY");
        Context context0 = this.getContext();
        if(context0 != null) {
            context0.registerReceiver(this.becomingNoisyAll, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION", null);
        }
        IntentFilter intentFilter1 = new IntentFilter();
        intentFilter1.addAction("android.intent.action.HEADSET_PLUG");
        Context context1 = this.getContext();
        if(context1 != null) {
            context1.registerReceiver(this.headSetReceiver, intentFilter1, "com.iloen.melon.permission.SIG_PERMISSION", null);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        Context context0 = this.getContext();
        if(context0 != null) {
            context0.unregisterReceiver(this.becomingNoisyAll);
        }
        Context context1 = this.getContext();
        if(context1 != null) {
            context1.unregisterReceiver(this.headSetReceiver);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.mEmptyView = view0.findViewById(0x7F0A08A5);  // id:network_error_layout
        l1 l10 = this.viewBinding;
        if(l10 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = l10.d.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.getStatusBarHeight(this.requireContext());
            l1 l11 = this.viewBinding;
            if(l11 != null) {
                l l0 = new l(this, 0);
                l11.b.setOnClickListener(l0);
                l1 l12 = this.viewBinding;
                if(l12 != null) {
                    l l1 = new l(this, 1);
                    l12.c.setOnClickListener(l1);
                    this.getViewModel().getResponse().observe(this.getViewLifecycleOwner(), new TrendShortFormFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.fragments.shortform.k(this, 1)));
                    this.getViewModel().getList().observe(this.getViewLifecycleOwner(), new TrendShortFormFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.fragments.shortform.k(this, 2)));
                    D d0 = this.getViewLifecycleOwner();
                    q.f(d0, "getViewLifecycleOwner(...)");
                    BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(null) {
                        int label;

                        {
                            TrendShortFormFragment.this = trendShortFormFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5(TrendShortFormFragment.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            ne.a a0 = ne.a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5.1 trendShortFormFragment$onViewCreated$5$10 = new we.n(null) {
                                        int label;

                                        {
                                            TrendShortFormFragment.this = trendShortFormFragment0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            return new com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5.1(TrendShortFormFragment.this, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                            return ((com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            ne.a a0 = ne.a.a;
                                            switch(this.label) {
                                                case 0: {
                                                    d5.n.D(object0);
                                                    StateFlow stateFlow0 = TrendShortFormFragment.this.getViewModel().getSoundAble();
                                                    com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5.1.1 trendShortFormFragment$onViewCreated$5$1$10 = new we.n(null) {
                                                        boolean Z$0;
                                                        int label;

                                                        {
                                                            TrendShortFormFragment.this = trendShortFormFragment0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5.1.1(TrendShortFormFragment.this, continuation0);
                                                            continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                                            return continuation1;
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(boolean z, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.5.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            boolean z = this.Z$0;
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            l1 l10 = TrendShortFormFragment.this.viewBinding;
                                                            if(l10 != null) {
                                                                H h0 = H.a;
                                                                if(l10.c.a == z) {
                                                                    return h0;
                                                                }
                                                                l1 l11 = TrendShortFormFragment.this.viewBinding;
                                                                if(l11 != null) {
                                                                    l11.c.setChecked(z);
                                                                    l1 l12 = TrendShortFormFragment.this.viewBinding;
                                                                    if(l12 != null) {
                                                                        l12.c.setContentDescription(TrendShortFormFragment.this.getString((z ? 0x7F130C5B : 0x7F130C5C)));  // string:talkback_sound_off_btn "소리끄기"
                                                                        TrendShortFormFragment.this.startSoundAnim(z);
                                                                        TrendShortFormFragment trendShortFormFragment0 = TrendShortFormFragment.this;
                                                                        if(z) {
                                                                            trendShortFormFragment0.requestAudioFocus();
                                                                            return h0;
                                                                        }
                                                                        trendShortFormFragment0.abandonAudioFocus();
                                                                        return h0;
                                                                    }
                                                                    q.m("viewBinding");
                                                                    throw null;
                                                                }
                                                                q.m("viewBinding");
                                                                throw null;
                                                            }
                                                            q.m("viewBinding");
                                                            throw null;
                                                        }
                                                    };
                                                    this.label = 1;
                                                    return FlowKt.collectLatest(stateFlow0, trendShortFormFragment$onViewCreated$5$1$10, this) == a0 ? a0 : H.a;
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
                                    return f0.j(TrendShortFormFragment.this, s.d, trendShortFormFragment$onViewCreated$5$10, this) == a0 ? a0 : H.a;
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
                    D d1 = this.getViewLifecycleOwner();
                    q.f(d1, "getViewLifecycleOwner(...)");
                    BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new we.n(null) {
                        int label;

                        {
                            TrendShortFormFragment.this = trendShortFormFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.6(TrendShortFormFragment.this, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.6)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            ne.a a0 = ne.a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    SharedFlow sharedFlow0 = TrendShortFormFragment.this.getViewModel().getClickEventFlow();
                                    com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.6.1 trendShortFormFragment$onViewCreated$6$10 = new we.n(null) {
                                        Object L$0;
                                        int label;

                                        {
                                            TrendShortFormFragment.this = trendShortFormFragment0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.6.1(TrendShortFormFragment.this, continuation0);
                                            continuation1.L$0 = object0;
                                            return continuation1;
                                        }

                                        public final Object invoke(ClickEvent trendShortFormViewModel$ClickEvent0, Continuation continuation0) {
                                            return ((com.iloen.melon.fragments.shortform.TrendShortFormFragment.onViewCreated.6.1)this.create(trendShortFormViewModel$ClickEvent0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((ClickEvent)object0), ((Continuation)object1));
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            ClickEvent trendShortFormViewModel$ClickEvent0 = (ClickEvent)this.L$0;
                                            if(this.label != 0) {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                            d5.n.D(object0);
                                            TrendShortFormFragment.this.handleClickEvent(trendShortFormViewModel$ClickEvent0);
                                            return H.a;
                                        }
                                    };
                                    this.label = 1;
                                    return FlowKt.collectLatest(sharedFlow0, trendShortFormFragment$onViewCreated$6$10, this) == a0 ? a0 : H.a;
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
                    this.registerIsLoginFlow();
                    return;
                }
                q.m("viewBinding");
                throw null;
            }
            q.m("viewBinding");
            throw null;
        }
        q.m("viewBinding");
        throw null;
    }

    private static final void onViewCreated$lambda$3(TrendShortFormFragment trendShortFormFragment0, View view0) {
        trendShortFormFragment0.performBackPress();
    }

    private static final void onViewCreated$lambda$4(TrendShortFormFragment trendShortFormFragment0, View view0) {
        trendShortFormFragment0.clickSoundBtn();
    }

    private static final H onViewCreated$lambda$5(TrendShortFormFragment trendShortFormFragment0, v8.i i0) {
        int v = WhenMappings.$EnumSwitchMapping$0[i0.a.ordinal()];
        switch(v) {
            case 1: {
                trendShortFormFragment0.selectedPosition = -1;
                trendShortFormFragment0.showProgress(true);
                trendShortFormFragment0.hideEmptyAndErrorView();
                return H.a;
            }
            case 2: {
                trendShortFormFragment0.onFetchSuccessUI(i0);
                l1 l12 = trendShortFormFragment0.viewBinding;
                if(l12 != null) {
                    l12.c.setVisibility(0);
                    return H.a;
                }
                q.m("viewBinding");
                throw null;
            }
            default: {
                if(v != 3 && v != 4) {
                    trendShortFormFragment0.hideEmptyAndErrorView();
                    l1 l10 = trendShortFormFragment0.viewBinding;
                    if(l10 != null) {
                        l10.c.setVisibility(4);
                        return H.a;
                    }
                    q.m("viewBinding");
                    throw null;
                }
                trendShortFormFragment0.onFetchErrorUI(i0);
                l1 l11 = trendShortFormFragment0.viewBinding;
                if(l11 != null) {
                    l11.c.setVisibility(4);
                    return H.a;
                }
                q.m("viewBinding");
                throw null;
            }
        }
    }

    private static final H onViewCreated$lambda$6(TrendShortFormFragment trendShortFormFragment0, List list0) {
        q.d(list0);
        trendShortFormFragment0.initPager(list0);
        return H.a;
    }

    private final void registerIsLoginFlow() {
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new we.n(null) {
            int label;

            {
                TrendShortFormFragment.this = trendShortFormFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.shortform.TrendShortFormFragment.registerIsLoginFlow.1(TrendShortFormFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.shortform.TrendShortFormFragment.registerIsLoginFlow.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = FlowKt.drop(FlowKt.distinctUntilChanged(((e0)va.o.a()).n()), 1);
                        com.iloen.melon.fragments.shortform.TrendShortFormFragment.registerIsLoginFlow.1.1 trendShortFormFragment$registerIsLoginFlow$1$10 = new we.n(null) {
                            boolean Z$0;
                            int label;

                            {
                                TrendShortFormFragment.this = trendShortFormFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.fragments.shortform.TrendShortFormFragment.registerIsLoginFlow.1.1(TrendShortFormFragment.this, continuation0);
                                continuation1.Z$0 = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.shortform.TrendShortFormFragment.registerIsLoginFlow.1.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.Z$0;
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                LogU logU0 = new LogU("TrendShortFormFragment");
                                logU0.setCategory(Category.Login);
                                logU0.setUseThreadInfo(true);
                                LogU.debug$default(logU0, "TrendShortFormFragment - isLogin: " + z, null, false, 6, null);
                                TrendShortFormFragment.this.getViewModel().clearCache();
                                return H.a;
                            }
                        };
                        this.label = 1;
                        return FlowKt.collectLatest(flow0, trendShortFormFragment$registerIsLoginFlow$1$10, this) == a0 ? a0 : H.a;
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

    private final void requestAudioFocus() {
        this.getPlayerUseCase().s();
        AudioManager audioManager0 = this.audioManager;
        if(audioManager0 != null) {
            AudioFocusRequest audioFocusRequest0 = this.audioFocusRequest;
            if(audioFocusRequest0 != null) {
                int v = audioManager0.requestAudioFocus(audioFocusRequest0);
                Y.t("requestAudioFocus() result : ", v, LogU.Companion, "TrendShortFormFragment");
                if(1 == v) {
                    this.getViewModel().setSoundFlag(true);
                }
                return;
            }
            q.m("audioFocusRequest");
            throw null;
        }
        q.m("audioManager");
        throw null;
    }

    private final void sendSwipeLog(int v, int v1) {
        v8.i i0 = (v8.i)this.getViewModel().getResponse().getValue();
        if(i0 != null) {
            TrendShortFormRes trendShortFormRes0 = (TrendShortFormRes)i0.c;
            if(trendShortFormRes0 != null) {
                Response trendShortFormRes$Response0 = trendShortFormRes0.response;
                if(trendShortFormRes$Response0 != null) {
                    List list0 = (List)this.getViewModel().getList().getValue();
                    if(list0 != null) {
                        SLOTLIST trendShortFormRes$Response$SLOTLIST0 = (SLOTLIST)list0.get(v);
                        if(trendShortFormRes$Response$SLOTLIST0 != null) {
                            List list1 = (List)this.getViewModel().getList().getValue();
                            if(list1 != null) {
                                SLOTLIST trendShortFormRes$Response$SLOTLIST1 = (SLOTLIST)list1.get(v1);
                                if(trendShortFormRes$Response$SLOTLIST1 != null) {
                                    String s = trendShortFormRes$Response$SLOTLIST0.contsTitle;
                                    q.f(s, "contsTitle");
                                    String s1 = o.O0(s, ".MP4");
                                    String s2 = trendShortFormRes$Response$SLOTLIST1.contsTitle;
                                    q.f(s2, "contsTitle");
                                    String s3 = o.O0(s2, ".MP4");
                                    p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                                    g0.b = trendShortFormRes$Response0.section;
                                    g0.c = trendShortFormRes$Response0.page;
                                    g0.y = trendShortFormRes$Response$SLOTLIST0.slotName;
                                    g0.I = this.getMenuId();
                                    g0.a = this.getString(0x7F130DD3);  // string:tiara_common_action_swipe "스와이프"
                                    g0.d = ActionKind.ClickContent;
                                    g0.F = v >= v1 ? this.getString(0x7F130DA5) : this.getString(0x7F130DA4);  // string:tiara_click_copy_swipe_to_prev "스와이프이전"
                                    Builder meta$Builder0 = new Builder();
                                    meta$Builder0.id(trendShortFormRes$Response$SLOTLIST0.contsId);
                                    meta$Builder0.type(trendShortFormRes$Response$SLOTLIST0.contsTypeCode);
                                    meta$Builder0.name(s1);
                                    meta$Builder0.category(trendShortFormRes$Response$SLOTLIST0.slotTypeDesc);
                                    meta$Builder0.categoryId(trendShortFormRes$Response$SLOTLIST0.slotType);
                                    g0.c0 = meta$Builder0.build();
                                    Builder meta$Builder1 = new Builder();
                                    meta$Builder1.id(trendShortFormRes$Response$SLOTLIST1.contsId);
                                    meta$Builder1.type(trendShortFormRes$Response$SLOTLIST1.contsTypeCode);
                                    meta$Builder1.name(s3);
                                    meta$Builder1.category(trendShortFormRes$Response$SLOTLIST1.slotTypeDesc);
                                    meta$Builder1.categoryId(trendShortFormRes$Response$SLOTLIST1.slotType);
                                    g0.b0 = meta$Builder1.build();
                                    g0.J = trendShortFormRes$Response$SLOTLIST0.statsElements.rangeCode;
                                    g0.a().track();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private final void setBottomSheetBaseFragment(MelonBottomSheetBaseFragment melonBottomSheetBaseFragment0) {
        if(melonBottomSheetBaseFragment0 != null) {
            melonBottomSheetBaseFragment0.setDismissListener(this);
        }
        this.bottomSheetBaseFragment = melonBottomSheetBaseFragment0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    private final void startSoundAnim(boolean z) {
        l1 l10 = this.viewBinding;
        if(l10 != null) {
            l10.e.setAnimation((z ? "animation/ic_common_sound_on.json" : "animation/ic_common_sound_off.json"));
            l10.e.playAnimation();
            return;
        }
        q.m("viewBinding");
        throw null;
    }
}

