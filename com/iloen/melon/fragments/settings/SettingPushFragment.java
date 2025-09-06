package com.iloen.melon.fragments.settings;

import Td.b;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.custom.b1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventResponseMessage.failMessage;
import com.iloen.melon.eventbus.EventResponseMessage;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.utils.preference.PreferenceHelper;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SettingPushFragment extends Hilt_SettingPushFragment {
    private static final String TAG = "SettingPushFragment";
    private SettingItemView mMarketingPushOptions;
    private SettingItemView mPushAlertOptions;
    private SettingItemView mPushMannerOptions;
    @Inject
    PreferenceHelper preferenceHelper;

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settingsPushNotification");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309F5;  // string:setting_title_push "Push 알림 설정"
    }

    private void initViews() {
        this.mPushAlertOptions = (SettingItemView)this.findViewById(0x7F0A099D);  // id:radio_receive_alert
        this.mMarketingPushOptions = (SettingItemView)this.findViewById(0x7F0A099B);  // id:radio_marketing_receive_alert
        this.mPushMannerOptions = (SettingItemView)this.findViewById(0x7F0A099E);  // id:radio_silent_alert
        this.mPushAlertOptions.setViewType(12);
        this.mPushAlertOptions.setRadioOnOff(MelonSettingInfo.getUsePushAlert());
        this.mPushAlertOptions.setRadioBtnClickListener(new b1() {
            @Override  // com.iloen.melon.custom.b1
            public void onRadioBtnClick(boolean z) {
                if(!NetUtils.isConnected()) {
                    ToastManager.show(0x7F1303F3);  // string:error_unstable_network "네트워크 연결이 원활하지 않습니다.\n잠시 후 다시 시도해주세요."
                    SettingPushFragment.this.mPushAlertOptions.setRadioOnOff(!z);
                    return;
                }
                MelonSettingInfo.setUsePushAlert(z);
                SettingPushFragment.this.updateAllView();
            }
        });
        this.mMarketingPushOptions.setViewType(12);
        this.mMarketingPushOptions.setRadioOnOff(MelonSettingInfo.getUseMarketingPushAlert());
        this.mMarketingPushOptions.setRadioBtnClickListener(new b1() {
            @Override  // com.iloen.melon.custom.b1
            public void onRadioBtnClick(boolean z) {
                if(!NetUtils.isConnected()) {
                    ToastManager.show(0x7F1303F3);  // string:error_unstable_network "네트워크 연결이 원활하지 않습니다.\n잠시 후 다시 시도해주세요."
                    SettingPushFragment.this.mMarketingPushOptions.setRadioOnOff(!z);
                    return;
                }
                MelonSettingInfo.setUseMarketingPushAlert(z);
                SettingPushFragment.this.updateAllView();
            }
        });
        this.mPushMannerOptions.setViewType(12);
        this.mPushMannerOptions.setRadioOnOff(MelonSettingInfo.getUsePushAlert());
        this.mPushMannerOptions.setRadioBtnClickListener(new b1() {
            @Override  // com.iloen.melon.custom.b1
            public void onRadioBtnClick(boolean z) {
                if(!MelonSettingInfo.getUsePushAlert() && !MelonSettingInfo.getUseMarketingPushAlert()) {
                    return;
                }
                if(!NetUtils.isConnected()) {
                    ToastManager.show(0x7F1303F3);  // string:error_unstable_network "네트워크 연결이 원활하지 않습니다.\n잠시 후 다시 시도해주세요."
                    SettingPushFragment.this.mPushMannerOptions.setRadioOnOff(!z);
                    return;
                }
                MelonSettingInfo.setPushAlertMannerMode(z);
            }
        });
        this.updateAllView();
    }

    public static SettingPushFragment newInstance() {
        return new SettingPushFragment();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0838, viewGroup0, false);  // layout:setting_push_alert
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventResponseMessage eventResponseMessage0) {
        int v = this.preferenceHelper.a.getSharedPreferences("pushinfo", 0).getInt("CALL_FROM", -1);
        if(eventResponseMessage0 instanceof failMessage) {
            switch(v) {
                case 2: {
                    boolean z = MelonSettingInfo.getUsePushAlert();
                    MelonSettingInfo.setUsePushAlertPref(!z);
                    this.mPushAlertOptions.setRadioOnOff(!z);
                    this.updateAllView();
                    return;
                }
                case 3: {
                    boolean z1 = MelonSettingInfo.getPushAlertMannerMode();
                    MelonSettingInfo.setPushAlertMannerModePref(!z1);
                    this.mPushMannerOptions.setRadioOnOff(!z1);
                    this.updateAllView();
                    break;
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
        EventBusHelper.register(this);
        b.a(this.getActivity());
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
        EventBusHelper.unregister(this);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }

    private void updateAllView() {
        boolean z = MelonSettingInfo.getUsePushAlert();
        boolean z1 = MelonSettingInfo.getUseMarketingPushAlert();
        this.mPushAlertOptions.setRadioOnOff(z);
        this.mMarketingPushOptions.setRadioOnOff(z1);
        if(!z && !z1) {
            this.mPushMannerOptions.setRadioOnOff(false);
            ViewUtils.setEnable(this.mPushMannerOptions, false, true);
            return;
        }
        this.mPushMannerOptions.setRadioOnOff(MelonSettingInfo.getPushAlertMannerMode());
        ViewUtils.setEnable(this.mPushMannerOptions, true, true);
    }
}

