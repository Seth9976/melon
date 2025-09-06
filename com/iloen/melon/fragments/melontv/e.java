package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.adapters.common.p;
import com.melon.net.res.common.MvInfoBase;

public final class e implements View.OnClickListener {
    public final int a;
    public final int b;
    public final p c;
    public final Object d;

    public e(MelonTvNewAdapter melonTvNewFragment$MelonTvNewAdapter0, int v, MvInfoBase mvInfoBase0) {
        this.a = 0;
        super();
        this.c = melonTvNewFragment$MelonTvNewAdapter0;
        this.b = v;
        this.d = mvInfoBase0;
    }

    public e(MelonTvTodayAdapter melonTvTodayFragment$MelonTvTodayAdapter0, ViewPagerAdapter melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0, int v) {
        this.a = 1;
        super();
        this.c = melonTvTodayFragment$MelonTvTodayAdapter0;
        this.d = melonTvTodayFragment$MelonTvTodayAdapter$ViewPagerAdapter0;
        this.b = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ViewPagerAdapter.a(((MelonTvTodayAdapter)this.c), ((ViewPagerAdapter)this.d), this.b, view0);
            return;
        }
        MelonTvNewAdapter.updateItemView$lambda$0(((MelonTvNewAdapter)this.c), this.b, ((MvInfoBase)this.d), view0);
    }
}

