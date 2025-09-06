package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.constants.AppVersionInfo;
import com.iloen.melon.net.v4x.response.ListArtistRes.Response.CONTENTSLIST;

public final class q implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public q(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                SettingExcludedArtistSearchFragment.updateErrorUI$lambda$5$lambda$3(((ExcludedArtistSearchAdapter)this.b), ((SettingExcludedArtistSearchFragment)this.c), view0);
                return;
            }
            case 1: {
                ExcludedArtistSearchAdapter.onBindViewImpl$lambda$6$lambda$5$lambda$4$lambda$3(((ExcludedArtistSearchAdapter)this.b), ((CONTENTSLIST)this.c), view0);
                return;
            }
            default: {
                SettingMainFragment.updateVersionInfoView$lambda$23$lambda$22(((AppVersionInfo)this.b), ((SettingMainFragment)this.c), view0);
            }
        }
    }
}

