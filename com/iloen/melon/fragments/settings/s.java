package com.iloen.melon.fragments.settings;

import a9.d;
import androidx.activity.result.ActivityResult;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.N0;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.b1;
import e.a;

public final class s implements d, ErrorListener, N0, b1, a {
    public final int a;
    public final SettingBaseFragment b;

    public s(SettingBaseFragment settingBaseFragment0, int v) {
        this.a = v;
        this.b = settingBaseFragment0;
        super();
    }

    @Override  // e.a
    public void onActivityResult(Object object0) {
        SettingDownloadFolderFragment.activityResult$lambda$1(((SettingDownloadFolderFragment)this.b), ((ActivityResult)object0));
    }

    @Override  // com.iloen.melon.custom.N0
    public void onCheckedChanged(RadioGroup radioGroup0, int v) {
        SettingServerPhaseFragment.initView$lambda$1(((SettingServerPhaseFragment)this.b), radioGroup0, v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        SettingOfflinePlayback.requestGetPremiumDevices$lambda$5(((SettingOfflinePlayback)this.b), volleyError0);
    }

    @Override  // com.iloen.melon.custom.b1
    public void onRadioBtnClick(boolean z) {
        if(this.a != 2) {
            SettingScreenFragment.initViews$lambda$1(((SettingScreenFragment)this.b), z);
            return;
        }
        SettingLoudnessNormalizationFragment.onViewCreated$lambda$2$lambda$1(((SettingLoudnessNormalizationFragment)this.b), z);
    }

    @Override  // a9.d
    public void onSelected(int v) {
        ExcludedArtistSearchAdapter.onBindViewImpl$lambda$2$lambda$1(((SettingExcludedArtistSearchFragment)this.b), v);
    }
}

