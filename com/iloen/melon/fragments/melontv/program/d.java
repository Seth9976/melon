package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.MVINFO.MVLIST;
import com.melon.net.res.common.AlbumInfoBase;

public final class d implements View.OnClickListener {
    public final int a;
    public final TvProgramHomeFragment b;
    public final Object c;
    public final TvProgramHomeAdapter d;
    public final int e;

    public d(TvProgramHomeFragment tvProgramHomeFragment0, AlbumInfoBase albumInfoBase0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v, int v1) {
        this.a = v1;
        this.b = tvProgramHomeFragment0;
        this.c = albumInfoBase0;
        this.d = tvProgramHomeFragment$TvProgramHomeAdapter0;
        this.e = v;
        super();
    }

    public d(MVLIST programHomeRes$RESPONSE$MVINFO$MVLIST0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, TvProgramHomeFragment tvProgramHomeFragment0, int v) {
        this.a = 2;
        super();
        this.c = programHomeRes$RESPONSE$MVINFO$MVLIST0;
        this.d = tvProgramHomeFragment$TvProgramHomeAdapter0;
        this.b = tvProgramHomeFragment0;
        this.e = v;
    }

    public d(AlbumInfoBase albumInfoBase0, TvProgramHomeFragment tvProgramHomeFragment0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, int v) {
        this.a = 0;
        super();
        this.c = albumInfoBase0;
        this.b = tvProgramHomeFragment0;
        this.d = tvProgramHomeFragment$TvProgramHomeAdapter0;
        this.e = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                TvProgramHomeAdapter.a(this.b, this.c, this.d, this.e, view0);
                return;
            }
            case 1: {
                TvProgramHomeAdapter.c(this.b, this.c, this.d, this.e, view0);
                return;
            }
            case 2: {
                TvProgramHomeAdapter.k(this.b, this.c, this.d, this.e, view0);
                return;
            }
            case 3: {
                TvProgramHomeAdapter.i(this.b, this.c, this.d, this.e, view0);
                return;
            }
            default: {
                TvProgramHomeAdapter.j(this.b, this.c, this.d, this.e, view0);
            }
        }
    }
}

