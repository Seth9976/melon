package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;

public final class Z implements View.OnClickListener {
    public final int a;
    public final ItemsPagerContainer b;

    public Z(ItemsPagerContainer itemsPagerContainer0, int v) {
        this.a = v;
        this.b = itemsPagerContainer0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            int v = this.b.c.getCurrentItem();
            this.b.setCurrentItem(v + 1);
            return;
        }
        int v1 = this.b.c.getCurrentItem();
        this.b.setCurrentItem(v1 - 1);
    }
}

