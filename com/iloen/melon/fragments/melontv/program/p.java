package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.MetaContentBaseFragment;

public final class p implements View.OnClickListener {
    public final int a;
    public final MetaContentBaseFragment b;

    public p(MetaContentBaseFragment metaContentBaseFragment0, int v) {
        this.a = v;
        this.b = metaContentBaseFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TvProgramMoreSongFragment.onViewCreated$lambda$2(((TvProgramMoreSongFragment)this.b), view0);
                return;
            }
            case 1: {
                TvProgramMoreSongFragment.onViewCreated$lambda$4(((TvProgramMoreSongFragment)this.b), view0);
                return;
            }
            case 2: {
                TvProgramMoreSongFragment.onViewCreated$lambda$6(((TvProgramMoreSongFragment)this.b), view0);
                return;
            }
            default: {
                TvProgramHomeFragment.initHeaderContainer$lambda$10$lambda$9$lambda$7(((TvProgramHomeFragment)this.b), view0);
            }
        }
    }
}

