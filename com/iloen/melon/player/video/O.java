package com.iloen.melon.player.video;

import J8.w3;
import android.content.DialogInterface.OnShowListener;
import android.content.DialogInterface;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class o implements DialogInterface.OnShowListener {
    public final VideoChatFragment a;

    public o(VideoChatFragment videoChatFragment0) {
        this.a = videoChatFragment0;
    }

    @Override  // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface0) {
        w3 w30 = this.a.f;
        if(w30 != null) {
            ConstraintLayout constraintLayout0 = w30.h;
            if(constraintLayout0 != null) {
                constraintLayout0.setVisibility(4);
            }
        }
    }
}

