package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

public final class a extends Drawable {
    public final ActionBarContainer a;

    public a(ActionBarContainer actionBarContainer0) {
        this.a = actionBarContainer0;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas0) {
        ActionBarContainer actionBarContainer0 = this.a;
        if(actionBarContainer0.h) {
            Drawable drawable0 = actionBarContainer0.g;
            if(drawable0 != null) {
                drawable0.draw(canvas0);
            }
        }
        else {
            Drawable drawable1 = actionBarContainer0.e;
            if(drawable1 != null) {
                drawable1.draw(canvas0);
            }
            Drawable drawable2 = actionBarContainer0.f;
            if(drawable2 != null && actionBarContainer0.i) {
                drawable2.draw(canvas0);
            }
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override  // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline0) {
        ActionBarContainer actionBarContainer0 = this.a;
        if(!actionBarContainer0.h) {
            Drawable drawable0 = actionBarContainer0.e;
            if(drawable0 != null) {
                drawable0.getOutline(outline0);
            }
        }
        else if(actionBarContainer0.g != null) {
            actionBarContainer0.e.getOutline(outline0);
        }
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setAlpha(int v) {
    }

    @Override  // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter0) {
    }
}

