package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.LikeListTagBaseRes.RESPONSE.TAGLIST;
import com.iloen.melon.net.v5x.response.MelonTvProgramLikeProgListForMyMusicRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v6x.response.ProfileBaseRes.SnsInfoBase;

public final class w implements View.OnClickListener {
    public final int a;
    public final Object b;

    public w(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                SnsConnectViewHolder.bindItem$lambda$6$lambda$5(((SnsInfoBase)this.b), view0);
                return;
            }
            case 1: {
                LikedTagAdapter.onBindViewImpl$lambda$3$lambda$2(((TAGLIST)this.b), view0);
                return;
            }
            case 2: {
                LikedMvAdapter.onBindViewImpl$lambda$6$lambda$1(((CONTENTSLIST)this.b), view0);
                return;
            }
            case 3: {
                MyMusicPlayListEditFragment.onViewCreated$lambda$1$lambda$0(((MyMusicPlayListEditFragment)this.b), view0);
                return;
            }
            case 4: {
                MyMusicTabFragment.getPlaylistEditRightButton$lambda$2$lambda$1(((MyMusicTabFragment)this.b), view0);
                return;
            }
            default: {
                ProfileDjPickListFragment.onViewCreated$lambda$2$lambda$1(((ProfileDjPickListFragment)this.b), view0);
            }
        }
    }
}

