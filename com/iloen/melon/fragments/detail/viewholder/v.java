package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ForUDetailRes.RESPONSE.MIX;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;

public final class v implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;
    public final Object e;

    public v(PlaylistMixHolder playlistMixHolder0, MIX forUDetailRes$RESPONSE$MIX0, int v, String s) {
        this.a = 1;
        super();
        this.c = playlistMixHolder0;
        this.d = forUDetailRes$RESPONSE$MIX0;
        this.b = v;
        this.e = s;
    }

    public v(SongInfoBase songInfoBase0, SongHolder songHolder0, OtherSongHolder otherSongHolder0, int v) {
        this.a = 0;
        super();
        this.c = songInfoBase0;
        this.d = songHolder0;
        this.e = otherSongHolder0;
        this.b = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            PlaylistMixHolder.bindItem$lambda$6$lambda$5(((PlaylistMixHolder)this.c), ((MIX)this.d), this.b, ((String)this.e), view0);
            return;
        }
        InnerSongAdapter.onBindViewImpl$lambda$3$lambda$2$lambda$1(((SongInfoBase)this.c), ((SongHolder)this.d), ((OtherSongHolder)this.e), this.b, view0);
    }
}

