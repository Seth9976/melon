package com.facebook;

import android.view.View.OnClickListener;
import android.view.View;

public final class d implements View.OnClickListener {
    public final FacebookButtonBase a;

    public d(FacebookButtonBase facebookButtonBase0) {
        this.a = facebookButtonBase0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        FacebookButtonBase.setupOnClickListener$lambda$0(this.a, view0);
    }
}

