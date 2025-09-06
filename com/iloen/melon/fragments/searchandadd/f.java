package com.iloen.melon.fragments.searchandadd;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.SongInfoBase;

public final class f implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public f(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PlaylistAdapter.onBindViewImpl$lambda$1$lambda$0(((PlaylistSearchAndAddPlaylistFragment)this.b), ((PLAYLISTLIST)this.c), view0);
                return;
            }
            case 1: {
                SongListAdapter.onBindViewHolder$lambda$6$lambda$5(((PlaylistSearchAndAddPlaylistFragment)this.b), ((SongInfoBase)this.c), view0);
                return;
            }
            case 2: {
                SearchListAdapter.onBindViewHolder$lambda$3(((O0)this.b), ((PlaylistSearchAndAddTabFragment)this.c), view0);
                return;
            }
            case 3: {
                PlaylistSearchAndAddAdapter.onBindViewImpl$lambda$3(((PlaylistSearchAndAddAdapter)this.b), ((SongInfoBase)this.c), view0);
                return;
            }
            default: {
                SearchAndAddNowPlayingSongAdapter.onBindViewImpl$lambda$2(((PlaylistSearchAndAddSongListFragment)this.b), ((Playable)this.c), view0);
            }
        }
    }
}

