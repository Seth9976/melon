package com.iloen.melon.fragments.settings;

import De.I;
import J8.U2;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation.Callback;
import android.view.WindowInsetsAnimation;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.iloen.melon.alarm.AlarmReceiver;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.NumberPicker;
import com.iloen.melon.custom.U0;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import ie.H;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u0000 72\u00020\u0001:\u000287B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0003J\u000F\u0010\u0011\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0003J\u000F\u0010\u0012\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0003J\u0011\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0016\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J!\u0010\"\u001A\u00020\r2\u0006\u0010!\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010$\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b$\u0010\u0003J\u000F\u0010%\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b%\u0010\u0003J\u000F\u0010\'\u001A\u00020&H\u0014\u00A2\u0006\u0004\b\'\u0010(R\u0014\u0010*\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010-\u001A\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00101\u001A\u00020,8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b/\u00100R\u0014\u00103\u001A\u0002028BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b3\u00104R\u0014\u00106\u001A\u00020\u000B8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b5\u0010\u0017\u00A8\u00069"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "secs", "", "getHoursString", "(J)Ljava/lang/String;", "getMinutesString", "getSecondsString", "", "timeInMinutes", "Lie/H;", "setTimer", "(I)V", "resetTimer", "startTimer", "stopTimer", "Landroid/app/PendingIntent;", "pendingIntent", "()Landroid/app/PendingIntent;", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment$TimerHandler;", "mTimerHandler", "Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment$TimerHandler;", "LJ8/U2;", "_binding", "LJ8/U2;", "getBinding", "()LJ8/U2;", "binding", "", "isStopTimer", "()Z", "getCurrentTimeMinutes", "currentTimeMinutes", "Companion", "TimerHandler", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingStopTimerFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001A\u00020\rH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_INITIALIZE", "MAX_HOUR", "", "MAX_MINUTE", "TIMER_STOP", "TIMER_START", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingStopTimerFragment newInstance() {
            SettingStopTimerFragment settingStopTimerFragment0 = new SettingStopTimerFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argInitialize", true);
            settingStopTimerFragment0.setArguments(bundle0);
            return settingStopTimerFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001A\u00020\b2\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment$TimerHandler;", "Lcom/iloen/melon/custom/U0;", "Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment;", "ref", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment;)V", "Landroid/os/Message;", "msg", "Lie/H;", "handleMessage", "(Lcom/iloen/melon/fragments/settings/SettingStopTimerFragment;Landroid/os/Message;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class TimerHandler extends U0 {
        public TimerHandler(@Nullable SettingStopTimerFragment settingStopTimerFragment0) {
            super(settingStopTimerFragment0);
        }

        public void handleMessage(@Nullable SettingStopTimerFragment settingStopTimerFragment0, @Nullable Message message0) {
            Integer integer0 = message0 == null ? null : message0.what;
            if(integer0 != null && ((int)integer0) == 0) {
                if(settingStopTimerFragment0 != null) {
                    settingStopTimerFragment0.stopTimer();
                }
            }
            else if(integer0 != null && ((int)integer0) == 1 && settingStopTimerFragment0 != null) {
                settingStopTimerFragment0.startTimer();
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((SettingStopTimerFragment)object0), message0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_INITIALIZE = "argInitialize";
    @NotNull
    public static final Companion Companion = null;
    private static final int MAX_HOUR = 12;
    private static final int MAX_MINUTE = 59;
    @NotNull
    private static final String TAG = "SettingStopTimerFragment";
    private static final int TIMER_START = 1;
    private static final int TIMER_STOP;
    @Nullable
    private U2 _binding;
    @NotNull
    private final TimerHandler mTimerHandler;

    static {
        SettingStopTimerFragment.Companion = new Companion(null);
        SettingStopTimerFragment.$stable = 8;
    }

    public SettingStopTimerFragment() {
        this.mTimerHandler = new TimerHandler(this);
    }

    private final U2 getBinding() {
        U2 u20 = this._binding;
        q.d(u20);
        return u20;
    }

    private final int getCurrentTimeMinutes() {
        return this.getBinding().b.getValue() * 60 + this.getBinding().c.getValue();
    }

    private final String getHoursString(long v) {
        return String.format("%02d", Arrays.copyOf(new Object[]{((long)(v / 3600L))}, 1));
    }

    private final String getMinutesString(long v) {
        return String.format("%02d", Arrays.copyOf(new Object[]{((long)(v % 3600L / 60L))}, 1));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settingsReserveStop");
    }

    private final String getSecondsString(long v) {
        return String.format("%02d", Arrays.copyOf(new Object[]{((long)(v % 60L))}, 1));
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309B4;  // string:setting_melon_etc_timer "예약 정지"
    }

    private final boolean isStopTimer() {
        return Calendar.getInstance().getTimeInMillis() > MelonSettingInfo.getMelonTimer();
    }

    @NotNull
    public static final SettingStopTimerFragment newInstance() {
        return SettingStopTimerFragment.Companion.newInstance();
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D083E, viewGroup0, false);  // layout:setting_stop_timer
        int v = 0x7F0A0542;  // id:hour_number_picker
        View view1 = I.C(view0, 0x7F0A0542);  // id:hour_number_picker
        if(((NumberPicker)view1) != null) {
            v = 0x7F0A080D;  // id:minute_number_picker
            View view2 = I.C(view0, 0x7F0A080D);  // id:minute_number_picker
            if(((NumberPicker)view2) != null) {
                v = 0x7F0A09E2;  // id:remain_hour_text
                View view3 = I.C(view0, 0x7F0A09E2);  // id:remain_hour_text
                if(((MelonTextView)view3) != null) {
                    v = 0x7F0A09E3;  // id:remain_minute_text
                    View view4 = I.C(view0, 0x7F0A09E3);  // id:remain_minute_text
                    if(((MelonTextView)view4) != null) {
                        v = 0x7F0A09E4;  // id:remain_second_text
                        View view5 = I.C(view0, 0x7F0A09E4);  // id:remain_second_text
                        if(((MelonTextView)view5) != null) {
                            v = 0x7F0A09E5;  // id:remain_time_container
                            View view6 = I.C(view0, 0x7F0A09E5);  // id:remain_time_container
                            if(((LinearLayout)view6) != null && ((ScrollView)I.C(view0, 0x7F0A0A78)) != null) {  // id:setting_scrollview
                                v = 0x7F0A0B88;  // id:time_container
                                View view7 = I.C(view0, 0x7F0A0B88);  // id:time_container
                                if(((LinearLayout)view7) != null) {
                                    v = 0x7F0A0B8B;  // id:timer_button
                                    View view8 = I.C(view0, 0x7F0A0B8B);  // id:timer_button
                                    if(((MelonTextView)view8) != null) {
                                        this._binding = new U2(((LinearLayout)view0), ((NumberPicker)view1), ((NumberPicker)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((MelonTextView)view5), ((LinearLayout)view6), ((LinearLayout)view7), ((MelonTextView)view8));
                                        return this.getBinding().a;
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

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        super.onPause();
        this.mTimerHandler.removeMessages(1);
        this.mTimerHandler.removeMessages(0);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        if(this.isStopTimer()) {
            this.resetTimer();
            return;
        }
        Context context0 = this.getContext();
        f f0 = new f(this, 2);
        if(com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, context0, null, f0, 2, null)) {
            this.mTimerHandler.removeMessages(1);
            this.mTimerHandler.sendEmptyMessage(1);
        }
    }

    private static final H onResume$lambda$3(SettingStopTimerFragment settingStopTimerFragment0) {
        settingStopTimerFragment0.resetTimer();
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        NumberPicker numberPicker0 = this.getBinding().b;
        numberPicker0.setValue(0);
        numberPicker0.setFormatter(NumberPicker.getTwoDigitFormatter());
        NumberPicker numberPicker1 = this.getBinding().c;
        numberPicker1.setValue(0);
        numberPicker1.setFormatter(NumberPicker.getTwoDigitFormatter());
        if(Build.VERSION.SDK_INT >= 30) {
            U2 u20 = this.getBinding();
            com.iloen.melon.fragments.settings.SettingStopTimerFragment.onViewCreated.1 settingStopTimerFragment$onViewCreated$10 = new WindowInsetsAnimation.Callback(numberPicker0, numberPicker1) {
                final NumberPicker $hourPicker;
                final NumberPicker $minutePicker;

                {
                    SettingStopTimerFragment.this = settingStopTimerFragment0;
                    this.$hourPicker = numberPicker0;
                    this.$minutePicker = numberPicker1;
                    super(0);
                }

                @Override  // android.view.WindowInsetsAnimation$Callback
                public void onEnd(WindowInsetsAnimation windowInsetsAnimation0) {
                    q.g(windowInsetsAnimation0, "animation");
                    super.onEnd(windowInsetsAnimation0);
                    boolean z = SettingStopTimerFragment.this.getBinding().h.getRootWindowInsets().isVisible(8);
                    this.$hourPicker.setItemHide(z);
                    this.$minutePicker.setItemHide(z);
                }

                @Override  // android.view.WindowInsetsAnimation$Callback
                public WindowInsets onProgress(WindowInsets windowInsets0, List list0) {
                    q.g(windowInsets0, "insets");
                    q.g(list0, "runningAnimations");
                    return windowInsets0;
                }
            };
            u20.h.setWindowInsetsAnimationCallback(settingStopTimerFragment$onViewCreated$10);
        }
        U2 u21 = this.getBinding();
        c c0 = new c(this, 4);
        u21.i.setOnClickListener(c0);
        this.calculateScrollView(this.findViewById(0x7F0A0A78));  // id:setting_scrollview
    }

    private static final void onViewCreated$lambda$2(SettingStopTimerFragment settingStopTimerFragment0, View view0) {
        if(settingStopTimerFragment0.isStopTimer()) {
            settingStopTimerFragment0.getBinding().b.clearFocus();
            settingStopTimerFragment0.getBinding().c.clearFocus();
            int v = settingStopTimerFragment0.getCurrentTimeMinutes();
            if(v > 0) {
                settingStopTimerFragment0.setTimer(v);
            }
            return;
        }
        settingStopTimerFragment0.resetTimer();
    }

    private final PendingIntent pendingIntent() {
        Context context0 = this.getContext();
        if(context0 != null && !TextUtils.isEmpty("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER")) {
            Intent intent0 = new Intent(context0, AlarmReceiver.class);
            intent0.setAction("com.iloen.melon.intent.action.PLAYBACK_STOP_TIMER");
            PendingIntent pendingIntent0 = PendingIntent.getBroadcast(context0, 0, intent0, 0x1C000000);
            q.f(pendingIntent0, "getBroadcast(...)");
            return pendingIntent0;
        }
        LogU.Companion.w("AlarmTrigger", "getPendingBroadcastIntent() invalid parameter.");
        return null;
    }

    private final void resetTimer() {
        o8.c.a(this.getContext(), this.pendingIntent());
        MelonSettingInfo.setMelonTimer(0L);
        this.mTimerHandler.removeMessages(1);
        this.mTimerHandler.sendEmptyMessage(0);
    }

    private final void setTimer(int v) {
        this.mTimerHandler.sendEmptyMessage(1);
        o8.c.g(this.getContext(), v, true);
    }

    private final void startTimer() {
        this.getBinding().i.setText(0x7F1309DA);  // string:setting_timer_reservation_cancel "취소"
        ViewUtils.hideWhen(this.getBinding().h, true);
        ViewUtils.showWhen(this.getBinding().g, true);
        long v = MelonSettingInfo.getMelonTimer();
        long v1 = Calendar.getInstance().getTimeInMillis();
        long v2 = (v - v1) / 1000L;
        U2 u20 = this.getBinding();
        String s = this.getHoursString(v2);
        u20.d.setText(s);
        U2 u21 = this.getBinding();
        String s1 = this.getMinutesString(v2);
        u21.e.setText(s1);
        U2 u22 = this.getBinding();
        String s2 = this.getSecondsString(v2);
        u22.f.setText(s2);
        this.getBinding().b.g();
        this.getBinding().c.g();
        if(v1 > v) {
            this.mTimerHandler.sendEmptyMessage(0);
            return;
        }
        this.mTimerHandler.sendEmptyMessageDelayed(1, 500L);
    }

    private final void stopTimer() {
        this.mTimerHandler.removeMessages(1);
        this.getBinding().i.setText(0x7F1309DB);  // string:setting_timer_reservation_start "시작하기"
        ViewUtils.showWhen(this.getBinding().h, true);
        ViewUtils.hideWhen(this.getBinding().g, true);
    }
}

