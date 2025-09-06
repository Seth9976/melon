package com.iloen.melon.fragments.detail;

import X8.a;
import com.iloen.melon.net.v4x.common.UserInfoBase;

public final class i implements a {
    public final int a;
    public final com.iloen.melon.fragments.detail.DetailLikePersonListFragment.LikePersonListAdapter.2 b;
    public final UserInfoBase c;
    public final ItemHolder d;

    public i(com.iloen.melon.fragments.detail.DetailLikePersonListFragment.LikePersonListAdapter.2 detailLikePersonListFragment$LikePersonListAdapter$20, UserInfoBase userInfoBase0, ItemHolder detailLikePersonListFragment$ItemHolder0, int v) {
        this.a = v;
        this.b = detailLikePersonListFragment$LikePersonListAdapter$20;
        this.c = userInfoBase0;
        this.d = detailLikePersonListFragment$ItemHolder0;
        super();
    }

    @Override  // X8.a
    public final void onJobComplete(String s) {
        if(this.a != 0) {
            this.b.lambda$onClick$1(this.c, this.d, s);
            return;
        }
        this.b.lambda$onClick$0(this.c, this.d, s);
    }
}

