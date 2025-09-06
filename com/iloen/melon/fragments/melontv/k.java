package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.MENUPROGINFO.PROGLIST.MV;

public final class k implements View.OnClickListener {
    public final int a;
    public final MelonTvTodayAdapter b;
    public final MV c;

    public k(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, MV melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0, int v) {
        this.a = v;
        this.b = melonTvTodayFragment$MelonTvTodayAdapter0;
        this.c = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST$MV0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MelonTvTodayAdapter.j(this.b, this.c, view0);
                return;
            }
            case 1: {
                MelonTvTodayAdapter.h(this.b, this.c, view0);
                return;
            }
            case 2: {
                MelonTvTodayAdapter.z(this.b, this.c, view0);
                return;
            }
            case 3: {
                MelonTvTodayAdapter.k(this.b, this.c, view0);
                return;
            }
            case 4: {
                MelonTvTodayAdapter.d(this.b, this.c, view0);
                return;
            }
            case 5: {
                MelonTvTodayAdapter.q(this.b, this.c, view0);
                return;
            }
            case 6: {
                MelonTvTodayAdapter.D(this.b, this.c, view0);
                return;
            }
            default: {
                MelonTvTodayAdapter.E(this.b, this.c, view0);
            }
        }
    }
}

