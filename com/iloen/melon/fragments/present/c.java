package com.iloen.melon.fragments.present;

import android.view.View.OnClickListener;
import android.view.View;

public final class c implements View.OnClickListener {
    public final int a;
    public final PresentSendFragment b;

    public c(PresentSendFragment presentSendFragment0, int v) {
        this.a = v;
        this.b = presentSendFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                PresentSendFragment.createListHeader$lambda$15(this.b, view0);
                return;
            }
            case 1: {
                PresentSendFragment.createListHeader$lambda$16(this.b, view0);
                return;
            }
            case 2: {
                PresentSendFragment.createListHeader$lambda$17(this.b, view0);
                return;
            }
            case 3: {
                PresentSendFragment.createListHeader$lambda$18(this.b, view0);
                return;
            }
            default: {
                PresentSendFragment.createListHeader$lambda$19(this.b, view0);
            }
        }
    }
}

