package com.iloen.melon.fragments.friend;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE.USERLIST;

public final class j implements View.OnClickListener {
    public final int a;
    public final USERLIST b;
    public final O0 c;
    public final Object d;

    public j(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, Object object0, O0 o00, int v) {
        this.a = v;
        this.b = listFollowingFollowerRes$RESPONSE$USERLIST0;
        this.d = object0;
        this.c = o00;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                FollowerAdapter.onBindViewImpl$lambda$9(this.b, ((FollowerFragment)this.d), this.c, view0);
                return;
            }
            case 1: {
                FollowingAdapter.onBindViewImpl$lambda$9(this.b, ((FollowingAdapter)this.d), this.c, view0);
                return;
            }
            case 2: {
                com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter.onBindViewImpl$lambda$4(this.b, ((OtherFollowerFragment)this.d), this.c, view0);
                return;
            }
            default: {
                com.iloen.melon.fragments.friend.OtherFollowingFragment.FollowingAdapter.onBindViewImpl$lambda$5(this.b, ((OtherFollowingFragment)this.d), this.c, view0);
            }
        }
    }
}

