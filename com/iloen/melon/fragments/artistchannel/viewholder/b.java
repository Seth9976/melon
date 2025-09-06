package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.DetailBaseRes.ARTISTNOTE;

public final class b implements View.OnClickListener {
    public final int a;
    public final ARTISTNOTE b;
    public final ArtistArtistNoteHolder c;
    public final int d;

    public b(ArtistArtistNoteHolder artistArtistNoteHolder0, ARTISTNOTE detailBaseRes$ARTISTNOTE0, int v) {
        this.a = 0;
        super();
        this.c = artistArtistNoteHolder0;
        this.b = detailBaseRes$ARTISTNOTE0;
        this.d = v;
    }

    public b(ARTISTNOTE detailBaseRes$ARTISTNOTE0, ArtistArtistNoteHolder artistArtistNoteHolder0, int v, int v1) {
        this.a = v1;
        this.b = detailBaseRes$ARTISTNOTE0;
        this.c = artistArtistNoteHolder0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ArtistArtistNoteHolder.bindItem$lambda$3(this.c, this.b, this.d, view0);
                return;
            }
            case 1: {
                ArtistArtistNoteHolder.a(this.c, this.b, this.d, view0);
                return;
            }
            case 2: {
                ArtistArtistNoteHolder.c(this.c, this.b, this.d, view0);
                return;
            }
            default: {
                ArtistArtistNoteHolder.b(this.c, this.b, this.d, view0);
            }
        }
    }
}

