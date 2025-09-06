package com.iloen.melon.custom;

import Vb.i;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.MelonFragmentManager;
import com.melon.ui.popup.b;
import va.e0;
import va.o;

public final class Z0 implements View.OnClickListener {
    public final int a;
    public final SettingItemView b;

    public Z0(SettingItemView settingItemView0, int v) {
        this.a = v;
        this.b = settingItemView0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            SettingItemView settingItemView0 = this.b;
            if(settingItemView0.n && !((e0)o.a()).m()) {
                b.v(MelonFragmentManager.getInstance().getCurrentActivity().getSupportFragmentManager(), "안내", "로그인이 필요한 서비스입니다.\n로그인하시겠습니까?", false, null, null, new i(18), null);
                return;
            }
            if(!settingItemView0.o) {
                settingItemView0.setRadioOnOff(!settingItemView0.m);
            }
            b1 b10 = settingItemView0.w;
            if(b10 != null) {
                b10.onRadioBtnClick(settingItemView0.m);
            }
            return;
        }
        a1 a10 = this.b.r;
        if(a10 != null) {
            a10.onButtonClick();
        }
    }
}

