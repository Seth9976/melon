package v6;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.checkbox.MaterialCheckBox;

public final class c extends O4.c {
    public final int b;
    public final View c;

    public c(View view0, int v) {
        this.b = v;
        this.c = view0;
        super();
    }

    @Override  // O4.c
    public final void a(Drawable drawable0) {
        switch(this.b) {
            case 0: {
                ((d)this.c).setIndeterminate(false);
                ((d)this.c).b(((d)this.c).b);
                return;
            }
            case 1: {
                d d0 = (d)this.c;
                if(!d0.f) {
                    d0.setVisibility(d0.g);
                }
                return;
            }
            default: {
                ColorStateList colorStateList0 = ((MaterialCheckBox)this.c).o;
                if(colorStateList0 != null) {
                    drawable0.setTintList(colorStateList0);
                }
            }
        }
    }

    @Override  // O4.c
    public void b(Drawable drawable0) {
        if(this.b != 2) {
            return;
        }
        MaterialCheckBox materialCheckBox0 = (MaterialCheckBox)this.c;
        ColorStateList colorStateList0 = materialCheckBox0.o;
        if(colorStateList0 != null) {
            drawable0.setTint(colorStateList0.getColorForState(materialCheckBox0.D, colorStateList0.getDefaultColor()));
        }
    }
}

