package com.iloen.melon.fragments.friend;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class g implements View.OnClickListener {
    public final int a;
    public final O0 b;
    public final MetaContentBaseFragment c;

    public g(MetaContentBaseFragment metaContentBaseFragment0, O0 o00, int v) {
        this.a = v;
        this.c = metaContentBaseFragment0;
        this.b = o00;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                FollowerAdapter.onBindViewImpl$lambda$3(((FollowerFragment)this.c), this.b, view0);
                return;
            }
            case 1: {
                FollowingAdapter.onBindViewImpl$lambda$4(((FollowingFragment)this.c), this.b, view0);
                return;
            }
            case 2: {
                com.iloen.melon.fragments.friend.OtherFollowerFragment.FollowerAdapter.onBindViewImpl$lambda$7(((OtherFollowerFragment)this.c), this.b, view0);
                return;
            }
            default: {
                com.iloen.melon.fragments.friend.OtherFollowingFragment.FollowingAdapter.onBindViewImpl$lambda$8(((OtherFollowingFragment)this.c), this.b, view0);
            }
        }
    }
}

