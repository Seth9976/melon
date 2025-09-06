package com.iloen.melon.fragments.detail;

import J8.E2;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.response.ArtistPlylstMainInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.DjPlaylistInformRes.RESPONSE.EVENT;
import com.iloen.melon.types.MelonLinkInfo;
import com.melon.net.res.common.SongInfoBase;

public final class h implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public h(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ArtistPlaylistDetailFragment.drawHeaderView$lambda$11$lambda$8(((ArtistPlaylistDetailFragment)this.b), ((RESPONSE)this.c), view0);
                return;
            }
            case 1: {
                DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$13(((DjPlaylistDetailFragment)this.b), ((EVENT)this.c), view0);
                return;
            }
            case 2: {
                DjPlaylistDetailFragment.drawHeaderView$lambda$25$lambda$23$lambda$21(((MelonLinkInfo)this.b), ((DjPlaylistDetailFragment)this.c), view0);
                return;
            }
            case 3: {
                PlaylistDetailBaseFragment.setDescText$lambda$11$lambda$10(((E2)this.b), ((PlaylistDetailBaseFragment)this.c), view0);
                return;
            }
            default: {
                SongDetailFragment.drawHeaderView$lambda$21$lambda$11(((com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE)this.b), ((SongInfoBase)this.c), view0);
            }
        }
    }
}

