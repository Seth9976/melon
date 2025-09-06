package f2;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import c2.M;
import c2.W;
import com.iloen.melon.fragments.radio.a;
import java.util.ArrayList;

public final class d {
    public final b a;
    public final ArrayList b;
    public S1.d c;
    public S1.d d;
    public int e;

    public d(ViewGroup viewGroup0) {
        this.b = new ArrayList();
        this.c = S1.d.e;
        this.d = S1.d.e;
        Drawable drawable0 = viewGroup0.getBackground();
        this.e = drawable0 instanceof ColorDrawable ? ((ColorDrawable)drawable0).getColor() : 0;
        b b0 = new b(this, viewGroup0.getContext(), viewGroup0);
        this.a = b0;
        b0.setWillNotDraw(true);
        M.n(b0, new a(this, 7));
        W.q(b0, new c(this));
        viewGroup0.addView(b0, 0);
    }
}

