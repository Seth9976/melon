package com.iloen.melon.fragments.settings.alarm;

import B.a;
import De.I;
import F8.P;
import F8.o;
import J8.S2;
import J8.f2;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation.Callback;
import android.view.WindowInsetsAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.media3.session.H0;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.NumberPicker;
import com.iloen.melon.custom.RadioButton;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.detail.viewholder.s;
import com.iloen.melon.fragments.settings.w;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v3x.comments.ListMusicRes.result.MUSICLIST;
import com.iloen.melon.net.v3x.comments.ListMusicRes;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v6x.request.SongInfoReq;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.SongInfoRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.datastore.VoiceAlarmDataStoreKt;
import com.iloen.melon.utils.datastore.VoiceAlarmPreferenceKeys;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.system.VolumeUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.VoiceAlarm.Track;
import com.melon.net.res.VoiceAlarmKt;
import d3.g;
import e.k;
import ie.H;
import ie.j;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import l2.i;
import o8.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q2.h;
import vd.E;
import vd.G;
import we.n;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\b\u0005\b\u0007\u0018\u0000 n2\u00020\u0001:\u0001nB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001A\u00020\t2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\n\u0010\u000BJ+\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0015\u0010\u001D\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u0004\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u000F\u0010 \u001A\u00020\tH\u0016\u00A2\u0006\u0004\b \u0010\u0003J\u000F\u0010!\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b!\u0010\u0018J\u000F\u0010#\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010%\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b%\u0010\u0003J\u000F\u0010&\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b&\u0010\u0003J\u0017\u0010)\u001A\u00020\t2\u0006\u0010(\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001A\u00020\t2\u0006\u0010(\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b+\u0010*J\u0017\u0010,\u001A\u00020\t2\u0006\u0010(\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b,\u0010*J\u0017\u0010-\u001A\u00020\t2\u0006\u0010(\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b-\u0010*J\u001F\u0010/\u001A\u00020\t2\u0006\u0010.\u001A\u00020\u00042\u0006\u0010(\u001A\u00020\'H\u0002\u00A2\u0006\u0004\b/\u00100J\u001F\u00102\u001A\u00020\u00042\u0006\u0010.\u001A\u00020\u00042\u0006\u00101\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b2\u00103J\u0019\u00104\u001A\u00020\t2\b\b\u0001\u0010.\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b4\u0010\u001EJ\u0017\u00106\u001A\u00020\t2\u0006\u00105\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b6\u00107J\u0017\u00108\u001A\u00020\t2\u0006\u0010\u001C\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b8\u0010\u001EJ\u000F\u00109\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b9\u0010\u0003J\u0017\u0010;\u001A\u00020\t2\u0006\u0010:\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b;\u0010\u001EJ\u000F\u0010<\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b<\u0010\u0003J\u0017\u0010>\u001A\u00020\t2\u0006\u0010=\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b>\u0010\u001EJ\u0017\u0010@\u001A\u00020\t2\u0006\u0010?\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b@\u0010\u000BJ\u0019\u0010B\u001A\u00020\t2\b\b\u0002\u0010A\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bB\u00107J\u0017\u0010D\u001A\u00020\t2\u0006\u0010C\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bD\u00107J\u001F\u0010G\u001A\u00020\t2\u0006\u0010E\u001A\u00020\u00162\u0006\u0010F\u001A\u00020\"H\u0002\u00A2\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001A\u00020\t2\u0006\u00105\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bI\u00107J!\u0010K\u001A\u00020\t2\b\u0010\u0013\u001A\u0004\u0018\u00010J2\u0006\u0010E\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bK\u0010LJ\u000F\u0010M\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bM\u0010\u0003J\u000F\u0010N\u001A\u00020\tH\u0002\u00A2\u0006\u0004\bN\u0010\u0003J\u0013\u0010O\u001A\u00020\t*\u00020\'H\u0002\u00A2\u0006\u0004\bO\u0010*J\u0017\u0010R\u001A\u00020\t2\u0006\u0010Q\u001A\u00020PH\u0002\u00A2\u0006\u0004\bR\u0010SR\u0018\u0010U\u001A\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010X\u001A\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bX\u0010YR\u001B\u0010_\u001A\u00020Z8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b[\u0010\\\u001A\u0004\b]\u0010^R\u001E\u0010a\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010J0`8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010d\u001A\u00020c8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001A\u00020W8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bf\u0010gR\u0014\u0010i\u001A\u00020\u00168BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bi\u0010\u0018R\u0014\u0010m\u001A\u00020j8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bk\u0010l\u00A8\u0006o"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "getTitleResId", "()I", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "onBackPressed", "()Z", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "volume", "syncVolume", "(I)V", "onStop", "onDestroyView", "isBringToFrontFragment", "", "getFragmentTag", "()Ljava/lang/String;", "initAlarmData", "buildUi", "Lo8/d;", "alarm", "buildMusicTypeSettingView", "(Lo8/d;)V", "buildDayOfWeekSettingView", "buildTimePickerView", "buildSoundVolumeSettingView", "period", "correct24Hour", "(ILo8/d;)V", "hour", "convert12HourTo24Hour", "(II)I", "updateAmPm", "isOn", "updateAllDayCheckedState", "(Z)V", "updateSoundIcon", "defaultAlarmSoundType", "type", "setAlarmSoundType", "updateMusicAndVoiceTrackVisibility", "soundType", "updateCheckBoxSelection", "bundle", "setMusicAlarmSetting", "isForce", "updateMusicInfo", "isService", "updateSongItemLayout", "enabled", "message", "setEnableVoiceItemLayout", "(ZLjava/lang/String;)V", "updateRepeatAllButton", "Landroid/widget/TextView;", "setDayViewEnabled", "(Landroid/widget/TextView;Z)V", "saveAlarmSetting", "finishFragment", "updateCurrentTime", "Lcom/melon/net/res/VoiceAlarm$Track;", "track", "updateVoiceTrackItem", "(Lcom/melon/net/res/VoiceAlarm$Track;)V", "LF8/P;", "saveButton", "LF8/P;", "LJ8/S2;", "_binding", "LJ8/S2;", "Lcom/iloen/melon/fragments/settings/alarm/MusicAlarmViewModel;", "viewModel$delegate", "Lie/j;", "getViewModel", "()Lcom/iloen/melon/fragments/settings/alarm/MusicAlarmViewModel;", "viewModel", "", "mDayOfWeekView", "[Landroid/widget/TextView;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "mSeekBarChangedListener", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "getBinding", "()LJ8/S2;", "binding", "isCheckedAllWeekDay", "", "getDayOfWeekSelected", "()[Z", "dayOfWeekSelected", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingMusicAlarmFragment extends Hilt_SettingMusicAlarmFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\f2\n\b\u0002\u0010\u0011\u001A\u0004\u0018\u00010\u0012R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmFragment$Companion;", "", "<init>", "()V", "TAG", "", "SEARCH_SONG_REQUEST_KEY", "KEY_MUSIC", "KEY_VOICE_TRACK", "KEY_SOUND_TYPE", "KEY_ALARM_ID", "HOURS_IN_HALF_DAY", "", "STATUS_TRACK_EXPIRED", "newInstance", "Lcom/iloen/melon/fragments/settings/alarm/SettingMusicAlarmFragment;", "id", "track", "Lcom/melon/net/res/VoiceAlarm$Track;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingMusicAlarmFragment newInstance(int v, @Nullable Track voiceAlarm$Track0) {
            SettingMusicAlarmFragment settingMusicAlarmFragment0 = new SettingMusicAlarmFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("key_alarm_id", v);
            bundle0.putParcelable("voice_track", voiceAlarm$Track0);
            settingMusicAlarmFragment0.setArguments(bundle0);
            return settingMusicAlarmFragment0;
        }

        public static SettingMusicAlarmFragment newInstance$default(Companion settingMusicAlarmFragment$Companion0, int v, Track voiceAlarm$Track0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = 0;
            }
            if((v1 & 2) != 0) {
                voiceAlarm$Track0 = null;
            }
            return settingMusicAlarmFragment$Companion0.newInstance(v, voiceAlarm$Track0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int HOURS_IN_HALF_DAY = 12;
    @NotNull
    public static final String KEY_ALARM_ID = "key_alarm_id";
    @NotNull
    public static final String KEY_MUSIC = "music";
    @NotNull
    public static final String KEY_SOUND_TYPE = "sound_type";
    @NotNull
    public static final String KEY_VOICE_TRACK = "voice_track";
    @NotNull
    public static final String SEARCH_SONG_REQUEST_KEY = "music_alarm_search_song_request_key";
    @NotNull
    private static final String STATUS_TRACK_EXPIRED = "-1";
    @NotNull
    public static final String TAG = "SettingMusicAlarmFragment";
    @Nullable
    private S2 _binding;
    @NotNull
    private TextView[] mDayOfWeekView;
    @NotNull
    private final SeekBar.OnSeekBarChangeListener mSeekBarChangedListener;
    @Nullable
    private P saveButton;
    @NotNull
    private final j viewModel$delegate;

    static {
        SettingMusicAlarmFragment.Companion = new Companion(null);
        SettingMusicAlarmFragment.$stable = 8;
    }

    public SettingMusicAlarmFragment() {
        this.viewModel$delegate = g.Q(new b(this, 0));
        this.mDayOfWeekView = new TextView[7];
        this.mSeekBarChangedListener = new SeekBar.OnSeekBarChangeListener() {
            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
                q.g(seekBar0, "seekBar");
                if(z) {
                    d d0 = SettingMusicAlarmFragment.access$getViewModel(SettingMusicAlarmFragment.this).getMusicAlarm();
                    if(d0 != null) {
                        int v1 = SettingMusicAlarmFragment.access$getBinding(SettingMusicAlarmFragment.this).u.getProgress();
                        d0.d = v1;
                        SettingMusicAlarmFragment.this.syncVolume(v1);
                    }
                }
            }

            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar0) {
                q.g(seekBar0, "seekBar");
            }

            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar0) {
                q.g(seekBar0, "seekBar");
                d d0 = SettingMusicAlarmFragment.access$getViewModel(SettingMusicAlarmFragment.this).getMusicAlarm();
                if(d0 != null) {
                    int v = SettingMusicAlarmFragment.access$getBinding(SettingMusicAlarmFragment.this).u.getProgress();
                    d0.d = v;
                    SettingMusicAlarmFragment.this.syncVolume(v);
                }
            }
        };
    }

    public static void K(SettingMusicAlarmFragment settingMusicAlarmFragment0, d d0, View view0) {
        SettingMusicAlarmFragment.buildDayOfWeekSettingView$lambda$20(d0, settingMusicAlarmFragment0, view0);
    }

    public static void N(S2 s20, d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        SettingMusicAlarmFragment.buildMusicTypeSettingView$lambda$17$lambda$11(s20, d0, settingMusicAlarmFragment0, view0);
    }

    public static void Q(SettingMusicAlarmFragment settingMusicAlarmFragment0, d d0, View view0) {
        SettingMusicAlarmFragment.buildSoundVolumeSettingView$lambda$27(d0, settingMusicAlarmFragment0, view0);
    }

    public static void U(SettingMusicAlarmFragment settingMusicAlarmFragment0, d d0, View view0) {
        SettingMusicAlarmFragment.buildSoundVolumeSettingView$lambda$28(d0, settingMusicAlarmFragment0, view0);
    }

    public static void V(SettingMusicAlarmFragment settingMusicAlarmFragment0, d d0, View view0) {
        SettingMusicAlarmFragment.buildMusicTypeSettingView$lambda$17$lambda$9(d0, settingMusicAlarmFragment0, view0);
    }

    public static void Z(SettingMusicAlarmFragment settingMusicAlarmFragment0, NumberPicker numberPicker0, NumberPicker numberPicker1, int v, int v1) {
        SettingMusicAlarmFragment.buildTimePickerView$lambda$25$lambda$24(settingMusicAlarmFragment0, numberPicker0, numberPicker1, v, v1);
    }

    public static final MusicAlarmViewModel access$getViewModel(SettingMusicAlarmFragment settingMusicAlarmFragment0) {
        return settingMusicAlarmFragment0.getViewModel();
    }

    private final void buildDayOfWeekSettingView(d d0) {
        boolean z = false;
        int v = 0;
        int v1 = 0;
        while(v < this.getBinding().n.getChildCount()) {
            View view0 = this.getBinding().n.getChildAt(v);
            if(view0 instanceof TextView) {
                this.mDayOfWeekView[v1] = view0;
                ++v;
                ++v1;
            }
            else {
                ++v;
            }
        }
        for(int v2 = 0; v2 < this.mDayOfWeekView.length; ++v2) {
            TextView textView0 = this.mDayOfWeekView[v2];
            this.setDayViewEnabled(textView0, d0.f[v2]);
            if(textView0 != null) {
                textView0.setOnClickListener(new c(d0, this, 4));
            }
        }
        this.updateRepeatAllButton(this.isCheckedAllWeekDay());
        P p0 = this.saveButton;
        if(p0 != null) {
            boolean[] arr_z = d0.f;
            int v4 = 0;
            for(int v3 = 0; v3 < arr_z.length; ++v3) {
                if(arr_z[v3]) {
                    ++v4;
                }
            }
            if(v4 > 0) {
                z = true;
            }
            p0.j(z);
        }
        this.getBinding().p.setChecked(!d0.h);
        S2 s20 = this.getBinding();
        f f0 = (CompoundButton compoundButton0, boolean z) -> {
            if(compoundButton0.isPressed()) {
                ToastManager.show((z ? 0x7F13095C : 0x7F13095B));  // string:setting_auto_play_set_on_repeat "알람이 해당 요일에 반복 설정됩니다."
            }
            d0.h = !z;
            if(!z) {
                this.updateRepeatAllButton(false);
                this.updateAllDayCheckedState(false);
                boolean[] arr_z = this.getDayOfWeekSelected();
                q.g(arr_z, "<set-?>");
                d0.f = arr_z;
                P p0 = this.saveButton;
                if(p0 != null) {
                    p0.j(false);
                }
            }
        };
        s20.p.setOnCheckedChangeListener(f0);
    }

    private static final void buildDayOfWeekSettingView$lambda$20(d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        boolean z = view0.isSelected();
        boolean z1 = false;
        if(d0.h) {
            settingMusicAlarmFragment0.updateAllDayCheckedState(false);
        }
        settingMusicAlarmFragment0.setDayViewEnabled(((TextView)view0), !z);
        settingMusicAlarmFragment0.updateRepeatAllButton(settingMusicAlarmFragment0.isCheckedAllWeekDay());
        boolean[] arr_z = settingMusicAlarmFragment0.getDayOfWeekSelected();
        q.g(arr_z, "<set-?>");
        d0.f = arr_z;
        P p0 = settingMusicAlarmFragment0.saveButton;
        if(p0 != null) {
            int v1 = 0;
            for(int v = 0; v < arr_z.length; ++v) {
                if(arr_z[v]) {
                    ++v1;
                }
            }
            if(v1 > 0) {
                z1 = true;
            }
            p0.j(z1);
        }
    }

    // 检测为 Lambda 实现
    private static final void buildDayOfWeekSettingView$lambda$22(d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, CompoundButton compoundButton0, boolean z) [...]

    private final void buildMusicTypeSettingView(d d0) {
        S2 s20 = this.getBinding();
        f2 f20 = s20.r;
        f2 f21 = s20.l;
        c c0 = new c(d0, this, 2);
        s20.d.setOnClickListener(c0);
        c c1 = new c(this, d0);
        s20.f.setOnClickListener(c1);
        s s0 = new s(s20, d0, this, 2);
        s20.h.setOnClickListener(s0);
        if(d0.i == 1 && (d0.g == null || d0.g.length() == 0) || d0.i == 2 && d0.m == null) {
            d0.i = 0;
        }
        this.setAlarmSoundType(d0.i);
        f21.c.setVisibility(8);
        f21.b.setVisibility(8);
        ((MelonTextView)f21.d.c).setVisibility(0);
        Gd.f f0 = new Gd.f(14);
        ((MelonTextView)f21.d.c).setOnClickListener(f0);
        s20.m.setVisibility((d0.g == null || d0.g.length() == 0 ? 8 : 0));
        if(d0.g != null && d0.g.length() != 0) {
            SettingMusicAlarmFragment.updateMusicInfo$default(this, false, 1, null);
        }
        f20.c.setVisibility(8);
        f20.b.setVisibility(8);
        ((MelonTextView)f20.d.c).setVisibility(0);
        Gd.f f1 = new Gd.f(15);
        ((MelonTextView)f20.d.c).setOnClickListener(f1);
        Track voiceAlarm$Track0 = d0.m;
        if(voiceAlarm$Track0 != null) {
            this.updateVoiceTrackItem(voiceAlarm$Track0);
        }
    }

    private static final void buildMusicTypeSettingView$lambda$17$lambda$10(SettingMusicAlarmFragment settingMusicAlarmFragment0, d d0, View view0) {
        settingMusicAlarmFragment0.updateCheckBoxSelection(1);
        if(d0.g != null && d0.g.length() != 0) {
            d0.i = 1;
            return;
        }
        SettingMusicAlarmSongFragment.Companion.newInstance().open();
    }

    private static final void buildMusicTypeSettingView$lambda$17$lambda$11(S2 s20, d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        s20.h.setChecked(false);
        if(d0.m == null) {
            Navigator.INSTANCE.openVoiceAlarm();
            return;
        }
        d0.i = 2;
        settingMusicAlarmFragment0.updateCheckBoxSelection(2);
    }

    private static final void buildMusicTypeSettingView$lambda$17$lambda$13$lambda$12(View view0) {
        SettingMusicAlarmSongFragment.Companion.newInstance().open();
    }

    private static final void buildMusicTypeSettingView$lambda$17$lambda$15$lambda$14(View view0) {
        Navigator.INSTANCE.openVoiceAlarm();
    }

    private static final void buildMusicTypeSettingView$lambda$17$lambda$9(d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        d0.i = 0;
        settingMusicAlarmFragment0.updateCheckBoxSelection(0);
    }

    private final void buildSoundVolumeSettingView(d d0) {
        this.updateSoundIcon(d0.d);
        int v = ScreenUtils.dipToPixel(this.getContext(), 5.5f);
        this.getBinding().u.setPadding(v, 0, v, 0);
        S2 s20 = this.getBinding();
        Context context0 = this.getContext();
        int v1 = com.iloen.melon.utils.system.VolumeUtils.Companion.getMaxVolume$default(VolumeUtils.Companion, context0, null, 2, null);
        s20.u.setMax(v1);
        this.getBinding().u.setProgress(d0.d);
        this.getBinding().u.setOnSeekBarChangeListener(this.mSeekBarChangedListener);
        S2 s21 = this.getBinding();
        c c0 = new c(d0, this, 0);
        s21.t.setOnClickListener(c0);
        S2 s22 = this.getBinding();
        c c1 = new c(d0, this, 1);
        s22.v.setOnClickListener(c1);
    }

    private static final void buildSoundVolumeSettingView$lambda$27(d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        int v = d0.d;
        if(v > 0) {
            d0.d = v - 1;
            settingMusicAlarmFragment0.syncVolume(v - 1);
        }
    }

    private static final void buildSoundVolumeSettingView$lambda$28(d d0, SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        int v = d0.d;
        Context context0 = settingMusicAlarmFragment0.requireContext();
        if(v < com.iloen.melon.utils.system.VolumeUtils.Companion.getMaxVolume$default(VolumeUtils.Companion, context0, null, 2, null)) {
            int v1 = d0.d + 1;
            d0.d = v1;
            settingMusicAlarmFragment0.syncVolume(v1);
        }
    }

    private final void buildTimePickerView(d d0) {
        NumberPicker numberPicker0 = this.getBinding().c;
        String[] arr_s = numberPicker0.getContext().getResources().getStringArray(0x7F030060);  // array:time_am_pm
        q.f(arr_s, "getStringArray(...)");
        numberPicker0.setDisplayedValues(arr_s);
        int v = 0;
        numberPicker0.setSelectorFocusable(false);
        q.g(d0, "<this>");
        int v1 = 12;
        if(12 <= d0.b && d0.b < 24) {
            v = 1;
        }
        numberPicker0.setValue(v);
        NumberPicker numberPicker1 = this.getBinding().i;
        int v2 = d0.b;
        if(v2 > 12) {
            v1 = v2 - 12;
        }
        else if(v2 != 0) {
            v1 = v2;
        }
        numberPicker1.setValue(v1);
        numberPicker1.setOnValueChangedListener(new H0(16, this, numberPicker0));
        NumberPicker numberPicker2 = this.getBinding().k;
        numberPicker2.setValue(d0.c);
        numberPicker2.setFormatter(NumberPicker.getTwoDigitFormatter());
        if(Build.VERSION.SDK_INT >= 30) {
            S2 s20 = this.getBinding();
            com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.buildTimePickerView.1 settingMusicAlarmFragment$buildTimePickerView$10 = new WindowInsetsAnimation.Callback(numberPicker1, numberPicker2) {
                final NumberPicker $hourPicker;
                final NumberPicker $minutePicker;

                {
                    SettingMusicAlarmFragment.this = settingMusicAlarmFragment0;
                    this.$hourPicker = numberPicker0;
                    this.$minutePicker = numberPicker1;
                    super(0);
                }

                @Override  // android.view.WindowInsetsAnimation$Callback
                public void onEnd(WindowInsetsAnimation windowInsetsAnimation0) {
                    q.g(windowInsetsAnimation0, "animation");
                    super.onEnd(windowInsetsAnimation0);
                    boolean z = SettingMusicAlarmFragment.this.getBinding().q.getRootWindowInsets().isVisible(8);
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
            s20.q.setWindowInsetsAnimationCallback(settingMusicAlarmFragment$buildTimePickerView$10);
        }
    }

    private static final void buildTimePickerView$lambda$25$lambda$24(SettingMusicAlarmFragment settingMusicAlarmFragment0, NumberPicker numberPicker0, NumberPicker numberPicker1, int v, int v1) {
        if(v == 11 && v1 == 12 || v == 12 && v1 == 11) {
            settingMusicAlarmFragment0.updateAmPm(numberPicker0.getValue());
        }
    }

    private final void buildUi() {
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            P p0 = new P();  // 初始化器: Ljava/lang/Object;-><init>()V
            p0.c = new com.iloen.melon.fragments.settings.alarm.d(this, 0);
            this.saveButton = p0;
            o o0 = a.s(1);
            o0.g(p0);
            titleBar0.a(o0);
            titleBar0.setTitle(this.getString(0x7F1309E6));  // string:setting_title_etc_alarm_setting "알람 설정"
            titleBar0.f(false);
        }
        S2 s20 = this.getBinding();
        e e0 = (View view0, int v, int v1, int v2, int v3) -> this.showScrolledLine(v1 > 0);
        s20.b.setOnScrollChangeListener(e0);
        d d0 = this.getViewModel().getMusicAlarm();
        int v = this.getViewModel().getMusicAlarmId();
        LogU.Companion.d("SettingMusicAlarmFragment", "buildUi: " + d0 + ", musicAlarmId=" + v + "}");
        d d1 = this.getViewModel().getMusicAlarm();
        if(d1 != null) {
            this.buildSoundVolumeSettingView(d1);
            this.buildTimePickerView(d1);
            this.buildDayOfWeekSettingView(d1);
            this.buildMusicTypeSettingView(d1);
        }
    }

    private static final void buildUi$lambda$6$lambda$5$lambda$4(SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        settingMusicAlarmFragment0.saveAlarmSetting();
        settingMusicAlarmFragment0.getViewModel().sendSaveClickLog();
        MusicAlarmPrefsHelper.INSTANCE.sendMusicAlarmListLog();
    }

    // 检测为 Lambda 实现
    private static final void buildUi$lambda$7(SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0, int v, int v1, int v2, int v3) [...]

    private final int convert12HourTo24Hour(int v, int v1) {
        if(v == 0 && v1 == 12) {
            return 0;
        }
        return v != 1 || v1 == 12 ? v1 : v1 + 12;
    }

    private final void correct24Hour(int v, d d0) {
        if(v == 0) {
            int v1 = d0.b;
            if(v1 >= 12) {
                d0.b = v1 - 12;
                return;
            }
        }
        if(v == 1) {
            int v2 = d0.b;
            if(v2 < 12) {
                d0.b = v2 + 12;
            }
        }
    }

    private final void defaultAlarmSoundType() {
        this.setAlarmSoundType(0);
    }

    private final void finishFragment() {
        if(H0.e.N(this)) {
            this.requireActivity().getOnBackPressedDispatcher().c();
        }
    }

    private final S2 getBinding() {
        S2 s20 = this._binding;
        q.d(s20);
        return s20;
    }

    private final boolean[] getDayOfWeekSelected() {
        TextView[] arr_textView = this.mDayOfWeekView;
        boolean[] arr_z = new boolean[arr_textView.length];
        for(int v = 0; v < arr_textView.length; ++v) {
            boolean z = true;
            TextView textView0 = this.mDayOfWeekView[v];
            if(textView0 == null || !textView0.isSelected()) {
                z = false;
            }
            arr_z[v] = z;
        }
        return arr_z;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public String getFragmentTag() {
        return "SettingMusicAlarmFragment";
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.requireContext(), "settingsAlarm");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309E6;  // string:setting_title_etc_alarm_setting "알람 설정"
    }

    private final MusicAlarmViewModel getViewModel() {
        return (MusicAlarmViewModel)this.viewModel$delegate.getValue();
    }

    private final void initAlarmData() {
        if(this.getViewModel().getMusicAlarm() == null) {
            if(this.getViewModel().getMusicAlarmId() == 0) {
                GregorianCalendar gregorianCalendar0 = new GregorianCalendar();
                MusicAlarmViewModel musicAlarmViewModel0 = this.getViewModel();
                int v = gregorianCalendar0.get(11);
                int v1 = gregorianCalendar0.get(12);
                Track voiceAlarm$Track0 = this.getViewModel().getVoiceTrackSavedState();
                d d0 = new d(v, v1, 0, (this.getViewModel().getVoiceTrackSavedState() == null ? 0 : 2), voiceAlarm$Track0, 0xEF9);
                boolean[] arr_z = d0.f;
                arr_z[gregorianCalendar0.get(7) - 1] = true;
                musicAlarmViewModel0.setMusicAlarm(d0);
                return;
            }
            int v2 = this.getViewModel().getMusicAlarmId();
            d d1 = MusicAlarmPrefsHelper.INSTANCE.getAlarm(v2);
            if(d1 != null) {
                this.getViewModel().setMusicAlarm(d1);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isBringToFrontFragment() {
        return true;
    }

    private final boolean isCheckedAllWeekDay() {
        TextView[] arr_textView = this.mDayOfWeekView;
        if(arr_textView == null) {
            return false;
        }
        q.d(arr_textView);
        for(int v = 0; v < arr_textView.length; ++v) {
            TextView textView0 = arr_textView[v];
            q.d(textView0);
            if(!textView0.isSelected()) {
                return false;
            }
        }
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        this.initAlarmData();
        Q1.c.R(this, "music_alarm_search_song_request_key", new com.iloen.melon.fragments.settings.alarm.a(this, 0));
    }

    private static final H onCreate$lambda$1(SettingMusicAlarmFragment settingMusicAlarmFragment0, String s, Bundle bundle0) {
        q.g(s, "<unused var>");
        q.g(bundle0, "bundle");
        settingMusicAlarmFragment0.setMusicAlarmSetting(bundle0);
        return H.a;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0822, viewGroup0, false);  // layout:setting_alarm
        int v = 0x7F0A007E;  // id:alarm_scroll_view
        View view1 = I.C(view0, 0x7F0A007E);  // id:alarm_scroll_view
        if(((ScrollView)view1) != null) {
            v = 0x7F0A009A;  // id:am_pm_picker
            View view2 = I.C(view0, 0x7F0A009A);  // id:am_pm_picker
            if(((NumberPicker)view2) != null && ((LinearLayout)I.C(view0, 0x7F0A00D9)) != null) {  // id:auto_play_setting_variable_layout
                v = 0x7F0A0253;  // id:check_playlist
                View view3 = I.C(view0, 0x7F0A0253);  // id:check_playlist
                if(view3 != null) {
                    CheckBox checkBox0 = (CheckBox)view3;
                    v = 0x7F0A0254;  // id:check_playlist_layout
                    View view4 = I.C(view0, 0x7F0A0254);  // id:check_playlist_layout
                    if(((RadioButton)view4) != null) {
                        v = 0x7F0A0257;  // id:check_song
                        View view5 = I.C(view0, 0x7F0A0257);  // id:check_song
                        if(view5 != null) {
                            CheckBox checkBox1 = (CheckBox)view5;
                            v = 0x7F0A0258;  // id:check_song_desc
                            View view6 = I.C(view0, 0x7F0A0258);  // id:check_song_desc
                            if(((MelonTextView)view6) != null) {
                                v = 0x7F0A0259;  // id:check_song_layout
                                View view7 = I.C(view0, 0x7F0A0259);  // id:check_song_layout
                                if(((RadioButton)view7) != null) {
                                    v = 0x7F0A025A;  // id:check_voice
                                    View view8 = I.C(view0, 0x7F0A025A);  // id:check_voice
                                    if(view8 != null) {
                                        CheckBox checkBox2 = (CheckBox)view8;
                                        v = 0x7F0A025B;  // id:check_voice_desc
                                        View view9 = I.C(view0, 0x7F0A025B);  // id:check_voice_desc
                                        if(((MelonTextView)view9) != null) {
                                            v = 0x7F0A025C;  // id:check_voice_layout
                                            View view10 = I.C(view0, 0x7F0A025C);  // id:check_voice_layout
                                            if(((RadioButton)view10) != null) {
                                                v = 0x7F0A0543;  // id:hour_picker
                                                View view11 = I.C(view0, 0x7F0A0543);  // id:hour_picker
                                                if(((NumberPicker)view11) != null) {
                                                    v = 0x7F0A0689;  // id:iv_setting_sound
                                                    View view12 = I.C(view0, 0x7F0A0689);  // id:iv_setting_sound
                                                    if(((ImageView)view12) != null) {
                                                        v = 0x7F0A080E;  // id:minute_picker
                                                        View view13 = I.C(view0, 0x7F0A080E);  // id:minute_picker
                                                        if(((NumberPicker)view13) != null) {
                                                            v = 0x7F0A0883;  // id:music_item
                                                            View view14 = I.C(view0, 0x7F0A0883);  // id:music_item
                                                            if(view14 != null) {
                                                                f2 f20 = f2.a(view14);
                                                                v = 0x7F0A0884;  // id:music_layout
                                                                View view15 = I.C(view0, 0x7F0A0884);  // id:music_layout
                                                                if(((LinearLayout)view15) != null && ((ImageView)I.C(view0, 0x7F0A08AF)) != null) {  // id:new_iv
                                                                    v = 0x7F0A09E7;  // id:repeat_day_of_week_setting
                                                                    View view16 = I.C(view0, 0x7F0A09E7);  // id:repeat_day_of_week_setting
                                                                    if(((LinearLayout)view16) != null) {
                                                                        v = 0x7F0A09E8;  // id:repeat_day_of_week_setting_all
                                                                        View view17 = I.C(view0, 0x7F0A09E8);  // id:repeat_day_of_week_setting_all
                                                                        if(((MelonTextView)view17) != null && ((MelonTextView)I.C(view0, 0x7F0A09E9)) != null) {  // id:repeat_day_of_week_setting_all_desc
                                                                            v = 0x7F0A0A74;  // id:setting_auto_play_repeat_every_week_checkbox
                                                                            View view18 = I.C(view0, 0x7F0A0A74);  // id:setting_auto_play_repeat_every_week_checkbox
                                                                            if(((AppCompatCheckBox)view18) != null && ((LinearLayout)I.C(view0, 0x7F0A0A79)) != null) {  // id:setting_volume_container
                                                                                v = 0x7F0A0B8C;  // id:timer_container
                                                                                View view19 = I.C(view0, 0x7F0A0B8C);  // id:timer_container
                                                                                if(((LinearLayout)view19) != null) {
                                                                                    v = 0x7F0A0DDD;  // id:voice_item
                                                                                    View view20 = I.C(view0, 0x7F0A0DDD);  // id:voice_item
                                                                                    if(view20 != null) {
                                                                                        f2 f21 = f2.a(view20);
                                                                                        v = 0x7F0A0DDE;  // id:voice_track_layout
                                                                                        View view21 = I.C(view0, 0x7F0A0DDE);  // id:voice_track_layout
                                                                                        if(((LinearLayout)view21) != null && ((LinearLayout)I.C(view0, 0x7F0A0DDF)) != null) {  // id:volume_control_container
                                                                                            v = 0x7F0A0DE0;  // id:volume_down
                                                                                            View view22 = I.C(view0, 0x7F0A0DE0);  // id:volume_down
                                                                                            if(((ImageView)view22) != null) {
                                                                                                v = 0x7F0A0DE2;  // id:volume_seekbar
                                                                                                View view23 = I.C(view0, 0x7F0A0DE2);  // id:volume_seekbar
                                                                                                if(((SeekBar)view23) != null) {
                                                                                                    v = 0x7F0A0DE3;  // id:volume_up
                                                                                                    View view24 = I.C(view0, 0x7F0A0DE3);  // id:volume_up
                                                                                                    if(((ImageView)view24) != null) {
                                                                                                        this._binding = new S2(((LinearLayout)view0), ((ScrollView)view1), ((NumberPicker)view2), ((RadioButton)view4), ((MelonTextView)view6), ((RadioButton)view7), ((MelonTextView)view9), ((RadioButton)view10), ((NumberPicker)view11), ((ImageView)view12), ((NumberPicker)view13), f20, ((LinearLayout)view15), ((LinearLayout)view16), ((MelonTextView)view17), ((AppCompatCheckBox)view18), ((LinearLayout)view19), f21, ((LinearLayout)view21), ((ImageView)view22), ((SeekBar)view23), ((ImageView)view24));
                                                                                                        S2 s20 = this.getBinding();
                                                                                                        q.f(s20.a, "getRoot(...)");
                                                                                                        return s20.a;
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

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        d d0 = this.getViewModel().getMusicAlarm();
        if(d0 != null) {
            this.updateCurrentTime(d0);
            this.getViewModel().setMusicAlarmSavedState(d0.a());
        }
        super.onStop();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.buildUi();
    }

    private final void saveAlarmSetting() {
        boolean[] arr_z = this.getDayOfWeekSelected();
        q.g(arr_z, "<this>");
        int v;
        for(v = 0; true; ++v) {
            if(v >= arr_z.length) {
                v = -1;
                break;
            }
            if(arr_z[v]) {
                break;
            }
        }
        if(v >= 0) {
            d d0 = this.getViewModel().getMusicAlarm();
            if(d0 != null) {
                if(d0.a == 0) {
                    MusicAlarmPrefsHelper musicAlarmPrefsHelper0 = MusicAlarmPrefsHelper.INSTANCE;
                    if(musicAlarmPrefsHelper0.getAlarmList().isEmpty()) {
                        d0.a = 1;
                    }
                    else {
                        Iterator iterator0 = musicAlarmPrefsHelper0.getAlarmList().iterator();
                        if(!iterator0.hasNext()) {
                            throw new NoSuchElementException();
                        }
                        Object object0 = iterator0.next();
                        Integer integer0 = ((d)object0).a;
                        while(iterator0.hasNext()) {
                            Object object1 = iterator0.next();
                            Integer integer1 = ((d)object1).a;
                            if(integer0.compareTo(integer1) < 0) {
                                integer0 = integer1;
                            }
                        }
                        d0.a = integer0.intValue() + 1;
                    }
                }
                d0.e = true;
                d0.h = !this.getBinding().p.isChecked();
                d0.b = this.convert12HourTo24Hour(this.getBinding().c.getValue(), this.getBinding().i.getValue());
                this.correct24Hour(this.getBinding().c.getValue(), d0);
                d0.c = this.getBinding().k.getValue();
                LogU.Companion.d("SettingMusicAlarmFragment", "saveAlarmSetting: " + d0);
                long v1 = o8.e.d(d0);
                Context context0 = this.requireContext();
                if(com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion.canScheduleExactAlarms$default(AlarmPermissionHelper.Companion, context0, null, null, 6, null)) {
                    o8.c.f(v1, d0.a, true);
                    MusicAlarmPrefsHelper.INSTANCE.addAlarm(d0);
                    if(d0.i == 2) {
                        D d1 = this.getViewLifecycleOwner();
                        q.f(d1, "getViewLifecycleOwner(...)");
                        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new n(null) {
                            int label;

                            {
                                SettingMusicAlarmFragment.this = settingMusicAlarmFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2(SettingMusicAlarmFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        Context context0 = SettingMusicAlarmFragment.this.getContext();
                                        if(context0 != null) {
                                            i i0 = VoiceAlarmDataStoreKt.getVoiceAlarmDataStore(context0);
                                            if(i0 != null) {
                                                Flow flow0 = i0.getData();
                                                if(flow0 != null) {
                                                    com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1 settingMusicAlarmFragment$saveAlarmSetting$1$2$10 = new n(null) {
                                                        Object L$0;
                                                        int label;

                                                        {
                                                            SettingMusicAlarmFragment.this = settingMusicAlarmFragment0;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            Continuation continuation1 = new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1(SettingMusicAlarmFragment.this, continuation0);
                                                            continuation1.L$0 = object0;
                                                            return continuation1;
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((h)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(h h0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1)this.create(h0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            h h0 = (h)this.L$0;
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            Boolean boolean0 = (Boolean)h0.b(VoiceAlarmPreferenceKeys.INSTANCE.getDO_NOT_SHOW_VOICE_ALARM_SAVE_POPUP());
                                                            if((boolean0 == null ? false : boolean0.booleanValue())) {
                                                                SettingMusicAlarmFragment.this.finishFragment();
                                                                return H.a;
                                                            }
                                                            l0 l00 = SettingMusicAlarmFragment.this.getChildFragmentManager();
                                                            String s = SettingMusicAlarmFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                                                            String s1 = SettingMusicAlarmFragment.this.getString(0x7F13093D);  // string:setting_alarm_voice_expire_info "보이스알람 이용권 종료 시,\n‘듣던 곡 재생’으로 알람이 재생되며 재생 
                                                                                                                               // 목록에 곡이 없을 경우,\n알람 음악이 재생되지 않습니다."
                                                            com.iloen.melon.fragments.settings.alarm.g g0 = new com.iloen.melon.fragments.settings.alarm.g(SettingMusicAlarmFragment.this, 0);
                                                            E e0 = E.a;
                                                            if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
                                                                l00.C();
                                                                if(com.melon.ui.popup.b.b(l00, "showCheckBoxPopup", e0, null, 8) == null) {
                                                                    e3.h.t(s, s1, null, false, null, null, new sd.j(12), new G(g0, 1), true, false, vd.h.b, false, null, 0xD450).show(l00, "showCheckBoxPopup");
                                                                }
                                                            }
                                                            return H.a;

                                                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                                                            @oe.e(c = "com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment$saveAlarmSetting$1$2$1$1$1", f = "SettingMusicAlarmFragment.kt", l = {0x29F}, m = "invokeSuspend")
                                                            final class com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1 extends oe.i implements n {
                                                                final boolean $isChecked;
                                                                int label;

                                                                public com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1(boolean z, SettingMusicAlarmFragment settingMusicAlarmFragment0, Continuation continuation0) {
                                                                    this.$isChecked = z;
                                                                    SettingMusicAlarmFragment.this = settingMusicAlarmFragment0;
                                                                    super(2, continuation0);
                                                                }

                                                                @Override  // oe.a
                                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                                    return new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1(this.$isChecked, SettingMusicAlarmFragment.this, continuation0);
                                                                }

                                                                @Override  // we.n
                                                                public Object invoke(Object object0, Object object1) {
                                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                }

                                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                    return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                }

                                                                @Override  // oe.a
                                                                public final Object invokeSuspend(Object object0) {
                                                                    h h0;
                                                                    ne.a a0 = ne.a.a;
                                                                    switch(this.label) {
                                                                        case 0: {
                                                                            d5.n.D(object0);
                                                                            l1.B("saveAlarmSetting: ", this.$isChecked, LogU.Companion, "SettingMusicAlarmFragment");
                                                                            if(this.$isChecked) {
                                                                                Context context0 = SettingMusicAlarmFragment.this.getContext();
                                                                                if(context0 != null) {
                                                                                    i i0 = VoiceAlarmDataStoreKt.getVoiceAlarmDataStore(context0);
                                                                                    if(i0 != null) {
                                                                                        com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1.1 settingMusicAlarmFragment$saveAlarmSetting$1$2$1$1$1$10 = new n() {
                                                                                            Object L$0;
                                                                                            int label;

                                                                                            {
                                                                                                super(2, continuation0);
                                                                                            }

                                                                                            @Override  // oe.a
                                                                                            public final Continuation create(Object object0, Continuation continuation0) {
                                                                                                Continuation continuation1 = new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1.1(continuation0);
                                                                                                continuation1.L$0 = object0;
                                                                                                return continuation1;
                                                                                            }

                                                                                            @Override  // we.n
                                                                                            public Object invoke(Object object0, Object object1) {
                                                                                                return this.invoke(((q2.b)object0), ((Continuation)object1));
                                                                                            }

                                                                                            public final Object invoke(q2.b b0, Continuation continuation0) {
                                                                                                return ((com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1.1)this.create(b0, continuation0)).invokeSuspend(H.a);
                                                                                            }

                                                                                            @Override  // oe.a
                                                                                            public final Object invokeSuspend(Object object0) {
                                                                                                q2.b b0 = (q2.b)this.L$0;
                                                                                                if(this.label != 0) {
                                                                                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                                                                }
                                                                                                d5.n.D(object0);
                                                                                                b0.g(VoiceAlarmPreferenceKeys.INSTANCE.getDO_NOT_SHOW_VOICE_ALARM_SAVE_POPUP(), Boolean.TRUE);
                                                                                                return H.a;
                                                                                            }
                                                                                        };
                                                                                        this.label = 1;
                                                                                        object0 = k.n(i0, settingMusicAlarmFragment$saveAlarmSetting$1$2$1$1$1$10, this);
                                                                                        if(object0 == a0) {
                                                                                            return a0;
                                                                                        }
                                                                                        h0 = (h)object0;
                                                                                    }
                                                                                }
                                                                            }
                                                                            break;
                                                                        }
                                                                        case 1: {
                                                                            d5.n.D(object0);
                                                                            h0 = (h)object0;
                                                                            break;
                                                                        }
                                                                        default: {
                                                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                                        }
                                                                    }
                                                                    SettingMusicAlarmFragment.this.finishFragment();
                                                                    return H.a;
                                                                }
                                                            }

                                                        }

                                                        private static final H invokeSuspend$lambda$0(SettingMusicAlarmFragment settingMusicAlarmFragment0, boolean z) {
                                                            D d0 = settingMusicAlarmFragment0.getViewLifecycleOwner();
                                                            q.f(d0, "getViewLifecycleOwner(...)");
                                                            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment.saveAlarmSetting.1.2.1.1.1(z, settingMusicAlarmFragment0, null), 3, null);
                                                            return H.a;
                                                        }
                                                    };
                                                    this.label = 1;
                                                    if(FlowKt.collectLatest(flow0, settingMusicAlarmFragment$saveAlarmSetting$1$2$10, this) == a0) {
                                                        return a0;
                                                    }
                                                }
                                            }
                                        }
                                        return H.a;
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
                        return;
                    }
                    this.finishFragment();
                }
            }
            return;
        }
        ToastManager.show(0x7F130959);  // string:setting_auto_play_none_check_dayofweek "요일을 선택해주세요."
    }

    private final void setAlarmSoundType(int v) {
        S2 s20 = this.getBinding();
        boolean z = false;
        s20.d.setChecked(v == 0);
        s20.f.setChecked(v == 1);
        RadioButton radioButton0 = s20.h;
        if(v == 2) {
            z = true;
        }
        radioButton0.setChecked(z);
        this.updateMusicAndVoiceTrackVisibility();
    }

    private final void setDayViewEnabled(TextView textView0, boolean z) {
        if(textView0 == null) {
            return;
        }
        textView0.setBackgroundResource((z ? 0x7F080856 : 0x7F08085E));  // drawable:shape_circle_green502s
        textView0.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604A1 : 0x7F060160)));  // color:white000e
        textView0.setSelected(z);
    }

    private final void setEnableVoiceItemLayout(boolean z, String s) {
        if(!z) {
            this.getBinding().r.g.setText(s);
            S2 s20 = this.getBinding();
            int v = ScreenUtils.dipToPixel(this.getContext(), 44.0f);
            ViewUtils.setDefaultImage(s20.r.e.c, v);
        }
        ViewUtils.setEnable(this.getBinding().r.j, z);
    }

    private final void setMusicAlarmSetting(Bundle bundle0) {
        LogU.Companion.d("SettingMusicAlarmFragment", "setFragmentResultListener: " + bundle0);
        if(bundle0.getInt("sound_type") == 2) {
            Track voiceAlarm$Track0 = (Track)(((Parcelable)com.google.firebase.b.F(bundle0, "voice_track", Track.class)));
            if(voiceAlarm$Track0 != null) {
                d d0 = this.getViewModel().getMusicAlarm();
                if(d0 != null) {
                    d0.m = voiceAlarm$Track0;
                    d0.i = 2;
                }
                this.setAlarmSoundType(2);
                this.updateVoiceTrackItem(voiceAlarm$Track0);
                return;
            }
            this.defaultAlarmSoundType();
            return;
        }
        MUSICLIST listMusicRes$result$MUSICLIST0 = (MUSICLIST)CompatUtils.getSerializable(bundle0, "music", MUSICLIST.class);
        if(listMusicRes$result$MUSICLIST0 != null) {
            S2 s20 = this.getBinding();
            q.f(s20.m, "musicLayout");
            s20.m.setVisibility(0);
            S2 s21 = this.getBinding();
            q.f(s21.e, "checkSongDesc");
            s21.e.setVisibility(8);
            MusicAlarmViewModel musicAlarmViewModel0 = this.getViewModel();
            d d1 = musicAlarmViewModel0.getMusicAlarm();
            if(d1 != null) {
                d1.i = 1;
                d1.g = String.valueOf(listMusicRes$result$MUSICLIST0.songid);
                d1.j = listMusicRes$result$MUSICLIST0.songname;
                d1.k = String.valueOf(listMusicRes$result$MUSICLIST0.artistid);
                d1.l = ListMusicRes.getArtistNames(listMusicRes$result$MUSICLIST0.artistlist);
            }
            String s = listMusicRes$result$MUSICLIST0.songname;
            q.f(s, "songname");
            musicAlarmViewModel0.setSongName(s);
            String s1 = ListMusicRes.getArtistNames(listMusicRes$result$MUSICLIST0.artistlist);
            q.f(s1, "getArtistNames(...)");
            musicAlarmViewModel0.setArtistName(s1);
            String s2 = listMusicRes$result$MUSICLIST0.albumimagepath;
            q.f(s2, "albumimagepath");
            musicAlarmViewModel0.setAlbumImageUrl(s2);
            musicAlarmViewModel0.setAdult(listMusicRes$result$MUSICLIST0.adultflag);
            this.updateMusicInfo(true);
            return;
        }
        d d2 = this.getViewModel().getMusicAlarm();
        String s3 = d2 == null ? null : d2.g;
        if(s3 != null && s3.length() != 0) {
            return;
        }
        this.defaultAlarmSoundType();
    }

    public final void syncVolume(int v) {
        this.updateSoundIcon(v);
        if(this.getBinding().u.getProgress() != v) {
            this.getBinding().u.setProgress(v);
            this.getBinding().u.invalidate();
        }
    }

    private final void updateAllDayCheckedState(boolean z) {
        TextView[] arr_textView = this.mDayOfWeekView;
        for(int v = 0; v < arr_textView.length; ++v) {
            this.setDayViewEnabled(arr_textView[v], z);
        }
    }

    private final void updateAmPm(int v) {
        this.getBinding().c.setValue((v == 0 || v != 1 ? 1 : 0));
    }

    private final void updateCheckBoxSelection(int v) {
        switch(v) {
            case 0: {
                this.getBinding().d.setChecked(true);
                this.getBinding().f.setChecked(false);
                this.getBinding().h.setChecked(false);
                return;
            }
            case 1: {
                this.getBinding().d.setChecked(false);
                this.getBinding().h.setChecked(false);
                return;
            }
            default: {
                if(v != 2) {
                    return;
                }
                this.getBinding().d.setChecked(false);
                this.getBinding().f.setChecked(false);
                this.getBinding().h.setChecked(true);
            }
        }
    }

    private final void updateCurrentTime(d d0) {
        d0.b = this.convert12HourTo24Hour(this.getBinding().c.getValue(), this.getBinding().i.getValue());
        this.correct24Hour(this.getBinding().c.getValue(), d0);
        d0.c = this.getBinding().k.getValue();
    }

    private final void updateMusicAndVoiceTrackVisibility() {
        S2 s20 = this.getBinding();
        q.f(s20.m, "musicLayout");
        d d0 = this.getViewModel().getMusicAlarm();
        Track voiceAlarm$Track0 = null;
        String s = d0 == null ? null : d0.g;
        int v = 0;
        s20.m.setVisibility((s == null || s.length() == 0 ? 8 : 0));
        q.f(s20.e, "checkSongDesc");
        d d1 = this.getViewModel().getMusicAlarm();
        String s1 = d1 == null ? null : d1.g;
        s20.e.setVisibility((s1 != null && s1.length() != 0 ? 0 : 8));
        q.f(s20.s, "voiceTrackLayout");
        d d2 = this.getViewModel().getMusicAlarm();
        s20.s.setVisibility((Cb.i.l((d2 == null ? null : d2.m)) ? 0 : 8));
        MelonTextView melonTextView0 = s20.g;
        q.f(melonTextView0, "checkVoiceDesc");
        d d3 = this.getViewModel().getMusicAlarm();
        if(d3 != null) {
            voiceAlarm$Track0 = d3.m;
        }
        if(voiceAlarm$Track0 != null) {
            v = 8;
        }
        melonTextView0.setVisibility(v);
    }

    private final void updateMusicInfo(boolean z) {
        if(!z && this.getViewModel().getAlbumImageUrl().length() != 0 && this.getViewModel().getSongName().length() != 0 && this.getViewModel().getArtistName().length() != 0) {
            S2 s20 = this.getBinding();
            String s = this.getViewModel().getSongName();
            s20.l.h.setText(s);
            S2 s21 = this.getBinding();
            String s1 = this.getViewModel().getArtistName();
            s21.l.g.setText(s1);
            View view0 = this.getBinding().l.f.findViewById(0x7F0A063B);  // id:iv_list_19
            q.f(view0, "findViewById(...)");
            view0.setVisibility((this.getViewModel().isAdult() ? 0 : 8));
            q.d(Glide.with(this.requireContext()).load(this.getViewModel().getAlbumImageUrl()).into(this.getBinding().l.e.b));
            return;
        }
        Context context0 = this.getContext();
        d d0 = this.getViewModel().getMusicAlarm();
        RequestBuilder.newInstance(new SongInfoReq(context0, (d0 == null ? null : d0.g))).tag("SettingMusicAlarmFragment").listener(new m(this, 2)).errorListener(this.mResponseErrorListener).request();
    }

    public static void updateMusicInfo$default(SettingMusicAlarmFragment settingMusicAlarmFragment0, boolean z, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        settingMusicAlarmFragment0.updateMusicInfo(z);
    }

    private static final void updateMusicInfo$lambda$37(SettingMusicAlarmFragment settingMusicAlarmFragment0, SongInfoRes songInfoRes0) {
        int v = 0;
        settingMusicAlarmFragment0.showProgress(false);
        q.d(songInfoRes0);
        if(Cb.j.d(songInfoRes0) && H0.e.N(settingMusicAlarmFragment0)) {
            RESPONSE songInfoRes$RESPONSE0 = songInfoRes0.response;
            if((songInfoRes$RESPONSE0 == null ? null : songInfoRes$RESPONSE0.songInfo) != null) {
                settingMusicAlarmFragment0.updateSongItemLayout(songInfoRes$RESPONSE0.songInfo.canService);
                MusicAlarmViewModel musicAlarmViewModel0 = settingMusicAlarmFragment0.getViewModel();
                String s = songInfoRes0.response.songInfo.songName;
                String s1 = "";
                if(s == null) {
                    s = "";
                }
                musicAlarmViewModel0.setSongName(s);
                settingMusicAlarmFragment0.getViewModel().setArtistName(songInfoRes0.response.songInfo.getArtistNames());
                MusicAlarmViewModel musicAlarmViewModel1 = settingMusicAlarmFragment0.getViewModel();
                String s2 = songInfoRes0.response.songInfo.albumImg;
                if(s2 != null) {
                    s1 = s2;
                }
                musicAlarmViewModel1.setAlbumImageUrl(s1);
                settingMusicAlarmFragment0.getViewModel().setAdult(songInfoRes0.response.songInfo.isAdult);
                S2 s20 = settingMusicAlarmFragment0.getBinding();
                String s3 = settingMusicAlarmFragment0.getViewModel().getSongName();
                s20.l.h.setText(s3);
                S2 s21 = settingMusicAlarmFragment0.getBinding();
                String s4 = settingMusicAlarmFragment0.getViewModel().getArtistName();
                s21.l.g.setText(s4);
                View view0 = settingMusicAlarmFragment0.getBinding().l.f.findViewById(0x7F0A063B);  // id:iv_list_19
                q.f(view0, "findViewById(...)");
                if(!settingMusicAlarmFragment0.getViewModel().isAdult()) {
                    v = 8;
                }
                view0.setVisibility(v);
                Glide.with(settingMusicAlarmFragment0.requireContext()).load(settingMusicAlarmFragment0.getViewModel().getAlbumImageUrl()).into(settingMusicAlarmFragment0.getBinding().l.e.b);
                return;
            }
            settingMusicAlarmFragment0.updateSongItemLayout(false);
            d d0 = settingMusicAlarmFragment0.getViewModel().getMusicAlarm();
            if(d0 != null && d0.i == 1) {
                d0.i = 0;
                MusicAlarmPrefsHelper.INSTANCE.addAlarm(d0);
            }
        }
    }

    private final void updateRepeatAllButton(boolean z) {
        this.getBinding().o.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F06017C : 0x7F060160)));  // color:green500s_support_high_contrast
        this.getBinding().o.setBackgroundResource((z ? 0x7F0808E5 : 0x7F0808D2));  // drawable:shape_rectangle_green500e_0_5dp_stroke_round100
        S2 s20 = this.getBinding();
        w w0 = new w(z, this, 1);
        s20.o.setOnClickListener(w0);
    }

    private static final void updateRepeatAllButton$lambda$38(boolean z, SettingMusicAlarmFragment settingMusicAlarmFragment0, View view0) {
        if(!z) {
            settingMusicAlarmFragment0.updateRepeatAllButton(true);
            settingMusicAlarmFragment0.updateAllDayCheckedState(true);
            P p0 = settingMusicAlarmFragment0.saveButton;
            if(p0 != null) {
                p0.j(true);
            }
            d d0 = settingMusicAlarmFragment0.getViewModel().getMusicAlarm();
            if(d0 != null) {
                boolean[] arr_z = settingMusicAlarmFragment0.getDayOfWeekSelected();
                q.g(arr_z, "<set-?>");
                d0.f = arr_z;
            }
            settingMusicAlarmFragment0.getBinding().p.setChecked(true);
        }
    }

    private final void updateSongItemLayout(boolean z) {
        String s;
        if(!z) {
            d d0 = this.getViewModel().getMusicAlarm();
            if(d0 != null && d0.i == 0) {
                this.getBinding().d.setChecked(true);
                this.getBinding().h.setChecked(false);
            }
            else {
                d d1 = this.getViewModel().getMusicAlarm();
                if(d1 != null && d1.i == 1) {
                    this.getBinding().d.setChecked(true);
                    this.getBinding().h.setChecked(false);
                }
                else {
                    this.getBinding().d.setChecked(false);
                }
            }
            this.getBinding().f.setChecked(false);
            MelonTextView melonTextView0 = this.getBinding().l.h;
            d d2 = this.getViewModel().getMusicAlarm();
            if(d2 == null) {
                s = "";
            }
            else {
                s = d2.j;
                if(s == null) {
                    s = "";
                }
            }
            melonTextView0.setText(s);
            S2 s20 = this.getBinding();
            String s1 = this.getString(0x7F130A28);  // string:smart_playlist_service_stopped_song "서비스 중지된 콘텐츠입니다"
            s20.l.g.setText(s1);
            S2 s21 = this.getBinding();
            int v = ScreenUtils.dipToPixel(this.getContext(), 44.0f);
            ViewUtils.setDefaultImage(s21.l.e.c, v);
        }
        ViewUtils.setEnable(this.getBinding().l.j, z);
    }

    private final void updateSoundIcon(int v) {
        if(v < 1) {
            this.getBinding().j.setImageResource(0x7F080260);  // drawable:btn_setting_sound_mute
            return;
        }
        this.getBinding().j.setImageResource(0x7F08025F);  // drawable:btn_setting_sound
    }

    private final void updateVoiceTrackItem(Track voiceAlarm$Track0) {
        LogU.Companion.d("SettingMusicAlarmFragment", "updateVoiceTrackItem: " + voiceAlarm$Track0);
        S2 s20 = this.getBinding();
        q.f(s20.s, "voiceTrackLayout");
        s20.s.setVisibility(0);
        S2 s21 = this.getBinding();
        q.f(s21.g, "checkVoiceDesc");
        s21.g.setVisibility(8);
        S2 s22 = this.getBinding();
        s22.r.h.setText(voiceAlarm$Track0.getTrackName());
        s22.r.g.setText(voiceAlarm$Track0.getArtistName());
        Glide.with(this.requireContext()).load(voiceAlarm$Track0.getAlbumImage()).into(s22.r.e.b);
        boolean z = VoiceAlarmKt.isValidate(voiceAlarm$Track0);
        this.setEnableVoiceItemLayout(z, voiceAlarm$Track0.getMessage());
        if(!z) {
            String s = q.b(voiceAlarm$Track0.getStatus(), "-1") ? this.getString(0x7F13094C) : this.getString(0x7F13094D);  // string:setting_alarm_voice_track_status_expire "보이스알람 이용기간이 종료되어 ‘듣던 곡 재생’으로 알람이 
                                                                                                                            // 재생 됩니다."
            q.d(s);
            ToastManager.show(s);
        }
    }

    private static final MusicAlarmViewModel viewModel_delegate$lambda$0(SettingMusicAlarmFragment settingMusicAlarmFragment0) {
        q.g(settingMusicAlarmFragment0, "owner");
        q0 q00 = settingMusicAlarmFragment0.getViewModelStore();
        o0 o00 = settingMusicAlarmFragment0.getDefaultViewModelProviderFactory();
        S2.c c0 = settingMusicAlarmFragment0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        o9.b b0 = com.iloen.melon.utils.a.p(c0, "defaultCreationExtras", q00, o00, c0);
        De.d d0 = df.d.y(MusicAlarmViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (MusicAlarmViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }
}

