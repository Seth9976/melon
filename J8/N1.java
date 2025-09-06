package J8;

import Q4.a;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class n1 implements a {
    public final ConstraintLayout a;
    public final ImageView b;
    public final ImageView c;
    public final r1 d;

    public n1(ConstraintLayout constraintLayout0, ImageView imageView0, ImageView imageView1, r1 r10) {
        this.a = constraintLayout0;
        this.b = imageView0;
        this.c = imageView1;
        this.d = r10;
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

