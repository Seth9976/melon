package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;

public final class j1 implements View.OnClickListener {
    public final Receiver a;
    public final ToReceiverView b;

    public j1(ToReceiverView toReceiverView0, Receiver toReceiverView$Receiver0) {
        this.b = toReceiverView0;
        this.a = toReceiverView$Receiver0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        k1 k10 = this.b.d;
        if(k10 != null) {
            k10.onContentReceiver(view0, this.a);
        }
    }
}

