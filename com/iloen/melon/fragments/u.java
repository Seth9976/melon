package com.iloen.melon.fragments;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.CastProgramDetailRes.Response.Banner;

public final class u implements View.OnClickListener {
    public final int a;
    public final Object b;

    public u(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ProgramDetailFragment.updateUI$lambda$12$lambda$11(((Banner)this.b), view0);
            return;
        }
        MelonBottomSheetBaseFragment.onCreateView$lambda$1(((MelonBottomSheetBaseFragment)this.b), view0);
    }
}

