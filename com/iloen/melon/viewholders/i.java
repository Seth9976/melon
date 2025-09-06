package com.iloen.melon.viewholders;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.MvInfoBase;

public final class i implements View.OnClickListener {
    public final MvInfoBase a;
    public final String b;
    public final MvHolderDefaultImpl c;

    public i(MvHolderDefaultImpl mvHolderDefaultImpl0, MvInfoBase mvInfoBase0, String s) {
        this.c = mvHolderDefaultImpl0;
        this.a = mvInfoBase0;
        this.b = s;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MvHolderDefaultImpl mvHolderDefaultImpl0 = this.c;
        if(mvHolderDefaultImpl0.mOnClickListenr != null) {
            mvHolderDefaultImpl0.mOnClickListenr.showContextPopup(Playable.from(this.a, this.b, null));
        }
    }
}

