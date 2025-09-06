package com.iloen.melon.fragments.mymusic.dna;

import androidx.lifecycle.M;
import java.util.ArrayList;
import v8.i;

public final class c implements M {
    public final int a;
    public final MonthlyDnaLogFragment b;

    public c(MonthlyDnaLogFragment monthlyDnaLogFragment0, int v) {
        this.a = v;
        this.b = monthlyDnaLogFragment0;
        super();
    }

    @Override  // androidx.lifecycle.M
    public final void onChanged(Object object0) {
        if(this.a != 0) {
            MonthlyDnaLogFragment.onViewCreated$lambda$4(this.b, ((ArrayList)object0));
            return;
        }
        MonthlyDnaLogFragment.onViewCreated$lambda$3(this.b, ((i)object0));
    }
}

