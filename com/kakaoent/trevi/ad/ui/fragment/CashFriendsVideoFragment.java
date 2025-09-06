package com.kakaoent.trevi.ad.ui.fragment;

import De.d;
import Q4.a;
import S2.c;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.f0;
import androidx.lifecycle.l;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.lifecycle.t;
import com.kakaoent.trevi.ad.R.string;
import com.kakaoent.trevi.ad.TreviAd.OfferWallCallback;
import com.kakaoent.trevi.ad.TreviAd;
import com.kakaoent.trevi.ad.databinding.TreviCashFriendsVideoFragmentBinding;
import com.kakaoent.trevi.ad.util.TreviAdFunctionKt;
import com.kakaoent.trevi.ad.util.TreviLog;
import com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.Event.CompleteFailVideoTracking;
import com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.Event.SuccessVideoTracking;
import com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel.Event;
import com.kakaoent.trevi.ad.viewmodel.CashFriendsVideoViewModel;
import ie.H;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import o9.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u0000 C2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001CB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001A\u00020\u00072\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\n\u0010\u0004J\u000F\u0010\u000B\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u000B\u0010\u0004J\u0017\u0010\u000E\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001C\u001A\u00020\u00072\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ!\u0010 \u001A\u00020\u00072\u0006\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0016\u00A2\u0006\u0004\b \u0010!J\u000F\u0010\"\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\"\u0010\u0004J\u000F\u0010#\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b#\u0010\u0004J\u000F\u0010$\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b$\u0010\u0004J\u0015\u0010\'\u001A\u00020\u00072\u0006\u0010&\u001A\u00020%\u00A2\u0006\u0004\b\'\u0010(J\r\u0010)\u001A\u00020\u0007\u00A2\u0006\u0004\b)\u0010\u0004J\u000F\u0010*\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b*\u0010\u0004R\u0016\u0010,\u001A\u00020+8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u0010/R\u0016\u00101\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00102\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u0010/R\u0016\u00103\u001A\u00020\u00108\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u0010/R\u0018\u00105\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u00108R\u0018\u0010;\u001A\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\r\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\r\u00108R\u0016\u0010=\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u00108R\u0016\u0010>\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u00108R\u0016\u0010@\u001A\u00020?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001A\u00020?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010A\u00A8\u0006D"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsVideoFragment;", "Lcom/kakaoent/trevi/ad/ui/fragment/BaseViewFragment;", "Lcom/kakaoent/trevi/ad/databinding/TreviCashFriendsVideoFragmentBinding;", "<init>", "()V", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event;", "event", "Lie/H;", "render", "(Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel$Event;)V", "closeVideo", "timerCounter", "", "progress", "sendActType", "(I)V", "", "actType", "send", "(Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "inflateBinding", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/kakaoent/trevi/ad/databinding/TreviCashFriendsVideoFragmentBinding;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onPause", "onDestroyView", "onBackPressed", "", "remainDuration", "displayProgress", "(D)V", "destroyTimer", "onDestroy", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel;", "viewModel", "Lcom/kakaoent/trevi/ad/viewmodel/CashFriendsVideoViewModel;", "cpvEnv", "Ljava/lang/String;", "videoUrl", "orientation", "ask", "popupUrl", "Landroid/os/ResultReceiver;", "resultReceiver", "Landroid/os/ResultReceiver;", "webViewFragmentHashCode", "I", "totalDuration", "Ljava/util/Timer;", "timer", "Ljava/util/Timer;", "recentSendProgress", "stopPosition", "", "isResumedActivity", "Z", "isCompleteReward", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsVideoFragment extends BaseViewFragment {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u00042\b\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001A\u00020\u0014R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsVideoFragment$Companion;", "", "()V", "ARGS_CASH_FRIENDS_POPUP_URL", "", "ARGS_CASH_FRIENDS_VIDEO_ASK", "ARGS_CASH_FRIENDS_VIDEO_ORIENTATION", "ARGS_CASH_FRIENDS_VIDEO_RESULT_RECEIVER", "ARGS_CASH_FRIENDS_VIDEO_URL", "ARGS_CASH_FRIENDS_WEB_VIEW_HASHCODE", "TAG", "newInstance", "Lcom/kakaoent/trevi/ad/ui/fragment/CashFriendsVideoFragment;", "videoUrl", "orientation", "ask", "popupUrl", "resultReceiver", "Landroid/os/ResultReceiver;", "webViewFragmentHashCode", "", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CashFriendsVideoFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @Nullable ResultReceiver resultReceiver0, int v) {
            q.g(s, "videoUrl");
            q.g(s1, "orientation");
            q.g(s2, "ask");
            q.g(s3, "popupUrl");
            Bundle bundle0 = new Bundle();
            bundle0.putString("ARGS_CASH_FRIENDS_VIDEO_URL", s);
            bundle0.putString("ARGS_CASH_FRIENDS_VIDEO_ORIENTATION", s1);
            bundle0.putString("ARGS_CASH_FRIENDS_VIDEO_ASK", s2);
            bundle0.putString("ARGS_CASH_FRIENDS_POPUP_URL", s3);
            bundle0.putParcelable("ARGS_CASH_FRIENDS_VIDEO_RESULT_RECEIVER", resultReceiver0);
            bundle0.putInt("ARGS_CASH_FRIENDS_WEB_VIEW_HASHCODE", v);
            CashFriendsVideoFragment cashFriendsVideoFragment0 = new CashFriendsVideoFragment();
            cashFriendsVideoFragment0.setArguments(bundle0);
            return cashFriendsVideoFragment0;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private String ask;
    @NotNull
    private String cpvEnv;
    private boolean isCompleteReward;
    private boolean isResumedActivity;
    @NotNull
    private String orientation;
    @NotNull
    private String popupUrl;
    private int progress;
    private int recentSendProgress;
    @Nullable
    private ResultReceiver resultReceiver;
    private int stopPosition;
    @Nullable
    private Timer timer;
    private int totalDuration;
    @NotNull
    private String videoUrl;
    private CashFriendsVideoViewModel viewModel;
    private int webViewFragmentHashCode;

    static {
        CashFriendsVideoFragment.Companion = new Companion(null);
    }

    public CashFriendsVideoFragment() {
        this.cpvEnv = "real";
        this.videoUrl = "";
        this.orientation = "landscape";
        this.ask = "";
        this.popupUrl = "";
    }

    private final void closeVideo() {
        boolean z;
        this.destroyTimer();
        TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0 = (TreviCashFriendsVideoFragmentBinding)this.getBinding();
        if(treviCashFriendsVideoFragmentBinding0 != null) {
            VideoView videoView0 = treviCashFriendsVideoFragmentBinding0.videoView;
            if(videoView0 != null) {
                try {
                    z = videoView0.isPlaying();
                }
                catch(Exception exception0) {
                    TreviLog.INSTANCE.d("CashFriendsVideoFragment", "closeVideo - isPlaying error: " + exception0);
                    z = false;
                }
                if(z) {
                    videoView0.stopPlayback();
                    videoView0.setVisibility(8);
                    TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding1 = (TreviCashFriendsVideoFragmentBinding)this.getBinding();
                    ConstraintLayout constraintLayout0 = treviCashFriendsVideoFragmentBinding1 == null ? null : treviCashFriendsVideoFragmentBinding1.videoLayout;
                    if(constraintLayout0 != null) {
                        constraintLayout0.setVisibility(8);
                    }
                }
            }
        }
        super.onBackPressed();
    }

    public final void destroyTimer() {
        if(this.timer != null) {
            TreviLog.INSTANCE.d("CashFriendsVideoFragment", "destroyTimer");
            Timer timer0 = this.timer;
            if(timer0 != null) {
                timer0.cancel();
            }
            this.timer = null;
        }
    }

    public final void displayProgress(double f) {
        TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0 = (TreviCashFriendsVideoFragmentBinding)this.getBinding();
        if(treviCashFriendsVideoFragmentBinding0 == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(() -> CashFriendsVideoFragment.displayProgress$lambda$16(this, f, treviCashFriendsVideoFragmentBinding0));
    }

    private static final void displayProgress$lambda$16(CashFriendsVideoFragment cashFriendsVideoFragment0, double f, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0) {
        q.g(cashFriendsVideoFragment0, "this$0");
        q.g(treviCashFriendsVideoFragmentBinding0, "$binding");
        if(!cashFriendsVideoFragment0.isInitBinding()) {
            return;
        }
        treviCashFriendsVideoFragmentBinding0.videoRemainTimeProgressView.setVisibility(0);
        treviCashFriendsVideoFragmentBinding0.videoRemainTimeTextView.setVisibility(0);
        treviCashFriendsVideoFragmentBinding0.videoRemainTimeTextView.setText(String.valueOf(((int)Math.rint(f / 1000.0))));
        treviCashFriendsVideoFragmentBinding0.videoRemainTimeProgressView.setProgress(((int)f));
        treviCashFriendsVideoFragmentBinding0.videoRemainTimeProgressView.setMax(cashFriendsVideoFragment0.totalDuration);
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseViewFragment
    public a inflateBinding(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        return this.inflateBinding(layoutInflater0, viewGroup0);
    }

    @NotNull
    public TreviCashFriendsVideoFragmentBinding inflateBinding(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0) {
        q.g(layoutInflater0, "inflater");
        TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0 = TreviCashFriendsVideoFragmentBinding.inflate(layoutInflater0);
        q.f(treviCashFriendsVideoFragmentBinding0, "inflate(...)");
        return treviCashFriendsVideoFragmentBinding0;
    }

    // 检测为 Lambda 实现
    public static void l(CashFriendsVideoFragment cashFriendsVideoFragment0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0, MediaPlayer mediaPlayer0) [...]

    // 检测为 Lambda 实现
    public static boolean m(CashFriendsVideoFragment cashFriendsVideoFragment0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0, MediaPlayer mediaPlayer0, int v, int v1) [...]

    // 检测为 Lambda 实现
    public static void n(CashFriendsVideoFragment cashFriendsVideoFragment0, VideoView videoView0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0, MediaPlayer mediaPlayer0) [...]

    // 检测为 Lambda 实现
    public static void o(CashFriendsVideoFragment cashFriendsVideoFragment0, double f, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0) [...]

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseFragment
    public void onBackPressed() {
        this.closeVideo();
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.useBackPressed();
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            String s = bundle1.getString("ARGS_CASH_FRIENDS_VIDEO_URL", "");
            q.f(s, "getString(...)");
            this.videoUrl = s;
            String s1 = bundle1.getString("ARGS_CASH_FRIENDS_VIDEO_ORIENTATION", "landscape");
            q.f(s1, "getString(...)");
            this.orientation = s1;
            String s2 = bundle1.getString("ARGS_CASH_FRIENDS_VIDEO_ASK", "");
            q.f(s2, "getString(...)");
            this.ask = s2;
            String s3 = bundle1.getString("ARGS_CASH_FRIENDS_POPUP_URL", "");
            q.f(s3, "getString(...)");
            this.popupUrl = s3;
            this.resultReceiver = (ResultReceiver)bundle1.getParcelable("ARGS_CASH_FRIENDS_VIDEO_RESULT_RECEIVER");
            this.webViewFragmentHashCode = bundle1.getInt("ARGS_CASH_FRIENDS_WEB_VIEW_HASHCODE");
        }
        this.cpvEnv = "real";
        OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.webViewFragmentHashCode);
        if(treviAd$OfferWallCallback0 != null) {
            treviAd$OfferWallCallback0.cpvLifecycle(true);
        }
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseFragment
    public void onDestroy() {
        super.onDestroy();
        OfferWallCallback treviAd$OfferWallCallback0 = (OfferWallCallback)TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.webViewFragmentHashCode);
        if(treviAd$OfferWallCallback0 != null) {
            treviAd$OfferWallCallback0.cpvLifecycle(false);
        }
    }

    @Override  // com.kakaoent.trevi.ad.ui.fragment.BaseViewFragment
    public void onDestroyView() {
        this.destroyTimer();
        this.resultReceiver = null;
        super.onDestroyView();
    }

    @Override  // androidx.fragment.app.I
    public void onPause() {
        boolean z;
        super.onPause();
        TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0 = (TreviCashFriendsVideoFragmentBinding)this.getBinding();
        if(treviCashFriendsVideoFragmentBinding0 != null) {
            this.destroyTimer();
            try {
                z = treviCashFriendsVideoFragmentBinding0.videoView.isPlaying();
            }
            catch(Exception exception0) {
                TreviLog.INSTANCE.e("cycle onPause", "isPlaying error: " + exception0);
                z = false;
            }
            if(z) {
                this.isResumedActivity = true;
                treviCashFriendsVideoFragmentBinding0.videoView.pause();
                this.stopPosition = treviCashFriendsVideoFragmentBinding0.videoView.getCurrentPosition();
                TreviLog.INSTANCE.d("CashFriendsVideoFragment", "stopPosition : " + this.stopPosition);
            }
        }
    }

    @Override  // androidx.fragment.app.I
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0 = (TreviCashFriendsVideoFragmentBinding)this.getBinding();
        if(treviCashFriendsVideoFragmentBinding0 == null) {
            return;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Window window0 = fragmentActivity0.getWindow();
            if(window0 != null) {
                window0.addFlags(0x200);
            }
        }
        q0 q00 = this.getViewModelStore();
        o0 o00 = this.getDefaultViewModelProviderFactory();
        c c0 = this.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        d d0 = df.d.y(CashFriendsVideoViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.viewModel = (CashFriendsVideoViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), null, null, new n(null) {
            int label;

            {
                CashFriendsVideoFragment.this = cashFriendsVideoFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.onViewCreated.1(CashFriendsVideoFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                return ((com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CashFriendsVideoViewModel cashFriendsVideoViewModel0 = CashFriendsVideoFragment.this.viewModel;
                        if(cashFriendsVideoViewModel0 != null) {
                            Flow flow0 = cashFriendsVideoViewModel0.getEventsFlow();
                            t t0 = CashFriendsVideoFragment.this.getLifecycle();
                            q.f(t0, "<get-lifecycle>(...)");
                            q.g(flow0, "<this>");
                            Flow flow1 = FlowKt.callbackFlow(new l(t0, flow0, null));
                            com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.onViewCreated.1.1 cashFriendsVideoFragment$onViewCreated$1$10 = new FlowCollector() {
                                @Nullable
                                public final Object emit(@NotNull Event cashFriendsVideoViewModel$Event0, @NotNull Continuation continuation0) {
                                    CashFriendsVideoFragment.this.render(cashFriendsVideoViewModel$Event0);
                                    return H.a;
                                }

                                @Override  // kotlinx.coroutines.flow.FlowCollector
                                public Object emit(Object object0, Continuation continuation0) {
                                    return this.emit(((Event)object0), continuation0);
                                }
                            };
                            this.label = 1;
                            return flow1.collect(cashFriendsVideoFragment$onViewCreated$1$10, this) == a0 ? a0 : H.a;
                        }
                        q.m("viewModel");
                        throw null;
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
        Uri uri0 = Uri.parse(this.videoUrl);
        treviCashFriendsVideoFragmentBinding0.videoView.setVideoURI(uri0);
        Q9.a a0 = (MediaPlayer mediaPlayer0, int v, int v1) -> CashFriendsVideoFragment.onViewCreated$lambda$7$lambda$1(this, treviCashFriendsVideoFragmentBinding0, mediaPlayer0, v, v1);
        treviCashFriendsVideoFragmentBinding0.videoView.setOnInfoListener(a0);
        Q9.b b1 = (MediaPlayer mediaPlayer0) -> CashFriendsVideoFragment.onViewCreated$lambda$7$lambda$2(this, treviCashFriendsVideoFragmentBinding0, mediaPlayer0);
        treviCashFriendsVideoFragmentBinding0.videoView.setOnCompletionListener(b1);
        Q9.c c1 = (MediaPlayer mediaPlayer0) -> CashFriendsVideoFragment.onViewCreated$lambda$7$lambda$6(this, treviCashFriendsVideoFragmentBinding0.videoView, treviCashFriendsVideoFragmentBinding0, mediaPlayer0);
        treviCashFriendsVideoFragmentBinding0.videoView.setOnPreparedListener(c1);
        com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.onViewCreated.lambda.9..inlined.click.1 cashFriendsVideoFragment$onViewCreated$lambda$9$$inlined$click$10 = new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public final void onClick(View view0) {
                q.d(view0);
                CashFriendsVideoFragment.this.onBackPressed();
            }
        };
        treviCashFriendsVideoFragmentBinding0.closeButton.setOnClickListener(cashFriendsVideoFragment$onViewCreated$lambda$9$$inlined$click$10);
        int[] arr_v = {S1.c.k(0xFF000000, 51), S1.c.k(0xFF000000, 0)};
        GradientDrawable gradientDrawable0 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, arr_v);
        treviCashFriendsVideoFragmentBinding0.closeGradientView.setBackground(gradientDrawable0);
        int[] arr_v1 = {S1.c.k(0xFF000000, 51), S1.c.k(0xFF000000, 0)};
        GradientDrawable gradientDrawable1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, arr_v1);
        treviCashFriendsVideoFragmentBinding0.progressGradientView.setBackground(gradientDrawable1);
        q.f(treviCashFriendsVideoFragmentBinding0.loadingProgress, "loadingProgress");
        treviCashFriendsVideoFragmentBinding0.loadingProgress.setVisibility(0);
    }

    private static final boolean onViewCreated$lambda$7$lambda$1(CashFriendsVideoFragment cashFriendsVideoFragment0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0, MediaPlayer mediaPlayer0, int v, int v1) {
        q.g(cashFriendsVideoFragment0, "this$0");
        q.g(treviCashFriendsVideoFragmentBinding0, "$binding");
        if(v == 3 && !cashFriendsVideoFragment0.isResumedActivity) {
            cashFriendsVideoFragment0.timerCounter();
            cashFriendsVideoFragment0.send("V_START");
            q.f(treviCashFriendsVideoFragmentBinding0.loadingProgress, "loadingProgress");
            treviCashFriendsVideoFragmentBinding0.loadingProgress.setVisibility(8);
        }
        return false;
    }

    private static final void onViewCreated$lambda$7$lambda$2(CashFriendsVideoFragment cashFriendsVideoFragment0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0, MediaPlayer mediaPlayer0) {
        q.g(cashFriendsVideoFragment0, "this$0");
        q.g(treviCashFriendsVideoFragmentBinding0, "$binding");
        cashFriendsVideoFragment0.destroyTimer();
        cashFriendsVideoFragment0.progress = 100;
        if(cashFriendsVideoFragment0.recentSendProgress == 75) {
            cashFriendsVideoFragment0.recentSendProgress = 100;
            cashFriendsVideoFragment0.send("V_COMPLETE");
        }
        treviCashFriendsVideoFragmentBinding0.videoRemainTimeProgressView.setProgress(cashFriendsVideoFragment0.totalDuration);
    }

    private static final void onViewCreated$lambda$7$lambda$6(CashFriendsVideoFragment cashFriendsVideoFragment0, VideoView videoView0, TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0, MediaPlayer mediaPlayer0) {
        q.g(cashFriendsVideoFragment0, "this$0");
        q.g(videoView0, "$this_apply");
        q.g(treviCashFriendsVideoFragmentBinding0, "$binding");
        if(cashFriendsVideoFragment0.isCompleteReward) {
            return;
        }
        float f = ((float)mediaPlayer0.getVideoWidth()) / ((float)mediaPlayer0.getVideoHeight());
        float f1 = ((float)videoView0.getWidth()) / ((float)videoView0.getHeight());
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = videoView0.getLayoutParams();
        if(Float.compare(f, f1) < 0) {
            viewGroup$LayoutParams0.width = -2;
            viewGroup$LayoutParams0.height = -1;
        }
        else {
            viewGroup$LayoutParams0.width = -1;
            viewGroup$LayoutParams0.height = -2;
        }
        mediaPlayer0.setVideoScalingMode(2);
        if(cashFriendsVideoFragment0.isResumedActivity) {
            mediaPlayer0.seekTo(((long)cashFriendsVideoFragment0.stopPosition), 3);
            cashFriendsVideoFragment0.timerCounter();
        }
        else {
            treviCashFriendsVideoFragmentBinding0.videoRemainTimeTextView.setText(String.valueOf(cashFriendsVideoFragment0.totalDuration / 1000));
            treviCashFriendsVideoFragmentBinding0.videoRemainTimeProgressView.setMax(cashFriendsVideoFragment0.totalDuration);
        }
        cashFriendsVideoFragment0.totalDuration = mediaPlayer0.getDuration();
        mediaPlayer0.start();
    }

    private final void render(Event cashFriendsVideoViewModel$Event0) {
        if(cashFriendsVideoViewModel$Event0 != null) {
            if(cashFriendsVideoViewModel$Event0 instanceof SuccessVideoTracking) {
                TreviLog treviLog0 = TreviLog.INSTANCE;
                treviLog0.d("CashFriendsVideoFragment", "UI_DATA_VIDEO_TRACKING actType : " + ((SuccessVideoTracking)cashFriendsVideoViewModel$Event0).getActType());
                if(q.b(((SuccessVideoTracking)cashFriendsVideoViewModel$Event0).getActType(), "V_COMPLETE")) {
                    treviLog0.d("CashFriendsVideoFragment", "cash : " + ((SuccessVideoTracking)cashFriendsVideoViewModel$Event0).getTrackingData().getWinPrice());
                    this.isCompleteReward = true;
                    if(this.getContext() != null) {
                        Object object0 = TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.webViewFragmentHashCode);
                        if(((OfferWallCallback)object0) != null) {
                            WeakReference weakReference0 = new WeakReference(this.getActivity());
                            String s = this.getString(R.string.trevi_cashfriends_video_event_join_complete);
                            String s1 = this.getString(R.string.trevi_cashfriends_more_about);
                            q.f(s1, "getString(...)");
                            ((OfferWallCallback)object0).showAlertDialog(weakReference0, null, s, false, s1, this.getString(R.string.trevi_cashfriends_close_or_cancel), new we.a() {
                                {
                                    CashFriendsVideoFragment.this = cashFriendsVideoFragment0;
                                    super(0);
                                }

                                @Override  // we.a
                                public Object invoke() {
                                    this.invoke();
                                    return H.a;
                                }

                                public final void invoke() {
                                    CashFriendsVideoFragment.this.send("V_CLICK");
                                    ResultReceiver resultReceiver0 = CashFriendsVideoFragment.this.resultReceiver;
                                    if(resultReceiver0 != null) {
                                        resultReceiver0.send(-1, null);
                                    }
                                    CashFriendsVideoFragment.this.onBackPressed();
                                    String s = CashFriendsVideoFragment.this.popupUrl;
                                    Pattern pattern0 = Pattern.compile("#");
                                    q.f(pattern0, "compile(...)");
                                    q.g(s, "input");
                                    String s1 = pattern0.matcher(s).replaceAll("%23");
                                    q.f(s1, "replaceAll(...)");
                                    Intent intent0 = new Intent("android.intent.action.VIEW", TreviAdFunctionKt.toUri(s1));
                                    intent0.addFlags(0x4000000);
                                    intent0.addFlags(0x10200000);
                                    Context context0 = CashFriendsVideoFragment.this.getContext();
                                    if(context0 != null) {
                                        context0.startActivity(intent0);
                                    }
                                }
                            }, new we.a() {
                                {
                                    CashFriendsVideoFragment.this = cashFriendsVideoFragment0;
                                    super(0);
                                }

                                @Override  // we.a
                                public Object invoke() {
                                    this.invoke();
                                    return H.a;
                                }

                                public final void invoke() {
                                    ResultReceiver resultReceiver0 = CashFriendsVideoFragment.this.resultReceiver;
                                    if(resultReceiver0 != null) {
                                        resultReceiver0.send(-1, null);
                                    }
                                    CashFriendsVideoFragment.this.onBackPressed();
                                }
                            });
                        }
                    }
                }
            }
            else if(cashFriendsVideoViewModel$Event0 instanceof CompleteFailVideoTracking) {
                TreviLog.INSTANCE.d("CashFriendsVideoFragment", "UI_DATA_VIDEO_TRACKING_COMPLETE_FAILURE");
                if(this.getContext() != null) {
                    Object object1 = TreviAd.INSTANCE.getOfferWallCallbackList$trevi_ad_android_sdk_release().get(this.webViewFragmentHashCode);
                    if(((OfferWallCallback)object1) != null) {
                        WeakReference weakReference1 = new WeakReference(this.getActivity());
                        String s2 = this.getString(R.string.trevi_cashfriends_video_event_join_failed);
                        String s3 = this.getString(R.string.trevi_close);
                        q.f(s3, "getString(...)");
                        ((OfferWallCallback)object1).showAlertDialog(weakReference1, null, s2, false, s3, null, new we.a() {
                            {
                                CashFriendsVideoFragment.this = cashFriendsVideoFragment0;
                                super(0);
                            }

                            @Override  // we.a
                            public Object invoke() {
                                this.invoke();
                                return H.a;
                            }

                            public final void invoke() {
                                CashFriendsVideoFragment.this.onBackPressed();
                            }
                        }, com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.render.2.2.INSTANCE);
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001A\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lie/H;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 9, 0})
        final class com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.render.2.2 extends r implements we.a {
            public static final com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.render.2.2 INSTANCE;

            static {
                com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.render.2.2.INSTANCE = new com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.render.2.2();
            }

            public com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.render.2.2() {
                super(0);
            }

            @Override  // we.a
            public Object invoke() {
                return H.a;
            }

            public final void invoke() {
            }
        }

    }

    private final void send(String s) {
        TreviLog.INSTANCE.d("CashFriendsVideoFragment", "send : " + s);
        CashFriendsVideoViewModel cashFriendsVideoViewModel0 = this.viewModel;
        if(cashFriendsVideoViewModel0 != null) {
            cashFriendsVideoViewModel0.sendTracking(this.ask, s, this.cpvEnv);
            return;
        }
        q.m("viewModel");
        throw null;
    }

    private final void sendActType(int v) {
        switch(this.recentSendProgress) {
            case 0: {
                if(v >= 10) {
                    this.recentSendProgress = 10;
                    this.send("V_PROGRESS_10_P");
                    return;
                }
                break;
            }
            case 10: {
                if(v >= 25) {
                    this.recentSendProgress = 25;
                    this.send("V_1Q");
                    return;
                }
                break;
            }
            case 25: {
                if(v >= 50) {
                    this.recentSendProgress = 50;
                    this.send("V_MID");
                    return;
                }
                break;
            }
            case 50: {
                if(v >= 75) {
                    this.recentSendProgress = 75;
                    this.send("V_3Q");
                    return;
                }
                break;
            }
        }
    }

    private final void timerCounter() {
        TreviCashFriendsVideoFragmentBinding treviCashFriendsVideoFragmentBinding0 = (TreviCashFriendsVideoFragmentBinding)this.getBinding();
        if(treviCashFriendsVideoFragmentBinding0 != null) {
            this.timer = new Timer();
            com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.timerCounter.task.1 cashFriendsVideoFragment$timerCounter$task$10 = new TimerTask() {
                @Override
                public void run() {
                    boolean z;
                    if(!treviCashFriendsVideoFragmentBinding0.isInitBinding()) {
                        treviCashFriendsVideoFragmentBinding0.destroyTimer();
                        return;
                    }
                    if(treviCashFriendsVideoFragmentBinding0.progress >= 100) {
                        treviCashFriendsVideoFragmentBinding0.destroyTimer();
                    }
                    try {
                        z = this.$binding.videoView.isPlaying();
                    }
                    catch(Exception exception0) {
                        TreviLog.INSTANCE.d("CashFriendsVideoFragment", "timerCounter - isPlaying error: " + exception0);
                        z = false;
                    }
                    if(z) {
                        int v = this.$binding.videoView.getCurrentPosition();
                        if(v == 0) {
                            return;
                        }
                        treviCashFriendsVideoFragmentBinding0.progress = v * 100 / treviCashFriendsVideoFragmentBinding0.totalDuration;
                        int v1 = this.$binding.videoView.getCurrentPosition();
                        treviCashFriendsVideoFragmentBinding0.displayProgress(((double)(treviCashFriendsVideoFragmentBinding0.totalDuration - v1)));
                    }
                    treviCashFriendsVideoFragmentBinding0.sendActType(treviCashFriendsVideoFragmentBinding0.progress);
                }
            };
            Timer timer0 = this.timer;
            if(timer0 != null) {
                timer0.schedule(cashFriendsVideoFragment$timerCounter$task$10, 0L, 100L);
            }
        }
    }
}

