package com.iloen.melon.adapters;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.MvInfoBase.REPARTIST;
import com.melon.net.res.common.MvInfoBase;

public final class b implements View.OnClickListener {
    public final MvInfoBase a;
    public final MelonTvAdapter b;

    public b(MelonTvAdapter melonTvAdapter0, MvInfoBase mvInfoBase0) {
        this.b = melonTvAdapter0;
        this.a = mvInfoBase0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MelonTvAdapter melonTvAdapter0 = this.b;
        String s = melonTvAdapter0.getMenuId();
        MvInfoBase mvInfoBase0 = this.a;
        Playable playable0 = Playable.from(mvInfoBase0, s, null);
        REPARTIST mvInfoBase$REPARTIST0 = mvInfoBase0.repArtist;
        if(mvInfoBase$REPARTIST0 != null && mvInfoBase$REPARTIST0.isBrandDjs) {
            playable0.setArtist(mvInfoBase$REPARTIST0.getArtistId(), mvInfoBase0.repArtist.getArtistName());
            playable0.setBrandDj(mvInfoBase0.repArtist.isBrandDjs);
        }
        melonTvAdapter0.mInfoBtnClick.a(playable0);
    }
}

