package com.iloen.melon.adapters;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.utils.Navigator;
import com.melon.net.res.common.MvInfoBase;

public final class a implements View.OnClickListener {
    public final MvInfoBase a;
    public final MelonTvAdapter b;

    public a(MelonTvAdapter melonTvAdapter0, MvInfoBase mvInfoBase0) {
        this.b = melonTvAdapter0;
        this.a = mvInfoBase0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        Navigator.openMvInfo(this.a.mvId, this.b.getMenuId());
    }
}

