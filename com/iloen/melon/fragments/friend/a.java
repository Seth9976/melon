package com.iloen.melon.fragments.friend;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.DeleteHiddenFriendRes;
import com.iloen.melon.net.v4x.response.InsertHiddenFriendRes;
import java.util.List;

public final class a implements Listener {
    public final int a;
    public final FollowerFragment b;
    public final List c;

    public a(FollowerFragment followerFragment0, List list0, int v) {
        this.a = v;
        this.b = followerFragment0;
        this.c = list0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            FollowerFragment.requestHide$lambda$17(this.b, this.c, ((InsertHiddenFriendRes)object0));
            return;
        }
        FollowerFragment.requestUnHide$lambda$19(this.b, this.c, ((DeleteHiddenFriendRes)object0));
    }
}

