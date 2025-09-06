package com.iloen.melon.fragments.friend;

import X8.a;
import android.view.View.OnClickListener;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.net.v4x.response.ListRecmFriendRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v4x.response.SearchMemberListRes.RESPONSE.CONTENTSLIST;

public final class m implements a {
    public final int a;
    public final View.OnClickListener b;
    public final Object c;
    public final O0 d;

    public m(View.OnClickListener view$OnClickListener0, Object object0, O0 o00, int v) {
        this.a = v;
        this.b = view$OnClickListener0;
        this.c = object0;
        this.d = o00;
        super();
    }

    @Override  // X8.a
    public final void onJobComplete(String s) {
        switch(this.a) {
            case 0: {
                ((com.iloen.melon.fragments.friend.FriendAddFragment.FriendAddAdapter.8)this.b).lambda$onClick$0(((USERLIST)this.c), ((RecommandHolder)this.d), s);
                return;
            }
            case 1: {
                ((com.iloen.melon.fragments.friend.FriendAddFragment.FriendAddAdapter.8)this.b).lambda$onClick$1(((USERLIST)this.c), ((RecommandHolder)this.d), s);
                return;
            }
            default: {
                ((com.iloen.melon.fragments.friend.FriendSearchFragment.FriendSearchAdapter.2)this.b).lambda$onClick$0(((CONTENTSLIST)this.c), ((FriendSearchHolder)this.d), s);
            }
        }
    }
}

