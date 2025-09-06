package com.iloen.melon.fragments.friend;

import a9.d;
import androidx.recyclerview.widget.O0;
import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v6x.response.ListFollowingFollowerRes;
import v9.i;

public final class e implements d, Listener {
    public final int a;
    public final Object b;
    public final MetaContentBaseFragment c;

    public e(MetaContentBaseFragment metaContentBaseFragment0, Object object0, int v) {
        this.a = v;
        this.c = metaContentBaseFragment0;
        this.b = object0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 4: {
                FollowerFragment.onFetchStart$lambda$1(((FollowerFragment)this.c), ((i)this.b), ((ListFollowingFollowerRes)object0));
                return;
            }
            case 5: {
                FollowingFragment.onFetchStart$lambda$1(((FollowingFragment)this.c), ((i)this.b), ((ListFollowingFollowerRes)object0));
                return;
            }
            case 6: {
                OtherFollowerFragment.onFetchStart$lambda$1(((OtherFollowerFragment)this.c), ((i)this.b), ((ListFollowingFollowerRes)object0));
                return;
            }
            default: {
                OtherFollowingFragment.onFetchStart$lambda$1(((OtherFollowingFragment)this.c), ((i)this.b), ((ListFollowingFollowerRes)object0));
            }
        }
    }

    @Override  // a9.d
    public void onSelected(int v) {
        switch(this.a) {
            case 0: {
                FollowerAdapter.onBindViewImpl$lambda$3$lambda$2(((FollowerFragment)this.c), ((O0)this.b), v);
                return;
            }
            case 1: {
                FollowingAdapter.onBindViewImpl$lambda$4$lambda$3(((FollowingFragment)this.c), ((O0)this.b), v);
                return;
            }
            case 2: {
                com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter.onBindViewImpl$lambda$7$lambda$6(((OtherFollowerFragment)this.c), ((O0)this.b), v);
                return;
            }
            default: {
                com.iloen.melon.fragments.friend.OtherFollowingFragment.FollowingAdapter.onBindViewImpl$lambda$8$lambda$7(((OtherFollowingFragment)this.c), ((O0)this.b), v);
            }
        }
    }
}

