package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.H;

public final class l implements View.OnClickListener {
    public final MelonTvTodayAdapter a;
    public final H b;
    public final H c;
    public final int d;
    public final ArrayList e;

    public l(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, H h0, H h1, int v, ArrayList arrayList0) {
        this.a = melonTvTodayFragment$MelonTvTodayAdapter0;
        this.b = h0;
        this.c = h1;
        this.d = v;
        this.e = arrayList0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MelonTvTodayAdapter.a(this.a, this.b, this.c, this.d, this.e, view0);
    }
}

