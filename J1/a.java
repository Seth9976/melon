package J1;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.constraintlayout.utils.widget.ImageFilterButton;

public final class a extends ViewOutlineProvider {
    public final int a;
    public final ImageFilterButton b;

    public a(ImageFilterButton imageFilterButton0, int v) {
        this.a = v;
        this.b = imageFilterButton0;
        super();
    }

    @Override  // android.view.ViewOutlineProvider
    public final void getOutline(View view0, Outline outline0) {
        if(this.a != 0) {
            outline0.setRoundRect(0, 0, this.b.getWidth(), this.b.getHeight(), this.b.g);
            return;
        }
        int v = this.b.getWidth();
        int v1 = this.b.getHeight();
        outline0.setRoundRect(0, 0, v, v1, ((float)Math.min(v, v1)) * this.b.f / 2.0f);
    }
}

