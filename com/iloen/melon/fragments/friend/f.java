package com.iloen.melon.fragments.friend;

import androidx.recyclerview.widget.O0;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes.RESPONSE.USERLIST;
import we.a;

public final class f implements a {
    public final int a;
    public final USERLIST b;
    public final O0 c;

    public f(USERLIST listFollowingFollowerRes$RESPONSE$USERLIST0, O0 o00, int v) {
        this.a = v;
        this.b = listFollowingFollowerRes$RESPONSE$USERLIST0;
        this.c = o00;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return FollowerAdapter.onBindViewImpl$lambda$9$lambda$7(this.b, this.c);
            }
            case 1: {
                return FollowerAdapter.onBindViewImpl$lambda$9$lambda$8(this.b, this.c);
            }
            case 2: {
                return FollowingAdapter.onBindViewImpl$lambda$9$lambda$7(this.b, this.c);
            }
            case 3: {
                return FollowingAdapter.onBindViewImpl$lambda$9$lambda$8(this.b, this.c);
            }
            case 4: {
                return com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter.onBindViewImpl$lambda$4$lambda$2(this.b, this.c);
            }
            case 5: {
                return com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter.onBindViewImpl$lambda$4$lambda$3(this.b, this.c);
            }
            case 6: {
                return com.iloen.melon.fragments.friend.OtherFollowingFragment.FollowingAdapter.onBindViewImpl$lambda$5$lambda$3(this.b, this.c);
            }
            default: {
                return com.iloen.melon.fragments.friend.OtherFollowingFragment.FollowingAdapter.onBindViewImpl$lambda$5$lambda$4(this.b, this.c);
            }
        }
    }
}

