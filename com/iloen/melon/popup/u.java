package com.iloen.melon.popup;

import J8.J0;
import U8.l;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.utils.Navigator;
import kotlin.jvm.internal.q;

public final class u implements View.OnClickListener {
    public final int a;
    public final EqualizerSelectPopup b;

    public u(EqualizerSelectPopup equalizerSelectPopup0, int v) {
        this.a = v;
        this.b = equalizerSelectPopup0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        EqualizerSelectPopup equalizerSelectPopup0 = this.b;
        switch(this.a) {
            case 0: {
                J0 j00 = equalizerSelectPopup0.b;
                if(j00 != null) {
                    ((CheckableImageView)j00.d).toggle();
                    return;
                }
                q.m("binding");
                throw null;
            }
            case 1: {
                l l0 = new l();
                Navigator.INSTANCE.open(l0);
                equalizerSelectPopup0.trackTiaraEventLog(new h(19));
                equalizerSelectPopup0.dismiss();
                return;
            }
            default: {
                equalizerSelectPopup0.dismiss();
            }
        }
    }
}

