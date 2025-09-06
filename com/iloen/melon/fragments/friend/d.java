package com.iloen.melon.fragments.friend;

import com.iloen.melon.fragments.MetaContentBaseFragment;
import we.a;

public final class d implements a {
    public final int a;
    public final MetaContentBaseFragment b;

    public d(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.a) {
            case 0: {
                return FollowerFragment.filterTexts_delegate$lambda$0(((FollowerFragment)this.b));
            }
            case 1: {
                return FollowingFragment.filterTexts_delegate$lambda$0(((FollowingFragment)this.b));
            }
            case 2: {
                return OtherFollowerFragment.filterTexts_delegate$lambda$0(((OtherFollowerFragment)this.b));
            }
            default: {
                return OtherFollowingFragment.filterTexts_delegate$lambda$0(((OtherFollowingFragment)this.b));
            }
        }
    }
}

