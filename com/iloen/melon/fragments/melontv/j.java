package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v4x.response.MelonTvLikedProgramRes.RESPONSE.CONTENTSLIST;

public final class j implements View.OnClickListener {
    public final int a;
    public final Object b;

    public j(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MelonTvTodayAdapter.g(((MelonTvTodayAdapter)this.b), view0);
                return;
            }
            case 1: {
                MelonTvTodayAdapter.onBindViewImpl$lambda$55$lambda$54$lambda$53(((MelonTvTodayAdapter)this.b), view0);
                return;
            }
            case 2: {
                MelonTvTodayAdapter.C(((MelonTvTodayAdapter)this.b), view0);
                return;
            }
            case 3: {
                MelonTvTodayAdapter.m(((MelonTvTodayAdapter)this.b), view0);
                return;
            }
            default: {
                MelonTvLikedAdapter.lambda$onBindViewImpl$0(((CONTENTSLIST)this.b), view0);
            }
        }
    }
}

