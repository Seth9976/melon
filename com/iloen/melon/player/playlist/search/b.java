package com.iloen.melon.player.playlist.search;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.ProgramDetailBottomFragment.ProgramDetailAdapter;
import com.iloen.melon.fragments.ProgramDetailBottomFragment;
import com.iloen.melon.net.v5x.response.CastProgramEpsdRes.Response.CastList;
import com.iloen.melon.playback.Playable;

public final class b implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final int e;

    public b(PlaylistSearchFragment playlistSearchFragment0, SearchWrapperPlayable searchListType$SearchWrapperPlayable0, int v, Playable playable0) {
        this.a = 0;
        super();
        this.b = playlistSearchFragment0;
        this.c = searchListType$SearchWrapperPlayable0;
        this.e = v;
        this.d = playable0;
    }

    public b(Object object0, Object object1, Object object2, int v, int v1) {
        this.a = v1;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        this.e = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ClickSongItem playlistSearchUserEvent$ClickSongItem0 = new ClickSongItem(((SearchWrapperPlayable)this.c).getIndexInPlaylist());
                ((PlaylistSearchFragment)this.b).sendUserEvent(playlistSearchUserEvent$ClickSongItem0);
                PlaylistSearchFragment.access$getTiaraLogHelper(((PlaylistSearchFragment)this.b)).sendPlayClickLog(this.e, ((Playable)this.d));
                return;
            }
            case 1: {
                ClickAlbumThumbnail playlistSearchUserEvent$ClickAlbumThumbnail0 = new ClickAlbumThumbnail(((SearchWrapperPlayable)this.c).getIndexInPlaylist(), ((Playable)this.d));
                ((PlaylistSearchFragment)this.b).sendUserEvent(playlistSearchUserEvent$ClickAlbumThumbnail0);
                PlaylistSearchFragment.access$getTiaraLogHelper(((PlaylistSearchFragment)this.b)).sendAlbumImgClickLog(this.e, ((Playable)this.d));
                return;
            }
            default: {
                ProgramDetailAdapter.onBindViewImpl$lambda$2$lambda$1(((CastList)this.b), ((ProgramDetailAdapter)this.c), ((ProgramDetailBottomFragment)this.d), this.e, view0);
            }
        }
    }
}

