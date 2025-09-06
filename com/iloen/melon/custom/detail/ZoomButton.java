package com.iloen.melon.custom.detail;

import B8.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import androidx.media3.session.a0;
import com.iloen.melon.custom.AlphaControlButton;
import com.iloen.melon.fragments.detail.viewholder.LyricHolder;

public class ZoomButton extends AlphaControlButton implements View.OnClickListener {
    public final float i;
    public final float j;
    public int k;
    public b l;

    public ZoomButton(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.i = 16.0f;
        this.j = 18.0f;
        this.k = 0;
        super.setOnClickListener(this);
        this.h();
    }

    public final void h() {
        switch(this.k) {
            case 0: {
                this.setBackgroundResource(0x7F0802B0);  // drawable:btn_zoom_x_1
                return;
            }
            case 1: {
                this.setBackgroundResource(0x7F0802B1);  // drawable:btn_zoom_x_2
            }
        }
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        int v = (this.k + 1) % 2;
        this.k = v;
        b b0 = this.l;
        if(b0 != null) {
            LyricHolder.d(((LyricHolder)((a0)b0).b), v);
        }
        this.h();
    }

    public void setOnZoomLevelChangedListener(b b0) {
        this.l = b0;
    }

    public void setZoomLevel(int v) {
        this.k = v;
        this.h();
    }
}

