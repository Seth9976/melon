package com.iloen.melon.fragments.comments;

import android.view.View.OnClickListener;
import android.view.View;

public final class c implements View.OnClickListener {
    public final int a;
    public final AdcmtListFragment b;

    public c(AdcmtListFragment adcmtListFragment0, int v) {
        this.a = v;
        this.b = adcmtListFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            this.b.lambda$onViewCreated$1(view0);
            return;
        }
        this.b.lambda$onViewCreated$0(view0);
    }
}

