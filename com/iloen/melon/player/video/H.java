package com.iloen.melon.player.video;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.iloen.melon.popup.MelonTextPopup;

public final class h implements DialogInterface.OnClickListener {
    public final int a;
    public final MelonTextPopup b;

    public h(MelonTextPopup melonTextPopup0, int v) {
        this.a = v;
        this.b = melonTextPopup0;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        MelonTextPopup melonTextPopup0 = this.b;
        if(this.a != 0) {
            melonTextPopup0.dismiss();
            return;
        }
        melonTextPopup0.dismiss();
    }
}

