package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.DetailBaseRes.RELATIONCONTENT;

public final class x implements View.OnClickListener {
    public final int a;
    public final RELATIONCONTENT b;
    public final PlaylistRelationContentHolder c;
    public final int d;

    public x(PlaylistRelationContentHolder playlistRelationContentHolder0, RELATIONCONTENT detailBaseRes$RELATIONCONTENT0, int v) {
        this.a = 0;
        super();
        this.c = playlistRelationContentHolder0;
        this.b = detailBaseRes$RELATIONCONTENT0;
        this.d = v;
    }

    public x(RELATIONCONTENT detailBaseRes$RELATIONCONTENT0, PlaylistRelationContentHolder playlistRelationContentHolder0, int v, int v1) {
        this.a = v1;
        this.b = detailBaseRes$RELATIONCONTENT0;
        this.c = playlistRelationContentHolder0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PlaylistRelationContentHolder.bindItem$lambda$4$lambda$2(this.c, this.b, this.d, view0);
                return;
            }
            case 1: {
                PlaylistRelationContentHolder.c(this.c, this.b, this.d, view0);
                return;
            }
            default: {
                PlaylistRelationContentHolder.b(this.c, this.b, this.d, view0);
            }
        }
    }
}

