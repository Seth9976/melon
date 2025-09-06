package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;

public final class w implements View.OnClickListener {
    public final int a;
    public final MixPlaylistDetailFragment b;
    public final LayoutParams c;

    public w(LayoutParams constraintLayout$LayoutParams0, MixPlaylistDetailFragment mixPlaylistDetailFragment0) {
        this.a = 0;
        super();
        this.c = constraintLayout$LayoutParams0;
        this.b = mixPlaylistDetailFragment0;
    }

    public w(MixPlaylistDetailFragment mixPlaylistDetailFragment0, LayoutParams constraintLayout$LayoutParams0) {
        this.a = 1;
        super();
        this.b = mixPlaylistDetailFragment0;
        this.c = constraintLayout$LayoutParams0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MixPlaylistDetailFragment.F0(this.c, this.b, view0);
            return;
        }
        MixPlaylistDetailFragment.setDescText$lambda$15(this.c, this.b, view0);
    }
}

