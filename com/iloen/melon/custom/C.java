package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder;
import com.iloen.melon.fragments.musicmessage.MusicMessageBlockListViewHolder;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorBaseViewHolder;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorMeViewHolder;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorYouViewHolder;
import com.iloen.melon.fragments.musicmessage.MusicMessageListViewHolder;
import com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes.RESPONSE.USERLIST;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST;
import java.io.Serializable;
import java.util.List;
import we.n;

public final class c implements View.OnClickListener {
    public final int a;
    public final int b;
    public final int c;
    public final Object d;
    public final Object e;

    public c(ArtistCardRelayRollingView artistCardRelayRollingView0, int v, List list0, int v1) {
        this.a = 0;
        super();
        this.d = artistCardRelayRollingView0;
        this.b = v;
        this.e = list0;
        this.c = v1;
    }

    public c(MusicMessageBaseViewHolder musicMessageBaseViewHolder0, Serializable serializable0, int v, int v1, int v2) {
        this.a = v2;
        this.d = musicMessageBaseViewHolder0;
        this.e = serializable0;
        this.b = v;
        this.c = v1;
        super();
    }

    public c(MusicMessageEditorBaseViewHolder musicMessageEditorBaseViewHolder0, int v, int v1, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, int v2) {
        this.a = v2;
        this.d = musicMessageEditorBaseViewHolder0;
        this.b = v;
        this.c = v1;
        this.e = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                List list0 = (List)this.e;
                n n0 = ((ArtistCardRelayRollingView)this.d).a;
                if(n0 != null) {
                    Object object0 = list0.get(this.c);
                    n0.invoke(this.b, object0);
                }
                return;
            }
            case 1: {
                MusicMessageBlockListViewHolder.b(((MusicMessageBlockListViewHolder)this.d), ((USERLIST)this.e), this.b, this.c, view0);
                return;
            }
            case 2: {
                MusicMessageEditorMeViewHolder.b(((MusicMessageEditorMeViewHolder)this.d), this.b, this.c, ((CONTENTSLIST)this.e), view0);
                return;
            }
            case 3: {
                MusicMessageEditorYouViewHolder.c(((MusicMessageEditorYouViewHolder)this.d), this.b, this.c, ((CONTENTSLIST)this.e), view0);
                return;
            }
            default: {
                MusicMessageListViewHolder.c(((MusicMessageListViewHolder)this.d), ((INBOXLIST)this.e), this.b, this.c, view0);
            }
        }
    }
}

