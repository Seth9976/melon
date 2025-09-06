package com.iloen.melon.popup;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.MelonEditText;

public final class t implements View.OnClickListener {
    public final int a;
    public final EqualizerCancelConfirmPopup b;

    public t(EqualizerCancelConfirmPopup equalizerCancelConfirmPopup0, int v) {
        this.a = v;
        this.b = equalizerCancelConfirmPopup0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        EqualizerCancelConfirmPopup equalizerCancelConfirmPopup0 = this.b;
        if(this.a != 0) {
            equalizerCancelConfirmPopup0.dismiss();
            return;
        }
        MelonEditText melonEditText0 = equalizerCancelConfirmPopup0.a;
        if(melonEditText0 != null) {
            melonEditText0.setText("");
        }
    }
}

