package com.iloen.melon.fragments.musicmessage;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v4x.response.MusicMessageInformInboxSeqRes;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes;
import v9.i;

public final class b implements Listener {
    public final int a;
    public final MusicMessageEditorFragment b;
    public final i c;

    public b(MusicMessageEditorFragment musicMessageEditorFragment0, i i0, int v) {
        this.a = v;
        this.b = musicMessageEditorFragment0;
        this.c = i0;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public final void onResponse(Object object0) {
        if(this.a != 0) {
            MusicMessageEditorFragment.y0(this.b, this.c, ((MusicMessageInformInboxSeqRes)object0));
            return;
        }
        MusicMessageEditorFragment.l0(this.b, this.c, ((MusicMessageListMusicMsgInboxContentsRes)object0));
    }
}

