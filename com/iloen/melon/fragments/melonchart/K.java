package com.iloen.melon.fragments.melonchart;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.response.ArtistChartListRes.RESPONSE.CHARTLIST;

public final class k implements View.OnClickListener {
    public final CHARTLIST a;
    public final MelonChartArtistFragment b;
    public final ArtistAdapter c;
    public final int d;
    public final ArtistAllHolder e;

    public k(CHARTLIST artistChartListRes$RESPONSE$CHARTLIST0, MelonChartArtistFragment melonChartArtistFragment0, ArtistAdapter melonChartArtistFragment$ArtistAdapter0, int v, ArtistAllHolder melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0) {
        this.a = artistChartListRes$RESPONSE$CHARTLIST0;
        this.b = melonChartArtistFragment0;
        this.c = melonChartArtistFragment$ArtistAdapter0;
        this.d = v;
        this.e = melonChartArtistFragment$ArtistAdapter$ArtistAllHolder0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ArtistAdapter.onBindViewImpl$lambda$2(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

