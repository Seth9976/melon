package e6;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import r6.a;

public final class e extends Property {
    public final int a;
    public final Object b;

    public e() {
        this.a = 0;
        super(Matrix.class, "imageMatrixProperty");
        this.b = new Matrix();
    }

    public e(a a0) {
        this.a = 1;
        this.b = a0;
        super(Float.class, "LABEL_OPACITY_PROPERTY");
    }

    @Override  // android.util.Property
    public final Object get(Object object0) {
        if(this.a != 0) {
            int v = Color.alpha(((ExtendedFloatingActionButton)object0).e0.getColorForState(((ExtendedFloatingActionButton)object0).getDrawableState(), ((a)this.b).b.e0.getDefaultColor()));
            return e6.a.a(0.0f, 1.0f, ((float)Color.alpha(((ExtendedFloatingActionButton)object0).getCurrentTextColor())) / 255.0f / ((float)v));
        }
        Matrix matrix0 = ((ImageView)object0).getImageMatrix();
        ((Matrix)this.b).set(matrix0);
        return (Matrix)this.b;
    }

    @Override  // android.util.Property
    public final void set(Object object0, Object object1) {
        if(this.a != 0) {
            int v = ((ExtendedFloatingActionButton)object0).e0.getColorForState(((ExtendedFloatingActionButton)object0).getDrawableState(), ((a)this.b).b.e0.getDefaultColor());
            ColorStateList colorStateList0 = ColorStateList.valueOf(Color.argb(((int)(e6.a.a(0.0f, ((float)Color.alpha(v)) / 255.0f, ((float)(((Float)object1)))) * 255.0f)), Color.red(v), Color.green(v), Color.blue(v)));
            if(((float)(((Float)object1))) == 1.0f) {
                ((ExtendedFloatingActionButton)object0).f(((ExtendedFloatingActionButton)object0).e0);
                return;
            }
            ((ExtendedFloatingActionButton)object0).f(colorStateList0);
            return;
        }
        ((ImageView)object0).setImageMatrix(((Matrix)object1));
    }
}

