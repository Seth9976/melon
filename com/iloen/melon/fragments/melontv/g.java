package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.TvProgramSimpleListRes.Response.Program;

public final class g implements View.OnClickListener {
    public final int a;
    public final MelonTvProgramSelectFragment b;
    public final Program c;

    public g(MelonTvProgramSelectFragment melonTvProgramSelectFragment0, Program tvProgramSimpleListRes$Response$Program0, int v) {
        this.a = v;
        this.b = melonTvProgramSelectFragment0;
        this.c = tvProgramSimpleListRes$Response$Program0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ProgramAdapter.onBindViewImpl$lambda$4$lambda$3(this.b, this.c, view0);
            return;
        }
        ProgramAdapter.onBindViewImpl$lambda$2$lambda$0(this.b, this.c, view0);
    }
}

