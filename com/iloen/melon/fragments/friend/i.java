package com.iloen.melon.fragments.friend;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE.USERLIST;

public final class i implements View.OnClickListener {
    public final int a;
    public final Object b;

    public i(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                FollowerAdapter.onBindViewImpl$lambda$6(((USERLIST)this.b), view0);
                return;
            }
            case 1: {
                FollowingAdapter.onBindViewImpl$lambda$6(((USERLIST)this.b), view0);
                return;
            }
            case 2: {
                com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter.onBindViewImpl$lambda$1(((USERLIST)this.b), view0);
                return;
            }
            case 3: {
                com.iloen.melon.fragments.friend.OtherFollowingFragment.FollowingAdapter.onBindViewImpl$lambda$1(((USERLIST)this.b), view0);
                return;
            }
            default: {
                FriendPagerFragment.buildTitleBar$lambda$3$lambda$1(((FriendPagerFragment)this.b), view0);
            }
        }
    }
}

