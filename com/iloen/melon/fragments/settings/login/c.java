package com.iloen.melon.fragments.settings.login;

import android.view.View.OnClickListener;
import android.view.View;

public final class c implements View.OnClickListener {
    public final int a;
    public final LoginSimpleAccountFragment b;
    public final String c;

    public c(LoginSimpleAccountFragment loginSimpleAccountFragment0, String s, int v) {
        this.a = v;
        this.b = loginSimpleAccountFragment0;
        this.c = s;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.invokeSuspend$lambda$5$lambda$4(this.b, this.c, view0);
            return;
        }
        com.iloen.melon.fragments.settings.login.LoginSimpleAccountFragment.initViews.2.1.invokeSuspend$lambda$5$lambda$2(this.b, this.c, view0);
    }
}

