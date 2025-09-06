package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;

public final class i1 implements View.OnClickListener {
    public final ToReceiverView a;

    public i1(ToReceiverView toReceiverView0) {
        this.a = toReceiverView0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        k1 k10 = this.a.d;
        if(k10 != null) {
            k10.onDeleteReceiver(view0);
        }
    }
}

