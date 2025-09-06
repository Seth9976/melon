package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import com.iloen.melon.net.v5x.response.CastMemberDetailRes.RESPONSE.PROGRAM;
import com.melon.net.res.common.AlbumInfoBase;
import java.util.List;

public final class z implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public z(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LikedAlbumAdapter.a(((MyMusicLikedAlbumFragment)this.c), ((AlbumInfoBase)this.b), ((LikedAlbumAdapter)this.d), view0);
                return;
            }
            case 1: {
                CastProgramAdapter.onBindViewImpl$lambda$5$lambda$4(((String)this.b), ((ProfileDetailStationFragment)this.c), ((PROGRAM)this.d), view0);
                return;
            }
            default: {
                MyDetailContentsLyricHighlightFragment.makeHeaderView$lambda$1(((MyDetailContentsLyricHighlightFragment)this.b), ((List)this.c), ((TextView)this.d), view0);
            }
        }
    }
}

