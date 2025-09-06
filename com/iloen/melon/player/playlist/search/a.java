package com.iloen.melon.player.playlist.search;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.lifecycle.f0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

public final class a implements View.OnClickListener {
    public final int a;
    public final PlaylistSearchFragment b;

    public a(PlaylistSearchFragment playlistSearchFragment0, int v) {
        this.a = v;
        this.b = playlistSearchFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        PlaylistSearchFragment playlistSearchFragment0 = this.b;
        switch(this.a) {
            case 0: {
                BuildersKt__Builders_commonKt.launch$default(f0.f(playlistSearchFragment0), null, null, new PlaylistSearchFragment.closeSearchMode.1(playlistSearchFragment0, null), 3, null);
                return;
            }
            case 1: {
                BuildersKt__Builders_commonKt.launch$default(f0.f(playlistSearchFragment0), null, null, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.SearchEmptyViewHolder.1.1(playlistSearchFragment0, null), 3, null);
                return;
            }
            default: {
                BuildersKt__Builders_commonKt.launch$default(f0.f(playlistSearchFragment0), null, null, new com.iloen.melon.player.playlist.search.PlaylistSearchFragment.TotalSearchViewHolder.1.1(playlistSearchFragment0, null), 3, null);
            }
        }
    }
}

