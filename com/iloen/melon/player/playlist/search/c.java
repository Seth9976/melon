package com.iloen.melon.player.playlist.search;

import android.view.View;
import d2.n;
import kotlin.jvm.internal.q;

public final class c implements n {
    public final PlaylistSearchFragment a;
    public final SearchWrapperPlayable b;

    public c(PlaylistSearchFragment playlistSearchFragment0, SearchWrapperPlayable searchListType$SearchWrapperPlayable0) {
        this.a = playlistSearchFragment0;
        this.b = searchListType$SearchWrapperPlayable0;
    }

    @Override  // d2.n
    public final boolean t(View view0) {
        q.g(view0, "<unused var>");
        ClickSongItem playlistSearchUserEvent$ClickSongItem0 = new ClickSongItem(this.b.getIndexInPlaylist());
        this.a.sendUserEvent(playlistSearchUserEvent$ClickSongItem0);
        return true;
    }
}

