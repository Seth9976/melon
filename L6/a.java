package l6;

import android.graphics.Outline;
import android.graphics.Path;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;
import z6.A;
import z6.B;

public final class a extends ViewOutlineProvider {
    public final int a;
    public final Object b;

    public a(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.ViewOutlineProvider
    public final void getOutline(View view0, Outline outline0) {
        switch(this.a) {
            case 0: {
                d d0 = ((Chip)this.b).e;
                if(d0 != null) {
                    d0.getOutline(outline0);
                    return;
                }
                outline0.setAlpha(0.0f);
                return;
            }
            case 1: {
                A a0 = (A)this.b;
                if(a0.c != null && !a0.d.isEmpty()) {
                    outline0.setRoundRect(((int)a0.d.left), ((int)a0.d.top), ((int)a0.d.right), ((int)a0.d.bottom), a0.g);
                }
                return;
            }
            default: {
                Path path0 = ((B)this.b).e;
                if(!path0.isEmpty()) {
                    outline0.setPath(path0);
                }
            }
        }
    }
}

