package com.iloen.melon.fragments.friend;

import android.view.View.OnClickListener;
import android.view.View;

public final class h implements View.OnClickListener {
    public final FollowerFragment a;
    public final int b;

    public h(FollowerFragment followerFragment0, int v) {
        this.a = followerFragment0;
        this.b = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        FollowerAdapter.onBindViewImpl$lambda$5(this.a, this.b, view0);
    }
}

