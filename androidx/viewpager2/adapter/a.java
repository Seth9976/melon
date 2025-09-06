package androidx.viewpager2.adapter;

import U4.F;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;

public final class a extends F {
    public final I h;
    public final FrameLayout i;
    public final h j;

    public a(h h0, I i0, FrameLayout frameLayout0) {
        this.j = h0;
        this.h = i0;
        this.i = frameLayout0;
    }

    @Override  // U4.F
    public final void P(l0 l00, I i0, View view0) {
        if(i0 == this.h) {
            l00.p0(this);
            this.j.addViewToContainer(view0, this.i);
        }
    }
}

