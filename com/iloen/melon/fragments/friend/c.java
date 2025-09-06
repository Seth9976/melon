package com.iloen.melon.fragments.friend;

import java.util.ArrayList;
import java.util.List;
import we.a;

public final class c implements a {
    public final int a;
    public final FollowerFragment b;
    public final ArrayList c;
    public final List d;

    public c(FollowerFragment followerFragment0, ArrayList arrayList0, List list0, int v) {
        this.a = v;
        this.b = followerFragment0;
        this.c = arrayList0;
        this.d = list0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? FollowerFragment.checkAndHideMarkedFriend$lambda$13(this.b, this.c, this.d) : FollowerFragment.checkAndUnhideMarkedFriend$lambda$16(this.b, this.c, this.d);
    }
}

