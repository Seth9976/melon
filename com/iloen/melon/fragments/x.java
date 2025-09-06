package com.iloen.melon.fragments;

import android.view.View.OnClickListener;
import android.view.View;

public final class x implements View.OnClickListener {
    public final int a;
    public final MelonWidgetSettingFragment b;

    public x(MelonWidgetSettingFragment melonWidgetSettingFragment0, int v) {
        this.a = v;
        this.b = melonWidgetSettingFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MelonWidgetSettingFragment.confirmClickListener$lambda$7(this.b, view0);
                return;
            }
            case 1: {
                MelonWidgetSettingFragment.initLayout$lambda$1(this.b, view0);
                return;
            }
            case 2: {
                MelonWidgetSettingFragment.initLayout$lambda$3$lambda$2(this.b, view0);
                return;
            }
            default: {
                MelonWidgetSettingFragment.initLayout$lambda$5$lambda$4(this.b, view0);
            }
        }
    }
}

