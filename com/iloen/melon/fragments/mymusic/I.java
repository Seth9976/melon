package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class i implements View.OnClickListener {
    public final int a;

    public i(int v) {
        this.a = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                LockerAdapter.onBindViewHolder$lambda$8(view0);
                return;
            }
            case 1: {
                LockerAdapter.onBindViewHolder$lambda$9(view0);
                return;
            }
            case 2: {
                LockerAdapter.onBindViewHolder$lambda$11(view0);
                return;
            }
            case 3: {
                LockerAdapter.onBindViewHolder$lambda$12(view0);
                return;
            }
            case 4: {
                LockerAdapter.onBindViewHolder$lambda$13(view0);
                return;
            }
            case 5: {
                LockerAdapter.onBindViewHolder$lambda$14(view0);
                return;
            }
            case 6: {
                LockerAdapter.onBindViewHolder$lambda$4(view0);
                return;
            }
            case 7: {
                LockerAdapter.onBindViewHolder$lambda$6(view0);
                return;
            }
            default: {
                LockerAdapter.onBindViewHolder$lambda$7(view0);
            }
        }
    }
}

