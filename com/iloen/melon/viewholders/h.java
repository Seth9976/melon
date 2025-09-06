package com.iloen.melon.viewholders;

import android.view.View.OnClickListener;
import android.view.View;

public final class h implements View.OnClickListener {
    public final int a;
    public final MvHolderDefaultImpl b;

    public h(MvHolderDefaultImpl mvHolderDefaultImpl0, int v) {
        this.b = mvHolderDefaultImpl0;
        this.a = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MvHolderDefaultImpl mvHolderDefaultImpl0 = this.b;
        if(mvHolderDefaultImpl0.mOnClickListenr != null) {
            mvHolderDefaultImpl0.mOnClickListenr.playMusicVideo(this.a);
        }
    }
}

