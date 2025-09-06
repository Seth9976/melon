package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class h implements View.OnClickListener {
    public final int a;
    public final LockerFragment b;
    public final LockerAdapter c;
    public final int d;

    public h(LockerFragment lockerFragment0, LockerAdapter lockerFragment$LockerAdapter0, int v, int v1) {
        this.a = v1;
        this.b = lockerFragment0;
        this.c = lockerFragment$LockerAdapter0;
        this.d = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            LockerAdapter.onBindViewHolder$lambda$3(this.b, this.c, this.d, view0);
            return;
        }
        LockerAdapter.onBindViewHolder$lambda$2(this.b, this.c, this.d, view0);
    }
}

