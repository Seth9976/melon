package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.MelonTvTodayRes.RESPONSE.MENUPROGINFO.PROGLIST;

public final class m implements View.OnClickListener {
    public final int a;
    public final MelonTvTodayAdapter b;
    public final PROGLIST c;

    public m(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, PROGLIST melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0, int v) {
        this.a = v;
        this.b = melonTvTodayFragment$MelonTvTodayAdapter0;
        this.c = melonTvTodayRes$RESPONSE$MENUPROGINFO$PROGLIST0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MelonTvTodayAdapter.w(this.b, this.c, view0);
                return;
            }
            case 1: {
                MelonTvTodayAdapter.i(this.b, this.c, view0);
                return;
            }
            case 2: {
                MelonTvTodayAdapter.n(this.b, this.c, view0);
                return;
            }
            case 3: {
                MelonTvTodayAdapter.A(this.b, this.c, view0);
                return;
            }
            case 4: {
                MelonTvTodayAdapter.v(this.b, this.c, view0);
                return;
            }
            case 5: {
                MelonTvTodayAdapter.t(this.b, this.c, view0);
                return;
            }
            case 6: {
                MelonTvTodayAdapter.B(this.b, this.c, view0);
                return;
            }
            default: {
                MelonTvTodayAdapter.r(this.b, this.c, view0);
            }
        }
    }
}

