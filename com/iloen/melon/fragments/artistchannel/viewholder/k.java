package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.HIGHLIGHTLIST;

public final class k implements View.OnClickListener {
    public final int a;
    public final HIGHLIGHTLIST b;
    public final ArtistHighlightHolder c;
    public final int d;

    public k(ArtistHighlightHolder artistHighlightHolder0, HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, int v, int v1) {
        this.a = v1;
        this.c = artistHighlightHolder0;
        this.b = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0;
        this.d = v;
        super();
    }

    public k(HIGHLIGHTLIST artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0, ArtistHighlightHolder artistHighlightHolder0, int v, int v1) {
        this.a = v1;
        this.b = artistHomeContentsRes$RESPONSE$HIGHLIGHTLIST0;
        this.c = artistHighlightHolder0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ArtistHighlightHolder.c(this.c, this.b, this.d, view0);
                return;
            }
            case 1: {
                ArtistHighlightHolder.e(this.c, this.b, this.d, view0);
                return;
            }
            case 2: {
                ArtistHighlightHolder.bindHighlightSquareItem$lambda$7(this.c, this.b, this.d, view0);
                return;
            }
            case 3: {
                ArtistHighlightHolder.d(this.c, this.b, this.d, view0);
                return;
            }
            default: {
                ArtistHighlightHolder.bindHighlightSquareItem$lambda$9(this.c, this.b, this.d, view0);
            }
        }
    }
}

