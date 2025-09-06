package com.iloen.melon.fragments.searchandadd;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;

public final class h implements View.OnClickListener {
    public final int a;
    public final Serializable b;
    public final int c;
    public final MelonBaseFragment d;
    public final j0 e;

    public h(MelonBaseFragment melonBaseFragment0, Serializable serializable0, j0 j00, int v, int v1) {
        this.a = v1;
        this.d = melonBaseFragment0;
        this.b = serializable0;
        this.e = j00;
        this.c = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                SongListAdapter.onBindViewHolder$lambda$6$lambda$4(((PlaylistSearchAndAddPlaylistFragment)this.d), ((SongInfoBase)this.b), ((SongListAdapter)this.e), this.c, view0);
                return;
            }
            case 1: {
                SearchListAdapter.onBindViewHolder$lambda$5$lambda$4(((PlaylistSearchAndAddTabFragment)this.d), ((SongInfoBase)this.b), ((SearchListAdapter)this.e), this.c, view0);
                return;
            }
            default: {
                SearchAndAddNowPlayingSongAdapter.onBindViewImpl$lambda$0(((PlaylistSearchAndAddSongListFragment)this.d), ((Playable)this.b), ((SearchAndAddNowPlayingSongAdapter)this.e), this.c, view0);
            }
        }
    }
}

