package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RelatedArtistsInfoBase;

public final class g implements View.OnClickListener {
    public final int a;
    public final ArtistGroupHolder b;
    public final RelatedArtistsInfoBase c;
    public final int d;

    public g(ArtistGroupHolder artistGroupHolder0, RelatedArtistsInfoBase artistHomeContentsRes$RelatedArtistsInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = artistGroupHolder0;
        this.c = artistHomeContentsRes$RelatedArtistsInfoBase0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ArtistGroupHolder.bindItem$lambda$4(this.b, this.c, this.d, view0);
            return;
        }
        ArtistGroupHolder.bindItem$lambda$3(this.b, this.c, this.d, view0);
    }
}

