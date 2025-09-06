package com.iloen.melon.fragments.musicmessage;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v6x.response.MusicMessageDeleteBanUserRes;
import com.iloen.melon.net.v6x.response.MusicMessageInsertBanUserRes;

public final class i implements Listener {
    public final int a;
    public final MusicMessageListFragment b;
    public final int c;

    public i(MusicMessageListFragment musicMessageListFragment0, int v, int v1) {
        this.a = v1;
        this.b = musicMessageListFragment0;
        this.c = v;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            MusicMessageListFragment.unblockUser$lambda$24$lambda$22(this.b, this.c, ((MusicMessageDeleteBanUserRes)object0));
            return;
        }
        MusicMessageListFragment.blockUser$lambda$20$lambda$18(this.b, this.c, ((MusicMessageInsertBanUserRes)object0));
    }
}

