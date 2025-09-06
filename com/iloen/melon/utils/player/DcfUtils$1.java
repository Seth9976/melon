package com.iloen.melon.utils.player;

import com.iloen.melon.activity.BaseActivity;
import com.melon.ui.popup.b;

class DcfUtils.1 implements Runnable {
    public final BaseActivity a;
    public final String b;

    public DcfUtils.1(BaseActivity baseActivity0, String s) {
        this.a = baseActivity0;
        this.b = s;
    }

    @Override
    public void run() {
        b.a.c(this.a.getSupportFragmentManager(), "안내", this.b);
    }
}

