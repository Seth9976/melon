package com.iloen.melon.fragments.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b3.Z;
import com.iloen.melon.custom.N0;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;

public class SettingDownloadSongFragment extends SettingSoundQualityFragment {
    private static final String TAG = "SettingDownloadSongFragment";

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settingsDownloadSoundQuality");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F131050;  // string:title_setting_download_song "다운로드 음질 설정"
    }

    private void initViews() {
        RadioGroup radioGroup0 = (RadioGroup)this.findViewById(0x7F0A09A5);  // id:radiogroup_download_bitrate
        String s = MelonSettingInfo.getDownloadBitrate();
        LogU.d("SettingDownloadSongFragment", "initViews() downloadBitrate : " + s);
        if(s.equals("192K")) {
            radioGroup0.a(0x7F0A06BE);  // id:k192Layout
            this.setAccessibilityDesc(radioGroup0, 0x7F0A06BE);  // id:k192Layout
        }
        else {
            radioGroup0.a(0x7F0A06C2);  // id:k320Layout
            this.setAccessibilityDesc(radioGroup0, 0x7F0A06C2);  // id:k320Layout
        }
        radioGroup0.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                String s1;
                String s;
                Z.r(v, "onCheckedChanged() checkedId:", "SettingDownloadSongFragment");
                if(v == 0x7F0A06C2) {  // id:k320Layout
                    s = "320K";
                    s1 = "SQ04";
                }
                else {
                    s = "192K";
                    s1 = "SQ03";
                }
                SettingDownloadSongFragment.this.setAccessibilityDesc(radioGroup0, v);
                if(!s.equals(MelonSettingInfo.getDownloadBitrate())) {
                    MelonSettingInfo.setDownloadBitrate(s);
                    SettingDownloadSongFragment.this.sendUALog("settingsDownloadSoundQualityUa", s1);
                }
            }
        });
    }

    public static SettingDownloadSongFragment newInstance() {
        return new SettingDownloadSongFragment();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D082A, viewGroup0, false);  // layout:setting_download_song
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }

    private void setAccessibilityDesc(RadioGroup radioGroup0, int v) {
        if(v == 0x7F0A06C2) {  // id:k320Layout
            String s = this.getString(0x7F130924);  // string:setting_320k "320K"
            String s1 = this.getString(0x7F130923);  // string:setting_192k "192K"
            radioGroup0.c(0x7F0A06C2, String.format(this.getString(0x7F130AF3), s));  // id:k320Layout
            radioGroup0.c(0x7F0A06BE, String.format(this.getString(0x7F130AF7), s1));  // id:k192Layout
            return;
        }
        String s2 = this.getString(0x7F130923);  // string:setting_192k "192K"
        String s3 = this.getString(0x7F130924);  // string:setting_320k "320K"
        radioGroup0.c(0x7F0A06BE, String.format(this.getString(0x7F130AF3), s2));  // id:k192Layout
        radioGroup0.c(0x7F0A06C2, String.format(this.getString(0x7F130AF7), s3));  // id:k320Layout
    }
}

