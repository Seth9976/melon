package com.iloen.melon.fragments.artistchannel;

import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.WEEKAWARDLIST;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RelatedArtistsInfoBase;
import com.iloen.melon.net.v6x.response.ArtistFanFanListRes.RESPONSE.RISINGFANLIST;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.MEMORIALLIST;
import com.iloen.melon.net.v6x.response.ArtistTemperatureGetMemorialCardRelayRes.RESPONSE.MEMORIALCARDRELAYLIST;

public final class d implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public d(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        this.d = object2;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                AlbumAdapter.onBindViewImpl$lambda$3(((ArtistDetailContentsAlbumFragment)this.c), ((TextView)this.b), ((AlbumAdapter)this.d), view0);
                return;
            }
            case 1: {
                MagazineAdapter.onBindViewImpl$lambda$1(((ArtistDetailContentsMagazineFragment)this.c), ((TextView)this.b), ((MagazineAdapter)this.d), view0);
                return;
            }
            case 2: {
                PhotoAdapter.onBindViewImpl$lambda$2(((ArtistDetailContentsPhotoFragment)this.c), ((TextView)this.b), ((PhotoAdapter)this.d), view0);
                return;
            }
            case 3: {
                VideoAdapter.onBindViewImpl$lambda$3(((ArtistDetailContentsVideoFragment)this.c), ((TextView)this.b), ((VideoAdapter)this.d), view0);
                return;
            }
            case 4: {
                RelatedArtistHolder.bind$lambda$6(((RelatedArtistHolder)this.c), ((ArtistDetailDetailInfoFragment)this.b), ((RelatedArtistsInfoBase)this.d), view0);
                return;
            }
            case 5: {
                WeekAwardListAdapter.onBindViewHolder$lambda$0(((ArtistDetailDetailInfoFragment)this.c), ((WEEKAWARDLIST)this.b), ((DetailInfoAdapter)this.d), view0);
                return;
            }
            case 6: {
                MemorialCardRelayAdapter.onBindViewHolder$lambda$2$lambda$1(((FanListAdapter)this.c), ((MEMORIALCARDRELAYLIST)this.b), ((ArtistDetailFanListFragment)this.d), view0);
                return;
            }
            case 7: {
                RisingFanListAdapter.onBindViewHolder$lambda$2$lambda$1(((FanListAdapter)this.c), ((RISINGFANLIST)this.b), ((ArtistDetailFanListFragment)this.d), view0);
                return;
            }
            default: {
                MemorialGridAdapter.onBindViewImpl$lambda$2$lambda$1(((ArtistDetailTemperatureFragment)this.c), ((MEMORIALLIST)this.b), ((MemorialGridAdapter)this.d), view0);
            }
        }
    }
}

