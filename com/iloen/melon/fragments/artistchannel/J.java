package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RelatedArtistsInfoBase;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.ARTISTPICK;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.MEMORIALLIST;
import com.melon.net.res.common.AlbumInfoBase;
import java.util.List;

public final class j implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public j(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TopicAdapter.onBindViewImpl$lambda$1(((ArtistDetailContentsTopicFragment)this.b), ((TextView)this.c), view0);
                return;
            }
            case 1: {
                DetailInfoHolder.bind$lambda$0(((RESPONSE)this.b), ((ArtistDetailDetailInfoFragment)this.c), view0);
                return;
            }
            case 2: {
                RelatedArtistHolder.bind$lambda$0(((ArtistDetailDetailInfoFragment)this.b), ((RelatedArtistsInfoBase)this.c), view0);
                return;
            }
            case 3: {
                ArtistDetailContentsSongFragment.makeAllSelectAndOrderButton$lambda$8(((ArtistDetailContentsSongFragment)this.b), ((List)this.c), view0);
                return;
            }
            case 4: {
                ArtistDetailHomeFragment.drawArtistPickLayout$lambda$20(((ARTISTPICK)this.b), ((ArtistDetailHomeFragment)this.c), view0);
                return;
            }
            case 5: {
                ArtistDetailMemorialCardFragment.updateUi$lambda$16$lambda$15(((ArtistDetailMemorialCardFragment)this.b), ((MEMORIALLIST)this.c), view0);
                return;
            }
            case 6: {
                ArtistPickItemFragment.onViewCreated$lambda$7$lambda$2$lambda$1(((ArtistPickItemFragment)this.b), ((AlbumInfoBase)this.c), view0);
                return;
            }
            default: {
                ArtistPickItemFragment.onViewCreated$lambda$7$lambda$5(((com.iloen.melon.net.v6x.response.ArtistPickRes.RESPONSE.ARTISTPICK)this.b), ((ArtistPickItemFragment)this.c), view0);
            }
        }
    }
}

