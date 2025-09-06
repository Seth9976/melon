package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.MvInfoBase;

public final class n implements View.OnClickListener {
    public final int a;
    public final MelonTvTodayAdapter b;
    public final MvInfoBase c;

    public n(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MvInfoBase mvInfoBase0, int v) {
        this.a = v;
        this.b = melonTvTodayFragment$MelonTvTodayAdapter0;
        this.c = mvInfoBase0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MelonTvTodayAdapter.f(this.b, this.c, view0);
                return;
            }
            case 1: {
                MelonTvTodayAdapter.y(this.b, this.c, view0);
                return;
            }
            case 2: {
                MelonTvTodayAdapter.u(this.b, this.c, view0);
                return;
            }
            case 3: {
                MelonTvTodayAdapter.c(this.b, this.c, view0);
                return;
            }
            case 4: {
                MelonTvTodayAdapter.s(this.b, this.c, view0);
                return;
            }
            case 5: {
                MelonTvTodayAdapter.x(this.b, this.c, view0);
                return;
            }
            case 6: {
                MelonTvTodayAdapter.p(this.b, this.c, view0);
                return;
            }
            default: {
                MelonTvTodayAdapter.o(this.b, this.c, view0);
            }
        }
    }
}

