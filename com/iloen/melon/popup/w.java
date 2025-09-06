package com.iloen.melon.popup;

import J8.I2;
import android.os.Handler;
import com.iloen.melon.playback.OemMusicPlayer;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.q;

public final class w implements Runnable {
    public final InstantPlayPopup a;
    public final F b;

    public w(InstantPlayPopup instantPlayPopup0, F f0) {
        this.a = instantPlayPopup0;
        this.b = f0;
    }

    @Override
    public final void run() {
        InstantPlayPopup instantPlayPopup0 = this.a;
        w w0 = instantPlayPopup0.j;
        if(w0 != null) {
            int v = instantPlayPopup0.k == null ? 0 : instantPlayPopup0.k.getCurrentPosition();
            OemMusicPlayer oemMusicPlayer0 = instantPlayPopup0.k;
            if(oemMusicPlayer0 != null) {
                int v1 = oemMusicPlayer0.getDuration() >= 30000 ? 30000 : oemMusicPlayer0.getDuration();
                if(oemMusicPlayer0.getDuration() >= 60000) {
                    v -= 30000;
                }
                int v2 = instantPlayPopup0.requireContext().getResources().getDimensionPixelSize(0x7F070124);  // dimen:instant_play_popup_width
                I2 i20 = instantPlayPopup0.B;
                q.d(i20);
                i20.h.getLayoutParams().width = (int)(((float)v) / ((float)v1) * ((float)v2));
                I2 i21 = instantPlayPopup0.B;
                q.d(i21);
                i21.h.requestLayout();
            }
            int v3 = this.b.a;
            this.b.a = v3 + 1;
            if(v3 > 30 && v >= 30000) {
                instantPlayPopup0.dismissAllowingStateLoss();
                return;
            }
            Handler handler0 = instantPlayPopup0.i;
            if(handler0 != null) {
                handler0.postDelayed(w0, 500L);
            }
        }
    }
}

