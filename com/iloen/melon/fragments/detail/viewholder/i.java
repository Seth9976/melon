package com.iloen.melon.fragments.detail.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ARTISTNOTE;

public final class i implements View.OnClickListener {
    public final int a;
    public final DetailContentsArtistNoteHolder b;
    public final ARTISTNOTE c;
    public final int d;

    public i(DetailContentsArtistNoteHolder detailContentsArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v, int v1) {
        this.a = v1;
        this.b = detailContentsArtistNoteHolder0;
        this.c = detailBaseRes$ARTISTNOTE0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailContentsArtistNoteHolder.bind$lambda$2(this.b, this.c, this.d, view0);
                return;
            }
            case 1: {
                DetailContentsArtistNoteHolder.bind$lambda$3(this.b, this.c, this.d, view0);
                return;
            }
            case 2: {
                DetailContentsArtistNoteHolder.bind$lambda$4(this.b, this.c, this.d, view0);
                return;
            }
            default: {
                DetailContentsArtistNoteHolder.bind$lambda$5(this.b, this.c, this.d, view0);
            }
        }
    }
}

