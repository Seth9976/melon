package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.RadioButton;

public final class u implements View.OnClickListener {
    public final int a;
    public final SettingFloatingLyricFragment b;
    public final RadioButton c;
    public final RadioButton d;

    public u(SettingFloatingLyricFragment settingFloatingLyricFragment0, RadioButton radioButton0, RadioButton radioButton1, int v) {
        this.a = v;
        this.b = settingFloatingLyricFragment0;
        this.c = radioButton0;
        this.d = radioButton1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            SettingFloatingLyricFragment.initUI$lambda$3(this.b, this.c, this.d, view0);
            return;
        }
        SettingFloatingLyricFragment.initUI$lambda$2(this.b, this.c, this.d, view0);
    }
}

