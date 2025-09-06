package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.ProgramBase.Cast;

public final class h0 implements View.OnClickListener {
    public final int a;
    public final String b;
    public final ProfileDetailStationFragment c;
    public final Cast d;

    public h0(String s, ProfileDetailStationFragment profileDetailStationFragment0, Cast programBase$Cast0, int v) {
        this.a = v;
        this.b = s;
        this.c = profileDetailStationFragment0;
        this.d = programBase$Cast0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            CastProgramAdapter.onBindViewImpl$lambda$8$lambda$7(this.b, this.c, this.d, view0);
            return;
        }
        CastProgramAdapter.onBindViewImpl$lambda$3(this.b, this.c, this.d, view0);
    }
}

