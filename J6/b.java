package j6;

import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;

public final class b extends InsetDrawable {
    @Override  // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return -1;
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return -1;
    }

    @Override  // android.graphics.drawable.InsetDrawable
    public final boolean getPadding(Rect rect0) {
        return false;
    }
}

