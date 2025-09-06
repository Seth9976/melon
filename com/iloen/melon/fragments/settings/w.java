package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.settings.alarm.SettingMusicAlarmFragment;
import com.iloen.melon.popup.SmartPlayerSettingPopup;
import p8.g;
import we.k;

public final class w implements View.OnClickListener {
    public final int a;
    public final boolean b;
    public final Object c;

    public w(SmartPlayerSettingPopup smartPlayerSettingPopup0, boolean z) {
        this.a = 2;
        super();
        this.c = smartPlayerSettingPopup0;
        this.b = z;
    }

    public w(boolean z, SettingBaseFragment settingBaseFragment0, int v) {
        this.a = v;
        this.b = z;
        this.c = settingBaseFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        boolean z = this.b;
        Object object0 = this.c;
        switch(this.a) {
            case 0: {
                SettingLaboratoryFragment.initLocalPlayListRestore$lambda$9(z, ((SettingLaboratoryFragment)object0), view0);
                return;
            }
            case 1: {
                SettingMusicAlarmFragment.updateRepeatAllButton$lambda$38(z, ((SettingMusicAlarmFragment)object0), view0);
                return;
            }
            default: {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = "1000000558";
                g0.a = "페이지이동";
                g0.b = "재생목록";
                g0.c = "재생목록_곡";
                g0.J = "1000003098";
                g0.y = "재생환경설정";
                g0.F = "스마트재생목록On/Off";
                g0.V = ((SmartPlayerSettingPopup)object0).getContext().getString((z ? 0x7F130FCE : 0x7F130FCF));  // string:tiara_props_off "off"
                g0.a().track();
                k k0 = ((SmartPlayerSettingPopup)object0).e;
                if(k0 != null) {
                    k0.invoke(2);
                }
                ((SmartPlayerSettingPopup)object0).dismiss();
            }
        }
    }
}

