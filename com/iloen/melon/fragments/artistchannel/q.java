package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE;

public final class q implements View.OnClickListener {
    public final int a;
    public final Object b;

    public q(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                IntroHolder.bind$lambda$1(((RESPONSE)this.b), view0);
                return;
            }
            case 1: {
                ArtistDetailTemperatureAdapter.onBindViewImpl$lambda$15(((ArtistDetailTemperatureAdapter)this.b), view0);
                return;
            }
            case 2: {
                ArtistDetailDetailInfoFragment.onViewCreated$lambda$0(((ArtistDetailDetailInfoFragment)this.b), view0);
                return;
            }
            default: {
                ArtistDetailTemperatureFragment.onViewCreated$lambda$4(((ArtistDetailTemperatureFragment)this.b), view0);
            }
        }
    }
}

