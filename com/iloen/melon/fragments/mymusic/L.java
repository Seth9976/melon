package com.iloen.melon.fragments.mymusic;

import com.android.volley.Response.Listener;

public final class l implements Listener {
    public final MemberProfileEditFragment a;
    public final int b;

    public l(MemberProfileEditFragment memberProfileEditFragment0, int v) {
        this.a = memberProfileEditFragment0;
        this.b = v;
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        MemberProfileEditFragment.requestSiteChannelUpdateRepnt$lambda$16(this.a, this.b, object0);
    }
}

