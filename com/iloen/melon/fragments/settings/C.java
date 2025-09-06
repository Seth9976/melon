package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;

public final class c implements View.OnClickListener {
    public final int a;
    public final SettingBaseFragment b;

    public c(SettingBaseFragment settingBaseFragment0, int v) {
        this.a = v;
        this.b = settingBaseFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                SettingAddPositionFragment.initViews$lambda$0(((SettingAddPositionFragment)this.b), view0);
                return;
            }
            case 1: {
                SettingDownloadFolderFragment.onViewCreated$lambda$3$lambda$2(((SettingDownloadFolderFragment)this.b), view0);
                return;
            }
            case 2: {
                SettingExcludedArtistSearchFragment.updateErrorUI$lambda$5$lambda$4(((SettingExcludedArtistSearchFragment)this.b), view0);
                return;
            }
            case 3: {
                SettingLaboratoryFragment.initExportLog4User$lambda$6(((SettingLaboratoryFragment)this.b), view0);
                return;
            }
            default: {
                SettingStopTimerFragment.onViewCreated$lambda$2(((SettingStopTimerFragment)this.b), view0);
            }
        }
    }
}

