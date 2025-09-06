package com.iloen.melon.fragments.melontv;

import android.view.View.OnClickListener;
import android.view.View;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.net.v6x.response.TvProgramSimpleListRes.Response.Program;
import com.melon.net.res.common.MvInfoBase;

public final class h implements View.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public h(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                ProgramAdapter.onBindViewImpl$lambda$2$lambda$1(((MelonTvProgramSelectFragment)this.b), ((O0)this.c), ((Program)this.d), view0);
                return;
            }
            case 1: {
                MelonTvTodayAdapter.e(((MelonTvTodayAdapter)this.b), ((ServerDataWrapper)this.c), ((MvInfoBase)this.d), view0);
                return;
            }
            default: {
                MelonTvTodayAdapter.onBindViewImpl$lambda$59$lambda$58$lambda$57(((MvInfoBase)this.b), ((MelonTvTodayAdapter)this.c), ((MelonTvTodayFragment)this.d), view0);
            }
        }
    }
}

