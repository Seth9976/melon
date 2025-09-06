package com.iloen.melon.fragments.melontv.program;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.fragments.FetcherBaseFragment;

public final class e implements View.OnClickListener {
    public final int a;
    public final FetcherBaseFragment b;
    public final Object c;
    public final Object d;

    public e(FetcherBaseFragment fetcherBaseFragment0, Object object0, Object object1, int v) {
        this.a = v;
        this.b = fetcherBaseFragment0;
        this.c = object0;
        this.d = object1;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            TvProgramMoreVideoFragment.onViewCreated$lambda$2(((TvProgramMoreVideoFragment)this.b), ((View)this.c), ((View)this.d), view0);
            return;
        }
        TvProgramHomeAdapter.d(((TvProgramHomeFragment)this.b), ((TvProgramHomeAdapter)this.c), ((String)this.d), view0);
    }
}

