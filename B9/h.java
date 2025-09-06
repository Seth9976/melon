package B9;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.MyMusicRecentListPlylstRecntRes.RESPONSE.RECNTPLYLSTLIST;

public final class h implements View.OnClickListener {
    public final int a;
    public final k b;
    public final RECNTPLYLSTLIST c;

    public h(k k0, RECNTPLYLSTLIST myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0, int v) {
        this.a = v;
        this.b = k0;
        this.c = myMusicRecentListPlylstRecntRes$RESPONSE$RECNTPLYLSTLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            com.iloen.melon.fragments.mymusic.MyMusicListenedPlaylistFragment.ListenedPlaylistAdapter.onBindViewImpl.6 myMusicListenedPlaylistFragment$ListenedPlaylistAdapter$onBindViewImpl$60 = this.b.g;
            if(myMusicListenedPlaylistFragment$ListenedPlaylistAdapter$onBindViewImpl$60 != null) {
                myMusicListenedPlaylistFragment$ListenedPlaylistAdapter$onBindViewImpl$60.playMixPlaylist(this.c);
            }
            return;
        }
        com.iloen.melon.fragments.mymusic.MyMusicListenedPlaylistFragment.ListenedPlaylistAdapter.onBindViewImpl.6 myMusicListenedPlaylistFragment$ListenedPlaylistAdapter$onBindViewImpl$61 = this.b.g;
        if(myMusicListenedPlaylistFragment$ListenedPlaylistAdapter$onBindViewImpl$61 != null) {
            myMusicListenedPlaylistFragment$ListenedPlaylistAdapter$onBindViewImpl$61.clickBody(this.c);
        }
    }
}

