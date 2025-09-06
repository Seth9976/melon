package com.iloen.melon.fragments.mymusic;

import J8.x2;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ProfileBaseRes.SnsInfoBase;

public final class v implements View.OnClickListener {
    public final x2 a;
    public final MemberProfileEditFragment b;
    public final SnsInfoBase c;
    public final int d;
    public final MemberProfileEditAdapter e;

    public v(x2 x20, MemberProfileEditFragment memberProfileEditFragment0, SnsInfoBase profileBaseRes$SnsInfoBase0, int v, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0) {
        this.a = x20;
        this.b = memberProfileEditFragment0;
        this.c = profileBaseRes$SnsInfoBase0;
        this.d = v;
        this.e = memberProfileEditFragment$MemberProfileEditAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        SnsConnectViewHolder.bindItem$lambda$6$lambda$4(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

