package com.iloen.melon.fragments.mymusic.dna;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.MusicDnaMonthlyLogDetailRes.GNRTOP.LIKEGNRTOP3;

public final class b implements View.OnClickListener {
    public final int a;
    public final MonthlyDnaLogAdapter b;
    public final LIKEGNRTOP3 c;
    public final Bundle d;

    public b(MonthlyDnaLogAdapter monthlyDnaLogAdapter0, LIKEGNRTOP3 musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30, Bundle bundle0, int v) {
        this.a = v;
        this.b = monthlyDnaLogAdapter0;
        this.c = musicDnaMonthlyLogDetailRes$GNRTOP$LIKEGNRTOP30;
        this.d = bundle0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MonthlyDnaLogAdapter.onBindViewImpl$lambda$8$lambda$7(this.b, this.c, this.d, view0);
            return;
        }
        MonthlyDnaLogAdapter.onBindViewImpl$lambda$8$lambda$6(this.b, this.c, this.d, view0);
    }
}

