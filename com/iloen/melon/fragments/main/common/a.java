package com.iloen.melon.fragments.main.common;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final int a;
    public final MainTabTitleView b;

    public a(MainTabTitleView mainTabTitleView0, int v) {
        this.a = v;
        this.b = mainTabTitleView0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MainTabTitleView._init_$lambda$1(this.b, view0);
                return;
            }
            case 1: {
                MainTabTitleView._init_$lambda$2(this.b, view0);
                return;
            }
            case 2: {
                MainTabTitleView._init_$lambda$3(this.b, view0);
                return;
            }
            default: {
                MainTabTitleView.setTitleClickable$lambda$4(this.b, view0);
            }
        }
    }
}

