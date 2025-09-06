package com.iloen.melon.fragments.friend;

import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.G;
import we.o;

public final class k implements o {
    public final int a;
    public final G b;
    public final O0 c;

    public k(G g0, O0 o00, int v) {
        this.a = v;
        this.b = g0;
        this.c = o00;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        return this.a == 0 ? ((com.iloen.melon.fragments.friend.FollowerSelectFragment.AlphabetAdapter.1)this.b).lambda$onClick$0(((FilterHolder)this.c), ((Integer)object0), ((Integer)object1), ((Integer)object2)) : ((com.iloen.melon.fragments.friend.FollowingSelectFragment.AlphabetAdapter.1)this.b).lambda$onClick$0(((com.iloen.melon.fragments.friend.FollowingSelectFragment.AlphabetAdapter.FilterHolder)this.c), ((Integer)object0), ((Integer)object1), ((Integer)object2));
    }
}

