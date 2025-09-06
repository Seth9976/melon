package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE.PLAYLIST;
import com.iloen.melon.net.v6x.response.ListArtistMyFanRes.RESPONSE.ARTISTLIST;
import com.iloen.melon.net.v6x.response.ListMyFriendlyArtistRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res.RESPONSE.PLAYLISTLIST;
import com.melon.net.res.common.ArtistsInfoBase;
import java.io.Serializable;

public final class f implements View.OnClickListener {
    public final int a;
    public final int b;
    public final MetaContentBaseFragment c;
    public final Serializable d;

    public f(MetaContentBaseFragment metaContentBaseFragment0, ArtistPlayListInfoBase artistPlayListInfoBase0, int v, int v1) {
        this.a = v1;
        this.c = metaContentBaseFragment0;
        this.d = artistPlayListInfoBase0;
        this.b = v;
        super();
    }

    public f(MyMusicFanArtistFragment myMusicFanArtistFragment0, int v, ArtistsInfoBase artistsInfoBase0, int v1) {
        this.a = v1;
        this.c = myMusicFanArtistFragment0;
        this.b = v;
        this.d = artistsInfoBase0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PlaylistAdapter.onBindViewImpl$lambda$8(((DjPlaylistFragment)this.c), ((PLAYLIST)this.d), this.b, view0);
                return;
            }
            case 1: {
                FanArtistAdapter.onBindViewImpl$lambda$11$lambda$9(((MyMusicFanArtistFragment)this.c), this.b, ((ARTISTLIST)this.d), view0);
                return;
            }
            case 2: {
                FanArtistAdapter.onBindViewImpl$lambda$11$lambda$10(((MyMusicFanArtistFragment)this.c), this.b, ((CONTENTSLIST)this.d), view0);
                return;
            }
            default: {
                com.iloen.melon.fragments.mymusic.PlaylistFragment.PlaylistAdapter.onBindViewImpl$lambda$5(((PlaylistFragment)this.c), ((PLAYLISTLIST)this.d), this.b, view0);
            }
        }
    }
}

