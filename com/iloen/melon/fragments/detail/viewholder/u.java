package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE.MIX;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;

public final class u implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final Serializable d;
    public final Object e;
    public final Object f;

    public u(OtherSongHolder otherSongHolder0, SongInfoBase songInfoBase0, InnerSongAdapter otherSongHolder$InnerSongAdapter0, SongHolder songHolder0, int v) {
        this.a = 0;
        super();
        this.c = otherSongHolder0;
        this.d = songInfoBase0;
        this.e = otherSongHolder$InnerSongAdapter0;
        this.f = songHolder0;
        this.b = v;
    }

    public u(MIX forUDetailRes$RESPONSE$MIX0, MIX forUDetailRes$RESPONSE$MIX1, PlaylistMixHolder playlistMixHolder0, int v, String s) {
        this.a = 1;
        super();
        this.c = forUDetailRes$RESPONSE$MIX0;
        this.d = forUDetailRes$RESPONSE$MIX1;
        this.e = playlistMixHolder0;
        this.b = v;
        this.f = s;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            PlaylistMixHolder.bindItem$lambda$6$lambda$4(((MIX)this.c), ((MIX)this.d), ((PlaylistMixHolder)this.e), this.b, ((String)this.f), view0);
            return;
        }
        InnerSongAdapter.onBindViewImpl$lambda$3$lambda$2$lambda$0(((OtherSongHolder)this.c), ((SongInfoBase)this.d), ((InnerSongAdapter)this.e), ((SongHolder)this.f), this.b, view0);
    }
}

