package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.ALBUMLIST;

public final class a implements View.OnClickListener {
    public final int a;
    public final ArtistAlbumHolder b;
    public final ALBUMLIST c;
    public final int d;

    public a(ArtistAlbumHolder artistAlbumHolder0, ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0, int v) {
        this.a = 1;
        super();
        this.b = artistAlbumHolder0;
        this.c = artistHomeContentsRes$RESPONSE$ALBUMLIST0;
        this.d = v;
    }

    public a(ALBUMLIST artistHomeContentsRes$RESPONSE$ALBUMLIST0, ArtistAlbumHolder artistAlbumHolder0, int v) {
        this.a = 0;
        super();
        this.c = artistHomeContentsRes$RESPONSE$ALBUMLIST0;
        this.b = artistAlbumHolder0;
        this.d = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ArtistAlbumHolder.bindItem$lambda$5(this.b, this.c, this.d, view0);
            return;
        }
        ArtistAlbumHolder.b(this.b, this.c, this.d, view0);
    }
}

