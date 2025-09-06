package com.iloen.melon.fragments.musicmessage;

import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST.TARGETMEMBERINFOLIST;
import we.a;

public final class h implements a {
    public final int a;
    public final MusicMessageListFragment b;
    public final TARGETMEMBERINFOLIST c;
    public final int d;

    public h(MusicMessageListFragment musicMessageListFragment0, TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0, int v, int v1) {
        this.a = v1;
        this.b = musicMessageListFragment0;
        this.c = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0;
        this.d = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        return this.a == 0 ? MusicMessageListFragment.blockUser$lambda$20(this.b, this.c, this.d) : MusicMessageListFragment.unblockUser$lambda$24(this.b, this.c, this.d);
    }
}

