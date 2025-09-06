package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v6x.response.CommentMyListRes.RESPONSE.CMTLIST.LANDING;
import com.iloen.melon.net.v6x.response.CommentMyListRes.RESPONSE.CMTLIST;
import com.iloen.melon.net.v6x.response.MyMusicTopListSongManyRes.RESPONSE.SONGLIST;
import com.melon.net.res.common.SongInfoBase;

public final class e implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public e(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PlaylistAdapter.onBindViewImpl$lambda$7(((DjPlaylistFragment)this.b), ((MelonTextView)this.c), view0);
                return;
            }
            case 1: {
                LockerAdapter.onBindViewHolder$lambda$15(((LockerFragment)this.b), ((LockerAdapter)this.c), view0);
                return;
            }
            case 2: {
                FanArtistAdapter.onBindViewImpl$lambda$8$lambda$7(((MyMusicFanArtistFragment)this.b), ((O0)this.c), view0);
                return;
            }
            case 3: {
                LikedSongAdapter.onBindViewImpl$lambda$4(((MyMusicLikedSongFragment)this.b), ((SongInfoBase)this.c), view0);
                return;
            }
            case 4: {
                ListenedSongAdapter.onBindViewImpl$lambda$4(((SongInfoBase)this.b), ((MyMusicListenedSongFragment)this.c), view0);
                return;
            }
            case 5: {
                MyChartAdapter.onBindViewImpl$lambda$4(((SONGLIST)this.b), ((MyMusicMyChartMonthFragment)this.c), view0);
                return;
            }
            case 6: {
                CommentAdapter.onBindViewImpl$lambda$0(((CommentAdapter)this.b), ((CMTLIST)this.c), view0);
                return;
            }
            case 7: {
                CommentAdapter.onBindViewImpl$lambda$1(((CommentAdapter)this.b), ((LANDING)this.c), view0);
                return;
            }
            case 8: {
                com.iloen.melon.fragments.mymusic.PlaylistFragment.PlaylistAdapter.onBindViewImpl$lambda$4(((PlaylistFragment)this.b), ((MelonTextView)this.c), view0);
                return;
            }
            default: {
                DjPicklistAdapter.onBindViewImpl$lambda$1(((ProfileDjPickListFragment)this.b), ((B9.e)this.c), view0);
            }
        }
    }
}

