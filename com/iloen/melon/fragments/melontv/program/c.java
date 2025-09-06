package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.playback.Playable;

public final class c implements View.OnLongClickListener {
    public final TvProgramHomeFragment a;
    public final Playable b;

    public c(TvProgramHomeFragment tvProgramHomeFragment0, Playable playable0) {
        this.a = tvProgramHomeFragment0;
        this.b = playable0;
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return TvProgramHomeAdapter.m(this.a, this.b, view0);
    }
}

