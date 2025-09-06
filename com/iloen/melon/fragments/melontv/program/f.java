package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.BUTTONINFO;
import com.iloen.melon.net.v6x.response.ProgramHomeRes.RESPONSE.NEWMVINFO;

public final class f implements View.OnClickListener {
    public final int a;
    public final TvProgramHomeAdapter b;
    public final Object c;
    public final TvProgramHomeFragment d;

    public f(TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0, NEWMVINFO programHomeRes$RESPONSE$NEWMVINFO0, TvProgramHomeFragment tvProgramHomeFragment0) {
        this.a = 1;
        super();
        this.b = tvProgramHomeFragment$TvProgramHomeAdapter0;
        this.c = programHomeRes$RESPONSE$NEWMVINFO0;
        this.d = tvProgramHomeFragment0;
    }

    public f(TvProgramHomeFragment tvProgramHomeFragment0, BUTTONINFO programHomeRes$RESPONSE$BUTTONINFO0, TvProgramHomeAdapter tvProgramHomeFragment$TvProgramHomeAdapter0) {
        this.a = 0;
        super();
        this.d = tvProgramHomeFragment0;
        this.c = programHomeRes$RESPONSE$BUTTONINFO0;
        this.b = tvProgramHomeFragment$TvProgramHomeAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TvProgramHomeAdapter.h(this.b, this.c, this.d, view0);
            return;
        }
        TvProgramHomeAdapter.g(this.b, this.c, this.d, view0);
    }
}

