package l6;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.google.android.material.chip.Chip;
import d2.c;
import d2.d;
import j2.a;
import java.util.ArrayList;

public final class b extends a {
    public final Chip n;

    public b(Chip chip0, Chip chip1) {
        this.n = chip0;
        super(chip1);
    }

    // 去混淆评级： 低(20)
    @Override  // j2.a
    public final int e(float f, float f1) {
        return !this.n.d() || !this.n.getCloseIconTouchBounds().contains(f, f1) ? 0 : 1;
    }

    @Override  // j2.a
    public final void f(ArrayList arrayList0) {
        arrayList0.add(0);
        if(this.n.d() && (this.n.e != null && this.n.e.h0 && this.n.h != null)) {
            arrayList0.add(1);
        }
    }

    @Override  // j2.a
    public final boolean j(int v, int v1, Bundle bundle0) {
        boolean z = false;
        if(v1 == 16) {
            Chip chip0 = this.n;
            if(v == 0) {
                return chip0.performClick();
            }
            if(v == 1) {
                chip0.playSoundEffect(0);
                View.OnClickListener view$OnClickListener0 = chip0.h;
                if(view$OnClickListener0 != null) {
                    view$OnClickListener0.onClick(chip0);
                    z = true;
                }
                if(chip0.E) {
                    chip0.D.o(1, 1);
                }
            }
        }
        return z;
    }

    @Override  // j2.a
    public final void k(d d0) {
        d0.a.setCheckable(this.n.e != null && this.n.e.n0);
        d0.a.setClickable(this.n.isClickable());
        d0.l(this.n.getAccessibilityClassName());
        d0.q(this.n.getText());
    }

    @Override  // j2.a
    public final void l(int v, d d0) {
        CharSequence charSequence0 = "";
        if(v == 1) {
            Chip chip0 = this.n;
            CharSequence charSequence1 = chip0.getCloseIconContentDescription();
            if(charSequence1 == null) {
                CharSequence charSequence2 = chip0.getText();
                Context context0 = chip0.getContext();
                if(!TextUtils.isEmpty(charSequence2)) {
                    charSequence0 = charSequence2;
                }
                d0.o(context0.getString(0x7F1306E2, new Object[]{charSequence0}).trim());  // string:mtrl_chip_close_icon_content_description "Remove %1$s"
            }
            else {
                d0.o(charSequence1);
            }
            d0.j(chip0.getCloseIconTouchBoundsInt());
            d0.b(c.g);
            boolean z = chip0.isEnabled();
            d0.a.setEnabled(z);
            return;
        }
        d0.o("");
        d0.j(Chip.N);
    }

    @Override  // j2.a
    public final void m(int v, boolean z) {
        if(v == 1) {
            this.n.n = z;
            this.n.refreshDrawableState();
        }
    }
}

