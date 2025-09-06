package com.iloen.melon.fragments.artistchannel;

import E8.g;
import a9.d;
import android.widget.TextView;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicListRes;
import com.iloen.melon.net.v6x.response.ArtistContentsPhotoListRes;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsAlbumRes;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsArtistNoteRes;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsStationRes;
import com.iloen.melon.net.v6x.response.ArtistFanFollowYnListRes;
import com.iloen.melon.net.v6x.response.ArtistMusicSongListRes;
import com.iloen.melon.net.v6x.response.ArtistPickWholeListRes;
import com.iloen.melon.net.v6x.response.DetailContentsMagazineRes;
import com.iloen.melon.net.v6x.response.DetailContentsMvRes;
import java.util.ArrayList;
import java.util.List;
import v9.i;

public final class c implements g, d, ErrorListener, Listener {
    public final int a;
    public final Object b;
    public final Object c;

    public c(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // E8.g
    public void b(int v) {
        if(this.a != 0) {
            VideoAdapter.onBindViewImpl$lambda$1$lambda$0(((ArtistDetailContentsVideoFragment)this.b), ((VideoAdapter)this.c), v);
            return;
        }
        AlbumAdapter.onBindViewImpl$lambda$1$lambda$0(((ArtistDetailContentsAlbumFragment)this.b), ((AlbumAdapter)this.c), v);
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionCountApi.2.invokeSuspend$lambda$4$lambda$3(((TextView)this.b), ((TextView)this.c), volleyError0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 4: {
                ArtistDetailContentsAlbumFragment.fetchAlbumList$lambda$10(((ArtistDetailContentsAlbumFragment)this.b), ((i)this.c), ((ArtistDetailContentsAlbumRes)object0));
                return;
            }
            case 5: {
                ArtistDetailContentsArtistNoteFragment.onFetchStart$lambda$3(((ArtistDetailContentsArtistNoteFragment)this.b), ((i)this.c), ((ArtistDetailContentsArtistNoteRes)object0));
                return;
            }
            case 6: {
                ArtistDetailContentsMagazineFragment.onFetchStart$lambda$3(((ArtistDetailContentsMagazineFragment)this.b), ((i)this.c), ((DetailContentsMagazineRes)object0));
                return;
            }
            case 7: {
                ArtistDetailContentsPhotoFragment.onFetchStart$lambda$6(((ArtistDetailContentsPhotoFragment)this.b), ((i)this.c), ((ArtistContentsPhotoListRes)object0));
                return;
            }
            case 8: {
                ArtistDetailContentsSongFragment.fetchSongList$lambda$19(((ArtistDetailContentsSongFragment)this.b), ((i)this.c), ((ArtistMusicSongListRes)object0));
                return;
            }
            case 9: {
                ArtistDetailContentsStationFragment.onFetchStart$lambda$2(((ArtistDetailContentsStationFragment)this.b), ((i)this.c), ((ArtistDetailContentsStationRes)object0));
                return;
            }
            case 10: {
                ArtistDetailContentsTopicFragment.fetchTopicLike$lambda$19(((ArtistDetailContentsTopicFragment)this.b), ((List)this.c), ((UserActionsRes)object0));
                return;
            }
            case 11: {
                ArtistDetailContentsTopicFragment.onFetchStart$lambda$7(((ArtistDetailContentsTopicFragment)this.b), ((i)this.c), ((ArtistContentsArtistTopicListRes)object0));
                return;
            }
            case 12: {
                ArtistDetailContentsVideoFragment.onFetchStart$lambda$6(((ArtistDetailContentsVideoFragment)this.b), ((i)this.c), ((DetailContentsMvRes)object0));
                return;
            }
            case 13: {
                ArtistDetailFanListFragment.getFollowYNInfoFromServer$lambda$3(((ArtistDetailFanListFragment)this.b), ((ArrayList)this.c), ((ArtistFanFollowYnListRes)object0));
                return;
            }
            default: {
                ArtistPickGridFragment.onFetchStart$lambda$2(((ArtistPickGridFragment)this.b), ((i)this.c), ((ArtistPickWholeListRes)object0));
            }
        }
    }

    @Override  // a9.d
    public void onSelected(int v) {
        TopicAdapter.onBindViewImpl$lambda$1$lambda$0(((ArtistDetailContentsTopicFragment)this.b), ((TextView)this.c), v);
    }
}

