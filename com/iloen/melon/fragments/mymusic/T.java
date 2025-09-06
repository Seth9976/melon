package com.iloen.melon.fragments.mymusic;

import B9.u;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.DjMembersDjPickPlaylistsRes.RESPONSE.DJPLAYLISTLIST;
import kotlin.jvm.internal.H;

public final class t implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;

    public t(Object object0, Object object1, Object object2, Object object3, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = object3;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            DjPicklistAdapter.onBindViewImpl$lambda$2(((u)this.b), ((ProfileDjPickListFragment)this.c), ((DJPLAYLISTLIST)this.d), ((DjPicklistAdapter)this.e), view0);
            return;
        }
        PrivateSettingViewHolder.bindItem$lambda$0(((MemberProfileEditFragment)this.b), ((H)this.c), ((MemberProfileEditAdapter)this.d), ((String)this.e), view0);
    }
}

