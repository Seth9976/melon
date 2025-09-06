package com.iloen.melon.fragments.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.l0;
import b3.Z;
import com.iloen.melon.custom.N0;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import com.melon.utils.system.DeviceData;
import javax.inject.Inject;

public class SettingMusicVideoFragment extends Hilt_SettingMusicVideoFragment {
    private static final String TAG = "SettingMusicVideoFragment";
    private RadioGroup m3gRadioGroup;
    @Inject
    DeviceData mDeviceData;
    private RadioGroup mWifiRadioGroup;

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settingsVideoQuality");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F131056;  // string:title_setting_musicvideo "비디오 화질 설정"
    }

    private void initPreferenceValue() {
        LogU.d("SettingMusicVideoFragment", "initPreferenceValue()");
        String s = MelonSettingInfo.getMusicVideoBitrate3G();
        LogU.d("SettingMusicVideoFragment", "-bitrate 3g : " + s);
        String s1 = MelonSettingInfo.getMusicVideoBitrateWifi();
        LogU.d("SettingMusicVideoFragment", "-bitrate wifi : " + s1);
        if(s.equals("700K")) {
            this.m3gRadioGroup.a(0x7F0A06C3);  // id:k700_1
            this.setAccessibilityDataNetwork(this.m3gRadioGroup, 0x7F0A06C3);  // id:k700_1
        }
        else if(s.equals("1M")) {
            this.m3gRadioGroup.a(0x7F0A06BB);  // id:k1000_1
            this.setAccessibilityDataNetwork(this.m3gRadioGroup, 0x7F0A06BB);  // id:k1000_1
        }
        else {
            this.m3gRadioGroup.a(0x7F0A06BF);  // id:k3000_1
            this.setAccessibilityDataNetwork(this.m3gRadioGroup, 0x7F0A06BF);  // id:k3000_1
        }
        if(s1.equals("700K")) {
            this.mWifiRadioGroup.a(0x7F0A06C4);  // id:k700_2
            this.setAccessibilityWifi(this.mWifiRadioGroup, 0x7F0A06C4);  // id:k700_2
            return;
        }
        if(s1.equals("1M")) {
            this.mWifiRadioGroup.a(0x7F0A06BC);  // id:k1000_2
            this.setAccessibilityWifi(this.mWifiRadioGroup, 0x7F0A06BC);  // id:k1000_2
            return;
        }
        this.mWifiRadioGroup.a(0x7F0A06C0);  // id:k3000_2
        this.setAccessibilityWifi(this.mWifiRadioGroup, 0x7F0A06C0);  // id:k3000_2
    }

    private void initUIClass() {
        LogU.d("SettingMusicVideoFragment", "initUIClass()");
        this.m3gRadioGroup = (RadioGroup)this.findViewById(0x7F0A088A);  // id:musicvideo_3g_setting_radio
        this.mWifiRadioGroup = (RadioGroup)this.findViewById(0x7F0A088C);  // id:musicvideo_wifi_setting_radio
        boolean z = this.mDeviceData.i();
        ViewUtils.hideWhen(this.findViewById(0x7F0A088B), z);  // id:musicvideo_3g_setting_title
        ViewUtils.hideWhen(this.findViewById(0x7F0A0889), z);  // id:musicvideo_3g_setting_explain1_container
        ViewUtils.hideWhen(this.findViewById(0x7F0A0DA3), z);  // id:vbar
        ViewUtils.hideWhen(this.m3gRadioGroup, z);
        this.calculateScrollView(this.findViewById(0x7F0A0A78));  // id:setting_scrollview
    }

    public static SettingMusicVideoFragment newInstance() {
        return new SettingMusicVideoFragment();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0836, viewGroup0, false);  // layout:setting_musicvideo
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initUIClass();
        this.initPreferenceValue();
        this.setClickEventListener();
    }

    private void setAccessibilityDataNetwork(RadioGroup radioGroup0, int v) {
        this.setAccessibilityRadioGroup(radioGroup0, v, new String[]{this.getString(0x7F1309B9), this.getString(0x7F130993), this.getString(0x7F130992)}, new int[]{0x7F0A06C3, 0x7F0A06BB, 0x7F0A06BF});  // string:setting_normal "일반화질"
    }

    private void setAccessibilityWifi(RadioGroup radioGroup0, int v) {
        this.setAccessibilityRadioGroup(radioGroup0, v, new String[]{this.getString(0x7F1309B9), this.getString(0x7F130993), this.getString(0x7F130992)}, new int[]{0x7F0A06C4, 0x7F0A06BC, 0x7F0A06C0});  // string:setting_normal "일반화질"
    }

    private void setClickEventListener() {
        LogU.d("SettingMusicVideoFragment", "setClickEventListener()");
        this.m3gRadioGroup.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                Z.r(v, "3g RadioGroup onCheckedChanged : ", "SettingMusicVideoFragment");
                if(v == 0x7F0A06C3) {  // id:k700_1
                    MelonSettingInfo.setMusicVideoBitrate3G("700K");
                }
                else {
                    switch(v) {
                        case 0x7F0A06BB: {  // id:k1000_1
                            MelonSettingInfo.setMusicVideoBitrate3G("1M");
                            break;
                        }
                        case 0x7F0A06BF: {  // id:k3000_1
                            MelonSettingInfo.setMusicVideoBitrate3G("3M");
                            l0 l00 = SettingMusicVideoFragment.this.getChildFragmentManager();
                            String s = SettingMusicVideoFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            String s1 = SettingMusicVideoFragment.this.getString(0x7F1300E4);  // string:alert_selected_mv_high_quality "네트워크 환경에 따라 재생 중 끊김 현상이 발생하거나 다음 비디오로의 연결이 
                                                                                               // 느려질 수 있습니다."
                            b.a.c(l00, s, s1);
                        }
                    }
                }
                SettingMusicVideoFragment.this.setAccessibilityDataNetwork(radioGroup0, v);
            }
        });
        this.mWifiRadioGroup.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                Z.r(v, "Wifi RadioGroup onCheckedChanged : ", "SettingMusicVideoFragment");
                if(v == 0x7F0A06C4) {  // id:k700_2
                    MelonSettingInfo.setMusicVideoBitrateWifi("700K");
                }
                else {
                    switch(v) {
                        case 0x7F0A06BC: {  // id:k1000_2
                            MelonSettingInfo.setMusicVideoBitrateWifi("1M");
                            break;
                        }
                        case 0x7F0A06C0: {  // id:k3000_2
                            MelonSettingInfo.setMusicVideoBitrateWifi("3M");
                            l0 l00 = SettingMusicVideoFragment.this.getChildFragmentManager();
                            String s = SettingMusicVideoFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                            String s1 = SettingMusicVideoFragment.this.getString(0x7F1300E4);  // string:alert_selected_mv_high_quality "네트워크 환경에 따라 재생 중 끊김 현상이 발생하거나 다음 비디오로의 연결이 
                                                                                               // 느려질 수 있습니다."
                            b.a.c(l00, s, s1);
                        }
                    }
                }
                SettingMusicVideoFragment.this.setAccessibilityWifi(radioGroup0, v);
            }
        });
    }
}

