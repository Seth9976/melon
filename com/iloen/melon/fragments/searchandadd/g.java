package com.iloen.melon.fragments.searchandadd;

import android.view.View.OnClickListener;
import android.view.View;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.F;

public final class g implements View.OnClickListener {
    public final SongListAdapter a;
    public final C b;
    public final PlaylistSearchAndAddPlaylistFragment c;
    public final F d;

    public g(SongListAdapter playlistSearchAndAddPlaylistFragment$SongListAdapter0, C c0, PlaylistSearchAndAddPlaylistFragment playlistSearchAndAddPlaylistFragment0, F f0) {
        this.a = playlistSearchAndAddPlaylistFragment$SongListAdapter0;
        this.b = c0;
        this.c = playlistSearchAndAddPlaylistFragment0;
        this.d = f0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        SongListAdapter.onBindViewHolder$lambda$3(this.a, this.b, this.c, this.d, view0);
    }
}

