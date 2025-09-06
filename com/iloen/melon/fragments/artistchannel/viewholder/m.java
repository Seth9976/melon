package com.iloen.melon.fragments.artistchannel.viewholder;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.RECMTRACKLIST;

public final class m implements View.OnClickListener {
    public final int a;
    public final ArtistRecommendTrackHolder b;
    public final RECMTRACKLIST c;
    public final int d;

    public m(ArtistRecommendTrackHolder artistRecommendTrackHolder0, RECMTRACKLIST artistHomeContentsRes$RESPONSE$RECMTRACKLIST0, int v, int v1) {
        this.a = v1;
        this.b = artistRecommendTrackHolder0;
        this.c = artistHomeContentsRes$RESPONSE$RECMTRACKLIST0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ArtistRecommendTrackHolder.bindItem$lambda$9(this.b, this.c, this.d, view0);
            return;
        }
        ArtistRecommendTrackHolder.bindItem$lambda$4(this.b, this.c, this.d, view0);
    }
}

