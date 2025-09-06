package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.PROGINFO;
import java.util.List;

public final class b implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;

    public b(int v, Object object0, Object object1) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TvProgramHomeAdapter.e(((NoticeViewHolder)this.b), this.c, view0);
                return;
            }
            case 1: {
                FilterViewHolder._init_$lambda$2(((TvProgramMoreAlbumFragment)this.b), ((FilterViewHolder)this.c), view0);
                return;
            }
            case 2: {
                TvProgramHomeFragment.initHeaderContainer$lambda$10$lambda$9$lambda$8(((TvProgramHomeFragment)this.b), ((PROGINFO)this.c), view0);
                return;
            }
            default: {
                TvProgramMoreVideoFragment.onViewCreated$lambda$5(((TvProgramMoreVideoFragment)this.b), ((List)this.c), view0);
            }
        }
    }
}

