package com.iloen.melon.fragments.musicmessage;

import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST.TARGETMEMBERINFOLIST;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST;
import com.melon.ui.k2;

public final class k implements we.k {
    public final boolean a;
    public final MusicMessageListFragment b;
    public final TARGETMEMBERINFOLIST c;
    public final int d;
    public final int e;
    public final INBOXLIST f;
    public final boolean g;

    public k(boolean z, MusicMessageListFragment musicMessageListFragment0, TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0, int v, int v1, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, boolean z1) {
        this.a = z;
        this.b = musicMessageListFragment0;
        this.c = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST$TARGETMEMBERINFOLIST0;
        this.d = v;
        this.e = v1;
        this.f = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0;
        this.g = z1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        return MusicMessageListFragment.openContextListPopup$lambda$16(this.a, this.b, this.c, this.d, this.e, this.f, this.g, ((k2)object0));
    }
}

