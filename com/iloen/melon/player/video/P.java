package com.iloen.melon.player.video;

import J8.w3;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class p implements DialogInterface.OnDismissListener {
    public final VideoChatFragment a;

    public p(VideoChatFragment videoChatFragment0) {
        this.a = videoChatFragment0;
    }

    @Override  // android.content.DialogInterface$OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface0) {
        w3 w30 = this.a.f;
        if(w30 != null) {
            ConstraintLayout constraintLayout0 = w30.h;
            if(constraintLayout0 != null) {
                constraintLayout0.setVisibility(0);
            }
        }
    }
}

