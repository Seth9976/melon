package com.kakaoent.trevi.ad.ui;

import B0.s;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import c2.h0;
import com.kakaoent.trevi.ad.R.layout;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment;
import com.kakaoent.trevi.ad.util.AppContextHolder;
import com.kakaoent.trevi.ad.util.TreviAdFunctionKt;
import com.kakaoent.trevi.ad.util.TreviLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\b\u0005*\u0001\u0013\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001A\u00020\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u000E\u0010\u0003J\u0017\u0010\u0011\u001A\u00020\u00042\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001A\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsVideoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Lie/H;", "setFullScreen", "", "orientation", "lockOrientation", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "", "hasFocus", "onWindowFocusChanged", "(Z)V", "com/kakaoent/trevi/ad/ui/CashFriendsVideoActivity$activityCloseReceiver$1", "activityCloseReceiver", "Lcom/kakaoent/trevi/ad/ui/CashFriendsVideoActivity$activityCloseReceiver$1;", "Companion", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class CashFriendsVideoActivity extends AppCompatActivity {
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u000E\u001A\u00020\r2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u00042\b\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\f\u001A\u00020\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJQ\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u0006\u001A\u0004\u0018\u00010\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u00042\b\u0010\n\u001A\u0004\u0018\u00010\t2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001A\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001A\u0010\u0016R\u0014\u0010\u001B\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001B\u0010\u0016R\u0014\u0010\u001C\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001C\u0010\u0016R\u0014\u0010\u001D\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001D\u0010\u0016¨\u0006\u001E"}, d2 = {"Lcom/kakaoent/trevi/ad/ui/CashFriendsVideoActivity$Companion;", "", "<init>", "()V", "", "videoUrl", "orientation", "ask", "popupUrl", "Landroid/os/ResultReceiver;", "videoPlayResultReceiver", "", "webViewFragmentHashCode", "Landroid/content/Intent;", "getIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/ResultReceiver;I)Landroid/content/Intent;", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lie/H;", "startActivity", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/ResultReceiver;I)V", "ACTION_CASH_FRIEND_FULL_VIDEO_ACTIVITY_FINISH", "Ljava/lang/String;", "EXTRA_VIDEO_ASK", "EXTRA_VIDEO_ORIENTATION", "EXTRA_VIDEO_POPUP_URL", "EXTRA_VIDEO_RESULT_RECEIVER", "EXTRA_VIDEO_URL", "EXTRA_WEB_VIEW_FRAGMENT_HASHCODE", "TAG", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final Intent getIntent(String s, String s1, String s2, String s3, ResultReceiver resultReceiver0, int v) {
            Intent intent0 = new Intent(AppContextHolder.INSTANCE.getContext(), CashFriendsActivity.class);
            intent0.putExtra("EXTRA_VIDEO_URL", s);
            intent0.putExtra("EXTRA_VIDEO_ORIENTATION", s1);
            intent0.putExtra("EXTRA_VIDEO_ASK", s2);
            intent0.putExtra("EXTRA_VIDEO_POPUP_URL", s3);
            intent0.putExtra("EXTRA_VIDEO_RESULT_RECEIVER", resultReceiver0);
            intent0.putExtra("EXTRA_WEB_VIEW_FRAGMENT_HASHCODE", v);
            intent0.addFlags(0x4000000);
            return intent0;
        }

        public final void startActivity(@Nullable FragmentActivity fragmentActivity0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable ResultReceiver resultReceiver0, int v) {
            if(fragmentActivity0 == null) {
                return;
            }
            Intent intent0 = this.getIntent(s, s1, s2, s3, resultReceiver0, v);
            intent0.setClass(fragmentActivity0, CashFriendsVideoActivity.class);
            fragmentActivity0.startActivity(intent0);
        }
    }

    @NotNull
    private static final String ACTION_CASH_FRIEND_FULL_VIDEO_ACTIVITY_FINISH = "com.kakaoent.trevi.ad.ACTION_CASH_FRIEND_FULL_VIDEO_ACTIVITY_FINISH";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String EXTRA_VIDEO_ASK = "EXTRA_VIDEO_ASK";
    @NotNull
    private static final String EXTRA_VIDEO_ORIENTATION = "EXTRA_VIDEO_ORIENTATION";
    @NotNull
    private static final String EXTRA_VIDEO_POPUP_URL = "EXTRA_VIDEO_POPUP_URL";
    @NotNull
    private static final String EXTRA_VIDEO_RESULT_RECEIVER = "EXTRA_VIDEO_RESULT_RECEIVER";
    @NotNull
    private static final String EXTRA_VIDEO_URL = "EXTRA_VIDEO_URL";
    @NotNull
    private static final String EXTRA_WEB_VIEW_FRAGMENT_HASHCODE = "EXTRA_WEB_VIEW_FRAGMENT_HASHCODE";
    @NotNull
    private static final String TAG = "CashFriendsVideoActivity";
    @NotNull
    private final com.kakaoent.trevi.ad.ui.CashFriendsVideoActivity.activityCloseReceiver.1 activityCloseReceiver;

    static {
        CashFriendsVideoActivity.Companion = new Companion(null);
    }

    public CashFriendsVideoActivity() {
        this.activityCloseReceiver = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context0, @Nullable Intent intent0) {
                TreviLog.INSTANCE.d("CashFriendsVideoActivity", "onReceive() activityCloseReceiver");
                if("com.kakaoent.trevi.ad.ACTION_CASH_FRIEND_FULL_VIDEO_ACTIVITY_FINISH".equals((intent0 == null ? null : intent0.getAction()))) {
                    CashFriendsVideoActivity.this.finish();
                }
            }
        };
    }

    @SuppressLint({"WrongConstant"})
    private final void lockOrientation(int v) {
        try {
            this.setRequestedOrientation(v);
        }
        catch(Throwable throwable0) {
            TreviLog.INSTANCE.e("CashFriendsVideoActivity", "lockOrientation", throwable0);
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(R.layout.trevi_cash_friends_video_activity);
        String s = this.getIntent().getStringExtra("EXTRA_VIDEO_URL");
        String s1 = this.getIntent().getStringExtra("EXTRA_VIDEO_ORIENTATION");
        String s2 = this.getIntent().getStringExtra("EXTRA_VIDEO_ASK");
        String s3 = this.getIntent().getStringExtra("EXTRA_VIDEO_POPUP_URL");
        Parcelable parcelable0 = this.getIntent().getParcelableExtra("EXTRA_VIDEO_RESULT_RECEIVER");
        int v = this.getIntent().getIntExtra("EXTRA_WEB_VIEW_FRAGMENT_HASHCODE", 0);
        if(q.b(s1, "landscape")) {
            this.lockOrientation(0);
        }
        else {
            this.lockOrientation(1);
        }
        l0 l00 = this.getSupportFragmentManager();
        a a0 = com.iloen.melon.utils.a.f(l00, "getSupportFragmentManager(...)", l00);
        com.kakaoent.trevi.ad.ui.fragment.CashFriendsVideoFragment.Companion cashFriendsVideoFragment$Companion0 = CashFriendsVideoFragment.Companion;
        if(s == null) {
            s = "";
        }
        a0.g(0x7F0A04DC, cashFriendsVideoFragment$Companion0.newInstance(s, (s1 == null ? "landscape" : s1), (s2 == null ? "" : s2), (s3 == null ? "" : s3), ((ResultReceiver)parcelable0), v), null);  // id:fragmentContainerLayout
        a0.k();
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.kakaoent.trevi.ad.ACTION_CASH_FRIEND_FULL_VIDEO_ACTIVITY_FINISH");
        TreviAdFunctionKt.registerReceiverCompat(this, this.activityCloseReceiver, intentFilter0, true);
    }

    @Override  // androidx.appcompat.app.AppCompatActivity
    public void onDestroy() {
        super.onDestroy();
        try {
            this.unregisterReceiver(this.activityCloseReceiver);
        }
        catch(Exception unused_ex) {
        }
    }

    @Override  // android.app.Activity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if(z) {
            this.setFullScreen();
        }
    }

    private final void setFullScreen() {
        androidx.appcompat.app.a a0 = this.getSupportActionBar();
        if(a0 != null) {
            a0.f();
        }
        if(Build.VERSION.SDK_INT >= 30) {
            s.q(this.getWindow());
            WindowInsetsController windowInsetsController0 = this.getWindow().getInsetsController();
            if(windowInsetsController0 != null) {
                windowInsetsController0.hide(h0.b() | h0.s());
                h0.u(windowInsetsController0);
            }
            return;
        }
        this.getWindow().setFlags(0x400, 0x400);
        this.getWindow().getDecorView().setSystemUiVisibility(0x1706);
        this.getWindow().addFlags(0x8000000);
    }
}

