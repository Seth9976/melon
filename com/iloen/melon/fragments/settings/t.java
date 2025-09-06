package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;

public final class t implements View.OnClickListener {
    public final int a;
    public final SettingFloatingLyricFragment b;

    public t(SettingFloatingLyricFragment settingFloatingLyricFragment0, int v) {
        this.a = v;
        this.b = settingFloatingLyricFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                SettingFloatingLyricFragment.mTextBtnClickListener$lambda$7(this.b, view0);
                return;
            }
            case 1: {
                SettingFloatingLyricFragment.initUI$lambda$4(this.b, view0);
                return;
            }
            default: {
                SettingFloatingLyricFragment.initUI$lambda$5(this.b, view0);
            }
        }
    }
}

