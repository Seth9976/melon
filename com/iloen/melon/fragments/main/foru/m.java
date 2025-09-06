package com.iloen.melon.fragments.main.foru;

import android.view.View.OnClickListener;
import android.view.View;

public final class m implements View.OnClickListener {
    public final boolean a;

    public m(boolean z) {
        this.a = z;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        ForUMixMakerMainFragment.k0(view0, this.a);
    }
}

