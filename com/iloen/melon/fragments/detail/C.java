package com.iloen.melon.fragments.detail;

import a9.d;
import androidx.recyclerview.widget.O0;
import com.android.volley.Response.Listener;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.response.MyMusicInsertBanSongRes;
import com.iloen.melon.playback.Playable;

public final class c implements d, Listener {
    public final int a;
    public final MetaContentBaseFragment b;
    public final Object c;

    public c(int v, MixPlaylistDetailFragment mixPlaylistDetailFragment0, Playable playable0) {
        this.b = mixPlaylistDetailFragment0;
        this.a = v;
        this.c = playable0;
    }

    public c(AlbumDetailContentsPhotoFragment albumDetailContentsPhotoFragment0, O0 o00, int v) {
        this.b = albumDetailContentsPhotoFragment0;
        this.c = o00;
        this.a = v;
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        MixPlaylistDetailFragment.requestBanSong$lambda$35(((MixPlaylistDetailFragment)this.b), this.a, ((Playable)this.c), ((MyMusicInsertBanSongRes)object0));
    }

    @Override  // a9.d
    public void onSelected(int v) {
        PhotoAdapter.onBindViewImpl$lambda$1$lambda$0(((AlbumDetailContentsPhotoFragment)this.b), ((O0)this.c), this.a, v);
    }
}

