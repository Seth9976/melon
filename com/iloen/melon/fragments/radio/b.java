package com.iloen.melon.fragments.radio;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.StationHomeRes.RESPONSE.PROGRAMLIST;

public final class b implements View.OnClickListener {
    public final int a;
    public final StationFragment b;
    public final PROGRAMLIST c;
    public final StationAdapter d;
    public final int e;

    public b(StationFragment stationFragment0, PROGRAMLIST stationHomeRes$RESPONSE$PROGRAMLIST0, StationAdapter stationFragment$StationAdapter0, int v) {
        this.a = 1;
        super();
        this.b = stationFragment0;
        this.c = stationHomeRes$RESPONSE$PROGRAMLIST0;
        this.d = stationFragment$StationAdapter0;
        this.e = v;
    }

    public b(PROGRAMLIST stationHomeRes$RESPONSE$PROGRAMLIST0, StationAdapter stationFragment$StationAdapter0, StationFragment stationFragment0, int v) {
        this.a = 0;
        super();
        this.c = stationHomeRes$RESPONSE$PROGRAMLIST0;
        this.d = stationFragment$StationAdapter0;
        this.b = stationFragment0;
        this.e = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            StationAdapter.a(this.b, this.c, this.d, this.e, view0);
            return;
        }
        StationAdapter.b(this.b, this.c, this.d, this.e, view0);
    }
}

