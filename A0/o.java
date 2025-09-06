package a0;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import y0.s;

public final class o extends RippleDrawable {
    public final boolean a;
    public s b;
    public Integer c;
    public boolean d;

    public o(boolean z) {
        super(ColorStateList.valueOf(0xFF000000), null, (z ? new ColorDrawable(-1) : null));
        this.a = z;
    }

    @Override  // android.graphics.drawable.RippleDrawable
    public final Rect getDirtyBounds() {
        if(!this.a) {
            this.d = true;
        }
        Rect rect0 = super.getDirtyBounds();
        this.d = false;
        return rect0;
    }

    @Override  // android.graphics.drawable.RippleDrawable
    public final boolean isProjected() {
        return this.d;
    }
}

