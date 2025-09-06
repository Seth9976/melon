package s6;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.imageview.ShapeableImageView;
import z6.i;

public final class a extends ViewOutlineProvider {
    public final Rect a;
    public final ShapeableImageView b;

    public a(ShapeableImageView shapeableImageView0) {
        this.b = shapeableImageView0;
        super();
        this.a = new Rect();
    }

    @Override  // android.view.ViewOutlineProvider
    public final void getOutline(View view0, Outline outline0) {
        ShapeableImageView shapeableImageView0 = this.b;
        if(shapeableImageView0.i == null) {
            return;
        }
        if(shapeableImageView0.h == null) {
            shapeableImageView0.h = new i(shapeableImageView0.i);
        }
        shapeableImageView0.b.round(this.a);
        shapeableImageView0.h.setBounds(this.a);
        shapeableImageView0.h.getOutline(outline0);
    }
}

