package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ArtistPickWholeListRes.RESPONSE.ArtistPick;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.TOPSTREAMINGSONG;

public final class p implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;
    public final Object e;

    public p(ArtistPickGridFragment artistPickGridFragment0, ArtistPickGridAdapter artistPickGridFragment$ArtistPickGridAdapter0, int v, ArtistPick artistPickWholeListRes$RESPONSE$ArtistPick0) {
        this.a = 2;
        super();
        this.c = artistPickGridFragment0;
        this.d = artistPickGridFragment$ArtistPickGridAdapter0;
        this.b = v;
        this.e = artistPickWholeListRes$RESPONSE$ArtistPick0;
    }

    public p(Object object0, Object object1, Object object2, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.e = object2;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                IntroHolder.bind$lambda$0(((IntroHolder)this.c), ((DetailInfoAdapter)this.d), ((ArtistDetailDetailInfoFragment)this.e), this.b, view0);
                return;
            }
            case 1: {
                ArtistDetailTemperatureAdapter.onBindViewImpl$lambda$17(((ArtistDetailTemperatureFragment)this.c), ((TOPSTREAMINGSONG)this.d), ((ArtistDetailTemperatureAdapter)this.e), this.b, view0);
                return;
            }
            default: {
                ArtistPickGridAdapter.onBindViewImpl$lambda$0(((ArtistPickGridFragment)this.c), ((ArtistPickGridAdapter)this.d), this.b, ((ArtistPick)this.e), view0);
            }
        }
    }
}

