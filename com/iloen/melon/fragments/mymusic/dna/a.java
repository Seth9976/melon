package com.iloen.melon.fragments.mymusic.dna;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import com.melon.net.res.common.SongInfoBase;

public final class a implements View.OnClickListener {
    public final int a;
    public final MonthlyDnaLogAdapter b;
    public final SongInfoBase c;
    public final Bundle d;

    public a(MonthlyDnaLogAdapter dnaSummaryViewHolder$MonthlyDnaLogAdapter0, SongInfoBase songInfoBase0, Bundle bundle0, int v) {
        this.a = v;
        this.b = dnaSummaryViewHolder$MonthlyDnaLogAdapter0;
        this.c = songInfoBase0;
        this.d = bundle0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MonthlyDnaLogAdapter.onBindViewHolder$lambda$1(this.b, this.c, this.d, view0);
            return;
        }
        MonthlyDnaLogAdapter.onBindViewHolder$lambda$0(this.b, this.c, this.d, view0);
    }
}

