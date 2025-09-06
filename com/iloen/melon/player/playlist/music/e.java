package com.iloen.melon.player.playlist.music;

import Lb.a;
import Lb.b;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.melon.ui.I4;
import we.k;

public final class e implements DialogInterface.OnClickListener {
    public final int a;
    public final I4 b;

    public e(I4 i40, int v) {
        this.a = v;
        this.b = i40;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        I4 i40 = this.b;
        if(this.a != 0) {
            k k0 = ((a)i40).c;
            if(k0 != null) {
                k0.invoke(v);
            }
            return;
        }
        ((b)i40).c.invoke(v);
    }
}

