package com.iloen.melon.fragments.settings;

import Gd.f;
import Vb.s0;
import Vb.t0;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import ie.H;
import javax.inject.Inject;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.MutableStateFlow;

public class SettingAdvancedFragment extends Hilt_SettingAdvancedFragment {
    private static final String TAG = "SettingAdvancedFragment";
    private SettingItemView mFloatingLyricRadioContainer;
    private View mSettingLyricBtn;
    @Inject
    t0 playerRules;

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F13092C;  // string:setting_advanced "고급"
    }

    private void initNotificationExpireTime() {
        ViewUtils.hideWhen(this.findViewById(0x7F0A0331), true);  // id:container_notication_remain_time
    }

    private void initUI() {
        this.initUsageOptimization();
        this.initUsePlayingScreenOn();
        this.initNotificationExpireTime();
        this.initUseFloatingLyric();
        this.initUseAudioFocusKeeping();
    }

    private void initUsageOptimization() {
        ViewUtils.showWhen(this.findViewById(0x7F0A0733), true);  // id:layout_optimization
        SettingItemView settingItemView0 = (SettingItemView)this.findViewById(0x7F0A0D7C);  // id:usage_optimization
        settingItemView0.setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        settingItemView0.setOnClickListener(new View.OnClickListener() {
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                SettingUsageOptimizationFragment.Companion.newInstance().open();
            }
        });
    }

    private void initUseAudioFocusKeeping() {
        boolean z = MelonSettingInfo.isKeepAudioFocus();
        SettingItemView settingItemView0 = (SettingItemView)this.findViewById(0x7F0A00D1);  // id:audio_focus_keeping_radio
        settingItemView0.setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        settingItemView0.setRadioOnOff(z);
        settingItemView0.setViewType(12);
        settingItemView0.setRadioBtnClickListener(new e(this, 2));
    }

    private void initUseFloatingLyric() {
        boolean z = MelonSettingInfo.isUseLaboratoryFloatingLyric();
        this.mFloatingLyricRadioContainer = (SettingItemView)this.findViewById(0x7F0A04CA);  // id:floating_lyric_use_radio
        this.mSettingLyricBtn = this.findViewById(0x7F0A04C9);  // id:floating_lyric_setting_btn
        this.mFloatingLyricRadioContainer.setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        this.mFloatingLyricRadioContainer.setRadioOnOff(z);
        this.mFloatingLyricRadioContainer.setViewType(12);
        this.mFloatingLyricRadioContainer.setRadioBtnClickListener(new e(this, 0));
        ViewUtils.setEnable(this.mSettingLyricBtn, z);
        ViewUtils.setOnClickListener(this.mSettingLyricBtn, new f(12));
    }

    private void initUsePlayingScreenOn() {
        boolean z = MelonSettingInfo.isKeepScreenOnDuringPlayback();
        SettingItemView settingItemView0 = (SettingItemView)this.findViewById(0x7F0A0931);  // id:playing_screen_on_radio
        settingItemView0.setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        settingItemView0.setRadioOnOff(z);
        settingItemView0.setViewType(12);
        settingItemView0.setRadioBtnClickListener(new e(this, 1));
    }

    private void lambda$initUseAudioFocusKeeping$3(boolean z) {
        MelonSettingInfo.setKeepAudioFocus(z);
        this.toastMessageDisplay(z);
    }

    private void lambda$initUseFloatingLyric$1(boolean z) {
        if(!AndroidSettings.canDrawOverlays()) {
            this.requestOverlayPermission();
        }
        ViewUtils.setEnable(this.mSettingLyricBtn, z);
        MelonSettingInfo.setUseLaboratoryFloatingLyric(z);
        this.toastMessageDisplay(z);
    }

    private static void lambda$initUseFloatingLyric$2(View view0) {
        SettingFloatingLyricFragment.newInstance().open();
    }

    private void lambda$initUsePlayingScreenOn$0(boolean z) {
        t0 t00 = this.playerRules;
        t00.d.getClass();
        MelonSettingInfo.setKeepScreenOnDuringPlayback(z);
        MutableStateFlow mutableStateFlow0 = t00.e;
        do {
            Object object0 = mutableStateFlow0.getValue();
            q.g(((s0)object0), "it");
        }
        while(!mutableStateFlow0.compareAndSet(object0, s0.a(((s0)object0), 0, 0, z, 3)));
        this.toastMessageDisplay(z);
    }

    private H lambda$requestOverlayPermission$4() {
        Intent intent0 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent0.setData(Uri.parse("package:com.iloen.melon"));
        this.startActivity(intent0);
        return null;
    }

    private H lambda$requestOverlayPermission$5() {
        boolean z = MelonSettingInfo.isUseLaboratoryFloatingLyric();
        SettingItemView settingItemView0 = this.mFloatingLyricRadioContainer;
        if(settingItemView0 != null) {
            settingItemView0.setRadioOnOff(z);
        }
        ViewUtils.setEnable(this.mSettingLyricBtn, z);
        return null;
    }

    public static SettingAdvancedFragment newInstance() {
        return new SettingAdvancedFragment();
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0821, viewGroup0, false);  // layout:setting_advanced
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        boolean z = MelonSettingInfo.isUseLaboratoryFloatingLyric();
        LogU.d("SettingAdvancedFragment", "isUserFloatingLyric : " + z);
        ViewUtils.setEnable(this.mSettingLyricBtn, z);
        this.mFloatingLyricRadioContainer.setRadioOnOff(z);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initUI();
    }

    private void requestOverlayPermission() {
        b.v(this.getChildFragmentManager(), this.getString(0x7F1300D0), this.getString(0x7F13098B), false, null, null, new com.iloen.melon.fragments.settings.f(this, 0), new com.iloen.melon.fragments.settings.f(this, 1));  // string:alert_dlg_title_info "안내"
    }

    public void toastMessageDisplay(boolean z) {
        ToastManager.show((z ? 0x7F1309A2 : 0x7F1309A1));  // string:setting_laboratory_toast_on "On 설정되었습니다."
    }
}

