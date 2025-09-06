package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class j implements View.OnClickListener {
    public final int a;
    public final LockerFragment b;

    public j(LockerFragment lockerFragment0, int v) {
        this.a = v;
        this.b = lockerFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            LockerAdapter.onBindViewHolder$lambda$5(this.b, view0);
            return;
        }
        LockerAdapter.onBindViewHolder$lambda$10(this.b, view0);
    }
}

