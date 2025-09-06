package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.ProgramBase.Cast;

public final class g0 implements View.OnClickListener {
    public final int a;
    public final String b;
    public final CastProgramAdapter c;
    public final ProfileDetailStationFragment d;
    public final Cast e;

    public g0(String s, CastProgramAdapter profileDetailStationFragment$CastProgramAdapter0, ProfileDetailStationFragment profileDetailStationFragment0, Cast programBase$Cast0, int v) {
        this.a = v;
        this.b = s;
        this.c = profileDetailStationFragment$CastProgramAdapter0;
        this.d = profileDetailStationFragment0;
        this.e = programBase$Cast0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            CastProgramAdapter.onBindViewImpl$lambda$8$lambda$6(this.b, this.c, this.d, this.e, view0);
            return;
        }
        CastProgramAdapter.onBindViewImpl$lambda$2(this.b, this.c, this.d, this.e, view0);
    }
}

