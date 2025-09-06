package com.iloen.melon.fragments.musicmessage;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST;

public final class l implements View.OnLongClickListener {
    public final MusicMessageListViewHolder a;
    public final INBOXLIST b;
    public final int c;
    public final int d;

    public l(MusicMessageListViewHolder musicMessageListViewHolder0, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v, int v1) {
        this.a = musicMessageListViewHolder0;
        this.b = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0;
        this.c = v;
        this.d = v1;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return MusicMessageListViewHolder.bindView$lambda$3(this.a, this.b, this.c, this.d, view0);
    }
}

