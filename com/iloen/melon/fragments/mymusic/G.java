package com.iloen.melon.fragments.mymusic;

import B9.e;
import a9.d;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.android.volley.Response.Listener;
import com.iloen.melon.custom.K;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.response.MyMusicLikeListAlbumRes;
import com.iloen.melon.net.v4x.response.MyMusicLikeListSongRes;
import com.iloen.melon.net.v4x.response.MyMusicRecentListMvRecntRes;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v5x.response.MyMusicLikeListTagRes;
import com.iloen.melon.net.v5x.response.MyMusicRecentListSongRecntRes;
import com.iloen.melon.net.v6x.response.CommentMyListRes;
import com.iloen.melon.net.v6x.response.DjMembersDjPickPlaylistsRes;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res;
import com.iloen.melon.net.v6x.response.ListArtistMyFanRes;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes;
import com.iloen.melon.net.v6x.response.MyMusicLikeUpdateListCastRes;
import com.iloen.melon.net.v6x.response.MyMusicLyricListLyricHighlightRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListV6Res;
import com.iloen.melon.net.v6x.response.MyMusicRecentListPlylstRecntRes;
import java.util.ArrayList;
import v9.i;
import we.k;

public final class g implements d, Listener, K {
    public final int a;
    public final MetaContentBaseFragment b;
    public final Object c;

    public g(MetaContentBaseFragment metaContentBaseFragment0, Object object0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        this.c = object0;
        super();
    }

    @Override  // com.iloen.melon.custom.K
    public void onClick(View view0) {
        switch(this.a) {
            case 2: {
                LikedAlbumAdapter.onBindViewImpl$lambda$1$lambda$0(((MyMusicLikedAlbumFragment)this.b), ((LikedAlbumAdapter)this.c), view0);
                return;
            }
            case 3: {
                LikedCastAdapter.onBindViewImpl$lambda$2(((MyMusicLikedCastFragment)this.b), ((LikedCastAdapter)this.c), view0);
                return;
            }
            case 4: {
                LikedPlaylistAdapter.onBindViewImpl$lambda$3$lambda$0(((MyMusicLikedPlaylistFragment)this.b), ((LikedPlaylistAdapter)this.c), view0);
                return;
            }
            default: {
                LikedTagAdapter.onBindViewImpl$lambda$1$lambda$0(((MyMusicLikedTagFragment)this.b), ((LikedTagAdapter)this.c), view0);
            }
        }
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 6: {
                ListenedPlaylistAdapter.playForUSongList$lambda$3(((MyMusicListenedPlaylistFragment)this.b), ((ListenedPlaylistAdapter)this.c), object0);
                return;
            }
            case 9: {
                DjPlaylistFragment.onFetchStart$lambda$5(((DjPlaylistFragment)this.b), ((i)this.c), ((DjPlaylistListV6Res)object0));
                return;
            }
            case 10: {
                MemberProfileEditFragment.requestDjTermSnsAgree$lambda$15(((MemberProfileEditFragment)this.b), ((ArrayList)this.c), object0);
                return;
            }
            case 11: {
                MyDetailContentsLyricHighlightFragment.onFetchStart$lambda$3(((MyDetailContentsLyricHighlightFragment)this.b), ((i)this.c), ((MyMusicLyricListLyricHighlightRes)object0));
                return;
            }
            case 12: {
                MyMusicFanArtistFragment.getTemperatureInfoFromServer$lambda$7(((MyMusicFanArtistFragment)this.b), ((ArrayList)this.c), ((UserActionsRes)object0));
                return;
            }
            case 13: {
                MyMusicFanArtistFragment.requestListArtistMyFan$lambda$4(((MyMusicFanArtistFragment)this.b), ((i)this.c), ((ListArtistMyFanRes)object0));
                return;
            }
            case 14: {
                ((MyMusicLikeEditFragment)this.b).lambda$requestLikeCast$0(((i)this.c), ((MyMusicLikeUpdateListCastRes)object0));
                return;
            }
            case 15: {
                MyMusicLikedCastFragment.onFetchStart$lambda$2(((MyMusicLikedCastFragment)this.b), ((i)this.c), ((MyMusicCastListRes)object0));
                return;
            }
            case 16: {
                MyMusicLikedTagFragment.onFetchStart$lambda$1(((MyMusicLikedTagFragment)this.b), ((i)this.c), ((MyMusicLikeListTagRes)object0));
                return;
            }
            case 17: {
                MyMusicListenedCastFragment.onFetchStart$lambda$1(((MyMusicListenedCastFragment)this.b), ((i)this.c), ((MyMusicCastListRes)object0));
                return;
            }
            case 18: {
                MyMusicListenedPlaylistFragment.onFetchStart$lambda$0(((MyMusicListenedPlaylistFragment)this.b), ((i)this.c), ((MyMusicRecentListPlylstRecntRes)object0));
                return;
            }
            case 19: {
                MyMusicListenedSongFragment.onFetchStart$lambda$4(((MyMusicListenedSongFragment)this.b), ((i)this.c), ((MyMusicRecentListSongRecntRes)object0));
                return;
            }
            case 20: {
                MyMusicListenedVideoFragment.onFetchStart$lambda$2(((MyMusicListenedVideoFragment)this.b), ((i)this.c), ((MyMusicRecentListMvRecntRes)object0));
                return;
            }
            case 21: {
                MyMusicMyCommentFragment.onFetchStart$lambda$1(((MyMusicMyCommentFragment)this.b), ((i)this.c), ((CommentMyListRes)object0));
                return;
            }
            case 22: {
                OtherMusicLikedAlbumFragment.onFetchStart$lambda$1(((OtherMusicLikedAlbumFragment)this.b), ((i)this.c), ((MyMusicLikeListAlbumRes)object0));
                return;
            }
            case 23: {
                OtherMusicLikedSongFragment.onFetchStart$lambda$10(((OtherMusicLikedSongFragment)this.b), ((i)this.c), ((MyMusicLikeListSongRes)object0));
                return;
            }
            case 24: {
                OtherMusicLikedSongFragment.getAllLikedSong$lambda$7(((OtherMusicLikedSongFragment)this.b), ((k)this.c), object0);
                return;
            }
            case 25: {
                PlaylistFragment.onFetchStart$lambda$4(((PlaylistFragment)this.b), ((i)this.c), ((MyMusicPlaylistListV6Res)object0));
                return;
            }
            default: {
                ProfileDjPickListFragment.onFetchStart$lambda$5(((ProfileDjPickListFragment)this.b), ((i)this.c), ((DjMembersDjPickPlaylistsRes)object0));
            }
        }
    }

    @Override  // a9.d
    public void onSelected(int v) {
        switch(this.a) {
            case 0: {
                PlaylistAdapter.onBindViewImpl$lambda$7$lambda$6(((DjPlaylistFragment)this.b), ((MelonTextView)this.c), v);
                return;
            }
            case 1: {
                FanArtistAdapter.onBindViewImpl$lambda$8$lambda$7$lambda$6(((MyMusicFanArtistFragment)this.b), ((O0)this.c), v);
                return;
            }
            case 7: {
                com.iloen.melon.fragments.mymusic.PlaylistFragment.PlaylistAdapter.onBindViewImpl$lambda$4$lambda$3(((PlaylistFragment)this.b), ((MelonTextView)this.c), v);
                return;
            }
            default: {
                DjPicklistAdapter.onBindViewImpl$lambda$1$lambda$0(((ProfileDjPickListFragment)this.b), ((e)this.c), v);
            }
        }
    }
}

